package androidx.camera.core;

import androidx.camera.core.impl.ap;
import androidx.camera.core.impl.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class q
{
  public static final q Gr;
  public static final q Gs;
  public LinkedHashSet<m> Gt;
  
  static
  {
    AppMethodBeat.i(198537);
    Gr = new a().aS(0).iJ();
    Gs = new a().aS(1).iJ();
    AppMethodBeat.o(198537);
  }
  
  q(LinkedHashSet<m> paramLinkedHashSet)
  {
    this.Gt = paramLinkedHashSet;
  }
  
  public final List<n> F(List<n> paramList)
  {
    AppMethodBeat.i(198551);
    Object localObject = new ArrayList(paramList);
    Iterator localIterator = this.Gt.iterator();
    while (localIterator.hasNext()) {
      localObject = ((m)localIterator.next()).F(Collections.unmodifiableList((List)localObject));
    }
    ((List)localObject).retainAll(paramList);
    AppMethodBeat.o(198551);
    return localObject;
  }
  
  public final t b(LinkedHashSet<t> paramLinkedHashSet)
  {
    AppMethodBeat.i(198544);
    paramLinkedHashSet = c(paramLinkedHashSet).iterator();
    if (paramLinkedHashSet.hasNext())
    {
      paramLinkedHashSet = (t)paramLinkedHashSet.next();
      AppMethodBeat.o(198544);
      return paramLinkedHashSet;
    }
    paramLinkedHashSet = new IllegalArgumentException("No available camera can be found");
    AppMethodBeat.o(198544);
    throw paramLinkedHashSet;
  }
  
  public final LinkedHashSet<t> c(LinkedHashSet<t> paramLinkedHashSet)
  {
    AppMethodBeat.i(198559);
    Object localObject1 = new ArrayList();
    Object localObject2 = paramLinkedHashSet.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((t)((Iterator)localObject2).next()).gK());
    }
    localObject1 = F((List)localObject1);
    localObject2 = new LinkedHashSet();
    paramLinkedHashSet = paramLinkedHashSet.iterator();
    while (paramLinkedHashSet.hasNext())
    {
      t localt = (t)paramLinkedHashSet.next();
      if (((List)localObject1).contains(localt.gK())) {
        ((LinkedHashSet)localObject2).add(localt);
      }
    }
    AppMethodBeat.o(198559);
    return localObject2;
  }
  
  public final Integer gW()
  {
    AppMethodBeat.i(198565);
    Iterator localIterator = this.Gt.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (m)localIterator.next();
      if ((localObject2 instanceof ap))
      {
        localObject2 = Integer.valueOf(((ap)localObject2).MO);
        if (localObject1 == null)
        {
          localObject1 = localObject2;
        }
        else if (!((Integer)localObject1).equals(localObject2))
        {
          localObject1 = new IllegalStateException("Multiple conflicting lens facing requirements exist.");
          AppMethodBeat.o(198565);
          throw ((Throwable)localObject1);
        }
      }
    }
    AppMethodBeat.o(198565);
    return localObject1;
  }
  
  public static final class a
  {
    public final LinkedHashSet<m> Gt;
    
    public a()
    {
      AppMethodBeat.i(198577);
      this.Gt = new LinkedHashSet();
      AppMethodBeat.o(198577);
    }
    
    public a(LinkedHashSet<m> paramLinkedHashSet)
    {
      AppMethodBeat.i(198584);
      this.Gt = new LinkedHashSet(paramLinkedHashSet);
      AppMethodBeat.o(198584);
    }
    
    public final a aS(int paramInt)
    {
      AppMethodBeat.i(198590);
      this.Gt.add(new ap(paramInt));
      AppMethodBeat.o(198590);
      return this;
    }
    
    public final q iJ()
    {
      AppMethodBeat.i(198593);
      q localq = new q(this.Gt);
      AppMethodBeat.o(198593);
      return localq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.q
 * JD-Core Version:    0.7.0.1
 */