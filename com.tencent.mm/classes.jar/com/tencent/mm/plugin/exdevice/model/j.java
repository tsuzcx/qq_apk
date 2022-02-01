package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static j rAp;
  private SparseArray<List<a>> rAq;
  
  private j()
  {
    AppMethodBeat.i(23375);
    this.rAq = new SparseArray();
    AppMethodBeat.o(23375);
  }
  
  public static j cKC()
  {
    AppMethodBeat.i(23376);
    if (rAp == null) {
      rAp = new j();
    }
    j localj = rAp;
    AppMethodBeat.o(23376);
    return localj;
  }
  
  public final boolean a(int paramInt, a parama)
  {
    AppMethodBeat.i(23377);
    if (parama == null)
    {
      AppMethodBeat.o(23377);
      return false;
    }
    List localList = (List)this.rAq.get(paramInt);
    Object localObject;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.rAq.put(paramInt, localObject);
    }
    do
    {
      boolean bool = ((List)localObject).add(parama);
      AppMethodBeat.o(23377);
      return bool;
      localObject = localList;
    } while (!localList.contains(parama));
    AppMethodBeat.o(23377);
    return false;
  }
  
  public final boolean b(int paramInt, a parama)
  {
    AppMethodBeat.i(23378);
    List localList = (List)this.rAq.get(paramInt);
    if (localList != null)
    {
      localList.remove(parama);
      if (localList.size() == 0) {
        this.rAq.remove(paramInt);
      }
    }
    AppMethodBeat.o(23378);
    return false;
  }
  
  public final void i(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23379);
    List localList = (List)this.rAq.get(paramInt);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(23379);
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      ((a)localList.get(i)).h(paramInt, paramVarArgs);
      i += 1;
    }
    AppMethodBeat.o(23379);
  }
  
  public static abstract interface a
  {
    public abstract void h(int paramInt, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.j
 * JD-Core Version:    0.7.0.1
 */