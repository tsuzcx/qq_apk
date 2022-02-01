package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  private int mType;
  public bo rXL;
  public LinkedList<c> rXM;
  private int rXN;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.rXN = 0;
    if (parama == null)
    {
      this.rXL = new bo();
      AppMethodBeat.o(41524);
      return;
    }
    this.rXL = ((bo)parama);
    this.mType = paramInt1;
    this.rXN = paramInt2;
    parama = new LinkedList();
    if (this.rXL.scH != null)
    {
      paramInt1 = this.rXN;
      Iterator localIterator = this.rXL.scH.iterator();
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
            localc.dvS = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.dvS = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.rXM = parama;
    d.av(this.rXM);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */