package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveSysMsgNotifierManager;", "", "()V", "notifier", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "instace", "release", "", "setup", "plugin-logic_release"})
public final class s
{
  private static j hIk;
  public static final s hIl;
  
  static
  {
    AppMethodBeat.i(207689);
    hIl = new s();
    AppMethodBeat.o(207689);
  }
  
  public static void a(j paramj)
  {
    hIk = paramj;
  }
  
  public static j aGe()
  {
    return hIk;
  }
  
  public static void release()
  {
    hIk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.s
 * JD-Core Version:    0.7.0.1
 */