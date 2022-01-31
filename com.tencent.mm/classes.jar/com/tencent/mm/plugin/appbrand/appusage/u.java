package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum u
{
  static void a(int paramInt, LinkedList<czt> paramLinkedList)
  {
    AppMethodBeat.i(129665);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (czt)paramLinkedList.next();
      if (!bo.isNullOrNil(((czt)localObject).username)) {
        localHashSet.add(((czt)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = k.a.hjg;; paramLinkedList = k.a.hjf)
    {
      s.a((List)localObject, paramLinkedList);
      AppMethodBeat.o(129665);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u
 * JD-Core Version:    0.7.0.1
 */