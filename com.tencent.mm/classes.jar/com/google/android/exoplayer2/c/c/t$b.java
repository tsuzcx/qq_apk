package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class t$b
  implements p
{
  private final SparseIntArray aFA = new SparseIntArray();
  private final i aFy = new i(new byte[5]);
  private final SparseArray<u> aFz = new SparseArray();
  private final int pid;
  
  public t$b(t paramt, int paramInt)
  {
    this.pid = paramInt;
  }
  
  public final void a(q paramq, f paramf, u.d paramd) {}
  
  public final void b(j paramj)
  {
    if (paramj.readUnsignedByte() != 2) {
      return;
    }
    q localq;
    int i1;
    int j;
    label221:
    int k;
    int m;
    int i2;
    int i3;
    int i4;
    label304:
    int i5;
    long l;
    Object localObject4;
    Object localObject2;
    if ((t.c(this.aFx) == 1) || (t.c(this.aFx) == 2) || (t.d(this.aFx) == 1))
    {
      localq = (q)t.e(this.aFx).get(0);
      paramj.dB(2);
      i1 = paramj.readUnsignedShort();
      paramj.dB(5);
      paramj.c(this.aFy, 2);
      this.aFy.dy(4);
      paramj.dB(this.aFy.dz(12));
      if ((t.c(this.aFx) == 2) && (t.f(this.aFx) == null))
      {
        localObject1 = new u.b(21, null, null, new byte[0]);
        t.a(this.aFx, t.g(this.aFx).a(21, (u.b)localObject1));
        t.f(this.aFx).a(localq, t.h(this.aFx), new u.d(i1, 21, 8192));
      }
      this.aFz.clear();
      this.aFA.clear();
      j = paramj.oe();
      if (j <= 0) {
        break label861;
      }
      paramj.c(this.aFy, 5);
      k = this.aFy.dz(8);
      this.aFy.dy(3);
      m = this.aFy.dz(13);
      this.aFy.dy(4);
      i2 = this.aFy.dz(12);
      i3 = paramj.position;
      i4 = i3 + i2;
      i = -1;
      localObject1 = null;
      localObject3 = null;
      if (paramj.position >= i4) {
        break label675;
      }
      n = paramj.readUnsignedByte();
      i5 = paramj.readUnsignedByte() + paramj.position;
      if (n != 5) {
        break label486;
      }
      l = paramj.bp();
      if (l != t.md()) {
        break label431;
      }
      i = 129;
      localObject4 = localObject1;
      localObject2 = localObject3;
    }
    label431:
    label486:
    do
    {
      for (;;)
      {
        paramj.dB(i5 - paramj.position);
        localObject3 = localObject2;
        localObject1 = localObject4;
        break label304;
        localq = new q(((q)t.e(this.aFx).get(0)).aDd);
        t.e(this.aFx).add(localq);
        break;
        if (l == t.me())
        {
          i = 135;
          localObject2 = localObject3;
          localObject4 = localObject1;
        }
        else
        {
          localObject2 = localObject3;
          localObject4 = localObject1;
          if (l == t.mf())
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
                break label576;
              }
              localObject4 = paramj.readString(3).trim();
              localObject2 = localObject3;
            }
          }
        }
      }
      localObject2 = localObject3;
      localObject4 = localObject1;
    } while (n != 89);
    label576:
    int n = 89;
    Object localObject3 = new ArrayList();
    for (;;)
    {
      localObject2 = localObject3;
      localObject4 = localObject1;
      i = n;
      if (paramj.position >= i5) {
        break;
      }
      localObject2 = paramj.readString(3).trim();
      i = paramj.readUnsignedByte();
      localObject4 = new byte[4];
      paramj.readBytes((byte[])localObject4, 0, 4);
      ((List)localObject3).add(new u.a((String)localObject2, i, (byte[])localObject4));
    }
    label675:
    paramj.setPosition(i4);
    Object localObject1 = new u.b(i, (String)localObject1, (List)localObject3, Arrays.copyOfRange(paramj.data, i3, i4));
    if (k == 6) {}
    for (int i = ((u.b)localObject1).streamType;; i = k)
    {
      j -= i2 + 5;
      if (t.c(this.aFx) == 2)
      {
        k = i;
        label740:
        if (t.i(this.aFx).get(k)) {
          break label1114;
        }
        if ((t.c(this.aFx) != 2) || (i != 21)) {
          break label841;
        }
      }
      label841:
      for (localObject1 = t.f(this.aFx);; localObject1 = t.g(this.aFx).a(i, (u.b)localObject1))
      {
        if ((t.c(this.aFx) != 2) || (m < this.aFA.get(k, 8192)))
        {
          this.aFA.put(k, m);
          this.aFz.put(k, localObject1);
        }
        break;
        k = m;
        break label740;
      }
      label861:
      j = this.aFA.size();
      i = 0;
      while (i < j)
      {
        k = this.aFA.keyAt(i);
        t.i(this.aFx).put(k, true);
        paramj = (u)this.aFz.valueAt(i);
        if (paramj != null)
        {
          if (paramj != t.f(this.aFx)) {
            paramj.a(localq, t.h(this.aFx), new u.d(i1, k, 8192));
          }
          t.a(this.aFx).put(this.aFA.valueAt(i), paramj);
        }
        i += 1;
      }
      if (t.c(this.aFx) == 2)
      {
        if (t.j(this.aFx)) {
          break;
        }
        t.h(this.aFx).lV();
        t.a(this.aFx, 0);
        t.k(this.aFx);
        return;
      }
      t.a(this.aFx).remove(this.pid);
      paramj = this.aFx;
      if (t.c(this.aFx) == 1) {}
      for (i = 0;; i = t.d(this.aFx) - 1)
      {
        t.a(paramj, i);
        if (t.d(this.aFx) != 0) {
          break;
        }
        t.h(this.aFx).lV();
        t.k(this.aFx);
        return;
      }
      label1114:
      break label221;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.t.b
 * JD-Core Version:    0.7.0.1
 */