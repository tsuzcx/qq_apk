package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class jj<D extends jh>
  extends jo<D>
  implements je<D>
{
  ArrayList<jg<D>> a;
  private boolean b;
  
  public jj()
  {
    AppMethodBeat.i(223398);
    this.a = new ArrayList();
    this.b = true;
    AppMethodBeat.o(223398);
  }
  
  private static void a(String paramString, D paramD, List<jg<D>> paramList)
  {
    AppMethodBeat.i(223430);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      jg localjg = (jg)paramList.next();
      if ((localjg instanceof jn)) {
        ((jn)localjg).m().b(paramString, paramD);
      } else {
        localjg.a(paramString, paramD);
      }
    }
    AppMethodBeat.o(223430);
  }
  
  private void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private void a(jg<D>... paramVarArgs)
  {
    AppMethodBeat.i(223418);
    this.a.addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(223418);
  }
  
  public final je<D> a()
  {
    return this;
  }
  
  public final jg<D> a(int paramInt)
  {
    AppMethodBeat.i(223438);
    if (paramInt >= this.a.size())
    {
      AppMethodBeat.o(223438);
      return null;
    }
    jg localjg = (jg)this.a.get(paramInt);
    AppMethodBeat.o(223438);
    return localjg;
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    AppMethodBeat.i(223468);
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    Object localObject2 = localObject1;
    jg localjg;
    if (localIterator.hasNext())
    {
      localjg = (jg)localIterator.next();
      localObject2 = localObject1;
      if (localjg == null) {
        break label252;
      }
      if ((localjg instanceof jn))
      {
        localObject1 = ((jn)localjg).m().b(paramString, paramClass);
        label88:
        if ((localObject1 == null) || (((jh)localObject1).a() <= 0)) {
          break label211;
        }
        kh.c("TDZ", "从[" + localjg + "]缓存中获取数据成功");
        localObject2 = localObject1;
      }
    }
    else
    {
      if ((localObject2 != null) && (localObject2.a() > 0) && (!localArrayList.isEmpty())) {
        a(paramString, localObject2, localArrayList);
      }
      if (localObject2 != null) {
        break label259;
      }
    }
    label259:
    for (int i = 0;; i = localObject2.a())
    {
      kl.a("CS", paramString, "get data length", Integer.valueOf(i));
      kl.f("CS", paramString);
      AppMethodBeat.o(223468);
      return localObject2;
      localObject1 = localjg.a(paramString, paramClass);
      break label88;
      label211:
      localObject2 = localObject1;
      if (this.b)
      {
        kl.a("CS", paramString, "back to fill ".concat(String.valueOf(localjg)));
        localArrayList.add(localjg);
        localObject2 = localObject1;
      }
      label252:
      localObject1 = localObject2;
      break;
    }
  }
  
  public final void a(je.a<Boolean> parama)
  {
    AppMethodBeat.i(223548);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg != null) {
        if ((localjg instanceof je))
        {
          ((je)localjg).a().a(parama);
        }
        else if ((localjg instanceof jn))
        {
          ((jn)localjg).m().j();
          if (parama != null) {
            parama.callback(Boolean.TRUE);
          }
        }
        else
        {
          localjg.b();
          if (parama != null) {
            parama.callback(Boolean.TRUE);
          }
        }
      }
    }
    AppMethodBeat.o(223548);
  }
  
  public final void a(String paramString, je.a<Boolean> parama)
  {
    AppMethodBeat.i(223540);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (jg)localIterator.next();
      if (localObject != null) {
        if ((localObject instanceof je))
        {
          ((je)localObject).a().a(paramString, parama);
        }
        else if ((localObject instanceof jn))
        {
          localObject = ((jn)localObject).m();
          if (parama != null) {
            parama.callback(Boolean.valueOf(((jn)localObject).b(paramString)));
          }
        }
        else if (parama != null)
        {
          parama.callback(Boolean.valueOf(((jg)localObject).a(paramString)));
        }
      }
    }
    AppMethodBeat.o(223540);
  }
  
  public final void a(String paramString, D paramD)
  {
    AppMethodBeat.i(223450);
    kl.b("CS", paramString);
    int i;
    Iterator localIterator;
    if (paramD == null)
    {
      i = 0;
      kl.a("DC", paramString, "put data length", Integer.valueOf(i));
      localIterator = this.a.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label113;
      }
      jg localjg = (jg)localIterator.next();
      if (localjg != null)
      {
        if ((localjg instanceof jn))
        {
          ((jn)localjg).m().b(paramString, paramD);
          continue;
          i = paramD.a();
          break;
        }
        localjg.a(paramString, paramD);
      }
    }
    label113:
    AppMethodBeat.o(223450);
  }
  
  public final void a(String paramString, D paramD, je.a<Boolean> parama)
  {
    AppMethodBeat.i(223522);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg != null) {
        if ((localjg instanceof je))
        {
          ((je)localjg).a().a(paramString, paramD, parama);
        }
        else if ((localjg instanceof jn))
        {
          ((jn)localjg).m().b(paramString, paramD);
          if (parama != null) {
            parama.callback(Boolean.TRUE);
          }
        }
        else
        {
          localjg.a(paramString, paramD);
          if (parama != null) {
            parama.callback(Boolean.TRUE);
          }
        }
      }
    }
    AppMethodBeat.o(223522);
  }
  
  public final void a(String paramString, Class<D> paramClass, je.a<D> parama)
  {
    AppMethodBeat.i(223529);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (jg)localIterator.next();
      if (localObject != null) {
        if ((localObject instanceof je))
        {
          ((je)localObject).a().a(paramString, paramClass, parama);
        }
        else if ((localObject instanceof jn))
        {
          localObject = ((jn)localObject).m();
          if (parama != null) {
            parama.callback(((jn)localObject).b(paramString, paramClass));
          }
        }
        else if (parama != null)
        {
          parama.callback(((jg)localObject).a(paramString, paramClass));
        }
      }
    }
    AppMethodBeat.o(223529);
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(223478);
    Iterator localIterator = this.a.iterator();
    boolean bool = true;
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg == null) {
        break label87;
      }
      if ((localjg instanceof jn)) {
        bool = ((jn)localjg).m().b(paramString);
      } else {
        bool = localjg.a(paramString);
      }
    }
    label87:
    for (;;)
    {
      break;
      AppMethodBeat.o(223478);
      return bool;
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(223485);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg != null) {
        if ((localjg instanceof jn)) {
          ((jn)localjg).m().j();
        } else {
          localjg.b();
        }
      }
    }
    AppMethodBeat.o(223485);
  }
  
  public final void b(je.a<Long> parama)
  {
    AppMethodBeat.i(223555);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (jg)localIterator.next();
      if (localObject != null) {
        if ((localObject instanceof je))
        {
          ((je)localObject).a().b(parama);
        }
        else if ((localObject instanceof jn))
        {
          localObject = ((jn)localObject).m();
          if (parama != null) {
            parama.callback(Long.valueOf(((jn)localObject).k()));
          }
        }
        else if (parama != null)
        {
          parama.callback(Long.valueOf(((jg)localObject).c()));
        }
      }
    }
    AppMethodBeat.o(223555);
  }
  
  public final long c()
  {
    AppMethodBeat.i(223495);
    Iterator localIterator = this.a.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg == null) {
        break label89;
      }
      if ((localjg instanceof jn)) {
        l = ((jn)localjg).m().k() + l;
      } else {
        l = localjg.c() + l;
      }
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(223495);
      return l;
    }
  }
  
  public final void c(je.a<Long> parama)
  {
    AppMethodBeat.i(223564);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (jg)localIterator.next();
      if (localObject != null) {
        if ((localObject instanceof je))
        {
          ((je)localObject).a().c(parama);
        }
        else if ((localObject instanceof jn))
        {
          localObject = ((jn)localObject).m();
          if (parama != null) {
            parama.callback(Long.valueOf(((jn)localObject).l()));
          }
        }
        else if (parama != null)
        {
          parama.callback(Long.valueOf(((jg)localObject).d()));
        }
      }
    }
    AppMethodBeat.o(223564);
  }
  
  public final long d()
  {
    AppMethodBeat.i(223505);
    Iterator localIterator = this.a.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg == null) {
        break label91;
      }
      if ((localjg instanceof jn)) {
        l = ((jn)localjg).m().l() + l;
      } else {
        l = localjg.d() + l;
      }
    }
    label91:
    for (;;)
    {
      break;
      AppMethodBeat.o(223505);
      return l;
    }
  }
  
  public final void d(je.a<Long> parama)
  {
    AppMethodBeat.i(223574);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (jg)localIterator.next();
      if (localObject != null) {
        if ((localObject instanceof je))
        {
          ((je)localObject).a().d(parama);
        }
        else if ((localObject instanceof jn))
        {
          localObject = ((jn)localObject).m();
          if (parama != null) {
            parama.callback(Long.valueOf(((jn)localObject).e()));
          }
        }
        else if (parama != null)
        {
          parama.callback(Long.valueOf(((jg)localObject).e()));
        }
      }
    }
    AppMethodBeat.o(223574);
  }
  
  public final long e()
  {
    AppMethodBeat.i(223510);
    Iterator localIterator = this.a.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      jg localjg = (jg)localIterator.next();
      if (localjg == null) {
        break label91;
      }
      if ((localjg instanceof jn)) {
        l = ((jn)localjg).m().e() + l;
      } else {
        l = localjg.e() + l;
      }
    }
    label91:
    for (;;)
    {
      break;
      AppMethodBeat.o(223510);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jj
 * JD-Core Version:    0.7.0.1
 */