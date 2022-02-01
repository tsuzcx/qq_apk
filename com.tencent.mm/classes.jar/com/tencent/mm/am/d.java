package com.tencent.mm.am;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/HandlerData;", "", "thread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "(Landroid/os/HandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getThread", "()Landroid/os/HandlerThread;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-audiologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final MMHandler handler;
  final HandlerThread thread;
  
  public d(HandlerThread paramHandlerThread, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(236782);
    this.thread = paramHandlerThread;
    this.handler = paramMMHandler;
    AppMethodBeat.o(236782);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236788);
    if (this == paramObject)
    {
      AppMethodBeat.o(236788);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(236788);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.thread, paramObject.thread))
    {
      AppMethodBeat.o(236788);
      return false;
    }
    if (!s.p(this.handler, paramObject.handler))
    {
      AppMethodBeat.o(236788);
      return false;
    }
    AppMethodBeat.o(236788);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(236787);
    int i = this.thread.hashCode();
    int j = this.handler.hashCode();
    AppMethodBeat.o(236787);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(236784);
    String str = "HandlerData(thread=" + this.thread + ", handler=" + this.handler + ')';
    AppMethodBeat.o(236784);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.d
 * JD-Core Version:    0.7.0.1
 */