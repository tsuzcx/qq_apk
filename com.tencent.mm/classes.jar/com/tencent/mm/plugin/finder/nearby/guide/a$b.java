package com.tencent.mm.plugin.finder.nearby.guide;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper$attachFloatView$2", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements TextureView.SurfaceTextureListener
{
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339950);
    s.u(paramSurfaceTexture, "surface");
    Log.i("FinderLiveCardPreViewAnimationHelper", s.X("liveView#onSurfaceTextureAvailable surface:", paramSurfaceTexture));
    AppMethodBeat.o(339950);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(339963);
    s.u(paramSurfaceTexture, "surface");
    Log.i("FinderLiveCardPreViewAnimationHelper", s.X("liveView#onSurfaceTextureDestroyed surface:", paramSurfaceTexture));
    AppMethodBeat.o(339963);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339955);
    s.u(paramSurfaceTexture, "surface");
    Log.i("FinderLiveCardPreViewAnimationHelper", "liveView#onSurfaceTextureSizeChanged");
    AppMethodBeat.o(339955);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(339968);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(339968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.guide.a.b
 * JD-Core Version:    0.7.0.1
 */