package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.FilterOutputStream;

public final class b
  extends FilterOutputStream
{
  private a hrd;
  
  public b(e parame, long paramLong)
  {
    super(i.d(parame, false));
    AppMethodBeat.i(155982);
    this.hrd = new a(paramLong);
    AppMethodBeat.o(155982);
  }
  
  public final void close()
  {
    AppMethodBeat.i(155984);
    super.close();
    if (this.hrd != null) {
      this.hrd.free();
    }
    AppMethodBeat.o(155984);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155983);
    this.hrd.B(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsfs.b
 * JD-Core Version:    0.7.0.1
 */