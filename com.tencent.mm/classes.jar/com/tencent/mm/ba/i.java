package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bti;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends k.b
{
  private bti iln;
  
  public i(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).ilo);
    }
    this.iln = new bti();
    this.iln.nID = paramList.size();
    this.iln.nIE = localLinkedList;
    this.vWq = this.iln;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    bth ilo;
    private int key;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.ilo = new bth();
      this.ilo.yxe = 0;
      this.ilo.yxn = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.ilo = new bth();
      this.ilo.yxe = paramInt;
      this.ilo.yxn = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.i
 * JD-Core Version:    0.7.0.1
 */