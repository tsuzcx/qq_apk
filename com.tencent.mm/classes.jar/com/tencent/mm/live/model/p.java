package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveSysMsgNotifierManager;", "", "()V", "notifier", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "instace", "release", "", "setup", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p mZf;
  private static g mZg;
  
  static
  {
    AppMethodBeat.i(246525);
    mZf = new p();
    AppMethodBeat.o(246525);
  }
  
  public static void a(g paramg)
  {
    mZg = paramg;
  }
  
  public static g bhS()
  {
    return mZg;
  }
  
  public static void release()
  {
    mZg = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.p
 * JD-Core Version:    0.7.0.1
 */