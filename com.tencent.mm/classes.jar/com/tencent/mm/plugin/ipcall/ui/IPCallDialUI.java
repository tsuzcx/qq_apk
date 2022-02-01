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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.ewj;
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
  private TextView hXv;
  private String krY;
  private String mCountryCode;
  private DialPad ysX;
  private TextView ysY;
  private EditText ysZ;
  private View yta;
  private ImageButton ytb;
  private View ytc;
  private TextView ytd;
  private TextView yte;
  private b yvm;
  private String yvn;
  private String yvo;
  private String yvp;
  private int yvq;
  private int yvr;
  private int yvs;
  private LinkedList<ewj> yvt;
  com.tencent.mm.plugin.ipcall.model.e.b yvu;
  com.tencent.mm.plugin.ipcall.model.e.c yvv;
  private IListener yvw;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.yvq = 0;
    this.yvr = 0;
    this.yvs = -1;
    this.yvw = new IListener() {};
    AppMethodBeat.o(25746);
  }
  
  private void ebm()
  {
    AppMethodBeat.i(25758);
    Log.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.yvs = 2;
    if (this.yvr == 1)
    {
      this.yvr = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.yvr = 4;
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
    setMMTitle(2131761886);
    setVolumeControlStream(1);
    this.ysX = ((DialPad)findViewById(2131299634));
    this.ysY = ((TextView)findViewById(2131299270));
    this.ytc = findViewById(2131299268);
    this.ysZ = ((EditText)findViewById(2131305906));
    this.yta = findViewById(2131305905);
    this.hXv = ((TextView)findViewById(2131299638));
    this.ytb = ((ImageButton)findViewById(2131299618));
    this.ytd = ((TextView)findViewById(2131299272));
    this.yte = ((TextView)findViewById(2131299621));
    this.yvm = new b(this, this.ysZ, this.ysY, this.yta, this.ysX, this.ytb, this.hXv, this.ytc, this.ytd, this.yte);
    this.yvm.ysW = this;
    if (!Util.isNullOrNil(this.yvn)) {
      this.yvm.es(this.yvn, -1);
    }
    if (!Util.isNullOrNil(this.mCountryCode)) {
      this.yvm.aCe(this.mCountryCode);
    }
    if ((!Util.isNullOrNil(this.yvn)) && (!Util.isNullOrNil(this.mCountryCode))) {
      this.yvm.ebd();
    }
    this.yvm.bb(this.yvt);
    AppMethodBeat.o(25750);
  }
  
  public final void aCf(String paramString)
  {
    AppMethodBeat.i(25756);
    Log.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.yvs != 2) && (this.yvs != -1) && (!this.mCountryCode.equals(paramString))) {
      ebm();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void aCg(String paramString)
  {
    AppMethodBeat.i(25757);
    Log.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.yvn });
    if ((this.yvs != 2) && (this.yvs != -1) && (!this.yvn.equals(paramString))) {
      ebm();
    }
    AppMethodBeat.o(25757);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495098;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25751);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.yvm;
    Log.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      paramIntent = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      Log.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!Util.isNullOrNil(paramIntent)) && (!Util.isNullOrNil(str)))
      {
        localb.ytf = str;
        localb.ytg = "+".concat(String.valueOf(paramIntent));
        localb.ysY.setText(localb.ytg);
        localb.yth = localb.im(paramIntent.replace("+", ""), localb.yth);
        localb.es(localb.yth, -1);
        localb.ytl = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.gte.setResult(-1, paramIntent);
      localb.gte.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.yvw);
    bg.azz().a(807, this);
    bg.azz().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), 2131689510);
    this.krY = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.yvn = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.yvo = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.yvp = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.yvq = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    Log.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.krY, this.yvn, this.yvo, this.mCountryCode, this.yvp, Integer.valueOf(this.yvq) });
    if (!Util.isNullOrNil(this.yvn)) {
      this.yvn = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.yvn);
    }
    if (Util.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.aCy(this.yvn))
      {
        if (Util.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.yvn))) {
          this.yvn = com.tencent.mm.plugin.ipcall.a.a.aCz(this.yvn);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.ebO();
      }
    }
    else
    {
      if (this.yvq == 1) {
        break label468;
      }
      this.yvs = 0;
      this.yvr = 3;
      this.yvu = new com.tencent.mm.plugin.ipcall.model.e.b(this.yvn, this.mCountryCode, "", Util.getSimCountryCode(this), this.yvq);
      bg.azz().a(this.yvu, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      Log.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.yvr = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.yvo);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.krY);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.yvn);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.yvq);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.yvr);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label468:
      this.yvs = -1;
      this.yvr = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.yvm != null) {
      this.yvm.ysW = null;
    }
    EventCenter.instance.removeListener(this.yvw);
    bg.azz().b(807, this);
    bg.azz().b(746, this);
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
      com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
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
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq == this.yvu))
      {
        if (this.yvu.yrq != null) {
          Log.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.yvu.yrq.LjQ), this.yvu.yrq.MKj, this.yvu.yrq.yAf });
        }
        if (this.yvs != 2)
        {
          this.yvs = 1;
          this.yvr = 1;
          paramString = this.yvu;
          if ((paramString.yrq != null) && (paramString.yrq.LjQ == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            Log.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.yvu;
          if ((paramString.yrq != null) && ((paramString.yrq.LjQ == 1) || (paramString.yrq.LjQ == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.yvu.yrq == null) || (Util.isNullOrNil(this.yvu.yrq.yAf))) {
                break label406;
              }
              if (this.yvm != null)
              {
                Log.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.yvu.yrq.yAf, this.mCountryCode });
                this.mCountryCode = this.yvu.yrq.yAf;
                this.yvm.aCe(this.yvu.yrq.yAf);
              }
            }
          }
          for (;;)
          {
            if ((this.yvu.yrq == null) || (Util.isNullOrNil(this.yvu.yrq.MKj)) || (this.yvm == null)) {
              break label481;
            }
            Log.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.yvu.yrq.MKj, this.yvn });
            this.yvn = this.yvu.yrq.MKj;
            this.yvm.es(this.yvu.yrq.MKj, -1);
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
    for (this.yvt = ((com.tencent.mm.plugin.ipcall.model.e.c)paramq).yrs.Mdr;; this.yvt = null)
    {
      if (this.yvm != null) {
        this.yvm.bb(this.yvt);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.yvv = new com.tencent.mm.plugin.ipcall.model.e.c();
    bg.azz().a(this.yvv, 0);
    AppMethodBeat.o(25748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25752);
    Log.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.gq(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.ead().OY(Util.getInt(paramString1, -1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131756924), getString(2131756925), true);
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.yvq);
    localIntent.putExtra("IPCallTalkUI_countryType", this.yvr);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */