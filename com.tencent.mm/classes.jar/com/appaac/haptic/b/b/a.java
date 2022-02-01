package com.appaac.haptic.b.b;

import com.appaac.haptic.b.a.c;
import com.appaac.haptic.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  implements c
{
  public b crx;
  public ArrayList<e> cry;
  
  public final int getDuration()
  {
    AppMethodBeat.i(208333);
    for (;;)
    {
      try
      {
        localb = ((e)this.cry.get(this.cry.size() - 1)).crw;
        if (!"continuous".equals(localb.crp)) {
          continue;
        }
        i = localb.crq;
        int j = localb.crr;
        i = j + i;
      }
      catch (Exception localException)
      {
        com.appaac.haptic.b.a.b localb;
        int i = 0;
        continue;
      }
      AppMethodBeat.o(208333);
      return i;
      i = localb.crq;
      i += 22;
    }
  }
  
  public final int getVersion()
  {
    return this.crx.crz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.b.b.a
 * JD-Core Version:    0.7.0.1
 */