package com.tencent.mm.plugin.finder.live.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$BeautyInfo;", "", "key", "", "title", "", "(ILjava/lang/String;)V", "getKey", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class d$a
{
  final int key;
  final String title;
  
  public d$a(int paramInt, String paramString)
  {
    AppMethodBeat.i(248036);
    this.key = paramInt;
    this.title = paramString;
    AppMethodBeat.o(248036);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248039);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.key != paramObject.key) || (!p.j(this.title, paramObject.title))) {}
      }
    }
    else
    {
      AppMethodBeat.o(248039);
      return true;
    }
    AppMethodBeat.o(248039);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(248038);
    int j = this.key;
    String str = this.title;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(248038);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248037);
    String str = "BeautyInfo(key=" + this.key + ", title=" + this.title + ")";
    AppMethodBeat.o(248037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.d.a
 * JD-Core Version:    0.7.0.1
 */