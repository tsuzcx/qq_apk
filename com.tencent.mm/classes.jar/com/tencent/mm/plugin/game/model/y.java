package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.ca;
import com.tencent.mm.plugin.game.protobuf.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  public ca IFf;
  public LinkedList<c> IFg;
  private int IFh;
  private int mType;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.IFh = 0;
    if (parama == null)
    {
      this.IFf = new ca();
      AppMethodBeat.o(41524);
      return;
    }
    this.IFf = ((ca)parama);
    this.mType = paramInt1;
    this.IFh = paramInt2;
    parama = new LinkedList();
    if (this.IFf.IKy != null)
    {
      paramInt1 = this.IFh;
      Iterator localIterator = this.IFf.IKy.iterator();
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
            localc.hYi = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.hYi = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.IFg = parama;
    d.bz(this.IFg);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */