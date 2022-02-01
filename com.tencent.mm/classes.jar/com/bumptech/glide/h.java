package com.bumptech.glide;

import android.support.v4.e.l.a;
import com.bumptech.glide.c.a.e.a;
import com.bumptech.glide.c.b.s;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.p;
import com.bumptech.glide.c.k;
import com.bumptech.glide.c.l;
import com.bumptech.glide.e.b;
import com.bumptech.glide.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private final p aAg;
  public final com.bumptech.glide.e.a aAh;
  private final com.bumptech.glide.e.e aAi;
  public final com.bumptech.glide.e.f aAj;
  public final com.bumptech.glide.c.a.f aAk;
  private final com.bumptech.glide.c.d.f.f aAl;
  final b aAm;
  private final com.bumptech.glide.e.d aAn;
  private final c aAo;
  private final l.a<List<Throwable>> aAp;
  
  public h()
  {
    AppMethodBeat.i(76794);
    this.aAn = new com.bumptech.glide.e.d();
    this.aAo = new c();
    this.aAp = com.bumptech.glide.h.a.a.pT();
    this.aAg = new p(this.aAp);
    this.aAh = new com.bumptech.glide.e.a();
    this.aAi = new com.bumptech.glide.e.e();
    this.aAj = new com.bumptech.glide.e.f();
    this.aAk = new com.bumptech.glide.c.a.f();
    this.aAl = new com.bumptech.glide.c.d.f.f();
    this.aAm = new b();
    ArrayList localArrayList = new ArrayList(Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" }));
    localArrayList.add(0, "legacy_prepend_all");
    localArrayList.add("legacy_append");
    this.aAi.s(localArrayList);
    AppMethodBeat.o(76794);
  }
  
  public final <Model> List<n<Model, ?>> M(Model paramModel)
  {
    AppMethodBeat.i(76804);
    List localList = this.aAg.M(paramModel);
    if (localList.isEmpty())
    {
      paramModel = new h.c(paramModel);
      AppMethodBeat.o(76804);
      throw paramModel;
    }
    AppMethodBeat.o(76804);
    return localList;
  }
  
  public final <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    AppMethodBeat.i(76802);
    ??? = this.aAo.c(paramClass, paramClass1, paramClass2);
    if (c.a((s)???))
    {
      AppMethodBeat.o(76802);
      return null;
    }
    Object localObject1 = ???;
    Object localObject3;
    if (??? == null)
    {
      localObject1 = new ArrayList();
      ??? = this.aAi.h(paramClass, paramClass1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (Class)((Iterator)???).next();
        Iterator localIterator = this.aAl.d((Class)localObject3, paramClass2).iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          ((List)localObject1).add(new com.bumptech.glide.c.b.h(paramClass, (Class)localObject3, localClass, this.aAi.g(paramClass, (Class)localObject3), this.aAl.c((Class)localObject3, localClass), this.aAp));
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label249;
      }
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = this.aAo;
      synchronized (((c)localObject3).aKq)
      {
        localObject3 = ((c)localObject3).aKq;
        paramClass1 = new com.bumptech.glide.h.h(paramClass, paramClass1, paramClass2);
        if (localObject1 != null)
        {
          paramClass = (Class<Data>)localObject1;
          ((android.support.v4.e.a)localObject3).put(paramClass1, paramClass);
          AppMethodBeat.o(76802);
          return localObject1;
          label249:
          localObject1 = new s(paramClass, paramClass1, paramClass2, (List)localObject1, this.aAp);
          continue;
        }
        paramClass = c.aKp;
      }
    }
  }
  
  public final h a(e.a<?> parama)
  {
    AppMethodBeat.i(76799);
    this.aAk.b(parama);
    AppMethodBeat.o(76799);
    return this;
  }
  
  public final <Data> h a(Class<Data> paramClass, com.bumptech.glide.c.d<Data> paramd)
  {
    AppMethodBeat.i(76795);
    this.aAh.b(paramClass, paramd);
    AppMethodBeat.o(76795);
    return this;
  }
  
  public final <TResource> h a(Class<TResource> paramClass, l<TResource> paraml)
  {
    AppMethodBeat.i(76798);
    this.aAj.b(paramClass, paraml);
    AppMethodBeat.o(76798);
    return this;
  }
  
  public final <Model, Data> h a(Class<Model> paramClass, Class<Data> paramClass1, o<Model, Data> paramo)
  {
    AppMethodBeat.i(76801);
    this.aAg.b(paramClass, paramClass1, paramo);
    AppMethodBeat.o(76801);
    return this;
  }
  
  public final <TResource, Transcode> h a(Class<TResource> paramClass, Class<Transcode> paramClass1, com.bumptech.glide.c.d.f.e<TResource, Transcode> parame)
  {
    AppMethodBeat.i(76800);
    this.aAl.b(paramClass, paramClass1, parame);
    AppMethodBeat.o(76800);
    return this;
  }
  
  public final <Data, TResource> h a(Class<Data> paramClass, Class<TResource> paramClass1, k<Data, TResource> paramk)
  {
    AppMethodBeat.i(76796);
    a("legacy_append", paramClass, paramClass1, paramk);
    AppMethodBeat.o(76796);
    return this;
  }
  
  public final <Data, TResource> h a(String paramString, Class<Data> paramClass, Class<TResource> paramClass1, k<Data, TResource> paramk)
  {
    AppMethodBeat.i(76797);
    this.aAi.a(paramString, paramk, paramClass, paramClass1);
    AppMethodBeat.o(76797);
    return this;
  }
  
  public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> paramClass, Class<TResource> paramClass1, Class<Transcode> arg3)
  {
    AppMethodBeat.i(76803);
    Object localObject2 = this.aAn.f(paramClass, paramClass1);
    Object localObject1 = localObject2;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      localObject2 = this.aAg.q(paramClass).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Class)((Iterator)localObject2).next();
        localObject3 = this.aAi.h((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject3).next();
          if ((!this.aAl.d(localClass, ???).isEmpty()) && (!((List)localObject1).contains(localClass))) {
            ((List)localObject1).add(localClass);
          }
        }
      }
      localObject2 = this.aAn;
      localObject3 = Collections.unmodifiableList((List)localObject1);
    }
    synchronized (((com.bumptech.glide.e.d)localObject2).aKt)
    {
      ((com.bumptech.glide.e.d)localObject2).aKt.put(new com.bumptech.glide.h.h(paramClass, paramClass1), localObject3);
      AppMethodBeat.o(76803);
      return localObject1;
    }
  }
  
  public final List<com.bumptech.glide.c.f> nj()
  {
    AppMethodBeat.i(76805);
    Object localObject = this.aAm.po();
    if (((List)localObject).isEmpty())
    {
      localObject = new h.b();
      AppMethodBeat.o(76805);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(76805);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h
 * JD-Core Version:    0.7.0.1
 */