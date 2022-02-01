package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  private String ddU;
  private String dgo;
  private int rih;
  
  public final boolean z(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = true;
    label174:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(24875);
        ad.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        if ((paramInt != 1) && (paramInt != 2))
        {
          if (paramInt == 3)
          {
            break label174;
            if (i == 0)
            {
              AppMethodBeat.o(24875);
              return bool;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          if ((m.dq(paramString1)) || (m.dq(paramString2)))
          {
            AppMethodBeat.o(24875);
            bool = false;
            continue;
          }
          if ((paramString1.equals(this.ddU)) && (paramString2.equals(this.dgo)) && (this.rih != paramInt))
          {
            AppMethodBeat.o(24875);
            bool = false;
            continue;
          }
          this.rih = paramInt;
          this.ddU = paramString1;
          this.dgo = paramString2;
          AppMethodBeat.o(24875);
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
  
  static final class a
  {
    private static d rii;
    
    static
    {
      AppMethodBeat.i(24874);
      rii = new d((byte)0);
      AppMethodBeat.o(24874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.d
 * JD-Core Version:    0.7.0.1
 */