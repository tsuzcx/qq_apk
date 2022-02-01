package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.FilterOutputStream;

public final class b
  extends FilterOutputStream
{
  private a inM;
  
  public b(k paramk, long paramLong)
  {
    super(o.d(paramk, false));
    AppMethodBeat.i(155982);
    this.inM = new a(paramLong);
    AppMethodBeat.o(155982);
  }
  
  public final void close()
  {
    AppMethodBeat.i(155984);
    super.close();
    if (this.inM != null) {
      this.inM.free();
    }
    AppMethodBeat.o(155984);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155983);
    this.inM.z(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.b
 * JD-Core Version:    0.7.0.1
 */