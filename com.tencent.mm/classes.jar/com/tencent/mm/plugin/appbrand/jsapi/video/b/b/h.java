package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.ArrayList;
import java.util.Collections;

public final class h
  implements b
{
  private static long buL;
  private static int kQs;
  private static long kQt;
  private int buG;
  private long bvf;
  private final Handler eventHandler;
  private final b.a kQo;
  private final c kQp;
  private final p kQq;
  private long kQr;
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    this(new q());
    AppMethodBeat.i(194218);
    AppMethodBeat.o(194218);
  }
  
  private h(c paramc)
  {
    this(paramc, (byte)0);
  }
  
  private h(c paramc, byte paramByte)
  {
    AppMethodBeat.i(194219);
    this.eventHandler = null;
    this.kQo = null;
    this.kQp = paramc;
    this.kQq = new p();
    buL = -1L;
    AppMethodBeat.o(194219);
  }
  
  public final void onTransferEnd()
  {
    long l2;
    Object localObject4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(194221);
        if (this.buG > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.kQp.elapsedRealtime();
          i = (int)(l2 - this.bvf);
          kQs = i;
          if (i <= 0) {
            break label527;
          }
          f = (float)(this.kQr * 8000L / kQs);
          localObject4 = this.kQq;
          i = (int)Math.sqrt(this.kQr);
          if (((p)localObject4).bwU != 1)
          {
            Collections.sort(((p)localObject4).bwS, p.bwP);
            ((p)localObject4).bwU = 1;
          }
          if (((p)localObject4).bwX <= 0) {
            break label323;
          }
          Object localObject1 = ((p)localObject4).kQJ;
          j = ((p)localObject4).bwX - 1;
          ((p)localObject4).bwX = j;
          localObject1 = localObject1[j];
          j = ((p)localObject4).bwV;
          ((p)localObject4).bwV = (j + 1);
          ((p.a)localObject1).index = j;
          ((p.a)localObject1).weight = i;
          ((p.a)localObject1).value = f;
          ((p)localObject4).bwS.add(localObject1);
          ((p)localObject4).bwW += i;
          if (((p)localObject4).bwW <= ((p)localObject4).bwR) {
            break;
          }
          i = ((p)localObject4).bwW - ((p)localObject4).bwR;
          localObject1 = (p.a)((p)localObject4).bwS.get(0);
          if (((p.a)localObject1).weight > i) {
            break label336;
          }
          ((p)localObject4).bwW -= ((p.a)localObject1).weight;
          ((p)localObject4).bwS.remove(0);
          if (((p)localObject4).bwX >= 5) {
            continue;
          }
          p.a[] arrayOfa = ((p)localObject4).kQJ;
          i = ((p)localObject4).bwX;
          ((p)localObject4).bwX = (i + 1);
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
      ((p)localObject4).bwW -= i;
    }
    Object localObject3 = this.kQq;
    if (((p)localObject3).bwU != 0)
    {
      Collections.sort(((p)localObject3).bwS, p.bwQ);
      ((p)localObject3).bwU = 0;
    }
    float f = ((p)localObject3).bwW;
    final int i = 0;
    int j = 0;
    if (i < ((p)localObject3).bwS.size())
    {
      localObject4 = (p.a)((p)localObject3).bwS.get(i);
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
      buL = l1;
      kQt = l1;
      i = kQs;
      l1 = this.kQr;
      long l3 = buL;
      if ((this.eventHandler != null) && (this.kQo != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      this.buG -= 1;
      if (this.buG > 0) {
        this.bvf = l2;
      }
      this.kQr = 0L;
      AppMethodBeat.o(194221);
      return;
      i += 1;
      break;
      if (((p)localObject3).bwS.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label455;
      }
      f = ((p.a)((p)localObject3).bwS.get(((p)localObject3).bwS.size() - 1)).value;
      break label455;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      AppMethodBeat.i(194220);
      if (this.buG == 0) {
        this.bvf = this.kQp.elapsedRealtime();
      }
      this.buG += 1;
      AppMethodBeat.o(194220);
      return;
    }
    finally {}
  }
  
  public final void sS(int paramInt)
  {
    try
    {
      this.kQr += paramInt;
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