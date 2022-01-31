package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cwg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i
{
  private static boolean oxS;
  private static List<i.a> oxT;
  
  static
  {
    AppMethodBeat.i(43115);
    oxS = false;
    oxT = new ArrayList();
    AppMethodBeat.o(43115);
  }
  
  public static void a(i.a parama)
  {
    AppMethodBeat.i(43113);
    ab.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", new Object[] { Boolean.valueOf(oxT.remove(parama)) });
    AppMethodBeat.o(43113);
  }
  
  public static void a(i.a parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(142108);
    ab.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!g.RG())
    {
      ab.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
      AppMethodBeat.o(142108);
      return;
    }
    i = j;
    String str;
    if (paramBoolean2)
    {
      str = (String)g.RL().Ru().get(ac.a.yLk, null);
      i = j;
      if (bo.isNullOrNil(str)) {}
    }
    for (;;)
    {
      try
      {
        cjf localcjf = new cjf();
        localcjf.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
        if (parama != null) {}
        ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", localIOException1, "", new Object[0]);
      }
      catch (IOException localIOException1)
      {
        try
        {
          parama.a(localcjf);
          i = 1;
          if (((paramBoolean2) && (i == 0)) || (paramBoolean1))
          {
            if ((parama != null) && (!oxT.contains(parama))) {
              oxT.add(parama);
            }
            if (!oxS) {
              break label219;
            }
            ab.i("MicroMsg.QueryWeChatWalletManager", "is quering");
            if ((i == 0) && (!paramBoolean1)) {
              h.qsU.cT(997, 1);
            }
          }
          AppMethodBeat.o(142108);
          return;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            i = 1;
          }
        }
        localIOException1 = localIOException1;
        i = 0;
      }
      continue;
      label219:
      oxS = true;
      com.tencent.mm.wallet_core.ui.e.a("wallet_balance_version", new i.1(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */