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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements g, b.a
{
  private TextView gIk;
  private String iXH;
  private String mCountryCode;
  private DialPad tLY;
  private TextView tLZ;
  private EditText tMa;
  private View tMb;
  private ImageButton tMc;
  private View tMd;
  private TextView tMe;
  private TextView tMf;
  private b tOn;
  private String tOo;
  private String tOp;
  private String tOq;
  private int tOr;
  private int tOs;
  private int tOt;
  private LinkedList<dur> tOu;
  com.tencent.mm.plugin.ipcall.model.e.b tOv;
  com.tencent.mm.plugin.ipcall.model.e.c tOw;
  private com.tencent.mm.sdk.b.c tOx;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.tOr = 0;
    this.tOs = 0;
    this.tOt = -1;
    this.tOx = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(25746);
  }
  
  private void cVp()
  {
    AppMethodBeat.i(25758);
    ac.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.tOt = 2;
    if (this.tOs == 1)
    {
      this.tOs = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.tOs = 4;
    AppMethodBeat.o(25758);
  }
  
  private void init()
  {
    AppMethodBeat.i(25750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ac.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
    if (!bool)
    {
      AppMethodBeat.o(25750);
      return;
    }
    setMMTitle(2131760441);
    setVolumeControlStream(1);
    this.tLY = ((DialPad)findViewById(2131299111));
    this.tLZ = ((TextView)findViewById(2131298806));
    this.tMd = findViewById(2131298804);
    this.tMa = ((EditText)findViewById(2131303238));
    this.tMb = findViewById(2131303237);
    this.gIk = ((TextView)findViewById(2131299115));
    this.tMc = ((ImageButton)findViewById(2131299095));
    this.tMe = ((TextView)findViewById(2131298808));
    this.tMf = ((TextView)findViewById(2131299098));
    this.tOn = new b(this, this.tMa, this.tLZ, this.tMb, this.tLY, this.tMc, this.gIk, this.tMd, this.tMe, this.tMf);
    this.tOn.tLX = this;
    if (!bs.isNullOrNil(this.tOo)) {
      this.tOn.dG(this.tOo, -1);
    }
    if (!bs.isNullOrNil(this.mCountryCode)) {
      this.tOn.aiV(this.mCountryCode);
    }
    if ((!bs.isNullOrNil(this.tOo)) && (!bs.isNullOrNil(this.mCountryCode))) {
      this.tOn.cVg();
    }
    this.tOn.aE(this.tOu);
    AppMethodBeat.o(25750);
  }
  
  public final void aiW(String paramString)
  {
    AppMethodBeat.i(25756);
    ac.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.tOt != 2) && (this.tOt != -1) && (!this.mCountryCode.equals(paramString))) {
      cVp();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void aiX(String paramString)
  {
    AppMethodBeat.i(25757);
    ac.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.tOo });
    if ((this.tOt != 2) && (this.tOt != -1) && (!this.tOo.equals(paramString))) {
      cVp();
    }
    AppMethodBeat.o(25757);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494506;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25751);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.tOn;
    ac.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = bs.bG(paramIntent.getStringExtra("country_name"), "");
      paramIntent = bs.bG(paramIntent.getStringExtra("couttry_code"), "");
      ac.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!bs.isNullOrNil(paramIntent)) && (!bs.isNullOrNil(str)))
      {
        localb.tMg = str;
        localb.tMh = "+".concat(String.valueOf(paramIntent));
        localb.tLZ.setText(localb.tMh);
        localb.tMi = b.hl(paramIntent.replace("+", ""), localb.tMi);
        localb.dG(localb.tMi, -1);
        localb.tMm = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.iMV.setResult(-1, paramIntent);
      localb.iMV.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.GpY.c(this.tOx);
    az.agi().a(807, this);
    az.agi().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), 2131689508);
    this.iXH = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.tOo = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.tOp = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.tOq = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.tOr = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    ac.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.iXH, this.tOo, this.tOp, this.mCountryCode, this.tOq, Integer.valueOf(this.tOr) });
    if (!bs.isNullOrNil(this.tOo)) {
      this.tOo = com.tencent.mm.plugin.ipcall.a.c.ajw(this.tOo);
    }
    if (bs.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.ajq(this.tOo))
      {
        if (bs.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.ajo(this.tOo))) {
          this.tOo = com.tencent.mm.plugin.ipcall.a.a.ajr(this.tOo);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.cVU();
      }
    }
    else
    {
      if (this.tOr == 1) {
        break label468;
      }
      this.tOt = 0;
      this.tOs = 3;
      this.tOv = new com.tencent.mm.plugin.ipcall.model.e.b(this.tOo, this.mCountryCode, "", bs.iW(this), this.tOr);
      az.agi().a(this.tOv, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      ac.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.tOs = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.tOp);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.iXH);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.tOo);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.tOr);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.tOs);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label468:
      this.tOt = -1;
      this.tOs = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.tOn != null) {
      this.tOn.tLX = null;
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.tOx);
    az.agi().b(807, this);
    az.agi().b(746, this);
    AppMethodBeat.o(25753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25754);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25754);
      return;
    }
    ac.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
      com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25749);
    ac.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25749);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25755);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn == this.tOv))
      {
        if (this.tOv.tKq != null) {
          ac.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.tOv.tKq.Epu), this.tOv.tKq.FvU, this.tOv.tKq.tTg });
        }
        if (this.tOt != 2)
        {
          this.tOt = 1;
          this.tOs = 1;
          paramString = this.tOv;
          if ((paramString.tKq != null) && (paramString.tKq.Epu == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            ac.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.tOv;
          if ((paramString.tKq != null) && ((paramString.tKq.Epu == 1) || (paramString.tKq.Epu == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.tOv.tKq == null) || (bs.isNullOrNil(this.tOv.tKq.tTg))) {
                break label406;
              }
              if (this.tOn != null)
              {
                ac.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.tOv.tKq.tTg, this.mCountryCode });
                this.mCountryCode = this.tOv.tKq.tTg;
                this.tOn.aiV(this.tOv.tKq.tTg);
              }
            }
          }
          for (;;)
          {
            if ((this.tOv.tKq == null) || (bs.isNullOrNil(this.tOv.tKq.FvU)) || (this.tOn == null)) {
              break label481;
            }
            ac.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.tOv.tKq.FvU, this.tOo });
            this.tOo = this.tOv.tKq.FvU;
            this.tOn.dG(this.tOv.tKq.FvU, -1);
            AppMethodBeat.o(25755);
            return;
            paramInt1 = 0;
            break;
            label406:
            ac.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
          }
        }
        ac.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
        AppMethodBeat.o(25755);
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.c)) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label488;
      }
    }
    label481:
    label488:
    for (this.tOu = ((com.tencent.mm.plugin.ipcall.model.e.c)paramn).tKs.EVB;; this.tOu = null)
    {
      if (this.tOn != null) {
        this.tOn.aE(this.tOu);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.tOw = new com.tencent.mm.plugin.ipcall.model.e.c();
    az.agi().a(this.tOw, 0);
    AppMethodBeat.o(25748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25752);
    ac.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.fA(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.cUg().Hb(bs.getInt(paramString1, -1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131756761), getString(2131756762), true);
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.tOr);
    localIntent.putExtra("IPCallTalkUI_countryType", this.tOs);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */