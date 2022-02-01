package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public final class a
{
  public boolean kma;
  public boolean kmb;
  SparseArray<WeakReference<f>> kmc;
  
  private a()
  {
    AppMethodBeat.i(137464);
    this.kma = true;
    this.kmb = true;
    this.kmc = new SparseArray();
    AppMethodBeat.o(137464);
  }
  
  public final boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(137466);
    if (this.kmc.indexOfKey(paramInt) >= 0)
    {
      Object localObject = (WeakReference)this.kmc.get(paramInt);
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
          this.kmc.remove(paramInt);
        }
        AppMethodBeat.o(137466);
        return true;
        ac.i("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
        continue;
        ac.i("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
      }
    }
    AppMethodBeat.o(137466);
    return false;
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(137465);
    this.kmc.put(paramInt, new WeakReference(paramf));
    AppMethodBeat.o(137465);
  }
  
  public final int[] bfX()
  {
    int i = 0;
    AppMethodBeat.i(137467);
    if ((this.kmc == null) || (this.kmc.size() == 0))
    {
      AppMethodBeat.o(137467);
      return new int[0];
    }
    int[] arrayOfInt = new int[this.kmc.size()];
    while (i < this.kmc.size())
    {
      arrayOfInt[i] = this.kmc.keyAt(i);
      i += 1;
    }
    AppMethodBeat.o(137467);
    return arrayOfInt;
  }
  
  public final boolean bfY()
  {
    AppMethodBeat.i(137468);
    if (!this.kma) {
      ac.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    boolean bool = this.kma;
    AppMethodBeat.o(137468);
    return bool;
  }
  
  public static final class a
  {
    private static a kmd;
    
    static
    {
      AppMethodBeat.i(137463);
      kmd = new a((byte)0);
      AppMethodBeat.o(137463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */