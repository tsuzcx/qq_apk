package com.tencent.mm.plugin.finder.live.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicBottomStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "bottomGroup", "Landroid/view/View;", "group", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveInterceptTouchRelativeLayout;", "hungupBtn", "muteBtn", "muteIconBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "widgetRoot", "fillContent", "", "hideLinkMicBottomBar", "refreshMuteState", "showToast", "", "releaseContent", "requestDisallowInterceptTouchEvent", "disallow", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends aq
{
  private final FinderLiveInterceptTouchRelativeLayout Esc;
  private final View Esf;
  private final View Esk;
  private final View Esl;
  private final View Esm;
  private final WeImageView Esn;
  private final String TAG;
  
  public ap(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, paramFinderLiveShadeView);
    AppMethodBeat.i(361490);
    this.TAG = "Finder.FinderLiveMicAudioStateWidget";
    paramFinderLiveShadeView = paramViewGroup.getContext();
    s.s(paramFinderLiveShadeView, "root.context");
    this.Esc = new FinderLiveInterceptTouchRelativeLayout(paramFinderLiveShadeView);
    paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.CeD, null);
    s.s(paramViewGroup, "inflate(root.context, R.…ic_audio_bottom_ui, null)");
    this.Esf = paramViewGroup;
    paramViewGroup = this.Esf.findViewById(p.e.BOC);
    s.s(paramViewGroup, "widgetRoot.findViewById(…state_audio_hungup_group)");
    this.Esk = paramViewGroup;
    paramViewGroup = this.Esf.findViewById(p.e.BOB);
    s.s(paramViewGroup, "widgetRoot.findViewById(…state_audio_bottom_group)");
    this.Esl = paramViewGroup;
    paramViewGroup = this.Esf.findViewById(p.e.BOD);
    s.s(paramViewGroup, "widgetRoot.findViewById(…c_state_audio_mute_group)");
    this.Esm = paramViewGroup;
    paramViewGroup = this.Esf.findViewById(p.e.BOE);
    s.s(paramViewGroup, "widgetRoot.findViewById(…ic_state_audio_mute_icon)");
    this.Esn = ((WeImageView)paramViewGroup);
    this.Esk.setOnClickListener(new ap..ExternalSyntheticLambda1(this, paramb));
    this.Esm.setOnClickListener(new ap..ExternalSyntheticLambda0(paramb, this));
    AppMethodBeat.o(361490);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.plugin.b paramb, ap paramap, View paramView)
  {
    AppMethodBeat.i(361514);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramap);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$basePlugin");
    s.u(paramap, "this$0");
    paramView = (e)paramb.business(e.class);
    if (!((e)paramb.business(e.class)).Eem) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.Eem = bool;
      paramView = new Bundle();
      paramView.putBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", ((e)paramb.business(e.class)).Eem);
      paramb.CTj.statusChange(b.c.neV, paramView);
      ((aq)paramap).sD(false);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361514);
      return;
    }
  }
  
  private static final void a(ap paramap, final com.tencent.mm.plugin.finder.live.plugin.b paramb, View paramView)
  {
    AppMethodBeat.i(361503);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramap);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramap, "this$0");
    s.u(paramb, "$basePlugin");
    paramap.ar((kotlin.g.a.b)new a(paramap, paramb));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361503);
  }
  
  public final void erb()
  {
    AppMethodBeat.i(361610);
    d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(361610);
  }
  
  public final void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(361629);
    this.Esc.setInterceptTouch(paramBoolean);
    AppMethodBeat.o(361629);
  }
  
  public final void sD(final boolean paramBoolean)
  {
    AppMethodBeat.i(361592);
    d.uiThread((kotlin.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(361592);
  }
  
  public final void x(final Rect paramRect)
  {
    AppMethodBeat.i(361599);
    s.u(paramRect, "contentRect");
    d.uiThread((kotlin.g.a.a)new d(this, paramRect));
    AppMethodBeat.o(361599);
  }
  
  public final void y(Rect paramRect)
  {
    AppMethodBeat.i(361621);
    s.u(paramRect, "contentRect");
    if (s.p(this.Esz, paramRect))
    {
      Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.Esz + " contentRect:" + paramRect);
      AppMethodBeat.o(361621);
      return;
    }
    super.y(paramRect);
    Log.i(this.TAG, s.X("updateLinkMicBottomBar contentRect:", paramRect));
    this.Esc.setTranslationX(paramRect.left);
    this.Esc.setTranslationY(paramRect.top);
    ViewGroup.LayoutParams localLayoutParams = this.Esc.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramRect.width();
      localLayoutParams.height = paramRect.height();
      this.Esc.requestLayout();
    }
    AppMethodBeat.o(361621);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    a(ap paramap, com.tencent.mm.plugin.finder.live.plugin.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(ap paramap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ap paramap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ap paramap, Rect paramRect)
    {
      super();
    }
    
    private static final void a(ap paramap, View paramView)
    {
      AppMethodBeat.i(361926);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramap);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramap, "this$0");
      localObject = ((e)paramap.CwG.business(e.class)).eyF();
      paramView = paramap.Esy;
      if (paramView == null)
      {
        paramView = null;
        if (!Util.isEqual((String)localObject, paramView)) {
          break label129;
        }
        Log.i(ap.c(paramap), "click rect area but is myself, skipped");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(361926);
        return;
        paramView = paramView.mXL;
        break;
        label129:
        paramap.eBh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ap
 * JD-Core Version:    0.7.0.1
 */