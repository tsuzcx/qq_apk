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
  implements d, x<Object>
{
  private final d.a bwH;
  private final r bwI;
  private final c bwJ;
  private int bwK;
  private long bwL;
  private long bwM;
  private long bwN;
  private long bwO;
  private long bwP;
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
    this(paramHandler, parama, c.byF);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(93056);
    this.eventHandler = paramHandler;
    this.bwH = parama;
    this.bwI = new r();
    this.bwJ = paramc;
    this.bwP = -1L;
    AppMethodBeat.o(93056);
  }
  
  public final void fj(int paramInt)
  {
    try
    {
      this.bwM += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long vg()
  {
    try
    {
      long l = this.bwP;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vl()
  {
    try
    {
      AppMethodBeat.i(93057);
      if (this.bwK == 0) {
        this.bwL = this.bwJ.elapsedRealtime();
      }
      this.bwK += 1;
      AppMethodBeat.o(93057);
      return;
    }
    finally {}
  }
  
  public final void vm()
  {
    long l2;
    final int k;
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
        AppMethodBeat.i(93058);
        if (this.bwK > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.bwJ.elapsedRealtime();
          k = (int)(l2 - this.bwL);
          this.bwN += k;
          this.bwO += this.bwM;
          if (k <= 0) {
            break label517;
          }
          f = (float)(this.bwM * 8000L / k);
          localObject4 = this.bwI;
          i = (int)Math.sqrt(this.bwM);
          if (((r)localObject4).bzm != 1)
          {
            Collections.sort(((r)localObject4).bzk, r.bzh);
            ((r)localObject4).bzm = 1;
          }
          if (((r)localObject4).bzp <= 0) {
            break label345;
          }
          Object localObject1 = ((r)localObject4).bzl;
          j = ((r)localObject4).bzp - 1;
          ((r)localObject4).bzp = j;
          localObject1 = localObject1[j];
          j = ((r)localObject4).bzn;
          ((r)localObject4).bzn = (j + 1);
          ((r.a)localObject1).index = j;
          ((r.a)localObject1).weight = i;
          ((r.a)localObject1).value = f;
          ((r)localObject4).bzk.add(localObject1);
          ((r)localObject4).bzo += i;
          if (((r)localObject4).bzo <= ((r)localObject4).bzj) {
            break;
          }
          i = ((r)localObject4).bzo - ((r)localObject4).bzj;
          localObject1 = (r.a)((r)localObject4).bzk.get(0);
          if (((r.a)localObject1).weight > i) {
            break label358;
          }
          ((r)localObject4).bzo -= ((r.a)localObject1).weight;
          ((r)localObject4).bzk.remove(0);
          if (((r)localObject4).bzp >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject4).bzl;
          i = ((r)localObject4).bzp;
          ((r)localObject4).bzp = (i + 1);
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
      ((r)localObject4).bzo -= i;
    }
    if ((this.bwN >= 2000L) || (this.bwO >= 524288L))
    {
      localObject3 = this.bwI;
      if (((r)localObject3).bzm != 0)
      {
        Collections.sort(((r)localObject3).bzk, r.bzi);
        ((r)localObject3).bzm = 0;
      }
      f = ((r)localObject3).bzo;
      i = 0;
      j = 0;
      if (i >= ((r)localObject3).bzk.size()) {
        break label607;
      }
      localObject4 = (r.a)((r)localObject3).bzk.get(i);
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
    for (final long l1 = -1L;; l1 = f)
    {
      this.bwP = l1;
      l1 = this.bwM;
      long l3 = this.bwP;
      if ((this.eventHandler != null) && (this.bwH != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      i = this.bwK - 1;
      this.bwK = i;
      if (i > 0) {
        this.bwL = l2;
      }
      this.bwM = 0L;
      AppMethodBeat.o(93058);
      return;
      label600:
      i += 1;
      break;
      label607:
      if (((r)localObject3).bzk.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label499;
      }
      f = ((r.a)((r)localObject3).bzk.get(((r)localObject3).bzk.size() - 1)).value;
      break label499;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */