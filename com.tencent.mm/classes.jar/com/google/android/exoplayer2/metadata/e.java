package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
  extends com.google.android.exoplayer2.a
  implements Handler.Callback
{
  private final k cWD;
  private final Metadata[] cXA;
  private final long[] cXB;
  private int cXC;
  private int cXD;
  private a cXE;
  private boolean cXc;
  private final c cXw;
  private final a cXx;
  private final Handler cXy;
  private final d cXz;
  
  public e(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.cXv);
  }
  
  private e(a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(92471);
    this.cXx = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.cXy = parama;
      this.cXw = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.cWD = new k();
      this.cXz = new d();
      this.cXA = new Metadata[5];
      this.cXB = new long[5];
      AppMethodBeat.o(92471);
      return;
    }
  }
  
  private void SK()
  {
    AppMethodBeat.i(92477);
    Arrays.fill(this.cXA, null);
    this.cXC = 0;
    this.cXD = 0;
    AppMethodBeat.o(92477);
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(92479);
    this.cXx.b(paramMetadata);
    AppMethodBeat.o(92479);
  }
  
  public final void B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92475);
    if ((!this.cXc) && (this.cXD < 5))
    {
      this.cXz.clear();
      if (a(this.cWD, this.cXz, false) == -4)
      {
        if (!this.cXz.Ry()) {
          break label150;
        }
        this.cXc = true;
      }
    }
    if ((this.cXD > 0) && (this.cXB[this.cXC] <= paramLong1))
    {
      Metadata localMetadata = this.cXA[this.cXC];
      if (this.cXy == null) {
        break label265;
      }
      this.cXy.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.cXA[this.cXC] = null;
        this.cXC = ((this.cXC + 1) % 5);
        this.cXD -= 1;
        AppMethodBeat.o(92475);
        return;
        if (this.cXz.Rx()) {
          break;
        }
        this.cXz.cGY = this.cWD.cHc.cGY;
        this.cXz.RD();
        try
        {
          int i = (this.cXC + this.cXD) % 5;
          this.cXA[i] = this.cXE.a(this.cXz);
          this.cXB[i] = this.cXz.timeUs;
          this.cXD += 1;
        }
        catch (b localb)
        {
          locale = com.google.android.exoplayer2.e.b(localb, getIndex());
          AppMethodBeat.o(92475);
          throw locale;
        }
      }
      label265:
      d(locale);
    }
  }
  
  public final boolean QU()
  {
    return this.cXc;
  }
  
  public final void Qw()
  {
    AppMethodBeat.i(92476);
    SK();
    this.cXE = null;
    AppMethodBeat.o(92476);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92473);
    this.cXE = this.cXw.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(92473);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92472);
    if (this.cXw.g(paramFormat))
    {
      AppMethodBeat.o(92472);
      return 4;
    }
    AppMethodBeat.o(92472);
    return 0;
  }
  
  public final void f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92474);
    SK();
    this.cXc = false;
    AppMethodBeat.o(92474);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(92478);
    switch (paramMessage.what)
    {
    default: 
      paramMessage = new IllegalStateException();
      AppMethodBeat.o(92478);
      throw paramMessage;
    }
    d((Metadata)paramMessage.obj);
    AppMethodBeat.o(92478);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void b(Metadata paramMetadata);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.7.0.1
 */