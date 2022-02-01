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
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.az;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.plugin.luckymoney.model.be;
import com.tencent.mm.plugin.luckymoney.model.bi;
import com.tencent.mm.plugin.luckymoney.model.e;
import com.tencent.mm.plugin.luckymoney.model.s.6;
import com.tencent.mm.plugin.luckymoney.model.s.7;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import com.tencent.mm.wallet_core.c.m;
import java.util.HashMap;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private static HashMap<String, bwe> zgd;
  private long gof;
  private String mRa;
  private int maxSize;
  private TextView nAB;
  private ViewGroup nmW;
  private int qBv;
  private d.a rbg;
  private String rcU;
  private EmojiInfo rfq;
  private long startTime;
  private int textSize;
  private com.tencent.mm.ui.base.q tipDialog;
  private String xGm;
  private ImageView yQt;
  private TextView yRk;
  private Button yRl;
  private View yRm;
  private ImageView yRn;
  private TextView yRo;
  private ImageView yTs;
  private String yUc;
  private LinearLayout yUh;
  private TextView yUi;
  private View yUj;
  private ImageView yUk;
  private RelativeLayout yUl;
  private BaseEmojiView yUm;
  private TextView yUn;
  private LinearLayout yUo;
  private ProgressBar yUp;
  private String yUq;
  private ae yUs;
  public int yUt;
  private bd yXY;
  private TextView yln;
  private int zbZ;
  private long zdW;
  private int zdY;
  private com.tencent.mm.ak.i zdZ;
  private int zdu;
  private hf zdz;
  private int zeb;
  private String zge;
  private boolean zgf;
  
  static
  {
    AppMethodBeat.i(213427);
    zgd = new HashMap();
    AppMethodBeat.o(213427);
  }
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(65742);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.yUs = null;
    this.yUt = 0;
    this.zgf = false;
    this.rbg = new d.a()
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
                if ((LuckyMoneyNotHookReceiveUI.1.1.this.zei != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5().equals(LuckyMoneyNotHookReceiveUI.1.1.this.zei.getMd5())))
                {
                  if (LuckyMoneyNotHookReceiveUI.1.1.this.gxI)
                  {
                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, k.getEmojiStorageMgr().OpN.blk(LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this).getMd5()));
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                    LuckyMoneyNotHookReceiveUI.c(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                    LuckyMoneyNotHookReceiveUI.egu();
                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this));
                    AppMethodBeat.o(65730);
                    return;
                  }
                  Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                  LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this).setVisibility(8);
                  LuckyMoneyNotHookReceiveUI.d(LuckyMoneyNotHookReceiveUI.this).setVisibility(0);
                  LuckyMoneyNotHookReceiveUI.egu();
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
    this.zdW = 0L;
    this.zdY = 3;
    this.zeb = 0;
    this.zdZ = new LuckyMoneyNotHookReceiveUI.12(this);
    AppMethodBeat.o(65742);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65751);
    this.zeb = 4;
    this.yUm.setEmojiInfo(paramEmojiInfo);
    this.zdz = new hf();
    this.zdz.eEH = 8L;
    this.zdz.bfK();
    AppMethodBeat.o(65751);
  }
  
  private static int PY(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  private void a(final ay paramay)
  {
    AppMethodBeat.i(65754);
    com.tencent.mm.plugin.luckymoney.model.q localq = paramay.yWT;
    Object localObject;
    if (localq.eha == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_intercept_win_after", paramay.yXF);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, paramay.yWT);
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramay.egX);
        ((Intent)localObject).putExtra("key_sendid", paramay.yQE);
        aH((Intent)localObject);
        if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramay.yRu != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramay.yRu);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("scene_id", this.zbZ);
        ((Intent)localObject).putExtra("key_emoji_switch", paramay.yXj);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paramay.yXh);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paramay.yXi);
        ((Intent)localObject).putExtra("key_msgid", this.gof);
        ((Intent)localObject).putExtra("scene_id", this.zbZ);
        paramay = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramay.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramay.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        String str = getIntent().getStringExtra("key_username");
        if (!ab.IN(str))
        {
          localObject = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVA(this.yUq);
          paramay = (ay)localObject;
          if (localObject == null) {
            paramay = new ae();
          }
          paramay.field_mNativeUrl = this.yUq;
          paramay.field_hbType = localq.egY;
          paramay.field_receiveAmount = localq.eht;
          paramay.field_receiveTime = System.currentTimeMillis();
          paramay.field_hbStatus = localq.egZ;
          paramay.field_receiveStatus = localq.eha;
          paramay.field_sender = str;
          paramay.field_sendId = this.yUc;
          paramay.field_exclusiveUsername = getIntent().getStringExtra("key_exclusive_username");
          if (paramay.field_receiveAmount > 0L)
          {
            com.tencent.mm.plugin.wallet_core.model.t.fQE().a(paramay);
            com.tencent.mm.plugin.luckymoney.b.a.eex().aDq(str);
          }
        }
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
    this.yRl.setBackgroundResource(2131233773);
    this.yRl.setText(2131762692);
    this.yRl.setOnClickListener(null);
    this.yRl.setVisibility(8);
    if (!Util.isNullOrNil(localq.yRQ))
    {
      this.nAB.setText(localq.yRQ);
      this.nAB.setVisibility(0);
      this.yln.setText(localq.yVb);
      localObject = (RelativeLayout.LayoutParams)this.yRm.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
      this.yRm.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!com.tencent.mm.model.z.aTY().equals(this.xGm)) && (localq.egY != 1)) {
        break label704;
      }
      this.yRm.setVisibility(0);
      this.yRm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213417);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent();
          if (paramay.yRu != null) {
            ((Intent)localObject).putExtra("key_realname_guide_helper", paramay.yRu);
          }
          ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
          ((Intent)localObject).putExtra("key_native_url", paramay.egX);
          ((Intent)localObject).putExtra("key_sendid", paramay.yQE);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("scene_id", LuckyMoneyNotHookReceiveUI.l(LuckyMoneyNotHookReceiveUI.this));
          ((Intent)localObject).putExtra("key_emoji_switch", paramay.yXj);
          ((Intent)localObject).putExtra("key_detail_emoji_md5", paramay.yXh);
          ((Intent)localObject).putExtra("key_detail_emoji_type", paramay.yXi);
          ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this));
          LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
          paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$16", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LuckyMoneyNotHookReceiveUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213417);
        }
      });
      this.yRn.setVisibility(8);
    }
    for (;;)
    {
      if ((localq.egY == 1) && (localq.egZ == 4) && (!af.rQ(this.zbZ))) {
        egs();
      }
      AppMethodBeat.o(65754);
      return;
      this.nAB.setVisibility(8);
      break;
      label704:
      this.yRm.setVisibility(8);
      this.yRn.setVisibility(0);
    }
  }
  
  private void a(final bwe parambwe)
  {
    AppMethodBeat.i(213420);
    if (parambwe.Mca)
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "show envelope promo");
      final ViewGroup localViewGroup = (ViewGroup)findViewById(2131304236);
      Object localObject2 = (CdnImageView)localViewGroup.findViewById(2131304235);
      Object localObject1 = (TextView)localViewGroup.findViewById(2131304237);
      int i = com.tencent.mm.cb.a.E(getContext(), com.tencent.mm.cb.a.jn(getContext()));
      ((TextView)localObject1).setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(getContext(), i - 24 - 20 - 36 - 18));
      com.tencent.mm.wallet_core.ui.f.G((TextView)localObject1);
      ((CdnImageView)localObject2).setRoundCorner(true);
      ((CdnImageView)localObject2).setUrl(parambwe.iwv);
      ((TextView)localObject1).setText(parambwe.title);
      long l;
      if (parambwe.Mce != null)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(com.tencent.mm.cb.a.fromDPToPix(getContext(), 24));
        l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(parambwe.Mce.LrI, parambwe.Mce.LrJ);
        if (l != -1L) {
          ((GradientDrawable)localObject2).setColor(com.tencent.mm.plugin.wallet_core.utils.g.argbColor(l));
        }
      }
      if (parambwe.Mcd != null)
      {
        l = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(parambwe.Mce.LrI, parambwe.Mce.LrJ);
        if (l != -1L) {
          ((TextView)localObject1).setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.argbColor(l));
        }
      }
      localViewGroup.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213415);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.wallet_core.ui.f.bn(LuckyMoneyNotHookReceiveUI.this.getContext(), parambwe.url);
          com.tencent.mm.plugin.report.service.h.CyF.a(22105, new Object[] { Integer.valueOf(3), Integer.valueOf(0), parambwe.Mcf });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213415);
        }
      });
      localViewGroup.setVisibility(0);
      localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772076);
      ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
      ((Animation)localObject1).setDuration(300L);
      ((Animation)localObject1).setFillAfter(true);
      ((Animation)localObject1).setFillEnabled(true);
      localObject2 = AnimationUtils.loadAnimation(getContext(), 2130771981);
      ((Animation)localObject2).setDuration(300L);
      ((Animation)localObject2).setFillEnabled(true);
      ((Animation)localObject2).setFillAfter(true);
      AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localViewGroup.startAnimation(localAnimationSet);
      com.tencent.mm.plugin.report.service.h.CyF.a(22105, new Object[] { Integer.valueOf(2), Integer.valueOf(0), parambwe.Mcf });
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(213416);
          paramAnonymousAnimation = new Rect();
          localViewGroup.getGlobalVisibleRect(paramAnonymousAnimation);
          Point localPoint = com.tencent.mm.ui.ao.gx(LuckyMoneyNotHookReceiveUI.this.getContext());
          if (paramAnonymousAnimation.bottom >= localPoint.y)
          {
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "over bottom");
            paramAnonymousAnimation = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
            if (paramAnonymousAnimation != null)
            {
              paramAnonymousAnimation.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.hif();
              localViewGroup.setLayoutParams(paramAnonymousAnimation);
            }
            paramAnonymousAnimation = (ViewGroup.MarginLayoutParams)LuckyMoneyNotHookReceiveUI.o(LuckyMoneyNotHookReceiveUI.this).getLayoutParams();
            if (paramAnonymousAnimation != null)
            {
              paramAnonymousAnimation.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.hif();
              LuckyMoneyNotHookReceiveUI.o(LuckyMoneyNotHookReceiveUI.this).setLayoutParams(paramAnonymousAnimation);
            }
          }
          AppMethodBeat.o(213416);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(213420);
  }
  
  private void aH(Intent paramIntent)
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
    paramIntent.putExtra("key_material_flag", this.qBv);
    AppMethodBeat.o(163761);
  }
  
  private void eeN()
  {
    AppMethodBeat.i(65749);
    if (this.yRl == null)
    {
      AppMethodBeat.o(65749);
      return;
    }
    com.tencent.mm.plugin.normsg.a.d.AEF.TL(this.yRl.getId());
    String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    if ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))))
    {
      AppMethodBeat.o(65749);
      return;
    }
    this.yRl.setBackgroundResource(2131233788);
    this.yRl.setText(2131762695);
    AppMethodBeat.o(65749);
  }
  
  private void egs()
  {
    AppMethodBeat.i(213419);
    if (!com.tencent.mm.plugin.luckymoney.ui.a.a.bfV())
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "random drop this time");
      AppMethodBeat.o(213419);
      return;
    }
    Object localObject = (bwe)zgd.get(this.yUc);
    if (localObject != null)
    {
      Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache response this time");
      a((bwe)localObject);
      AppMethodBeat.o(213419);
      return;
    }
    localObject = getIntent().getStringExtra("key_packet_id");
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get time limit promot: %s", new Object[] { localObject });
    new e((String)localObject).aYI().b(new com.tencent.mm.vending.c.a() {}).a(this);
    AppMethodBeat.o(213419);
  }
  
  private int egt()
  {
    AppMethodBeat.i(65755);
    if (com.tencent.mm.model.z.aTY().equals(this.xGm))
    {
      AppMethodBeat.o(65755);
      return 1;
    }
    AppMethodBeat.o(65755);
    return 0;
  }
  
  private void qM(boolean paramBoolean)
  {
    AppMethodBeat.i(65750);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.yUn.setVisibility(8);
    this.zeb = 1;
    if (paramBoolean) {
      this.zdY = 3;
    }
    do
    {
      this.rfq = k.getEmojiStorageMgr().OpN.blk(this.rcU);
      if (this.rfq == null) {
        break;
      }
      if ((s.boW(this.rfq.hRM()) <= 0L) && (!this.rfq.NA()) && (!this.rfq.hRB())) {
        break label218;
      }
      this.yUm.setVisibility(0);
      A(this.rfq);
      AppMethodBeat.o(65750);
      return;
      this.zdY -= 1;
    } while (this.zdY != 0);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.yUo.setVisibility(8);
    this.yUn.setVisibility(0);
    this.zeb = 2;
    AppMethodBeat.o(65750);
    return;
    this.rfq = new EmojiInfo();
    this.rfq.field_md5 = this.rcU;
    this.rfq.field_type = this.zdu;
    label218:
    if (paramBoolean)
    {
      this.yUm.setVisibility(8);
      this.yUo.setVisibility(0);
      k.cGd().rbg = this.rbg;
    }
    k.cGd().u(this.rfq);
    com.tencent.mm.kernel.g.aAg().hqi.a(697, this.zdZ);
    AppMethodBeat.o(65750);
  }
  
  public final void aDF(String paramString)
  {
    AppMethodBeat.i(213421);
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      String str = getIntent().getStringExtra("key_username");
      if (af.rQ(this.zbZ))
      {
        paramString = new az(this.yXY.msgType, this.yXY.channelId, this.yXY.yQE, this.yXY.egX, af.efj(), com.tencent.mm.model.z.aUa(), str, "v1.0", this.yXY.yXR);
        if (ab.IN(str))
        {
          str = getIntent().getStringExtra("key_emoji_md5");
          if (Util.isNullOrNil(str)) {
            break label209;
          }
        }
      }
      label209:
      for (boolean bool = true;; bool = false)
      {
        paramString.yWK = new s.7(bool, str);
        com.tencent.mm.plugin.luckymoney.a.d.xV(2);
        doSceneProgress(paramString, false);
        af.c(this.yRl);
        AppMethodBeat.o(213421);
        return;
        paramString = new ay(this.yXY.msgType, this.yXY.channelId, this.yXY.yQE, this.yXY.egX, af.efj(), com.tencent.mm.model.z.aUa(), str, "v1.0", this.yXY.yXR, paramString);
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
    overridePendingTransition(0, 2130772056);
    AppMethodBeat.o(65747);
  }
  
  public int getLayoutId()
  {
    return 2131495382;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65748);
    this.yUj = findViewById(2131304246);
    this.nmW = ((ViewGroup)findViewById(2131304243));
    this.yUh = ((LinearLayout)findViewById(2131304267));
    this.yQt = ((ImageView)findViewById(2131304244));
    this.yRk = ((TextView)findViewById(2131304245));
    this.nAB = ((TextView)findViewById(2131304247));
    this.yln = ((TextView)findViewById(2131304251));
    this.yUl = ((RelativeLayout)findViewById(2131304102));
    this.yUm = ((BaseEmojiView)findViewById(2131304098));
    this.yUn = ((TextView)findViewById(2131304266));
    this.yUo = ((LinearLayout)findViewById(2131304151));
    this.yUp = ((ProgressBar)findViewById(2131299998));
    this.yRl = ((Button)findViewById(2131304255));
    this.yRo = ((TextView)findViewById(2131304252));
    this.yRm = findViewById(2131304253);
    this.yRn = ((ImageView)findViewById(2131304018));
    this.yUk = ((ImageView)findViewById(2131304238));
    this.yUi = ((TextView)findViewById(2131304256));
    this.yTs = ((ImageView)findViewById(2131304254));
    this.yTs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65735);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LuckyMoneyNotHookReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.h.CyF.a(22105, new Object[] { Integer.valueOf(4), Long.valueOf(Util.ticksToNow(LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this)) / 1000L) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65735);
      }
    });
    this.yUn.setOnClickListener(new LuckyMoneyNotHookReceiveUI.10(this));
    this.nAB.setLines(2);
    android.support.v4.widget.q.d(this.nAB);
    this.maxSize = ((int)(com.tencent.mm.cb.a.aH(getContext(), 2131166624) * 1.125F));
    this.textSize = com.tencent.mm.cb.a.aG(getContext(), 2131166624);
    if (this.textSize > this.maxSize) {}
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      showLoading();
      eeN();
      AppMethodBeat.o(65748);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65743);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131101287));
    }
    this.startTime = Util.currentTicks();
    this.yUq = getIntent().getStringExtra("key_native_url");
    this.zge = getIntent().getStringExtra("key_cropname");
    this.gof = getIntent().getLongExtra("key_msgid", 0L);
    this.qBv = getIntent().getIntExtra("key_material_flag", 0);
    this.zbZ = getIntent().getIntExtra("scene_id", 1002);
    this.mRa = getIntent().getStringExtra("key_username");
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + Util.nullAsNil(this.yUq));
    initView();
    paramBundle = Uri.parse(Util.nullAsNil(this.yUq));
    try
    {
      this.yUc = paramBundle.getQueryParameter("sendid");
      label200:
      this.yUs = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVA(this.yUq);
      if ((this.yUs != null) && (this.yUs.field_receiveAmount > 0L) && (Util.milliSecondsToNow(this.yUs.field_receiveTime) < 86400000L))
      {
        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.yUs.field_receiveTime), Util.nullAsNil(this.yUq) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.yUs.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.yUc);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        paramBundle.putExtra("scene_id", this.zbZ);
        paramBundle.putExtra("key_msgid", this.gof);
        aH(paramBundle);
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(65743);
        return;
      }
      if (!Util.isNullOrNil(this.yUc))
      {
        int i = Util.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.xGm = paramBundle.getQueryParameter("sendusername");
        String str = getIntent().getStringExtra("key_username");
        if (af.rQ(this.zbZ))
        {
          paramBundle = new be(i, this.yUc, this.yUq, getIntent().getIntExtra("key_way", 0), "v1.0");
          if (ab.IN(str))
          {
            str = getIntent().getStringExtra("key_emoji_md5");
            if (Util.isNullOrNil(str)) {
              break label670;
            }
          }
        }
        label670:
        for (boolean bool = true;; bool = false)
        {
          paramBundle.yWK = new s.6(bool, str);
          doSceneProgress(paramBundle, false);
          if (this.tipDialog != null) {
            this.tipDialog.show();
          }
          AppMethodBeat.o(65743);
          return;
          paramBundle = new bd(i, this.yUc, this.yUq, getIntent().getIntExtra("key_way", 0), "v1.0", str);
          break;
        }
      }
      finish();
      Log.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
      AppMethodBeat.o(65743);
      return;
    }
    catch (Exception localException)
    {
      break label200;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65744);
    super.onDestroy();
    if ((this.zeb == 1) || (this.zeb == 2))
    {
      this.zdz = new hf();
      this.zdz.eEH = 9L;
      this.zdz.bfK();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    k.cGd().rbg = null;
    com.tencent.mm.kernel.g.aAg().hqi.b(697, this.zdZ);
    AppMethodBeat.o(65744);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65746);
    super.onPause();
    com.tencent.mm.modelstat.d.m("LuckyMoneyReceiveUI", this.zdW, Util.nowSecond());
    AppMethodBeat.o(65746);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65745);
    super.onResume();
    this.zdW = Util.nowSecond();
    AppMethodBeat.o(65745);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65753);
    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    label524:
    final boolean bool;
    if ((paramq instanceof bd))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.yXY = ((bd)paramq);
        this.yUt = this.yXY.yUt;
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(PY(this.yXY.egY)), Integer.valueOf(egt()), Integer.valueOf(0), Integer.valueOf(1) });
        paramq = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVA(this.yUq);
        paramString = paramq;
        if (paramq == null) {
          paramString = new ae();
        }
        paramString.field_mNativeUrl = this.yUq;
        paramString.field_hbType = this.yXY.egY;
        paramString.field_hbStatus = this.yXY.egZ;
        paramString.field_receiveStatus = this.yXY.eha;
        paramString.field_sendId = this.yUc;
        paramString.field_sender = this.mRa;
        com.tencent.mm.plugin.wallet_core.model.t.fQE().a(paramString);
        com.tencent.mm.plugin.luckymoney.b.a.eex().aDq(this.mRa);
        if (this.yXY.eha == 2)
        {
          if (af.rQ(this.zbZ)) {}
          for (paramString = new ap(this.yUc, this.yUq, "v1.0");; paramString = new com.tencent.mm.plugin.luckymoney.model.ao(this.yUc, 11, 0, this.yUq, "v1.0"))
          {
            doSceneProgress(paramString, false);
            AppMethodBeat.o(65753);
            return true;
          }
        }
        if (!Util.isNullOrNil(this.yXY.yXh))
        {
          this.zdz = new hf();
          this.zdz.eEH = 7L;
          this.zdz.bfK();
        }
        af.a(this.yQt, this.yXY.yVe, this.yXY.yVy);
        paramString = getIntent().getStringExtra("key_username");
        if (af.rQ(this.zbZ)) {
          if (ab.IN(paramString))
          {
            if ((!Util.isNullOrNil(this.yXY.yVy)) && (Util.isNullOrNil(this.yXY.yXN))) {
              this.yXY.yXN = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yXY.yVy);
            }
            this.yRk.setText(this.yXY.yXN);
            if ((this.yXY.egY == 1) && (this.yXY.egZ == 4) && (!af.rQ(this.zbZ)))
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(22105, new Object[] { Integer.valueOf(1) });
              egs();
            }
            bool = false;
            if ((this.yXY.eha == 1) || (this.yXY.egZ == 4) || (this.yXY.egZ == 5) || (this.yXY.egZ == 1)) {
              break label1517;
            }
            if (!Util.isNullOrNil(this.yXY.yVb))
            {
              this.nAB.setText(this.yXY.yVb);
              this.nAB.setVisibility(0);
            }
            if (!Util.isNullOrNil(this.yXY.yPK))
            {
              af.a(getContext(), this.yln, this.yXY.yPK);
              this.yln.setVisibility(0);
              this.nAB.setVisibility(8);
            }
            if ((!Util.isNullOrNil(this.yXY.yXh)) && (Util.isEqual(this.yUt, 1)))
            {
              this.rcU = this.yXY.yXh;
              this.zdu = this.yXY.yXi;
              this.yUl.setVisibility(0);
              qM(true);
            }
            this.yRl.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(163760);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(10, 3);
                com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.PZ(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).egY)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
                Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
                LuckyMoneyNotHookReceiveUI.k(LuckyMoneyNotHookReceiveUI.this).setClickable(false);
                LuckyMoneyNotHookReceiveUI.this.aDF("");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163760);
              }
            });
            if ((!com.tencent.mm.model.z.aTY().equals(this.xGm)) && ((this.yXY.egY != 1) || (this.yXY.egZ != 4)) && ((this.yXY.egY != 3) || (this.yXY.egZ != 4))) {
              break label1670;
            }
            if (this.yXY.egY == 1) {
              this.yRo.setText(2131762603);
            }
            this.yRm.setVisibility(0);
            this.yRm.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65740);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.PZ(LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).egY)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
                }
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).egX);
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).yQE);
                ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
                ((Intent)localObject).putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                ((Intent)localObject).putExtra("scene_id", LuckyMoneyNotHookReceiveUI.l(LuckyMoneyNotHookReceiveUI.this));
                ((Intent)localObject).putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this));
                LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (Intent)localObject);
                paramAnonymousView = LuckyMoneyNotHookReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyNotHookReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65740);
              }
            });
            this.yRn.setVisibility(8);
            label896:
            if ((ab.IN(paramString)) && (this.yXY.yXS == null)) {
              this.yXY.yXS = new bi();
            }
            if (this.yXY.yXS == null) {
              break label1702;
            }
            paramString = getIntent().getStringExtra("key_receive_envelope_url");
            paramq = getIntent().getStringExtra("key_receive_envelope_md5");
            if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramq)))
            {
              Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
              if (this.yXY.yXS.yXW == null) {
                this.yXY.yXS.yXW = new cbe();
              }
              this.yXY.yXS.yXW.MgC = new cbf();
              this.yXY.yXS.yXW.MgC.igW = paramString;
              this.yXY.yXS.yXW.MgC.MgX = paramq;
            }
            paramq = this.yXY.yXS.yXW;
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
            if (paramq != null)
            {
              ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.yUk, paramq, null);
              this.yUk.setVisibility(0);
              this.yRn.setVisibility(8);
              this.zgf = true;
              if (this.qBv != 2) {
                break label1690;
              }
              this.yUi.setVisibility(0);
              label1154:
              paramString = (LinearLayout.LayoutParams)this.yUh.getLayoutParams();
              paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);
              this.yUh.setLayoutParams(paramString);
              af.s(this.yln);
              af.s(this.nAB);
              af.s(this.yRk);
              paramString = "";
              if (paramq.MgC != null) {
                paramString = paramq.MgC.igW;
              }
              com.tencent.mm.plugin.luckymoney.a.c.bC(2, paramString);
            }
            getIntent().getStringExtra("key_username");
            if (!Util.isNullOrNil(this.yXY.yXS.yXW.MgB)) {
              this.zge = this.yXY.yXS.yXW.MgB;
            }
            if (!com.tencent.mm.ui.ao.isDarkMode()) {
              break label1787;
            }
            this.nmW.setBackgroundResource(2131099667);
            com.tencent.mm.ui.ao.q(this, getResources().getColor(2131099667));
          }
        }
        for (;;)
        {
          getContentView().setVisibility(0);
          this.yUj.setVisibility(0);
          af.eo(this.yUj);
          break;
          if ((!Util.isNullOrNil(this.yXY.yVy)) && (Util.isNullOrNil(this.yXY.yXN))) {
            this.yXY.yXN = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yXY.yVy);
          }
          do
          {
            af.a(getContext(), this.yRk, getString(2131762757, new Object[] { this.yXY.yXN }));
            break;
            af.a(getContext(), this.yRk, this.yXY.yXN);
            break;
            if (ab.IN(paramString))
            {
              this.yRk.setText(this.yXY.yXN);
              break;
            }
          } while (this.yXY.egY != 3);
          af.a(getContext(), this.yRk, getString(2131762758, new Object[] { this.yXY.yXN }));
          break label524;
          label1517:
          this.yRl.setVisibility(8);
          if (!Util.isNullOrNil(this.yXY.yRQ))
          {
            this.nAB.setText(this.yXY.yRQ);
            this.nAB.setVisibility(0);
            label1561:
            if (Util.isNullOrNil(this.yXY.yVb)) {
              break label1658;
            }
            this.yln.setText(this.yXY.yVb);
            this.yln.setVisibility(0);
            this.yln.setSingleLine(false);
          }
          for (;;)
          {
            paramq = (RelativeLayout.LayoutParams)this.yRm.getLayoutParams();
            paramq.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0F);
            this.yRm.setLayoutParams(paramq);
            bool = true;
            break;
            this.nAB.setVisibility(8);
            break label1561;
            label1658:
            this.yln.setVisibility(8);
          }
          label1670:
          this.yRm.setVisibility(8);
          this.yRn.setVisibility(0);
          break label896;
          label1690:
          this.yUi.setVisibility(8);
          break label1154;
          label1702:
          paramString = (LinearLayout.LayoutParams)this.yUh.getLayoutParams();
          if (!Util.isNullOrNil(this.rcU)) {}
          for (paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0F);; paramString.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 118.0F))
          {
            if (com.tencent.mm.cc.a.gvi() != 1.0F) {
              paramString.topMargin = ((int)(paramString.topMargin / com.tencent.mm.cc.a.gvi()));
            }
            this.yUh.setLayoutParams(paramString);
            break;
          }
          label1787:
          this.nmW.setBackgroundResource(2131100750);
          com.tencent.mm.ui.ao.q(this, getResources().getColor(2131100750));
        }
      }
      AppMethodBeat.o(65753);
      return false;
    }
    if ((paramq instanceof ay))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      af.d(this.yRl);
      this.yRl.setClickable(true);
      eeN();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ay)paramq;
        l.a(this, l.a.zjb);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
        {
          public final void eeY()
          {
            AppMethodBeat.i(174384);
            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, paramString);
            AppMethodBeat.o(174384);
          }
        })))
        {
          AppMethodBeat.o(65753);
          return true;
        }
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.yXE))
        {
          setContentViewVisibility(4);
          new com.tencent.mm.plugin.wallet_core.utils.c(this).a(paramString.yXE, new com.tencent.mm.plugin.wallet_core.utils.c.a()
          {
            public final void a(cfl paramAnonymouscfl)
            {
              AppMethodBeat.i(213412);
              if (paramAnonymouscfl.action == 2)
              {
                LuckyMoneyNotHookReceiveUI.this.showLoading();
                LuckyMoneyNotHookReceiveUI.this.aDF(paramString.yXG);
                AppMethodBeat.o(213412);
                return;
              }
              LuckyMoneyNotHookReceiveUI.this.finish();
              AppMethodBeat.o(213412);
            }
          });
          AppMethodBeat.o(65753);
          return true;
        }
        a(paramString);
        if (this.zgf) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(991, 13);
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
        this.yRl.setBackgroundResource(2131232445);
        bool = af.a(this, paramInt2, paramq, paramString, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null, 1003);
        AppMethodBeat.o(65753);
        return bool;
      }
      if (paramInt2 == 419)
      {
        com.tencent.mm.ui.base.h.a(getContext(), paramString, "", getContext().getString(2131762604), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(213413);
            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "click AlertDialog");
            LuckyMoneyNotHookReceiveUI.this.finish();
            AppMethodBeat.o(213413);
          }
        });
        AppMethodBeat.o(65753);
        return true;
      }
    }
    else if ((paramq instanceof com.tencent.mm.plugin.luckymoney.model.ao))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ao)paramq;
        paramq = new Intent();
        paramq.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramq.putExtra("key_lucky_money_can_received", true);
        try
        {
          com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, paramString.yWT);
          paramq.putExtra("key_jump_from", 2);
          paramq.putExtra("key_native_url", this.yUq);
          paramq.putExtra("key_sendid", this.yUc);
          paramq.putExtra("key_anim_slide", true);
          paramq.putExtra("key_detail_emoji_md5", paramString.yXh);
          paramq.putExtra("key_detail_emoji_type", paramString.yXi);
          paramq.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramq.putExtra("scene_id", this.zbZ);
          paramq.putExtra("key_emoji_switch", paramString.yXj);
          paramq.putExtra("key_msgid", this.gof);
          aH(paramq);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      com.tencent.mm.ui.base.h.cD(this, paramString);
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
    AppMethodBeat.i(213418);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65737);
        if ((LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this) != null) && (LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this).isShowing())) {
          LuckyMoneyNotHookReceiveUI.f(LuckyMoneyNotHookReceiveUI.this).dismiss();
        }
        LuckyMoneyNotHookReceiveUI.this.zbX.forceCancel();
        if ((LuckyMoneyNotHookReceiveUI.g(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
          LuckyMoneyNotHookReceiveUI.this.finish();
        }
        AppMethodBeat.o(65737);
      }
    });
    AppMethodBeat.o(213418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */