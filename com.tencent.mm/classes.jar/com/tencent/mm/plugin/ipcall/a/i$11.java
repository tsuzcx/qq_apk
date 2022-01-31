package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.il;
import com.tencent.mm.h.a.sj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class i$11
  implements bx.a
{
  i$11(i parami) {}
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
    parama = aa.a(parama.dBs.svH);
    if ((parama == null) || (parama.length() == 0))
    {
      y.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
      return;
    }
    Object localObject = bn.s(parama, "sysmsg");
    if (localObject == null)
    {
      y.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
      return;
    }
    int i;
    if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
    {
      i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
      y.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uqg, Integer.valueOf(i));
    }
    for (;;)
    {
      int j;
      if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
      {
        j = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
        y.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
        if (j != 0)
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqf, Boolean.valueOf(true));
          h.nFQ.f(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
      }
      else
      {
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
        {
          i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1265;
          }
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqs, Boolean.valueOf(true));
          h.nFQ.f(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label370:
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
        {
          i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1285;
          }
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqm, Boolean.valueOf(true));
          h.nFQ.f(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label494:
        String str;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uql, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqn, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqh, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
        {
          i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqw, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqr, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqi, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
        {
          i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqj, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
        {
          i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqk, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
        {
          i = bk.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
          h.nFQ.f(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqt, Integer.valueOf(i));
        }
        i = parama.indexOf("<ActivityInfo>");
        j = parama.indexOf("</ActivityInfo>");
        if ((i > 0) && (j > 0) && (j > i))
        {
          parama = parama.substring(i, j + 15);
          y.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { parama });
          localObject = com.tencent.mm.plugin.ipcall.a.g.a.Fy(parama);
          if ((localObject == null) || (!bk.bl(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).bGw)) || (!bk.bl(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).kRN))) {
            break label1305;
          }
          y.i("MicroMsg.SubCoreIPCall", "clear activity");
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqF, Boolean.valueOf(false));
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqG, "");
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.udP.m(new il());
        com.tencent.mm.sdk.b.a.udP.m(new sj());
        return;
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqf, Boolean.valueOf(false));
        break;
        label1265:
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqs, Boolean.valueOf(false));
        break label370;
        label1285:
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqm, Boolean.valueOf(false));
        break label494;
        label1305:
        if (localObject != null)
        {
          if (!bk.bl(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).lsF)) {
            o.OI().a(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).lsF, null);
          }
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqF, Boolean.valueOf(true));
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqG, parama);
        }
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.i.11
 * JD-Core Version:    0.7.0.1
 */