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
  e aCn;
  Class<Transcode> aDd;
  Object aDg;
  private final List<com.bumptech.glide.c.h> aFS;
  com.bumptech.glide.c.h aGb;
  j aGd;
  private final List<n.a<?>> aGe;
  Class<?> aGf;
  g.d aGg;
  Map<Class<?>, m<?>> aGh;
  private boolean aGi;
  private boolean aGj;
  g aGk;
  i aGl;
  boolean aGm;
  boolean aGn;
  int height;
  int width;
  
  f()
  {
    AppMethodBeat.i(76932);
    this.aGe = new ArrayList();
    this.aFS = new ArrayList();
    AppMethodBeat.o(76932);
  }
  
  final void clear()
  {
    AppMethodBeat.i(76933);
    this.aCn = null;
    this.aDg = null;
    this.aGb = null;
    this.aGf = null;
    this.aDd = null;
    this.aGd = null;
    this.aGk = null;
    this.aGh = null;
    this.aGl = null;
    this.aGe.clear();
    this.aGi = false;
    this.aFS.clear();
    this.aGj = false;
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
    paramClass = this.aCn.aCo.a(paramClass, this.aGf, this.aDd);
    AppMethodBeat.o(76936);
    return paramClass;
  }
  
  final <Z> m<Z> m(Class<Z> paramClass)
  {
    AppMethodBeat.i(76937);
    m localm = (m)this.aGh.get(paramClass);
    Object localObject = localm;
    if (localm == null)
    {
      Iterator localIterator = this.aGh.entrySet().iterator();
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
      if ((this.aGh.isEmpty()) && (this.aGm))
      {
        paramClass = new IllegalArgumentException("Missing transformation for " + paramClass + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        AppMethodBeat.o(76937);
        throw paramClass;
      }
      paramClass = b.ps();
      AppMethodBeat.o(76937);
      return paramClass;
    }
    AppMethodBeat.o(76937);
    return localObject;
  }
  
  final a ot()
  {
    AppMethodBeat.i(76934);
    a locala = this.aGg.ot();
    AppMethodBeat.o(76934);
    return locala;
  }
  
  final List<n.a<?>> ou()
  {
    AppMethodBeat.i(76939);
    if (!this.aGi)
    {
      this.aGi = true;
      this.aGe.clear();
      localList = this.aCn.aCo.P(this.aDg);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        n.a locala = ((n)localList.get(i)).b(this.aDg, this.width, this.height, this.aGd);
        if (locala != null) {
          this.aGe.add(locala);
        }
        i += 1;
      }
    }
    List localList = this.aGe;
    AppMethodBeat.o(76939);
    return localList;
  }
  
  final List<com.bumptech.glide.c.h> ov()
  {
    AppMethodBeat.i(76940);
    if (!this.aGj)
    {
      this.aGj = true;
      this.aFS.clear();
      localList = ou();
      int k = localList.size();
      int i = 0;
      while (i < k)
      {
        n.a locala = (n.a)localList.get(i);
        if (!this.aFS.contains(locala.aFW)) {
          this.aFS.add(locala.aFW);
        }
        int j = 0;
        while (j < locala.aKo.size())
        {
          if (!this.aFS.contains(locala.aKo.get(j))) {
            this.aFS.add(locala.aKo.get(j));
          }
          j += 1;
        }
        i += 1;
      }
    }
    List localList = this.aFS;
    AppMethodBeat.o(76940);
    return localList;
  }
  
  final List<n<File, ?>> t(File paramFile)
  {
    AppMethodBeat.i(76938);
    paramFile = this.aCn.aCo.P(paramFile);
    AppMethodBeat.o(76938);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.f
 * JD-Core Version:    0.7.0.1
 */