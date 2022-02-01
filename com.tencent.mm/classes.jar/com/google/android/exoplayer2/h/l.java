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
  final d.a dip;
  private final r diq;
  private final c dis;
  private int dit;
  private long diu;
  private long div;
  private long diw;
  private long dix;
  private long diy;
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
    this(paramHandler, parama, c.dkf);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(93056);
    this.eventHandler = paramHandler;
    this.dip = parama;
    this.diq = new r(2000);
    this.dis = paramc;
    this.diy = -1L;
    AppMethodBeat.o(93056);
  }
  
  public final long Ui()
  {
    try
    {
      long l = this.diy;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(210317);
      if (this.dit == 0) {
        this.diu = this.dis.elapsedRealtime();
      }
      this.dit += 1;
      AppMethodBeat.o(210317);
      return;
    }
    finally {}
  }
  
  public final void bj(Object paramObject)
  {
    long l2;
    final int k;
    float f;
    Object localObject;
    int i;
    int j;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210319);
        if (this.dit > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.dis.elapsedRealtime();
          k = (int)(l2 - this.diu);
          this.diw += k;
          this.dix += this.div;
          if (k <= 0) {
            break label504;
          }
          f = (float)(this.div * 8000L / k);
          localObject = this.diq;
          i = (int)Math.sqrt(this.div);
          if (((r)localObject).dkK != 1)
          {
            Collections.sort(((r)localObject).dkI, r.dkF);
            ((r)localObject).dkK = 1;
          }
          if (((r)localObject).dkN <= 0) {
            break label338;
          }
          paramObject = ((r)localObject).dkJ;
          j = ((r)localObject).dkN - 1;
          ((r)localObject).dkN = j;
          paramObject = paramObject[j];
          j = ((r)localObject).dkL;
          ((r)localObject).dkL = (j + 1);
          paramObject.index = j;
          paramObject.weight = i;
          paramObject.value = f;
          ((r)localObject).dkI.add(paramObject);
          ((r)localObject).dkM += i;
          if (((r)localObject).dkM <= ((r)localObject).dkH) {
            break;
          }
          i = ((r)localObject).dkM - ((r)localObject).dkH;
          paramObject = (r.a)((r)localObject).dkI.get(0);
          if (paramObject.weight > i) {
            break label350;
          }
          ((r)localObject).dkM -= paramObject.weight;
          ((r)localObject).dkI.remove(0);
          if (((r)localObject).dkN >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject).dkJ;
          i = ((r)localObject).dkN;
          ((r)localObject).dkN = (i + 1);
          arrayOfa[i] = paramObject;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label338:
      paramObject = new r.a((byte)0);
      continue;
      label350:
      paramObject.weight -= i;
      ((r)localObject).dkM -= i;
    }
    if ((this.diw >= 2000L) || (this.dix >= 524288L))
    {
      paramObject = this.diq;
      if (paramObject.dkK != 0)
      {
        Collections.sort(paramObject.dkI, r.dkG);
        paramObject.dkK = 0;
      }
      f = paramObject.dkM;
      i = 0;
      j = 0;
      if (i >= paramObject.dkI.size()) {
        break label594;
      }
      localObject = (r.a)paramObject.dkI.get(i);
      j = ((r.a)localObject).weight + j;
      if (j < 0.5F * f) {
        break label587;
      }
      f = ((r.a)localObject).value;
      label486:
      if (!Float.isNaN(f)) {
        break label636;
      }
    }
    label504:
    label636:
    for (final long l1 = -1L;; l1 = f)
    {
      this.diy = l1;
      l1 = this.div;
      long l3 = this.diy;
      if ((this.eventHandler != null) && (this.dip != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      i = this.dit - 1;
      this.dit = i;
      if (i > 0) {
        this.diu = l2;
      }
      this.div = 0L;
      AppMethodBeat.o(210319);
      return;
      i += 1;
      break;
      if (paramObject.dkI.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label486;
      }
      f = ((r.a)paramObject.dkI.get(paramObject.dkI.size() - 1)).value;
      break label486;
    }
  }
  
  public final void f(Object paramObject, int paramInt)
  {
    try
    {
      this.div += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */