package com.tencent.mm.plugin.cast.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cast.i.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "", "()V", "audioChannelCnt", "", "getAudioChannelCnt", "()I", "setAudioChannelCnt", "(I)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "isAudioRecordAllow", "", "()Z", "setAudioRecordAllow", "(Z)V", "plugin-cast_release"})
public final class a
{
  public int audioSampleRate;
  public boolean tIM;
  public int tIN;
  
  public a()
  {
    AppMethodBeat.i(189935);
    e locale = e.tKY;
    this.tIM = e.cMi();
    locale = e.tKY;
    this.audioSampleRate = e.cMj();
    locale = e.tKY;
    this.tIN = e.cMm();
    AppMethodBeat.o(189935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.b.a
 * JD-Core Version:    0.7.0.1
 */