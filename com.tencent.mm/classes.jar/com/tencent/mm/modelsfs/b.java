package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FilterInputStream;

public final class b
  extends FilterInputStream
{
  private boolean fOd;
  private a fOh;
  
  public b(String paramString, long paramLong)
  {
    super(e.openRead(paramString));
    AppMethodBeat.i(93154);
    this.fOd = false;
    this.fOh = new a(paramLong);
    AppMethodBeat.o(93154);
  }
  
  public final void close()
  {
    AppMethodBeat.i(93157);
    super.close();
    if (this.fOh != null) {
      this.fOh.free();
    }
    ab.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    AppMethodBeat.o(93157);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(93158);
    super.mark(paramInt);
    this.fOh.ajg();
    AppMethodBeat.o(93158);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93155);
    if (this.fOd) {
      ab.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bo.dtY().toString());
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(93155);
      return paramInt1;
    }
    this.fOh.y(paramArrayOfByte, paramInt2);
    AppMethodBeat.o(93155);
    return paramInt1;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93159);
    super.reset();
    this.fOh.reset();
    AppMethodBeat.o(93159);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(93156);
    long l = super.skip(paramLong);
    this.fOh.seek(paramLong);
    AppMethodBeat.o(93156);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.b
 * JD-Core Version:    0.7.0.1
 */