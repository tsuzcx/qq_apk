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
  private final p aBa;
  public final com.bumptech.glide.e.a aBb;
  private final com.bumptech.glide.e.e aBc;
  public final com.bumptech.glide.e.f aBd;
  public final com.bumptech.glide.c.a.f aBe;
  private final com.bumptech.glide.c.d.f.f aBf;
  final b aBg;
  private final com.bumptech.glide.e.d aBh;
  private final c aBi;
  private final l.a<List<Throwable>> aBj;
  
  public h()
  {
    AppMethodBeat.i(76794);
    this.aBh = new com.bumptech.glide.e.d();
    this.aBi = new c();
    this.aBj = com.bumptech.glide.h.a.a.qd();
    this.aBa = new p(this.aBj);
    this.aBb = new com.bumptech.glide.e.a();
    this.aBc = new com.bumptech.glide.e.e();
    this.aBd = new com.bumptech.glide.e.f();
    this.aBe = new com.bumptech.glide.c.a.f();
    this.aBf = new com.bumptech.glide.c.d.f.f();
    this.aBg = new b();
    ArrayList localArrayList = new ArrayList(Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" }));
    localArrayList.add(0, "legacy_prepend_all");
    localArrayList.add("legacy_append");
    this.aBc.r(localArrayList);
    AppMethodBeat.o(76794);
  }
  
  public final <Model> List<n<Model, ?>> O(Model paramModel)
  {
    AppMethodBeat.i(76804);
    List localList = this.aBa.O(paramModel);
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
    ??? = this.aBi.c(paramClass, paramClass1, paramClass2);
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
      ??? = this.aBc.h(paramClass, paramClass1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (Class)((Iterator)???).next();
        Iterator localIterator = this.aBf.d((Class)localObject3, paramClass2).iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          ((List)localObject1).add(new com.bumptech.glide.c.b.h(paramClass, (Class)localObject3, localClass, this.aBc.g(paramClass, (Class)localObject3), this.aBf.c((Class)localObject3, localClass), this.aBj));
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label249;
      }
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = this.aBi;
      synchronized (((c)localObject3).aLg)
      {
        localObject3 = ((c)localObject3).aLg;
        paramClass1 = new com.bumptech.glide.h.h(paramClass, paramClass1, paramClass2);
        if (localObject1 != null)
        {
          paramClass = (Class<Data>)localObject1;
          ((android.support.v4.e.a)localObject3).put(paramClass1, paramClass);
          AppMethodBeat.o(76802);
          return localObject1;
          label249:
          localObject1 = new s(paramClass, paramClass1, paramClass2, (List)localObject1, this.aBj);
          continue;
        }
        paramClass = c.aLf;
      }
    }
  }
  
  public final h a(e.a<?> parama)
  {
    AppMethodBeat.i(76799);
    this.aBe.b(parama);
    AppMethodBeat.o(76799);
    return this;
  }
  
  public final <Data> h a(Class<Data> paramClass, com.bumptech.glide.c.d<Data> paramd)
  {
    AppMethodBeat.i(76795);
    this.aBb.b(paramClass, paramd);
    AppMethodBeat.o(76795);
    return this;
  }
  
  public final <TResource> h a(Class<TResource> paramClass, l<TResource> paraml)
  {
    AppMethodBeat.i(76798);
    this.aBd.b(paramClass, paraml);
    AppMethodBeat.o(76798);
    return this;
  }
  
  public final <Model, Data> h a(Class<Model> paramClass, Class<Data> paramClass1, o<Model, Data> paramo)
  {
    AppMethodBeat.i(76801);
    this.aBa.b(paramClass, paramClass1, paramo);
    AppMethodBeat.o(76801);
    return this;
  }
  
  public final <TResource, Transcode> h a(Class<TResource> paramClass, Class<Transcode> paramClass1, com.bumptech.glide.c.d.f.e<TResource, Transcode> parame)
  {
    AppMethodBeat.i(76800);
    this.aBf.b(paramClass, paramClass1, parame);
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
    this.aBc.a(paramString, paramk, paramClass, paramClass1);
    AppMethodBeat.o(76797);
    return this;
  }
  
  public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> paramClass, Class<TResource> paramClass1, Class<Transcode> arg3)
  {
    AppMethodBeat.i(76803);
    Object localObject2 = this.aBh.f(paramClass, paramClass1);
    Object localObject1 = localObject2;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      localObject2 = this.aBa.q(paramClass).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Class)((Iterator)localObject2).next();
        localObject3 = this.aBc.h((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject3).next();
          if ((!this.aBf.d(localClass, ???).isEmpty()) && (!((List)localObject1).contains(localClass))) {
            ((List)localObject1).add(localClass);
          }
        }
      }
      localObject2 = this.aBh;
      localObject3 = Collections.unmodifiableList((List)localObject1);
    }
    synchronized (((com.bumptech.glide.e.d)localObject2).aLj)
    {
      ((com.bumptech.glide.e.d)localObject2).aLj.put(new com.bumptech.glide.h.h(paramClass, paramClass1), localObject3);
      AppMethodBeat.o(76803);
      return localObject1;
    }
  }
  
  public final List<com.bumptech.glide.c.f> nt()
  {
    AppMethodBeat.i(76805);
    Object localObject = this.aBg.py();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h
 * JD-Core Version:    0.7.0.1
 */