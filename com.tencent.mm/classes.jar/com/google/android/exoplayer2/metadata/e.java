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
  private final k bcI;
  private final c bdC;
  private final a bdD;
  private final Handler bdE;
  private final d bdF;
  private final Metadata[] bdG;
  private final long[] bdH;
  private int bdI;
  private int bdJ;
  private a bdK;
  private boolean bdi;
  
  public e(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.bdB);
  }
  
  private e(a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(92471);
    this.bdD = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bdE = parama;
      this.bdC = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.bcI = new k();
      this.bdF = new d();
      this.bdG = new Metadata[5];
      this.bdH = new long[5];
      AppMethodBeat.o(92471);
      return;
    }
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(92479);
    this.bdD.b(paramMetadata);
    AppMethodBeat.o(92479);
  }
  
  private void th()
  {
    AppMethodBeat.i(92477);
    Arrays.fill(this.bdG, null);
    this.bdI = 0;
    this.bdJ = 0;
    AppMethodBeat.o(92477);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92474);
    th();
    this.bdi = false;
    AppMethodBeat.o(92474);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92473);
    this.bdK = this.bdC.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(92473);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92472);
    if (this.bdC.g(paramFormat))
    {
      AppMethodBeat.o(92472);
      return 4;
    }
    AppMethodBeat.o(92472);
    return 0;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92475);
    if ((!this.bdi) && (this.bdJ < 5))
    {
      this.bdF.clear();
      if (a(this.bcI, this.bdF, false) == -4)
      {
        if (!this.bdF.rV()) {
          break label150;
        }
        this.bdi = true;
      }
    }
    if ((this.bdJ > 0) && (this.bdH[this.bdI] <= paramLong1))
    {
      Metadata localMetadata = this.bdG[this.bdI];
      if (this.bdE == null) {
        break label265;
      }
      this.bdE.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.bdG[this.bdI] = null;
        this.bdI = ((this.bdI + 1) % 5);
        this.bdJ -= 1;
        AppMethodBeat.o(92475);
        return;
        if (this.bdF.rU()) {
          break;
        }
        this.bdF.aNc = this.bcI.aNg.aNc;
        this.bdF.sa();
        try
        {
          int i = (this.bdI + this.bdJ) % 5;
          this.bdG[i] = this.bdK.a(this.bdF);
          this.bdH[i] = this.bdF.timeUs;
          this.bdJ += 1;
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
  
  public final void qU()
  {
    AppMethodBeat.i(92476);
    th();
    this.bdK = null;
    AppMethodBeat.o(92476);
  }
  
  public final boolean rt()
  {
    return this.bdi;
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