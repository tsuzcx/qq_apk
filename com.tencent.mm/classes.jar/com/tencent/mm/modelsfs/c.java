package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.FilterOutputStream;

public final class c
  extends FilterOutputStream
{
  private a fOh;
  
  public c(b paramb, long paramLong)
  {
    super(e.s(paramb));
    AppMethodBeat.i(93160);
    this.fOh = new a(paramLong);
    AppMethodBeat.o(93160);
  }
  
  public c(String paramString1, String paramString2)
  {
    super(e.M(paramString1, false));
    AppMethodBeat.i(93161);
    this.fOh = new a(paramString2);
    AppMethodBeat.o(93161);
  }
  
  public final void close()
  {
    AppMethodBeat.i(93163);
    super.close();
    if (this.fOh != null) {
      this.fOh.free();
    }
    AppMethodBeat.o(93163);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93162);
    this.fOh.y(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.c
 * JD-Core Version:    0.7.0.1
 */