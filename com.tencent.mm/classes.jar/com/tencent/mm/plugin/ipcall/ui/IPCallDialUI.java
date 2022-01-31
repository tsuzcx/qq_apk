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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements f, b.a
{
  private String gJX;
  private TextView gqe;
  private String mCountryCode;
  private ImageButton nQA;
  private View nQB;
  private TextView nQC;
  private TextView nQD;
  private DialPad nQw;
  private TextView nQx;
  private EditText nQy;
  private View nQz;
  private b nSL;
  private String nSM;
  private String nSN;
  private String nSO;
  private int nSP;
  private int nSQ;
  private int nSR;
  private LinkedList<cuz> nSS;
  com.tencent.mm.plugin.ipcall.a.d.b nST;
  com.tencent.mm.plugin.ipcall.a.d.c nSU;
  private com.tencent.mm.sdk.b.c nSV;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(22129);
    this.nSP = 0;
    this.nSQ = 0;
    this.nSR = -1;
    this.nSV = new IPCallDialUI.2(this);
    AppMethodBeat.o(22129);
  }
  
  private void bKi()
  {
    AppMethodBeat.i(22141);
    ab.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.nSR = 2;
    if (this.nSQ == 1)
    {
      this.nSQ = 2;
      AppMethodBeat.o(22141);
      return;
    }
    this.nSQ = 4;
    AppMethodBeat.o(22141);
  }
  
  private void init()
  {
    AppMethodBeat.i(22133);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ab.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (!bool)
    {
      AppMethodBeat.o(22133);
      return;
    }
    setMMTitle(2131300840);
    setVolumeControlStream(1);
    this.nQw = ((DialPad)findViewById(2131825219));
    this.nQx = ((TextView)findViewById(2131825210));
    this.nQB = findViewById(2131825213);
    this.nQy = ((EditText)findViewById(2131825211));
    this.nQz = findViewById(2131825212);
    this.gqe = ((TextView)findViewById(2131825215));
    this.nQA = ((ImageButton)findViewById(2131823417));
    this.nQC = ((TextView)findViewById(2131825214));
    this.nQD = ((TextView)findViewById(2131825216));
    this.nSL = new b(this, this.nQy, this.nQx, this.nQz, this.nQw, this.nQA, this.gqe, this.nQB, this.nQC, this.nQD);
    this.nSL.nQv = this;
    if (!bo.isNullOrNil(this.nSM)) {
      this.nSL.cy(this.nSM, -1);
    }
    if (!bo.isNullOrNil(this.mCountryCode)) {
      this.nSL.Rj(this.mCountryCode);
    }
    if ((!bo.isNullOrNil(this.nSM)) && (!bo.isNullOrNil(this.mCountryCode))) {
      this.nSL.bJZ();
    }
    this.nSL.ai(this.nSS);
    AppMethodBeat.o(22133);
  }
  
  public final void Rk(String paramString)
  {
    AppMethodBeat.i(22139);
    ab.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.nSR != 2) && (this.nSR != -1) && (!this.mCountryCode.equals(paramString))) {
      bKi();
    }
    AppMethodBeat.o(22139);
  }
  
  public final void Rl(String paramString)
  {
    AppMethodBeat.i(22140);
    ab.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.nSM });
    if ((this.nSR != 2) && (this.nSR != -1) && (!this.nSM.equals(paramString))) {
      bKi();
    }
    AppMethodBeat.o(22140);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969928;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22134);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.nSL;
    ab.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = bo.bf(paramIntent.getStringExtra("country_name"), "");
      paramIntent = bo.bf(paramIntent.getStringExtra("couttry_code"), "");
      ab.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!bo.isNullOrNil(paramIntent)) && (!bo.isNullOrNil(str)))
      {
        localb.nQE = str;
        localb.nQF = "+".concat(String.valueOf(paramIntent));
        localb.nQx.setText(localb.nQF);
        localb.nQG = b.eT(paramIntent.replace("+", ""), localb.nQG);
        localb.cy(localb.nQG, -1);
        localb.nQK = false;
      }
      AppMethodBeat.o(22134);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.cmc.setResult(-1, paramIntent);
      localb.cmc.finish();
    }
    AppMethodBeat.o(22134);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22130);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.c(this.nSV);
    aw.Rc().a(807, this);
    aw.Rc().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), 2131230755);
    this.gJX = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.nSM = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.nSN = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.nSO = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.nSP = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    ab.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.gJX, this.nSM, this.nSN, this.mCountryCode, this.nSO, Integer.valueOf(this.nSP) });
    if (!bo.isNullOrNil(this.nSM)) {
      this.nSM = com.tencent.mm.plugin.ipcall.b.c.RK(this.nSM);
    }
    if (bo.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.b.a.RE(this.nSM))
      {
        if (bo.isNullOrNil(com.tencent.mm.plugin.ipcall.b.a.RC(this.nSM))) {
          this.nSM = com.tencent.mm.plugin.ipcall.b.a.RF(this.nSM);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.b.c.bKM();
      }
    }
    else
    {
      if (this.nSP == 1) {
        break label468;
      }
      this.nSR = 0;
      this.nSQ = 3;
      this.nST = new com.tencent.mm.plugin.ipcall.a.d.b(this.nSM, this.mCountryCode, "", bo.hi(this), this.nSP);
      aw.Rc().a(this.nST, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(22130);
      return;
      ab.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.nSQ = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.nSN);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.gJX);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.nSM);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.nSP);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.nSQ);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(22130);
      return;
      label468:
      this.nSR = -1;
      this.nSQ = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22136);
    super.onDestroy();
    if (this.nSL != null) {
      this.nSL.nQv = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.nSV);
    aw.Rc().b(807, this);
    aw.Rc().b(746, this);
    AppMethodBeat.o(22136);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22137);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(22137);
      return;
    }
    ab.i("MicroMsg.IPCallDialUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22137);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(22137);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131297837), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22132);
    ab.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
    AppMethodBeat.o(22132);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22138);
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm == this.nST))
      {
        if (this.nST.nON != null) {
          ab.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.nST.nON.wKy), this.nST.nON.xCn, this.nST.nON.nXE });
        }
        if (this.nSR != 2)
        {
          this.nSR = 1;
          this.nSQ = 1;
          paramString = this.nST;
          if ((paramString.nON != null) && (paramString.nON.wKy == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            ab.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(22138);
            return;
          }
          paramString = this.nST;
          if ((paramString.nON != null) && ((paramString.nON.wKy == 1) || (paramString.nON.wKy == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.nST.nON == null) || (bo.isNullOrNil(this.nST.nON.nXE))) {
                break label406;
              }
              if (this.nSL != null)
              {
                ab.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.nST.nON.nXE, this.mCountryCode });
                this.mCountryCode = this.nST.nON.nXE;
                this.nSL.Rj(this.nST.nON.nXE);
              }
            }
          }
          for (;;)
          {
            if ((this.nST.nON == null) || (bo.isNullOrNil(this.nST.nON.xCn)) || (this.nSL == null)) {
              break label481;
            }
            ab.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.nST.nON.xCn, this.nSM });
            this.nSM = this.nST.nON.xCn;
            this.nSL.cy(this.nST.nON.xCn, -1);
            AppMethodBeat.o(22138);
            return;
            paramInt1 = 0;
            break;
            label406:
            ab.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
          }
        }
        ab.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
        AppMethodBeat.o(22138);
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.c)) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label488;
      }
    }
    label481:
    label488:
    for (this.nSS = ((com.tencent.mm.plugin.ipcall.a.d.c)paramm).nOP.xhd;; this.nSS = null)
    {
      if (this.nSL != null) {
        this.nSL.ai(this.nSS);
      }
      AppMethodBeat.o(22138);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(22131);
    super.onStart();
    this.nSU = new com.tencent.mm.plugin.ipcall.a.d.c();
    aw.Rc().a(this.nSU, 0);
    AppMethodBeat.o(22131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(22135);
    ab.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.b.c.es(this))
    {
      AppMethodBeat.o(22135);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.a.c.bIZ().xE(bo.getInt(paramString1, -1)))
    {
      com.tencent.mm.ui.base.h.b(this, getString(2131297832), getString(2131297833), true);
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(12058, paramString1);
      AppMethodBeat.o(22135);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.nSP);
    localIntent.putExtra("IPCallTalkUI_countryType", this.nSQ);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(22135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */