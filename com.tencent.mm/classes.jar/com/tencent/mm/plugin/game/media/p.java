package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.commlib.e.c.a;

public final class p
{
  public static final String CGG;
  
  static
  {
    AppMethodBeat.i(41173);
    CGG = c.c(c.a.Czw) + "haowan/";
    AppMethodBeat.o(41173);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(41172);
      CGH = new a("FROM_PUBLISH_GALLERY", 0);
      CGI = new a("FROM_TAB_GALLERY", 1);
      CGJ = new a[] { CGH, CGI };
      AppMethodBeat.o(41172);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.p
 * JD-Core Version:    0.7.0.1
 */