package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "videoWidth", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;II)V", "TAG", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends e
{
  private final String TAG;
  
  public o(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong1, long paramLong2, int paramInt9, kotlin.g.a.b<? super Float, ah> paramb, kotlin.g.a.b<? super String, ah> paramb1, int paramInt10, int paramInt11)
  {
    super(paramString1, paramString2, paramInt1, paramString3, paramRect, paramInt10, paramInt11, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong1, paramLong2, false, false, 0, 0, false, paramInt9, paramb, paramb1);
    AppMethodBeat.i(334800);
    this.TAG = "Finder.FinderVideoRemuxer";
    AppMethodBeat.o(334800);
  }
  
  public final com.tencent.mm.media.j.b bpH()
  {
    AppMethodBeat.i(168169);
    if (this.nBZ) {}
    for (Object localObject = new n(bpF(), bpG(), getOutputWidth(), getOutputHeight(), 2);; localObject = new n(bpF(), bpG(), getOutputWidth(), getOutputHeight()))
    {
      Rect localRect = iD();
      s.checkNotNull(localRect);
      s.u(localRect, "rect");
      ((com.tencent.mm.media.j.b)localObject).nDB = localRect;
      int i = getVideoWidth();
      int j = getVideoHeight();
      ((n)localObject).videoWidth = i;
      ((n)localObject).videoHeight = j;
      Log.i(((n)localObject).TAG, "setVideoSize: " + i + ", " + j);
      Log.i(this.TAG, "videoWidth: " + getVideoWidth() + ", videoHeight: " + getVideoHeight() + ", cropRect:" + iD());
      localObject = (com.tencent.mm.media.j.b)localObject;
      AppMethodBeat.o(168169);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.o
 * JD-Core Version:    0.7.0.1
 */