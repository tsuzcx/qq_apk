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
  e aAw;
  Class<Transcode> aBm;
  Object aBp;
  private final List<com.bumptech.glide.c.h> aEb;
  com.bumptech.glide.c.h aEk;
  j aEm;
  private final List<n.a<?>> aEn;
  Class<?> aEo;
  g.d aEp;
  Map<Class<?>, m<?>> aEq;
  private boolean aEr;
  private boolean aEs;
  g aEt;
  i aEu;
  boolean aEv;
  boolean aEw;
  int height;
  int width;
  
  f()
  {
    AppMethodBeat.i(76932);
    this.aEn = new ArrayList();
    this.aEb = new ArrayList();
    AppMethodBeat.o(76932);
  }
  
  final void clear()
  {
    AppMethodBeat.i(76933);
    this.aAw = null;
    this.aBp = null;
    this.aEk = null;
    this.aEo = null;
    this.aBm = null;
    this.aEm = null;
    this.aEt = null;
    this.aEq = null;
    this.aEu = null;
    this.aEn.clear();
    this.aEr = false;
    this.aEb.clear();
    this.aEs = false;
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
    paramClass = this.aAw.aAx.a(paramClass, this.aEo, this.aBm);
    AppMethodBeat.o(76936);
    return paramClass;
  }
  
  final <Z> m<Z> m(Class<Z> paramClass)
  {
    AppMethodBeat.i(76937);
    m localm = (m)this.aEq.get(paramClass);
    Object localObject = localm;
    if (localm == null)
    {
      Iterator localIterator = this.aEq.entrySet().iterator();
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
      if ((this.aEq.isEmpty()) && (this.aEv))
      {
        paramClass = new IllegalArgumentException("Missing transformation for " + paramClass + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        AppMethodBeat.o(76937);
        throw paramClass;
      }
      paramClass = b.pa();
      AppMethodBeat.o(76937);
      return paramClass;
    }
    AppMethodBeat.o(76937);
    return localObject;
  }
  
  final a ob()
  {
    AppMethodBeat.i(76934);
    a locala = this.aEp.ob();
    AppMethodBeat.o(76934);
    return locala;
  }
  
  final List<n.a<?>> oc()
  {
    AppMethodBeat.i(76939);
    if (!this.aEr)
    {
      this.aEr = true;
      this.aEn.clear();
      localList = this.aAw.aAx.O(this.aBp);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        n.a locala = ((n)localList.get(i)).b(this.aBp, this.width, this.height, this.aEm);
        if (locala != null) {
          this.aEn.add(locala);
        }
        i += 1;
      }
    }
    List localList = this.aEn;
    AppMethodBeat.o(76939);
    return localList;
  }
  
  final List<com.bumptech.glide.c.h> od()
  {
    AppMethodBeat.i(76940);
    if (!this.aEs)
    {
      this.aEs = true;
      this.aEb.clear();
      localList = oc();
      int k = localList.size();
      int i = 0;
      while (i < k)
      {
        n.a locala = (n.a)localList.get(i);
        if (!this.aEb.contains(locala.aEf)) {
          this.aEb.add(locala.aEf);
        }
        int j = 0;
        while (j < locala.aIx.size())
        {
          if (!this.aEb.contains(locala.aIx.get(j))) {
            this.aEb.add(locala.aIx.get(j));
          }
          j += 1;
        }
        i += 1;
      }
    }
    List localList = this.aEb;
    AppMethodBeat.o(76940);
    return localList;
  }
  
  final List<n<File, ?>> t(File paramFile)
  {
    AppMethodBeat.i(76938);
    paramFile = this.aAw.aAx.O(paramFile);
    AppMethodBeat.o(76938);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.f
 * JD-Core Version:    0.7.0.1
 */