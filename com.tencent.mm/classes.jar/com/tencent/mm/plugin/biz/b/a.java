package com.tencent.mm.plugin.biz.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "noOftenReadMode", "", "noOftenReadMode$annotations", "getNoOftenReadMode", "()Z", "setNoOftenReadMode", "(Z)V", "noVideoChannelMode", "noVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", "plugin-biz_release"})
public final class a
{
  private static boolean noa;
  private static boolean nob;
  public static final a noc;
  
  static
  {
    AppMethodBeat.i(209584);
    noc = new a();
    AppMethodBeat.o(209584);
  }
  
  public static final boolean bIn()
  {
    return noa;
  }
  
  public static final boolean bIo()
  {
    return nob;
  }
  
  public static final void iV(boolean paramBoolean)
  {
    noa = paramBoolean;
  }
  
  public static final void iW(boolean paramBoolean)
  {
    nob = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.a
 * JD-Core Version:    0.7.0.1
 */