package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public enum d
{
  public WeakReference<Context> fWB;
  public HashMap<Integer, a> fWC;
  public com.tencent.e.i.b fWD;
  public final Object fWE;
  public boolean isRunning;
  
  static
  {
    AppMethodBeat.i(136211);
    fWA = new d("INSTANCE");
    fWF = new d[] { fWA };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.fWB = null;
    this.fWC = new HashMap();
    this.isRunning = false;
    this.fWD = null;
    this.fWE = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b adc()
  {
    AppMethodBeat.i(136209);
    synchronized (this.fWE)
    {
      if (this.fWC != null)
      {
        Object localObject2 = (a)this.fWC.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).acZ();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void ade()
  {
    AppMethodBeat.i(136210);
    synchronized (this.fWE)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.fWD != null) {
        this.fWD.cancel();
      }
      this.isRunning = false;
      if (this.fWC != null) {
        this.fWC.clear();
      }
      AppMethodBeat.o(136210);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d
 * JD-Core Version:    0.7.0.1
 */