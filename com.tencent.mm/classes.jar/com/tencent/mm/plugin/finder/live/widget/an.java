package com.tencent.mm.plugin.finder.live.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "group", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveInterceptTouchRelativeLayout;", "fillContent", "", "hideLinkMicBottomBar", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "releaseContent", "requestDisallowInterceptTouchEvent", "disallow", "", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends as
{
  private final FinderLiveInterceptTouchRelativeLayout Esc;
  private final String TAG;
  
  public an(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, paramFinderLiveShadeView);
    AppMethodBeat.i(361559);
    this.TAG = "Finder.FinderLiveMicAnchorHolderWidget";
    paramViewGroup = paramViewGroup.getContext();
    s.s(paramViewGroup, "root.context");
    this.Esc = new FinderLiveInterceptTouchRelativeLayout(paramViewGroup);
    AppMethodBeat.o(361559);
  }
  
  public final void erb()
  {
    AppMethodBeat.i(361617);
    d.uiThread((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(361617);
  }
  
  public final void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(361639);
    this.Esc.setInterceptTouch(paramBoolean);
    AppMethodBeat.o(361639);
  }
  
  public final void x(final Rect paramRect)
  {
    AppMethodBeat.i(361609);
    s.u(paramRect, "contentRect");
    d.uiThread((kotlin.g.a.a)new b(this, paramRect));
    AppMethodBeat.o(361609);
  }
  
  public final void y(Rect paramRect)
  {
    AppMethodBeat.i(361628);
    s.u(paramRect, "contentRect");
    if (s.p(this.Esz, paramRect))
    {
      Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.Esz + " contentRect:" + paramRect);
      AppMethodBeat.o(361628);
      return;
    }
    super.y(paramRect);
    this.Esc.setTranslationX(paramRect.left);
    this.Esc.setTranslationY(paramRect.top);
    ViewGroup.LayoutParams localLayoutParams = this.Esc.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramRect.width();
      localLayoutParams.height = paramRect.height();
      this.Esc.requestLayout();
    }
    AppMethodBeat.o(361628);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(an paraman)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(an paraman, Rect paramRect)
    {
      super();
    }
    
    private static final void a(an paraman, View paramView)
    {
      FinderContact localFinderContact = null;
      AppMethodBeat.i(362157);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paraman);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paraman, "this$0");
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        Log.i(an.b(paraman), "click rect area but i am anchor, skipped");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAnchorHolderWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(362157);
        return;
      }
      localObject = ((e)paraman.CwG.business(e.class)).eyF();
      paramView = paraman.Esy;
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.mXL)
      {
        if (!Util.isEqual((String)localObject, paramView)) {
          break label157;
        }
        Log.i(an.b(paraman), "click rect area but is myself, skipped");
        break;
      }
      label157:
      paramView = paraman.Esy;
      if (paramView == null)
      {
        paramView = null;
        label168:
        if (paramView != null)
        {
          localObject = ((e)paraman.CwG.business(e.class)).Eco;
          if (localObject != null) {
            break label212;
          }
        }
      }
      for (;;)
      {
        paramView.contact = localFinderContact;
        paraman.eBh();
        break;
        paramView = paramView.EbJ;
        break label168;
        label212:
        localFinderContact = ((FinderObject)localObject).contact;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.an
 * JD-Core Version:    0.7.0.1
 */