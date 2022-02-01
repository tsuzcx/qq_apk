package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.ArrayList;
import java.util.Collections;

public final class h
  implements b
{
  private static long bwP;
  private static int koZ;
  private static long kpa;
  private int bwK;
  private long bxw;
  private final Handler eventHandler;
  private final b.a koV;
  private final c koW;
  private final p koX;
  private long koY;
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    this(new q());
    AppMethodBeat.i(193871);
    AppMethodBeat.o(193871);
  }
  
  private h(c paramc)
  {
    this(paramc, (byte)0);
  }
  
  private h(c paramc, byte paramByte)
  {
    AppMethodBeat.i(193872);
    this.eventHandler = null;
    this.koV = null;
    this.koW = paramc;
    this.koX = new p();
    bwP = -1L;
    AppMethodBeat.o(193872);
  }
  
  public final void onTransferEnd()
  {
    long l2;
    Object localObject4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193874);
        if (this.bwK > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.koW.elapsedRealtime();
          i = (int)(l2 - this.bxw);
          koZ = i;
          if (i <= 0) {
            break label527;
          }
          f = (float)(this.koY * 8000L / koZ);
          localObject4 = this.koX;
          i = (int)Math.sqrt(this.koY);
          if (((p)localObject4).bzm != 1)
          {
            Collections.sort(((p)localObject4).bzk, p.bzh);
            ((p)localObject4).bzm = 1;
          }
          if (((p)localObject4).bzp <= 0) {
            break label323;
          }
          Object localObject1 = ((p)localObject4).kpq;
          j = ((p)localObject4).bzp - 1;
          ((p)localObject4).bzp = j;
          localObject1 = localObject1[j];
          j = ((p)localObject4).bzn;
          ((p)localObject4).bzn = (j + 1);
          ((p.a)localObject1).index = j;
          ((p.a)localObject1).weight = i;
          ((p.a)localObject1).value = f;
          ((p)localObject4).bzk.add(localObject1);
          ((p)localObject4).bzo += i;
          if (((p)localObject4).bzo <= ((p)localObject4).bzj) {
            break;
          }
          i = ((p)localObject4).bzo - ((p)localObject4).bzj;
          localObject1 = (p.a)((p)localObject4).bzk.get(0);
          if (((p.a)localObject1).weight > i) {
            break label336;
          }
          ((p)localObject4).bzo -= ((p.a)localObject1).weight;
          ((p)localObject4).bzk.remove(0);
          if (((p)localObject4).bzp >= 5) {
            continue;
          }
          p.a[] arrayOfa = ((p)localObject4).kpq;
          i = ((p)localObject4).bzp;
          ((p)localObject4).bzp = (i + 1);
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
      ((p)localObject4).bzo -= i;
    }
    Object localObject3 = this.koX;
    if (((p)localObject3).bzm != 0)
    {
      Collections.sort(((p)localObject3).bzk, p.bzi);
      ((p)localObject3).bzm = 0;
    }
    float f = ((p)localObject3).bzo;
    final int i = 0;
    int j = 0;
    if (i < ((p)localObject3).bzk.size())
    {
      localObject4 = (p.a)((p)localObject3).bzk.get(i);
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
      bwP = l1;
      kpa = l1;
      i = koZ;
      l1 = this.koY;
      long l3 = bwP;
      if ((this.eventHandler != null) && (this.koV != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      this.bwK -= 1;
      if (this.bwK > 0) {
        this.bxw = l2;
      }
      this.koY = 0L;
      AppMethodBeat.o(193874);
      return;
      i += 1;
      break;
      if (((p)localObject3).bzk.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label455;
      }
      f = ((p.a)((p)localObject3).bzk.get(((p)localObject3).bzk.size() - 1)).value;
      break label455;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      AppMethodBeat.i(193873);
      if (this.bwK == 0) {
        this.bxw = this.koW.elapsedRealtime();
      }
      this.bwK += 1;
      AppMethodBeat.o(193873);
      return;
    }
    finally {}
  }
  
  public final void sc(int paramInt)
  {
    try
    {
      this.koY += paramInt;
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