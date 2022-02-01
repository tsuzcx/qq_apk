package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  final int kXG;
  final int kXH;
  
  static
  {
    AppMethodBeat.i(134952);
    kXB = new a("NORMAL", 0, -1, -1);
    kXC = new a("LBS", 1, 2131760995, 2131230948);
    kXD = new a("VOICE", 2, 2131760996, 2131230950);
    kXE = new a("VIDEO", 3, -1, 2131230949);
    kXF = new a("LOADING", 4, -1, -1);
    kXI = new a[] { kXB, kXC, kXD, kXE, kXF };
    AppMethodBeat.o(134952);
  }
  
  private b$a(int paramInt1, int paramInt2)
  {
    this.kXG = paramInt1;
    this.kXH = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */