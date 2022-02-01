package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  private int mType;
  public br udt;
  public LinkedList<c> udu;
  private int udv;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.udv = 0;
    if (parama == null)
    {
      this.udt = new br();
      AppMethodBeat.o(41524);
      return;
    }
    this.udt = ((br)parama);
    this.mType = paramInt1;
    this.udv = paramInt2;
    parama = new LinkedList();
    if (this.udt.uiF != null)
    {
      paramInt1 = this.udv;
      Iterator localIterator = this.udt.uiF.iterator();
      paramInt1 += 1;
      while (localIterator.hasNext())
      {
        c localc = a((f)localIterator.next());
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
            localc.dFG = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.dFG = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.udu = parama;
    d.aE(this.udu);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */