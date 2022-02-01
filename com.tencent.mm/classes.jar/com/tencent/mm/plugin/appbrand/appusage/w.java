package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum w
{
  static void a(int paramInt, LinkedList<duj> paramLinkedList)
  {
    AppMethodBeat.i(44599);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (duj)paramLinkedList.next();
      if (!bt.isNullOrNil(((duj)localObject).username)) {
        localHashSet.add(((duj)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = n.a.jei;; paramLinkedList = n.a.jeh)
    {
      com.tencent.mm.plugin.appbrand.config.w.c((List)localObject, paramLinkedList);
      AppMethodBeat.o(44599);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */