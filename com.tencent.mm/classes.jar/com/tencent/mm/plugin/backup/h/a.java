package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public MMHandler handler;
  LinkedList<a> rSq;
  
  public a()
  {
    AppMethodBeat.i(21743);
    this.rSq = new LinkedList();
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(21743);
  }
  
  public final void l(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(21744);
    this.rSq.add(new a(paramInt, paramObject));
    AppMethodBeat.o(21744);
  }
  
  final class a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a
 * JD-Core Version:    0.7.0.1
 */