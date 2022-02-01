package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  private static boolean inI = false;
  long inJ;
  private String inK;
  long inL;
  long mNativePtr;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(155977);
    this.inJ = 0L;
    this.mNativePtr = 0L;
    this.inL = 0L;
    this.inK = String.valueOf(paramLong);
    init();
    AppMethodBeat.o(155977);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(155978);
    this.inJ = 0L;
    this.mNativePtr = 0L;
    this.inL = 0L;
    this.inK = paramString;
    init();
    AppMethodBeat.o(155978);
  }
  
  public final void free()
  {
    AppMethodBeat.i(155981);
    ae.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(155981);
  }
  
  final void init()
  {
    AppMethodBeat.i(155979);
    ae.i("MicroMsg.EncEngine", "init  key  enckey " + this.inK + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.inK);
    try
    {
      ae.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      AppMethodBeat.o(155979);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
      AppMethodBeat.o(155979);
    }
  }
  
  public final int z(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(155980);
    if (this.mNativePtr == 0L) {
      ae.i("MicroMsg.EncEngine", "transFor " + bu.fpN().toString());
    }
    if (inI) {
      ae.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((inI) && (this.inJ < 64L)) {
      ae.d("MicroMsg.EncEngine", "dump before _offset " + this.inJ + "  length:" + paramInt + " " + bu.cE(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.inJ, paramInt);
    if ((inI) && (this.inJ < 64L)) {
      ae.d("MicroMsg.EncEngine", "dump after _offset " + this.inJ + "  length:" + paramInt + " " + bu.cE(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.inJ += paramInt;
    AppMethodBeat.o(155980);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */