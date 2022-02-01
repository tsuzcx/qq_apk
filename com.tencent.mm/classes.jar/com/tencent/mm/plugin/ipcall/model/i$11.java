package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.h.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

final class i$11
  implements cj.a
{
  i$11(i parami) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(25388);
    Log.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
    parama = z.a(parama.heO.KHn);
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
      bg.aVF();
      c.azQ().set(ar.a.NVi, Integer.valueOf(i));
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
          bg.aVF();
          c.azQ().set(ar.a.NVh, Boolean.TRUE);
          h.CyF.a(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
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
          bg.aVF();
          c.azQ().set(ar.a.NVu, Boolean.TRUE);
          h.CyF.a(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label387:
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1305;
          }
          bg.aVF();
          c.azQ().set(ar.a.NVo, Boolean.TRUE);
          h.CyF.a(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label510:
        String str;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
          bg.aVF();
          c.azQ().set(ar.a.NVn, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
          bg.aVF();
          c.azQ().set(ar.a.NVp, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
          bg.aVF();
          c.azQ().set(ar.a.NVj, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          bg.aVF();
          c.azQ().set(ar.a.NVy, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
          bg.aVF();
          c.azQ().set(ar.a.NVt, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
          bg.aVF();
          c.azQ().set(ar.a.NVk, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
          bg.aVF();
          c.azQ().set(ar.a.NVl, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          bg.aVF();
          c.azQ().set(ar.a.NVm, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
        {
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
          h.CyF.a(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
          bg.aVF();
          c.azQ().set(ar.a.NVv, Integer.valueOf(i));
        }
        i = parama.indexOf("<ActivityInfo>");
        j = parama.indexOf("</ActivityInfo>");
        if ((i > 0) && (j > 0) && (j > i))
        {
          parama = parama.substring(i, j + 15);
          Log.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { parama });
          localObject = a.aBT(parama);
          if ((localObject == null) || (!Util.isNullOrNil(((a)localObject).Title)) || (!Util.isNullOrNil(((a)localObject).Desc))) {
            break label1324;
          }
          Log.i("MicroMsg.SubCoreIPCall", "clear activity");
          bg.aVF();
          c.azQ().set(ar.a.NVH, Boolean.FALSE);
          bg.aVF();
          c.azQ().set(ar.a.NVI, "");
        }
      }
      for (;;)
      {
        EventCenter.instance.publish(new kw());
        EventCenter.instance.publish(new yi());
        AppMethodBeat.o(25388);
        return;
        bg.aVF();
        c.azQ().set(ar.a.NVh, Boolean.FALSE);
        break;
        label1286:
        bg.aVF();
        c.azQ().set(ar.a.NVu, Boolean.FALSE);
        break label387;
        label1305:
        bg.aVF();
        c.azQ().set(ar.a.NVo, Boolean.FALSE);
        break label510;
        label1324:
        if (localObject != null)
        {
          if (!Util.isNullOrNil(((a)localObject).ImgUrl)) {
            q.bcQ().a(((a)localObject).ImgUrl, null);
          }
          bg.aVF();
          c.azQ().set(ar.a.NVH, Boolean.TRUE);
          bg.aVF();
          c.azQ().set(ar.a.NVI, parama);
        }
      }
      i = -1;
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.11
 * JD-Core Version:    0.7.0.1
 */