package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.storage.an;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static an a(an paraman, cfn paramcfn)
  {
    AppMethodBeat.i(151322);
    paraman.setUsername(paramcfn.userName);
    paraman.to(paramcfn.bVF);
    AppMethodBeat.o(151322);
    return paraman;
  }
  
  public static LinkedList<vz> aF(List<cfo> paramList)
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
      cfo localcfo = (cfo)paramList.next();
      vz localvz = new vz();
      localvz.nIJ = localcfo.userName;
      localvz.nJO = localcfo.bVF;
      localvz.GnM = localcfo.fXp;
      localvz.GnN = localcfo.Guf;
      localvz.GnO = localcfo.Gug;
      localvz.GnP = localcfo.Hsr;
      localvz.GnQ = localcfo.Hst;
      localLinkedList.add(localvz);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */