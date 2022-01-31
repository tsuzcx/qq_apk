package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  private String coX;
  private String crs;
  private int mLd;
  
  public final boolean v(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = true;
    label174:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(20805);
        ab.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        if ((paramInt != 1) && (paramInt != 2))
        {
          if (paramInt == 3)
          {
            break label174;
            if (i == 0)
            {
              AppMethodBeat.o(20805);
              return bool;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if ((m.isEmpty(paramString1)) || (m.isEmpty(paramString2)))
          {
            AppMethodBeat.o(20805);
            bool = false;
            continue;
          }
          if ((paramString1.equals(this.coX)) && (paramString2.equals(this.crs)) && (this.mLd != paramInt))
          {
            AppMethodBeat.o(20805);
            bool = false;
            continue;
          }
          this.mLd = paramInt;
          this.coX = paramString1;
          this.crs = paramString2;
          AppMethodBeat.o(20805);
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.d
 * JD-Core Version:    0.7.0.1
 */