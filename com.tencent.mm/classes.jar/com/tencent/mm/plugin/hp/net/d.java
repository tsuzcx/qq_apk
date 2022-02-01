package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  protected boolean uUy;
  com.tencent.mm.plugin.hp.d.b uUz;
  
  public d()
  {
    this("", "", null, false);
  }
  
  public d(String paramString1, String paramString2, List<chn> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private d(String paramString1, String paramString2, List<chn> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(117450);
    this.uUy = true;
    if (!paramBoolean)
    {
      paramString1 = com.tencent.mm.loader.j.a.arW();
      paramString2 = com.tencent.mm.loader.j.a.arX();
      paramList = e.dfk();
    }
    for (this.mScene = 1;; this.mScene = 0)
    {
      this.uUo = paramString1;
      this.uUp = paramString2;
      this.uUq.addAll(paramList);
      this.uUy = paramBoolean;
      if (!this.uUy) {
        break label300;
      }
      paramString1 = new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
        {
          AppMethodBeat.i(117449);
          if ((paramAnonymousBoolean) && (paramAnonymousb != null))
          {
            d.this.uUz = paramAnonymousb;
            d.this.uUp = d.this.uUz.nZN;
            ae.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { d.this.uUz.nZN, d.this.uUp });
            g.yxI.idkeyStat(614L, 71L, 1L, false);
            AppMethodBeat.o(117449);
            return;
          }
          paramAnonymousb = ak.getContext();
          String str = d.this.uUo;
          paramAnonymousb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
          h.aL(ak.getContext(), "");
          AppMethodBeat.o(117449);
        }
      };
      paramList = ak.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
      if (bu.isNullOrNil(paramList)) {
        break label292;
      }
      try
      {
        paramString2 = new chp();
        paramString2.parseFrom(Base64.decode(paramList.getBytes(), 0));
        if (paramString2.wTE == null) {
          break label292;
        }
        paramList = com.tencent.mm.loader.j.a.arX();
        String str1 = com.tencent.mm.loader.j.a.arW();
        String str2 = ak.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
        paramString2 = new com.tencent.mm.plugin.hp.d.b(paramString2.HtO);
        ae.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramString2.nZN, paramList, str2, str1 });
        if ((bu.isNullOrNil(paramString2.nZN)) || (paramString2.nZN.equalsIgnoreCase(paramList)) || (bu.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
          break label292;
        }
        paramString1.a(true, paramString2);
        AppMethodBeat.o(117450);
        return;
      }
      catch (Exception paramString2)
      {
        ae.printErrStackTrace("Tinker.TinkerUtils", paramString2, "parse tinker update Response failed.", new Object[0]);
        g.yxI.idkeyStat(614L, 73L, 1L, false);
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
    if ((j.TINKER_VERSION.equals("1.9.14.5-INTERNALv1")) && (((com.tencent.mm.sdk.h.a.fqj()) && (Build.VERSION.SDK_INT == 24)) || ((com.tencent.mm.sdk.h.d.fqs()) && (Build.VERSION.SDK_INT > 28))))
    {
      ae.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
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
    ae.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (chp)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      paramString = paramq.HtO;
      if (paramString != null)
      {
        if (this.uUy) {
          try
          {
            h.aL(ak.getContext(), new String(Base64.encode(paramq.toByteArray(), 0)));
            h.ac(ak.getContext(), 0);
            ae.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
            paramString = new com.tencent.mm.plugin.hp.d.b(paramString);
            ae.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
            new com.tencent.mm.plugin.hp.b.e(paramString).nB(this.uUy);
            ae.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
            com.tencent.mm.plugin.hp.b.a.gp(4, 0);
            AppMethodBeat.o(117451);
            return;
          }
          catch (Exception paramq)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramq, "save node failed.", new Object[0]);
              g.yxI.idkeyStat(614L, 72L, 1L, false);
            }
          }
        }
        ae.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
        AppMethodBeat.o(117451);
        return;
      }
      if (paramq.HtQ == 1) {
        com.tencent.mm.plugin.hp.b.a.gp(1, 0);
      }
      while (this.uUz != null)
      {
        paramString = com.tencent.mm.loader.j.a.arX();
        if ((!bu.isNullOrNil(this.uUz.nZN)) && (!this.uUz.nZN.equalsIgnoreCase(paramString)))
        {
          paramInt1 = ak.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
          if (paramInt1 >= 4)
          {
            h.aL(ak.getContext(), "");
            h.ac(ak.getContext(), 0);
            ae.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
            g.yxI.idkeyStat(614L, 74L, 1L, false);
            AppMethodBeat.o(117451);
            return;
            if (paramq.HtQ == 2) {
              com.tencent.mm.plugin.hp.b.a.gp(2, 0);
            } else if (paramq.HtQ == 3) {
              com.tencent.mm.plugin.hp.b.a.gp(3, 0);
            } else if (paramq.HtQ == 4) {
              com.tencent.mm.plugin.hp.b.a.gp(6, 0);
            } else if (paramq.HtQ == 6) {
              ae.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
            } else {
              com.tencent.mm.plugin.hp.b.a.gp(5, 0);
            }
          }
          else
          {
            new com.tencent.mm.plugin.hp.b.e(this.uUz).nB(this.uUy);
            g.yxI.idkeyStat(614L, 70L, 1L, false);
            paramInt1 += 1;
            h.ac(ak.getContext(), paramInt1);
            ae.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
      }
      AppMethodBeat.o(117451);
      return;
    }
    ae.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
    com.tencent.mm.plugin.hp.b.a.gp(5, paramInt2);
    AppMethodBeat.o(117451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.d
 * JD-Core Version:    0.7.0.1
 */