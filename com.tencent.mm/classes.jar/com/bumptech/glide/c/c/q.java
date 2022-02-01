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
  private final List<n<Model, Data>> aEg;
  private final l.a<List<Throwable>> aID;
  
  q(List<n<Model, Data>> paramList, l.a<List<Throwable>> parama)
  {
    this.aEg = paramList;
    this.aID = parama;
  }
  
  public final boolean W(Model paramModel)
  {
    AppMethodBeat.i(77285);
    Iterator localIterator = this.aEg.iterator();
    while (localIterator.hasNext()) {
      if (((n)localIterator.next()).W(paramModel))
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
    int j = this.aEg.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    h localh = null;
    if (i < j)
    {
      Object localObject = (n)this.aEg.get(i);
      if (!((n)localObject).W(paramModel)) {
        break label167;
      }
      localObject = ((n)localObject).b(paramModel, paramInt1, paramInt2, paramj);
      if (localObject == null) {
        break label167;
      }
      localh = ((n.a)localObject).aEf;
      localArrayList.add(((n.a)localObject).aIy);
    }
    label167:
    for (;;)
    {
      i += 1;
      break;
      if ((!localArrayList.isEmpty()) && (localh != null))
      {
        paramModel = new n.a(localh, new a(localArrayList, this.aID));
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
    String str = "MultiModelLoader{modelLoaders=" + Arrays.toString(this.aEg.toArray()) + '}';
    AppMethodBeat.o(77286);
    return str;
  }
  
  static final class a<Data>
    implements d<Data>, d.a<Data>
  {
    private final l.a<List<Throwable>> aBj;
    private g aEt;
    private final List<d<Data>> aIE;
    private d.a<? super Data> aIF;
    private List<Throwable> aIG;
    private int currentIndex;
    
    a(List<d<Data>> paramList, l.a<List<Throwable>> parama)
    {
      AppMethodBeat.i(77275);
      this.aBj = parama;
      i.b(paramList);
      this.aIE = paramList;
      this.currentIndex = 0;
      AppMethodBeat.o(77275);
    }
    
    private void oX()
    {
      AppMethodBeat.i(77283);
      if (this.currentIndex < this.aIE.size() - 1)
      {
        this.currentIndex += 1;
        a(this.aEt, this.aIF);
        AppMethodBeat.o(77283);
        return;
      }
      i.checkNotNull(this.aIG, "Argument must not be null");
      this.aIF.e(new p("Fetch failed", new ArrayList(this.aIG)));
      AppMethodBeat.o(77283);
    }
    
    public final void R(Data paramData)
    {
      AppMethodBeat.i(77281);
      if (paramData != null)
      {
        this.aIF.R(paramData);
        AppMethodBeat.o(77281);
        return;
      }
      oX();
      AppMethodBeat.o(77281);
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77276);
      this.aEt = paramg;
      this.aIF = parama;
      this.aIG = ((List)this.aBj.acquire());
      ((d)this.aIE.get(this.currentIndex)).a(paramg, this);
      AppMethodBeat.o(77276);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(77278);
      Iterator localIterator = this.aIE.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cancel();
      }
      AppMethodBeat.o(77278);
    }
    
    public final void cleanup()
    {
      AppMethodBeat.i(77277);
      if (this.aIG != null) {
        this.aBj.release(this.aIG);
      }
      this.aIG = null;
      Iterator localIterator = this.aIE.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cleanup();
      }
      AppMethodBeat.o(77277);
    }
    
    public final void e(Exception paramException)
    {
      AppMethodBeat.i(77282);
      ((List)i.checkNotNull(this.aIG, "Argument must not be null")).add(paramException);
      oX();
      AppMethodBeat.o(77282);
    }
    
    public final Class<Data> nU()
    {
      AppMethodBeat.i(77279);
      Class localClass = ((d)this.aIE.get(0)).nU();
      AppMethodBeat.o(77279);
      return localClass;
    }
    
    public final a nV()
    {
      AppMethodBeat.i(77280);
      a locala = ((d)this.aIE.get(0)).nV();
      AppMethodBeat.o(77280);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.q
 * JD-Core Version:    0.7.0.1
 */