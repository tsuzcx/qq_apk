package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final com.tencent.mm.hellhoundlib.a.c sIS;
  private static volatile boolean sIT;
  
  static
  {
    AppMethodBeat.i(169369);
    sIS = new com.tencent.mm.hellhoundlib.a.c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184386);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(220, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(184386);
      }
    };
    sIT = false;
    AppMethodBeat.o(169369);
  }
  
  public static void Dx(long paramLong)
  {
    AppMethodBeat.i(184387);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.ScanSessionHandler", "baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localcyl.sessionId });
    if (arb(localcyl.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(localcyl, paramLong);
    }
    AppMethodBeat.o(184387);
  }
  
  public static boolean arb(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void arc(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoR(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, sIS);
    AppMethodBeat.o(169363);
  }
  
  public static void ard(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoR(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(221);
    AppMethodBeat.o(169364);
  }
  
  private static void c(cyl paramcyl, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220595);
    if ((paramcyl == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(220595);
      return;
    }
    if (arb(paramcyl.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramcyl, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(220595);
  }
  
  public static void cQK()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, sIS);
    AppMethodBeat.o(169365);
  }
  
  public static void y(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220594);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      AppMethodBeat.o(220594);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, curSession: %s, %s", new Object[] { localcyl.sessionId, paramString });
    if (arb(localcyl.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString))
      {
        if (!sIT)
        {
          sIT = true;
          c(localcyl, str, paramInt, paramLong);
          AppMethodBeat.o(220594);
          return;
        }
        sIT = false;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(localcyl, paramLong);
        AppMethodBeat.o(220594);
        return;
      }
      c(localcyl, str, paramInt, paramLong);
    }
    AppMethodBeat.o(220594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a
 * JD-Core Version:    0.7.0.1
 */