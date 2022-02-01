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
  private final d.a buD;
  private final r buE;
  private final c buF;
  private int buG;
  private long buH;
  private long buI;
  private long buJ;
  private long buK;
  private long buL;
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
    this(paramHandler, parama, c.bwn);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(93056);
    this.eventHandler = paramHandler;
    this.buD = parama;
    this.buE = new r();
    this.buF = paramc;
    this.buL = -1L;
    AppMethodBeat.o(93056);
  }
  
  public final void eV(int paramInt)
  {
    try
    {
      this.buI += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long va()
  {
    try
    {
      long l = this.buL;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ve()
  {
    try
    {
      AppMethodBeat.i(93057);
      if (this.buG == 0) {
        this.buH = this.buF.elapsedRealtime();
      }
      this.buG += 1;
      AppMethodBeat.o(93057);
      return;
    }
    finally {}
  }
  
  public final void vf()
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
        if (this.buG > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.buF.elapsedRealtime();
          k = (int)(l2 - this.buH);
          this.buJ += k;
          this.buK += this.buI;
          if (k <= 0) {
            break label517;
          }
          f = (float)(this.buI * 8000L / k);
          localObject4 = this.buE;
          i = (int)Math.sqrt(this.buI);
          if (((r)localObject4).bwU != 1)
          {
            Collections.sort(((r)localObject4).bwS, r.bwP);
            ((r)localObject4).bwU = 1;
          }
          if (((r)localObject4).bwX <= 0) {
            break label345;
          }
          Object localObject1 = ((r)localObject4).bwT;
          j = ((r)localObject4).bwX - 1;
          ((r)localObject4).bwX = j;
          localObject1 = localObject1[j];
          j = ((r)localObject4).bwV;
          ((r)localObject4).bwV = (j + 1);
          ((r.a)localObject1).index = j;
          ((r.a)localObject1).weight = i;
          ((r.a)localObject1).value = f;
          ((r)localObject4).bwS.add(localObject1);
          ((r)localObject4).bwW += i;
          if (((r)localObject4).bwW <= ((r)localObject4).bwR) {
            break;
          }
          i = ((r)localObject4).bwW - ((r)localObject4).bwR;
          localObject1 = (r.a)((r)localObject4).bwS.get(0);
          if (((r.a)localObject1).weight > i) {
            break label358;
          }
          ((r)localObject4).bwW -= ((r.a)localObject1).weight;
          ((r)localObject4).bwS.remove(0);
          if (((r)localObject4).bwX >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject4).bwT;
          i = ((r)localObject4).bwX;
          ((r)localObject4).bwX = (i + 1);
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
      ((r)localObject4).bwW -= i;
    }
    if ((this.buJ >= 2000L) || (this.buK >= 524288L))
    {
      localObject3 = this.buE;
      if (((r)localObject3).bwU != 0)
      {
        Collections.sort(((r)localObject3).bwS, r.bwQ);
        ((r)localObject3).bwU = 0;
      }
      f = ((r)localObject3).bwW;
      i = 0;
      j = 0;
      if (i >= ((r)localObject3).bwS.size()) {
        break label607;
      }
      localObject4 = (r.a)((r)localObject3).bwS.get(i);
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
      this.buL = l1;
      l1 = this.buI;
      long l3 = this.buL;
      if ((this.eventHandler != null) && (this.buD != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      i = this.buG - 1;
      this.buG = i;
      if (i > 0) {
        this.buH = l2;
      }
      this.buI = 0L;
      AppMethodBeat.o(93058);
      return;
      label600:
      i += 1;
      break;
      label607:
      if (((r)localObject3).bwS.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label499;
      }
      f = ((r.a)((r)localObject3).bwS.get(((r)localObject3).bwS.size() - 1)).value;
      break label499;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */