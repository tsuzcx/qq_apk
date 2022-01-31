package com.tencent.mm.openim.room.a;

import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.storage.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static ad a(ad paramad, bbb parambbb)
  {
    paramad.setUsername(parambbb.userName);
    paramad.dk(parambbb.aVr);
    return paramad;
  }
  
  public static LinkedList<ob> ae(List<bbc> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null) {
      return localLinkedList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbc localbbc = (bbc)paramList.next();
      ob localob = new ob();
      localob.hPY = localbbc.userName;
      localob.hRf = localbbc.aVr;
      localob.sLC = localbbc.dtK;
      localob.sLD = localbbc.sQf;
      localob.sLE = localbbc.sQg;
      localob.sLF = localbbc.txf;
      localob.sLG = localbbc.txh;
      localLinkedList.add(localob);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */