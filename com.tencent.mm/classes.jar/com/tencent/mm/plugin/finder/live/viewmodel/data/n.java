package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;", "", "chatroomList", "Ljava/util/LinkedList;", "", "clientBuff", "(Ljava/util/LinkedList;Ljava/lang/String;)V", "getChatroomList", "()Ljava/util/LinkedList;", "setChatroomList", "(Ljava/util/LinkedList;)V", "getClientBuff", "()Ljava/lang/String;", "setClientBuff", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public LinkedList<String> EbY;
  public String EbZ;
  
  private n(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(356841);
    this.EbY = paramLinkedList;
    this.EbZ = null;
    AppMethodBeat.o(356841);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356870);
    if (this == paramObject)
    {
      AppMethodBeat.o(356870);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(356870);
      return false;
    }
    paramObject = (n)paramObject;
    if (!s.p(this.EbY, paramObject.EbY))
    {
      AppMethodBeat.o(356870);
      return false;
    }
    if (!s.p(this.EbZ, paramObject.EbZ))
    {
      AppMethodBeat.o(356870);
      return false;
    }
    AppMethodBeat.o(356870);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(356864);
    int j = this.EbY.hashCode();
    if (this.EbZ == null) {}
    for (int i = 0;; i = this.EbZ.hashCode())
    {
      AppMethodBeat.o(356864);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356857);
    String str = "LuckyMoneyLiveData(chatroomList=" + this.EbY + ", clientBuff=" + this.EbZ + ')';
    AppMethodBeat.o(356857);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.n
 * JD-Core Version:    0.7.0.1
 */