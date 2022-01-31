package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.t;

public final class s<T>
  implements r.c
{
  public final i aJa;
  private final s.a<? extends T> aSc;
  private volatile boolean aSd;
  public volatile long aSe;
  private final f ayZ;
  public volatile T result;
  public final int type;
  
  public s(f paramf, Uri paramUri, s.a<? extends T> parama)
  {
    this.ayZ = paramf;
    this.aJa = new i(paramUri);
    this.type = 4;
    this.aSc = parama;
  }
  
  public final void mR()
  {
    this.aSd = true;
  }
  
  public final boolean mS()
  {
    return this.aSd;
  }
  
  public final void mT()
  {
    h localh = new h(this.ayZ, this.aJa);
    try
    {
      localh.nQ();
      this.result = this.aSc.b(this.ayZ.getUri(), localh);
      return;
    }
    finally
    {
      this.aSe = localh.aQT;
      t.closeQuietly(localh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s
 * JD-Core Version:    0.7.0.1
 */