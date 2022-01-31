package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void B(com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramg.field_updateTime = System.currentTimeMillis();
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      paramg.field_localId = System.currentTimeMillis();
    }
    C(paramg);
    com.tencent.mm.plugin.fav.a.b.j(paramg);
  }
  
  private static void C(com.tencent.mm.plugin.fav.a.g paramg)
  {
    h.ew(paramg.field_localId);
    if (paramg.field_favProto.sXc.size() > 0)
    {
      com.tencent.mm.sdk.f.e.post(new b.a(paramg), "AddFavService_copy");
      return;
    }
    paramg.field_itemStatus = 9;
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().y(paramg);
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
      return;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramg, new String[0]);
    }
  }
  
  public static boolean a(cj paramcj)
  {
    if ((paramcj.bIw.bIy != null) && (paramcj.bIw.bIy.sXc != null))
    {
      paramcj = paramcj.bIw.bIy.sXc.iterator();
      while (paramcj.hasNext())
      {
        xv localxv = (xv)paramcj.next();
        int i = localxv.aYU;
        if (((i == 2) || (i == 4) || (i == 15) || (i == 8)) && (bk.bl(localxv.sUG)))
        {
          if (bk.bl(localxv.sVe)) {
            return false;
          }
          if (!com.tencent.mm.vfs.e.bK(localxv.sVe)) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  static int b(cj paramcj)
  {
    com.tencent.mm.plugin.fav.a.g localg1 = new com.tencent.mm.plugin.fav.a.g();
    localg1.field_favProto = paramcj.bIw.bIy;
    localg1.field_sessionId = paramcj.bIw.bIB;
    int j = paramcj.bIw.bID;
    yp localyp = localg1.field_favProto.sXa;
    int i;
    if (localyp != null)
    {
      localg1.field_sourceId = localyp.sXj;
      if ((localg1.field_sourceId == null) || (localg1.field_sourceId.equals(""))) {
        i = 0;
      }
      while (i != 0)
      {
        y.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
        i = 0;
        if (i != 0) {
          break label510;
        }
        paramcj = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().CO(localg1.field_sourceId);
        if (paramcj != null) {
          com.tencent.mm.plugin.fav.a.b.et(paramcj.field_localId);
        }
        return 0;
        com.tencent.mm.plugin.fav.a.g localg2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().CO(localg1.field_sourceId);
        if ((localg2 != null) && (localg2.field_id > 0))
        {
          i = localg2.field_id;
          if (i > 0) {
            break label210;
          }
          y.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[] { Integer.valueOf(i) });
        }
        for (;;)
        {
          if (localg2 == null) {
            break label281;
          }
          i = 1;
          break;
          label210:
          Object localObject = new LinkedList();
          axi localaxi = new axi();
          localaxi.ttL = 1;
          localaxi.ttM = ((int)(System.currentTimeMillis() / 1000L));
          ((LinkedList)localObject).add(localaxi);
          localObject = new al(i, (LinkedList)localObject, null);
          com.tencent.mm.kernel.g.Dk().a((m)localObject, 0);
        }
        label281:
        i = 0;
      }
      switch (localyp.bIl)
      {
      case 2: 
      default: 
        localg1.field_sourceType = localyp.bIl;
      }
    }
    for (;;)
    {
      localg1.field_fromUser = localyp.bRO;
      localg1.field_toUser = localyp.toUser;
      localg1.field_sourceId = localyp.sXj;
      localg1.field_sourceCreateTime = localyp.createTime;
      y.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[] { localg1.field_fromUser, localg1.field_toUser, localg1.field_sourceId, Integer.valueOf(localg1.field_sourceType) });
      i = 1;
      break;
      if (s.hl(localg1.field_fromUser))
      {
        localg1.field_sourceType = 23;
      }
      else if (s.fn(localg1.field_fromUser))
      {
        localg1.field_sourceType = 22;
      }
      else
      {
        localg1.field_sourceType = 21;
        continue;
        if (j == 1) {
          localg1.field_sourceType = 24;
        } else if (j == 2) {
          localg1.field_sourceType = 25;
        } else if (j == 3) {
          localg1.field_sourceType = 26;
        } else {
          localg1.field_sourceType = localyp.bIl;
        }
      }
    }
    label510:
    localg1.field_flag = 0;
    localg1.field_updateTime = System.currentTimeMillis();
    localg1.field_localId = System.currentTimeMillis();
    com.tencent.mm.plugin.fav.a.b.et(localg1.field_localId);
    localg1.field_type = paramcj.bIw.type;
    if ((paramcj.bIw.desc != null) && (paramcj.bIw.desc.length() >= 10001))
    {
      y.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
      localg1.field_favProto.Yp(paramcj.bIw.desc.substring(0, 10001));
    }
    for (;;)
    {
      localg1.field_xml = com.tencent.mm.plugin.fav.a.g.s(localg1);
      C(localg1);
      com.tencent.mm.plugin.fav.a.b.j(localg1);
      localg1.CE("MicroMsg.Fav.FavAddService");
      return 0;
      localg1.field_favProto.Yp(paramcj.bIw.desc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b
 * JD-Core Version:    0.7.0.1
 */