package com.tencent.live2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum V2TXLiveDef$V2TXLiveBufferType
{
  static
  {
    AppMethodBeat.i(213730);
    V2TXLiveBufferTypeUnknown = new V2TXLiveBufferType("V2TXLiveBufferTypeUnknown", 0);
    V2TXLiveBufferTypeByteBuffer = new V2TXLiveBufferType("V2TXLiveBufferTypeByteBuffer", 1);
    V2TXLiveBufferTypeByteArray = new V2TXLiveBufferType("V2TXLiveBufferTypeByteArray", 2);
    V2TXLiveBufferTypeTexture = new V2TXLiveBufferType("V2TXLiveBufferTypeTexture", 3);
    $VALUES = new V2TXLiveBufferType[] { V2TXLiveBufferTypeUnknown, V2TXLiveBufferTypeByteBuffer, V2TXLiveBufferTypeByteArray, V2TXLiveBufferTypeTexture };
    AppMethodBeat.o(213730);
  }
  
  private V2TXLiveDef$V2TXLiveBufferType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType
 * JD-Core Version:    0.7.0.1
 */