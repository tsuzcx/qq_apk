package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String a;
  public final int b;
  public final int c;
  public final long d;
  
  public e(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(15431);
    this.a = paramString;
    this.b = paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 < 600) {
      paramInt1 = 600;
    }
    this.c = paramInt1;
    this.d = paramLong;
    AppMethodBeat.o(15431);
  }
  
  public final boolean a()
  {
    return this.b == 5;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(15432);
    if (this == paramObject)
    {
      AppMethodBeat.o(15432);
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof e)))
    {
      AppMethodBeat.o(15432);
      return false;
    }
    paramObject = (e)paramObject;
    if ((this.a.equals(paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d))
    {
      AppMethodBeat.o(15432);
      return true;
    }
    AppMethodBeat.o(15432);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.network.a.e
 * JD-Core Version:    0.7.0.1
 */