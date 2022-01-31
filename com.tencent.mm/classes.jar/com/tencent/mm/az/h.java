package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.ayz;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class h
  extends j.b
{
  private ayz fLR;
  
  public h(List<h.a> paramList)
  {
    super(36);
    AppMethodBeat.i(59997);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((h.a)localIterator.next()).fLS);
    }
    this.fLR = new ayz();
    this.fLR.jJu = paramList.size();
    this.fLR.jJv = localLinkedList;
    this.oDZ = this.fLR;
    AppMethodBeat.o(59997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.h
 * JD-Core Version:    0.7.0.1
 */