package com.tencent.mm.plugin.eggspring.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.StateSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import androidx.lifecycle.y.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.d.b;
import com.tencent.mm.plugin.eggspring.d.d;
import com.tencent.mm.plugin.eggspring.d.e;
import com.tencent.mm.plugin.eggspring.d.f;
import com.tencent.mm.plugin.eggspring.d.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "isChatRoom", "", "()Z", "isChatRoom$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startTime", "", "videoController", "Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "viewModel", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "viewModel$annotations", "getViewModel", "()Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "viewModel$delegate", "animateCardToShow", "", "bindViewModel", "createShapeDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "getLayoutId", "getSavePath", "", "url", "makeButtonBackground", "normalColor", "makeStatefulBottomTextColor", "Landroid/content/res/ColorStateList;", "alpha", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "redirect", "target", "", "safeColor", "fallback", "setCoverImage", "vertical", "setupBars", "setupViews", "setupWindow", "observe", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lkotlin/Function1;", "Companion", "plugin-eggspring_release"})
public final class SpringLuckyEggActivity
  extends MMActivity
{
  public static final SpringLuckyEggActivity.a uyi;
  private final ak rcY;
  private long startTime;
  private final f uye;
  private c uyf;
  private e uyg;
  private final f uyh;
  
  static
  {
    AppMethodBeat.i(249490);
    uyi = new SpringLuckyEggActivity.a((byte)0);
    AppMethodBeat.o(249490);
  }
  
  public SpringLuckyEggActivity()
  {
    AppMethodBeat.i(249489);
    this.rcY = al.iRe();
    this.uye = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.uyh = kotlin.g.ar((kotlin.g.a.a)new i(this));
    AppMethodBeat.o(249489);
  }
  
  private final Drawable Jm(int paramInt)
  {
    AppMethodBeat.i(249484);
    Object localObject = new PaintDrawable(paramInt);
    ((PaintDrawable)localObject).setCornerRadius(com.tencent.mm.ci.a.fromDPToPix((Context)this, 4.0F));
    localObject = (Drawable)localObject;
    AppMethodBeat.o(249484);
    return localObject;
  }
  
  public static final Intent a(Context paramContext, com.tencent.mm.be.e parame, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(249501);
    p.k(paramContext, "context");
    p.k(parame, "egg");
    p.k(paramString1, "keyword");
    paramContext = new Intent(paramContext, SpringLuckyEggActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString1);
    localBundle.putString("trace_id", paramString3);
    localBundle.putString("app_id", paramString2);
    localBundle.putString("egg_name", parame.name);
    localBundle.putString("background", parame.jIS.lXE);
    localBundle.putBoolean("is_chat_room", paramBoolean);
    paramContext.putExtras(localBundle);
    AppMethodBeat.o(249501);
    return paramContext;
  }
  
  private final d cTo()
  {
    AppMethodBeat.i(249481);
    d locald = (d)this.uye.getValue();
    AppMethodBeat.o(249481);
    return locald;
  }
  
  private final boolean cTp()
  {
    AppMethodBeat.i(249482);
    boolean bool = ((Boolean)this.uyh.getValue()).booleanValue();
    AppMethodBeat.o(249482);
    return bool;
  }
  
  private final int du(String paramString, @androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(249488);
    if (paramString == null)
    {
      paramInt = androidx.core.content.a.w((Context)this, paramInt);
      AppMethodBeat.o(249488);
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
        Log.w("MicroMsg.SpringLuckyEggActivity", "Illegal color value: ".concat(String.valueOf(paramString)));
        paramInt = androidx.core.content.a.w((Context)this, paramInt);
      }
    }
    AppMethodBeat.o(249488);
    return paramInt;
  }
  
  public final int getLayoutId()
  {
    return d.f.uxv;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249483);
    super.onCreate(paramBundle);
    this.startTime = Util.nowMilliSecond();
    paramBundle = com.tencent.mm.plugin.eggspring.e.uxF;
    com.tencent.mm.plugin.eggspring.e.setAppId(getIntent().getStringExtra("app_id"));
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this), d.g.icons_outlined_close);
    hideActionbarLine();
    getWindow().addFlags(128);
    getWindow().clearFlags(67108864);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    setActionbarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setStatusBarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setNavigationBarColor(0);
    getWindow().setFormat(-3);
    paramBundle = findViewById(d.e.root);
    p.j(paramBundle, "findViewById(R.id.root)");
    paramBundle = (ViewGroup)paramBundle;
    Object localObject1 = findViewById(d.e.uxp);
    p.j(localObject1, "findViewById(R.id.loading_animator)");
    localObject1 = (MMAnimateView)localObject1;
    Object localObject2 = findViewById(d.e.uxd);
    p.j(localObject2, "findViewById(R.id.bottom…itle_clickable_indicator)");
    localObject2 = (WeImageView)localObject2;
    Object localObject3 = findViewById(d.e.uxc);
    p.j(localObject3, "findViewById(R.id.bottom_brand_title)");
    localObject3 = (TextView)localObject3;
    Object localObject4 = findViewById(d.e.uxb);
    p.j(localObject4, "findViewById(R.id.bottom_brand_subtitle)");
    localObject4 = (TextView)localObject4;
    Object localObject5 = findViewById(d.e.uxa);
    p.j(localObject5, "findViewById(R.id.bottom_background_image)");
    localObject5 = (ImageView)localObject5;
    Object localObject6 = findViewById(d.e.uxo);
    p.j(localObject6, "findViewById(R.id.card_root)");
    localObject6 = (ViewGroup)localObject6;
    Object localObject7 = findViewById(d.e.uxg);
    p.j(localObject7, "findViewById(R.id.card_bag_container)");
    localObject7 = (ViewGroup)localObject7;
    Object localObject8 = findViewById(d.e.uxn);
    p.j(localObject8, "findViewById(R.id.card_brand_logo)");
    localObject8 = (MMAnimateView)localObject8;
    Object localObject9 = findViewById(d.e.duY);
    p.j(localObject9, "findViewById(R.id.card_brand_name)");
    localObject9 = (TextView)localObject9;
    Object localObject10 = findViewById(d.e.uxk);
    p.j(localObject10, "findViewById(R.id.card_bag_title)");
    localObject10 = (TextView)localObject10;
    Object localObject11 = findViewById(d.e.uxj);
    p.j(localObject11, "findViewById(R.id.card_bag_subtitle)");
    localObject11 = (TextView)localObject11;
    Object localObject12 = findViewById(d.e.uxf);
    p.j(localObject12, "findViewById(R.id.card_bag_accept_btn)");
    localObject12 = (Button)localObject12;
    Object localObject13 = findViewById(d.e.uxh);
    p.j(localObject13, "findViewById(R.id.card_bag_cover)");
    localObject13 = (MMAnimateView)localObject13;
    Object localObject14 = findViewById(d.e.uxi);
    p.j(localObject14, "findViewById(R.id.card_bag_media_container)");
    localObject14 = (ViewGroup)localObject14;
    Object localObject15 = findViewById(d.e.dCU);
    p.j(localObject15, "findViewById(R.id.cover_container)");
    localObject15 = (ViewGroup)localObject15;
    Object localObject16 = findViewById(d.e.uxt);
    p.j(localObject16, "findViewById(R.id.money_value)");
    localObject16 = (TextView)localObject16;
    Object localObject17 = findViewById(d.e.uxs);
    p.j(localObject17, "findViewById(R.id.money_container)");
    localObject17 = (ViewGroup)localObject17;
    Object localObject18 = findViewById(d.e.uxl);
    p.j(localObject18, "findViewById(R.id.card_bag_video)");
    localObject18 = (SpringEggVideoView)localObject18;
    View localView = findViewById(d.e.uxm);
    p.j(localView, "findViewById(R.id.card_bag_volume_switch)");
    this.uyf = new c(paramBundle, (MMAnimateView)localObject1, (WeImageView)localObject2, (TextView)localObject3, (TextView)localObject4, (ImageView)localObject5, (TextView)localObject9, (MMAnimateView)localObject8, (ViewGroup)localObject6, (ViewGroup)localObject7, (TextView)localObject10, (TextView)localObject11, (Button)localObject12, (ViewGroup)localObject14, (MMAnimateView)localObject13, (ViewGroup)localObject15, (TextView)localObject16, (ViewGroup)localObject17, (SpringEggVideoView)localObject18, (WeImageView)localView);
    paramBundle = this.uyf;
    if (paramBundle == null) {
      p.bGy("viewBinding");
    }
    paramBundle.kiF.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new l(this));
    if (u.agG(PluginEggSpring.uwM))
    {
      paramBundle = this.uyf;
      if (paramBundle == null) {
        p.bGy("viewBinding");
      }
      paramBundle.uyq.setImageFilePath(PluginEggSpring.uwM);
    }
    for (;;)
    {
      paramBundle = this.uyf;
      if (paramBundle == null) {
        p.bGy("viewBinding");
      }
      paramBundle.uyz.setOnClickListener((View.OnClickListener)new SpringLuckyEggActivity.m(this));
      findViewById(d.e.uxe).setOnClickListener((View.OnClickListener)new SpringLuckyEggActivity.n(this));
      ((LiveData)cTo().uyJ).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new c(this));
      ((LiveData)cTo().uyH).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new d(this));
      ((LiveData)cTo().uyM).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new SpringLuckyEggActivity.e(this));
      ((LiveData)cTo().uyN).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new f(this));
      ((LiveData)cTo().uyI).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new SpringLuckyEggActivity.g(this));
      ((LiveData)cTo().uyO).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new SpringLuckyEggActivity.h(this));
      AppMethodBeat.o(249483);
      return;
      paramBundle = this.uyf;
      if (paramBundle == null) {
        p.bGy("viewBinding");
      }
      paramBundle.uyq.setImageResource(d.d.uwY);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249487);
    super.onDestroy();
    Object localObject = (com.tencent.mm.t.a.n)cTo().uyM.getValue();
    long l2;
    long l3;
    label60:
    int i;
    label77:
    long l1;
    if (localObject != null)
    {
      l2 = ((com.tencent.mm.t.a.n)localObject).jEe;
      localObject = com.tencent.mm.plugin.eggspring.e.uxF;
      localObject = this.uyg;
      if (localObject == null) {
        break label224;
      }
      l3 = ((e)localObject).sTg;
      localObject = this.uyg;
      if (localObject == null) {
        break label230;
      }
      i = ((e)localObject).count;
      localObject = this.uyg;
      if (localObject == null) {
        break label244;
      }
      if (((e)localObject).uyZ <= 0L) {
        break label235;
      }
      l1 = ((e)localObject).playDuration + Util.milliSecondsToNow(((e)localObject).uyZ);
    }
    for (;;)
    {
      com.tencent.mm.plugin.eggspring.e.a(l3, i, l1, l2);
      localObject = this.uyg;
      if (localObject != null)
      {
        Log.i("MicroMsg.VideoController", "release");
        String str = ((e)localObject).uyY;
        if (str != null) {
          com.tencent.mm.modelvideo.s.bqC().l(str, null);
        }
        ((e)localObject).uyF.onUIDestroy();
        ((e)localObject).uyZ = 0L;
      }
      localObject = this.uyf;
      if (localObject == null) {
        p.bGy("viewBinding");
      }
      ((c)localObject).uyq.stop();
      al.a(this.rcY, null);
      AppMethodBeat.o(249487);
      return;
      l2 = 0L;
      break;
      label224:
      l3 = 0L;
      break label60;
      label230:
      i = 0;
      break label77;
      label235:
      l1 = ((e)localObject).playDuration;
      continue;
      label244:
      l1 = 0L;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249485);
    super.onPause();
    Log.i("MicroMsg.SpringLuckyEggActivity", "onPause");
    e locale = this.uyg;
    if (locale != null)
    {
      Log.i("MicroMsg.VideoController", "pause");
      locale.uyF.onUIPause();
      locale.playDuration += Util.milliSecondsToNow(locale.uyZ);
      locale.uyZ = 0L;
      AppMethodBeat.o(249485);
      return;
    }
    AppMethodBeat.o(249485);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249486);
    super.onResume();
    Log.i("MicroMsg.SpringLuckyEggActivity", "onResume");
    e locale = this.uyg;
    if (locale != null)
    {
      Log.i("MicroMsg.VideoController", "resume");
      locale.count -= 1;
      locale.uyF.onUIResume();
      locale.uyZ = Util.nowMilliSecond();
      AppMethodBeat.o(249486);
      return;
    }
    AppMethodBeat.o(249486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$animateCardToShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(long paramLong) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(249460);
      Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationCancel");
      SpringLuckyEggActivity.a(this.uyj).uyq.setVisibility(8);
      SpringLuckyEggActivity.a(this.uyj).uyq.stop();
      SpringLuckyEggActivity.a(this.uyj).uyq.setVisibility(8);
      AppMethodBeat.o(249460);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(249458);
      Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationEnd");
      SpringLuckyEggActivity.a(this.uyj).uyq.setVisibility(8);
      SpringLuckyEggActivity.a(this.uyj).uyq.stop();
      SpringLuckyEggActivity.a(this.uyj).uyq.setVisibility(8);
      paramAnimator = (com.tencent.mm.t.a.n)SpringLuckyEggActivity.b(this.uyj).uyM.getValue();
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.jDY;
        if (paramAnimator != null) {
          if (((CharSequence)paramAnimator).length() <= 0) {
            break label156;
          }
        }
      }
      label156:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          SpringLuckyEggActivity.a(this.uyj).uys.setText((CharSequence)paramAnimator);
        }
        if (SpringLuckyEggActivity.b(this.uyj).uyK.getValue() == null) {
          break;
        }
        SpringLuckyEggActivity.a(this.uyj).uyr.setVisibility(0);
        AppMethodBeat.o(249458);
        return;
      }
      SpringLuckyEggActivity.a(this.uyj).uyr.setVisibility(4);
      AppMethodBeat.o(249458);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(249461);
      Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationStart");
      SpringLuckyEggActivity.a(this.uyj).uyx.setVisibility(0);
      paramAnimator = (com.tencent.mm.t.a.n)SpringLuckyEggActivity.b(this.uyj).uyM.getValue();
      if (paramAnimator != null) {}
      for (long l = paramAnimator.jEe;; l = 0L)
      {
        paramAnimator = com.tencent.mm.plugin.eggspring.e.uxF;
        com.tencent.mm.plugin.eggspring.e.Q(Util.milliSecondsToNow(this.uyk), l);
        AppMethodBeat.o(249461);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
  public static final class c<T>
    implements androidx.lifecycle.s<T>
  {
    public c(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      AppMethodBeat.i(249292);
      paramT = (String)paramT;
      int i = SpringLuckyEggActivity.a(this.uyj, paramT, d.b.uwQ);
      SpringLuckyEggActivity.a(this.uyj).kiF.setBackgroundColor(i);
      this.uyj.setActionbarColor(i);
      paramT = this.uyj.getWindow();
      p.j(paramT, "window");
      paramT.setStatusBarColor(0);
      paramT = this.uyj.getWindow();
      p.j(paramT, "window");
      paramT.setNavigationBarColor(0);
      AppMethodBeat.o(249292);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
  public static final class d<T>
    implements androidx.lifecycle.s<T>
  {
    public d(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      AppMethodBeat.i(249531);
      if (p.h((Boolean)paramT, Boolean.TRUE))
      {
        SpringLuckyEggActivity.a(this.uyj).uyx.setVisibility(4);
        SpringLuckyEggActivity.a(this.uyj).uyq.start();
        SpringLuckyEggActivity.a(this.uyj).uyq.setVisibility(0);
        AppMethodBeat.o(249531);
        return;
      }
      SpringLuckyEggActivity.a(this.uyj, SpringLuckyEggActivity.c(this.uyj));
      AppMethodBeat.o(249531);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
  public static final class f<T>
    implements androidx.lifecycle.s<T>
  {
    public f(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void onChanged(T paramT)
    {
      AppMethodBeat.i(249672);
      paramT = (com.tencent.mm.be.l)paramT;
      if (paramT == null)
      {
        AppMethodBeat.o(249672);
        return;
      }
      Object localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = (h.getDataEmojiPath() + "/egg/");
      int i;
      Object localObject2;
      int j;
      if (paramT.lXP == 0)
      {
        i = 1;
        localObject2 = this.uyj.getWindow();
        p.j(localObject2, "window");
        localObject2 = ((Window)localObject2).getDecorView();
        p.j(localObject2, "window.decorView");
        if ((i == 0) || (Build.VERSION.SDK_INT < 23)) {
          break label564;
        }
        j = 9984;
        label110:
        ((View)localObject2).setSystemUiVisibility(j);
        localObject2 = this.uyj;
        if (i == 0) {
          break label571;
        }
        i = -16777216;
        label129:
        ((SpringLuckyEggActivity)localObject2).setBackBtnColorFilter(i);
        SpringLuckyEggActivity.a(this.uyj).tuh.setText((CharSequence)paramT.fzM);
        SpringLuckyEggActivity.a(this.uyj).uyv.setImageFilePath((String)((aa.f)localObject1).aaBC + '/' + paramT.lXD);
        SpringLuckyEggActivity.a(this.uyj).uys.setText((CharSequence)paramT.lXz);
        SpringLuckyEggActivity.a(this.uyj).uyt.setText((CharSequence)paramT.lXB);
        i = SpringLuckyEggActivity.a(this.uyj, paramT.lXA, d.b.uwR);
        j = SpringLuckyEggActivity.a(this.uyj, paramT.lXC, d.b.uwP);
        SpringLuckyEggActivity.a(this.uyj).uys.setTextColor(SpringLuckyEggActivity.p(i, 0.6F));
        SpringLuckyEggActivity.a(this.uyj).uyr.C(i, 0.6F);
        SpringLuckyEggActivity.a(this.uyj).uyt.setTextColor(SpringLuckyEggActivity.a(this.uyj, paramT.lXC, d.b.uwP));
        SpringLuckyEggActivity.a(this.uyj).uyt.setTextColor(SpringLuckyEggActivity.p(j, 0.3F));
        if (paramT.lXF != null) {
          break label576;
        }
        SpringLuckyEggActivity.a(this.uyj).uyu.setImageBitmap(null);
        label373:
        localObject1 = (String)((aa.f)localObject1).aaBC + '/' + paramT.lXK;
        if (!u.agG((String)localObject1)) {
          break label607;
        }
        SpringLuckyEggActivity.a(this.uyj).uyq.setImageFilePath((String)localObject1);
      }
      for (;;)
      {
        localObject1 = SpringLuckyEggActivity.a(this.uyj).uyz;
        localObject2 = StateSet.WILD_CARD;
        ((Button)localObject1).setTextColor(new ColorStateList((int[][])new int[][] { { -16842910 }, localObject2 }, new int[] { androidx.core.content.a.w((Context)this.uyj, d.b.UN_BW_0_Alpha_0_3), SpringLuckyEggActivity.a(this.uyj, paramT.lXM, d.b.White) }));
        SpringLuckyEggActivity.a(this.uyj).uyz.setBackground(SpringLuckyEggActivity.a(this.uyj, SpringLuckyEggActivity.a(this.uyj, paramT.lXL, d.b.Red_90)));
        AppMethodBeat.o(249672);
        return;
        i = 0;
        break;
        label564:
        j = 1792;
        break label110;
        label571:
        i = -1;
        break label129;
        label576:
        kotlinx.coroutines.g.b(SpringLuckyEggActivity.e(this.uyj), null, (m)new SpringLuckyEggActivity.f.a((aa.f)localObject1, paramT, null, this), 3);
        break label373;
        label607:
        if (u.agG(PluginEggSpring.uwM)) {
          SpringLuckyEggActivity.a(this.uyj).uyq.setImageFilePath(PluginEggSpring.uwM);
        } else {
          SpringLuckyEggActivity.a(this.uyj).uyq.setImageResource(d.d.uwY);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    i(SpringLuckyEggActivity paramSpringLuckyEggActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 3>", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V"})
  static final class j
    implements k
  {
    j(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(249678);
      if (paramBitmap == null)
      {
        paramString = (com.tencent.mm.be.l)SpringLuckyEggActivity.b(this.uyj).uyN.getValue();
        if (paramString != null)
        {
          paramView = (CharSequence)paramString.lXN;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label135;
          }
        }
      }
      label135:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramView = h.getDataEmojiPath() + "/egg/";
          paramString = paramView + '/' + paramString.lXN;
          if (u.agG(paramString)) {
            SpringLuckyEggActivity.a(this.uyj).uyB.setImageFilePath(paramString);
          }
        }
        AppMethodBeat.o(249678);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(249318);
      this.uyj.finish();
      AppMethodBeat.o(249318);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-eggspring_release"})
  public static final class l
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(249637);
      SpringLuckyEggActivity.a(this.uyj).kiF.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = com.tencent.mm.compatible.util.n.getStatusBarHeight((Context)this.uyj.getContext());
      int j = com.tencent.mm.ci.a.H((Context)this.uyj.getContext(), SpringLuckyEggActivity.a(this.uyj).kiF.getMeasuredHeight() + i);
      if (j > 812)
      {
        Object localObject = SpringLuckyEggActivity.a(this.uyj).uyw.getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(249637);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = (com.tencent.mm.ci.a.fromDPToPix((Context)this.uyj.getContext(), (j - 812) / 2 + 128) - i);
        SpringLuckyEggActivity.a(this.uyj).uyw.requestLayout();
      }
      AppMethodBeat.o(249637);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<d>
  {
    o(SpringLuckyEggActivity paramSpringLuckyEggActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity
 * JD-Core Version:    0.7.0.1
 */