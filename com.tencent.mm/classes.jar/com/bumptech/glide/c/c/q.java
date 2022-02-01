package com.bumptech.glide.c.c;

import android.support.v4.e.l.a;
import com.bumptech.glide.c.a;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.b.p;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class q<Model, Data>
  implements n<Model, Data>
{
  private final List<n<Model, Data>> aFX;
  private final l.a<List<Throwable>> aKu;
  
  q(List<n<Model, Data>> paramList, l.a<List<Throwable>> parama)
  {
    this.aFX = paramList;
    this.aKu = parama;
  }
  
  public final boolean X(Model paramModel)
  {
    AppMethodBeat.i(77285);
    Iterator localIterator = this.aFX.iterator();
    while (localIterator.hasNext()) {
      if (((n)localIterator.next()).X(paramModel))
      {
        AppMethodBeat.o(77285);
        return true;
      }
    }
    AppMethodBeat.o(77285);
    return false;
  }
  
  public final n.a<Data> b(Model paramModel, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(77284);
    int j = this.aFX.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    h localh = null;
    if (i < j)
    {
      Object localObject = (n)this.aFX.get(i);
      if (!((n)localObject).X(paramModel)) {
        break label167;
      }
      localObject = ((n)localObject).b(paramModel, paramInt1, paramInt2, paramj);
      if (localObject == null) {
        break label167;
      }
      localh = ((n.a)localObject).aFW;
      localArrayList.add(((n.a)localObject).aKp);
    }
    label167:
    for (;;)
    {
      i += 1;
      break;
      if ((!localArrayList.isEmpty()) && (localh != null))
      {
        paramModel = new n.a(localh, new a(localArrayList, this.aKu));
        AppMethodBeat.o(77284);
        return paramModel;
      }
      AppMethodBeat.o(77284);
      return null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77286);
    String str = "MultiModelLoader{modelLoaders=" + Arrays.toString(this.aFX.toArray()) + '}';
    AppMethodBeat.o(77286);
    return str;
  }
  
  static final class a<Data>
    implements d<Data>, d.a<Data>
  {
    private final l.a<List<Throwable>> aDa;
    private g aGk;
    private final List<d<Data>> aKv;
    private d.a<? super Data> aKw;
    private List<Throwable> aKx;
    private int currentIndex;
    
    a(List<d<Data>> paramList, l.a<List<Throwable>> parama)
    {
      AppMethodBeat.i(77275);
      this.aDa = parama;
      i.b(paramList);
      this.aKv = paramList;
      this.currentIndex = 0;
      AppMethodBeat.o(77275);
    }
    
    private void pp()
    {
      AppMethodBeat.i(77283);
      if (this.currentIndex < this.aKv.size() - 1)
      {
        this.currentIndex += 1;
        a(this.aGk, this.aKw);
        AppMethodBeat.o(77283);
        return;
      }
      i.checkNotNull(this.aKx, "Argument must not be null");
      this.aKw.e(new p("Fetch failed", new ArrayList(this.aKx)));
      AppMethodBeat.o(77283);
    }
    
    public final void S(Data paramData)
    {
      AppMethodBeat.i(77281);
      if (paramData != null)
      {
        this.aKw.S(paramData);
        AppMethodBeat.o(77281);
        return;
      }
      pp();
      AppMethodBeat.o(77281);
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77276);
      this.aGk = paramg;
      this.aKw = parama;
      this.aKx = ((List)this.aDa.acquire());
      ((d)this.aKv.get(this.currentIndex)).a(paramg, this);
      AppMethodBeat.o(77276);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(77278);
      Iterator localIterator = this.aKv.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cancel();
      }
      AppMethodBeat.o(77278);
    }
    
    public final void cleanup()
    {
      AppMethodBeat.i(77277);
      if (this.aKx != null) {
        this.aDa.release(this.aKx);
      }
      this.aKx = null;
      Iterator localIterator = this.aKv.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cleanup();
      }
      AppMethodBeat.o(77277);
    }
    
    public final void e(Exception paramException)
    {
      AppMethodBeat.i(77282);
      ((List)i.checkNotNull(this.aKx, "Argument must not be null")).add(paramException);
      pp();
      AppMethodBeat.o(77282);
    }
    
    public final Class<Data> om()
    {
      AppMethodBeat.i(77279);
      Class localClass = ((d)this.aKv.get(0)).om();
      AppMethodBeat.o(77279);
      return localClass;
    }
    
    public final a on()
    {
      AppMethodBeat.i(77280);
      a locala = ((d)this.aKv.get(0)).on();
      AppMethodBeat.o(77280);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.q
 * JD-Core Version:    0.7.0.1
 */