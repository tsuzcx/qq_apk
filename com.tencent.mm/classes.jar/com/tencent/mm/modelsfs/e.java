package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends SFSOutputStream
{
  private a fOh;
  
  public e(long paramLong, String paramString)
  {
    super(paramLong);
    AppMethodBeat.i(93171);
    this.fOh = new a(paramString);
    AppMethodBeat.o(93171);
  }
  
  public final void close()
  {
    AppMethodBeat.i(93174);
    super.close();
    if (this.fOh != null) {
      this.fOh.free();
    }
    AppMethodBeat.o(93174);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93175);
    super.finalize();
    AppMethodBeat.o(93175);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(93172);
    super.write(paramInt);
    AppMethodBeat.o(93172);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93173);
    this.fOh.y(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.e
 * JD-Core Version:    0.7.0.1
 */