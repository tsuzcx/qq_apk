package com.tencent.mm.modelvideo;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelvideo/CompositionVideoTranscodeParam;", "", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "blendBitmapProvider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pts", "Landroid/graphics/Bitmap;", "getBlendBitmapProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendBitmapProvider", "(Lkotlin/jvm/functions/Function1;)V", "calcAdaptiveBitrate", "", "getCalcAdaptiveBitrate", "()Z", "setCalcAdaptiveBitrate", "(Z)V", "calcAdaptiveBitrateScene", "", "getCalcAdaptiveBitrateScene", "()I", "setCalcAdaptiveBitrateScene", "(I)V", "endTimeMs", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "mute", "getMute", "setMute", "outputHevc", "getOutputHevc", "setOutputHevc", "parallelParam", "Lcom/tencent/mm/modelvideo/ParallelParam;", "getParallelParam", "()Lcom/tencent/mm/modelvideo/ParallelParam;", "setParallelParam", "(Lcom/tencent/mm/modelvideo/ParallelParam;)V", "softEncode", "getSoftEncode", "setSoftEncode", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public long endTimeMs;
  public kotlin.g.a.b<? super Long, Bitmap> nBp;
  public boolean nLP;
  public final VideoTransPara oXZ;
  public boolean oYa;
  public boolean oYb;
  public int oYc;
  public o oYd;
  public boolean softEncode;
  public long startTimeMs;
  
  public b(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(241179);
    this.oXZ = paramVideoTransPara;
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.oYb = true;
    this.oYd = new o((byte)0);
    AppMethodBeat.o(241179);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(241187);
    if (this == paramObject)
    {
      AppMethodBeat.o(241187);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(241187);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.oXZ, paramObject.oXZ))
    {
      AppMethodBeat.o(241187);
      return false;
    }
    AppMethodBeat.o(241187);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(241184);
    int i = this.oXZ.hashCode();
    AppMethodBeat.o(241184);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241182);
    String str = "CompositionVideoTranscodeParam(videoParam=" + this.oXZ + ')';
    AppMethodBeat.o(241182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.b
 * JD-Core Version:    0.7.0.1
 */