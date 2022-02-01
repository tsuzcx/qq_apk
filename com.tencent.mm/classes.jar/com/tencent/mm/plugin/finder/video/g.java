package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.f;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "videoWidth", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJZZIIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;II)V", "TAG", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "plugin-finder_release"})
public final class g
  extends f
{
  private final String TAG;
  
  public g(String paramString1, String paramString2, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, b<? super Float, y> paramb, b<? super String, y> paramb1, int paramInt8, int paramInt9)
  {
    super(null, paramString1, 1, paramString2, paramRect, paramInt8, paramInt9, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong1, paramLong2, false, false, 0, 0, false, paramb, paramb1);
    AppMethodBeat.i(168170);
    this.TAG = "Finder.FinderVideoRemuxer";
    AppMethodBeat.o(168170);
  }
  
  public final c akf()
  {
    AppMethodBeat.i(168169);
    if (this.gtM) {}
    for (Object localObject = new l(this.gsY, this.gsZ, this.gtF, this.gtG, 3);; localObject = new l(this.gsY, this.gsZ, this.gtF, this.gtG))
    {
      Rect localRect = this.gtE;
      if (localRect == null) {
        k.fvU();
      }
      ((l)localObject).j(localRect);
      int i = this.videoWidth;
      int j = this.videoHeight;
      ((l)localObject).videoWidth = i;
      ((l)localObject).videoHeight = j;
      ad.i(this.TAG, "videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", cropRect:" + this.gtE);
      localObject = (c)localObject;
      AppMethodBeat.o(168169);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.g
 * JD-Core Version:    0.7.0.1
 */