package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b$c
{
  public int jPN = 0;
  public int jPO = 0;
  public int jPP = 0;
  public int mDay = 0;
  public int mMonth = 0;
  public int mYear = 0;
  
  public final boolean L(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(18459);
    String str = b.access$000();
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.d(str, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(7) });
      if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 7)) {
        break;
      }
      ab.e(b.access$000(), "data input error");
      AppMethodBeat.o(18459);
      return false;
    }
    this.mYear = ((paramArrayOfByte[paramInt] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
    this.mMonth = (paramArrayOfByte[(paramInt + 2)] & 0xFF);
    this.mDay = (paramArrayOfByte[(paramInt + 3)] & 0xFF);
    this.jPN = (paramArrayOfByte[(paramInt + 4)] & 0xFF);
    this.jPO = (paramArrayOfByte[(paramInt + 5)] & 0xFF);
    this.jPP = (paramArrayOfByte[(paramInt + 6)] & 0xFF);
    ab.d(b.access$000(), "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.jPN), Integer.valueOf(this.jPO), Integer.valueOf(this.jPP) });
    AppMethodBeat.o(18459);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */