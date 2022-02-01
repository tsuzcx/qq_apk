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
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  implements com.tencent.mm.plugin.ipcall.e, a.b
{
  DialPad DTb;
  private String DVr;
  private String DVs;
  private String DVt;
  private int DVu;
  private int DVv;
  a DZA;
  private long DZB;
  long DZC;
  boolean DZD;
  boolean DZE;
  private AudioManager DZF;
  private boolean DZG;
  private boolean DZH;
  private boolean DZI;
  boolean DZJ;
  boolean DZK;
  Bitmap DZd;
  EditText DZm;
  TextView DZn;
  ImageView DZo;
  private IPCallFuncButton DZp;
  private IPCallFuncButton DZq;
  private IPCallFuncButton DZr;
  private ImageButton DZs;
  public TextView DZt;
  public View DZu;
  private ImageButton DZv;
  private int DZw;
  String DZx;
  IPCallTalkUI DZy;
  com.tencent.mm.plugin.ipcall.c DZz;
  ImageView jiu;
  private TextView jmj;
  private String mCountryCode;
  private String njH;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.DZw = -1;
    this.DZC = -1L;
    this.DZD = false;
    this.DZE = false;
    this.DZF = null;
    this.DZG = false;
    this.DZH = true;
    this.DZI = false;
    this.DZJ = false;
    this.DZK = false;
    this.DZy = paramIPCallTalkUI;
    this.DZz = i.eJv();
    this.DZz.DOh = this;
    AppMethodBeat.o(26034);
  }
  
  private void Vy(int paramInt)
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
      String str1 = com.tencent.mm.plugin.ipcall.a.c.VB(i.eJq().DOY.DPY);
      if (this.DZw != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.Vz(this.DZw);
        this.jmj.setText(str1 + this.DZy.getString(R.l.eJt, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.jmj.setText(str1 + this.DZy.getString(R.l.eJs));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.jmj.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.DZB / 60L), Long.valueOf(this.DZB % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.jmj.setText(R.l.eJv);
    }
  }
  
  private void eKA()
  {
    AppMethodBeat.i(26045);
    this.DZw = com.tencent.mm.plugin.ipcall.a.a.iC(this.DVs, this.DVr);
    Vy(1);
    this.DZz.a(this.njH, this.DVr, this.DVt, this.DZx, this.DVs, this.DZw, this.DVu, this.DVv);
    Log.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.DZx });
    i.eJs().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void eKB()
  {
    AppMethodBeat.i(26046);
    if (i.eJq().DOY != null)
    {
      this.njH = i.eJq().DOY.nickname;
      this.DZx = i.eJq().DOY.DQk;
      this.DVt = i.eJq().DOY.fcD;
      this.DVs = i.eJq().DOY.fXl;
      this.DVr = i.eJq().DOY.DQj;
      this.DZw = i.eJq().DOY.phoneType;
      Log.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.njH, this.DZx, this.DVt, this.DVs, this.DVr, Integer.valueOf(this.DZw) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void eKC()
  {
    AppMethodBeat.i(26047);
    i.eJu();
    Log.i("MicroMsg.TalkUIController", f.Vj(i.eJu().pzp));
    Vy(i.eJu().pzp);
    eKE();
    eKD();
    AppMethodBeat.o(26047);
  }
  
  private void eKD()
  {
    AppMethodBeat.i(26048);
    if (i.eJu().eJk())
    {
      this.DZr.setChecked(i.eJt().DQq.crl());
      this.DZp.setChecked(i.eJt().DQq.DPD.iYs);
    }
    AppMethodBeat.o(26048);
  }
  
  private void eKE()
  {
    AppMethodBeat.i(26049);
    String str1 = i.eJq().DOY.DQk;
    String str2 = i.eJq().DOY.DQl;
    if (!Util.isNullOrNil(str2))
    {
      aMy(str2);
      this.DZn.setText(com.tencent.mm.plugin.ipcall.a.a.aMH(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!Util.isNullOrNil(str1))
    {
      aMy(str1);
      this.DZn.setText(com.tencent.mm.plugin.ipcall.a.a.aMH(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void eKv()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(12058, this.mCountryCode);
    com.tencent.mm.ui.base.h.a(this.DZy, this.DZy.getString(R.l.etD), this.DZy.getString(R.l.etE), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        j.this.DZy.finish();
        j.this.DZy = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void eKw()
  {
    AppMethodBeat.i(26038);
    if ((!Util.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.aMF(this.DVr)))
    {
      this.DZx = (this.mCountryCode + this.DVr);
      if (!this.DZx.startsWith("+"))
      {
        this.DZx = ("+" + this.DZx);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.DZx = this.DVr;
    }
    AppMethodBeat.o(26038);
  }
  
  private void eKx()
  {
    AppMethodBeat.i(26039);
    i.eJt().iXq = this.DZy;
    i.eJt().eJI();
    i.eJt().a(this);
    i.eJt().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void eKy()
  {
    AppMethodBeat.i(26042);
    if (!Util.isNullOrNil(this.DZx)) {
      aMy(this.DZx);
    }
    if (com.tencent.mm.compatible.util.d.qV(16))
    {
      this.DZm.setTypeface(Typeface.create("sans-serif-light", 0));
      this.DZn.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!Util.isNullOrNil(this.DVs)) {
      this.DZd = com.tencent.mm.plugin.ipcall.a.a.g(this.DZy, this.DVs, true);
    }
    if ((this.DZd == null) && (!Util.isNullOrNil(this.DVr)) && (com.tencent.mm.plugin.ipcall.a.a.byl())) {
      this.DZd = com.tencent.mm.plugin.ipcall.a.a.bq(this.DZy, this.DVr);
    }
    if ((this.DZd == null) && (!Util.isNullOrNil(this.DVt))) {
      this.DZd = com.tencent.mm.am.d.f(this.DVt, 480, 480, 4);
    }
    if (this.DZd == null)
    {
      this.DZo.setVisibility(0);
      this.jiu.setVisibility(8);
    }
    if (this.DZd != null)
    {
      this.DZo.setVisibility(8);
      this.jiu.setVisibility(0);
      this.jiu.setImageBitmap(this.DZd);
    }
    this.DZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        i.eJv().eIQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26029);
      }
    });
    this.DZr.setClickCallback(new IPCallFuncButton.a()
    {
      public final void tC(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        Log.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (i.eJu().eJk())
        {
          j.this.DZD = paramAnonymousBoolean;
          j.this.DZE = paramAnonymousBoolean;
          i.eJt().ty(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.IzE.a(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!i.eJA().adI()) && (!i.eJu().eJm())) {
          i.eJA().Bo(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.DZp.setClickCallback(new IPCallFuncButton.a()
    {
      public final void tC(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (i.eJu().eJl())
        {
          Log.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = i.eJr();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.DQH.setAppCmd(412);; i = locala.DQH.setAppCmd(413))
        {
          if (i < 0) {
            Log.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          i.eJt().DQq.DPD.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.IzE.a(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.DZq.setClickCallback(new IPCallFuncButton.a()
    {
      public final void tC(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          localj = j.this;
          if (localj.DZd == null) {
            localj.jiu.setVisibility(8);
          }
          for (;;)
          {
            localj.jiu.setVisibility(8);
            localj.DZo.setVisibility(8);
            localj.DZm.setText("");
            localj.DZn.setText("");
            localj.DTb.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.IzE.a(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            localj.jiu.setVisibility(4);
          }
        }
        j localj = j.this;
        if (localj.DZd != null)
        {
          localj.jiu.setVisibility(0);
          localj.DZo.setVisibility(8);
        }
        for (;;)
        {
          localj.aMy(localj.DZx);
          localj.DTb.setVisibility(4);
          break;
          localj.DZo.setVisibility(0);
          localj.jiu.setVisibility(8);
        }
      }
    });
    this.DZs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        j.b(j.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26033);
      }
    });
    AppMethodBeat.o(26042);
  }
  
  private void eKz()
  {
    AppMethodBeat.i(26043);
    this.DTb.setDialButtonClickListener(new DialPad.a()
    {
      public final void aMj(String paramAnonymousString)
      {
        AppMethodBeat.i(26023);
        String str2 = j.this.DZm.getText().toString();
        if (Util.isNullOrNil(str2)) {
          j.this.DZC = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.DZC >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.DZC = l;
        j.this.iB(str1, "");
        com.tencent.mm.plugin.ipcall.c.aLX(paramAnonymousString);
        com.tencent.mm.plugin.report.service.h.IzE.a(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(26023);
      }
      
      public final void aMk(String paramAnonymousString) {}
    });
    AppMethodBeat.o(26043);
  }
  
  private void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    eKF();
    if (!Util.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.jmj.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (Util.isNullOrNil(paramString3)) {
          paramString1 = this.DZy.getString(R.l.eIA);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          com.tencent.mm.ui.base.h.a(this.DZy, paramString2, paramString1, this.DZy.getString(R.l.eIB), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              j.this.DZy.finish();
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
    this.DZm.setKeyListener(null);
    this.DZm.setHorizontallyScrolling(true);
    this.DTb.setVisibility(4);
    this.DTb.setTalkUIMode(true);
    eKy();
    eKz();
    AppMethodBeat.o(26040);
  }
  
  final void aMy(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!Util.isNullOrNil(this.njH))
    {
      iB(this.njH, com.tencent.mm.plugin.ipcall.a.a.aMH(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    iB(com.tencent.mm.plugin.ipcall.a.a.aMH(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.DZG = this.DZy.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    Log.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.DZG) });
    this.DZo = ((ImageView)this.DZy.findViewById(R.h.dWk));
    this.jiu = ((ImageView)this.DZy.findViewById(R.h.dWj));
    this.DZm = ((EditText)this.DZy.findViewById(R.h.dWo));
    this.jmj = ((TextView)this.DZy.findViewById(R.h.dWr));
    this.DZn = ((TextView)this.DZy.findViewById(R.h.dWp));
    this.DZp = ((IPCallFuncButton)this.DZy.findViewById(R.h.dWn));
    this.DZq = ((IPCallFuncButton)this.DZy.findViewById(R.h.dWl));
    this.DZr = ((IPCallFuncButton)this.DZy.findViewById(R.h.dWq));
    this.DZs = ((ImageButton)this.DZy.findViewById(R.h.dWm));
    this.DZv = ((ImageButton)this.DZy.findViewById(R.h.ipcall_mini_action));
    this.DZt = ((TextView)this.DZy.findViewById(R.h.voip_net_status_hint));
    this.DZu = this.DZy.findViewById(R.h.eau);
    this.DTb = ((DialPad)this.DZy.findViewById(R.h.dEI));
    if (this.DZG)
    {
      eKB();
      eKx();
      initUI();
      eKC();
      AppMethodBeat.o(26035);
      return;
    }
    if (i.eJu().eJj())
    {
      com.tencent.mm.ui.base.h.a(this.DZy, R.l.in_wechat_out_tip, R.l.app_tip, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          j.this.DZy.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    eKx();
    this.njH = paramString1;
    this.DVr = paramString2;
    this.DVs = paramString3;
    this.mCountryCode = paramString4;
    this.DVu = paramInt1;
    this.DVv = paramInt2;
    if (!Util.isNullOrNil(this.DVr)) {
      this.DVr = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.DVr);
    }
    if (Util.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.aMF(this.DVr))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.DVr);
        if (!Util.isNullOrNil(paramString1)) {
          break label581;
        }
        this.DVr = com.tencent.mm.plugin.ipcall.a.a.aMG(this.DVr);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.eKM();; this.mCountryCode = paramString1)
    {
      Log.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.eJb().aLZ(this.mCountryCode);
      if (Util.isNullOrNil(this.njH)) {
        this.njH = com.tencent.mm.plugin.ipcall.a.a.bn(this.DZy, this.DVr);
      }
      this.DVt = paramString5;
      eKw();
      Log.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.DZx });
      if (!com.tencent.mm.plugin.ipcall.model.c.eJb().Vg(Util.getInt(this.mCountryCode, -1))) {
        break;
      }
      eKv();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.DVr = com.tencent.mm.plugin.ipcall.a.a.aMI(this.DVr);
    }
    if (!NetStatusUtil.isNetworkConnected(this.DZy))
    {
      Toast.makeText(this.DZy, R.l.voip_net_unavailable, 1).show();
      this.DZy.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.DZy.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      Log.i("MicroMsg.TalkUIController", "onDisasterHappen");
      com.tencent.mm.ui.base.h.a(this.DZy, this.DZy.getString(R.l.eIF, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.DZy.getString(R.l.eIA), this.DZy.getString(R.l.eIB), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          j.this.DZy.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    initUI();
    if ((!this.DZG) || (!i.eJu().eJj())) {
      eKA();
    }
    this.DZI = false;
    AppMethodBeat.o(26035);
  }
  
  public final void eIF()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    Log.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = i.eJq().DOY.DQk;
    String str2 = i.eJq().DOY.DQl;
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      Log.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      aMy(str2);
    }
    Log.i("MicroMsg.TalkUIController", "callFlag:" + i.eJq().DOY.DPY);
    int k = i.eJq().DOY.DPY;
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
      com.tencent.mm.ui.base.h.a(this.DZy, R.l.eJB, R.l.eJC, R.l.eJA, R.l.eJz, true, null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26024);
          Log.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
          j.b(j.this);
          AppMethodBeat.o(26024);
        }
      });
    }
    Vy(3);
    AppMethodBeat.o(26051);
  }
  
  public final void eIG()
  {
    AppMethodBeat.i(26052);
    Log.d("MicroMsg.TalkUIController", "onStartRing");
    if (i.eJu().eJk())
    {
      this.DZD = this.DZr.isChecked();
      this.DZE = this.DZr.isChecked();
      i.eJt().ty(this.DZr.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void eIV()
  {
    AppMethodBeat.i(26053);
    Log.d("MicroMsg.TalkUIController", "onUserAccept");
    if (i.eJu().eJk())
    {
      this.DZD = this.DZr.isChecked();
      this.DZE = this.DZr.isChecked();
      i.eJt().ty(this.DZr.isChecked());
    }
    if (i.eJu().eJl()) {
      i.eJt().DQq.DPD.setMute(this.DZp.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void eIW()
  {
    AppMethodBeat.i(26054);
    Log.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    eKF();
    Vy(10);
    bh.getNotification().cancel(42);
    if (this.DZA != null) {
      this.DZA.tE(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void eIX()
  {
    AppMethodBeat.i(26059);
    this.DZy.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void eIY()
  {
    AppMethodBeat.i(26058);
    this.DZB = i.eJv().eIS();
    Vy(5);
    AppMethodBeat.o(26058);
  }
  
  public final void eKF()
  {
    AppMethodBeat.i(26060);
    if (this.DZt != null) {
      this.DZt.setVisibility(4);
    }
    if (this.DZu != null) {
      this.DZu.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    Log.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.DZH = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!Util.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.DZy.getString(R.l.eIA);
      }
    }
    label173:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.DZy, paramString2, paramString1, this.DZy.getString(R.l.eIB), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          j.this.DZy.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        bh.getNotification().cancel(42);
        if ((this.DZA != null) && (!this.DZI)) {
          this.DZA.tE(this.DZH);
        }
        AppMethodBeat.o(26055);
        return;
        f(paramString1, paramString2, paramInt2, this.DZy.getString(R.l.eIz));
        continue;
        f(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void iB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.DZm.setText(paramString1);
    if (!Util.isNullOrNil(paramString1)) {
      this.DZm.setSelection(this.DZm.getText().length() - 1);
    }
    this.DZn.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void tw(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    Log.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.eJu().eJk())
    {
      if (paramBoolean)
      {
        this.DZD = i.eJt().DQq.crl();
        i.eJt().ty(false);
        this.DZr.setEnable(false);
        AppMethodBeat.o(26056);
        return;
      }
      i.eJt().ty(this.DZD);
      this.DZr.setEnable(true);
      this.DZr.setChecked(this.DZD);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void tx(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    Log.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.eJu().eJk())
    {
      if (paramBoolean)
      {
        this.DZE = i.eJt().DQq.crl();
        i.eJt().ty(false);
        this.DZr.setEnable(false);
        AppMethodBeat.o(26057);
        return;
      }
      i.eJt().ty(this.DZE);
      this.DZr.setEnable(true);
      this.DZr.setChecked(this.DZE);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void tE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */