package android.support.v4.widget;

import android.support.v4.e.k.a;
import android.support.v4.e.k.b;
import android.support.v4.e.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T>
{
  public final k.a<ArrayList<T>> JA = new k.b(10);
  public final m<T, ArrayList<T>> JB = new m();
  private final ArrayList<T> JC = new ArrayList();
  private final HashSet<T> JD = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (paramHashSet.contains(paramT)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.JB.get(paramT);
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
  
  public final void G(T paramT)
  {
    if (!this.JB.containsKey(paramT)) {
      this.JB.put(paramT, null);
    }
  }
  
  public final List H(T paramT)
  {
    return (List)this.JB.get(paramT);
  }
  
  public final List<T> I(T paramT)
  {
    Object localObject1 = null;
    int j = this.JB.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.JB.valueAt(i);
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
      ((ArrayList)localObject1).add(this.JB.keyAt(i));
      localObject2 = localObject1;
      i += 1;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }
  
  public final ArrayList<T> dV()
  {
    this.JC.clear();
    this.JD.clear();
    int i = 0;
    int j = this.JB.size();
    while (i < j)
    {
      a(this.JB.keyAt(i), this.JC, this.JD);
      i += 1;
    }
    return this.JC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */