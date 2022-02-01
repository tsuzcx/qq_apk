package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iw;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarNicknameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getActionBarNicknameTv", "()Landroid/widget/TextView;", "actionBarNicknameTv$delegate", "Lkotlin/Lazy;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "backBtnIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBackBtnIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "backBtnIv$delegate", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "coverAlphaView", "Landroid/view/View;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1;", "isAvatarLoaded", "", "lastActionBarProgress", "", "moreBtn", "Landroid/widget/LinearLayout;", "getMoreBtn", "()Landroid/widget/LinearLayout;", "moreBtn$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", "username", "", "changeViewAlpha", "", "progress", "alpha", "fixActionBarStatus", "hideActionBar", "initCustomActionBar", "loadAvatar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setCoveredStyle", "setNormalStyle", "setVisibleStats", "view", "visibleStat", "OnOffsetChangedListener", "plugin-finder_release"})
public final class f
  extends UIComponent
{
  private bkr fGc;
  private String username;
  private final kotlin.f wYL;
  private final kotlin.f wYM;
  private final kotlin.f wYN;
  private final kotlin.f wYO;
  private final kotlin.f wYP;
  private final kotlin.f wYQ;
  private final kotlin.f wYR;
  private View wYS;
  private int wYT;
  private boolean wYU;
  private final f wYV;
  private float wYW;
  private int wYX;
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279298);
    this.wYL = g.ar((a)new c(paramAppCompatActivity));
    this.wYM = g.ar((a)new e(paramAppCompatActivity));
    this.wYN = g.ar((a)new b(paramAppCompatActivity));
    this.wYO = g.ar((a)new i(paramAppCompatActivity));
    this.wYP = g.ar((a)new d(paramAppCompatActivity));
    this.wYQ = g.ar((a)new g(paramAppCompatActivity));
    this.wYR = g.ar((a)new h(paramAppCompatActivity));
    this.wYT = paramAppCompatActivity.getResources().getColor(b.c.finder_activity_covered_background);
    this.username = "";
    this.wYV = new f(this);
    AppMethodBeat.o(279298);
  }
  
  private static void ah(View paramView, int paramInt)
  {
    AppMethodBeat.i(279297);
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(279297);
  }
  
  private final AppBarLayout dmO()
  {
    AppMethodBeat.i(279290);
    AppBarLayout localAppBarLayout = (AppBarLayout)this.wYL.getValue();
    AppMethodBeat.o(279290);
    return localAppBarLayout;
  }
  
  private final TextView dmP()
  {
    AppMethodBeat.i(279292);
    TextView localTextView = (TextView)this.wYN.getValue();
    AppMethodBeat.o(279292);
    return localTextView;
  }
  
  private final LinearLayout dmQ()
  {
    AppMethodBeat.i(279293);
    LinearLayout localLinearLayout = (LinearLayout)this.wYO.getValue();
    AppMethodBeat.o(279293);
    return localLinearLayout;
  }
  
  private final LinearLayout dmR()
  {
    AppMethodBeat.i(279294);
    LinearLayout localLinearLayout = (LinearLayout)this.wYR.getValue();
    AppMethodBeat.o(279294);
    return localLinearLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279295);
    super.onCreate(paramBundle);
    this.wYV.alive();
    Object localObject = getActivity().getIntent().getStringExtra("key_creator_finder_name");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.username = paramBundle;
    paramBundle = getActivity().getWindow();
    p.j(paramBundle, "activity.window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    c.f((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = ax.getStatusBarHeight((Context)getActivity());
    paramBundle = dmR();
    p.j(paramBundle, "myActionBar");
    paramBundle = paramBundle.getLayoutParams();
    paramBundle.height += i;
    localObject = dmR();
    p.j(localObject, "myActionBar");
    ((LinearLayout)localObject).setLayoutParams(paramBundle);
    dmR().setPadding(0, i, 0, 0);
    paramBundle = dmQ();
    p.j(paramBundle, "userInfoLayout");
    paramBundle.setAlpha(0.0F);
    this.wYS = getActivity().findViewById(b.f.activity_profile_cover_alpha);
    paramBundle = dmO();
    localObject = new a();
    AppBarLayout localAppBarLayout = dmO();
    p.j(localAppBarLayout, "appBarLayout");
    ((a)localObject).c(localAppBarLayout, 0);
    paramBundle.a((AppBarLayout.b)localObject);
    AppMethodBeat.o(279295);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279296);
    super.onDestroy();
    this.wYV.dead();
    AppMethodBeat.o(279296);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC;)V", "onOffsetChanged", "", "view", "Lcom/google/android/material/appbar/AppBarLayout;", "offset", "", "plugin-finder_release"})
  public final class a
    implements AppBarLayout.b
  {
    public final void c(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(284190);
      p.k(paramAppBarLayout, "view");
      f.a(this.wYY, paramInt);
      float f2 = Math.abs(paramInt) * 1.0F / paramAppBarLayout.getTotalScrollRange();
      if (f2 == f.a(this.wYY))
      {
        AppMethodBeat.o(284190);
        return;
      }
      f.a(this.wYY, f2);
      float f1;
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        f.b(this.wYY).setBackgroundColor(this.wYY.getResources().getColor(b.c.transparent));
        paramAppBarLayout = f.c(this.wYY);
        p.j(paramAppBarLayout, "userInfoLayout");
        paramAppBarLayout.setAlpha(0.0F);
        f.a(this.wYY, f2, f1);
      }
      for (;;)
      {
        paramAppBarLayout = f.e(this.wYY);
        if (paramAppBarLayout != null) {
          paramAppBarLayout.setAlpha(f2);
        }
        Log.i("SimpleUIComponent", "alpha : ".concat(String.valueOf(f1)));
        AppMethodBeat.o(284190);
        return;
        f1 = (f2 - 0.5F) / 0.5F;
        paramInt = (int)(255.0F * f1);
        f.b(this.wYY).setBackgroundColor(au.fG(f.d(this.wYY), paramInt));
        paramAppBarLayout = f.c(this.wYY);
        p.j(paramAppBarLayout, "userInfoLayout");
        paramAppBarLayout.setAlpha(f1);
        f.a(this.wYY, f2, f1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<TextView>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<AppBarLayout>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<WeImageView>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements a<CoordinatorLayout>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class f
    extends IListener<iw>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements a<LinearLayout>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements a<LinearLayout>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements a<LinearLayout>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.f
 * JD-Core Version:    0.7.0.1
 */