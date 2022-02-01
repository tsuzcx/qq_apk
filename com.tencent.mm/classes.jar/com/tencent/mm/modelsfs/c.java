package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends SFSInputStream
{
  private a lYR;
  
  public c(long paramLong1, long paramLong2)
  {
    super(paramLong1);
    AppMethodBeat.i(155985);
    this.lYR = new a(paramLong2);
    AppMethodBeat.o(155985);
  }
  
  public final void close()
  {
    AppMethodBeat.i(155991);
    super.close();
    if (this.lYR != null) {
      this.lYR.free();
    }
    AppMethodBeat.o(155991);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(155986);
    super.mark(paramInt);
    a locala = this.lYR;
    locala.lYQ = locala.lYO;
    AppMethodBeat.o(155986);
  }
  
  public final int read()
  {
    AppMethodBeat.i(155988);
    int i = super.read();
    AppMethodBeat.o(155988);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155989);
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(155989);
      return paramInt1;
    }
    this.lYR.B(paramArrayOfByte, paramInt2);
    AppMethodBeat.o(155989);
    return paramInt1;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(155987);
    super.reset();
    a locala = this.lYR;
    Log.i("MicroMsg.EncEngine", "reset " + Util.getStack());
    locala.free();
    if (locala.lYQ == 0L)
    {
      locala.init();
      locala.lYO = 0L;
      AppMethodBeat.o(155987);
      return;
    }
    locala.init();
    MMIMAGEENCJNI.seek(locala.mNativePtr, locala.lYQ, 1);
    locala.lYO = locala.lYQ;
    AppMethodBeat.o(155987);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(155990);
    long l = super.skip(paramLong);
    a locala = this.lYR;
    locala.lYO = paramLong;
    MMIMAGEENCJNI.seek(locala.mNativePtr, paramLong, 1);
    AppMethodBeat.o(155990);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.c
 * JD-Core Version:    0.7.0.1
 */