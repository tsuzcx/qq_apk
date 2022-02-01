package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    String str = u.axw();
    aht localaht = new aht();
    localaht.aJC(str);
    localaht.aJD(str);
    localaht.XV(paramg.field_sourceType);
    localaht.zY(bs.eWj());
    paramg.field_favProto.a(localaht);
    paramg.field_fromUser = localaht.dng;
    paramg.field_toUser = localaht.toUser;
    AppMethodBeat.o(106788);
  }
  
  public static com.tencent.mm.plugin.fav.a.g a(LinkedList<agx> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = tM(paramLong);
      }
      ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new com.tencent.mm.plugin.fav.a.g();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 18;
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
      G((com.tencent.mm.plugin.fav.a.g)localObject2);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XU(1);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.XT(127);
    }
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bs.aNx();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime = bs.eWj();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.zX(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EBJ.zY(bs.eWj());
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bk(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<agx> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      ac.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong))
    {
      b.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> jdMethod_do(List<String> paramList)
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
          bs.d(paramList);
        } else {
          localList = paramList;
        }
      }
      catch (Exception paramList)
      {
        paramList = paramList;
        paramList = null;
        bs.d(paramList);
      }
      finally
      {
        bs.d(localList);
        AppMethodBeat.o(106786);
      }
    }
    AppMethodBeat.o(106786);
    return localArrayList;
  }
  
  public static boolean dp(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = jdMethod_do(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.e("MicroMsg.FavPostLogic", "postImgs path null");
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
      agx localagx = new agx();
      localagx.aIQ(str);
      localagx.aIP(com.tencent.mm.plugin.fav.a.b.cY(localagx.toString(), 2));
      f.c(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.a(localagx));
      localagx.aIR(com.tencent.mm.plugin.fav.a.b.a(localagx));
      localagx.XM(2);
      localg.field_favProto.nxC.add(localagx);
    }
    b.C(localg);
    h.wUl.f(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
  
  private static com.tencent.mm.plugin.fav.a.g tM(long paramLong)
  {
    AppMethodBeat.i(106785);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = u.axw();
    aht localaht = new aht();
    localaht.aJC(str);
    localaht.aJD(str);
    localaht.XV(localg.field_sourceType);
    localaht.zY(bs.eWj());
    localg.field_favProto.a(localaht);
    localg.field_fromUser = localaht.dng;
    localg.field_toUser = localaht.toUser;
    localg.field_favProto.XU(1);
    localg.field_favProto.XT(127);
    localg.field_edittime = bs.aNx();
    localg.field_updateTime = bs.eWj();
    localg.field_favProto.zX(localg.field_edittime);
    localg.field_favProto.EBJ.zY(bs.eWj());
    localg.field_itemStatus = 9;
    localg.field_localId = paramLong;
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(localg);
    AppMethodBeat.o(106785);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */