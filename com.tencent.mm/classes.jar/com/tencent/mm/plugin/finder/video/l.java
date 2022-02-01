package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.f;
import com.tencent.mm.media.j.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "videoWidth", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;II)V", "TAG", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "plugin-finder_release"})
public final class l
  extends f
{
  private final String TAG;
  
  public l(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong1, long paramLong2, int paramInt9, b<? super Float, z> paramb, b<? super String, z> paramb1, int paramInt10, int paramInt11)
  {
    super(paramString1, paramString2, paramInt1, paramString3, paramRect, paramInt10, paramInt11, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong1, paramLong2, false, false, 0, 0, false, paramInt9, paramb, paramb1);
    AppMethodBeat.i(205449);
    this.TAG = "Finder.FinderVideoRemuxer";
    AppMethodBeat.o(205449);
  }
  
  public final c auf()
  {
    AppMethodBeat.i(168169);
    if (this.hpg) {}
    for (Object localObject = new k(this.how, this.hox, this.outputWidth, this.outputHeight, 3);; localObject = new k(this.how, this.hox, this.outputWidth, this.outputHeight))
    {
      Rect localRect = this.hpa;
      if (localRect == null) {
        p.gkB();
      }
      p.h(localRect, "rect");
      ((c)localObject).hqf = localRect;
      int i = this.videoWidth;
      int j = this.videoHeight;
      ((k)localObject).videoWidth = i;
      ((k)localObject).videoHeight = j;
      ae.i(((k)localObject).TAG, "setVideoSize: " + i + ", " + j);
      ae.i(this.TAG, "videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", cropRect:" + this.hpa);
      localObject = (c)localObject;
      AppMethodBeat.o(168169);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.l
 * JD-Core Version:    0.7.0.1
 */