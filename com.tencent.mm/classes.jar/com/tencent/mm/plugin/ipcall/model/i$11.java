package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.f.a.zp;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.h.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

final class i$11
  implements ck.a
{
  i$11(i parami) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(25388);
    Log.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
    parama = z.a(parama.jQG.RIF);
    if ((parama == null) || (parama.length() == 0))
    {
      Log.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25388);
      return;
    }
    Object localObject = XmlParser.parseXml(parama, "sysmsg", null);
    if (localObject == null)
    {
      Log.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
      AppMethodBeat.o(25388);
      return;
    }
    int i;
    if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
    {
      i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
      Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
      bh.beI();
      c.aHp().set(ar.a.Vji, Integer.valueOf(i));
    }
    for (;;)
    {
      int j;
      if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
      {
        j = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
        Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
        if (j != 0)
        {
          bh.beI();
          c.aHp().set(ar.a.Vjh, Boolean.TRUE);
          h.IzE.a(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
      }
      else
      {
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1286;
          }
          bh.beI();
          c.aHp().set(ar.a.Vju, Boolean.TRUE);
          h.IzE.a(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label387:
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1305;
          }
          bh.beI();
          c.aHp().set(ar.a.Vjo, Boolean.TRUE);
          h.IzE.a(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label510:
        String str;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
          bh.beI();
          c.aHp().set(ar.a.Vjn, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
          bh.beI();
          c.aHp().set(ar.a.Vjp, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
          bh.beI();
          c.aHp().set(ar.a.Vjj, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          bh.beI();
          c.aHp().set(ar.a.Vjy, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
          bh.beI();
          c.aHp().set(ar.a.Vjt, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
          bh.beI();
          c.aHp().set(ar.a.Vjk, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
          bh.beI();
          c.aHp().set(ar.a.Vjl, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          bh.beI();
          c.aHp().set(ar.a.Vjm, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
          h.IzE.a(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
          bh.beI();
          c.aHp().set(ar.a.Vjv, Integer.valueOf(i));
        }
        i = parama.indexOf("<ActivityInfo>");
        j = parama.indexOf("</ActivityInfo>");
        if ((i > 0) && (j > 0) && (j > i))
        {
          parama = parama.substring(i, j + 15);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { parama });
          localObject = a.aMa(parama);
          if ((localObject == null) || (!Util.isNullOrNil(((a)localObject).fwr)) || (!Util.isNullOrNil(((a)localObject).CMB))) {
            break label1324;
          }
          Log.i("MicroMsg.SubCoreIPCall", "clear activity");
          bh.beI();
          c.aHp().set(ar.a.VjH, Boolean.FALSE);
          bh.beI();
          c.aHp().set(ar.a.VjI, "");
        }
      }
      for (;;)
      {
        EventCenter.instance.publish(new ln());
        EventCenter.instance.publish(new zp());
        AppMethodBeat.o(25388);
        return;
        bh.beI();
        c.aHp().set(ar.a.Vjh, Boolean.FALSE);
        break;
        label1286:
        bh.beI();
        c.aHp().set(ar.a.Vju, Boolean.FALSE);
        break label387;
        label1305:
        bh.beI();
        c.aHp().set(ar.a.Vjo, Boolean.FALSE);
        break label510;
        label1324:
        if (localObject != null)
        {
          if (!Util.isNullOrNil(((a)localObject).DSF)) {
            q.bmg().a(((a)localObject).DSF, null);
          }
          bh.beI();
          c.aHp().set(ar.a.VjH, Boolean.TRUE);
          bh.beI();
          c.aHp().set(ar.a.VjI, parama);
        }
      }
      i = -1;
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.11
 * JD-Core Version:    0.7.0.1
 */