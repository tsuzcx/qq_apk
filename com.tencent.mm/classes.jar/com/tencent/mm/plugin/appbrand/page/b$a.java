package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  final int lYO;
  final int lYP;
  
  static
  {
    AppMethodBeat.i(134952);
    lYJ = new a("NORMAL", 0, -1, -1);
    lYK = new a("LBS", 1, 2131760995, 2131230948);
    lYL = new a("VOICE", 2, 2131760996, 2131230950);
    lYM = new a("VIDEO", 3, -1, 2131230949);
    lYN = new a("LOADING", 4, -1, -1);
    lYQ = new a[] { lYJ, lYK, lYL, lYM, lYN };
    AppMethodBeat.o(134952);
  }
  
  private b$a(int paramInt1, int paramInt2)
  {
    this.lYO = paramInt1;
    this.lYP = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */