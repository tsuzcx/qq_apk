package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static j jvO;
  private SparseArray<List<j.a>> jvP = new SparseArray();
  
  public static j aLC()
  {
    if (jvO == null) {
      jvO = new j();
    }
    return jvO;
  }
  
  public final boolean a(int paramInt, j.a parama)
  {
    if (parama == null) {
      return false;
    }
    List localList = (List)this.jvP.get(paramInt);
    Object localObject;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.jvP.put(paramInt, localObject);
    }
    do
    {
      return ((List)localObject).add(parama);
      localObject = localList;
    } while (!localList.contains(parama));
    return false;
  }
  
  public final boolean b(int paramInt, j.a parama)
  {
    List localList = (List)this.jvP.get(paramInt);
    if (localList != null)
    {
      localList.remove(parama);
      if (localList.size() == 0) {
        this.jvP.remove(paramInt);
      }
    }
    return false;
  }
  
  public final void h(int paramInt, Object... paramVarArgs)
  {
    List localList = (List)this.jvP.get(paramInt);
    if ((localList == null) || (localList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < localList.size())
      {
        ((j.a)localList.get(i)).g(paramInt, paramVarArgs);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.j
 * JD-Core Version:    0.7.0.1
 */