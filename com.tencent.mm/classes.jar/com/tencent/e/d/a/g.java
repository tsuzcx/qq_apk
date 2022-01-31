package com.tencent.e.d.a;

import com.tencent.e.d.b.d.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
  implements b
{
  private final List<d.a> Bkl;
  private final Pattern zDQ;
  
  public g()
  {
    AppMethodBeat.i(114512);
    this.Bkl = new ArrayList();
    this.zDQ = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");
    AppMethodBeat.o(114512);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(114513);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(114513);
      return;
    }
    if (parama.Bks != 1)
    {
      AppMethodBeat.o(114513);
      return;
    }
    this.Bkl.add(parama);
    AppMethodBeat.o(114513);
  }
  
  public final boolean dUx()
  {
    AppMethodBeat.i(114514);
    Iterator localIterator = this.Bkl.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      new StringBuilder("SingleProcessAnalyzer : ").append(locala.toString());
      h.dUU();
      if ((locala.name != null) && (this.zDQ.matcher(locala.name).find()))
      {
        new StringBuilder("SingleProcessAnalyzer match : ").append(locala.toString());
        h.dUT();
        AppMethodBeat.o(114514);
        return true;
      }
    }
    AppMethodBeat.o(114514);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.e.d.a.g
 * JD-Core Version:    0.7.0.1
 */