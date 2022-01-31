package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import java.util.Arrays;

public final class e
  extends com.google.android.exoplayer2.a
  implements Handler.Callback
{
  private final k aFR;
  private final c aGK;
  private final e.a aGL;
  private final Handler aGM;
  private final d aGN;
  private final Metadata[] aGO;
  private final long[] aGP;
  private int aGQ;
  private int aGR;
  private a aGS;
  private boolean aGq;
  
  public e(e.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, c.aGJ);
  }
  
  private e(e.a parama, Looper paramLooper, c paramc)
  {
    super(4);
    this.aGL = ((e.a)com.google.android.exoplayer2.i.a.E(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.aGM = parama;
      this.aGK = ((c)com.google.android.exoplayer2.i.a.E(paramc));
      this.aFR = new k();
      this.aGN = new d();
      this.aGO = new Metadata[5];
      this.aGP = new long[5];
      return;
    }
  }
  
  private void b(Metadata paramMetadata)
  {
    this.aGL.a(paramMetadata);
  }
  
  private void mu()
  {
    Arrays.fill(this.aGO, null);
    this.aGQ = 0;
    this.aGR = 0;
  }
  
  protected final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    this.aGS = this.aGK.h(paramArrayOfFormat[0]);
  }
  
  public final int b(Format paramFormat)
  {
    if (this.aGK.g(paramFormat)) {
      return 4;
    }
    return 0;
  }
  
  protected final void b(long paramLong, boolean paramBoolean)
  {
    mu();
    this.aGq = false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    if ((!this.aGq) && (this.aGR < 5))
    {
      this.aGN.clear();
      if (a(this.aFR, this.aGN, false) == -4)
      {
        if (!this.aGN.lz()) {
          break label140;
        }
        this.aGq = true;
      }
    }
    if ((this.aGR > 0) && (this.aGP[this.aGQ] <= paramLong1))
    {
      Metadata localMetadata = this.aGO[this.aGQ];
      if (this.aGM == null) {
        break label246;
      }
      this.aGM.obtainMessage(0, localMetadata).sendToTarget();
    }
    for (;;)
    {
      for (;;)
      {
        this.aGO[this.aGQ] = null;
        this.aGQ = ((this.aGQ + 1) % 5);
        this.aGR -= 1;
        return;
        label140:
        if (this.aGN.ly()) {
          break;
        }
        this.aGN.auG = this.aFR.auL.auG;
        this.aGN.lF();
        try
        {
          int i = (this.aGQ + this.aGR) % 5;
          this.aGO[i] = this.aGS.a(this.aGN);
          this.aGP[i] = this.aGN.ayE;
          this.aGR += 1;
        }
        catch (b localb)
        {
          throw com.google.android.exoplayer2.e.a(localb, this.index);
        }
      }
      label246:
      b(localb);
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new IllegalStateException();
    }
    b((Metadata)paramMessage.obj);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final boolean kU()
  {
    return this.aGq;
  }
  
  protected final void kz()
  {
    mu();
    this.aGS = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.7.0.1
 */