package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class c
  extends e
{
  private static final int[] bEg = new int[0];
  private final f.a bEh;
  private final AtomicReference<b> bEi;
  
  public c()
  {
    this(null);
  }
  
  public c(f.a parama)
  {
    AppMethodBeat.i(92933);
    this.bEh = parama;
    this.bEi = new AtomicReference(new b());
    AppMethodBeat.o(92933);
  }
  
  private static int a(q paramq, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    AppMethodBeat.i(92935);
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      int k = ((Integer)paramList.get(j)).intValue();
      if (!a(paramq.bwD[k], paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4)) {
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
  
  private static int a(q paramq, int[] paramArrayOfInt, c.a parama)
  {
    AppMethodBeat.i(92940);
    int j = 0;
    int i = 0;
    if (j < paramq.length)
    {
      if (!a(paramq.bwD[j], paramArrayOfInt[j], parama)) {
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
        localPoint = new Point(paramInt2, x.bi(paramInt2 * paramInt4, paramInt3));
        AppMethodBeat.o(92946);
        return localPoint;
        i = 0;
        break;
        label75:
        j = 0;
        break label26;
      }
      Point localPoint = new Point(x.bi(paramInt1 * paramInt3, paramInt4), paramInt1);
      AppMethodBeat.o(92946);
      return localPoint;
      label107:
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  private static f a(r paramr, int[][] paramArrayOfInt, b paramb)
  {
    AppMethodBeat.i(92938);
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int i2 = -1;
    int i3 = -1;
    int m = 0;
    while (m < paramr.length)
    {
      q localq = paramr.bxi[m];
      List localList = a(localq, paramb.viewportWidth, paramb.viewportHeight, paramb.bEp);
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < localq.length)
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
        if (q(arrayOfInt[j], paramb.bEs))
        {
          localFormat = localq.bwD[j];
          if ((!localList.contains(Integer.valueOf(j))) || ((localFormat.width != -1) && (localFormat.width > paramb.bEl)) || ((localFormat.height != -1) && (localFormat.height > paramb.bEm)) || ((localFormat.bitrate != -1) && (localFormat.bitrate > paramb.bEn))) {
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
            if (!paramb.bEo) {}
          }
          else
          {
            if (i4 == 0) {
              break label408;
            }
            i = 2;
            boolean bool = q(arrayOfInt[j], false);
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
              if (localFormat.tv() == i3) {
                break label418;
              }
              i = bg(localFormat.tv(), i3);
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
            i8 = localFormat.tv();
            i5 = j;
            localObject2 = localq;
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
          i = bg(localFormat.bitrate, i2);
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
    paramr = new d(localObject1, n);
    AppMethodBeat.o(92938);
    return paramr;
  }
  
  private static f a(r paramr, int[][] paramArrayOfInt, b paramb, f.a parama)
  {
    AppMethodBeat.i(92939);
    int n = -1;
    int m = -1;
    int i2 = 0;
    int j = 0;
    int[] arrayOfInt;
    int k;
    int i;
    while (j < paramr.length)
    {
      localq = paramr.bxi[j];
      arrayOfInt = paramArrayOfInt[j];
      k = 0;
      int i1 = m;
      if (k < localq.length)
      {
        int i4 = i2;
        int i3 = i1;
        i = n;
        if (q(arrayOfInt[k], paramb.bEs))
        {
          Format localFormat = localq.bwD[k];
          i3 = arrayOfInt[k];
          String str = paramb.bEj;
          if ((localFormat.bdD & 0x1) == 0) {
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
          if (q(i3, false)) {
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
    q localq = paramr.bxi[n];
    if (parama != null)
    {
      arrayOfInt = paramArrayOfInt[n];
      boolean bool = paramb.bEq;
      i = 0;
      paramr = null;
      paramb = new HashSet();
      j = 0;
      if (j < localq.length)
      {
        paramArrayOfInt = localq.bwD[j];
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
          k = a(localq, arrayOfInt, paramArrayOfInt);
          if (k <= i) {
            break label533;
          }
          i = k;
          paramr = paramArrayOfInt;
        }
      }
    }
    label533:
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfInt = paramArrayOfInt.bdq;
      break label346;
      if (i > 1)
      {
        paramArrayOfInt = new int[i];
        j = 0;
        i = 0;
        while (i < localq.length)
        {
          k = j;
          if (a(localq.bwD[i], arrayOfInt[i], paramr))
          {
            paramArrayOfInt[j] = i;
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      for (paramr = paramArrayOfInt; paramr.length > 0; paramr = bEg)
      {
        paramr = parama.a(localq, paramr);
        AppMethodBeat.o(92939);
        return paramr;
      }
      paramr = new d(localq, m);
      AppMethodBeat.o(92939);
      return paramr;
    }
  }
  
  private static List<Integer> a(q paramq, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92945);
    ArrayList localArrayList = new ArrayList(paramq.length);
    int i = 0;
    while (i < paramq.length)
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
    if (j < paramq.length)
    {
      Format localFormat = paramq.bwD[j];
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
          paramInt2 = paramq.bwD[paramInt2].tv();
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
    if ((q(paramInt, false)) && (paramFormat.channelCount == parama.channelCount) && (paramFormat.sampleRate == parama.sampleRate) && ((parama.mimeType == null) || (TextUtils.equals(parama.mimeType, paramFormat.bdq))))
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
    if ((q(paramInt1, false)) && ((paramInt1 & paramInt2) != 0) && ((paramString == null) || (x.j(paramFormat.bdq, paramString))) && ((paramFormat.width == -1) || (paramFormat.width <= paramInt3)) && ((paramFormat.height == -1) || (paramFormat.height <= paramInt4)) && ((paramFormat.bitrate == -1) || (paramFormat.bitrate <= paramInt5)))
    {
      AppMethodBeat.o(92937);
      return true;
    }
    AppMethodBeat.o(92937);
    return false;
  }
  
  private static f b(r paramr, int[][] paramArrayOfInt, b paramb)
  {
    AppMethodBeat.i(92942);
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int m = 0;
    while (m < paramr.length)
    {
      q localq = paramr.bxi[m];
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < localq.length)
      {
        int i2 = i1;
        int i = n;
        Object localObject2 = localObject1;
        Format localFormat;
        label103:
        int k;
        if (q(arrayOfInt[j], paramb.bEs))
        {
          localFormat = localq.bwD[j];
          if ((localFormat.bdD & 0x1) == 0) {
            break label206;
          }
          i = 1;
          if ((localFormat.bdD & 0x2) == 0) {
            break label211;
          }
          k = 1;
          label116:
          if (!a(localFormat, paramb.bEk)) {
            break label232;
          }
          if (i == 0) {
            break label217;
          }
          i = 6;
        }
        for (;;)
        {
          label135:
          k = i;
          if (q(arrayOfInt[j], false)) {
            k = i + 1000;
          }
          i2 = i1;
          i = n;
          localObject2 = localObject1;
          if (k > i1)
          {
            i = j;
            localObject2 = localq;
            i2 = k;
          }
          label206:
          label211:
          label217:
          label232:
          do
          {
            j += 1;
            i1 = i2;
            n = i;
            localObject1 = localObject2;
            break;
            i = 0;
            break label103;
            k = 0;
            break label116;
            if (k == 0)
            {
              i = 5;
              break label135;
            }
            i = 4;
            break label135;
            if (i != 0)
            {
              i = 3;
              break label135;
            }
            i2 = i1;
            i = n;
            localObject2 = localObject1;
          } while (k == 0);
          if (a(localFormat, paramb.bEj)) {
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
    paramr = new d(localObject1, n);
    AppMethodBeat.o(92942);
    return paramr;
  }
  
  private static void b(q paramq, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    AppMethodBeat.i(92936);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!a(paramq.bwD[j], paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4)) {
        paramList.remove(i);
      }
      i -= 1;
    }
    AppMethodBeat.o(92936);
  }
  
  private static int bg(int paramInt1, int paramInt2)
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
  
  private static f c(r paramr, int[][] paramArrayOfInt, b paramb)
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
    if (n < paramr.length)
    {
      q localq = paramr.bxi[n];
      int[] arrayOfInt = paramArrayOfInt[n];
      i = 0;
      if (i < localq.length)
      {
        if (!q(arrayOfInt[i], paramb.bEs)) {
          break label195;
        }
        if ((localq.bwD[i].bdD & 0x1) != 0)
        {
          k = 1;
          if (k == 0) {
            break label147;
          }
          m = 2;
          label93:
          k = m;
          if (q(arrayOfInt[i], false)) {
            k = m + 1000;
          }
          if (k <= j) {
            break label195;
          }
          i1 = i;
          localObject = localq;
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
      paramr = new d(localObject, i1);
      AppMethodBeat.o(92943);
      return paramr;
      label195:
      k = j;
    }
  }
  
  private static boolean q(int paramInt, boolean paramBoolean)
  {
    paramInt &= 0x7;
    return (paramInt == 4) || ((paramBoolean) && (paramInt == 3));
  }
  
  protected final f[] a(s[] paramArrayOfs, r[] paramArrayOfr, int[][][] paramArrayOfInt)
  {
    AppMethodBeat.i(92934);
    int i4 = paramArrayOfs.length;
    f[] arrayOff = new f[i4];
    b localb = (b)this.bEi.get();
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
    q localq;
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
        localObject3 = paramArrayOfr[m];
        int[][] arrayOfInt = paramArrayOfInt[m];
        f.a locala = this.bEh;
        localObject1 = null;
        if (locala != null)
        {
          if (localb.bEr)
          {
            k = 24;
            if ((!localb.bEq) || ((((s)localObject2).td() & k) == 0)) {
              break label318;
            }
            n = 1;
            i1 = 0;
            if (i1 >= ((r)localObject3).length) {
              break label533;
            }
            localq = localObject3.bxi[i1];
            arrayOfInt1 = arrayOfInt[i1];
            i5 = localb.bEl;
            i6 = localb.bEm;
            i7 = localb.bEn;
            i = localb.viewportWidth;
            i2 = localb.viewportHeight;
            bool = localb.bEp;
            if (localq.length >= 2) {
              break label324;
            }
            localObject1 = bEg;
            label221:
            if (localObject1.length <= 0) {
              break label524;
            }
            localObject1 = locala.a(localq, (int[])localObject1);
          }
        }
        else
        {
          label240:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a((r)localObject3, arrayOfInt, localb);
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
        if (paramArrayOfr[m].length <= 0) {
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
      List localList = a(localq, i, i2, bool);
      if (localList.size() < 2)
      {
        localObject1 = bEg;
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
          localObject2 = localq.bwD[i3].bdq;
          if (!localHashSet.add(localObject2)) {
            break label805;
          }
          i3 = a(localq, arrayOfInt1, k, (String)localObject2, i5, i6, i7, localList);
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
        b(localq, arrayOfInt1, k, (String)localObject1, i5, i6, i7, localList);
        if (localList.size() < 2)
        {
          localObject1 = bEg;
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
            arrayOff[k] = c(paramArrayOfr[k], paramArrayOfInt[k], localb);
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
            localObject2 = paramArrayOfr[k];
            localObject3 = paramArrayOfInt[k];
            if (j != 0)
            {
              localObject1 = null;
              arrayOff[k] = a((r)localObject2, (int[][])localObject3, localb, (f.a)localObject1);
              if (arrayOff[k] == null) {
                break label731;
              }
            }
            for (i = 1;; i = 0)
            {
              i1 = m;
              break;
              localObject1 = this.bEh;
              break label688;
            }
            i = n;
            i1 = m;
          } while (m != 0);
          arrayOff[k] = b(paramArrayOfr[k], paramArrayOfInt[k], localb);
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
    public final String bEj = null;
    public final String bEk = null;
    public final int bEl = 2147483647;
    public final int bEm = 2147483647;
    public final int bEn = 2147483647;
    public final boolean bEo = true;
    public final boolean bEp = true;
    public final boolean bEq = false;
    public final boolean bEr = true;
    public final boolean bEs = true;
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
      if ((this.bEq == paramObject.bEq) && (this.bEr == paramObject.bEr) && (this.bEl == paramObject.bEl) && (this.bEm == paramObject.bEm) && (this.bEo == paramObject.bEo) && (this.bEs == paramObject.bEs) && (this.bEp == paramObject.bEp) && (this.viewportWidth == paramObject.viewportWidth) && (this.viewportHeight == paramObject.viewportHeight) && (this.bEn == paramObject.bEn) && (TextUtils.equals(this.bEj, paramObject.bEj)) && (TextUtils.equals(this.bEk, paramObject.bEk)))
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
      int i1 = this.bEj.hashCode();
      int i2 = this.bEk.hashCode();
      int i;
      int j;
      label44:
      int i3;
      int i4;
      int i5;
      int k;
      label71:
      int m;
      if (this.bEq)
      {
        i = 1;
        if (!this.bEr) {
          break label176;
        }
        j = 1;
        i3 = this.bEl;
        i4 = this.bEm;
        i5 = this.bEn;
        if (!this.bEo) {
          break label181;
        }
        k = 1;
        if (!this.bEs) {
          break label186;
        }
        m = 1;
        label81:
        if (!this.bEp) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.g.c
 * JD-Core Version:    0.7.0.1
 */