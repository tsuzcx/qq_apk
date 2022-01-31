package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Arrays;

public final class j
{
  private static long dZs = -1L;
  
  public static void run()
  {
    int k = 1;
    AppMethodBeat.i(153480);
    if (d.fw(21))
    {
      AppMethodBeat.o(153480);
      return;
    }
    if (dZs < 0L) {
      dZs = ah.getContext().getSharedPreferences("eabi_report", 0).getLong("last_report", -1L);
    }
    int i;
    ArrayList localArrayList;
    if ((dZs < 0L) || (System.currentTimeMillis() - dZs > 86400000L))
    {
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label234;
      }
      i = 1;
      ab.i("MicroMsg.PostTaskReportEABISupport", "current device support eabi: %s, %s", new Object[] { Arrays.toString(Build.SUPPORTED_32_BIT_ABIS), Arrays.toString(Build.SUPPORTED_64_BIT_ABIS) });
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(661, 3, 1));
      if (i == 0) {
        break label239;
      }
    }
    label234:
    label239:
    for (int j = 1;; j = 0)
    {
      localArrayList.add(new IDKey(661, 4, j));
      j = k;
      if (i != 0) {
        j = 0;
      }
      localArrayList.add(new IDKey(661, 5, j));
      e.qrI.b(localArrayList, false);
      dZs = System.currentTimeMillis();
      ah.getContext().getSharedPreferences("eabi_report", 0).edit().putLong("last_report", dZs).commit();
      AppMethodBeat.o(153480);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.j
 * JD-Core Version:    0.7.0.1
 */