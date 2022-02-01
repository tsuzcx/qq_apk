package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.x.c;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum w
{
  static void a(int paramInt, LinkedList<ehv> paramLinkedList)
  {
    AppMethodBeat.i(44599);
    a(paramInt, paramLinkedList, null);
    AppMethodBeat.o(44599);
  }
  
  static void a(int paramInt, LinkedList<ehv> paramLinkedList, x.c paramc)
  {
    AppMethodBeat.i(222153);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (ehv)paramLinkedList.next();
      if (!bu.isNullOrNil(((ehv)localObject).username)) {
        localHashSet.add(((ehv)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = n.a.kbN;; paramLinkedList = n.a.kbM)
    {
      x.a((List)localObject, paramLinkedList, paramc);
      AppMethodBeat.o(222153);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */