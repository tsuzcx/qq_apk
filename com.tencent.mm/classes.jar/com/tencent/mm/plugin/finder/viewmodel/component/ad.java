package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.core.view.c;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullSlideGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "hideTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "checkShowGuide", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "shouldShowGuide", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends UIComponent
{
  private com.tencent.threadpool.i.d<?> GQB;
  
  public ad(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338782);
    AppMethodBeat.o(338782);
  }
  
  public ad(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338779);
    AppMethodBeat.o(338779);
  }
  
  private static final void d(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(338787);
    s.u(paramLinearLayout, "$container");
    paramLinearLayout.setVisibility(8);
    AppMethodBeat.o(338787);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338817);
    super.onCreate(paramBundle);
    boolean bool1 = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adht, true);
    paramBundle = k.aeZF;
    if (((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).fnX() == 1)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acZE, false);
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eVJ().bmg()).intValue() != 1) && (!bool1)) {
        break label560;
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eSh().bmg()).intValue() != 1) || (i == 0) || (!bool2)) {
        break label560;
      }
    }
    label560:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBundle = new LinearLayout((Context)getActivity());
        paramBundle.setOrientation(1);
        paramBundle.setGravity(17);
        paramBundle.setBackgroundResource(e.b.hot_tab_BW_0_Alpha_0_3);
        Object localObject1 = k.aeZF;
        ((ah)k.d(getActivity()).q(ah.class)).GRZ = false;
        localObject1 = new PAGView((Context)getActivity());
        ((PAGView)localObject1).setRepeatCount(0);
        ((PAGView)localObject1).setFile(PAGFile.Load(getContext().getAssets(), "finder_full_slide_guide.pag"));
        i = c.dip2px((Context)getActivity(), 90.0F);
        int j = c.dip2px((Context)getActivity(), 96.0F);
        Object localObject2 = (View)localObject1;
        Object localObject3 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject3).gravity = 17;
        kotlin.ah localah = kotlin.ah.aiuX;
        paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject2 = new TextView((Context)getActivity());
        ((TextView)localObject2).setText((CharSequence)getActivity().getResources().getString(e.h.finder_left_slide_guide_tips));
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(1, 20.0F);
        com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject2);
        localObject2 = (View)localObject2;
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = ((int)getActivity().getResources().getDimension(e.c.Edge_2A));
        ((LinearLayout.LayoutParams)localObject3).gravity = 17;
        localah = kotlin.ah.aiuX;
        paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((PAGView)localObject1).play();
        localObject1 = (FrameLayout)getActivity().getWindow().getDecorView();
        localObject2 = (View)paramBundle;
        localObject3 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        localah = kotlin.ah.aiuX;
        ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramBundle.setClickable(false);
        localObject1 = k.aeZF;
        ((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).GRB.add(new a(paramBundle));
        this.GQB = com.tencent.threadpool.h.ahAA.o(new ad..ExternalSyntheticLambda0(paramBundle), 3000L);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adht, Boolean.FALSE);
      }
      AppMethodBeat.o(338817);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338824);
    super.onDestroy();
    com.tencent.threadpool.i.d locald = this.GQB;
    if (locald != null) {
      locald.cancel(true);
    }
    AppMethodBeat.o(338824);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFullSlideGuideUIC$checkShowGuide$4", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.finder.view.h
  {
    a(LinearLayout paramLinearLayout) {}
    
    public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(338546);
      this.GQC.setVisibility(8);
      AppMethodBeat.o(338546);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(338532);
      s.u(paramFinderHomeTabFragment, "fragment");
      AppMethodBeat.o(338532);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(338552);
      s.u(this, "this");
      AppMethodBeat.o(338552);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ad
 * JD-Core Version:    0.7.0.1
 */