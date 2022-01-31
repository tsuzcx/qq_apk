package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i
  implements d
{
  private final List<e> aMM;
  private final long[] aON;
  private final int aQe;
  private final long[] aQf;
  
  public i(List<e> paramList)
  {
    this.aMM = paramList;
    this.aQe = paramList.size();
    this.aON = new long[this.aQe * 2];
    int i = 0;
    while (i < this.aQe)
    {
      e locale = (e)paramList.get(i);
      int j = i * 2;
      this.aON[j] = locale.startTime;
      this.aON[(j + 1)] = locale.endTime;
      i += 1;
    }
    this.aQf = Arrays.copyOf(this.aON, this.aON.length);
    Arrays.sort(this.aQf);
  }
  
  public final int S(long paramLong)
  {
    int i = t.a(this.aQf, paramLong);
    if (i < this.aQf.length) {
      return i;
    }
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> T(long paramLong)
  {
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = null;
    Object localObject1 = null;
    Object localObject3 = null;
    if (i < this.aQe)
    {
      Object localObject2 = localObject3;
      int j;
      if (this.aON[(i * 2)] <= paramLong)
      {
        localObject2 = localObject3;
        if (paramLong < this.aON[(i * 2 + 1)])
        {
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ArrayList();
          }
          localObject3 = (e)this.aMM.get(i);
          if ((((e)localObject3).aMj == 1.4E-45F) && (((e)localObject3).aMl == 1.4E-45F))
          {
            j = 1;
            label113:
            if (j == 0) {
              break label204;
            }
            if (localObject1 != null) {
              break label144;
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
        break label113;
        label144:
        if (localSpannableStringBuilder == null)
        {
          localSpannableStringBuilder = new SpannableStringBuilder();
          localSpannableStringBuilder.append(localObject1.text).append("\n").append(((e)localObject3).text);
        }
        else
        {
          localSpannableStringBuilder.append("\n").append(((e)localObject3).text);
          continue;
          label204:
          ((ArrayList)localObject2).add(localObject3);
        }
      }
    }
    if (localSpannableStringBuilder != null) {
      ((ArrayList)localObject3).add(new e(localSpannableStringBuilder));
    }
    while (localObject3 != null)
    {
      return localObject3;
      if (localObject1 != null) {
        ((ArrayList)localObject3).add(localObject1);
      }
    }
    return Collections.emptyList();
  }
  
  public final long dn(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.aB(bool1);
      if (paramInt >= this.aQf.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.aB(bool1);
      return this.aQf[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public final int nk()
  {
    return this.aQf.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.i
 * JD-Core Version:    0.7.0.1
 */