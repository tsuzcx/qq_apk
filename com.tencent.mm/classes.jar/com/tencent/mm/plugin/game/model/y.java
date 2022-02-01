package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.g;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  private int mType;
  public by uoB;
  public LinkedList<c> uoC;
  private int uoD;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.uoD = 0;
    if (parama == null)
    {
      this.uoB = new by();
      AppMethodBeat.o(41524);
      return;
    }
    this.uoB = ((by)parama);
    this.mType = paramInt1;
    this.uoD = paramInt2;
    parama = new LinkedList();
    if (this.uoB.uud != null)
    {
      paramInt1 = this.uoD;
      Iterator localIterator = this.uoB.uud.iterator();
      paramInt1 += 1;
      while (localIterator.hasNext())
      {
        c localc = a((g)localIterator.next());
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
            localc.dGL = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.dGL = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.uoC = parama;
    d.aE(this.uoC);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */