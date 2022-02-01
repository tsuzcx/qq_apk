package com.tencent.live2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum V2TXLiveDef$V2TXLivePushStatus
{
  static
  {
    AppMethodBeat.i(215298);
    V2TXLivePushStatusDisconnected = new V2TXLivePushStatus("V2TXLivePushStatusDisconnected", 0);
    V2TXLivePushStatusConnecting = new V2TXLivePushStatus("V2TXLivePushStatusConnecting", 1);
    V2TXLivePushStatusConnectSuccess = new V2TXLivePushStatus("V2TXLivePushStatusConnectSuccess", 2);
    V2TXLivePushStatusReconnecting = new V2TXLivePushStatus("V2TXLivePushStatusReconnecting", 3);
    $VALUES = new V2TXLivePushStatus[] { V2TXLivePushStatusDisconnected, V2TXLivePushStatusConnecting, V2TXLivePushStatusConnectSuccess, V2TXLivePushStatusReconnecting };
    AppMethodBeat.o(215298);
  }
  
  private V2TXLiveDef$V2TXLivePushStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus
 * JD-Core Version:    0.7.0.1
 */