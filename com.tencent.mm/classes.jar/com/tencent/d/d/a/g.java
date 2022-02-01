package com.tencent.d.d.a;

import com.tencent.d.d.b.e.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
  implements b
{
  private final Pattern WFU;
  private final List<e.a> ZoV;
  
  public g()
  {
    AppMethodBeat.i(138353);
    this.ZoV = new ArrayList();
    this.WFU = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");
    AppMethodBeat.o(138353);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(138354);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(138354);
      return;
    }
    if (parama.Zpc != 1)
    {
      AppMethodBeat.o(138354);
      return;
    }
    this.ZoV.add(parama);
    AppMethodBeat.o(138354);
  }
  
  public final boolean inU()
  {
    AppMethodBeat.i(138355);
    Iterator localIterator = this.ZoV.iterator();
    while (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      new StringBuilder("SingleProcessAnalyzer : ").append(locala.toString());
      h.hEQ();
      if ((locala.name != null) && (this.WFU.matcher(locala.name).find()))
      {
        new StringBuilder("SingleProcessAnalyzer match : ").append(locala.toString());
        h.iop();
        AppMethodBeat.o(138355);
        return true;
      }
    }
    AppMethodBeat.o(138355);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.a.g
 * JD-Core Version:    0.7.0.1
 */