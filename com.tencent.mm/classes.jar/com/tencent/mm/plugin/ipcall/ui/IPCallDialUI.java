package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.zr;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.fgv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements i, b.a
{
  private DialPad DTb;
  private TextView DTc;
  private EditText DTd;
  private View DTe;
  private ImageButton DTf;
  private View DTg;
  private TextView DTh;
  private TextView DTi;
  private IListener DVA;
  private b DVq;
  private String DVr;
  private String DVs;
  private String DVt;
  private int DVu;
  private int DVv;
  private int DVw;
  private LinkedList<fgv> DVx;
  com.tencent.mm.plugin.ipcall.model.e.b DVy;
  com.tencent.mm.plugin.ipcall.model.e.c DVz;
  private TextView kMa;
  private String mCountryCode;
  private String njH;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.DVu = 0;
    this.DVv = 0;
    this.DVw = -1;
    this.DVA = new IListener() {};
    AppMethodBeat.o(25746);
  }
  
  private void eKk()
  {
    AppMethodBeat.i(25758);
    Log.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.DVw = 2;
    if (this.DVv == 1)
    {
      this.DVv = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.DVv = 4;
    AppMethodBeat.o(25758);
  }
  
  private void init()
  {
    AppMethodBeat.i(25750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    Log.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(25750);
      return;
    }
    setMMTitle(R.l.eIE);
    setVolumeControlStream(1);
    this.DTb = ((DialPad)findViewById(R.h.dEI));
    this.DTc = ((TextView)findViewById(R.h.dCO));
    this.DTg = findViewById(R.h.dCN);
    this.DTd = ((EditText)findViewById(R.h.dRd));
    this.DTe = findViewById(R.h.dRc);
    this.kMa = ((TextView)findViewById(R.h.dEK));
    this.DTf = ((ImageButton)findViewById(R.h.dEs));
    this.DTh = ((TextView)findViewById(R.h.dCP));
    this.DTi = ((TextView)findViewById(R.h.dEv));
    this.DVq = new b(this, this.DTd, this.DTc, this.DTe, this.DTb, this.DTf, this.kMa, this.DTg, this.DTh, this.DTi);
    this.DVq.DTa = this;
    if (!Util.isNullOrNil(this.DVr)) {
      this.DVq.eS(this.DVr, -1);
    }
    if (!Util.isNullOrNil(this.mCountryCode)) {
      this.DVq.aMl(this.mCountryCode);
    }
    if ((!Util.isNullOrNil(this.DVr)) && (!Util.isNullOrNil(this.mCountryCode))) {
      this.DVq.eKb();
    }
    this.DVq.bu(this.DVx);
    AppMethodBeat.o(25750);
  }
  
  public final void aMm(String paramString)
  {
    AppMethodBeat.i(25756);
    Log.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.DVw != 2) && (this.DVw != -1) && (!this.mCountryCode.equals(paramString))) {
      eKk();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void aMn(String paramString)
  {
    AppMethodBeat.i(25757);
    Log.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.DVr });
    if ((this.DVw != 2) && (this.DVw != -1) && (!this.DVr.equals(paramString))) {
      eKk();
    }
    AppMethodBeat.o(25757);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ehR;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25751);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.DVq;
    Log.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      paramIntent = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      Log.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!Util.isNullOrNil(paramIntent)) && (!Util.isNullOrNil(str)))
      {
        localb.DTj = str;
        localb.DTk = "+".concat(String.valueOf(paramIntent));
        localb.DTc.setText(localb.DTk);
        localb.DTl = localb.iz(paramIntent.replace("+", ""), localb.DTl);
        localb.eS(localb.DTl, -1);
        localb.DTp = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.iXq.setResult(-1, paramIntent);
      localb.iXq.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.DVA);
    bh.aGY().a(807, this);
    bh.aGY().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), R.k.actionbar_quit_webview_icon);
    this.njH = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.DVr = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.DVs = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.DVt = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.DVu = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    Log.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.njH, this.DVr, this.DVs, this.mCountryCode, this.DVt, Integer.valueOf(this.DVu) });
    if (!Util.isNullOrNil(this.DVr)) {
      this.DVr = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.DVr);
    }
    if (Util.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.aMF(this.DVr))
      {
        if (Util.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.DVr))) {
          this.DVr = com.tencent.mm.plugin.ipcall.a.a.aMG(this.DVr);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.eKM();
      }
    }
    else
    {
      if (this.DVu == 1) {
        break label469;
      }
      this.DVw = 0;
      this.DVv = 3;
      this.DVy = new com.tencent.mm.plugin.ipcall.model.e.b(this.DVr, this.mCountryCode, "", Util.getSimCountryCode(this), this.DVu);
      bh.aGY().a(this.DVy, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      Log.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.DVv = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.DVs);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.njH);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.DVr);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.DVu);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.DVv);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label469:
      this.DVw = -1;
      this.DVv = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.DVq != null) {
      this.DVq.DTa = null;
    }
    EventCenter.instance.removeListener(this.DVA);
    bh.aGY().b(807, this);
    bh.aGY().b(746, this);
    AppMethodBeat.o(25753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25754);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25754);
      return;
    }
    Log.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25754);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(25754);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25749);
    Log.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25749);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25755);
    if ((paramq instanceof com.tencent.mm.plugin.ipcall.model.e.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq == this.DVy))
      {
        if (this.DVy.DRs != null) {
          Log.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.DVy.DRs.Tsk), this.DVy.DRs.TWd, this.DVy.DRs.DZX });
        }
        if (this.DVw != 2)
        {
          this.DVw = 1;
          this.DVv = 1;
          paramString = this.DVy;
          if ((paramString.DRs != null) && (paramString.DRs.Tsk == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            Log.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.DVy;
          if ((paramString.DRs != null) && ((paramString.DRs.Tsk == 1) || (paramString.DRs.Tsk == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.DVy.DRs == null) || (Util.isNullOrNil(this.DVy.DRs.DZX))) {
                break label406;
              }
              if (this.DVq != null)
              {
                Log.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.DVy.DRs.DZX, this.mCountryCode });
                this.mCountryCode = this.DVy.DRs.DZX;
                this.DVq.aMl(this.DVy.DRs.DZX);
              }
            }
          }
          for (;;)
          {
            if ((this.DVy.DRs == null) || (Util.isNullOrNil(this.DVy.DRs.TWd)) || (this.DVq == null)) {
              break label481;
            }
            Log.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.DVy.DRs.TWd, this.DVr });
            this.DVr = this.DVy.DRs.TWd;
            this.DVq.eS(this.DVy.DRs.TWd, -1);
            AppMethodBeat.o(25755);
            return;
            paramInt1 = 0;
            break;
            label406:
            Log.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
          }
        }
        Log.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
        AppMethodBeat.o(25755);
      }
    }
    else if ((paramq instanceof com.tencent.mm.plugin.ipcall.model.e.c)) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label488;
      }
    }
    label481:
    label488:
    for (this.DVx = ((com.tencent.mm.plugin.ipcall.model.e.c)paramq).DRu.TmS;; this.DVx = null)
    {
      if (this.DVq != null) {
        this.DVq.bu(this.DVx);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.DVz = new com.tencent.mm.plugin.ipcall.model.e.c();
    bh.aGY().a(this.DVz, 0);
    AppMethodBeat.o(25748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25752);
    Log.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.hn(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.eJb().Vg(Util.getInt(paramString1, -1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.etD), getString(R.l.etE), true);
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.DVu);
    localIntent.putExtra("IPCallTalkUI_countryType", this.DVv);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */