package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static ai a(ai paramai, cac paramcac)
  {
    AppMethodBeat.i(151322);
    paramai.setUsername(paramcac.userName);
    paramai.qj(paramcac.bLs);
    AppMethodBeat.o(151322);
    return paramai;
  }
  
  public static LinkedList<ub> aE(List<cad> paramList)
  {
    AppMethodBeat.i(151323);
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(151323);
      return localLinkedList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cad localcad = (cad)paramList.next();
      ub localub = new ub();
      localub.ncR = localcad.userName;
      localub.ndW = localcad.bLs;
      localub.Eoe = localcad.fBV;
      localub.Eof = localcad.Euf;
      localub.Eog = localcad.Eug;
      localub.Eoh = localcad.Fpf;
      localub.Eoi = localcad.Fph;
      localLinkedList.add(localub);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */