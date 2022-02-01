package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  private int mType;
  public bo tfD;
  public LinkedList<c> tfE;
  private int tfF;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.tfF = 0;
    if (parama == null)
    {
      this.tfD = new bo();
      AppMethodBeat.o(41524);
      return;
    }
    this.tfD = ((bo)parama);
    this.mType = paramInt1;
    this.tfF = paramInt2;
    parama = new LinkedList();
    if (this.tfD.tkB != null)
    {
      paramInt1 = this.tfF;
      Iterator localIterator = this.tfD.tkB.iterator();
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
            localc.dtF = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.dtF = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.tfE = parama;
    d.aC(this.tfE);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */