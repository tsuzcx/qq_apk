package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static com.tencent.mm.plugin.fav.a.g Ed(long paramLong)
  {
    AppMethodBeat.i(106785);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = z.aTY();
    anh localanh = new anh();
    localanh.bhf(str);
    localanh.bhg(str);
    localanh.ajm(localg.field_sourceType);
    localanh.MA(Util.nowMilliSecond());
    localg.field_favProto.a(localanh);
    localg.field_fromUser = localanh.dRL;
    localg.field_toUser = localanh.toUser;
    localg.field_favProto.ajl(1);
    localg.field_favProto.ajk(127);
    localg.field_edittime = Util.nowSecond();
    localg.field_updateTime = Util.nowMilliSecond();
    localg.field_favProto.Mz(localg.field_edittime);
    localg.field_favProto.Lya.MA(Util.nowMilliSecond());
    localg.field_itemStatus = 9;
    localg.field_localId = paramLong;
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(localg);
    AppMethodBeat.o(106785);
    return localg;
  }
  
  static void G(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106788);
    String str = z.aTY();
    anh localanh = new anh();
    localanh.bhf(str);
    localanh.bhg(str);
    localanh.ajm(paramg.field_sourceType);
    localanh.MA(Util.nowMilliSecond());
    paramg.field_favProto.a(localanh);
    paramg.field_fromUser = localanh.dRL;
    paramg.field_toUser = localanh.toUser;
    AppMethodBeat.o(106788);
  }
  
  public static com.tencent.mm.plugin.fav.a.g a(LinkedList<aml> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Ed(paramLong);
      }
      ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new com.tencent.mm.plugin.fav.a.g();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 18;
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
      G((com.tencent.mm.plugin.fav.a.g)localObject2);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajl(1);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ajk(127);
    }
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = Util.nowSecond();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime = Util.nowMilliSecond();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Mz(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Lya.MA(Util.nowMilliSecond());
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bH(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<aml> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      Log.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong))
    {
      b.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> dH(List<String> paramList)
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
        paramList = s.openRead(str);
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
  
  public static boolean dI(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = dH(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.FavPostLogic", "postImgs path null");
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
      aml localaml = new aml();
      localaml.bgt(str);
      localaml.bgs(com.tencent.mm.plugin.fav.a.b.ds(localaml.toString(), 2));
      BitmapUtil.createThumbNail(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.a(localaml), true);
      localaml.bgu(com.tencent.mm.plugin.fav.a.b.a(localaml));
      localaml.ajd(2);
      localg.field_favProto.ppH.add(localaml);
    }
    b.C(localg);
    h.CyF.a(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */