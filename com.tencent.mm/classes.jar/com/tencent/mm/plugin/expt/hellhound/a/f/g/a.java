package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final com.tencent.mm.hellhoundlib.a.c qZq;
  private static volatile boolean qZr;
  
  static
  {
    AppMethodBeat.i(169369);
    qZq = new a.1();
    qZr = false;
    AppMethodBeat.o(169369);
  }
  
  public static void A(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210496);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      AppMethodBeat.o(210496);
      return;
    }
    ad.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, curSession: %s, %s", new Object[] { localchk.sessionId, paramString });
    if (afu(localchk.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString))
      {
        if (!qZr)
        {
          qZr = true;
          c(localchk, str, paramInt, paramLong);
          AppMethodBeat.o(210496);
          return;
        }
        qZr = false;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(localchk, paramLong);
        AppMethodBeat.o(210496);
        return;
      }
      c(localchk, str, paramInt, paramLong);
    }
    AppMethodBeat.o(210496);
  }
  
  public static boolean afu(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void afv(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.adK(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    ad.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, qZq);
    AppMethodBeat.o(169363);
  }
  
  public static void afw(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.adK(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(221);
    AppMethodBeat.o(169364);
  }
  
  private static void c(chk paramchk, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210497);
    if ((paramchk == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(210497);
      return;
    }
    if (afu(paramchk.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramchk, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(210497);
  }
  
  public static void cqA()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, qZq);
    AppMethodBeat.o(169365);
  }
  
  public static void vd(long paramLong)
  {
    AppMethodBeat.i(184387);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.ScanSessionHandler", "baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    ad.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localchk.sessionId });
    if (afu(localchk.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(localchk, paramLong);
    }
    AppMethodBeat.o(184387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a
 * JD-Core Version:    0.7.0.1
 */