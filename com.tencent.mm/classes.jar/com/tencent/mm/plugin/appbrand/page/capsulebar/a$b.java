package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$b
{
  final int mkx;
  final int mky;
  
  static
  {
    AppMethodBeat.i(207866);
    mks = new b("NORMAL", 0, -1, -1);
    mkt = new b("LBS", 1, 2131760995, 2131230948);
    mku = new b("VOICE", 2, 2131760996, 2131230950);
    mkv = new b("VIDEO", 3, -1, 2131230949);
    mkw = new b("LOADING", 4, -1, -1);
    mkz = new b[] { mks, mkt, mku, mkv, mkw };
    AppMethodBeat.o(207866);
  }
  
  private a$b(int paramInt1, int paramInt2)
  {
    this.mkx = paramInt1;
    this.mky = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.a.b
 * JD-Core Version:    0.7.0.1
 */