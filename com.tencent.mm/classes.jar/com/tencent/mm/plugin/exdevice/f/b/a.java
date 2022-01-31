package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a
{
  SparseArray<WeakReference<e>> lHV;
  
  public final void a(e parame)
  {
    AppMethodBeat.i(19475);
    Assert.assertTrue(true);
    if (this.lHV == null) {
      this.lHV = new SparseArray();
    }
    this.lHV.put(parame.hashCode(), new WeakReference(parame));
    AppMethodBeat.o(19475);
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(19477);
    Assert.assertTrue(true);
    if (this.lHV == null)
    {
      ab.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
      AppMethodBeat.o(19477);
      return;
    }
    int i = 0;
    while (i < this.lHV.size())
    {
      int j = this.lHV.keyAt(i);
      e locale = (e)((WeakReference)this.lHV.get(j)).get();
      if (locale != null) {
        locale.b(paramString, paramd);
      }
      i += 1;
    }
    ab.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
    AppMethodBeat.o(19477);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(19476);
    Assert.assertTrue(true);
    if (this.lHV == null)
    {
      ab.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
      AppMethodBeat.o(19476);
      return;
    }
    this.lHV.remove(parame.hashCode());
    AppMethodBeat.o(19476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.a
 * JD-Core Version:    0.7.0.1
 */