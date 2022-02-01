package com.tencent.mm.plugin.appbrand;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public final class r
{
  public final SparseArray<List<b>> jAl;
  final SparseIntArray jAm;
  
  private r()
  {
    AppMethodBeat.i(134601);
    this.jAl = new SparseArray();
    this.jAm = new SparseIntArray();
    AppMethodBeat.o(134601);
  }
  
  public final void e(int paramInt, List<b> paramList)
  {
    AppMethodBeat.i(134605);
    if (this.jAm.size() <= 0)
    {
      AppMethodBeat.o(134605);
      return;
    }
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jAm.indexOfKey(paramInt) < 0)
    {
      ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      AppMethodBeat.o(134605);
      return;
    }
    this.jAm.delete(paramInt);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((b)paramList.get(paramInt)).aXF();
      paramInt += 1;
    }
    AppMethodBeat.o(134605);
  }
  
  public static final class a
  {
    public static r jAn;
    
    static
    {
      AppMethodBeat.i(134600);
      jAn = new r((byte)0);
      AppMethodBeat.o(134600);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aXF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */