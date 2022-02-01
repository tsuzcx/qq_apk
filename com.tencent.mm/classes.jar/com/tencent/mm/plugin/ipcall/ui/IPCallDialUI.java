package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abm;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.ehw;
import com.tencent.mm.protocal.protobuf.gdh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class IPCallDialUI
  extends MMActivity
  implements com.tencent.mm.am.h, b.a
{
  private DialPad JKl;
  private TextView JKm;
  private EditText JKn;
  private View JKo;
  private ImageButton JKp;
  private View JKq;
  private TextView JKr;
  private TextView JKs;
  private String JMA;
  private String JMB;
  private String JMC;
  private int JMD;
  private int JME;
  private int JMF;
  private LinkedList<gdh> JMG;
  com.tencent.mm.plugin.ipcall.model.e.b JMH;
  com.tencent.mm.plugin.ipcall.model.e.c JMI;
  private IListener JMJ;
  private b JMz;
  private String mCountryCode;
  private TextView nnW;
  private String qgV;
  
  public IPCallDialUI()
  {
    AppMethodBeat.i(25746);
    this.JMD = 0;
    this.JME = 0;
    this.JMF = -1;
    this.JMJ = new IListener(f.hfK) {};
    AppMethodBeat.o(25746);
  }
  
  private void fSk()
  {
    AppMethodBeat.i(25758);
    Log.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
    this.JMF = 2;
    if (this.JME == 1)
    {
      this.JME = 2;
      AppMethodBeat.o(25758);
      return;
    }
    this.JME = 4;
    AppMethodBeat.o(25758);
  }
  
  private void init()
  {
    AppMethodBeat.i(25750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null);
    Log.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(25750);
      return;
    }
    setMMTitle(R.l.gKl);
    setVolumeControlStream(1);
    this.JKl = ((DialPad)findViewById(R.h.fFN));
    this.JKm = ((TextView)findViewById(R.h.fDG));
    this.JKq = findViewById(R.h.fDF);
    this.JKn = ((EditText)findViewById(R.h.fTj));
    this.JKo = findViewById(R.h.fTi);
    this.nnW = ((TextView)findViewById(R.h.fFP));
    this.JKp = ((ImageButton)findViewById(R.h.fFx));
    this.JKr = ((TextView)findViewById(R.h.fDH));
    this.JKs = ((TextView)findViewById(R.h.fFA));
    this.JMz = new b(this, this.JKn, this.JKm, this.JKo, this.JKl, this.JKp, this.nnW, this.JKq, this.JKr, this.JKs);
    this.JMz.JKk = this;
    if (!Util.isNullOrNil(this.JMA)) {
      this.JMz.fK(this.JMA, -1);
    }
    if (!Util.isNullOrNil(this.mCountryCode)) {
      this.JMz.aJf(this.mCountryCode);
    }
    if ((!Util.isNullOrNil(this.JMA)) && (!Util.isNullOrNil(this.mCountryCode))) {
      this.JMz.fSb();
    }
    this.JMz.bB(this.JMG);
    AppMethodBeat.o(25750);
  }
  
  public final void C(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25752);
    Log.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    if (!com.tencent.mm.plugin.ipcall.a.c.iI(this))
    {
      AppMethodBeat.o(25752);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.c.fRb().Zb(Util.getInt(paramString1, -1)))
    {
      k.c(this, getString(R.l.gvZ), getString(R.l.gwa), true);
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(12058, paramString1);
      AppMethodBeat.o(25752);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    Intent localIntent = new Intent(this, IPCallTalkUI.class);
    localIntent.putExtra("IPCallTalkUI_contactId", paramString3);
    localIntent.putExtra("IPCallTalkUI_countryCode", paramString1);
    localIntent.putExtra("IPCallTalkUI_nickname", paramString4);
    localIntent.putExtra("IPCallTalkUI_phoneNumber", paramString2);
    localIntent.putExtra("IPCallTalkUI_dialScene", this.JMD);
    localIntent.putExtra("IPCallTalkUI_countryType", this.JME);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(25752);
  }
  
  public final void aJg(String paramString)
  {
    AppMethodBeat.i(25756);
    Log.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[] { paramString, this.mCountryCode });
    if ((this.JMF != 2) && (this.JMF != -1) && (!this.mCountryCode.equals(paramString))) {
      fSk();
    }
    AppMethodBeat.o(25756);
  }
  
  public final void aJh(String paramString)
  {
    AppMethodBeat.i(25757);
    Log.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[] { paramString, this.JMA });
    if ((this.JMF != 2) && (this.JMF != -1) && (!this.JMA.equals(paramString))) {
      fSk();
    }
    AppMethodBeat.o(25757);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkM;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25751);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.JMz;
    Log.d("MicroMsg.DialPadController", "onActivityResult");
    if ((paramInt1 == 100) && (paramInt2 == 100))
    {
      String str = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      paramIntent = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      Log.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[] { paramIntent, str });
      if ((!Util.isNullOrNil(paramIntent)) && (!Util.isNullOrNil(str)))
      {
        localb.JKt = str;
        localb.JKu = "+".concat(String.valueOf(paramIntent));
        localb.JKm.setText(localb.JKu);
        localb.JKv = localb.jJ(paramIntent.replace("+", ""), localb.JKv);
        localb.fK(localb.JKv, -1);
        localb.JKz = false;
      }
      AppMethodBeat.o(25751);
      return;
    }
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      paramIntent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
      localb.lzt.setResult(-1, paramIntent);
      localb.lzt.finish();
    }
    AppMethodBeat.o(25751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25747);
    super.onCreate(paramBundle);
    this.JMJ.alive();
    bh.aZW().a(807, this);
    bh.aZW().a(746, this);
    getWindow().addFlags(131072);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25742);
        IPCallDialUI.this.finish();
        AppMethodBeat.o(25742);
        return true;
      }
    }, R.k.actionbar_quit_webview_icon);
    this.qgV = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.JMA = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.JMB = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.JMC = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.JMD = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    Log.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[] { this.qgV, this.JMA, this.JMB, this.mCountryCode, this.JMC, Integer.valueOf(this.JMD) });
    if (!Util.isNullOrNil(this.JMA)) {
      this.JMA = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.JMA);
    }
    if (Util.isNullOrNil(this.mCountryCode))
    {
      if (com.tencent.mm.plugin.ipcall.a.a.aJz(this.JMA))
      {
        if (Util.isNullOrNil(com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.JMA))) {
          this.JMA = com.tencent.mm.plugin.ipcall.a.a.aJA(this.JMA);
        }
      }
      else {
        this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.fSL();
      }
    }
    else
    {
      if (this.JMD == 1) {
        break label465;
      }
      this.JMF = 0;
      this.JME = 3;
      this.JMH = new com.tencent.mm.plugin.ipcall.model.e.b(this.JMA, this.mCountryCode, "", Util.getSimCountryCode(this), this.JMD);
      bh.aZW().a(this.JMH, 0);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(25747);
      return;
      Log.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
      this.JME = 4;
      paramBundle = new Intent(this, IPCallTalkUI.class);
      paramBundle.putExtra("IPCallTalkUI_contactId", this.JMB);
      paramBundle.putExtra("IPCallTalkUI_countryCode", this.mCountryCode);
      paramBundle.putExtra("IPCallTalkUI_nickname", this.qgV);
      paramBundle.putExtra("IPCallTalkUI_phoneNumber", this.JMA);
      paramBundle.putExtra("IPCallTalkUI_dialScene", this.JMD);
      paramBundle.putExtra("IPCallTalkUI_countryType", this.JME);
      startActivityForResult(paramBundle, 1001);
      finish();
      AppMethodBeat.o(25747);
      return;
      label465:
      this.JMF = -1;
      this.JME = 4;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25753);
    super.onDestroy();
    if (this.JMz != null) {
      this.JMz.JKk = null;
    }
    this.JMJ.dead();
    bh.aZW().b(807, this);
    bh.aZW().b(746, this);
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
      k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(25744);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(IPCallDialUI.this.getContext());
          AppMethodBeat.o(25744);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(25745);
          paramAnonymousDialogInterface.dismiss();
          IPCallDialUI.this.finish();
          AppMethodBeat.o(25745);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25749);
    Log.d("MicroMsg.IPCallDialUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25749);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(25755);
    if ((paramp instanceof com.tencent.mm.plugin.ipcall.model.e.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp == this.JMH))
      {
        if (this.JMH.JIC != null) {
          Log.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[] { Integer.valueOf(this.JMH.JIC.aaGv), this.JMH.JIC.abmS, this.JMH.JIC.JRf });
        }
        if (this.JMF != 2)
        {
          this.JMF = 1;
          this.JME = 1;
          paramString = this.JMH;
          if ((paramString.JIC != null) && (paramString.JIC.aaGv == 2)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            Log.i("MicroMsg.IPCallDialUI", "check error show error dialog");
            AppMethodBeat.o(25755);
            return;
          }
          paramString = this.JMH;
          if ((paramString.JIC != null) && ((paramString.JIC.aaGv == 1) || (paramString.JIC.aaGv == 0)))
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if ((this.JMH.JIC == null) || (Util.isNullOrNil(this.JMH.JIC.JRf))) {
                break label406;
              }
              if (this.JMz != null)
              {
                Log.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[] { this.JMH.JIC.JRf, this.mCountryCode });
                this.mCountryCode = this.JMH.JIC.JRf;
                this.JMz.aJf(this.JMH.JIC.JRf);
              }
            }
          }
          for (;;)
          {
            if ((this.JMH.JIC == null) || (Util.isNullOrNil(this.JMH.JIC.abmS)) || (this.JMz == null)) {
              break label481;
            }
            Log.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[] { this.JMH.JIC.abmS, this.JMA });
            this.JMA = this.JMH.JIC.abmS;
            this.JMz.fK(this.JMH.JIC.abmS, -1);
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
    else if ((paramp instanceof com.tencent.mm.plugin.ipcall.model.e.c)) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label488;
      }
    }
    label481:
    label488:
    for (this.JMG = ((com.tencent.mm.plugin.ipcall.model.e.c)paramp).JIE.aaAY;; this.JMG = null)
    {
      if (this.JMz != null) {
        this.JMz.bB(this.JMG);
      }
      AppMethodBeat.o(25755);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25748);
    super.onStart();
    this.JMI = new com.tencent.mm.plugin.ipcall.model.e.c();
    bh.aZW().a(this.JMI, 0);
    AppMethodBeat.o(25748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI
 * JD-Core Version:    0.7.0.1
 */