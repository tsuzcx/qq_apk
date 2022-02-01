package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dxf;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract interface b
{
  public static final class a
  {
    public static LinkedList<dxf> cp(List<String> paramList)
    {
      AppMethodBeat.i(151319);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        dxf localdxf = new dxf();
        localdxf.userName = str;
        localLinkedList.add(localdxf);
      }
      AppMethodBeat.o(151319);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b
 * JD-Core Version:    0.7.0.1
 */