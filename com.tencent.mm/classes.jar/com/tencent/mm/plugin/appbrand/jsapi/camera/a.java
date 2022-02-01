package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class a
{
  public boolean jLA;
  SparseArray<WeakReference<f>> jLB;
  public boolean jLz;
  
  private a()
  {
    AppMethodBeat.i(137464);
    this.jLz = true;
    this.jLA = true;
    this.jLB = new SparseArray();
    AppMethodBeat.o(137464);
  }
  
  public final boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(137466);
    if (this.jLB.indexOfKey(paramInt) >= 0)
    {
      Object localObject = (WeakReference)this.jLB.get(paramInt);
      if (localObject != null)
      {
        localObject = (f)((WeakReference)localObject).get();
        if (localObject != null) {
          ((f)localObject).release();
        }
      }
      for (;;)
      {
        if (paramBoolean) {
          this.jLB.remove(paramInt);
        }
        AppMethodBeat.o(137466);
        return true;
        ad.i("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
        continue;
        ad.i("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
      }
    }
    AppMethodBeat.o(137466);
    return false;
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(137465);
    this.jLB.put(paramInt, new WeakReference(paramf));
    AppMethodBeat.o(137465);
  }
  
  public final int[] aZf()
  {
    int i = 0;
    AppMethodBeat.i(137467);
    if ((this.jLB == null) || (this.jLB.size() == 0))
    {
      AppMethodBeat.o(137467);
      return new int[0];
    }
    int[] arrayOfInt = new int[this.jLB.size()];
    while (i < this.jLB.size())
    {
      arrayOfInt[i] = this.jLB.keyAt(i);
      i += 1;
    }
    AppMethodBeat.o(137467);
    return arrayOfInt;
  }
  
  public final boolean aZg()
  {
    AppMethodBeat.i(137468);
    if (!this.jLz) {
      ad.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    boolean bool = this.jLz;
    AppMethodBeat.o(137468);
    return bool;
  }
  
  public static final class a
  {
    private static a jLC;
    
    static
    {
      AppMethodBeat.i(137463);
      jLC = new a((byte)0);
      AppMethodBeat.o(137463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */