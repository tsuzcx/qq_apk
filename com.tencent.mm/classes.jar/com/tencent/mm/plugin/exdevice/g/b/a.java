package com.tencent.mm.plugin.exdevice.g.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a
{
  SparseArray<WeakReference<e>> qma;
  
  public final void a(e parame)
  {
    AppMethodBeat.i(23543);
    Assert.assertTrue(true);
    if (this.qma == null) {
      this.qma = new SparseArray();
    }
    this.qma.put(parame.hashCode(), new WeakReference(parame));
    AppMethodBeat.o(23543);
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(23545);
    Assert.assertTrue(true);
    if (this.qma == null)
    {
      ae.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
      AppMethodBeat.o(23545);
      return;
    }
    int i = 0;
    while (i < this.qma.size())
    {
      int j = this.qma.keyAt(i);
      e locale = (e)((WeakReference)this.qma.get(j)).get();
      if (locale != null) {
        locale.b(paramString, paramd);
      }
      i += 1;
    }
    ae.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
    AppMethodBeat.o(23545);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(23544);
    Assert.assertTrue(true);
    if (this.qma == null)
    {
      ae.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
      AppMethodBeat.o(23544);
      return;
    }
    this.qma.remove(parame.hashCode());
    AppMethodBeat.o(23544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a
 * JD-Core Version:    0.7.0.1
 */