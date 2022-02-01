package com.tencent.mm.plugin.hp.net;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;

@Keep
public class SimpleHttpLogic
{
  public static native boolean pack(byte[] paramArrayOfByte1, PByteArray paramPByteArray, byte[] paramArrayOfByte2, int paramInt1, byte[] paramArrayOfByte3, String paramString, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt5, int paramInt6, int paramInt7);
  
  public static boolean packRequest(byte[] paramArrayOfByte, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(195596);
    boolean bool = pack(paramArrayOfByte, paramPByteArray, new byte[10], 0, new byte[10], "defaultid", 0, 3777, 1234567, new byte[10], new byte[10], 0, 6, 0);
    AppMethodBeat.o(195596);
    return bool;
  }
  
  public static native void startRequest(Request paramRequest, TaskCallback paramTaskCallback, String paramString);
  
  public static native boolean unpack(PByteArray paramPByteArray1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PByteArray paramPByteArray2, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4);
  
  public static boolean unpackResponse(byte[] paramArrayOfByte, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(195599);
    PInt localPInt = new PInt(-100);
    boolean bool = unpack(paramPByteArray, paramArrayOfByte, new byte[10], new PByteArray(), localPInt, new PInt(0), new PInt(0), new PInt(255));
    c.i("simple", "unpack ret is " + localPInt.value + " unpack result " + bool, new Object[0]);
    AppMethodBeat.o(195599);
    return bool;
  }
  
  @Keep
  public static class Request
  {
    public byte[] body;
    public String cgi;
    public String host;
  }
  
  @Keep
  public static abstract interface TaskCallback
  {
    public abstract void onCompleted(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.SimpleHttpLogic
 * JD-Core Version:    0.7.0.1
 */