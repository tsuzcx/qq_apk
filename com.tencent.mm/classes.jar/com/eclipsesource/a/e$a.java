package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  private final byte[] aua;
  
  public e$a()
  {
    AppMethodBeat.i(70533);
    this.aua = new byte[32];
    AppMethodBeat.o(70533);
  }
  
  private int N(Object paramObject)
  {
    AppMethodBeat.i(70536);
    int i = paramObject.hashCode();
    int j = this.aua.length;
    AppMethodBeat.o(70536);
    return i & j - 1;
  }
  
  final void g(String paramString, int paramInt)
  {
    AppMethodBeat.i(70534);
    int i = N(paramString);
    if (paramInt < 255)
    {
      this.aua[i] = ((byte)(paramInt + 1));
      AppMethodBeat.o(70534);
      return;
    }
    this.aua[i] = 0;
    AppMethodBeat.o(70534);
  }
  
  final int get(Object paramObject)
  {
    AppMethodBeat.i(70535);
    int i = N(paramObject);
    i = this.aua[i];
    AppMethodBeat.o(70535);
    return (i & 0xFF) - 1;
  }
  
  public final void remove(int paramInt)
  {
    int i = 0;
    if (i < this.aua.length)
    {
      if (this.aua[i] == paramInt + 1) {
        this.aua[i] = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.aua[i] > paramInt + 1)
        {
          byte[] arrayOfByte = this.aua;
          arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.a.e.a
 * JD-Core Version:    0.7.0.1
 */