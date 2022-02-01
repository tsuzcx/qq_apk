package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b$c
{
  public int mDay = 0;
  public int mMonth = 0;
  public int mYear = 0;
  public int nRY = 0;
  public int nRZ = 0;
  public int nSa = 0;
  
  public final boolean N(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(22570);
    String str = b.access$000();
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ad.d(str, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(7) });
      if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 7)) {
        break;
      }
      ad.e(b.access$000(), "data input error");
      AppMethodBeat.o(22570);
      return false;
    }
    this.mYear = ((paramArrayOfByte[paramInt] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
    this.mMonth = (paramArrayOfByte[(paramInt + 2)] & 0xFF);
    this.mDay = (paramArrayOfByte[(paramInt + 3)] & 0xFF);
    this.nRY = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
    this.nRZ = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
    this.nSa = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
    ad.d(b.access$000(), "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.nRY), Integer.valueOf(this.nRZ), Integer.valueOf(this.nSa) });
    AppMethodBeat.o(22570);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */