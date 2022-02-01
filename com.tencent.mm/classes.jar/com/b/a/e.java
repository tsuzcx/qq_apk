package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.Locale;

final class e
  extends m
{
  final h aFg;
  final com.b.a.a.b aFh;
  b aFi;
  
  public e(h paramh, com.b.a.a.b paramb)
  {
    super(paramh, paramb);
    this.aFh = paramb;
    this.aFg = paramh;
  }
  
  static String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(183567);
    paramString = String.format(Locale.US, paramString, paramVarArgs);
    AppMethodBeat.o(183567);
    return paramString;
  }
  
  final void a(OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(183565);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = c(arrayOfByte, paramLong);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      paramLong += i;
    }
    paramOutputStream.flush();
    AppMethodBeat.o(183565);
  }
  
  final void b(OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(183566);
    h localh = new h(this.aFg);
    paramLong = (int)paramLong;
    try
    {
      localh.s(paramLong);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localh.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      paramOutputStream.flush();
    }
    finally
    {
      localh.close();
      AppMethodBeat.o(183566);
    }
    localh.close();
    AppMethodBeat.o(183566);
  }
  
  protected final void dJ(int paramInt)
  {
    AppMethodBeat.i(183568);
    if (this.aFi != null) {
      this.aFi.b(this.aFh.file, paramInt);
    }
    AppMethodBeat.o(183568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.e
 * JD-Core Version:    0.7.0.1
 */