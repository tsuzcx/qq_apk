package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.by;
import com.tencent.mm.plugin.game.protobuf.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  private int mType;
  public by xGU;
  public LinkedList<c> xGV;
  private int xGW;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.xGW = 0;
    if (parama == null)
    {
      this.xGU = new by();
      AppMethodBeat.o(41524);
      return;
    }
    this.xGU = ((by)parama);
    this.mType = paramInt1;
    this.xGW = paramInt2;
    parama = new LinkedList();
    if (this.xGU.xMf != null)
    {
      paramInt1 = this.xGW;
      Iterator localIterator = this.xGU.xMf.iterator();
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
            localc.dYu = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.dYu = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.xGV = parama;
    d.aZ(this.xGV);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */