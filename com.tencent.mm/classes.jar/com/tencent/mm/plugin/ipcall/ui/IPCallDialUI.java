package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.protocal.c.bfw;
import com.tencent.mm.protocal.c.cho;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements f, b.a
{
  private TextView eYn;
  private String fsv;
  private DialPad ltd;
  private TextView lte;
  private EditText ltf;
  private View ltg;
  private ImageButton lth;
  private View lti;
  private TextView ltj;
  private TextView ltk;
  private int lvA = 0;
  private int lvB = 0;
  private int lvC = -1;
  private LinkedList<cho> lvD;
  com.tencent.mm.plugin.ipcall.a.d.b lvE;
  com.tencent.mm.plugin.ipcall.a.d.c lvF;
  private com.tencent.mm.sdk.b.c lvG = new IPCallDialUI.2(this);
  private b lvv;
  private String lvw;
  private String lvx;
  private String lvy;
  private String lvz;
  
  private void bcY()
  {
    y.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.lvC = 2;
    if (this.lvB == 1)
    {
      this.lvB = 2;
      return;
    }
    this.lvB = 4;
  }
  
  private void init()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    y.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {
      return;
    }
    setMMTitle(R.l.ip_call_dial_title);
    setVolumeControlStream(1);
    this.ltd = ((DialPad)findViewById(R.h.dial_pad));
    this.lte = ((TextView)findViewById(R.h.country_code_tv));
    this.lti = findViewById(R.h.country_code_icon_ll);
    this.ltf = ((EditText)findViewById(R.h.phonenumber_tv));
    this.ltg = findViewById(R.h.phonenumber_del_button);
    this.eYn = ((TextView)findViewById(R.h.dial_ui_username_tv));
    this.lth = ((ImageButton)findViewById(R.h.dial_button));
    this.ltj = ((TextView)findViewById(R.h.country_name_tv));
    this.ltk = ((TextView)findViewById(R.h.dial_free_tv));
    this.lvv = new b(this, this.ltf, this.lte, this.ltg, this.ltd, this.lth, this.eYn, this.lti, this.ltj, this.ltk);
    this.lvv.ltc = this;
    if (!bk.bl(this.lvw)) {
      this.lvv.bL(this.lvw, -1);
    }
    if (!bk.bl(this.lvy)) {
      this.lvv.FH(this.lvy);
    }
    if ((!bk.bl(this.lvw)) && (!bk.bl(this.lvy))) {
      this.lvv.bcQ();
    }
    this.lvv.aa(this.lvD);
  }
  
  public final void FI(String paramString)
  {
    y.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.lvy });
    if ((this.lvC != 2) && (this.lvC != -1) && (!this.lvy.equals(paramString))) {
      bcY();
    }
  }
  
  public final void FJ(String paramString)
  {
    y.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.lvw });
    if ((this.lvC != 2) && (this.lvC != -1) && (!this.lvw.equals(paramString))) {
      bcY();
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_dial_ui;
  }
  
  public final void n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    y.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.b.c.dG(this)) {
      return;
    }
    if (com.tencent.mm.plugin.ipcall.a.c.bbS().sE(bk.getInt(paramString1, -1)))
    {
      com.tencent.mm.ui.base.h.b(this, getString(R.l.callout_country_restriction_hint), getString(R.l.callout_country_restriction_hint_title), true);
      com.tencent.mm.plugin.report.service.h.nFQ.aC(12058, paramString1);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.lvA);
    localIntent.putExtra("IPCallTalkUI_countryType", this.lvB);
    startActivityForResult(localIntent, 1001);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.lvv;
    y.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      str = bk.aM(paramIntent.getStringExtra("country_name"), "");
      paramIntent = bk.aM(paramIntent.getStringExtra("couttry_code"), "");
      y.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!bk.bl(paramIntent)) && (!bk.bl(str)))
      {
        localb.ltl = str;
        localb.ltm = ("+" + paramIntent);
        localb.lte.setText(localb.ltm);
        localb.ltn = b.dB(paramIntent.replace("+", ""), localb.ltn);
        localb.bL(localb.ltn, -1);
        localb.ltr = false;
      }
    }
    while ((paramInt1 != 1001) || (paramInt2 != -1))
    {
      String str;
      return;
    }
    paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
    localb.bER.setResult(-1, paramIntent);
    localb.bER.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.udP.c(this.lvG);
    au.Dk().a(807, this);
    au.Dk().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), R.k.actionbar_quit_webview_icon);
    this.fsv = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.lvw = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.lvx = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.lvy = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.lvz = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.lvA = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    y.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.fsv, this.lvw, this.lvx, this.lvy, this.lvz, Integer.valueOf(this.lvA) });
    if (!bk.bl(this.lvw)) {
      this.lvw = com.tencent.mm.plugin.ipcall.b.c.Gi(this.lvw);
    }
    if (bk.bl(this.lvy))
    {
      if (com.tencent.mm.plugin.ipcall.b.a.Gc(this.lvw))
      {
        if (bk.bl(com.tencent.mm.plugin.ipcall.b.a.Ga(this.lvw))) {
          this.lvw = com.tencent.mm.plugin.ipcall.b.a.Gd(this.lvw);
        }
      }
      else {
        this.lvy = com.tencent.mm.plugin.ipcall.b.c.bdr();
      }
    }
    else
    {
      if (this.lvA == 1) {
        break label451;
      }
      this.lvC = 0;
      this.lvB = 3;
      this.lvE = new com.tencent.mm.plugin.ipcall.a.d.b(this.lvw, this.lvy, "", bk.fS(this), this.lvA);
      au.Dk().a(this.lvE, 0);
    }
    for (;;)
    {
      init();
      return;
      y.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.lvB = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.lvx);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.lvy);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.fsv);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.lvw);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.lvA);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.lvB);
      startActivityForResult(paramBundle, 1001);
      finish();
      return;
      label451:
      this.lvC = -1;
      this.lvB = 4;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.lvv != null) {
      this.lvv.ltc = null;
    }
    com.tencent.mm.sdk.b.a.udP.d(this.lvG);
    au.Dk().b(807, this);
    au.Dk().b(746, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.IPCallDialUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      init();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
  }
  
  protected void onResume()
  {
    y.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.b)) {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm == this.lvE))
      {
        if (this.lvE.lrr != null) {
          y.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.lvE.lrr.sML), this.lvE.lrr.tAF, this.lvE.lrr.lAs });
        }
        if (this.lvC == 2) {
          break label399;
        }
        this.lvC = 1;
        this.lvB = 1;
        paramString = this.lvE;
        if ((paramString.lrr == null) || (paramString.lrr.sML != 2)) {
          break label145;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label150;
        }
        y.i("MicroMsg.IPCallDialUI", "check error show error dialog");
      }
    }
    for (;;)
    {
      return;
      label145:
      paramInt1 = 0;
      break;
      label150:
      paramString = this.lvE;
      if ((paramString.lrr != null) && ((paramString.lrr.sML == 1) || (paramString.lrr.sML == 0)))
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          if ((this.lvE.lrr == null) || (bk.bl(this.lvE.lrr.lAs))) {
            break label388;
          }
          if (this.lvv != null)
          {
            y.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.lvE.lrr.lAs, this.lvy });
            this.lvy = this.lvE.lrr.lAs;
            this.lvv.FH(this.lvE.lrr.lAs);
          }
        }
      }
      for (;;)
      {
        if ((this.lvE.lrr == null) || (bk.bl(this.lvE.lrr.tAF)) || (this.lvv == null)) {
          break label397;
        }
        y.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.lvE.lrr.tAF, this.lvw });
        this.lvw = this.lvE.lrr.tAF;
        this.lvv.bL(this.lvE.lrr.tAF, -1);
        return;
        paramInt1 = 0;
        break;
        label388:
        y.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
      }
      label397:
      continue;
      label399:
      y.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
      return;
      if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.c))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (this.lvD = ((com.tencent.mm.plugin.ipcall.a.d.c)paramm).lrt.tir; this.lvv != null; this.lvD = null)
        {
          this.lvv.aa(this.lvD);
          return;
        }
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.lvF = new com.tencent.mm.plugin.ipcall.a.d.c();
    au.Dk().a(this.lvF, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */