package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static void G(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106788);
    String str = v.aAC();
    akt localakt = new akt();
    localakt.aQC(str);
    localakt.aQD(str);
    localakt.aax(paramg.field_sourceType);
    localakt.Dk(bu.fpO());
    paramg.field_favProto.a(localakt);
    paramg.field_fromUser = localakt.dzZ;
    paramg.field_toUser = localakt.toUser;
    AppMethodBeat.o(106788);
  }
  
  public static com.tencent.mm.plugin.fav.a.g a(LinkedList<ajx> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106784);
    Object localObject1 = null;
    if (paramLong != -1L)
    {
      localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = vZ(paramLong);
      }
      ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.clear();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new com.tencent.mm.plugin.fav.a.g();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 18;
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
      G((com.tencent.mm.plugin.fav.a.g)localObject2);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aaw(1);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aav(127);
    }
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bu.aRi();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_updateTime = bu.fpO();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Dj(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.GCe.Dk(bu.fpO());
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bm(paramLinkedList);
    AppMethodBeat.o(106784);
    return localObject2;
  }
  
  public static boolean a(String paramString, LinkedList<ajx> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(106783);
    if (paramString.length() == 0)
    {
      ae.e("MicroMsg.FavPostLogic", "postNote null");
      AppMethodBeat.o(106783);
      return false;
    }
    if (-1L == paramLong) {}
    for (paramString = a(paramLinkedList, paramLong);; paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong))
    {
      b.C(paramString);
      AppMethodBeat.o(106783);
      return true;
    }
  }
  
  private static List<String> dt(List<String> paramList)
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
        paramList = o.openRead(str);
        if (paramList == null) {
          bu.d(paramList);
        } else {
          localList = paramList;
        }
      }
      catch (Exception paramList)
      {
        paramList = paramList;
        paramList = null;
        bu.d(paramList);
      }
      finally
      {
        bu.d(localList);
        AppMethodBeat.o(106786);
      }
    }
    AppMethodBeat.o(106786);
    return localArrayList;
  }
  
  public static boolean du(List<String> paramList)
  {
    AppMethodBeat.i(106787);
    paramList = dt(paramList);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.e("MicroMsg.FavPostLogic", "postImgs path null");
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
      ajx localajx = new ajx();
      localajx.aPQ(str);
      localajx.aPP(com.tencent.mm.plugin.fav.a.b.dm(localajx.toString(), 2));
      h.c(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, com.tencent.mm.plugin.fav.a.b.a(localajx));
      localajx.aPR(com.tencent.mm.plugin.fav.a.b.a(localajx));
      localajx.aao(2);
      localg.field_favProto.oeJ.add(localajx);
    }
    b.C(localg);
    com.tencent.mm.plugin.report.service.g.yxI.f(10648, new Object[] { Integer.valueOf(2), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(106787);
    return true;
  }
  
  private static com.tencent.mm.plugin.fav.a.g vZ(long paramLong)
  {
    AppMethodBeat.i(106785);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 18;
    localg.field_sourceType = 6;
    String str = v.aAC();
    akt localakt = new akt();
    localakt.aQC(str);
    localakt.aQD(str);
    localakt.aax(localg.field_sourceType);
    localakt.Dk(bu.fpO());
    localg.field_favProto.a(localakt);
    localg.field_fromUser = localakt.dzZ;
    localg.field_toUser = localakt.toUser;
    localg.field_favProto.aaw(1);
    localg.field_favProto.aav(127);
    localg.field_edittime = bu.aRi();
    localg.field_updateTime = bu.fpO();
    localg.field_favProto.Dj(localg.field_edittime);
    localg.field_favProto.GCe.Dk(bu.fpO());
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