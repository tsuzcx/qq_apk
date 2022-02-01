package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.edr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static boolean vPu;
  private static List<a> vPv;
  
  static
  {
    AppMethodBeat.i(66011);
    vPu = false;
    vPv = new ArrayList();
    AppMethodBeat.o(66011);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(66008);
    ae.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", new Object[] { Boolean.valueOf(vPv.remove(parama)) });
    AppMethodBeat.o(66008);
  }
  
  public static void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66007);
    ae.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
      AppMethodBeat.o(66007);
      return;
    }
    cqm localcqm = new cqm();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IZE, null);
    if (!bu.isNullOrNil(str)) {}
    try
    {
      localcqm.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
      if (paramBoolean2)
      {
        if (parama != null) {
          parama.b(localcqm);
        }
        i = 1;
        if (((paramBoolean2) && (i == 0)) || (paramBoolean1))
        {
          if ((parama != null) && (!vPv.contains(parama))) {
            vPv.add(parama);
          }
          if (!vPu) {
            break label209;
          }
          ae.i("MicroMsg.QueryWeChatWalletManager", "is quering");
          if ((i == 0) && (!paramBoolean1)) {
            com.tencent.mm.plugin.report.service.g.yxI.dD(997, 1);
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
        ae.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", localIOException, "", new Object[0]);
        continue;
        label209:
        vPu = true;
        f.a("wallet_balance_version", new f.b()
        {
          public final void dr(Object paramAnonymousObject)
          {
            AppMethodBeat.i(66003);
            ae.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", new Object[] { paramAnonymousObject });
            long l = 0L;
            if ((paramAnonymousObject instanceof Long)) {
              l = ((Long)paramAnonymousObject).longValue();
            }
            j.a(l, this.vPw, this.vPx);
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
    public abstract void b(cqm paramcqm);
    
    public abstract void c(cqm paramcqm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */