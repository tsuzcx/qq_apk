package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.ag.d;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.protocal.protobuf.gkl;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum v
{
  static void a(int paramInt, LinkedList<gkl> paramLinkedList)
  {
    AppMethodBeat.i(44599);
    a(paramInt, paramLinkedList, null);
    AppMethodBeat.o(44599);
  }
  
  static void a(int paramInt, LinkedList<gkl> paramLinkedList, ag.d paramd)
  {
    AppMethodBeat.i(319327);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (gkl)paramLinkedList.next();
      if (!Util.isNullOrNil(((gkl)localObject).username)) {
        localHashSet.add(((gkl)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = q.a.qZp;; paramLinkedList = q.a.qZo)
    {
      ag.a((List)localObject, paramLinkedList, paramd);
      AppMethodBeat.o(319327);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.v
 * JD-Core Version:    0.7.0.1
 */