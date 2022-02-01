package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.FilterOutputStream;

public final class b
  extends FilterOutputStream
{
  private a oRW;
  
  public b(u paramu, long paramLong)
  {
    super(y.e(paramu, false));
    AppMethodBeat.i(155982);
    this.oRW = new a(paramLong);
    AppMethodBeat.o(155982);
  }
  
  public final void close()
  {
    AppMethodBeat.i(155984);
    super.close();
    if (this.oRW != null) {
      this.oRW.free();
    }
    AppMethodBeat.o(155984);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155983);
    this.oRW.A(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.b
 * JD-Core Version:    0.7.0.1
 */