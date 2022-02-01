package com.tencent.mm.modelvideo;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelvideo/CompositionVideoTranscodeParam;", "", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "blendBitmapProvider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pts", "Landroid/graphics/Bitmap;", "getBlendBitmapProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendBitmapProvider", "(Lkotlin/jvm/functions/Function1;)V", "calcAdaptiveBitrate", "", "getCalcAdaptiveBitrate", "()Z", "setCalcAdaptiveBitrate", "(Z)V", "calcAdaptiveBitrateScene", "", "getCalcAdaptiveBitrateScene", "()I", "setCalcAdaptiveBitrateScene", "(I)V", "endTimeMs", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "mute", "getMute", "setMute", "outputHevc", "getOutputHevc", "setOutputHevc", "softEncode", "getSoftEncode", "setSoftEncode", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-videologic_release"})
public final class b
{
  public long endTimeMs;
  public kotlin.g.a.b<? super Long, Bitmap> kVT;
  public boolean lhf;
  public boolean mfh;
  public boolean mfi;
  public int mfj;
  public final VideoTransPara mfk;
  public boolean softEncode;
  public long startTimeMs;
  
  public b(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(216446);
    this.mfk = paramVideoTransPara;
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.mfi = true;
    AppMethodBeat.o(216446);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216454);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (!p.h(this.mfk, paramObject.mfk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(216454);
      return true;
    }
    AppMethodBeat.o(216454);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(216452);
    VideoTransPara localVideoTransPara = this.mfk;
    if (localVideoTransPara != null)
    {
      int i = localVideoTransPara.hashCode();
      AppMethodBeat.o(216452);
      return i;
    }
    AppMethodBeat.o(216452);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216449);
    String str = "CompositionVideoTranscodeParam(videoParam=" + this.mfk + ")";
    AppMethodBeat.o(216449);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.b
 * JD-Core Version:    0.7.0.1
 */