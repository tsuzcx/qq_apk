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
  private boolean btK;
  private final k btk;
  private final c bue;
  private final e.a bug;
  private final Handler buh;
  private final d bui;
  private final Metadata[] buj;
  private final long[] buk;
  private int bul;
  private int bum;
  private a bun;
  
  public e(e.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.bud);
  }
  
  private e(e.a parama, Looper paramLooper, c paramc)
  {
    super(4);
    AppMethodBeat.i(92471);
    this.bug = ((e.a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.buh = parama;
      this.bue = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.btk = new k();
      this.bui = new d();
      this.buj = new Metadata[5];
      this.buk = new long[5];
      AppMethodBeat.o(92471);
      return;
    }
  }
  
  private void d(Metadata paramMetadata)
  {
    AppMethodBeat.i(92479);
    this.bug.b(paramMetadata);
    AppMethodBeat.o(92479);
  }
  
  private void ve()
  {
    AppMethodBeat.i(92477);
    Arrays.fill(this.buj, null);
    this.bul = 0;
    this.bum = 0;
    AppMethodBeat.o(92477);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92474);
    ve();
    this.btK = false;
    AppMethodBeat.o(92474);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92473);
    this.bun = this.bue.h(paramArrayOfFormat[0]);
    AppMethodBeat.o(92473);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92472);
    if (this.bue.g(paramFormat))
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
    if ((!this.btK) && (this.bum < 5))
    {
      this.bui.clear();
      if (a(this.btk, this.bui, false) == -4)
      {
        if (!this.bui.tY()) {
          break label150;
        }
        this.btK = true;
      }
    }
    if ((this.bum > 0) && (this.buk[this.bul] <= paramLong1))
    {
      Metadata localMetadata = this.buj[this.bul];
      if (this.buh == null) {
        break label265;
      }
      this.buh.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      label150:
      com.google.android.exoplayer2.e locale;
      for (;;)
      {
        this.buj[this.bul] = null;
        this.bul = ((this.bul + 1) % 5);
        this.bum -= 1;
        AppMethodBeat.o(92475);
        return;
        if (this.bui.tX()) {
          break;
        }
        this.bui.bdF = this.btk.bdI.bdF;
        this.bui.ud();
        try
        {
          int i = (this.bul + this.bum) % 5;
          this.buj[i] = this.bun.a(this.bui);
          this.buk[i] = this.bui.timeUs;
          this.bum += 1;
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
  
  public final void sZ()
  {
    AppMethodBeat.i(92476);
    ve();
    this.bun = null;
    AppMethodBeat.o(92476);
  }
  
  public final boolean tw()
  {
    return this.btK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.7.0.1
 */