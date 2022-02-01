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
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;

public final class j
  implements e, a.b
{
  ImageView fTj;
  private TextView fWX;
  private String jtJ;
  private String mCountryCode;
  DialPad vax;
  private String vcN;
  private String vcO;
  private String vcP;
  private int vcQ;
  private int vcR;
  Bitmap vgM;
  EditText vgV;
  TextView vgW;
  ImageView vgX;
  private IPCallFuncButton vgY;
  private IPCallFuncButton vgZ;
  private IPCallFuncButton vha;
  private ImageButton vhb;
  public TextView vhc;
  public View vhd;
  private ImageButton vhe;
  private int vhf;
  String vhg;
  IPCallTalkUI vhh;
  com.tencent.mm.plugin.ipcall.c vhi;
  a vhj;
  private long vhk;
  long vhl;
  boolean vhm;
  boolean vhn;
  private AudioManager vho;
  private boolean vhp;
  private boolean vhq;
  private boolean vhr;
  boolean vhs;
  boolean vht;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.vhf = -1;
    this.vhl = -1L;
    this.vhm = false;
    this.vhn = false;
    this.vho = null;
    this.vhp = false;
    this.vhq = true;
    this.vhr = false;
    this.vhs = false;
    this.vht = false;
    this.vhh = paramIPCallTalkUI;
    this.vhi = com.tencent.mm.plugin.ipcall.model.i.dgD();
    this.vhi.uVE = this;
    AppMethodBeat.o(26034);
  }
  
  private void Jm(int paramInt)
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
      String str1 = com.tencent.mm.plugin.ipcall.a.c.Jp(com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXv);
      if (this.vhf != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.Jn(this.vhf);
        this.fWX.setText(str1 + this.vhh.getString(2131760497, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.fWX.setText(str1 + this.vhh.getString(2131760496));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.fWX.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.vhk / 60L), Long.valueOf(this.vhk % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.fWX.setText(2131760500);
    }
  }
  
  private void dhF()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(12058, this.mCountryCode);
    h.a(this.vhh, this.vhh.getString(2131756761), this.vhh.getString(2131756762), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        j.this.vhh.finish();
        j.this.vhh = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void dhG()
  {
    AppMethodBeat.i(26038);
    if ((!bu.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.apf(this.vcN)))
    {
      this.vhg = (this.mCountryCode + this.vcN);
      if (!this.vhg.startsWith("+"))
      {
        this.vhg = ("+" + this.vhg);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.vhg = this.vcN;
    }
    AppMethodBeat.o(26038);
  }
  
  private void dhH()
  {
    AppMethodBeat.i(26039);
    com.tencent.mm.plugin.ipcall.model.i.dgB().fNT = this.vhh;
    com.tencent.mm.plugin.ipcall.model.i.dgB().dgQ();
    com.tencent.mm.plugin.ipcall.model.i.dgB().a(this);
    com.tencent.mm.plugin.ipcall.model.i.dgB().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void dhI()
  {
    AppMethodBeat.i(26040);
    this.vgV.setKeyListener(null);
    this.vgV.setHorizontallyScrolling(true);
    this.vax.setVisibility(4);
    this.vax.setTalkUIMode(true);
    dhJ();
    dhK();
    AppMethodBeat.o(26040);
  }
  
  private void dhJ()
  {
    AppMethodBeat.i(26042);
    if (!bu.isNullOrNil(this.vhg)) {
      aoX(this.vhg);
    }
    if (d.lA(16))
    {
      this.vgV.setTypeface(Typeface.create("sans-serif-light", 0));
      this.vgW.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!bu.isNullOrNil(this.vcO)) {
      this.vgM = com.tencent.mm.plugin.ipcall.a.a.g(this.vhh, this.vcO, true);
    }
    if ((this.vgM == null) && (!bu.isNullOrNil(this.vcN)) && (com.tencent.mm.plugin.ipcall.a.a.aTq())) {
      this.vgM = com.tencent.mm.plugin.ipcall.a.a.aR(this.vhh, this.vcN);
    }
    if ((this.vgM == null) && (!bu.isNullOrNil(this.vcP))) {
      this.vgM = com.tencent.mm.aj.c.e(this.vcP, 480, 480, 4);
    }
    if (this.vgM == null)
    {
      this.vgX.setVisibility(0);
      this.fTj.setVisibility(8);
    }
    if (this.vgM != null)
    {
      this.vgX.setVisibility(8);
      this.fTj.setVisibility(0);
      this.fTj.setImageBitmap(this.vgM);
    }
    this.vhe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.ipcall.model.i.dgD().dfY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26029);
      }
    });
    this.vha.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nR(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        ae.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgs())
        {
          j.this.vhm = paramAnonymousBoolean;
          j.this.vhn = paramAnonymousBoolean;
          com.tencent.mm.plugin.ipcall.model.i.dgB().nN(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.g.yxI.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!com.tencent.mm.plugin.ipcall.model.i.dgI().OH()) && (!com.tencent.mm.plugin.ipcall.model.i.dgC().dgu())) {
          com.tencent.mm.plugin.ipcall.model.i.dgI().tO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.vgY.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nR(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgt())
        {
          ae.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = com.tencent.mm.plugin.ipcall.model.i.dgz();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.uYf.setAppCmd(412);; i = locala.uYf.setAppCmd(413))
        {
          if (i < 0) {
            ae.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          com.tencent.mm.plugin.ipcall.model.i.dgB().uXO.uXa.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.g.yxI.f(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.vgZ.setClickCallback(new IPCallFuncButton.a()
    {
      public final void nR(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          localj = j.this;
          if (localj.vgM == null) {
            localj.fTj.setVisibility(8);
          }
          for (;;)
          {
            localj.fTj.setVisibility(8);
            localj.vgX.setVisibility(8);
            localj.vgV.setText("");
            localj.vgW.setText("");
            localj.vax.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.yxI.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            localj.fTj.setVisibility(4);
          }
        }
        j localj = j.this;
        if (localj.vgM != null)
        {
          localj.fTj.setVisibility(0);
          localj.vgX.setVisibility(8);
        }
        for (;;)
        {
          localj.aoX(localj.vhg);
          localj.vax.setVisibility(4);
          break;
          localj.vgX.setVisibility(0);
          localj.fTj.setVisibility(8);
        }
      }
    });
    this.vhb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        j.b(j.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26033);
      }
    });
    AppMethodBeat.o(26042);
  }
  
  private void dhK()
  {
    AppMethodBeat.i(26043);
    this.vax.setDialButtonClickListener(new DialPad.a()
    {
      public final void aoI(String paramAnonymousString)
      {
        AppMethodBeat.i(26023);
        String str2 = j.this.vgV.getText().toString();
        if (bu.isNullOrNil(str2)) {
          j.this.vhl = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.vhl >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.vhl = l;
        j.this.hG(str1, "");
        com.tencent.mm.plugin.ipcall.c.aow(paramAnonymousString);
        com.tencent.mm.plugin.report.service.g.yxI.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(26023);
      }
      
      public final void aoJ(String paramAnonymousString) {}
    });
    AppMethodBeat.o(26043);
  }
  
  private void dhL()
  {
    AppMethodBeat.i(26045);
    this.vhf = com.tencent.mm.plugin.ipcall.a.a.hH(this.vcO, this.vcN);
    Jm(1);
    this.vhi.a(this.jtJ, this.vcN, this.vcP, this.vhg, this.vcO, this.vhf, this.vcQ, this.vcR);
    ae.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.vhg });
    com.tencent.mm.plugin.ipcall.model.i.dgA().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void dhM()
  {
    AppMethodBeat.i(26046);
    if (com.tencent.mm.plugin.ipcall.model.i.dgy().uWv != null)
    {
      this.jtJ = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.nickname;
      this.vhg = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXH;
      this.vcP = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.cUB;
      this.vcO = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.dLq;
      this.vcN = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXG;
      this.vhf = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXJ;
      ae.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.jtJ, this.vhg, this.vcP, this.vcO, this.vcN, Integer.valueOf(this.vhf) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void dhN()
  {
    AppMethodBeat.i(26047);
    com.tencent.mm.plugin.ipcall.model.i.dgC();
    ae.i("MicroMsg.TalkUIController", f.stateToString(com.tencent.mm.plugin.ipcall.model.i.dgC().lur));
    Jm(com.tencent.mm.plugin.ipcall.model.i.dgC().lur);
    dhP();
    dhO();
    AppMethodBeat.o(26047);
  }
  
  private void dhO()
  {
    AppMethodBeat.i(26048);
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgs())
    {
      this.vha.setChecked(com.tencent.mm.plugin.ipcall.model.i.dgB().uXO.isSpeakerphoneOn());
      this.vgY.setChecked(com.tencent.mm.plugin.ipcall.model.i.dgB().uXO.uXa.fOX);
    }
    AppMethodBeat.o(26048);
  }
  
  private void dhP()
  {
    AppMethodBeat.i(26049);
    String str1 = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXH;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXI;
    if (!bu.isNullOrNil(str2))
    {
      aoX(str2);
      this.vgW.setText(com.tencent.mm.plugin.ipcall.a.a.aph(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!bu.isNullOrNil(str1))
    {
      aoX(str1);
      this.vgW.setText(com.tencent.mm.plugin.ipcall.a.a.aph(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    dhQ();
    if (!bu.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.fWX.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (bu.isNullOrNil(paramString3)) {
          paramString1 = this.vhh.getString(2131760432);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          h.a(this.vhh, paramString2, paramString1, this.vhh.getString(2131760433), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              j.this.vhh.finish();
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
  
  final void aoX(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!bu.isNullOrNil(this.jtJ))
    {
      hG(this.jtJ, com.tencent.mm.plugin.ipcall.a.a.aph(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    hG(com.tencent.mm.plugin.ipcall.a.a.aph(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.vhp = this.vhh.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    ae.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.vhp) });
    this.vgX = ((ImageView)this.vhh.findViewById(2131305655));
    this.fTj = ((ImageView)this.vhh.findViewById(2131305653));
    this.vgV = ((EditText)this.vhh.findViewById(2131305660));
    this.fWX = ((TextView)this.vhh.findViewById(2131305663));
    this.vgW = ((TextView)this.vhh.findViewById(2131305661));
    this.vgY = ((IPCallFuncButton)this.vhh.findViewById(2131305659));
    this.vgZ = ((IPCallFuncButton)this.vhh.findViewById(2131305656));
    this.vha = ((IPCallFuncButton)this.vhh.findViewById(2131305662));
    this.vhb = ((ImageButton)this.vhh.findViewById(2131305658));
    this.vhe = ((ImageButton)this.vhh.findViewById(2131301125));
    this.vhc = ((TextView)this.vhh.findViewById(2131306581));
    this.vhd = this.vhh.findViewById(2131306582);
    this.vax = ((DialPad)this.vhh.findViewById(2131299111));
    if (this.vhp)
    {
      dhM();
      dhH();
      dhI();
      dhN();
      AppMethodBeat.o(26035);
      return;
    }
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgr())
    {
      h.a(this.vhh, 2131760337, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          j.this.vhh.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    dhH();
    this.jtJ = paramString1;
    this.vcN = paramString2;
    this.vcO = paramString3;
    this.mCountryCode = paramString4;
    this.vcQ = paramInt1;
    this.vcR = paramInt2;
    if (!bu.isNullOrNil(this.vcN)) {
      this.vcN = com.tencent.mm.plugin.ipcall.a.c.apl(this.vcN);
    }
    if (bu.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.apf(this.vcN))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.apd(this.vcN);
        if (!bu.isNullOrNil(paramString1)) {
          break label581;
        }
        this.vcN = com.tencent.mm.plugin.ipcall.a.a.apg(this.vcN);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.dhX();; this.mCountryCode = paramString1)
    {
      ae.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.dgj().aoy(this.mCountryCode);
      if (bu.isNullOrNil(this.jtJ)) {
        this.jtJ = com.tencent.mm.plugin.ipcall.a.a.aO(this.vhh, this.vcN);
      }
      this.vcP = paramString5;
      dhG();
      ae.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.vhg });
      if (!com.tencent.mm.plugin.ipcall.model.c.dgj().IV(bu.getInt(this.mCountryCode, -1))) {
        break;
      }
      dhF();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.vcN = com.tencent.mm.plugin.ipcall.a.a.api(this.vcN);
    }
    if (!az.isNetworkConnected(this.vhh))
    {
      Toast.makeText(this.vhh, 2131764895, 1).show();
      this.vhh.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.vhh.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      ae.i("MicroMsg.TalkUIController", "onDisasterHappen");
      h.a(this.vhh, this.vhh.getString(2131760442, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.vhh.getString(2131760432), this.vhh.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          j.this.vhh.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    dhI();
    if ((!this.vhp) || (!com.tencent.mm.plugin.ipcall.model.i.dgC().dgr())) {
      dhL();
    }
    this.vhr = false;
    AppMethodBeat.o(26035);
  }
  
  public final void dfO()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    ae.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXH;
    String str2 = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXI;
    if ((!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      ae.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      aoX(str2);
    }
    ae.i("MicroMsg.TalkUIController", "callFlag:" + com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXv);
    int k = com.tencent.mm.plugin.ipcall.model.i.dgy().uWv.uXv;
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
      ae.i("MicroMsg.TalkUIController", "isNotFree");
      h.a(this.vhh, 2131760512, 2131760513, 2131760511, 2131760510, true, null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26024);
          ae.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
          j.b(j.this);
          AppMethodBeat.o(26024);
        }
      });
    }
    Jm(3);
    AppMethodBeat.o(26051);
  }
  
  public final void dfP()
  {
    AppMethodBeat.i(26052);
    ae.d("MicroMsg.TalkUIController", "onStartRing");
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgs())
    {
      this.vhm = this.vha.isChecked();
      this.vhn = this.vha.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.dgB().nN(this.vha.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void dgd()
  {
    AppMethodBeat.i(26053);
    ae.d("MicroMsg.TalkUIController", "onUserAccept");
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgs())
    {
      this.vhm = this.vha.isChecked();
      this.vhn = this.vha.isChecked();
      com.tencent.mm.plugin.ipcall.model.i.dgB().nN(this.vha.isChecked());
    }
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgt()) {
      com.tencent.mm.plugin.ipcall.model.i.dgB().uXO.uXa.setMute(this.vgY.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void dge()
  {
    AppMethodBeat.i(26054);
    ae.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    dhQ();
    Jm(10);
    bc.getNotification().cancel(42);
    if (this.vhj != null) {
      this.vhj.nT(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void dgf()
  {
    AppMethodBeat.i(26059);
    this.vhh.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void dgg()
  {
    AppMethodBeat.i(26058);
    this.vhk = com.tencent.mm.plugin.ipcall.model.i.dgD().dga();
    Jm(5);
    AppMethodBeat.o(26058);
  }
  
  public final void dhQ()
  {
    AppMethodBeat.i(26060);
    if (this.vhc != null) {
      this.vhc.setVisibility(4);
    }
    if (this.vhd != null) {
      this.vhd.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    ae.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.vhq = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!bu.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.vhh.getString(2131760432);
      }
    }
    label173:
    for (;;)
    {
      h.a(this.vhh, paramString2, paramString1, this.vhh.getString(2131760433), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          j.this.vhh.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        bc.getNotification().cancel(42);
        if ((this.vhj != null) && (!this.vhr)) {
          this.vhj.nT(this.vhq);
        }
        AppMethodBeat.o(26055);
        return;
        g(paramString1, paramString2, paramInt2, this.vhh.getString(2131760431));
        continue;
        g(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void hG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.vgV.setText(paramString1);
    if (!bu.isNullOrNil(paramString1)) {
      this.vgV.setSelection(this.vgV.getText().length() - 1);
    }
    this.vgW.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void nL(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    ae.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgs())
    {
      if (paramBoolean)
      {
        this.vhm = com.tencent.mm.plugin.ipcall.model.i.dgB().uXO.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.dgB().nN(false);
        this.vha.setEnable(false);
        AppMethodBeat.o(26056);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.dgB().nN(this.vhm);
      this.vha.setEnable(true);
      this.vha.setChecked(this.vhm);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void nM(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    ae.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.model.i.dgC().dgs())
    {
      if (paramBoolean)
      {
        this.vhn = com.tencent.mm.plugin.ipcall.model.i.dgB().uXO.isSpeakerphoneOn();
        com.tencent.mm.plugin.ipcall.model.i.dgB().nN(false);
        this.vha.setEnable(false);
        AppMethodBeat.o(26057);
        return;
      }
      com.tencent.mm.plugin.ipcall.model.i.dgB().nN(this.vhn);
      this.vha.setEnable(true);
      this.vha.setChecked(this.vhn);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void nT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */