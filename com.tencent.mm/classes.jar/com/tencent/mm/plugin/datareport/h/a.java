package com.tencent.mm.plugin.datareport.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.c.i;

public final class a
{
  private static Boolean xhO = null;
  private static int xhP = 0;
  private static int xhQ = 0;
  private static int xhR = 0;
  private static int xhS = 0;
  
  public static void Jw(int paramInt)
  {
    AppMethodBeat.i(262807);
    if (!dtO())
    {
      AppMethodBeat.o(262807);
      return;
    }
    if (paramInt <= xhP)
    {
      AppMethodBeat.o(262807);
      return;
    }
    xhP = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("1");
    localArrayList.add(String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.P(24504, localArrayList);
    AppMethodBeat.o(262807);
  }
  
  public static void Jx(int paramInt)
  {
    AppMethodBeat.i(262818);
    if (!dtO())
    {
      AppMethodBeat.o(262818);
      return;
    }
    if (paramInt <= xhQ)
    {
      AppMethodBeat.o(262818);
      return;
    }
    xhQ = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("3");
    localArrayList.add(String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.P(24504, localArrayList);
    AppMethodBeat.o(262818);
  }
  
  public static void Jy(int paramInt)
  {
    AppMethodBeat.i(262826);
    if (!dtO())
    {
      AppMethodBeat.o(262826);
      return;
    }
    if (paramInt <= xhR)
    {
      AppMethodBeat.o(262826);
      return;
    }
    xhR = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("4");
    localArrayList.add(String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.P(24504, localArrayList);
    AppMethodBeat.o(262826);
  }
  
  public static void Jz(int paramInt)
  {
    AppMethodBeat.i(262833);
    if (!dtO())
    {
      AppMethodBeat.o(262833);
      return;
    }
    if (paramInt <= xhS)
    {
      AppMethodBeat.o(262833);
      return;
    }
    xhS = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("5");
    localArrayList.add(String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.P(24504, localArrayList);
    AppMethodBeat.o(262833);
  }
  
  public static void amx(String paramString)
  {
    AppMethodBeat.i(262811);
    if (!dtO())
    {
      AppMethodBeat.o(262811);
      return;
    }
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262811);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("2");
    localArrayList.add(paramString.replace(",", "`"));
    paramString = com.tencent.mm.plugin.report.service.h.OAn;
    com.tencent.mm.plugin.report.service.h.P(24504, localArrayList);
    AppMethodBeat.o(262811);
  }
  
  private static boolean dtO()
  {
    AppMethodBeat.i(262839);
    if (xhO == null)
    {
      xhO = Boolean.valueOf(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zqo, false));
      Log.i("DataReportPerformanceReport", "[isOpenPerformanceReport] mIsOpenPerformanceReport : " + xhO);
    }
    if (com.tencent.mm.plugin.datareport.j.a.anH()) {
      xhO = Boolean.TRUE;
    }
    boolean bool = xhO.booleanValue();
    AppMethodBeat.o(262839);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.h.a
 * JD-Core Version:    0.7.0.1
 */