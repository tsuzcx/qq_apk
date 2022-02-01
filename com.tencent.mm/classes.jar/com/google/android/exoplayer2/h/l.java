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
  private final d.a bEX;
  private final r bEY;
  private final c bEZ;
  private int bFa;
  private long bFb;
  private long bFc;
  private long bFd;
  private long bFe;
  private long bFf;
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
    this(paramHandler, parama, c.bGS);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(93056);
    this.eventHandler = paramHandler;
    this.bEX = parama;
    this.bEY = new r(2000);
    this.bEZ = paramc;
    this.bFf = -1L;
    AppMethodBeat.o(93056);
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(196064);
      if (this.bFa == 0) {
        this.bFb = this.bEZ.elapsedRealtime();
      }
      this.bFa += 1;
      AppMethodBeat.o(196064);
      return;
    }
    finally {}
  }
  
  public final void ai(Object paramObject)
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
        AppMethodBeat.i(196065);
        if (this.bFa > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.bEZ.elapsedRealtime();
          k = (int)(l2 - this.bFb);
          this.bFd += k;
          this.bFe += this.bFc;
          if (k <= 0) {
            break label504;
          }
          f = (float)(this.bFc * 8000L / k);
          localObject = this.bEY;
          i = (int)Math.sqrt(this.bFc);
          if (((r)localObject).bHz != 1)
          {
            Collections.sort(((r)localObject).bHx, r.bHu);
            ((r)localObject).bHz = 1;
          }
          if (((r)localObject).bHC <= 0) {
            break label338;
          }
          paramObject = ((r)localObject).bHy;
          j = ((r)localObject).bHC - 1;
          ((r)localObject).bHC = j;
          paramObject = paramObject[j];
          j = ((r)localObject).bHA;
          ((r)localObject).bHA = (j + 1);
          paramObject.index = j;
          paramObject.weight = i;
          paramObject.value = f;
          ((r)localObject).bHx.add(paramObject);
          ((r)localObject).bHB += i;
          if (((r)localObject).bHB <= ((r)localObject).bHw) {
            break;
          }
          i = ((r)localObject).bHB - ((r)localObject).bHw;
          paramObject = (r.a)((r)localObject).bHx.get(0);
          if (paramObject.weight > i) {
            break label350;
          }
          ((r)localObject).bHB -= paramObject.weight;
          ((r)localObject).bHx.remove(0);
          if (((r)localObject).bHC >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject).bHy;
          i = ((r)localObject).bHC;
          ((r)localObject).bHC = (i + 1);
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
      ((r)localObject).bHB -= i;
    }
    if ((this.bFd >= 2000L) || (this.bFe >= 524288L))
    {
      paramObject = this.bEY;
      if (paramObject.bHz != 0)
      {
        Collections.sort(paramObject.bHx, r.bHv);
        paramObject.bHz = 0;
      }
      f = paramObject.bHB;
      i = 0;
      j = 0;
      if (i >= paramObject.bHx.size()) {
        break label594;
      }
      localObject = (r.a)paramObject.bHx.get(i);
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
      this.bFf = l1;
      l1 = this.bFc;
      long l3 = this.bFf;
      if ((this.eventHandler != null) && (this.bEX != null)) {
        this.eventHandler.post(new Runnable()
        {
          public final void run() {}
        });
      }
      i = this.bFa - 1;
      this.bFa = i;
      if (i > 0) {
        this.bFb = l2;
      }
      this.bFc = 0L;
      AppMethodBeat.o(196065);
      return;
      i += 1;
      break;
      if (paramObject.bHx.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label486;
      }
      f = ((r.a)paramObject.bHx.get(paramObject.bHx.size() - 1)).value;
      break label486;
    }
  }
  
  public final void d(Object paramObject, int paramInt)
  {
    try
    {
      this.bFc += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final long wE()
  {
    try
    {
      long l = this.bFf;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */