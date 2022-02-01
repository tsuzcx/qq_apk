package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  ao handler;
  public LinkedList<a> mZE;
  
  public a()
  {
    AppMethodBeat.i(22056);
    this.mZE = new LinkedList();
    this.handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(22056);
  }
  
  public final boolean i(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(22057);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22054);
        a.this.mZE.add(new a.a(a.this, paramInt, paramObject));
        AppMethodBeat.o(22054);
      }
    });
    AppMethodBeat.o(22057);
    return true;
  }
  
  public final class a
  {
    public Object obj;
    public int type;
    
    public a(int paramInt, Object paramObject)
    {
      this.type = paramInt;
      this.obj = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.a
 * JD-Core Version:    0.7.0.1
 */