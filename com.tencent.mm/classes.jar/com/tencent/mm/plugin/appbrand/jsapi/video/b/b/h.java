package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.ArrayList;
import java.util.Collections;

public final class h
  implements b
{
  private static long bFf;
  private static int mxY;
  private static long mxZ;
  private int bFa;
  private final Handler eventHandler;
  private final b.a mxU;
  private final c mxV;
  private final p mxW;
  private long mxX;
  private long startTimeMs;
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    this(new q());
    AppMethodBeat.i(234726);
    AppMethodBeat.o(234726);
  }
  
  private h(Handler paramHandler, b.a parama, c paramc)
  {
    AppMethodBeat.i(234727);
    this.eventHandler = null;
    this.mxU = null;
    this.mxV = paramc;
    this.mxW = new p();
    bFf = -1L;
    AppMethodBeat.o(234727);
  }
  
  private h(c paramc)
  {
    this(null, null, paramc);
  }
  
  public final void onTransferEnd()
  {
    long l2;
    Object localObject4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(234729);
        if (this.bFa > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.mxV.elapsedRealtime();
          i = (int)(l2 - this.startTimeMs);
          mxY = i;
          if (i <= 0) {
            break label527;
          }
          f = (float)(this.mxX * 8000L / mxY);
          localObject4 = this.mxW;
          i = (int)Math.sqrt(this.mxX);
          if (((p)localObject4).bHz != 1)
          {
            Collections.sort(((p)localObject4).bHx, p.bHu);
            ((p)localObject4).bHz = 1;
          }
          if (((p)localObject4).bHC <= 0) {
            break label323;
          }
          Object localObject1 = ((p)localObject4).myp;
          j = ((p)localObject4).bHC - 1;
          ((p)localObject4).bHC = j;
          localObject1 = localObject1[j];
          j = ((p)localObject4).bHA;
          ((p)localObject4).bHA = (j + 1);
          ((p.a)localObject1).index = j;
          ((p.a)localObject1).weight = i;
          ((p.a)localObject1).value = f;
          ((p)localObject4).bHx.add(localObject1);
          ((p)localObject4).bHB += i;
          if (((p)localObject4).bHB <= ((p)localObject4).bHw) {
            break;
          }
          i = ((p)localObject4).bHB - ((p)localObject4).bHw;
          localObject1 = (p.a)((p)localObject4).bHx.get(0);
          if (((p.a)localObject1).weight > i) {
            break label336;
          }
          ((p)localObject4).bHB -= ((p.a)localObject1).weight;
          ((p)localObject4).bHx.remove(0);
          if (((p)localObject4).bHC >= 5) {
            continue;
          }
          p.a[] arrayOfa = ((p)localObject4).myp;
          i = ((p)localObject4).bHC;
          ((p)localObject4).bHC = (i + 1);
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
      ((p)localObject4).bHB -= i;
    }
    Object localObject3 = this.mxW;
    if (((p)localObject3).bHz != 0)
    {
      Collections.sort(((p)localObject3).bHx, p.bHv);
      ((p)localObject3).bHz = 0;
    }
    float f = ((p)localObject3).bHB;
    final int i = 0;
    int j = 0;
    if (i < ((p)localObject3).bHx.size())
    {
      localObject4 = (p.a)((p)localObject3).bHx.get(i);
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
      bFf = l1;
      mxZ = l1;
      i = mxY;
      l1 = this.mxX;
      long l3 = bFf;
      if ((this.eventHandler != null) && (this.mxU != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      this.bFa -= 1;
      if (this.bFa > 0) {
        this.startTimeMs = l2;
      }
      this.mxX = 0L;
      AppMethodBeat.o(234729);
      return;
      i += 1;
      break;
      if (((p)localObject3).bHx.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label455;
      }
      f = ((p.a)((p)localObject3).bHx.get(((p)localObject3).bHx.size() - 1)).value;
      break label455;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      AppMethodBeat.i(234728);
      if (this.bFa == 0) {
        this.startTimeMs = this.mxV.elapsedRealtime();
      }
      this.bFa += 1;
      AppMethodBeat.o(234728);
      return;
    }
    finally {}
  }
  
  public final void xx(int paramInt)
  {
    try
    {
      this.mxX += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.h
 * JD-Core Version:    0.7.0.1
 */