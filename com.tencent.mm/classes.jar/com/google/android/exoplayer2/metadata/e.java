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
  private boolean biL;
  private final k bil;
  private final c bjf;
  private final a bjg;
  private final Handler bjh;
  private final d bji;
  private final Metadata[] bjj;
  private final long[] bjk;
  private int bjl;
  private int bjm;
  private a bjn;
  
  public e(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.bje);
  }
  
  private e(a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(92471);
    this.bjg = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bjh = parama;
      this.bjf = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.bil = new k();
      this.bji = new d();
      this.bjj = new Metadata[5];
      this.bjk = new long[5];
      AppMethodBeat.o(92471);
      return;
    }
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(92479);
    this.bjg.b(paramMetadata);
    AppMethodBeat.o(92479);
  }
  
  private void tx()
  {
    AppMethodBeat.i(92477);
    Arrays.fill(this.bjj, null);
    this.bjl = 0;
    this.bjm = 0;
    AppMethodBeat.o(92477);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92474);
    tx();
    this.biL = false;
    AppMethodBeat.o(92474);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92473);
    this.bjn = this.bjf.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(92473);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92472);
    if (this.bjf.g(paramFormat))
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
    if ((!this.biL) && (this.bjm < 5))
    {
      this.bji.clear();
      if (a(this.bil, this.bji, false) == -4)
      {
        if (!this.bji.sq()) {
          break label150;
        }
        this.biL = true;
      }
    }
    if ((this.bjm > 0) && (this.bjk[this.bjl] <= paramLong1))
    {
      Metadata localMetadata = this.bjj[this.bjl];
      if (this.bjh == null) {
        break label265;
      }
      this.bjh.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.bjj[this.bjl] = null;
        this.bjl = ((this.bjl + 1) % 5);
        this.bjm -= 1;
        AppMethodBeat.o(92475);
        return;
        if (this.bji.sp()) {
          break;
        }
        this.bji.aSr = this.bil.aSv.aSr;
        this.bji.sv();
        try
        {
          int i = (this.bjl + this.bjm) % 5;
          this.bjj[i] = this.bjn.a(this.bji);
          this.bjk[i] = this.bji.timeUs;
          this.bjm += 1;
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
  
  public final boolean rM()
  {
    return this.biL;
  }
  
  public final void rp()
  {
    AppMethodBeat.i(92476);
    tx();
    this.bjn = null;
    AppMethodBeat.o(92476);
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