package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class r
{
  public final SparseArray<List<b>> jhg;
  final SparseIntArray jhh;
  
  private r()
  {
    AppMethodBeat.i(134601);
    this.jhg = new SparseArray();
    this.jhh = new SparseIntArray();
    AppMethodBeat.o(134601);
  }
  
  public final void e(int paramInt, List<b> paramList)
  {
    AppMethodBeat.i(134605);
    if (this.jhh.size() <= 0)
    {
      AppMethodBeat.o(134605);
      return;
    }
    ac.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jhh.indexOfKey(paramInt) < 0)
    {
      ac.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      AppMethodBeat.o(134605);
      return;
    }
    this.jhh.delete(paramInt);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((b)paramList.get(paramInt)).aUt();
      paramInt += 1;
    }
    AppMethodBeat.o(134605);
  }
  
  public static final class a
  {
    public static r jhi;
    
    static
    {
      AppMethodBeat.i(134600);
      jhi = new r((byte)0);
      AppMethodBeat.o(134600);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aUt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */