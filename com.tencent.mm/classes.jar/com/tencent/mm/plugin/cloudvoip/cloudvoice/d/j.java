package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class j
{
  final ArrayList<b> ots;
  ArrayList<b> ott;
  final ArrayList<a> otu;
  Timer otv;
  
  public j()
  {
    AppMethodBeat.i(90816);
    this.ott = new ArrayList(10);
    this.otu = new ArrayList(2);
    this.ots = new ArrayList(10);
    AppMethodBeat.o(90816);
  }
  
  final String Aq(int paramInt)
  {
    AppMethodBeat.i(184466);
    if (this.ots != null)
    {
      Object localObject = this.ots.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (paramInt == localb.osF))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.j
 * JD-Core Version:    0.7.0.1
 */