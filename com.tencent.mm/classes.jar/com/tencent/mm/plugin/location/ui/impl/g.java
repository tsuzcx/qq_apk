package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private int enterScene;
  private int fHy;
  private int iYs;
  int vtn;
  
  private g()
  {
    AppMethodBeat.i(56107);
    this.iYs = b.vtx.ordinal();
    AppMethodBeat.o(56107);
  }
  
  private void report()
  {
    AppMethodBeat.i(56111);
    com.tencent.mm.plugin.report.service.g.yxI.f(17993, new Object[] { Integer.valueOf(this.fHy), Integer.valueOf(this.enterScene), Integer.valueOf(this.iYs), Integer.valueOf(this.vtn) });
    reset();
    AppMethodBeat.o(56111);
  }
  
  private void reset()
  {
    AppMethodBeat.i(56110);
    this.enterScene = 0;
    this.iYs = b.vtx.ordinal();
    this.vtn = 0;
    this.fHy = 0;
    AppMethodBeat.o(56110);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(56109);
    this.fHy = parama.ordinal();
    report();
    AppMethodBeat.o(56109);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(56108);
    this.iYs = paramb.ordinal();
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
      vts = new b("UNKNOWN", 0);
      vtt = new b("SEARCH_LIST", 1);
      vtu = new b("SEARCH_MAP", 2);
      vtv = new b("DRAG_MAP", 3);
      vtw = new b("LIST", 4);
      vtx = new b("DIRECT", 5);
      vty = new b[] { vts, vtt, vtu, vtv, vtw, vtx };
      AppMethodBeat.o(56105);
    }
    
    private b() {}
  }
  
  static final class c
  {
    static g vtz;
    
    static
    {
      AppMethodBeat.i(56106);
      vtz = new g((byte)0);
      AppMethodBeat.o(56106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */