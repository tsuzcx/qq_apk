package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.bso;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends k.b
{
  private bso iiu;
  
  public i(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).iiv);
    }
    this.iiu = new bso();
    this.iiu.nDi = paramList.size();
    this.iiu.nDj = localLinkedList;
    this.vKm = this.iiu;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    bsn iiv;
    private int key;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.iiv = new bsn();
      this.iiv.yhn = 0;
      this.iiv.yhw = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.iiv = new bsn();
      this.iiv.yhn = paramInt;
      this.iiv.yhw = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.i
 * JD-Core Version:    0.7.0.1
 */