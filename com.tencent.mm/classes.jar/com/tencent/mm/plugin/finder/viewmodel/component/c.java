package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/DebugVideoLoadInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "debugInfoLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getDebugInfoLayout", "()Landroid/view/View;", "debugInfoLayout$delegate", "Lkotlin/Lazy;", "isShowDebugInfoView", "", "parentView", "getParentView", "parentView$delegate", "testPreLoadView", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "getTestPreLoadView", "()Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "testPreLoadView$delegate", "onAttach", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "headerCount", "", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "tabType", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateTopMargin", "topMargin", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  private final boolean GMr;
  private final j GMs;
  private final j GMt;
  private final j GMu;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338271);
    paramAppCompatActivity = d.FAy;
    this.GMr = ((Boolean)d.eSb().bmg()).booleanValue();
    this.GMs = k.cm((a)new c(this));
    this.GMt = k.cm((a)new a(this));
    this.GMu = k.cm((a)new b(this));
    AppMethodBeat.o(338271);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338280);
    paramFragment = d.FAy;
    this.GMr = ((Boolean)d.eSb().bmg()).booleanValue();
    this.GMs = k.cm((a)new c(this));
    this.GMt = k.cm((a)new a(this));
    this.GMu = k.cm((a)new b(this));
    AppMethodBeat.o(338280);
  }
  
  private final View doW()
  {
    AppMethodBeat.i(338259);
    View localView = (View)this.GMu.getValue();
    AppMethodBeat.o(338259);
    return localView;
  }
  
  private final TestPreloadPreview fmX()
  {
    AppMethodBeat.i(338247);
    TestPreloadPreview localTestPreloadPreview = (TestPreloadPreview)this.GMs.getValue();
    AppMethodBeat.o(338247);
    return localTestPreloadPreview;
  }
  
  private final View fmY()
  {
    AppMethodBeat.i(338254);
    View localView = (View)this.GMt.getValue();
    AppMethodBeat.o(338254);
    return localView;
  }
  
  public final void Vc(int paramInt)
  {
    AppMethodBeat.i(338312);
    Object localObject = fmX();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof FrameLayout.LayoutParams)) {
        break label64;
      }
    }
    label64:
    for (localObject = (FrameLayout.LayoutParams)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
      }
      localObject = fmX();
      if (localObject != null) {
        ((TestPreloadPreview)localObject).requestLayout();
      }
      AppMethodBeat.o(338312);
      return;
      localObject = ((TestPreloadPreview)localObject).getLayoutParams();
      break;
    }
  }
  
  public final void a(DataBuffer<cc> paramDataBuffer, int paramInt1, l paraml, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(338303);
    s.u(paramDataBuffer, "data");
    s.u(paraml, "videoCore");
    if (!this.GMr)
    {
      AppMethodBeat.o(338303);
      return;
    }
    ((ViewGroup)doW()).addView(af.mU((Context)getContext()).inflate(e.f.finder_debug_load_info_layout, null, false));
    TestPreloadPreview localTestPreloadPreview = fmX();
    if (localTestPreloadPreview != null) {
      localTestPreloadPreview.a(paramDataBuffer, paramInt1, paraml, paramc, paramInt2);
    }
    paramDataBuffer = fmY();
    if (paramDataBuffer != null) {
      paramDataBuffer.setVisibility(0);
    }
    Vc(bf.getStatusBarHeight((Context)getContext()));
    AppMethodBeat.o(338303);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338293);
    super.onCreate(paramBundle);
    AppMethodBeat.o(338293);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<View>
  {
    a(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<View>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<TestPreloadPreview>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.c
 * JD-Core Version:    0.7.0.1
 */