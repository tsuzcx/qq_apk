package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.StickTopLoadingLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWifiHintUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragments", "", "Landroidx/fragment/app/Fragment;", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "hideHintRunnable", "Ljava/lang/Runnable;", "hintTv", "Landroid/widget/TextView;", "getHintTv", "()Landroid/widget/TextView;", "hintTv$delegate", "Lkotlin/Lazy;", "onSimChange", "Lcom/tencent/mm/plugin/misc/api/ISimcardService$ISIMCardListener;", "checkShowNotWifiHint", "", "checkTimesLimit", "", "checkShowNotWifiHintAsync", "hideHint", "isFreeSimCard", "isUnicomNetwork", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setLoadingOffsetExtra", "isShow", "showHint", "durationMs", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
  extends UIComponent
{
  public static final bf.a GWj;
  private final j GWk;
  List<? extends Fragment> fragments;
  private final a.a ozF;
  private final Runnable ykR;
  
  static
  {
    AppMethodBeat.i(338393);
    GWj = new bf.a((byte)0);
    AppMethodBeat.o(338393);
  }
  
  public bf(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338321);
    this.GWk = k.cm((kotlin.g.a.a)new bf.c(paramAppCompatActivity));
    this.ykR = new bf..ExternalSyntheticLambda1(this);
    this.ozF = new bf..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(338321);
  }
  
  private static final void a(bf parambf)
  {
    AppMethodBeat.i(338349);
    s.u(parambf, "this$0");
    parambf.fpw();
    AppMethodBeat.o(338349);
  }
  
  private static final void a(bf parambf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(338359);
    s.u(parambf, "this$0");
    e.launch$default((e)parambf, null, null, (m)new bf.d(paramInt2, paramInt1, null), 3, null);
    AppMethodBeat.o(338359);
  }
  
  private final TextView fpv()
  {
    AppMethodBeat.i(338327);
    Object localObject = this.GWk.getValue();
    s.s(localObject, "<get-hintTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(338327);
    return localObject;
  }
  
  private final void vr(boolean paramBoolean)
  {
    float f3 = 0.0F;
    AppMethodBeat.i(338342);
    float f1;
    float f4;
    float f2;
    label85:
    Object localObject1;
    if (paramBoolean)
    {
      f1 = getActivity().getResources().getDimension(e.c.Edge_2A);
      f4 = getActivity().getResources().getDimension(e.c.Edge_2_5_A);
      float f5 = fpv().getMeasuredHeight();
      if (!paramBoolean) {
        break label272;
      }
      if ((f5 <= 0.0F) || (f5 <= f4)) {
        break label258;
      }
      f3 = f5;
      f2 = f1 + (f5 - f4);
      f1 = f3;
      Log.i("FinderWifiHintUIC", "[setLoadingOffsetExtra] isShow:" + paramBoolean + " hintHeight:" + f1 + " minHintHeight:" + f4 + " measuredHeight:" + f5);
      localObject1 = this.fragments;
      if (localObject1 == null) {
        break label300;
      }
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label300;
      }
      Object localObject2 = ((Fragment)((Iterator)localObject1).next()).getView();
      if (localObject2 != null)
      {
        localObject2 = (RefreshLoadMoreLayout)((View)localObject2).findViewById(e.e.rl_layout);
        if (localObject2 != null)
        {
          localObject2 = ((RefreshLoadMoreLayout)localObject2).getStickTopLoadingLayout();
          if (localObject2 != null)
          {
            ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).agJI = f2;
            ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).agJJ = f1;
            if (((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).agJF.getVisibility() == 0)
            {
              ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).setTranslationY(((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).getTranslationY() + f2);
              continue;
              f1 = 0.0F;
              break;
              label258:
              f2 = f4;
              f3 = f1;
              f1 = f2;
              f2 = f3;
              break label85;
              label272:
              f2 = f1;
              f1 = f3;
              break label85;
            }
            ((RefreshLoadMoreLayout.StickTopLoadingLayout)localObject2).agJH.invoke(Float.valueOf(f2 + f1));
          }
        }
      }
    }
    label300:
    AppMethodBeat.o(338342);
  }
  
  public final void fpw()
  {
    AppMethodBeat.i(338426);
    fpv().setVisibility(8);
    vr(false);
    Log.i("FinderWifiHintUIC", "[hideHint]");
    AppMethodBeat.o(338426);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338414);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.misc.a.a)h.ax(com.tencent.mm.plugin.misc.a.a.class)).a(8, this.ozF);
    Log.d("FinderWifiHintUIC", "[onCreate] addListener");
    AppMethodBeat.o(338414);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338421);
    super.onDestroy();
    ((com.tencent.mm.plugin.misc.a.a)h.ax(com.tencent.mm.plugin.misc.a.a.class)).b(8, this.ozF);
    Log.d("FinderWifiHintUIC", "[onDestroy] removeListener");
    AppMethodBeat.o(338421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bf
 * JD-Core Version:    0.7.0.1
 */