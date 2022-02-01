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
  private final List<e> bqi;
  private final long[] bsj;
  private final int btA;
  private final long[] btB;
  
  public i(List<e> paramList)
  {
    AppMethodBeat.i(92917);
    this.bqi = paramList;
    this.btA = paramList.size();
    this.bsj = new long[this.btA * 2];
    int i = 0;
    while (i < this.btA)
    {
      e locale = (e)paramList.get(i);
      int j = i * 2;
      this.bsj[j] = locale.startTime;
      this.bsj[(j + 1)] = locale.endTime;
      i += 1;
    }
    this.btB = Arrays.copyOf(this.bsj, this.bsj.length);
    Arrays.sort(this.btB);
    AppMethodBeat.o(92917);
  }
  
  public final int ai(long paramLong)
  {
    AppMethodBeat.i(92918);
    int i = x.a(this.btB, paramLong, false, false);
    if (i < this.btB.length)
    {
      AppMethodBeat.o(92918);
      return i;
    }
    AppMethodBeat.o(92918);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> aj(long paramLong)
  {
    AppMethodBeat.i(92920);
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = null;
    Object localObject1 = null;
    Object localObject3 = null;
    if (i < this.btA)
    {
      Object localObject2 = localObject3;
      int j;
      if (this.bsj[(i * 2)] <= paramLong)
      {
        localObject2 = localObject3;
        if (paramLong < this.bsj[(i * 2 + 1)])
        {
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ArrayList();
          }
          localObject3 = (e)this.bqi.get(i);
          if ((((e)localObject3).bpF == 1.4E-45F) && (((e)localObject3).bpH == 1.4E-45F))
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
  
  public final long eE(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92919);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.btB.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.btB[paramInt];
      AppMethodBeat.o(92919);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int uw()
  {
    return this.btB.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.i
 * JD-Core Version:    0.7.0.1
 */