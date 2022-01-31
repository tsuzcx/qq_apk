package com.tencent.d.d.a;

import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
  implements b
{
  private final Pattern vou = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");
  private final List<d.a> wMM = new ArrayList();
  
  public final void a(d.a parama)
  {
    if (parama.uid != 0) {}
    while (parama.wMT != 1) {
      return;
    }
    this.wMM.add(parama);
  }
  
  public final boolean cOI()
  {
    Iterator localIterator = this.wMM.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      h.d("SingleProcessAnalyzer : " + locala.toString());
      if ((locala.name != null) && (this.vou.matcher(locala.name).find()))
      {
        h.i("SingleProcessAnalyzer match : " + locala.toString());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.d.a.g
 * JD-Core Version:    0.7.0.1
 */