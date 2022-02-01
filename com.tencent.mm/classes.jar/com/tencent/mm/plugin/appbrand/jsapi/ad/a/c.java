package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
  extends b
{
  public static enum a
  {
    public int mFN;
    public String mFO;
    
    static
    {
      AppMethodBeat.i(137901);
      mFH = new a("AUTO", 0, 0, "auto");
      mFI = new a("MIC", 1, 1, "mic");
      mFJ = new a("CAMCORDER", 2, 5, "camcorder");
      mFK = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
      mFL = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
      mFM = new a("UNPROCESSED", 5, 9, "unprocessed");
      mFP = new a[] { mFH, mFI, mFJ, mFK, mFL, mFM };
      AppMethodBeat.o(137901);
    }
    
    private a(int paramInt, String paramString)
    {
      this.mFN = paramInt;
      this.mFO = paramString;
    }
  }
  
  public static final class b
  {
    int duration;
    String filePath;
    String format;
    int mFQ;
    int mFR;
    double mFS;
    c.a mFT;
    int sampleRate;
    
    public final String toString()
    {
      AppMethodBeat.i(137902);
      String str = "RecordParams{filePath='" + this.filePath + '\'' + ", duration=" + this.duration + ", sampleRate=" + this.sampleRate + ", numberOfChannels=" + this.mFQ + ", format='" + this.format + '\'' + ", encodeBitRate=" + this.mFR + ", frameSize=" + this.mFS + ", audioSource=" + this.mFT + '}';
      AppMethodBeat.o(137902);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.c
 * JD-Core Version:    0.7.0.1
 */