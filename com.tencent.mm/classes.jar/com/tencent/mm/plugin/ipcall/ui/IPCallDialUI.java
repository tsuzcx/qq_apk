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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements f, b.a
{
  private TextView hbU;
  private String jqQ;
  private String mCountryCode;
  private DialPad uOL;
  private TextView uOM;
  private EditText uON;
  private View uOO;
  private ImageButton uOP;
  private View uOQ;
  private TextView uOR;
  private TextView uOS;
  private b uRa;
  private String uRb;
  private String uRc;
  private String uRd;
  private int uRe;
  private int uRf;
  private int uRg;
  private LinkedList<eal> uRh;
  com.tencent.mm.plugin.ipcall.model.e.b uRi;
  com.tencent.mm.plugin.ipcall.model.e.c uRj;
  private com.tencent.mm.sdk.b.c uRk;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.uRe = 0;
    this.uRf = 0;
    this.uRg = -1;
    this.uRk = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(25746);
  }
  
  private void deA()
  {
    AppMethodBeat.i(25758);
    ad.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.uRg = 2;
    if (this.uRf == 1)
    {
      this.uRf = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.uRf = 4;
    AppMethodBeat.o(25758);
  }
  
  private void init()
  {
    AppMethodBeat.i(25750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ad.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
    if (!bool)
    {
      AppMethodBeat.o(25750);
      return;
    }
    setMMTitle(2131760441);
    setVolumeControlStream(1);
    this.uOL = ((DialPad)findViewById(2131299111));
    this.uOM = ((TextView)findViewById(2131298806));
    this.uOQ = findViewById(2131298804);
    this.uON = ((EditText)findViewById(2131303238));
    this.uOO = findViewById(2131303237);
    this.hbU = ((TextView)findViewById(2131299115));
    this.uOP = ((ImageButton)findViewById(2131299095));
    this.uOR = ((TextView)findViewById(2131298808));
    this.uOS = ((TextView)findViewById(2131299098));
    this.uRa = new b(this, this.uON, this.uOM, this.uOO, this.uOL, this.uOP, this.hbU, this.uOQ, this.uOR, this.uOS);
    this.uRa.uOK = this;
    if (!bt.isNullOrNil(this.uRb)) {
      this.uRa.dX(this.uRb, -1);
    }
    if (!bt.isNullOrNil(this.mCountryCode)) {
      this.uRa.anI(this.mCountryCode);
    }
    if ((!bt.isNullOrNil(this.uRb)) && (!bt.isNullOrNil(this.mCountryCode))) {
      this.uRa.der();
    }
    this.uRa.aG(this.uRh);
    AppMethodBeat.o(25750);
  }
  
  public final void anJ(String paramString)
  {
    AppMethodBeat.i(25756);
    ad.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.uRg != 2) && (this.uRg != -1) && (!this.mCountryCode.equals(paramString))) {
      deA();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void anK(String paramString)
  {
    AppMethodBeat.i(25757);
    ad.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.uRb });
    if ((this.uRg != 2) && (this.uRg != -1) && (!this.uRb.equals(paramString))) {
      deA();
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
    b localb = this.uRa;
    ad.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = bt.bI(paramIntent.getStringExtra("country_name"), "");
      paramIntent = bt.bI(paramIntent.getStringExtra("couttry_code"), "");
      ad.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!bt.isNullOrNil(paramIntent)) && (!bt.isNullOrNil(str)))
      {
        localb.uOT = str;
        localb.uOU = "+".concat(String.valueOf(paramIntent));
        localb.uOM.setText(localb.uOU);
        localb.uOV = b.hx(paramIntent.replace("+", ""), localb.uOV);
        localb.dX(localb.uOV, -1);
        localb.uOZ = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.fLP.setResult(-1, paramIntent);
      localb.fLP.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IbL.c(this.uRk);
    ba.aiU().a(807, this);
    ba.aiU().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new IPCallDialUI.1(this), 2131689508);
    this.jqQ = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.uRb = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.uRc = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.uRd = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.uRe = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    ad.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.jqQ, this.uRb, this.uRc, this.mCountryCode, this.uRd, Integer.valueOf(this.uRe) });
    if (!bt.isNullOrNil(this.uRb)) {
      this.uRb = com.tencent.mm.plugin.ipcall.a.c.aoj(this.uRb);
    }
    if (bt.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.aod(this.uRb))
      {
        if (bt.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.aob(this.uRb))) {
          this.uRb = com.tencent.mm.plugin.ipcall.a.a.aoe(this.uRb);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.dff();
      }
    }
    else
    {
      if (this.uRe == 1) {
        break label468;
      }
      this.uRg = 0;
      this.uRf = 3;
      this.uRi = new com.tencent.mm.plugin.ipcall.model.e.b(this.uRb, this.mCountryCode, "", bt.jg(this), this.uRe);
      ba.aiU().a(this.uRi, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      ad.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.uRf = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.uRc);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.jqQ);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.uRb);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.uRe);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.uRf);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label468:
      this.uRg = -1;
      this.uRf = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.uRa != null) {
      this.uRa.uOK = null;
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.uRk);
    ba.aiU().b(807, this);
    ba.aiU().b(746, this);
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
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new IPCallDialUI.3(this), new IPCallDialUI.4(this));
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
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn == this.uRi))
      {
        if (this.uRi.uNd != null) {
          ad.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.uRi.uNd.FWG), this.uRi.uNd.Hga, this.uRi.uNd.uVT });
        }
        if (this.uRg != 2)
        {
          this.uRg = 1;
          this.uRf = 1;
          paramString = this.uRi;
          if ((paramString.uNd != null) && (paramString.uNd.FWG == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            ad.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.uRi;
          if ((paramString.uNd != null) && ((paramString.uNd.FWG == 1) || (paramString.uNd.FWG == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.uRi.uNd == null) || (bt.isNullOrNil(this.uRi.uNd.uVT))) {
                break label406;
              }
              if (this.uRa != null)
              {
                ad.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.uRi.uNd.uVT, this.mCountryCode });
                this.mCountryCode = this.uRi.uNd.uVT;
                this.uRa.anI(this.uRi.uNd.uVT);
              }
            }
          }
          for (;;)
          {
            if ((this.uRi.uNd == null) || (bt.isNullOrNil(this.uRi.uNd.Hga)) || (this.uRa == null)) {
              break label481;
            }
            ad.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.uRi.uNd.Hga, this.uRb });
            this.uRb = this.uRi.uNd.Hga;
            this.uRa.dX(this.uRi.uNd.Hga, -1);
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
    for (this.uRh = ((com.tencent.mm.plugin.ipcall.model.e.c)paramn).uNf.GEZ;; this.uRh = null)
    {
      if (this.uRa != null) {
        this.uRa.aG(this.uRh);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.uRj = new com.tencent.mm.plugin.ipcall.model.e.c();
    ba.aiU().a(this.uRj, 0);
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
    ad.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.fF(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.ddr().Ix(bt.getInt(paramString1, -1)))
    {
      h.c(this, getString(2131756761), getString(2131756762), true);
      g.yhR.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    g.yhR.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.uRe);
    localIntent.putExtra("IPCallTalkUI_countryType", this.uRf);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */