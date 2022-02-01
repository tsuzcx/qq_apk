package android.support.v4.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import android.support.v4.e.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T>
{
  public final l.a<ArrayList<T>> Rv = new l.b(10);
  public final n<T, ArrayList<T>> Rw = new n();
  private final ArrayList<T> Rx = new ArrayList();
  private final HashSet<T> Ry = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (paramHashSet.contains(paramT)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.Rw.get(paramT);
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
  
  public final void H(T paramT)
  {
    if (!this.Rw.containsKey(paramT)) {
      this.Rw.put(paramT, null);
    }
  }
  
  public final List I(T paramT)
  {
    return (List)this.Rw.get(paramT);
  }
  
  public final List<T> J(T paramT)
  {
    Object localObject1 = null;
    int j = this.Rw.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.Rw.valueAt(i);
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
      ((ArrayList)localObject1).add(this.Rw.keyAt(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }
  
  public final ArrayList<T> fv()
  {
    this.Rx.clear();
    this.Ry.clear();
    int i = 0;
    int j = this.Rw.size();
    while (i < j)
    {
      a(this.Rw.keyAt(i), this.Rx, this.Ry);
      i += 1;
    }
    return this.Rx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */