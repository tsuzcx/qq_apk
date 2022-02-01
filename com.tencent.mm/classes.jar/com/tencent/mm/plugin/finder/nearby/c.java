package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.n;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isCurrentResume", "", "squareTabFetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher;", "buildTab", "", "checkAddFootPrintRedDot", "fetchTabsInfo", "getNearbyTab", "Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "index", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "registerRedDot", "setMenuType", "menuType", "setNearbyLiveTabTitle", "title", "", "setNearbyVideoTabTitle", "setTabIndex", "findByTag", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lcom/google/android/material/tabs/TabLayout;", "any", "", "Companion", "NearbyTab", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public static final a EFk;
  private com.tencent.mm.plugin.finder.nearby.live.square.tab.a EFl;
  private boolean EFm;
  
  static
  {
    AppMethodBeat.i(339690);
    EFk = new a((byte)0);
    AppMethodBeat.o(339690);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339588);
    AppMethodBeat.o(339588);
  }
  
  private final b Qx(int paramInt)
  {
    AppMethodBeat.i(339618);
    Object localObject = (TabLayout)getActivity().findViewById(f.d.EGE);
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      AppMethodBeat.o(339618);
      return null;
      localObject = ((TabLayout)localObject).js(paramInt);
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((TabLayout.e)localObject).tag;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
          AppMethodBeat.o(339618);
          throw ((Throwable)localObject);
        }
        localObject = (b)localObject;
      }
    }
    AppMethodBeat.o(339618);
    return localObject;
  }
  
  private static TabLayout.e a(TabLayout paramTabLayout, Object paramObject)
  {
    AppMethodBeat.i(339609);
    int i = 0;
    int k = paramTabLayout.getTabCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      TabLayout.e locale = paramTabLayout.js(i);
      Object localObject;
      if (locale == null) {
        localObject = null;
      }
      while ((localObject instanceof b))
      {
        localObject = locale.tag;
        if (localObject == null)
        {
          paramTabLayout = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
          AppMethodBeat.o(339609);
          throw paramTabLayout;
          localObject = locale.tag;
        }
        else
        {
          i = ((b)localObject).hJx;
          if ((paramObject instanceof Integer)) {
            break label113;
          }
        }
      }
      while (j >= k)
      {
        AppMethodBeat.o(339609);
        return null;
        label113:
        if (i == ((Number)paramObject).intValue())
        {
          AppMethodBeat.o(339609);
          return locale;
        }
      }
      i = j;
    }
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(339631);
    kotlin.g.b.s.u(paramc, "this$0");
    k localk = k.aeZF;
    paramc = ((e)k.d(paramc.getActivity()).q(e.class)).eEg();
    if (paramc != null) {
      paramc.eEp();
    }
    AppMethodBeat.o(339631);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(339625);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.getActivity().onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(339625);
  }
  
  private static final void a(c paramc, TabLayout paramTabLayout, l.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(339649);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.s(paramTabLayout, "tabLayout");
    paramc = a(paramTabLayout, Integer.valueOf(1002));
    if (paramc != null)
    {
      paramTabLayout = paramc.tag;
      if (paramTabLayout != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("[registerRedDot] TAB_NEARBY_TYPE_VIDEO isShow=");
        if (parama == null)
        {
          paramc = null;
          localStringBuilder = localStringBuilder.append(paramc).append(" show_type=");
          if (parama != null) {
            break label153;
          }
          paramc = localObject;
          label85:
          Log.i("NearbyActionBarUIC", paramc);
          if ((parama == null) || (parama.hBY != true)) {
            break label179;
          }
        }
        label153:
        label179:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label184;
          }
          paramc = ((b)paramTabLayout).EFo;
          if (paramc == null) {
            break label201;
          }
          paramc.setVisibility(0);
          AppMethodBeat.o(339649);
          return;
          paramc = Boolean.valueOf(parama.hBY);
          break;
          bxq localbxq = parama.ASg;
          paramc = localObject;
          if (localbxq == null) {
            break label85;
          }
          paramc = Integer.valueOf(localbxq.show_type);
          break label85;
        }
        label184:
        paramc = ((b)paramTabLayout).EFo;
        if (paramc != null) {
          paramc.setVisibility(4);
        }
      }
    }
    label201:
    AppMethodBeat.o(339649);
  }
  
  private static final void a(String paramString, c paramc, View paramView)
  {
    AppMethodBeat.i(339670);
    kotlin.g.b.s.u(paramString, "$title");
    kotlin.g.b.s.u(paramc, "this$0");
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Object localObject = paramc.Qx(0);
      if (localObject == null) {}
      int i;
      int j;
      for (localObject = null;; localObject = ((b)localObject).titleTv)
      {
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)paramString);
        }
        if (paramString.length() == 2) {
          break label159;
        }
        i = paramString.length();
        j = com.tencent.mm.live.core.view.c.dip2px((Context)paramc.getActivity(), 15.0F);
        if (paramView.getLayoutParams() == null) {
          break label159;
        }
        paramString = paramView.getLayoutParams();
        if (paramString != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(339670);
        throw paramString;
      }
      paramString = (ConstraintLayout.LayoutParams)paramString;
      paramString.leftMargin -= (i - 2) * j;
      paramView.setLayoutParams((ViewGroup.LayoutParams)paramString);
    }
    label159:
    AppMethodBeat.o(339670);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(339638);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    Log.i("NearbyActionBarUIC", "onMenuClick ...");
    paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(339638);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda5(paramc));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(339638);
  }
  
  private static final void b(c paramc, TabLayout paramTabLayout, l.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(339652);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.s(paramTabLayout, "tabLayout");
    paramc = a(paramTabLayout, Integer.valueOf(1001));
    if (paramc != null)
    {
      paramTabLayout = paramc.tag;
      if (paramTabLayout != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("[registerRedDot] TAB_NEARBY_TYPE_LIVE isShow=");
        if (parama == null)
        {
          paramc = null;
          localStringBuilder = localStringBuilder.append(paramc).append(" show_type=");
          if (parama != null) {
            break label153;
          }
          paramc = localObject;
          label85:
          Log.i("NearbyActionBarUIC", paramc);
          if ((parama == null) || (parama.hBY != true)) {
            break label179;
          }
        }
        label153:
        label179:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label184;
          }
          paramc = ((b)paramTabLayout).EFo;
          if (paramc == null) {
            break label201;
          }
          paramc.setVisibility(0);
          AppMethodBeat.o(339652);
          return;
          paramc = Boolean.valueOf(parama.hBY);
          break;
          bxq localbxq = parama.ASg;
          paramc = localObject;
          if (localbxq == null) {
            break label85;
          }
          paramc = Integer.valueOf(localbxq.show_type);
          break label85;
        }
        label184:
        paramc = ((b)paramTabLayout).EFo;
        if (paramc != null) {
          paramc.setVisibility(4);
        }
      }
    }
    label201:
    AppMethodBeat.o(339652);
  }
  
  private static final void c(c paramc, TabLayout paramTabLayout, l.a parama)
  {
    Object localObject = null;
    int j = 1;
    AppMethodBeat.i(339662);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.s(paramTabLayout, "tabLayout");
    paramc = a(paramTabLayout, Integer.valueOf(1003));
    label88:
    int i;
    if (paramc != null)
    {
      paramTabLayout = paramc.tag;
      if (paramTabLayout != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("[registerRedDot] TAB_NEARBY_TYPE_PERSON isShow=");
        if (parama != null) {
          break label189;
        }
        paramc = null;
        localStringBuilder = localStringBuilder.append(paramc).append(" show_type=");
        if (parama != null) {
          break label200;
        }
        paramc = localObject;
        Log.i("NearbyActionBarUIC", paramc);
        if ((parama == null) || (parama.hBY != true)) {
          break label226;
        }
        i = 1;
        label117:
        if (i == 0) {
          break label270;
        }
        paramc = parama.ASg;
        if ((paramc == null) || (paramc.show_type != 101)) {
          break label231;
        }
        i = j;
        label142:
        if (i == 0) {
          break label236;
        }
        paramc = ((b)paramTabLayout).EFo;
        if (paramc != null) {
          paramc.setVisibility(4);
        }
        paramc = ((b)paramTabLayout).EFn;
        if (paramc != null) {
          label175:
          i = 0;
        }
      }
    }
    for (;;)
    {
      label177:
      paramc.setVisibility(i);
      label182:
      label189:
      label200:
      label226:
      label231:
      label236:
      do
      {
        do
        {
          AppMethodBeat.o(339662);
          return;
          paramc = Boolean.valueOf(parama.hBY);
          break;
          bxq localbxq = parama.ASg;
          paramc = localObject;
          if (localbxq == null) {
            break label88;
          }
          paramc = Integer.valueOf(localbxq.show_type);
          break label88;
          i = 0;
          break label117;
          i = 0;
          break label142;
          paramc = ((b)paramTabLayout).EFo;
          if (paramc != null) {
            paramc.setVisibility(0);
          }
          paramc = ((b)paramTabLayout).EFn;
        } while (paramc == null);
        i = 4;
        break label177;
        if (parama != null)
        {
          paramc = parama.ASg;
          if ((paramc == null) || (paramc.show_type != 101)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label320;
          }
          paramc = ((b)paramTabLayout).EFn;
          if (paramc == null) {
            break label182;
          }
          i = 4;
          break;
        }
        paramc = ((b)paramTabLayout).EFo;
        if (paramc != null) {
          paramc.setVisibility(4);
        }
        paramTabLayout = ((b)paramTabLayout).EFn;
      } while (paramTabLayout == null);
      label270:
      label320:
      paramc = paramTabLayout;
      if (!com.tencent.mm.bp.a.aDN()) {
        break label175;
      }
      i = 4;
      paramc = paramTabLayout;
    }
  }
  
  public static void eEb()
  {
    AppMethodBeat.i(339597);
    if (!com.tencent.mm.bp.a.aDN())
    {
      Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: add footprint red dot");
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQu.eaq();
      AppMethodBeat.o(339597);
      return;
    }
    Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: clear footprint red dot");
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Nv(1014);
    AppMethodBeat.o(339597);
  }
  
  public final void Qw(int paramInt)
  {
    AppMethodBeat.i(339774);
    Object localObject = (TabLayout)getActivity().findViewById(f.d.EGE);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).js(paramInt);
      if ((localObject != null) && (!((TabLayout.e)localObject).isSelected())) {
        ((TabLayout.e)localObject).Xf();
      }
    }
    AppMethodBeat.o(339774);
  }
  
  public final void ayV(String paramString)
  {
    AppMethodBeat.i(339795);
    kotlin.g.b.s.u(paramString, "title");
    Log.i("NearbyActionBarUIC", kotlin.g.b.s.X("setNearbyVideoTabTitle title:", paramString));
    View localView = getActivity().findViewById(f.d.EGD);
    if (localView != null) {
      localView.post(new c..ExternalSyntheticLambda6(paramString, this, localView));
    }
    AppMethodBeat.o(339795);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(339758);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((LinearLayout)getActivity().findViewById(f.d.EFG)).setOnClickListener(new c..ExternalSyntheticLambda1(this));
    ((HardTouchableLayout)getActivity().findViewById(f.d.EGD)).setOnSingleClickListener((HardTouchableLayout.g)new e(this));
    ((HardTouchableLayout)getActivity().findViewById(f.d.EGD)).setOnDoubleClickListener((HardTouchableLayout.b)new f(this));
    ((ConstraintLayout)getActivity().findViewById(f.d.EGn)).setOnClickListener(new c..ExternalSyntheticLambda0(this));
    paramBundle = (TextView)getActivity().findViewById(f.d.nearby_menu_live);
    if (paramBundle != null) {
      paramBundle.setTextSize(1, 15.0F);
    }
    paramBundle = k.aeZF;
    if (((e)k.d(getActivity()).q(e.class)).fragments.size() == 2)
    {
      paramBundle = ((HardTouchableLayout)getActivity().findViewById(f.d.EGD)).getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(339758);
        throw paramBundle;
      }
      ((ConstraintLayout.LayoutParams)paramBundle).leftMargin = 0;
    }
    paramBundle = (TabLayout)getActivity().findViewById(f.d.EGE);
    Object localObject1 = k.aeZF;
    localObject1 = ((Iterable)((e)k.d(getActivity()).q(e.class)).fragments).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (AbsNearByFragment)localObject2;
      Object localObject3 = paramBundle.WW();
      kotlin.g.b.s.s(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.e)localObject3, ((AbsNearByFragment)localObject2).hJx);
      if (!TextUtils.isEmpty((CharSequence)((AbsNearByFragment)localObject2).title)) {
        ((b)localObject3).setTitle(((AbsNearByFragment)localObject2).title);
      }
      for (;;)
      {
        ((b)localObject3).index = i;
        paramBundle.a(((b)localObject3).dyQ, false);
        i += 1;
        break;
        localObject2 = getContext().getString(((AbsNearByFragment)localObject2).EHx);
        kotlin.g.b.s.s(localObject2, "context.getString(fragment.titleId)");
        ((b)localObject3).setTitle((String)localObject2);
      }
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)getActivity().findViewById(f.d.EGE);
    localObject1 = l.ARA;
    d.a((LiveData)l.dZU(), (q)getActivity(), new c..ExternalSyntheticLambda2(this, paramBundle));
    localObject1 = l.ARA;
    d.a((LiveData)l.dZV(), (q)getActivity(), new c..ExternalSyntheticLambda3(this, paramBundle));
    localObject1 = l.ARA;
    d.a((LiveData)l.dZW(), (q)getActivity(), new c..ExternalSyntheticLambda4(this, paramBundle));
    paramBundle = getFragment();
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        break label650;
      }
      paramBundle = k.aeZF;
      paramBundle = ((as)k.d(getActivity()).q(as.class)).fou();
    }
    label650:
    for (;;)
    {
      if (this.EFl == null) {
        this.EFl = new com.tencent.mm.plugin.finder.nearby.live.square.tab.a((Context)getContext());
      }
      localObject1 = this.EFl;
      if (localObject1 != null) {
        com.tencent.mm.plugin.finder.nearby.live.square.tab.a.a((com.tencent.mm.plugin.finder.nearby.live.square.tab.a)localObject1, paramBundle, (kotlin.g.a.s)new d(this));
      }
      AppMethodBeat.o(339758);
      return;
      localObject1 = k.aeZF;
      paramBundle = ((as)k.y(paramBundle).q(as.class)).fou();
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(339767);
    super.onDestroy();
    com.tencent.mm.plugin.finder.nearby.live.square.tab.a locala = this.EFl;
    if (locala != null) {
      locala.detach();
    }
    AppMethodBeat.o(339767);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(339785);
    super.onPause();
    this.EFm = false;
    AppMethodBeat.o(339785);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(339778);
    super.onResume();
    this.EFm = true;
    AppMethodBeat.o(339778);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$Companion;", "", "()V", "MENU_TYPE_LIVE", "", "MENU_TYPE_PERSON", "MENU_TYPE_VIDEO", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "Landroid/widget/TextView;", "getTabRedTv", "()Landroid/widget/TextView;", "setTabRedTv", "(Landroid/widget/TextView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "title", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    WeImageView EFn;
    ImageView EFo;
    TabLayout.e dyQ;
    int hJx;
    int index;
    TextView titleTv;
    
    public b(TabLayout.e parame, int paramInt)
    {
      AppMethodBeat.i(339653);
      this.dyQ = parame;
      this.hJx = paramInt;
      this.dyQ.tag = this;
      parame = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      parame = MMApplicationContext.getContext();
      kotlin.g.b.s.s(parame, "getContext()");
      float f = com.tencent.mm.plugin.finder.accessibility.a.g(parame, 15.0F);
      switch (this.hJx)
      {
      case 1004: 
      case 1005: 
      default: 
        this.dyQ.jw(f.e.finder_home_ui_tab_empty);
      }
      label146:
      label230:
      label376:
      do
      {
        AppMethodBeat.o(339653);
        return;
        this.dyQ.jw(f.e.EGN);
        parame = this.dyQ.dyK;
        if (parame == null)
        {
          parame = null;
          kotlin.g.b.s.checkNotNull(parame);
          this.titleTv = parame;
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label230;
          }
        }
        for (parame = localObject2;; parame = (ImageView)parame.findViewById(f.d.tabRed))
        {
          kotlin.g.b.s.checkNotNull(parame);
          this.EFo = parame;
          parame = this.EFo;
          if (parame != null) {
            parame.setImageResource(f.g.finder_live_icon);
          }
          parame = this.titleTv;
          if (parame == null) {
            break;
          }
          parame.setTextSize(1, f);
          AppMethodBeat.o(339653);
          return;
          parame = (TextView)parame.findViewById(f.d.tabTitle);
          break label146;
        }
        this.dyQ.jw(f.e.EGN);
        parame = this.dyQ.dyK;
        if (parame == null)
        {
          parame = null;
          kotlin.g.b.s.checkNotNull(parame);
          this.titleTv = parame;
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label337;
          }
        }
        for (parame = localObject3;; parame = (ImageView)parame.findViewById(f.d.tabRed))
        {
          kotlin.g.b.s.checkNotNull(parame);
          this.EFo = parame;
          parame = this.titleTv;
          if (parame == null) {
            break;
          }
          parame.setTextSize(1, f);
          AppMethodBeat.o(339653);
          return;
          parame = (TextView)parame.findViewById(f.d.tabTitle);
          break label269;
        }
        this.dyQ.jw(f.e.EGO);
        parame = this.dyQ.dyK;
        if (parame == null)
        {
          parame = null;
          kotlin.g.b.s.checkNotNull(parame);
          this.titleTv = parame;
          parame = this.titleTv;
          if (parame != null) {
            parame.setTextSize(1, f);
          }
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label487;
          }
          parame = null;
          kotlin.g.b.s.checkNotNull(parame);
          this.EFn = parame;
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label501;
          }
        }
        for (parame = localObject1;; parame = (ImageView)parame.findViewById(f.d.tabRed))
        {
          kotlin.g.b.s.checkNotNull(parame);
          this.EFo = parame;
          if (!com.tencent.mm.bp.a.aDN()) {
            break label515;
          }
          parame = this.EFn;
          if (parame == null) {
            break;
          }
          parame.setVisibility(4);
          AppMethodBeat.o(339653);
          return;
          parame = (TextView)parame.findViewById(f.d.tabTitle);
          break label376;
          parame = (WeImageView)parame.findViewById(f.d.tabTitleImage);
          break label414;
        }
        parame = this.EFn;
      } while (parame == null);
      label269:
      label337:
      label487:
      label501:
      parame.setVisibility(0);
      label414:
      AppMethodBeat.o(339653);
      label515:
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(339669);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.ui.aw.a((Paint)localTextView.getPaint(), 0.8F);
          AppMethodBeat.o(339669);
          return;
        }
        localTextView.getPaint().setFakeBoldText(false);
        localTextView.getPaint().setStrokeWidth(0.0F);
      }
      AppMethodBeat.o(339669);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(339663);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        View localView = this.dyQ.dyK;
        kotlin.g.b.s.checkNotNull(localView);
        localTextView.setTextColor(localView.getContext().getResources().getColor(paramInt));
      }
      AppMethodBeat.o(339663);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(339655);
      kotlin.g.b.s.u(paramString, "title");
      TextView localTextView = this.titleTv;
      if (localTextView != null) {
        localTextView.setText((CharSequence)paramString);
      }
      AppMethodBeat.o(339655);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$buildTab$2", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    c(c paramc) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(339666);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      if ((parame instanceof c.b))
      {
        ((c.b)parame).setTextColor(f.a.normal_text_color);
        ((c.b)parame).setTextBold(true);
        k localk = k.aeZF;
        ((e)k.d(this.EFp.getActivity()).q(e.class)).Qz(((c.b)parame).hJx);
        switch (((c.b)parame).hJx)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(339666);
        return;
        c.a(this.EFp, 3);
        c.eEb();
        AppMethodBeat.o(339666);
        return;
        c.a(this.EFp, 2);
        AppMethodBeat.o(339666);
        return;
        c.a(this.EFp, 1);
      }
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(339657);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      if ((parame instanceof c.b))
      {
        ((c.b)parame).setTextColor(f.a.desc_text_color);
        ((c.b)parame).setTextBold(false);
        if (((c.b)parame).hJx == 1003) {
          c.eEb();
        }
      }
      AppMethodBeat.o(339657);
    }
    
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(339654);
      kotlin.g.b.s.u(parame, "t");
      AppMethodBeat.o(339654);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "title", "", "videoTabName", "liveTabName", "tabList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "isHideTabs", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.s<String, String, String, LinkedList<bnn>, Boolean, ah>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements HardTouchableLayout.g
  {
    e(c paramc) {}
    
    private static final void c(c paramc)
    {
      AppMethodBeat.i(339667);
      kotlin.g.b.s.u(paramc, "this$0");
      k localk = k.aeZF;
      paramc = ((e)k.d(paramc.getActivity()).q(e.class)).eEg();
      if (paramc != null) {
        paramc.eEq();
      }
      AppMethodBeat.o(339667);
    }
    
    public final void fu(View paramView)
    {
      AppMethodBeat.i(339678);
      kotlin.g.b.s.u(paramView, "view");
      Log.i("NearbyActionBarUIC", "onDoubleClick ...");
      com.tencent.threadpool.h.ahAA.bk(new c.e..ExternalSyntheticLambda0(this.EFp));
      AppMethodBeat.o(339678);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements HardTouchableLayout.b
  {
    f(c paramc) {}
    
    private static final void d(c paramc)
    {
      AppMethodBeat.i(339633);
      kotlin.g.b.s.u(paramc, "this$0");
      k localk = k.aeZF;
      paramc = ((e)k.d(paramc.getActivity()).q(e.class)).eEg();
      if (paramc != null) {
        paramc.eEr();
      }
      AppMethodBeat.o(339633);
    }
    
    public final void c(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(339648);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramMotionEvent, "e");
      Log.i("NearbyActionBarUIC", "onDoubleClick ...");
      com.tencent.threadpool.h.ahAA.bk(new c.f..ExternalSyntheticLambda0(this.EFp));
      AppMethodBeat.o(339648);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(String paramString, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.c
 * JD-Core Version:    0.7.0.1
 */