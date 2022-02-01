package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  protected boolean uIL;
  com.tencent.mm.plugin.hp.d.b uIM;
  
  public d()
  {
    this("", "", null, false);
  }
  
  public d(String paramString1, String paramString2, List<cgt> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private d(String paramString1, String paramString2, List<cgt> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117450);
    this.uIL = true;
    if (!paramBoolean)
    {
      paramString1 = com.tencent.mm.loader.j.a.arH();
      paramString2 = com.tencent.mm.loader.j.a.arI();
      paramList = e.dcs();
    }
    for (this.mScene = 1;; this.mScene = 0)
    {
      this.uIB = paramString1;
      this.uIC = paramString2;
      this.uID.addAll(paramList);
      this.uIL = paramBoolean;
      if (!this.uIL) {
        break label300;
      }
      paramString1 = new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
        {
          AppMethodBeat.i(117449);
          if ((paramAnonymousBoolean) && (paramAnonymousb != null))
          {
            d.this.uIM = paramAnonymousb;
            d.this.uIC = d.this.uIM.nUh;
            ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { d.this.uIM.nUh, d.this.uIC });
            g.yhR.idkeyStat(614L, 71L, 1L, false);
            AppMethodBeat.o(117449);
            return;
          }
          paramAnonymousb = aj.getContext();
          String str = d.this.uIB;
          paramAnonymousb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
          h.aJ(aj.getContext(), "");
          AppMethodBeat.o(117449);
        }
      };
      paramList = aj.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
      if (bt.isNullOrNil(paramList)) {
        break label292;
      }
      try
      {
        paramString2 = new cgv();
        paramString2.parseFrom(Base64.decode(paramList.getBytes(), 0));
        if (paramString2.wDT == null) {
          break label292;
        }
        paramList = com.tencent.mm.loader.j.a.arI();
        String str1 = com.tencent.mm.loader.j.a.arH();
        String str2 = aj.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
        paramString2 = new com.tencent.mm.plugin.hp.d.b(paramString2.Hao);
        ad.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramString2.nUh, paramList, str2, str1 });
        if ((bt.isNullOrNil(paramString2.nUh)) || (paramString2.nUh.equalsIgnoreCase(paramList)) || (bt.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
          break label292;
        }
        paramString1.a(true, paramString2);
        AppMethodBeat.o(117450);
        return;
      }
      catch (Exception paramString2)
      {
        ad.printErrStackTrace("Tinker.TinkerUtils", paramString2, "parse tinker update Response failed.", new Object[0]);
        g.yhR.idkeyStat(614L, 73L, 1L, false);
      }
    }
    label292:
    paramString1.a(false, null);
    label300:
    AppMethodBeat.o(117450);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(177772);
    if ((i.TINKER_VERSION.equals("1.9.14.5-INTERNALv1")) && (((com.tencent.mm.sdk.h.a.fmo()) && (Build.VERSION.SDK_INT == 24)) || ((com.tencent.mm.sdk.h.d.fmx()) && (Build.VERSION.SDK_INT > 28))))
    {
      ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
      this.callback = paramf;
      AppMethodBeat.o(177772);
      return -1;
    }
    int i = super.doScene(parame, paramf);
    AppMethodBeat.o(177772);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117451);
    ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cgv)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      paramString = paramq.Hao;
      if (paramString != null)
      {
        if (this.uIL) {
          try
          {
            h.aJ(aj.getContext(), new String(Base64.encode(paramq.toByteArray(), 0)));
            h.ac(aj.getContext(), 0);
            ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
            paramString = new com.tencent.mm.plugin.hp.d.b(paramString);
            ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
            new com.tencent.mm.plugin.hp.b.e(paramString).nx(this.uIL);
            ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
            com.tencent.mm.plugin.hp.b.a.gp(4, 0);
            AppMethodBeat.o(117451);
            return;
          }
          catch (Exception paramq)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramq, "save node failed.", new Object[0]);
              g.yhR.idkeyStat(614L, 72L, 1L, false);
            }
          }
        }
        ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
        AppMethodBeat.o(117451);
        return;
      }
      if (paramq.Haq == 1) {
        com.tencent.mm.plugin.hp.b.a.gp(1, 0);
      }
      while (this.uIM != null)
      {
        paramString = com.tencent.mm.loader.j.a.arI();
        if ((!bt.isNullOrNil(this.uIM.nUh)) && (!this.uIM.nUh.equalsIgnoreCase(paramString)))
        {
          paramInt1 = aj.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
          if (paramInt1 >= 4)
          {
            h.aJ(aj.getContext(), "");
            h.ac(aj.getContext(), 0);
            ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
            g.yhR.idkeyStat(614L, 74L, 1L, false);
            AppMethodBeat.o(117451);
            return;
            if (paramq.Haq == 2) {
              com.tencent.mm.plugin.hp.b.a.gp(2, 0);
            } else if (paramq.Haq == 3) {
              com.tencent.mm.plugin.hp.b.a.gp(3, 0);
            } else if (paramq.Haq == 4) {
              com.tencent.mm.plugin.hp.b.a.gp(6, 0);
            } else if (paramq.Haq == 6) {
              ad.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
            } else {
              com.tencent.mm.plugin.hp.b.a.gp(5, 0);
            }
          }
          else
          {
            new com.tencent.mm.plugin.hp.b.e(this.uIM).nx(this.uIL);
            g.yhR.idkeyStat(614L, 70L, 1L, false);
            paramInt1 += 1;
            h.ac(aj.getContext(), paramInt1);
            ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
      }
      AppMethodBeat.o(117451);
      return;
    }
    ad.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
    com.tencent.mm.plugin.hp.b.a.gp(5, paramInt2);
    AppMethodBeat.o(117451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.d
 * JD-Core Version:    0.7.0.1
 */