package com.tencent.mm.plugin.cast.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cast.h.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "", "()V", "audioChannelCnt", "", "getAudioChannelCnt", "()I", "setAudioChannelCnt", "(I)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "isAudioRecordAllow", "", "()Z", "setAudioRecordAllow", "(Z)V", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public int audioSampleRate;
  public boolean wMt;
  public int wMu;
  
  public a()
  {
    AppMethodBeat.i(274041);
    e locale = e.wOn;
    this.wMt = e.dpM();
    locale = e.wOn;
    this.audioSampleRate = e.dpN();
    locale = e.wOn;
    this.wMu = e.dpQ();
    AppMethodBeat.o(274041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.a.a
 * JD-Core Version:    0.7.0.1
 */