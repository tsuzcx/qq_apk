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
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;

public final class j
  implements e, a.b
{
  ImageView fRd;
  private TextView fUR;
  private String jqQ;
  private String mCountryCode;
  DialPad uOL;
  private String uRb;
  private String uRc;
  private String uRd;
  private int uRe;
  private int uRf;
  Bitmap uUZ;
  boolean uVA;
  private AudioManager uVB;
  private boolean uVC;
  private boolean uVD;
  private boolean uVE;
  boolean uVF;
  boolean uVG;
  EditText uVi;
  TextView uVj;
  ImageView uVk;
  private IPCallFuncButton uVl;
  private IPCallFuncButton uVm;
  private IPCallFuncButton uVn;
  private ImageButton uVo;
  public TextView uVp;
  public View uVq;
  private ImageButton uVr;
  private int uVs;
  String uVt;
  IPCallTalkUI uVu;
  com.tencent.mm.plugin.ipcall.c uVv;
  a uVw;
  private long uVx;
  long uVy;
  boolean uVz;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.uVs = -1;
    this.uVy = -1L;
    this.uVz = false;
    this.uVA = false;
    this.uVB = null;
    this.uVC = false;
    this.uVD = true;
    this.uVE = false;
    this.uVF = false;
    this.uVG = false;
    this.uVu = paramIPCallTalkUI;
    this.uVv = com.tencent.mm.plugin.ipcall.model.i.ddL();
    this.uVv.uJR = this;
    AppMethodBeat.o(26034);
  }
  
  private void IO(int paramInt)
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
      String str1 = com.tencent.mm.plugin.ipcall.a.c.IR(com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLI);
      if (this.uVs != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.IP(this.uVs);
        this.fUR.setText(str1 + this.uVu.getString(2131760497, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.fUR.setText(str1 + this.uVu.getString(2131760496));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.fUR.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.uVx / 60L), Long.valueOf(this.uVx % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.fUR.setText(2131760500);
    }
  }
  
  private void deN()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(12058, this.mCountryCode);
    h.a(this.uVu, this.uVu.getString(2131756761), this.uVu.getString(2131756762), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        j.this.uVu.finish();
        j.this.uVu = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void deO()
  {
    AppMethodBeat.i(26038);
    if ((!bt.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.aod(this.uRb)))
    {
      this.uVt = (this.mCountryCode + this.uRb);
      if (!this.uVt.startsWith("+"))
      {
        this.uVt = ("+" + this.uVt);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.uVt = this.uRb;
    }
    AppMethodBeat.o(26038);
  }
  
  private void deP()
  {
    AppMethodBeat.i(26039);
    com.tencent.mm.plugin.ipcall.model.i.ddJ().fLP = this.uVu;
    com.tencent.mm.plugin.ipcall.model.i.ddJ().ddY();
    com.tencent.mm.plugin.ipcall.model.i.ddJ().a(this);
    com.tencent.mm.plugin.ipcall.model.i.ddJ().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void deQ()
  {
    AppMethodBeat.i(26040);
    this.uVi.setKeyListener(null);
    this.uVi.setHorizontallyScrolling(true);
    this.uOL.setVisibility(4);
    this.uOL.setTalkUIMode(true);
    deR();
    deS();
    AppMethodBeat.o(26040);
  }
  
  private void deR()
  {
    AppMethodBeat.i(26042);
    if (!bt.isNullOrNil(this.uVt)) {
      anV(this.uVt);
    }
    if (d.ly(16))
    {
      this.uVi.setTypeface(Typeface.create("sans-serif-light", 0));
      this.uVj.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!bt.isNullOrNil(this.uRc)) {
      this.uUZ = com.tencent.mm.plugin.ipcall.a.a.g(this.uVu, this.uRc, true);
    }
    if ((this.uUZ == null) && (!bt.isNullOrNil(this.uRb)) && (com.tencent.mm.plugin.ipcall.a.a.aSR())) {
      this.uUZ = com.tencent.mm.plugin.ipcall.a.a.aP(this.uVu, this.uRb);
    }
    if ((this.uUZ == null) && (!bt.isNullOrNil(this.uRd))) {
      this.uUZ = com.tencent.mm.ak.c.e(this.uRd, 480, 480, 4);
    }
    if (this.uUZ == null)
    {
      this.uVk.setVisibility(0);
      this.fRd.setVisibility(8);
    }
    if (this.uUZ != null)
    {
      this.uVk.setVisibility(8);
      this.fRd.setVisibility(0);
      this.fRd.setImageBitmap(this.uUZ);
    }
    this.uVr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.ipcall.model.i.ddL().ddg();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26029);
      }
    });
    this.uVn.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        ad.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddA())
        {
          j.this.uVz = paramAnonymousBoolean;
          j.this.uVA = paramAnonymousBoolean;
          com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.g.yhR.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!com.tencent.mm.plugin.ipcall.model.i.ddQ().OJ()) && (!com.tencent.mm.plugin.ipcall.model.i.ddK().ddC())) {
          com.tencent.mm.plugin.ipcall.model.i.ddQ().tH(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.uVl.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddB())
        {
          ad.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = com.tencent.mm.plugin.ipcall.model.i.ddH();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.uMs.setAppCmd(412);; i = locala.uMs.setAppCmd(413))
        {
          if (i < 0) {
            ad.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          com.tencent.mm.plugin.ipcall.model.i.ddJ().uMb.uLn.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.g.yhR.f(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.uVm.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          localj = j.this;
          if (localj.uUZ == null) {
            localj.fRd.setVisibility(8);
          }
          for (;;)
          {
            localj.fRd.setVisibility(8);
            localj.uVk.setVisibility(8);
            localj.uVi.setText("");
            localj.uVj.setText("");
            localj.uOL.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.yhR.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            localj.fRd.setVisibility(4);
          }
        }
        j localj = j.this;
        if (localj.uUZ != null)
        {
          localj.fRd.setVisibility(0);
          localj.uVk.setVisibility(8);
        }
        for (;;)
        {
          localj.anV(localj.uVt);
          localj.uOL.setVisibility(4);
          break;
          localj.uVk.setVisibility(0);
          localj.fRd.setVisibility(8);
        }
      }
    });
    this.uVo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        j.b(j.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26033);
      }
    });
    AppMethodBeat.o(26042);
  }
  
  private void deS()
  {
    AppMethodBeat.i(26043);
    this.uOL.setDialButtonClickListener(new DialPad.a()
    {
      public final void anG(String paramAnonymousString)
      {
        AppMethodBeat.i(26023);
        String str2 = j.this.uVi.getText().toString();
        if (bt.isNullOrNil(str2)) {
          j.this.uVy = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.uVy >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.uVy = l;
        j.this.hz(str1, "");
        com.tencent.mm.plugin.ipcall.c.anu(paramAnonymousString);
        com.tencent.mm.plugin.report.service.g.yhR.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(26023);
      }
      
      public final void anH(String paramAnonymousString) {}
    });
    AppMethodBeat.o(26043);
  }
  
  private void deT()
  {
    AppMethodBeat.i(26045);
    this.uVs = com.tencent.mm.plugin.ipcall.a.a.hA(this.uRc, this.uRb);
    IO(1);
    this.uVv.a(this.jqQ, this.uRb, this.uRd, this.uVt, this.uRc, this.uVs, this.uRe, this.uRf);
    ad.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.uVt });
    com.tencent.mm.plugin.ipcall.model.i.ddI().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void deU()
  {
    AppMethodBeat.i(26046);
    if (com.tencent.mm.plugin.ipcall.model.i.ddG().uKI != null)
    {
      this.jqQ = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.nickname;
      this.uVt = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLU;
      this.uRd = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.dHz;
      this.uRc = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.dKb;
      this.uRb = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLT;
      this.uVs = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLW;
      ad.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.jqQ, this.uVt, this.uRd, this.uRc, this.uRb, Integer.valueOf(this.uVs) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void deV()
  {
    AppMethodBeat.i(26047);
    com.tencent.mm.plugin.ipcall.model.i.ddK();
    ad.i("MicroMsg.TalkUIController", f.stateToString(com.tencent.mm.plugin.ipcall.model.i.ddK().lpU));
    IO(com.tencent.mm.plugin.ipcall.model.i.ddK().lpU);
    deX();
    deW();
    AppMethodBeat.o(26047);
  }
  
  private void deW()
  {
    AppMethodBeat.i(26048);
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddA())
    {
      this.uVn.setChecked(com.tencent.mm.plugin.ipcall.model.i.ddJ().uMb.isSpeakerphoneOn());
      this.uVl.setChecked(com.tencent.mm.plugin.ipcall.model.i.ddJ().uMb.uLn.fMP);
    }
    AppMethodBeat.o(26048);
  }
  
  private void deX()
  {
    AppMethodBeat.i(26049);
    String str1 = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLU;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLV;
    if (!bt.isNullOrNil(str2))
    {
      anV(str2);
      this.uVj.setText(com.tencent.mm.plugin.ipcall.a.a.aof(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!bt.isNullOrNil(str1))
    {
      anV(str1);
      this.uVj.setText(com.tencent.mm.plugin.ipcall.a.a.aof(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    deY();
    if (!bt.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.fUR.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (bt.isNullOrNil(paramString3)) {
          paramString1 = this.uVu.getString(2131760432);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          h.a(this.uVu, paramString2, paramString1, this.uVu.getString(2131760433), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              j.this.uVu.finish();
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
  
  final void anV(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!bt.isNullOrNil(this.jqQ))
    {
      hz(this.jqQ, com.tencent.mm.plugin.ipcall.a.a.aof(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    hz(com.tencent.mm.plugin.ipcall.a.a.aof(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.uVC = this.uVu.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    ad.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.uVC) });
    this.uVk = ((ImageView)this.uVu.findViewById(2131305655));
    this.fRd = ((ImageView)this.uVu.findViewById(2131305653));
    this.uVi = ((EditText)this.uVu.findViewById(2131305660));
    this.fUR = ((TextView)this.uVu.findViewById(2131305663));
    this.uVj = ((TextView)this.uVu.findViewById(2131305661));
    this.uVl = ((IPCallFuncButton)this.uVu.findViewById(2131305659));
    this.uVm = ((IPCallFuncButton)this.uVu.findViewById(2131305656));
    this.uVn = ((IPCallFuncButton)this.uVu.findViewById(2131305662));
    this.uVo = ((ImageButton)this.uVu.findViewById(2131305658));
    this.uVr = ((ImageButton)this.uVu.findViewById(2131301125));
    this.uVp = ((TextView)this.uVu.findViewById(2131306581));
    this.uVq = this.uVu.findViewById(2131306582);
    this.uOL = ((DialPad)this.uVu.findViewById(2131299111));
    if (this.uVC)
    {
      deU();
      deP();
      deQ();
      deV();
      AppMethodBeat.o(26035);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddz())
    {
      h.a(this.uVu, 2131760337, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          j.this.uVu.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    deP();
    this.jqQ = paramString1;
    this.uRb = paramString2;
    this.uRc = paramString3;
    this.mCountryCode = paramString4;
    this.uRe = paramInt1;
    this.uRf = paramInt2;
    if (!bt.isNullOrNil(this.uRb)) {
      this.uRb = com.tencent.mm.plugin.ipcall.a.c.aoj(this.uRb);
    }
    if (bt.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.aod(this.uRb))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.aob(this.uRb);
        if (!bt.isNullOrNil(paramString1)) {
          break label581;
        }
        this.uRb = com.tencent.mm.plugin.ipcall.a.a.aoe(this.uRb);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.dff();; this.mCountryCode = paramString1)
    {
      ad.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.ddr().anw(this.mCountryCode);
      if (bt.isNullOrNil(this.jqQ)) {
        this.jqQ = com.tencent.mm.plugin.ipcall.a.a.aM(this.uVu, this.uRb);
      }
      this.uRd = paramString5;
      deO();
      ad.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.uVt });
      if (!com.tencent.mm.plugin.ipcall.model.c.ddr().Ix(bt.getInt(this.mCountryCode, -1))) {
        break;
      }
      deN();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.uRb = com.tencent.mm.plugin.ipcall.a.a.aog(this.uRb);
    }
    if (!ay.isNetworkConnected(this.uVu))
    {
      Toast.makeText(this.uVu, 2131764895, 1).show();
      this.uVu.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.uVu.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      ad.i("MicroMsg.TalkUIController", "onDisasterHappen");
      h.a(this.uVu, this.uVu.getString(2131760442, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.uVu.getString(2131760432), this.uVu.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          j.this.uVu.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    deQ();
    if ((!this.uVC) || (!com.tencent.mm.plugin.ipcall.model.i.ddK().ddz())) {
      deT();
    }
    this.uVE = false;
    AppMethodBeat.o(26035);
  }
  
  public final void dcW()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    ad.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLU;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLV;
    if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      ad.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      anV(str2);
    }
    ad.i("MicroMsg.TalkUIController", "callFlag:" + com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLI);
    int k = com.tencent.mm.plugin.ipcall.model.i.ddG().uKI.uLI;
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
      h.a(this.uVu, 2131760512, 2131760513, 2131760511, 2131760510, true, null, new DialogInterface.OnClickListener()
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
    IO(3);
    AppMethodBeat.o(26051);
  }
  
  public final void dcX()
  {
    AppMethodBeat.i(26052);
    ad.d("MicroMsg.TalkUIController", "onStartRing");
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddA())
    {
      this.uVz = this.uVn.isChecked();
      this.uVA = this.uVn.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(this.uVn.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void ddl()
  {
    AppMethodBeat.i(26053);
    ad.d("MicroMsg.TalkUIController", "onUserAccept");
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddA())
    {
      this.uVz = this.uVn.isChecked();
      this.uVA = this.uVn.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(this.uVn.isChecked());
    }
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddB()) {
      com.tencent.mm.plugin.ipcall.model.i.ddJ().uMb.uLn.setMute(this.uVl.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void ddm()
  {
    AppMethodBeat.i(26054);
    ad.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    deY();
    IO(10);
    ba.getNotification().cancel(42);
    if (this.uVw != null) {
      this.uVw.nP(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void ddn()
  {
    AppMethodBeat.i(26059);
    this.uVu.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void ddo()
  {
    AppMethodBeat.i(26058);
    this.uVx = com.tencent.mm.plugin.ipcall.model.i.ddL().ddi();
    IO(5);
    AppMethodBeat.o(26058);
  }
  
  public final void deY()
  {
    AppMethodBeat.i(26060);
    if (this.uVp != null) {
      this.uVp.setVisibility(4);
    }
    if (this.uVq != null) {
      this.uVq.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    ad.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.uVD = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!bt.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.uVu.getString(2131760432);
      }
    }
    label173:
    for (;;)
    {
      h.a(this.uVu, paramString2, paramString1, this.uVu.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          j.this.uVu.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        ba.getNotification().cancel(42);
        if ((this.uVw != null) && (!this.uVE)) {
          this.uVw.nP(this.uVD);
        }
        AppMethodBeat.o(26055);
        return;
        g(paramString1, paramString2, paramInt2, this.uVu.getString(2131760431));
        continue;
        g(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void hz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.uVi.setText(paramString1);
    if (!bt.isNullOrNil(paramString1)) {
      this.uVi.setSelection(this.uVi.getText().length() - 1);
    }
    this.uVj.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void nH(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    ad.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddA())
    {
      if (paramBoolean)
      {
        this.uVz = com.tencent.mm.plugin.ipcall.model.i.ddJ().uMb.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(false);
        this.uVn.setEnable(false);
        AppMethodBeat.o(26056);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(this.uVz);
      this.uVn.setEnable(true);
      this.uVn.setChecked(this.uVz);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void nI(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    ad.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.ddK().ddA())
    {
      if (paramBoolean)
      {
        this.uVA = com.tencent.mm.plugin.ipcall.model.i.ddJ().uMb.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(false);
        this.uVn.setEnable(false);
        AppMethodBeat.o(26057);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.ddJ().nJ(this.uVA);
      this.uVn.setEnable(true);
      this.uVn.setChecked(this.uVA);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void nP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */