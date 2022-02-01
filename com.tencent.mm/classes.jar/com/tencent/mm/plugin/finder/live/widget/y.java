package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "group", "Landroid/widget/RelativeLayout;", "fillContent", "", "hideLinkMicBottomBar", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "releaseContent", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "plugin-finder_release"})
public final class y
  extends ac
{
  private final String TAG;
  private final RelativeLayout zpv;
  
  public y(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.d paramd, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramd, paramFinderLiveShadeView);
    AppMethodBeat.i(272698);
    this.TAG = "Finder.FinderLiveMicAnchorHolderWidget";
    this.zpv = new RelativeLayout(paramViewGroup.getContext());
    AppMethodBeat.o(272698);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(272693);
    p.k(paramo, "menu");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGF()))
    {
      localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
      localObject = ((Context)localObject).getResources().getString(b.j.finder_live_link_mic_gift_item);
      p.j(localObject, "root.context.resources.g…_live_link_mic_gift_item)");
      paramo.d(0, (CharSequence)localObject);
    }
    localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getString(b.j.finder_live_link_mic_finder_item);
    p.j(localObject, "root.context.resources.g…ive_link_mic_finder_item)");
    paramo.d(1, (CharSequence)localObject);
    AppMethodBeat.o(272693);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(272695);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(272695);
  }
  
  public final void r(final Rect paramRect)
  {
    AppMethodBeat.i(272694);
    p.k(paramRect, "contentRect");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramRect));
    AppMethodBeat.o(272694);
  }
  
  public final void s(Rect paramRect)
  {
    AppMethodBeat.i(272697);
    p.k(paramRect, "contentRect");
    if (p.h(this.lastContentRect, paramRect))
    {
      Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + paramRect);
      AppMethodBeat.o(272697);
      return;
    }
    super.s(paramRect);
    this.zpv.setTranslationX(paramRect.left);
    this.zpv.setTranslationY(paramRect.top);
    ViewGroup.LayoutParams localLayoutParams = this.zpv.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramRect.width();
      localLayoutParams.height = paramRect.height();
      this.zpv.requestLayout();
      AppMethodBeat.o(272697);
      return;
    }
    AppMethodBeat.o(272697);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(y paramy)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(y paramy, Rect paramRect)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.y
 * JD-Core Version:    0.7.0.1
 */