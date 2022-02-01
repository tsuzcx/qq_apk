package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  private final byte[] cBX;
  
  public e$a()
  {
    AppMethodBeat.i(74720);
    this.cBX = new byte[32];
    AppMethodBeat.o(74720);
  }
  
  private int bc(Object paramObject)
  {
    AppMethodBeat.i(74723);
    int i = paramObject.hashCode();
    int j = this.cBX.length;
    AppMethodBeat.o(74723);
    return i & j - 1;
  }
  
  final int bb(Object paramObject)
  {
    AppMethodBeat.i(74722);
    int i = bc(paramObject);
    i = this.cBX[i];
    AppMethodBeat.o(74722);
    return (i & 0xFF) - 1;
  }
  
  public final void remove(int paramInt)
  {
    int i = 0;
    if (i < this.cBX.length)
    {
      if (this.cBX[i] == paramInt + 1) {
        this.cBX[i] = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.cBX[i] > paramInt + 1)
        {
          byte[] arrayOfByte = this.cBX;
          arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
        }
      }
    }
  }
  
  final void u(String paramString, int paramInt)
  {
    AppMethodBeat.i(74721);
    int i = bc(paramString);
    if (paramInt < 255)
    {
      this.cBX[i] = ((byte)(paramInt + 1));
      AppMethodBeat.o(74721);
      return;
    }
    this.cBX[i] = 0;
    AppMethodBeat.o(74721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.eclipsesource.a.e.a
 * JD-Core Version:    0.7.0.1
 */