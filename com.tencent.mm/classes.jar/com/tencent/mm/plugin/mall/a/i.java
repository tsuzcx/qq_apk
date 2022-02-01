package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  private static boolean uAL;
  private static List<a> uAM;
  
  static
  {
    AppMethodBeat.i(66011);
    uAL = false;
    uAM = new ArrayList();
    AppMethodBeat.o(66011);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(66008);
    ac.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", new Object[] { Boolean.valueOf(uAM.remove(parama)) });
    AppMethodBeat.o(66008);
  }
  
  public static void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66007);
    ac.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
      AppMethodBeat.o(66007);
      return;
    }
    cks localcks = new cks();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GSz, null);
    if (!bs.isNullOrNil(str)) {}
    try
    {
      localcks.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
      if (paramBoolean2)
      {
        if (parama != null) {
          parama.b(localcks);
        }
        i = 1;
        if (((paramBoolean2) && (i == 0)) || (paramBoolean1))
        {
          if ((parama != null) && (!uAM.contains(parama))) {
            uAM.add(parama);
          }
          if (!uAL) {
            break label209;
          }
          ac.i("MicroMsg.QueryWeChatWalletManager", "is quering");
          if ((i == 0) && (!paramBoolean1)) {
            h.wUl.dB(997, 1);
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
        ac.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", localIOException, "", new Object[0]);
        continue;
        label209:
        uAL = true;
        e.a("wallet_balance_version", new e.b()
        {
          public final void dn(Object paramAnonymousObject)
          {
            AppMethodBeat.i(66003);
            ac.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", new Object[] { paramAnonymousObject });
            long l = 0L;
            if ((paramAnonymousObject instanceof Long)) {
              l = ((Long)paramAnonymousObject).longValue();
            }
            i.a(l, this.uAN, this.uAO);
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
    public abstract void b(cks paramcks);
    
    public abstract void c(cks paramcks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */