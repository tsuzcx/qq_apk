package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicAudioPreviewWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "bgView", "group", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveInterceptTouchRelativeLayout;", "lastNotTalking", "", "nickname", "Landroid/widget/TextView;", "userLevel", "waveIcon", "Lorg/libpag/PAGView;", "widgetRoot", "Landroid/view/View;", "fillContent", "", "hideLinkMicBottomBar", "notifyMicUserTalikingState", "sdkUserId", "notTalking", "releaseContent", "requestDisallowInterceptTouchEvent", "disallow", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends as
{
  private final PAGView CVz;
  private final TextView DTO;
  private final FinderLiveInterceptTouchRelativeLayout Esc;
  private final View Esf;
  private final TextView Esg;
  private final ImageView Esh;
  private boolean Esi;
  private final String TAG;
  private final ImageView avatar;
  
  public ao(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, paramFinderLiveShadeView);
    AppMethodBeat.i(361519);
    this.TAG = "Finder.FinderLiveMicAudioPreviewWidget";
    paramb = paramViewGroup.getContext();
    s.s(paramb, "root.context");
    this.Esc = new FinderLiveInterceptTouchRelativeLayout(paramb);
    paramb = View.inflate(paramViewGroup.getContext(), p.f.CeG, null);
    s.s(paramb, "inflate(root.context, R.…mic_state_audio_ui, null)");
    this.Esf = paramb;
    paramb = this.Esf.findViewById(p.e.BOz);
    s.s(paramb, "widgetRoot.findViewById(…e_mic_state_audio_avatar)");
    this.avatar = ((ImageView)paramb);
    paramb = this.Esf.findViewById(p.e.BOF);
    s.s(paramb, "widgetRoot.findViewById(…ive_mic_state_audio_name)");
    this.DTO = ((TextView)paramb);
    paramb = this.Esf.findViewById(p.e.BOH);
    s.s(paramb, "widgetRoot.findViewById(…nder_live_mic_user_level)");
    this.Esg = ((TextView)paramb);
    paramb = this.Esf.findViewById(p.e.BOG);
    s.s(paramb, "widgetRoot.findViewById(…ic_state_audio_wave_icon)");
    this.CVz = ((PAGView)paramb);
    paramb = this.Esf.findViewById(p.e.BOA);
    s.s(paramb, "widgetRoot.findViewById(…_live_mic_state_audio_bg)");
    this.Esh = ((ImageView)paramb);
    this.CVz.setFile(PAGFile.Load(paramViewGroup.getContext().getAssets(), "finder_live_link_mic_wave.pag"));
    this.CVz.setRepeatCount(-1);
    AppMethodBeat.o(361519);
  }
  
  public final void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(361589);
    if (this.Esi != paramBoolean)
    {
      Log.i(this.TAG, "sdkUserId:" + paramString + " notTalking:" + paramBoolean);
      this.Esi = paramBoolean;
      if (paramBoolean)
      {
        this.CVz.stop();
        this.CVz.setVisibility(8);
        AppMethodBeat.o(361589);
        return;
      }
      this.CVz.setVisibility(0);
      this.CVz.play();
    }
    AppMethodBeat.o(361589);
  }
  
  public final void erb()
  {
    AppMethodBeat.i(361604);
    d.uiThread((a)new b(this));
    AppMethodBeat.o(361604);
  }
  
  public final void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(361625);
    this.Esc.setInterceptTouch(paramBoolean);
    AppMethodBeat.o(361625);
  }
  
  public final void x(final Rect paramRect)
  {
    AppMethodBeat.i(361595);
    s.u(paramRect, "contentRect");
    d.uiThread((a)new c(this, paramRect));
    AppMethodBeat.o(361595);
  }
  
  public final void y(Rect paramRect)
  {
    AppMethodBeat.i(361616);
    s.u(paramRect, "contentRect");
    if (s.p(this.Esz, paramRect))
    {
      Log.i(this.TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.Esz + " contentRect:" + paramRect);
      AppMethodBeat.o(361616);
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
    AppMethodBeat.o(361616);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    a(ao paramao)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(ao paramao)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(ao paramao, Rect paramRect)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ao
 * JD-Core Version:    0.7.0.1
 */