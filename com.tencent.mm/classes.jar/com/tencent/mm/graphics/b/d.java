package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public enum d
{
  public HashMap<Integer, a> gxA;
  public com.tencent.e.i.b gxB;
  public final Object gxC;
  public WeakReference<Context> gxz;
  public boolean isRunning;
  
  static
  {
    AppMethodBeat.i(136211);
    gxy = new d("INSTANCE");
    gxD = new d[] { gxy };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.gxz = null;
    this.gxA = new HashMap();
    this.isRunning = false;
    this.gxB = null;
    this.gxC = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b ahu()
  {
    AppMethodBeat.i(136209);
    synchronized (this.gxC)
    {
      if (this.gxA != null)
      {
        Object localObject2 = (a)this.gxA.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).ahr();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void ahv()
  {
    AppMethodBeat.i(136210);
    synchronized (this.gxC)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.gxB != null) {
        this.gxB.cancel();
      }
      this.isRunning = false;
      if (this.gxA != null) {
        this.gxA.clear();
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