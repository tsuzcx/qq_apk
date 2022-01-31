package com.tencent.mm.plugin.appbrand.ui.collection;

import a.a.e;
import a.d.b.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.l.a;
import com.tencent.mm.plugin.appbrand.config.s;
import java.util.HashSet;
import java.util.Iterator;

final class a$e$1
  implements Runnable
{
  a$e$1(a.e parame) {}
  
  public final void run()
  {
    
    if (this.hgi.hgh.isAdded()) {
      a.f(this.hgi.hgh);
    }
    HashSet localHashSet = new HashSet();
    Object localObject = a.b(this.hgi.hgh);
    if (localObject == null) {
      g.cUk();
    }
    localObject = ((Iterable)((h)localObject).hgv).iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((LocalUsageInfo)((Iterator)localObject).next()).username);
    }
    s.a(e.c((Iterable)localHashSet), l.a.fQx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a.e.1
 * JD-Core Version:    0.7.0.1
 */