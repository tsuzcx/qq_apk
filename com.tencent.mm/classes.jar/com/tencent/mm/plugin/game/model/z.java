package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends y
{
  public bn kQl;
  public LinkedList<d> kQm;
  private int kQn = 0;
  private int mType = 0;
  
  public z(a parama, int paramInt1, int paramInt2)
  {
    if (parama == null)
    {
      this.kQl = new bn();
      return;
    }
    this.kQl = ((bn)parama);
    this.mType = paramInt1;
    this.kQn = paramInt2;
    parama = new LinkedList();
    if (this.kQl.kVd != null)
    {
      paramInt1 = this.kQn;
      Iterator localIterator = this.kQl.kVd.iterator();
      paramInt1 += 1;
      while (localIterator.hasNext())
      {
        d locald = a((e)localIterator.next());
        if (locald != null)
        {
          switch (this.mType)
          {
          }
          for (;;)
          {
            parama.add(locald);
            break;
            locald.scene = 16;
            locald.bXn = 1601;
            paramInt2 = paramInt1 + 1;
            locald.position = paramInt1;
            paramInt1 = paramInt2;
            continue;
            locald.scene = 15;
            locald.bXn = 1501;
            paramInt2 = paramInt1 + 1;
            locald.position = paramInt1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    this.kQm = parama;
    com.tencent.mm.plugin.game.f.d.Y(this.kQm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */