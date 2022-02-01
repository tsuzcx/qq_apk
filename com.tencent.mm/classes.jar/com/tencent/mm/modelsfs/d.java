package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends SFSOutputStream
{
  private a lYR;
  
  public d(long paramLong, String paramString)
  {
    super(paramLong);
    AppMethodBeat.i(155992);
    this.lYR = new a(paramString);
    AppMethodBeat.o(155992);
  }
  
  public final void close()
  {
    AppMethodBeat.i(155995);
    super.close();
    if (this.lYR != null) {
      this.lYR.free();
    }
    AppMethodBeat.o(155995);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(155996);
    super.finalize();
    AppMethodBeat.o(155996);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(155993);
    super.write(paramInt);
    AppMethodBeat.o(155993);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155994);
    this.lYR.B(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.d
 * JD-Core Version:    0.7.0.1
 */