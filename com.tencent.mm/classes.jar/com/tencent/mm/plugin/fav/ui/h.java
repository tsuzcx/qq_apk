package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  static void E(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74040);
    String str = r.Zn();
    acw localacw = new acw();
    localacw.aon(str);
    localacw.aoo(str);
    localacw.MR(paramg.field_sourceType);
    localacw.nI(bo.aoy());
    paramg.field_favProto.a(localacw);
    paramg.field_fromUser = localacw.czp;
    paramg.field_toUser = localacw.toUser;
    AppMethodBeat.o(74040);
  }
  
  public static com.tencent.mm.plugin.fav.a.g a(LinkedList<aca> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(74036);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = kg(paramLong);
      }
      ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new com.tencent.mm.plugin.fav.a.g();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 18;
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
      E((com.tencent.mm.plugin.fav.a.g)localObject2);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MQ(1);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.MP(127);
    }
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bo.aox();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime = bo.aoy();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nH(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.wVa.nI(bo.aoy());
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aJ(paramLinkedList);
    AppMethodBeat.o(74036);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<aca> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(74035);
    if (paramString.length() == 0)
    {
      ab.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(74035);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong))
    {
      b.B(paramString);
      AppMethodBeat.o(74035);
      return true;
    }
  }
  
  private static List<String> bK(List<String> paramList)
  {
    AppMethodBeat.i(74038);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(74038);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List<String> localList = null;
      try
      {
        paramList = e.openRead(str);
        if (paramList == null) {
          bo.b(paramList);
        } else {
          localList = paramList;
        }
      }
      catch (Exception paramList)
      {
        paramList = paramList;
        paramList = null;
        bo.b(paramList);
      }
      finally
      {
        bo.b(localList);
        AppMethodBeat.o(74038);
      }
    }
    AppMethodBeat.o(74038);
    return localArrayList;
  }
  
  public static boolean bL(List<String> paramList)
  {
    AppMethodBeat.i(74039);
    paramList = bK(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.e("MicroMsg.FavPostLogic", "postImgs path null");
      AppMethodBeat.o(74039);
      return false;
    }
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 2;
    localg.field_sourceType = 6;
    E(localg);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aca localaca = new aca();
      localaca.anE(str);
      localaca.anD(com.tencent.mm.plugin.fav.a.b.cj(localaca.toString(), 2));
      d.c(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.c(localaca));
      localaca.anF(com.tencent.mm.plugin.fav.a.b.c(localaca));
      localaca.MI(2);
      localg.field_favProto.wVc.add(localaca);
    }
    b.B(localg);
    com.tencent.mm.plugin.report.service.h.qsU.e(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(74039);
    return true;
  }
  
  private static com.tencent.mm.plugin.fav.a.g kg(long paramLong)
  {
    AppMethodBeat.i(74037);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = r.Zn();
    acw localacw = new acw();
    localacw.aon(str);
    localacw.aoo(str);
    localacw.MR(localg.field_sourceType);
    localacw.nI(bo.aoy());
    localg.field_favProto.a(localacw);
    localg.field_fromUser = localacw.czp;
    localg.field_toUser = localacw.toUser;
    localg.field_favProto.MQ(1);
    localg.field_favProto.MP(127);
    localg.field_edittime = bo.aox();
    localg.field_updateTime = bo.aoy();
    localg.field_favProto.nH(localg.field_edittime);
    localg.field_favProto.wVa.nI(bo.aoy());
    localg.field_itemStatus = 9;
    localg.field_localId = paramLong;
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().y(localg);
    AppMethodBeat.o(74037);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.h
 * JD-Core Version:    0.7.0.1
 */