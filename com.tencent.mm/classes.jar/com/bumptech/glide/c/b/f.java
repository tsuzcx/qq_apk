package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.b.a;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.n.a;
import com.bumptech.glide.c.d.b;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.m;
import com.bumptech.glide.e;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class f<Transcode>
{
  Class<Transcode> aAs;
  Object aAv;
  private boolean aDA;
  private boolean aDB;
  g aDC;
  i aDD;
  boolean aDE;
  boolean aDF;
  private final List<com.bumptech.glide.c.h> aDk;
  com.bumptech.glide.c.h aDt;
  j aDv;
  private final List<n.a<?>> aDw;
  Class<?> aDx;
  g.d aDy;
  Map<Class<?>, m<?>> aDz;
  e azC;
  int height;
  int width;
  
  f()
  {
    AppMethodBeat.i(76932);
    this.aDw = new ArrayList();
    this.aDk = new ArrayList();
    AppMethodBeat.o(76932);
  }
  
  final void clear()
  {
    AppMethodBeat.i(76933);
    this.azC = null;
    this.aAv = null;
    this.aDt = null;
    this.aDx = null;
    this.aAs = null;
    this.aDv = null;
    this.aDC = null;
    this.aDz = null;
    this.aDD = null;
    this.aDw.clear();
    this.aDA = false;
    this.aDk.clear();
    this.aDB = false;
    AppMethodBeat.o(76933);
  }
  
  final boolean k(Class<?> paramClass)
  {
    AppMethodBeat.i(76935);
    if (l(paramClass) != null)
    {
      AppMethodBeat.o(76935);
      return true;
    }
    AppMethodBeat.o(76935);
    return false;
  }
  
  final <Data> s<Data, ?, Transcode> l(Class<Data> paramClass)
  {
    AppMethodBeat.i(76936);
    paramClass = this.azC.azD.a(paramClass, this.aDx, this.aAs);
    AppMethodBeat.o(76936);
    return paramClass;
  }
  
  final <Z> m<Z> m(Class<Z> paramClass)
  {
    AppMethodBeat.i(76937);
    m localm = (m)this.aDz.get(paramClass);
    Object localObject = localm;
    if (localm == null)
    {
      Iterator localIterator = this.aDz.entrySet().iterator();
      do
      {
        localObject = localm;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass));
      localObject = (m)((Map.Entry)localObject).getValue();
    }
    if (localObject == null)
    {
      if ((this.aDz.isEmpty()) && (this.aDE))
      {
        paramClass = new IllegalArgumentException("Missing transformation for " + paramClass + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        AppMethodBeat.o(76937);
        throw paramClass;
      }
      paramClass = b.oQ();
      AppMethodBeat.o(76937);
      return paramClass;
    }
    AppMethodBeat.o(76937);
    return localObject;
  }
  
  final a nR()
  {
    AppMethodBeat.i(76934);
    a locala = this.aDy.nR();
    AppMethodBeat.o(76934);
    return locala;
  }
  
  final List<n.a<?>> nS()
  {
    AppMethodBeat.i(76939);
    if (!this.aDA)
    {
      this.aDA = true;
      this.aDw.clear();
      localList = this.azC.azD.M(this.aAv);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        n.a locala = ((n)localList.get(i)).b(this.aAv, this.width, this.height, this.aDv);
        if (locala != null) {
          this.aDw.add(locala);
        }
        i += 1;
      }
    }
    List localList = this.aDw;
    AppMethodBeat.o(76939);
    return localList;
  }
  
  final List<com.bumptech.glide.c.h> nT()
  {
    AppMethodBeat.i(76940);
    if (!this.aDB)
    {
      this.aDB = true;
      this.aDk.clear();
      localList = nS();
      int k = localList.size();
      int i = 0;
      while (i < k)
      {
        n.a locala = (n.a)localList.get(i);
        if (!this.aDk.contains(locala.aDo)) {
          this.aDk.add(locala.aDo);
        }
        int j = 0;
        while (j < locala.aHH.size())
        {
          if (!this.aDk.contains(locala.aHH.get(j))) {
            this.aDk.add(locala.aHH.get(j));
          }
          j += 1;
        }
        i += 1;
      }
    }
    List localList = this.aDk;
    AppMethodBeat.o(76940);
    return localList;
  }
  
  final List<n<File, ?>> t(File paramFile)
  {
    AppMethodBeat.i(76938);
    paramFile = this.azC.azD.M(paramFile);
    AppMethodBeat.o(76938);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.f
 * JD-Core Version:    0.7.0.1
 */