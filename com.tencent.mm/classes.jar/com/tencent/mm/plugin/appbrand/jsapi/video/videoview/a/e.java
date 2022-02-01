package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

public class e
  extends BaseVideoView
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public a eS(Context paramContext)
  {
    AppMethodBeat.i(328904);
    this.sJh = 1;
    paramContext = new d(paramContext);
    AppMethodBeat.o(328904);
    return paramContext;
  }
  
  public TextureView getVideoTexture()
  {
    return (TextureView)this.sJc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e
 * JD-Core Version:    0.7.0.1
 */