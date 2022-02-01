package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioPreviewWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "bgView", "group", "Landroid/widget/RelativeLayout;", "lastNotTalking", "", "nickname", "Landroid/widget/TextView;", "userLevel", "waveIcon", "Lorg/libpag/PAGView;", "widgetRoot", "Landroid/view/View;", "fillContent", "", "hideLinkMicBottomBar", "notifyMicUserTalikingState", "sdkUserId", "notTalking", "releaseContent", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "plugin-finder_release"})
public final class z
  extends ac
{
  public final String TAG;
  private final ImageView mWb;
  public final PAGView ymH;
  private final TextView zai;
  private final TextView zpA;
  private final ImageView zpB;
  public boolean zpC;
  private final RelativeLayout zpv;
  private final View zpz;
  
  public z(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.d paramd, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramd, paramFinderLiveShadeView);
    AppMethodBeat.i(282779);
    this.TAG = "Finder.FinderLiveMicAudioPreviewWidget";
    this.zpv = new RelativeLayout(paramViewGroup.getContext());
    paramd = View.inflate(paramViewGroup.getContext(), b.g.finder_live_mic_state_audio_ui, null);
    p.j(paramd, "View.inflate(root.contex…mic_state_audio_ui, null)");
    this.zpz = paramd;
    paramd = this.zpz.findViewById(b.f.finder_live_mic_state_audio_avatar);
    p.j(paramd, "widgetRoot.findViewById(…e_mic_state_audio_avatar)");
    this.mWb = ((ImageView)paramd);
    paramd = this.zpz.findViewById(b.f.finder_live_mic_state_audio_name);
    p.j(paramd, "widgetRoot.findViewById(…ive_mic_state_audio_name)");
    this.zai = ((TextView)paramd);
    paramd = this.zpz.findViewById(b.f.finder_live_mic_user_level);
    p.j(paramd, "widgetRoot.findViewById(…nder_live_mic_user_level)");
    this.zpA = ((TextView)paramd);
    paramd = this.zpz.findViewById(b.f.finder_live_mic_state_audio_wave_icon);
    p.j(paramd, "widgetRoot.findViewById(…ic_state_audio_wave_icon)");
    this.ymH = ((PAGView)paramd);
    paramd = this.zpz.findViewById(b.f.finder_live_mic_state_audio_bg);
    p.j(paramd, "widgetRoot.findViewById(…_live_mic_state_audio_bg)");
    this.zpB = ((ImageView)paramd);
    paramd = this.ymH;
    paramViewGroup = paramViewGroup.getContext();
    p.j(paramViewGroup, "root.context");
    paramd.setFile(PAGFile.Load(paramViewGroup.getAssets(), "finder_live_link_mic_wave.pag"));
    this.ymH.setRepeatCount(-1);
    AppMethodBeat.o(282779);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(282777);
    com.tencent.mm.ae.d.uiThread((a)new a(this));
    AppMethodBeat.o(282777);
  }
  
  public final void r(final Rect paramRect)
  {
    AppMethodBeat.i(282776);
    p.k(paramRect, "contentRect");
    com.tencent.mm.ae.d.uiThread((a)new b(this, paramRect));
    AppMethodBeat.o(282776);
  }
  
  public final void s(Rect paramRect)
  {
    AppMethodBeat.i(282778);
    p.k(paramRect, "contentRect");
    if (p.h(this.lastContentRect, paramRect))
    {
      Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + paramRect);
      AppMethodBeat.o(282778);
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
      AppMethodBeat.o(282778);
      return;
    }
    AppMethodBeat.o(282778);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(z paramz)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(z paramz, Rect paramRect)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.z
 * JD-Core Version:    0.7.0.1
 */