package android.support.v4.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import android.support.v4.e.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T>
{
  public final l.a<ArrayList<T>> QA = new l.b(10);
  public final n<T, ArrayList<T>> QB = new n();
  private final ArrayList<T> QC = new ArrayList();
  private final HashSet<T> QD = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (paramHashSet.contains(paramT)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.QB.get(paramT);
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
  
  public final void F(T paramT)
  {
    if (!this.QB.containsKey(paramT)) {
      this.QB.put(paramT, null);
    }
  }
  
  public final List G(T paramT)
  {
    return (List)this.QB.get(paramT);
  }
  
  public final List<T> H(T paramT)
  {
    Object localObject1 = null;
    int j = this.QB.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.QB.valueAt(i);
      localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramT))
        {
          if (localObject1 != null) {
            break label99;
          }
          localObject1 = new ArrayList();
        }
      }
    }
    label99:
    for (;;)
    {
      ((ArrayList)localObject1).add(this.QB.keyAt(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }
  
  public final ArrayList<T> fn()
  {
    this.QC.clear();
    this.QD.clear();
    int i = 0;
    int j = this.QB.size();
    while (i < j)
    {
      a(this.QB.keyAt(i), this.QC, this.QD);
      i += 1;
    }
    return this.QC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */