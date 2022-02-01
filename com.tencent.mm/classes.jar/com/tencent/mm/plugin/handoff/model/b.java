package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "", "opCode", "", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "seq", "", "(ILjava/util/Collection;J)V", "getItems", "()Ljava/util/Collection;", "setItems", "(Ljava/util/Collection;)V", "getOpCode", "()I", "setOpCode", "(I)V", "getSeq", "()J", "setSeq", "(J)V", "buildXml", "", "deviceId", "networkStatus", "availableCount", "Companion", "api-handoff_release"})
public final class b
{
  public static final b.a yhI;
  public int dJY;
  public long seq;
  public Collection<? extends HandOff> yhH;
  
  static
  {
    AppMethodBeat.i(238052);
    yhI = new b.a((byte)0);
    AppMethodBeat.o(238052);
  }
  
  public b()
  {
    this(0, null, 0L, 7);
  }
  
  private b(int paramInt, Collection<? extends HandOff> paramCollection, long paramLong)
  {
    AppMethodBeat.i(238050);
    this.dJY = paramInt;
    this.yhH = paramCollection;
    this.seq = paramLong;
    AppMethodBeat.o(238050);
  }
  
  public final String V(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(238049);
    p.h(paramString1, "deviceId");
    p.h(paramString2, "networkStatus");
    paramString1 = new StringBuilder("\n        <handofflist opcode=\"").append(this.dJY).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(paramString1).append("\" networkstatus=\"");
    paramString2 = paramString2.toLowerCase();
    p.g(paramString2, "(this as java.lang.String).toLowerCase()");
    paramString2 = paramString1.append(paramString2).append("\" availablecount=\"").append(paramInt).append("\">\n        ");
    Object localObject = (Iterable)this.yhH;
    paramString1 = "";
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HandOff localHandOff = (HandOff)((Iterator)localObject).next();
      paramString1 = paramString1 + localHandOff.build();
    }
    paramString1 = paramString1 + "\n        </handofflist>\n        ";
    if (paramString1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(238049);
      throw paramString1;
    }
    paramString1 = n.trim((CharSequence)paramString1).toString();
    AppMethodBeat.o(238049);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.b
 * JD-Core Version:    0.7.0.1
 */