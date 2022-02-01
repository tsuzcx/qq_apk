package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "", "url", "", "level", "", "desc", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getLevel", "()I", "setLevel", "(I)V", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public String desc;
  public int level;
  public final String url;
  
  public j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(247904);
    this.url = paramString1;
    this.level = paramInt;
    this.desc = paramString2;
    AppMethodBeat.o(247904);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247931);
    if (this == paramObject)
    {
      AppMethodBeat.o(247931);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(247931);
      return false;
    }
    paramObject = (j)paramObject;
    if (!s.p(this.url, paramObject.url))
    {
      AppMethodBeat.o(247931);
      return false;
    }
    if (this.level != paramObject.level)
    {
      AppMethodBeat.o(247931);
      return false;
    }
    if (!s.p(this.desc, paramObject.desc))
    {
      AppMethodBeat.o(247931);
      return false;
    }
    AppMethodBeat.o(247931);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247923);
    int j = this.url.hashCode();
    int k = this.level;
    if (this.desc == null) {}
    for (int i = 0;; i = this.desc.hashCode())
    {
      AppMethodBeat.o(247923);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247915);
    String str = "url:" + this.url + ", level:" + this.level + ", desc:" + this.desc;
    AppMethodBeat.o(247915);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.j
 * JD-Core Version:    0.7.0.1
 */