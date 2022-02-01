package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class a
{
  public boolean oLp;
  public boolean oLq;
  SparseArray<WeakReference<f>> oLr;
  
  private a()
  {
    AppMethodBeat.i(137464);
    this.oLp = true;
    this.oLq = true;
    this.oLr = new SparseArray();
    AppMethodBeat.o(137464);
  }
  
  public static a bRo()
  {
    AppMethodBeat.i(207214);
    a locala = a.bRr();
    AppMethodBeat.o(207214);
    return locala;
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(137466);
    if (this.oLr.indexOfKey(paramInt) >= 0)
    {
      Object localObject = (WeakReference)this.oLr.get(paramInt);
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
          this.oLr.remove(paramInt);
        }
        AppMethodBeat.o(137466);
        return true;
        Log.i("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
        continue;
        Log.i("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
      }
    }
    AppMethodBeat.o(137466);
    return false;
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(137465);
    this.oLr.put(paramInt, new WeakReference(paramf));
    AppMethodBeat.o(137465);
  }
  
  public final int[] bRp()
  {
    int i = 0;
    AppMethodBeat.i(137467);
    if ((this.oLr == null) || (this.oLr.size() == 0))
    {
      AppMethodBeat.o(137467);
      return new int[0];
    }
    int[] arrayOfInt = new int[this.oLr.size()];
    while (i < this.oLr.size())
    {
      arrayOfInt[i] = this.oLr.keyAt(i);
      i += 1;
    }
    AppMethodBeat.o(137467);
    return arrayOfInt;
  }
  
  public final boolean bRq()
  {
    AppMethodBeat.i(137468);
    if (!this.oLp) {
      Log.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    boolean bool = this.oLp;
    AppMethodBeat.o(137468);
    return bool;
  }
  
  public static final class a
  {
    private static a oLs;
    
    static
    {
      AppMethodBeat.i(137463);
      oLs = new a((byte)0);
      AppMethodBeat.o(137463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */