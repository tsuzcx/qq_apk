package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;", "", "chatroomList", "Ljava/util/LinkedList;", "", "clientBuff", "(Ljava/util/LinkedList;Ljava/lang/String;)V", "getChatroomList", "()Ljava/util/LinkedList;", "setChatroomList", "(Ljava/util/LinkedList;)V", "getClientBuff", "()Ljava/lang/String;", "setClientBuff", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"})
public final class m
{
  public LinkedList<String> zeT;
  public String zeU;
  
  private m(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(263521);
    this.zeT = paramLinkedList;
    this.zeU = null;
    AppMethodBeat.o(263521);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(263525);
    if (this != paramObject)
    {
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
        if ((!p.h(this.zeT, paramObject.zeT)) || (!p.h(this.zeU, paramObject.zeU))) {}
      }
    }
    else
    {
      AppMethodBeat.o(263525);
      return true;
    }
    AppMethodBeat.o(263525);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(263524);
    Object localObject = this.zeT;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.zeU;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(263524);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263523);
    String str = "LuckyMoneyLiveData(chatroomList=" + this.zeT + ", clientBuff=" + this.zeU + ")";
    AppMethodBeat.o(263523);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.m
 * JD-Core Version:    0.7.0.1
 */