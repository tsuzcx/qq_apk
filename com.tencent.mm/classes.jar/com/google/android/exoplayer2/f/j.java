package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class j
  extends com.google.android.exoplayer2.a
  implements Handler.Callback
{
  private final a bAj;
  private final g bAk;
  private int bAl;
  private Format bAm;
  private e bAn;
  private h bAo;
  private i bAp;
  private i bAq;
  private int bAr;
  private boolean btK;
  private boolean btL;
  private final k btk;
  private final Handler buh;
  
  public j(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.bAh);
  }
  
  private j(a parama, Looper paramLooper, g paramg)
  {
    super(3);
    AppMethodBeat.i(92825);
    this.bAj = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.buh = parama;
      this.bAk = paramg;
      this.btk = new k();
      AppMethodBeat.o(92825);
      return;
    }
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(92832);
    vW();
    this.bAn.release();
    this.bAn = null;
    this.bAl = 0;
    AppMethodBeat.o(92832);
  }
  
  private void vW()
  {
    AppMethodBeat.i(92831);
    this.bAo = null;
    this.bAr = -1;
    if (this.bAp != null)
    {
      this.bAp.release();
      this.bAp = null;
    }
    if (this.bAq != null)
    {
      this.bAq.release();
      this.bAq = null;
    }
    AppMethodBeat.o(92831);
  }
  
  private void vX()
  {
    AppMethodBeat.i(92833);
    releaseDecoder();
    this.bAn = this.bAk.k(this.bAm);
    AppMethodBeat.o(92833);
  }
  
  private long vY()
  {
    AppMethodBeat.i(92834);
    if ((this.bAr == -1) || (this.bAr >= this.bAp.vV()))
    {
      AppMethodBeat.o(92834);
      return 9223372036854775807L;
    }
    long l = this.bAp.eI(this.bAr);
    AppMethodBeat.o(92834);
    return l;
  }
  
  private void w(List<a> paramList)
  {
    AppMethodBeat.i(92835);
    if (this.buh != null)
    {
      this.buh.obtainMessage(0, paramList).sendToTarget();
      AppMethodBeat.o(92835);
      return;
    }
    x(paramList);
    AppMethodBeat.o(92835);
  }
  
  private void x(List<a> paramList)
  {
    AppMethodBeat.i(92837);
    this.bAj.s(paramList);
    AppMethodBeat.o(92837);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92828);
    w(Collections.emptyList());
    this.btK = false;
    this.btL = false;
    if (this.bAl != 0)
    {
      vX();
      AppMethodBeat.o(92828);
      return;
    }
    vW();
    this.bAn.flush();
    AppMethodBeat.o(92828);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92827);
    this.bAm = paramArrayOfFormat[0];
    if (this.bAn != null)
    {
      this.bAl = 1;
      AppMethodBeat.o(92827);
      return;
    }
    this.bAn = this.bAk.k(this.bAm);
    AppMethodBeat.o(92827);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92826);
    if (this.bAk.g(paramFormat))
    {
      AppMethodBeat.o(92826);
      return 4;
    }
    if (com.google.android.exoplayer2.i.j.bz(paramFormat.bdt))
    {
      AppMethodBeat.o(92826);
      return 1;
    }
    AppMethodBeat.o(92826);
    return 0;
  }
  
  public final void e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92829);
    if (this.btL)
    {
      AppMethodBeat.o(92829);
      return;
    }
    if (this.bAq == null) {
      this.bAn.ah(paramLong1);
    }
    Object localObject;
    try
    {
      this.bAq = ((i)this.bAn.ub());
      if (this.state != 2)
      {
        AppMethodBeat.o(92829);
        return;
      }
    }
    catch (f localf1)
    {
      localObject = com.google.android.exoplayer2.e.b(localf1, this.index);
      AppMethodBeat.o(92829);
      throw ((Throwable)localObject);
    }
    if (this.bAp != null)
    {
      paramLong2 = vY();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.bAr += 1;
        paramLong2 = vY();
      }
    }
    int i = 0;
    int j = i;
    if (this.bAq != null)
    {
      if (!this.bAq.tY()) {
        break label239;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (vY() == 9223372036854775807L)
        {
          if (this.bAl != 2) {
            break label223;
          }
          vX();
          j = i;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        w(this.bAp.aj(paramLong1));
      }
      if (this.bAl != 2) {
        break;
      }
      AppMethodBeat.o(92829);
      return;
      label223:
      vW();
      this.btL = true;
      j = i;
      continue;
      label239:
      j = i;
      if (this.bAq.timeUs <= paramLong1)
      {
        if (this.bAp != null) {
          this.bAp.release();
        }
        this.bAp = this.bAq;
        this.bAq = null;
        this.bAr = this.bAp.ai(paramLong1);
        j = 1;
      }
    }
    try
    {
      i = a(this.btk, this.bAo, false);
      if (i == -4) {
        if (this.bAo.tY())
        {
          this.btK = true;
          this.bAn.af(this.bAo);
          this.bAo = null;
        }
      }
      com.google.android.exoplayer2.e locale;
      while (i != -3) {
        for (;;)
        {
          if (this.btK) {
            break label508;
          }
          if (this.bAo == null)
          {
            this.bAo = ((h)this.bAn.ua());
            localObject = this.bAo;
            if (localObject == null)
            {
              AppMethodBeat.o(92829);
              return;
            }
          }
          if (this.bAl != 1) {
            break;
          }
          this.bAo.flags = 4;
          this.bAn.af(this.bAo);
          this.bAo = null;
          this.bAl = 2;
          AppMethodBeat.o(92829);
          return;
          this.bAo.bdF = this.btk.bdI.bdF;
          this.bAo.ud();
        }
      }
    }
    catch (f localf2)
    {
      locale = com.google.android.exoplayer2.e.b(localf2, this.index);
      AppMethodBeat.o(92829);
      throw locale;
    }
    AppMethodBeat.o(92829);
    return;
    label508:
    AppMethodBeat.o(92829);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(92836);
    switch (paramMessage.what)
    {
    default: 
      paramMessage = new IllegalStateException();
      AppMethodBeat.o(92836);
      throw paramMessage;
    }
    x((List)paramMessage.obj);
    AppMethodBeat.o(92836);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final void sZ()
  {
    AppMethodBeat.i(92830);
    this.bAm = null;
    w(Collections.emptyList());
    releaseDecoder();
    AppMethodBeat.o(92830);
  }
  
  public final boolean tw()
  {
    return this.btL;
  }
  
  public static abstract interface a
  {
    public abstract void s(List<a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.j
 * JD-Core Version:    0.7.0.1
 */