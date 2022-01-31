package com.hilive.mediasdk;

import com.hilive.mediasdk.serialize.HPMarshaller;
import com.hilive.mediasdk.serialize.MshBuffer;
import com.hilive.mediasdk.serialize.SignalByteBufferPool;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InvokeEvent$IEAnalysis
  extends HPMarshaller
{
  public static final int evtType = 2;
  public String filePath = null;
  
  public byte[] format()
  {
    AppMethodBeat.i(142824);
    Object localObject = null;
    MshBuffer localMshBuffer = new MshBuffer(4096, SignalByteBufferPool.get());
    try
    {
      byte[] arrayOfByte = HPmarshall(localMshBuffer);
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      label29:
      break label29;
    }
    localMshBuffer.freeBuffer();
    AppMethodBeat.o(142824);
    return localObject;
  }
  
  public byte[] marshall()
  {
    AppMethodBeat.i(142823);
    pushString16(this.filePath);
    byte[] arrayOfByte = super.marshall();
    AppMethodBeat.o(142823);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.hilive.mediasdk.InvokeEvent.IEAnalysis
 * JD-Core Version:    0.7.0.1
 */