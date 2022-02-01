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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.f.b.a.ga;
import com.tencent.mm.f.b.a.go;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private TextView DLp;
  private LinkedList<ac> EBB;
  private String EBp;
  private int EBr;
  private int EBy;
  private String ECX;
  private a EHK;
  private View EHL;
  private ViewGroup EHW;
  private int EIb;
  private LuckyMoneyAutoScrollView EJZ;
  private View EKB;
  private View EKC;
  private TextView EKD;
  private ImageView EKE;
  private TextView EKF;
  private ImageView EKG;
  private ImageView EKH;
  private TextView EKI;
  private LinearLayout EKJ;
  private MMAnimateView EKK;
  private LinearLayout EKL;
  private String EKM;
  private boolean EKN;
  private int EKO;
  private int EKP;
  private EmojiInfo EKQ;
  private ga EKR;
  private go EKS;
  private int EKT;
  private int EKU;
  private int EKV;
  private int EKW;
  private int EKX;
  private int EKY;
  private long EKZ;
  private TextView EKa;
  private ImageView EKn;
  private View EKo;
  private BaseEmojiView EKp;
  private String ELa;
  private int ELb;
  private com.tencent.mm.emoji.d.a ELc;
  private String ELd;
  private String ExZ;
  private int Eyo;
  private int fRV;
  private int mChannel;
  private MMHandler mHandler;
  private View.OnClickListener nmC;
  private ChatFooterPanel rzI;
  private Dialog tipDialog;
  private EmojiInfo uIz;
  private Button uOZ;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.EKN = true;
    this.EKO = 0;
    this.EBy = 0;
    this.EKP = 0;
    this.mHandler = new MMHandler();
    this.EKT = 1;
    this.EIb = 0;
    this.EKU = 0;
    this.EKV = 0;
    this.EKW = 0;
    this.EKX = 0;
    this.EKY = 0;
    this.EKZ = 0L;
    this.ExZ = "";
    this.ELa = "";
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getId() == a.f.lucky_money_new_year_send_btn)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
          LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65693);
          return;
          if (paramAnonymousView.getId() == a.f.lucky_money_new_year_take_cancle_iv)
          {
            LuckyMoneyNewYearSendUI.this.finish();
            com.tencent.mm.plugin.report.service.h.IzE.a(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ga());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).gCd = 11L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bpa();
            LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          }
          else if ((paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_btn) || (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_tips))
          {
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ga());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).gCd = 3L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bpa();
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_del_btn)
          {
            LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vod, "");
            com.tencent.mm.plugin.report.service.h.IzE.a(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ga());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).gCd = 5L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bpa();
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_refresh_layout)
          {
            paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
            paramAnonymousView.hasCallBack = false;
            paramAnonymousView.EGg.setVisibility(0);
            paramAnonymousView.EGh.setVisibility(0);
            paramAnonymousView.EGi.setVisibility(0);
            paramAnonymousView.EGm.setVisibility(4);
            paramAnonymousView.EGn.setVisibility(4);
            paramAnonymousView.EGo.setVisibility(4);
            LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
            com.tencent.mm.plugin.report.service.h.IzE.a(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ga());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).gCd = 2L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bpa();
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_reload_btn)
          {
            paramAnonymousView = com.tencent.mm.emoji.d.i.jPu;
            com.tencent.mm.emoji.d.i.Fo(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression)
          {
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
        }
      }
    };
    this.ELb = 0;
    this.ELc = new com.tencent.mm.emoji.d.a()
    {
      public final void a(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(65691);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this)), Long.valueOf(paramAnonymousLong), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
        if (Util.isEqual(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this), paramAnonymousLong))
        {
          if (!paramAnonymousBoolean) {
            break label111;
          }
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymousString);
        }
        for (;;)
        {
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
          paramAnonymousString = com.tencent.mm.emoji.d.b.jPc;
          com.tencent.mm.emoji.d.b.b(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.A(LuckyMoneyNewYearSendUI.this));
          AppMethodBeat.o(65691);
          return;
          label111:
          if ((Util.isEqual(LuckyMoneyNewYearSendUI.y(LuckyMoneyNewYearSendUI.this), 0)) && (com.tencent.mm.plugin.emoji.i.b.IV(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this))))
          {
            LuckyMoneyNewYearSendUI.z(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 3);
            AppMethodBeat.o(65691);
            return;
          }
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 5);
        }
      }
    };
    this.fRV = 0;
    this.ELd = "";
    AppMethodBeat.o(65703);
  }
  
  private void Wh(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.EKS = new go();
    this.EKS.giq = paramInt;
    this.EKS.gCU = this.EKT;
    this.EKS.gCV = this.EKU;
    this.EKS.gCW = this.EKV;
    this.EKS.gCX = this.EKW;
    this.EKS.gDa = this.EKX;
    this.EKS.gCY = this.EKY;
    go localgo = this.EKS;
    if (this.uIz == null) {}
    for (String str = "";; str = this.uIz.getMd5())
    {
      localgo.vB(str);
      this.EKS.bpa();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void Wi(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (Util.isEqual(this.EBy, 0))
    {
      this.EKn.setVisibility(0);
      this.EKC.setVisibility(8);
      this.EKo.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.EKn.setVisibility(8);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.EKC.setVisibility(0);
      this.EKD.setText(a.i.lucky_money_add_expression);
      this.EKo.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.EKC.setVisibility(8);
      this.EKo.setVisibility(0);
      this.EKG.setVisibility(0);
      this.EKp.setVisibility(8);
      this.EKH.setVisibility(8);
      this.EKI.setVisibility(8);
      this.EKJ.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.EKQ != null)
      {
        this.EKR = new ga();
        this.EKR.gCd = 4L;
        this.EKR.bpa();
      }
      this.EKQ = this.uIz;
      if (this.EIb == 0) {
        if (com.tencent.mm.plugin.emoji.i.b.z(this.uIz)) {
          this.EKT = 2;
        }
      }
      for (;;)
      {
        this.EKC.setVisibility(8);
        this.EKo.setVisibility(0);
        this.EKG.setVisibility(8);
        this.EKp.setVisibility(0);
        this.EKH.setVisibility(0);
        this.EKI.setVisibility(8);
        this.EKJ.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (com.tencent.mm.plugin.emoji.i.b.x(this.uIz))
        {
          this.EKT = 4;
        }
        else
        {
          this.EKT = 3;
          continue;
          if (this.EIb == 1)
          {
            this.EKT = 2;
            this.EKV += 1;
          }
          else if (this.EIb == 2)
          {
            if (com.tencent.mm.plugin.emoji.i.b.z(this.uIz))
            {
              this.EKT = 2;
              this.EKY += 1;
            }
            else if (com.tencent.mm.plugin.emoji.i.b.x(this.uIz))
            {
              this.EKT = 4;
              this.EKX += 1;
            }
            else
            {
              this.EKT = 3;
              this.EKW += 1;
            }
          }
        }
      }
      this.EKC.setVisibility(8);
      this.EKo.setVisibility(0);
      this.EKG.setVisibility(8);
      this.EKp.setVisibility(8);
      this.EKH.setVisibility(8);
      this.EKI.setVisibility(0);
      this.EKJ.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.EKC.setVisibility(8);
      this.EKo.setVisibility(0);
      this.EKG.setVisibility(8);
      this.EKp.setVisibility(8);
      this.EKH.setVisibility(8);
      this.EKI.setVisibility(8);
      this.EKJ.setVisibility(0);
      this.EKK.setImageResource(a.h.lucky_money_newyear_creat_loading);
      AppMethodBeat.o(65711);
      return;
      this.EKC.setVisibility(0);
      this.EKD.setText(a.i.lucky_money_newyear_fail_and_again_add);
      this.EKo.setVisibility(8);
    }
  }
  
  private void Wj(int paramInt)
  {
    AppMethodBeat.i(65712);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    for (;;)
    {
      String str2 = z.bcZ();
      String str1 = "";
      int i = 0;
      if (this.uIz != null)
      {
        str1 = this.uIz.getMd5();
        i = this.uIz.field_type;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.ELa, Integer.valueOf(paramInt), Integer.valueOf(this.fRV), this.ExZ });
      doSceneProgress(new bd(this.EBr, this.EBp, ag.aNF(str2), this.EKM, str2, z.bdb(), this.Eyo, str1, i, this.ELa, paramInt, this.fRV, this.ExZ), false);
      AppMethodBeat.o(65712);
      return;
      this.tipDialog = com.tencent.mm.wallet_core.ui.i.a(getContext(), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65698);
          if ((LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this) != null) && (LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this).isShowing())) {
            LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this).dismiss();
          }
          if ((LuckyMoneyNewYearSendUI.q(LuckyMoneyNewYearSendUI.this).getVisibility() == 8) || (LuckyMoneyNewYearSendUI.r(LuckyMoneyNewYearSendUI.this).getVisibility() == 4))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearSendUI.this.finish();
          }
          LuckyMoneyNewYearSendUI.this.EGu.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
  }
  
  private void aNO(String paramString)
  {
    AppMethodBeat.i(65710);
    this.uIz = p.getEmojiStorageMgr().VFH.bxK(paramString);
    this.EKp.setEmojiInfo(this.uIz);
    Wi(2);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vod, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void ePT()
  {
    AppMethodBeat.i(65709);
    this.EKR = new ga();
    this.EKR.gCd = 10L;
    this.EKR.bpa();
    this.EIb = 2;
    this.EHK.show();
    if (Util.isEqual(this.EKO, 1)) {}
    for (int i = ChatFooterPanel.Rcp;; i = ChatFooterPanel.Rcm)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.b.a(this.EHW, this.rzI, i, new ac.a()
      {
        public final void a(r paramAnonymousr)
        {
          AppMethodBeat.i(65694);
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousr });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymousr);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65694);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(293270);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(293270);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void ePU()
  {
    AppMethodBeat.i(65713);
    this.EKU += 1;
    int i;
    if ((this.EBB != null) && (this.EBB.size() > 0))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHE();
      i = com.tencent.mm.kernel.b.getUin();
      int j = this.EBB.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.EKP = i;
      if ((this.EKP >= 0) && (this.EKP < this.EBB.size()))
      {
        this.EBr = ((ac)this.EBB.get(this.EKP)).EAE;
        this.EBp = ((ac)this.EBB.get(this.EKP)).EAF;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.EKP + " randomAmount:" + this.EBr + " randomWishing:" + this.EBp);
      this.EJZ.setFinalText(g.formatMoney2f(this.EBr / 100.0D));
      tR(false);
      this.EJZ.setFocusable(false);
      this.EJZ.setContentDescription("");
      this.EJZ.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void ePz()
        {
          AppMethodBeat.i(65700);
          if (LuckyMoneyNewYearSendUI.s(LuckyMoneyNewYearSendUI.this))
          {
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).setVisibility(4);
            ag.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
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
            ag.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).invalidate();
          }
        }
      });
      AppMethodBeat.o(65713);
      return;
      Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
  }
  
  private void tR(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.uOZ.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.uOZ.getBackground() != null) && (this.uOZ.getBackground().mutate() != null)) {
        this.uOZ.getBackground().mutate().setAlpha(255);
      }
      this.uOZ.setTextColor(getResources().getColor(a.c.lucky_money_new_year_send_btn_text_color));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.uOZ.getBackground() != null) && (this.uOZ.getBackground().mutate() != null)) {
      this.uOZ.getBackground().mutate().setAlpha(128);
    }
    this.uOZ.setTextColor(getResources().getColor(a.c.lucky_money_new_year_send_btn_text_color_half_transparency));
    AppMethodBeat.o(65714);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_new_year_send_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65706);
    setActionbarColor(-839716110);
    setContentViewVisibility(8);
    this.EKB = findViewById(a.f.lucky_money_newyear_send_ll);
    this.EKa = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
    this.EJZ = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_new_year_amount));
    this.DLp = ((TextView)findViewById(a.f.lucky_money_new_year_wishing));
    this.uOZ = ((Button)findViewById(a.f.lucky_money_new_year_send_btn));
    this.uOZ.setOnClickListener(this.nmC);
    ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv)).setOnClickListener(this.nmC);
    this.EKn = ((ImageView)findViewById(a.f.lucky_money_new_year_good));
    this.EKC = findViewById(a.f.lucky_money_new_year_expression_ll);
    this.EKD = ((TextView)findViewById(a.f.lucky_money_new_year_expression_tips));
    this.EKE = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_btn));
    this.EKE.setOnClickListener(this.nmC);
    this.EKF = ((TextView)findViewById(a.f.lucky_money_new_year_expression_tips));
    this.EKF.setOnClickListener(this.nmC);
    this.EKo = findViewById(a.f.lucky_money_new_year_expression_layout);
    this.EKp = ((BaseEmojiView)findViewById(a.f.lucky_money_new_year_expression));
    this.EKp.setOnClickListener(this.nmC);
    this.EKH = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_del_btn));
    this.EKH.setOnClickListener(this.nmC);
    this.EKG = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_default));
    this.EKI = ((TextView)findViewById(a.f.lucky_money_new_year_reload_btn));
    this.EKI.setOnClickListener(this.nmC);
    this.EKJ = ((LinearLayout)findViewById(a.f.lucky_money_new_year_creating));
    this.EKK = ((MMAnimateView)findViewById(a.f.loading_image));
    this.EKL = ((LinearLayout)findViewById(a.f.lucky_money_new_year_refresh_layout));
    this.EKL.setOnClickListener(this.nmC);
    this.EHK = new a(this);
    this.EHL = getLayoutInflater().inflate(a.g.lucky_money_emoji_dialog, null);
    this.EHK.setContentView(this.EHL, new ViewGroup.LayoutParams(-1, -1));
    this.EHL.findViewById(a.f.lucky_money_emoji_dismiss_area).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65688);
      }
    });
    this.EHK.EFM = new a.a()
    {
      public final void ePv()
      {
        AppMethodBeat.i(65692);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65692);
      }
    };
    this.EHW = ((ViewGroup)this.EHL.findViewById(a.f.lucky_money_emoji_root));
    this.rzI = com.tencent.mm.pluginsdk.ui.chat.e.RnO.fd(getContext());
    this.rzI.setTalkerName(this.EKM);
    this.rzI.setShowSmiley(false);
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
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        if ((paramIntent == null) || (!paramIntent.hasExtra("key_realname_guide_helper"))) {
          break label825;
        }
        localObject1 = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
        if (localObject1 == null) {
          break label825;
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
      if (this.uIz == null)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = XmlParser.parseXml(this.ECX, "msg", null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
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
            int i = this.ECX.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.ECX.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.uIz != null) {
                break label362;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (com.tencent.mm.f.c.bj)localObject1, 0);
              localObject1 = new StringBuilder(this.ECX.substring(0, i));
              String str = this.ECX.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.ECX = ((StringBuilder)localObject1).toString();
            }
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label362:
          localObject2 = this.uIz;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.eNR().eNW().aND((String)localObject2))
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.ECX });
        ag.ag(this.ECX, this.EKM, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.EKR = new ga();
        if (this.EKT != 1) {
          break label567;
        }
        this.EKR.gCd = 8L;
        label469:
        this.EKR.bpa();
        Wh(1);
      }
      for (;;)
      {
        localObject2 = z.bcZ();
        if (paramInt2 != -1) {
          break label641;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.fRV = 1;
        this.ELd = "";
        paramIntent = new ax(this.ExZ, this.ELa, 1, (String)localObject2, Util.nullAsNil(this.EKM));
        com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label567:
        if (this.EKT == 2)
        {
          this.EKR.gCd = 6L;
          break label469;
        }
        if (this.EKT == 3)
        {
          this.EKR.gCd = 7L;
          break label469;
        }
        if (this.EKT != 4) {
          break label469;
        }
        this.EKR.gCd = 14L;
        break label469;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label641:
      if (paramIntent != null) {}
      for (this.fRV = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.fRV = 3)
      {
        this.ELd = this.ExZ;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.fRV) });
        paramIntent = new ax(this.ExZ, this.ELa, this.fRV, (String)localObject2, Util.nullAsNil(this.EKM));
        break;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.EKZ = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!Util.isEqual(this.EKZ, 0L))
        {
          Wi(4);
          tR(false);
          paramIntent = com.tencent.mm.emoji.d.b.jPc;
          com.tencent.mm.emoji.d.b.a(this.EKZ, this.ELc);
          AppMethodBeat.o(65716);
          return;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(65716);
        return;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
      break;
      label825:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65707);
    Wh(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.EKM = getIntent().getStringExtra("key_username");
    this.Eyo = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (Util.isNullOrNil(this.EKM))
    {
      Log.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new ar(8, "v1.0", ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vty, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.h.IzE.a(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(65704);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.rzI != null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.rzI.onPause();
      this.rzI.hjm();
      this.rzI.destroy();
    }
    com.tencent.mm.emoji.d.b localb = com.tencent.mm.emoji.d.b.jPc;
    com.tencent.mm.emoji.d.b.b(this.EKZ, this.ELc);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(65715);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ar)paramq;
        this.EBr = paramString.EBr;
        this.EBp = paramString.EBp;
        this.EKO = paramString.EBx;
        this.EBy = paramString.EBy;
        this.ELa = paramString.fND;
        this.EBB = paramString.EBB;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.EKO) });
        ePU();
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.EBB != null) && (this.EBB.size() > 0))
        {
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.EKL.setVisibility(0);
          this.DLp.getLayoutParams();
          this.DLp.setTextSize(1, 21.0F);
          this.EKa.setTextSize(1, 15.0F);
          this.EJZ.ia(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height));
          paramString = (LinearLayout.LayoutParams)this.EJZ.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
          this.EJZ.setLayoutParams(paramString);
          this.EJZ.invalidate();
          paramString = (LinearLayout.LayoutParams)this.EKL.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_refresh_layout_top_margin_for_normal);
          this.EKL.setLayoutParams(paramString);
          this.EKL.invalidate();
          paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vod, "");
          if (!Util.isNullOrNil(paramString)) {
            break label407;
          }
          Wi(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          ag.a(this.EKB, null);
          AppMethodBeat.o(65715);
          return true;
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.EKL.setVisibility(8);
          break;
          label407:
          aNO(paramString);
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
        if ((paramq instanceof bb))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (bb)paramq;
            this.ECX = paramString.EBL;
            paramq = new PayInfo();
            paramq.fwv = paramString.ByI;
            paramq.fOY = 37;
            paramq.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        else
        {
          if (!(paramq instanceof bd)) {
            break;
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (bd)paramq;
            this.ECX = paramString.EBL;
            this.ExZ = paramString.ybP;
            if (paramString.isJumpRemind())
            {
              Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
              {
                public final void bE(int paramAnonymousInt, String paramAnonymousString)
                {
                  AppMethodBeat.i(65701);
                  Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                  if ((Util.isEqual(paramAnonymousInt, 2)) && (Util.isEqual(paramAnonymousString, "requestwxhb")))
                  {
                    LuckyMoneyNewYearSendUI.x(LuckyMoneyNewYearSendUI.this);
                    AppMethodBeat.o(65701);
                    return;
                  }
                  if (Util.isEqual(paramAnonymousInt, 1)) {
                    com.tencent.mm.plugin.account.sdk.b.a.b(LuckyMoneyNewYearSendUI.this, paramAnonymousString, 0, true);
                  }
                  AppMethodBeat.o(65701);
                }
                
                public final void onCancel()
                {
                  AppMethodBeat.i(65702);
                  Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                  AppMethodBeat.o(65702);
                }
              });
              AppMethodBeat.o(65715);
              return true;
            }
            paramq = new PayInfo();
            paramq.fwv = paramString.ByI;
            paramq.fOY = 37;
            paramq.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 1);
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
                if (bb.l(paramq))
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
          Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
      }
    } while (!(paramq instanceof ax));
    AppMethodBeat.o(65715);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI
 * JD-Core Version:    0.7.0.1
 */