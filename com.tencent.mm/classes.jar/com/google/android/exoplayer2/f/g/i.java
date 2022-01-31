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
  private final List<e> aUg;
  private final long[] aWh;
  private final int aXy;
  private final long[] aXz;
  
  public i(List<e> paramList)
  {
    AppMethodBeat.i(95749);
    this.aUg = paramList;
    this.aXy = paramList.size();
    this.aWh = new long[this.aXy * 2];
    int i = 0;
    while (i < this.aXy)
    {
      e locale = (e)paramList.get(i);
      int j = i * 2;
      this.aWh[j] = locale.startTime;
      this.aWh[(j + 1)] = locale.endTime;
      i += 1;
    }
    this.aXz = Arrays.copyOf(this.aWh, this.aWh.length);
    Arrays.sort(this.aXz);
    AppMethodBeat.o(95749);
  }
  
  public final int ab(long paramLong)
  {
    AppMethodBeat.i(95750);
    int i = x.a(this.aXz, paramLong, false, false);
    if (i < this.aXz.length)
    {
      AppMethodBeat.o(95750);
      return i;
    }
    AppMethodBeat.o(95750);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> ac(long paramLong)
  {
    AppMethodBeat.i(95752);
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = null;
    Object localObject1 = null;
    Object localObject3 = null;
    if (i < this.aXy)
    {
      Object localObject2 = localObject3;
      int j;
      if (this.aWh[(i * 2)] <= paramLong)
      {
        localObject2 = localObject3;
        if (paramLong < this.aWh[(i * 2 + 1)])
        {
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ArrayList();
          }
          localObject3 = (e)this.aUg.get(i);
          if ((((e)localObject3).aTD == 1.4E-45F) && (((e)localObject3).aTF == 1.4E-45F))
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
          localSpannableStringBuilder.append(((e)localObject1).text).append("\n").append(((e)localObject3).text);
        }
        else
        {
          localSpannableStringBuilder.append("\n").append(((e)localObject3).text);
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
      AppMethodBeat.o(95752);
      return localObject3;
      if (localObject1 != null) {
        ((ArrayList)localObject3).add(localObject1);
      }
    }
    localObject1 = Collections.emptyList();
    AppMethodBeat.o(95752);
    return localObject1;
  }
  
  public final long dT(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(95751);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.aXz.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.aXz[paramInt];
      AppMethodBeat.o(95751);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int pH()
  {
    return this.aXz.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.i
 * JD-Core Version:    0.7.0.1
 */