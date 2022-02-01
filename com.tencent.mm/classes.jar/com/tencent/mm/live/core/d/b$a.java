package com.tencent.mm.live.core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "", "key", "", "path", "", "title", "value", "(ILjava/lang/String;Ljava/lang/String;I)V", "getKey", "()I", "getPath", "()Ljava/lang/String;", "getTitle", "getValue", "setValue", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public final int key;
  public final String path;
  public final String title;
  public int value;
  
  public b$a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(247629);
    this.key = paramInt1;
    this.path = paramString1;
    this.title = paramString2;
    this.value = paramInt2;
    AppMethodBeat.o(247629);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247650);
    if (this == paramObject)
    {
      AppMethodBeat.o(247650);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(247650);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.key != paramObject.key)
    {
      AppMethodBeat.o(247650);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(247650);
      return false;
    }
    if (!s.p(this.title, paramObject.title))
    {
      AppMethodBeat.o(247650);
      return false;
    }
    if (this.value != paramObject.value)
    {
      AppMethodBeat.o(247650);
      return false;
    }
    AppMethodBeat.o(247650);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247643);
    int i = this.key;
    int j = this.path.hashCode();
    int k = this.title.hashCode();
    int m = this.value;
    AppMethodBeat.o(247643);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247633);
    String str = "FilterInfo(key=" + this.key + ", path=" + this.path + ", title=" + this.title + ", value=" + this.value + ')';
    AppMethodBeat.o(247633);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.d.b.a
 * JD-Core Version:    0.7.0.1
 */