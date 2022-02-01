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
  private boolean btF;
  private final c btZ;
  private final k btf;
  private final a bua;
  private final Handler bub;
  private final d buc;
  private final Metadata[] bud;
  private final long[] bue;
  private int bug;
  private int buh;
  private a bui;
  
  public e(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.btY);
  }
  
  private e(a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(92471);
    this.bua = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bub = parama;
      this.btZ = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.btf = new k();
      this.buc = new d();
      this.bud = new Metadata[5];
      this.bue = new long[5];
      AppMethodBeat.o(92471);
      return;
    }
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(92479);
    this.bua.b(paramMetadata);
    AppMethodBeat.o(92479);
  }
  
  private void vj()
  {
    AppMethodBeat.i(92477);
    Arrays.fill(this.bud, null);
    this.bug = 0;
    this.buh = 0;
    AppMethodBeat.o(92477);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92474);
    vj();
    this.btF = false;
    AppMethodBeat.o(92474);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92473);
    this.bui = this.btZ.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(92473);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92472);
    if (this.btZ.g(paramFormat))
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
    if ((!this.btF) && (this.buh < 5))
    {
      this.buc.clear();
      if (a(this.btf, this.buc, false) == -4)
      {
        if (!this.buc.ud()) {
          break label150;
        }
        this.btF = true;
      }
    }
    if ((this.buh > 0) && (this.bue[this.bug] <= paramLong1))
    {
      Metadata localMetadata = this.bud[this.bug];
      if (this.bub == null) {
        break label265;
      }
      this.bub.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.bud[this.bug] = null;
        this.bug = ((this.bug + 1) % 5);
        this.buh -= 1;
        AppMethodBeat.o(92475);
        return;
        if (this.buc.uc()) {
          break;
        }
        this.buc.bdC = this.btf.bdF.bdC;
        this.buc.ui();
        try
        {
          int i = (this.bug + this.buh) % 5;
          this.bud[i] = this.bui.a(this.buc);
          this.bue[i] = this.buc.timeUs;
          this.buh += 1;
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
  
  public final boolean tB()
  {
    return this.btF;
  }
  
  public final void te()
  {
    AppMethodBeat.i(92476);
    vj();
    this.bui = null;
    AppMethodBeat.o(92476);
  }
  
  public static abstract interface a
  {
    public abstract void b(Metadata paramMetadata);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.7.0.1
 */