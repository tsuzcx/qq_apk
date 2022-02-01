package com.tencent.mm.plugin.eggspring.ui;

import TT;;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.StateSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.e.a;
import com.tencent.mm.plugin.eggspring.e.b;
import com.tencent.mm.plugin.eggspring.e.c;
import com.tencent.mm.plugin.eggspring.e.d;
import com.tencent.mm.plugin.eggspring.e.e;
import com.tencent.mm.plugin.eggspring.e.f;
import com.tencent.mm.plugin.eggspring.e.g;
import com.tencent.mm.plugin.eggspring.e.h;
import com.tencent.mm.plugin.eggspring.f;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "appId$delegate", "Lkotlin/Lazy;", "isChatRoom", "", "()Z", "isChatRoom$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startTime", "", "videoController", "Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "viewModel", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "getViewModel$annotations", "getViewModel", "()Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "viewModel$delegate", "animateCardToShow", "", "bindViewModel", "createShapeDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "getLayoutId", "getSavePath", "url", "makeBottomDividerColor", "alpha", "", "makeButtonBackground", "normalColor", "makeStatefulBottomTextColor", "Landroid/content/res/ColorStateList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "redirect", "target", "", "safeColor", "fallback", "setCoverImage", "vertical", "setupBars", "setupViews", "setupWindow", "observe", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lkotlin/Function1;", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SpringLuckyEggActivity
  extends MMActivity
{
  public static final SpringLuckyEggActivity.a xEN;
  private final aq scope;
  private long startTime;
  private final kotlin.j ujH;
  private final kotlin.j vTI;
  private b xEO;
  private d xEP;
  private final kotlin.j xEQ;
  
  static
  {
    AppMethodBeat.i(266778);
    xEN = new SpringLuckyEggActivity.a((byte)0);
    AppMethodBeat.o(266778);
  }
  
  public SpringLuckyEggActivity()
  {
    AppMethodBeat.i(266632);
    this.scope = ar.kBZ();
    this.ujH = k.cm((kotlin.g.a.a)new SpringLuckyEggActivity.n(this));
    this.xEQ = k.cm((kotlin.g.a.a)new SpringLuckyEggActivity.l(this));
    this.vTI = k.cm((kotlin.g.a.a)new SpringLuckyEggActivity.d(this));
    AppMethodBeat.o(266632);
  }
  
  private final Drawable JS(int paramInt)
  {
    AppMethodBeat.i(266658);
    Object localObject = new PaintDrawable(paramInt);
    ((PaintDrawable)localObject).setCornerRadius(com.tencent.mm.cd.a.fromDPToPix((Context)this, 4.0F));
    localObject = (Drawable)localObject;
    AppMethodBeat.o(266658);
    return localObject;
  }
  
  public static final Intent a(Context paramContext, e parame, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(266689);
    s.u(paramContext, "context");
    s.u(parame, "egg");
    s.u(paramString1, "keyword");
    paramContext = new Intent(paramContext, SpringLuckyEggActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString1);
    localBundle.putString("trace_id", paramString3);
    localBundle.putString("app_id", paramString2);
    localBundle.putString("egg_name", parame.name);
    localBundle.putString("background", parame.mij.oQI);
    localBundle.putBoolean("is_chat_room", paramBoolean);
    parame = ah.aiuX;
    paramContext.putExtras(localBundle);
    AppMethodBeat.o(266689);
    return paramContext;
  }
  
  private static final void a(SpringLuckyEggActivity paramSpringLuckyEggActivity, View paramView)
  {
    AppMethodBeat.i(266663);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSpringLuckyEggActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSpringLuckyEggActivity, "this$0");
    paramView = f.xEl;
    paramView = (com.tencent.mm.r.a.n)paramSpringLuckyEggActivity.dxI().xFu.getValue();
    if (paramView == null) {}
    for (long l = 0L;; l = paramView.mea)
    {
      f.V(22, l);
      paramSpringLuckyEggActivity.eY(paramSpringLuckyEggActivity.dxI().xFt.getValue());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266663);
      return;
    }
  }
  
  private static final void a(SpringLuckyEggActivity paramSpringLuckyEggActivity, String paramString, View paramView, Bitmap paramBitmap, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(266680);
    s.u(paramSpringLuckyEggActivity, "this$0");
    if (paramBitmap == null)
    {
      paramString = (com.tencent.mm.modelpackage.m)paramSpringLuckyEggActivity.dxI().xFv.getValue();
      if (paramString != null)
      {
        paramView = (CharSequence)paramString.oQR;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label142;
        }
      }
    }
    label142:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView = s.X(com.tencent.mm.plugin.emoji.mgr.h.getDataEmojiPath(), "/egg/");
        paramView = paramView + '/' + paramString.oQR;
        if (com.tencent.mm.vfs.y.ZC(paramView))
        {
          paramString = paramSpringLuckyEggActivity.xEO;
          paramSpringLuckyEggActivity = paramString;
          if (paramString == null)
          {
            s.bIx("viewBinding");
            paramSpringLuckyEggActivity = null;
          }
          paramSpringLuckyEggActivity.xFh.setImageFilePath(paramView);
        }
      }
      AppMethodBeat.o(266680);
      return;
    }
  }
  
  private static final void a(SpringLuckyEggActivity arg0, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(266668);
    s.u(???, "this$0");
    long l;
    if (paramBoolean)
    {
      paramString = f.xEl;
      paramString = (com.tencent.mm.r.a.n)???.dxI().xFu.getValue();
      if (paramString != null) {
        break label114;
      }
      l = 0L;
    }
    for (;;)
    {
      f.V(23, l);
      aa.db((Context)???, ???.getString(e.h.xEd));
      ???.finish();
      paramString = com.tencent.mm.plugin.eggspring.e.a.xFF;
      paramString = (String)???.vTI.getValue();
      if (paramString != null) {}
      synchronized (com.tencent.mm.plugin.eggspring.e.a.lPT)
      {
        ???.add(paramString);
        paramString = ah.aiuX;
        com.tencent.mm.plugin.eggspring.e.a.dxK();
        AppMethodBeat.o(266668);
        return;
        label114:
        l = paramString.mea;
      }
    }
  }
  
  private static final boolean a(SpringLuckyEggActivity paramSpringLuckyEggActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(266661);
    s.u(paramSpringLuckyEggActivity, "this$0");
    paramSpringLuckyEggActivity.finish();
    AppMethodBeat.o(266661);
    return true;
  }
  
  private static final void b(SpringLuckyEggActivity paramSpringLuckyEggActivity, View paramView)
  {
    AppMethodBeat.i(266665);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSpringLuckyEggActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSpringLuckyEggActivity, "this$0");
    Log.i("MicroMsg.SpringLuckyEggActivity", "clicked bottom title");
    if (paramSpringLuckyEggActivity.dxI().xFs.getValue() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266665);
      return;
    }
    paramView = f.xEl;
    paramView = (com.tencent.mm.r.a.n)paramSpringLuckyEggActivity.dxI().xFu.getValue();
    if (paramView == null) {}
    for (long l = 0L;; l = paramView.mea)
    {
      f.V(10, l);
      paramSpringLuckyEggActivity.eY(paramSpringLuckyEggActivity.dxI().xFs.getValue());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266665);
      return;
    }
  }
  
  private static final void c(SpringLuckyEggActivity paramSpringLuckyEggActivity, View paramView)
  {
    AppMethodBeat.i(266671);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSpringLuckyEggActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSpringLuckyEggActivity, "this$0");
    Log.i("MicroMsg.SpringLuckyEggActivity", "setupViews: click close");
    paramView = new g.a((Context)paramSpringLuckyEggActivity);
    paramView.bf((CharSequence)paramSpringLuckyEggActivity.getString(e.h.xEf)).bDE(paramSpringLuckyEggActivity.getString(e.h.xEe)).bDI(paramSpringLuckyEggActivity.getString(e.h.xEc));
    paramView.c(new SpringLuckyEggActivity..ExternalSyntheticLambda5(paramSpringLuckyEggActivity)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266671);
  }
  
  private final int dV(String paramString, int paramInt)
  {
    AppMethodBeat.i(266660);
    if (paramString == null)
    {
      paramInt = androidx.core.content.a.w((Context)this, paramInt);
      AppMethodBeat.o(266660);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(paramString);
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.SpringLuckyEggActivity", s.X("Illegal color value: ", paramString));
        paramInt = androidx.core.content.a.w((Context)this, paramInt);
      }
    }
    AppMethodBeat.o(266660);
    return paramInt;
  }
  
  private final c dxI()
  {
    AppMethodBeat.i(266636);
    c localc = (c)this.ujH.getValue();
    AppMethodBeat.o(266636);
    return localc;
  }
  
  private final boolean dxJ()
  {
    AppMethodBeat.i(266640);
    boolean bool = ((Boolean)this.xEQ.getValue()).booleanValue();
    AppMethodBeat.o(266640);
    return bool;
  }
  
  private final void eY(Object paramObject)
  {
    AppMethodBeat.i(266656);
    Log.i("MicroMsg.SpringLuckyEggActivity", s.X("redirect: target=", paramObject));
    Object localObject1;
    Object localObject2;
    if ((paramObject instanceof com.tencent.mm.r.a.a))
    {
      localObject1 = new Intent();
      localObject2 = ((com.tencent.mm.r.a.a)paramObject).mdB;
      s.s(localObject2, "target.ad_xml");
      if (kotlin.n.n.a((CharSequence)localObject2, "<adxml", 0, false, 6) >= 0) {}
      for (paramObject = ((com.tencent.mm.r.a.a)paramObject).mdB;; paramObject = "<adxml>" + ((com.tencent.mm.r.a.a)paramObject).mdB + "</adxml>")
      {
        ((Intent)localObject1).putExtra("sns_landing_pages_xml", paramObject);
        ((Intent)localObject1).putExtra("sns_landig_pages_from_source", 14);
        ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        com.tencent.mm.br.c.b((Context)getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject1);
        AppMethodBeat.o(266656);
        return;
      }
    }
    if ((paramObject instanceof com.tencent.mm.r.a.t))
    {
      localObject2 = new g();
      localObject1 = ((com.tencent.mm.r.a.t)paramObject).met;
      s.s(localObject1, "target.app_user_name");
      if (kotlin.n.n.rs((String)localObject1, "@app")) {}
      for (localObject1 = ((com.tencent.mm.r.a.t)paramObject).met;; localObject1 = s.X(((com.tencent.mm.r.a.t)paramObject).met, "@app"))
      {
        ((g)localObject2).username = ((String)localObject1);
        ((g)localObject2).qAF = ((com.tencent.mm.r.a.t)paramObject).meu;
        ((g)localObject2).scene = 1189;
        ((g)localObject2).euz = 0;
        ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(MMApplicationContext.getContext(), (g)localObject2);
        AppMethodBeat.o(266656);
        return;
      }
    }
    if ((paramObject instanceof com.tencent.mm.r.a.m))
    {
      paramObject = ((com.tencent.mm.r.a.m)paramObject).url;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramObject);
      ((Intent)localObject1).putExtra("from_shortcut", true);
      ((Intent)localObject1).putExtra("disable_minimize", true);
      ((Intent)localObject1).putExtra("MMActivity.OverrideEnterAnimation", e.a.anim_not_change);
      ((Intent)localObject1).putExtra("MMActivity.OverrideExitAnimation", e.a.push_down_out);
      com.tencent.mm.br.c.b((Context)this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 3001);
      overridePendingTransition(e.a.push_up_in, e.a.anim_not_change);
      AppMethodBeat.o(266656);
      return;
    }
    if ((paramObject instanceof com.tencent.mm.r.a.d))
    {
      localObject2 = dxI();
      localObject1 = ((com.tencent.mm.r.a.d)paramObject).appid;
      if (localObject1 == null)
      {
        localObject1 = "";
        paramObject = ((com.tencent.mm.r.a.d)paramObject).mdE;
        if (paramObject != null) {
          break label522;
        }
        paramObject = "";
      }
      label522:
      for (;;)
      {
        s.u(localObject1, "appId");
        s.u(paramObject, "stockId");
        Log.i("MicroMsg.SpringLuckyEggViewModel", "accept coupon: appId=" + (String)localObject1 + ", stockId=" + paramObject + ", traceId=" + ((c)localObject2).qTb);
        kotlinx.coroutines.j.a(((c)localObject2).scope, null, null, (kotlin.g.a.m)new c.b((String)localObject1, paramObject, (c)localObject2, null), 3);
        AppMethodBeat.o(266656);
        return;
        break;
      }
    }
    if ((paramObject instanceof com.tencent.mm.r.a.c))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", ((com.tencent.mm.r.a.c)paramObject).username);
      paramObject = f.xEl;
      ((Intent)localObject1).putExtra("key_session_id", String.valueOf(f.dxH()));
      ((Intent)localObject1).putExtra("key_comment_scene", 32);
      if (dxJ()) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(3, 12, 32, (Intent)localObject1);
      }
      for (;;)
      {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI((Context)this, (Intent)localObject1);
        AppMethodBeat.o(266656);
        return;
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(2, 12, 32, (Intent)localObject1);
      }
    }
    if ((paramObject instanceof com.tencent.mm.r.a.b))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("from_user", z.bAM());
      ((Intent)localObject1).putExtra("feed_encrypted_object_id", ((com.tencent.mm.r.a.b)paramObject).mdC);
      ((Intent)localObject1).putExtra("feed_object_nonceId", ((com.tencent.mm.r.a.b)paramObject).mdD);
      paramObject = f.xEl;
      ((Intent)localObject1).putExtra("key_session_id", String.valueOf(f.dxH()));
      ((Intent)localObject1).putExtra("key_comment_scene", 25);
      if (dxJ()) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(3, 12, 25, (Intent)localObject1);
      }
      for (;;)
      {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI((Context)this, (Intent)localObject1);
        AppMethodBeat.o(266656);
        return;
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(2, 12, 25, (Intent)localObject1);
      }
    }
    finish();
    AppMethodBeat.o(266656);
  }
  
  public final int getLayoutId()
  {
    return e.f.xEb;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(266815);
    super.onCreate(paramBundle);
    this.startTime = Util.nowMilliSecond();
    paramBundle = f.xEl;
    f.setAppId(getIntent().getStringExtra("app_id"));
    setMMTitle("");
    setBackBtn(new SpringLuckyEggActivity..ExternalSyntheticLambda0(this), e.g.icons_outlined_close);
    hideActionbarLine();
    getWindow().addFlags(128);
    getWindow().clearFlags(67108864);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    setActionbarColor(0);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    getWindow().setFormat(-3);
    paramBundle = (ViewGroup)findViewById(e.e.root);
    Object localObject = (MMAnimateView)findViewById(e.e.xDV);
    WeImageView localWeImageView1 = (WeImageView)findViewById(e.e.xDI);
    TextView localTextView1 = (TextView)findViewById(e.e.xDH);
    TextView localTextView2 = (TextView)findViewById(e.e.xDG);
    View localView = findViewById(e.e.xDK);
    TextView localTextView3 = (TextView)findViewById(e.e.xDF);
    ImageView localImageView = (ImageView)findViewById(e.e.xDE);
    ViewGroup localViewGroup1 = (ViewGroup)findViewById(e.e.xDU);
    ViewGroup localViewGroup2 = (ViewGroup)findViewById(e.e.xDM);
    MMAnimateView localMMAnimateView1 = (MMAnimateView)findViewById(e.e.xDT);
    TextView localTextView4 = (TextView)findViewById(e.e.fvq);
    TextView localTextView5 = (TextView)findViewById(e.e.xDQ);
    TextView localTextView6 = (TextView)findViewById(e.e.xDP);
    Button localButton = (Button)findViewById(e.e.xDL);
    MMAnimateView localMMAnimateView2 = (MMAnimateView)findViewById(e.e.xDN);
    ViewGroup localViewGroup3 = (ViewGroup)findViewById(e.e.xDO);
    ViewGroup localViewGroup4 = (ViewGroup)findViewById(e.e.fDM);
    TextView localTextView7 = (TextView)findViewById(e.e.xDZ);
    ViewGroup localViewGroup5 = (ViewGroup)findViewById(e.e.xDY);
    SpringEggVideoView localSpringEggVideoView = (SpringEggVideoView)findViewById(e.e.xDR);
    WeImageView localWeImageView2 = (WeImageView)findViewById(e.e.xDS);
    s.s(paramBundle, "findViewById(R.id.root)");
    s.s(localObject, "findViewById(R.id.loading_animator)");
    s.s(localWeImageView1, "findViewById(R.id.bottom…itle_clickable_indicator)");
    s.s(localTextView1, "findViewById(R.id.bottom_brand_title)");
    s.s(localTextView2, "findViewById(R.id.bottom_brand_subtitle)");
    s.s(localView, "findViewById(R.id.bottom_subtitle_divider)");
    s.s(localTextView3, "findViewById(R.id.bottom_brand_close)");
    s.s(localImageView, "findViewById(R.id.bottom_background_image)");
    s.s(localTextView4, "findViewById(R.id.card_brand_name)");
    s.s(localMMAnimateView1, "findViewById(R.id.card_brand_logo)");
    s.s(localViewGroup1, "findViewById(R.id.card_root)");
    s.s(localViewGroup2, "findViewById(R.id.card_bag_container)");
    s.s(localTextView5, "findViewById(R.id.card_bag_title)");
    s.s(localTextView6, "findViewById(R.id.card_bag_subtitle)");
    s.s(localButton, "findViewById(R.id.card_bag_accept_btn)");
    s.s(localViewGroup3, "findViewById(R.id.card_bag_media_container)");
    s.s(localMMAnimateView2, "findViewById(R.id.card_bag_cover)");
    s.s(localViewGroup4, "findViewById(R.id.cover_container)");
    s.s(localTextView7, "findViewById(R.id.money_value)");
    s.s(localViewGroup5, "findViewById(R.id.money_container)");
    s.s(localSpringEggVideoView, "findViewById(R.id.card_bag_video)");
    s.s(localWeImageView2, "findViewById(R.id.card_bag_volume_switch)");
    this.xEO = new b(paramBundle, (MMAnimateView)localObject, localWeImageView1, localTextView1, localTextView2, localView, localTextView3, localImageView, localTextView4, localMMAnimateView1, localViewGroup1, localViewGroup2, localTextView5, localTextView6, localButton, localViewGroup3, localMMAnimateView2, localViewGroup4, localTextView7, localViewGroup5, localSpringEggVideoView, localWeImageView2);
    localObject = this.xEO;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("viewBinding");
      paramBundle = null;
    }
    paramBundle.mJe.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new m(this));
    if (com.tencent.mm.vfs.y.ZC(PluginEggSpring.xDn))
    {
      localObject = this.xEO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("viewBinding");
        paramBundle = null;
      }
      paramBundle.xEU.setImageFilePath(PluginEggSpring.xDn);
    }
    for (;;)
    {
      localObject = this.xEO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("viewBinding");
        paramBundle = null;
      }
      paramBundle.xFf.setOnClickListener(new SpringLuckyEggActivity..ExternalSyntheticLambda2(this));
      findViewById(e.e.xDJ).setOnClickListener(new SpringLuckyEggActivity..ExternalSyntheticLambda1(this));
      localObject = this.xEO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("viewBinding");
        paramBundle = null;
      }
      paramBundle.xEZ.setOnClickListener(new SpringLuckyEggActivity..ExternalSyntheticLambda3(this));
      ((LiveData)dxI().xFr).a((androidx.lifecycle.q)this, (androidx.lifecycle.y)new e(this));
      ((LiveData)dxI().xFp).a((androidx.lifecycle.q)this, (androidx.lifecycle.y)new f(this));
      ((LiveData)dxI().xFu).a((androidx.lifecycle.q)this, (androidx.lifecycle.y)new g(this));
      ((LiveData)dxI().xFv).a((androidx.lifecycle.q)this, (androidx.lifecycle.y)new h(this));
      ((LiveData)dxI().xFq).a((androidx.lifecycle.q)this, (androidx.lifecycle.y)new i(this));
      ((LiveData)dxI().xFw).a((androidx.lifecycle.q)this, (androidx.lifecycle.y)new j(this));
      AppMethodBeat.o(266815);
      return;
      localObject = this.xEO;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("viewBinding");
        paramBundle = null;
      }
      paramBundle.xEU.setImageResource(e.d.xDC);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(266828);
    super.onDestroy();
    Object localObject1 = (com.tencent.mm.r.a.n)dxI().xFu.getValue();
    long l2;
    long l3;
    label52:
    int i;
    label65:
    long l1;
    if (localObject1 == null)
    {
      l2 = 0L;
      localObject1 = f.xEl;
      localObject1 = this.xEP;
      if (localObject1 != null) {
        break label200;
      }
      l3 = 0L;
      localObject1 = this.xEP;
      if (localObject1 != null) {
        break label210;
      }
      i = 0;
      localObject1 = this.xEP;
      if (localObject1 != null) {
        break label219;
      }
      l1 = 0L;
    }
    for (;;)
    {
      f.a(l3, i, l1, l2);
      localObject1 = this.xEP;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.VideoController", "release");
        localObject2 = ((d)localObject1).xFD;
        if (localObject2 != null) {
          v.bOi().l((String)localObject2, null);
        }
        ((d)localObject1).xFl.onUIDestroy();
        ((d)localObject1).xFE = 0L;
      }
      Object localObject2 = this.xEO;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewBinding");
        localObject1 = null;
      }
      ((b)localObject1).xEU.stop();
      ar.a(this.scope, null);
      AppMethodBeat.o(266828);
      return;
      l2 = ((com.tencent.mm.r.a.n)localObject1).mea;
      break;
      label200:
      l3 = ((d)localObject1).vYw;
      break label52;
      label210:
      i = ((d)localObject1).count;
      break label65;
      label219:
      if (((d)localObject1).xFE > 0L) {
        l1 = ((d)localObject1).playDuration + Util.milliSecondsToNow(((d)localObject1).xFE);
      } else {
        l1 = ((d)localObject1).playDuration;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(266820);
    super.onPause();
    Log.i("MicroMsg.SpringLuckyEggActivity", "onPause");
    d locald = this.xEP;
    if (locald != null)
    {
      Log.i("MicroMsg.VideoController", "pause");
      locald.xFl.onUIPause();
      locald.playDuration += Util.milliSecondsToNow(locald.xFE);
      locald.xFE = 0L;
    }
    AppMethodBeat.o(266820);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(266824);
    super.onResume();
    Log.i("MicroMsg.SpringLuckyEggActivity", "onResume");
    d locald = this.xEP;
    if (locald != null)
    {
      Log.i("MicroMsg.VideoController", "resume");
      locald.count -= 1;
      locald.xFl.onUIResume();
      locald.xFE = Util.nowMilliSecond();
    }
    AppMethodBeat.o(266824);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$animateCardToShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(SpringLuckyEggActivity paramSpringLuckyEggActivity, long paramLong) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(266602);
      Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationCancel");
      b localb = SpringLuckyEggActivity.a(this.xER);
      paramAnimator = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramAnimator = null;
      }
      paramAnimator.xEU.setVisibility(8);
      localb = SpringLuckyEggActivity.a(this.xER);
      paramAnimator = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramAnimator = null;
      }
      paramAnimator.xEU.stop();
      paramAnimator = SpringLuckyEggActivity.a(this.xER);
      if (paramAnimator == null)
      {
        s.bIx("viewBinding");
        paramAnimator = localObject;
      }
      for (;;)
      {
        paramAnimator.xEU.setVisibility(8);
        AppMethodBeat.o(266602);
        return;
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(266594);
      Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationEnd");
      b localb = SpringLuckyEggActivity.a(this.xER);
      paramAnimator = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramAnimator = null;
      }
      paramAnimator.xEU.setVisibility(8);
      localb = SpringLuckyEggActivity.a(this.xER);
      paramAnimator = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramAnimator = null;
      }
      paramAnimator.xEU.stop();
      localb = SpringLuckyEggActivity.a(this.xER);
      paramAnimator = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramAnimator = null;
      }
      paramAnimator.xEU.setVisibility(8);
      paramAnimator = (com.tencent.mm.r.a.n)SpringLuckyEggActivity.b(this.xER).xFu.getValue();
      int i;
      if (paramAnimator != null)
      {
        String str = paramAnimator.mdU;
        if (str != null)
        {
          paramAnimator = this.xER;
          if (((CharSequence)str).length() <= 0) {
            break label252;
          }
          i = 1;
          if (i != 0)
          {
            localb = SpringLuckyEggActivity.a(paramAnimator);
            paramAnimator = localb;
            if (localb == null)
            {
              s.bIx("viewBinding");
              paramAnimator = null;
            }
            paramAnimator.xEW.setText((CharSequence)str);
          }
        }
      }
      if (SpringLuckyEggActivity.b(this.xER).xFs.getValue() != null)
      {
        paramAnimator = SpringLuckyEggActivity.a(this.xER);
        if (paramAnimator == null)
        {
          s.bIx("viewBinding");
          paramAnimator = localObject1;
        }
        for (;;)
        {
          paramAnimator.xEV.setVisibility(0);
          AppMethodBeat.o(266594);
          return;
          label252:
          i = 0;
          break;
        }
      }
      paramAnimator = SpringLuckyEggActivity.a(this.xER);
      if (paramAnimator == null)
      {
        s.bIx("viewBinding");
        paramAnimator = localObject2;
      }
      for (;;)
      {
        paramAnimator.xEV.setVisibility(4);
        AppMethodBeat.o(266594);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(266609);
      Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationStart");
      b localb = SpringLuckyEggActivity.a(this.xER);
      paramAnimator = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramAnimator = null;
      }
      paramAnimator.xFd.setVisibility(0);
      paramAnimator = (com.tencent.mm.r.a.n)SpringLuckyEggActivity.b(this.xER).xFu.getValue();
      if (paramAnimator == null) {}
      for (long l = 0L;; l = paramAnimator.mea)
      {
        paramAnimator = f.xEl;
        f.an(Util.milliSecondsToNow(this.Uj), l);
        AppMethodBeat.o(266609);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e<T>
    implements androidx.lifecycle.y
  {
    public e(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      AppMethodBeat.i(266597);
      paramT = (String)paramT;
      int i = SpringLuckyEggActivity.a(this.xER, paramT, e.b.xDu);
      b localb = SpringLuckyEggActivity.a(this.xER);
      paramT = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        paramT = null;
      }
      paramT.mJe.setBackgroundColor(i);
      this.xER.setActionbarColor(i);
      this.xER.getWindow().setStatusBarColor(0);
      this.xER.getWindow().setNavigationBarColor(0);
      AppMethodBeat.o(266597);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f<T>
    implements androidx.lifecycle.y
  {
    public f(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      Object localObject = null;
      AppMethodBeat.i(266591);
      if (s.p((Boolean)paramT, Boolean.TRUE))
      {
        b localb = SpringLuckyEggActivity.a(this.xER);
        paramT = localb;
        if (localb == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFd.setVisibility(4);
        localb = SpringLuckyEggActivity.a(this.xER);
        paramT = localb;
        if (localb == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEU.start();
        paramT = SpringLuckyEggActivity.a(this.xER);
        if (paramT == null)
        {
          s.bIx("viewBinding");
          paramT = localObject;
        }
        for (;;)
        {
          paramT.xEU.setVisibility(0);
          AppMethodBeat.o(266591);
          return;
        }
      }
      SpringLuckyEggActivity.a(this.xER, SpringLuckyEggActivity.c(this.xER));
      AppMethodBeat.o(266591);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g<T>
    implements androidx.lifecycle.y
  {
    public g(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(266612);
      com.tencent.mm.r.a.n localn = (com.tencent.mm.r.a.n)paramT;
      Object localObject1;
      boolean bool;
      if (localn != null)
      {
        paramT = f.xEl;
        f.V(1, localn.mea);
        localObject1 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject1;
        if (localObject1 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFe.setText((CharSequence)localn.title);
        localObject1 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject1;
        if (localObject1 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.wyG.setText((CharSequence)localn.desc);
        if ((!s.p(SpringLuckyEggActivity.b(this.xER).xFw.getValue(), Boolean.TRUE)) || (!a.a(localn)))
        {
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xFf.setText((CharSequence)localn.mdR);
        }
        Object localObject4 = localn.meb.mel;
        if (localObject4 != null)
        {
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xFj.setText((CharSequence)((com.tencent.mm.r.a.q)localObject4).mes);
        }
        paramT = (CharSequence)localn.mdY;
        int i;
        if ((paramT == null) || (paramT.length() == 0)) {
          i = 1;
        }
        while (i == 0)
        {
          if (localn.mdX != 2) {
            break label788;
          }
          localObject4 = this.xER;
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          SpringEggVideoView localSpringEggVideoView = paramT.xFl;
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          localObject1 = localn.mdY;
          s.s(localObject1, "material.creative_url");
          SpringLuckyEggActivity.a((SpringLuckyEggActivity)localObject4, new d(localSpringEggVideoView, paramT, (String)localObject1));
          paramT = SpringLuckyEggActivity.d(this.xER);
          if (paramT != null)
          {
            Log.i("MicroMsg.VideoController", "start");
            paramT.xFl.start();
            localObject1 = paramT.xFl.getContext().getSystemService("audio");
            if (localObject1 == null)
            {
              paramT = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
              AppMethodBeat.o(266612);
              throw paramT;
              i = 0;
              continue;
            }
            localObject1 = (AudioManager)localObject1;
            Log.i("MicroMsg.VideoController", s.X("init: rangerMode=", Integer.valueOf(((AudioManager)localObject1).getRingerMode())));
            if (((AudioManager)localObject1).getRingerMode() == 2) {
              break label545;
            }
          }
          label545:
          for (bool = true;; bool = false)
          {
            paramT.setMute(bool);
            paramT.xEO.xFm.setVisibility(0);
            paramT.xFl.setVisibility(0);
            localObject1 = SpringLuckyEggActivity.a(this.xER);
            paramT = (TT)localObject1;
            if (localObject1 == null)
            {
              s.bIx("viewBinding");
              paramT = null;
            }
            paramT = paramT.xFg.getLayoutParams();
            if (paramT != null) {
              break;
            }
            paramT = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(266612);
            throw paramT;
          }
          paramT = (FrameLayout.LayoutParams)paramT;
          paramT.width = -1;
          paramT.height = this.xER.getResources().getDimensionPixelSize(e.c.xDw);
          paramT.topMargin = 0;
          paramT.gravity = 17;
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xFg.requestLayout();
          localObject1 = this.xER;
          paramT = localn.mdZ;
          s.s(paramT, "material.thumb_url");
        }
      }
      label647:
      label788:
      label971:
      for (;;)
      {
        bool = false;
        SpringLuckyEggActivity.a((SpringLuckyEggActivity)localObject1, paramT, bool);
        if (a.b(localn))
        {
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xFf.setVisibility(8);
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xFk.setVisibility(0);
          localObject1 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject1;
          if (localObject1 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xFi.setVisibility(8);
          paramT = SpringLuckyEggActivity.a(this.xER);
          if (paramT == null)
          {
            s.bIx("viewBinding");
            paramT = localObject2;
          }
          for (;;)
          {
            paramT.xFf.setVisibility(8);
            AppMethodBeat.o(266612);
            return;
            if (localn.mdX != 1) {
              break label647;
            }
            localObject1 = this.xER;
            paramT = localn.mdY;
            s.s(paramT, "material.creative_url");
            if ((localn == null) || (localn.mdP != 4)) {
              break label971;
            }
            bool = true;
            break;
          }
        }
        localObject1 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject1;
        if (localObject1 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFf.setVisibility(0);
        localObject1 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject1;
        if (localObject1 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFk.setVisibility(8);
        localObject1 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject1;
        if (localObject1 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFi.setVisibility(0);
        paramT = SpringLuckyEggActivity.a(this.xER);
        if (paramT == null)
        {
          s.bIx("viewBinding");
          paramT = localObject3;
        }
        for (;;)
        {
          paramT.xFf.setVisibility(0);
          AppMethodBeat.o(266612);
          return;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h<T>
    implements androidx.lifecycle.y
  {
    public h(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      Object localObject1 = null;
      AppMethodBeat.i(266611);
      com.tencent.mm.modelpackage.m localm = (com.tencent.mm.modelpackage.m)paramT;
      Object localObject3;
      int i;
      int j;
      label66:
      label84:
      Object localObject2;
      if (localm != null)
      {
        localObject3 = s.X(com.tencent.mm.plugin.emoji.mgr.h.getDataEmojiPath(), "/egg/");
        if (localm.oQT != 0) {
          break label753;
        }
        i = 1;
        paramT = this.xER.getWindow().getDecorView();
        if ((i == 0) || (Build.VERSION.SDK_INT < 23)) {
          break label758;
        }
        j = 9984;
        paramT.setSystemUiVisibility(j);
        paramT = this.xER;
        if (i == 0) {
          break label765;
        }
        i = e.b.BW_0;
        paramT.setBackBtnColorFilter(i);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.wyE.setText((CharSequence)localm.hEy);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFb.setImageFilePath((String)localObject3 + '/' + localm.oQH);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEW.setText((CharSequence)localm.oQD);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEX.setText((CharSequence)localm.oQF);
        i = SpringLuckyEggActivity.a(this.xER, localm.oQE, e.b.xDv);
        j = SpringLuckyEggActivity.a(this.xER, localm.oQG, e.b.xDt);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEW.setTextColor(SpringLuckyEggActivity.s(i, 0.6F));
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEV.F(i, 0.6F);
        ColorStateList localColorStateList = SpringLuckyEggActivity.s(j, 0.3F);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEX.setTextColor(localColorStateList);
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEY.setBackgroundColor(SpringLuckyEggActivity.JT(j));
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEZ.setTextColor(localColorStateList);
        if (localm.oQJ != null) {
          break label772;
        }
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFa.setImageBitmap(null);
        label517:
        localObject3 = (String)localObject3 + '/' + localm.oQO;
        if (!com.tencent.mm.vfs.y.ZC((String)localObject3)) {
          break label808;
        }
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEU.setImageFilePath((String)localObject3);
        label588:
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT = paramT.xFf;
        localObject3 = new int[] { -16842910 };
        localObject2 = StateSet.WILD_CARD;
        i = androidx.core.content.a.w((Context)this.xER, e.b.UN_BW_0_Alpha_0_3);
        j = SpringLuckyEggActivity.a(this.xER, localm.oQQ, e.b.White);
        paramT.setTextColor(new ColorStateList(new int[][] { localObject3, localObject2 }, new int[] { i, j }));
        paramT = SpringLuckyEggActivity.a(this.xER);
        if (paramT != null) {
          break label891;
        }
        s.bIx("viewBinding");
        paramT = localObject1;
      }
      label753:
      label758:
      label891:
      for (;;)
      {
        paramT.xFf.setBackground(SpringLuckyEggActivity.a(this.xER, SpringLuckyEggActivity.a(this.xER, localm.oQP, e.b.Red_90)));
        AppMethodBeat.o(266611);
        return;
        i = 0;
        break;
        j = 1792;
        break label66;
        label765:
        i = e.b.White;
        break label84;
        kotlinx.coroutines.j.a(SpringLuckyEggActivity.e(this.xER), null, null, (kotlin.g.a.m)new SpringLuckyEggActivity.k(this.xER, (String)localObject3, localm, null), 3);
        break label517;
        if (com.tencent.mm.vfs.y.ZC(PluginEggSpring.xDn))
        {
          localObject2 = SpringLuckyEggActivity.a(this.xER);
          paramT = (TT)localObject2;
          if (localObject2 == null)
          {
            s.bIx("viewBinding");
            paramT = null;
          }
          paramT.xEU.setImageFilePath(PluginEggSpring.xDn);
          break label588;
        }
        localObject2 = SpringLuckyEggActivity.a(this.xER);
        paramT = (TT)localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xEU.setImageResource(e.d.xDC);
        break label588;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i<T>
    implements androidx.lifecycle.y
  {
    public i(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      AppMethodBeat.i(266600);
      paramT = (com.tencent.mm.plugin.eggspring.c.a)paramT;
      if (paramT != null) {
        switch (SpringLuckyEggActivity.b.$EnumSwitchMapping$0[paramT.ordinal()])
        {
        }
      }
      for (;;)
      {
        SpringLuckyEggActivity.b(this.xER).xFq.setValue(null);
        AppMethodBeat.o(266600);
        return;
        aa.db((Context)this.xER.getContext(), this.xER.getContext().getResources().getString(e.h.xEj));
        continue;
        aa.dc((Context)this.xER.getContext(), this.xER.getContext().getResources().getString(e.h.xEi));
        continue;
        aa.dc((Context)this.xER.getContext(), this.xER.getContext().getResources().getString(e.h.xEh));
        continue;
        aa.dc((Context)this.xER.getContext(), this.xER.getContext().getResources().getString(e.h.xEi));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j<T>
    implements androidx.lifecycle.y
  {
    public j(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      Object localObject = null;
      AppMethodBeat.i(266596);
      paramT = (Boolean)paramT;
      if ((paramT != null) && (!s.p(paramT, Boolean.FALSE)) && (a.a((com.tencent.mm.r.a.n)SpringLuckyEggActivity.b(this.xER).xFu.getValue())))
      {
        b localb = SpringLuckyEggActivity.a(this.xER);
        paramT = localb;
        if (localb == null)
        {
          s.bIx("viewBinding");
          paramT = null;
        }
        paramT.xFf.setText((CharSequence)this.xER.getString(e.h.xEk));
        paramT = SpringLuckyEggActivity.a(this.xER);
        if (paramT != null) {
          break label122;
        }
        s.bIx("viewBinding");
        paramT = localObject;
      }
      label122:
      for (;;)
      {
        paramT.xFf.setEnabled(false);
        AppMethodBeat.o(266596);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    m(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onGlobalLayout()
    {
      Object localObject2 = null;
      AppMethodBeat.i(266603);
      b localb = SpringLuckyEggActivity.a(this.xER);
      Object localObject1 = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        localObject1 = null;
      }
      ((b)localObject1).mJe.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = com.tencent.mm.compatible.util.o.I((Context)this.xER.getContext(), 0);
      Context localContext = (Context)this.xER.getContext();
      localb = SpringLuckyEggActivity.a(this.xER);
      localObject1 = localb;
      if (localb == null)
      {
        s.bIx("viewBinding");
        localObject1 = null;
      }
      int j = com.tencent.mm.cd.a.K(localContext, ((b)localObject1).mJe.getMeasuredHeight() + i);
      if (j > 812)
      {
        localb = SpringLuckyEggActivity.a(this.xER);
        localObject1 = localb;
        if (localb == null)
        {
          s.bIx("viewBinding");
          localObject1 = null;
        }
        localObject1 = ((b)localObject1).xFc.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(266603);
          throw ((Throwable)localObject1);
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (com.tencent.mm.cd.a.fromDPToPix((Context)this.xER.getContext(), (j - 812) / 2 + 128) - i);
        localObject1 = SpringLuckyEggActivity.a(this.xER);
        if (localObject1 != null) {
          break label238;
        }
        s.bIx("viewBinding");
        localObject1 = localObject2;
      }
      label238:
      for (;;)
      {
        ((b)localObject1).xFc.requestLayout();
        AppMethodBeat.o(266603);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity
 * JD-Core Version:    0.7.0.1
 */