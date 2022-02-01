package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final d woP;
  private static volatile boolean woQ;
  
  static
  {
    AppMethodBeat.i(169369);
    woP = new d()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184386);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(220, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(184386);
      }
    };
    woQ = false;
    AppMethodBeat.o(169369);
  }
  
  public static void JL(long paramLong)
  {
    AppMethodBeat.i(184387);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.ScanSessionHandler", "baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localdhx.sessionId });
    if (azc(localdhx.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(localdhx, paramLong);
    }
    AppMethodBeat.o(184387);
  }
  
  public static boolean azc(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void azd(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.awQ(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, woP);
    AppMethodBeat.o(169363);
  }
  
  public static void aze(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.awQ(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().Kz(221);
    AppMethodBeat.o(169364);
  }
  
  private static void c(dhx paramdhx, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253635);
    if ((paramdhx == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(253635);
      return;
    }
    if (azc(paramdhx.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramdhx, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(253635);
  }
  
  public static void dfE()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, woP);
    AppMethodBeat.o(169365);
  }
  
  public static void z(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253632);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      AppMethodBeat.o(253632);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, curSession: %s, %s", new Object[] { localdhx.sessionId, paramString });
    if (azc(localdhx.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString))
      {
        if (!woQ)
        {
          woQ = true;
          c(localdhx, str, paramInt, paramLong);
          AppMethodBeat.o(253632);
          return;
        }
        woQ = false;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(localdhx, paramLong);
        AppMethodBeat.o(253632);
        return;
      }
      c(localdhx, str, paramInt, paramLong);
    }
    AppMethodBeat.o(253632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a
 * JD-Core Version:    0.7.0.1
 */