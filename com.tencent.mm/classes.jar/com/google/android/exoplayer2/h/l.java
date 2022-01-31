package com.google.android.exoplayer2.h;

import android.os.Handler;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.r.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class l
  implements d, w<Object>
{
  private final d.a aYG;
  private final r aYH;
  private final c aYI;
  private int aYJ;
  private long aYK;
  private long aYL;
  private long aYM;
  private long aYN;
  private long aYO;
  private final Handler eventHandler;
  
  public l()
  {
    this(null, null);
  }
  
  public l(Handler paramHandler, d.a parama)
  {
    this(paramHandler, parama, (byte)0);
  }
  
  private l(Handler paramHandler, d.a parama, byte paramByte)
  {
    this(paramHandler, parama, c.baE);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(95813);
    this.eventHandler = paramHandler;
    this.aYG = parama;
    this.aYH = new r();
    this.aYI = paramc;
    this.aYO = -1L;
    AppMethodBeat.o(95813);
  }
  
  public final void el(int paramInt)
  {
    try
    {
      this.aYL += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long qm()
  {
    try
    {
      long l = this.aYO;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void qq()
  {
    try
    {
      AppMethodBeat.i(95814);
      if (this.aYJ == 0) {
        this.aYK = this.aYI.elapsedRealtime();
      }
      this.aYJ += 1;
      AppMethodBeat.o(95814);
      return;
    }
    finally {}
  }
  
  public final void qr()
  {
    long l2;
    int k;
    float f;
    Object localObject4;
    int i;
    int j;
    label345:
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95815);
        if (this.aYJ > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.aYI.elapsedRealtime();
          k = (int)(l2 - this.aYK);
          this.aYM += k;
          this.aYN += this.aYL;
          if (k <= 0) {
            break label517;
          }
          f = (float)(this.aYL * 8000L / k);
          localObject4 = this.aYH;
          i = (int)Math.sqrt(this.aYL);
          if (((r)localObject4).bbl != 1)
          {
            Collections.sort(((r)localObject4).bbj, r.bbg);
            ((r)localObject4).bbl = 1;
          }
          if (((r)localObject4).bbo <= 0) {
            break label345;
          }
          Object localObject1 = ((r)localObject4).bbk;
          j = ((r)localObject4).bbo - 1;
          ((r)localObject4).bbo = j;
          localObject1 = localObject1[j];
          j = ((r)localObject4).bbm;
          ((r)localObject4).bbm = (j + 1);
          ((r.a)localObject1).index = j;
          ((r.a)localObject1).weight = i;
          ((r.a)localObject1).value = f;
          ((r)localObject4).bbj.add(localObject1);
          ((r)localObject4).bbn += i;
          if (((r)localObject4).bbn <= ((r)localObject4).bbi) {
            break;
          }
          i = ((r)localObject4).bbn - ((r)localObject4).bbi;
          localObject1 = (r.a)((r)localObject4).bbj.get(0);
          if (((r.a)localObject1).weight > i) {
            break label358;
          }
          ((r)localObject4).bbn -= ((r.a)localObject1).weight;
          ((r)localObject4).bbj.remove(0);
          if (((r)localObject4).bbo >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject4).bbk;
          i = ((r)localObject4).bbo;
          ((r)localObject4).bbo = (i + 1);
          arrayOfa[i] = localObject1;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      localObject3 = new r.a((byte)0);
      continue;
      label358:
      ((r.a)localObject3).weight -= i;
      ((r)localObject4).bbn -= i;
    }
    if ((this.aYM >= 2000L) || (this.aYN >= 524288L))
    {
      localObject3 = this.aYH;
      if (((r)localObject3).bbl != 0)
      {
        Collections.sort(((r)localObject3).bbj, r.bbh);
        ((r)localObject3).bbl = 0;
      }
      f = ((r)localObject3).bbn;
      i = 0;
      j = 0;
      if (i >= ((r)localObject3).bbj.size()) {
        break label607;
      }
      localObject4 = (r.a)((r)localObject3).bbj.get(i);
      j = ((r.a)localObject4).weight + j;
      if (j < 0.5F * f) {
        break label600;
      }
      f = ((r.a)localObject4).value;
      label499:
      if (!Float.isNaN(f)) {
        break label652;
      }
    }
    label517:
    label652:
    for (long l1 = -1L;; l1 = f)
    {
      this.aYO = l1;
      l1 = this.aYL;
      long l3 = this.aYO;
      if ((this.eventHandler != null) && (this.aYG != null)) {
        this.eventHandler.post(new l.1(this, k, l1, l3));
      }
      i = this.aYJ - 1;
      this.aYJ = i;
      if (i > 0) {
        this.aYK = l2;
      }
      this.aYL = 0L;
      AppMethodBeat.o(95815);
      return;
      label600:
      i += 1;
      break;
      label607:
      if (((r)localObject3).bbj.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label499;
      }
      f = ((r.a)((r)localObject3).bbj.get(((r)localObject3).bbj.size() - 1)).value;
      break label499;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */