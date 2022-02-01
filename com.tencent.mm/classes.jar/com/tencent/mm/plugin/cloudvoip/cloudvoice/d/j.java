package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class j
{
  final ArrayList<b> pdr;
  ArrayList<b> pds;
  final ArrayList<a> pdt;
  Timer pdu;
  
  public j()
  {
    AppMethodBeat.i(90816);
    this.pds = new ArrayList(10);
    this.pdt = new ArrayList(2);
    this.pdr = new ArrayList(10);
    AppMethodBeat.o(90816);
  }
  
  final String Bl(int paramInt)
  {
    AppMethodBeat.i(184466);
    if (this.pdr != null)
    {
      Object localObject = this.pdr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (paramInt == localb.pcE))
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
    public abstract void J(ArrayList<b> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.j
 * JD-Core Version:    0.7.0.1
 */