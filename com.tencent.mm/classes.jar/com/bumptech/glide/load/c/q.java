package com.bumptech.glide.load.c;

import android.support.v4.e.l.a;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class q<Model, Data>
  implements n<Model, Data>
{
  private final List<n<Model, Data>> aFP;
  private final l.a<List<Throwable>> aKm;
  
  q(List<n<Model, Data>> paramList, l.a<List<Throwable>> parama)
  {
    this.aFP = paramList;
    this.aKm = parama;
  }
  
  public final boolean X(Model paramModel)
  {
    AppMethodBeat.i(77285);
    Iterator localIterator = this.aFP.iterator();
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
  
  public final n.a<Data> b(Model paramModel, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(77284);
    int j = this.aFP.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    com.bumptech.glide.load.g localg = null;
    if (i < j)
    {
      Object localObject = (n)this.aFP.get(i);
      if (!((n)localObject).X(paramModel)) {
        break label167;
      }
      localObject = ((n)localObject).b(paramModel, paramInt1, paramInt2, parami);
      if (localObject == null) {
        break label167;
      }
      localg = ((n.a)localObject).aFO;
      localArrayList.add(((n.a)localObject).aKh);
    }
    label167:
    for (;;)
    {
      i += 1;
      break;
      if ((!localArrayList.isEmpty()) && (localg != null))
      {
        paramModel = new n.a(localg, new a(localArrayList, this.aKm));
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
    String str = "MultiModelLoader{modelLoaders=" + Arrays.toString(this.aFP.toArray()) + '}';
    AppMethodBeat.o(77286);
    return str;
  }
  
  static final class a<Data>
    implements d<Data>, d.a<Data>
  {
    private final l.a<List<Throwable>> aDa;
    private com.bumptech.glide.g aGc;
    private final List<d<Data>> aKn;
    private d.a<? super Data> aKo;
    private List<Throwable> aKp;
    private int currentIndex;
    private boolean isCancelled;
    
    a(List<d<Data>> paramList, l.a<List<Throwable>> parama)
    {
      AppMethodBeat.i(77275);
      this.aDa = parama;
      j.b(paramList);
      this.aKn = paramList;
      this.currentIndex = 0;
      AppMethodBeat.o(77275);
    }
    
    private void pu()
    {
      AppMethodBeat.i(77283);
      if (this.isCancelled)
      {
        AppMethodBeat.o(77283);
        return;
      }
      if (this.currentIndex < this.aKn.size() - 1)
      {
        this.currentIndex += 1;
        a(this.aGc, this.aKo);
        AppMethodBeat.o(77283);
        return;
      }
      j.checkNotNull(this.aKp, "Argument must not be null");
      this.aKo.e(new com.bumptech.glide.load.b.q("Fetch failed", new ArrayList(this.aKp)));
      AppMethodBeat.o(77283);
    }
    
    public final void S(Data paramData)
    {
      AppMethodBeat.i(77281);
      if (paramData != null)
      {
        this.aKo.S(paramData);
        AppMethodBeat.o(77281);
        return;
      }
      pu();
      AppMethodBeat.o(77281);
    }
    
    public final void a(com.bumptech.glide.g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77276);
      this.aGc = paramg;
      this.aKo = parama;
      this.aKp = ((List)this.aDa.acquire());
      ((d)this.aKn.get(this.currentIndex)).a(paramg, this);
      if (this.isCancelled) {
        cancel();
      }
      AppMethodBeat.o(77276);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(77278);
      this.isCancelled = true;
      Iterator localIterator = this.aKn.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cancel();
      }
      AppMethodBeat.o(77278);
    }
    
    public final void cleanup()
    {
      AppMethodBeat.i(77277);
      if (this.aKp != null) {
        this.aDa.release(this.aKp);
      }
      this.aKp = null;
      Iterator localIterator = this.aKn.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cleanup();
      }
      AppMethodBeat.o(77277);
    }
    
    public final void e(Exception paramException)
    {
      AppMethodBeat.i(77282);
      ((List)j.checkNotNull(this.aKp, "Argument must not be null")).add(paramException);
      pu();
      AppMethodBeat.o(77282);
    }
    
    public final Class<Data> os()
    {
      AppMethodBeat.i(77279);
      Class localClass = ((d)this.aKn.get(0)).os();
      AppMethodBeat.o(77279);
      return localClass;
    }
    
    public final a ot()
    {
      AppMethodBeat.i(77280);
      a locala = ((d)this.aKn.get(0)).ot();
      AppMethodBeat.o(77280);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.q
 * JD-Core Version:    0.7.0.1
 */