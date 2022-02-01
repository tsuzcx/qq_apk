package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.c.c.a;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  private boolean tGc;
  com.tencent.mm.plugin.hp.c.b tGd;
  
  public d()
  {
    this("", "", null, false);
  }
  
  public d(String paramString1, String paramString2, List<ccc> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private d(String paramString1, String paramString2, List<ccc> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117450);
    this.tGc = true;
    if (!paramBoolean)
    {
      paramString1 = com.tencent.mm.loader.j.a.aoU();
      paramString2 = com.tencent.mm.loader.j.a.aoV();
      paramList = e.cTl();
    }
    for (this.mScene = 1;; this.mScene = 0)
    {
      this.tFS = paramString1;
      this.tFT = paramString2;
      this.tFU.addAll(paramList);
      this.tGc = paramBoolean;
      if (!this.tGc) {
        break label300;
      }
      paramString1 = new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, com.tencent.mm.plugin.hp.c.b paramAnonymousb)
        {
          AppMethodBeat.i(117449);
          if ((paramAnonymousBoolean) && (paramAnonymousb != null))
          {
            d.this.tGd = paramAnonymousb;
            d.this.tFT = d.this.tGd.ntl;
            ac.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { d.this.tGd.ntl, d.this.tFT });
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 71L, 1L, false);
            AppMethodBeat.o(117449);
            return;
          }
          paramAnonymousb = ai.getContext();
          String str = d.this.tFS;
          paramAnonymousb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
          com.tencent.mm.plugin.hp.tinker.h.aG(ai.getContext(), "");
          AppMethodBeat.o(117449);
        }
      };
      paramList = ai.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
      if (bs.isNullOrNil(paramList)) {
        break label292;
      }
      try
      {
        paramString2 = new cce();
        paramString2.parseFrom(Base64.decode(paramList.getBytes(), 0));
        if (paramString2.vyz == null) {
          break label292;
        }
        paramList = com.tencent.mm.loader.j.a.aoV();
        String str1 = com.tencent.mm.loader.j.a.aoU();
        String str2 = ai.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
        paramString2 = new com.tencent.mm.plugin.hp.c.b(paramString2.FqE);
        ac.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramString2.ntl, paramList, str2, str1 });
        if ((bs.isNullOrNil(paramString2.ntl)) || (paramString2.ntl.equalsIgnoreCase(paramList)) || (bs.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
          break label292;
        }
        paramString1.a(true, paramString2);
        AppMethodBeat.o(117450);
        return;
      }
      catch (Exception paramString2)
      {
        ac.printErrStackTrace("Tinker.TinkerUtils", paramString2, "parse tinker update Response failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 73L, 1L, false);
      }
    }
    label292:
    paramString1.a(false, null);
    label300:
    AppMethodBeat.o(117450);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(177772);
    if ((com.tencent.mm.sdk.platformtools.h.TINKER_VERSION.equals("1.9.14.5-INTERNALv1")) && (((com.tencent.mm.sdk.h.a.eWE()) && (Build.VERSION.SDK_INT == 24)) || ((com.tencent.mm.sdk.h.d.eWN()) && (Build.VERSION.SDK_INT > 28))))
    {
      ac.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
      this.callback = paramg;
      AppMethodBeat.o(177772);
      return -1;
    }
    int i = super.doScene(parame, paramg);
    AppMethodBeat.o(177772);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117451);
    ac.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (cce)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      paramq = paramArrayOfByte.FqE;
      if (paramq != null) {
        if (!this.tGc) {}
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.hp.tinker.h.aG(ai.getContext(), new String(Base64.encode(paramArrayOfByte.toByteArray(), 0)));
        com.tencent.mm.plugin.hp.tinker.h.Z(ai.getContext(), 0);
        ac.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
        paramq = new com.tencent.mm.plugin.hp.c.b(paramq);
        ac.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
        new com.tencent.mm.plugin.hp.b.e(paramq).nd(this.tGc);
        ac.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
        com.tencent.mm.plugin.hp.b.a.fY(4, 0);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(117451);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ac.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramArrayOfByte, "save node failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 72L, 1L, false);
        continue;
      }
      ac.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
      continue;
      if (paramArrayOfByte.FqG == 1) {
        com.tencent.mm.plugin.hp.b.a.fY(1, 0);
      }
      for (;;)
      {
        if (this.tGd == null) {
          break label436;
        }
        paramq = com.tencent.mm.loader.j.a.aoV();
        if ((bs.isNullOrNil(this.tGd.ntl)) || (this.tGd.ntl.equalsIgnoreCase(paramq))) {
          break;
        }
        paramInt1 = ai.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
        if (paramInt1 < 4) {
          break label438;
        }
        com.tencent.mm.plugin.hp.tinker.h.aG(ai.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.Z(ai.getContext(), 0);
        ac.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 74L, 1L, false);
        break;
        if (paramArrayOfByte.FqG == 2) {
          com.tencent.mm.plugin.hp.b.a.fY(2, 0);
        } else if (paramArrayOfByte.FqG == 3) {
          com.tencent.mm.plugin.hp.b.a.fY(3, 0);
        } else if (paramArrayOfByte.FqG == 4) {
          com.tencent.mm.plugin.hp.b.a.fY(6, 0);
        } else if (paramArrayOfByte.FqG == 6) {
          ac.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
        } else {
          com.tencent.mm.plugin.hp.b.a.fY(5, 0);
        }
      }
      label436:
      continue;
      label438:
      new com.tencent.mm.plugin.hp.b.e(this.tGd).nd(this.tGc);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 70L, 1L, false);
      paramInt1 += 1;
      com.tencent.mm.plugin.hp.tinker.h.Z(ai.getContext(), paramInt1);
      ac.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
      continue;
      ac.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
      com.tencent.mm.plugin.hp.b.a.fY(5, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.d
 * JD-Core Version:    0.7.0.1
 */