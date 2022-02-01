package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final com.tencent.mm.hellhoundlib.a.c qqn;
  private static volatile boolean qqo;
  
  static
  {
    AppMethodBeat.i(169369);
    qqn = new com.tencent.mm.hellhoundlib.a.c()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184386);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(220, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(184386);
      }
      
      public final void f(String paramAnonymousString, Object paramAnonymousObject) {}
    };
    qqo = false;
    AppMethodBeat.o(169369);
  }
  
  public static boolean abG(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void abH(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZX(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    ac.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, qqn);
    AppMethodBeat.o(169363);
  }
  
  public static void abI(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZX(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().Cg(221);
    AppMethodBeat.o(169364);
  }
  
  public static void ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(169367);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      AppMethodBeat.o(169367);
      return;
    }
    ac.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler, curSession: %s, %s", new Object[] { localccs.sessionId, paramString });
    if (abG(localccs.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString))
      {
        if (!qqo)
        {
          qqo = true;
          d(localccs, str, paramLong);
          AppMethodBeat.o(169367);
          return;
        }
        qqo = false;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(localccs, paramLong);
        AppMethodBeat.o(169367);
        return;
      }
      d(localccs, str, paramLong);
    }
    AppMethodBeat.o(169367);
  }
  
  public static void clj()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, qqn);
    AppMethodBeat.o(169365);
  }
  
  private static void d(ccs paramccs, String paramString, long paramLong)
  {
    AppMethodBeat.i(169368);
    if ((paramccs == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(169368);
      return;
    }
    if (abG(paramccs.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.c(paramccs, paramString, paramLong);
    }
    AppMethodBeat.o(169368);
  }
  
  public static void tg(long paramLong)
  {
    AppMethodBeat.i(184387);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.e("ScanSessionHandler", "HABBYGE-MALI, baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    ac.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localccs.sessionId });
    if (abG(localccs.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(localccs, paramLong);
    }
    AppMethodBeat.o(184387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a
 * JD-Core Version:    0.7.0.1
 */