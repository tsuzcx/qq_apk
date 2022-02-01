package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic$VideoInfo;", "", "durationS", "", "(I)V", "getDurationS", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ab$a
{
  final int svT;
  
  public ab$a(int paramInt)
  {
    this.svT = paramInt;
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
    } while (this.svT == paramObject.svT);
    return false;
  }
  
  public final int hashCode()
  {
    return this.svT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(326394);
    String str = "VideoInfo(durationS=" + this.svT + ')';
    AppMethodBeat.o(326394);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ab.a
 * JD-Core Version:    0.7.0.1
 */