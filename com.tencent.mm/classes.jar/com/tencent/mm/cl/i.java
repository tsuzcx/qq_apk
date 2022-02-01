package com.tencent.mm.cl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements CharSequence
{
  public final CharSequence UYW;
  private int bPh;
  public final int end;
  public final int start;
  
  public i(CharSequence paramCharSequence)
  {
    this(paramCharSequence, 0, paramCharSequence.length());
    AppMethodBeat.i(225427);
    AppMethodBeat.o(225427);
  }
  
  public i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225431);
    this.UYW = paramCharSequence;
    this.start = paramInt1;
    this.end = paramInt2;
    if ((paramInt1 < 0) || (paramInt1 > paramInt2) || (paramInt2 > paramCharSequence.length()))
    {
      paramCharSequence = new IndexOutOfBoundsException("origin length is " + paramCharSequence.length() + " start/end is [" + paramInt1 + ", " + paramInt2 + "]");
      AppMethodBeat.o(225431);
      throw paramCharSequence;
    }
    AppMethodBeat.o(225431);
  }
  
  public final char charAt(int paramInt)
  {
    AppMethodBeat.i(225434);
    if ((paramInt < 0) || (paramInt >= length()))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("length is " + length() + " index is " + paramInt);
      AppMethodBeat.o(225434);
      throw localIndexOutOfBoundsException;
    }
    char c = this.UYW.charAt(this.start + paramInt);
    AppMethodBeat.o(225434);
    return c;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225445);
    if (this == paramObject)
    {
      AppMethodBeat.o(225445);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(225445);
      return false;
    }
    paramObject = (i)paramObject;
    int i = length();
    if (i == paramObject.length())
    {
      int j = 0;
      while (i != 0)
      {
        if (charAt(j) != paramObject.charAt(j))
        {
          AppMethodBeat.o(225445);
          return false;
        }
        j += 1;
        i -= 1;
      }
      AppMethodBeat.o(225445);
      return true;
    }
    AppMethodBeat.o(225445);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225448);
    int i = this.bPh;
    int m = Math.max(this.start, 0);
    int k = this.UYW.length();
    int j = k;
    if (this.end > 0)
    {
      j = k;
      if (this.end < k) {
        j = this.end;
      }
    }
    k = i;
    if (i == 0)
    {
      k = i;
      if (j > 0)
      {
        k = m;
        while (k < j)
        {
          i = i * 31 + this.UYW.charAt(k);
          k += 1;
        }
        this.bPh = i;
        k = i;
      }
    }
    AppMethodBeat.o(225448);
    return k;
  }
  
  public final int length()
  {
    return this.end - this.start;
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225436);
    i locali = new i(this.UYW, this.start + paramInt1, this.end + paramInt2);
    AppMethodBeat.o(225436);
    return locali;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225440);
    String str = this.UYW.subSequence(this.start, this.end).toString();
    AppMethodBeat.o(225440);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cl.i
 * JD-Core Version:    0.7.0.1
 */