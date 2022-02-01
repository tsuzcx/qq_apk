package com.tencent.mm.an;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/HandlerData;", "", "thread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "(Landroid/os/HandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getThread", "()Landroid/os/HandlerThread;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-audiologic_release"})
public final class e
{
  public final MMHandler handler;
  public final HandlerThread thread;
  
  public e(HandlerThread paramHandlerThread, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(229277);
    this.thread = paramHandlerThread;
    this.handler = paramMMHandler;
    AppMethodBeat.o(229277);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229287);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.h(this.thread, paramObject.thread)) || (!p.h(this.handler, paramObject.handler))) {}
      }
    }
    else
    {
      AppMethodBeat.o(229287);
      return true;
    }
    AppMethodBeat.o(229287);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(229281);
    Object localObject = this.thread;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.handler;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(229281);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229280);
    String str = "HandlerData(thread=" + this.thread + ", handler=" + this.handler + ")";
    AppMethodBeat.o(229280);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.e
 * JD-Core Version:    0.7.0.1
 */