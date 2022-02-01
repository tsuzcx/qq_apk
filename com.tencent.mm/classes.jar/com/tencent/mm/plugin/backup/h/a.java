package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public ap handler;
  LinkedList<a> nAb;
  
  public a()
  {
    AppMethodBeat.i(21743);
    this.nAb = new LinkedList();
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(21743);
  }
  
  public final void h(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(21744);
    this.nAb.add(new a(paramInt, paramObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a
 * JD-Core Version:    0.7.0.1
 */