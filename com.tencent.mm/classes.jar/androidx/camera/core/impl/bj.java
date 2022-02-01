package androidx.camera.core.impl;

import androidx.camera.core.al;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bj
{
  public final String AW;
  public final Map<String, b> ND;
  
  public bj(String paramString)
  {
    AppMethodBeat.i(198824);
    this.ND = new LinkedHashMap();
    this.AW = paramString;
    AppMethodBeat.o(198824);
  }
  
  private Collection<bb> a(a parama)
  {
    AppMethodBeat.i(198837);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ND.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((parama == null) || (parama.filter((b)localEntry.getValue()))) {
        localArrayList.add(((b)localEntry.getValue()).Cj);
      }
    }
    AppMethodBeat.o(198837);
    return localArrayList;
  }
  
  private b g(String paramString, bb parambb)
  {
    AppMethodBeat.i(198828);
    b localb2 = (b)this.ND.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(parambb);
      this.ND.put(paramString, localb1);
    }
    AppMethodBeat.o(198828);
    return localb1;
  }
  
  public final void Z(String paramString)
  {
    AppMethodBeat.i(198876);
    if (!this.ND.containsKey(paramString))
    {
      AppMethodBeat.o(198876);
      return;
    }
    b localb = (b)this.ND.get(paramString);
    localb.mActive = false;
    if (!localb.NE) {
      this.ND.remove(paramString);
    }
    AppMethodBeat.o(198876);
  }
  
  public final void aa(String paramString)
  {
    AppMethodBeat.i(198889);
    if (!this.ND.containsKey(paramString))
    {
      AppMethodBeat.o(198889);
      return;
    }
    b localb = (b)this.ND.get(paramString);
    localb.NE = false;
    if (!localb.mActive) {
      this.ND.remove(paramString);
    }
    AppMethodBeat.o(198889);
  }
  
  public final boolean ab(String paramString)
  {
    AppMethodBeat.i(198896);
    if (!this.ND.containsKey(paramString))
    {
      AppMethodBeat.o(198896);
      return false;
    }
    boolean bool = ((b)this.ND.get(paramString)).NE;
    AppMethodBeat.o(198896);
    return bool;
  }
  
  public final void d(String paramString, bb parambb)
  {
    AppMethodBeat.i(198869);
    g(paramString, parambb).mActive = true;
    AppMethodBeat.o(198869);
  }
  
  public final void e(String paramString, bb parambb)
  {
    AppMethodBeat.i(198885);
    g(paramString, parambb).NE = true;
    AppMethodBeat.o(198885);
  }
  
  public final void f(String paramString, bb parambb)
  {
    AppMethodBeat.i(198915);
    if (!this.ND.containsKey(paramString))
    {
      AppMethodBeat.o(198915);
      return;
    }
    parambb = new b(parambb);
    b localb = (b)this.ND.get(paramString);
    parambb.NE = localb.NE;
    parambb.mActive = localb.mActive;
    this.ND.put(paramString, parambb);
    AppMethodBeat.o(198915);
  }
  
  public final Collection<bb> kC()
  {
    AppMethodBeat.i(198902);
    Collection localCollection = Collections.unmodifiableCollection(a(bj..ExternalSyntheticLambda1.INSTANCE));
    AppMethodBeat.o(198902);
    return localCollection;
  }
  
  public final Collection<bb> kD()
  {
    AppMethodBeat.i(198909);
    Collection localCollection = Collections.unmodifiableCollection(a(bj..ExternalSyntheticLambda0.INSTANCE));
    AppMethodBeat.o(198909);
    return localCollection;
  }
  
  public final bb.f kE()
  {
    AppMethodBeat.i(198922);
    bb.f localf = new bb.f();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ND.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      b localb = (b)localEntry.getValue();
      if (localb.NE)
      {
        localf.e(localb.Cj);
        localArrayList.add((String)localEntry.getKey());
      }
    }
    new StringBuilder("All use case: ").append(localArrayList).append(" for camera: ").append(this.AW);
    al.O("UseCaseAttachState");
    AppMethodBeat.o(198922);
    return localf;
  }
  
  static abstract interface a
  {
    public abstract boolean filter(bj.b paramb);
  }
  
  public static final class b
  {
    public final bb Cj;
    public boolean NE = false;
    public boolean mActive = false;
    
    b(bb parambb)
    {
      this.Cj = parambb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bj
 * JD-Core Version:    0.7.0.1
 */