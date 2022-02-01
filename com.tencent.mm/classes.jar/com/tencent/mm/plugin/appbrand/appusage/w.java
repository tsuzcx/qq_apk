package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.d;
import com.tencent.mm.plugin.appbrand.config.o.a;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

 enum w
{
  static void a(int paramInt, LinkedList<fcn> paramLinkedList)
  {
    AppMethodBeat.i(44599);
    a(paramInt, paramLinkedList, null);
    AppMethodBeat.o(44599);
  }
  
  static void a(int paramInt, LinkedList<fcn> paramLinkedList, aa.d paramd)
  {
    AppMethodBeat.i(226393);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (fcn)paramLinkedList.next();
      if (!Util.isNullOrNil(((fcn)localObject).username)) {
        localHashSet.add(((fcn)localObject).username);
      }
    }
    Object localObject = new ArrayList(localHashSet.size());
    ((List)localObject).addAll(localHashSet);
    if (paramInt == 3) {}
    for (paramLinkedList = o.a.leU;; paramLinkedList = o.a.leT)
    {
      aa.a((List)localObject, paramLinkedList, paramd);
      AppMethodBeat.o(226393);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */