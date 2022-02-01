package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g
{
  int EqY;
  private int enterScene;
  private int iQS;
  private int selectType;
  
  private g()
  {
    AppMethodBeat.i(56107);
    this.selectType = b.Eri.ordinal();
    AppMethodBeat.o(56107);
  }
  
  private void report()
  {
    AppMethodBeat.i(56111);
    h.IzE.a(17993, new Object[] { Integer.valueOf(this.iQS), Integer.valueOf(this.enterScene), Integer.valueOf(this.selectType), Integer.valueOf(this.EqY) });
    reset();
    AppMethodBeat.o(56111);
  }
  
  private void reset()
  {
    AppMethodBeat.i(56110);
    this.enterScene = 0;
    this.selectType = b.Eri.ordinal();
    this.EqY = 0;
    this.iQS = 0;
    AppMethodBeat.o(56110);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(56109);
    this.iQS = parama.ordinal();
    report();
    AppMethodBeat.o(56109);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(56108);
    this.selectType = paramb.ordinal();
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
      Erd = new b("UNKNOWN", 0);
      Ere = new b("SEARCH_LIST", 1);
      Erf = new b("SEARCH_MAP", 2);
      Erg = new b("DRAG_MAP", 3);
      Erh = new b("LIST", 4);
      Eri = new b("DIRECT", 5);
      Erj = new b[] { Erd, Ere, Erf, Erg, Erh, Eri };
      AppMethodBeat.o(56105);
    }
    
    private b() {}
  }
  
  static final class c
  {
    static g Erk;
    
    static
    {
      AppMethodBeat.i(56106);
      Erk = new g((byte)0);
      AppMethodBeat.o(56106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */