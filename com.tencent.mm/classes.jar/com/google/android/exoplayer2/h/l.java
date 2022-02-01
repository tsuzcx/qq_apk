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
  final d.a boA;
  private final r boB;
  private final c boC;
  private int boD;
  private long boE;
  private long boF;
  private long boG;
  private long boH;
  private long boI;
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
    this(paramHandler, parama, c.bqB);
  }
  
  private l(Handler paramHandler, d.a parama, c paramc)
  {
    AppMethodBeat.i(93056);
    this.eventHandler = paramHandler;
    this.boA = parama;
    this.boB = new r(2000);
    this.boC = paramc;
    this.boI = -1L;
    AppMethodBeat.o(93056);
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(199586);
      if (this.boD == 0) {
        this.boE = this.boC.elapsedRealtime();
      }
      this.boD += 1;
      AppMethodBeat.o(199586);
      return;
    }
    finally {}
  }
  
  public final void aa(Object paramObject)
  {
    long l2;
    int k;
    float f;
    Object localObject;
    int i;
    int j;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(199609);
        if (this.boD > 0)
        {
          bool = true;
          a.checkState(bool);
          l2 = this.boC.elapsedRealtime();
          k = (int)(l2 - this.boE);
          this.boG += k;
          this.boH += this.boF;
          if (k <= 0) {
            break label504;
          }
          f = (float)(this.boF * 8000L / k);
          localObject = this.boB;
          i = (int)Math.sqrt(this.boF);
          if (((r)localObject).brg != 1)
          {
            Collections.sort(((r)localObject).bre, r.brb);
            ((r)localObject).brg = 1;
          }
          if (((r)localObject).brj <= 0) {
            break label338;
          }
          paramObject = ((r)localObject).brf;
          j = ((r)localObject).brj - 1;
          ((r)localObject).brj = j;
          paramObject = paramObject[j];
          j = ((r)localObject).brh;
          ((r)localObject).brh = (j + 1);
          paramObject.index = j;
          paramObject.weight = i;
          paramObject.value = f;
          ((r)localObject).bre.add(paramObject);
          ((r)localObject).bri += i;
          if (((r)localObject).bri <= ((r)localObject).brd) {
            break;
          }
          i = ((r)localObject).bri - ((r)localObject).brd;
          paramObject = (r.a)((r)localObject).bre.get(0);
          if (paramObject.weight > i) {
            break label350;
          }
          ((r)localObject).bri -= paramObject.weight;
          ((r)localObject).bre.remove(0);
          if (((r)localObject).brj >= 5) {
            continue;
          }
          r.a[] arrayOfa = ((r)localObject).brf;
          i = ((r)localObject).brj;
          ((r)localObject).brj = (i + 1);
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
      ((r)localObject).bri -= i;
    }
    if ((this.boG >= 2000L) || (this.boH >= 524288L))
    {
      paramObject = this.boB;
      if (paramObject.brg != 0)
      {
        Collections.sort(paramObject.bre, r.brc);
        paramObject.brg = 0;
      }
      f = paramObject.bri;
      i = 0;
      j = 0;
      if (i >= paramObject.bre.size()) {
        break label594;
      }
      localObject = (r.a)paramObject.bre.get(i);
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
    for (long l1 = -1L;; l1 = f)
    {
      this.boI = l1;
      l1 = this.boF;
      long l3 = this.boI;
      if ((this.eventHandler != null) && (this.boA != null)) {
        this.eventHandler.post(new l.1(this, k, l1, l3));
      }
      i = this.boD - 1;
      this.boD = i;
      if (i > 0) {
        this.boE = l2;
      }
      this.boF = 0L;
      AppMethodBeat.o(199609);
      return;
      i += 1;
      break;
      if (paramObject.bre.isEmpty())
      {
        f = (0.0F / 0.0F);
        break label486;
      }
      f = ((r.a)paramObject.bre.get(paramObject.bre.size() - 1)).value;
      break label486;
    }
  }
  
  public final void e(Object paramObject, int paramInt)
  {
    try
    {
      this.boF += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final long uF()
  {
    try
    {
      long l = this.boI;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.l
 * JD-Core Version:    0.7.0.1
 */