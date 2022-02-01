package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  private static boolean hRB = false;
  long hRC;
  private String hRD;
  long hRE;
  long mNativePtr;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(155977);
    this.hRC = 0L;
    this.mNativePtr = 0L;
    this.hRE = 0L;
    this.hRD = String.valueOf(paramLong);
    init();
    AppMethodBeat.o(155977);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(155978);
    this.hRC = 0L;
    this.mNativePtr = 0L;
    this.hRE = 0L;
    this.hRD = paramString;
    init();
    AppMethodBeat.o(155978);
  }
  
  public final void free()
  {
    AppMethodBeat.i(155981);
    ac.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(155981);
  }
  
  final void init()
  {
    AppMethodBeat.i(155979);
    ac.i("MicroMsg.EncEngine", "init  key  enckey " + this.hRD + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.hRD);
    try
    {
      ac.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      AppMethodBeat.o(155979);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
      AppMethodBeat.o(155979);
    }
  }
  
  public final int z(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(155980);
    if (this.mNativePtr == 0L) {
      ac.i("MicroMsg.EncEngine", "transFor " + bs.eWi().toString());
    }
    if (hRB) {
      ac.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((hRB) && (this.hRC < 64L)) {
      ac.d("MicroMsg.EncEngine", "dump before _offset " + this.hRC + "  length:" + paramInt + " " + bs.cu(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.hRC, paramInt);
    if ((hRB) && (this.hRC < 64L)) {
      ac.d("MicroMsg.EncEngine", "dump after _offset " + this.hRC + "  length:" + paramInt + " " + bs.cu(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.hRC += paramInt;
    AppMethodBeat.o(155980);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */