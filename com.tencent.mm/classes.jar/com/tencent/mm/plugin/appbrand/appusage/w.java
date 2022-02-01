package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.x.c;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum w
{
  static void a(int paramInt, LinkedList<ege> paramLinkedList)
  {
    AppMethodBeat.i(44599);
    a(paramInt, paramLinkedList, null);
    AppMethodBeat.o(44599);
  }
  
  static void a(int paramInt, LinkedList<ege> paramLinkedList, x.c paramc)
  {
    AppMethodBeat.i(188034);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (ege)paramLinkedList.next();
      if (!bt.isNullOrNil(((ege)localObject).username)) {
        localHashSet.add(((ege)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = n.a.jYy;; paramLinkedList = n.a.jYx)
    {
      x.a((List)localObject, paramLinkedList, paramc);
      AppMethodBeat.o(188034);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */