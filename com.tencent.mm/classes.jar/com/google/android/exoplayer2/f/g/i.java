package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i
  implements d
{
  private final List<e> bkh;
  private final long[] bmg;
  private final int bns;
  private final long[] bnt;
  
  public i(List<e> paramList)
  {
    AppMethodBeat.i(92917);
    this.bkh = paramList;
    this.bns = paramList.size();
    this.bmg = new long[this.bns * 2];
    int i = 0;
    while (i < this.bns)
    {
      e locale = (e)paramList.get(i);
      int j = i * 2;
      this.bmg[j] = locale.startTime;
      this.bmg[(j + 1)] = locale.endTime;
      i += 1;
    }
    this.bnt = Arrays.copyOf(this.bmg, this.bmg.length);
    Arrays.sort(this.bnt);
    AppMethodBeat.o(92917);
  }
  
  public final int al(long paramLong)
  {
    AppMethodBeat.i(92918);
    int i = x.a(this.bnt, paramLong, false, false);
    if (i < this.bnt.length)
    {
      AppMethodBeat.o(92918);
      return i;
    }
    AppMethodBeat.o(92918);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> am(long paramLong)
  {
    AppMethodBeat.i(92920);
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = null;
    Object localObject1 = null;
    Object localObject3 = null;
    if (i < this.bns)
    {
      Object localObject2 = localObject3;
      int j;
      if (this.bmg[(i * 2)] <= paramLong)
      {
        localObject2 = localObject3;
        if (paramLong < this.bmg[(i * 2 + 1)])
        {
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ArrayList();
          }
          localObject3 = (e)this.bkh.get(i);
          if ((((e)localObject3).bjD == 1.4E-45F) && (((e)localObject3).bjF == 1.4E-45F))
          {
            j = 1;
            label118:
            if (j == 0) {
              break label209;
            }
            if (localObject1 != null) {
              break label149;
            }
            localObject1 = localObject3;
          }
        }
      }
      for (;;)
      {
        i += 1;
        localObject3 = localObject2;
        break;
        j = 0;
        break label118;
        label149:
        if (localSpannableStringBuilder == null)
        {
          localSpannableStringBuilder = new SpannableStringBuilder();
          localSpannableStringBuilder.append(((e)localObject1).LV).append("\n").append(((e)localObject3).LV);
        }
        else
        {
          localSpannableStringBuilder.append("\n").append(((e)localObject3).LV);
          continue;
          label209:
          ((ArrayList)localObject2).add(localObject3);
        }
      }
    }
    if (localSpannableStringBuilder != null) {
      ((ArrayList)localObject3).add(new e(localSpannableStringBuilder));
    }
    while (localObject3 != null)
    {
      AppMethodBeat.o(92920);
      return localObject3;
      if (localObject1 != null) {
        ((ArrayList)localObject3).add(localObject1);
      }
    }
    localObject1 = Collections.emptyList();
    AppMethodBeat.o(92920);
    return localObject1;
  }
  
  public final long eX(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92919);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.bnt.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.bnt[paramInt];
      AppMethodBeat.o(92919);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int ua()
  {
    return this.bnt.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.i
 * JD-Core Version:    0.7.0.1
 */