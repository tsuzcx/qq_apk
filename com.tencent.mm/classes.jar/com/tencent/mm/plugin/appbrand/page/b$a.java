package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  final int ivb;
  final int ivc;
  
  static
  {
    AppMethodBeat.i(87026);
    iuW = new a("NORMAL", 0, -1, -1);
    iuX = new a("LBS", 1, 2131301350, 2130837712);
    iuY = new a("VOICE", 2, 2131301351, 2130837714);
    iuZ = new a("VIDEO", 3, -1, 2130837713);
    iva = new a("LOADING", 4, -1, -1);
    ivd = new a[] { iuW, iuX, iuY, iuZ, iva };
    AppMethodBeat.o(87026);
  }
  
  private b$a(int paramInt1, int paramInt2)
  {
    this.ivb = paramInt1;
    this.ivc = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */