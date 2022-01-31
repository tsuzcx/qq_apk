package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.k.a;
import com.google.android.exoplayer2.i.a;

public final class f
{
  public final boolean aCF;
  public final String aCG;
  public final k.a aCH;
  public final int aCI;
  public final byte[] aCJ;
  
  public f(boolean paramBoolean, String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    int i;
    int j;
    if (paramInt1 == 0)
    {
      i = 1;
      if (paramArrayOfByte2 != null) {
        break label88;
      }
      j = 1;
      label25:
      a.aB(j ^ i);
      this.aCF = paramBoolean;
      this.aCG = paramString;
      this.aCI = paramInt1;
      this.aCJ = paramArrayOfByte2;
      if (paramString != null) {
        break label94;
      }
      i = k;
    }
    for (;;)
    {
      label62:
      this.aCH = new k.a(i, paramArrayOfByte1, paramInt2, paramInt3);
      return;
      i = 0;
      break;
      label88:
      j = 0;
      break label25;
      label94:
      switch (paramString.hashCode())
      {
      default: 
        paramInt1 = -1;
      }
      for (;;)
      {
        label140:
        i = k;
        switch (paramInt1)
        {
        case 0: 
        case 1: 
        default: 
          new StringBuilder("Unsupported protection scheme type '").append(paramString).append("'. Assuming AES-CTR crypto mode.");
          i = k;
          break label62;
          if (!paramString.equals("cenc")) {
            break label140;
          }
          paramInt1 = m;
          continue;
          if (!paramString.equals("cens")) {
            break label140;
          }
          paramInt1 = 1;
          continue;
          if (!paramString.equals("cbc1")) {
            break label140;
          }
          paramInt1 = 2;
          continue;
          if (!paramString.equals("cbcs")) {
            break label140;
          }
          paramInt1 = 3;
        }
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.f
 * JD-Core Version:    0.7.0.1
 */