package com.tencent.mm.plugin.finder.utils;

import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$PosTriggerConfig;", "", "jsonStr", "", "(Ljava/lang/String;)V", "enableForward", "", "getEnableForward", "()Z", "setEnableForward", "(Z)V", "enableLike", "getEnableLike", "setEnableLike", "enableSwitchFeed", "getEnableSwitchFeed", "setEnableSwitchFeed", "eventDetails", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$EventDetail;", "getEventDetails", "()Ljava/util/LinkedList;", "getJsonStr", "()Ljava/lang/String;", "setJsonStr", "component1", "copy", "equals", "other", "hashCode", "", "parse", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$b
{
  public boolean Czb;
  public boolean Ggu;
  public boolean Ggv;
  public final LinkedList<m.a> Ggw;
  private String rDx;
  
  public m$b(String paramString)
  {
    AppMethodBeat.i(333820);
    this.rDx = paramString;
    this.Ggw = new LinkedList();
    paramString = (CharSequence)this.rDx;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString = new JSONObject(this.rDx);
        if (paramString.has("listenEventList"))
        {
          JSONArray localJSONArray = paramString.getJSONArray("listenEventList");
          s.s(localJSONArray, "eventList");
          c.a(localJSONArray, (b)new a(this));
        }
        if (paramString.has("detail"))
        {
          paramString = paramString.getJSONArray("detail");
          s.s(paramString, "detailList");
          c.a(paramString, (b)new b(this));
        }
      }
      AppMethodBeat.o(333820);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(333835);
    if (this == paramObject)
    {
      AppMethodBeat.o(333835);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(333835);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.rDx, paramObject.rDx))
    {
      AppMethodBeat.o(333835);
      return false;
    }
    AppMethodBeat.o(333835);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(333832);
    if (this.rDx == null)
    {
      AppMethodBeat.o(333832);
      return 0;
    }
    int i = this.rDx.hashCode();
    AppMethodBeat.o(333832);
    return i;
  }
  
  public final String toString()
  {
    String str2 = this.rDx;
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    return str1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "type", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, ah>
  {
    a(m.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<JSONObject, ah>
  {
    b(m.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.b
 * JD-Core Version:    0.7.0.1
 */