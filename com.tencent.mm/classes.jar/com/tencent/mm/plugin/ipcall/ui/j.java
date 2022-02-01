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
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class j
  implements e, a.b
{
  private TextView fBE;
  ImageView fxQ;
  private String iXH;
  private String mCountryCode;
  DialPad tLY;
  private String tOo;
  private String tOp;
  private String tOq;
  private int tOr;
  private int tOs;
  private IPCallFuncButton tSA;
  private ImageButton tSB;
  public TextView tSC;
  public View tSD;
  private ImageButton tSE;
  private int tSF;
  String tSG;
  IPCallTalkUI tSH;
  com.tencent.mm.plugin.ipcall.c tSI;
  a tSJ;
  private long tSK;
  long tSL;
  boolean tSM;
  boolean tSN;
  private AudioManager tSO;
  private boolean tSP;
  private boolean tSQ;
  private boolean tSR;
  boolean tSS;
  boolean tST;
  Bitmap tSm;
  EditText tSv;
  TextView tSw;
  ImageView tSx;
  private IPCallFuncButton tSy;
  private IPCallFuncButton tSz;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.tSF = -1;
    this.tSL = -1L;
    this.tSM = false;
    this.tSN = false;
    this.tSO = null;
    this.tSP = false;
    this.tSQ = true;
    this.tSR = false;
    this.tSS = false;
    this.tST = false;
    this.tSH = paramIPCallTalkUI;
    this.tSI = com.tencent.mm.plugin.ipcall.model.i.cUA();
    this.tSI.tHe = this;
    AppMethodBeat.o(26034);
  }
  
  private void Hs(int paramInt)
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
      String str1 = com.tencent.mm.plugin.ipcall.a.c.Hv(com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tIV);
      if (this.tSF != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.Ht(this.tSF);
        this.fBE.setText(str1 + this.tSH.getString(2131760497, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.fBE.setText(str1 + this.tSH.getString(2131760496));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.fBE.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.tSK / 60L), Long.valueOf(this.tSK % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.fBE.setText(2131760500);
    }
  }
  
  private void cVC()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(12058, this.mCountryCode);
    com.tencent.mm.ui.base.h.a(this.tSH, this.tSH.getString(2131756761), this.tSH.getString(2131756762), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        j.this.tSH.finish();
        j.this.tSH = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void cVD()
  {
    AppMethodBeat.i(26038);
    if ((!bs.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.ajq(this.tOo)))
    {
      this.tSG = (this.mCountryCode + this.tOo);
      if (!this.tSG.startsWith("+"))
      {
        this.tSG = ("+" + this.tSG);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.tSG = this.tOo;
    }
    AppMethodBeat.o(26038);
  }
  
  private void cVE()
  {
    AppMethodBeat.i(26039);
    com.tencent.mm.plugin.ipcall.model.i.cUy().iMV = this.tSH;
    com.tencent.mm.plugin.ipcall.model.i.cUy().cUN();
    com.tencent.mm.plugin.ipcall.model.i.cUy().a(this);
    com.tencent.mm.plugin.ipcall.model.i.cUy().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void cVF()
  {
    AppMethodBeat.i(26040);
    this.tSv.setKeyListener(null);
    this.tSv.setHorizontallyScrolling(true);
    this.tLY.setVisibility(4);
    this.tLY.setTalkUIMode(true);
    cVG();
    cVH();
    AppMethodBeat.o(26040);
  }
  
  private void cVG()
  {
    AppMethodBeat.i(26042);
    if (!bs.isNullOrNil(this.tSG)) {
      aji(this.tSG);
    }
    if (d.kZ(16))
    {
      this.tSv.setTypeface(Typeface.create("sans-serif-light", 0));
      this.tSw.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!bs.isNullOrNil(this.tOp)) {
      this.tSm = com.tencent.mm.plugin.ipcall.a.a.g(this.tSH, this.tOp, true);
    }
    if ((this.tSm == null) && (!bs.isNullOrNil(this.tOo)) && (com.tencent.mm.plugin.ipcall.a.a.aPF())) {
      this.tSm = com.tencent.mm.plugin.ipcall.a.a.aM(this.tSH, this.tOo);
    }
    if ((this.tSm == null) && (!bs.isNullOrNil(this.tOq))) {
      this.tSm = com.tencent.mm.aj.c.e(this.tOq, 480, 480, 4);
    }
    if (this.tSm == null)
    {
      this.tSx.setVisibility(0);
      this.fxQ.setVisibility(8);
    }
    if (this.tSm != null)
    {
      this.tSx.setVisibility(8);
      this.fxQ.setVisibility(0);
      this.fxQ.setImageBitmap(this.tSm);
    }
    this.tSE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26029);
        com.tencent.mm.plugin.ipcall.model.i.cUA().cTV();
        AppMethodBeat.o(26029);
      }
    });
    this.tSA.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        ac.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
        {
          j.this.tSM = paramAnonymousBoolean;
          j.this.tSN = paramAnonymousBoolean;
          com.tencent.mm.plugin.ipcall.model.i.cUy().np(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.wUl.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!com.tencent.mm.plugin.ipcall.model.i.cUF().Na()) && (!com.tencent.mm.plugin.ipcall.model.i.cUz().cUr())) {
          com.tencent.mm.plugin.ipcall.model.i.cUF().sX(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.tSy.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUq())
        {
          ac.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = com.tencent.mm.plugin.ipcall.model.i.cUw();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.tJF.setAppCmd(412);; i = locala.tJF.setAppCmd(413))
        {
          if (i < 0) {
            ac.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.tIA.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.wUl.f(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.tSz.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          localj = j.this;
          if (localj.tSm == null) {
            localj.fxQ.setVisibility(8);
          }
          for (;;)
          {
            localj.fxQ.setVisibility(8);
            localj.tSx.setVisibility(8);
            localj.tSv.setText("");
            localj.tSw.setText("");
            localj.tLY.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.wUl.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            localj.fxQ.setVisibility(4);
          }
        }
        j localj = j.this;
        if (localj.tSm != null)
        {
          localj.fxQ.setVisibility(0);
          localj.tSx.setVisibility(8);
        }
        for (;;)
        {
          localj.aji(localj.tSG);
          localj.tLY.setVisibility(4);
          break;
          localj.tSx.setVisibility(0);
          localj.fxQ.setVisibility(8);
        }
      }
    });
    this.tSB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26033);
        j.b(j.this);
        AppMethodBeat.o(26033);
      }
    });
    AppMethodBeat.o(26042);
  }
  
  private void cVH()
  {
    AppMethodBeat.i(26043);
    this.tLY.setDialButtonClickListener(new DialPad.a()
    {
      public final void aiT(String paramAnonymousString)
      {
        AppMethodBeat.i(26023);
        String str2 = j.this.tSv.getText().toString();
        if (bs.isNullOrNil(str2)) {
          j.this.tSL = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.tSL >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.tSL = l;
        j.this.hn(str1, "");
        com.tencent.mm.plugin.ipcall.c.aiH(paramAnonymousString);
        com.tencent.mm.plugin.report.service.h.wUl.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(26023);
      }
      
      public final void aiU(String paramAnonymousString) {}
    });
    AppMethodBeat.o(26043);
  }
  
  private void cVI()
  {
    AppMethodBeat.i(26045);
    this.tSF = com.tencent.mm.plugin.ipcall.a.a.ho(this.tOp, this.tOo);
    Hs(1);
    this.tSI.a(this.iXH, this.tOo, this.tOq, this.tSG, this.tOp, this.tSF, this.tOr, this.tOs);
    ac.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.tSG });
    com.tencent.mm.plugin.ipcall.model.i.cUx().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void cVJ()
  {
    AppMethodBeat.i(26046);
    if (com.tencent.mm.plugin.ipcall.model.i.cUv().tHV != null)
    {
      this.iXH = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.nickname;
      this.tSG = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJh;
      this.tOq = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.dvw;
      this.tOp = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.dxO;
      this.tOo = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJg;
      this.tSF = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJj;
      ac.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.iXH, this.tSG, this.tOq, this.tOp, this.tOo, Integer.valueOf(this.tSF) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void cVK()
  {
    AppMethodBeat.i(26047);
    com.tencent.mm.plugin.ipcall.model.i.cUz();
    ac.i("MicroMsg.TalkUIController", f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr));
    Hs(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr);
    cVM();
    cVL();
    AppMethodBeat.o(26047);
  }
  
  private void cVL()
  {
    AppMethodBeat.i(26048);
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
    {
      this.tSA.setChecked(com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.isSpeakerphoneOn());
      this.tSy.setChecked(com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.tIA.ftN);
    }
    AppMethodBeat.o(26048);
  }
  
  private void cVM()
  {
    AppMethodBeat.i(26049);
    String str1 = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJh;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJi;
    if (!bs.isNullOrNil(str2))
    {
      aji(str2);
      this.tSw.setText(com.tencent.mm.plugin.ipcall.a.a.ajs(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!bs.isNullOrNil(str1))
    {
      aji(str1);
      this.tSw.setText(com.tencent.mm.plugin.ipcall.a.a.ajs(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    cVN();
    if (!bs.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.fBE.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (bs.isNullOrNil(paramString3)) {
          paramString1 = this.tSH.getString(2131760432);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          com.tencent.mm.ui.base.h.a(this.tSH, paramString2, paramString1, this.tSH.getString(2131760433), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              j.this.tSH.finish();
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
  
  final void aji(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!bs.isNullOrNil(this.iXH))
    {
      hn(this.iXH, com.tencent.mm.plugin.ipcall.a.a.ajs(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    hn(com.tencent.mm.plugin.ipcall.a.a.ajs(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.tSP = this.tSH.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    ac.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.tSP) });
    this.tSx = ((ImageView)this.tSH.findViewById(2131305655));
    this.fxQ = ((ImageView)this.tSH.findViewById(2131305653));
    this.tSv = ((EditText)this.tSH.findViewById(2131305660));
    this.fBE = ((TextView)this.tSH.findViewById(2131305663));
    this.tSw = ((TextView)this.tSH.findViewById(2131305661));
    this.tSy = ((IPCallFuncButton)this.tSH.findViewById(2131305659));
    this.tSz = ((IPCallFuncButton)this.tSH.findViewById(2131305656));
    this.tSA = ((IPCallFuncButton)this.tSH.findViewById(2131305662));
    this.tSB = ((ImageButton)this.tSH.findViewById(2131305658));
    this.tSE = ((ImageButton)this.tSH.findViewById(2131301125));
    this.tSC = ((TextView)this.tSH.findViewById(2131306581));
    this.tSD = this.tSH.findViewById(2131306582);
    this.tLY = ((DialPad)this.tSH.findViewById(2131299111));
    if (this.tSP)
    {
      cVJ();
      cVE();
      cVF();
      cVK();
      AppMethodBeat.o(26035);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUo())
    {
      com.tencent.mm.ui.base.h.a(this.tSH, 2131760337, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          j.this.tSH.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    cVE();
    this.iXH = paramString1;
    this.tOo = paramString2;
    this.tOp = paramString3;
    this.mCountryCode = paramString4;
    this.tOr = paramInt1;
    this.tOs = paramInt2;
    if (!bs.isNullOrNil(this.tOo)) {
      this.tOo = com.tencent.mm.plugin.ipcall.a.c.ajw(this.tOo);
    }
    if (bs.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.ajq(this.tOo))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.ajo(this.tOo);
        if (!bs.isNullOrNil(paramString1)) {
          break label581;
        }
        this.tOo = com.tencent.mm.plugin.ipcall.a.a.ajr(this.tOo);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.cVU();; this.mCountryCode = paramString1)
    {
      ac.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.cUg().aiJ(this.mCountryCode);
      if (bs.isNullOrNil(this.iXH)) {
        this.iXH = com.tencent.mm.plugin.ipcall.a.a.aJ(this.tSH, this.tOo);
      }
      this.tOq = paramString5;
      cVD();
      ac.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.tSG });
      if (!com.tencent.mm.plugin.ipcall.model.c.cUg().Hb(bs.getInt(this.mCountryCode, -1))) {
        break;
      }
      cVC();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.tOo = com.tencent.mm.plugin.ipcall.a.a.ajt(this.tOo);
    }
    if (!ax.isNetworkConnected(this.tSH))
    {
      Toast.makeText(this.tSH, 2131764895, 1).show();
      this.tSH.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.tSH.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      ac.i("MicroMsg.TalkUIController", "onDisasterHappen");
      com.tencent.mm.ui.base.h.a(this.tSH, this.tSH.getString(2131760442, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.tSH.getString(2131760432), this.tSH.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          j.this.tSH.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    cVF();
    if ((!this.tSP) || (!com.tencent.mm.plugin.ipcall.model.i.cUz().cUo())) {
      cVI();
    }
    this.tSR = false;
    AppMethodBeat.o(26035);
  }
  
  public final void cTL()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    ac.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJh;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tJi;
    if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      ac.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      aji(str2);
    }
    ac.i("MicroMsg.TalkUIController", "callFlag:" + com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tIV);
    int k = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV.tIV;
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
      ac.i("MicroMsg.TalkUIController", "isNotFree");
      com.tencent.mm.ui.base.h.a(this.tSH, 2131760512, 2131760513, 2131760511, 2131760510, true, null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26024);
          ac.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
          j.b(j.this);
          AppMethodBeat.o(26024);
        }
      });
    }
    Hs(3);
    AppMethodBeat.o(26051);
  }
  
  public final void cTM()
  {
    AppMethodBeat.i(26052);
    ac.d("MicroMsg.TalkUIController", "onStartRing");
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
    {
      this.tSM = this.tSA.isChecked();
      this.tSN = this.tSA.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.cUy().np(this.tSA.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void cUa()
  {
    AppMethodBeat.i(26053);
    ac.d("MicroMsg.TalkUIController", "onUserAccept");
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
    {
      this.tSM = this.tSA.isChecked();
      this.tSN = this.tSA.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.cUy().np(this.tSA.isChecked());
    }
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUq()) {
      com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.tIA.setMute(this.tSy.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void cUb()
  {
    AppMethodBeat.i(26054);
    ac.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    cVN();
    Hs(10);
    az.getNotification().cancel(42);
    if (this.tSJ != null) {
      this.tSJ.nv(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(26059);
    this.tSH.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void cUd()
  {
    AppMethodBeat.i(26058);
    this.tSK = com.tencent.mm.plugin.ipcall.model.i.cUA().cTX();
    Hs(5);
    AppMethodBeat.o(26058);
  }
  
  public final void cVN()
  {
    AppMethodBeat.i(26060);
    if (this.tSC != null) {
      this.tSC.setVisibility(4);
    }
    if (this.tSD != null) {
      this.tSD.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    ac.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.tSQ = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!bs.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.tSH.getString(2131760432);
      }
    }
    label173:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.tSH, paramString2, paramString1, this.tSH.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          j.this.tSH.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        az.getNotification().cancel(42);
        if ((this.tSJ != null) && (!this.tSR)) {
          this.tSJ.nv(this.tSQ);
        }
        AppMethodBeat.o(26055);
        return;
        g(paramString1, paramString2, paramInt2, this.tSH.getString(2131760431));
        continue;
        g(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void hn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.tSv.setText(paramString1);
    if (!bs.isNullOrNil(paramString1)) {
      this.tSv.setSelection(this.tSv.getText().length() - 1);
    }
    this.tSw.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void nn(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    ac.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
    {
      if (paramBoolean)
      {
        this.tSM = com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.cUy().np(false);
        this.tSA.setEnable(false);
        AppMethodBeat.o(26056);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.cUy().np(this.tSM);
      this.tSA.setEnable(true);
      this.tSA.setChecked(this.tSM);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void no(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    ac.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
    {
      if (paramBoolean)
      {
        this.tSN = com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.cUy().np(false);
        this.tSA.setEnable(false);
        AppMethodBeat.o(26057);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.cUy().np(this.tSN);
      this.tSA.setEnable(true);
      this.tSA.setChecked(this.tSN);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void nv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */