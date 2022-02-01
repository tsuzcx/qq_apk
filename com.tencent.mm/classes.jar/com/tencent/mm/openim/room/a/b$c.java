package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static as a(as paramas, dfe paramdfe)
  {
    AppMethodBeat.i(151322);
    paramas.setUsername(paramdfe.userName);
    paramas.setNickname(paramdfe.nickName);
    AppMethodBeat.o(151322);
    return paramas;
  }
  
  public static LinkedList<xn> aL(List<dff> paramList)
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
      dff localdff = (dff)paramList.next();
      xn localxn = new xn();
      localxn.UserName = localdff.userName;
      localxn.rWI = localdff.nickName;
      localxn.SjH = localdff.jmB;
      localxn.SjI = localdff.Srd;
      localxn.SjJ = localdff.Sre;
      localxn.SjK = localdff.TMV;
      localxn.SjL = localdff.TMX;
      localLinkedList.add(localxn);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */