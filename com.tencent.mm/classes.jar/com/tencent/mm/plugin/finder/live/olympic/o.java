package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/OlympicCgiException;", "", "errorType", "", "errorCode", "msg", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends Throwable
{
  final int errorCode;
  private final int hDx;
  final String msg;
  
  public o(int paramInt1, int paramInt2, String paramString)
  {
    super(paramString);
    this.hDx = paramInt1;
    this.errorCode = paramInt2;
    this.msg = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(360462);
    if (this == paramObject)
    {
      AppMethodBeat.o(360462);
      return true;
    }
    if (!(paramObject instanceof o))
    {
      AppMethodBeat.o(360462);
      return false;
    }
    paramObject = (o)paramObject;
    if (this.hDx != paramObject.hDx)
    {
      AppMethodBeat.o(360462);
      return false;
    }
    if (this.errorCode != paramObject.errorCode)
    {
      AppMethodBeat.o(360462);
      return false;
    }
    if (!s.p(this.msg, paramObject.msg))
    {
      AppMethodBeat.o(360462);
      return false;
    }
    AppMethodBeat.o(360462);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(360455);
    int j = this.hDx;
    int k = this.errorCode;
    if (this.msg == null) {}
    for (int i = 0;; i = this.msg.hashCode())
    {
      AppMethodBeat.o(360455);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(360451);
    String str = "OlympicCgiException(errorType=" + this.hDx + ", errorCode=" + this.errorCode + ", msg=" + this.msg + ')';
    AppMethodBeat.o(360451);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.o
 * JD-Core Version:    0.7.0.1
 */