package com.tencent.mm.plugin.expt.hellhound.a.f.g;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final com.tencent.mm.hellhoundlib.a.c rhw;
  private static volatile boolean rhx;
  
  static
  {
    AppMethodBeat.i(169369);
    rhw = new a.1();
    rhx = false;
    AppMethodBeat.o(169369);
  }
  
  public static boolean agq(String paramString)
  {
    AppMethodBeat.i(122266);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramString);
    if (("124".equals(paramString)) || ("109".equals(paramString)))
    {
      AppMethodBeat.o(122266);
      return true;
    }
    AppMethodBeat.o(122266);
    return false;
  }
  
  public static void agr(String paramString)
  {
    AppMethodBeat.i(169363);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aeE(paramString))
    {
      AppMethodBeat.o(169363);
      return;
    }
    ae.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, startMonitor: %s", new Object[] { paramString });
    paramString = new ArrayList();
    paramString.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", paramString);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(localHashMap, rhw);
    AppMethodBeat.o(169363);
  }
  
  public static void ags(String paramString)
  {
    AppMethodBeat.i(169364);
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aeE(paramString))
    {
      AppMethodBeat.o(169364);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().De(221);
    AppMethodBeat.o(169364);
  }
  
  private static void c(cie paramcie, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196164);
    if ((paramcie == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(196164);
      return;
    }
    if (agq(paramcie.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramcie, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(196164);
  }
  
  public static void csc()
  {
    AppMethodBeat.i(169365);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("goBack", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/plugin/scanner/ui/BaseScanUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.b(localHashMap, rhw);
    AppMethodBeat.o(169365);
  }
  
  public static void vt(long paramLong)
  {
    AppMethodBeat.i(184387);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.ScanSessionHandler", "baseScanUIGoBack, session End !!");
      AppMethodBeat.o(184387);
      return;
    }
    ae.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, baseScanUIGoBack: %s", new Object[] { localcie.sessionId });
    if (agq(localcie.sessionId)) {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(localcie, paramLong);
    }
    AppMethodBeat.o(184387);
  }
  
  public static void z(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196163);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      AppMethodBeat.o(196163);
      return;
    }
    ae.i("HABBYGE-MALI.ScanSessionHandler", "ScanSessionHandler, curSession: %s, %s", new Object[] { localcie.sessionId, paramString });
    if (agq(localcie.sessionId))
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString))
      {
        if (!rhx)
        {
          rhx = true;
          c(localcie, str, paramInt, paramLong);
          AppMethodBeat.o(196163);
          return;
        }
        rhx = false;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(localcie, paramLong);
        AppMethodBeat.o(196163);
        return;
      }
      c(localcie, str, paramInt, paramLong);
    }
    AppMethodBeat.o(196163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a
 * JD-Core Version:    0.7.0.1
 */