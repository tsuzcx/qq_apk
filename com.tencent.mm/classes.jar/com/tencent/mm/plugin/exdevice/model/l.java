package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  private static l yrU;
  private SparseArray<List<a>> yrV;
  
  private l()
  {
    AppMethodBeat.i(23375);
    this.yrV = new SparseArray();
    AppMethodBeat.o(23375);
  }
  
  public static l dFF()
  {
    AppMethodBeat.i(23376);
    if (yrU == null) {
      yrU = new l();
    }
    l locall = yrU;
    AppMethodBeat.o(23376);
    return locall;
  }
  
  public final boolean a(int paramInt, a parama)
  {
    AppMethodBeat.i(23377);
    if (parama == null)
    {
      AppMethodBeat.o(23377);
      return false;
    }
    List localList = (List)this.yrV.get(paramInt);
    Object localObject;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.yrV.put(paramInt, localObject);
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
    List localList = (List)this.yrV.get(paramInt);
    if (localList != null)
    {
      localList.remove(parama);
      if (localList.size() == 0) {
        this.yrV.remove(paramInt);
      }
    }
    AppMethodBeat.o(23378);
    return false;
  }
  
  public final void i(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23379);
    List localList = (List)this.yrV.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */