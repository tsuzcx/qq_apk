package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static boolean hqZ = false;
  long hra;
  private String hrb;
  long hrc;
  long mNativePtr;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(155977);
    this.hra = 0L;
    this.mNativePtr = 0L;
    this.hrc = 0L;
    this.hrb = String.valueOf(paramLong);
    init();
    AppMethodBeat.o(155977);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(155978);
    this.hra = 0L;
    this.mNativePtr = 0L;
    this.hrc = 0L;
    this.hrb = paramString;
    init();
    AppMethodBeat.o(155978);
  }
  
  public final int B(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(155980);
    if (this.mNativePtr == 0L) {
      ad.i("MicroMsg.EncEngine", "transFor " + bt.eGN().toString());
    }
    if (hqZ) {
      ad.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((hqZ) && (this.hra < 64L)) {
      ad.d("MicroMsg.EncEngine", "dump before _offset " + this.hra + "  length:" + paramInt + " " + bt.cv(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.hra, paramInt);
    if ((hqZ) && (this.hra < 64L)) {
      ad.d("MicroMsg.EncEngine", "dump after _offset " + this.hra + "  length:" + paramInt + " " + bt.cv(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.hra += paramInt;
    AppMethodBeat.o(155980);
    return paramInt;
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
    ad.i("MicroMsg.EncEngine", "init  key  enckey " + this.hrb + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.hrb);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */