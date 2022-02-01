package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "", "opCode", "", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "seq", "", "(ILjava/util/Collection;J)V", "getItems", "()Ljava/util/Collection;", "setItems", "(Ljava/util/Collection;)V", "getOpCode", "()I", "setOpCode", "(I)V", "getSeq", "()J", "setSeq", "(J)V", "buildXml", "", "deviceId", "networkStatus", "availableCount", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a Jlq;
  public Collection<? extends HandOff> Jlr;
  public int hHC;
  public long seq;
  
  static
  {
    AppMethodBeat.i(266021);
    Jlq = new b.a((byte)0);
    AppMethodBeat.o(266021);
  }
  
  public b()
  {
    this(0, null, 0L, 7);
  }
  
  private b(int paramInt, Collection<? extends HandOff> paramCollection, long paramLong)
  {
    AppMethodBeat.i(266007);
    this.hHC = paramInt;
    this.Jlr = paramCollection;
    this.seq = paramLong;
    AppMethodBeat.o(266007);
  }
  
  public final String ag(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(266029);
    s.u(paramString1, "deviceId");
    s.u(paramString2, "networkStatus");
    paramString1 = new StringBuilder("\n        <handofflist opcode=\"").append(this.hHC).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(paramString1).append("\" networkstatus=\"");
    paramString2 = paramString2.toLowerCase();
    s.s(paramString2, "(this as java.lang.String).toLowerCase()");
    paramString2 = paramString1.append(paramString2).append("\" availablecount=\"").append(paramInt).append("\">\n        ");
    Object localObject = (Iterable)this.Jlr;
    paramString1 = "";
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString1 = s.X(paramString1, ((HandOff)((Iterator)localObject).next()).build());
    }
    paramString1 = paramString1 + "\n        </handofflist>\n        ";
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(266029);
      throw paramString1;
    }
    paramString1 = n.bq((CharSequence)paramString1).toString();
    AppMethodBeat.o(266029);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.b
 * JD-Core Version:    0.7.0.1
 */