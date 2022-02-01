package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.lv;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.finder.live.report.q.bh;
import com.tencent.mm.plugin.finder.live.report.q.bi;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.bk;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.s.8;
import com.tencent.mm.plugin.luckymoney.model.s.9;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.j.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.mm.wallet_core.model.g;
import com.tencent.mm.wallet_core.model.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(7)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private static HashMap<String, ctq> KFv;
  private long Bti;
  private String IEA;
  private com.tencent.mm.am.h Iej;
  private TextView JCr;
  private WeImageView KAx;
  private ImageView KAy;
  private int KBU;
  private int KBW;
  private int KBl;
  private lv KBp;
  private Set<String> KBz;
  private boolean KFA;
  private ImageView KFw;
  private View KFx;
  private String KFy;
  private ResultReceiver KFz;
  private ImageView KmZ;
  private TextView KnP;
  private Button KnQ;
  private ImageView KnR;
  private View KnS;
  private ImageView KnT;
  private TextView KnU;
  private String KqM;
  private LinearLayout KqR;
  private TextView KqS;
  private View KqT;
  private ImageView KqU;
  private RelativeLayout KqV;
  private BaseEmojiView KqW;
  private TextView KqX;
  private LinearLayout KqY;
  private ProgressBar KqZ;
  private String Kra;
  private ad Krc;
  public int Krd;
  private bf Kvf;
  private int KzF;
  private String KzH;
  private String KzI;
  private int KzJ;
  private int lCR;
  private long lul;
  private int maxSize;
  private String sWX;
  private long startTime;
  private TextView tHK;
  private int textSize;
  private w tipDialog;
  private ViewGroup tth;
  private i.a xMB;
  private String xOC;
  private EmojiInfo xRp;
  private int xdN;
  
  static
  {
    AppMethodBeat.i(284588);
    KFv = new HashMap();
    AppMethodBeat.o(284588);
  }
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.Krc = null;
    this.Krd = 0;
    this.KFA = false;
    this.KBz = new HashSet();
    this.xMB = new i.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65732);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65731);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65730);
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.KCg != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5().equals(LuckyMoneyNotHookReceiveUI.1.1.this.KCg.getMd5())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.lKa)
                  {
                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.fYI();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.fYI();
                }
                AppMethodBeat.o(65730);
              }
            });
            AppMethodBeat.o(65731);
          }
        });
        AppMethodBeat.o(65732);
      }
    };
    this.Bti = 0L;
    this.KBU = 3;
    this.KBW = 0;
    this.Iej = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(284539);
        if ((Util.isEqual(paramAnonymousp.getType(), 697)) && ((paramAnonymousp instanceof com.tencent.mm.plugin.emoji.e.e)))
        {
          paramAnonymousString = (com.tencent.mm.plugin.emoji.e.e)paramAnonymousp;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.dAy();
            if ((paramAnonymousString != null) && (paramAnonymousString.YMz != null) && (paramAnonymousString.YMz.size() > 0) && (Util.isEqual(((amn)paramAnonymousString.YMz.get(0)).Md5, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5()))) {
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, false);
            }
          }
        }
        AppMethodBeat.o(284539);
      }
    };
    AppMethodBeat.o(65742);
  }
  
  private void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.KBW = 4;
    this.KqW.setEmojiInfo(paramEmojiInfo);
    this.KBp = new lv();
    this.KBp.iPe = 8L;
    this.KBp.bMH();
    AppMethodBeat.o(65751);
  }
  
  private void a(q.bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(284448);
    if (Util.isNullOrNil(this.KzH))
    {
      AppMethodBeat.o(284448);
      return;
    }
    if (com.tencent.mm.kernel.h.ax(cf.class) != null) {
      ((cf)com.tencent.mm.kernel.h.ax(cf.class)).a(parambi, q.bh.DAQ, paramBoolean);
    }
    AppMethodBeat.o(284448);
  }
  
  private void a(final ba paramba)
  {
    AppMethodBeat.i(65754);
    q localq = paramba.KtU;
    Object localObject;
    if (localq.ihA == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_intercept_win_after", paramba.KuJ);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.KqM, paramba.KtU);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramba.ihx);
        ((Intent)localObject).putExtra("key_sendid", paramba.CAf);
        ba((Intent)localObject);
        if (com.tencent.mm.k.i.aRC().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramba.Koa != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramba.Koa);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("scene_id", this.KzF);
        ((Intent)localObject).putExtra("key_emoji_switch", paramba.Kum);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramba.Kuk);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramba.Kul);
        ((Intent)localObject).putExtra("key_msgid", this.lul);
        ((Intent)localObject).putExtra("scene_id", this.KzF);
        paramba = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramba.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramba.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        String str = getIntent().getStringExtra("key_username");
        if (!ab.IN(str))
        {
          localObject = u.iiy().bgT(this.Kra);
          paramba = (ba)localObject;
          if (localObject == null) {
            paramba = new ad();
          }
          paramba.field_mNativeUrl = this.Kra;
          paramba.field_receiveAmount = localq.ihV;
          paramba.field_receiveTime = System.currentTimeMillis();
          paramba.field_hbStatus = localq.ihz;
          paramba.field_receiveStatus = localq.ihA;
          paramba.field_sender = str;
          paramba.field_sendId = this.KqM;
          paramba.field_exclusiveUsername = getIntent().getStringExtra("key_exclusive_username");
          if (paramba.field_receiveAmount > 0L) {
            u.iiy().a(paramba);
          }
        }
        fYE();
        AppMethodBeat.o(65754);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
        }
      }
    }
    this.KnQ.setBackgroundResource(a.e.lucky_money_receive_open_disabled_btn);
    this.KnQ.setText(a.i.lucky_money_open);
    this.KnQ.setOnClickListener(null);
    this.KnQ.setVisibility(8);
    this.KnR.setVisibility(8);
    if (!Util.isNullOrNil(localq.Kov))
    {
      this.tHK.setText(localq.Kov);
      this.tHK.setVisibility(0);
      this.JCr.setText(localq.KrL);
      localObject = (RelativeLayout.LayoutParams)this.KnS.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
      this.KnS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!com.tencent.mm.model.z.bAM().equals(this.IEA)) && (localq.ihy != 1)) {
        break label719;
      }
      this.KnS.setVisibility(0);
      this.KnS.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284479);
          Object localObject = new Intent();
          if (paramba.Koa != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramba.Koa);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramba.ihx);
          ((Intent)localObject).putExtra("key_sendid", paramba.CAf);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("scene_id", LuckyMoneyNotHookReceiveUI.p(LuckyMoneyNotHookReceiveUI.this));
          ((Intent)localObject).putExtra("key_emoji_switch", paramba.Kum);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramba.Kuk);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramba.Kul);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.q(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$21", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$21", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          AppMethodBeat.o(284479);
        }
      });
      this.KnT.setVisibility(8);
    }
    for (;;)
    {
      if ((localq.ihy == 1) && (localq.ihz == 4) && (!ah.uX(this.KzF)) && (this.lCR != 3)) {
        fYG();
      }
      fYF();
      AppMethodBeat.o(65754);
      return;
      this.tHK.setVisibility(8);
      break;
      label719:
      this.KnS.setVisibility(8);
      this.KnT.setVisibility(8);
    }
  }
  
  private void a(final ctq paramctq)
  {
    AppMethodBeat.i(284416);
    if ((isFinishing()) || (isDestroyed()))
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "the activity is finishing or destroyed.");
      AppMethodBeat.o(284416);
      return;
    }
    if (paramctq.aazq)
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "show envelope promo");
      final ViewGroup localViewGroup = (ViewGroup)findViewById(a.f.lucky_money_receive_envelope_biz_layout);
      Object localObject2 = (CdnImageView)localViewGroup.findViewById(a.f.lucky_money_receive_envelope_biz_icon_iv);
      Object localObject1 = (TextView)localViewGroup.findViewById(a.f.lucky_money_receive_envelope_biz_title_tv);
      int i = com.tencent.mm.cd.a.K(getContext(), com.tencent.mm.cd.a.ms(getContext()));
      ((TextView)localObject1).setMaxWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), i - 24 - 20 - 36 - 18));
      com.tencent.mm.wallet_core.ui.i.Q((TextView)localObject1);
      ((CdnImageView)localObject2).setRoundCorner(true);
      ((CdnImageView)localObject2).setUrl(paramctq.nQG);
      ((TextView)localObject1).setText(paramctq.title);
      long l;
      if (paramctq.aazu != null)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.cd.a.fromDPToPix(getContext(), 24));
        l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramctq.aazu.Zss, paramctq.aazu.Zst);
        if (l != -1L) {
          ((GradientDrawable)localObject2).setColor(com.tencent.mm.plugin.wallet_core.utils.n.argbColor(l));
        }
        localViewGroup.setBackground((Drawable)localObject2);
      }
      if (paramctq.aazt != null)
      {
        l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramctq.aazt.Zss, paramctq.aazt.Zst);
        if (l != -1L) {
          ((TextView)localObject1).setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.argbColor(l));
        }
      }
      localViewGroup.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284503);
          com.tencent.mm.wallet_core.ui.i.bC(LuckyMoneyNotHookReceiveUI.this.getContext(), paramctq.url);
          com.tencent.mm.plugin.report.service.h.OAn.b(22105, new Object[] { Integer.valueOf(3), Integer.valueOf(0), paramctq.aazv });
          AppMethodBeat.o(284503);
        }
      });
      localViewGroup.setVisibility(0);
      localObject1 = AnimationUtils.loadAnimation(getContext(), a.a.in_from_bottom);
      ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
      ((Animation)localObject1).setDuration(300L);
      ((Animation)localObject1).setFillAfter(true);
      ((Animation)localObject1).setFillEnabled(true);
      localObject2 = AnimationUtils.loadAnimation(getContext(), a.a.alpha_in);
      ((Animation)localObject2).setDuration(300L);
      ((Animation)localObject2).setFillEnabled(true);
      ((Animation)localObject2).setFillAfter(true);
      AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localViewGroup.startAnimation(localAnimationSet);
      com.tencent.mm.plugin.report.service.h.OAn.b(22105, new Object[] { Integer.valueOf(2), Integer.valueOf(0), paramctq.aazv });
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(284509);
          paramAnonymousAnimation = new Rect();
          localViewGroup.getGlobalVisibleRect(paramAnonymousAnimation);
          Point localPoint = aw.iQ(LuckyMoneyNotHookReceiveUI.this.getContext());
          if (paramAnonymousAnimation.bottom >= localPoint.y)
          {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "over bottom");
            paramAnonymousAnimation = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
            if (paramAnonymousAnimation != null)
            {
              paramAnonymousAnimation.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.aGE(16);
              localViewGroup.setLayoutParams(paramAnonymousAnimation);
            }
            paramAnonymousAnimation = (ViewGroup.MarginLayoutParams)LuckyMoneyNotHookReceiveUI.s(LuckyMoneyNotHookReceiveUI.this).getLayoutParams();
            if (paramAnonymousAnimation != null)
            {
              paramAnonymousAnimation.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.aGE(16);
              LuckyMoneyNotHookReceiveUI.s(LuckyMoneyNotHookReceiveUI.this).setLayoutParams(paramAnonymousAnimation);
            }
          }
          AppMethodBeat.o(284509);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(284416);
  }
  
  private static int aag(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  private void ba(Intent paramIntent)
  {
    AppMethodBeat.i(163761);
    paramIntent.putExtra("key_detail_envelope_url", getIntent().getStringExtra("key_detail_envelope_url"));
    paramIntent.putExtra("key_detail_envelope_md5", getIntent().getStringExtra("key_detail_envelope_md5"));
    paramIntent.putExtra("key_about_url", getIntent().getStringExtra("key_about_url"));
    paramIntent.putExtra("key_store_action_type", getIntent().getStringExtra("key_store_action_type"));
    paramIntent.putExtra("key_story_url", getIntent().getStringExtra("key_story_url"));
    paramIntent.putExtra("key_cropname", getIntent().getStringExtra("key_cropname"));
    paramIntent.putExtra("key_packet_id", getIntent().getStringExtra("key_packet_id"));
    paramIntent.putExtra("key_receive_envelope_widget_status_flag", getIntent().getIntExtra("key_receive_envelope_widget_status_flag", 0));
    paramIntent.putExtra("key_receive_envelope_fission_info", getIntent().getStringExtra("key_receive_envelope_fission_info"));
    paramIntent.putExtra("key_packet_create_time", getIntent().getIntExtra("key_packet_create_time", 0));
    paramIntent.putExtra("key_packet_source", getIntent().getIntExtra("key_packet_source", 0));
    paramIntent.putExtra("key_has_story", getIntent().getBooleanExtra("key_has_story", false));
    paramIntent.putExtra("key_material_flag", this.xdN);
    paramIntent.putExtra("key_from", getIntent().getIntExtra("key_from", 0));
    paramIntent.putExtra("key_live_id", getIntent().getStringExtra("key_live_id"));
    paramIntent.putExtra("key_live_attach", getIntent().getStringExtra("key_live_attach"));
    paramIntent.putExtra("key_live_anchor_type", getIntent().getIntExtra("key_live_anchor_type", 0));
    AppMethodBeat.o(163761);
  }
  
  private void fWC()
  {
    AppMethodBeat.i(65749);
    if (this.KnQ == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.d.MtP.aeR(this.KnQ.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.KnQ.setBackgroundResource(a.e.lucky_money_send_btn);
    this.KnQ.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(65749);
  }
  
  private void fYE()
  {
    AppMethodBeat.i(284382);
    if (this.KFz != null) {
      this.KFz.send(-1, null);
    }
    AppMethodBeat.o(284382);
  }
  
  private void fYF()
  {
    AppMethodBeat.i(284385);
    if (this.KFz != null) {
      this.KFz.send(1, null);
    }
    AppMethodBeat.o(284385);
  }
  
  private void fYG()
  {
    AppMethodBeat.i(284410);
    if (!com.tencent.mm.plugin.luckymoney.ui.a.a.bMS())
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "random drop this time");
      AppMethodBeat.o(284410);
      return;
    }
    Object localObject = (ctq)KFv.get(this.KqM);
    if (localObject != null)
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache response this time");
      a((ctq)localObject);
      AppMethodBeat.o(284410);
      return;
    }
    localObject = getIntent().getStringExtra("key_packet_id");
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get time limit promot: %s", new Object[] { localObject });
    new com.tencent.mm.plugin.luckymoney.model.f((String)localObject).bFJ().b(new com.tencent.mm.vending.c.a() {}).a(this);
    AppMethodBeat.o(284410);
  }
  
  private int fYH()
  {
    AppMethodBeat.i(65755);
    if (com.tencent.mm.model.z.bAM().equals(this.IEA))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void ya(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.KqX.setVisibility(8);
    this.KBW = 1;
    if (paramBoolean) {
      this.KBU = 3;
    }
    do
    {
      this.xRp = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(this.xOC);
      if (this.xRp == null) {
        break;
      }
      if ((y.bEl(this.xRp.kMn()) <= 0L) && (!this.xRp.aqJ()) && (!this.xRp.kMe())) {
        break label218;
      }
      this.KqW.setVisibility(0);
      C(this.xRp);
      AppMethodBeat.o(65750);
      return;
      this.KBU -= 1;
    } while (this.KBU != 0);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.KqY.setVisibility(8);
    this.KqX.setVisibility(0);
    this.KBW = 2;
    AppMethodBeat.o(65750);
    return;
    this.xRp = new EmojiInfo();
    this.xRp.field_md5 = this.xOC;
    this.xRp.field_type = this.KBl;
    label218:
    if (paramBoolean)
    {
      this.KqW.setVisibility(8);
      this.KqY.setVisibility(0);
      com.tencent.mm.plugin.emoji.model.s.dAj().xMB = this.xMB;
    }
    com.tencent.mm.plugin.emoji.model.s.dAj().u(this.xRp);
    com.tencent.mm.kernel.h.baD().mCm.a(697, this.Iej);
    AppMethodBeat.o(65750);
  }
  
  public final void aKN(String paramString)
  {
    AppMethodBeat.i(284736);
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      String str1 = getIntent().getStringExtra("key_username");
      if (ah.uX(this.KzF))
      {
        paramString = new bb(this.Kvf.msgType, this.Kvf.channelId, this.Kvf.CAf, this.Kvf.ihx, ah.fXi(), com.tencent.mm.model.z.bAO(), str1, "v1.0", this.Kvf.KuX);
        if (ab.IN(str1))
        {
          str1 = getIntent().getStringExtra("key_emoji_md5");
          if (Util.isNullOrNil(str1)) {
            break label315;
          }
        }
      }
      label315:
      for (boolean bool = true;; bool = false)
      {
        paramString.KtL = new s.9(bool, str1);
        com.tencent.mm.plugin.luckymoney.a.d.BI(2);
        doSceneProgress(paramString, false);
        this.KnQ.setVisibility(8);
        ah.n(this.KnR);
        AppMethodBeat.o(284736);
        return;
        if (this.lCR == 3)
        {
          String str2 = getIntent().getStringExtra("key_live_id");
          String str3 = getIntent().getStringExtra("key_live_attach");
          paramString = new com.tencent.mm.plugin.luckymoney.model.a.b(this.Kvf.msgType, this.Kvf.channelId, this.Kvf.CAf, this.Kvf.ihx, ah.fXi(), com.tencent.mm.model.z.bAO(), str1, "v1.0", this.Kvf.KuX, paramString, str2, str3, this.KzJ);
          break;
        }
        paramString = new ba(this.Kvf.msgType, this.Kvf.channelId, this.Kvf.CAf, this.Kvf.ihx, ah.fXi(), com.tencent.mm.model.z.bAO(), str1, "v1.0", this.Kvf.KuX, paramString);
        break;
      }
    }
  }
  
  public boolean enableActivityAnimation()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(65747);
    super.finish();
    overridePendingTransition(0, a.a.fast_alot_faded_out);
    AppMethodBeat.o(65747);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65748);
    this.KqT = findViewById(a.f.lucky_money_receive_test_ll);
    this.tth = ((ViewGroup)findViewById(a.f.lucky_money_receive_root_view));
    this.KqR = ((LinearLayout)findViewById(a.f.lucky_money_sender_detail_ll));
    this.KmZ = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.KnP = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.tHK = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.JCr = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.KqV = ((RelativeLayout)findViewById(a.f.lucky_money_emoji_layout));
    this.KqW = ((BaseEmojiView)findViewById(a.f.lucky_money_emoji));
    this.KqX = ((TextView)findViewById(a.f.lucky_money_reload_emoji));
    this.KqY = ((LinearLayout)findViewById(a.f.lucky_money_loading_emoji_area));
    this.KqZ = ((ProgressBar)findViewById(a.f.emoji_loading_image));
    this.KnQ = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.KnR = ((ImageView)findViewById(a.f.lucky_money_recieve_open_animateview));
    this.KnU = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.KnS = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.KnT = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    this.KqU = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_iv));
    this.KFw = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_mask_iv));
    this.KAy = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_widget));
    this.KFx = findViewById(a.f.lucky_money_receive_envelope_widget_ll);
    this.KqS = ((TextView)findViewById(a.f.lucky_money_recieve_temp_label_tv));
    this.KAx = ((WeImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.KAx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284470);
        LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this);
        LuckyMoneyNotHookReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.h.OAn.b(22105, new Object[] { Integer.valueOf(4), Long.valueOf(Util.ticksToNow(LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this)) / 1000L) });
        AppMethodBeat.o(284470);
      }
    });
    if (this.lCR == 3)
    {
      this.KAx.setEnableColorFilter(true);
      this.KAx.setImageResource(a.h.icons_outlined_close2);
      this.KAx.setIconColor(getResources().getColor(a.c.White));
      this.KqX.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284496);
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, true);
          AppMethodBeat.o(284496);
        }
      });
      this.tHK.setLines(2);
      androidx.core.widget.j.c(this.tHK);
      this.maxSize = ((int)(com.tencent.mm.cd.a.bs(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize) * 1.125F));
      this.textSize = com.tencent.mm.cd.a.br(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize);
      if (this.textSize <= this.maxSize) {
        break label507;
      }
    }
    label507:
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      showLoading();
      fWC();
      AppMethodBeat.o(65748);
      return;
      this.KAx.setEnableColorFilter(false);
      this.KAx.setImageResource(a.e.lucky_money_close_btn);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(65743);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.transparent));
    }
    this.startTime = Util.currentTicks();
    this.Kra = getIntent().getStringExtra("key_native_url");
    this.KFy = getIntent().getStringExtra("key_cropname");
    this.lul = getIntent().getLongExtra("key_msgid", 0L);
    this.xdN = getIntent().getIntExtra("key_material_flag", 0);
    this.KzF = getIntent().getIntExtra("scene_id", 1002);
    this.sWX = getIntent().getStringExtra("key_username");
    this.lCR = getIntent().getIntExtra("key_from", 0);
    this.KzH = getIntent().getStringExtra("key_live_id");
    this.KzI = getIntent().getStringExtra("key_live_attach");
    this.KFz = ((ResultReceiver)getIntent().getParcelableExtra("key_open_result_receiver"));
    this.KzJ = getIntent().getIntExtra("key_live_anchor_type", 0);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + Util.nullAsNil(this.Kra));
    initView();
    paramBundle = Uri.parse(Util.nullAsNil(this.Kra));
    try
    {
      this.KqM = paramBundle.getQueryParameter("sendid");
      label279:
      this.Krc = u.iiy().bgT(this.Kra);
      if ((this.Krc != null) && (this.Krc.field_receiveAmount > 0L) && (Util.milliSecondsToNow(this.Krc.field_receiveTime) < 86400000L))
      {
        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.Krc.field_receiveTime), Util.nullAsNil(this.Kra) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.Krc.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.KqM);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("scene_id", this.KzF);
        paramBundle.putExtra("key_msgid", this.lul);
        ba(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      int i;
      String str1;
      if (!Util.isNullOrNil(this.KqM))
      {
        i = Util.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.IEA = paramBundle.getQueryParameter("sendusername");
        str1 = getIntent().getStringExtra("key_username");
        if (ah.uX(this.KzF))
        {
          paramBundle = new bg(i, this.KqM, this.Kra, getIntent().getIntExtra("key_way", 0), "v1.0");
          if (ab.IN(str1))
          {
            str1 = getIntent().getStringExtra("key_emoji_md5");
            if (Util.isNullOrNil(str1)) {
              break label870;
            }
            bool1 = true;
            label676:
            paramBundle.KtL = new s.8(bool1, str1);
          }
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          label710:
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(284534);
              LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this);
              LuckyMoneyNotHookReceiveUI.this.finish();
              AppMethodBeat.o(284534);
              return false;
            }
          });
          if (!Util.isNullOrNil(this.KqM))
          {
            paramBundle = q.bi.DAX;
            if (this.lCR != 3) {
              break label891;
            }
          }
        }
      }
      label870:
      label891:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a(paramBundle, bool1);
        AppMethodBeat.o(65743);
        return;
        if (this.lCR == 3)
        {
          paramBundle = getIntent().getStringExtra("key_live_id");
          String str2 = getIntent().getStringExtra("key_live_attach");
          paramBundle = new com.tencent.mm.plugin.luckymoney.model.a.e(i, this.KqM, this.Kra, getIntent().getIntExtra("key_way", 0), "v1.0", str1, paramBundle, str2, this.KzJ);
          break;
        }
        paramBundle = new bf(i, this.KqM, this.Kra, getIntent().getIntExtra("key_way", 0), "v1.0", str1);
        break;
        bool1 = false;
        break label676;
        finish();
        Log.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
        break label710;
      }
    }
    catch (Exception localException)
    {
      break label279;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65744);
    super.onDestroy();
    if ((this.KBW == 1) || (this.KBW == 2))
    {
      this.KBp = new lv();
      this.KBp.iPe = 9L;
      this.KBp.bMH();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.plugin.emoji.model.s.dAj().xMB = null;
    com.tencent.mm.kernel.h.baD().mCm.b(697, this.Iej);
    Iterator localIterator = this.KBz.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      az.a.okP.Jq(str);
    }
    this.KBz.clear();
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.n("LuckyMoneyReceiveUI", this.Bti, Util.nowSecond());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.Bti = Util.nowSecond();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(65753);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    label463:
    label746:
    final boolean bool;
    label559:
    label1019:
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof bf))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Kvf = ((bf)paramp);
        this.Krd = this.Kvf.Krd;
        com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(aag(this.Kvf.ihy)), Integer.valueOf(fYH()), Integer.valueOf(0), Integer.valueOf(1) });
        paramp = u.iiy().bgT(this.Kra);
        paramString = paramp;
        if (paramp == null) {
          paramString = new ad();
        }
        paramString.field_mNativeUrl = this.Kra;
        paramString.field_hbType = this.Kvf.ihy;
        paramString.field_hbStatus = this.Kvf.ihz;
        paramString.field_receiveStatus = this.Kvf.ihA;
        paramString.field_sendId = this.KqM;
        paramString.field_sender = this.sWX;
        u.iiy().a(paramString);
        if (this.Kvf.ihA == 2)
        {
          if (ah.uX(this.KzF)) {
            paramString = new ar(this.KqM, this.Kra, "v1.0");
          }
          for (;;)
          {
            doSceneProgress(paramString, false);
            fYE();
            AppMethodBeat.o(65753);
            return true;
            if (this.lCR == 3) {
              paramString = new com.tencent.mm.plugin.luckymoney.model.a.d(this.KqM, this.Kra, "v1.0", this.KzH, this.KzI, this.KzJ);
            } else {
              paramString = new aq(this.KqM, 11, 0, this.Kra, "v1.0");
            }
          }
        }
        if (!Util.isNullOrNil(this.Kvf.Kuk))
        {
          this.KBp = new lv();
          this.KBp.iPe = 7L;
          this.KBp.bMH();
        }
        if (this.Kvf.Ksr == 1)
        {
          this.KmZ.setVisibility(8);
          paramString = getIntent().getStringExtra("key_username");
          if (!ah.uX(this.KzF)) {
            break label1786;
          }
          if (!ab.IN(paramString)) {
            break label1676;
          }
          if ((!Util.isNullOrNil(this.Kvf.Ksi)) && (Util.isNullOrNil(this.Kvf.KuS))) {
            this.Kvf.KuS = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.Kvf.Ksi);
          }
          this.KnP.setText(this.Kvf.KuS);
          if ((this.Kvf.ihy == 1) && (this.Kvf.ihz == 4) && (!ah.uX(this.KzF)) && (this.lCR != 3))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(22105, new Object[] { Integer.valueOf(1) });
            fYG();
          }
          if ((!Util.isNullOrNil(this.Kvf.Kuk)) && (Util.isEqual(this.Krd, 1)))
          {
            this.xOC = this.Kvf.Kuk;
            this.KBl = this.Kvf.Kul;
            this.KqV.setVisibility(0);
            ya(true);
          }
          paramp = getIntent().getStringExtra("key_live_error_msg");
          if (!Util.isNullOrNil(paramp)) {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "live errorMsg: %s", new Object[] { paramp });
          }
          if (this.Kvf != null)
          {
            if (this.Kvf.ihz != 5) {
              break label2047;
            }
            a(q.bi.DBc, true);
          }
          bool = false;
          if ((this.Kvf.ihA == 1) || (this.Kvf.ihz == 4) || (this.Kvf.ihz == 5) || (this.Kvf.ihz == 1) || (!Util.isNullOrNil(paramp))) {
            break label2091;
          }
          if (!Util.isNullOrNil(this.Kvf.KrL))
          {
            this.tHK.setText(this.Kvf.KrL);
            this.tHK.setVisibility(0);
          }
          if (!Util.isNullOrNil(this.Kvf.Kmq))
          {
            ah.a(getContext(), this.JCr, this.Kvf.Kmq);
            this.JCr.setVisibility(0);
            this.tHK.setVisibility(8);
          }
          this.KnQ.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284303);
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(10, 3);
              com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.aah(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).ihy)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
              Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click! mLiveId[%s]", new Object[] { LuckyMoneyNotHookReceiveUI.n(LuckyMoneyNotHookReceiveUI.this) });
              LuckyMoneyNotHookReceiveUI.o(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, q.bi.DAZ);
              LuckyMoneyNotHookReceiveUI.this.aKN("");
              AppMethodBeat.o(284303);
            }
          });
          if (((!com.tencent.mm.model.z.bAM().equals(this.IEA)) && ((this.Kvf.ihy != 1) || (this.Kvf.ihz != 4)) && ((this.Kvf.ihy != 3) || (this.Kvf.ihz != 4))) || (!Util.isNullOrNil(paramp))) {
            break label2282;
          }
          if (this.Kvf.ihy == 1) {
            this.KnU.setText(a.i.lucky_money_detail_luck);
          }
          this.KnS.setVisibility(0);
          this.KnS.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(284427);
              if (bool) {
                com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.aah(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).ihy)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
              }
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
              ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).ihx);
              ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).CAf);
              ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("scene_id", LuckyMoneyNotHookReceiveUI.p(LuckyMoneyNotHookReceiveUI.this));
              ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.q(LuckyMoneyNotHookReceiveUI.this));
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyNotHookReceiveUI.this.finish();
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, q.bi.DBe);
              AppMethodBeat.o(284427);
            }
          });
          this.KnT.setVisibility(8);
          if ((ab.IN(paramString)) && (this.Kvf.KuY == null)) {
            this.Kvf.KuY = new bk();
          }
          if (this.Kvf.KuY == null) {
            break label2372;
          }
          paramString = getIntent().getStringExtra("key_receive_envelope_url");
          paramp = getIntent().getStringExtra("key_receive_envelope_md5");
          localObject1 = getIntent().getStringExtra("key_receive_envelope_widget_url");
          localObject2 = getIntent().getStringExtra("key_receive_envelope_widget_md5");
          if (!Util.isNullOrNil(paramString))
          {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
            if (this.Kvf.KuY.Kvd == null) {
              this.Kvf.KuY.Kvd = new czi();
            }
            this.Kvf.KuY.Kvd.aaEq = new czj();
            this.Kvf.KuY.Kvd.aaEq.nBe = paramString;
            this.Kvf.KuY.Kvd.aaEq.aaEM = paramp;
            this.Kvf.KuY.Kvd.aaEq.aaEP = ((String)localObject1);
            this.Kvf.KuY.Kvd.aaEq.aaEQ = ((String)localObject2);
          }
          paramp = this.Kvf.KuY.Kvd;
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
          if (paramp != null)
          {
            this.KFw.setImageResource(a.e.lucky_money_envelope_transparent_cap_widget);
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.KqU, paramp, null);
            this.KqU.setVisibility(0);
            this.KnT.setVisibility(8);
            this.KFA = true;
            if (this.xdN != 2) {
              break label2303;
            }
            this.KqS.setVisibility(0);
            label1339:
            paramString = (LinearLayout.LayoutParams)this.KqR.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);
            this.KqR.setLayoutParams(paramString);
            ah.z(this.JCr);
            ah.z(this.tHK);
            ah.z(this.KnP);
            paramString = "";
            if (paramp.aaEq != null) {
              paramString = paramp.aaEq.nBe;
            }
            com.tencent.mm.plugin.luckymoney.a.c.cg(2, paramString);
            if ((Util.isNullOrNil(paramp.aaEq.aaEP)) || (Util.isNullOrNil(paramp.aaEq.aaEQ))) {
              break label2315;
            }
            this.KAy.post(new LuckyMoneyNotHookReceiveUI.13(this));
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).b(this.KAy, paramp, null);
            this.KAy.setVisibility(0);
            this.KFx.setVisibility(0);
            ah.hZ(this.KAy);
            paramString = (ViewGroup.MarginLayoutParams)this.KAx.getLayoutParams();
            if (paramString != null)
            {
              paramString.topMargin = 0;
              this.KAx.setLayoutParams(paramString);
            }
          }
          label1535:
          getIntent().getStringExtra("key_username");
          if (!Util.isNullOrNil(this.Kvf.KuY.Kvd.aaEp)) {
            this.KFy = this.Kvf.KuY.Kvd.aaEp;
          }
          if (this.lCR != 3) {
            break label2457;
          }
          this.tth.setBackgroundResource(a.e.lucky_money_live_receive_bg);
          aw.t(this, getResources().getColor(a.c.UN_BW_0_Alpha_0_3));
          findViewById(a.f.lucky_money_receive_bg_mask_iv).setVisibility(8);
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.KqT.setVisibility(0);
          ah.hZ(this.KqT);
          break;
          ah.a(this.KmZ, this.Kvf.KrO, this.Kvf.Ksi);
          break label463;
          label1676:
          if ((!Util.isNullOrNil(this.Kvf.Ksi)) && (Util.isNullOrNil(this.Kvf.KuS))) {
            this.Kvf.KuS = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.Kvf.Ksi);
          }
          label1786:
          do
          {
            ah.a(getContext(), this.KnP, getString(a.i.lucky_money_whose, new Object[] { this.Kvf.KuS }));
            break;
            ah.a(getContext(), this.KnP, this.Kvf.KuS);
            break;
            if (ab.IN(paramString))
            {
              this.KnP.setText(this.Kvf.KuS);
              break;
            }
            if (this.Kvf.ihy == 3)
            {
              ah.a(getContext(), this.KnP, getString(a.i.lucky_money_whose2, new Object[] { this.Kvf.KuS }));
              break;
            }
          } while (this.lCR != 3);
          if (this.Kvf.KuT)
          {
            com.tencent.mm.kernel.h.baF();
            paramp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxv(this.Kvf.Ksi);
            if ((paramp != null) && (!Util.isNullOrNil(paramp.field_username)))
            {
              ah.a(getContext(), this.KnP, getString(a.i.lucky_money_whose2, new Object[] { this.Kvf.KuS }));
              break label559;
            }
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get contact: %s", new Object[] { this.Kvf.Ksi });
            this.KBz.add(this.Kvf.Ksi);
            az.a.okP.a(this.Kvf.Ksi, "", new az.b.a()
            {
              public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(284533);
                Log.v("MicroMsg.LuckyMoneyParseHelper", "getContact suc, user: %s", new Object[] { paramAnonymousString });
                if (paramAnonymousBoolean) {
                  com.tencent.threadpool.h.ahAA.bl(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(284292);
                      LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this).remove(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).Ksi);
                      LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).KuS = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).Ksi);
                      ah.a(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyNotHookReceiveUI.l(LuckyMoneyNotHookReceiveUI.this), LuckyMoneyNotHookReceiveUI.this.getString(a.i.lucky_money_whose2, new Object[] { LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).KuS }));
                      AppMethodBeat.o(284292);
                    }
                  });
                }
                AppMethodBeat.o(284533);
              }
            });
            break label559;
          }
          ah.a(getContext(), this.KnP, this.Kvf.KuS);
          break label559;
          label2047:
          if (this.Kvf.ihA == 1)
          {
            a(q.bi.DBb, true);
            break label746;
          }
          if (this.Kvf.ihz != 4) {
            break label746;
          }
          a(q.bi.DBa, true);
          break label746;
          label2091:
          this.KnQ.setVisibility(8);
          this.KnR.setVisibility(8);
          if (!Util.isNullOrNil(paramp))
          {
            this.tHK.setText(paramp);
            this.tHK.setVisibility(0);
          }
          label2280:
          for (;;)
          {
            this.JCr.setVisibility(8);
            localObject1 = (RelativeLayout.LayoutParams)this.KnS.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
            this.KnS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            fYF();
            bool = true;
            break;
            if (!Util.isNullOrNil(this.Kvf.Kov))
            {
              this.tHK.setText(this.Kvf.Kov);
              this.tHK.setVisibility(0);
            }
            for (;;)
            {
              if (Util.isNullOrNil(this.Kvf.KrL)) {
                break label2280;
              }
              this.JCr.setText(this.Kvf.KrL);
              this.JCr.setVisibility(0);
              this.JCr.setSingleLine(false);
              break;
              this.tHK.setVisibility(8);
            }
          }
          label2282:
          this.KnS.setVisibility(8);
          this.KnT.setVisibility(8);
          break label1019;
          label2303:
          this.KqS.setVisibility(8);
          break label1339;
          label2315:
          this.KAy.setVisibility(8);
          this.KFx.setVisibility(8);
          paramString = (ViewGroup.MarginLayoutParams)this.KAx.getLayoutParams();
          if (paramString == null) {
            break label1535;
          }
          paramString.topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
          this.KAx.setLayoutParams(paramString);
          break label1535;
          label2372:
          paramString = (LinearLayout.LayoutParams)this.KqR.getLayoutParams();
          if (!Util.isNullOrNil(this.xOC)) {}
          for (paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 118.0F))
          {
            if (com.tencent.mm.ce.c.iRs() != 1.0F) {
              paramString.topMargin = ((int)(paramString.topMargin / com.tencent.mm.ce.c.iRs()));
            }
            this.KqR.setLayoutParams(paramString);
            break;
          }
          label2457:
          if (aw.isDarkMode())
          {
            this.tth.setBackgroundResource(a.c.BW_0_Alpha_0_8);
            aw.t(this, getResources().getColor(a.c.BW_0_Alpha_0_8));
          }
          else
          {
            this.tth.setBackgroundResource(a.c.lucky_money_goldstyle_receive_bg_color_new);
            aw.t(this, getResources().getColor(a.c.lucky_money_goldstyle_receive_bg_color_new));
          }
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramp instanceof ba))
    {
      if ((paramp instanceof com.tencent.mm.plugin.luckymoney.model.a.b))
      {
        localObject2 = (com.tencent.mm.plugin.luckymoney.model.a.b)paramp;
        if (paramInt2 != 0)
        {
          int i = ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).Kvk;
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "whether doing the retry logic of NetSceneLiveOpenLuckyMoney, delayTimeMs: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            if (((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).Kvm != null)
            {
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).Kvm.put("policy_retry", "1");
              localObject1 = new com.tencent.mm.plugin.luckymoney.model.a.b(((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).Kvm);
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject1).CAf = ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).CAf;
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject1).ihx = ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).ihx;
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject1).talker = ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).talker;
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject1).oQk = ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject2).oQk;
            }
            while (localObject1 != null)
            {
              com.tencent.threadpool.h.ahAA.p(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(284422);
                  LuckyMoneyNotHookReceiveUI.this.doSceneProgress(this.KFF, false);
                  AppMethodBeat.o(284422);
                }
              }, i);
              AppMethodBeat.o(65753);
              return true;
              localObject1 = null;
            }
            Log.e("MicroMsg.LuckyMoneyNotHookReceiveUI", "The retryNetScene is null");
          }
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      ah.o(this.KnR);
      this.KnQ.setClickable(true);
      fWC();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ba)paramp;
        l.play(this, a.i.lucky_cashrecivedrevised);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new g()
        {
          public final void fWQ()
          {
            AppMethodBeat.i(284421);
            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, paramString);
            AppMethodBeat.o(284421);
          }
        })))
        {
          AppMethodBeat.o(65753);
          return true;
        }
        if (com.tencent.mm.plugin.wallet_core.utils.j.a(paramString.KtV))
        {
          setContentViewVisibility(4);
          new com.tencent.mm.plugin.wallet_core.utils.j(this).a(paramString.KtV, new j.a()
          {
            public final void a(dfc paramAnonymousdfc)
            {
              AppMethodBeat.i(284423);
              if (paramAnonymousdfc.action == 2)
              {
                LuckyMoneyNotHookReceiveUI.this.showLoading();
                LuckyMoneyNotHookReceiveUI.this.aKN(paramString.KuK);
                AppMethodBeat.o(284423);
                return;
              }
              LuckyMoneyNotHookReceiveUI.this.finish();
              AppMethodBeat.o(284423);
            }
          });
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.KFA) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 13);
        }
        AppMethodBeat.o(65753);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNotHookReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        this.KnQ.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
        this.KnQ.setVisibility(0);
        bool = ah.a(this, paramInt2, paramp, paramString, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null, 1003);
        AppMethodBeat.o(65753);
        return bool;
      }
      if (paramInt2 == 419)
      {
        com.tencent.mm.ui.base.k.a(getContext(), paramString, "", getContext().getString(a.i.lucky_money_dialog_i_know), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(284428);
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "click AlertDialog");
            LuckyMoneyNotHookReceiveUI.this.finish();
            AppMethodBeat.o(284428);
          }
        });
        this.KnQ.setVisibility(0);
        AppMethodBeat.o(65753);
        return true;
      }
      paramp = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramp = getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(284424);
          paramAnonymousDialogInterface.dismiss();
          LuckyMoneyNotHookReceiveUI.this.finish();
          AppMethodBeat.o(284424);
        }
      });
      AppMethodBeat.o(65753);
      return true;
    }
    if ((paramp instanceof aq))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramp;
        paramp = new Intent();
        paramp.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramp.putExtra("key_lucky_money_can_received", true);
        try
        {
          com.tencent.mm.plugin.luckymoney.a.b.a(this.KqM, paramString.KtU);
          paramp.putExtra("key_jump_from", 2);
          paramp.putExtra("key_native_url", this.Kra);
          paramp.putExtra("key_sendid", this.KqM);
          paramp.putExtra("key_anim_slide", true);
          paramp.putExtra("key_detail_emoji_md5", paramString.Kuk);
          paramp.putExtra("key_detail_emoji_type", paramString.Kul);
          paramp.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramp.putExtra("scene_id", this.KzF);
          paramp.putExtra("key_emoji_switch", paramString.Kum);
          paramp.putExtra("key_msgid", this.lul);
          ba(paramp);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(65753);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localException.getLocalizedMessage());
          }
        }
      }
      com.tencent.mm.ui.base.k.cZ(this, paramString);
      finish();
      AppMethodBeat.o(65753);
      return true;
    }
    AppMethodBeat.o(65753);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(284654);
    this.tipDialog = com.tencent.mm.ui.base.k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(284486);
        if ((LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).isShowing())) {
          LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).dismiss();
        }
        LuckyMoneyNotHookReceiveUI.this.KzD.forceCancel();
        if ((LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
          LuckyMoneyNotHookReceiveUI.this.finish();
        }
        AppMethodBeat.o(284486);
      }
    });
    AppMethodBeat.o(284654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */