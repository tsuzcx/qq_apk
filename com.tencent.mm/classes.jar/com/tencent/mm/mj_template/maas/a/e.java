package com.tencent.mm.mj_template.maas.a;

import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/TemplateOutputInfo;", "", "level", "Lcom/tencent/maas/instamovie/mediafoundation/DimensionLevel;", "outputSize", "Lcom/tencent/mm/media/camera/model/GLSize;", "videoBitsPerFrame", "", "averageAudioBitRate", "maxKeyframeInterval", "(Lcom/tencent/maas/instamovie/mediafoundation/DimensionLevel;Lcom/tencent/mm/media/camera/model/GLSize;III)V", "getAverageAudioBitRate", "()I", "setAverageAudioBitRate", "(I)V", "getLevel", "()Lcom/tencent/maas/instamovie/mediafoundation/DimensionLevel;", "setLevel", "(Lcom/tencent/maas/instamovie/mediafoundation/DimensionLevel;)V", "getMaxKeyframeInterval", "setMaxKeyframeInterval", "getOutputSize", "()Lcom/tencent/mm/media/camera/model/GLSize;", "setOutputSize", "(Lcom/tencent/mm/media/camera/model/GLSize;)V", "getVideoBitsPerFrame", "setVideoBitsPerFrame", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final int Ue = 8;
  int averageAudioBitRate;
  int maxKeyframeInterval;
  public h nvN;
  b obm;
  int videoBitsPerFrame;
  
  private e(b paramb, h paramh)
  {
    AppMethodBeat.i(239987);
    this.obm = paramb;
    this.nvN = paramh;
    this.videoBitsPerFrame = 233333;
    this.averageAudioBitRate = 41000;
    this.maxKeyframeInterval = 30;
    AppMethodBeat.o(239987);
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(240009);
    s.u(paramb, "<set-?>");
    this.obm = paramb;
    AppMethodBeat.o(240009);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240029);
    if (this == paramObject)
    {
      AppMethodBeat.o(240029);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(240029);
      return false;
    }
    paramObject = (e)paramObject;
    if (this.obm != paramObject.obm)
    {
      AppMethodBeat.o(240029);
      return false;
    }
    if (!s.p(this.nvN, paramObject.nvN))
    {
      AppMethodBeat.o(240029);
      return false;
    }
    if (this.videoBitsPerFrame != paramObject.videoBitsPerFrame)
    {
      AppMethodBeat.o(240029);
      return false;
    }
    if (this.averageAudioBitRate != paramObject.averageAudioBitRate)
    {
      AppMethodBeat.o(240029);
      return false;
    }
    if (this.maxKeyframeInterval != paramObject.maxKeyframeInterval)
    {
      AppMethodBeat.o(240029);
      return false;
    }
    AppMethodBeat.o(240029);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(240026);
    int i = this.obm.hashCode();
    int j = this.nvN.hashCode();
    int k = this.videoBitsPerFrame;
    int m = this.averageAudioBitRate;
    int n = this.maxKeyframeInterval;
    AppMethodBeat.o(240026);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240020);
    String str = "TemplateOutputInfo(level=" + this.obm + ", outputSize=" + this.nvN + ", videoBitsPerFrame=" + this.videoBitsPerFrame + ", averageAudioBitRate=" + this.averageAudioBitRate + ", maxKeyframeInterval=" + this.maxKeyframeInterval + ')';
    AppMethodBeat.o(240020);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.e
 * JD-Core Version:    0.7.0.1
 */