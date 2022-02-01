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
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.g.c.bi;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
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
  private int dGt;
  private View.OnClickListener jwB;
  private int mChannel;
  private com.tencent.mm.sdk.platformtools.aq mHandler;
  private EmojiInfo pOS;
  private Button pUO;
  private Dialog tipDialog;
  private TextView uSM;
  private String vCj;
  private int vCl;
  private int vCs;
  private LinkedList<w> vCv;
  private int vDK;
  private String vDO;
  private String vHa;
  private ViewGroup vIB;
  private int vIG;
  private a vIr;
  private View vIs;
  private ChatFooterPanel vIz;
  private LuckyMoneyAutoScrollView vJQ;
  private TextView vJR;
  private LinearLayout vKA;
  private MMAnimateView vKB;
  private LinearLayout vKC;
  private String vKD;
  private boolean vKE;
  private int vKF;
  private int vKG;
  private EmojiInfo vKH;
  private cm vKI;
  private cn vKJ;
  private int vKK;
  private int vKL;
  private int vKM;
  private int vKN;
  private int vKO;
  private int vKP;
  private long vKQ;
  private String vKR;
  private int vKS;
  private com.tencent.mm.emoji.c.a vKT;
  private String vKU;
  private ImageView vKe;
  private View vKf;
  private BaseEmojiView vKg;
  private View vKs;
  private View vKt;
  private TextView vKu;
  private ImageView vKv;
  private TextView vKw;
  private ImageView vKx;
  private ImageView vKy;
  private TextView vKz;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.vKE = true;
    this.vKF = 0;
    this.vCs = 0;
    this.vKG = 0;
    this.mHandler = new com.tencent.mm.sdk.platformtools.aq();
    this.vKK = 1;
    this.vIG = 0;
    this.vKL = 0;
    this.vKM = 0;
    this.vKN = 0;
    this.vKO = 0;
    this.vKP = 0;
    this.vKQ = 0L;
    this.vHa = "";
    this.vKR = "";
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getId() == 2131301874)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
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
            com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eeh = 11L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLH();
            LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          }
          else if ((paramAnonymousView.getId() == 2131301863) || (paramAnonymousView.getId() == 2131301868))
          {
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eeh = 3L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLH();
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
          else if (paramAnonymousView.getId() == 2131301865)
          {
            LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IRZ, "");
            com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eeh = 5L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLH();
          }
          else if (paramAnonymousView.getId() == 2131301871)
          {
            paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
            paramAnonymousView.hasCallBack = false;
            paramAnonymousView.vGK.setVisibility(0);
            paramAnonymousView.vGL.setVisibility(0);
            paramAnonymousView.vGM.setVisibility(0);
            paramAnonymousView.vGQ.setVisibility(4);
            paramAnonymousView.vGR.setVisibility(4);
            paramAnonymousView.vGS.setVisibility(4);
            LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
            com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new cm());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eeh = 2L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).aLH();
          }
          else if (paramAnonymousView.getId() == 2131301872)
          {
            paramAnonymousView = i.gsD;
            i.rj(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
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
    this.vKS = 0;
    this.vKT = new com.tencent.mm.emoji.c.a()
    {
      public final void a(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        int j = 0;
        AppMethodBeat.i(65691);
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this)), Long.valueOf(paramAnonymousLong), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        if (bu.az(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this), paramAnonymousLong))
        {
          if (!paramAnonymousBoolean) {
            break label114;
          }
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymousString);
        }
        for (;;)
        {
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
          paramAnonymousString = com.tencent.mm.emoji.c.b.gsl;
          com.tencent.mm.emoji.c.b.b(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.A(LuckyMoneyNewYearSendUI.this));
          AppMethodBeat.o(65691);
          return;
          label114:
          if (bu.jB(LuckyMoneyNewYearSendUI.y(LuckyMoneyNewYearSendUI.this), 0))
          {
            paramAnonymousLong = LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this);
            paramAnonymousString = be.fvc().JfU.Eh(paramAnonymousLong);
            int i = j;
            if (paramAnonymousString != null)
            {
              i = j;
              if (paramAnonymousString.fxx() == EmojiInfo.a.Jiv)
              {
                paramAnonymousString = paramAnonymousString.fRh();
                switch (com.tencent.mm.plugin.emoji.h.b.1.pWF[paramAnonymousString.ordinal()])
                {
                }
              }
            }
            for (i = j; i != 0; i = 1)
            {
              LuckyMoneyNewYearSendUI.z(LuckyMoneyNewYearSendUI.this);
              LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 3);
              AppMethodBeat.o(65691);
              return;
            }
          }
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 5);
        }
      }
    };
    this.dGt = 0;
    this.vKU = "";
    AppMethodBeat.o(65703);
  }
  
  private void JT(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.vKJ = new cn();
    this.vKJ.dTq = paramInt;
    this.vKJ.eei = this.vKK;
    this.vKJ.eej = this.vKL;
    this.vKJ.eek = this.vKM;
    this.vKJ.eel = this.vKN;
    this.vKJ.eeo = this.vKO;
    this.vKJ.eem = this.vKP;
    cn localcn = this.vKJ;
    if (this.pOS == null) {}
    for (String str = "";; str = this.pOS.Lj())
    {
      localcn.md(str);
      this.vKJ.aLH();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void JU(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (bu.jB(this.vCs, 0))
    {
      this.vKe.setVisibility(0);
      this.vKt.setVisibility(8);
      this.vKf.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.vKe.setVisibility(8);
    ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.vKt.setVisibility(0);
      this.vKu.setText(2131760824);
      this.vKf.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.vKt.setVisibility(8);
      this.vKf.setVisibility(0);
      this.vKx.setVisibility(0);
      this.vKg.setVisibility(8);
      this.vKy.setVisibility(8);
      this.vKz.setVisibility(8);
      this.vKA.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.vKH != null)
      {
        this.vKI = new cm();
        this.vKI.eeh = 4L;
        this.vKI.aLH();
      }
      this.vKH = this.pOS;
      if (this.vIG == 0) {
        if (com.tencent.mm.plugin.emoji.h.b.y(this.pOS)) {
          this.vKK = 2;
        }
      }
      for (;;)
      {
        this.vKt.setVisibility(8);
        this.vKf.setVisibility(0);
        this.vKx.setVisibility(8);
        this.vKg.setVisibility(0);
        this.vKy.setVisibility(0);
        this.vKz.setVisibility(8);
        this.vKA.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (com.tencent.mm.plugin.emoji.h.b.w(this.pOS))
        {
          this.vKK = 4;
        }
        else
        {
          this.vKK = 3;
          continue;
          if (this.vIG == 1)
          {
            this.vKK = 2;
            this.vKM += 1;
          }
          else if (this.vIG == 2)
          {
            if (com.tencent.mm.plugin.emoji.h.b.y(this.pOS))
            {
              this.vKK = 2;
              this.vKP += 1;
            }
            else if (com.tencent.mm.plugin.emoji.h.b.w(this.pOS))
            {
              this.vKK = 4;
              this.vKO += 1;
            }
            else
            {
              this.vKK = 3;
              this.vKN += 1;
            }
          }
        }
      }
      this.vKt.setVisibility(8);
      this.vKf.setVisibility(0);
      this.vKx.setVisibility(8);
      this.vKg.setVisibility(8);
      this.vKy.setVisibility(8);
      this.vKz.setVisibility(0);
      this.vKA.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.vKt.setVisibility(8);
      this.vKf.setVisibility(0);
      this.vKx.setVisibility(8);
      this.vKg.setVisibility(8);
      this.vKy.setVisibility(8);
      this.vKz.setVisibility(8);
      this.vKA.setVisibility(0);
      this.vKB.setImageResource(2131690763);
      AppMethodBeat.o(65711);
      return;
      this.vKt.setVisibility(0);
      this.vKu.setText(2131760903);
      this.vKf.setVisibility(8);
    }
  }
  
  private void JV(int paramInt)
  {
    AppMethodBeat.i(65712);
    ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    for (;;)
    {
      String str2 = v.aAC();
      String str1 = "";
      int i = 0;
      if (this.pOS != null)
      {
        str1 = this.pOS.Lj();
        i = this.pOS.field_type;
      }
      ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.vKR, Integer.valueOf(paramInt), Integer.valueOf(this.dGt), this.vHa });
      doSceneProgress(new ar(this.vCl, this.vCj, z.aqa(str2), this.vKD, str2, v.aAE(), this.vDK, str1, i, this.vKR, paramInt, this.dGt, this.vHa), false);
      AppMethodBeat.o(65712);
      return;
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65698);
          if ((LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this) != null) && (LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this).isShowing())) {
            LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this).dismiss();
          }
          if ((LuckyMoneyNewYearSendUI.q(LuckyMoneyNewYearSendUI.this).getVisibility() == 8) || (LuckyMoneyNewYearSendUI.r(LuckyMoneyNewYearSendUI.this).getVisibility() == 4))
          {
            ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearSendUI.this.finish();
          }
          LuckyMoneyNewYearSendUI.this.vGY.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
  }
  
  private void aqi(String paramString)
  {
    AppMethodBeat.i(65710);
    this.pOS = k.getEmojiStorageMgr().JfU.aWl(paramString);
    this.vKg.setEmojiInfo(this.pOS);
    JU(2);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IRZ, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void dmv()
  {
    AppMethodBeat.i(65709);
    this.vKI = new cm();
    this.vKI.eeh = 10L;
    this.vKI.aLH();
    this.vIG = 2;
    this.vIr.show();
    if (bu.jB(this.vKF, 1)) {}
    for (int i = ChatFooterPanel.FkS;; i = ChatFooterPanel.FkP)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.vIB, this.vIz, i, new z.a()
      {
        public final void a(p paramAnonymousp)
        {
          AppMethodBeat.i(65694);
          ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousp });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymousp);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65694);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(224232);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(224232);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void dmw()
  {
    AppMethodBeat.i(65713);
    this.vKL += 1;
    int i;
    if ((this.vCv != null) && (this.vCv.size() > 0))
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      i = com.tencent.mm.kernel.a.getUin();
      int j = this.vCv.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.vKG = i;
      if ((this.vKG >= 0) && (this.vKG < this.vCv.size()))
      {
        this.vCl = ((w)this.vCv.get(this.vKG)).vBD;
        this.vCj = ((w)this.vCv.get(this.vKG)).vBE;
      }
      ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.vKG + " randomAmount:" + this.vCl + " randomWishing:" + this.vCj);
      this.vJQ.setFinalText(com.tencent.mm.wallet_core.ui.f.C(this.vCl / 100.0D));
      og(false);
      this.vJQ.setFocusable(false);
      this.vJQ.setContentDescription("");
      this.vJQ.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void dmc()
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
      ae.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
  }
  
  private void og(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.pUO.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.pUO.getBackground() != null) && (this.pUO.getBackground().mutate() != null)) {
        this.pUO.getBackground().mutate().setAlpha(255);
      }
      this.pUO.setTextColor(getResources().getColor(2131100594));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.pUO.getBackground() != null) && (this.pUO.getBackground().mutate() != null)) {
      this.pUO.getBackground().mutate().setAlpha(128);
    }
    this.pUO.setTextColor(getResources().getColor(2131100595));
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
    this.vKs = findViewById(2131301890);
    this.vJR = ((TextView)findViewById(2131301717));
    this.vJQ = ((LuckyMoneyAutoScrollView)findViewById(2131301860));
    this.uSM = ((TextView)findViewById(2131301877));
    this.pUO = ((Button)findViewById(2131301874));
    this.pUO.setOnClickListener(this.jwB);
    ((ImageView)findViewById(2131301876)).setOnClickListener(this.jwB);
    this.vKe = ((ImageView)findViewById(2131301869));
    this.vKt = findViewById(2131301867);
    this.vKu = ((TextView)findViewById(2131301868));
    this.vKv = ((ImageView)findViewById(2131301863));
    this.vKv.setOnClickListener(this.jwB);
    this.vKw = ((TextView)findViewById(2131301868));
    this.vKw.setOnClickListener(this.jwB);
    this.vKf = findViewById(2131301866);
    this.vKg = ((BaseEmojiView)findViewById(2131301862));
    this.vKg.setOnClickListener(this.jwB);
    this.vKy = ((ImageView)findViewById(2131301865));
    this.vKy.setOnClickListener(this.jwB);
    this.vKx = ((ImageView)findViewById(2131301864));
    this.vKz = ((TextView)findViewById(2131301872));
    this.vKz.setOnClickListener(this.jwB);
    this.vKA = ((LinearLayout)findViewById(2131301861));
    this.vKB = ((MMAnimateView)findViewById(2131301501));
    this.vKC = ((LinearLayout)findViewById(2131301871));
    this.vKC.setOnClickListener(this.jwB);
    this.vIr = new a(this);
    this.vIs = getLayoutInflater().inflate(2131494640, null);
    this.vIr.setContentView(this.vIs, new ViewGroup.LayoutParams(-1, -1));
    this.vIs.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65688);
      }
    });
    this.vIr.vGq = new a.a()
    {
      public final void dlZ()
      {
        AppMethodBeat.i(65692);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65692);
      }
    };
    this.vIB = ((ViewGroup)this.vIs.findViewById(2131301798));
    this.vIz = com.tencent.mm.pluginsdk.ui.chat.e.Fwh.eE(getContext());
    this.vIz.setTalkerName(this.vKD);
    this.vIz.setShowSmiley(false);
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
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
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
      if (this.pOS == null)
      {
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = bx.M(this.vDO, "msg");
        if (localObject1 == null)
        {
          ae.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
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
            int i = this.vDO.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.vDO.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.pOS != null) {
                break label361;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (bi)localObject1, 0);
              localObject1 = new StringBuilder(this.vDO.substring(0, i));
              String str = this.vDO.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.vDO = ((StringBuilder)localObject1).toString();
            }
            ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label361:
          localObject2 = this.pOS;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apY((String)localObject2))
      {
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.vDO });
        z.Z(this.vDO, this.vKD, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.vKI = new cm();
        if (this.vKK != 1) {
          break label566;
        }
        this.vKI.eeh = 8L;
        label468:
        this.vKI.aLH();
        JT(1);
      }
      for (;;)
      {
        localObject2 = v.aAC();
        if (paramInt2 != -1) {
          break label640;
        }
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.dGt = 1;
        this.vKU = "";
        paramIntent = new an(this.vHa, this.vKR, 1, (String)localObject2, bu.nullAsNil(this.vKD));
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        ae.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label566:
        if (this.vKK == 2)
        {
          this.vKI.eeh = 6L;
          break label468;
        }
        if (this.vKK == 3)
        {
          this.vKI.eeh = 7L;
          break label468;
        }
        if (this.vKK != 4) {
          break label468;
        }
        this.vKI.eeh = 14L;
        break label468;
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label640:
      if (paramIntent != null) {}
      for (this.dGt = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dGt = 3)
      {
        this.vKU = this.vHa;
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dGt) });
        paramIntent = new an(this.vHa, this.vKR, this.dGt, (String)localObject2, bu.nullAsNil(this.vKD));
        break;
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.vKQ = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!bu.az(this.vKQ, 0L))
        {
          JU(4);
          og(false);
          paramIntent = com.tencent.mm.emoji.c.b.gsl;
          com.tencent.mm.emoji.c.b.a(this.vKQ, this.vKT);
          AppMethodBeat.o(65716);
          return;
        }
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(65716);
        return;
      }
      ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
      break;
      label824:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65707);
    JT(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.vKD = getIntent().getStringExtra("key_username");
    this.vDK = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (bu.isNullOrNil(this.vKD))
    {
      ae.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new ai("v1.0", ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWU, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(65704);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.vIz != null)
    {
      ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.vIz.onPause();
      this.vIz.ffs();
      this.vIz.destroy();
    }
    com.tencent.mm.emoji.c.b localb = com.tencent.mm.emoji.c.b.gsl;
    com.tencent.mm.emoji.c.b.b(this.vKQ, this.vKT);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(65715);
    ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        this.vCl = paramString.vCl;
        this.vCj = paramString.vCj;
        this.vKF = paramString.vCr;
        this.vCs = paramString.vCs;
        this.vKR = paramString.dCl;
        this.vCv = paramString.vCv;
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.vKF) });
        dmw();
        ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.vCv != null) && (this.vCv.size() > 0))
        {
          ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.vKC.setVisibility(0);
          this.uSM.getLayoutParams();
          this.uSM.setTextSize(1, 21.0F);
          this.vJR.setTextSize(1, 15.0F);
          this.vJQ.gx(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.vJQ.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.vJQ.setLayoutParams(paramString);
          this.vJQ.invalidate();
          paramString = (LinearLayout.LayoutParams)this.vKC.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166520);
          this.vKC.setLayoutParams(paramString);
          this.vKC.invalidate();
          paramString = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRZ, "");
          if (!bu.isNullOrNil(paramString)) {
            break label407;
          }
          JU(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          z.a(this.vKs, null);
          AppMethodBeat.o(65715);
          return true;
          ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.vKC.setVisibility(8);
          break;
          label407:
          aqi(paramString);
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
        if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.aq))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (com.tencent.mm.plugin.luckymoney.model.aq)paramn;
            this.vDO = paramString.vCE;
            paramn = new PayInfo();
            paramn.dmw = paramString.tsf;
            paramn.dDH = 37;
            paramn.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          ae.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
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
            ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (ar)paramn;
            this.vDO = paramString.vCE;
            this.vHa = paramString.vwq;
            if (paramString.isJumpRemind())
            {
              ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
              {
                public final void bu(int paramAnonymousInt, String paramAnonymousString)
                {
                  AppMethodBeat.i(65701);
                  ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                  if ((bu.jB(paramAnonymousInt, 2)) && (bu.lX(paramAnonymousString, "requestwxhb")))
                  {
                    LuckyMoneyNewYearSendUI.x(LuckyMoneyNewYearSendUI.this);
                    AppMethodBeat.o(65701);
                    return;
                  }
                  if (bu.jB(paramAnonymousInt, 1)) {
                    com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyNewYearSendUI.this, paramAnonymousString, 0, true);
                  }
                  AppMethodBeat.o(65701);
                }
                
                public final void onCancel()
                {
                  AppMethodBeat.i(65702);
                  ae.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                  AppMethodBeat.o(65702);
                }
              });
              AppMethodBeat.o(65715);
              return true;
            }
            paramn = new PayInfo();
            paramn.dmw = paramString.tsf;
            paramn.dDH = 37;
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
                if (com.tencent.mm.plugin.luckymoney.model.aq.j(paramn))
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
          ae.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI
 * JD-Core Version:    0.7.0.1
 */