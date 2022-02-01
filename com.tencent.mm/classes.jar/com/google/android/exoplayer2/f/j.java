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
  private final k biQ;
  private final Handler bjM;
  private boolean bjq;
  private boolean bjr;
  private final a bpO;
  private final g bpP;
  private int bpQ;
  private Format bpR;
  private e bpS;
  private h bpT;
  private i bpU;
  private i bpV;
  private int bpW;
  
  public j(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.bpM);
  }
  
  private j(a parama, Looper paramLooper, g paramg)
  {
    super(3);
    AppMethodBeat.i(92825);
    this.bpO = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bjM = parama;
      this.bpP = paramg;
      this.biQ = new k();
      AppMethodBeat.o(92825);
      return;
    }
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(92832);
    ux();
    this.bpS.release();
    this.bpS = null;
    this.bpQ = 0;
    AppMethodBeat.o(92832);
  }
  
  private void ux()
  {
    AppMethodBeat.i(92831);
    this.bpT = null;
    this.bpW = -1;
    if (this.bpU != null)
    {
      this.bpU.release();
      this.bpU = null;
    }
    if (this.bpV != null)
    {
      this.bpV.release();
      this.bpV = null;
    }
    AppMethodBeat.o(92831);
  }
  
  private void uy()
  {
    AppMethodBeat.i(92833);
    releaseDecoder();
    this.bpS = this.bpP.k(this.bpR);
    AppMethodBeat.o(92833);
  }
  
  private long uz()
  {
    AppMethodBeat.i(92834);
    if ((this.bpW == -1) || (this.bpW >= this.bpU.uw()))
    {
      AppMethodBeat.o(92834);
      return 9223372036854775807L;
    }
    long l = this.bpU.eE(this.bpW);
    AppMethodBeat.o(92834);
    return l;
  }
  
  private void w(List<a> paramList)
  {
    AppMethodBeat.i(92835);
    if (this.bjM != null)
    {
      this.bjM.obtainMessage(0, paramList).sendToTarget();
      AppMethodBeat.o(92835);
      return;
    }
    x(paramList);
    AppMethodBeat.o(92835);
  }
  
  private void x(List<a> paramList)
  {
    AppMethodBeat.i(92837);
    this.bpO.s(paramList);
    AppMethodBeat.o(92837);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92828);
    w(Collections.emptyList());
    this.bjq = false;
    this.bjr = false;
    if (this.bpQ != 0)
    {
      uy();
      AppMethodBeat.o(92828);
      return;
    }
    ux();
    this.bpS.flush();
    AppMethodBeat.o(92828);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92827);
    this.bpR = paramArrayOfFormat[0];
    if (this.bpS != null)
    {
      this.bpQ = 1;
      AppMethodBeat.o(92827);
      return;
    }
    this.bpS = this.bpP.k(this.bpR);
    AppMethodBeat.o(92827);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92826);
    if (this.bpP.g(paramFormat))
    {
      AppMethodBeat.o(92826);
      return 4;
    }
    if (com.google.android.exoplayer2.i.j.aG(paramFormat.aSY))
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
    if (this.bjr)
    {
      AppMethodBeat.o(92829);
      return;
    }
    if (this.bpV == null) {
      this.bpS.ah(paramLong1);
    }
    Object localObject;
    try
    {
      this.bpV = ((i)this.bpS.sC());
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
    if (this.bpU != null)
    {
      paramLong2 = uz();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.bpW += 1;
        paramLong2 = uz();
      }
    }
    int i = 0;
    int j = i;
    if (this.bpV != null)
    {
      if (!this.bpV.sz()) {
        break label239;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (uz() == 9223372036854775807L)
        {
          if (this.bpQ != 2) {
            break label223;
          }
          uy();
          j = i;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        w(this.bpU.aj(paramLong1));
      }
      if (this.bpQ != 2) {
        break;
      }
      AppMethodBeat.o(92829);
      return;
      label223:
      ux();
      this.bjr = true;
      j = i;
      continue;
      label239:
      j = i;
      if (this.bpV.timeUs <= paramLong1)
      {
        if (this.bpU != null) {
          this.bpU.release();
        }
        this.bpU = this.bpV;
        this.bpV = null;
        this.bpW = this.bpU.ai(paramLong1);
        j = 1;
      }
    }
    try
    {
      i = a(this.biQ, this.bpT, false);
      if (i == -4) {
        if (this.bpT.sz())
        {
          this.bjq = true;
          this.bpS.ad(this.bpT);
          this.bpT = null;
        }
      }
      com.google.android.exoplayer2.e locale;
      while (i != -3) {
        for (;;)
        {
          if (this.bjq) {
            break label508;
          }
          if (this.bpT == null)
          {
            this.bpT = ((h)this.bpS.sB());
            localObject = this.bpT;
            if (localObject == null)
            {
              AppMethodBeat.o(92829);
              return;
            }
          }
          if (this.bpQ != 1) {
            break;
          }
          this.bpT.flags = 4;
          this.bpS.ad(this.bpT);
          this.bpT = null;
          this.bpQ = 2;
          AppMethodBeat.o(92829);
          return;
          this.bpT.aTk = this.biQ.aTo.aTk;
          this.bpT.sE();
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
  
  public final void rA()
  {
    AppMethodBeat.i(92830);
    this.bpR = null;
    w(Collections.emptyList());
    releaseDecoder();
    AppMethodBeat.o(92830);
  }
  
  public final boolean rX()
  {
    return this.bjr;
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