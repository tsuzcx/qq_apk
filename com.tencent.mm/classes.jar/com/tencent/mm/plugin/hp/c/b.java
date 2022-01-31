package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.b.e;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  com.tencent.mm.plugin.hp.d.b nKA;
  private boolean nKz;
  
  public b()
  {
    this("", "", null, false);
  }
  
  public b(String paramString1, String paramString2, List<bjt> paramList)
  {
    this(paramString1, paramString2, paramList, true);
  }
  
  private b(String paramString1, String paramString2, List<bjt> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(90622);
    this.nKz = true;
    String str1;
    if (!paramBoolean)
    {
      str1 = "tinker_id_" + com.tencent.mm.loader.j.a.Uj();
      if (com.tencent.mm.loader.j.a.eQt == null) {
        paramString1 = "";
      }
    }
    for (;;)
    {
      paramList = bIj();
      this.mScene = 1;
      paramString2 = paramString1;
      label59:
      this.nKv = str1;
      this.nKw = paramString2;
      this.nKx.addAll(paramList);
      this.nKz = paramBoolean;
      if (this.nKz)
      {
        paramString2 = new b.1(this);
        paramString1 = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
        if (!bo.isNullOrNil(paramString1)) {
          try
          {
            paramList = new bjv();
            paramList.parseFrom(Base64.decode(paramString1.getBytes(), 0));
            if (paramList.pqD != null)
            {
              if (com.tencent.mm.loader.j.a.eQt == null) {}
              for (paramString1 = "";; paramString1 = "tinker_id_" + com.tencent.mm.loader.j.a.eQt)
              {
                str1 = "tinker_id_" + com.tencent.mm.loader.j.a.Uj();
                String str2 = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
                paramList = new com.tencent.mm.plugin.hp.d.b(paramList.xyk);
                ab.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[] { paramList.nKR, paramString1, str2, str1 });
                if ((bo.isNullOrNil(paramList.nKR)) || (paramList.nKR.equalsIgnoreCase(paramString1)) || (bo.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(str2))) {
                  break label383;
                }
                paramString2.a(true, paramList);
                AppMethodBeat.o(90622);
                return;
                paramString1 = "tinker_id_" + com.tencent.mm.loader.j.a.eQt;
                break;
                this.mScene = 0;
                str1 = paramString1;
                break label59;
              }
            }
            paramString2.a(false, null);
          }
          catch (Exception paramString1)
          {
            ab.printErrStackTrace("Tinker.TinkerUtils", paramString1, "parse tinker update Response failed.", new Object[0]);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 73L, 1L, false);
          }
        }
      }
    }
    label383:
    AppMethodBeat.o(90622);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90623);
    ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bjv)((com.tencent.mm.ai.b)paramq).fsW.fta;
      paramq = paramArrayOfByte.xyk;
      if (paramq != null) {
        if (!this.nKz) {}
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.hp.tinker.h.aB(ah.getContext(), new String(Base64.encode(paramArrayOfByte.toByteArray(), 0)));
        com.tencent.mm.plugin.hp.tinker.h.Q(ah.getContext(), 0);
        ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
        paramq = new com.tencent.mm.plugin.hp.d.b(paramq);
        ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
        new e(paramq).iv(this.nKz);
        ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
        com.tencent.mm.plugin.hp.b.a.ew(4, 0);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(90623);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", paramArrayOfByte, "save node failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 72L, 1L, false);
        continue;
      }
      ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
      continue;
      if (paramArrayOfByte.xym == 1)
      {
        com.tencent.mm.plugin.hp.b.a.ew(1, 0);
        label240:
        if (this.nKA == null) {
          break label439;
        }
        if (com.tencent.mm.loader.j.a.eQt != null) {
          break label441;
        }
      }
      label439:
      label441:
      for (paramq = "";; paramq = "tinker_id_" + com.tencent.mm.loader.j.a.eQt)
      {
        if ((bo.isNullOrNil(this.nKA.nKR)) || (this.nKA.nKR.equalsIgnoreCase(paramq))) {
          break label462;
        }
        paramInt1 = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
        if (paramInt1 < 4) {
          break label464;
        }
        com.tencent.mm.plugin.hp.tinker.h.aB(ah.getContext(), "");
        com.tencent.mm.plugin.hp.tinker.h.Q(ah.getContext(), 0);
        ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 74L, 1L, false);
        break;
        if (paramArrayOfByte.xym == 2)
        {
          com.tencent.mm.plugin.hp.b.a.ew(2, 0);
          break label240;
        }
        if (paramArrayOfByte.xym == 3)
        {
          com.tencent.mm.plugin.hp.b.a.ew(3, 0);
          break label240;
        }
        if (paramArrayOfByte.xym == 4)
        {
          com.tencent.mm.plugin.hp.b.a.ew(6, 0);
          break label240;
        }
        if (paramArrayOfByte.xym == 6)
        {
          ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
          break label240;
        }
        com.tencent.mm.plugin.hp.b.a.ew(5, 0);
        break label240;
        break;
      }
      label462:
      continue;
      label464:
      new e(this.nKA).iv(this.nKz);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 70L, 1L, false);
      paramInt1 += 1;
      com.tencent.mm.plugin.hp.tinker.h.Q(ah.getContext(), paramInt1);
      ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[] { Integer.valueOf(paramInt1) });
      continue;
      ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
      com.tencent.mm.plugin.hp.b.a.ew(5, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.b
 * JD-Core Version:    0.7.0.1
 */