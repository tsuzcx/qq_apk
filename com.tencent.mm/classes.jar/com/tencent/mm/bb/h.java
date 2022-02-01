package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bki;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class h
  extends j.b
{
  private bki hoD;
  
  public h(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).hoE);
    }
    this.hoD = new bki();
    this.hoD.mAK = paramList.size();
    this.hoD.mAL = localLinkedList;
    this.tyM = this.hoD;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    bkh hoE;
    private int key;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.hoE = new bkh();
      this.hoE.vJz = 0;
      this.hoE.vJI = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.hoE = new bkh();
      this.hoE.vJz = paramInt;
      this.hoE.vJI = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.h
 * JD-Core Version:    0.7.0.1
 */