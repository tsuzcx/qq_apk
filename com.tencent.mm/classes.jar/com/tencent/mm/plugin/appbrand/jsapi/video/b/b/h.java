package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.ArrayList;
import java.util.Collections;

public final class h
  implements b
{
  private static long diy;
  private static int sBy;
  private static long sBz;
  private int dit;
  private final Handler eventHandler;
  final b.a sBu;
  private final c sBv;
  private final p sBw;
  private long sBx;
  private long startTimeMs;
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    this(new q());
    AppMethodBeat.i(328516);
    AppMethodBeat.o(328516);
  }
  
  private h(Handler paramHandler, b.a parama, c paramc)
  {
    AppMethodBeat.i(328532);
    this.eventHandler = null;
    this.sBu = null;
    this.sBv = paramc;
    this.sBw = new p();
    diy = -1L;
    AppMethodBeat.o(328532);
  }
  
  private h(c paramc)
  {
    this(null, null, paramc);
  }
  
  public final void Bj(int paramInt)
  {
    try
    {
      this.sBx += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onTransferEnd()
  {
    long l2;
    Object localObject4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(328562);
        if (this.dit > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.sBv.elapsedRealtime();
          i = (int)(l2 - this.startTimeMs);
          sBy = i;
          if (i <= 0) {
            break label527;
          }
          f = (float)(this.sBx * 8000L / sBy);
          localObject4 = this.sBw;
          i = (int)Math.sqrt(this.sBx);
          if (((p)localObject4).dkK != 1)
          {
            Collections.sort(((p)localObject4).dkI, p.dkF);
            ((p)localObject4).dkK = 1;
          }
          if (((p)localObject4).dkN <= 0) {
            break label323;
          }
          Object localObject1 = ((p)localObject4).sBP;
          j = ((p)localObject4).dkN - 1;
          ((p)localObject4).dkN = j;
          localObject1 = localObject1[j];
          j = ((p)localObject4).dkL;
          ((p)localObject4).dkL = (j + 1);
          ((p.a)localObject1).index = j;
          ((p.a)localObject1).weight = i;
          ((p.a)localObject1).value = f;
          ((p)localObject4).dkI.add(localObject1);
          ((p)localObject4).dkM += i;
          if (((p)localObject4).dkM <= ((p)localObject4).dkH) {
            break;
          }
          i = ((p)localObject4).dkM - ((p)localObject4).dkH;
          localObject1 = (p.a)((p)localObject4).dkI.get(0);
          if (((p.a)localObject1).weight > i) {
            break label336;
          }
          ((p)localObject4).dkM -= ((p.a)localObject1).weight;
          ((p)localObject4).dkI.remove(0);
          if (((p)localObject4).dkN >= 5) {
            continue;
          }
          p.a[] arrayOfa = ((p)localObject4).sBP;
          i = ((p)localObject4).dkN;
          ((p)localObject4).dkN = (i + 1);
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
      ((p)localObject4).dkM -= i;
    }
    Object localObject3 = this.sBw;
    if (((p)localObject3).dkK != 0)
    {
      Collections.sort(((p)localObject3).dkI, p.dkG);
      ((p)localObject3).dkK = 0;
    }
    float f = ((p)localObject3).dkM;
    final int i = 0;
    int j = 0;
    if (i < ((p)localObject3).dkI.size())
    {
      localObject4 = (p.a)((p)localObject3).dkI.get(i);
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
      diy = l1;
      sBz = l1;
      i = sBy;
      l1 = this.sBx;
      long l3 = diy;
      if ((this.eventHandler != null) && (this.sBu != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      this.dit -= 1;
      if (this.dit > 0) {
        this.startTimeMs = l2;
      }
      this.sBx = 0L;
      AppMethodBeat.o(328562);
      return;
      i += 1;
      break;
      if (((p)localObject3).dkI.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label455;
      }
      f = ((p.a)((p)localObject3).dkI.get(((p)localObject3).dkI.size() - 1)).value;
      break label455;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      AppMethodBeat.i(328539);
      if (this.dit == 0) {
        this.startTimeMs = this.sBv.elapsedRealtime();
      }
      this.dit += 1;
      AppMethodBeat.o(328539);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.h
 * JD-Core Version:    0.7.0.1
 */