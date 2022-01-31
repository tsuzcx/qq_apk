package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private static boolean fOd = false;
  private long fOe;
  private String fOf;
  private long fOg;
  private long mNativePtr;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(93147);
    this.fOe = 0L;
    this.mNativePtr = 0L;
    this.fOg = 0L;
    this.fOf = String.valueOf(paramLong);
    init();
    AppMethodBeat.o(93147);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(93148);
    this.fOe = 0L;
    this.mNativePtr = 0L;
    this.fOg = 0L;
    this.fOf = paramString;
    init();
    AppMethodBeat.o(93148);
  }
  
  private void init()
  {
    AppMethodBeat.i(93149);
    ab.i("MicroMsg.EncEngine", "init  key  enckey " + this.fOf + "  hashcode " + hashCode());
    this.mNativePtr = MMIMAGEENCJNI.open(this.fOf);
    try
    {
      ab.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
      AppMethodBeat.o(93149);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.EncEngine", "exception " + localException.getMessage());
      AppMethodBeat.o(93149);
    }
  }
  
  public final long ajg()
  {
    this.fOg = this.fOe;
    return this.fOg;
  }
  
  public final void free()
  {
    AppMethodBeat.i(93153);
    ab.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
    MMIMAGEENCJNI.free(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(93153);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93150);
    ab.i("MicroMsg.EncEngine", "reset " + bo.dtY());
    free();
    if (this.fOg == 0L)
    {
      init();
      this.fOe = 0L;
      AppMethodBeat.o(93150);
      return;
    }
    init();
    MMIMAGEENCJNI.seek(this.mNativePtr, this.fOg, 1);
    this.fOe = this.fOg;
    AppMethodBeat.o(93150);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(93152);
    this.fOe = paramLong;
    MMIMAGEENCJNI.seek(this.mNativePtr, paramLong, 1);
    AppMethodBeat.o(93152);
  }
  
  public final int y(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93151);
    if (this.mNativePtr == 0L) {
      ab.i("MicroMsg.EncEngine", "transFor " + bo.dtY().toString());
    }
    if (fOd) {
      ab.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + paramArrayOfByte.length);
    }
    if ((fOd) && (this.fOe < 64L)) {
      ab.d("MicroMsg.EncEngine", "dump before _offset " + this.fOe + "  length:" + paramInt + " " + bo.cd(paramArrayOfByte) + " hashcode " + hashCode());
    }
    MMIMAGEENCJNI.transFor(this.mNativePtr, paramArrayOfByte, this.fOe, paramInt);
    if ((fOd) && (this.fOe < 64L)) {
      ab.d("MicroMsg.EncEngine", "dump after _offset " + this.fOe + "  length:" + paramInt + " " + bo.cd(paramArrayOfByte) + " hashcode " + hashCode());
    }
    this.fOe += paramInt;
    AppMethodBeat.o(93151);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.a
 * JD-Core Version:    0.7.0.1
 */