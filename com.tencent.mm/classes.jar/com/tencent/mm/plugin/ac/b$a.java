package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "", "createTime", "", "elementId", "", "canvasId", "", "(JILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "getCreateTime", "()J", "setCreateTime", "(J)V", "getElementId", "()I", "firstOnScreenCost", "getFirstOnScreenCost", "setFirstOnScreenCost", "(I)V", "hasRendered", "", "getHasRendered", "()Z", "setHasRendered", "(Z)V", "isClientContextStarted", "setClientContextStarted", "jsInitCost", "getJsInitCost", "setJsInitCost", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "webview-sdk_release"})
public final class b$a
{
  public boolean IBL;
  public boolean IBM;
  private final int biJ;
  public long createTime;
  private final String lAN;
  
  public b$a(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(224856);
    this.createTime = paramLong;
    this.biJ = paramInt;
    this.lAN = paramString;
    this.IBM = true;
    AppMethodBeat.o(224856);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224859);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.createTime != paramObject.createTime) || (this.biJ != paramObject.biJ) || (!p.j(this.lAN, paramObject.lAN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(224859);
      return true;
    }
    AppMethodBeat.o(224859);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(224858);
    long l = this.createTime;
    int j = (int)(l ^ l >>> 32);
    int k = this.biJ;
    String str = this.lAN;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(224858);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224857);
    String str = "BindInfo(createTime=" + this.createTime + ", elementId=" + this.biJ + ", canvasId=" + this.lAN + ")";
    AppMethodBeat.o(224857);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b.a
 * JD-Core Version:    0.7.0.1
 */