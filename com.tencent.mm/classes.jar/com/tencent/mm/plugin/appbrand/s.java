package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

public final class s
{
  public final SparseArray<List<b>> jDo;
  final SparseIntArray jDp;
  
  private s()
  {
    AppMethodBeat.i(134601);
    this.jDo = new SparseArray();
    this.jDp = new SparseIntArray();
    AppMethodBeat.o(134601);
  }
  
  public final void e(int paramInt, List<b> paramList)
  {
    AppMethodBeat.i(134605);
    if (this.jDp.size() <= 0)
    {
      AppMethodBeat.o(134605);
      return;
    }
    ae.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jDp.indexOfKey(paramInt) < 0)
    {
      ae.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      AppMethodBeat.o(134605);
      return;
    }
    this.jDp.delete(paramInt);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((b)paramList.get(paramInt)).aYa();
      paramInt += 1;
    }
    AppMethodBeat.o(134605);
  }
  
  public static final class a
  {
    public static s jDq;
    
    static
    {
      AppMethodBeat.i(134600);
      jDq = new s((byte)0);
      AppMethodBeat.o(134600);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aYa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s
 * JD-Core Version:    0.7.0.1
 */