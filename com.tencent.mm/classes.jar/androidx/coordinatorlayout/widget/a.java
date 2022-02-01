package androidx.coordinatorlayout.widget;

import androidx.b.g;
import androidx.core.f.f.a;
import androidx.core.f.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a<T>
{
  final f.a<ArrayList<T>> HG;
  final g<T, ArrayList<T>> HH;
  private final ArrayList<T> HI;
  private final HashSet<T> HJ;
  
  public a()
  {
    AppMethodBeat.i(263443);
    this.HG = new f.b(10);
    this.HH = new g();
    this.HI = new ArrayList();
    this.HJ = new HashSet();
    AppMethodBeat.o(263443);
  }
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    AppMethodBeat.i(263449);
    if (paramArrayList.contains(paramT))
    {
      AppMethodBeat.o(263449);
      return;
    }
    if (paramHashSet.contains(paramT))
    {
      paramT = new RuntimeException("This graph contains cyclic dependencies");
      AppMethodBeat.o(263449);
      throw paramT;
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.HH.get(paramT);
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
    AppMethodBeat.o(263449);
  }
  
  public final ArrayList<T> gh()
  {
    AppMethodBeat.i(263447);
    this.HI.clear();
    this.HJ.clear();
    int i = 0;
    int j = this.HH.size();
    while (i < j)
    {
      a(this.HH.aO(i), this.HI, this.HJ);
      i += 1;
    }
    ArrayList localArrayList = this.HI;
    AppMethodBeat.o(263447);
    return localArrayList;
  }
  
  public final void v(T paramT)
  {
    AppMethodBeat.i(263444);
    if (!this.HH.containsKey(paramT)) {
      this.HH.put(paramT, null);
    }
    AppMethodBeat.o(263444);
  }
  
  public final List w(T paramT)
  {
    AppMethodBeat.i(263446);
    paramT = (List)this.HH.get(paramT);
    AppMethodBeat.o(263446);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */