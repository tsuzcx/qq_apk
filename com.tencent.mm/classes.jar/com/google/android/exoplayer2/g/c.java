package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class c
  extends e
{
  private static final int[] bEe = new int[0];
  private final f.a bEf;
  private final AtomicReference<b> bEg;
  
  public c()
  {
    this(null);
  }
  
  public c(f.a parama)
  {
    AppMethodBeat.i(92933);
    this.bEf = parama;
    this.bEg = new AtomicReference(new b());
    AppMethodBeat.o(92933);
  }
  
  private static int a(o paramo, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    AppMethodBeat.i(92935);
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      int k = ((Integer)paramList.get(j)).intValue();
      if (!a(paramo.bwC[k], paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4)) {
        break label88;
      }
      i += 1;
    }
    label88:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(92935);
      return i;
    }
  }
  
  private static int a(o paramo, int[] paramArrayOfInt, c.a parama)
  {
    AppMethodBeat.i(92940);
    int j = 0;
    int i = 0;
    if (j < paramo.length)
    {
      if (!a(paramo.bwC[j], paramArrayOfInt[j], parama)) {
        break label57;
      }
      i += 1;
    }
    label57:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(92940);
      return i;
    }
  }
  
  private static Point a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    AppMethodBeat.i(92946);
    int i;
    if (paramBoolean) {
      if (paramInt3 > paramInt4)
      {
        i = 1;
        if (paramInt1 <= paramInt2) {
          break label75;
        }
        label26:
        if (i == j) {
          break label107;
        }
      }
    }
    for (;;)
    {
      if (paramInt3 * paramInt1 >= paramInt4 * paramInt2)
      {
        localPoint = new Point(paramInt2, x.bo(paramInt2 * paramInt4, paramInt3));
        AppMethodBeat.o(92946);
        return localPoint;
        i = 0;
        break;
        label75:
        j = 0;
        break label26;
      }
      Point localPoint = new Point(x.bo(paramInt1 * paramInt3, paramInt4), paramInt1);
      AppMethodBeat.o(92946);
      return localPoint;
      label107:
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  private static f a(p paramp, int[][] paramArrayOfInt, b paramb)
  {
    AppMethodBeat.i(92938);
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int i2 = -1;
    int i3 = -1;
    int m = 0;
    while (m < paramp.length)
    {
      o localo = paramp.bxh[m];
      List localList = a(localo, paramb.viewportWidth, paramb.viewportHeight, paramb.bEn);
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < localo.length)
      {
        int i8 = i3;
        int i7 = i2;
        int i6 = i1;
        int i5 = n;
        Object localObject2 = localObject1;
        Format localFormat;
        int i4;
        label205:
        int i;
        label244:
        int k;
        if (o(arrayOfInt[j], paramb.bEq))
        {
          localFormat = localo.bwC[j];
          if ((!localList.contains(Integer.valueOf(j))) || ((localFormat.width != -1) && (localFormat.width > paramb.bEj)) || ((localFormat.height != -1) && (localFormat.height > paramb.bEk)) || ((localFormat.bitrate != -1) && (localFormat.bitrate > paramb.bEl))) {
            break label402;
          }
          i4 = 1;
          if (i4 == 0)
          {
            i8 = i3;
            i7 = i2;
            i6 = i1;
            i5 = n;
            localObject2 = localObject1;
            if (!paramb.bEm) {}
          }
          else
          {
            if (i4 == 0) {
              break label408;
            }
            i = 2;
            boolean bool = o(arrayOfInt[j], false);
            k = i;
            if (bool) {
              k = i + 1000;
            }
            if (k <= i1) {
              break label413;
            }
            i = 1;
            label279:
            if (k == i1)
            {
              if (localFormat.tq() == i3) {
                break label418;
              }
              i = bm(localFormat.tq(), i3);
              label307:
              if ((!bool) || (i4 == 0)) {
                break label437;
              }
              if (i <= 0) {
                break label432;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          i8 = i3;
          i7 = i2;
          i6 = i1;
          i5 = n;
          localObject2 = localObject1;
          if (i != 0)
          {
            i7 = localFormat.bitrate;
            i8 = localFormat.tq();
            i5 = j;
            localObject2 = localo;
            i6 = k;
          }
          j += 1;
          i3 = i8;
          i2 = i7;
          i1 = i6;
          n = i5;
          localObject1 = localObject2;
          break;
          label402:
          i4 = 0;
          break label205;
          label408:
          i = 1;
          break label244;
          label413:
          i = 0;
          break label279;
          label418:
          i = bm(localFormat.bitrate, i2);
          break label307;
          label432:
          i = 0;
          continue;
          label437:
          if (i < 0) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      m += 1;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(92938);
      return null;
    }
    paramp = new d(localObject1, n);
    AppMethodBeat.o(92938);
    return paramp;
  }
  
  private static f a(p paramp, int[][] paramArrayOfInt, b paramb, f.a parama)
  {
    AppMethodBeat.i(92939);
    int n = -1;
    int m = -1;
    int i2 = 0;
    int j = 0;
    int[] arrayOfInt;
    int k;
    int i;
    while (j < paramp.length)
    {
      localo = paramp.bxh[j];
      arrayOfInt = paramArrayOfInt[j];
      k = 0;
      int i1 = m;
      if (k < localo.length)
      {
        int i4 = i2;
        int i3 = i1;
        i = n;
        if (o(arrayOfInt[k], paramb.bEq))
        {
          Format localFormat = localo.bwC[k];
          i3 = arrayOfInt[k];
          String str = paramb.bEh;
          if ((localFormat.bdG & 0x1) == 0) {
            break label212;
          }
          i = 1;
          label121:
          if (!a(localFormat, str)) {
            break label224;
          }
          if (i == 0) {
            break label218;
          }
          i = 4;
        }
        for (;;)
        {
          m = i;
          if (o(i3, false)) {
            m = i + 1000;
          }
          i4 = i2;
          i3 = i1;
          i = n;
          if (m > i2)
          {
            i3 = k;
            i = j;
            i4 = m;
          }
          k += 1;
          i2 = i4;
          i1 = i3;
          n = i;
          break;
          label212:
          i = 0;
          break label121;
          label218:
          i = 3;
          continue;
          label224:
          if (i != 0) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
      j += 1;
      m = i1;
    }
    if (n == -1)
    {
      AppMethodBeat.o(92939);
      return null;
    }
    o localo = paramp.bxh[n];
    if (parama != null)
    {
      arrayOfInt = paramArrayOfInt[n];
      boolean bool = paramb.bEo;
      i = 0;
      paramp = null;
      paramb = new HashSet();
      j = 0;
      if (j < localo.length)
      {
        paramArrayOfInt = localo.bwC[j];
        k = paramArrayOfInt.channelCount;
        n = paramArrayOfInt.sampleRate;
        if (bool)
        {
          paramArrayOfInt = null;
          label346:
          paramArrayOfInt = new c.a(k, n, paramArrayOfInt);
          if (!paramb.add(paramArrayOfInt)) {
            break label533;
          }
          k = a(localo, arrayOfInt, paramArrayOfInt);
          if (k <= i) {
            break label533;
          }
          i = k;
          paramp = paramArrayOfInt;
        }
      }
    }
    label533:
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfInt = paramArrayOfInt.bdt;
      break label346;
      if (i > 1)
      {
        paramArrayOfInt = new int[i];
        j = 0;
        i = 0;
        while (i < localo.length)
        {
          k = j;
          if (a(localo.bwC[i], arrayOfInt[i], paramp))
          {
            paramArrayOfInt[j] = i;
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      for (paramp = paramArrayOfInt; paramp.length > 0; paramp = bEe)
      {
        paramp = parama.a(localo, paramp);
        AppMethodBeat.o(92939);
        return paramp;
      }
      paramp = new d(localo, m);
      AppMethodBeat.o(92939);
      return paramp;
    }
  }
  
  private static List<Integer> a(o paramo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92945);
    ArrayList localArrayList = new ArrayList(paramo.length);
    int i = 0;
    while (i < paramo.length)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    if ((paramInt1 == 2147483647) || (paramInt2 == 2147483647))
    {
      AppMethodBeat.o(92945);
      return localArrayList;
    }
    i = 2147483647;
    if (j < paramo.length)
    {
      Format localFormat = paramo.bwC[j];
      if ((localFormat.width <= 0) || (localFormat.height <= 0)) {
        break label273;
      }
      Point localPoint = a(paramBoolean, paramInt1, paramInt2, localFormat.width, localFormat.height);
      int k = localFormat.width * localFormat.height;
      if ((localFormat.width < (int)(localPoint.x * 0.98F)) || (localFormat.height < (int)(localPoint.y * 0.98F)) || (k >= i)) {
        break label273;
      }
      i = k;
    }
    label273:
    for (;;)
    {
      j += 1;
      break;
      if (i != 2147483647)
      {
        paramInt1 = localArrayList.size() - 1;
        while (paramInt1 >= 0)
        {
          paramInt2 = ((Integer)localArrayList.get(paramInt1)).intValue();
          paramInt2 = paramo.bwC[paramInt2].tq();
          if ((paramInt2 == -1) || (paramInt2 > i)) {
            localArrayList.remove(paramInt1);
          }
          paramInt1 -= 1;
        }
      }
      AppMethodBeat.o(92945);
      return localArrayList;
    }
  }
  
  private static boolean a(Format paramFormat, int paramInt, c.a parama)
  {
    AppMethodBeat.i(92941);
    if ((o(paramInt, false)) && (paramFormat.channelCount == parama.channelCount) && (paramFormat.sampleRate == parama.sampleRate) && ((parama.mimeType == null) || (TextUtils.equals(parama.mimeType, paramFormat.bdt))))
    {
      AppMethodBeat.o(92941);
      return true;
    }
    AppMethodBeat.o(92941);
    return false;
  }
  
  private static boolean a(Format paramFormat, String paramString)
  {
    AppMethodBeat.i(92944);
    if ((paramString != null) && (TextUtils.equals(paramString, x.bF(paramFormat.language))))
    {
      AppMethodBeat.o(92944);
      return true;
    }
    AppMethodBeat.o(92944);
    return false;
  }
  
  private static boolean a(Format paramFormat, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(92937);
    if ((o(paramInt1, false)) && ((paramInt1 & paramInt2) != 0) && ((paramString == null) || (x.i(paramFormat.bdt, paramString))) && ((paramFormat.width == -1) || (paramFormat.width <= paramInt3)) && ((paramFormat.height == -1) || (paramFormat.height <= paramInt4)) && ((paramFormat.bitrate == -1) || (paramFormat.bitrate <= paramInt5)))
    {
      AppMethodBeat.o(92937);
      return true;
    }
    AppMethodBeat.o(92937);
    return false;
  }
  
  private static f b(p paramp, int[][] paramArrayOfInt, b paramb)
  {
    AppMethodBeat.i(92942);
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int m = 0;
    while (m < paramp.length)
    {
      o localo = paramp.bxh[m];
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < localo.length)
      {
        int i2 = i1;
        int i = n;
        Object localObject2 = localObject1;
        Format localFormat;
        label102:
        int k;
        if (o(arrayOfInt[j], paramb.bEq))
        {
          localFormat = localo.bwC[j];
          if ((localFormat.bdG & 0x1) == 0) {
            break label205;
          }
          i = 1;
          if ((localFormat.bdG & 0x2) == 0) {
            break label210;
          }
          k = 1;
          label115:
          if (!a(localFormat, paramb.bEi)) {
            break label231;
          }
          if (i == 0) {
            break label216;
          }
          i = 6;
        }
        for (;;)
        {
          label134:
          k = i;
          if (o(arrayOfInt[j], false)) {
            k = i + 1000;
          }
          i2 = i1;
          i = n;
          localObject2 = localObject1;
          if (k > i1)
          {
            i = j;
            localObject2 = localo;
            i2 = k;
          }
          label205:
          label210:
          label216:
          label231:
          do
          {
            j += 1;
            i1 = i2;
            n = i;
            localObject1 = localObject2;
            break;
            i = 0;
            break label102;
            k = 0;
            break label115;
            if (k == 0)
            {
              i = 5;
              break label134;
            }
            i = 4;
            break label134;
            if (i != 0)
            {
              i = 3;
              break label134;
            }
            i2 = i1;
            i = n;
            localObject2 = localObject1;
          } while (k == 0);
          if (a(localFormat, paramb.bEh)) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
      m += 1;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(92942);
      return null;
    }
    paramp = new d(localObject1, n);
    AppMethodBeat.o(92942);
    return paramp;
  }
  
  private static void b(o paramo, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    AppMethodBeat.i(92936);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!a(paramo.bwC[j], paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4)) {
        paramList.remove(i);
      }
      i -= 1;
    }
    AppMethodBeat.o(92936);
  }
  
  private static int bm(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == -1)
    {
      paramInt1 = i;
      if (paramInt2 == -1) {
        paramInt1 = 0;
      }
      return paramInt1;
    }
    if (paramInt2 == -1) {
      return 1;
    }
    return paramInt1 - paramInt2;
  }
  
  private static f c(p paramp, int[][] paramArrayOfInt, b paramb)
  {
    AppMethodBeat.i(92943);
    int n = 0;
    int j = 0;
    int i1 = 0;
    Object localObject = null;
    int i;
    label44:
    int k;
    label85:
    int m;
    if (n < paramp.length)
    {
      o localo = paramp.bxh[n];
      int[] arrayOfInt = paramArrayOfInt[n];
      i = 0;
      if (i < localo.length)
      {
        if (!o(arrayOfInt[i], paramb.bEq)) {
          break label195;
        }
        if ((localo.bwC[i].bdG & 0x1) != 0)
        {
          k = 1;
          if (k == 0) {
            break label147;
          }
          m = 2;
          label93:
          k = m;
          if (o(arrayOfInt[i], false)) {
            k = m + 1000;
          }
          if (k <= j) {
            break label195;
          }
          i1 = i;
          localObject = localo;
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label44;
      k = 0;
      break label85;
      label147:
      m = 1;
      break label93;
      n += 1;
      break;
      if (localObject == null)
      {
        AppMethodBeat.o(92943);
        return null;
      }
      paramp = new d(localObject, i1);
      AppMethodBeat.o(92943);
      return paramp;
      label195:
      k = j;
    }
  }
  
  private static boolean o(int paramInt, boolean paramBoolean)
  {
    paramInt &= 0x7;
    return (paramInt == 4) || ((paramBoolean) && (paramInt == 3));
  }
  
  protected final f[] a(s[] paramArrayOfs, p[] paramArrayOfp, int[][][] paramArrayOfInt)
  {
    AppMethodBeat.i(92934);
    int i4 = paramArrayOfs.length;
    f[] arrayOff = new f[i4];
    b localb = (b)this.bEg.get();
    int j = 0;
    int k = 0;
    int m = 0;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label111:
    int n;
    label135:
    int i1;
    o localo;
    int[] arrayOfInt1;
    int i5;
    int i6;
    int i7;
    int i2;
    boolean bool;
    if (m < i4)
    {
      if (2 != paramArrayOfs[m].getTrackType()) {
        break label814;
      }
      i = k;
      if (k == 0)
      {
        localObject2 = paramArrayOfs[m];
        localObject3 = paramArrayOfp[m];
        int[][] arrayOfInt = paramArrayOfInt[m];
        f.a locala = this.bEf;
        localObject1 = null;
        if (locala != null)
        {
          if (localb.bEp)
          {
            k = 24;
            if ((!localb.bEo) || ((((s)localObject2).sY() & k) == 0)) {
              break label318;
            }
            n = 1;
            i1 = 0;
            if (i1 >= ((p)localObject3).length) {
              break label533;
            }
            localo = localObject3.bxh[i1];
            arrayOfInt1 = arrayOfInt[i1];
            i5 = localb.bEj;
            i6 = localb.bEk;
            i7 = localb.bEl;
            i = localb.viewportWidth;
            i2 = localb.viewportHeight;
            bool = localb.bEn;
            if (localo.length >= 2) {
              break label324;
            }
            localObject1 = bEe;
            label221:
            if (localObject1.length <= 0) {
              break label524;
            }
            localObject1 = locala.a(localo, (int[])localObject1);
          }
        }
        else
        {
          label240:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a((p)localObject3, arrayOfInt, localb);
          }
          arrayOff[m] = localObject2;
          if (arrayOff[m] == null) {
            break label539;
          }
          i = 1;
        }
      }
      else
      {
        label278:
        if (paramArrayOfp[m].length <= 0) {
          break label545;
        }
        k = 1;
        label291:
        j = k | j;
      }
    }
    for (;;)
    {
      m += 1;
      k = i;
      break;
      k = 16;
      break label111;
      label318:
      n = 0;
      break label135;
      label324:
      List localList = a(localo, i, i2, bool);
      if (localList.size() < 2)
      {
        localObject1 = bEe;
        break label221;
      }
      localObject1 = null;
      if (n == 0)
      {
        HashSet localHashSet = new HashSet();
        i = 0;
        i2 = 0;
        while (i2 < localList.size())
        {
          int i3 = ((Integer)localList.get(i2)).intValue();
          localObject2 = localo.bwC[i3].bdt;
          if (!localHashSet.add(localObject2)) {
            break label805;
          }
          i3 = a(localo, arrayOfInt1, k, (String)localObject2, i5, i6, i7, localList);
          if (i3 <= i) {
            break label805;
          }
          i = i3;
          localObject1 = localObject2;
          label467:
          i2 += 1;
        }
      }
      for (;;)
      {
        b(localo, arrayOfInt1, k, (String)localObject1, i5, i6, i7, localList);
        if (localList.size() < 2)
        {
          localObject1 = bEe;
          break label221;
        }
        localObject1 = x.y(localList);
        break label221;
        label524:
        i1 += 1;
        break;
        label533:
        localObject1 = null;
        break label240;
        label539:
        i = 0;
        break label278;
        label545:
        k = 0;
        break label291;
        n = 0;
        m = 0;
        k = 0;
        if (k < i4)
        {
          i = n;
          i1 = m;
          switch (paramArrayOfs[k].getTrackType())
          {
          default: 
            arrayOff[k] = c(paramArrayOfp[k], paramArrayOfInt[k], localb);
            i1 = m;
            i = n;
          }
          label688:
          label731:
          do
          {
            do
            {
              k += 1;
              n = i;
              m = i1;
              break;
              i = n;
              i1 = m;
            } while (n != 0);
            localObject2 = paramArrayOfp[k];
            localObject3 = paramArrayOfInt[k];
            if (j != 0)
            {
              localObject1 = null;
              arrayOff[k] = a((p)localObject2, (int[][])localObject3, localb, (f.a)localObject1);
              if (arrayOff[k] == null) {
                break label731;
              }
            }
            for (i = 1;; i = 0)
            {
              i1 = m;
              break;
              localObject1 = this.bEf;
              break label688;
            }
            i = n;
            i1 = m;
          } while (m != 0);
          arrayOff[k] = b(paramArrayOfp[k], paramArrayOfInt[k], localb);
          if (arrayOff[k] != null) {}
          for (i = 1;; i = 0)
          {
            i1 = i;
            i = n;
            break;
          }
        }
        AppMethodBeat.o(92934);
        return arrayOff;
        label805:
        break label467;
        localObject1 = null;
      }
      label814:
      i = k;
    }
  }
  
  public static final class b
  {
    public final String bEh = null;
    public final String bEi = null;
    public final int bEj = 2147483647;
    public final int bEk = 2147483647;
    public final int bEl = 2147483647;
    public final boolean bEm = true;
    public final boolean bEn = true;
    public final boolean bEo = false;
    public final boolean bEp = true;
    public final boolean bEq = true;
    public final int viewportHeight = 2147483647;
    public final int viewportWidth = 2147483647;
    
    public b()
    {
      this((byte)0);
    }
    
    private b(byte paramByte) {}
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(92931);
      if (this == paramObject)
      {
        AppMethodBeat.o(92931);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(92931);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.bEo == paramObject.bEo) && (this.bEp == paramObject.bEp) && (this.bEj == paramObject.bEj) && (this.bEk == paramObject.bEk) && (this.bEm == paramObject.bEm) && (this.bEq == paramObject.bEq) && (this.bEn == paramObject.bEn) && (this.viewportWidth == paramObject.viewportWidth) && (this.viewportHeight == paramObject.viewportHeight) && (this.bEl == paramObject.bEl) && (TextUtils.equals(this.bEh, paramObject.bEh)) && (TextUtils.equals(this.bEi, paramObject.bEi)))
      {
        AppMethodBeat.o(92931);
        return true;
      }
      AppMethodBeat.o(92931);
      return false;
    }
    
    public final int hashCode()
    {
      int n = 1;
      AppMethodBeat.i(92932);
      int i1 = this.bEh.hashCode();
      int i2 = this.bEi.hashCode();
      int i;
      int j;
      label44:
      int i3;
      int i4;
      int i5;
      int k;
      label71:
      int m;
      if (this.bEo)
      {
        i = 1;
        if (!this.bEp) {
          break label176;
        }
        j = 1;
        i3 = this.bEj;
        i4 = this.bEk;
        i5 = this.bEl;
        if (!this.bEm) {
          break label181;
        }
        k = 1;
        if (!this.bEq) {
          break label186;
        }
        m = 1;
        label81:
        if (!this.bEn) {
          break label192;
        }
      }
      for (;;)
      {
        int i6 = this.viewportWidth;
        int i7 = this.viewportHeight;
        AppMethodBeat.o(92932);
        return (((m + (k + ((((j + (i + (i1 * 31 + i2) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + n) * 31 + i6) * 31 + i7;
        i = 0;
        break;
        label176:
        j = 0;
        break label44;
        label181:
        k = 0;
        break label71;
        label186:
        m = 0;
        break label81;
        label192:
        n = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.c
 * JD-Core Version:    0.7.0.1
 */