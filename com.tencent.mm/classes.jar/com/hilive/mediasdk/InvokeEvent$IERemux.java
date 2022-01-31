package com.hilive.mediasdk;

import com.hilive.mediasdk.serialize.HPMarshaller;
import com.hilive.mediasdk.serialize.MshBuffer;
import com.hilive.mediasdk.serialize.SignalByteBufferPool;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class InvokeEvent$IERemux
  extends HPMarshaller
{
  public static final int evtType = 1;
  public String audioName;
  public int audioSuggestTransBitRates;
  public int audioSuggestTransChannels;
  public int audioSuggestTransCodecId;
  public int audioSuggestTransSampleRates;
  public String fileName;
  public Map<Long, Long> videoCutStamps;
  public String videoName;
  
  public InvokeEvent$IERemux()
  {
    AppMethodBeat.i(142825);
    this.videoName = null;
    this.videoCutStamps = new HashMap();
    this.audioName = null;
    this.audioSuggestTransCodecId = 0;
    this.audioSuggestTransChannels = 0;
    this.audioSuggestTransSampleRates = 0;
    this.audioSuggestTransBitRates = 0;
    this.fileName = null;
    AppMethodBeat.o(142825);
  }
  
  public byte[] format()
  {
    AppMethodBeat.i(142827);
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
    AppMethodBeat.o(142827);
    return localObject;
  }
  
  public byte[] marshall()
  {
    AppMethodBeat.i(142826);
    pushString16(this.videoName);
    pushMap(this.videoCutStamps, Long.class);
    pushString16(this.audioName);
    pushInt(this.audioSuggestTransCodecId);
    pushInt(this.audioSuggestTransChannels);
    pushInt(this.audioSuggestTransSampleRates);
    pushInt(this.audioSuggestTransBitRates);
    pushString16(this.fileName);
    byte[] arrayOfByte = super.marshall();
    AppMethodBeat.o(142826);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.hilive.mediasdk.InvokeEvent.IERemux
 * JD-Core Version:    0.7.0.1
 */