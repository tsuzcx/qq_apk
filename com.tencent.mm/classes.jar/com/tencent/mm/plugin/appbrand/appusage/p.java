package com.tencent.mm.plugin.appbrand.appusage;

import a.d.b.g;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import java.util.Collections;
import java.util.List;

public final class p
  extends j
  implements ag
{
  public final void a(j.a parama, Looper paramLooper)
  {
    e.aaZ().a(parama, paramLooper);
    e.aaT().a(parama, paramLooper);
  }
  
  public final boolean as(String paramString, int paramInt)
  {
    return e.aaZ().ax(paramString, paramInt);
  }
  
  public final void c(j.a parama)
  {
    a(parama, Looper.getMainLooper());
  }
  
  public final void d(j.a parama)
  {
    e.aaZ().d(parama);
    e.aaT().d(parama);
  }
  
  public final List<? extends LocalUsageInfo> kz(int paramInt)
  {
    if (paramInt <= 0)
    {
      localObject = Collections.emptyList();
      g.j(localObject, "Collections.emptyList<LocalUsageInfo>()");
      return localObject;
    }
    Object localObject = w.f(e.aaZ().a(null, paramInt, 0));
    g.j(localObject, "obtainHistoryList(SubCor…istories(null, count, 0))");
    return (List)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */