package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.ArrayList;
import java.util.Collections;

public final class h
  implements b
{
  private static long bFa;
  private static int lrs;
  private static long lrt;
  private int bEV;
  private final Handler eventHandler;
  private final b.a lro;
  private final c lrp;
  private final p lrq;
  private long lrr;
  private long startTimeMs;
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    this(new q());
    AppMethodBeat.i(211057);
    AppMethodBeat.o(211057);
  }
  
  private h(c paramc)
  {
    this(paramc, (byte)0);
  }
  
  private h(c paramc, byte paramByte)
  {
    AppMethodBeat.i(211058);
    this.eventHandler = null;
    this.lro = null;
    this.lrp = paramc;
    this.lrq = new p();
    bFa = -1L;
    AppMethodBeat.o(211058);
  }
  
  public final void onTransferEnd()
  {
    long l2;
    Object localObject4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(211060);
        if (this.bEV > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.lrp.elapsedRealtime();
          i = (int)(l2 - this.startTimeMs);
          lrs = i;
          if (i <= 0) {
            break label527;
          }
          f = (float)(this.lrr * 8000L / lrs);
          localObject4 = this.lrq;
          i = (int)Math.sqrt(this.lrr);
          if (((p)localObject4).bHi != 1)
          {
            Collections.sort(((p)localObject4).bHg, p.bHd);
            ((p)localObject4).bHi = 1;
          }
          if (((p)localObject4).bHl <= 0) {
            break label323;
          }
          Object localObject1 = ((p)localObject4).lrJ;
          j = ((p)localObject4).bHl - 1;
          ((p)localObject4).bHl = j;
          localObject1 = localObject1[j];
          j = ((p)localObject4).bHj;
          ((p)localObject4).bHj = (j + 1);
          ((p.a)localObject1).index = j;
          ((p.a)localObject1).weight = i;
          ((p.a)localObject1).value = f;
          ((p)localObject4).bHg.add(localObject1);
          ((p)localObject4).bHk += i;
          if (((p)localObject4).bHk <= ((p)localObject4).bHf) {
            break;
          }
          i = ((p)localObject4).bHk - ((p)localObject4).bHf;
          localObject1 = (p.a)((p)localObject4).bHg.get(0);
          if (((p.a)localObject1).weight > i) {
            break label336;
          }
          ((p)localObject4).bHk -= ((p.a)localObject1).weight;
          ((p)localObject4).bHg.remove(0);
          if (((p)localObject4).bHl >= 5) {
            continue;
          }
          p.a[] arrayOfa = ((p)localObject4).lrJ;
          i = ((p)localObject4).bHl;
          ((p)localObject4).bHl = (i + 1);
          arrayOfa[i] = localObject1;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label323:
      localObject3 = new p.a((byte)0);
      continue;
      label336:
      ((p.a)localObject3).weight -= i;
      ((p)localObject4).bHk -= i;
    }
    Object localObject3 = this.lrq;
    if (((p)localObject3).bHi != 0)
    {
      Collections.sort(((p)localObject3).bHg, p.bHe);
      ((p)localObject3).bHi = 0;
    }
    float f = ((p)localObject3).bHk;
    final int i = 0;
    int j = 0;
    if (i < ((p)localObject3).bHg.size())
    {
      localObject4 = (p.a)((p)localObject3).bHg.get(i);
      j = ((p.a)localObject4).weight + j;
      if (j >= 0.5F * f)
      {
        f = ((p.a)localObject4).value;
        label455:
        if (!Float.isNaN(f)) {
          break label615;
        }
      }
    }
    label527:
    label615:
    for (final long l1 = -1L;; l1 = f)
    {
      bFa = l1;
      lrt = l1;
      i = lrs;
      l1 = this.lrr;
      long l3 = bFa;
      if ((this.eventHandler != null) && (this.lro != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      this.bEV -= 1;
      if (this.bEV > 0) {
        this.startTimeMs = l2;
      }
      this.lrr = 0L;
      AppMethodBeat.o(211060);
      return;
      i += 1;
      break;
      if (((p)localObject3).bHg.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label455;
      }
      f = ((p.a)((p)localObject3).bHg.get(((p)localObject3).bHg.size() - 1)).value;
      break label455;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      AppMethodBeat.i(211059);
      if (this.bEV == 0) {
        this.startTimeMs = this.lrp.elapsedRealtime();
      }
      this.bEV += 1;
      AppMethodBeat.o(211059);
      return;
    }
    finally {}
  }
  
  public final void tz(int paramInt)
  {
    try
    {
      this.lrr += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.h
 * JD-Core Version:    0.7.0.1
 */