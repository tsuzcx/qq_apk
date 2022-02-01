package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g
{
  int KjE;
  private int enterScene;
  private int lsO;
  private int selectType;
  
  private g()
  {
    AppMethodBeat.i(56107);
    this.selectType = b.KjO.ordinal();
    AppMethodBeat.o(56107);
  }
  
  private void report()
  {
    AppMethodBeat.i(56111);
    h.OAn.b(17993, new Object[] { Integer.valueOf(this.lsO), Integer.valueOf(this.enterScene), Integer.valueOf(this.selectType), Integer.valueOf(this.KjE) });
    reset();
    AppMethodBeat.o(56111);
  }
  
  private void reset()
  {
    AppMethodBeat.i(56110);
    this.enterScene = 0;
    this.selectType = b.KjO.ordinal();
    this.KjE = 0;
    this.lsO = 0;
    AppMethodBeat.o(56110);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(56109);
    this.lsO = parama.ordinal();
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
      KjJ = new b("UNKNOWN", 0);
      KjK = new b("SEARCH_LIST", 1);
      KjL = new b("SEARCH_MAP", 2);
      KjM = new b("DRAG_MAP", 3);
      KjN = new b("LIST", 4);
      KjO = new b("DIRECT", 5);
      KjP = new b[] { KjJ, KjK, KjL, KjM, KjN, KjO };
      AppMethodBeat.o(56105);
    }
    
    private b() {}
  }
  
  static final class c
  {
    static g KjQ;
    
    static
    {
      AppMethodBeat.i(56106);
      KjQ = new g((byte)0);
      AppMethodBeat.o(56106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */