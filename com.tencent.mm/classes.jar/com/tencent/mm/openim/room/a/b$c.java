package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.storage.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static ad a(ad paramad, bib parambib)
  {
    AppMethodBeat.i(78978);
    paramad.setUsername(parambib.userName);
    paramad.jp(parambib.blZ);
    AppMethodBeat.o(78978);
    return paramad;
  }
  
  public static LinkedList<rd> am(List<bic> paramList)
  {
    AppMethodBeat.i(78979);
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(78979);
      return localLinkedList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bic localbic = (bic)paramList.next();
      rd localrd = new rd();
      localrd.jJA = localbic.userName;
      localrd.jKG = localbic.blZ;
      localrd.wJp = localbic.elx;
      localrd.wJq = localbic.wOA;
      localrd.wJr = localbic.wOB;
      localrd.wJs = localbic.xxl;
      localrd.wJt = localbic.xxn;
      localLinkedList.add(localrd);
    }
    AppMethodBeat.o(78979);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */