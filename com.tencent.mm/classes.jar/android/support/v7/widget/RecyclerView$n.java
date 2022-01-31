package android.support.v7.widget;

import android.util.SparseArray;
import java.util.ArrayList;

public final class RecyclerView$n
{
  SparseArray<RecyclerView.n.a> ajB = new SparseArray();
  int ajC = 0;
  
  static long c(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return paramLong2;
    }
    return paramLong1 / 4L * 3L + paramLong2 / 4L;
  }
  
  final boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    long l = bZ(paramInt).ajF;
    return (l == 0L) || (l + paramLong1 < paramLong2);
  }
  
  public final void aB(int paramInt1, int paramInt2)
  {
    Object localObject = bZ(paramInt1);
    ((RecyclerView.n.a)localObject).ajE = paramInt2;
    localObject = ((RecyclerView.n.a)localObject).ajD;
    while (((ArrayList)localObject).size() > paramInt2) {
      ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
  }
  
  public final RecyclerView.v bY(int paramInt)
  {
    Object localObject = (RecyclerView.n.a)this.ajB.get(paramInt);
    if ((localObject != null) && (!((RecyclerView.n.a)localObject).ajD.isEmpty()))
    {
      localObject = ((RecyclerView.n.a)localObject).ajD;
      return (RecyclerView.v)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
    return null;
  }
  
  final RecyclerView.n.a bZ(int paramInt)
  {
    RecyclerView.n.a locala2 = (RecyclerView.n.a)this.ajB.get(paramInt);
    RecyclerView.n.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new RecyclerView.n.a();
      this.ajB.put(paramInt, locala1);
    }
    return locala1;
  }
  
  final void d(int paramInt, long paramLong)
  {
    RecyclerView.n.a locala = bZ(paramInt);
    locala.ajF = c(locala.ajF, paramLong);
  }
  
  final void detach()
  {
    this.ajC -= 1;
  }
  
  final void jE()
  {
    this.ajC += 1;
  }
  
  public final void p(RecyclerView.v paramv)
  {
    int i = paramv.aky;
    ArrayList localArrayList = bZ(i).ajD;
    if (((RecyclerView.n.a)this.ajB.get(i)).ajE <= localArrayList.size()) {
      return;
    }
    paramv.resetInternal();
    localArrayList.add(paramv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.n
 * JD-Core Version:    0.7.0.1
 */