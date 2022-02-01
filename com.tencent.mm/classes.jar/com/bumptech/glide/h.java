package com.bumptech.glide;

import android.support.v4.e.l.a;
import com.bumptech.glide.d.b;
import com.bumptech.glide.d.c;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e.a;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.p;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private final p aCR;
  public final com.bumptech.glide.d.a aCS;
  private final com.bumptech.glide.d.e aCT;
  public final com.bumptech.glide.d.f aCU;
  public final com.bumptech.glide.load.a.f aCV;
  private final com.bumptech.glide.load.d.f.f aCW;
  private final b aCX;
  private final com.bumptech.glide.d.d aCY;
  private final c aCZ;
  private final l.a<List<Throwable>> aDa;
  
  public h()
  {
    AppMethodBeat.i(76794);
    this.aCY = new com.bumptech.glide.d.d();
    this.aCZ = new c();
    this.aDa = com.bumptech.glide.g.a.a.qy();
    this.aCR = new p(this.aDa);
    this.aCS = new com.bumptech.glide.d.a();
    this.aCT = new com.bumptech.glide.d.e();
    this.aCU = new com.bumptech.glide.d.f();
    this.aCV = new com.bumptech.glide.load.a.f();
    this.aCW = new com.bumptech.glide.load.d.f.f();
    this.aCX = new b();
    List localList = Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" });
    ArrayList localArrayList = new ArrayList(localList.size());
    localArrayList.addAll(localList);
    localArrayList.add(0, "legacy_prepend_all");
    localArrayList.add("legacy_append");
    this.aCT.r(localArrayList);
    AppMethodBeat.o(76794);
  }
  
  public final <Model> List<n<Model, ?>> P(Model paramModel)
  {
    AppMethodBeat.i(76804);
    List localList = this.aCR.s(paramModel.getClass());
    int m = localList.size();
    int i = 1;
    Object localObject1 = Collections.emptyList();
    int k = 0;
    while (k < m)
    {
      n localn = (n)localList.get(k);
      Object localObject2 = localObject1;
      int j = i;
      if (localn.X(paramModel))
      {
        j = i;
        if (i != 0)
        {
          localObject1 = new ArrayList(m - k);
          j = 0;
        }
        ((List)localObject1).add(localn);
        localObject2 = localObject1;
      }
      k += 1;
      localObject1 = localObject2;
      i = j;
    }
    if (((List)localObject1).isEmpty())
    {
      paramModel = new c(paramModel);
      AppMethodBeat.o(76804);
      throw paramModel;
    }
    AppMethodBeat.o(76804);
    return localObject1;
  }
  
  public final h a(ImageHeaderParser paramImageHeaderParser)
  {
    AppMethodBeat.i(204442);
    this.aCX.b(paramImageHeaderParser);
    AppMethodBeat.o(204442);
    return this;
  }
  
  public final h a(e.a<?> parama)
  {
    AppMethodBeat.i(76799);
    this.aCV.b(parama);
    AppMethodBeat.o(76799);
    return this;
  }
  
  public final <Data> h a(Class<Data> paramClass, com.bumptech.glide.load.d<Data> paramd)
  {
    AppMethodBeat.i(76795);
    this.aCS.b(paramClass, paramd);
    AppMethodBeat.o(76795);
    return this;
  }
  
  public final <TResource> h a(Class<TResource> paramClass, k<TResource> paramk)
  {
    AppMethodBeat.i(76798);
    this.aCU.b(paramClass, paramk);
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
  
  public final <TResource, Transcode> h a(Class<TResource> paramClass, Class<Transcode> paramClass1, com.bumptech.glide.load.d.f.e<TResource, Transcode> parame)
  {
    AppMethodBeat.i(76800);
    this.aCW.b(paramClass, paramClass1, parame);
    AppMethodBeat.o(76800);
    return this;
  }
  
  public final <Data, TResource> h a(Class<Data> paramClass, Class<TResource> paramClass1, j<Data, TResource> paramj)
  {
    AppMethodBeat.i(76796);
    a("legacy_append", paramClass, paramClass1, paramj);
    AppMethodBeat.o(76796);
    return this;
  }
  
  public final <Data, TResource> h a(String paramString, Class<Data> paramClass, Class<TResource> paramClass1, j<Data, TResource> paramj)
  {
    AppMethodBeat.i(76797);
    this.aCT.a(paramString, paramj, paramClass, paramClass1);
    AppMethodBeat.o(76797);
    return this;
  }
  
  public final <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    AppMethodBeat.i(76802);
    ??? = this.aCZ.c(paramClass, paramClass1, paramClass2);
    if (c.a((t)???))
    {
      AppMethodBeat.o(76802);
      return null;
    }
    Object localObject1 = ???;
    Object localObject3;
    if (??? == null)
    {
      localObject1 = new ArrayList();
      ??? = this.aCT.g(paramClass, paramClass1).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (Class)((Iterator)???).next();
        Iterator localIterator = this.aCW.d((Class)localObject3, paramClass2).iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          ((List)localObject1).add(new com.bumptech.glide.load.b.i(paramClass, (Class)localObject3, localClass, this.aCT.f(paramClass, (Class)localObject3), this.aCW.c((Class)localObject3, localClass), this.aDa));
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
      synchronized (((c)localObject3).aMO)
      {
        localObject3 = ((c)localObject3).aMO;
        paramClass1 = new com.bumptech.glide.g.i(paramClass, paramClass1, paramClass2);
        if (localObject1 != null)
        {
          paramClass = (Class<Data>)localObject1;
          ((android.support.v4.e.a)localObject3).put(paramClass1, paramClass);
          AppMethodBeat.o(76802);
          return localObject1;
          label249:
          localObject1 = new t(paramClass, paramClass1, paramClass2, (List)localObject1, this.aDa);
          continue;
        }
        paramClass = c.aMN;
      }
    }
  }
  
  public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    AppMethodBeat.i(76803);
    ??? = this.aCY.d(paramClass, paramClass1, paramClass2);
    Object localObject1 = ???;
    Object localObject3;
    Object localObject4;
    if (??? == null)
    {
      localObject1 = new ArrayList();
      ??? = this.aCR.r(paramClass).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (Class)((Iterator)???).next();
        localObject3 = this.aCT.g((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Class)((Iterator)localObject3).next();
          if ((!this.aCW.d((Class)localObject4, paramClass2).isEmpty()) && (!((List)localObject1).contains(localObject4))) {
            ((List)localObject1).add(localObject4);
          }
        }
      }
      localObject3 = this.aCY;
      localObject4 = Collections.unmodifiableList((List)localObject1);
    }
    synchronized (((com.bumptech.glide.d.d)localObject3).aMR)
    {
      ((com.bumptech.glide.d.d)localObject3).aMR.put(new com.bumptech.glide.g.i(paramClass, paramClass1, paramClass2), localObject4);
      AppMethodBeat.o(76803);
      return localObject1;
    }
  }
  
  public final List<ImageHeaderParser> nO()
  {
    AppMethodBeat.i(76805);
    Object localObject = this.aCX.pV();
    if (((List)localObject).isEmpty())
    {
      localObject = new b();
      AppMethodBeat.o(76805);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(76805);
    return localObject;
  }
  
  public static class a
    extends RuntimeException
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static final class b
    extends h.a
  {
    public b()
    {
      super();
    }
  }
  
  public static final class c
    extends h.a
  {
    public c(Class<?> paramClass1, Class<?> paramClass2)
    {
      super();
      AppMethodBeat.i(76791);
      AppMethodBeat.o(76791);
    }
    
    public c(Object paramObject)
    {
      super();
      AppMethodBeat.i(76790);
      AppMethodBeat.o(76790);
    }
  }
  
  public static final class d
    extends h.a
  {
    public d(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(76792);
      AppMethodBeat.o(76792);
    }
  }
  
  public static final class e
    extends h.a
  {
    public e(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(76793);
      AppMethodBeat.o(76793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h
 * JD-Core Version:    0.7.0.1
 */