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
  public boolean Uz;
  public WeakReference<Context> mvP;
  public HashMap<Integer, a> mvQ;
  public com.tencent.threadpool.i.b mvR;
  public final Object mvS;
  
  static
  {
    AppMethodBeat.i(136211);
    mvO = new d("INSTANCE");
    mvT = new d[] { mvO };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.mvP = null;
    this.mvQ = new HashMap();
    this.Uz = false;
    this.mvR = null;
    this.mvS = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b aYa()
  {
    AppMethodBeat.i(136209);
    synchronized (this.mvS)
    {
      if (this.mvQ != null)
      {
        Object localObject2 = (a)this.mvQ.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).aXX();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void aYb()
  {
    AppMethodBeat.i(136210);
    synchronized (this.mvS)
    {
      if (!this.Uz)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.mvR != null) {
        this.mvR.cancel();
      }
      this.Uz = false;
      if (this.mvQ != null) {
        this.mvQ.clear();
      }
      AppMethodBeat.o(136210);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d
 * JD-Core Version:    0.7.0.1
 */