package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g
{
  private int enterScene;
  private int gmJ;
  private int jVX;
  int yNa;
  
  private g()
  {
    AppMethodBeat.i(56107);
    this.jVX = b.yNk.ordinal();
    AppMethodBeat.o(56107);
  }
  
  private void report()
  {
    AppMethodBeat.i(56111);
    h.CyF.a(17993, new Object[] { Integer.valueOf(this.gmJ), Integer.valueOf(this.enterScene), Integer.valueOf(this.jVX), Integer.valueOf(this.yNa) });
    reset();
    AppMethodBeat.o(56111);
  }
  
  private void reset()
  {
    AppMethodBeat.i(56110);
    this.enterScene = 0;
    this.jVX = b.yNk.ordinal();
    this.yNa = 0;
    this.gmJ = 0;
    AppMethodBeat.o(56110);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(56109);
    this.gmJ = parama.ordinal();
    report();
    AppMethodBeat.o(56109);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(56108);
    this.jVX = paramb.ordinal();
    AppMethodBeat.o(56108);
  }
  
  public final void setScene(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      this.enterScene = 0;
      return;
    case 3: 
      this.enterScene = 5;
      return;
    case -1: 
      this.enterScene = 3;
      return;
    }
    this.enterScene = paramInt;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(56105);
      yNf = new b("UNKNOWN", 0);
      yNg = new b("SEARCH_LIST", 1);
      yNh = new b("SEARCH_MAP", 2);
      yNi = new b("DRAG_MAP", 3);
      yNj = new b("LIST", 4);
      yNk = new b("DIRECT", 5);
      yNl = new b[] { yNf, yNg, yNh, yNi, yNj, yNk };
      AppMethodBeat.o(56105);
    }
    
    private b() {}
  }
  
  static final class c
  {
    static g yNm;
    
    static
    {
      AppMethodBeat.i(56106);
      yNm = new g((byte)0);
      AppMethodBeat.o(56106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */