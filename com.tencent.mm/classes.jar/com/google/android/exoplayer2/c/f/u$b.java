package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class u$b
  implements q
{
  private final l aMm;
  private final SparseArray<v> aMn;
  private final SparseIntArray aMo;
  private final int pid;
  
  public u$b(u paramu, int paramInt)
  {
    AppMethodBeat.i(95168);
    this.aMm = new l(new byte[5]);
    this.aMn = new SparseArray();
    this.aMo = new SparseIntArray();
    this.pid = paramInt;
    AppMethodBeat.o(95168);
  }
  
  public final void a(com.google.android.exoplayer2.i.u paramu, g paramg, v.d paramd) {}
  
  public final void t(m paramm)
  {
    AppMethodBeat.i(95169);
    if (paramm.readUnsignedByte() != 2)
    {
      AppMethodBeat.o(95169);
      return;
    }
    com.google.android.exoplayer2.i.u localu;
    int i1;
    int j;
    int k;
    int m;
    int i2;
    int i3;
    int i4;
    label314:
    int i5;
    long l;
    Object localObject4;
    Object localObject2;
    if ((u.c(this.aMl) == 1) || (u.c(this.aMl) == 2) || (u.d(this.aMl) == 1))
    {
      localu = (com.google.android.exoplayer2.i.u)u.e(this.aMl).get(0);
      paramm.en(2);
      i1 = paramm.readUnsignedShort();
      paramm.en(5);
      paramm.c(this.aMm, 2);
      this.aMm.dE(4);
      paramm.en(this.aMm.dD(12));
      if ((u.c(this.aMl) == 2) && (u.f(this.aMl) == null))
      {
        localObject1 = new v.b(21, null, null, new byte[0]);
        u.a(this.aMl, u.g(this.aMl).a(21, (v.b)localObject1));
        u.f(this.aMl).a(localu, u.h(this.aMl), new v.d(i1, 21, 8192));
      }
      this.aMn.clear();
      this.aMo.clear();
      j = paramm.qM();
      if (j <= 0) {
        break label871;
      }
      paramm.c(this.aMm, 5);
      k = this.aMm.dD(8);
      this.aMm.dE(3);
      m = this.aMm.dD(13);
      this.aMm.dE(4);
      i2 = this.aMm.dD(12);
      i3 = paramm.position;
      i4 = i3 + i2;
      i = -1;
      localObject1 = null;
      localObject3 = null;
      if (paramm.position >= i4) {
        break label685;
      }
      n = paramm.readUnsignedByte();
      i5 = paramm.readUnsignedByte() + paramm.position;
      if (n != 5) {
        break label496;
      }
      l = paramm.cc();
      if (l != u.access$900()) {
        break label441;
      }
      i = 129;
      localObject4 = localObject1;
      localObject2 = localObject3;
    }
    label441:
    label496:
    do
    {
      for (;;)
      {
        paramm.en(i5 - paramm.position);
        localObject3 = localObject2;
        localObject1 = localObject4;
        break label314;
        localu = new com.google.android.exoplayer2.i.u(((com.google.android.exoplayer2.i.u)u.e(this.aMl).get(0)).aJP);
        u.e(this.aMl).add(localu);
        break;
        if (l == u.ov())
        {
          i = 135;
          localObject2 = localObject3;
          localObject4 = localObject1;
        }
        else
        {
          localObject2 = localObject3;
          localObject4 = localObject1;
          if (l == u.ow())
          {
            i = 36;
            localObject2 = localObject3;
            localObject4 = localObject1;
            continue;
            if (n == 106)
            {
              i = 129;
              localObject2 = localObject3;
              localObject4 = localObject1;
            }
            else if (n == 122)
            {
              i = 135;
              localObject2 = localObject3;
              localObject4 = localObject1;
            }
            else if (n == 123)
            {
              i = 138;
              localObject2 = localObject3;
              localObject4 = localObject1;
            }
            else
            {
              if (n != 10) {
                break label586;
              }
              localObject4 = paramm.readString(3).trim();
              localObject2 = localObject3;
            }
          }
        }
      }
      localObject2 = localObject3;
      localObject4 = localObject1;
    } while (n != 89);
    label586:
    int n = 89;
    Object localObject3 = new ArrayList();
    for (;;)
    {
      localObject2 = localObject3;
      localObject4 = localObject1;
      i = n;
      if (paramm.position >= i5) {
        break;
      }
      localObject2 = paramm.readString(3).trim();
      i = paramm.readUnsignedByte();
      localObject4 = new byte[4];
      paramm.readBytes((byte[])localObject4, 0, 4);
      ((List)localObject3).add(new v.a((String)localObject2, i, (byte[])localObject4));
    }
    label685:
    paramm.setPosition(i4);
    Object localObject1 = new v.b(i, (String)localObject1, (List)localObject3, Arrays.copyOfRange(paramm.data, i3, i4));
    if (k == 6) {}
    for (int i = ((v.b)localObject1).streamType;; i = k)
    {
      j -= i2 + 5;
      if (u.c(this.aMl) == 2)
      {
        k = i;
        label750:
        if (u.i(this.aMl).get(k)) {
          break label1134;
        }
        if ((u.c(this.aMl) != 2) || (i != 21)) {
          break label851;
        }
      }
      label851:
      for (localObject1 = u.f(this.aMl);; localObject1 = u.g(this.aMl).a(i, (v.b)localObject1))
      {
        if ((u.c(this.aMl) != 2) || (m < this.aMo.get(k, 8192)))
        {
          this.aMo.put(k, m);
          this.aMn.put(k, localObject1);
        }
        break;
        k = m;
        break label750;
      }
      label871:
      j = this.aMo.size();
      i = 0;
      while (i < j)
      {
        k = this.aMo.keyAt(i);
        u.i(this.aMl).put(k, true);
        paramm = (v)this.aMn.valueAt(i);
        if (paramm != null)
        {
          if (paramm != u.f(this.aMl)) {
            paramm.a(localu, u.h(this.aMl), new v.d(i1, k, 8192));
          }
          u.a(this.aMl).put(this.aMo.valueAt(i), paramm);
        }
        i += 1;
      }
      if (u.c(this.aMl) == 2)
      {
        if (!u.j(this.aMl))
        {
          u.h(this.aMl).nZ();
          u.a(this.aMl, 0);
          u.k(this.aMl);
          AppMethodBeat.o(95169);
        }
      }
      else
      {
        u.a(this.aMl).remove(this.pid);
        paramm = this.aMl;
        if (u.c(this.aMl) != 1) {
          break label1121;
        }
      }
      label1121:
      for (i = 0;; i = u.d(this.aMl) - 1)
      {
        u.a(paramm, i);
        if (u.d(this.aMl) == 0)
        {
          u.h(this.aMl).nZ();
          u.k(this.aMl);
        }
        AppMethodBeat.o(95169);
        return;
      }
      label1134:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.u.b
 * JD-Core Version:    0.7.0.1
 */