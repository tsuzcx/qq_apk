package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a
{
  SparseArray<WeakReference<e>> jyw;
  
  public final void a(e parame)
  {
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.jyw == null) {
        this.jyw = new SparseArray();
      }
      this.jyw.put(parame.hashCode(), new WeakReference(parame));
      return;
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    Assert.assertTrue(true);
    if (this.jyw == null)
    {
      y.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
      return;
    }
    int i = 0;
    while (i < this.jyw.size())
    {
      int j = this.jyw.keyAt(i);
      e locale = (e)((WeakReference)this.jyw.get(j)).get();
      if (locale != null) {
        locale.b(paramString, paramd);
      }
      i += 1;
    }
    y.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
  }
  
  public final void b(e parame)
  {
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.jyw != null) {
        break;
      }
      y.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
      return;
    }
    this.jyw.remove(parame.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.a
 * JD-Core Version:    0.7.0.1
 */