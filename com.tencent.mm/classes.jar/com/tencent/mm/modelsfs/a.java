package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static boolean ikP = false;
  long ikQ;
  private String ikR;
  long ikS;
  long mNativePtr;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(155977);
    this.ikQ = 0L;
    this.mNativePtr = 0L;
    this.ikS = 0L;
    this.ikR = String.valueOf(paramLong);
    init();
    AppMethodBeat.o(155977);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(155978);
    this.ikQ = 0L;
    this.mNativePtr = 0L;
    this.ikS = 0L;
    this.ikR = paramString;
    init();
    AppMethodBeat.o(155978);
  }
  
  public final void free()
  {
    AppMethodBeat.i(155981);
    ad.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(155981);
  }
  
  final void init()
  {
    AppMethodBeat.i(155979);
    ad.i("MicroMsg.EncEngine", "init  key  enckey " + this.ikR + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.ikR);
    try
    {
      ad.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      AppMethodBeat.o(155979);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
      AppMethodBeat.o(155979);
    }
  }
  
  public final int z(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(155980);
    if (this.mNativePtr == 0L) {
      ad.i("MicroMsg.EncEngine", "transFor " + bt.flS().toString());
    }
    if (ikP) {
      ad.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((ikP) && (this.ikQ < 64L)) {
      ad.d("MicroMsg.EncEngine", "dump before _offset " + this.ikQ + "  length:" + paramInt + " " + bt.cB(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.ikQ, paramInt);
    if ((ikP) && (this.ikQ < 64L)) {
      ad.d("MicroMsg.EncEngine", "dump after _offset " + this.ikQ + "  length:" + paramInt + " " + bt.cB(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.ikQ += paramInt;
    AppMethodBeat.o(155980);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */