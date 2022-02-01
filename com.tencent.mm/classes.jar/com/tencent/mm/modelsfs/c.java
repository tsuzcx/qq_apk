package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends SFSInputStream
{
  private a oRW;
  
  public c(long paramLong1, long paramLong2)
  {
    super(paramLong1);
    AppMethodBeat.i(155985);
    this.oRW = new a(paramLong2);
    AppMethodBeat.o(155985);
  }
  
  public final void close()
  {
    AppMethodBeat.i(155991);
    super.close();
    if (this.oRW != null) {
      this.oRW.free();
    }
    AppMethodBeat.o(155991);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(155986);
    super.mark(paramInt);
    a locala = this.oRW;
    locala.oRV = locala.oRT;
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
    this.oRW.A(paramArrayOfByte, paramInt2);
    AppMethodBeat.o(155989);
    return paramInt1;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(155987);
    super.reset();
    a locala = this.oRW;
    Log.i("MicroMsg.EncEngine", "reset " + Util.getStack());
    locala.free();
    if (locala.oRV == 0L)
    {
      locala.init();
      locala.oRT = 0L;
      AppMethodBeat.o(155987);
      return;
    }
    locala.init();
    MMIMAGEENCJNI.seek(locala.mNativePtr, locala.oRV, 1);
    locala.oRT = locala.oRV;
    AppMethodBeat.o(155987);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(155990);
    long l = super.skip(paramLong);
    a locala = this.oRW;
    locala.oRT = paramLong;
    MMIMAGEENCJNI.seek(locala.mNativePtr, paramLong, 1);
    AppMethodBeat.o(155990);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.c
 * JD-Core Version:    0.7.0.1
 */