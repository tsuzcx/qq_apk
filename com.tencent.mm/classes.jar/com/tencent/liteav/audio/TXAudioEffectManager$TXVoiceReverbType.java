package com.tencent.liteav.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TXAudioEffectManager$TXVoiceReverbType
{
  private int nativeValue;
  
  static
  {
    AppMethodBeat.i(247065);
    TXLiveVoiceReverbType_0 = new TXVoiceReverbType("TXLiveVoiceReverbType_0", 0, 0);
    TXLiveVoiceReverbType_1 = new TXVoiceReverbType("TXLiveVoiceReverbType_1", 1, 1);
    TXLiveVoiceReverbType_2 = new TXVoiceReverbType("TXLiveVoiceReverbType_2", 2, 2);
    TXLiveVoiceReverbType_3 = new TXVoiceReverbType("TXLiveVoiceReverbType_3", 3, 3);
    TXLiveVoiceReverbType_4 = new TXVoiceReverbType("TXLiveVoiceReverbType_4", 4, 4);
    TXLiveVoiceReverbType_5 = new TXVoiceReverbType("TXLiveVoiceReverbType_5", 5, 5);
    TXLiveVoiceReverbType_6 = new TXVoiceReverbType("TXLiveVoiceReverbType_6", 6, 6);
    TXLiveVoiceReverbType_7 = new TXVoiceReverbType("TXLiveVoiceReverbType_7", 7, 7);
    $VALUES = new TXVoiceReverbType[] { TXLiveVoiceReverbType_0, TXLiveVoiceReverbType_1, TXLiveVoiceReverbType_2, TXLiveVoiceReverbType_3, TXLiveVoiceReverbType_4, TXLiveVoiceReverbType_5, TXLiveVoiceReverbType_6, TXLiveVoiceReverbType_7 };
    AppMethodBeat.o(247065);
  }
  
  private TXAudioEffectManager$TXVoiceReverbType(int paramInt)
  {
    this.nativeValue = paramInt;
  }
  
  public final int getNativeValue()
  {
    return this.nativeValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType
 * JD-Core Version:    0.7.0.1
 */