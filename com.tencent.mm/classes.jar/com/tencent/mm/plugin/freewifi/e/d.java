package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  private String dnO;
  private String dqk;
  private int tyt;
  
  public final boolean y(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = true;
    label174:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(24875);
        ae.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
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
          if ((m.ef(paramString1)) || (m.ef(paramString2)))
          {
            AppMethodBeat.o(24875);
            bool = false;
            continue;
          }
          if ((paramString1.equals(this.dnO)) && (paramString2.equals(this.dqk)) && (this.tyt != paramInt))
          {
            AppMethodBeat.o(24875);
            bool = false;
            continue;
          }
          this.tyt = paramInt;
          this.dnO = paramString1;
          this.dqk = paramString2;
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
    private static d tyu;
    
    static
    {
      AppMethodBeat.i(24874);
      tyu = new d((byte)0);
      AppMethodBeat.o(24874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.d
 * JD-Core Version:    0.7.0.1
 */