package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/VideoPlayTime;", "", "saveTime", "", "playTime", "", "(JD)V", "getPlayTime", "()D", "getSaveTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-brandservice_release"})
public final class j
{
  final long kiO;
  final double kiP;
  
  public j(long paramLong, double paramDouble)
  {
    this.kiO = paramLong;
    this.kiP = paramDouble;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(15347);
    if (this != paramObject)
    {
      if (!(paramObject instanceof j)) {
        break label68;
      }
      paramObject = (j)paramObject;
      if (this.kiO != paramObject.kiO) {
        break label63;
      }
    }
    label63:
    for (int i = 1; (i != 0) && (Double.compare(this.kiP, paramObject.kiP) == 0); i = 0)
    {
      AppMethodBeat.o(15347);
      return true;
    }
    label68:
    AppMethodBeat.o(15347);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(15346);
    long l = this.kiO;
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.kiP);
    int j = (int)(l ^ l >>> 32);
    AppMethodBeat.o(15346);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(15345);
    String str = "VideoPlayTime(saveTime=" + this.kiO + ", playTime=" + this.kiP + ")";
    AppMethodBeat.o(15345);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j
 * JD-Core Version:    0.7.0.1
 */