package com.tencent.mm.plugin.f.a.b.a;

import com.tencent.mm.sdk.platformtools.y;

public final class b$c
{
  public int dtl = 0;
  public int dtp = 0;
  public int hVT = 0;
  public int hVU = 0;
  public int hVV = 0;
  public int hVW = 0;
  
  public final boolean K(byte[] paramArrayOfByte, int paramInt)
  {
    String str = b.access$000();
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      y.d(str, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(7) });
      if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 7)) {
        break;
      }
      y.e(b.access$000(), "data input error");
      return false;
    }
    this.dtp = ((paramArrayOfByte[paramInt] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
    this.dtl = (paramArrayOfByte[(paramInt + 2)] & 0xFF);
    this.hVT = (paramArrayOfByte[(paramInt + 3)] & 0xFF);
    this.hVU = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
    this.hVV = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
    this.hVW = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
    y.d(b.access$000(), "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.dtp), Integer.valueOf(this.dtl), Integer.valueOf(this.hVT), Integer.valueOf(this.hVU), Integer.valueOf(this.hVV), Integer.valueOf(this.hVW) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */