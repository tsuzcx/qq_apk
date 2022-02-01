package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class k
{
  final ArrayList<b> qsr;
  ArrayList<b> qss;
  final ArrayList<a> qst;
  Timer qsu;
  
  public k()
  {
    AppMethodBeat.i(90816);
    this.qss = new ArrayList(10);
    this.qst = new ArrayList(2);
    this.qsr = new ArrayList(10);
    AppMethodBeat.o(90816);
  }
  
  final String ET(int paramInt)
  {
    AppMethodBeat.i(184466);
    if (this.qsr != null)
    {
      Object localObject = this.qsr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (paramInt == localb.qrD))
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
    public abstract void Q(ArrayList<b> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k
 * JD-Core Version:    0.7.0.1
 */