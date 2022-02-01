package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mm.am.p;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.t;
import com.tencent.mm.autogen.b.bm;
import com.tencent.mm.autogen.mmdata.rpt.hv;
import com.tencent.mm.autogen.mmdata.rpt.ij;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.model.be;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private TextView JCr;
  private a KBb;
  private View KBc;
  private ViewGroup KBn;
  private int KBs;
  private LuckyMoneyAutoScrollView KDH;
  private TextView KDI;
  private ImageView KDV;
  private View KDW;
  private BaseEmojiView KDX;
  private View KEA;
  private View KEB;
  private TextView KEC;
  private ImageView KED;
  private TextView KEE;
  private ImageView KEF;
  private ImageView KEG;
  private TextView KEH;
  private LinearLayout KEI;
  private MMAnimateView KEJ;
  private LinearLayout KEK;
  private TextView KEL;
  private TextView KEM;
  private String KEN;
  private boolean KEO;
  private int KEP;
  private int KEQ;
  private EmojiInfo KER;
  private hv KES;
  private ij KET;
  private int KEU;
  private int KEV;
  private int KEW;
  private int KEX;
  private int KEZ;
  private int KFa;
  private long KFb;
  private boolean KFc;
  private String KFd;
  private int KFe;
  private com.tencent.mm.emoji.e.a KFf;
  private String KFg;
  private String KqM;
  private int Krb;
  private String Kun;
  private int Kup;
  private int Kuw;
  private LinkedList<ad> Kuz;
  private String Kwb;
  private int hXQ;
  private int mChannel;
  private MMHandler mHandler;
  private View.OnClickListener qjL;
  private Dialog tipDialog;
  private ChatFooterPanel uKY;
  private LinearLayout wzS;
  private EmojiInfo xRp;
  private Button xXJ;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.KEO = true;
    this.KEP = 0;
    this.Kuw = 0;
    this.KEQ = 0;
    this.mHandler = new MMHandler();
    this.KEU = 1;
    this.KBs = 0;
    this.KEV = 0;
    this.KEW = 0;
    this.KEX = 0;
    this.KEZ = 0;
    this.KFa = 0;
    this.KFb = 0L;
    this.KFc = false;
    this.KqM = "";
    this.KFd = "";
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == a.f.lucky_money_new_year_send_btn)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
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
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new hv());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).iPe = 11L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bMH();
            LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          }
          else if ((paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_btn) || (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_tips))
          {
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new hv());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).iPe = 3L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bMH();
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_expression_del_btn)
          {
            LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acPy, "");
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new hv());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).iPe = 5L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bMH();
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_refresh_layout)
          {
            LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this).fYd();
            LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
            com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new hv());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).iPe = 2L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bMH();
          }
          else if (paramAnonymousView.getId() == a.f.lucky_money_new_year_reload_btn)
          {
            paramAnonymousView = com.tencent.mm.emoji.e.h.mol;
            com.tencent.mm.emoji.e.h.hw(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
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
    this.KFe = 0;
    this.KFf = new com.tencent.mm.emoji.e.a()
    {
      public final void a(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(284310);
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
          paramAnonymousString = com.tencent.mm.emoji.e.b.mnS;
          com.tencent.mm.emoji.e.b.b(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.A(LuckyMoneyNewYearSendUI.this));
          AppMethodBeat.o(284310);
          return;
          label111:
          if ((Util.isEqual(LuckyMoneyNewYearSendUI.y(LuckyMoneyNewYearSendUI.this), 0)) && (d.lr(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this))))
          {
            LuckyMoneyNewYearSendUI.z(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 3);
            AppMethodBeat.o(284310);
            return;
          }
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 5);
        }
      }
    };
    this.hXQ = 0;
    this.KFg = "";
    AppMethodBeat.o(65703);
  }
  
  private void aKM(String paramString)
  {
    AppMethodBeat.i(65710);
    this.xRp = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramString);
    this.KDX.setEmojiInfo(this.xRp);
    aad(2);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acPy, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void aad(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (Util.isEqual(this.Kuw, 0))
    {
      this.KDV.setVisibility(0);
      this.KEB.setVisibility(8);
      this.KDW.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.KDV.setVisibility(8);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.KEB.setVisibility(0);
      this.KEC.setText(a.i.lucky_money_add_expression);
      this.KDW.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.KEB.setVisibility(8);
      this.KDW.setVisibility(0);
      this.KEF.setVisibility(0);
      this.KDX.setVisibility(8);
      this.KEG.setVisibility(8);
      this.KEH.setVisibility(8);
      this.KEI.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.KER != null)
      {
        this.KES = new hv();
        this.KES.iPe = 4L;
        this.KES.bMH();
      }
      this.KER = this.xRp;
      if (this.KBs == 0) {
        if (d.z(this.xRp)) {
          this.KEU = 2;
        }
      }
      for (;;)
      {
        this.KEB.setVisibility(8);
        this.KDW.setVisibility(0);
        this.KEF.setVisibility(8);
        this.KDX.setVisibility(0);
        this.KEG.setVisibility(0);
        this.KEH.setVisibility(8);
        this.KEI.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (d.x(this.xRp))
        {
          this.KEU = 4;
        }
        else
        {
          this.KEU = 3;
          continue;
          if (this.KBs == 1)
          {
            this.KEU = 2;
            this.KEW += 1;
          }
          else if (this.KBs == 2)
          {
            if (d.z(this.xRp))
            {
              this.KEU = 2;
              this.KFa += 1;
            }
            else if (d.x(this.xRp))
            {
              this.KEU = 4;
              this.KEZ += 1;
            }
            else
            {
              this.KEU = 3;
              this.KEX += 1;
            }
          }
        }
      }
      this.KEB.setVisibility(8);
      this.KDW.setVisibility(0);
      this.KEF.setVisibility(8);
      this.KDX.setVisibility(8);
      this.KEG.setVisibility(8);
      this.KEH.setVisibility(0);
      this.KEI.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.KEB.setVisibility(8);
      this.KDW.setVisibility(0);
      this.KEF.setVisibility(8);
      this.KDX.setVisibility(8);
      this.KEG.setVisibility(8);
      this.KEH.setVisibility(8);
      this.KEI.setVisibility(0);
      this.KEJ.setImageResource(a.h.lucky_money_newyear_creat_loading);
      AppMethodBeat.o(65711);
      return;
      this.KEB.setVisibility(0);
      this.KEC.setText(a.i.lucky_money_newyear_fail_and_again_add);
      this.KDW.setVisibility(8);
    }
  }
  
  private void aae(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.KET = new ij();
    this.KET.ioV = paramInt;
    this.KET.iPW = this.KEU;
    this.KET.iPX = this.KEV;
    this.KET.iPY = this.KEW;
    this.KET.iPZ = this.KEX;
    this.KET.iQc = this.KEZ;
    this.KET.iQa = this.KFa;
    ij localij = this.KET;
    if (this.xRp == null) {}
    for (String str = "";; str = this.xRp.getMd5())
    {
      localij.rN(str);
      this.KET.bMH();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void aaf(int paramInt)
  {
    AppMethodBeat.i(65712);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    String str2;
    String str1;
    int i;
    for (;;)
    {
      str2 = com.tencent.mm.model.z.bAM();
      str1 = "";
      i = 0;
      if (this.xRp != null)
      {
        str1 = this.xRp.getMd5();
        i = this.xRp.field_type;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.KFd, Integer.valueOf(paramInt), Integer.valueOf(this.hXQ), this.KqM });
      if (!this.KFc) {
        break;
      }
      doSceneProgress(new au(1, this.Kup, this.Kup, 3, this.Kun, this.KEN, ah.fXi(), com.tencent.mm.model.z.bAM(), 2), false);
      AppMethodBeat.o(65712);
      return;
      this.tipDialog = l.a(getContext(), true, new DialogInterface.OnCancelListener()
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
          LuckyMoneyNewYearSendUI.this.KzD.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
    doSceneProgress(new be(this.Kup, this.Kun, ah.aKC(str2), this.KEN, str2, com.tencent.mm.model.z.bAO(), this.Krb, str1, i, this.KFd, paramInt, this.hXQ, this.KqM), false);
    AppMethodBeat.o(65712);
  }
  
  private void fYA()
  {
    AppMethodBeat.i(65709);
    this.KES = new hv();
    this.KES.iPe = 10L;
    this.KES.bMH();
    this.KBs = 2;
    this.KBb.show();
    if (Util.isEqual(this.KEP, 1)) {}
    for (int i = ChatFooterPanel.XYu;; i = ChatFooterPanel.XYr)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.b.a(this.KBn, this.uKY, i, new ad.a()
      {
        public final void a(t paramAnonymoust)
        {
          AppMethodBeat.i(65694);
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymoust });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, paramAnonymoust);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(65694);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(369815);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(369815);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void fYB()
  {
    AppMethodBeat.i(65713);
    this.KEV += 1;
    int i;
    if ((this.Kuz != null) && (this.Kuz.size() > 0))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC();
      i = com.tencent.mm.kernel.b.getUin();
      int j = this.Kuz.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.KEQ = i;
      if ((this.KEQ >= 0) && (this.KEQ < this.Kuz.size()))
      {
        this.Kup = ((ad)this.Kuz.get(this.KEQ)).KtA;
        this.Kun = ((ad)this.Kuz.get(this.KEQ)).KtB;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.KEQ + " randomAmount:" + this.Kup + " randomWishing:" + this.Kun);
      this.KDH.setFinalText(i.formatMoney2f(this.Kup / 100.0D));
      yg(false);
      this.KDH.setFocusable(false);
      this.KDH.setContentDescription("");
      this.KDH.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void fYe()
        {
          AppMethodBeat.i(65700);
          if (LuckyMoneyNewYearSendUI.s(LuckyMoneyNewYearSendUI.this))
          {
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).setVisibility(4);
            ah.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
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
            ah.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
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
  
  private void updateView()
  {
    AppMethodBeat.i(284174);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
    if ((this.Kuz != null) && (this.Kuz.size() > 0))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
      this.KEK.setVisibility(0);
    }
    for (;;)
    {
      this.JCr.getLayoutParams();
      this.JCr.setTextSize(1, 21.0F);
      this.KDI.setTextSize(1, 15.0F);
      this.KDH.jF(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.KDH.getLayoutParams();
      localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
      this.KDH.setLayoutParams(localLayoutParams);
      this.KDH.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.KEK.getLayoutParams();
      localLayoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_refresh_layout_top_margin_for_normal);
      this.KEK.setLayoutParams(localLayoutParams);
      this.KEK.invalidate();
      AppMethodBeat.o(284174);
      return;
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
      this.KEK.setVisibility(8);
    }
  }
  
  private void yg(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.xXJ.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.xXJ.getBackground() != null) && (this.xXJ.getBackground().mutate() != null)) {
        this.xXJ.getBackground().mutate().setAlpha(255);
      }
      this.xXJ.setTextColor(getResources().getColor(a.c.lucky_money_new_year_send_btn_text_color));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.xXJ.getBackground() != null) && (this.xXJ.getBackground().mutate() != null)) {
      this.xXJ.getBackground().mutate().setAlpha(128);
    }
    this.xXJ.setTextColor(getResources().getColor(a.c.lucky_money_new_year_send_btn_text_color_half_transparency));
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
    this.KEA = findViewById(a.f.lucky_money_newyear_send_ll);
    this.KDI = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
    this.KDH = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_new_year_amount));
    this.JCr = ((TextView)findViewById(a.f.lucky_money_new_year_wishing));
    this.xXJ = ((Button)findViewById(a.f.lucky_money_new_year_send_btn));
    this.xXJ.setOnClickListener(this.qjL);
    ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv)).setOnClickListener(this.qjL);
    this.KDV = ((ImageView)findViewById(a.f.lucky_money_new_year_good));
    this.KEB = findViewById(a.f.lucky_money_new_year_expression_ll);
    this.KEC = ((TextView)findViewById(a.f.lucky_money_new_year_expression_tips));
    this.KED = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_btn));
    this.KED.setOnClickListener(this.qjL);
    this.KEE = ((TextView)findViewById(a.f.lucky_money_new_year_expression_tips));
    this.KEE.setOnClickListener(this.qjL);
    this.KDW = findViewById(a.f.lucky_money_new_year_expression_layout);
    this.KDX = ((BaseEmojiView)findViewById(a.f.lucky_money_new_year_expression));
    this.KDX.setOnClickListener(this.qjL);
    this.KEG = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_del_btn));
    this.KEG.setOnClickListener(this.qjL);
    this.KEF = ((ImageView)findViewById(a.f.lucky_money_new_year_expression_default));
    this.KEH = ((TextView)findViewById(a.f.lucky_money_new_year_reload_btn));
    this.KEH.setOnClickListener(this.qjL);
    this.KEI = ((LinearLayout)findViewById(a.f.lucky_money_new_year_creating));
    this.KEJ = ((MMAnimateView)findViewById(a.f.loading_image));
    this.KEK = ((LinearLayout)findViewById(a.f.lucky_money_new_year_refresh_layout));
    this.KEK.setOnClickListener(this.qjL);
    this.KBb = new a(this);
    this.KBc = getLayoutInflater().inflate(a.g.lucky_money_emoji_dialog, null);
    this.KBb.setContentView(this.KBc, new ViewGroup.LayoutParams(-1, -1));
    this.KBc.findViewById(a.f.lucky_money_emoji_dismiss_area).setOnClickListener(new LuckyMoneyNewYearSendUI.1(this));
    this.KBb.KyS = new LuckyMoneyNewYearSendUI.6(this);
    this.KBn = ((ViewGroup)this.KBc.findViewById(a.f.lucky_money_emoji_root));
    this.uKY = com.tencent.mm.pluginsdk.ui.chat.e.Ykf.fZ(getContext());
    this.uKY.setTalkerName(this.KEN);
    this.uKY.setShowSmiley(false);
    this.wzS = ((LinearLayout)findViewById(a.f.lucky_money_new_year_header));
    this.KEL = ((TextView)findViewById(a.f.lucky_money_hk_amount_unit_title_tv));
    this.KEM = ((TextView)findViewById(a.f.lucky_money_hk_amount_holder));
    if (this.KFc)
    {
      this.wzS.setVisibility(4);
      this.KEA.setBackgroundResource(a.e.lucky_money_hk_newyear_new_bg);
      this.KEL.setVisibility(0);
      this.KEM.setVisibility(4);
      this.KDI.setVisibility(8);
    }
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
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        if ((paramIntent == null) || (!paramIntent.hasExtra("key_realname_guide_helper"))) {
          break label983;
        }
        localObject1 = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
        if (localObject1 == null) {
          break label983;
        }
        if (!((RealnameGuideHelper)localObject1).b(this, null, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(284314);
            LuckyMoneyNewYearSendUI.this.finish();
            AppMethodBeat.o(284314);
          }
        })) {
          paramInt1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.xRp == null)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = XmlParser.parseXml(this.Kwb, "msg", null);
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
            int i = this.Kwb.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.Kwb.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.xRp != null) {
                break label375;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (bm)localObject1, 0);
              localObject1 = new StringBuilder(this.Kwb.substring(0, i));
              String str = this.Kwb.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.Kwb = ((StringBuilder)localObject1).toString();
            }
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label375:
          localObject2 = this.xRp;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.app.a.fWk().fWp().aKz((String)localObject2))
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.Kwb });
        ah.an(this.Kwb, this.KEN, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.KES = new hv();
        if (this.KEU != 1) {
          break label583;
        }
        this.KES.iPe = 8L;
        label483:
        this.KES.bMH();
        aae(1);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.z.bAM();
        if (paramInt2 != -1) {
          break label658;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.hXQ = 1;
        this.KFg = "";
        paramIntent = new ay(this.KqM, this.KFd, 1, (String)localObject2, Util.nullAsNil(this.KEN));
        com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label583:
        if (this.KEU == 2)
        {
          this.KES.iPe = 6L;
          break label483;
        }
        if (this.KEU == 3)
        {
          this.KES.iPe = 7L;
          break label483;
        }
        if (this.KEU != 4) {
          break label483;
        }
        this.KES.iPe = 14L;
        break label483;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label658:
      if (paramIntent != null) {}
      for (this.hXQ = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.hXQ = 3)
      {
        this.KFg = this.KqM;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.hXQ) });
        paramIntent = new ay(this.KqM, this.KFd, this.hXQ, (String)localObject2, Util.nullAsNil(this.KEN));
        break;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.KFb = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!Util.isEqual(this.KFb, 0L))
        {
          aad(4);
          yg(false);
          paramIntent = com.tencent.mm.emoji.e.b.mnS;
          com.tencent.mm.emoji.e.b.a(this.KFb, this.KFf);
          AppMethodBeat.o(65716);
          return;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(65716);
        return;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
      AppMethodBeat.o(65716);
      return;
      if ((paramIntent == null) || (!paramIntent.hasExtra("result_data"))) {
        break;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      if (paramIntent != null)
      {
        paramInt1 = Util.getInt(paramIntent.getString("payState", "2"), 0);
        Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult REQUEST_CODE_H5_PAY payState is ".concat(String.valueOf(paramInt1)));
        if (paramInt1 == 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
          finish();
        }
        AppMethodBeat.o(65716);
        return;
      }
      Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
      break;
      label983:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65707);
    aae(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.KEN = getIntent().getStringExtra("key_username");
    this.Krb = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (Util.isNullOrNil(this.KEN))
    {
      Log.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    this.KFc = ah.fXj();
    initView();
    if (this.KFc) {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.a.f());
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(65704);
      return;
      doSceneProgress(new as(8, "v1.0", ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue()));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.uKY != null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.uKY.onPause();
      this.uKY.iKg();
      this.uKY.destroy();
    }
    com.tencent.mm.emoji.e.b localb = com.tencent.mm.emoji.e.b.mnS;
    com.tencent.mm.emoji.e.b.b(this.KFb, this.KFf);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(65715);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    if ((paramp instanceof as))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (as)paramp;
        this.Kup = paramString.Kup;
        this.Kun = paramString.Kun;
        this.KEP = paramString.Kuv;
        this.Kuw = paramString.Kuw;
        this.KFd = paramString.hTs;
        this.Kuz = paramString.Kuz;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.KEP) });
        fYB();
        updateView();
        paramString = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPy, "");
        if (Util.isNullOrNil(paramString)) {
          aad(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          ah.a(this.KEA, null);
          AppMethodBeat.o(65715);
          return true;
          aKM(paramString);
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
        if ((paramp instanceof com.tencent.mm.plugin.luckymoney.model.a.f))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = (com.tencent.mm.plugin.luckymoney.model.a.f)paramp;
            if (paramString.Kvq == 1)
            {
              this.Kup = paramString.Kup;
              this.Kun = paramString.Kun;
              this.Kuz = paramString.Kuz;
              fYB();
              updateView();
              setContentViewVisibility(0);
              ah.a(this.KEA, null);
              AppMethodBeat.o(65715);
              return true;
            }
            Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "hk sceneSwitch is %d", new Object[] { Integer.valueOf(paramString.Kvq) });
            finish();
          }
          else
          {
            finish();
          }
        }
        else if ((paramp instanceof au))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = ((au)paramp).wZd;
            if (!Util.isNullOrNil(paramString))
            {
              Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "payUrl is not null");
              i.a(getContext(), paramString, false, 5);
            }
            else
            {
              Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "payUrl is null");
            }
          }
        }
        else
        {
          if (!(paramp instanceof bc)) {
            break;
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (bc)paramp;
            this.Kwb = paramString.KuM;
            paramp = new PayInfo();
            paramp.hAT = paramString.Hgk;
            paramp.hUR = 37;
            paramp.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramp, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
      }
      if ((paramp instanceof be))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
          paramString = (be)paramp;
          this.Kwb = paramString.KuM;
          this.KqM = paramString.CAf;
          if (paramString.isJumpRemind())
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
            paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.model.h()
            {
              public final void cm(int paramAnonymousInt, String paramAnonymousString)
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
                  com.tencent.mm.plugin.account.sdk.c.a.b(LuckyMoneyNewYearSendUI.this, paramAnonymousString, 0, true);
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
          paramp = new PayInfo();
          paramp.hAT = paramString.Hgk;
          paramp.hUR = 37;
          paramp.channel = this.mChannel;
          com.tencent.mm.pluginsdk.wallet.f.a(this, paramp, 1);
          AppMethodBeat.o(65715);
          return true;
        }
        if (paramInt2 == 268502454)
        {
          k.d(this, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(65689);
              if (bc.l(paramp))
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
        this.hXQ = 2;
        paramp = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramp = getString(a.i.wallet_unknown_err);
        }
        setContentViewVisibility(4);
        k.a(this, paramp, null, false, new LuckyMoneyNewYearSendUI.3(this, this));
        AppMethodBeat.o(65715);
        return true;
      }
    } while (!(paramp instanceof ay));
    AppMethodBeat.o(65715);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI
 * JD-Core Version:    0.7.0.1
 */