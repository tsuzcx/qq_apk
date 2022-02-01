package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class j
{
  final ArrayList<b> nQn;
  ArrayList<b> nQo;
  final ArrayList<a> nQp;
  Timer nQq;
  
  public j()
  {
    AppMethodBeat.i(90816);
    this.nQo = new ArrayList(10);
    this.nQp = new ArrayList(2);
    this.nQn = new ArrayList(10);
    AppMethodBeat.o(90816);
  }
  
  final String zz(int paramInt)
  {
    AppMethodBeat.i(184466);
    if (this.nQn != null)
    {
      Object localObject = this.nQn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (paramInt == localb.nPB))
        {
          localObject = localb.openId;
          AppMethodBeat.o(184466);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(184466);
    return null;
  }
  
  static abstract interface a
  {
    public abstract void E(ArrayList<b> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.j
 * JD-Core Version:    0.7.0.1
 */