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
  public WeakReference<Context> guS;
  public HashMap<Integer, a> guT;
  public com.tencent.e.i.b guU;
  public final Object guV;
  public boolean isRunning;
  
  static
  {
    AppMethodBeat.i(136211);
    guR = new d("INSTANCE");
    guW = new d[] { guR };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.guS = null;
    this.guT = new HashMap();
    this.isRunning = false;
    this.guU = null;
    this.guV = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b ahf()
  {
    AppMethodBeat.i(136209);
    synchronized (this.guV)
    {
      if (this.guT != null)
      {
        Object localObject2 = (a)this.guT.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).ahc();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void ahg()
  {
    AppMethodBeat.i(136210);
    synchronized (this.guV)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.guU != null) {
        this.guU.cancel();
      }
      this.isRunning = false;
      if (this.guT != null) {
        this.guT.clear();
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