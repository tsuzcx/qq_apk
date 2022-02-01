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
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
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
  private TextView gCd;
  ImageView gyr;
  private String krY;
  private String mCountryCode;
  DialPad ysX;
  private String yvn;
  private String yvo;
  private String yvp;
  private int yvq;
  private int yvr;
  private ImageButton yzA;
  public TextView yzB;
  public View yzC;
  private ImageButton yzD;
  private int yzE;
  String yzF;
  IPCallTalkUI yzG;
  com.tencent.mm.plugin.ipcall.c yzH;
  a yzI;
  private long yzJ;
  long yzK;
  boolean yzL;
  boolean yzM;
  private AudioManager yzN;
  private boolean yzO;
  private boolean yzP;
  private boolean yzQ;
  boolean yzR;
  boolean yzS;
  Bitmap yzl;
  EditText yzu;
  TextView yzv;
  ImageView yzw;
  private IPCallFuncButton yzx;
  private IPCallFuncButton yzy;
  private IPCallFuncButton yzz;
  
  public j(IPCallTalkUI paramIPCallTalkUI)
  {
    AppMethodBeat.i(26034);
    this.yzE = -1;
    this.yzK = -1L;
    this.yzL = false;
    this.yzM = false;
    this.yzN = null;
    this.yzO = false;
    this.yzP = true;
    this.yzQ = false;
    this.yzR = false;
    this.yzS = false;
    this.yzG = paramIPCallTalkUI;
    this.yzH = i.eax();
    this.yzH.yof = this;
    AppMethodBeat.o(26034);
  }
  
  private void Pp(int paramInt)
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
      String str1 = com.tencent.mm.plugin.ipcall.a.c.Ps(i.eas().yoW.ypW);
      if (this.yzE != -1)
      {
        String str2 = com.tencent.mm.plugin.ipcall.a.a.Pq(this.yzE);
        this.gCd.setText(str1 + this.yzG.getString(2131761942, new Object[] { str2 }));
        AppMethodBeat.o(26050);
        return;
      }
      this.gCd.setText(str1 + this.yzG.getString(2131761941));
      AppMethodBeat.o(26050);
      return;
      AppMethodBeat.o(26050);
      return;
      this.gCd.setText(String.format("%02d:%02d", new Object[] { Long.valueOf(this.yzJ / 60L), Long.valueOf(this.yzJ % 60L) }));
      AppMethodBeat.o(26050);
      return;
      this.gCd.setText(2131761945);
    }
  }
  
  private void ebA()
  {
    AppMethodBeat.i(26042);
    if (!Util.isNullOrNil(this.yzF)) {
      aCr(this.yzF);
    }
    if (d.oD(16))
    {
      this.yzu.setTypeface(Typeface.create("sans-serif-light", 0));
      this.yzv.setTypeface(Typeface.create("sans-serif-light", 0));
    }
    if (!Util.isNullOrNil(this.yvo)) {
      this.yzl = com.tencent.mm.plugin.ipcall.a.a.g(this.yzG, this.yvo, true);
    }
    if ((this.yzl == null) && (!Util.isNullOrNil(this.yvn)) && (com.tencent.mm.plugin.ipcall.a.a.boc())) {
      this.yzl = com.tencent.mm.plugin.ipcall.a.a.be(this.yzG, this.yvn);
    }
    if ((this.yzl == null) && (!Util.isNullOrNil(this.yvp))) {
      this.yzl = com.tencent.mm.aj.c.e(this.yvp, 480, 480, 4);
    }
    if (this.yzl == null)
    {
      this.yzw.setVisibility(0);
      this.gyr.setVisibility(8);
    }
    if (this.yzl != null)
    {
      this.yzw.setVisibility(8);
      this.gyr.setVisibility(0);
      this.gyr.setImageBitmap(this.yzl);
    }
    this.yzD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        i.eax().dZS();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26029);
      }
    });
    this.yzz.setClickCallback(new IPCallFuncButton.a()
    {
      public final void qA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26030);
        Log.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (i.eaw().eam())
        {
          j.this.yzL = paramAnonymousBoolean;
          j.this.yzM = paramAnonymousBoolean;
          i.eav().qw(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.CyF.a(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26030);
          return;
        }
        if ((!i.eaC().YZ()) && (!i.eaw().eao())) {
          i.eaC().xw(paramAnonymousBoolean);
        }
        AppMethodBeat.o(26030);
      }
    });
    this.yzx.setClickCallback(new IPCallFuncButton.a()
    {
      public final void qA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26031);
        com.tencent.mm.plugin.ipcall.model.d.a locala;
        if (i.eaw().ean())
        {
          Log.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          locala = i.eat();
          if (!paramAnonymousBoolean) {
            break label131;
          }
        }
        label131:
        for (int i = locala.yqF.setAppCmd(412);; i = locala.yqF.setAppCmd(413))
        {
          if (i < 0) {
            Log.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
          }
          i.eav().yqo.ypB.setMute(paramAnonymousBoolean);
          com.tencent.mm.plugin.report.service.h.CyF.a(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(26031);
          return;
        }
      }
    });
    this.yzy.setClickCallback(new IPCallFuncButton.a()
    {
      public final void qA(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26032);
        if (paramAnonymousBoolean)
        {
          localj = j.this;
          if (localj.yzl == null) {
            localj.gyr.setVisibility(8);
          }
          for (;;)
          {
            localj.gyr.setVisibility(8);
            localj.yzw.setVisibility(8);
            localj.yzu.setText("");
            localj.yzv.setText("");
            localj.ysX.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.CyF.a(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26032);
            return;
            localj.gyr.setVisibility(4);
          }
        }
        j localj = j.this;
        if (localj.yzl != null)
        {
          localj.gyr.setVisibility(0);
          localj.yzw.setVisibility(8);
        }
        for (;;)
        {
          localj.aCr(localj.yzF);
          localj.ysX.setVisibility(4);
          break;
          localj.yzw.setVisibility(0);
          localj.gyr.setVisibility(8);
        }
      }
    });
    this.yzA.setOnClickListener(new j.12(this));
    AppMethodBeat.o(26042);
  }
  
  private void ebB()
  {
    AppMethodBeat.i(26043);
    this.ysX.setDialButtonClickListener(new DialPad.a()
    {
      public final void aCc(String paramAnonymousString)
      {
        AppMethodBeat.i(26023);
        String str2 = j.this.yzu.getText().toString();
        if (Util.isNullOrNil(str2)) {
          j.this.yzK = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        String str1 = str2;
        if (l - j.this.yzK >= 3000L) {
          str1 = str2 + " ";
        }
        str1 = str1 + paramAnonymousString;
        j.this.yzK = l;
        j.this.io(str1, "");
        com.tencent.mm.plugin.ipcall.c.aBQ(paramAnonymousString);
        com.tencent.mm.plugin.report.service.h.CyF.a(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        AppMethodBeat.o(26023);
      }
      
      public final void aCd(String paramAnonymousString) {}
    });
    AppMethodBeat.o(26043);
  }
  
  private void ebC()
  {
    AppMethodBeat.i(26045);
    this.yzE = com.tencent.mm.plugin.ipcall.a.a.ip(this.yvo, this.yvn);
    Pp(1);
    this.yzH.a(this.krY, this.yvn, this.yvp, this.yzF, this.yvo, this.yzE, this.yvq, this.yvr);
    Log.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { this.yzF });
    i.eau().setCountryCode(this.mCountryCode);
    AppMethodBeat.o(26045);
  }
  
  private void ebD()
  {
    AppMethodBeat.i(26046);
    if (i.eas().yoW != null)
    {
      this.krY = i.eas().yoW.nickname;
      this.yzF = i.eas().yoW.yqi;
      this.yvp = i.eas().yoW.dkV;
      this.yvo = i.eas().yoW.edf;
      this.yvn = i.eas().yoW.yqh;
      this.yzE = i.eas().yoW.phoneType;
      Log.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { this.krY, this.yzF, this.yvp, this.yvo, this.yvn, Integer.valueOf(this.yzE) });
    }
    AppMethodBeat.o(26046);
  }
  
  private void ebE()
  {
    AppMethodBeat.i(26047);
    i.eaw();
    Log.i("MicroMsg.TalkUIController", f.stateToString(i.eaw().mAT));
    Pp(i.eaw().mAT);
    ebG();
    ebF();
    AppMethodBeat.o(26047);
  }
  
  private void ebF()
  {
    AppMethodBeat.i(26048);
    if (i.eaw().eam())
    {
      this.yzz.setChecked(i.eav().yqo.isSpeakerphoneOn());
      this.yzx.setChecked(i.eav().yqo.ypB.guh);
    }
    AppMethodBeat.o(26048);
  }
  
  private void ebG()
  {
    AppMethodBeat.i(26049);
    String str1 = i.eas().yoW.yqi;
    String str2 = i.eas().yoW.yqj;
    if (!Util.isNullOrNil(str2))
    {
      aCr(str2);
      this.yzv.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(str2));
      AppMethodBeat.o(26049);
      return;
    }
    if (!Util.isNullOrNil(str1))
    {
      aCr(str1);
      this.yzv.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(str1));
    }
    AppMethodBeat.o(26049);
  }
  
  private void ebx()
  {
    AppMethodBeat.i(26036);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(12058, this.mCountryCode);
    com.tencent.mm.ui.base.h.a(this.yzG, this.yzG.getString(2131756924), this.yzG.getString(2131756925), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26027);
        j.this.yzG.finish();
        j.this.yzG = null;
        AppMethodBeat.o(26027);
      }
    });
    AppMethodBeat.o(26036);
  }
  
  private void eby()
  {
    AppMethodBeat.i(26038);
    if ((!Util.isNullOrNil(this.mCountryCode)) && (!com.tencent.mm.plugin.ipcall.a.a.aCy(this.yvn)))
    {
      this.yzF = (this.mCountryCode + this.yvn);
      if (!this.yzF.startsWith("+"))
      {
        this.yzF = ("+" + this.yzF);
        AppMethodBeat.o(26038);
      }
    }
    else
    {
      this.yzF = this.yvn;
    }
    AppMethodBeat.o(26038);
  }
  
  private void ebz()
  {
    AppMethodBeat.i(26039);
    i.eav().gte = this.yzG;
    i.eav().eaK();
    i.eav().a(this);
    i.eav().a(this);
    AppMethodBeat.o(26039);
  }
  
  private void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(26037);
    ebH();
    if (!Util.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if ((2 == paramInt) && (paramString2 != null))
      {
        this.gCd.setText(paramString2);
        AppMethodBeat.o(26037);
        return;
        if (Util.isNullOrNil(paramString3)) {
          paramString1 = this.yzG.getString(2131761877);
        }
      }
      else
      {
        if ((1 == paramInt) && (paramString2 != null)) {
          com.tencent.mm.ui.base.h.a(this.yzG, paramString2, paramString1, this.yzG.getString(2131761878), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26028);
              j.this.yzG.finish();
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
    this.yzu.setKeyListener(null);
    this.yzu.setHorizontallyScrolling(true);
    this.ysX.setVisibility(4);
    this.ysX.setTalkUIMode(true);
    ebA();
    ebB();
    AppMethodBeat.o(26040);
  }
  
  final void aCr(String paramString)
  {
    AppMethodBeat.i(26041);
    if (!Util.isNullOrNil(this.krY))
    {
      io(this.krY, com.tencent.mm.plugin.ipcall.a.a.aCA(paramString));
      AppMethodBeat.o(26041);
      return;
    }
    io(com.tencent.mm.plugin.ipcall.a.a.aCA(paramString), "");
    AppMethodBeat.o(26041);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26035);
    this.yzO = this.yzG.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    Log.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(this.yzO) });
    this.yzw = ((ImageView)this.yzG.findViewById(2131308900));
    this.gyr = ((ImageView)this.yzG.findViewById(2131308898));
    this.yzu = ((EditText)this.yzG.findViewById(2131308905));
    this.gCd = ((TextView)this.yzG.findViewById(2131308908));
    this.yzv = ((TextView)this.yzG.findViewById(2131308906));
    this.yzx = ((IPCallFuncButton)this.yzG.findViewById(2131308904));
    this.yzy = ((IPCallFuncButton)this.yzG.findViewById(2131308901));
    this.yzz = ((IPCallFuncButton)this.yzG.findViewById(2131308907));
    this.yzA = ((ImageButton)this.yzG.findViewById(2131308903));
    this.yzD = ((ImageButton)this.yzG.findViewById(2131302779));
    this.yzB = ((TextView)this.yzG.findViewById(2131310041));
    this.yzC = this.yzG.findViewById(2131310042);
    this.ysX = ((DialPad)this.yzG.findViewById(2131299634));
    if (this.yzO)
    {
      ebD();
      ebz();
      initUI();
      ebE();
      AppMethodBeat.o(26035);
      return;
    }
    if (i.eaw().eal())
    {
      com.tencent.mm.ui.base.h.a(this.yzG, 2131761782, 2131755998, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26022);
          j.this.yzG.finish();
          AppMethodBeat.o(26022);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    ebz();
    this.krY = paramString1;
    this.yvn = paramString2;
    this.yvo = paramString3;
    this.mCountryCode = paramString4;
    this.yvq = paramInt1;
    this.yvr = paramInt2;
    if (!Util.isNullOrNil(this.yvn)) {
      this.yvn = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.yvn);
    }
    if (Util.isNullOrNil(this.mCountryCode)) {
      if (com.tencent.mm.plugin.ipcall.a.a.aCy(this.yvn))
      {
        paramString1 = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.yvn);
        if (!Util.isNullOrNil(paramString1)) {
          break label581;
        }
        this.yvn = com.tencent.mm.plugin.ipcall.a.a.aCz(this.yvn);
      }
    }
    for (this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.ebO();; this.mCountryCode = paramString1)
    {
      Log.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { this.mCountryCode });
      com.tencent.mm.plugin.ipcall.model.c.ead().aBS(this.mCountryCode);
      if (Util.isNullOrNil(this.krY)) {
        this.krY = com.tencent.mm.plugin.ipcall.a.a.bb(this.yzG, this.yvn);
      }
      this.yvp = paramString5;
      eby();
      Log.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { this.yzF });
      if (!com.tencent.mm.plugin.ipcall.model.c.ead().OY(Util.getInt(this.mCountryCode, -1))) {
        break;
      }
      ebx();
      AppMethodBeat.o(26035);
      return;
      label581:
      this.yvn = com.tencent.mm.plugin.ipcall.a.a.aCB(this.yvn);
    }
    if (!NetStatusUtil.isNetworkConnected(this.yzG))
    {
      Toast.makeText(this.yzG, 2131767334, 1).show();
      this.yzG.finish();
      AppMethodBeat.o(26035);
      return;
    }
    long l1 = this.yzG.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      Log.i("MicroMsg.TalkUIController", "onDisasterHappen");
      com.tencent.mm.ui.base.h.a(this.yzG, this.yzG.getString(2131761887, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), this.yzG.getString(2131761877), this.yzG.getString(2131761878), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26026);
          j.this.yzG.finish();
          AppMethodBeat.o(26026);
        }
      });
      AppMethodBeat.o(26035);
      return;
    }
    initUI();
    if ((!this.yzO) || (!i.eaw().eal())) {
      ebC();
    }
    this.yzQ = false;
    AppMethodBeat.o(26035);
  }
  
  public final void dZI()
  {
    int j = 0;
    AppMethodBeat.i(26051);
    Log.i("MicroMsg.TalkUIController", "onInviteSuccess");
    String str1 = i.eas().yoW.yqi;
    String str2 = i.eas().yoW.yqj;
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (!str1.equals(str2)))
    {
      Log.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", new Object[] { str1, str2 });
      aCr(str2);
    }
    Log.i("MicroMsg.TalkUIController", "callFlag:" + i.eas().yoW.ypW);
    int k = i.eas().yoW.ypW;
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
      com.tencent.mm.ui.base.h.a(this.yzG, 2131761957, 2131761958, 2131761956, 2131761955, true, null, new j.3(this));
    }
    Pp(3);
    AppMethodBeat.o(26051);
  }
  
  public final void dZJ()
  {
    AppMethodBeat.i(26052);
    Log.d("MicroMsg.TalkUIController", "onStartRing");
    if (i.eaw().eam())
    {
      this.yzL = this.yzz.isChecked();
      this.yzM = this.yzz.isChecked();
      i.eav().qw(this.yzz.isChecked());
    }
    AppMethodBeat.o(26052);
  }
  
  public final void dZX()
  {
    AppMethodBeat.i(26053);
    Log.d("MicroMsg.TalkUIController", "onUserAccept");
    if (i.eaw().eam())
    {
      this.yzL = this.yzz.isChecked();
      this.yzM = this.yzz.isChecked();
      i.eav().qw(this.yzz.isChecked());
    }
    if (i.eaw().ean()) {
      i.eav().yqo.ypB.setMute(this.yzx.isChecked());
    }
    AppMethodBeat.o(26053);
  }
  
  public final void dZY()
  {
    AppMethodBeat.i(26054);
    Log.d("MicroMsg.TalkUIController", "onOthersideShutdown");
    ebH();
    Pp(10);
    bg.getNotification().cancel(42);
    if (this.yzI != null) {
      this.yzI.qC(true);
    }
    AppMethodBeat.o(26054);
  }
  
  public final void dZZ()
  {
    AppMethodBeat.i(26059);
    this.yzG.finish();
    AppMethodBeat.o(26059);
  }
  
  public final void eaa()
  {
    AppMethodBeat.i(26058);
    this.yzJ = i.eax().dZU();
    Pp(5);
    AppMethodBeat.o(26058);
  }
  
  public final void ebH()
  {
    AppMethodBeat.i(26060);
    if (this.yzB != null) {
      this.yzB.setVisibility(4);
    }
    if (this.yzC != null) {
      this.yzC.setVisibility(4);
    }
    AppMethodBeat.o(26060);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(26055);
    Log.d("MicroMsg.TalkUIController", "onError, error: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt2 == 1) {
      this.yzP = false;
    }
    if (paramInt1 == 8) {
      if (paramInt2 == 1)
      {
        if (!Util.isNullOrNil(paramString1)) {
          break label173;
        }
        paramString1 = this.yzG.getString(2131761877);
      }
    }
    label173:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.yzG, paramString2, paramString1, this.yzG.getString(2131761878), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26025);
          j.this.yzG.finish();
          AppMethodBeat.o(26025);
        }
      });
      for (;;)
      {
        bg.getNotification().cancel(42);
        if ((this.yzI != null) && (!this.yzQ)) {
          this.yzI.qC(this.yzP);
        }
        AppMethodBeat.o(26055);
        return;
        f(paramString1, paramString2, paramInt2, this.yzG.getString(2131761876));
        continue;
        f(paramString1, paramString2, paramInt2, null);
      }
    }
  }
  
  final void io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26044);
    this.yzu.setText(paramString1);
    if (!Util.isNullOrNil(paramString1)) {
      this.yzu.setSelection(this.yzu.getText().length() - 1);
    }
    this.yzv.setText(paramString2);
    AppMethodBeat.o(26044);
  }
  
  public final void qu(boolean paramBoolean)
  {
    AppMethodBeat.i(26056);
    Log.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.eaw().eam())
    {
      if (paramBoolean)
      {
        this.yzL = i.eav().yqo.isSpeakerphoneOn();
        i.eav().qw(false);
        this.yzz.setEnable(false);
        AppMethodBeat.o(26056);
        return;
      }
      i.eav().qw(this.yzL);
      this.yzz.setEnable(true);
      this.yzz.setChecked(this.yzL);
    }
    AppMethodBeat.o(26056);
  }
  
  public final void qv(boolean paramBoolean)
  {
    AppMethodBeat.i(26057);
    Log.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.eaw().eam())
    {
      if (paramBoolean)
      {
        this.yzM = i.eav().yqo.isSpeakerphoneOn();
        i.eav().qw(false);
        this.yzz.setEnable(false);
        AppMethodBeat.o(26057);
        return;
      }
      i.eav().qw(this.yzM);
      this.yzz.setEnable(true);
      this.yzz.setChecked(this.yzM);
    }
    AppMethodBeat.o(26057);
  }
  
  public static abstract interface a
  {
    public abstract void qC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j
 * JD-Core Version:    0.7.0.1
 */