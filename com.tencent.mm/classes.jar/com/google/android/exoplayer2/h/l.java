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
  private final d.a bES;
  private final r bET;
  private final c bEU;
  private int bEV;
  private long bEW;
  private long bEX;
  private long bEY;
  private long bEZ;
  private long bFa;
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
    this(paramHandler, parama, c.bGB);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(93056);
    this.eventHandler = paramHandler;
    this.bES = parama;
    this.bET = new r();
    this.bEU = paramc;
    this.bFa = -1L;
    AppMethodBeat.o(93056);
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(217124);
      if (this.bEV == 0) {
        this.bEW = this.bEU.elapsedRealtime();
      }
      this.bEV += 1;
      AppMethodBeat.o(217124);
      return;
    }
    finally {}
  }
  
  public final void ah(Object paramObject)
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
        AppMethodBeat.i(217125);
        if (this.bEV > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.bEU.elapsedRealtime();
          k = (int)(l2 - this.bEW);
          this.bEY += k;
          this.bEZ += this.bEX;
          if (k <= 0) {
            break label504;
          }
          f = (float)(this.bEX * 8000L / k);
          localObject = this.bET;
          i = (int)Math.sqrt(this.bEX);
          if (((r)localObject).bHi != 1)
          {
            Collections.sort(((r)localObject).bHg, r.bHd);
            ((r)localObject).bHi = 1;
          }
          if (((r)localObject).bHl <= 0) {
            break label338;
          }
          paramObject = ((r)localObject).bHh;
          j = ((r)localObject).bHl - 1;
          ((r)localObject).bHl = j;
          paramObject = paramObject[j];
          j = ((r)localObject).bHj;
          ((r)localObject).bHj = (j + 1);
          paramObject.index = j;
          paramObject.weight = i;
          paramObject.value = f;
          ((r)localObject).bHg.add(paramObject);
          ((r)localObject).bHk += i;
          if (((r)localObject).bHk <= ((r)localObject).bHf) {
            break;
          }
          i = ((r)localObject).bHk - ((r)localObject).bHf;
          paramObject = (r.a)((r)localObject).bHg.get(0);
          if (paramObject.weight > i) {
            break label350;
          }
          ((r)localObject).bHk -= paramObject.weight;
          ((r)localObject).bHg.remove(0);
          if (((r)localObject).bHl >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject).bHh;
          i = ((r)localObject).bHl;
          ((r)localObject).bHl = (i + 1);
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
      ((r)localObject).bHk -= i;
    }
    if ((this.bEY >= 2000L) || (this.bEZ >= 524288L))
    {
      paramObject = this.bET;
      if (paramObject.bHi != 0)
      {
        Collections.sort(paramObject.bHg, r.bHe);
        paramObject.bHi = 0;
      }
      f = paramObject.bHk;
      i = 0;
      j = 0;
      if (i >= paramObject.bHg.size()) {
        break label594;
      }
      localObject = (r.a)paramObject.bHg.get(i);
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
      this.bFa = l1;
      l1 = this.bEX;
      long l3 = this.bFa;
      if ((this.eventHandler != null) && (this.bES != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      i = this.bEV - 1;
      this.bEV = i;
      if (i > 0) {
        this.bEW = l2;
      }
      this.bEX = 0L;
      AppMethodBeat.o(217125);
      return;
      i += 1;
      break;
      if (paramObject.bHg.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label486;
      }
      f = ((r.a)paramObject.bHg.get(paramObject.bHg.size() - 1)).value;
      break label486;
    }
  }
  
  public final void e(Object paramObject, int paramInt)
  {
    try
    {
      this.bEX += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final long wz()
  {
    try
    {
      long l = this.bFa;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */