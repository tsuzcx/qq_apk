package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public enum d
{
  public WeakReference<Context> gbi;
  public HashMap<Integer, a> gbj;
  public com.tencent.e.i.b gbk;
  public final Object gbl;
  public boolean isRunning;
  
  static
  {
    AppMethodBeat.i(136211);
    gbh = new d("INSTANCE");
    gbm = new d[] { gbh };
    AppMethodBeat.o(136211);
  }
  
  private d()
  {
    AppMethodBeat.i(136208);
    this.gbi = null;
    this.gbj = new HashMap();
    this.isRunning = false;
    this.gbk = null;
    this.gbl = new Object();
    AppMethodBeat.o(136208);
  }
  
  public final b aet()
  {
    AppMethodBeat.i(136209);
    synchronized (this.gbl)
    {
      if (this.gbj != null)
      {
        Object localObject2 = (a)this.gbj.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).aeq();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(136209);
          return localObject2;
        }
      }
      AppMethodBeat.o(136209);
      return null;
    }
  }
  
  public final void aeu()
  {
    AppMethodBeat.i(136210);
    synchronized (this.gbl)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(136210);
        return;
      }
      if (this.gbk != null) {
        this.gbk.cancel();
      }
      this.isRunning = false;
      if (this.gbj != null) {
        this.gbj.clear();
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