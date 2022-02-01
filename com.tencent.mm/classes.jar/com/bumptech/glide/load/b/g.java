package com.bumptech.glide.load.b;

import com.bumptech.glide.e;
import com.bumptech.glide.h;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.n.a;
import com.bumptech.glide.load.d.b;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class g<Transcode>
{
  e aCm;
  Class<Transcode> aDd;
  Object aDf;
  private final List<com.bumptech.glide.load.g> aFK;
  com.bumptech.glide.load.g aFT;
  i aFV;
  private final List<n.a<?>> aFW;
  Class<?> aFX;
  h.d aFY;
  Map<Class<?>, l<?>> aFZ;
  private boolean aGa;
  private boolean aGb;
  com.bumptech.glide.g aGc;
  j aGd;
  boolean aGe;
  boolean aGf;
  int height;
  int width;
  
  g()
  {
    AppMethodBeat.i(76932);
    this.aFW = new ArrayList();
    this.aFK = new ArrayList();
    AppMethodBeat.o(76932);
  }
  
  final void clear()
  {
    AppMethodBeat.i(76933);
    this.aCm = null;
    this.aDf = null;
    this.aFT = null;
    this.aFX = null;
    this.aDd = null;
    this.aFV = null;
    this.aGc = null;
    this.aFZ = null;
    this.aGd = null;
    this.aFW.clear();
    this.aGa = false;
    this.aFK.clear();
    this.aGb = false;
    AppMethodBeat.o(76933);
  }
  
  final boolean l(Class<?> paramClass)
  {
    AppMethodBeat.i(76935);
    if (m(paramClass) != null)
    {
      AppMethodBeat.o(76935);
      return true;
    }
    AppMethodBeat.o(76935);
    return false;
  }
  
  final <Data> t<Data, ?, Transcode> m(Class<Data> paramClass)
  {
    AppMethodBeat.i(76936);
    paramClass = this.aCm.aCn.a(paramClass, this.aFX, this.aDd);
    AppMethodBeat.o(76936);
    return paramClass;
  }
  
  final <Z> l<Z> n(Class<Z> paramClass)
  {
    AppMethodBeat.i(76937);
    l locall = (l)this.aFZ.get(paramClass);
    Object localObject = locall;
    if (locall == null)
    {
      Iterator localIterator = this.aFZ.entrySet().iterator();
      do
      {
        localObject = locall;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass));
      localObject = (l)((Map.Entry)localObject).getValue();
    }
    if (localObject == null)
    {
      if ((this.aFZ.isEmpty()) && (this.aGe))
      {
        paramClass = new IllegalArgumentException("Missing transformation for " + paramClass + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        AppMethodBeat.o(76937);
        throw paramClass;
      }
      paramClass = b.px();
      AppMethodBeat.o(76937);
      return paramClass;
    }
    AppMethodBeat.o(76937);
    return localObject;
  }
  
  final List<n.a<?>> oA()
  {
    AppMethodBeat.i(76939);
    if (!this.aGa)
    {
      this.aGa = true;
      this.aFW.clear();
      localList = this.aCm.aCn.P(this.aDf);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        n.a locala = ((n)localList.get(i)).b(this.aDf, this.width, this.height, this.aFV);
        if (locala != null) {
          this.aFW.add(locala);
        }
        i += 1;
      }
    }
    List localList = this.aFW;
    AppMethodBeat.o(76939);
    return localList;
  }
  
  final List<com.bumptech.glide.load.g> oB()
  {
    AppMethodBeat.i(76940);
    if (!this.aGb)
    {
      this.aGb = true;
      this.aFK.clear();
      localList = oA();
      int k = localList.size();
      int i = 0;
      while (i < k)
      {
        n.a locala = (n.a)localList.get(i);
        if (!this.aFK.contains(locala.aFO)) {
          this.aFK.add(locala.aFO);
        }
        int j = 0;
        while (j < locala.aKg.size())
        {
          if (!this.aFK.contains(locala.aKg.get(j))) {
            this.aFK.add(locala.aKg.get(j));
          }
          j += 1;
        }
        i += 1;
      }
    }
    List localList = this.aFK;
    AppMethodBeat.o(76940);
    return localList;
  }
  
  final a oz()
  {
    AppMethodBeat.i(76934);
    a locala = this.aFY.oz();
    AppMethodBeat.o(76934);
    return locala;
  }
  
  final List<n<File, ?>> t(File paramFile)
  {
    AppMethodBeat.i(76938);
    paramFile = this.aCm.aCn.P(paramFile);
    AppMethodBeat.o(76938);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.g
 * JD-Core Version:    0.7.0.1
 */