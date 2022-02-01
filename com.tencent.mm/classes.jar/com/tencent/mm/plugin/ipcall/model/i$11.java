package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Map;

final class i$11
  implements cf.a
{
  i$11(i parami) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(25388);
    ae.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
    parama = z.a(parama.gte.FNI);
    if ((parama == null) || (parama.length() == 0))
    {
      ae.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25388);
      return;
    }
    Object localObject = bx.M(parama, "sysmsg");
    if (localObject == null)
    {
      ae.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
      AppMethodBeat.o(25388);
      return;
    }
    int i;
    if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
    {
      i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
      ae.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
      bc.aCg();
      c.ajA().set(am.a.INf, Integer.valueOf(i));
    }
    for (;;)
    {
      int j;
      if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
      {
        j = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
        ae.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
        if (j != 0)
        {
          bc.aCg();
          c.ajA().set(am.a.INe, Boolean.TRUE);
          g.yxI.f(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
      }
      else
      {
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
        {
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1285;
          }
          bc.aCg();
          c.ajA().set(am.a.INr, Boolean.TRUE);
          g.yxI.f(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label386:
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
        {
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1304;
          }
          bc.aCg();
          c.ajA().set(am.a.INl, Boolean.TRUE);
          g.yxI.f(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label509:
        String str;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
          bc.aCg();
          c.ajA().set(am.a.INk, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
          bc.aCg();
          c.ajA().set(am.a.INm, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
          bc.aCg();
          c.ajA().set(am.a.INg, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
        {
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          bc.aCg();
          c.ajA().set(am.a.INv, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
          bc.aCg();
          c.ajA().set(am.a.INq, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
          bc.aCg();
          c.ajA().set(am.a.INh, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
        {
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
          bc.aCg();
          c.ajA().set(am.a.INi, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
        {
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          bc.aCg();
          c.ajA().set(am.a.INj, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
        {
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
          g.yxI.f(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
          bc.aCg();
          c.ajA().set(am.a.INs, Integer.valueOf(i));
        }
        i = parama.indexOf("<ActivityInfo>");
        j = parama.indexOf("</ActivityInfo>");
        if ((i > 0) && (j > 0) && (j > i))
        {
          parama = parama.substring(i, j + 15);
          ae.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { parama });
          localObject = com.tencent.mm.plugin.ipcall.model.h.a.aoz(parama);
          if ((localObject == null) || (!bu.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Title)) || (!bu.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Desc))) {
            break label1323;
          }
          ae.i("MicroMsg.SubCoreIPCall", "clear activity");
          bc.aCg();
          c.ajA().set(am.a.INE, Boolean.FALSE);
          bc.aCg();
          c.ajA().set(am.a.INF, "");
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.IvT.l(new kh());
        com.tencent.mm.sdk.b.a.IvT.l(new xh());
        AppMethodBeat.o(25388);
        return;
        bc.aCg();
        c.ajA().set(am.a.INe, Boolean.FALSE);
        break;
        label1285:
        bc.aCg();
        c.ajA().set(am.a.INr, Boolean.FALSE);
        break label386;
        label1304:
        bc.aCg();
        c.ajA().set(am.a.INl, Boolean.FALSE);
        break label509;
        label1323:
        if (localObject != null)
        {
          if (!bu.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl)) {
            q.aIW().a(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl, null);
          }
          bc.aCg();
          c.ajA().set(am.a.INE, Boolean.TRUE);
          bc.aCg();
          c.ajA().set(am.a.INF, parama);
        }
      }
      i = -1;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.11
 * JD-Core Version:    0.7.0.1
 */