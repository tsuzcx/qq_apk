package com.tencent.mm.plugin.finder.utils;

import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;", "", "jsonStr", "", "(Ljava/lang/String;)V", "enableForward", "", "getEnableForward", "()Z", "setEnableForward", "(Z)V", "enableLike", "getEnableLike", "setEnableLike", "enableSwitchFeed", "getEnableSwitchFeed", "setEnableSwitchFeed", "getJsonStr", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "hashCode", "", "parse", "", "toString", "plugin-finder-base_release"})
public final class h$a
{
  public boolean ADg;
  public boolean ADh;
  public boolean ADi;
  private final String ozE;
  
  public h$a(String paramString)
  {
    AppMethodBeat.i(258384);
    this.ozE = paramString;
    paramString = (CharSequence)this.ozE;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString = new JSONObject(this.ozE);
        if (paramString.has("listen_event_list"))
        {
          paramString = paramString.getJSONArray("listen_event_list");
          p.j(paramString, "eventList");
          c.a(paramString, (b)new a(this));
        }
      }
      AppMethodBeat.o(258384);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258388);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!p.h(this.ozE, paramObject.ozE)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258388);
      return true;
    }
    AppMethodBeat.o(258388);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(258385);
    String str = this.ozE;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(258385);
      return i;
    }
    AppMethodBeat.o(258385);
    return 0;
  }
  
  public final String toString()
  {
    String str2 = this.ozE;
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    return str1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "type", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, x>
  {
    a(h.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.h.a
 * JD-Core Version:    0.7.0.1
 */