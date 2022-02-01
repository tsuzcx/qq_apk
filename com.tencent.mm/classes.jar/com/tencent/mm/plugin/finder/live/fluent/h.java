package com.tencent.mm.plugin.finder.live.fluent;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "", "fluentScene", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "feedId", "", "parentView", "Landroid/view/View;", "videoWidth", "", "videoHeight", "videoRatioWH", "", "livePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;JLandroid/view/View;IIFLcom/tencent/mm/live/core/core/player/ILivePlayer;)V", "getFeedId", "()J", "getFluentScene", "()Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "setFluentScene", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;)V", "getLivePlayer", "()Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setLivePlayer", "(Lcom/tencent/mm/live/core/core/player/ILivePlayer;)V", "getParentView", "()Landroid/view/View;", "targetRect", "Landroid/graphics/Rect;", "getTargetRect", "()Landroid/graphics/Rect;", "setTargetRect", "(Landroid/graphics/Rect;)V", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "getVideoRatioWH", "()F", "setVideoRatioWH", "(F)V", "getVideoWidth", "setVideoWidth", "isLiveValid", "", "FluentScene", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
{
  public a CCA;
  public b CCB;
  public Rect CCC;
  final long feedId;
  public float hKI;
  public final View uJh;
  public int videoHeight;
  public int videoWidth;
  
  public h(a parama, long paramLong, View paramView, int paramInt1, int paramInt2, float paramFloat, b paramb)
  {
    AppMethodBeat.i(352101);
    this.CCA = parama;
    this.feedId = paramLong;
    this.uJh = paramView;
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.hKI = paramFloat;
    this.CCB = paramb;
    this.CCC = new Rect();
    AppMethodBeat.o(352101);
  }
  
  public final void w(Rect paramRect)
  {
    AppMethodBeat.i(352108);
    s.u(paramRect, "<set-?>");
    this.CCC = paramRect;
    AppMethodBeat.o(352108);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "", "(Ljava/lang/String;I)V", "FINDER", "LIVE_SQUARE", "LIVE_WINDOW", "UNKNOW", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(352132);
      CCD = new a("FINDER", 0);
      CCE = new a("LIVE_SQUARE", 1);
      CCF = new a("LIVE_WINDOW", 2);
      CCG = new a("UNKNOW", 3);
      CCH = new a[] { CCD, CCE, CCF, CCG };
      AppMethodBeat.o(352132);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.h
 * JD-Core Version:    0.7.0.1
 */