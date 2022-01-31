package com.google.android.exoplayer2.e;

import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.t;

public final class b$a
  extends Exception
{
  public final boolean aGv;
  public final String aGw;
  public final String aGx;
  public final String mimeType;
  
  public b$a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super("Decoder init failed: [" + paramInt + "], " + paramFormat, paramThrowable);
    this.mimeType = paramFormat.aus;
    this.aGv = paramBoolean;
    this.aGw = null;
    if (paramInt < 0) {}
    for (paramFormat = "neg_";; paramFormat = "")
    {
      this.aGx = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
      return;
    }
  }
  
  public b$a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    super("Decoder init failed: " + paramString + ", " + paramFormat, paramThrowable);
    this.mimeType = paramFormat.aus;
    this.aGv = paramBoolean;
    this.aGw = paramString;
    paramFormat = localObject;
    if (t.SDK_INT >= 21)
    {
      paramFormat = localObject;
      if ((paramThrowable instanceof MediaCodec.CodecException)) {
        paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
      }
    }
    this.aGx = paramFormat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b.a
 * JD-Core Version:    0.7.0.1
 */