package com.tencent.mm.plugin.appbrand.jsapi.x.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  int duration;
  String filePath;
  String format;
  int kXq;
  int kXr;
  double kXs;
  c.a kXt;
  int sampleRate;
  
  public final String toString()
  {
    AppMethodBeat.i(137902);
    String str = "RecordParams{filePath='" + this.filePath + '\'' + ", duration=" + this.duration + ", sampleRate=" + this.sampleRate + ", numberOfChannels=" + this.kXq + ", format='" + this.format + '\'' + ", encodeBitRate=" + this.kXr + ", frameSize=" + this.kXs + ", audioSource=" + this.kXt + '}';
    AppMethodBeat.o(137902);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.a.c.b
 * JD-Core Version:    0.7.0.1
 */