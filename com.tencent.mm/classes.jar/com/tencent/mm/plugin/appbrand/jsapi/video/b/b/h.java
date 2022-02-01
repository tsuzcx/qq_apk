package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.ArrayList;
import java.util.Collections;

public final class h
  implements b
{
  private static long boI;
  private static int pws;
  private static long pwt;
  private int boD;
  private final Handler eventHandler;
  final b.a pwo;
  private final c pwp;
  private final p pwq;
  private long pwr;
  private long startTimeMs;
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    this(new q());
    AppMethodBeat.i(229819);
    AppMethodBeat.o(229819);
  }
  
  private h(Handler paramHandler, b.a parama, c paramc)
  {
    AppMethodBeat.i(229821);
    this.eventHandler = null;
    this.pwo = null;
    this.pwp = paramc;
    this.pwq = new p();
    boI = -1L;
    AppMethodBeat.o(229821);
  }
  
  private h(c paramc)
  {
    this(null, null, paramc);
  }
  
  public final void AU(int paramInt)
  {
    try
    {
      this.pwr += paramInt;
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
        AppMethodBeat.i(229831);
        if (this.boD > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.pwp.elapsedRealtime();
          i = (int)(l2 - this.startTimeMs);
          pws = i;
          if (i <= 0) {
            break label527;
          }
          f = (float)(this.pwr * 8000L / pws);
          localObject4 = this.pwq;
          i = (int)Math.sqrt(this.pwr);
          if (((p)localObject4).brg != 1)
          {
            Collections.sort(((p)localObject4).bre, p.brb);
            ((p)localObject4).brg = 1;
          }
          if (((p)localObject4).brj <= 0) {
            break label323;
          }
          Object localObject1 = ((p)localObject4).pwJ;
          j = ((p)localObject4).brj - 1;
          ((p)localObject4).brj = j;
          localObject1 = localObject1[j];
          j = ((p)localObject4).brh;
          ((p)localObject4).brh = (j + 1);
          ((p.a)localObject1).index = j;
          ((p.a)localObject1).weight = i;
          ((p.a)localObject1).value = f;
          ((p)localObject4).bre.add(localObject1);
          ((p)localObject4).bri += i;
          if (((p)localObject4).bri <= ((p)localObject4).brd) {
            break;
          }
          i = ((p)localObject4).bri - ((p)localObject4).brd;
          localObject1 = (p.a)((p)localObject4).bre.get(0);
          if (((p.a)localObject1).weight > i) {
            break label336;
          }
          ((p)localObject4).bri -= ((p.a)localObject1).weight;
          ((p)localObject4).bre.remove(0);
          if (((p)localObject4).brj >= 5) {
            continue;
          }
          p.a[] arrayOfa = ((p)localObject4).pwJ;
          i = ((p)localObject4).brj;
          ((p)localObject4).brj = (i + 1);
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
      ((p)localObject4).bri -= i;
    }
    Object localObject3 = this.pwq;
    if (((p)localObject3).brg != 0)
    {
      Collections.sort(((p)localObject3).bre, p.brc);
      ((p)localObject3).brg = 0;
    }
    float f = ((p)localObject3).bri;
    int i = 0;
    int j = 0;
    if (i < ((p)localObject3).bre.size())
    {
      localObject4 = (p.a)((p)localObject3).bre.get(i);
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
    for (long l1 = -1L;; l1 = f)
    {
      boI = l1;
      pwt = l1;
      i = pws;
      l1 = this.pwr;
      long l3 = boI;
      if ((this.eventHandler != null) && (this.pwo != null)) {
        this.eventHandler.post(new h.1(this, i, l1, l3));
      }
      this.boD -= 1;
      if (this.boD > 0) {
        this.startTimeMs = l2;
      }
      this.pwr = 0L;
      AppMethodBeat.o(229831);
      return;
      i += 1;
      break;
      if (((p)localObject3).bre.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label455;
      }
      f = ((p.a)((p)localObject3).bre.get(((p)localObject3).bre.size() - 1)).value;
      break label455;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      AppMethodBeat.i(229823);
      if (this.boD == 0) {
        this.startTimeMs = this.pwp.elapsedRealtime();
      }
      this.boD += 1;
      AppMethodBeat.o(229823);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.h
 * JD-Core Version:    0.7.0.1
 */