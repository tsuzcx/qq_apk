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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.c.i;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.g.c.bh;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ab;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.c.m;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private int dtm;
  private View.OnClickListener jax;
  private int mChannel;
  private ao mHandler;
  private EmojiInfo peL;
  private Button pkJ;
  private TextView tEq;
  private Dialog tipDialog;
  private int unA;
  private int unH;
  private LinkedList<w> unK;
  private String uny;
  private int upb;
  private String upf;
  private String ust;
  private a utK;
  private View utL;
  private ChatFooterPanel utS;
  private ViewGroup utU;
  private int utZ;
  private View uvL;
  private View uvM;
  private TextView uvN;
  private ImageView uvO;
  private TextView uvP;
  private ImageView uvQ;
  private ImageView uvR;
  private TextView uvS;
  private LinearLayout uvT;
  private MMAnimateView uvU;
  private LinearLayout uvV;
  private String uvW;
  private boolean uvX;
  private int uvY;
  private int uvZ;
  private LuckyMoneyAutoScrollView uvj;
  private TextView uvk;
  private ImageView uvx;
  private View uvy;
  private BaseEmojiView uvz;
  private EmojiInfo uwa;
  private com.tencent.mm.g.b.a.bv uwb;
  private bw uwc;
  private int uwd;
  private int uwe;
  private int uwf;
  private int uwg;
  private int uwh;
  private int uwi;
  private long uwj;
  private String uwk;
  private int uwl;
  private com.tencent.mm.emoji.c.a uwm;
  private String uwn;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.uvX = true;
    this.uvY = 0;
    this.unH = 0;
    this.uvZ = 0;
    this.mHandler = new ao();
    this.uwd = 1;
    this.utZ = 0;
    this.uwe = 0;
    this.uwf = 0;
    this.uwg = 0;
    this.uwh = 0;
    this.uwi = 0;
    this.uwj = 0L;
    this.ust = "";
    this.uwk = "";
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        if (paramAnonymousView.getId() == 2131301874)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
          LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301876)
        {
          LuckyMoneyNewYearSendUI.this.finish();
          com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new com.tencent.mm.g.b.a.bv());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dNx = 11L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aHZ();
          LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65693);
          return;
        }
        if ((paramAnonymousView.getId() == 2131301863) || (paramAnonymousView.getId() == 2131301868))
        {
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new com.tencent.mm.g.b.a.bv());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dNx = 3L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aHZ();
          LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301865)
        {
          LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
          LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLj, "");
          com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new com.tencent.mm.g.b.a.bv());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dNx = 5L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aHZ();
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301871)
        {
          paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
          paramAnonymousView.hasCallBack = false;
          paramAnonymousView.usd.setVisibility(0);
          paramAnonymousView.use.setVisibility(0);
          paramAnonymousView.usf.setVisibility(0);
          paramAnonymousView.usj.setVisibility(4);
          paramAnonymousView.usk.setVisibility(4);
          paramAnonymousView.usl.setVisibility(4);
          LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
          com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new com.tencent.mm.g.b.a.bv());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).dNx = 2L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aHZ();
          AppMethodBeat.o(65693);
          return;
        }
        if (paramAnonymousView.getId() == 2131301872)
        {
          paramAnonymousView = i.fWF;
          i.oW(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
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
    this.uwl = 0;
    this.uwm = new LuckyMoneyNewYearSendUI.4(this);
    this.dtm = 0;
    this.uwn = "";
    AppMethodBeat.o(65703);
  }
  
  private void HY(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.uwc = new bw();
    this.uwc.dFd = paramInt;
    this.uwc.dNy = this.uwd;
    this.uwc.dNz = this.uwe;
    this.uwc.dNA = this.uwf;
    this.uwc.dNB = this.uwg;
    this.uwc.dNE = this.uwh;
    this.uwc.dNC = this.uwi;
    bw localbw = this.uwc;
    if (this.peL == null) {}
    for (String str = "";; str = this.peL.JC())
    {
      localbw.jQ(str);
      this.uwc.aHZ();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void HZ(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (bs.jl(this.unH, 0))
    {
      this.uvx.setVisibility(0);
      this.uvM.setVisibility(8);
      this.uvy.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.uvx.setVisibility(8);
    ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.uvM.setVisibility(0);
      this.uvN.setText(2131760824);
      this.uvy.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.uvM.setVisibility(8);
      this.uvy.setVisibility(0);
      this.uvQ.setVisibility(0);
      this.uvz.setVisibility(8);
      this.uvR.setVisibility(8);
      this.uvS.setVisibility(8);
      this.uvT.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.uwa != null)
      {
        this.uwb = new com.tencent.mm.g.b.a.bv();
        this.uwb.dNx = 4L;
        this.uwb.aHZ();
      }
      this.uwa = this.peL;
      if (this.utZ == 0) {
        if (com.tencent.mm.plugin.emoji.h.b.y(this.peL)) {
          this.uwd = 2;
        }
      }
      for (;;)
      {
        this.uvM.setVisibility(8);
        this.uvy.setVisibility(0);
        this.uvQ.setVisibility(8);
        this.uvz.setVisibility(0);
        this.uvR.setVisibility(0);
        this.uvS.setVisibility(8);
        this.uvT.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (com.tencent.mm.plugin.emoji.h.b.w(this.peL))
        {
          this.uwd = 4;
        }
        else
        {
          this.uwd = 3;
          continue;
          if (this.utZ == 1)
          {
            this.uwd = 2;
            this.uwf += 1;
          }
          else if (this.utZ == 2)
          {
            if (com.tencent.mm.plugin.emoji.h.b.y(this.peL))
            {
              this.uwd = 2;
              this.uwi += 1;
            }
            else if (com.tencent.mm.plugin.emoji.h.b.w(this.peL))
            {
              this.uwd = 4;
              this.uwh += 1;
            }
            else
            {
              this.uwd = 3;
              this.uwg += 1;
            }
          }
        }
      }
      this.uvM.setVisibility(8);
      this.uvy.setVisibility(0);
      this.uvQ.setVisibility(8);
      this.uvz.setVisibility(8);
      this.uvR.setVisibility(8);
      this.uvS.setVisibility(0);
      this.uvT.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.uvM.setVisibility(8);
      this.uvy.setVisibility(0);
      this.uvQ.setVisibility(8);
      this.uvz.setVisibility(8);
      this.uvR.setVisibility(8);
      this.uvS.setVisibility(8);
      this.uvT.setVisibility(0);
      this.uvU.setImageResource(2131690763);
      AppMethodBeat.o(65711);
      return;
      this.uvM.setVisibility(0);
      this.uvN.setText(2131760903);
      this.uvy.setVisibility(8);
    }
  }
  
  private void Ia(int paramInt)
  {
    AppMethodBeat.i(65712);
    ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    for (;;)
    {
      String str2 = com.tencent.mm.model.u.axw();
      String str1 = "";
      int i = 0;
      if (this.peL != null)
      {
        str1 = this.peL.JC();
        i = this.peL.field_type;
      }
      ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.uwk, Integer.valueOf(paramInt), Integer.valueOf(this.dtm), this.ust });
      doSceneProgress(new ar(this.unA, this.uny, z.aki(str2), this.uvW, str2, com.tencent.mm.model.u.axy(), this.upb, str1, i, this.uwk, paramInt, this.dtm, this.ust), false);
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
            ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearSendUI.this.finish();
          }
          LuckyMoneyNewYearSendUI.this.usr.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
  }
  
  private void akq(String paramString)
  {
    AppMethodBeat.i(65710);
    this.peL = k.getEmojiStorageMgr().GXZ.aOT(paramString);
    this.uvz.setEmojiInfo(this.peL);
    HZ(2);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLj, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void daj()
  {
    AppMethodBeat.i(65709);
    this.uwb = new com.tencent.mm.g.b.a.bv();
    this.uwb.dNx = 10L;
    this.uwb.aHZ();
    this.utZ = 2;
    this.utK.show();
    if (bs.jl(this.uvY, 1)) {}
    for (int i = ChatFooterPanel.Dns;; i = ChatFooterPanel.Dnp)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.utU, this.utS, i, new z.a()
      {
        public final void a(p paramAnonymousp)
        {
          AppMethodBeat.i(65694);
          ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousp });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymousp);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65694);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(210292);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(210292);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void dak()
  {
    AppMethodBeat.i(65713);
    this.uwe += 1;
    int i;
    if ((this.unK != null) && (this.unK.size() > 0))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      i = com.tencent.mm.kernel.a.getUin();
      int j = this.unK.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.uvZ = i;
      if ((this.uvZ >= 0) && (this.uvZ < this.unK.size()))
      {
        this.unA = ((w)this.unK.get(this.uvZ)).umS;
        this.uny = ((w)this.unK.get(this.uvZ)).umT;
      }
      ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.uvZ + " randomAmount:" + this.unA + " randomWishing:" + this.uny);
      this.uvj.setFinalText(com.tencent.mm.wallet_core.ui.e.C(this.unA / 100.0D));
      nH(false);
      this.uvj.setFocusable(false);
      this.uvj.setContentDescription("");
      this.uvj.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void cZQ()
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
      ac.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
  }
  
  private void nH(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.pkJ.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.pkJ.getBackground() != null) && (this.pkJ.getBackground().mutate() != null)) {
        this.pkJ.getBackground().mutate().setAlpha(255);
      }
      this.pkJ.setTextColor(getResources().getColor(2131100594));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.pkJ.getBackground() != null) && (this.pkJ.getBackground().mutate() != null)) {
      this.pkJ.getBackground().mutate().setAlpha(128);
    }
    this.pkJ.setTextColor(getResources().getColor(2131100595));
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
    this.uvL = findViewById(2131301890);
    this.uvk = ((TextView)findViewById(2131301717));
    this.uvj = ((LuckyMoneyAutoScrollView)findViewById(2131301860));
    this.tEq = ((TextView)findViewById(2131301877));
    this.pkJ = ((Button)findViewById(2131301874));
    this.pkJ.setOnClickListener(this.jax);
    ((ImageView)findViewById(2131301876)).setOnClickListener(this.jax);
    this.uvx = ((ImageView)findViewById(2131301869));
    this.uvM = findViewById(2131301867);
    this.uvN = ((TextView)findViewById(2131301868));
    this.uvO = ((ImageView)findViewById(2131301863));
    this.uvO.setOnClickListener(this.jax);
    this.uvP = ((TextView)findViewById(2131301868));
    this.uvP.setOnClickListener(this.jax);
    this.uvy = findViewById(2131301866);
    this.uvz = ((BaseEmojiView)findViewById(2131301862));
    this.uvz.setOnClickListener(this.jax);
    this.uvR = ((ImageView)findViewById(2131301865));
    this.uvR.setOnClickListener(this.jax);
    this.uvQ = ((ImageView)findViewById(2131301864));
    this.uvS = ((TextView)findViewById(2131301872));
    this.uvS.setOnClickListener(this.jax);
    this.uvT = ((LinearLayout)findViewById(2131301861));
    this.uvU = ((MMAnimateView)findViewById(2131301501));
    this.uvV = ((LinearLayout)findViewById(2131301871));
    this.uvV.setOnClickListener(this.jax);
    this.utK = new a(this);
    this.utL = getLayoutInflater().inflate(2131494640, null);
    this.utK.setContentView(this.utL, new ViewGroup.LayoutParams(-1, -1));
    this.utL.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65688);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65688);
      }
    });
    this.utK.urJ = new a.a()
    {
      public final void cZN()
      {
        AppMethodBeat.i(65692);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65692);
      }
    };
    this.utU = ((ViewGroup)this.utL.findViewById(2131301798));
    this.utS = com.tencent.mm.pluginsdk.ui.chat.e.DyA.eA(getContext());
    this.utS.setTalkerName(this.uvW);
    this.utS.setShowSmiley(false);
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
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
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
      if (this.peL == null)
      {
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = com.tencent.mm.sdk.platformtools.bv.L(this.upf, "msg");
        if (localObject1 == null)
        {
          ac.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
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
            int i = this.upf.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.upf.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.peL != null) {
                break label361;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (bh)localObject1, 0);
              localObject1 = new StringBuilder(this.upf.substring(0, i));
              String str = this.upf.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.upf = ((StringBuilder)localObject1).toString();
            }
            ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label361:
          localObject2 = this.peL;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akg((String)localObject2))
      {
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.upf });
        z.W(this.upf, this.uvW, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.uwb = new com.tencent.mm.g.b.a.bv();
        if (this.uwd != 1) {
          break label566;
        }
        this.uwb.dNx = 8L;
        label468:
        this.uwb.aHZ();
        HY(1);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.u.axw();
        if (paramInt2 != -1) {
          break label640;
        }
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.dtm = 1;
        this.uwn = "";
        paramIntent = new an(this.ust, this.uwk, 1, (String)localObject2, bs.nullAsNil(this.uvW));
        com.tencent.mm.kernel.g.agQ().ghe.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        ac.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label566:
        if (this.uwd == 2)
        {
          this.uwb.dNx = 6L;
          break label468;
        }
        if (this.uwd == 3)
        {
          this.uwb.dNx = 7L;
          break label468;
        }
        if (this.uwd != 4) {
          break label468;
        }
        this.uwb.dNx = 14L;
        break label468;
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label640:
      if (paramIntent != null) {}
      for (this.dtm = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dtm = 3)
      {
        this.uwn = this.ust;
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dtm) });
        paramIntent = new an(this.ust, this.uwk, this.dtm, (String)localObject2, bs.nullAsNil(this.uvW));
        break;
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.uwj = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!bs.av(this.uwj, 0L))
        {
          HZ(4);
          nH(false);
          paramIntent = com.tencent.mm.emoji.c.b.fWn;
          com.tencent.mm.emoji.c.b.a(this.uwj, this.uwm);
          AppMethodBeat.o(65716);
          return;
        }
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(65716);
        return;
      }
      ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
      break;
      label824:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65707);
    HY(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.uvW = getIntent().getStringExtra("key_username");
    this.upb = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (bs.isNullOrNil(this.uvW))
    {
      ac.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new ai("v1.0", ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQa, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(65704);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.utS != null)
    {
      ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.utS.onPause();
      this.utS.eMG();
      this.utS.destroy();
    }
    com.tencent.mm.emoji.c.b localb = com.tencent.mm.emoji.c.b.fWn;
    com.tencent.mm.emoji.c.b.b(this.uwj, this.uwm);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(65715);
    ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        this.unA = paramString.unA;
        this.uny = paramString.uny;
        this.uvY = paramString.unG;
        this.unH = paramString.unH;
        this.uwk = paramString.dpt;
        this.unK = paramString.unK;
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.uvY) });
        dak();
        ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.unK != null) && (this.unK.size() > 0))
        {
          ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.uvV.setVisibility(0);
          this.tEq.getLayoutParams();
          this.tEq.setTextSize(1, 21.0F);
          this.uvk.setTextSize(1, 15.0F);
          this.uvj.gg(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.uvj.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.uvj.setLayoutParams(paramString);
          this.uvj.invalidate();
          paramString = (LinearLayout.LayoutParams)this.uvV.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166520);
          this.uvV.setLayoutParams(paramString);
          this.uvV.invalidate();
          paramString = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLj, "");
          if (!bs.isNullOrNil(paramString)) {
            break label407;
          }
          HZ(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          z.a(this.uvL, null);
          AppMethodBeat.o(65715);
          return true;
          ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.uvV.setVisibility(8);
          break;
          label407:
          akq(paramString);
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
            ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (aq)paramn;
            this.upf = paramString.unT;
            paramn = new PayInfo();
            paramn.dac = paramString.skK;
            paramn.dqL = 37;
            paramn.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          ac.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
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
            ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (ar)paramn;
            this.upf = paramString.unT;
            this.ust = paramString.uhB;
            if (paramString.isJumpRemind())
            {
              ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
              {
                public final void br(int paramAnonymousInt, String paramAnonymousString)
                {
                  AppMethodBeat.i(65701);
                  ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                  if ((bs.jl(paramAnonymousInt, 2)) && (bs.lr(paramAnonymousString, "requestwxhb")))
                  {
                    LuckyMoneyNewYearSendUI.x(LuckyMoneyNewYearSendUI.this);
                    AppMethodBeat.o(65701);
                    return;
                  }
                  if (bs.jl(paramAnonymousInt, 1)) {
                    com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyNewYearSendUI.this, paramAnonymousString, 0, true);
                  }
                  AppMethodBeat.o(65701);
                }
                
                public final void onCancel()
                {
                  AppMethodBeat.i(65702);
                  ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                  AppMethodBeat.o(65702);
                }
              });
              AppMethodBeat.o(65715);
              return true;
            }
            paramn = new PayInfo();
            paramn.dac = paramString.skK;
            paramn.dqL = 37;
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
                if (aq.j(paramn))
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
          ac.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
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