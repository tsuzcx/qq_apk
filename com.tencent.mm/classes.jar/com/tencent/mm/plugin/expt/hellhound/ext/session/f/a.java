package com.tencent.mm.plugin.expt.hellhound.ext.session.f;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final d zKU;
  private static volatile boolean zKV;
  
  static
  {
    AppMethodBeat.i(169369);
    zKU = new d()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184386);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(220, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(184386);
      }
    };
    zKV = false;
    AppMethodBeat.o(169369);
  }
  
  public static boolean ath(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void ati(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqU(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, zKU);
    AppMethodBeat.o(169363);
  }
  
  public static void atj(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqU(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().Lz(221);
    AppMethodBeat.o(169364);
  }
  
  private static void c(eah parameah, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300251);
    if ((parameah == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(300251);
      return;
    }
    if (ath(parameah.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.b(parameah, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(300251);
  }
  
  public static void dMs()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, zKU);
    AppMethodBeat.o(169365);
  }
  
  public static void mj(long paramLong)
  {
    AppMethodBeat.i(184387);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.ScanSessionHandler", "baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localeah.sessionId });
    if (ath(localeah.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(localeah, paramLong);
    }
    AppMethodBeat.o(184387);
  }
  
  public static void z(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300247);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      AppMethodBeat.o(300247);
      return;
    }
    Log.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, curSession: %s, %s", new Object[] { localeah.sessionId, paramString });
    if (ath(localeah.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString))
      {
        if (!zKV)
        {
          zKV = true;
          c(localeah, str, paramInt, paramLong);
          AppMethodBeat.o(300247);
          return;
        }
        zKV = false;
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(localeah, paramLong);
        AppMethodBeat.o(300247);
        return;
      }
      c(localeah, str, paramInt, paramLong);
    }
    AppMethodBeat.o(300247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.f.a
 * JD-Core Version:    0.7.0.1
 */