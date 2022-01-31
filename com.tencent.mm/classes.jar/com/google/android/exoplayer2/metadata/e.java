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
  private final k aMM;
  private final c aNF;
  private final e.a aNG;
  private final Handler aNH;
  private final d aNI;
  private final Metadata[] aNJ;
  private final long[] aNK;
  private int aNL;
  private int aNM;
  private a aNN;
  private boolean aNl;
  
  public e(e.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.aNE);
  }
  
  private e(e.a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(95349);
    this.aNG = ((e.a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.aNH = parama;
      this.aNF = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aMM = new k();
      this.aNI = new d();
      this.aNJ = new Metadata[5];
      this.aNK = new long[5];
      AppMethodBeat.o(95349);
      return;
    }
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(95357);
    this.aNG.b(paramMetadata);
    AppMethodBeat.o(95357);
  }
  
  private void oL()
  {
    AppMethodBeat.i(95355);
    Arrays.fill(this.aNJ, null);
    this.aNL = 0;
    this.aNM = 0;
    AppMethodBeat.o(95355);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(95351);
    this.aNN = this.aNF.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(95351);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(95350);
    if (this.aNF.g(paramFormat))
    {
      AppMethodBeat.o(95350);
      return 4;
    }
    AppMethodBeat.o(95350);
    return 0;
  }
  
  public final void b(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95352);
    oL();
    this.aNl = false;
    AppMethodBeat.o(95352);
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95353);
    if ((!this.aNl) && (this.aNM < 5))
    {
      this.aNI.clear();
      if (a(this.aMM, this.aNI, false) == -4)
      {
        if (!this.aNI.nE()) {
          break label150;
        }
        this.aNl = true;
      }
    }
    if ((this.aNM > 0) && (this.aNK[this.aNL] <= paramLong1))
    {
      Metadata localMetadata = this.aNJ[this.aNL];
      if (this.aNH == null) {
        break label265;
      }
      this.aNH.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.aNJ[this.aNL] = null;
        this.aNL = ((this.aNL + 1) % 5);
        this.aNM -= 1;
        AppMethodBeat.o(95353);
        return;
        if (this.aNI.nD()) {
          break;
        }
        this.aNI.awY = this.aMM.axd.awY;
        this.aNI.nJ();
        try
        {
          int i = (this.aNL + this.aNM) % 5;
          this.aNJ[i] = this.aNN.a(this.aNI);
          this.aNK[i] = this.aNI.aAT;
          this.aNM += 1;
        }
        catch (b localb)
        {
          locale = com.google.android.exoplayer2.e.b(localb, this.index);
          AppMethodBeat.o(95353);
          throw locale;
        }
      }
      label265:
      d(locale);
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(95356);
    switch (paramMessage.what)
    {
    default: 
      paramMessage = new IllegalStateException();
      AppMethodBeat.o(95356);
      throw paramMessage;
    }
    d((Metadata)paramMessage.obj);
    AppMethodBeat.o(95356);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final void mF()
  {
    AppMethodBeat.i(95354);
    oL();
    this.aNN = null;
    AppMethodBeat.o(95354);
  }
  
  public final boolean nd()
  {
    return this.aNl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.7.0.1
 */