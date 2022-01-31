package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void B(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(73921);
    paramg.field_updateTime = System.currentTimeMillis();
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      paramg.field_localId = System.currentTimeMillis();
    }
    C(paramg);
    com.tencent.mm.plugin.fav.a.b.j(paramg);
    AppMethodBeat.o(73921);
  }
  
  private static void C(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(73922);
    h.jT(paramg.field_localId);
    if (paramg.field_favProto.wVc.size() > 0)
    {
      d.post(new b.a(paramg), "AddFavService_copy");
      AppMethodBeat.o(73922);
      return;
    }
    paramg.field_itemStatus = 9;
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().y(paramg);
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
      AppMethodBeat.o(73922);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramg, new String[0]);
    }
  }
  
  private static boolean D(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(73924);
    if ((paramg.field_sourceId == null) || (paramg.field_sourceId.equals("")))
    {
      AppMethodBeat.o(73924);
      return false;
    }
    paramg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().NQ(paramg.field_sourceId);
    if ((paramg != null) && (paramg.field_id > 0)) {
      vW(paramg.field_id);
    }
    if (paramg != null)
    {
      AppMethodBeat.o(73924);
      return true;
    }
    AppMethodBeat.o(73924);
    return false;
  }
  
  public static boolean a(cm paramcm)
  {
    AppMethodBeat.i(73919);
    if ((paramcm.cpR.cpT != null) && (paramcm.cpR.cpT.wVc != null))
    {
      paramcm = paramcm.cpR.cpT.wVc.iterator();
      while (paramcm.hasNext())
      {
        aca localaca = (aca)paramcm.next();
        int i = localaca.dataType;
        if (((i == 2) || (i == 4) || (i == 15) || (i == 8)) && (bo.isNullOrNil(localaca.wSC)))
        {
          if (bo.isNullOrNil(localaca.wTa))
          {
            AppMethodBeat.o(73919);
            return false;
          }
          if (!e.cN(localaca.wTa))
          {
            AppMethodBeat.o(73919);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(73919);
    return true;
  }
  
  static int b(cm paramcm)
  {
    AppMethodBeat.i(73920);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_favProto = paramcm.cpR.cpT;
    localg.field_sessionId = paramcm.cpR.cpW;
    if (!b(localg, paramcm.cpR.cpY))
    {
      paramcm = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().NQ(localg.field_sourceId);
      if (paramcm != null) {
        com.tencent.mm.plugin.fav.a.b.jQ(paramcm.field_localId);
      }
      AppMethodBeat.o(73920);
      return 0;
    }
    localg.field_flag = 0;
    localg.field_updateTime = System.currentTimeMillis();
    localg.field_localId = System.currentTimeMillis();
    com.tencent.mm.plugin.fav.a.b.jQ(localg.field_localId);
    localg.field_type = paramcm.cpR.type;
    if ((paramcm.cpR.desc != null) && (paramcm.cpR.desc.length() >= 10001))
    {
      ab.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
      localg.field_favProto.aom(paramcm.cpR.desc.substring(0, 10001));
    }
    for (;;)
    {
      localg.field_xml = com.tencent.mm.plugin.fav.a.g.s(localg);
      C(localg);
      com.tencent.mm.plugin.fav.a.b.j(localg);
      localg.NG("MicroMsg.Fav.FavAddService");
      AppMethodBeat.o(73920);
      return 0;
      localg.field_favProto.aom(paramcm.cpR.desc);
    }
  }
  
  private static boolean b(com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(73923);
    acw localacw = paramg.field_favProto.wVa;
    if (localacw != null)
    {
      paramg.field_sourceId = localacw.wVj;
      if (D(paramg))
      {
        ab.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
        AppMethodBeat.o(73923);
        return false;
      }
      switch (localacw.cpG)
      {
      case 2: 
      default: 
        paramg.field_sourceType = localacw.cpG;
      }
    }
    for (;;)
    {
      paramg.field_fromUser = localacw.czp;
      paramg.field_toUser = localacw.toUser;
      paramg.field_sourceId = localacw.wVj;
      paramg.field_sourceCreateTime = localacw.createTime;
      ab.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[] { paramg.field_fromUser, paramg.field_toUser, paramg.field_sourceId, Integer.valueOf(paramg.field_sourceType) });
      AppMethodBeat.o(73923);
      return true;
      if (t.nU(paramg.field_fromUser))
      {
        paramg.field_sourceType = 23;
      }
      else if (t.lA(paramg.field_fromUser))
      {
        paramg.field_sourceType = 22;
      }
      else
      {
        paramg.field_sourceType = 21;
        continue;
        if (paramInt == 1) {
          paramg.field_sourceType = 24;
        } else if (paramInt == 2) {
          paramg.field_sourceType = 25;
        } else if (paramInt == 3) {
          paramg.field_sourceType = 26;
        } else {
          paramg.field_sourceType = localacw.cpG;
        }
      }
    }
  }
  
  private static void vW(int paramInt)
  {
    AppMethodBeat.i(73925);
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(73925);
      return;
    }
    Object localObject = new LinkedList();
    bdy localbdy = new bdy();
    localbdy.xtK = 1;
    localbdy.xtL = ((int)(System.currentTimeMillis() / 1000L));
    ((LinkedList)localObject).add(localbdy);
    localObject = new al(paramInt, (LinkedList)localObject, null);
    com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(73925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b
 * JD-Core Version:    0.7.0.1
 */