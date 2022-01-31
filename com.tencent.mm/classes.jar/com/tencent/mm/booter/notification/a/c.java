package com.tencent.mm.booter.notification.a;

import com.tencent.mm.R.g;
import com.tencent.mm.bq.a;
import com.tencent.mm.m.f;

public final class c
{
  public int djU = -1;
  
  public final int w(String paramString, int paramInt)
  {
    this.djU = a.bSL();
    if ((!f.gK(paramInt)) || (f.fj(paramString))) {}
    try
    {
      this.djU = R.g.voip_newmessagetips1;
      for (;;)
      {
        label28:
        if (this.djU < 0) {
          this.djU = a.bSL();
        }
        return this.djU;
        if (f.fk(paramString)) {
          try
          {
            this.djU = R.g.voip_newmessagetips1;
          }
          catch (Exception paramString) {}
        }
      }
    }
    catch (Exception paramString)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.c
 * JD-Core Version:    0.7.0.1
 */