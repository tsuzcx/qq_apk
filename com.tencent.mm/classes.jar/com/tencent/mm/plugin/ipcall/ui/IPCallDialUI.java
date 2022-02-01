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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements g, b.a
{
  private TextView icz;
  private String ixE;
  private String mCountryCode;
  private DialPad sEr;
  private TextView sEs;
  private EditText sEt;
  private View sEu;
  private ImageButton sEv;
  private View sEw;
  private TextView sEx;
  private TextView sEy;
  private b sGG;
  private String sGH;
  private String sGI;
  private String sGJ;
  private int sGK;
  private int sGL;
  private int sGM;
  private LinkedList<dpa> sGN;
  com.tencent.mm.plugin.ipcall.model.e.b sGO;
  com.tencent.mm.plugin.ipcall.model.e.c sGP;
  private com.tencent.mm.sdk.b.c sGQ;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.sGK = 0;
    this.sGL = 0;
    this.sGM = -1;
    this.sGQ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(25746);
  }
  
  private void cIe()
  {
    AppMethodBeat.i(25758);
    ad.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.sGM = 2;
    if (this.sGL == 1)
    {
      this.sGL = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.sGL = 4;
    AppMethodBeat.o(25758);
  }
  
  private void init()
  {
    AppMethodBeat.i(25750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ad.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
    if (!bool)
    {
      AppMethodBeat.o(25750);
      return;
    }
    setMMTitle(2131760441);
    setVolumeControlStream(1);
    this.sEr = ((DialPad)findViewById(2131299111));
    this.sEs = ((TextView)findViewById(2131298806));
    this.sEw = findViewById(2131298804);
    this.sEt = ((EditText)findViewById(2131303238));
    this.sEu = findViewById(2131303237);
    this.icz = ((TextView)findViewById(2131299115));
    this.sEv = ((ImageButton)findViewById(2131299095));
    this.sEx = ((TextView)findViewById(2131298808));
    this.sEy = ((TextView)findViewById(2131299098));
    this.sGG = new b(this, this.sEt, this.sEs, this.sEu, this.sEr, this.sEv, this.icz, this.sEw, this.sEx, this.sEy);
    this.sGG.sEq = this;
    if (!bt.isNullOrNil(this.sGH)) {
      this.sGG.dA(this.sGH, -1);
    }
    if (!bt.isNullOrNil(this.mCountryCode)) {
      this.sGG.aed(this.mCountryCode);
    }
    if ((!bt.isNullOrNil(this.sGH)) && (!bt.isNullOrNil(this.mCountryCode))) {
      this.sGG.cHV();
    }
    this.sGG.ax(this.sGN);
    AppMethodBeat.o(25750);
  }
  
  public final void aee(String paramString)
  {
    AppMethodBeat.i(25756);
    ad.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.sGM != 2) && (this.sGM != -1) && (!this.mCountryCode.equals(paramString))) {
      cIe();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void aef(String paramString)
  {
    AppMethodBeat.i(25757);
    ad.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.sGH });
    if ((this.sGM != 2) && (this.sGM != -1) && (!this.sGH.equals(paramString))) {
      cIe();
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
  
  public final void o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25752);
    ad.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.fn(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.cGV().Fg(bt.getInt(paramString1, -1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131756761), getString(2131756762), true);
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.sGK);
    localIntent.putExtra("IPCallTalkUI_countryType", this.sGL);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25751);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.sGG;
    ad.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = bt.by(paramIntent.getStringExtra("country_name"), "");
      paramIntent = bt.by(paramIntent.getStringExtra("couttry_code"), "");
      ad.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!bt.isNullOrNil(paramIntent)) && (!bt.isNullOrNil(str)))
      {
        localb.sEz = str;
        localb.sEA = "+".concat(String.valueOf(paramIntent));
        localb.sEs.setText(localb.sEA);
        localb.sEB = b.gU(paramIntent.replace("+", ""), localb.sEB);
        localb.dA(localb.sEB, -1);
        localb.sEF = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.imP.setResult(-1, paramIntent);
      localb.imP.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ESL.c(this.sGQ);
    az.aeS().a(807, this);
    az.aeS().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), 2131689508);
    this.ixE = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.sGH = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.sGI = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.sGJ = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.sGK = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    ad.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.ixE, this.sGH, this.sGI, this.mCountryCode, this.sGJ, Integer.valueOf(this.sGK) });
    if (!bt.isNullOrNil(this.sGH)) {
      this.sGH = com.tencent.mm.plugin.ipcall.a.c.aeE(this.sGH);
    }
    if (bt.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.aey(this.sGH))
      {
        if (bt.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.aew(this.sGH))) {
          this.sGH = com.tencent.mm.plugin.ipcall.a.a.aez(this.sGH);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.cIJ();
      }
    }
    else
    {
      if (this.sGK == 1) {
        break label469;
      }
      this.sGM = 0;
      this.sGL = 3;
      this.sGO = new com.tencent.mm.plugin.ipcall.model.e.b(this.sGH, this.mCountryCode, "", bt.iL(this), this.sGK);
      az.aeS().a(this.sGO, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      ad.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.sGL = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.sGI);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.ixE);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.sGH);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.sGK);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.sGL);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label469:
      this.sGM = -1;
      this.sGL = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.sGG != null) {
      this.sGG.sEq = null;
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.sGQ);
    az.aeS().b(807, this);
    az.aeS().b(746, this);
    AppMethodBeat.o(25753);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25754);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25754);
      return;
    }
    ad.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    ad.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25749);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25755);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn == this.sGO))
      {
        if (this.sGO.sCI != null) {
          ad.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.sGO.sCI.CWL), this.sGO.sCI.DYY, this.sGO.sCI.sLB });
        }
        if (this.sGM != 2)
        {
          this.sGM = 1;
          this.sGL = 1;
          paramString = this.sGO;
          if ((paramString.sCI != null) && (paramString.sCI.CWL == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            ad.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.sGO;
          if ((paramString.sCI != null) && ((paramString.sCI.CWL == 1) || (paramString.sCI.CWL == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.sGO.sCI == null) || (bt.isNullOrNil(this.sGO.sCI.sLB))) {
                break label406;
              }
              if (this.sGG != null)
              {
                ad.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.sGO.sCI.sLB, this.mCountryCode });
                this.mCountryCode = this.sGO.sCI.sLB;
                this.sGG.aed(this.sGO.sCI.sLB);
              }
            }
          }
          for (;;)
          {
            if ((this.sGO.sCI == null) || (bt.isNullOrNil(this.sGO.sCI.DYY)) || (this.sGG == null)) {
              break label481;
            }
            ad.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.sGO.sCI.DYY, this.sGH });
            this.sGH = this.sGO.sCI.DYY;
            this.sGG.dA(this.sGO.sCI.DYY, -1);
            AppMethodBeat.o(25755);
            return;
            paramInt1 = 0;
            break;
            label406:
            ad.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
          }
        }
        ad.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
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
    for (this.sGN = ((com.tencent.mm.plugin.ipcall.model.e.c)paramn).sCK.DAf;; this.sGN = null)
    {
      if (this.sGG != null) {
        this.sGG.ax(this.sGN);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.sGP = new com.tencent.mm.plugin.ipcall.model.e.c();
    az.aeS().a(this.sGP, 0);
    AppMethodBeat.o(25748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */