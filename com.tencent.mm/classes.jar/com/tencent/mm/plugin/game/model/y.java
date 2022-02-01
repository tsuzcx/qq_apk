package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.bz;
import com.tencent.mm.plugin.game.protobuf.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class y
  extends x
{
  public bz CKX;
  public LinkedList<c> CKY;
  private int CKZ;
  private int mType;
  
  public y(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41524);
    this.mType = 0;
    this.CKZ = 0;
    if (parama == null)
    {
      this.CKX = new bz();
      AppMethodBeat.o(41524);
      return;
    }
    this.CKX = ((bz)parama);
    this.mType = paramInt1;
    this.CKZ = paramInt2;
    parama = new LinkedList();
    if (this.CKX.CQo != null)
    {
      paramInt1 = this.CKZ;
      Iterator localIterator = this.CKX.CQo.iterator();
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
            localc.fSl = 1601;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            localc.scene = 15;
            localc.fSl = 1501;
            paramInt2 = paramInt1 + 1;
            localc.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.CKY = parama;
    d.bs(this.CKY);
    AppMethodBeat.o(41524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */