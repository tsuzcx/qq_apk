package com.tencent.live2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum V2TXLiveDef$V2TXLiveStatusChangeReason
{
  static
  {
    AppMethodBeat.i(215702);
    V2TXLiveStatusChangeReasonInternal = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonInternal", 0);
    V2TXLiveStatusChangeReasonBufferingBegin = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonBufferingBegin", 1);
    V2TXLiveStatusChangeReasonBufferingEnd = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonBufferingEnd", 2);
    V2TXLiveStatusChangeReasonLocalStarted = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonLocalStarted", 3);
    V2TXLiveStatusChangeReasonLocalStopped = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonLocalStopped", 4);
    V2TXLiveStatusChangeReasonRemoteStarted = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonRemoteStarted", 5);
    V2TXLiveStatusChangeReasonRemoteStopped = new V2TXLiveStatusChangeReason("V2TXLiveStatusChangeReasonRemoteStopped", 6);
    $VALUES = new V2TXLiveStatusChangeReason[] { V2TXLiveStatusChangeReasonInternal, V2TXLiveStatusChangeReasonBufferingBegin, V2TXLiveStatusChangeReasonBufferingEnd, V2TXLiveStatusChangeReasonLocalStarted, V2TXLiveStatusChangeReasonLocalStopped, V2TXLiveStatusChangeReasonRemoteStarted, V2TXLiveStatusChangeReasonRemoteStopped };
    AppMethodBeat.o(215702);
  }
  
  private V2TXLiveDef$V2TXLiveStatusChangeReason() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason
 * JD-Core Version:    0.7.0.1
 */