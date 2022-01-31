package com.tencent.mm.openim.room.a;

import com.tencent.mm.protocal.c.bba;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$a
{
  public static LinkedList<bba> ad(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bba localbba = new bba();
      localbba.userName = str;
      localLinkedList.add(localbba);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.a
 * JD-Core Version:    0.7.0.1
 */