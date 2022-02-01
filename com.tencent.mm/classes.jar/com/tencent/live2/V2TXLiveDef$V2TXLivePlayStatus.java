package com.tencent.live2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum V2TXLiveDef$V2TXLivePlayStatus
{
  static
  {
    AppMethodBeat.i(211319);
    V2TXLivePlayStatusStopped = new V2TXLivePlayStatus("V2TXLivePlayStatusStopped", 0);
    V2TXLivePlayStatusPlaying = new V2TXLivePlayStatus("V2TXLivePlayStatusPlaying", 1);
    V2TXLivePlayStatusLoading = new V2TXLivePlayStatus("V2TXLivePlayStatusLoading", 2);
    $VALUES = new V2TXLivePlayStatus[] { V2TXLivePlayStatusStopped, V2TXLivePlayStatusPlaying, V2TXLivePlayStatusLoading };
    AppMethodBeat.o(211319);
  }
  
  private V2TXLiveDef$V2TXLivePlayStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus
 * JD-Core Version:    0.7.0.1
 */