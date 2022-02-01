package com.tencent.mm.ak;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbase/HandlerData;", "", "thread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "(Landroid/os/HandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getThread", "()Landroid/os/HandlerThread;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-audiologic_release"})
public final class e
{
  public final MMHandler handler;
  public final HandlerThread thread;
  
  public e(HandlerThread paramHandlerThread, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(187351);
    this.thread = paramHandlerThread;
    this.handler = paramMMHandler;
    AppMethodBeat.o(187351);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187354);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.j(this.thread, paramObject.thread)) || (!p.j(this.handler, paramObject.handler))) {}
      }
    }
    else
    {
      AppMethodBeat.o(187354);
      return true;
    }
    AppMethodBeat.o(187354);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(187353);
    Object localObject = this.thread;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.handler;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(187353);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187352);
    String str = "HandlerData(thread=" + this.thread + ", handler=" + this.handler + ")";
    AppMethodBeat.o(187352);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.e
 * JD-Core Version:    0.7.0.1
 */