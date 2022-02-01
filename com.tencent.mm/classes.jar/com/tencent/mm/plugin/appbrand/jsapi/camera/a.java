package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

public final class a
{
  public boolean kKp;
  public boolean kKq;
  SparseArray<WeakReference<f>> kKr;
  
  private a()
  {
    AppMethodBeat.i(137464);
    this.kKp = true;
    this.kKq = true;
    this.kKr = new SparseArray();
    AppMethodBeat.o(137464);
  }
  
  public final boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(137466);
    if (this.kKr.indexOfKey(paramInt) >= 0)
    {
      Object localObject = (WeakReference)this.kKr.get(paramInt);
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
          this.kKr.remove(paramInt);
        }
        AppMethodBeat.o(137466);
        return true;
        ae.i("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
        continue;
        ae.i("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
      }
    }
    AppMethodBeat.o(137466);
    return false;
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(137465);
    this.kKr.put(paramInt, new WeakReference(paramf));
    AppMethodBeat.o(137465);
  }
  
  public final int[] bkk()
  {
    int i = 0;
    AppMethodBeat.i(137467);
    if ((this.kKr == null) || (this.kKr.size() == 0))
    {
      AppMethodBeat.o(137467);
      return new int[0];
    }
    int[] arrayOfInt = new int[this.kKr.size()];
    while (i < this.kKr.size())
    {
      arrayOfInt[i] = this.kKr.keyAt(i);
      i += 1;
    }
    AppMethodBeat.o(137467);
    return arrayOfInt;
  }
  
  public final boolean bkl()
  {
    AppMethodBeat.i(137468);
    if (!this.kKp) {
      ae.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    boolean bool = this.kKp;
    AppMethodBeat.o(137468);
    return bool;
  }
  
  public static final class a
  {
    private static a kKs;
    
    static
    {
      AppMethodBeat.i(137463);
      kKs = new a((byte)0);
      AppMethodBeat.o(137463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */