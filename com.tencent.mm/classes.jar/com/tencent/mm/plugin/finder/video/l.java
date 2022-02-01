package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.f;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "videoWidth", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJZZIIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;II)V", "TAG", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "plugin-finder_release"})
public final class l
  extends f
{
  private final String TAG;
  
  public l(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong1, long paramLong2, b<? super Float, y> paramb, b<? super String, y> paramb1, int paramInt9, int paramInt10)
  {
    super(paramString1, paramString2, paramInt1, paramString3, paramRect, paramInt9, paramInt10, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong1, paramLong2, false, false, 0, 0, false, paramb, paramb1);
    AppMethodBeat.i(203875);
    this.TAG = "Finder.FinderVideoRemuxer";
    AppMethodBeat.o(203875);
  }
  
  public final c ard()
  {
    AppMethodBeat.i(168169);
    if (this.gUr) {}
    for (Object localObject = new k(this.gTG, this.gTH, this.grA, this.grB, 3);; localObject = new k(this.gTG, this.gTH, this.grA, this.grB))
    {
      Rect localRect = this.gUl;
      if (localRect == null) {
        d.g.b.k.fOy();
      }
      d.g.b.k.h(localRect, "rect");
      ((c)localObject).gVo = localRect;
      int i = this.videoWidth;
      int j = this.videoHeight;
      ((k)localObject).videoWidth = i;
      ((k)localObject).videoHeight = j;
      ac.i(this.TAG, "videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", cropRect:" + this.gUl);
      localObject = (c)localObject;
      AppMethodBeat.o(168169);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.l
 * JD-Core Version:    0.7.0.1
 */