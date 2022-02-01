package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.c.i;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.c.m;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private int dvA;
  private View.OnClickListener iAw;
  private int mChannel;
  private ap mHandler;
  private EmojiInfo oBl;
  private Button oHj;
  private TextView swB;
  private String tfj;
  private int tfl;
  private int tfs;
  private LinkedList<w> tfv;
  private int tgM;
  private String tgQ;
  private Dialog tipDialog;
  private String tka;
  private ViewGroup tlB;
  private int tlG;
  private a tlr;
  private View tls;
  private ChatFooterPanel tlz;
  private LuckyMoneyAutoScrollView tmQ;
  private TextView tmR;
  private LinearLayout tnA;
  private MMAnimateView tnB;
  private LinearLayout tnC;
  private String tnD;
  private boolean tnE;
  private int tnF;
  private int tnG;
  private EmojiInfo tnH;
  private av tnI;
  private com.tencent.mm.g.b.a.aw tnJ;
  private int tnK;
  private int tnL;
  private int tnM;
  private int tnN;
  private int tnO;
  private int tnP;
  private long tnQ;
  private String tnR;
  private int tnS;
  private com.tencent.mm.emoji.c.a tnT;
  private String tnU;
  private ImageView tne;
  private View tnf;
  private BaseEmojiView tng;
  private View tns;
  private View tnt;
  private TextView tnu;
  private ImageView tnv;
  private TextView tnw;
  private ImageView tnx;
  private ImageView tny;
  private TextView tnz;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.tnE = true;
    this.tnF = 0;
    this.tfs = 0;
    this.tnG = 0;
    this.mHandler = new ap();
    this.tnK = 1;
    this.tlG = 0;
    this.tnL = 0;
    this.tnM = 0;
    this.tnN = 0;
    this.tnO = 0;
    this.tnP = 0;
    this.tnQ = 0L;
    this.tka = "";
    this.tnR = "";
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        if (paramAnonymousView.getId() == 2131301874)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
          LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301876)
        {
          LuckyMoneyNewYearSendUI.this.finish();
          com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new av());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dMW = 11L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aBj();
          LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65693);
          return;
        }
        if ((paramAnonymousView.getId() == 2131301863) || (paramAnonymousView.getId() == 2131301868))
        {
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new av());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dMW = 3L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aBj();
          LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301865)
        {
          LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
          LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fnu, "");
          com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new av());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dMW = 5L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aBj();
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301871)
        {
          paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
          paramAnonymousView.hasCallBack = false;
          paramAnonymousView.tjK.setVisibility(0);
          paramAnonymousView.tjL.setVisibility(0);
          paramAnonymousView.tjM.setVisibility(0);
          paramAnonymousView.tjQ.setVisibility(4);
          paramAnonymousView.tjR.setVisibility(4);
          paramAnonymousView.tjS.setVisibility(4);
          LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
          com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new av());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dMW = 2L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aBj();
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301872)
        {
          paramAnonymousView = i.fSK;
          i.lt(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301862) {
          LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
        }
        AppMethodBeat.o(65693);
      }
    };
    this.tnS = 0;
    this.tnT = new LuckyMoneyNewYearSendUI.4(this);
    this.dvA = 0;
    this.tnU = "";
    AppMethodBeat.o(65703);
  }
  
  private void Gd(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.tnJ = new com.tencent.mm.g.b.a.aw();
    this.tnJ.dHq = paramInt;
    this.tnJ.dMX = this.tnK;
    this.tnJ.dMY = this.tnL;
    this.tnJ.dMZ = this.tnM;
    this.tnJ.dNa = this.tnN;
    this.tnJ.dNd = this.tnO;
    this.tnJ.dNb = this.tnP;
    com.tencent.mm.g.b.a.aw localaw = this.tnJ;
    if (this.oBl == null) {}
    for (String str = "";; str = this.oBl.JS())
    {
      localaw.hM(str);
      this.tnJ.aBj();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void Ge(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (bt.iY(this.tfs, 0))
    {
      this.tne.setVisibility(0);
      this.tnt.setVisibility(8);
      this.tnf.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.tne.setVisibility(8);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.tnt.setVisibility(0);
      this.tnu.setText(2131760824);
      this.tnf.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.tnt.setVisibility(8);
      this.tnf.setVisibility(0);
      this.tnx.setVisibility(0);
      this.tng.setVisibility(8);
      this.tny.setVisibility(8);
      this.tnz.setVisibility(8);
      this.tnA.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.tnH != null)
      {
        this.tnI = new av();
        this.tnI.dMW = 4L;
        this.tnI.aBj();
      }
      this.tnH = this.oBl;
      if (this.tlG == 0) {
        if (com.tencent.mm.plugin.emoji.h.b.y(this.oBl)) {
          this.tnK = 2;
        }
      }
      for (;;)
      {
        this.tnt.setVisibility(8);
        this.tnf.setVisibility(0);
        this.tnx.setVisibility(8);
        this.tng.setVisibility(0);
        this.tny.setVisibility(0);
        this.tnz.setVisibility(8);
        this.tnA.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (com.tencent.mm.plugin.emoji.h.b.w(this.oBl))
        {
          this.tnK = 4;
        }
        else
        {
          this.tnK = 3;
          continue;
          if (this.tlG == 1)
          {
            this.tnK = 2;
            this.tnM += 1;
          }
          else if (this.tlG == 2)
          {
            if (com.tencent.mm.plugin.emoji.h.b.y(this.oBl))
            {
              this.tnK = 2;
              this.tnP += 1;
            }
            else if (com.tencent.mm.plugin.emoji.h.b.w(this.oBl))
            {
              this.tnK = 4;
              this.tnO += 1;
            }
            else
            {
              this.tnK = 3;
              this.tnN += 1;
            }
          }
        }
      }
      this.tnt.setVisibility(8);
      this.tnf.setVisibility(0);
      this.tnx.setVisibility(8);
      this.tng.setVisibility(8);
      this.tny.setVisibility(8);
      this.tnz.setVisibility(0);
      this.tnA.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.tnt.setVisibility(8);
      this.tnf.setVisibility(0);
      this.tnx.setVisibility(8);
      this.tng.setVisibility(8);
      this.tny.setVisibility(8);
      this.tnz.setVisibility(8);
      this.tnA.setVisibility(0);
      this.tnB.setImageResource(2131690763);
      AppMethodBeat.o(65711);
      return;
      this.tnt.setVisibility(0);
      this.tnu.setText(2131760903);
      this.tnf.setVisibility(8);
    }
  }
  
  private void Gf(int paramInt)
  {
    AppMethodBeat.i(65712);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    for (;;)
    {
      String str2 = com.tencent.mm.model.u.aqG();
      String str1 = "";
      int i = 0;
      if (this.oBl != null)
      {
        str1 = this.oBl.JS();
        i = this.oBl.field_type;
      }
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.tnR, Integer.valueOf(paramInt), Integer.valueOf(this.dvA), this.tka });
      doSceneProgress(new ar(this.tfl, this.tfj, z.afo(str2), this.tnD, str2, com.tencent.mm.model.u.aqI(), this.tgM, str1, i, this.tnR, paramInt, this.dvA, this.tka), false);
      AppMethodBeat.o(65712);
      return;
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65698);
          if ((LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this) != null) && (LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this).isShowing())) {
            LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this).dismiss();
          }
          if ((LuckyMoneyNewYearSendUI.q(LuckyMoneyNewYearSendUI.this).getVisibility() == 8) || (LuckyMoneyNewYearSendUI.r(LuckyMoneyNewYearSendUI.this).getVisibility() == 4))
          {
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearSendUI.this.finish();
          }
          LuckyMoneyNewYearSendUI.this.tjY.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
  }
  
  private void afw(String paramString)
  {
    AppMethodBeat.i(65710);
    this.oBl = k.getEmojiStorageMgr().FyY.aJx(paramString);
    this.tng.setEmojiInfo(this.oBl);
    Ge(2);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fnu, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void cMD()
  {
    AppMethodBeat.i(65709);
    this.tnI = new av();
    this.tnI.dMW = 10L;
    this.tnI.aBj();
    this.tlG = 2;
    this.tlr.show();
    if (bt.iY(this.tnF, 1)) {}
    for (int i = ChatFooterPanel.BVc;; i = ChatFooterPanel.BUZ)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.tlB, this.tlz, i, new z.a()
      {
        public final void a(p paramAnonymousp)
        {
          AppMethodBeat.i(65694);
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousp });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymousp);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65694);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(201267);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(201267);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void cME()
  {
    AppMethodBeat.i(65713);
    this.tnL += 1;
    int i;
    if ((this.tfv != null) && (this.tfv.size() > 0))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      i = com.tencent.mm.kernel.a.getUin();
      int j = this.tfv.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.tnG = i;
      if ((this.tnG >= 0) && (this.tnG < this.tfv.size()))
      {
        this.tfl = ((w)this.tfv.get(this.tnG)).teD;
        this.tfj = ((w)this.tfv.get(this.tnG)).teE;
      }
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.tnG + " randomAmount:" + this.tfl + " randomWishing:" + this.tfj);
      this.tmQ.setFinalText(com.tencent.mm.wallet_core.ui.e.D(this.tfl / 100.0D));
      mP(false);
      this.tmQ.setFocusable(false);
      this.tmQ.setContentDescription("");
      this.tmQ.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void cMk()
        {
          AppMethodBeat.i(65700);
          if (LuckyMoneyNewYearSendUI.s(LuckyMoneyNewYearSendUI.this))
          {
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).setVisibility(4);
            z.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65699);
                LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).setVisibility(0);
                AppMethodBeat.o(65699);
              }
            });
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).startAnimation(localAlphaAnimation);
            LuckyMoneyNewYearSendUI.v(LuckyMoneyNewYearSendUI.this);
          }
          for (;;)
          {
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
            LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this).setFocusable(true);
            LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this).setContentDescription(LuckyMoneyNewYearSendUI.w(LuckyMoneyNewYearSendUI.this) / 100.0D);
            AppMethodBeat.o(65700);
            return;
            z.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).invalidate();
          }
        }
      });
      AppMethodBeat.o(65713);
      return;
      ad.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
  }
  
  private void mP(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.oHj.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.oHj.getBackground() != null) && (this.oHj.getBackground().mutate() != null)) {
        this.oHj.getBackground().mutate().setAlpha(255);
      }
      this.oHj.setTextColor(getResources().getColor(2131100594));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.oHj.getBackground() != null) && (this.oHj.getBackground().mutate() != null)) {
      this.oHj.getBackground().mutate().setAlpha(128);
    }
    this.oHj.setTextColor(getResources().getColor(2131100595));
    AppMethodBeat.o(65714);
  }
  
  public int getLayoutId()
  {
    return 2131494651;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65706);
    setActionbarColor(-839716110);
    setContentViewVisibility(8);
    this.tns = findViewById(2131301890);
    this.tmR = ((TextView)findViewById(2131301717));
    this.tmQ = ((LuckyMoneyAutoScrollView)findViewById(2131301860));
    this.swB = ((TextView)findViewById(2131301877));
    this.oHj = ((Button)findViewById(2131301874));
    this.oHj.setOnClickListener(this.iAw);
    ((ImageView)findViewById(2131301876)).setOnClickListener(this.iAw);
    this.tne = ((ImageView)findViewById(2131301869));
    this.tnt = findViewById(2131301867);
    this.tnu = ((TextView)findViewById(2131301868));
    this.tnv = ((ImageView)findViewById(2131301863));
    this.tnv.setOnClickListener(this.iAw);
    this.tnw = ((TextView)findViewById(2131301868));
    this.tnw.setOnClickListener(this.iAw);
    this.tnf = findViewById(2131301866);
    this.tng = ((BaseEmojiView)findViewById(2131301862));
    this.tng.setOnClickListener(this.iAw);
    this.tny = ((ImageView)findViewById(2131301865));
    this.tny.setOnClickListener(this.iAw);
    this.tnx = ((ImageView)findViewById(2131301864));
    this.tnz = ((TextView)findViewById(2131301872));
    this.tnz.setOnClickListener(this.iAw);
    this.tnA = ((LinearLayout)findViewById(2131301861));
    this.tnB = ((MMAnimateView)findViewById(2131301501));
    this.tnC = ((LinearLayout)findViewById(2131301871));
    this.tnC.setOnClickListener(this.iAw);
    this.tlr = new a(this);
    this.tls = getLayoutInflater().inflate(2131494640, null);
    this.tlr.setContentView(this.tls, new ViewGroup.LayoutParams(-1, -1));
    this.tls.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65688);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65688);
      }
    });
    this.tlr.tjq = new a.a()
    {
      public final void cMh()
      {
        AppMethodBeat.i(65692);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65692);
      }
    };
    this.tlB = ((ViewGroup)this.tls.findViewById(2131301798));
    this.tlz = com.tencent.mm.pluginsdk.ui.chat.e.Cgj.es(getContext());
    this.tlz.setTalkerName(this.tnD);
    this.tlz.setShowSmiley(false);
    AppMethodBeat.o(65706);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65716);
    Object localObject1;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(65716);
      return;
    case 1: 
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        if ((paramIntent == null) || (!paramIntent.hasExtra("key_realname_guide_helper"))) {
          break label824;
        }
        localObject1 = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
        if (localObject1 == null) {
          break label824;
        }
        if (!((RealnameGuideHelper)localObject1).b(this, null, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65690);
            LuckyMoneyNewYearSendUI.this.finish();
            AppMethodBeat.o(65690);
          }
        })) {
          paramInt1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.oBl == null)
      {
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = bw.K(this.tgQ, "msg");
        if (localObject1 == null)
        {
          ad.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65716);
          return;
          paramInt1 = 0;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            int i = this.tgQ.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.tgQ.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.oBl != null) {
                break label361;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (bg)localObject1, 0);
              localObject1 = new StringBuilder(this.tgQ.substring(0, i));
              String str = this.tgQ.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.tgQ = ((StringBuilder)localObject1).toString();
            }
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label361:
          localObject2 = this.oBl;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afm((String)localObject2))
      {
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.tgQ });
        z.V(this.tgQ, this.tnD, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.tnI = new av();
        if (this.tnK != 1) {
          break label566;
        }
        this.tnI.dMW = 8L;
        label468:
        this.tnI.aBj();
        Gd(1);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.u.aqG();
        if (paramInt2 != -1) {
          break label640;
        }
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.dvA = 1;
        this.tnU = "";
        paramIntent = new an(this.tka, this.tnR, 1, (String)localObject2, bt.nullAsNil(this.tnD));
        com.tencent.mm.kernel.g.afA().gcy.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        ad.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label566:
        if (this.tnK == 2)
        {
          this.tnI.dMW = 6L;
          break label468;
        }
        if (this.tnK == 3)
        {
          this.tnI.dMW = 7L;
          break label468;
        }
        if (this.tnK != 4) {
          break label468;
        }
        this.tnI.dMW = 14L;
        break label468;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label640:
      if (paramIntent != null) {}
      for (this.dvA = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dvA = 3)
      {
        this.tnU = this.tka;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dvA) });
        paramIntent = new an(this.tka, this.tnR, this.dvA, (String)localObject2, bt.nullAsNil(this.tnD));
        break;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.tnQ = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!bt.aw(this.tnQ, 0L))
        {
          Ge(4);
          mP(false);
          paramIntent = com.tencent.mm.emoji.c.b.fSs;
          com.tencent.mm.emoji.c.b.a(this.tnQ, this.tnT);
          AppMethodBeat.o(65716);
          return;
        }
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(65716);
        return;
      }
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
      break;
      label824:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65707);
    Gd(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.tnD = getIntent().getStringExtra("key_username");
    this.tgM = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (bt.isNullOrNil(this.tnD))
    {
      ad.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new ai("v1.0", ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsj, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(65704);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.tlz != null)
    {
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.tlz.onPause();
      this.tlz.exm();
      this.tlz.destroy();
    }
    com.tencent.mm.emoji.c.b localb = com.tencent.mm.emoji.c.b.fSs;
    com.tencent.mm.emoji.c.b.b(this.tnQ, this.tnT);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(65715);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        this.tfl = paramString.tfl;
        this.tfj = paramString.tfj;
        this.tnF = paramString.tfr;
        this.tfs = paramString.tfs;
        this.tnR = paramString.drI;
        this.tfv = paramString.tfv;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.tnF) });
        cME();
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.tfv != null) && (this.tfv.size() > 0))
        {
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.tnC.setVisibility(0);
          this.swB.getLayoutParams();
          this.swB.setTextSize(1, 21.0F);
          this.tmR.setTextSize(1, 15.0F);
          this.tmQ.fZ(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.tmQ.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.tmQ.setLayoutParams(paramString);
          this.tmQ.invalidate();
          paramString = (LinearLayout.LayoutParams)this.tnC.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166520);
          this.tnC.setLayoutParams(paramString);
          this.tnC.invalidate();
          paramString = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnu, "");
          if (!bt.isNullOrNil(paramString)) {
            break label407;
          }
          Ge(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          z.a(this.tns, null);
          AppMethodBeat.o(65715);
          return true;
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.tnC.setVisibility(8);
          break;
          label407:
          afw(paramString);
        }
      }
      finish();
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(65715);
        return false;
        if ((paramn instanceof aq))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (aq)paramn;
            this.tgQ = paramString.tfE;
            paramn = new PayInfo();
            paramn.dcE = paramString.rcq;
            paramn.dtb = 37;
            paramn.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          ad.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        else
        {
          if (!(paramn instanceof ar)) {
            break;
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (ar)paramn;
            this.tgQ = paramString.tfE;
            this.tka = paramString.sZn;
            if (paramString.isJumpRemind())
            {
              ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
              {
                public final void bm(int paramAnonymousInt, String paramAnonymousString)
                {
                  AppMethodBeat.i(65701);
                  ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                  if ((bt.iY(paramAnonymousInt, 2)) && (bt.kU(paramAnonymousString, "requestwxhb")))
                  {
                    LuckyMoneyNewYearSendUI.x(LuckyMoneyNewYearSendUI.this);
                    AppMethodBeat.o(65701);
                    return;
                  }
                  if (bt.iY(paramAnonymousInt, 1)) {
                    com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyNewYearSendUI.this, paramAnonymousString, 0, true);
                  }
                  AppMethodBeat.o(65701);
                }
                
                public final void onCancel()
                {
                  AppMethodBeat.i(65702);
                  ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                  AppMethodBeat.o(65702);
                }
              });
              AppMethodBeat.o(65715);
              return true;
            }
            paramn = new PayInfo();
            paramn.dcE = paramString.rcq;
            paramn.dtb = 37;
            paramn.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          if (paramInt2 == 268502454)
          {
            com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(65689);
                if (aq.k(paramn))
                {
                  LuckyMoneyNewYearSendUI.this.finish();
                  AppMethodBeat.o(65689);
                  return;
                }
                AppMethodBeat.o(65689);
              }
            });
            AppMethodBeat.o(65715);
            return true;
          }
          ad.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
      }
    } while (!(paramn instanceof an));
    AppMethodBeat.o(65715);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI
 * JD-Core Version:    0.7.0.1
 */