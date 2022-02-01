package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class z
{
  public final SparseArray<List<b>> qwT;
  final SparseIntArray qwU;
  
  private z()
  {
    AppMethodBeat.i(134601);
    this.qwT = new SparseArray();
    this.qwU = new SparseIntArray();
    AppMethodBeat.o(134601);
  }
  
  public final void t(int paramInt, List<b> paramList)
  {
    AppMethodBeat.i(134605);
    if (this.qwU.size() <= 0)
    {
      AppMethodBeat.o(134605);
      return;
    }
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.qwU.indexOfKey(paramInt) < 0)
    {
      Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      AppMethodBeat.o(134605);
      return;
    }
    this.qwU.delete(paramInt);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((b)paramList.get(paramInt)).aEr();
      paramInt += 1;
    }
    AppMethodBeat.o(134605);
  }
  
  public static final class a
  {
    public static z qwV;
    
    static
    {
      AppMethodBeat.i(134600);
      qwV = new z((byte)0);
      AppMethodBeat.o(134600);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aEr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z
 * JD-Core Version:    0.7.0.1
 */