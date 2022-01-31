package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  final int blk;
  final c.a[] bll;
  
  c$b(int paramInt, c.a... paramVarArgs)
  {
    this.blk = paramInt;
    this.bll = paramVarArgs;
  }
  
  public final int sT()
  {
    c.a[] arrayOfa = this.bll;
    int k = arrayOfa.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfa[j].count;
      j += 1;
    }
    return i;
  }
  
  public final int sU()
  {
    AppMethodBeat.i(57176);
    int i = this.blk;
    int j = sT();
    AppMethodBeat.o(57176);
    return i * j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.f.a.c.b
 * JD-Core Version:    0.7.0.1
 */