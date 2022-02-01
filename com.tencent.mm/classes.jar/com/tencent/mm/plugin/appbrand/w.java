package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class w
{
  public final SparseArray<List<b>> nxF;
  final SparseIntArray nxG;
  
  private w()
  {
    AppMethodBeat.i(134601);
    this.nxF = new SparseArray();
    this.nxG = new SparseIntArray();
    AppMethodBeat.o(134601);
  }
  
  public final void e(int paramInt, List<b> paramList)
  {
    AppMethodBeat.i(134605);
    if (this.nxG.size() <= 0)
    {
      AppMethodBeat.o(134605);
      return;
    }
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.nxG.indexOfKey(paramInt) < 0)
    {
      Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      AppMethodBeat.o(134605);
      return;
    }
    this.nxG.delete(paramInt);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((b)paramList.get(paramInt)).acr();
      paramInt += 1;
    }
    AppMethodBeat.o(134605);
  }
  
  public static abstract interface b
  {
    public abstract void acr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w
 * JD-Core Version:    0.7.0.1
 */