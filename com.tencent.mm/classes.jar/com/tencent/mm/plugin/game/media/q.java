package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.commlib.e.c.a;

public final class q
{
  public static final String IAQ;
  
  static
  {
    AppMethodBeat.i(41173);
    IAQ = c.c(c.a.Itm) + "haowan/";
    AppMethodBeat.o(41173);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(41172);
      IAR = new a("FROM_PUBLISH_GALLERY", 0);
      IAS = new a("FROM_TAB_GALLERY", 1);
      IAT = new a[] { IAR, IAS };
      AppMethodBeat.o(41172);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.q
 * JD-Core Version:    0.7.0.1
 */