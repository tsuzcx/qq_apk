package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static boolean vDq;
  private static List<a> vDr;
  
  static
  {
    AppMethodBeat.i(66011);
    vDq = false;
    vDr = new ArrayList();
    AppMethodBeat.o(66011);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(66008);
    ad.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", new Object[] { Boolean.valueOf(vDr.remove(parama)) });
    AppMethodBeat.o(66008);
  }
  
  public static void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66007);
    ad.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
      AppMethodBeat.o(66007);
      return;
    }
    cps localcps = new cps();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.IFe, null);
    if (!bt.isNullOrNil(str)) {}
    try
    {
      localcps.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
      if (paramBoolean2)
      {
        if (parama != null) {
          parama.b(localcps);
        }
        i = 1;
        if (((paramBoolean2) && (i == 0)) || (paramBoolean1))
        {
          if ((parama != null) && (!vDr.contains(parama))) {
            vDr.add(parama);
          }
          if (!vDq) {
            break label209;
          }
          ad.i("MicroMsg.QueryWeChatWalletManager", "is quering");
          if ((i == 0) && (!paramBoolean1)) {
            com.tencent.mm.plugin.report.service.g.yhR.dD(997, 1);
          }
        }
        AppMethodBeat.o(66007);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", localIOException, "", new Object[0]);
        continue;
        label209:
        vDq = true;
        e.a("wallet_balance_version", new e.b()
        {
          public final void dq(Object paramAnonymousObject)
          {
            AppMethodBeat.i(66003);
            ad.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", new Object[] { paramAnonymousObject });
            long l = 0L;
            if ((paramAnonymousObject instanceof Long)) {
              l = ((Long)paramAnonymousObject).longValue();
            }
            j.a(l, this.vDs, this.vDt);
            AppMethodBeat.o(66003);
          }
        });
        continue;
        int i = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(cps paramcps);
    
    public abstract void c(cps paramcps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */