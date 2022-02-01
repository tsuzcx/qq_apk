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
  private final k cWD;
  private boolean cXc;
  private boolean cXd;
  private final Handler cXy;
  private final a ddH;
  private final g ddI;
  private int ddJ;
  private Format ddK;
  private e ddL;
  private h ddM;
  private i ddN;
  private i ddO;
  private int ddP;
  
  public j(a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.ddF);
  }
  
  private j(a parama, Looper paramLooper, g paramg)
  {
    super(3);
    AppMethodBeat.i(92825);
    this.ddH = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.cXy = parama;
      this.ddI = paramg;
      this.cWD = new k();
      AppMethodBeat.o(92825);
      return;
    }
  }
  
  private void TE()
  {
    AppMethodBeat.i(92831);
    this.ddM = null;
    this.ddP = -1;
    if (this.ddN != null)
    {
      this.ddN.release();
      this.ddN = null;
    }
    if (this.ddO != null)
    {
      this.ddO.release();
      this.ddO = null;
    }
    AppMethodBeat.o(92831);
  }
  
  private void TF()
  {
    AppMethodBeat.i(92833);
    releaseDecoder();
    this.ddL = this.ddI.k(this.ddK);
    AppMethodBeat.o(92833);
  }
  
  private long TG()
  {
    AppMethodBeat.i(92834);
    if ((this.ddP == -1) || (this.ddP >= this.ddN.TD()))
    {
      AppMethodBeat.o(92834);
      return 9223372036854775807L;
    }
    long l = this.ddN.in(this.ddP);
    AppMethodBeat.o(92834);
    return l;
  }
  
  private void ak(List<a> paramList)
  {
    AppMethodBeat.i(92835);
    if (this.cXy != null)
    {
      this.cXy.obtainMessage(0, paramList).sendToTarget();
      AppMethodBeat.o(92835);
      return;
    }
    al(paramList);
    AppMethodBeat.o(92835);
  }
  
  private void al(List<a> paramList)
  {
    AppMethodBeat.i(92837);
    this.ddH.ag(paramList);
    AppMethodBeat.o(92837);
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(92832);
    TE();
    this.ddL.release();
    this.ddL = null;
    this.ddJ = 0;
    AppMethodBeat.o(92832);
  }
  
  public final void B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92829);
    if (this.cXd)
    {
      AppMethodBeat.o(92829);
      return;
    }
    if (this.ddO == null) {
      this.ddL.cy(paramLong1);
    }
    Object localObject;
    try
    {
      this.ddO = ((i)this.ddL.RB());
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
    if (this.ddN != null)
    {
      paramLong2 = TG();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.ddP += 1;
        paramLong2 = TG();
      }
    }
    int i = 0;
    int j = i;
    if (this.ddO != null)
    {
      if (!this.ddO.Ry()) {
        break label239;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (TG() == 9223372036854775807L)
        {
          if (this.ddJ != 2) {
            break label223;
          }
          TF();
          j = i;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        ak(this.ddN.cA(paramLong1));
      }
      if (this.ddJ != 2) {
        break;
      }
      AppMethodBeat.o(92829);
      return;
      label223:
      TE();
      this.cXd = true;
      j = i;
      continue;
      label239:
      j = i;
      if (this.ddO.timeUs <= paramLong1)
      {
        if (this.ddN != null) {
          this.ddN.release();
        }
        this.ddN = this.ddO;
        this.ddO = null;
        this.ddP = this.ddN.cz(paramLong1);
        j = 1;
      }
    }
    try
    {
      i = a(this.cWD, this.ddM, false);
      if (i == -4) {
        if (this.ddM.Ry())
        {
          this.cXc = true;
          this.ddL.bg(this.ddM);
          this.ddM = null;
        }
      }
      com.google.android.exoplayer2.e locale;
      while (i != -3) {
        for (;;)
        {
          if (this.cXc) {
            break label508;
          }
          if (this.ddM == null)
          {
            this.ddM = ((h)this.ddL.RA());
            localObject = this.ddM;
            if (localObject == null)
            {
              AppMethodBeat.o(92829);
              return;
            }
          }
          if (this.ddJ != 1) {
            break;
          }
          this.ddM.flags = 4;
          this.ddL.bg(this.ddM);
          this.ddM = null;
          this.ddJ = 2;
          AppMethodBeat.o(92829);
          return;
          this.ddM.cGY = this.cWD.cHc.cGY;
          this.ddM.RD();
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
  
  public final boolean QU()
  {
    return this.cXd;
  }
  
  public final void Qw()
  {
    AppMethodBeat.i(92830);
    this.ddK = null;
    ak(Collections.emptyList());
    releaseDecoder();
    AppMethodBeat.o(92830);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(92827);
    this.ddK = paramArrayOfFormat[0];
    if (this.ddL != null)
    {
      this.ddJ = 1;
      AppMethodBeat.o(92827);
      return;
    }
    this.ddL = this.ddI.k(this.ddK);
    AppMethodBeat.o(92827);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(92826);
    if (this.ddI.g(paramFormat))
    {
      AppMethodBeat.o(92826);
      return 4;
    }
    if (com.google.android.exoplayer2.i.j.dg(paramFormat.cGN))
    {
      AppMethodBeat.o(92826);
      return 1;
    }
    AppMethodBeat.o(92826);
    return 0;
  }
  
  public final void f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92828);
    ak(Collections.emptyList());
    this.cXc = false;
    this.cXd = false;
    if (this.ddJ != 0)
    {
      TF();
      AppMethodBeat.o(92828);
      return;
    }
    TE();
    this.ddL.flush();
    AppMethodBeat.o(92828);
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
    al((List)paramMessage.obj);
    AppMethodBeat.o(92836);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void ag(List<a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.j
 * JD-Core Version:    0.7.0.1
 */