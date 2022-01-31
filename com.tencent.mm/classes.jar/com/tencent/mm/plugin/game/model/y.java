package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  private int mType;
  public bo nop;
  public LinkedList<c> noq;
  private int nor;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111359);
    this.mType = 0;
    this.nor = 0;
    if (parama == null)
    {
      this.nop = new bo();
      AppMethodBeat.o(111359);
      return;
    }
    this.nop = ((bo)parama);
    this.mType = paramInt1;
    this.nor = paramInt2;
    parama = new LinkedList();
    if (this.nop.ntf != null)
    {
      paramInt1 = this.nor;
      Iterator localIterator = this.nop.ntf.iterator();
      paramInt1 += 1;
      while (localIterator.hasNext())
      {
        c localc = a((e)localIterator.next());
        if (localc != null)
        {
          switch (this.mType)
          {
          }
          for (;;)
          {
            parama.add(localc);
            break;
            localc.scene = 16;
            localc.cFj = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.cFj = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.noq = parama;
    d.ag(this.noq);
    AppMethodBeat.o(111359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */