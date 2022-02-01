package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$c
{
  public static au a(au paramau, dxg paramdxg)
  {
    AppMethodBeat.i(151322);
    paramau.setUsername(paramdxg.userName);
    paramau.setNickname(paramdxg.nickName);
    AppMethodBeat.o(151322);
    return paramau;
  }
  
  public static LinkedList<zh> cq(List<dxh> paramList)
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
      dxh localdxh = (dxh)paramList.next();
      zh localzh = new zh();
      localzh.UserName = localdxh.userName;
      localzh.vhX = localdxh.nickName;
      localzh.ZhN = localdxh.displayName;
      localzh.ZhO = localdxh.Zqf;
      localzh.ZhP = localdxh.Zqg;
      localzh.ZhQ = localdxh.abdm;
      localzh.ZhR = localdxh.abdo;
      localLinkedList.add(localzh);
    }
    AppMethodBeat.o(151323);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.c
 * JD-Core Version:    0.7.0.1
 */