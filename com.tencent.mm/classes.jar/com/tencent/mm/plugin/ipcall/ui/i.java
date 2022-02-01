package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public final class i
  implements com.tencent.mm.plugin.ipcall.e, a.b
{
  Bitmap Hom;
  DialPad JKl;
  private String JMA;
  private String JMB;
  private String JMC;
  private int JMD;
  private int JME;
  private ImageButton JQA;
  public TextView JQB;
  public View JQC;
  private ImageButton JQD;
  private int JQE;
  String JQF;
  IPCallTalkUI JQG;
  com.tencent.mm.plugin.ipcall.c JQH;
  a JQI;
  private long JQJ;
  long JQK;
  boolean JQL;
  boolean JQM;
  private AudioManager JQN;
  private boolean JQO;
  private boolean JQP;
  private boolean JQQ;
  boolean JQR;
  boolean JQS;
  EditText JQu;
  TextView JQv;
  ImageView JQw;
  private IPCallFuncButton JQx;
  private IPCallFuncButton JQy;
  private IPCallFuncButton JQz;
  ImageView lKK;
  private TextView lPf;
  private String mCountryCode;
  private String qgV;
  
  public i(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.JQE = -1;
    this.JQK = -1L;
    this.JQL = false;
    this.JQM = false;
    this.JQN = null;
    this.JQO = false;
    this.JQP = true;
    this.JQQ = false;
    this.JQR = false;
    this.JQS = false;
    this.JQG = paramIPCallTalkUI;
    this.JQH = com.tencent.mm.plugin.ipcall.model.h.fRv();
    this.JQH.JFw = this;
    AppMethodBeat.o(26034);
  }
  
  private void Zt(int paramInt)
  {
    AppMethodBeat.i(26050);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      String str1 = com.tencent.mm.plugin.ipcall.a.c.Zw(com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHj);
      if (this.JQE != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.Zu(this.JQE);
        this.lPf.setText(str1 + this.JQG.getString(R.l.gLa, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.lPf.setText(str1 + this.JQG.getString(R.l.gKZ));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.lPf.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.JQJ / 60L), Long.valueOf(this.JQJ % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.lPf.setText(R.l.gLc);
    }
  }
  
  private void fSA()
  {
    AppMethodBeat.i(26043);
    this.JKl.setDialButtonClickListener(new i.2(this));
    AppMethodBeat.o(26043);
  }
  
  private void fSB()
  {
    AppMethodBeat.i(26045);
    this.JQE = com.tencent.mm.plugin.ipcall.a.a.jM(this.JMB, this.JMA);
    Zt(1);
    this.JQH.a(this.qgV, this.JMA, this.JMC, this.JQF, this.JMB, this.JQE, this.JMD, this.JME);
    Log.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.JQF });
    com.tencent.mm.plugin.ipcall.model.h.fRs().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void fSC()
  {
    AppMethodBeat.i(26046);
    if (com.tencent.mm.plugin.ipcall.model.h.fRq().JGn != null)
    {
      this.qgV = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.nickname;
      this.JQF = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHv;
      this.JMC = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.hgl;
      this.JMB = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.idl;
      this.JMA = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHu;
      this.JQE = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.phoneType;
      Log.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.qgV, this.JQF, this.JMC, this.JMB, this.JMA, Integer.valueOf(this.JQE) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void fSD()
  {
    AppMethodBeat.i(26047);
    com.tencent.mm.plugin.ipcall.model.h.fRu();
    Log.i("MicroMsg.TalkUIController", f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu));
    Zt(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu);
    fSF();
    fSE();
    AppMethodBeat.o(26047);
  }
  
  private void fSE()
  {
    AppMethodBeat.i(26048);
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
    {
      this.JQz.setChecked(com.tencent.mm.plugin.ipcall.model.h.fRt().JHB.cTU());
      this.JQx.setChecked(com.tencent.mm.plugin.ipcall.model.h.fRt().JHB.JGQ.lAj);
    }
    AppMethodBeat.o(26048);
  }
  
  private void fSF()
  {
    AppMethodBeat.i(26049);
    String str1 = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHv;
    String str2 = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHw;
    if (!Util.isNullOrNil(str2))
    {
      aJs(str2);
      this.JQv.setText(com.tencent.mm.plugin.ipcall.a.a.aJB(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!Util.isNullOrNil(str1))
    {
      aJs(str1);
      this.JQv.setText(com.tencent.mm.plugin.ipcall.a.a.aJB(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void fSw()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(12058, this.mCountryCode);
    k.a(this.JQG, this.JQG.getString(R.l.gvZ), this.JQG.getString(R.l.gwa), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        i.this.JQG.finish();
        i.this.JQG = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void fSx()
  {
    AppMethodBeat.i(26038);
    if ((!Util.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.aJz(this.JMA)))
    {
      this.JQF = (this.mCountryCode + this.JMA);
      if (!this.JQF.startsWith("+"))
      {
        this.JQF = ("+" + this.JQF);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.JQF = this.JMA;
    }
    AppMethodBeat.o(26038);
  }
  
  private void fSy()
  {
    AppMethodBeat.i(26039);
    com.tencent.mm.plugin.ipcall.model.h.fRt().lzt = this.JQG;
    com.tencent.mm.plugin.ipcall.model.h.fRt().fRJ();
    com.tencent.mm.plugin.ipcall.model.h.fRt().a(this);
    com.tencent.mm.plugin.ipcall.model.h.fRt().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void fSz()
  {
    AppMethodBeat.i(26042);
    if (!Util.isNullOrNil(this.JQF)) {
      aJs(this.JQF);
    }
    if (com.tencent.mm.compatible.util.d.rb(16))
    {
      this.JQu.setTypeface(Typeface.create("sans-serif-light", 0));
      this.JQv.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!Util.isNullOrNil(this.JMB)) {
      this.Hom = com.tencent.mm.plugin.ipcall.a.a.g(this.JQG, this.JMB, true);
    }
    if ((this.Hom == null) && (!Util.isNullOrNil(this.JMA)) && (com.tencent.mm.plugin.ipcall.a.a.bWY())) {
      this.Hom = com.tencent.mm.plugin.ipcall.a.a.bs(this.JQG, this.JMA);
    }
    if ((this.Hom == null) && (!Util.isNullOrNil(this.JMC))) {
      this.Hom = com.tencent.mm.modelavatar.d.f(this.JMC, 480, 480, 4);
    }
    if (this.Hom == null)
    {
      this.JQw.setVisibility(0);
      this.lKK.setVisibility(8);
    }
    if (this.Hom != null)
    {
      this.JQw.setVisibility(8);
      this.lKK.setVisibility(0);
      this.lKK.setImageBitmap(this.Hom);
    }
    this.JQD.setOnClickListener(new i.8(this));
    this.JQz.setClickCallback(new IPCallFuncButton.a()
    {
      public final void sK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        Log.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
        {
          i.this.JQL = paramAnonymousBoolean;
          i.this.JQM = paramAnonymousBoolean;
          com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.OAn.b(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!com.tencent.mm.plugin.ipcall.model.h.fRA().aFG()) && (!com.tencent.mm.plugin.ipcall.model.h.fRu().fRm())) {
          com.tencent.mm.plugin.ipcall.model.h.fRA().BN(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.JQx.setClickCallback(new IPCallFuncButton.a()
    {
      public final void sK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRl())
        {
          Log.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = com.tencent.mm.plugin.ipcall.model.h.fRr();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.JHR.setAppCmd(412);; i = locala.JHR.setAppCmd(413))
        {
          if (i < 0) {
            Log.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          com.tencent.mm.plugin.ipcall.model.h.fRt().JHB.JGQ.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.OAn.b(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.JQy.setClickCallback(new IPCallFuncButton.a()
    {
      public final void sK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          locali = i.this;
          if (locali.Hom == null) {
            locali.lKK.setVisibility(8);
          }
          for (;;)
          {
            locali.lKK.setVisibility(8);
            locali.JQw.setVisibility(8);
            locali.JQu.setText("");
            locali.JQv.setText("");
            locali.JKl.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.OAn.b(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            locali.lKK.setVisibility(4);
          }
        }
        i locali = i.this;
        if (locali.Hom != null)
        {
          locali.lKK.setVisibility(0);
          locali.JQw.setVisibility(8);
        }
        for (;;)
        {
          locali.aJs(locali.JQF);
          locali.JKl.setVisibility(4);
          break;
          locali.JQw.setVisibility(0);
          locali.lKK.setVisibility(8);
        }
      }
    });
    this.JQA.setOnClickListener(new i.12(this));
    AppMethodBeat.o(26042);
  }
  
  private void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    fww();
    if (!Util.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.lPf.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (Util.isNullOrNil(paramString3)) {
          paramString1 = this.JQG.getString(R.l.gKh);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          k.a(this.JQG, paramString2, paramString1, this.JQG.getString(R.l.gKi), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              i.this.JQG.finish();
              AppMethodBeat.o(26028);
            }
          });
        }
        AppMethodBeat.o(26037);
        return;
      }
      paramString1 = paramString3;
    }
  }
  
  private void initUI()
  {
    AppMethodBeat.i(26040);
    this.JQu.setKeyListener(null);
    this.JQu.setHorizontallyScrolling(true);
    this.JKl.setVisibility(4);
    this.JKl.setTalkUIMode(true);
    fSz();
    fSA();
    AppMethodBeat.o(26040);
  }
  
  final void aJs(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!Util.isNullOrNil(this.qgV))
    {
      jL(this.qgV, com.tencent.mm.plugin.ipcall.a.a.aJB(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    jL(com.tencent.mm.plugin.ipcall.a.a.aJB(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.JQO = this.JQG.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    Log.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.JQO) });
    this.JQw = ((ImageView)this.JQG.findViewById(R.h.fYQ));
    this.lKK = ((ImageView)this.JQG.findViewById(R.h.fYP));
    this.JQu = ((EditText)this.JQG.findViewById(R.h.fYU));
    this.lPf = ((TextView)this.JQG.findViewById(R.h.fYX));
    this.JQv = ((TextView)this.JQG.findViewById(R.h.fYV));
    this.JQx = ((IPCallFuncButton)this.JQG.findViewById(R.h.fYT));
    this.JQy = ((IPCallFuncButton)this.JQG.findViewById(R.h.fYR));
    this.JQz = ((IPCallFuncButton)this.JQG.findViewById(R.h.fYW));
    this.JQA = ((ImageButton)this.JQG.findViewById(R.h.fYS));
    this.JQD = ((ImageButton)this.JQG.findViewById(R.h.ipcall_mini_action));
    this.JQB = ((TextView)this.JQG.findViewById(R.h.voip_net_status_hint));
    this.JQC = this.JQG.findViewById(R.h.gdk);
    this.JKl = ((DialPad)this.JQG.findViewById(R.h.fFN));
    if (this.JQO)
    {
      fSC();
      fSy();
      initUI();
      fSD();
      AppMethodBeat.o(26035);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRj())
    {
      k.a(this.JQG, R.l.in_wechat_out_tip, R.l.app_tip, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          i.this.JQG.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    fSy();
    this.qgV = paramString1;
    this.JMA = paramString2;
    this.JMB = paramString3;
    this.mCountryCode = paramString4;
    this.JMD = paramInt1;
    this.JME = paramInt2;
    if (!Util.isNullOrNil(this.JMA)) {
      this.JMA = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.JMA);
    }
    if (Util.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.aJz(this.JMA))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.JMA);
        if (!Util.isNullOrNil(paramString1)) {
          break label581;
        }
        this.JMA = com.tencent.mm.plugin.ipcall.a.a.aJA(this.JMA);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.fSL();; this.mCountryCode = paramString1)
    {
      Log.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.fRb().aIT(this.mCountryCode);
      if (Util.isNullOrNil(this.qgV)) {
        this.qgV = com.tencent.mm.plugin.ipcall.a.a.bp(this.JQG, this.JMA);
      }
      this.JMC = paramString5;
      fSx();
      Log.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.JQF });
      if (!com.tencent.mm.plugin.ipcall.model.c.fRb().Zb(Util.getInt(this.mCountryCode, -1))) {
        break;
      }
      fSw();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.JMA = com.tencent.mm.plugin.ipcall.a.a.aJC(this.JMA);
    }
    if (!NetStatusUtil.isNetworkConnected(this.JQG))
    {
      Toast.makeText(this.JQG, R.l.voip_net_unavailable, 1).show();
      this.JQG.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.JQG.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      Log.i("MicroMsg.TalkUIController", "onDisasterHappen");
      k.a(this.JQG, this.JQG.getString(R.l.gKm, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.JQG.getString(R.l.gKh), this.JQG.getString(R.l.gKi), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          i.this.JQG.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    initUI();
    if ((!this.JQO) || (!com.tencent.mm.plugin.ipcall.model.h.fRu().fRj())) {
      fSB();
    }
    this.JQQ = false;
    AppMethodBeat.o(26035);
  }
  
  public final void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    Log.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.JQP = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!Util.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.JQG.getString(R.l.gKh);
      }
    }
    label173:
    for (;;)
    {
      k.a(this.JQG, paramString2, paramString1, this.JQG.getString(R.l.gKi), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          i.this.JQG.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        bh.getNotification().cancel(42);
        if ((this.JQI != null) && (!this.JQQ)) {
          this.JQI.xN(this.JQP);
        }
        AppMethodBeat.o(26055);
        return;
        g(paramString1, paramString2, paramInt2, this.JQG.getString(R.l.gKg));
        continue;
        g(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  public final void fQG()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    Log.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHv;
    String str2 = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHw;
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      Log.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      aJs(str2);
    }
    Log.i("MicroMsg.TalkUIController", "callFlag:" + com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHj);
    int k = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn.JHj;
    int i = j;
    if ((k & 0x1) > 0)
    {
      i = j;
      if ((k & 0x2) > 0)
      {
        i = j;
        if ((k & 0x8) <= 0) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      Log.i("MicroMsg.TalkUIController", "isNotFree");
      k.a(this.JQG, R.l.gLi, R.l.gLj, R.l.gLh, R.l.gLg, true, null, new i.3(this));
    }
    Zt(3);
    AppMethodBeat.o(26051);
  }
  
  public final void fQH()
  {
    AppMethodBeat.i(26052);
    Log.d("MicroMsg.TalkUIController", "onStartRing");
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
    {
      this.JQL = this.JQz.isChecked();
      this.JQM = this.JQz.isChecked();
      com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(this.JQz.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void fQW()
  {
    AppMethodBeat.i(26053);
    Log.d("MicroMsg.TalkUIController", "onUserAccept");
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
    {
      this.JQL = this.JQz.isChecked();
      this.JQM = this.JQz.isChecked();
      com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(this.JQz.isChecked());
    }
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRl()) {
      com.tencent.mm.plugin.ipcall.model.h.fRt().JHB.JGQ.setMute(this.JQx.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void fQX()
  {
    AppMethodBeat.i(26054);
    Log.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    fww();
    Zt(10);
    bh.getNotification().cancel(42);
    if (this.JQI != null) {
      this.JQI.xN(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void fQY()
  {
    AppMethodBeat.i(26059);
    this.JQG.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void fQZ()
  {
    AppMethodBeat.i(26058);
    this.JQJ = com.tencent.mm.plugin.ipcall.model.h.fRv().fQR();
    Zt(5);
    AppMethodBeat.o(26058);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(26060);
    if (this.JQB != null) {
      this.JQB.setVisibility(4);
    }
    if (this.JQC != null) {
      this.JQC.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  final void jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.JQu.setText(paramString1);
    if (!Util.isNullOrNil(paramString1)) {
      this.JQu.setSelection(this.JQu.getText().length() - 1);
    }
    this.JQv.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void xH(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    Log.i("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
    {
      if (paramBoolean)
      {
        this.JQL = this.JQz.isChecked();
        com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(false);
        this.JQz.setEnable(false);
        Log.i("MicroMsg.TalkUIController", "mHeadsetResumeSpeaker:%s", new Object[] { Boolean.valueOf(this.JQL) });
        AppMethodBeat.o(26056);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(this.JQL);
      this.JQz.setEnable(true);
      this.JQz.setChecked(this.JQL);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void xI(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    Log.i("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
    {
      if (paramBoolean)
      {
        this.JQM = this.JQz.isChecked();
        com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(false);
        this.JQz.setEnable(false);
        Log.i("MicroMsg.TalkUIController", "mBluetoothResumeSpeaker:%s", new Object[] { Boolean.valueOf(this.JQM) });
        AppMethodBeat.o(26057);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.h.fRt().xJ(this.JQM);
      this.JQz.setEnable(true);
      this.JQz.setChecked(this.JQM);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void xN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i
 * JD-Core Version:    0.7.0.1
 */