package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.exz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
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
  private static boolean zjy;
  private static List<a> zjz;
  
  static
  {
    AppMethodBeat.i(66011);
    zjy = false;
    zjz = new ArrayList();
    AppMethodBeat.o(66011);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(66008);
    Log.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", new Object[] { Boolean.valueOf(zjz.remove(parama)) });
    AppMethodBeat.o(66008);
  }
  
  public static void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66007);
    Log.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
      AppMethodBeat.o(66007);
      return;
    }
    dil localdil = new dil();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.Oij, null);
    if (!Util.isNullOrNil(str)) {}
    try
    {
      localdil.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
      if (paramBoolean2)
      {
        if (parama != null) {
          parama.b(localdil);
        }
        i = 1;
        if (((paramBoolean2) && (i == 0)) || (paramBoolean1))
        {
          if ((parama != null) && (!zjz.contains(parama))) {
            zjz.add(parama);
          }
          if (!zjy) {
            break label209;
          }
          Log.i("MicroMsg.QueryWeChatWalletManager", "is quering");
          if ((i == 0) && (!paramBoolean1)) {
            h.CyF.dN(997, 1);
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
        zjy = true;
        f.a("wallet_balance_version", new f.b()
        {
          public final void dy(Object paramAnonymousObject)
          {
            AppMethodBeat.i(66003);
            Log.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", new Object[] { paramAnonymousObject });
            long l = 0L;
            if ((paramAnonymousObject instanceof Long)) {
              l = ((Long)paramAnonymousObject).longValue();
            }
            j.a(l, this.zjA, this.zjB);
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
    public abstract void b(dil paramdil);
    
    public abstract void c(dil paramdil);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */