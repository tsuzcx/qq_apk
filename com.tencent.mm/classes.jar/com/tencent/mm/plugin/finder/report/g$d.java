package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter$ReportTaskInfo;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "moovPos", "", "getMoovPos", "()J", "setMoovPos", "(J)V", "requestVideoFormat", "", "getRequestVideoFormat", "()I", "setRequestVideoFormat", "(I)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class g$d
{
  long foi;
  private final String mediaId;
  int requestVideoFormat;
  
  public g$d(String paramString)
  {
    AppMethodBeat.i(198865);
    this.mediaId = paramString;
    AppMethodBeat.o(198865);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198868);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if (!k.g(this.mediaId, paramObject.mediaId)) {}
      }
    }
    else
    {
      AppMethodBeat.o(198868);
      return true;
    }
    AppMethodBeat.o(198868);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198867);
    String str = this.mediaId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(198867);
      return i;
    }
    AppMethodBeat.o(198867);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198866);
    String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
    AppMethodBeat.o(198866);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g.d
 * JD-Core Version:    0.7.0.1
 */