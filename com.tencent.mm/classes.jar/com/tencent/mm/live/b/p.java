package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveSysMsgNotifierManager;", "", "()V", "notifier", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "instace", "release", "", "setup", "plugin-logic_release"})
public final class p
{
  private static g kvE;
  public static final p kvF;
  
  static
  {
    AppMethodBeat.i(189605);
    kvF = new p();
    AppMethodBeat.o(189605);
  }
  
  public static void a(g paramg)
  {
    kvE = paramg;
  }
  
  public static g aOe()
  {
    return kvE;
  }
  
  public static void release()
  {
    kvE = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.p
 * JD-Core Version:    0.7.0.1
 */