package com.appaac.haptic.b.c;

import com.appaac.haptic.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  implements com.appaac.haptic.b.a.c
{
  public b crC;
  public ArrayList<c> crD;
  
  public final int getDuration()
  {
    AppMethodBeat.i(208336);
    for (;;)
    {
      int j;
      try
      {
        c localc = (c)this.crD.get(this.crD.size() - 1);
        Iterator localIterator = localc.cry.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (locale.crw.crp.equals("continuous"))
          {
            j = locale.crw.crq;
            j = locale.crw.crr + j;
          }
          else
          {
            j = locale.crw.crq + 22;
          }
        }
        else
        {
          j = localc.crE;
          AppMethodBeat.o(208336);
          return j + i;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(208336);
        return 0;
      }
      while (j <= i)
      {
        j = i;
        break;
      }
      int i = j;
    }
  }
  
  public final int getVersion()
  {
    return this.crC.crz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.b.c.a
 * JD-Core Version:    0.7.0.1
 */