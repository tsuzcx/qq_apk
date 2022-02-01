package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.f;
import com.tencent.mm.media.j.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "videoWidth", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;II)V", "TAG", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "plugin-finder_release"})
public final class n
  extends f
{
  private final String TAG;
  
  public n(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, b<? super Float, x> paramb, b<? super String, x> paramb1, int paramInt10, int paramInt11)
  {
    super(paramString1, paramString2, paramInt1, paramString3, paramRect, paramInt10, paramInt11, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong1, paramLong2, paramBoolean1, paramBoolean2, 0, 0, false, paramInt9, paramb, paramb1);
    AppMethodBeat.i(254335);
    this.TAG = "Finder.FinderVideoRemuxer";
    AppMethodBeat.o(254335);
  }
  
  public final c aMH()
  {
    AppMethodBeat.i(168169);
    if (this.iiC) {}
    for (Object localObject = new m(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, 2);; localObject = new m(this.ihQ, this.ihR, this.outputWidth, this.outputHeight))
    {
      Rect localRect = this.iiw;
      if (localRect == null) {
        p.hyc();
      }
      p.h(localRect, "rect");
      ((c)localObject).ijA = localRect;
      int i = this.videoWidth;
      int j = this.videoHeight;
      ((m)localObject).videoWidth = i;
      ((m)localObject).videoHeight = j;
      Log.i(((m)localObject).TAG, "setVideoSize: " + i + ", " + j);
      Log.i(this.TAG, "videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", cropRect:" + this.iiw);
      localObject = (c)localObject;
      AppMethodBeat.o(168169);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.n
 * JD-Core Version:    0.7.0.1
 */