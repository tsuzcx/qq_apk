package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class i$11
  implements bz.a
{
  i$11(i parami) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(21773);
    ab.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
    parama = aa.a(parama.eyJ.woR);
    if ((parama == null) || (parama.length() == 0))
    {
      ab.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
      AppMethodBeat.o(21773);
      return;
    }
    Object localObject = br.F(parama, "sysmsg");
    if (localObject == null)
    {
      ab.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
      AppMethodBeat.o(21773);
      return;
    }
    int i;
    if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
    {
      i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
      ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yAg, Integer.valueOf(i));
    }
    for (;;)
    {
      int j;
      if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
      {
        j = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
        ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
        if (j != 0)
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAf, Boolean.TRUE);
          h.qsU.e(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
      }
      else
      {
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
        {
          i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1285;
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAs, Boolean.TRUE);
          h.qsU.e(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label386:
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
        {
          i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label1304;
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAm, Boolean.TRUE);
          h.qsU.e(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        }
        label509:
        String str;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAl, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAn, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAh, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
        {
          i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAw, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAr, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
        {
          str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAi, str);
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
        {
          i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAj, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
        {
          i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAk, Integer.valueOf(i));
        }
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
        {
          i = bo.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
          h.qsU.e(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAt, Integer.valueOf(i));
        }
        i = parama.indexOf("<ActivityInfo>");
        j = parama.indexOf("</ActivityInfo>");
        if ((i > 0) && (j > 0) && (j > i))
        {
          parama = parama.substring(i, j + 15);
          ab.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { parama });
          localObject = com.tencent.mm.plugin.ipcall.a.g.a.QY(parama);
          if ((localObject == null) || (!bo.isNullOrNil(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).Title)) || (!bo.isNullOrNil(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).Desc))) {
            break label1323;
          }
          ab.i("MicroMsg.SubCoreIPCall", "clear activity");
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAF, Boolean.FALSE);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAG, "");
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.ymk.l(new is());
        com.tencent.mm.sdk.b.a.ymk.l(new ub());
        AppMethodBeat.o(21773);
        return;
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAf, Boolean.FALSE);
        break;
        label1285:
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAs, Boolean.FALSE);
        break label386;
        label1304:
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAm, Boolean.FALSE);
        break label509;
        label1323:
        if (localObject != null)
        {
          if (!bo.isNullOrNil(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).ImgUrl)) {
            o.ahB().a(((com.tencent.mm.plugin.ipcall.a.g.a)localObject).ImgUrl, null);
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAF, Boolean.TRUE);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAG, parama);
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