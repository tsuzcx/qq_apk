package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class t
{
  public final SparseArray<List<b>> kEp;
  final SparseIntArray kEq;
  
  private t()
  {
    AppMethodBeat.i(134601);
    this.kEp = new SparseArray();
    this.kEq = new SparseIntArray();
    AppMethodBeat.o(134601);
  }
  
  public final void e(int paramInt, List<b> paramList)
  {
    AppMethodBeat.i(134605);
    if (this.kEq.size() <= 0)
    {
      AppMethodBeat.o(134605);
      return;
    }
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.kEq.indexOfKey(paramInt) < 0)
    {
      Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      AppMethodBeat.o(134605);
      return;
    }
    this.kEq.delete(paramInt);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((b)paramList.get(paramInt)).btg();
      paramInt += 1;
    }
    AppMethodBeat.o(134605);
  }
  
  public static final class a
  {
    public static t kEr;
    
    static
    {
      AppMethodBeat.i(134600);
      kEr = new t((byte)0);
      AppMethodBeat.o(134600);
    }
  }
  
  public static abstract interface b
  {
    public abstract void btg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t
 * JD-Core Version:    0.7.0.1
 */