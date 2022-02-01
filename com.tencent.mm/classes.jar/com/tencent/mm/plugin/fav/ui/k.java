package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static void G(g paramg)
  {
    AppMethodBeat.i(106788);
    String str = z.bAM();
    asb localasb = new asb();
    localasb.bto(str);
    localasb.btp(str);
    localasb.axH(paramg.field_sourceType);
    localasb.yu(Util.nowMilliSecond());
    paramg.field_favProto.a(localasb);
    paramg.field_fromUser = localasb.hQQ;
    paramg.field_toUser = localasb.toUser;
    AppMethodBeat.o(106788);
  }
  
  public static g a(LinkedList<arf> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = mP(paramLong);
      }
      ((g)localObject1).field_favProto.vEn.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new g();
      ((g)localObject2).field_type = 18;
      ((g)localObject2).field_sourceType = 6;
      G((g)localObject2);
      ((g)localObject2).field_favProto.axG(1);
      ((g)localObject2).field_favProto.axF(127);
    }
    ((g)localObject2).field_edittime = Util.nowSecond();
    ((g)localObject2).field_updateTime = Util.nowMilliSecond();
    ((g)localObject2).field_favProto.yt(((g)localObject2).field_edittime);
    ((g)localObject2).field_favProto.ZBt.yu(Util.nowMilliSecond());
    ((g)localObject2).field_favProto.cs(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<arf> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      Log.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong))
    {
      a.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> fI(List<String> paramList)
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
        paramList = com.tencent.mm.vfs.y.Lh(str);
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
  
  public static boolean fJ(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = fI(paramList);
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
      arf localarf = new arf();
      localarf.bsC(str);
      localarf.bsB(b.er(localarf.toString(), 2));
      BitmapUtil.createThumbNail(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a(localarf), true);
      localarf.bsD(b.a(localarf));
      localarf.axy(2);
      localg.field_favProto.vEn.add(localarf);
    }
    a.C(localg);
    com.tencent.mm.plugin.report.service.h.OAn.b(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
  
  private static g mP(long paramLong)
  {
    AppMethodBeat.i(106785);
    g localg = new g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = z.bAM();
    asb localasb = new asb();
    localasb.bto(str);
    localasb.btp(str);
    localasb.axH(localg.field_sourceType);
    localasb.yu(Util.nowMilliSecond());
    localg.field_favProto.a(localasb);
    localg.field_fromUser = localasb.hQQ;
    localg.field_toUser = localasb.toUser;
    localg.field_favProto.axG(1);
    localg.field_favProto.axF(127);
    localg.field_edittime = Util.nowSecond();
    localg.field_updateTime = Util.nowMilliSecond();
    localg.field_favProto.yt(localg.field_edittime);
    localg.field_favProto.ZBt.yu(Util.nowMilliSecond());
    localg.field_itemStatus = 9;
    localg.field_localId = paramLong;
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().z(localg);
    AppMethodBeat.o(106785);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */