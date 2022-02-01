package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static as a(as paramas, cvu paramcvu)
  {
    AppMethodBeat.i(151322);
    paramas.setUsername(paramcvu.userName);
    paramas.setNickname(paramcvu.nickName);
    AppMethodBeat.o(151322);
    return paramas;
  }
  
  public static LinkedList<xh> aN(List<cvv> paramList)
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
      cvv localcvv = (cvv)paramList.next();
      xh localxh = new xh();
      localxh.UserName = localcvv.userName;
      localxh.oUJ = localcvv.nickName;
      localxh.Liq = localcvv.gCv;
      localxh.Lir = localcvv.LpH;
      localxh.Lis = localcvv.LpI;
      localxh.Lit = localcvv.MBo;
      localxh.Liu = localcvv.MBq;
      localLinkedList.add(localxh);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */