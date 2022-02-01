package androidx.coordinatorlayout.widget;

import androidx.b.g;
import androidx.core.f.e.a;
import androidx.core.f.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a<T>
{
  final e.a<ArrayList<T>> bnH;
  final g<T, ArrayList<T>> bnI;
  private final ArrayList<T> bnJ;
  private final HashSet<T> bnK;
  
  public a()
  {
    AppMethodBeat.i(193116);
    this.bnH = new e.b(10);
    this.bnI = new g();
    this.bnJ = new ArrayList();
    this.bnK = new HashSet();
    AppMethodBeat.o(193116);
  }
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    AppMethodBeat.i(193123);
    if (paramArrayList.contains(paramT))
    {
      AppMethodBeat.o(193123);
      return;
    }
    if (paramHashSet.contains(paramT))
    {
      paramT = new RuntimeException("This graph contains cyclic dependencies");
      AppMethodBeat.o(193123);
      throw paramT;
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.bnI.get(paramT);
    if (localArrayList != null)
    {
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        a(localArrayList.get(i), paramArrayList, paramHashSet);
        i += 1;
      }
    }
    paramHashSet.remove(paramT);
    paramArrayList.add(paramT);
    AppMethodBeat.o(193123);
  }
  
  public final ArrayList<T> Dt()
  {
    AppMethodBeat.i(193143);
    this.bnJ.clear();
    this.bnK.clear();
    int i = 0;
    int j = this.bnI.size();
    while (i < j)
    {
      a(this.bnI.bn(i), this.bnJ, this.bnK);
      i += 1;
    }
    ArrayList localArrayList = this.bnJ;
    AppMethodBeat.o(193143);
    return localArrayList;
  }
  
  public final void au(T paramT)
  {
    AppMethodBeat.i(193131);
    if (!this.bnI.containsKey(paramT)) {
      this.bnI.put(paramT, null);
    }
    AppMethodBeat.o(193131);
  }
  
  public final List av(T paramT)
  {
    AppMethodBeat.i(193138);
    paramT = (List)this.bnI.get(paramT);
    AppMethodBeat.o(193138);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */