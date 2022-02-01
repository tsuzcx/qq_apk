package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class i
  extends InputStream
{
  private final g aRo;
  private final j bgL;
  private final byte[] bop;
  long boq;
  private boolean closed;
  private boolean opened;
  
  public i(g paramg, j paramj)
  {
    AppMethodBeat.i(93037);
    this.opened = false;
    this.closed = false;
    this.aRo = paramg;
    this.bgL = paramj;
    this.bop = new byte[1];
    AppMethodBeat.o(93037);
  }
  
  public final void close()
  {
    AppMethodBeat.i(93041);
    if (!this.closed)
    {
      this.aRo.close();
      this.closed = true;
    }
    AppMethodBeat.o(93041);
  }
  
  public final int read()
  {
    AppMethodBeat.i(93038);
    if (read(this.bop) == -1)
    {
      AppMethodBeat.o(93038);
      return -1;
    }
    int i = this.bop[0];
    AppMethodBeat.o(93038);
    return i & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93039);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(93039);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93040);
    if (!this.closed) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      uI();
      paramInt1 = this.aRo.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break;
      }
      AppMethodBeat.o(93040);
      return -1;
    }
    this.boq += paramInt1;
    AppMethodBeat.o(93040);
    return paramInt1;
  }
  
  final void uI()
  {
    AppMethodBeat.i(93042);
    if (!this.opened)
    {
      this.aRo.a(this.bgL);
      this.opened = true;
    }
    AppMethodBeat.o(93042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.i
 * JD-Core Version:    0.7.0.1
 */