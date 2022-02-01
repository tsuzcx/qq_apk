package com.tencent.live2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V2TXLiveDef
{
  public static enum V2TXLiveVideoResolutionMode
  {
    static
    {
      AppMethodBeat.i(211365);
      V2TXLiveVideoResolutionModeLandscape = new V2TXLiveVideoResolutionMode("V2TXLiveVideoResolutionModeLandscape", 0);
      V2TXLiveVideoResolutionModePortrait = new V2TXLiveVideoResolutionMode("V2TXLiveVideoResolutionModePortrait", 1);
      $VALUES = new V2TXLiveVideoResolutionMode[] { V2TXLiveVideoResolutionModeLandscape, V2TXLiveVideoResolutionModePortrait };
      AppMethodBeat.o(211365);
    }
    
    private V2TXLiveVideoResolutionMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef
 * JD-Core Version:    0.7.0.1
 */