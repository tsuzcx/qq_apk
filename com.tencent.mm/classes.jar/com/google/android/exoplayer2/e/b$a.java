package com.google.android.exoplayer2.e;

import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
  extends Exception
{
  public final boolean aNq;
  public final String aNr;
  public final String aNs;
  public final String mimeType;
  
  public b$a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super("Decoder init failed: [" + paramInt + "], " + paramFormat, paramThrowable);
    AppMethodBeat.i(95235);
    this.mimeType = paramFormat.awK;
    this.aNq = paramBoolean;
    this.aNr = null;
    if (paramInt < 0) {}
    for (paramFormat = "neg_";; paramFormat = "")
    {
      this.aNs = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
      AppMethodBeat.o(95235);
      return;
    }
  }
  
  public b$a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    super("Decoder init failed: " + paramString + ", " + paramFormat, paramThrowable);
    AppMethodBeat.i(95236);
    this.mimeType = paramFormat.awK;
    this.aNq = paramBoolean;
    this.aNr = paramString;
    paramFormat = localObject;
    if (x.SDK_INT >= 21)
    {
      paramFormat = localObject;
      if ((paramThrowable instanceof MediaCodec.CodecException)) {
        paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
      }
    }
    this.aNs = paramFormat;
    AppMethodBeat.o(95236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b.a
 * JD-Core Version:    0.7.0.1
 */