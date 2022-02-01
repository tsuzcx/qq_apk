package com.tencent.mm.plugin.finder.webview.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper$DebugInfo;", "", "webUrl", "", "(Ljava/lang/String;)V", "getWebUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b
{
  public final String rDm;
  
  public d$b(String paramString)
  {
    AppMethodBeat.i(334612);
    this.rDm = paramString;
    AppMethodBeat.o(334612);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(334628);
    if (this == paramObject)
    {
      AppMethodBeat.o(334628);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(334628);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.rDm, paramObject.rDm))
    {
      AppMethodBeat.o(334628);
      return false;
    }
    AppMethodBeat.o(334628);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(334621);
    int i = this.rDm.hashCode();
    AppMethodBeat.o(334621);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(334618);
    String str = "DebugInfo(webUrl=" + this.rDm + ')';
    AppMethodBeat.o(334618);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.d.b
 * JD-Core Version:    0.7.0.1
 */