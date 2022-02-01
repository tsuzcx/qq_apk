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
  private final k biQ;
  private final c bjK;
  private final a bjL;
  private final Handler bjM;
  private final d bjN;
  private final Metadata[] bjO;
  private final long[] bjP;
  private int bjQ;
  private int bjR;
  private a bjS;
  private boolean bjq;
  
  public e(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.bjJ);
  }
  
  private e(a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(92471);
    this.bjL = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bjM = parama;
      this.bjK = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.biQ = new k();
      this.bjN = new d();
      this.bjO = new Metadata[5];
      this.bjP = new long[5];
      AppMethodBeat.o(92471);
      return;
    }
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(92479);
    this.bjL.b(paramMetadata);
    AppMethodBeat.o(92479);
  }
  
  private void tF()
  {
    AppMethodBeat.i(92477);
    Arrays.fill(this.bjO, null);
    this.bjQ = 0;
    this.bjR = 0;
    AppMethodBeat.o(92477);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92474);
    tF();
    this.bjq = false;
    AppMethodBeat.o(92474);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92473);
    this.bjS = this.bjK.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(92473);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92472);
    if (this.bjK.g(paramFormat))
    {
      AppMethodBeat.o(92472);
      return 4;
    }
    AppMethodBeat.o(92472);
    return 0;
  }
  
  public final void e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92475);
    if ((!this.bjq) && (this.bjR < 5))
    {
      this.bjN.clear();
      if (a(this.biQ, this.bjN, false) == -4)
      {
        if (!this.bjN.sz()) {
          break label150;
        }
        this.bjq = true;
      }
    }
    if ((this.bjR > 0) && (this.bjP[this.bjQ] <= paramLong1))
    {
      Metadata localMetadata = this.bjO[this.bjQ];
      if (this.bjM == null) {
        break label265;
      }
      this.bjM.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.bjO[this.bjQ] = null;
        this.bjQ = ((this.bjQ + 1) % 5);
        this.bjR -= 1;
        AppMethodBeat.o(92475);
        return;
        if (this.bjN.sy()) {
          break;
        }
        this.bjN.aTk = this.biQ.aTo.aTk;
        this.bjN.sE();
        try
        {
          int i = (this.bjQ + this.bjR) % 5;
          this.bjO[i] = this.bjS.a(this.bjN);
          this.bjP[i] = this.bjN.timeUs;
          this.bjR += 1;
        }
        catch (b localb)
        {
          locale = com.google.android.exoplayer2.e.b(localb, this.index);
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
  
  public final void rA()
  {
    AppMethodBeat.i(92476);
    tF();
    this.bjS = null;
    AppMethodBeat.o(92476);
  }
  
  public final boolean rX()
  {
    return this.bjq;
  }
  
  public static abstract interface a
  {
    public abstract void b(Metadata paramMetadata);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.7.0.1
 */