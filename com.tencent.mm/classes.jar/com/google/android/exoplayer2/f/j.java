package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import java.util.Collections;
import java.util.List;

public final class j
  extends com.google.android.exoplayer2.a
  implements Handler.Callback
{
  private final k aFR;
  private final Handler aGM;
  private boolean aGq;
  private boolean aGr;
  private int aMA;
  private final j.a aMs;
  private final g aMt;
  private int aMu;
  private Format aMv;
  private e aMw;
  private h aMx;
  private i aMy;
  private i aMz;
  
  public j(j.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.aMq);
  }
  
  private j(j.a parama, Looper paramLooper, g paramg)
  {
    super(3);
    this.aMs = ((j.a)com.google.android.exoplayer2.i.a.E(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.aGM = parama;
      this.aMt = paramg;
      this.aFR = new k();
      return;
    }
  }
  
  private void nl()
  {
    this.aMx = null;
    this.aMA = -1;
    if (this.aMy != null)
    {
      this.aMy.release();
      this.aMy = null;
    }
    if (this.aMz != null)
    {
      this.aMz.release();
      this.aMz = null;
    }
  }
  
  private void nm()
  {
    nl();
    this.aMw.release();
    this.aMw = null;
    this.aMu = 0;
  }
  
  private void nn()
  {
    nm();
    this.aMw = this.aMt.k(this.aMv);
  }
  
  private long no()
  {
    if ((this.aMA == -1) || (this.aMA >= this.aMy.nk())) {
      return 9223372036854775807L;
    }
    return this.aMy.dn(this.aMA);
  }
  
  private void t(List<a> paramList)
  {
    if (this.aGM != null)
    {
      this.aGM.obtainMessage(0, paramList).sendToTarget();
      return;
    }
    u(paramList);
  }
  
  private void u(List<a> paramList)
  {
    this.aMs.p(paramList);
  }
  
  protected final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    this.aMv = paramArrayOfFormat[0];
    if (this.aMw != null)
    {
      this.aMu = 1;
      return;
    }
    this.aMw = this.aMt.k(this.aMv);
  }
  
  public final int b(Format paramFormat)
  {
    if (this.aMt.g(paramFormat)) {
      return 4;
    }
    if (com.google.android.exoplayer2.i.g.ax(paramFormat.aus)) {
      return 1;
    }
    return 0;
  }
  
  protected final void b(long paramLong, boolean paramBoolean)
  {
    t(Collections.emptyList());
    this.aGq = false;
    this.aGr = false;
    if (this.aMu != 0)
    {
      nn();
      return;
    }
    nl();
    this.aMw.flush();
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    if (this.aGr) {}
    int i;
    int j;
    label167:
    do
    {
      for (;;)
      {
        return;
        if (this.aMz == null) {
          this.aMw.R(paramLong1);
        }
        try
        {
          this.aMz = ((i)this.aMw.lC());
          if (this.state == 2)
          {
            if (this.aMy != null)
            {
              paramLong2 = no();
              for (i = 0; paramLong2 <= paramLong1; i = 1)
              {
                this.aMA += 1;
                paramLong2 = no();
              }
            }
            i = 0;
          }
        }
        catch (f localf1)
        {
          throw com.google.android.exoplayer2.e.a(localf1, this.index);
        }
      }
      j = i;
      if (this.aMz != null)
      {
        if (!this.aMz.lz()) {
          break label297;
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (no() == 9223372036854775807L)
          {
            if (this.aMu != 2) {
              break;
            }
            nn();
            j = i;
          }
        }
      }
      if (j != 0) {
        t(this.aMy.T(paramLong1));
      }
    } while (this.aMu == 2);
    label297:
    label358:
    do
    {
      try
      {
        if (this.aGq) {
          break;
        }
        if (this.aMx == null)
        {
          this.aMx = ((h)this.aMw.lB());
          if (this.aMx == null) {
            break;
          }
        }
        if (this.aMu != 1) {
          break label358;
        }
        this.aMx.flags = 4;
        this.aMw.P(this.aMx);
        this.aMx = null;
        this.aMu = 2;
        return;
      }
      catch (f localf2)
      {
        throw com.google.android.exoplayer2.e.a(localf2, this.index);
      }
      nl();
      this.aGr = true;
      j = i;
      break label167;
      j = i;
      if (this.aMz.ayE > paramLong1) {
        break label167;
      }
      if (this.aMy != null) {
        this.aMy.release();
      }
      this.aMy = this.aMz;
      this.aMz = null;
      this.aMA = this.aMy.S(paramLong1);
      j = 1;
      break label167;
      i = a(this.aFR, this.aMx, false);
      if (i == -4)
      {
        if (this.aMx.lz()) {
          this.aGq = true;
        }
        for (;;)
        {
          this.aMw.P(this.aMx);
          this.aMx = null;
          break;
          this.aMx.auG = this.aFR.auL.auG;
          this.aMx.lF();
        }
      }
    } while (i != -3);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new IllegalStateException();
    }
    u((List)paramMessage.obj);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final boolean kU()
  {
    return this.aGr;
  }
  
  protected final void kz()
  {
    this.aMv = null;
    t(Collections.emptyList());
    nm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.f.j
 * JD-Core Version:    0.7.0.1
 */