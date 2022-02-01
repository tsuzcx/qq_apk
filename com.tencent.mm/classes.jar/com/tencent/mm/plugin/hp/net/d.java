package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.hp.b.c.a;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzq;
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
  protected boolean JEp;
  private com.tencent.mm.plugin.hp.b.b JEq;
  
  public d()
  {
    this("", "", null, false);
  }
  
  public d(String paramString1, String paramString2, List<dzo> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private d(String paramString1, String paramString2, List<dzo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117450);
    this.JEp = true;
    if (!paramBoolean)
    {
      paramString1 = com.tencent.mm.loader.i.a.bmm();
      paramString2 = com.tencent.mm.loader.i.a.bmn();
      paramList = e.fPU();
      this.mScene = 1;
      this.JEf = paramString1;
      this.JEg = paramString2;
      this.JEh.addAll(paramList);
      this.JEp = paramBoolean;
      if (this.JEp)
      {
        paramString1 = new c.a()
        {
          public final void a(boolean paramAnonymousBoolean, com.tencent.mm.plugin.hp.b.b paramAnonymousb)
          {
            AppMethodBeat.i(117449);
            if ((paramAnonymousBoolean) && (paramAnonymousb != null))
            {
              d.a(d.this, paramAnonymousb);
              d.this.JEg = d.a(d.this).egJ;
              Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { d.a(d.this).egJ, d.this.JEg });
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 71L, 1L, false);
              AppMethodBeat.o(117449);
              return;
            }
            paramAnonymousb = MMApplicationContext.getContext();
            String str = d.this.JEf;
            paramAnonymousb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
            com.tencent.mm.plugin.hp.tinker.h.bm(MMApplicationContext.getContext(), "");
            AppMethodBeat.o(117449);
          }
        };
        paramList = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
        if (Util.isNullOrNil(paramList)) {
          break label343;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new dzq();
        paramString2.parseFrom(Base64.decode(paramList.getBytes(), 0));
        if (paramString2.ycW == null) {
          break label343;
        }
        paramList = com.tencent.mm.loader.i.a.bmn();
        String str1 = com.tencent.mm.loader.i.a.bmm();
        String str2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
        paramString2 = new com.tencent.mm.plugin.hp.b.b(paramString2.abeO);
        Log.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramString2.egJ, paramList, str2, str1 });
        if ((Util.isNullOrNil(paramString2.egJ)) || (paramString2.egJ.equalsIgnoreCase(paramList)) || (Util.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
          break label343;
        }
        paramString1.a(true, paramString2);
        com.tencent.mm.plugin.report.service.h.OAn.b(24470, new Object[] { this.type, "", Integer.valueOf(this.mScene), Boolean.FALSE });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1821, 1);
        AppMethodBeat.o(117450);
        return;
      }
      catch (Exception paramString2)
      {
        Log.printErrStackTrace("Tinker.TinkerUtils", paramString2, "parse tinker update Response failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 73L, 1L, false);
      }
      this.mScene = 0;
      break;
      label343:
      paramString1.a(false, null);
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(177772);
    if ((BuildInfo.TINKER_VERSION.equals("1.9.14.5-INTERNALv1")) && (((Huawei.ifHUAWEI()) && (Build.VERSION.SDK_INT == 24)) || ((OnePlus.isOnePlus()) && (Build.VERSION.SDK_INT > 28))))
    {
      Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
      this.callback = paramh;
      AppMethodBeat.o(177772);
      return -1;
    }
    int i = super.doScene(paramg, paramh);
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
      params = (dzq)c.c.b(((c)params).otC);
      paramString = params.abeO;
      if (paramString != null)
      {
        if (this.JEp) {
          try
          {
            com.tencent.mm.plugin.hp.tinker.h.bm(MMApplicationContext.getContext(), new String(Base64.encode(params.toByteArray(), 0)));
            com.tencent.mm.plugin.hp.tinker.h.aN(MMApplicationContext.getContext(), 0);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
            paramString = new com.tencent.mm.plugin.hp.b.b(paramString);
            com.tencent.mm.plugin.hp.model.b.a(paramString);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
            new com.tencent.mm.plugin.hp.model.e(paramString).xx(this.JEp);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
            com.tencent.mm.plugin.hp.model.a.jv(4, 0);
            AppMethodBeat.o(117451);
            return;
          }
          catch (Exception params)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", params, "save node failed.", new Object[0]);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 72L, 1L, false);
            }
          }
        }
        Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
        AppMethodBeat.o(117451);
        return;
      }
      if (params.abeQ == 1) {
        com.tencent.mm.plugin.hp.model.a.jv(1, 0);
      }
      while (this.JEq != null)
      {
        paramString = com.tencent.mm.loader.i.a.bmn();
        if ((!Util.isNullOrNil(this.JEq.egJ)) && (!this.JEq.egJ.equalsIgnoreCase(paramString)))
        {
          paramInt1 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
          if (paramInt1 >= 4)
          {
            com.tencent.mm.plugin.hp.tinker.h.bm(MMApplicationContext.getContext(), "");
            com.tencent.mm.plugin.hp.tinker.h.aN(MMApplicationContext.getContext(), 0);
            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 74L, 1L, false);
            AppMethodBeat.o(117451);
            return;
            if (params.abeQ == 2) {
              com.tencent.mm.plugin.hp.model.a.jv(2, 0);
            } else if (params.abeQ == 3) {
              com.tencent.mm.plugin.hp.model.a.jv(3, 0);
            } else if (params.abeQ == 4) {
              com.tencent.mm.plugin.hp.model.a.jv(6, 0);
            } else if (params.abeQ == 6) {
              Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
            } else {
              com.tencent.mm.plugin.hp.model.a.jv(5, 0);
            }
          }
          else
          {
            com.tencent.mm.plugin.hp.model.b.a(this.JEq);
            new com.tencent.mm.plugin.hp.model.e(this.JEq).xx(this.JEp);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 70L, 1L, false);
            paramInt1 += 1;
            com.tencent.mm.plugin.hp.tinker.h.aN(MMApplicationContext.getContext(), paramInt1);
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
      }
      AppMethodBeat.o(117451);
      return;
    }
    Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
    com.tencent.mm.plugin.hp.model.a.jv(5, paramInt2);
    AppMethodBeat.o(117451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.d
 * JD-Core Version:    0.7.0.1
 */