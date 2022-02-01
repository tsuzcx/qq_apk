package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public enum d
{
  public WeakReference<Context> hkm;
  public HashMap<Integer, a> hkn;
  public com.tencent.f.i.b hko;
  public final Object hkp;
  public boolean isRunning;
  
  static
  {
    AppMethodBeat.i(136211);
    hkl = new d("INSTANCE");
    hkq = new d[] { hkl };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.hkm = null;
    this.hkn = new HashMap();
    this.isRunning = false;
    this.hko = null;
    this.hkp = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b axG()
  {
    AppMethodBeat.i(136209);
    synchronized (this.hkp)
    {
      if (this.hkn != null)
      {
        Object localObject2 = (a)this.hkn.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).axD();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void axH()
  {
    AppMethodBeat.i(136210);
    synchronized (this.hkp)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.hko != null) {
        this.hko.cancel();
      }
      this.isRunning = false;
      if (this.hkn != null) {
        this.hkn.clear();
      }
      AppMethodBeat.o(136210);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d
 * JD-Core Version:    0.7.0.1
 */