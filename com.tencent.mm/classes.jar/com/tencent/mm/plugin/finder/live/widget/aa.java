package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "bottomGroup", "Landroid/view/View;", "group", "Landroid/widget/RelativeLayout;", "hungupBtn", "muteBtn", "muteIconBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "widgetRoot", "fillContent", "", "hideLinkMicBottomBar", "releaseContent", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "plugin-finder_release"})
public final class aa
  extends ac
{
  private final String TAG;
  private final View zpE;
  private final View zpF;
  private final View zpG;
  private final WeImageView zpH;
  private final RelativeLayout zpv;
  private final View zpz;
  
  public aa(final ViewGroup paramViewGroup, final com.tencent.mm.plugin.finder.live.plugin.d paramd, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramd, paramFinderLiveShadeView);
    AppMethodBeat.i(276542);
    this.TAG = "Finder.FinderLiveMicAudioStateWidget";
    this.zpv = new RelativeLayout(paramViewGroup.getContext());
    paramFinderLiveShadeView = View.inflate(paramViewGroup.getContext(), b.g.finder_live_mic_audio_bottom_ui, null);
    p.j(paramFinderLiveShadeView, "View.inflate(root.contex…ic_audio_bottom_ui, null)");
    this.zpz = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_mic_state_audio_hungup_group);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…state_audio_hungup_group)");
    this.zpE = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_mic_state_audio_bottom_group);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…state_audio_bottom_group)");
    this.zpF = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_mic_state_audio_mute_group);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…c_state_audio_mute_group)");
    this.zpG = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_mic_state_audio_mute_icon);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…ic_state_audio_mute_icon)");
    this.zpH = ((WeImageView)paramFinderLiveShadeView);
    this.zpE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277502);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Bundle();
        paramAnonymousView = this.zpI.zpP;
        if (paramAnonymousView != null) {}
        for (paramAnonymousView = paramAnonymousView.sessionId;; paramAnonymousView = null)
        {
          ((Bundle)localObject).putString("PARAM_FINDER_LIVE_MIC_ID", paramAnonymousView);
          paramd.yld.statusChange(com.tencent.mm.live.c.b.c.kBa, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277502);
          return;
        }
      }
    });
    this.zpG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279831);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgs)
        {
          paramAnonymousView = aa.g(this.zpI);
          localObject = paramViewGroup.getContext();
          p.j(localObject, "root.context");
          paramAnonymousView.setIconColor(((Context)localObject).getResources().getColor(com.tencent.mm.plugin.finder.b.c.white_text_color));
          paramAnonymousView = aa.h(this.zpI);
          localObject = paramViewGroup.getContext();
          p.j(localObject, "root.context");
          paramAnonymousView.setBackground(((Context)localObject).getResources().getDrawable(b.e.finder_live_panel_btn_bg));
          paramAnonymousView = paramViewGroup.getContext();
          localObject = paramViewGroup.getContext();
          p.j(localObject, "root.context");
          w.cR(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_anchor_cancel_mute_toast_tip));
          paramAnonymousView = new Bundle();
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgs) {
            break label316;
          }
        }
        label316:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.putBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", bool);
          paramd.yld.statusChange(com.tencent.mm.live.c.b.c.kBu, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279831);
          return;
          aa.g(this.zpI).setIconColor(-16777216);
          paramAnonymousView = aa.h(this.zpI);
          localObject = paramViewGroup.getContext();
          p.j(localObject, "root.context");
          paramAnonymousView.setBackground(((Context)localObject).getResources().getDrawable(b.e.finder_live_panel_btn_white_bg));
          paramAnonymousView = paramViewGroup.getContext();
          localObject = paramViewGroup.getContext();
          p.j(localObject, "root.context");
          w.cR(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_anchor_mute_toast_tip));
          break;
        }
      }
    });
    AppMethodBeat.o(276542);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(276539);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(276539);
  }
  
  public final void r(final Rect paramRect)
  {
    AppMethodBeat.i(276538);
    p.k(paramRect, "contentRect");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramRect));
    AppMethodBeat.o(276538);
  }
  
  public final void s(Rect paramRect)
  {
    AppMethodBeat.i(276540);
    p.k(paramRect, "contentRect");
    if (p.h(this.lastContentRect, paramRect))
    {
      Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + paramRect);
      AppMethodBeat.o(276540);
      return;
    }
    super.s(paramRect);
    Log.i(this.TAG, "updateLinkMicBottomBar contentRect:".concat(String.valueOf(paramRect)));
    this.zpv.setTranslationX(paramRect.left);
    this.zpv.setTranslationY(paramRect.top);
    ViewGroup.LayoutParams localLayoutParams = this.zpv.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramRect.width();
      localLayoutParams.height = paramRect.height();
      this.zpv.requestLayout();
      AppMethodBeat.o(276540);
      return;
    }
    AppMethodBeat.o(276540);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(aa paramaa)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(aa paramaa, Rect paramRect)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aa
 * JD-Core Version:    0.7.0.1
 */