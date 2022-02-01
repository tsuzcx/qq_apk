package com.google.android.exoplayer2.e;

import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
  extends Exception
{
  public final boolean btK;
  public final String btL;
  public final String btM;
  public final String mimeType;
  
  public b$a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super("Decoder init failed: [" + paramInt + "], " + paramFormat, paramThrowable);
    AppMethodBeat.i(92357);
    this.mimeType = paramFormat.bdq;
    this.btK = paramBoolean;
    this.btL = null;
    if (paramInt < 0) {}
    for (paramFormat = "neg_";; paramFormat = "")
    {
      this.btM = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
      AppMethodBeat.o(92357);
      return;
    }
  }
  
  public b$a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    super("Decoder init failed: " + paramString + ", " + paramFormat, paramThrowable);
    AppMethodBeat.i(92358);
    this.mimeType = paramFormat.bdq;
    this.btK = paramBoolean;
    this.btL = paramString;
    paramFormat = localObject;
    if (x.SDK_INT >= 21)
    {
      paramFormat = localObject;
      if ((paramThrowable instanceof MediaCodec.CodecException)) {
        paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
      }
    }
    this.btM = paramFormat;
    AppMethodBeat.o(92358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b.a
 * JD-Core Version:    0.7.0.1
 */