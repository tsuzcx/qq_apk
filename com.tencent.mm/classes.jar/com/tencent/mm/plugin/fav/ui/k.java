package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static void G(g paramg)
  {
    AppMethodBeat.i(106788);
    String str = z.bcZ();
    aoi localaoi = new aoi();
    localaoi.btx(str);
    localaoi.bty(str);
    localaoi.arz(paramg.field_sourceType);
    localaoi.Ue(Util.nowMilliSecond());
    paramg.field_favProto.a(localaoi);
    paramg.field_fromUser = localaoi.fLi;
    paramg.field_toUser = localaoi.toUser;
    AppMethodBeat.o(106788);
  }
  
  private static g Kr(long paramLong)
  {
    AppMethodBeat.i(106785);
    g localg = new g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = z.bcZ();
    aoi localaoi = new aoi();
    localaoi.btx(str);
    localaoi.bty(str);
    localaoi.arz(localg.field_sourceType);
    localaoi.Ue(Util.nowMilliSecond());
    localg.field_favProto.a(localaoi);
    localg.field_fromUser = localaoi.fLi;
    localg.field_toUser = localaoi.toUser;
    localg.field_favProto.ary(1);
    localg.field_favProto.arx(127);
    localg.field_edittime = Util.nowSecond();
    localg.field_updateTime = Util.nowMilliSecond();
    localg.field_favProto.Ud(localg.field_edittime);
    localg.field_favProto.SAB.Ue(Util.nowMilliSecond());
    localg.field_itemStatus = 9;
    localg.field_localId = paramLong;
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().z(localg);
    AppMethodBeat.o(106785);
    return localg;
  }
  
  public static g a(LinkedList<anm> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Kr(paramLong);
      }
      ((g)localObject1).field_favProto.syG.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new g();
      ((g)localObject2).field_type = 18;
      ((g)localObject2).field_sourceType = 6;
      G((g)localObject2);
      ((g)localObject2).field_favProto.ary(1);
      ((g)localObject2).field_favProto.arx(127);
    }
    ((g)localObject2).field_edittime = Util.nowSecond();
    ((g)localObject2).field_updateTime = Util.nowMilliSecond();
    ((g)localObject2).field_favProto.Ud(((g)localObject2).field_edittime);
    ((g)localObject2).field_favProto.SAB.Ue(Util.nowMilliSecond());
    ((g)localObject2).field_favProto.cg(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<anm> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      Log.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong))
    {
      b.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> dN(List<String> paramList)
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
        paramList = u.Tf(str);
        if (paramList == null) {
          Util.qualityClose(paramList);
        } else {
          localList = paramList;
        }
      }
      catch (Exception paramList)
      {
        paramList = paramList;
        paramList = null;
        Util.qualityClose(paramList);
      }
      finally
      {
        Util.qualityClose(localList);
        AppMethodBeat.o(106786);
      }
    }
    AppMethodBeat.o(106786);
    return localArrayList;
  }
  
  public static boolean dO(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = dN(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.FavPostLogic", "postImgs path null");
      AppMethodBeat.o(106787);
      return false;
    }
    g localg = new g();
    localg.field_type = 2;
    localg.field_sourceType = 6;
    G(localg);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      anm localanm = new anm();
      localanm.bsL(str);
      localanm.bsK(com.tencent.mm.plugin.fav.a.b.dN(localanm.toString(), 2));
      BitmapUtil.createThumbNail(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.a(localanm), true);
      localanm.bsM(com.tencent.mm.plugin.fav.a.b.a(localanm));
      localanm.arq(2);
      localg.field_favProto.syG.add(localanm);
    }
    b.C(localg);
    com.tencent.mm.plugin.report.service.h.IzE.a(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */