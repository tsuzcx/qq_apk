package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private int enterScene;
  private int fFu;
  private int iVz;
  int vhg;
  
  private g()
  {
    AppMethodBeat.i(56107);
    this.iVz = b.vhq.ordinal();
    AppMethodBeat.o(56107);
  }
  
  private void report()
  {
    AppMethodBeat.i(56111);
    com.tencent.mm.plugin.report.service.g.yhR.f(17993, new Object[] { Integer.valueOf(this.fFu), Integer.valueOf(this.enterScene), Integer.valueOf(this.iVz), Integer.valueOf(this.vhg) });
    reset();
    AppMethodBeat.o(56111);
  }
  
  private void reset()
  {
    AppMethodBeat.i(56110);
    this.enterScene = 0;
    this.iVz = b.vhq.ordinal();
    this.vhg = 0;
    this.fFu = 0;
    AppMethodBeat.o(56110);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(56109);
    this.fFu = parama.ordinal();
    report();
    AppMethodBeat.o(56109);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(56108);
    this.iVz = paramb.ordinal();
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
      vhl = new b("UNKNOWN", 0);
      vhm = new b("SEARCH_LIST", 1);
      vhn = new b("SEARCH_MAP", 2);
      vho = new b("DRAG_MAP", 3);
      vhp = new b("LIST", 4);
      vhq = new b("DIRECT", 5);
      vhr = new b[] { vhl, vhm, vhn, vho, vhp, vhq };
      AppMethodBeat.o(56105);
    }
    
    private b() {}
  }
  
  static final class c
  {
    static g vhs;
    
    static
    {
      AppMethodBeat.i(56106);
      vhs = new g((byte)0);
      AppMethodBeat.o(56106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */