package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.storage.am;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static am a(am paramam, cet paramcet)
  {
    AppMethodBeat.i(151322);
    paramam.setUsername(paramcet.userName);
    paramam.sT(paramcet.bVF);
    AppMethodBeat.o(151322);
    return paramam;
  }
  
  public static LinkedList<vw> aF(List<ceu> paramList)
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
      ceu localceu = (ceu)paramList.next();
      vw localvw = new vw();
      localvw.nDo = localceu.userName;
      localvw.nEt = localceu.bVF;
      localvw.FVn = localceu.fVj;
      localvw.FVo = localceu.Gby;
      localvw.FVp = localceu.Gbz;
      localvw.FVq = localceu.GYQ;
      localvw.FVr = localceu.GYS;
      localLinkedList.add(localvw);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */