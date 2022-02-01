package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.aw.d;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Map;

final class i$11
  implements cd.a
{
  i$11(i parami) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(25388);
    ad.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
    parama = z.a(parama.gqE.Fvk);
    if ((parama == null) || (parama.length() == 0))
    {
      ad.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25388);
      return;
    }
    Object localObject = bw.M(parama, "sysmsg");
    if (localObject == null)
    {
      ad.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
      AppMethodBeat.o(25388);
      return;
    }
    int i;
    if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
    {
      i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
      ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
      ba.aBQ();
      c.ajl().set(al.a.IsJ, Integer.valueOf(i));
    }
    for (;;)
    {
      int j;
      if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
      {
        j = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
        ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
        if (j != 0)
        {
          ba.aBQ();
          c.ajl().set(al.a.IsI, Boolean.TRUE);
          g.yhR.f(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
      }
      else
      {
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1285;
          }
          ba.aBQ();
          c.ajl().set(al.a.IsV, Boolean.TRUE);
          g.yhR.f(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label386:
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1304;
          }
          ba.aBQ();
          c.ajl().set(al.a.IsP, Boolean.TRUE);
          g.yhR.f(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label509:
        String str;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
          ba.aBQ();
          c.ajl().set(al.a.IsO, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
          ba.aBQ();
          c.ajl().set(al.a.IsQ, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
          ba.aBQ();
          c.ajl().set(al.a.IsK, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          ba.aBQ();
          c.ajl().set(al.a.IsZ, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
          ba.aBQ();
          c.ajl().set(al.a.IsU, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
          ba.aBQ();
          c.ajl().set(al.a.IsL, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
          ba.aBQ();
          c.ajl().set(al.a.IsM, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          ba.aBQ();
          c.ajl().set(al.a.IsN, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
          g.yhR.f(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
          ba.aBQ();
          c.ajl().set(al.a.IsW, Integer.valueOf(i));
        }
        i = parama.indexOf("<ActivityInfo>");
        j = parama.indexOf("</ActivityInfo>");
        if ((i > 0) && (j > 0) && (j > i))
        {
          parama = parama.substring(i, j + 15);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { parama });
          localObject = com.tencent.mm.plugin.ipcall.model.h.a.anx(parama);
          if ((localObject == null) || (!bt.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Title)) || (!bt.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Desc))) {
            break label1323;
          }
          ad.i("MicroMsg.SubCoreIPCall", "clear activity");
          ba.aBQ();
          c.ajl().set(al.a.Iti, Boolean.FALSE);
          ba.aBQ();
          c.ajl().set(al.a.Itj, "");
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.IbL.l(new kg());
        com.tencent.mm.sdk.b.a.IbL.l(new xd());
        AppMethodBeat.o(25388);
        return;
        ba.aBQ();
        c.ajl().set(al.a.IsI, Boolean.FALSE);
        break;
        label1285:
        ba.aBQ();
        c.ajl().set(al.a.IsV, Boolean.FALSE);
        break label386;
        label1304:
        ba.aBQ();
        c.ajl().set(al.a.IsP, Boolean.FALSE);
        break label509;
        label1323:
        if (localObject != null)
        {
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl)) {
            q.aIE().a(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl, null);
          }
          ba.aBQ();
          c.ajl().set(al.a.Iti, Boolean.TRUE);
          ba.aBQ();
          c.ajl().set(al.a.Itj, parama);
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