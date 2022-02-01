package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "", "opCode", "", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "seq", "", "(ILjava/util/Collection;J)V", "getItems", "()Ljava/util/Collection;", "setItems", "(Ljava/util/Collection;)V", "getOpCode", "()I", "setOpCode", "(I)V", "getSeq", "()J", "setSeq", "(J)V", "buildXml", "", "deviceId", "networkStatus", "availableCount", "Companion", "api-handoff_release"})
public final class b
{
  public static final a DrK;
  public Collection<? extends HandOff> DrJ;
  public int fCN;
  public long seq;
  
  static
  {
    AppMethodBeat.i(192581);
    DrK = new a((byte)0);
    AppMethodBeat.o(192581);
  }
  
  public b()
  {
    this(0, null, 0L, 7);
  }
  
  private b(int paramInt, Collection<? extends HandOff> paramCollection, long paramLong)
  {
    AppMethodBeat.i(192574);
    this.fCN = paramInt;
    this.DrJ = paramCollection;
    this.seq = paramLong;
    AppMethodBeat.o(192574);
  }
  
  public final String Z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192571);
    p.k(paramString1, "deviceId");
    p.k(paramString2, "networkStatus");
    paramString1 = new StringBuilder("\n        <handofflist opcode=\"").append(this.fCN).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(paramString1).append("\" networkstatus=\"");
    paramString2 = paramString2.toLowerCase();
    p.j(paramString2, "(this as java.lang.String).toLowerCase()");
    paramString2 = paramString1.append(paramString2).append("\" availablecount=\"").append(paramInt).append("\">\n        ");
    Object localObject = (Iterable)this.DrJ;
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
      AppMethodBeat.o(192571);
      throw paramString1;
    }
    paramString1 = n.bb((CharSequence)paramString1).toString();
    AppMethodBeat.o(192571);
    return paramString1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/model/HandOffList$Companion;", "", "()V", "SEQ_PLACEHOLDER", "", "api-handoff_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.b
 * JD-Core Version:    0.7.0.1
 */