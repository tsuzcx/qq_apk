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
  private final k bcI;
  private final Handler bdE;
  private boolean bdi;
  private boolean bdj;
  private final a bjN;
  private final g bjO;
  private int bjP;
  private Format bjQ;
  private e bjR;
  private h bjS;
  private i bjT;
  private i bjU;
  private int bjV;
  
  public j(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.bjL);
  }
  
  private j(a parama, Looper paramLooper, g paramg)
  {
    super(3);
    AppMethodBeat.i(92825);
    this.bjN = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bdE = parama;
      this.bjO = paramg;
      this.bcI = new k();
      AppMethodBeat.o(92825);
      return;
    }
  }
  
  private void r(List<a> paramList)
  {
    AppMethodBeat.i(92835);
    if (this.bdE != null)
    {
      this.bdE.obtainMessage(0, paramList).sendToTarget();
      AppMethodBeat.o(92835);
      return;
    }
    s(paramList);
    AppMethodBeat.o(92835);
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(92832);
    ub();
    this.bjR.release();
    this.bjR = null;
    this.bjP = 0;
    AppMethodBeat.o(92832);
  }
  
  private void s(List<a> paramList)
  {
    AppMethodBeat.i(92837);
    this.bjN.n(paramList);
    AppMethodBeat.o(92837);
  }
  
  private void ub()
  {
    AppMethodBeat.i(92831);
    this.bjS = null;
    this.bjV = -1;
    if (this.bjT != null)
    {
      this.bjT.release();
      this.bjT = null;
    }
    if (this.bjU != null)
    {
      this.bjU.release();
      this.bjU = null;
    }
    AppMethodBeat.o(92831);
  }
  
  private void uc()
  {
    AppMethodBeat.i(92833);
    releaseDecoder();
    this.bjR = this.bjO.k(this.bjQ);
    AppMethodBeat.o(92833);
  }
  
  private long ud()
  {
    AppMethodBeat.i(92834);
    if ((this.bjV == -1) || (this.bjV >= this.bjT.ua()))
    {
      AppMethodBeat.o(92834);
      return 9223372036854775807L;
    }
    long l = this.bjT.eX(this.bjV);
    AppMethodBeat.o(92834);
    return l;
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92828);
    r(Collections.emptyList());
    this.bdi = false;
    this.bdj = false;
    if (this.bjP != 0)
    {
      uc();
      AppMethodBeat.o(92828);
      return;
    }
    ub();
    this.bjR.flush();
    AppMethodBeat.o(92828);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92827);
    this.bjQ = paramArrayOfFormat[0];
    if (this.bjR != null)
    {
      this.bjP = 1;
      AppMethodBeat.o(92827);
      return;
    }
    this.bjR = this.bjO.k(this.bjQ);
    AppMethodBeat.o(92827);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92826);
    if (this.bjO.g(paramFormat))
    {
      AppMethodBeat.o(92826);
      return 4;
    }
    if (com.google.android.exoplayer2.i.j.bK(paramFormat.aMQ))
    {
      AppMethodBeat.o(92826);
      return 1;
    }
    AppMethodBeat.o(92826);
    return 0;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92829);
    if (this.bdj)
    {
      AppMethodBeat.o(92829);
      return;
    }
    if (this.bjU == null) {
      this.bjR.ak(paramLong1);
    }
    Object localObject;
    try
    {
      this.bjU = ((i)this.bjR.rY());
      if (getState() != 2)
      {
        AppMethodBeat.o(92829);
        return;
      }
    }
    catch (f localf1)
    {
      localObject = com.google.android.exoplayer2.e.b(localf1, getIndex());
      AppMethodBeat.o(92829);
      throw ((Throwable)localObject);
    }
    if (this.bjT != null)
    {
      paramLong2 = ud();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.bjV += 1;
        paramLong2 = ud();
      }
    }
    int i = 0;
    int j = i;
    if (this.bjU != null)
    {
      if (!this.bjU.rV()) {
        break label239;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (ud() == 9223372036854775807L)
        {
          if (this.bjP != 2) {
            break label223;
          }
          uc();
          j = i;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        r(this.bjT.am(paramLong1));
      }
      if (this.bjP != 2) {
        break;
      }
      AppMethodBeat.o(92829);
      return;
      label223:
      ub();
      this.bdj = true;
      j = i;
      continue;
      label239:
      j = i;
      if (this.bjU.timeUs <= paramLong1)
      {
        if (this.bjT != null) {
          this.bjT.release();
        }
        this.bjT = this.bjU;
        this.bjU = null;
        this.bjV = this.bjT.al(paramLong1);
        j = 1;
      }
    }
    try
    {
      i = a(this.bcI, this.bjS, false);
      if (i == -4) {
        if (this.bjS.rV())
        {
          this.bdi = true;
          this.bjR.X(this.bjS);
          this.bjS = null;
        }
      }
      com.google.android.exoplayer2.e locale;
      while (i != -3) {
        for (;;)
        {
          if (this.bdi) {
            break label508;
          }
          if (this.bjS == null)
          {
            this.bjS = ((h)this.bjR.rX());
            localObject = this.bjS;
            if (localObject == null)
            {
              AppMethodBeat.o(92829);
              return;
            }
          }
          if (this.bjP != 1) {
            break;
          }
          this.bjS.flags = 4;
          this.bjR.X(this.bjS);
          this.bjS = null;
          this.bjP = 2;
          AppMethodBeat.o(92829);
          return;
          this.bjS.aNc = this.bcI.aNg.aNc;
          this.bjS.sa();
        }
      }
    }
    catch (f localf2)
    {
      locale = com.google.android.exoplayer2.e.b(localf2, getIndex());
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
    s((List)paramMessage.obj);
    AppMethodBeat.o(92836);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final void qU()
  {
    AppMethodBeat.i(92830);
    this.bjQ = null;
    r(Collections.emptyList());
    releaseDecoder();
    AppMethodBeat.o(92830);
  }
  
  public final boolean rt()
  {
    return this.bdj;
  }
  
  public static abstract interface a
  {
    public abstract void n(List<a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.j
 * JD-Core Version:    0.7.0.1
 */