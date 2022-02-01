package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.c.c.a;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  private boolean sym;
  com.tencent.mm.plugin.hp.c.b syn;
  
  public c()
  {
    this("", "", null, false);
  }
  
  public c(String paramString1, String paramString2, List<bxh> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private c(String paramString1, String paramString2, List<bxh> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117450);
    this.sym = true;
    if (!paramBoolean)
    {
      paramString1 = com.tencent.mm.loader.j.a.ahU();
      paramString2 = com.tencent.mm.loader.j.a.ahV();
      paramList = d.cGb();
    }
    for (this.mScene = 1;; this.mScene = 0)
    {
      this.syd = paramString1;
      this.sye = paramString2;
      this.syf.addAll(paramList);
      this.sym = paramBoolean;
      if (!this.sym) {
        break label300;
      }
      paramString1 = new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, com.tencent.mm.plugin.hp.c.b paramAnonymousb)
        {
          AppMethodBeat.i(117449);
          if ((paramAnonymousBoolean) && (paramAnonymousb != null))
          {
            c.this.syn = paramAnonymousb;
            c.this.sye = c.this.syn.syJ;
            ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { c.this.syn.syJ, c.this.sye });
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 71L, 1L, false);
            AppMethodBeat.o(117449);
            return;
          }
          paramAnonymousb = aj.getContext();
          String str = c.this.syd;
          paramAnonymousb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
          com.tencent.mm.plugin.hp.tinker.h.aF(aj.getContext(), "");
          AppMethodBeat.o(117449);
        }
      };
      paramList = aj.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
      if (bt.isNullOrNil(paramList)) {
        break label292;
      }
      try
      {
        paramString2 = new bxj();
        paramString2.parseFrom(Base64.decode(paramList.getBytes(), 0));
        if (paramString2.upD == null) {
          break label292;
        }
        paramList = com.tencent.mm.loader.j.a.ahV();
        String str1 = com.tencent.mm.loader.j.a.ahU();
        String str2 = aj.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
        paramString2 = new com.tencent.mm.plugin.hp.c.b(paramString2.DTR);
        ad.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramString2.syJ, paramList, str2, str1 });
        if ((bt.isNullOrNil(paramString2.syJ)) || (paramString2.syJ.equalsIgnoreCase(paramList)) || (bt.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
          break label292;
        }
        paramString1.a(true, paramString2);
        AppMethodBeat.o(117450);
        return;
      }
      catch (Exception paramString2)
      {
        ad.printErrStackTrace("Tinker.TinkerUtils", paramString2, "parse tinker update Response failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 73L, 1L, false);
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
    if ((com.tencent.mm.sdk.platformtools.h.TINKER_VERSION.equals("1.9.14.5-INTERNALv1")) && (((com.tencent.mm.sdk.h.a.eHj()) && (Build.VERSION.SDK_INT == 24)) || ((com.tencent.mm.sdk.h.d.eHs()) && (Build.VERSION.SDK_INT > 28))))
    {
      ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
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
    ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bxj)((com.tencent.mm.al.b)paramq).gUT.gUX;
      paramq = paramArrayOfByte.DTR;
      if (paramq != null) {
        if (!this.sym) {}
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.hp.tinker.h.aF(aj.getContext(), new String(Base64.encode(paramArrayOfByte.toByteArray(), 0)));
        com.tencent.mm.plugin.hp.tinker.h.T(aj.getContext(), 0);
        ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
        paramq = new com.tencent.mm.plugin.hp.c.b(paramq);
        ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
        new com.tencent.mm.plugin.hp.b.e(paramq).mk(this.sym);
        ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
        com.tencent.mm.plugin.hp.b.a.fR(4, 0);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(117451);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramArrayOfByte, "save node failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 72L, 1L, false);
        continue;
      }
      ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
      continue;
      if (paramArrayOfByte.DTT == 1) {
        com.tencent.mm.plugin.hp.b.a.fR(1, 0);
      }
      for (;;)
      {
        if (this.syn == null) {
          break label436;
        }
        paramq = com.tencent.mm.loader.j.a.ahV();
        if ((bt.isNullOrNil(this.syn.syJ)) || (this.syn.syJ.equalsIgnoreCase(paramq))) {
          break;
        }
        paramInt1 = aj.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
        if (paramInt1 < 4) {
          break label438;
        }
        com.tencent.mm.plugin.hp.tinker.h.aF(aj.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.T(aj.getContext(), 0);
        ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 74L, 1L, false);
        break;
        if (paramArrayOfByte.DTT == 2) {
          com.tencent.mm.plugin.hp.b.a.fR(2, 0);
        } else if (paramArrayOfByte.DTT == 3) {
          com.tencent.mm.plugin.hp.b.a.fR(3, 0);
        } else if (paramArrayOfByte.DTT == 4) {
          com.tencent.mm.plugin.hp.b.a.fR(6, 0);
        } else if (paramArrayOfByte.DTT == 6) {
          ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
        } else {
          com.tencent.mm.plugin.hp.b.a.fR(5, 0);
        }
      }
      label436:
      continue;
      label438:
      new com.tencent.mm.plugin.hp.b.e(this.syn).mk(this.sym);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 70L, 1L, false);
      paramInt1 += 1;
      com.tencent.mm.plugin.hp.tinker.h.T(aj.getContext(), paramInt1);
      ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
      continue;
      ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
      com.tencent.mm.plugin.hp.b.a.fR(5, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */