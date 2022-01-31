package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i
{
  private b kmC = j.aUj();
  
  public final void D(String paramString, long paramLong)
  {
    try
    {
      this.kmC.dj(paramString, String.valueOf(paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void bD(String paramString, int paramInt)
  {
    try
    {
      this.kmC.dj(paramString, String.valueOf(paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = m.isEmpty(paramString);
        if (!bool) {
          continue;
        }
        i = paramInt;
      }
      finally
      {
        try
        {
          paramString = this.kmC.DA(paramString);
          i = paramInt;
          if (m.isEmpty(paramString)) {
            continue;
          }
          i = Integer.valueOf(paramString).intValue();
        }
        catch (Exception paramString)
        {
          int i = paramInt;
        }
        paramString = finally;
      }
      return i;
    }
  }
  
  public final long pn(String paramString)
  {
    long l2 = 0L;
    for (;;)
    {
      try
      {
        boolean bool = m.isEmpty(paramString);
        if (!bool) {
          continue;
        }
        l1 = l2;
      }
      finally
      {
        try
        {
          paramString = this.kmC.DA(paramString);
          l1 = l2;
          if (m.isEmpty(paramString)) {
            continue;
          }
          l1 = Long.valueOf(paramString).longValue();
        }
        catch (Exception paramString)
        {
          long l1 = l2;
        }
        paramString = finally;
      }
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.i
 * JD-Core Version:    0.7.0.1
 */