package android.support.v4.widget;

import android.support.v4.f.k.a;
import android.support.v4.f.k.b;
import android.support.v4.f.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T>
{
  public final k.a<ArrayList<T>> JU = new k.b(10);
  public final m<T, ArrayList<T>> JV = new m();
  private final ArrayList<T> JW = new ArrayList();
  private final HashSet<T> JX = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (paramHashSet.contains(paramT)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.JV.get(paramT);
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
  }
  
  public final void I(T paramT)
  {
    if (!this.JV.containsKey(paramT)) {
      this.JV.put(paramT, null);
    }
  }
  
  public final List J(T paramT)
  {
    return (List)this.JV.get(paramT);
  }
  
  public final ArrayList<T> dE()
  {
    this.JW.clear();
    this.JX.clear();
    int i = 0;
    int j = this.JV.size();
    while (i < j)
    {
      a(this.JV.keyAt(i), this.JW, this.JX);
      i += 1;
    }
    return this.JW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */