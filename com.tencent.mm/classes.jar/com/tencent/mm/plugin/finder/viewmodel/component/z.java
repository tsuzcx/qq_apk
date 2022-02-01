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
import com.tencent.mm.live.core.view.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullSlideGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "hideTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "checkShowGuide", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "shouldShowGuide", "", "plugin-finder_release"})
public final class z
  extends UIComponent
{
  private com.tencent.e.i.d<?> BkJ;
  
  public z(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(288430);
    AppMethodBeat.o(288430);
  }
  
  public z(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(288429);
    AppMethodBeat.o(288429);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288427);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    boolean bool = paramBundle.aHp().getBoolean(ar.a.VEg, true);
    paramBundle = g.Xox;
    int i;
    if (((FinderHomeUIC)g.b(getActivity()).i(FinderHomeUIC.class)).ekL() == 1)
    {
      i = 1;
      paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWX().aSr()).intValue() != 1) && (!bool)) {
        break label430;
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTP().aSr()).intValue() != 1) {
        break label430;
      }
      paramBundle = aj.AGc;
      if ((!aj.isAllHomeTabEnableFullScreenEnjoy()) || (i == 0)) {
        break label430;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramBundle = new LinearLayout((Context)getActivity());
        paramBundle.setOrientation(1);
        paramBundle.setGravity(17);
        paramBundle.setBackgroundResource(b.c.hot_tab_BW_0_Alpha_0_3);
        Object localObject1 = new PAGView((Context)getActivity());
        ((PAGView)localObject1).setRepeatCount(0);
        ((PAGView)localObject1).setFile(PAGFile.Load(getContext().getAssets(), "finder_full_slide_guide.pag"));
        i = c.dip2px((Context)getActivity(), 90.0F);
        int j = c.dip2px((Context)getActivity(), 96.0F);
        Object localObject2 = (View)localObject1;
        Object localObject3 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject3).gravity = 17;
        paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject2 = new TextView((Context)getActivity());
        ((TextView)localObject2).setText((CharSequence)getActivity().getResources().getString(b.j.finder_left_slide_guide_tips));
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(1, 20.0F);
        com.tencent.mm.plugin.finder.utils.f.i((TextView)localObject2);
        localObject2 = (View)localObject2;
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = ((int)getActivity().getResources().getDimension(b.d.Edge_2A));
        ((LinearLayout.LayoutParams)localObject3).gravity = 17;
        paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((PAGView)localObject1).play();
        localObject1 = getActivity().getWindow();
        p.j(localObject1, "activity.window");
        localObject1 = ((Window)localObject1).getDecorView();
        if (localObject1 == null)
        {
          paramBundle = new t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(288427);
          throw paramBundle;
          i = 0;
          break;
          label430:
          i = 0;
          continue;
        }
        localObject1 = (FrameLayout)localObject1;
        localObject2 = (View)paramBundle;
        localObject3 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramBundle.setClickable(false);
        localObject1 = g.Xox;
        ((FinderHomeUIC)g.b(getActivity()).i(FinderHomeUIC.class)).Bls.add(new a(paramBundle));
        this.BkJ = com.tencent.e.h.ZvG.n((Runnable)new z.b(paramBundle), 3000L);
        paramBundle = com.tencent.mm.kernel.h.aHG();
        p.j(paramBundle, "MMKernel.storage()");
        paramBundle.aHp().set(ar.a.VEg, Boolean.FALSE);
      }
    }
    AppMethodBeat.o(288427);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288428);
    super.onDestroy();
    com.tencent.e.i.d locald = this.BkJ;
    if (locald != null)
    {
      locald.cancel(true);
      AppMethodBeat.o(288428);
      return;
    }
    AppMethodBeat.o(288428);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFullSlideGuideUIC$checkShowGuide$4", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.view.i
  {
    a(LinearLayout paramLinearLayout) {}
    
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(287728);
      this.BkK.setVisibility(8);
      AppMethodBeat.o(287728);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(287727);
      p.k(paramFinderHomeTabFragment, "fragment");
      AppMethodBeat.o(287727);
    }
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.z
 * JD-Core Version:    0.7.0.1
 */