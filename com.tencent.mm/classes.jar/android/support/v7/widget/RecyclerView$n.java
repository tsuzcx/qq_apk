package android.support.v7.widget;

import android.util.SparseArray;
import java.util.ArrayList;

public final class RecyclerView$n
{
  SparseArray<RecyclerView.n.a> ahl = new SparseArray();
  int ahm = 0;
  
  static long c(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return paramLong2;
    }
    return paramLong1 / 4L * 3L + paramLong2 / 4L;
  }
  
  public final void bS(int paramInt)
  {
    Object localObject = bT(paramInt);
    ((RecyclerView.n.a)localObject).aho = 10;
    localObject = ((RecyclerView.n.a)localObject).ahn;
    while (((ArrayList)localObject).size() > 10) {
      ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
  }
  
  final RecyclerView.n.a bT(int paramInt)
  {
    RecyclerView.n.a locala2 = (RecyclerView.n.a)this.ahl.get(paramInt);
    RecyclerView.n.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new RecyclerView.n.a();
      this.ahl.put(paramInt, locala1);
    }
    return locala1;
  }
  
  final void detach()
  {
    this.ahm -= 1;
  }
  
  final void hV()
  {
    this.ahm += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.n
 * JD-Core Version:    0.7.0.1
 */