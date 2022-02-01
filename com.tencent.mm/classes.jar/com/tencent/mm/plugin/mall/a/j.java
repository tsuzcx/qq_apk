package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.eky;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.gfc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.i.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static boolean KJn;
  private static List<a> KJo;
  
  static
  {
    AppMethodBeat.i(66011);
    KJn = false;
    KJo = new ArrayList();
    AppMethodBeat.o(66011);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(66008);
    Log.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", new Object[] { Boolean.valueOf(KJo.remove(parama)) });
    AppMethodBeat.o(66008);
  }
  
  public static void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66007);
    Log.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
      AppMethodBeat.o(66007);
      return;
    }
    eky localeky = new eky();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acYk, null);
    if (!Util.isNullOrNil(str)) {}
    try
    {
      localeky.parseFrom(str.getBytes(org.apache.commons.b.a.ISO_8859_1));
      if (paramBoolean2)
      {
        if (parama != null) {
          parama.b(localeky);
        }
        i = 1;
        if (((paramBoolean2) && (i == 0)) || (paramBoolean1))
        {
          if ((parama != null) && (!KJo.contains(parama))) {
            KJo.add(parama);
          }
          if (!KJn) {
            break label209;
          }
          Log.i("MicroMsg.QueryWeChatWalletManager", "is quering");
          if ((i == 0) && (!paramBoolean1)) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(997, 1);
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
        Log.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", localIOException, "", new Object[0]);
        continue;
        label209:
        KJn = true;
        i.a("wallet_balance_version", new i.b()
        {
          public final void fS(Object paramAnonymousObject)
          {
            AppMethodBeat.i(66003);
            Log.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", new Object[] { paramAnonymousObject });
            long l = 0L;
            if ((paramAnonymousObject instanceof Long)) {
              l = ((Long)paramAnonymousObject).longValue();
            }
            j.a(l, this.KJp, j.this);
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
    public abstract void b(eky parameky);
    
    public abstract void c(eky parameky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */