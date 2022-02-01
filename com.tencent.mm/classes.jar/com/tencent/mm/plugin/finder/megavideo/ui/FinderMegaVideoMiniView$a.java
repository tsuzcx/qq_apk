package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.res.Resources;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$Companion;", "", "()V", "DEFAULT_MIN_HEIGHT", "", "DEFAULT_MIN_WIDTH", "TAG", "", "USE_CURRENT_TP_VIEW", "", "getShapeSize", "Landroid/util/Size;", "resource", "Landroid/content/res/Resources;", "type", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$ShapeType;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMegaVideoMiniView$a
{
  public static Size a(Resources paramResources, FinderMegaVideoMiniView.c paramc)
  {
    AppMethodBeat.i(342013);
    s.u(paramResources, "resource");
    s.u(paramc, "type");
    switch (FinderMegaVideoMiniView.a.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      paramResources = new Size(paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_portrait_width), paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_portrait_height));
      AppMethodBeat.o(342013);
      return paramResources;
    case 1: 
      paramResources = new Size(paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_landscape_width), paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_landscape_height));
      AppMethodBeat.o(342013);
      return paramResources;
    case 2: 
      paramResources = new Size(paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_square_size), paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_square_size));
      AppMethodBeat.o(342013);
      return paramResources;
    }
    paramResources = new Size(paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_music_width), paramResources.getDimensionPixelOffset(e.c.finder_video_float_ball_music_height));
    AppMethodBeat.o(342013);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.a
 * JD-Core Version:    0.7.0.1
 */