package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.w.c;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum w
{
  static void a(int paramInt, LinkedList<eaa> paramLinkedList)
  {
    AppMethodBeat.i(44599);
    a(paramInt, paramLinkedList, null);
    AppMethodBeat.o(44599);
  }
  
  static void a(int paramInt, LinkedList<eaa> paramLinkedList, w.c paramc)
  {
    AppMethodBeat.i(186342);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (eaa)paramLinkedList.next();
      if (!bs.isNullOrNil(((eaa)localObject).username)) {
        localHashSet.add(((eaa)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = n.a.jEw;; paramLinkedList = n.a.jEv)
    {
      com.tencent.mm.plugin.appbrand.config.w.a((List)localObject, paramLinkedList, paramc);
      AppMethodBeat.o(186342);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */