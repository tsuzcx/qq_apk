package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.h.a;

public class Mp3EncodeJni
{
  static
  {
    AppMethodBeat.i(146314);
    Mp3EncodeJni.class.getClassLoader();
    h.btD().dK("mp3lame");
    AppMethodBeat.o(146314);
  }
  
  public static native void close();
  
  public static native int encode(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt, byte[] paramArrayOfByte);
  
  public static native int encodeBufferInterleaved(short[] paramArrayOfShort, int paramInt, byte[] paramArrayOfByte);
  
  public static native int flush(byte[] paramArrayOfByte);
  
  public static native int getVersion();
  
  public static native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void setMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni
 * JD-Core Version:    0.7.0.1
 */