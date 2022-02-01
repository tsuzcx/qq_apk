package com.tencent.mm.plugin.finder.nearby;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.f;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isCurrentResume", "", "buildTab", "", "checkAddFootPrintRedDot", "getNearbyTab", "Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "index", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "setMenuType", "menuType", "setNearbyVideoTabTitle", "title", "", "setTabIndex", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "NearbyTab", "plugin-finder_release"})
public final class NearbyActionBarUIC
  extends UIComponent
{
  public static final a uPV;
  private boolean uPU;
  
  static
  {
    AppMethodBeat.i(248990);
    uPV = new a((byte)0);
    AppMethodBeat.o(248990);
  }
  
  public NearbyActionBarUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248989);
    AppMethodBeat.o(248989);
  }
  
  public static TabLayout.f a(TabLayout paramTabLayout, Object paramObject)
  {
    AppMethodBeat.i(248988);
    p.h(paramTabLayout, "$this$findByTag");
    p.h(paramObject, "any");
    int j = paramTabLayout.getTabCount();
    int i = 0;
    if (i < j)
    {
      TabLayout.f localf = paramTabLayout.ab(i);
      Object localObject;
      if (localf != null) {
        localObject = localf.getTag();
      }
      int k;
      while ((localObject instanceof b))
      {
        localObject = localf.getTag();
        if (localObject == null)
        {
          paramTabLayout = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
          AppMethodBeat.o(248988);
          throw paramTabLayout;
          localObject = null;
        }
        else
        {
          k = ((b)localObject).dLS;
          if ((paramObject instanceof Integer)) {
            break label115;
          }
        }
      }
      label115:
      while (k != ((Integer)paramObject).intValue())
      {
        i += 1;
        break;
      }
      AppMethodBeat.o(248988);
      return localf;
    }
    AppMethodBeat.o(248988);
    return null;
  }
  
  public static void dlg()
  {
    AppMethodBeat.i(248985);
    if (!com.tencent.mm.bp.a.Xm())
    {
      Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: add footprint red dot");
      locala = g.ah(PluginFinder.class);
      p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager().tJA.dbs();
      AppMethodBeat.o(248985);
      return;
    }
    Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: clear footprint red dot");
    com.tencent.mm.kernel.b.a locala = g.ah(PluginFinder.class);
    p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)locala).getRedDotManager().Iy(1014);
    AppMethodBeat.o(248985);
  }
  
  public final void Jx(int paramInt)
  {
    AppMethodBeat.i(248984);
    Object localObject = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131308839);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).ab(paramInt);
      if (localObject != null)
      {
        p.g(localObject, "this");
        if (!((TabLayout.f)localObject).isSelected()) {
          ((TabLayout.f)localObject).select();
        }
        AppMethodBeat.o(248984);
        return;
      }
    }
    AppMethodBeat.o(248984);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(248983);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131297168)).setOnClickListener((View.OnClickListener)new d(this));
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131308833)).setOnSingleClickListener((HardTouchableLayout.g)new e(this));
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131308833)).setOnDoubleClickListener((HardTouchableLayout.b)new f(this));
    ((ConstraintLayout)((FragmentActivity)getActivity()).findViewById(2131305260)).setOnClickListener((View.OnClickListener)new g(this));
    paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(2131305261);
    if (paramBundle != null) {
      paramBundle.setTextSize(1, 15.0F);
    }
    paramBundle = a.uQd;
    a.dlh();
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    if (((NearbyHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(NearbyHomeUIC.class)).fragments.size() == 2)
    {
      paramBundle = (HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131308833);
      p.g(paramBundle, "activity.tab_container_htl");
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(248983);
        throw paramBundle;
      }
      ((ConstraintLayout.LayoutParams)paramBundle).leftMargin = 0;
    }
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131308839);
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = ((Iterable)((NearbyHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(NearbyHomeUIC.class)).fragments).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject2 = (AbsNearByFragment)localObject2;
      Object localObject3 = paramBundle.cW();
      p.g(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.f)localObject3, ((AbsNearByFragment)localObject2).dLS);
      if (!TextUtils.isEmpty((CharSequence)((AbsNearByFragment)localObject2).title)) {
        ((b)localObject3).setTitle(((AbsNearByFragment)localObject2).title);
      }
      for (;;)
      {
        ((b)localObject3).index = i;
        paramBundle.a(((b)localObject3).vq, false);
        i += 1;
        break;
        localObject2 = getContext().getString(((AbsNearByFragment)localObject2).uQk);
        p.g(localObject2, "context.getString(fragment.titleId)");
        ((b)localObject3).setTitle((String)localObject2);
      }
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131308839);
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dbc(), (LifecycleOwner)getActivity(), (Observer)new h(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dbd(), (LifecycleOwner)getActivity(), (Observer)new i(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dbe(), (LifecycleOwner)getActivity(), (Observer)new j(this, paramBundle));
    AppMethodBeat.o(248983);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(248987);
    super.onPause();
    this.uPU = false;
    AppMethodBeat.o(248987);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(248986);
    super.onResume();
    this.uPU = true;
    AppMethodBeat.o(248986);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$Companion;", "", "()V", "MENU_TYPE_LIVE", "", "MENU_TYPE_PERSON", "MENU_TYPE_VIDEO", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "Landroid/widget/TextView;", "getTabRedTv", "()Landroid/widget/TextView;", "setTabRedTv", "(Landroid/widget/TextView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "title", "", "plugin-finder_release"})
  public static final class b
  {
    int dLS;
    int index;
    TextView titleTv;
    WeImageView uPW;
    ImageView uPX;
    TabLayout.f vq;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(248968);
      this.vq = paramf;
      this.dLS = paramInt;
      this.vq.g(this);
      switch (this.dLS)
      {
      default: 
        this.vq.aj(2131494343);
        AppMethodBeat.o(248968);
        return;
      case 1001: 
        this.vq.aj(2131495822);
        paramf = this.vq.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308826);
          if (paramf == null) {
            p.hyc();
          }
          this.titleTv = paramf;
          paramf = this.vq.getCustomView();
          if (paramf == null) {
            break label185;
          }
        }
        for (paramf = (ImageView)paramf.findViewById(2131308823);; paramf = null)
        {
          if (paramf == null) {
            p.hyc();
          }
          this.uPX = paramf;
          paramf = this.titleTv;
          if (paramf == null) {
            break label190;
          }
          paramf.setTextSize(1, 15.0F);
          AppMethodBeat.o(248968);
          return;
          paramf = null;
          break;
        }
        AppMethodBeat.o(248968);
        return;
      case 1002: 
        label185:
        label190:
        this.vq.aj(2131495822);
        paramf = this.vq.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308826);
          if (paramf == null) {
            p.hyc();
          }
          this.titleTv = paramf;
          paramf = this.vq.getCustomView();
          if (paramf == null) {
            break label301;
          }
        }
        label301:
        for (paramf = (ImageView)paramf.findViewById(2131308823);; paramf = null)
        {
          if (paramf == null) {
            p.hyc();
          }
          this.uPX = paramf;
          paramf = this.titleTv;
          if (paramf == null) {
            break label306;
          }
          paramf.setTextSize(1, 15.0F);
          AppMethodBeat.o(248968);
          return;
          paramf = null;
          break;
        }
        label306:
        AppMethodBeat.o(248968);
        return;
      }
      this.vq.aj(2131495823);
      paramf = this.vq.getCustomView();
      if (paramf != null)
      {
        paramf = (TextView)paramf.findViewById(2131308826);
        if (paramf == null) {
          p.hyc();
        }
        this.titleTv = paramf;
        paramf = this.titleTv;
        if (paramf != null) {
          paramf.setTextSize(1, 15.0F);
        }
        paramf = this.vq.getCustomView();
        if (paramf == null) {
          break label471;
        }
        paramf = (WeImageView)paramf.findViewById(2131308829);
        label394:
        if (paramf == null) {
          p.hyc();
        }
        this.uPW = paramf;
        paramf = this.vq.getCustomView();
        if (paramf == null) {
          break label476;
        }
      }
      label471:
      label476:
      for (paramf = (ImageView)paramf.findViewById(2131308823);; paramf = null)
      {
        if (paramf == null) {
          p.hyc();
        }
        this.uPX = paramf;
        if (!com.tencent.mm.bp.a.Xm()) {
          break label487;
        }
        paramf = this.uPW;
        if (paramf == null) {
          break label481;
        }
        paramf.setVisibility(4);
        AppMethodBeat.o(248968);
        return;
        paramf = null;
        break;
        paramf = null;
        break label394;
      }
      label481:
      AppMethodBeat.o(248968);
      return;
      label487:
      paramf = this.uPW;
      if (paramf != null)
      {
        paramf.setVisibility(0);
        AppMethodBeat.o(248968);
        return;
      }
      AppMethodBeat.o(248968);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(248967);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(248967);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(248967);
        return;
      }
      AppMethodBeat.o(248967);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(248966);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.vq.getCustomView();
        if (localObject == null) {
          p.hyc();
        }
        p.g(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        p.g(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(248966);
        return;
      }
      AppMethodBeat.o(248966);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(248965);
      p.h(paramString, "title");
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)paramString);
        AppMethodBeat.o(248965);
        return;
      }
      AppMethodBeat.o(248965);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void i(TabLayout.f paramf)
    {
      AppMethodBeat.i(248971);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof NearbyActionBarUIC.b))
      {
        ((NearbyActionBarUIC.b)paramf).setTextColor(2131100904);
        ((NearbyActionBarUIC.b)paramf).setTextBold(true);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        ((NearbyHomeUIC)com.tencent.mm.ui.component.a.b(this.uPY.getActivity()).get(NearbyHomeUIC.class)).Jz(((NearbyActionBarUIC.b)paramf).dLS);
        switch (((NearbyActionBarUIC.b)paramf).dLS)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(248971);
        return;
        NearbyActionBarUIC.a(this.uPY, 3);
        NearbyActionBarUIC.dlg();
        AppMethodBeat.o(248971);
        return;
        NearbyActionBarUIC.a(this.uPY, 2);
        AppMethodBeat.o(248971);
        return;
        NearbyActionBarUIC.a(this.uPY, 1);
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void j(TabLayout.f paramf)
    {
      AppMethodBeat.i(248970);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof NearbyActionBarUIC.b))
      {
        ((NearbyActionBarUIC.b)paramf).setTextColor(2131100245);
        ((NearbyActionBarUIC.b)paramf).setTextBold(false);
        switch (((NearbyActionBarUIC.b)paramf).dLS)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(248970);
        return;
        NearbyActionBarUIC.dlg();
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void k(TabLayout.f paramf)
    {
      AppMethodBeat.i(248969);
      p.h(paramf, "t");
      AppMethodBeat.o(248969);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(NearbyActionBarUIC paramNearbyActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248972);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.uPY.getActivity().onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248972);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class e
    implements HardTouchableLayout.g
  {
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(248974);
      p.h(paramView, "view");
      Log.i("NearbyActionBarUIC", "onDoubleClick ...");
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(248974);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(NearbyActionBarUIC.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(248973);
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = ((NearbyHomeUIC)com.tencent.mm.ui.component.a.b(this.uPZ.uPY.getActivity()).get(NearbyHomeUIC.class)).dlj();
        if (localObject != null)
        {
          ((AbsNearByFragment)localObject).dll();
          AppMethodBeat.o(248973);
          return;
        }
        AppMethodBeat.o(248973);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class f
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(248976);
      p.h(paramView, "view");
      p.h(paramMotionEvent, "e");
      Log.i("NearbyActionBarUIC", "onDoubleClick ...");
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(248976);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(NearbyActionBarUIC.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(248975);
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = ((NearbyHomeUIC)com.tencent.mm.ui.component.a.b(this.uQa.uPY.getActivity()).get(NearbyHomeUIC.class)).dlj();
        if (localObject != null)
        {
          ((AbsNearByFragment)localObject).dlm();
          AppMethodBeat.o(248975);
          return;
        }
        AppMethodBeat.o(248975);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(NearbyActionBarUIC paramNearbyActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248978);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("NearbyActionBarUIC", "onMenuClick ...");
      paramView = y.vXH;
      if (y.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248978);
        return;
      }
      com.tencent.f.h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248977);
          Object localObject = com.tencent.mm.ui.component.a.PRN;
          localObject = ((NearbyHomeUIC)com.tencent.mm.ui.component.a.b(this.uQb.uPY.getActivity()).get(NearbyHomeUIC.class)).dlj();
          if (localObject != null)
          {
            ((AbsNearByFragment)localObject).dlk();
            AppMethodBeat.o(248977);
            return;
          }
          AppMethodBeat.o(248977);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248978);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class h<T>
    implements Observer<h.a>
  {
    h(NearbyActionBarUIC paramNearbyActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class i<T>
    implements Observer<h.a>
  {
    i(NearbyActionBarUIC paramNearbyActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<h.a>
  {
    j(NearbyActionBarUIC paramNearbyActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    public k(NearbyActionBarUIC paramNearbyActionBarUIC, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC
 * JD-Core Version:    0.7.0.1
 */