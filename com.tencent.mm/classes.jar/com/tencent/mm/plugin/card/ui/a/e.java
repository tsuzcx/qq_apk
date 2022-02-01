package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean dnB()
  {
    AppMethodBeat.i(113642);
    if ((this.wru.djq()) && (!l.IN(this.wAo.lCR)) && (this.wru.djF()) && (!dmH()))
    {
      AppMethodBeat.o(113642);
      return true;
    }
    AppMethodBeat.o(113642);
    return false;
  }
  
  public final boolean dnC()
  {
    AppMethodBeat.i(293804);
    boolean bool = dmH();
    AppMethodBeat.o(293804);
    return bool;
  }
  
  public final boolean dnE()
  {
    AppMethodBeat.i(113647);
    if ((this.wru.djK() != null) && (this.wru.djK().Zep))
    {
      AppMethodBeat.o(113647);
      return true;
    }
    AppMethodBeat.o(113647);
    return false;
  }
  
  public final boolean dnF()
  {
    AppMethodBeat.i(113643);
    if ((super.dnF()) || ((this.wru.djF()) && (!dmH()) && ((dnl()) || (dnm()))))
    {
      AppMethodBeat.o(113643);
      return true;
    }
    AppMethodBeat.o(113643);
    return false;
  }
  
  public final boolean dnK()
  {
    AppMethodBeat.i(113645);
    if ((this.wru.djF()) && (super.dnK()) && (!dnE()))
    {
      AppMethodBeat.o(113645);
      return true;
    }
    AppMethodBeat.o(113645);
    return false;
  }
  
  public final boolean dnO()
  {
    AppMethodBeat.i(113644);
    if ((this.wru.djq()) && (this.wru.djK().Zeb != null) && (this.wru.djF()) && (!dmH()) && (!dnl()) && (!dnm()))
    {
      AppMethodBeat.o(113644);
      return true;
    }
    AppMethodBeat.o(113644);
    return false;
  }
  
  public final boolean dno()
  {
    AppMethodBeat.i(113646);
    if ((super.dno()) && (this.wru.djF()) && (!dmH()) && (!dnl()) && (!dnm()))
    {
      AppMethodBeat.o(113646);
      return true;
    }
    AppMethodBeat.o(113646);
    return false;
  }
  
  public final boolean dnx()
  {
    AppMethodBeat.i(113641);
    if ((this.wru.djq()) && (!l.IN(this.wAo.lCR)) && (this.wru.djF()) && (!dmH()))
    {
      AppMethodBeat.o(113641);
      return false;
    }
    AppMethodBeat.o(113641);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */