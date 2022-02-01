package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class a
{
  private boolean rPj;
  public boolean rPk;
  boolean rPl;
  boolean rPm;
  SparseArray<WeakReference<f>> rPn;
  
  private a()
  {
    AppMethodBeat.i(137464);
    this.rPj = true;
    this.rPk = true;
    this.rPl = true;
    this.rPm = false;
    this.rPn = new SparseArray();
    AppMethodBeat.o(137464);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(137465);
    this.rPn.put(paramInt, new WeakReference(paramf));
    AppMethodBeat.o(137465);
  }
  
  public final boolean ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(137466);
    if (this.rPn.indexOfKey(paramInt) >= 0)
    {
      Object localObject = (WeakReference)this.rPn.get(paramInt);
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
          this.rPn.remove(paramInt);
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
  
  public final int[] crw()
  {
    int i = 0;
    AppMethodBeat.i(137467);
    if ((this.rPn == null) || (this.rPn.size() == 0))
    {
      AppMethodBeat.o(137467);
      return new int[0];
    }
    int[] arrayOfInt = new int[this.rPn.size()];
    while (i < this.rPn.size())
    {
      arrayOfInt[i] = this.rPn.keyAt(i);
      i += 1;
    }
    AppMethodBeat.o(137467);
    return arrayOfInt;
  }
  
  public final boolean crx()
  {
    AppMethodBeat.i(325991);
    if (!this.rPj) {
      Log.i("MicroMsg.AppBrandCameraMrg", "no external storage permission");
    }
    boolean bool = this.rPj;
    AppMethodBeat.o(325991);
    return bool;
  }
  
  public final boolean hasCameraPermission()
  {
    AppMethodBeat.i(137468);
    if (!this.rPk) {
      Log.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    boolean bool = this.rPk;
    AppMethodBeat.o(137468);
    return bool;
  }
  
  public final void jk(boolean paramBoolean)
  {
    AppMethodBeat.i(325995);
    Log.i("MicroMsg.AppBrandCameraMrg", "has external storage permission: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rPj = paramBoolean;
    AppMethodBeat.o(325995);
  }
  
  public static final class a
  {
    private static a rPo;
    
    static
    {
      AppMethodBeat.i(137463);
      rPo = new a((byte)0);
      AppMethodBeat.o(137463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */