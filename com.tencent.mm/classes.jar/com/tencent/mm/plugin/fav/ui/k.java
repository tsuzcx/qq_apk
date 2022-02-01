package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static void G(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106788);
    String str = u.aAm();
    akj localakj = new akj();
    localakj.aPf(str);
    localakj.aPg(str);
    localakj.ZR(paramg.field_sourceType);
    localakj.CM(bt.flT());
    paramg.field_favProto.a(localakj);
    paramg.field_fromUser = localakj.dyU;
    paramg.field_toUser = localakj.toUser;
    AppMethodBeat.o(106788);
  }
  
  public static com.tencent.mm.plugin.fav.a.g a(LinkedList<ajn> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = vJ(paramLong);
      }
      ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new com.tencent.mm.plugin.fav.a.g();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 18;
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
      G((com.tencent.mm.plugin.fav.a.g)localObject2);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZQ(1);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ZP(127);
    }
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bt.aQJ();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime = bt.flT();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.CL(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Gjv.CM(bt.flT());
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bl(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<ajn> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      ad.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong))
    {
      b.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> dq(List<String> paramList)
  {
    AppMethodBeat.i(106786);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(106786);
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
        paramList = i.openRead(str);
        if (paramList == null) {
          bt.d(paramList);
        } else {
          localList = paramList;
        }
      }
      catch (Exception paramList)
      {
        paramList = paramList;
        paramList = null;
        bt.d(paramList);
      }
      finally
      {
        bt.d(localList);
        AppMethodBeat.o(106786);
      }
    }
    AppMethodBeat.o(106786);
    return localArrayList;
  }
  
  public static boolean dr(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = dq(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.FavPostLogic", "postImgs path null");
      AppMethodBeat.o(106787);
      return false;
    }
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 2;
    localg.field_sourceType = 6;
    G(localg);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ajn localajn = new ajn();
      localajn.aOt(str);
      localajn.aOs(com.tencent.mm.plugin.fav.a.b.di(localajn.toString(), 2));
      com.tencent.mm.sdk.platformtools.g.c(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.a(localajn));
      localajn.aOu(com.tencent.mm.plugin.fav.a.b.a(localajn));
      localajn.ZI(2);
      localg.field_favProto.nZa.add(localajn);
    }
    b.C(localg);
    com.tencent.mm.plugin.report.service.g.yhR.f(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
  
  private static com.tencent.mm.plugin.fav.a.g vJ(long paramLong)
  {
    AppMethodBeat.i(106785);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = u.aAm();
    akj localakj = new akj();
    localakj.aPf(str);
    localakj.aPg(str);
    localakj.ZR(localg.field_sourceType);
    localakj.CM(bt.flT());
    localg.field_favProto.a(localakj);
    localg.field_fromUser = localakj.dyU;
    localg.field_toUser = localakj.toUser;
    localg.field_favProto.ZQ(1);
    localg.field_favProto.ZP(127);
    localg.field_edittime = bt.aQJ();
    localg.field_updateTime = bt.flT();
    localg.field_favProto.CL(localg.field_edittime);
    localg.field_favProto.Gjv.CM(bt.flT());
    localg.field_itemStatus = 9;
    localg.field_localId = paramLong;
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(localg);
    AppMethodBeat.o(106785);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */