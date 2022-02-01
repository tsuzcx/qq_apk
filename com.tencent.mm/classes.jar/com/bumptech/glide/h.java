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
  private final p aCR;
  public final com.bumptech.glide.e.a aCS;
  private final com.bumptech.glide.e.e aCT;
  public final com.bumptech.glide.e.f aCU;
  public final com.bumptech.glide.c.a.f aCV;
  private final com.bumptech.glide.c.d.f.f aCW;
  final b aCX;
  private final com.bumptech.glide.e.d aCY;
  private final c aCZ;
  private final l.a<List<Throwable>> aDa;
  
  public h()
  {
    AppMethodBeat.i(76794);
    this.aCY = new com.bumptech.glide.e.d();
    this.aCZ = new c();
    this.aDa = com.bumptech.glide.h.a.a.qv();
    this.aCR = new p(this.aDa);
    this.aCS = new com.bumptech.glide.e.a();
    this.aCT = new com.bumptech.glide.e.e();
    this.aCU = new com.bumptech.glide.e.f();
    this.aCV = new com.bumptech.glide.c.a.f();
    this.aCW = new com.bumptech.glide.c.d.f.f();
    this.aCX = new b();
    ArrayList localArrayList = new ArrayList(Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" }));
    localArrayList.add(0, "legacy_prepend_all");
    localArrayList.add("legacy_append");
    this.aCT.r(localArrayList);
    AppMethodBeat.o(76794);
  }
  
  public final <Model> List<n<Model, ?>> P(Model paramModel)
  {
    AppMethodBeat.i(76804);
    List localList = this.aCR.P(paramModel);
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
    ??? = this.aCZ.c(paramClass, paramClass1, paramClass2);
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
      ??? = this.aCT.h(paramClass, paramClass1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (Class)((Iterator)???).next();
        Iterator localIterator = this.aCW.d((Class)localObject3, paramClass2).iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          ((List)localObject1).add(new com.bumptech.glide.c.b.h(paramClass, (Class)localObject3, localClass, this.aCT.g(paramClass, (Class)localObject3), this.aCW.c((Class)localObject3, localClass), this.aDa));
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label249;
      }
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = this.aCZ;
      synchronized (((c)localObject3).aMX)
      {
        localObject3 = ((c)localObject3).aMX;
        paramClass1 = new com.bumptech.glide.h.h(paramClass, paramClass1, paramClass2);
        if (localObject1 != null)
        {
          paramClass = (Class<Data>)localObject1;
          ((android.support.v4.e.a)localObject3).put(paramClass1, paramClass);
          AppMethodBeat.o(76802);
          return localObject1;
          label249:
          localObject1 = new s(paramClass, paramClass1, paramClass2, (List)localObject1, this.aDa);
          continue;
        }
        paramClass = c.aMW;
      }
    }
  }
  
  public final h a(e.a<?> parama)
  {
    AppMethodBeat.i(76799);
    this.aCV.b(parama);
    AppMethodBeat.o(76799);
    return this;
  }
  
  public final <Data> h a(Class<Data> paramClass, com.bumptech.glide.c.d<Data> paramd)
  {
    AppMethodBeat.i(76795);
    this.aCS.b(paramClass, paramd);
    AppMethodBeat.o(76795);
    return this;
  }
  
  public final <TResource> h a(Class<TResource> paramClass, l<TResource> paraml)
  {
    AppMethodBeat.i(76798);
    this.aCU.b(paramClass, paraml);
    AppMethodBeat.o(76798);
    return this;
  }
  
  public final <Model, Data> h a(Class<Model> paramClass, Class<Data> paramClass1, o<Model, Data> paramo)
  {
    AppMethodBeat.i(76801);
    this.aCR.b(paramClass, paramClass1, paramo);
    AppMethodBeat.o(76801);
    return this;
  }
  
  public final <TResource, Transcode> h a(Class<TResource> paramClass, Class<Transcode> paramClass1, com.bumptech.glide.c.d.f.e<TResource, Transcode> parame)
  {
    AppMethodBeat.i(76800);
    this.aCW.b(paramClass, paramClass1, parame);
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
    this.aCT.a(paramString, paramk, paramClass, paramClass1);
    AppMethodBeat.o(76797);
    return this;
  }
  
  public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> paramClass, Class<TResource> paramClass1, Class<Transcode> arg3)
  {
    AppMethodBeat.i(76803);
    Object localObject2 = this.aCY.f(paramClass, paramClass1);
    Object localObject1 = localObject2;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      localObject2 = this.aCR.q(paramClass).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Class)((Iterator)localObject2).next();
        localObject3 = this.aCT.h((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject3).next();
          if ((!this.aCW.d(localClass, ???).isEmpty()) && (!((List)localObject1).contains(localClass))) {
            ((List)localObject1).add(localClass);
          }
        }
      }
      localObject2 = this.aCY;
      localObject3 = Collections.unmodifiableList((List)localObject1);
    }
    synchronized (((com.bumptech.glide.e.d)localObject2).aNa)
    {
      ((com.bumptech.glide.e.d)localObject2).aNa.put(new com.bumptech.glide.h.h(paramClass, paramClass1), localObject3);
      AppMethodBeat.o(76803);
      return localObject1;
    }
  }
  
  public final List<com.bumptech.glide.c.f> nL()
  {
    AppMethodBeat.i(76805);
    Object localObject = this.aCX.pQ();
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