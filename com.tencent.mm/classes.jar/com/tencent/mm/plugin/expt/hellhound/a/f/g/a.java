package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final com.tencent.mm.hellhoundlib.a.c pHG;
  private static volatile boolean pHH;
  
  static
  {
    AppMethodBeat.i(169369);
    pHG = new com.tencent.mm.hellhoundlib.a.c()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184386);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(220, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(184386);
      }
      
      public final void g(String paramAnonymousString, Object paramAnonymousObject) {}
    };
    pHH = false;
    AppMethodBeat.o(169369);
  }
  
  public static boolean Xj(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void Xk(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.VL(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    ad.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, pHG);
    AppMethodBeat.o(169363);
  }
  
  public static void Xl(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.VL(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().Bo(221);
    AppMethodBeat.o(169364);
  }
  
  public static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(169367);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      AppMethodBeat.o(169367);
      return;
    }
    ad.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler, curSession: %s, %s", new Object[] { localbxx.sessionId, paramString });
    if (Xj(localbxx.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString))
      {
        if (!pHH)
        {
          pHH = true;
          d(localbxx, str, paramLong);
          AppMethodBeat.o(169367);
          return;
        }
        pHH = false;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(localbxx, paramLong);
        AppMethodBeat.o(169367);
        return;
      }
      d(localbxx, str, paramLong);
    }
    AppMethodBeat.o(169367);
  }
  
  public static void cdB()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, pHG);
    AppMethodBeat.o(169365);
  }
  
  private static void d(bxx parambxx, String paramString, long paramLong)
  {
    AppMethodBeat.i(169368);
    if ((parambxx == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(169368);
      return;
    }
    if (Xj(parambxx.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.c(parambxx, paramString, paramLong);
    }
    AppMethodBeat.o(169368);
  }
  
  public static void pr(long paramLong)
  {
    AppMethodBeat.i(184387);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.e("ScanSessionHandler", "HABBYGE-MALI, baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    ad.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localbxx.sessionId });
    if (Xj(localbxx.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(localbxx, paramLong);
    }
    AppMethodBeat.o(184387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a
 * JD-Core Version:    0.7.0.1
 */