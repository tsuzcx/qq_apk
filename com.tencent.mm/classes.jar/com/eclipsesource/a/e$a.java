package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  private final byte[] aZT;
  
  public e$a()
  {
    AppMethodBeat.i(74720);
    this.aZT = new byte[32];
    AppMethodBeat.o(74720);
  }
  
  private int ac(Object paramObject)
  {
    AppMethodBeat.i(74723);
    int i = paramObject.hashCode();
    int j = this.aZT.length;
    AppMethodBeat.o(74723);
    return i & j - 1;
  }
  
  final int get(Object paramObject)
  {
    AppMethodBeat.i(74722);
    int i = ac(paramObject);
    i = this.aZT[i];
    AppMethodBeat.o(74722);
    return (i & 0xFF) - 1;
  }
  
  final void i(String paramString, int paramInt)
  {
    AppMethodBeat.i(74721);
    int i = ac(paramString);
    if (paramInt < 255)
    {
      this.aZT[i] = ((byte)(paramInt + 1));
      AppMethodBeat.o(74721);
      return;
    }
    this.aZT[i] = 0;
    AppMethodBeat.o(74721);
  }
  
  public final void remove(int paramInt)
  {
    int i = 0;
    if (i < this.aZT.length)
    {
      if (this.aZT[i] == paramInt + 1) {
        this.aZT[i] = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.aZT[i] > paramInt + 1)
        {
          byte[] arrayOfByte = this.aZT;
          arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.e.a
 * JD-Core Version:    0.7.0.1
 */