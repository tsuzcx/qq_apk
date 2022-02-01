package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public aq handler;
  LinkedList<a> nFw;
  
  public a()
  {
    AppMethodBeat.i(21743);
    this.nFw = new LinkedList();
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(21743);
  }
  
  public final void h(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(21744);
    this.nFw.add(new a(paramInt, paramObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a
 * JD-Core Version:    0.7.0.1
 */