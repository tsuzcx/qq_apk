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
  private boolean biL;
  private boolean biM;
  private final k bil;
  private final Handler bjh;
  private final a brP;
  private final g brQ;
  private int brR;
  private Format brS;
  private e brT;
  private h brU;
  private i brV;
  private i brW;
  private int brX;
  
  public j(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.brN);
  }
  
  private j(a parama, Looper paramLooper, g paramg)
  {
    super(3);
    AppMethodBeat.i(92825);
    this.brP = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.bjh = parama;
      this.brQ = paramg;
      this.bil = new k();
      AppMethodBeat.o(92825);
      return;
    }
  }
  
  private void B(List<a> paramList)
  {
    AppMethodBeat.i(92835);
    if (this.bjh != null)
    {
      this.bjh.obtainMessage(0, paramList).sendToTarget();
      AppMethodBeat.o(92835);
      return;
    }
    C(paramList);
    AppMethodBeat.o(92835);
  }
  
  private void C(List<a> paramList)
  {
    AppMethodBeat.i(92837);
    this.brP.t(paramList);
    AppMethodBeat.o(92837);
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(92832);
    uC();
    this.brT.release();
    this.brT = null;
    this.brR = 0;
    AppMethodBeat.o(92832);
  }
  
  private void uC()
  {
    AppMethodBeat.i(92831);
    this.brU = null;
    this.brX = -1;
    if (this.brV != null)
    {
      this.brV.release();
      this.brV = null;
    }
    if (this.brW != null)
    {
      this.brW.release();
      this.brW = null;
    }
    AppMethodBeat.o(92831);
  }
  
  private void uE()
  {
    AppMethodBeat.i(92833);
    releaseDecoder();
    this.brT = this.brQ.k(this.brS);
    AppMethodBeat.o(92833);
  }
  
  private long uF()
  {
    AppMethodBeat.i(92834);
    if ((this.brX == -1) || (this.brX >= this.brV.uB()))
    {
      AppMethodBeat.o(92834);
      return 9223372036854775807L;
    }
    long l = this.brV.eR(this.brX);
    AppMethodBeat.o(92834);
    return l;
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92828);
    B(Collections.emptyList());
    this.biL = false;
    this.biM = false;
    if (this.brR != 0)
    {
      uE();
      AppMethodBeat.o(92828);
      return;
    }
    uC();
    this.brT.flush();
    AppMethodBeat.o(92828);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92827);
    this.brS = paramArrayOfFormat[0];
    if (this.brT != null)
    {
      this.brR = 1;
      AppMethodBeat.o(92827);
      return;
    }
    this.brT = this.brQ.k(this.brS);
    AppMethodBeat.o(92827);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92826);
    if (this.brQ.g(paramFormat))
    {
      AppMethodBeat.o(92826);
      return 4;
    }
    if (com.google.android.exoplayer2.i.j.aL(paramFormat.aSd))
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
    if (this.biM)
    {
      AppMethodBeat.o(92829);
      return;
    }
    if (this.brW == null) {
      this.brT.al(paramLong1);
    }
    Object localObject;
    try
    {
      this.brW = ((i)this.brT.st());
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
    if (this.brV != null)
    {
      paramLong2 = uF();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.brX += 1;
        paramLong2 = uF();
      }
    }
    int i = 0;
    int j = i;
    if (this.brW != null)
    {
      if (!this.brW.sq()) {
        break label239;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (uF() == 9223372036854775807L)
        {
          if (this.brR != 2) {
            break label223;
          }
          uE();
          j = i;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        B(this.brV.an(paramLong1));
      }
      if (this.brR != 2) {
        break;
      }
      AppMethodBeat.o(92829);
      return;
      label223:
      uC();
      this.biM = true;
      j = i;
      continue;
      label239:
      j = i;
      if (this.brW.timeUs <= paramLong1)
      {
        if (this.brV != null) {
          this.brV.release();
        }
        this.brV = this.brW;
        this.brW = null;
        this.brX = this.brV.am(paramLong1);
        j = 1;
      }
    }
    try
    {
      i = a(this.bil, this.brU, false);
      if (i == -4) {
        if (this.brU.sq())
        {
          this.biL = true;
          this.brT.ab(this.brU);
          this.brU = null;
        }
      }
      com.google.android.exoplayer2.e locale;
      while (i != -3) {
        for (;;)
        {
          if (this.biL) {
            break label508;
          }
          if (this.brU == null)
          {
            this.brU = ((h)this.brT.ss());
            localObject = this.brU;
            if (localObject == null)
            {
              AppMethodBeat.o(92829);
              return;
            }
          }
          if (this.brR != 1) {
            break;
          }
          this.brU.flags = 4;
          this.brT.ab(this.brU);
          this.brU = null;
          this.brR = 2;
          AppMethodBeat.o(92829);
          return;
          this.brU.aSr = this.bil.aSv.aSr;
          this.brU.sv();
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
    C((List)paramMessage.obj);
    AppMethodBeat.o(92836);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final boolean rM()
  {
    return this.biM;
  }
  
  public final void rp()
  {
    AppMethodBeat.i(92830);
    this.brS = null;
    B(Collections.emptyList());
    releaseDecoder();
    AppMethodBeat.o(92830);
  }
  
  public static abstract interface a
  {
    public abstract void t(List<a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.j
 * JD-Core Version:    0.7.0.1
 */