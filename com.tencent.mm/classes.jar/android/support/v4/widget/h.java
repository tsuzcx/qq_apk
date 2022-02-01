package android.support.v4.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import android.support.v4.e.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T>
{
  public final l.a<ArrayList<T>> Tk = new l.b(10);
  public final n<T, ArrayList<T>> Tl = new n();
  private final ArrayList<T> Tm = new ArrayList();
  private final HashSet<T> Tn = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (paramHashSet.contains(paramT)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.Tl.get(paramT);
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
    if (!this.Tl.containsKey(paramT)) {
      this.Tl.put(paramT, null);
    }
  }
  
  public final List J(T paramT)
  {
    return (List)this.Tl.get(paramT);
  }
  
  public final List<T> K(T paramT)
  {
    Object localObject1 = null;
    int j = this.Tl.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.Tl.valueAt(i);
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
      ((ArrayList)localObject1).add(this.Tl.keyAt(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }
  
  public final ArrayList<T> fM()
  {
    this.Tm.clear();
    this.Tn.clear();
    int i = 0;
    int j = this.Tl.size();
    while (i < j)
    {
      a(this.Tl.keyAt(i), this.Tm, this.Tn);
      i += 1;
    }
    return this.Tm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */