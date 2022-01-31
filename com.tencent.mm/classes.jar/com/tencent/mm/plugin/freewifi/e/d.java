package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private String bHI;
  private String bJY;
  private int kpq;
  
  public final boolean l(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        y.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        int i;
        if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
        {
          i = 1;
          if (i == 0) {
            return bool;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if ((!m.isEmpty(paramString1)) && (!m.isEmpty(paramString2)))
        {
          if ((paramString1.equals(this.bHI)) && (paramString2.equals(this.bJY)) && (this.kpq != paramInt))
          {
            bool = false;
          }
          else
          {
            this.kpq = paramInt;
            this.bHI = paramString1;
            this.bJY = paramString2;
          }
        }
        else {
          bool = false;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.d
 * JD-Core Version:    0.7.0.1
 */