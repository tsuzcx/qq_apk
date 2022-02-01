package com.google.android.exoplayer2.c.a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

final class a
  extends d
{
  private static final int[] aXe = { 5512, 11025, 22050, 44100 };
  private boolean aXf;
  private boolean aXg;
  private int audioFormat;
  
  public a(com.google.android.exoplayer2.c.m paramm)
  {
    super(paramm);
  }
  
  protected final void a(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    AppMethodBeat.i(91977);
    if (this.audioFormat == 2)
    {
      i = paramm.vJ();
      this.aXw.a(paramm, i);
      this.aXw.a(paramLong, 1, i, 0, null);
      AppMethodBeat.o(91977);
      return;
    }
    int i = paramm.readUnsignedByte();
    if ((i == 0) && (!this.aXg))
    {
      byte[] arrayOfByte = new byte[paramm.vJ()];
      paramm.readBytes(arrayOfByte, 0, arrayOfByte.length);
      paramm = com.google.android.exoplayer2.i.d.v(arrayOfByte);
      paramm = Format.a(null, "audio/mp4a-latm", -1, -1, ((Integer)paramm.second).intValue(), ((Integer)paramm.first).intValue(), Collections.singletonList(arrayOfByte), null, null);
      this.aXw.f(paramm);
      this.aXg = true;
      AppMethodBeat.o(91977);
      return;
    }
    if ((this.audioFormat != 10) || (i == 1))
    {
      i = paramm.vJ();
      this.aXw.a(paramm, i);
      this.aXw.a(paramLong, 1, i, 0, null);
    }
    AppMethodBeat.o(91977);
  }
  
  protected final boolean a(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 2;
    AppMethodBeat.i(91976);
    int j;
    if (!this.aXf)
    {
      j = paramm.readUnsignedByte();
      this.audioFormat = (j >> 4 & 0xF);
      if (this.audioFormat == 2)
      {
        paramm = Format.a(null, "audio/mpeg", -1, -1, 1, aXe[(j >> 2 & 0x3)], null, null, null);
        this.aXw.f(paramm);
        this.aXg = true;
        this.aXf = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(91976);
      return true;
      if ((this.audioFormat == 7) || (this.audioFormat == 8))
      {
        if (this.audioFormat == 7)
        {
          paramm = "audio/g711-alaw";
          label116:
          if ((j & 0x1) != 1) {
            break label164;
          }
        }
        for (;;)
        {
          paramm = Format.a(null, paramm, -1, -1, 1, 8000, i, null, null, 0, null);
          this.aXw.f(paramm);
          this.aXg = true;
          break;
          paramm = "audio/g711-mlaw";
          break label116;
          label164:
          i = 3;
        }
      }
      if (this.audioFormat == 10) {
        break;
      }
      paramm = new d.a("Audio format not supported: " + this.audioFormat);
      AppMethodBeat.o(91976);
      throw paramm;
      paramm.fl(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.a
 * JD-Core Version:    0.7.0.1
 */