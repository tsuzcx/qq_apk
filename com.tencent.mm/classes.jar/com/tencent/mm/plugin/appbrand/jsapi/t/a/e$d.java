package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$d
{
  int duration = 600000;
  String filePath = "";
  int ifH = 2;
  String ifI = "pcm";
  int ifJ = 128000;
  double ifK = 0.0D;
  e.a ifL = e.a.ifz;
  int sampleRate = 44100;
  
  public final String toString()
  {
    AppMethodBeat.i(145945);
    String str = "RecordParams{filePath='" + this.filePath + '\'' + ", duration=" + this.duration + ", sampleRate=" + this.sampleRate + ", numberOfChannels=" + this.ifH + ", format='" + this.ifI + '\'' + ", encodeBitRate=" + this.ifJ + ", frameSize=" + this.ifK + ", audioSource=" + this.ifL + '}';
    AppMethodBeat.o(145945);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.e.d
 * JD-Core Version:    0.7.0.1
 */