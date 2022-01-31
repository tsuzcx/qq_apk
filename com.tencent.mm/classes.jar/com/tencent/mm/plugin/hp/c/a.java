package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bxr;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  String lnd;
  String lne;
  private LinkedList<bxr> lnf = new LinkedList();
  private boolean lnh = true;
  com.tencent.mm.plugin.hp.d.b lni;
  
  public a()
  {
    this("", "", null, false);
  }
  
  public a(String paramString1, String paramString2, List<bxr> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private a(String paramString1, String paramString2, List<bxr> paramList, boolean paramBoolean)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new ps();
    ((b.a)localObject1).ecI = new pt();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/checktinkerupdate";
    ((b.a)localObject1).ecG = 922;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    if (!paramBoolean)
    {
      String str = "tinker_id_" + com.tencent.mm.loader.a.a.EP();
      if (com.tencent.mm.loader.a.a.dON == null) {}
      for (paramString1 = "";; paramString1 = "tinker_id_" + com.tencent.mm.loader.a.a.dON)
      {
        LinkedList localLinkedList = new LinkedList();
        long l1 = 0L;
        try
        {
          long l2 = com.tencent.mm.kernel.a.De() & 0xFFFFFFFF;
          l1 = l2;
          y.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "uin is %s", new Object[] { bk.aac(String.valueOf(l2)) });
          l1 = l2;
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            Object localObject2;
            y.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramString2, "tinker patch manager get uin failed.", new Object[0]);
            continue;
            int i = 2;
          }
        }
        localLinkedList.add(dy("code-version", com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION));
        localLinkedList.add(dy("code-reversion", com.tencent.mm.sdk.platformtools.d.REV));
        localLinkedList.add(dy("sdk", String.valueOf(Build.VERSION.SDK_INT)));
        localLinkedList.add(dy("os-name", com.tencent.mm.protocal.d.soX));
        localLinkedList.add(dy("device-brand", com.tencent.mm.protocal.d.soU));
        localLinkedList.add(dy("device-name", com.tencent.mm.protocal.d.DEVICE_NAME));
        localLinkedList.add(dy("uin", String.valueOf(l1)));
        if (!aq.isWifi(ae.getContext())) {
          break;
        }
        i = 3;
        localLinkedList.add(dy("network", String.valueOf(i)));
        localObject2 = ((c)com.tencent.mm.kernel.g.r(c.class)).awD();
        localObject1 = paramString1;
        paramString2 = str;
        paramList = localLinkedList;
        if (localObject2 == null) {
          break label467;
        }
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          localObject1 = paramString1;
          paramString2 = str;
          paramList = localLinkedList;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramString2 = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject2).next();
          localLinkedList.add(dy(Integer.toHexString(paramString2.field_key), String.valueOf(paramString2.field_dau)));
        }
      }
    }
    localObject1 = paramString2;
    paramString2 = paramString1;
    label467:
    this.lnd = paramString2;
    this.lne = ((String)localObject1);
    this.lnf.addAll(paramList);
    this.lnh = paramBoolean;
  }
  
  private static bxr dy(String paramString1, String paramString2)
  {
    bxr localbxr = new bxr();
    localbxr.key = paramString1;
    localbxr.value = paramString2;
    return localbxr;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "doScene");
    this.dmL = paramf;
    paramf = (ps)this.dmK.ecE.ecN;
    paramf.sNy = this.lnd;
    paramf.sNz = this.lne;
    paramf.sNA = this.lnf;
    a.1 local1;
    if (this.lnh)
    {
      local1 = new a.1(this, paramf);
      paramf = ae.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
      if (bk.bl(paramf)) {
        break label339;
      }
    }
    label339:
    for (;;)
    {
      try
      {
        Object localObject = new pt();
        ((pt)localObject).aH(Base64.decode(paramf.getBytes(), 0));
        if (((pt)localObject).sNB != null) {
          if (com.tencent.mm.loader.a.a.dON == null)
          {
            paramf = "";
            String str1 = "tinker_id_" + com.tencent.mm.loader.a.a.EP();
            String str2 = ae.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
            localObject = new com.tencent.mm.plugin.hp.d.b(((pt)localObject).sNB);
            y.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { ((com.tencent.mm.plugin.hp.d.b)localObject).lny, paramf, str2, str1 });
            if ((!bk.bl(((com.tencent.mm.plugin.hp.d.b)localObject).lny)) && (!((com.tencent.mm.plugin.hp.d.b)localObject).lny.equalsIgnoreCase(paramf)) && (!bk.bl(str1)) && (str1.equalsIgnoreCase(str2)))
            {
              local1.a(true, (com.tencent.mm.plugin.hp.d.b)localObject);
              return a(parame, this.dmK, this);
            }
          }
          else
          {
            paramf = "tinker_id_" + com.tencent.mm.loader.a.a.dON;
            continue;
          }
        }
        local1.a(false, null);
      }
      catch (Exception paramf)
      {
        y.printErrStackTrace("Tinker.TinkerUtils", paramf, "parse tinker update Response failed.", new Object[0]);
        h.nFQ.a(614L, 73L, 1L, false);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (pt)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      paramq = paramArrayOfByte.sNB;
      if (paramq != null) {
        if (!this.lnh) {}
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.hp.tinker.g.at(ae.getContext(), new String(Base64.encode(paramArrayOfByte.toByteArray(), 0)));
        com.tencent.mm.plugin.hp.tinker.g.E(ae.getContext(), 0);
        y.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
        paramq = new com.tencent.mm.plugin.hp.d.b(paramq);
        y.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
        new com.tencent.mm.plugin.hp.b.e(paramq).gN(this.lnh);
        y.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
        com.tencent.mm.plugin.hp.b.a.cZ(4, 0);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramArrayOfByte, "save node failed.", new Object[0]);
        h.nFQ.a(614L, 72L, 1L, false);
        continue;
      }
      y.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
      continue;
      if (paramString.equalsIgnoreCase("no baseid matched"))
      {
        com.tencent.mm.plugin.hp.b.a.cZ(1, 0);
        label235:
        if (this.lni == null) {
          break label400;
        }
        if (com.tencent.mm.loader.a.a.dON != null) {
          break label402;
        }
      }
      label400:
      label402:
      for (paramq = "";; paramq = "tinker_id_" + com.tencent.mm.loader.a.a.dON)
      {
        if ((bk.bl(this.lni.lny)) || (this.lni.lny.equalsIgnoreCase(paramq))) {
          break label423;
        }
        paramInt1 = ae.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
        if (paramInt1 < 4) {
          break label425;
        }
        com.tencent.mm.plugin.hp.tinker.g.at(ae.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.g.E(ae.getContext(), 0);
        y.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
        h.nFQ.a(614L, 74L, 1L, false);
        break;
        if (paramString.equalsIgnoreCase("no update for this patch"))
        {
          com.tencent.mm.plugin.hp.b.a.cZ(2, 0);
          break label235;
        }
        if (paramString.equalsIgnoreCase("no sutable patch available"))
        {
          com.tencent.mm.plugin.hp.b.a.cZ(3, 0);
          break label235;
        }
        com.tencent.mm.plugin.hp.b.a.cZ(5, 0);
        break label235;
        break;
      }
      label423:
      continue;
      label425:
      new com.tencent.mm.plugin.hp.b.e(this.lni).gN(this.lnh);
      h.nFQ.a(614L, 70L, 1L, false);
      paramInt1 += 1;
      com.tencent.mm.plugin.hp.tinker.g.E(ae.getContext(), paramInt1);
      y.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
      continue;
      y.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
      com.tencent.mm.plugin.hp.b.a.cZ(5, paramInt2);
    }
  }
  
  public final int getType()
  {
    return 922;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a
 * JD-Core Version:    0.7.0.1
 */