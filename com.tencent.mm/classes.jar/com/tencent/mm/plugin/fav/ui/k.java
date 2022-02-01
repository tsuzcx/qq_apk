package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
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
    String str = u.aqG();
    agu localagu = new agu();
    localagu.aEl(str);
    localagu.aEm(str);
    localagu.VM(paramg.field_sourceType);
    localagu.vv(bt.eGO());
    paramg.field_favProto.a(localagu);
    paramg.field_fromUser = localagu.dpv;
    paramg.field_toUser = localagu.toUser;
    AppMethodBeat.o(106788);
  }
  
  public static com.tencent.mm.plugin.fav.a.g a(LinkedList<afy> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = pX(paramLong);
      }
      ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.mVb.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new com.tencent.mm.plugin.fav.a.g();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 18;
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
      G((com.tencent.mm.plugin.fav.a.g)localObject2);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VL(1);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.VK(127);
    }
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bt.aGK();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime = bt.eGO();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.vu(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.DiD.vv(bt.eGO());
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bd(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<afy> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      ad.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong))
    {
      b.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> dm(List<String> paramList)
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
  
  public static boolean dn(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = dm(paramList);
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
      afy localafy = new afy();
      localafy.aDz(str);
      localafy.aDy(com.tencent.mm.plugin.fav.a.b.cT(localafy.toString(), 2));
      f.c(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.a(localafy));
      localafy.aDA(com.tencent.mm.plugin.fav.a.b.a(localafy));
      localafy.VD(2);
      localg.field_favProto.mVb.add(localafy);
    }
    b.C(localg);
    h.vKh.f(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
  
  private static com.tencent.mm.plugin.fav.a.g pX(long paramLong)
  {
    AppMethodBeat.i(106785);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = u.aqG();
    agu localagu = new agu();
    localagu.aEl(str);
    localagu.aEm(str);
    localagu.VM(localg.field_sourceType);
    localagu.vv(bt.eGO());
    localg.field_favProto.a(localagu);
    localg.field_fromUser = localagu.dpv;
    localg.field_toUser = localagu.toUser;
    localg.field_favProto.VL(1);
    localg.field_favProto.VK(127);
    localg.field_edittime = bt.aGK();
    localg.field_updateTime = bt.eGO();
    localg.field_favProto.vu(localg.field_edittime);
    localg.field_favProto.DiD.vv(bt.eGO());
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