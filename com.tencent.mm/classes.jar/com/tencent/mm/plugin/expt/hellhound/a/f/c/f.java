package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
{
  public static String crM()
  {
    AppMethodBeat.i(122156);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    Object localObject;
    if (i == 0) {
      localObject = "-1";
    }
    for (;;)
    {
      localObject = d.afY((String)localObject);
      AppMethodBeat.o(122156);
      return localObject;
      String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenPageFlRptChe_".concat(String.valueOf(i)));
      if (str != null)
      {
        localObject = str;
        if (!str.isEmpty()) {}
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public static void vr(long paramLong)
  {
    AppMethodBeat.i(184375);
    String str2 = String.valueOf(paramLong);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i != 0)
    {
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenPageFlRptChe_".concat(String.valueOf(i)), str1);
        AppMethodBeat.o(184375);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageDao", localException, "HellSessionReportCache.writeBackOfFlow", new Object[0]);
      }
    }
    AppMethodBeat.o(184375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.f
 * JD-Core Version:    0.7.0.1
 */