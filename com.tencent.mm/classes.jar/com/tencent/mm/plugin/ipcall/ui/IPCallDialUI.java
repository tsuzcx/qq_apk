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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements f, b.a
{
  private TextView heI;
  private String jtJ;
  private String mCountryCode;
  private View vaA;
  private ImageButton vaB;
  private View vaC;
  private TextView vaD;
  private TextView vaE;
  private DialPad vax;
  private TextView vay;
  private EditText vaz;
  private b vcM;
  private String vcN;
  private String vcO;
  private String vcP;
  private int vcQ;
  private int vcR;
  private int vcS;
  private LinkedList<ecc> vcT;
  com.tencent.mm.plugin.ipcall.model.e.b vcU;
  com.tencent.mm.plugin.ipcall.model.e.c vcV;
  private com.tencent.mm.sdk.b.c vcW;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.vcQ = 0;
    this.vcR = 0;
    this.vcS = -1;
    this.vcW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(25746);
  }
  
  private void dhs()
  {
    AppMethodBeat.i(25758);
    ae.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.vcS = 2;
    if (this.vcR == 1)
    {
      this.vcR = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.vcR = 4;
    AppMethodBeat.o(25758);
  }
  
  private void init()
  {
    AppMethodBeat.i(25750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ae.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
    if (!bool)
    {
      AppMethodBeat.o(25750);
      return;
    }
    setMMTitle(2131760441);
    setVolumeControlStream(1);
    this.vax = ((DialPad)findViewById(2131299111));
    this.vay = ((TextView)findViewById(2131298806));
    this.vaC = findViewById(2131298804);
    this.vaz = ((EditText)findViewById(2131303238));
    this.vaA = findViewById(2131303237);
    this.heI = ((TextView)findViewById(2131299115));
    this.vaB = ((ImageButton)findViewById(2131299095));
    this.vaD = ((TextView)findViewById(2131298808));
    this.vaE = ((TextView)findViewById(2131299098));
    this.vcM = new b(this, this.vaz, this.vay, this.vaA, this.vax, this.vaB, this.heI, this.vaC, this.vaD, this.vaE);
    this.vcM.vaw = this;
    if (!bu.isNullOrNil(this.vcN)) {
      this.vcM.ed(this.vcN, -1);
    }
    if (!bu.isNullOrNil(this.mCountryCode)) {
      this.vcM.aoK(this.mCountryCode);
    }
    if ((!bu.isNullOrNil(this.vcN)) && (!bu.isNullOrNil(this.mCountryCode))) {
      this.vcM.dhj();
    }
    this.vcM.aG(this.vcT);
    AppMethodBeat.o(25750);
  }
  
  public final void aoL(String paramString)
  {
    AppMethodBeat.i(25756);
    ae.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.vcS != 2) && (this.vcS != -1) && (!this.mCountryCode.equals(paramString))) {
      dhs();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void aoM(String paramString)
  {
    AppMethodBeat.i(25757);
    ae.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.vcN });
    if ((this.vcS != 2) && (this.vcS != -1) && (!this.vcN.equals(paramString))) {
      dhs();
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
    b localb = this.vcM;
    ae.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = bu.bI(paramIntent.getStringExtra("country_name"), "");
      paramIntent = bu.bI(paramIntent.getStringExtra("couttry_code"), "");
      ae.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!bu.isNullOrNil(paramIntent)) && (!bu.isNullOrNil(str)))
      {
        localb.vaF = str;
        localb.vaG = "+".concat(String.valueOf(paramIntent));
        localb.vay.setText(localb.vaG);
        localb.vaH = b.hE(paramIntent.replace("+", ""), localb.vaH);
        localb.ed(localb.vaH, -1);
        localb.vaL = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.fNT.setResult(-1, paramIntent);
      localb.fNT.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IvT.c(this.vcW);
    bc.ajj().a(807, this);
    bc.ajj().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), 2131689508);
    this.jtJ = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.vcN = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.vcO = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.vcP = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.vcQ = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    ae.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.jtJ, this.vcN, this.vcO, this.mCountryCode, this.vcP, Integer.valueOf(this.vcQ) });
    if (!bu.isNullOrNil(this.vcN)) {
      this.vcN = com.tencent.mm.plugin.ipcall.a.c.apl(this.vcN);
    }
    if (bu.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.apf(this.vcN))
      {
        if (bu.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.apd(this.vcN))) {
          this.vcN = com.tencent.mm.plugin.ipcall.a.a.apg(this.vcN);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.dhX();
      }
    }
    else
    {
      if (this.vcQ == 1) {
        break label468;
      }
      this.vcS = 0;
      this.vcR = 3;
      this.vcU = new com.tencent.mm.plugin.ipcall.model.e.b(this.vcN, this.mCountryCode, "", bu.jm(this), this.vcQ);
      bc.ajj().a(this.vcU, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      ae.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.vcR = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.vcO);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.jtJ);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.vcN);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.vcQ);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.vcR);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label468:
      this.vcS = -1;
      this.vcR = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.vcM != null) {
      this.vcM.vaw = null;
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.vcW);
    bc.ajj().b(807, this);
    bc.ajj().b(746, this);
    AppMethodBeat.o(25753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25754);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25754);
      return;
    }
    ae.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25749);
    ae.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25749);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25755);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn == this.vcU))
      {
        if (this.vcU.uYQ != null) {
          ae.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.vcU.uYQ.Gpf), this.vcU.uYQ.HzA, this.vcU.uYQ.vhG });
        }
        if (this.vcS != 2)
        {
          this.vcS = 1;
          this.vcR = 1;
          paramString = this.vcU;
          if ((paramString.uYQ != null) && (paramString.uYQ.Gpf == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            ae.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.vcU;
          if ((paramString.uYQ != null) && ((paramString.uYQ.Gpf == 1) || (paramString.uYQ.Gpf == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.vcU.uYQ == null) || (bu.isNullOrNil(this.vcU.uYQ.vhG))) {
                break label406;
              }
              if (this.vcM != null)
              {
                ae.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.vcU.uYQ.vhG, this.mCountryCode });
                this.mCountryCode = this.vcU.uYQ.vhG;
                this.vcM.aoK(this.vcU.uYQ.vhG);
              }
            }
          }
          for (;;)
          {
            if ((this.vcU.uYQ == null) || (bu.isNullOrNil(this.vcU.uYQ.HzA)) || (this.vcM == null)) {
              break label481;
            }
            ae.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.vcU.uYQ.HzA, this.vcN });
            this.vcN = this.vcU.uYQ.HzA;
            this.vcM.ed(this.vcU.uYQ.HzA, -1);
            AppMethodBeat.o(25755);
            return;
            paramInt1 = 0;
            break;
            label406:
            ae.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
          }
        }
        ae.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
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
    for (this.vcT = ((com.tencent.mm.plugin.ipcall.model.e.c)paramn).uYS.GYB;; this.vcT = null)
    {
      if (this.vcM != null) {
        this.vcM.aG(this.vcT);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.vcV = new com.tencent.mm.plugin.ipcall.model.e.c();
    bc.ajj().a(this.vcV, 0);
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
    ae.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.fK(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.dgj().IV(bu.getInt(paramString1, -1)))
    {
      h.c(this, getString(2131756761), getString(2131756762), true);
      g.yxI.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    g.yxI.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.vcQ);
    localIntent.putExtra("IPCallTalkUI_countryType", this.vcR);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */