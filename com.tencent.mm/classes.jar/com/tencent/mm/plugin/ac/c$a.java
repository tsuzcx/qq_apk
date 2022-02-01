package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "", "appId", "", "idKey", "", "(Ljava/lang/String;J)V", "getAppId", "()Ljava/lang/String;", "getIdKey", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "webview-sdk_release"})
public final class c$a
{
  final long IBV;
  final String appId;
  
  public c$a(String paramString, long paramLong)
  {
    AppMethodBeat.i(224868);
    this.appId = paramString;
    this.IBV = paramLong;
    AppMethodBeat.o(224868);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224871);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.appId, paramObject.appId)) || (this.IBV != paramObject.IBV)) {}
      }
    }
    else
    {
      AppMethodBeat.o(224871);
      return true;
    }
    AppMethodBeat.o(224871);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(224870);
    String str = this.appId;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.IBV;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(224870);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224869);
    String str = "ClientInfo(appId=" + this.appId + ", idKey=" + this.IBV + ")";
    AppMethodBeat.o(224869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.c.a
 * JD-Core Version:    0.7.0.1
 */