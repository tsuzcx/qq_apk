package com.tencent.mm.booter;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.y;
import java.util.LinkedList;

public final class i
{
  public static void run()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = bk.a((Integer)au.Hv().get(19), 0);
    int i = 0;
    asx localasx;
    while (i < j)
    {
      localasx = new asx();
      localasx.nFi = 31;
      localasx.nFs = "0";
      localLinkedList.add(localasx);
      i += 1;
    }
    j = bk.a((Integer)au.Hv().get(20), 0);
    i = 0;
    while (i < j)
    {
      localasx = new asx();
      localasx.nFi = 31;
      localasx.nFs = "1";
      localLinkedList.add(localasx);
      i += 1;
    }
    if (localLinkedList.size() > 0)
    {
      bt.c(localLinkedList);
      au.Hv().set(19, Integer.valueOf(0));
      au.Hv().set(20, Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.i
 * JD-Core Version:    0.7.0.1
 */