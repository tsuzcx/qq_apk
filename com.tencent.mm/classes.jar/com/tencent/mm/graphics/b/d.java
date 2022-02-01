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
  public boolean isRunning;
  public WeakReference<Context> jVV;
  public HashMap<Integer, a> jVW;
  public com.tencent.e.i.b jVX;
  public final Object jVY;
  
  static
  {
    AppMethodBeat.i(136211);
    jVU = new d("INSTANCE");
    jVZ = new d[] { jVU };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.jVV = null;
    this.jVW = new HashMap();
    this.isRunning = false;
    this.jVX = null;
    this.jVY = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b aEY()
  {
    AppMethodBeat.i(136209);
    synchronized (this.jVY)
    {
      if (this.jVW != null)
      {
        Object localObject2 = (a)this.jVW.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).aEV();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(136210);
    synchronized (this.jVY)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.jVX != null) {
        this.jVX.cancel();
      }
      this.isRunning = false;
      if (this.jVW != null) {
        this.jVW.clear();
      }
      AppMethodBeat.o(136210);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d
 * JD-Core Version:    0.7.0.1
 */