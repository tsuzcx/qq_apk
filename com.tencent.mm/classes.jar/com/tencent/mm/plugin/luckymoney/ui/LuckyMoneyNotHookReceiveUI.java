package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
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
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.f.b.a.jk;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.finder.live.report.s.at;
import com.tencent.mm.plugin.finder.live.report.s.au;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.az;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.be;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.s.6;
import com.tencent.mm.plugin.luckymoney.model.s.7;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.utils.g.a;
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
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(7)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private static HashMap<String, cdu> ELg;
  private String CKp;
  private TextView DLp;
  private be ECe;
  private int EGA;
  private int EGw;
  private String EGy;
  private String EGz;
  private int EHU;
  private jk EHY;
  private com.tencent.mm.an.i EIA;
  private int EIC;
  private Set<String> EIi;
  private long EIx;
  private int EIz;
  private WeImageView ELh;
  private String ELi;
  private ResultReceiver ELj;
  private boolean ELk;
  private ImageView Eus;
  private TextView Evi;
  private Button Evj;
  private View Evk;
  private ImageView Evl;
  private TextView Evm;
  private String ExZ;
  private LinearLayout Eye;
  private TextView Eyf;
  private View Eyg;
  private ImageView Eyh;
  private RelativeLayout Eyi;
  private BaseEmojiView Eyj;
  private TextView Eyk;
  private LinearLayout Eyl;
  private ProgressBar Eym;
  private String Eyn;
  private af Eyp;
  public int Eyq;
  private long iSo;
  private int jaR;
  private int maxSize;
  private String pRV;
  private TextView qCM;
  private ViewGroup qoE;
  private long startTime;
  private int textSize;
  private s tipDialog;
  private i.a uEk;
  private String uFZ;
  private EmojiInfo uIz;
  private int uav;
  
  static
  {
    AppMethodBeat.i(225545);
    ELg = new HashMap();
    AppMethodBeat.o(225545);
  }
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.Eyp = null;
    this.Eyq = 0;
    this.ELk = false;
    this.EIi = new HashSet();
    this.uEk = new i.a()
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
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.EIM != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5().equals(LuckyMoneyNotHookReceiveUI.1.1.this.EIM.getMd5())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.jhK)
                  {
                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, p.getEmojiStorageMgr().VFH.bxK(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.ePZ();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.ePZ();
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
    this.EIx = 0L;
    this.EIz = 3;
    this.EIC = 0;
    this.EIA = new LuckyMoneyNotHookReceiveUI.16(this);
    AppMethodBeat.o(65742);
  }
  
  private void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.EIC = 4;
    this.Eyj.setEmojiInfo(paramEmojiInfo);
    this.EHY = new jk();
    this.EHY.gCd = 8L;
    this.EHY.bpa();
    AppMethodBeat.o(65751);
  }
  
  private static int Wk(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  private void a(s.au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(225512);
    if (Util.isNullOrNil(this.EGy))
    {
      AppMethodBeat.o(225512);
      return;
    }
    com.tencent.mm.plugin.finder.live.report.m.yCt.a(paramau, s.at.yJN, paramBoolean);
    AppMethodBeat.o(225512);
  }
  
  private void a(final az paramaz)
  {
    AppMethodBeat.i(65754);
    com.tencent.mm.plugin.luckymoney.model.q localq = paramaz.EAX;
    Object localObject;
    if (localq.gbq == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_intercept_win_after", paramaz.EBJ);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.ExZ, paramaz.EAX);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramaz.gbn);
        ((Intent)localObject).putExtra("key_sendid", paramaz.ybP);
        aF((Intent)localObject);
        if (com.tencent.mm.n.h.axc().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramaz.Evs != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramaz.Evs);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("scene_id", this.EGw);
        ((Intent)localObject).putExtra("key_emoji_switch", paramaz.EBo);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramaz.EBm);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramaz.EBn);
        ((Intent)localObject).putExtra("key_msgid", this.iSo);
        ((Intent)localObject).putExtra("scene_id", this.EGw);
        paramaz = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramaz.aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramaz.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        String str = getIntent().getStringExtra("key_username");
        if (!ab.Qg(str))
        {
          localObject = com.tencent.mm.plugin.wallet_core.model.u.gJk().bhj(this.Eyn);
          paramaz = (az)localObject;
          if (localObject == null) {
            paramaz = new af();
          }
          paramaz.field_mNativeUrl = this.Eyn;
          paramaz.field_receiveAmount = localq.gbJ;
          paramaz.field_receiveTime = System.currentTimeMillis();
          paramaz.field_hbStatus = localq.gbp;
          paramaz.field_receiveStatus = localq.gbq;
          paramaz.field_sender = str;
          paramaz.field_sendId = this.ExZ;
          paramaz.field_exclusiveUsername = getIntent().getStringExtra("key_exclusive_username");
          if (paramaz.field_receiveAmount > 0L) {
            com.tencent.mm.plugin.wallet_core.model.u.gJk().a(paramaz);
          }
        }
        ePV();
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
    this.Evj.setBackgroundResource(a.e.lucky_money_receive_open_disabled_btn);
    this.Evj.setText(a.i.lucky_money_open);
    this.Evj.setOnClickListener(null);
    this.Evj.setVisibility(8);
    if (!Util.isNullOrNil(localq.EvN))
    {
      this.qCM.setText(localq.EvN);
      this.qCM.setVisibility(0);
      this.DLp.setText(localq.EyY);
      localObject = (RelativeLayout.LayoutParams)this.Evk.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
      this.Evk.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!z.bcZ().equals(this.CKp)) && (localq.gbo != 1)) {
        break label710;
      }
      this.Evk.setVisibility(0);
      this.Evk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(235011);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent();
          if (paramaz.Evs != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramaz.Evs);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramaz.gbn);
          ((Intent)localObject).putExtra("key_sendid", paramaz.ybP);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("scene_id", LuckyMoneyNotHookReceiveUI.p(LuckyMoneyNotHookReceiveUI.this));
          ((Intent)localObject).putExtra("key_emoji_switch", paramaz.EBo);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramaz.EBm);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramaz.EBn);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.q(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235011);
        }
      });
      this.Evl.setVisibility(8);
    }
    for (;;)
    {
      if ((localq.gbo == 1) && (localq.gbp == 4) && (!ag.uK(this.EGw)) && (this.jaR != 3)) {
        ePX();
      }
      ePW();
      AppMethodBeat.o(65754);
      return;
      this.qCM.setVisibility(8);
      break;
      label710:
      this.Evk.setVisibility(8);
      this.Evl.setVisibility(8);
    }
  }
  
  private void a(cdu paramcdu)
  {
    AppMethodBeat.i(225472);
    if ((isFinishing()) || (isDestroyed()))
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "the activity is finishing or destroyed.");
      AppMethodBeat.o(225472);
      return;
    }
    if (paramcdu.Tly)
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "show envelope promo");
      final ViewGroup localViewGroup = (ViewGroup)findViewById(a.f.lucky_money_receive_envelope_biz_layout);
      Object localObject2 = (CdnImageView)localViewGroup.findViewById(a.f.lucky_money_receive_envelope_biz_icon_iv);
      Object localObject1 = (TextView)localViewGroup.findViewById(a.f.lucky_money_receive_envelope_biz_title_tv);
      int i = com.tencent.mm.ci.a.H(getContext(), com.tencent.mm.ci.a.kr(getContext()));
      ((TextView)localObject1).setMaxWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), i - 24 - 20 - 36 - 18));
      com.tencent.mm.wallet_core.ui.g.N((TextView)localObject1);
      ((CdnImageView)localObject2).setRoundCorner(true);
      ((CdnImageView)localObject2).setUrl(paramcdu.llI);
      ((TextView)localObject1).setText(paramcdu.title);
      long l;
      if (paramcdu.TlC != null)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.ci.a.fromDPToPix(getContext(), 24));
        l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramcdu.TlC.Stf, paramcdu.TlC.Stg);
        if (l != -1L) {
          ((GradientDrawable)localObject2).setColor(com.tencent.mm.plugin.wallet_core.utils.k.argbColor(l));
        }
        localViewGroup.setBackground((Drawable)localObject2);
      }
      if (paramcdu.TlB != null)
      {
        l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(paramcdu.TlB.Stf, paramcdu.TlB.Stg);
        if (l != -1L) {
          ((TextView)localObject1).setTextColor(com.tencent.mm.plugin.wallet_core.utils.k.argbColor(l));
        }
      }
      localViewGroup.setOnClickListener(new LuckyMoneyNotHookReceiveUI.9(this, paramcdu));
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
      com.tencent.mm.plugin.report.service.h.IzE.a(22105, new Object[] { Integer.valueOf(2), Integer.valueOf(0), paramcdu.TlD });
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(271234);
          paramAnonymousAnimation = new Rect();
          localViewGroup.getGlobalVisibleRect(paramAnonymousAnimation);
          Point localPoint = ar.hv(LuckyMoneyNotHookReceiveUI.this.getContext());
          if (paramAnonymousAnimation.bottom >= localPoint.y)
          {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "over bottom");
            paramAnonymousAnimation = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
            if (paramAnonymousAnimation != null)
            {
              paramAnonymousAnimation.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.azO(16);
              localViewGroup.setLayoutParams(paramAnonymousAnimation);
            }
            paramAnonymousAnimation = (ViewGroup.MarginLayoutParams)LuckyMoneyNotHookReceiveUI.s(LuckyMoneyNotHookReceiveUI.this).getLayoutParams();
            if (paramAnonymousAnimation != null)
            {
              paramAnonymousAnimation.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.azO(16);
              LuckyMoneyNotHookReceiveUI.s(LuckyMoneyNotHookReceiveUI.this).setLayoutParams(paramAnonymousAnimation);
            }
          }
          AppMethodBeat.o(271234);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(225472);
  }
  
  private void aF(Intent paramIntent)
  {
    AppMethodBeat.i(163761);
    paramIntent.putExtra("key_detail_envelope_url", getIntent().getStringExtra("key_detail_envelope_url"));
    paramIntent.putExtra("key_detail_envelope_md5", getIntent().getStringExtra("key_detail_envelope_md5"));
    paramIntent.putExtra("key_about_url", getIntent().getStringExtra("key_about_url"));
    paramIntent.putExtra("key_store_action_type", getIntent().getStringExtra("key_store_action_type"));
    paramIntent.putExtra("key_story_url", getIntent().getStringExtra("key_story_url"));
    paramIntent.putExtra("key_cropname", getIntent().getStringExtra("key_cropname"));
    paramIntent.putExtra("key_packet_id", getIntent().getStringExtra("key_packet_id"));
    paramIntent.putExtra("key_has_story", getIntent().getBooleanExtra("key_has_story", false));
    paramIntent.putExtra("key_material_flag", this.uav);
    paramIntent.putExtra("key_from", getIntent().getIntExtra("key_from", 0));
    paramIntent.putExtra("key_live_id", getIntent().getStringExtra("key_live_id"));
    paramIntent.putExtra("key_live_attach", getIntent().getStringExtra("key_live_attach"));
    paramIntent.putExtra("key_live_anchor_type", getIntent().getIntExtra("key_live_anchor_type", 0));
    AppMethodBeat.o(163761);
  }
  
  private void eOi()
  {
    AppMethodBeat.i(65749);
    if (this.Evj == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.d.GxJ.aay(this.Evj.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.Evj.setBackgroundResource(a.e.lucky_money_send_btn);
    this.Evj.setText(a.i.lucky_money_open_title);
    AppMethodBeat.o(65749);
  }
  
  private void ePV()
  {
    AppMethodBeat.i(225404);
    if (this.ELj != null) {
      this.ELj.send(-1, null);
    }
    AppMethodBeat.o(225404);
  }
  
  private void ePW()
  {
    AppMethodBeat.i(225406);
    if (this.ELj != null) {
      this.ELj.send(1, null);
    }
    AppMethodBeat.o(225406);
  }
  
  private void ePX()
  {
    AppMethodBeat.i(225458);
    if (!com.tencent.mm.plugin.luckymoney.ui.a.a.bpl())
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "random drop this time");
      AppMethodBeat.o(225458);
      return;
    }
    Object localObject = (cdu)ELg.get(this.ExZ);
    if (localObject != null)
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache response this time");
      a((cdu)localObject);
      AppMethodBeat.o(225458);
      return;
    }
    localObject = getIntent().getStringExtra("key_packet_id");
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get time limit promot: %s", new Object[] { localObject });
    new com.tencent.mm.plugin.luckymoney.model.e((String)localObject).bhW().b(new LuckyMoneyNotHookReceiveUI.8(this)).a(this);
    AppMethodBeat.o(225458);
  }
  
  private int ePY()
  {
    AppMethodBeat.i(65755);
    if (z.bcZ().equals(this.CKp))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void tO(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.Eyk.setVisibility(8);
    this.EIC = 1;
    if (paramBoolean) {
      this.EIz = 3;
    }
    do
    {
      this.uIz = p.getEmojiStorageMgr().VFH.bxK(this.uFZ);
      if (this.uIz == null) {
        break;
      }
      if ((com.tencent.mm.vfs.u.bBQ(this.uIz.ifh()) <= 0L) && (!this.uIz.Qv()) && (!this.uIz.hBu())) {
        break label218;
      }
      this.Eyj.setVisibility(0);
      C(this.uIz);
      AppMethodBeat.o(65750);
      return;
      this.EIz -= 1;
    } while (this.EIz != 0);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.Eyl.setVisibility(8);
    this.Eyk.setVisibility(0);
    this.EIC = 2;
    AppMethodBeat.o(65750);
    return;
    this.uIz = new EmojiInfo();
    this.uIz.field_md5 = this.uFZ;
    this.uIz.field_type = this.EHU;
    label218:
    if (paramBoolean)
    {
      this.Eyj.setVisibility(8);
      this.Eyl.setVisibility(0);
      p.cUM().uEk = this.uEk;
    }
    p.cUM().u(this.uIz);
    com.tencent.mm.kernel.h.aHF().kcd.a(697, this.EIA);
    AppMethodBeat.o(65750);
  }
  
  public final void aNP(String paramString)
  {
    AppMethodBeat.i(225511);
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      String str1 = getIntent().getStringExtra("key_username");
      if (ag.uK(this.EGw))
      {
        paramString = new ba(this.ECe.msgType, this.ECe.channelId, this.ECe.ybP, this.ECe.gbn, ag.eOH(), z.bdb(), str1, "v1.0", this.ECe.EBW);
        if (ab.Qg(str1))
        {
          str1 = getIntent().getStringExtra("key_emoji_md5");
          if (Util.isNullOrNil(str1)) {
            break label306;
          }
        }
      }
      label306:
      for (boolean bool = true;; bool = false)
      {
        paramString.EAO = new s.7(bool, str1);
        com.tencent.mm.plugin.luckymoney.a.d.Bv(2);
        doSceneProgress(paramString, false);
        ag.c(this.Evj);
        AppMethodBeat.o(225511);
        return;
        if (this.jaR == 3)
        {
          String str2 = getIntent().getStringExtra("key_live_id");
          String str3 = getIntent().getStringExtra("key_live_attach");
          paramString = new com.tencent.mm.plugin.luckymoney.model.a.b(this.ECe.msgType, this.ECe.channelId, this.ECe.ybP, this.ECe.gbn, ag.eOH(), z.bdb(), str1, "v1.0", this.ECe.EBW, paramString, str2, str3, this.EGA);
          break;
        }
        paramString = new az(this.ECe.msgType, this.ECe.channelId, this.ECe.ybP, this.ECe.gbn, ag.eOH(), z.bdb(), str1, "v1.0", this.ECe.EBW, paramString);
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
    this.Eyg = findViewById(a.f.lucky_money_receive_test_ll);
    this.qoE = ((ViewGroup)findViewById(a.f.lucky_money_receive_root_view));
    this.Eye = ((LinearLayout)findViewById(a.f.lucky_money_sender_detail_ll));
    this.Eus = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.Evi = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.qCM = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.DLp = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.Eyi = ((RelativeLayout)findViewById(a.f.lucky_money_emoji_layout));
    this.Eyj = ((BaseEmojiView)findViewById(a.f.lucky_money_emoji));
    this.Eyk = ((TextView)findViewById(a.f.lucky_money_reload_emoji));
    this.Eyl = ((LinearLayout)findViewById(a.f.lucky_money_loading_emoji_area));
    this.Eym = ((ProgressBar)findViewById(a.f.emoji_loading_image));
    this.Evj = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.Evm = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.Evk = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.Evl = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    this.Eyh = ((ImageView)findViewById(a.f.lucky_money_receive_envelope_iv));
    this.Eyf = ((TextView)findViewById(a.f.lucky_money_recieve_temp_label_tv));
    this.ELh = ((WeImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.ELh.setOnClickListener(new LuckyMoneyNotHookReceiveUI.13(this));
    if (this.jaR == 3)
    {
      this.ELh.setEnableColorFilter(true);
      this.ELh.setImageResource(a.h.icons_outlined_close2);
      this.ELh.setIconColor(getResources().getColor(a.c.White));
      this.Eyk.setOnClickListener(new LuckyMoneyNotHookReceiveUI.14(this));
      this.qCM.setLines(2);
      androidx.core.widget.i.c(this.qCM);
      this.maxSize = ((int)(com.tencent.mm.ci.a.aZ(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize) * 1.125F));
      this.textSize = com.tencent.mm.ci.a.aY(getContext(), a.d.lucky_money_goldstyle_envelop_wishing_textsize);
      if (this.textSize <= this.maxSize) {
        break label454;
      }
    }
    label454:
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      showLoading();
      eOi();
      AppMethodBeat.o(65748);
      return;
      this.ELh.setEnableColorFilter(false);
      this.ELh.setImageResource(a.e.lucky_money_close_btn);
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
    this.Eyn = getIntent().getStringExtra("key_native_url");
    this.ELi = getIntent().getStringExtra("key_cropname");
    this.iSo = getIntent().getLongExtra("key_msgid", 0L);
    this.uav = getIntent().getIntExtra("key_material_flag", 0);
    this.EGw = getIntent().getIntExtra("scene_id", 1002);
    this.pRV = getIntent().getStringExtra("key_username");
    this.jaR = getIntent().getIntExtra("key_from", 0);
    this.EGy = getIntent().getStringExtra("key_live_id");
    this.EGz = getIntent().getStringExtra("key_live_attach");
    this.ELj = ((ResultReceiver)getIntent().getParcelableExtra("key_open_result_receiver"));
    this.EGA = getIntent().getIntExtra("key_live_anchor_type", 0);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + Util.nullAsNil(this.Eyn));
    initView();
    paramBundle = Uri.parse(Util.nullAsNil(this.Eyn));
    try
    {
      this.ExZ = paramBundle.getQueryParameter("sendid");
      label279:
      this.Eyp = com.tencent.mm.plugin.wallet_core.model.u.gJk().bhj(this.Eyn);
      if ((this.Eyp != null) && (this.Eyp.field_receiveAmount > 0L) && (Util.milliSecondsToNow(this.Eyp.field_receiveTime) < 86400000L))
      {
        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.Eyp.field_receiveTime), Util.nullAsNil(this.Eyn) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.Eyp.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.ExZ);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("scene_id", this.EGw);
        paramBundle.putExtra("key_msgid", this.iSo);
        aF(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      int i;
      String str1;
      if (!Util.isNullOrNil(this.ExZ))
      {
        i = Util.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.CKp = paramBundle.getQueryParameter("sendusername");
        str1 = getIntent().getStringExtra("key_username");
        if (ag.uK(this.EGw))
        {
          paramBundle = new bf(i, this.ExZ, this.Eyn, getIntent().getIntExtra("key_way", 0), "v1.0");
          if (ab.Qg(str1))
          {
            str1 = getIntent().getStringExtra("key_emoji_md5");
            if (Util.isNullOrNil(str1)) {
              break label870;
            }
            bool1 = true;
            label676:
            paramBundle.EAO = new s.6(bool1, str1);
          }
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          label710:
          setBackBtn(new LuckyMoneyNotHookReceiveUI.12(this));
          if (!Util.isNullOrNil(this.ExZ))
          {
            paramBundle = s.au.yJU;
            if (this.jaR != 3) {
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
        if (this.jaR == 3)
        {
          paramBundle = getIntent().getStringExtra("key_live_id");
          String str2 = getIntent().getStringExtra("key_live_attach");
          paramBundle = new com.tencent.mm.plugin.luckymoney.model.a.e(i, this.ExZ, this.Eyn, getIntent().getIntExtra("key_way", 0), "v1.0", str1, paramBundle, str2, this.EGA);
          break;
        }
        paramBundle = new be(i, this.ExZ, this.Eyn, getIntent().getIntExtra("key_way", 0), "v1.0", str1);
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
    if ((this.EIC == 1) || (this.EIC == 2))
    {
      this.EHY = new jk();
      this.EHY.gCd = 9L;
      this.EHY.bpa();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    p.cUM().uEk = null;
    com.tencent.mm.kernel.h.aHF().kcd.b(697, this.EIA);
    Iterator localIterator = this.EIi.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      az.a.ltq.Rr(str);
    }
    this.EIi.clear();
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.l("LuckyMoneyReceiveUI", this.EIx, Util.nowSecond());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.EIx = Util.nowSecond();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65753);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    label463:
    final boolean bool;
    label559:
    label1019:
    Object localObject;
    if ((paramq instanceof be))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.ECe = ((be)paramq);
        this.Eyq = this.ECe.Eyq;
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(Wk(this.ECe.gbo)), Integer.valueOf(ePY()), Integer.valueOf(0), Integer.valueOf(1) });
        paramq = com.tencent.mm.plugin.wallet_core.model.u.gJk().bhj(this.Eyn);
        paramString = paramq;
        if (paramq == null) {
          paramString = new af();
        }
        paramString.field_mNativeUrl = this.Eyn;
        paramString.field_hbType = this.ECe.gbo;
        paramString.field_hbStatus = this.ECe.gbp;
        paramString.field_receiveStatus = this.ECe.gbq;
        paramString.field_sendId = this.ExZ;
        paramString.field_sender = this.pRV;
        com.tencent.mm.plugin.wallet_core.model.u.gJk().a(paramString);
        if (this.ECe.gbq == 2)
        {
          if (ag.uK(this.EGw)) {
            paramString = new aq(this.ExZ, this.Eyn, "v1.0");
          }
          for (;;)
          {
            doSceneProgress(paramString, false);
            ePV();
            AppMethodBeat.o(65753);
            return true;
            if (this.jaR == 3) {
              paramString = new com.tencent.mm.plugin.luckymoney.model.a.d(this.ExZ, this.Eyn, "v1.0", this.EGy, this.EGz, this.EGA);
            } else {
              paramString = new ap(this.ExZ, 11, 0, this.Eyn, "v1.0");
            }
          }
        }
        if (!Util.isNullOrNil(this.ECe.EBm))
        {
          this.EHY = new jk();
          this.EHY.gCd = 7L;
          this.EHY.bpa();
        }
        if (this.ECe.EzF == 1)
        {
          this.Eus.setVisibility(8);
          paramString = getIntent().getStringExtra("key_username");
          if (!ag.uK(this.EGw)) {
            break label1600;
          }
          if (!ab.Qg(paramString)) {
            break label1490;
          }
          if ((!Util.isNullOrNil(this.ECe.Ezw)) && (Util.isNullOrNil(this.ECe.EBR))) {
            this.ECe.EBR = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(this.ECe.Ezw);
          }
          this.Evi.setText(this.ECe.EBR);
          if ((this.ECe.gbo == 1) && (this.ECe.gbp == 4) && (!ag.uK(this.EGw)) && (this.jaR != 3))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(22105, new Object[] { Integer.valueOf(1) });
            ePX();
          }
          paramq = getIntent().getStringExtra("key_live_error_msg");
          if (!Util.isNullOrNil(paramq)) {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "live errorMsg: %s", new Object[] { paramq });
          }
          if (this.ECe != null)
          {
            if (this.ECe.gbp != 5) {
              break label1861;
            }
            a(s.au.yJY, true);
          }
          label687:
          bool = false;
          if ((this.ECe.gbq == 1) || (this.ECe.gbp == 4) || (this.ECe.gbp == 5) || (this.ECe.gbp == 1) || (!Util.isNullOrNil(paramq))) {
            break label1905;
          }
          if (!Util.isNullOrNil(this.ECe.EyY))
          {
            this.qCM.setText(this.ECe.EyY);
            this.qCM.setVisibility(0);
          }
          if (!Util.isNullOrNil(this.ECe.EtJ))
          {
            ag.a(getContext(), this.DLp, this.ECe.EtJ);
            this.DLp.setVisibility(0);
            this.qCM.setVisibility(8);
          }
          if ((!Util.isNullOrNil(this.ECe.EBm)) && (Util.isEqual(this.Eyq, 1)))
          {
            this.uFZ = this.ECe.EBm;
            this.EHU = this.ECe.EBn;
            this.Eyi.setVisibility(0);
            tO(true);
          }
          this.Evj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65741);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(10, 3);
              com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Wl(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).gbo)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
              Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click! mLiveId[%s]", new Object[] { LuckyMoneyNotHookReceiveUI.n(LuckyMoneyNotHookReceiveUI.this) });
              LuckyMoneyNotHookReceiveUI.o(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, s.au.yJV);
              LuckyMoneyNotHookReceiveUI.this.aNP("");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65741);
            }
          });
          if (((!z.bcZ().equals(this.CKp)) && ((this.ECe.gbo != 1) || (this.ECe.gbp != 4)) && ((this.ECe.gbo != 3) || (this.ECe.gbp != 4))) || (!Util.isNullOrNil(paramq))) {
            break label2087;
          }
          if (this.ECe.gbo == 1) {
            this.Evm.setText(a.i.lucky_money_detail_luck);
          }
          this.Evk.setVisibility(0);
          this.Evk.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(186655);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              if (bool) {
                com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.Wl(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).gbo)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
              }
              localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
              ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).gbn);
              ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).ybP);
              ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
              ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
              ((Intent)localObject).putExtra("scene_id", LuckyMoneyNotHookReceiveUI.p(LuckyMoneyNotHookReceiveUI.this));
              ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.q(LuckyMoneyNotHookReceiveUI.this));
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
              paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyNotHookReceiveUI.this.finish();
              LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, s.au.yKa);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186655);
            }
          });
          this.Evl.setVisibility(8);
          if ((ab.Qg(paramString)) && (this.ECe.EBX == null)) {
            this.ECe.EBX = new com.tencent.mm.plugin.luckymoney.model.bj();
          }
          if (this.ECe.EBX == null) {
            break label2120;
          }
          paramString = getIntent().getStringExtra("key_receive_envelope_url");
          paramq = getIntent().getStringExtra("key_receive_envelope_md5");
          if (!Util.isNullOrNil(paramString))
          {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
            if (this.ECe.EBX.ECc == null) {
              this.ECe.EBX.ECc = new cjf();
            }
            this.ECe.EBX.ECc.Tqo = new cjg();
            this.ECe.EBX.ECc.Tqo.kVK = paramString;
            this.ECe.EBX.ECc.Tqo.TqK = paramq;
          }
          paramq = this.ECe.EBX.ECc;
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
          if (paramq != null)
          {
            ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.Eyh, paramq, null);
            this.Eyh.setVisibility(0);
            this.Evl.setVisibility(8);
            this.ELk = true;
            if (this.uav != 2) {
              break label2108;
            }
            this.Eyf.setVisibility(0);
            label1269:
            paramString = (LinearLayout.LayoutParams)this.Eye.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);
            this.Eye.setLayoutParams(paramString);
            ag.y(this.DLp);
            ag.y(this.qCM);
            ag.y(this.Evi);
            paramString = "";
            if (paramq.Tqo != null) {
              paramString = paramq.Tqo.kVK;
            }
            com.tencent.mm.plugin.luckymoney.a.c.bz(2, paramString);
          }
          getIntent().getStringExtra("key_username");
          if (!Util.isNullOrNil(this.ECe.EBX.ECc.Tqn)) {
            this.ELi = this.ECe.EBX.ECc.Tqn;
          }
          if (this.jaR != 3) {
            break label2205;
          }
          this.qoE.setBackgroundResource(a.e.lucky_money_live_receive_bg);
          ar.r(this, getResources().getColor(a.c.UN_BW_0_Alpha_0_3));
          findViewById(a.f.lucky_money_receive_bg_mask_iv).setVisibility(8);
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.Eyg.setVisibility(0);
          ag.fm(this.Eyg);
          break;
          ag.a(this.Eus, this.ECe.Ezb, this.ECe.Ezw);
          break label463;
          label1490:
          if ((!Util.isNullOrNil(this.ECe.Ezw)) && (Util.isNullOrNil(this.ECe.EBR))) {
            this.ECe.EBR = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(this.ECe.Ezw);
          }
          label1600:
          do
          {
            ag.a(getContext(), this.Evi, getString(a.i.lucky_money_whose, new Object[] { this.ECe.EBR }));
            break;
            ag.a(getContext(), this.Evi, this.ECe.EBR);
            break;
            if (ab.Qg(paramString))
            {
              this.Evi.setText(this.ECe.EBR);
              break;
            }
            if (this.ECe.gbo == 3)
            {
              ag.a(getContext(), this.Evi, getString(a.i.lucky_money_whose2, new Object[] { this.ECe.EBR }));
              break;
            }
          } while (this.jaR != 3);
          if (this.ECe.EBS)
          {
            com.tencent.mm.kernel.h.aHH();
            paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwh(this.ECe.Ezw);
            if ((paramq != null) && (!Util.isNullOrNil(paramq.field_username)))
            {
              ag.a(getContext(), this.Evi, getString(a.i.lucky_money_whose2, new Object[] { this.ECe.EBR }));
              break label559;
            }
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get contact: %s", new Object[] { this.ECe.Ezw });
            this.EIi.add(this.ECe.Ezw);
            az.a.ltq.a(this.ECe.Ezw, "", new az.b.a()
            {
              public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(263581);
                Log.v("MicroMsg.LuckyMoneyParseHelper", "getContact suc, user: %s", new Object[] { paramAnonymousString });
                if (paramAnonymousBoolean) {
                  com.tencent.e.h.ZvG.bd(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(272248);
                      LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this).remove(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).Ezw);
                      LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).EBR = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).Ezw);
                      ag.a(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyNotHookReceiveUI.l(LuckyMoneyNotHookReceiveUI.this), LuckyMoneyNotHookReceiveUI.this.getString(a.i.lucky_money_whose2, new Object[] { LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this).EBR }));
                      AppMethodBeat.o(272248);
                    }
                  });
                }
                AppMethodBeat.o(263581);
              }
            });
            break label559;
          }
          ag.a(getContext(), this.Evi, this.ECe.EBR);
          break label559;
          label1861:
          if (this.ECe.gbq == 1)
          {
            a(s.au.yJX, true);
            break label687;
          }
          if (this.ECe.gbp != 4) {
            break label687;
          }
          a(s.au.yJW, true);
          break label687;
          label1905:
          this.Evj.setVisibility(8);
          if (!Util.isNullOrNil(paramq))
          {
            this.qCM.setText(paramq);
            this.qCM.setVisibility(0);
          }
          label2085:
          for (;;)
          {
            this.DLp.setVisibility(8);
            localObject = (RelativeLayout.LayoutParams)this.Evk.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
            this.Evk.setLayoutParams((ViewGroup.LayoutParams)localObject);
            ePW();
            bool = true;
            break;
            if (!Util.isNullOrNil(this.ECe.EvN))
            {
              this.qCM.setText(this.ECe.EvN);
              this.qCM.setVisibility(0);
            }
            for (;;)
            {
              if (Util.isNullOrNil(this.ECe.EyY)) {
                break label2085;
              }
              this.DLp.setText(this.ECe.EyY);
              this.DLp.setVisibility(0);
              this.DLp.setSingleLine(false);
              break;
              this.qCM.setVisibility(8);
            }
          }
          label2087:
          this.Evk.setVisibility(8);
          this.Evl.setVisibility(8);
          break label1019;
          label2108:
          this.Eyf.setVisibility(8);
          break label1269;
          label2120:
          paramString = (LinearLayout.LayoutParams)this.Eye.getLayoutParams();
          if (!Util.isNullOrNil(this.uFZ)) {}
          for (paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 118.0F))
          {
            if (com.tencent.mm.cj.a.hrd() != 1.0F) {
              paramString.topMargin = ((int)(paramString.topMargin / com.tencent.mm.cj.a.hrd()));
            }
            this.Eye.setLayoutParams(paramString);
            break;
          }
          label2205:
          if (ar.isDarkMode())
          {
            this.qoE.setBackgroundResource(a.c.BW_0_Alpha_0_8);
            ar.r(this, getResources().getColor(a.c.BW_0_Alpha_0_8));
          }
          else
          {
            this.qoE.setBackgroundResource(a.c.lucky_money_goldstyle_receive_bg_color_new);
            ar.r(this, getResources().getColor(a.c.lucky_money_goldstyle_receive_bg_color_new));
          }
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramq instanceof az))
    {
      if ((paramq instanceof com.tencent.mm.plugin.luckymoney.model.a.b))
      {
        com.tencent.mm.plugin.luckymoney.model.a.b localb = (com.tencent.mm.plugin.luckymoney.model.a.b)paramq;
        if (paramInt2 != 0)
        {
          int i = localb.ECj;
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "whether doing the retry logic of NetSceneLiveOpenLuckyMoney, delayTimeMs: %s", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            if (localb.ECl != null)
            {
              localb.ECl.put("policy_retry", "1");
              localObject = new com.tencent.mm.plugin.luckymoney.model.a.b(localb.ECl);
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject).ybP = localb.ybP;
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject).gbn = localb.gbn;
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject).talker = localb.talker;
              ((com.tencent.mm.plugin.luckymoney.model.a.b)localObject).lXi = localb.lXi;
            }
            while (localObject != null)
            {
              com.tencent.e.h.ZvG.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(226895);
                  LuckyMoneyNotHookReceiveUI.this.doSceneProgress(this.ELp, false);
                  AppMethodBeat.o(226895);
                }
              }, i);
              AppMethodBeat.o(65753);
              return true;
              localObject = null;
            }
            Log.e("MicroMsg.LuckyMoneyNotHookReceiveUI", "The retryNetScene is null");
          }
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      ag.d(this.Evj);
      this.Evj.setClickable(true);
      eOi();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (az)paramq;
        l.play(this, a.i.lucky_cashrecivedrevised);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
        {
          public final void eOt()
          {
            AppMethodBeat.i(271201);
            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, paramString);
            AppMethodBeat.o(271201);
          }
        })))
        {
          AppMethodBeat.o(65753);
          return true;
        }
        if (com.tencent.mm.plugin.wallet_core.utils.g.a(paramString.EAY))
        {
          setContentViewVisibility(4);
          new com.tencent.mm.plugin.wallet_core.utils.g(this).a(paramString.EAY, new g.a()
          {
            public final void a(coi paramAnonymouscoi)
            {
              AppMethodBeat.i(271376);
              if (paramAnonymouscoi.action == 2)
              {
                LuckyMoneyNotHookReceiveUI.this.showLoading();
                LuckyMoneyNotHookReceiveUI.this.aNP(paramString.EBK);
                AppMethodBeat.o(271376);
                return;
              }
              LuckyMoneyNotHookReceiveUI.this.finish();
              AppMethodBeat.o(271376);
            }
          });
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.ELk) {
          com.tencent.mm.plugin.report.service.h.IzE.el(991, 13);
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
        this.Evj.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
        bool = ag.a(this, paramInt2, paramq, paramString, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null, 1003);
        AppMethodBeat.o(65753);
        return bool;
      }
      if (paramInt2 == 419)
      {
        com.tencent.mm.ui.base.h.a(getContext(), paramString, "", getContext().getString(a.i.lucky_money_dialog_i_know), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(186538);
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "click AlertDialog");
            LuckyMoneyNotHookReceiveUI.this.finish();
            AppMethodBeat.o(186538);
          }
        });
        AppMethodBeat.o(65753);
        return true;
      }
    }
    else if ((paramq instanceof ap))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramq;
        paramq = new Intent();
        paramq.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramq.putExtra("key_lucky_money_can_received", true);
        try
        {
          com.tencent.mm.plugin.luckymoney.a.b.a(this.ExZ, paramString.EAX);
          paramq.putExtra("key_jump_from", 2);
          paramq.putExtra("key_native_url", this.Eyn);
          paramq.putExtra("key_sendid", this.ExZ);
          paramq.putExtra("key_anim_slide", true);
          paramq.putExtra("key_detail_emoji_md5", paramString.EBm);
          paramq.putExtra("key_detail_emoji_type", paramString.EBn);
          paramq.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramq.putExtra("scene_id", this.EGw);
          paramq.putExtra("key_emoji_switch", paramString.EBo);
          paramq.putExtra("key_msgid", this.iSo);
          aF(paramq);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
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
      com.tencent.mm.ui.base.h.cO(this, paramString);
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
    AppMethodBeat.i(225411);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(188782);
        if ((LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).isShowing())) {
          LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).dismiss();
        }
        LuckyMoneyNotHookReceiveUI.this.EGu.forceCancel();
        if ((LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
          LuckyMoneyNotHookReceiveUI.this.finish();
        }
        AppMethodBeat.o(188782);
      }
    });
    AppMethodBeat.o(225411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */