package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.storage.af;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static af a(af paramaf, bvk parambvk)
  {
    AppMethodBeat.i(151322);
    paramaf.setUsername(parambvk.userName);
    paramaf.nd(parambvk.bNK);
    AppMethodBeat.o(151322);
    return paramaf;
  }
  
  public static LinkedList<tr> aH(List<bvl> paramList)
  {
    AppMethodBeat.i(151323);
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(151323);
      return localLinkedList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bvl localbvl = (bvl)paramList.next();
      tr localtr = new tr();
      localtr.mAQ = localbvl.userName;
      localtr.mBV = localbvl.bNK;
      localtr.CVu = localbvl.fyo;
      localtr.CVv = localbvl.Dbg;
      localtr.CVw = localbvl.Dbh;
      localtr.CVx = localbvl.DSJ;
      localtr.CVy = localbvl.DSL;
      localLinkedList.add(localtr);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */