package com.tencent.mm.mj_template.maas.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/AudioConfig;", "", "sampleRate", "", "channelCount", "(II)V", "getChannelCount", "()I", "durationPerFrame", "getDurationPerFrame", "setDurationPerFrame", "(I)V", "sampleCountPerFrame", "getSampleCountPerFrame", "getSampleRate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final int Ue = 8;
  final int channelCount;
  int oaM;
  final int sampleRate;
  
  public a(int paramInt1, int paramInt2)
  {
    this.sampleRate = paramInt1;
    this.channelCount = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.sampleRate != paramObject.sampleRate) {
        return false;
      }
    } while (this.channelCount == paramObject.channelCount);
    return false;
  }
  
  public final int hashCode()
  {
    return this.sampleRate * 31 + this.channelCount;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239998);
    String str = "AudioConfig(sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ')';
    AppMethodBeat.o(239998);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.a
 * JD-Core Version:    0.7.0.1
 */