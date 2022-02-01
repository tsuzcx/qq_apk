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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  implements e, a.b
{
  ImageView fuj;
  private TextView fxX;
  private String ixE;
  private String mCountryCode;
  DialPad sEr;
  private String sGH;
  private String sGI;
  private String sGJ;
  private int sGK;
  private int sGL;
  Bitmap sKG;
  EditText sKP;
  TextView sKQ;
  ImageView sKR;
  private IPCallFuncButton sKS;
  private IPCallFuncButton sKT;
  private IPCallFuncButton sKU;
  private ImageButton sKV;
  public TextView sKW;
  public View sKX;
  private ImageButton sKY;
  private int sKZ;
  String sLa;
  IPCallTalkUI sLb;
  com.tencent.mm.plugin.ipcall.c sLd;
  a sLe;
  private long sLf;
  long sLg;
  boolean sLh;
  boolean sLi;
  private AudioManager sLj;
  private boolean sLk;
  private boolean sLl;
  private boolean sLm;
  boolean sLn;
  boolean sLo;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.sKZ = -1;
    this.sLg = -1L;
    this.sLh = false;
    this.sLi = false;
    this.sLj = null;
    this.sLk = false;
    this.sLl = true;
    this.sLm = false;
    this.sLn = false;
    this.sLo = false;
    this.sLb = paramIPCallTalkUI;
    this.sLd = com.tencent.mm.plugin.ipcall.model.i.cHp();
    this.sLd.szu = this;
    AppMethodBeat.o(26034);
  }
  
  private void Fx(int paramInt)
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
      String str1 = com.tencent.mm.plugin.ipcall.a.c.FA(com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBn);
      if (this.sKZ != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.Fy(this.sKZ);
        this.fxX.setText(str1 + this.sLb.getString(2131760497, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.fxX.setText(str1 + this.sLb.getString(2131760496));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.fxX.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.sLf / 60L), Long.valueOf(this.sLf % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.fxX.setText(2131760500);
    }
  }
  
  private void cIA()
  {
    AppMethodBeat.i(26048);
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
    {
      this.sKU.setChecked(com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.isSpeakerphoneOn());
      this.sKS.setChecked(com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.sAR.fqj);
    }
    AppMethodBeat.o(26048);
  }
  
  private void cIB()
  {
    AppMethodBeat.i(26049);
    String str1 = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBz;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBA;
    if (!bt.isNullOrNil(str2))
    {
      aeq(str2);
      this.sKQ.setText(com.tencent.mm.plugin.ipcall.a.a.aeA(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!bt.isNullOrNil(str1))
    {
      aeq(str1);
      this.sKQ.setText(com.tencent.mm.plugin.ipcall.a.a.aeA(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void cIr()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(12058, this.mCountryCode);
    com.tencent.mm.ui.base.h.a(this.sLb, this.sLb.getString(2131756761), this.sLb.getString(2131756762), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        j.this.sLb.finish();
        j.this.sLb = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void cIs()
  {
    AppMethodBeat.i(26038);
    if ((!bt.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.aey(this.sGH)))
    {
      this.sLa = (this.mCountryCode + this.sGH);
      if (!this.sLa.startsWith("+"))
      {
        this.sLa = ("+" + this.sLa);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.sLa = this.sGH;
    }
    AppMethodBeat.o(26038);
  }
  
  private void cIt()
  {
    AppMethodBeat.i(26039);
    com.tencent.mm.plugin.ipcall.model.i.cHn().imP = this.sLb;
    com.tencent.mm.plugin.ipcall.model.i.cHn().cHC();
    com.tencent.mm.plugin.ipcall.model.i.cHn().a(this);
    com.tencent.mm.plugin.ipcall.model.i.cHn().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void cIu()
  {
    AppMethodBeat.i(26040);
    this.sKP.setKeyListener(null);
    this.sKP.setHorizontallyScrolling(true);
    this.sEr.setVisibility(4);
    this.sEr.setTalkUIMode(true);
    cIv();
    cIw();
    AppMethodBeat.o(26040);
  }
  
  private void cIv()
  {
    AppMethodBeat.i(26042);
    if (!bt.isNullOrNil(this.sLa)) {
      aeq(this.sLa);
    }
    if (d.lf(16))
    {
      this.sKP.setTypeface(Typeface.create("sans-serif-light", 0));
      this.sKQ.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!bt.isNullOrNil(this.sGI)) {
      this.sKG = com.tencent.mm.plugin.ipcall.a.a.h(this.sLb, this.sGI, true);
    }
    if ((this.sKG == null) && (!bt.isNullOrNil(this.sGH)) && (com.tencent.mm.plugin.ipcall.a.a.aIO())) {
      this.sKG = com.tencent.mm.plugin.ipcall.a.a.aL(this.sLb, this.sGH);
    }
    if ((this.sKG == null) && (!bt.isNullOrNil(this.sGJ))) {
      this.sKG = com.tencent.mm.ak.c.e(this.sGJ, 480, 480, 4);
    }
    if (this.sKG == null)
    {
      this.sKR.setVisibility(0);
      this.fuj.setVisibility(8);
    }
    if (this.sKG != null)
    {
      this.sKR.setVisibility(8);
      this.fuj.setVisibility(0);
      this.fuj.setImageBitmap(this.sKG);
    }
    this.sKY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26029);
        com.tencent.mm.plugin.ipcall.model.i.cHp().cGK();
        AppMethodBeat.o(26029);
      }
    });
    this.sKU.setClickCallback(new IPCallFuncButton.a()
    {
      public final void mA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        ad.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
        {
          j.this.sLh = paramAnonymousBoolean;
          j.this.sLi = paramAnonymousBoolean;
          com.tencent.mm.plugin.ipcall.model.i.cHn().mw(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.vKh.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!com.tencent.mm.plugin.ipcall.model.i.cHu().Nc()) && (!com.tencent.mm.plugin.ipcall.model.i.cHo().cHg())) {
          com.tencent.mm.plugin.ipcall.model.i.cHu().rW(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.sKS.setClickCallback(new IPCallFuncButton.a()
    {
      public final void mA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHf())
        {
          ad.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = com.tencent.mm.plugin.ipcall.model.i.cHl();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.sBX.setAppCmd(412);; i = locala.sBX.setAppCmd(413))
        {
          if (i < 0) {
            ad.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.sAR.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.vKh.f(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.sKT.setClickCallback(new IPCallFuncButton.a()
    {
      public final void mA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          localj = j.this;
          if (localj.sKG == null) {
            localj.fuj.setVisibility(8);
          }
          for (;;)
          {
            localj.fuj.setVisibility(8);
            localj.sKR.setVisibility(8);
            localj.sKP.setText("");
            localj.sKQ.setText("");
            localj.sEr.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.vKh.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            localj.fuj.setVisibility(4);
          }
        }
        j localj = j.this;
        if (localj.sKG != null)
        {
          localj.fuj.setVisibility(0);
          localj.sKR.setVisibility(8);
        }
        for (;;)
        {
          localj.aeq(localj.sLa);
          localj.sEr.setVisibility(4);
          break;
          localj.sKR.setVisibility(0);
          localj.fuj.setVisibility(8);
        }
      }
    });
    this.sKV.setOnClickListener(new View.OnClickListener()
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
  
  private void cIw()
  {
    AppMethodBeat.i(26043);
    this.sEr.setDialButtonClickListener(new DialPad.a()
    {
      public final void aeb(String paramAnonymousString)
      {
        AppMethodBeat.i(26023);
        String str2 = j.this.sKP.getText().toString();
        if (bt.isNullOrNil(str2)) {
          j.this.sLg = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.sLg >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.sLg = l;
        j.this.gW(str1, "");
        com.tencent.mm.plugin.ipcall.c.adP(paramAnonymousString);
        com.tencent.mm.plugin.report.service.h.vKh.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(26023);
      }
      
      public final void aec(String paramAnonymousString) {}
    });
    AppMethodBeat.o(26043);
  }
  
  private void cIx()
  {
    AppMethodBeat.i(26045);
    this.sKZ = com.tencent.mm.plugin.ipcall.a.a.gX(this.sGI, this.sGH);
    Fx(1);
    this.sLd.a(this.ixE, this.sGH, this.sGJ, this.sLa, this.sGI, this.sKZ, this.sGK, this.sGL);
    ad.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.sLa });
    com.tencent.mm.plugin.ipcall.model.i.cHm().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void cIy()
  {
    AppMethodBeat.i(26046);
    if (com.tencent.mm.plugin.ipcall.model.i.cHk().sAl != null)
    {
      this.ixE = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.nickname;
      this.sLa = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBz;
      this.sGJ = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.dxK;
      this.sGI = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.dAc;
      this.sGH = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBy;
      this.sKZ = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBB;
      ad.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.ixE, this.sLa, this.sGJ, this.sGI, this.sGH, Integer.valueOf(this.sKZ) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void cIz()
  {
    AppMethodBeat.i(26047);
    com.tencent.mm.plugin.ipcall.model.i.cHo();
    ad.i("MicroMsg.TalkUIController", f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb));
    Fx(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb);
    cIB();
    cIA();
    AppMethodBeat.o(26047);
  }
  
  private void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    cIC();
    if (!bt.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.fxX.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (bt.isNullOrNil(paramString3)) {
          paramString1 = this.sLb.getString(2131760432);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          com.tencent.mm.ui.base.h.a(this.sLb, paramString2, paramString1, this.sLb.getString(2131760433), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              j.this.sLb.finish();
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
  
  final void aeq(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!bt.isNullOrNil(this.ixE))
    {
      gW(this.ixE, com.tencent.mm.plugin.ipcall.a.a.aeA(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    gW(com.tencent.mm.plugin.ipcall.a.a.aeA(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.sLk = this.sLb.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    ad.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.sLk) });
    this.sKR = ((ImageView)this.sLb.findViewById(2131305655));
    this.fuj = ((ImageView)this.sLb.findViewById(2131305653));
    this.sKP = ((EditText)this.sLb.findViewById(2131305660));
    this.fxX = ((TextView)this.sLb.findViewById(2131305663));
    this.sKQ = ((TextView)this.sLb.findViewById(2131305661));
    this.sKS = ((IPCallFuncButton)this.sLb.findViewById(2131305659));
    this.sKT = ((IPCallFuncButton)this.sLb.findViewById(2131305656));
    this.sKU = ((IPCallFuncButton)this.sLb.findViewById(2131305662));
    this.sKV = ((ImageButton)this.sLb.findViewById(2131305658));
    this.sKY = ((ImageButton)this.sLb.findViewById(2131301125));
    this.sKW = ((TextView)this.sLb.findViewById(2131306581));
    this.sKX = this.sLb.findViewById(2131306582);
    this.sEr = ((DialPad)this.sLb.findViewById(2131299111));
    if (this.sLk)
    {
      cIy();
      cIt();
      cIu();
      cIz();
      AppMethodBeat.o(26035);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHd())
    {
      com.tencent.mm.ui.base.h.a(this.sLb, 2131760337, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          j.this.sLb.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    cIt();
    this.ixE = paramString1;
    this.sGH = paramString2;
    this.sGI = paramString3;
    this.mCountryCode = paramString4;
    this.sGK = paramInt1;
    this.sGL = paramInt2;
    if (!bt.isNullOrNil(this.sGH)) {
      this.sGH = com.tencent.mm.plugin.ipcall.a.c.aeE(this.sGH);
    }
    if (bt.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.aey(this.sGH))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.aew(this.sGH);
        if (!bt.isNullOrNil(paramString1)) {
          break label581;
        }
        this.sGH = com.tencent.mm.plugin.ipcall.a.a.aez(this.sGH);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.cIJ();; this.mCountryCode = paramString1)
    {
      ad.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.cGV().adR(this.mCountryCode);
      if (bt.isNullOrNil(this.ixE)) {
        this.ixE = com.tencent.mm.plugin.ipcall.a.a.aI(this.sLb, this.sGH);
      }
      this.sGJ = paramString5;
      cIs();
      ad.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.sLa });
      if (!com.tencent.mm.plugin.ipcall.model.c.cGV().Fg(bt.getInt(this.mCountryCode, -1))) {
        break;
      }
      cIr();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.sGH = com.tencent.mm.plugin.ipcall.a.a.aeB(this.sGH);
    }
    if (!ay.isNetworkConnected(this.sLb))
    {
      Toast.makeText(this.sLb, 2131764895, 1).show();
      this.sLb.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.sLb.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      ad.i("MicroMsg.TalkUIController", "onDisasterHappen");
      com.tencent.mm.ui.base.h.a(this.sLb, this.sLb.getString(2131760442, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.sLb.getString(2131760432), this.sLb.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          j.this.sLb.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    cIu();
    if ((!this.sLk) || (!com.tencent.mm.plugin.ipcall.model.i.cHo().cHd())) {
      cIx();
    }
    this.sLm = false;
    AppMethodBeat.o(26035);
  }
  
  public final void cGB()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    ad.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBz;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBA;
    if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      ad.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      aeq(str2);
    }
    ad.i("MicroMsg.TalkUIController", "callFlag:" + com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBn);
    int k = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl.sBn;
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
      ad.i("MicroMsg.TalkUIController", "isNotFree");
      com.tencent.mm.ui.base.h.a(this.sLb, 2131760512, 2131760513, 2131760511, 2131760510, true, null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26024);
          ad.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
          j.b(j.this);
          AppMethodBeat.o(26024);
        }
      });
    }
    Fx(3);
    AppMethodBeat.o(26051);
  }
  
  public final void cGC()
  {
    AppMethodBeat.i(26052);
    ad.d("MicroMsg.TalkUIController", "onStartRing");
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
    {
      this.sLh = this.sKU.isChecked();
      this.sLi = this.sKU.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.cHn().mw(this.sKU.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void cGP()
  {
    AppMethodBeat.i(26053);
    ad.d("MicroMsg.TalkUIController", "onUserAccept");
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
    {
      this.sLh = this.sKU.isChecked();
      this.sLi = this.sKU.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.cHn().mw(this.sKU.isChecked());
    }
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHf()) {
      com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.sAR.setMute(this.sKS.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void cGQ()
  {
    AppMethodBeat.i(26054);
    ad.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    cIC();
    Fx(10);
    az.getNotification().cancel(42);
    if (this.sLe != null) {
      this.sLe.mC(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void cGR()
  {
    AppMethodBeat.i(26059);
    this.sLb.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void cGS()
  {
    AppMethodBeat.i(26058);
    this.sLf = com.tencent.mm.plugin.ipcall.model.i.cHp().cGM();
    Fx(5);
    AppMethodBeat.o(26058);
  }
  
  public final void cIC()
  {
    AppMethodBeat.i(26060);
    if (this.sKW != null) {
      this.sKW.setVisibility(4);
    }
    if (this.sKX != null) {
      this.sKX.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  public final void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    ad.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.sLl = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!bt.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.sLb.getString(2131760432);
      }
    }
    label173:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.sLb, paramString2, paramString1, this.sLb.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          j.this.sLb.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        az.getNotification().cancel(42);
        if ((this.sLe != null) && (!this.sLm)) {
          this.sLe.mC(this.sLl);
        }
        AppMethodBeat.o(26055);
        return;
        f(paramString1, paramString2, paramInt2, this.sLb.getString(2131760431));
        continue;
        f(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void gW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.sKP.setText(paramString1);
    if (!bt.isNullOrNil(paramString1)) {
      this.sKP.setSelection(this.sKP.getText().length() - 1);
    }
    this.sKQ.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void mu(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    ad.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
    {
      if (paramBoolean)
      {
        this.sLh = com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.cHn().mw(false);
        this.sKU.setEnable(false);
        AppMethodBeat.o(26056);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.cHn().mw(this.sLh);
      this.sKU.setEnable(true);
      this.sKU.setChecked(this.sLh);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    ad.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
    {
      if (paramBoolean)
      {
        this.sLi = com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.cHn().mw(false);
        this.sKU.setEnable(false);
        AppMethodBeat.o(26057);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.cHn().mw(this.sLi);
      this.sKU.setEnable(true);
      this.sKU.setChecked(this.sLi);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void mC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */