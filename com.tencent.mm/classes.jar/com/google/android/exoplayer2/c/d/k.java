package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public final m.a aZA;
  public final boolean bee;
  public final String bef;
  public final int beg;
  public final byte[] beh;
  
  public k(boolean paramBoolean, String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(92129);
    int i;
    int j;
    if (paramInt1 == 0)
    {
      i = 1;
      if (paramArrayOfByte2 != null) {
        break label98;
      }
      j = 1;
      label30:
      a.checkArgument(j ^ i);
      this.bee = paramBoolean;
      this.bef = paramString;
      this.beg = paramInt1;
      this.beh = paramArrayOfByte2;
      if (paramString != null) {
        break label104;
      }
      i = k;
    }
    for (;;)
    {
      label67:
      this.aZA = new m.a(i, paramArrayOfByte1, paramInt2, paramInt3);
      AppMethodBeat.o(92129);
      return;
      i = 0;
      break;
      label98:
      j = 0;
      break label30;
      label104:
      switch (paramString.hashCode())
      {
      default: 
        paramInt1 = -1;
      }
      for (;;)
      {
        label152:
        i = k;
        switch (paramInt1)
        {
        case 0: 
        case 1: 
        default: 
          new StringBuilder("Unsupported protection scheme type '").append(paramString).append("'. Assuming AES-CTR crypto mode.");
          i = k;
          break label67;
          if (!paramString.equals("cenc")) {
            break label152;
          }
          paramInt1 = m;
          continue;
          if (!paramString.equals("cens")) {
            break label152;
          }
          paramInt1 = 1;
          continue;
          if (!paramString.equals("cbc1")) {
            break label152;
          }
          paramInt1 = 2;
          continue;
          if (!paramString.equals("cbcs")) {
            break label152;
          }
          paramInt1 = 3;
        }
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.k
 * JD-Core Version:    0.7.0.1
 */