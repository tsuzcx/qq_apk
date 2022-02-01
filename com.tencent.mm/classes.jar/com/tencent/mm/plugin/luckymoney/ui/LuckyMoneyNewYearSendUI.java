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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.d.i;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
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
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private int dYe;
  private View.OnClickListener kuO;
  private int mChannel;
  private MMHandler mHandler;
  private EmojiInfo rfq;
  private Button rlN;
  private Dialog tipDialog;
  private String yUc;
  private int yUr;
  private String yXk;
  private int yXm;
  private int yXt;
  private LinkedList<ab> yXw;
  private String yYP;
  private TextView yln;
  private int zdC;
  private a zdk;
  private View zdl;
  private ChatFooterPanel zdv;
  private ViewGroup zdx;
  private LuckyMoneyAutoScrollView zeW;
  private TextView zeX;
  private TextView zfA;
  private ImageView zfB;
  private TextView zfC;
  private ImageView zfD;
  private ImageView zfE;
  private TextView zfF;
  private LinearLayout zfG;
  private MMAnimateView zfH;
  private LinearLayout zfI;
  private String zfJ;
  private boolean zfK;
  private int zfL;
  private int zfM;
  private EmojiInfo zfN;
  private ex zfO;
  private ey zfP;
  private int zfQ;
  private int zfR;
  private int zfS;
  private int zfT;
  private int zfU;
  private int zfV;
  private long zfW;
  private String zfX;
  private int zfY;
  private com.tencent.mm.emoji.d.a zfZ;
  private ImageView zfk;
  private View zfl;
  private BaseEmojiView zfm;
  private View zfy;
  private View zfz;
  private String zga;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(65703);
    this.tipDialog = null;
    this.zfK = true;
    this.zfL = 0;
    this.yXt = 0;
    this.zfM = 0;
    this.mHandler = new MMHandler();
    this.zfQ = 1;
    this.zdC = 0;
    this.zfR = 0;
    this.zfS = 0;
    this.zfT = 0;
    this.zfU = 0;
    this.zfV = 0;
    this.zfW = 0L;
    this.yUc = "";
    this.zfX = "";
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65693);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getId() == 2131304193)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
          LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65693);
          return;
          if (paramAnonymousView.getId() == 2131304195)
          {
            LuckyMoneyNewYearSendUI.this.finish();
            com.tencent.mm.plugin.report.service.h.CyF.a(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ex());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eEH = 11L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bfK();
            LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          }
          else if ((paramAnonymousView.getId() == 2131304182) || (paramAnonymousView.getId() == 2131304187))
          {
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ex());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eEH = 3L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bfK();
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
          else if (paramAnonymousView.getId() == 2131304184)
          {
            LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
            g.aAh().azQ().set(ar.a.Oab, "");
            com.tencent.mm.plugin.report.service.h.CyF.a(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ex());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eEH = 5L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bfK();
          }
          else if (paramAnonymousView.getId() == 2131304190)
          {
            paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
            paramAnonymousView.hasCallBack = false;
            paramAnonymousView.zbJ.setVisibility(0);
            paramAnonymousView.zbK.setVisibility(0);
            paramAnonymousView.zbL.setVisibility(0);
            paramAnonymousView.zbP.setVisibility(4);
            paramAnonymousView.zbQ.setVisibility(4);
            paramAnonymousView.zbR.setVisibility(4);
            LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
            com.tencent.mm.plugin.report.service.h.CyF.a(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new ex());
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).eEH = 2L;
            LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).bfK();
          }
          else if (paramAnonymousView.getId() == 2131304191)
          {
            paramAnonymousView = i.hdO;
            i.zm(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
          }
          else if (paramAnonymousView.getId() == 2131304181)
          {
            LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          }
        }
      }
    };
    this.zfY = 0;
    this.zfZ = new LuckyMoneyNewYearSendUI.4(this);
    this.dYe = 0;
    this.zga = "";
    AppMethodBeat.o(65703);
  }
  
  private void PV(int paramInt)
  {
    AppMethodBeat.i(65708);
    this.zfP = new ey();
    this.zfP.enl = paramInt;
    this.zfP.eEI = this.zfQ;
    this.zfP.eEJ = this.zfR;
    this.zfP.eEK = this.zfS;
    this.zfP.eEL = this.zfT;
    this.zfP.eEO = this.zfU;
    this.zfP.eEM = this.zfV;
    ey localey = this.zfP;
    if (this.rfq == null) {}
    for (String str = "";; str = this.rfq.getMd5())
    {
      localey.rU(str);
      this.zfP.bfK();
      AppMethodBeat.o(65708);
      return;
    }
  }
  
  private void PW(int paramInt)
  {
    AppMethodBeat.i(65711);
    if (Util.isEqual(this.yXt, 0))
    {
      this.zfk.setVisibility(0);
      this.zfz.setVisibility(8);
      this.zfl.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
    }
    this.zfk.setVisibility(8);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65711);
      return;
      this.zfz.setVisibility(0);
      this.zfA.setText(2131762578);
      this.zfl.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.zfz.setVisibility(8);
      this.zfl.setVisibility(0);
      this.zfD.setVisibility(0);
      this.zfm.setVisibility(8);
      this.zfE.setVisibility(8);
      this.zfF.setVisibility(8);
      this.zfG.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      if (this.zfN != null)
      {
        this.zfO = new ex();
        this.zfO.eEH = 4L;
        this.zfO.bfK();
      }
      this.zfN = this.rfq;
      if (this.zdC == 0) {
        if (com.tencent.mm.plugin.emoji.h.b.y(this.rfq)) {
          this.zfQ = 2;
        }
      }
      for (;;)
      {
        this.zfz.setVisibility(8);
        this.zfl.setVisibility(0);
        this.zfD.setVisibility(8);
        this.zfm.setVisibility(0);
        this.zfE.setVisibility(0);
        this.zfF.setVisibility(8);
        this.zfG.setVisibility(8);
        AppMethodBeat.o(65711);
        return;
        if (com.tencent.mm.plugin.emoji.h.b.w(this.rfq))
        {
          this.zfQ = 4;
        }
        else
        {
          this.zfQ = 3;
          continue;
          if (this.zdC == 1)
          {
            this.zfQ = 2;
            this.zfS += 1;
          }
          else if (this.zdC == 2)
          {
            if (com.tencent.mm.plugin.emoji.h.b.y(this.rfq))
            {
              this.zfQ = 2;
              this.zfV += 1;
            }
            else if (com.tencent.mm.plugin.emoji.h.b.w(this.rfq))
            {
              this.zfQ = 4;
              this.zfU += 1;
            }
            else
            {
              this.zfQ = 3;
              this.zfT += 1;
            }
          }
        }
      }
      this.zfz.setVisibility(8);
      this.zfl.setVisibility(0);
      this.zfD.setVisibility(8);
      this.zfm.setVisibility(8);
      this.zfE.setVisibility(8);
      this.zfF.setVisibility(0);
      this.zfG.setVisibility(8);
      AppMethodBeat.o(65711);
      return;
      this.zfz.setVisibility(8);
      this.zfl.setVisibility(0);
      this.zfD.setVisibility(8);
      this.zfm.setVisibility(8);
      this.zfE.setVisibility(8);
      this.zfF.setVisibility(8);
      this.zfG.setVisibility(0);
      this.zfH.setImageResource(2131691047);
      AppMethodBeat.o(65711);
      return;
      this.zfz.setVisibility(0);
      this.zfA.setText(2131762677);
      this.zfl.setVisibility(8);
    }
  }
  
  private void PX(int paramInt)
  {
    AppMethodBeat.i(65712);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.tipDialog != null) {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
    }
    for (;;)
    {
      String str2 = com.tencent.mm.model.z.aTY();
      String str1 = "";
      int i = 0;
      if (this.rfq != null)
      {
        str1 = this.rfq.getMd5();
        i = this.rfq.field_type;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.zfX, Integer.valueOf(paramInt), Integer.valueOf(this.dYe), this.yUc });
      doSceneProgress(new bc(this.yXm, this.yXk, af.aDw(str2), this.zfJ, str2, com.tencent.mm.model.z.aUa(), this.yUr, str1, i, this.zfX, paramInt, this.dYe, this.yUc), false);
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
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
            LuckyMoneyNewYearSendUI.this.finish();
          }
          LuckyMoneyNewYearSendUI.this.zbX.forceCancel();
          AppMethodBeat.o(65698);
        }
      });
    }
  }
  
  private void aDE(String paramString)
  {
    AppMethodBeat.i(65710);
    this.rfq = k.getEmojiStorageMgr().OpN.blk(paramString);
    this.zfm.setEmojiInfo(this.rfq);
    PW(2);
    g.aAh().azQ().set(ar.a.Oab, paramString);
    AppMethodBeat.o(65710);
  }
  
  private void egq()
  {
    AppMethodBeat.i(65709);
    this.zfO = new ex();
    this.zfO.eEH = 10L;
    this.zfO.bfK();
    this.zdC = 2;
    this.zdk.show();
    if (Util.isEqual(this.zfL, 1)) {}
    for (int i = ChatFooterPanel.KbK;; i = ChatFooterPanel.KbH)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.b.a(this.zdx, this.zdv, i, new ac.a()
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
          AppMethodBeat.i(258347);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(258347);
        }
      });
      AppMethodBeat.o(65709);
      return;
    }
  }
  
  private void egr()
  {
    AppMethodBeat.i(65713);
    this.zfR += 1;
    int i;
    if ((this.yXw != null) && (this.yXw.size() > 0))
    {
      g.aAi();
      g.aAf();
      i = com.tencent.mm.kernel.a.getUin();
      int j = this.yXw.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.zfM = i;
      if ((this.zfM >= 0) && (this.zfM < this.yXw.size()))
      {
        this.yXm = ((ab)this.yXw.get(this.zfM)).yWB;
        this.yXk = ((ab)this.yXw.get(this.zfM)).yWC;
      }
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.zfM + " randomAmount:" + this.yXm + " randomWishing:" + this.yXk);
      this.zeW.setFinalText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.yXm / 100.0D));
      qO(false);
      this.zeW.setFocusable(false);
      this.zeW.setContentDescription("");
      this.zeW.a(new LuckyMoneyAutoScrollView.a()
      {
        public final void efY()
        {
          AppMethodBeat.i(65700);
          if (LuckyMoneyNewYearSendUI.s(LuckyMoneyNewYearSendUI.this))
          {
            LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this).setVisibility(4);
            af.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
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
            af.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.t(LuckyMoneyNewYearSendUI.this), LuckyMoneyNewYearSendUI.u(LuckyMoneyNewYearSendUI.this));
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
  
  private void qO(boolean paramBoolean)
  {
    AppMethodBeat.i(65714);
    this.rlN.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.rlN.getBackground() != null) && (this.rlN.getBackground().mutate() != null)) {
        this.rlN.getBackground().mutate().setAlpha(255);
      }
      this.rlN.setTextColor(getResources().getColor(2131100762));
      AppMethodBeat.o(65714);
      return;
    }
    if ((this.rlN.getBackground() != null) && (this.rlN.getBackground().mutate() != null)) {
      this.rlN.getBackground().mutate().setAlpha(128);
    }
    this.rlN.setTextColor(getResources().getColor(2131100763));
    AppMethodBeat.o(65714);
  }
  
  public int getLayoutId()
  {
    return 2131495374;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65706);
    setActionbarColor(-839716110);
    setContentViewVisibility(8);
    this.zfy = findViewById(2131304209);
    this.zeX = ((TextView)findViewById(2131304017));
    this.zeW = ((LuckyMoneyAutoScrollView)findViewById(2131304179));
    this.yln = ((TextView)findViewById(2131304196));
    this.rlN = ((Button)findViewById(2131304193));
    this.rlN.setOnClickListener(this.kuO);
    ((ImageView)findViewById(2131304195)).setOnClickListener(this.kuO);
    this.zfk = ((ImageView)findViewById(2131304188));
    this.zfz = findViewById(2131304186);
    this.zfA = ((TextView)findViewById(2131304187));
    this.zfB = ((ImageView)findViewById(2131304182));
    this.zfB.setOnClickListener(this.kuO);
    this.zfC = ((TextView)findViewById(2131304187));
    this.zfC.setOnClickListener(this.kuO);
    this.zfl = findViewById(2131304185);
    this.zfm = ((BaseEmojiView)findViewById(2131304181));
    this.zfm.setOnClickListener(this.kuO);
    this.zfE = ((ImageView)findViewById(2131304184));
    this.zfE.setOnClickListener(this.kuO);
    this.zfD = ((ImageView)findViewById(2131304183));
    this.zfF = ((TextView)findViewById(2131304191));
    this.zfF.setOnClickListener(this.kuO);
    this.zfG = ((LinearLayout)findViewById(2131304180));
    this.zfH = ((MMAnimateView)findViewById(2131303704));
    this.zfI = ((LinearLayout)findViewById(2131304190));
    this.zfI.setOnClickListener(this.kuO);
    this.zdk = new a(this);
    this.zdl = getLayoutInflater().inflate(2131495362, null);
    this.zdk.setContentView(this.zdl, new ViewGroup.LayoutParams(-1, -1));
    this.zdl.findViewById(2131304101).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65688);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65688);
      }
    });
    this.zdk.zbp = new a.a()
    {
      public final void efU()
      {
        AppMethodBeat.i(65692);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(65692);
      }
    };
    this.zdx = ((ViewGroup)this.zdl.findViewById(2131304103));
    this.zdv = com.tencent.mm.pluginsdk.ui.chat.e.Knc.eZ(getContext());
    this.zdv.setTalkerName(this.zfJ);
    this.zdv.setShowSmiley(false);
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
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
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
      if (this.rfq == null)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = XmlParser.parseXml(this.yYP, "msg", null);
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
            int i = this.yYP.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.yYP.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.rfq != null) {
                break label362;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.e.a(localStringBuilder, (com.tencent.mm.g.c.bj)localObject1, 0);
              localObject1 = new StringBuilder(this.yYP.substring(0, i));
              String str = this.yYP.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.yYP = ((StringBuilder)localObject1).toString();
            }
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label362:
          localObject2 = this.rfq;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu((String)localObject2))
      {
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.yYP });
        af.ac(this.yYP, this.zfJ, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.zfO = new ex();
        if (this.zfQ != 1) {
          break label567;
        }
        this.zfO.eEH = 8L;
        label469:
        this.zfO.bfK();
        PV(1);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.z.aTY();
        if (paramInt2 != -1) {
          break label641;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.dYe = 1;
        this.zga = "";
        paramIntent = new aw(this.yUc, this.zfX, 1, (String)localObject2, Util.nullAsNil(this.zfJ));
        g.aAg().hqi.a(paramIntent, 0);
        AppMethodBeat.o(65716);
        return;
        Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label567:
        if (this.zfQ == 2)
        {
          this.zfO.eEH = 6L;
          break label469;
        }
        if (this.zfQ == 3)
        {
          this.zfO.eEH = 7L;
          break label469;
        }
        if (this.zfQ != 4) {
          break label469;
        }
        this.zfO.eEH = 14L;
        break label469;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label641:
      if (paramIntent != null) {}
      for (this.dYe = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dYe = 3)
      {
        this.zga = this.yUc;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dYe) });
        paramIntent = new aw(this.yUc, this.zfX, this.dYe, (String)localObject2, Util.nullAsNil(this.zfJ));
        break;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.zfW = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!Util.isEqual(this.zfW, 0L))
        {
          PW(4);
          qO(false);
          paramIntent = com.tencent.mm.emoji.d.b.hdv;
          com.tencent.mm.emoji.d.b.a(this.zfW, this.zfZ);
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
    PV(2);
    finish();
    AppMethodBeat.o(65707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65704);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.zfJ = getIntent().getStringExtra("key_username");
    this.yUr = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (Util.isNullOrNil(this.zfJ))
    {
      Log.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new aq("v1.0", ((Integer)g.aAh().azQ().get(ar.a.Ofm, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.h.CyF.a(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(65704);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65705);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.zdv != null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.zdv.onPause();
      this.zdv.goC();
      this.zdv.destroy();
    }
    com.tencent.mm.emoji.d.b localb = com.tencent.mm.emoji.d.b.hdv;
    com.tencent.mm.emoji.d.b.b(this.zfW, this.zfZ);
    AppMethodBeat.o(65705);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(65715);
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramq;
        this.yXm = paramString.yXm;
        this.yXk = paramString.yXk;
        this.zfL = paramString.yXs;
        this.yXt = paramString.yXt;
        this.zfX = paramString.dUb;
        this.yXw = paramString.yXw;
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.zfL) });
        egr();
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.yXw != null) && (this.yXw.size() > 0))
        {
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.zfI.setVisibility(0);
          this.yln.getLayoutParams();
          this.yln.setTextSize(1, 21.0F);
          this.zeX.setTextSize(1, 15.0F);
          this.zeW.gV(getResources().getDimensionPixelOffset(2131166649), getResources().getDimensionPixelOffset(2131166645));
          paramString = (LinearLayout.LayoutParams)this.zeW.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166632);
          this.zeW.setLayoutParams(paramString);
          this.zeW.invalidate();
          paramString = (LinearLayout.LayoutParams)this.zfI.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166635);
          this.zfI.setLayoutParams(paramString);
          this.zfI.invalidate();
          paramString = (String)g.aAh().azQ().get(ar.a.Oab, "");
          if (!Util.isNullOrNil(paramString)) {
            break label407;
          }
          PW(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          af.a(this.zfy, null);
          AppMethodBeat.o(65715);
          return true;
          Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.zfI.setVisibility(8);
          break;
          label407:
          aDE(paramString);
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
        if ((paramq instanceof ba))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (ba)paramq;
            this.yYP = paramString.yXH;
            paramq = new PayInfo();
            paramq.dDL = paramString.wFL;
            paramq.dVv = 37;
            paramq.channel = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 1);
            AppMethodBeat.o(65715);
            return true;
          }
          Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        else
        {
          if (!(paramq instanceof bc)) {
            break;
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (bc)paramq;
            this.yYP = paramString.yXH;
            this.yUc = paramString.yQE;
            if (paramString.isJumpRemind())
            {
              Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
              {
                public final void bG(int paramAnonymousInt, String paramAnonymousString)
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
                    com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyNewYearSendUI.this, paramAnonymousString, 0, true);
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
            paramq.dDL = paramString.wFL;
            paramq.dVv = 37;
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
                if (ba.l(paramq))
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
    } while (!(paramq instanceof aw));
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