package com.tencent.mm.plugin.game.media.background;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;

public class GameFakeVideoView
  extends VideoPlayerTextureView
{
  public GameFakeVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameFakeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GameFakeVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(41208);
    super.o(paramSurfaceTexture);
    if (this.yki != null) {
      this.yki.gw(getCurrentPosition(), getDuration());
    }
    AppMethodBeat.o(41208);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(41209);
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(41209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoView
 * JD-Core Version:    0.7.0.1
 */