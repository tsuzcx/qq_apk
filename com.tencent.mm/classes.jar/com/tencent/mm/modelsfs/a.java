package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static boolean jiQ = false;
  long jiR;
  private String jiS;
  long jiT;
  long mNativePtr;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(155977);
    this.jiR = 0L;
    this.mNativePtr = 0L;
    this.jiT = 0L;
    this.jiS = String.valueOf(paramLong);
    init();
    AppMethodBeat.o(155977);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(155978);
    this.jiR = 0L;
    this.mNativePtr = 0L;
    this.jiT = 0L;
    this.jiS = paramString;
    init();
    AppMethodBeat.o(155978);
  }
  
  public final int B(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(155980);
    if (this.mNativePtr == 0L) {
      Log.i("MicroMsg.EncEngine", "transFor " + Util.getStack().toString());
    }
    if (jiQ) {
      Log.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((jiQ) && (this.jiR < 64L)) {
      Log.d("MicroMsg.EncEngine", "dump before _offset " + this.jiR + "  length:" + paramInt + " " + Util.dumpHex(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.jiR, paramInt);
    if ((jiQ) && (this.jiR < 64L)) {
      Log.d("MicroMsg.EncEngine", "dump after _offset " + this.jiR + "  length:" + paramInt + " " + Util.dumpHex(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.jiR += paramInt;
    AppMethodBeat.o(155980);
    return paramInt;
  }
  
  public final void free()
  {
    AppMethodBeat.i(155981);
    Log.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(155981);
  }
  
  final void init()
  {
    AppMethodBeat.i(155979);
    Log.i("MicroMsg.EncEngine", "init  key  enckey " + this.jiS + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.jiS);
    try
    {
      Log.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      AppMethodBeat.o(155979);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
      AppMethodBeat.o(155979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */