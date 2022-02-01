package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.cox;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends k.b
{
  private cox lWP;
  
  public i(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).lWQ);
    }
    this.lWP = new cox();
    this.lWP.rVx = paramList.size();
    this.lWP.rVy = localLinkedList;
    this.EVU = this.lWP;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    private int key;
    cow lWQ;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.lWQ = new cow();
      this.lWQ.IyZ = 0;
      this.lWQ.Izj = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.lWQ = new cow();
      this.lWQ.IyZ = paramInt;
      this.lWQ.Izj = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.i
 * JD-Core Version:    0.7.0.1
 */