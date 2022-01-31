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
  private final k aMM;
  private final Handler aNH;
  private boolean aNl;
  private boolean aNm;
  private final j.a aTM;
  private final g aTN;
  private int aTO;
  private Format aTP;
  private e aTQ;
  private h aTR;
  private i aTS;
  private i aTT;
  private int aTU;
  
  public j(j.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.aTK);
  }
  
  private j(j.a parama, Looper paramLooper, g paramg)
  {
    super(3);
    AppMethodBeat.i(95657);
    this.aTM = ((j.a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    if (paramLooper == null) {}
    for (parama = null;; parama = new Handler(paramLooper, this))
    {
      this.aNH = parama;
      this.aTN = paramg;
      this.aMM = new k();
      AppMethodBeat.o(95657);
      return;
    }
  }
  
  private void pI()
  {
    AppMethodBeat.i(95663);
    this.aTR = null;
    this.aTU = -1;
    if (this.aTS != null)
    {
      this.aTS.release();
      this.aTS = null;
    }
    if (this.aTT != null)
    {
      this.aTT.release();
      this.aTT = null;
    }
    AppMethodBeat.o(95663);
  }
  
  private void pJ()
  {
    AppMethodBeat.i(95664);
    pI();
    this.aTQ.release();
    this.aTQ = null;
    this.aTO = 0;
    AppMethodBeat.o(95664);
  }
  
  private void pK()
  {
    AppMethodBeat.i(95665);
    pJ();
    this.aTQ = this.aTN.k(this.aTP);
    AppMethodBeat.o(95665);
  }
  
  private long pL()
  {
    AppMethodBeat.i(95666);
    if ((this.aTU == -1) || (this.aTU >= this.aTS.pH()))
    {
      AppMethodBeat.o(95666);
      return 9223372036854775807L;
    }
    long l = this.aTS.dT(this.aTU);
    AppMethodBeat.o(95666);
    return l;
  }
  
  private void v(List<a> paramList)
  {
    AppMethodBeat.i(95667);
    if (this.aNH != null)
    {
      this.aNH.obtainMessage(0, paramList).sendToTarget();
      AppMethodBeat.o(95667);
      return;
    }
    w(paramList);
    AppMethodBeat.o(95667);
  }
  
  private void w(List<a> paramList)
  {
    AppMethodBeat.i(95669);
    this.aTM.r(paramList);
    AppMethodBeat.o(95669);
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(95659);
    this.aTP = paramArrayOfFormat[0];
    if (this.aTQ != null)
    {
      this.aTO = 1;
      AppMethodBeat.o(95659);
      return;
    }
    this.aTQ = this.aTN.k(this.aTP);
    AppMethodBeat.o(95659);
  }
  
  public final int b(Format paramFormat)
  {
    AppMethodBeat.i(95658);
    if (this.aTN.g(paramFormat))
    {
      AppMethodBeat.o(95658);
      return 4;
    }
    if (com.google.android.exoplayer2.i.j.aI(paramFormat.awK))
    {
      AppMethodBeat.o(95658);
      return 1;
    }
    AppMethodBeat.o(95658);
    return 0;
  }
  
  public final void b(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95660);
    v(Collections.emptyList());
    this.aNl = false;
    this.aNm = false;
    if (this.aTO != 0)
    {
      pK();
      AppMethodBeat.o(95660);
      return;
    }
    pI();
    this.aTQ.flush();
    AppMethodBeat.o(95660);
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95661);
    if (this.aNm)
    {
      AppMethodBeat.o(95661);
      return;
    }
    if (this.aTT == null) {
      this.aTQ.aa(paramLong1);
    }
    Object localObject;
    try
    {
      this.aTT = ((i)this.aTQ.nH());
      if (this.state != 2)
      {
        AppMethodBeat.o(95661);
        return;
      }
    }
    catch (f localf1)
    {
      localObject = com.google.android.exoplayer2.e.b(localf1, this.index);
      AppMethodBeat.o(95661);
      throw ((Throwable)localObject);
    }
    if (this.aTS != null)
    {
      paramLong2 = pL();
      for (i = 0; paramLong2 <= paramLong1; i = 1)
      {
        this.aTU += 1;
        paramLong2 = pL();
      }
    }
    int i = 0;
    int j = i;
    if (this.aTT != null)
    {
      if (!this.aTT.nE()) {
        break label239;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (pL() == 9223372036854775807L)
        {
          if (this.aTO != 2) {
            break label223;
          }
          pK();
          j = i;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        v(this.aTS.ac(paramLong1));
      }
      if (this.aTO != 2) {
        break;
      }
      AppMethodBeat.o(95661);
      return;
      label223:
      pI();
      this.aNm = true;
      j = i;
      continue;
      label239:
      j = i;
      if (this.aTT.aAT <= paramLong1)
      {
        if (this.aTS != null) {
          this.aTS.release();
        }
        this.aTS = this.aTT;
        this.aTT = null;
        this.aTU = this.aTS.ab(paramLong1);
        j = 1;
      }
    }
    try
    {
      i = a(this.aMM, this.aTR, false);
      if (i == -4) {
        if (this.aTR.nE())
        {
          this.aNl = true;
          this.aTQ.P(this.aTR);
          this.aTR = null;
        }
      }
      com.google.android.exoplayer2.e locale;
      while (i != -3) {
        for (;;)
        {
          if (this.aNl) {
            break label508;
          }
          if (this.aTR == null)
          {
            this.aTR = ((h)this.aTQ.nG());
            localObject = this.aTR;
            if (localObject == null)
            {
              AppMethodBeat.o(95661);
              return;
            }
          }
          if (this.aTO != 1) {
            break;
          }
          this.aTR.flags = 4;
          this.aTQ.P(this.aTR);
          this.aTR = null;
          this.aTO = 2;
          AppMethodBeat.o(95661);
          return;
          this.aTR.awY = this.aMM.axd.awY;
          this.aTR.nJ();
        }
      }
    }
    catch (f localf2)
    {
      locale = com.google.android.exoplayer2.e.b(localf2, this.index);
      AppMethodBeat.o(95661);
      throw locale;
    }
    AppMethodBeat.o(95661);
    return;
    label508:
    AppMethodBeat.o(95661);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(95668);
    switch (paramMessage.what)
    {
    default: 
      paramMessage = new IllegalStateException();
      AppMethodBeat.o(95668);
      throw paramMessage;
    }
    w((List)paramMessage.obj);
    AppMethodBeat.o(95668);
    return true;
  }
  
  public final boolean isReady()
  {
    return true;
  }
  
  public final void mF()
  {
    AppMethodBeat.i(95662);
    this.aTP = null;
    v(Collections.emptyList());
    pJ();
    AppMethodBeat.o(95662);
  }
  
  public final boolean nd()
  {
    return this.aNm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.f.j
 * JD-Core Version:    0.7.0.1
 */