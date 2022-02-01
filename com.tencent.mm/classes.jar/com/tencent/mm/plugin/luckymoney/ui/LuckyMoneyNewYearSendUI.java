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
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.g.c.bi;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ab;
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
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.wallet_core.c.m;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private int dFo;
  private View.OnClickListener jtG;
  private int mChannel;
  private ap mHandler;
  private EmojiInfo pIn;
  private Button pOj;
  private Dialog tipDialog;
  private TextView uGZ;
  private String vqe;
  private int vqg;
  private int vqn;
  private LinkedList<w> vqq;
  private int vrF;
  private String vrJ;
  private String vuW;
  private int vwC;
  private a vwn;
  private View vwo;
  private ChatFooterPanel vwv;
  private ViewGroup vwx;
  private LuckyMoneyAutoScrollView vxM;
  private TextView vxN;
  private boolean vyA;
  private int vyB;
  private int vyC;
  private EmojiInfo vyD;
  private cm vyE;
  private cn vyF;
  private int vyG;
  private int vyH;
  private int vyI;
  private int vyJ;
  private int vyK;
  private int vyL;
  private long vyM;
  private String vyN;
  private int vyO;
  private com.tencent.mm.emoji.c.a vyP;
  private String vyQ;
  private ImageView vya;
  private View vyb;
  private BaseEmojiView vyc;
  private View vyo;
  private View vyp;
  private TextView vyq;
  private ImageView vyr;
  private TextView vys;
  private ImageView vyt;
  private ImageView vyu;
  private TextView vyv;
  private LinearLayout vyw;
  private MMAnimateView vyx;
  private LinearLayout vyy;
  private String vyz;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.vyA = true;
    this.vyB = 0;
    this.vqn = 0;
    this.vyC = 0;
    this.mHandler = new ap();
    this.vyG = 1;
    this.vwC = 0;
    this.vyH = 0;
    this.vyI = 0;
    this.vyJ = 0;
    this.vyK = 0;
    this.vyL = 0;
    this.vyM = 0L;
    this.vuW = "";
    this.vyN = "";
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131301874)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
          LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65693);
          return;
          if (paramAnonymousView.getId() == 2131301876)
          {
            LuckyMoneyNewYearSendUI.this.finish();
            com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ecM = 11L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLk();
            LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          }
          else if ((paramAnonymousView.getId() == 2131301863) || (paramAnonymousView.getId() == 2131301868))
          {
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ecM = 3L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLk();
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
          else if (paramAnonymousView.getId() == 2131301865)
          {
            LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxB, "");
            com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ecM = 5L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLk();
          }
          else if (paramAnonymousView.getId() == 2131301871)
          {
            paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
            paramAnonymousView.hasCallBack = false;
            paramAnonymousView.vuG.setVisibility(0);
            paramAnonymousView.vuH.setVisibility(0);
            paramAnonymousView.vuI.setVisibility(0);
            paramAnonymousView.vuM.setVisibility(4);
            paramAnonymousView.vuN.setVisibility(4);
            paramAnonymousView.vuO.setVisibility(4);
            LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
            com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ecM = 2L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLk();
          }
          else if (paramAnonymousView.getId() == 2131301872)
          {
            paramAnonymousView = i.gqi;
            i.qW(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
          }
          else if (paramAnonymousView.getId() == 2131301862)
          {
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
        }
      }
    };
    this.vyO = 0;
    this.vyP = new LuckyMoneyNewYearSendUI.4(this);
    this.dFo = 0;
    this.vyQ = "";
    AppMethodBeat.o(65703);
  }
  
  private void Ju(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.vyF = new cn();
    this.vyF.dSa = paramInt;
    this.vyF.ecN = this.vyG;
    this.vyF.ecO = this.vyH;
    this.vyF.ecP = this.vyI;
    this.vyF.ecQ = this.vyJ;
    this.vyF.ecT = this.vyK;
    this.vyF.ecR = this.vyL;
    cn localcn = this.vyF;
    if (this.pIn == null) {}
    for (String str = "";; str = this.pIn.Lb())
    {
      localcn.lM(str);
      this.vyF.aLk();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void Jv(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (bt.jx(this.vqn, 0))
    {
      this.vya.setVisibility(0);
      this.vyp.setVisibility(8);
      this.vyb.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.vya.setVisibility(8);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.vyp.setVisibility(0);
      this.vyq.setText(2131760824);
      this.vyb.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.vyp.setVisibility(8);
      this.vyb.setVisibility(0);
      this.vyt.setVisibility(0);
      this.vyc.setVisibility(8);
      this.vyu.setVisibility(8);
      this.vyv.setVisibility(8);
      this.vyw.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.vyD != null)
      {
        this.vyE = new cm();
        this.vyE.ecM = 4L;
        this.vyE.aLk();
      }
      this.vyD = this.pIn;
      if (this.vwC == 0) {
        if (com.tencent.mm.plugin.emoji.h.b.y(this.pIn)) {
          this.vyG = 2;
        }
      }
      for (;;)
      {
        this.vyp.setVisibility(8);
        this.vyb.setVisibility(0);
        this.vyt.setVisibility(8);
        this.vyc.setVisibility(0);
        this.vyu.setVisibility(0);
        this.vyv.setVisibility(8);
        this.vyw.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (com.tencent.mm.plugin.emoji.h.b.w(this.pIn))
        {
          this.vyG = 4;
        }
        else
        {
          this.vyG = 3;
          continue;
          if (this.vwC == 1)
          {
            this.vyG = 2;
            this.vyI += 1;
          }
          else if (this.vwC == 2)
          {
            if (com.tencent.mm.plugin.emoji.h.b.y(this.pIn))
            {
              this.vyG = 2;
              this.vyL += 1;
            }
            else if (com.tencent.mm.plugin.emoji.h.b.w(this.pIn))
            {
              this.vyG = 4;
              this.vyK += 1;
            }
            else
            {
              this.vyG = 3;
              this.vyJ += 1;
            }
          }
        }
      }
      this.vyp.setVisibility(8);
      this.vyb.setVisibility(0);
      this.vyt.setVisibility(8);
      this.vyc.setVisibility(8);
      this.vyu.setVisibility(8);
      this.vyv.setVisibility(0);
      this.vyw.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.vyp.setVisibility(8);
      this.vyb.setVisibility(0);
      this.vyt.setVisibility(8);
      this.vyc.setVisibility(8);
      this.vyu.setVisibility(8);
      this.vyv.setVisibility(8);
      this.vyw.setVisibility(0);
      this.vyx.setImageResource(2131690763);
      AppMethodBeat.o(65711);
      return;
      this.vyp.setVisibility(0);
      this.vyq.setText(2131760903);
      this.vyb.setVisibility(8);
    }
  }
  
  private void Jw(int paramInt)
  {
    AppMethodBeat.i(65712);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    for (;;)
    {
      String str2 = com.tencent.mm.model.u.aAm();
      String str1 = "";
      int i = 0;
      if (this.pIn != null)
      {
        str1 = this.pIn.Lb();
        i = this.pIn.field_type;
      }
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.vyN, Integer.valueOf(paramInt), Integer.valueOf(this.dFo), this.vuW });
      doSceneProgress(new ar(this.vqg, this.vqe, z.aoV(str2), this.vyz, str2, com.tencent.mm.model.u.aAo(), this.vrF, str1, i, this.vyN, paramInt, this.dFo, this.vuW), false);
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
          LuckyMoneyNewYearSendUI.this.vuU.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
  }
  
  private void apd(String paramString)
  {
    AppMethodBeat.i(65710);
    this.pIn = k.getEmojiStorageMgr().ILn.aUK(paramString);
    this.vyc.setEmojiInfo(this.pIn);
    Jv(2);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxB, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void djw()
  {
    AppMethodBeat.i(65709);
    this.vyE = new cm();
    this.vyE.ecM = 10L;
    this.vyE.aLk();
    this.vwC = 2;
    this.vwn.show();
    if (bt.jx(this.vyB, 1)) {}
    for (int i = ChatFooterPanel.ESx;; i = ChatFooterPanel.ESu)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.vwx, this.vwv, i, new z.a()
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
          AppMethodBeat.i(221332);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(221332);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void djx()
  {
    AppMethodBeat.i(65713);
    this.vyH += 1;
    int i;
    if ((this.vqq != null) && (this.vqq.size() > 0))
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      i = com.tencent.mm.kernel.a.getUin();
      int j = this.vqq.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.vyC = i;
      if ((this.vyC >= 0) && (this.vyC < this.vqq.size()))
      {
        this.vqg = ((w)this.vqq.get(this.vyC)).vpy;
        this.vqe = ((w)this.vqq.get(this.vyC)).vpz;
      }
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.vyC + " randomAmount:" + this.vqg + " randomWishing:" + this.vqe);
      this.vxM.setFinalText(com.tencent.mm.wallet_core.ui.e.C(this.vqg / 100.0D));
      ob(false);
      this.vxM.setFocusable(false);
      this.vxM.setContentDescription("");
      this.vxM.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void djd()
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
  
  private void ob(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.pOj.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.pOj.getBackground() != null) && (this.pOj.getBackground().mutate() != null)) {
        this.pOj.getBackground().mutate().setAlpha(255);
      }
      this.pOj.setTextColor(getResources().getColor(2131100594));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.pOj.getBackground() != null) && (this.pOj.getBackground().mutate() != null)) {
      this.pOj.getBackground().mutate().setAlpha(128);
    }
    this.pOj.setTextColor(getResources().getColor(2131100595));
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
    this.vyo = findViewById(2131301890);
    this.vxN = ((TextView)findViewById(2131301717));
    this.vxM = ((LuckyMoneyAutoScrollView)findViewById(2131301860));
    this.uGZ = ((TextView)findViewById(2131301877));
    this.pOj = ((Button)findViewById(2131301874));
    this.pOj.setOnClickListener(this.jtG);
    ((ImageView)findViewById(2131301876)).setOnClickListener(this.jtG);
    this.vya = ((ImageView)findViewById(2131301869));
    this.vyp = findViewById(2131301867);
    this.vyq = ((TextView)findViewById(2131301868));
    this.vyr = ((ImageView)findViewById(2131301863));
    this.vyr.setOnClickListener(this.jtG);
    this.vys = ((TextView)findViewById(2131301868));
    this.vys.setOnClickListener(this.jtG);
    this.vyb = findViewById(2131301866);
    this.vyc = ((BaseEmojiView)findViewById(2131301862));
    this.vyc.setOnClickListener(this.jtG);
    this.vyu = ((ImageView)findViewById(2131301865));
    this.vyu.setOnClickListener(this.jtG);
    this.vyt = ((ImageView)findViewById(2131301864));
    this.vyv = ((TextView)findViewById(2131301872));
    this.vyv.setOnClickListener(this.jtG);
    this.vyw = ((LinearLayout)findViewById(2131301861));
    this.vyx = ((MMAnimateView)findViewById(2131301501));
    this.vyy = ((LinearLayout)findViewById(2131301871));
    this.vyy.setOnClickListener(this.jtG);
    this.vwn = new a(this);
    this.vwo = getLayoutInflater().inflate(2131494640, null);
    this.vwn.setContentView(this.vwo, new ViewGroup.LayoutParams(-1, -1));
    this.vwo.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65688);
      }
    });
    this.vwn.vum = new a.a()
    {
      public final void dja()
      {
        AppMethodBeat.i(65692);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65692);
      }
    };
    this.vwx = ((ViewGroup)this.vwo.findViewById(2131301798));
    this.vwv = com.tencent.mm.pluginsdk.ui.chat.e.FdJ.eA(getContext());
    this.vwv.setTalkerName(this.vyz);
    this.vwv.setShowSmiley(false);
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
        com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
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
      if (this.pIn == null)
      {
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = bw.M(this.vrJ, "msg");
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
            int i = this.vrJ.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.vrJ.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.pIn != null) {
                break label361;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (bi)localObject1, 0);
              localObject1 = new StringBuilder(this.vrJ.substring(0, i));
              String str = this.vrJ.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.vrJ = ((StringBuilder)localObject1).toString();
            }
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label361:
          localObject2 = this.pIn;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoT((String)localObject2))
      {
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.vrJ });
        z.Z(this.vrJ, this.vyz, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.vyE = new cm();
        if (this.vyG != 1) {
          break label566;
        }
        this.vyE.ecM = 8L;
        label468:
        this.vyE.aLk();
        Ju(1);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.u.aAm();
        if (paramInt2 != -1) {
          break label640;
        }
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.dFo = 1;
        this.vyQ = "";
        paramIntent = new an(this.vuW, this.vyN, 1, (String)localObject2, bt.nullAsNil(this.vyz));
        com.tencent.mm.kernel.g.ajB().gAO.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        ad.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label566:
        if (this.vyG == 2)
        {
          this.vyE.ecM = 6L;
          break label468;
        }
        if (this.vyG == 3)
        {
          this.vyE.ecM = 7L;
          break label468;
        }
        if (this.vyG != 4) {
          break label468;
        }
        this.vyE.ecM = 14L;
        break label468;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label640:
      if (paramIntent != null) {}
      for (this.dFo = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dFo = 3)
      {
        this.vyQ = this.vuW;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dFo) });
        paramIntent = new an(this.vuW, this.vyN, this.dFo, (String)localObject2, bt.nullAsNil(this.vyz));
        break;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.vyM = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!bt.aA(this.vyM, 0L))
        {
          Jv(4);
          ob(false);
          paramIntent = com.tencent.mm.emoji.c.b.gpQ;
          com.tencent.mm.emoji.c.b.a(this.vyM, this.vyP);
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
    Ju(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.vyz = getIntent().getStringExtra("key_username");
    this.vrF = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (bt.isNullOrNil(this.vyz))
    {
      ad.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ai("v1.0", ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICu, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(65704);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.vwv != null)
    {
      ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.vwv.onPause();
      this.vwv.fbE();
      this.vwv.destroy();
    }
    com.tencent.mm.emoji.c.b localb = com.tencent.mm.emoji.c.b.gpQ;
    com.tencent.mm.emoji.c.b.b(this.vyM, this.vyP);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(65715);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ai)paramn;
        this.vqg = paramString.vqg;
        this.vqe = paramString.vqe;
        this.vyB = paramString.vqm;
        this.vqn = paramString.vqn;
        this.vyN = paramString.dBg;
        this.vqq = paramString.vqq;
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.vyB) });
        djx();
        ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.vqq != null) && (this.vqq.size() > 0))
        {
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.vyy.setVisibility(0);
          this.uGZ.getLayoutParams();
          this.uGZ.setTextSize(1, 21.0F);
          this.vxN.setTextSize(1, 15.0F);
          this.vxM.gx(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.vxM.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.vxM.setLayoutParams(paramString);
          this.vxM.invalidate();
          paramString = (LinearLayout.LayoutParams)this.vyy.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166520);
          this.vyy.setLayoutParams(paramString);
          this.vyy.invalidate();
          paramString = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxB, "");
          if (!bt.isNullOrNil(paramString)) {
            break label407;
          }
          Jv(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          z.a(this.vyo, null);
          AppMethodBeat.o(65715);
          return true;
          ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.vyy.setVisibility(8);
          break;
          label407:
          apd(paramString);
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
            this.vrJ = paramString.vqz;
            paramn = new PayInfo();
            paramn.dlu = paramString.thm;
            paramn.dCC = 37;
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
            this.vrJ = paramString.vqz;
            this.vuW = paramString.vkl;
            if (paramString.isJumpRemind())
            {
              ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
              {
                public final void bv(int paramAnonymousInt, String paramAnonymousString)
                {
                  AppMethodBeat.i(65701);
                  ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                  if ((bt.jx(paramAnonymousInt, 2)) && (bt.lQ(paramAnonymousString, "requestwxhb")))
                  {
                    LuckyMoneyNewYearSendUI.x(LuckyMoneyNewYearSendUI.this);
                    AppMethodBeat.o(65701);
                    return;
                  }
                  if (bt.jx(paramAnonymousInt, 1)) {
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
            paramn.dlu = paramString.thm;
            paramn.dCC = 37;
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