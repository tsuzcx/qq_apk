package com.tencent.mm.plugin.appbrand.jsapi.y.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  int duration;
  String filePath;
  String format;
  int kwc;
  int kwd;
  double kwe;
  c.a kwf;
  int sampleRate;
  
  public final String toString()
  {
    AppMethodBeat.i(137902);
    String str = "RecordParams{filePath='" + this.filePath + '\'' + ", duration=" + this.duration + ", sampleRate=" + this.sampleRate + ", numberOfChannels=" + this.kwc + ", format='" + this.format + '\'' + ", encodeBitRate=" + this.kwd + ", frameSize=" + this.kwe + ", audioSource=" + this.kwf + '}';
    AppMethodBeat.o(137902);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.c.b
 * JD-Core Version:    0.7.0.1
 */