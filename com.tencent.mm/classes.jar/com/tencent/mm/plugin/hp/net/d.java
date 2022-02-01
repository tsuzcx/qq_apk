package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.OnePlus;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  protected boolean DNb;
  private b DNc;
  
  public d()
  {
    this("", "", null, false);
  }
  
  public d(String paramString1, String paramString2, List<dhf> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private d(String paramString1, String paramString2, List<dhf> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117450);
    this.DNb = true;
    if (!paramBoolean)
    {
      paramString1 = com.tencent.mm.loader.j.a.aSy();
      paramString2 = com.tencent.mm.loader.j.a.aSz();
      paramList = e.eIb();
    }
    for (this.mScene = 1;; this.mScene = 0)
    {
      this.DMR = paramString1;
      this.DMS = paramString2;
      this.DMT.addAll(paramList);
      this.DNb = paramBoolean;
      if (!this.DNb) {
        break label300;
      }
      paramString1 = new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, b paramAnonymousb)
        {
          AppMethodBeat.i(117449);
          if ((paramAnonymousBoolean) && (paramAnonymousb != null))
          {
            d.a(d.this, paramAnonymousb);
            d.this.DMS = d.a(d.this).coY;
            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { d.a(d.this).coY, d.this.DMS });
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 71L, 1L, false);
            AppMethodBeat.o(117449);
            return;
          }
          paramAnonymousb = MMApplicationContext.getContext();
          String str = d.this.DMR;
          paramAnonymousb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
          com.tencent.mm.plugin.hp.tinker.h.bk(MMApplicationContext.getContext(), "");
          AppMethodBeat.o(117449);
        }
      };
      paramList = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
      if (Util.isNullOrNil(paramList)) {
        break label292;
      }
      try
      {
        paramString2 = new dhh();
        paramString2.parseFrom(Base64.decode(paramList.getBytes(), 0));
        if (paramString2.GIL == null) {
          break label292;
        }
        paramList = com.tencent.mm.loader.j.a.aSz();
        String str1 = com.tencent.mm.loader.j.a.aSy();
        String str2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
        paramString2 = new b(paramString2.TOs);
        Log.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramString2.coY, paramList, str2, str1 });
        if ((Util.isNullOrNil(paramString2.coY)) || (paramString2.coY.equalsIgnoreCase(paramList)) || (Util.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
          break label292;
        }
        paramString1.a(true, paramString2);
        AppMethodBeat.o(117450);
        return;
      }
      catch (Exception paramString2)
      {
        Log.printErrStackTrace("Tinker.TinkerUtils", paramString2, "parse tinker update Response failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 73L, 1L, false);
      }
    }
    label292:
    paramString1.a(false, null);
    label300:
    AppMethodBeat.o(117450);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(177772);
    if ((BuildInfo.TINKER_VERSION.equals("1.9.14.5-INTERNALv1")) && (((Huawei.ifHUAWEI()) && (Build.VERSION.SDK_INT == 24)) || ((OnePlus.isOnePlus()) && (Build.VERSION.SDK_INT > 28))))
    {
      Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
      this.callback = parami;
      AppMethodBeat.o(177772);
      return -1;
    }
    int i = super.doScene(paramg, parami);
    AppMethodBeat.o(177772);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117451);
    Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dhh)d.c.b(((com.tencent.mm.an.d)params).lBS);
      paramString = params.TOs;
      if (paramString != null)
      {
        if (this.DNb) {
          try
          {
            com.tencent.mm.plugin.hp.tinker.h.bk(MMApplicationContext.getContext(), new String(Base64.encode(params.toByteArray(), 0)));
            com.tencent.mm.plugin.hp.tinker.h.aA(MMApplicationContext.getContext(), 0);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
            paramString = new b(paramString);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
            new com.tencent.mm.plugin.hp.b.e(paramString).tm(this.DNb);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
            com.tencent.mm.plugin.hp.b.a.hR(4, 0);
            AppMethodBeat.o(117451);
            return;
          }
          catch (Exception params)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", params, "save node failed.", new Object[0]);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 72L, 1L, false);
            }
          }
        }
        Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
        AppMethodBeat.o(117451);
        return;
      }
      if (params.TOu == 1) {
        com.tencent.mm.plugin.hp.b.a.hR(1, 0);
      }
      while (this.DNc != null)
      {
        paramString = com.tencent.mm.loader.j.a.aSz();
        if ((!Util.isNullOrNil(this.DNc.coY)) && (!this.DNc.coY.equalsIgnoreCase(paramString)))
        {
          paramInt1 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
          if (paramInt1 >= 4)
          {
            com.tencent.mm.plugin.hp.tinker.h.bk(MMApplicationContext.getContext(), "");
            com.tencent.mm.plugin.hp.tinker.h.aA(MMApplicationContext.getContext(), 0);
            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 74L, 1L, false);
            AppMethodBeat.o(117451);
            return;
            if (params.TOu == 2) {
              com.tencent.mm.plugin.hp.b.a.hR(2, 0);
            } else if (params.TOu == 3) {
              com.tencent.mm.plugin.hp.b.a.hR(3, 0);
            } else if (params.TOu == 4) {
              com.tencent.mm.plugin.hp.b.a.hR(6, 0);
            } else if (params.TOu == 6) {
              Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
            } else {
              com.tencent.mm.plugin.hp.b.a.hR(5, 0);
            }
          }
          else
          {
            new com.tencent.mm.plugin.hp.b.e(this.DNc).tm(this.DNb);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 70L, 1L, false);
            paramInt1 += 1;
            com.tencent.mm.plugin.hp.tinker.h.aA(MMApplicationContext.getContext(), paramInt1);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
      }
      AppMethodBeat.o(117451);
      return;
    }
    Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
    com.tencent.mm.plugin.hp.b.a.hR(5, paramInt2);
    AppMethodBeat.o(117451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.d
 * JD-Core Version:    0.7.0.1
 */