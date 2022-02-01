package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$a
{
  public static LinkedList<cab> aD(List<String> paramList)
  {
    AppMethodBeat.i(151319);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      cab localcab = new cab();
      localcab.userName = str;
      localLinkedList.add(localcab);
    }
    AppMethodBeat.o(151319);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.a
 * JD-Core Version:    0.7.0.1
 */