package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends j.b
{
  private boc hPg;
  
  public i(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).hPh);
    }
    this.hPg = new boc();
    this.hPg.ncL = paramList.size();
    this.hPg.ncM = localLinkedList;
    this.uHj = this.hPg;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    bob hPh;
    private int key;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.hPh = new bob();
      this.hPh.wTD = 0;
      this.hPh.wTM = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.hPh = new bob();
      this.hPh.wTD = paramInt;
      this.hPh.wTM = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.i
 * JD-Core Version:    0.7.0.1
 */