package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.config.l.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.protocal.c.cmc;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum u
{
  static void a(int paramInt, LinkedList<cmc> paramLinkedList)
  {
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (cmc)paramLinkedList.next();
      if (!bk.bl(((cmc)localObject).username)) {
        localHashSet.add(((cmc)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = l.a.fQv;; paramLinkedList = l.a.fQu)
    {
      s.a((List)localObject, paramLinkedList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u
 * JD-Core Version:    0.7.0.1
 */