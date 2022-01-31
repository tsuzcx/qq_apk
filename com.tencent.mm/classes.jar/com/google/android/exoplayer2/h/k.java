package com.google.android.exoplayer2.h;

import android.os.Handler;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.n;
import com.google.android.exoplayer2.i.n.a;
import java.util.ArrayList;
import java.util.Collections;

public final class k
  implements d, t<Object>
{
  private final d.a aRe;
  private final n aRf;
  private final b aRg;
  private int aRh;
  private long aRi;
  private long aRj;
  private long aRk;
  private long aRl;
  private long aRm;
  private final Handler eventHandler;
  
  public k()
  {
    this(null, null);
  }
  
  public k(Handler paramHandler, d.a parama)
  {
    this(paramHandler, parama, (byte)0);
  }
  
  private k(Handler paramHandler, d.a parama, byte paramByte)
  {
    this(paramHandler, parama, b.aSf);
  }
  
  private k(Handler paramHandler, d.a parama, b paramb)
  {
    this.eventHandler = paramHandler;
    this.aRe = parama;
    this.aRf = new n();
    this.aRg = paramb;
    this.aRm = -1L;
  }
  
  public final void dx(int paramInt)
  {
    try
    {
      this.aRj += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void nT()
  {
    try
    {
      if (this.aRh == 0) {
        this.aRi = this.aRg.elapsedRealtime();
      }
      this.aRh += 1;
      return;
    }
    finally {}
  }
  
  public final void nU()
  {
    long l2;
    int k;
    float f;
    Object localObject4;
    int i;
    int j;
    label340:
    Object localObject3;
    for (;;)
    {
      try
      {
        if (this.aRh > 0)
        {
          bool = true;
          a.aC(bool);
          l2 = this.aRg.elapsedRealtime();
          k = (int)(l2 - this.aRi);
          this.aRk += k;
          this.aRl += this.aRj;
          if (k <= 0) {
            break label512;
          }
          f = (float)(this.aRj * 8000L / k);
          localObject4 = this.aRf;
          i = (int)Math.sqrt(this.aRj);
          if (((n)localObject4).aSK != 1)
          {
            Collections.sort(((n)localObject4).aSI, n.aSF);
            ((n)localObject4).aSK = 1;
          }
          if (((n)localObject4).aSN <= 0) {
            break label340;
          }
          Object localObject1 = ((n)localObject4).aSJ;
          j = ((n)localObject4).aSN - 1;
          ((n)localObject4).aSN = j;
          localObject1 = localObject1[j];
          j = ((n)localObject4).aSL;
          ((n)localObject4).aSL = (j + 1);
          ((n.a)localObject1).index = j;
          ((n.a)localObject1).weight = i;
          ((n.a)localObject1).value = f;
          ((n)localObject4).aSI.add(localObject1);
          ((n)localObject4).aSM += i;
          if (((n)localObject4).aSM <= ((n)localObject4).aSH) {
            break;
          }
          i = ((n)localObject4).aSM - ((n)localObject4).aSH;
          localObject1 = (n.a)((n)localObject4).aSI.get(0);
          if (((n.a)localObject1).weight > i) {
            break label353;
          }
          ((n)localObject4).aSM -= ((n.a)localObject1).weight;
          ((n)localObject4).aSI.remove(0);
          if (((n)localObject4).aSN >= 5) {
            continue;
          }
          n.a[] arrayOfa = ((n)localObject4).aSJ;
          i = ((n)localObject4).aSN;
          ((n)localObject4).aSN = (i + 1);
          arrayOfa[i] = localObject1;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      localObject3 = new n.a((byte)0);
      continue;
      label353:
      ((n.a)localObject3).weight -= i;
      ((n)localObject4).aSM -= i;
    }
    if ((this.aRk >= 2000L) || (this.aRl >= 524288L))
    {
      localObject3 = this.aRf;
      if (((n)localObject3).aSK != 0)
      {
        Collections.sort(((n)localObject3).aSI, n.aSG);
        ((n)localObject3).aSK = 0;
      }
      f = ((n)localObject3).aSM;
      i = 0;
      j = 0;
      if (i >= ((n)localObject3).aSI.size()) {
        break label597;
      }
      localObject4 = (n.a)((n)localObject3).aSI.get(i);
      j = ((n.a)localObject4).weight + j;
      if (j < 0.5F * f) {
        break label590;
      }
      f = ((n.a)localObject4).value;
      label494:
      if (!Float.isNaN(f)) {
        break label642;
      }
    }
    label512:
    label642:
    for (long l1 = -1L;; l1 = f)
    {
      this.aRm = l1;
      l1 = this.aRj;
      long l3 = this.aRm;
      if ((this.eventHandler != null) && (this.aRe != null)) {
        this.eventHandler.post(new k.1(this, k, l1, l3));
      }
      i = this.aRh - 1;
      this.aRh = i;
      if (i > 0) {
        this.aRi = l2;
      }
      this.aRj = 0L;
      return;
      label590:
      i += 1;
      break;
      label597:
      if (((n)localObject3).aSI.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label494;
      }
      f = ((n.a)((n)localObject3).aSI.get(((n)localObject3).aSI.size() - 1)).value;
      break label494;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.k
 * JD-Core Version:    0.7.0.1
 */