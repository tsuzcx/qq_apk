package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends d
{
  private static final int[] aQj = new int[0];
  private final e.a aQk = null;
  private final AtomicReference<b> aQl = new AtomicReference(new b());
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte) {}
  
  private static int a(l paraml, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      int k = ((Integer)paramList.get(j)).intValue();
      if (!a(paraml.aIs[k], paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4)) {
        break label78;
      }
      i += 1;
    }
    label78:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private static int a(l paraml, int[] paramArrayOfInt, b.a parama)
  {
    int j = 0;
    int i = 0;
    if (j < paraml.length)
    {
      if (!a(paraml.aIs[j], paramArrayOfInt[j], parama)) {
        break label47;
      }
      i += 1;
    }
    label47:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private static e a(m paramm, int[][] paramArrayOfInt, b paramb)
  {
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int i2 = -1;
    int i3 = -1;
    int m = 0;
    while (m < paramm.length)
    {
      l locall = paramm.aIZ[m];
      List localList = a(locall, paramb.viewportWidth, paramb.viewportHeight, paramb.aQs);
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < locall.length)
      {
        int i8 = i3;
        int i7 = i2;
        int i6 = i1;
        int i5 = n;
        Object localObject2 = localObject1;
        Format localFormat;
        int i4;
        label200:
        int i;
        label239:
        int k;
        if (s(arrayOfInt[j], paramb.aQv))
        {
          localFormat = locall.aIs[j];
          if ((!localList.contains(Integer.valueOf(j))) || ((localFormat.width != -1) && (localFormat.width > paramb.aQo)) || ((localFormat.height != -1) && (localFormat.height > paramb.aQp)) || ((localFormat.bitrate != -1) && (localFormat.bitrate > paramb.aQq))) {
            break label397;
          }
          i4 = 1;
          if (i4 == 0)
          {
            i8 = i3;
            i7 = i2;
            i6 = i1;
            i5 = n;
            localObject2 = localObject1;
            if (!paramb.aQr) {}
          }
          else
          {
            if (i4 == 0) {
              break label403;
            }
            i = 2;
            boolean bool = s(arrayOfInt[j], false);
            k = i;
            if (bool) {
              k = i + 1000;
            }
            if (k <= i1) {
              break label408;
            }
            i = 1;
            label274:
            if (k == i1)
            {
              if (localFormat.kQ() == i3) {
                break label413;
              }
              i = aH(localFormat.kQ(), i3);
              label302:
              if ((!bool) || (i4 == 0)) {
                break label432;
              }
              if (i <= 0) {
                break label427;
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
            i8 = localFormat.kQ();
            i5 = j;
            localObject2 = locall;
            i6 = k;
          }
          j += 1;
          i3 = i8;
          i2 = i7;
          i1 = i6;
          n = i5;
          localObject1 = localObject2;
          break;
          label397:
          i4 = 0;
          break label200;
          label403:
          i = 1;
          break label239;
          label408:
          i = 0;
          break label274;
          label413:
          i = aH(localFormat.bitrate, i2);
          break label302;
          label427:
          i = 0;
          continue;
          label432:
          if (i < 0) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      m += 1;
    }
    if (localObject1 == null) {
      return null;
    }
    return new c(localObject1, n);
  }
  
  private static e a(m paramm, int[][] paramArrayOfInt, b paramb, e.a parama)
  {
    int n = -1;
    int m = -1;
    int i2 = 0;
    int j = 0;
    int[] arrayOfInt;
    int k;
    int i;
    while (j < paramm.length)
    {
      locall = paramm.aIZ[j];
      arrayOfInt = paramArrayOfInt[j];
      k = 0;
      int i1 = m;
      if (k < locall.length)
      {
        int i4 = i2;
        int i3 = i1;
        i = n;
        if (s(arrayOfInt[k], paramb.aQv))
        {
          Format localFormat = locall.aIs[k];
          i3 = arrayOfInt[k];
          String str = paramb.aQm;
          if ((localFormat.auH & 0x1) == 0) {
            break label207;
          }
          i = 1;
          label116:
          if (!a(localFormat, str)) {
            break label219;
          }
          if (i == 0) {
            break label213;
          }
          i = 4;
        }
        for (;;)
        {
          m = i;
          if (s(i3, false)) {
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
          label207:
          i = 0;
          break label116;
          label213:
          i = 3;
          continue;
          label219:
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
    if (n == -1) {
      return null;
    }
    l locall = paramm.aIZ[n];
    if (parama != null)
    {
      arrayOfInt = paramArrayOfInt[n];
      boolean bool = paramb.aQt;
      i = 0;
      paramm = null;
      paramb = new HashSet();
      j = 0;
      if (j < locall.length)
      {
        paramArrayOfInt = locall.aIs[j];
        k = paramArrayOfInt.auC;
        n = paramArrayOfInt.sampleRate;
        if (bool)
        {
          paramArrayOfInt = null;
          label336:
          paramArrayOfInt = new b.a(k, n, paramArrayOfInt);
          if (!paramb.add(paramArrayOfInt)) {
            break label506;
          }
          k = a(locall, arrayOfInt, paramArrayOfInt);
          if (k <= i) {
            break label506;
          }
          i = k;
          paramm = paramArrayOfInt;
        }
      }
    }
    label506:
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfInt = paramArrayOfInt.aus;
      break label336;
      if (i > 1)
      {
        paramArrayOfInt = new int[i];
        j = 0;
        i = 0;
        while (i < locall.length)
        {
          k = j;
          if (a(locall.aIs[i], arrayOfInt[i], paramm))
          {
            paramArrayOfInt[j] = i;
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      for (paramm = paramArrayOfInt; paramm.length > 0; paramm = aQj) {
        return parama.nK();
      }
      return new c(locall, m);
    }
  }
  
  private static List<Integer> a(l paraml, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paraml.length);
    int i = 0;
    while (i < paraml.length)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    if ((paramInt1 == 2147483647) || (paramInt2 == 2147483647)) {
      return localArrayList;
    }
    i = 2147483647;
    int j = 0;
    Format localFormat;
    int k;
    int n;
    int i1;
    if (j < paraml.length)
    {
      localFormat = paraml.aIs[j];
      k = i;
      if (localFormat.width > 0)
      {
        k = i;
        if (localFormat.height > 0)
        {
          n = localFormat.width;
          i1 = localFormat.height;
          if (!paramBoolean) {
            break label383;
          }
          if (n <= i1) {
            break label277;
          }
          k = 1;
          label137:
          if (paramInt1 <= paramInt2) {
            break label283;
          }
          m = 1;
          label145:
          if (k == m) {
            break label383;
          }
          k = paramInt1;
        }
      }
    }
    for (int m = paramInt2;; m = paramInt1)
    {
      if (n * k >= i1 * m) {}
      for (Point localPoint = new Point(m, t.aJ(m * i1, n));; localPoint = new Point(t.aJ(k * n, i1), k))
      {
        m = localFormat.width * localFormat.height;
        k = i;
        if (localFormat.width >= (int)(localPoint.x * 0.98F))
        {
          k = i;
          if (localFormat.height >= (int)(localPoint.y * 0.98F))
          {
            k = i;
            if (m < i) {
              k = m;
            }
          }
        }
        j += 1;
        i = k;
        break;
        label277:
        k = 0;
        break label137;
        label283:
        m = 0;
        break label145;
      }
      if (i != 2147483647)
      {
        paramInt1 = localArrayList.size() - 1;
        while (paramInt1 >= 0)
        {
          paramInt2 = ((Integer)localArrayList.get(paramInt1)).intValue();
          paramInt2 = paraml.aIs[paramInt2].kQ();
          if ((paramInt2 == -1) || (paramInt2 > i)) {
            localArrayList.remove(paramInt1);
          }
          paramInt1 -= 1;
        }
      }
      return localArrayList;
      label383:
      k = paramInt2;
    }
  }
  
  private static boolean a(Format paramFormat, int paramInt, b.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (s(paramInt, false))
    {
      bool1 = bool2;
      if (paramFormat.auC == parama.auC)
      {
        bool1 = bool2;
        if (paramFormat.sampleRate == parama.sampleRate) {
          if (parama.mimeType != null)
          {
            bool1 = bool2;
            if (!TextUtils.equals(parama.mimeType, paramFormat.aus)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(Format paramFormat, String paramString)
  {
    return (paramString != null) && (TextUtils.equals(paramString, t.aD(paramFormat.auI)));
  }
  
  private static boolean a(Format paramFormat, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (s(paramInt1, false))
    {
      bool1 = bool2;
      if ((paramInt1 & paramInt2) != 0) {
        if (paramString != null)
        {
          bool1 = bool2;
          if (!t.e(paramFormat.aus, paramString)) {}
        }
        else if (paramFormat.width != -1)
        {
          bool1 = bool2;
          if (paramFormat.width > paramInt3) {}
        }
        else if (paramFormat.height != -1)
        {
          bool1 = bool2;
          if (paramFormat.height > paramInt4) {}
        }
        else if (paramFormat.bitrate != -1)
        {
          bool1 = bool2;
          if (paramFormat.bitrate > paramInt5) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static int aH(int paramInt1, int paramInt2)
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
  
  private static e b(m paramm, int[][] paramArrayOfInt, b paramb)
  {
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int m = 0;
    while (m < paramm.length)
    {
      l locall = paramm.aIZ[m];
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < locall.length)
      {
        int i2 = i1;
        int i = n;
        Object localObject2 = localObject1;
        Format localFormat;
        label97:
        int k;
        if (s(arrayOfInt[j], paramb.aQv))
        {
          localFormat = locall.aIs[j];
          if ((localFormat.auH & 0x1) == 0) {
            break label200;
          }
          i = 1;
          if ((localFormat.auH & 0x2) == 0) {
            break label205;
          }
          k = 1;
          label110:
          if (!a(localFormat, paramb.aQn)) {
            break label226;
          }
          if (i == 0) {
            break label211;
          }
          i = 6;
        }
        for (;;)
        {
          label129:
          k = i;
          if (s(arrayOfInt[j], false)) {
            k = i + 1000;
          }
          i2 = i1;
          i = n;
          localObject2 = localObject1;
          if (k > i1)
          {
            i = j;
            localObject2 = locall;
            i2 = k;
          }
          label200:
          label205:
          label211:
          label226:
          do
          {
            j += 1;
            i1 = i2;
            n = i;
            localObject1 = localObject2;
            break;
            i = 0;
            break label97;
            k = 0;
            break label110;
            if (k == 0)
            {
              i = 5;
              break label129;
            }
            i = 4;
            break label129;
            if (i != 0)
            {
              i = 3;
              break label129;
            }
            i2 = i1;
            i = n;
            localObject2 = localObject1;
          } while (k == 0);
          if (a(localFormat, paramb.aQm)) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
      m += 1;
    }
    if (localObject1 == null) {
      return null;
    }
    return new c(localObject1, n);
  }
  
  private static void b(l paraml, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!a(paraml.aIs[j], paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4)) {
        paramList.remove(i);
      }
      i -= 1;
    }
  }
  
  private static e c(m paramm, int[][] paramArrayOfInt, b paramb)
  {
    int n = 0;
    int j = 0;
    int i1 = 0;
    Object localObject = null;
    int i;
    label38:
    int k;
    label79:
    int m;
    if (n < paramm.length)
    {
      l locall = paramm.aIZ[n];
      int[] arrayOfInt = paramArrayOfInt[n];
      i = 0;
      if (i < locall.length)
      {
        if (!s(arrayOfInt[i], paramb.aQv)) {
          break label175;
        }
        if ((locall.aIs[i].auH & 0x1) != 0)
        {
          k = 1;
          if (k == 0) {
            break label141;
          }
          m = 2;
          label87:
          k = m;
          if (s(arrayOfInt[i], false)) {
            k = m + 1000;
          }
          if (k <= j) {
            break label175;
          }
          i1 = i;
          localObject = locall;
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label38;
      k = 0;
      break label79;
      label141:
      m = 1;
      break label87;
      n += 1;
      break;
      if (localObject == null) {
        return null;
      }
      return new c(localObject, i1);
      label175:
      k = j;
    }
  }
  
  private static boolean s(int paramInt, boolean paramBoolean)
  {
    paramInt &= 0x7;
    return (paramInt == 4) || ((paramBoolean) && (paramInt == 3));
  }
  
  protected final e[] a(s[] paramArrayOfs, m[] paramArrayOfm, int[][][] paramArrayOfInt)
  {
    int i4 = paramArrayOfs.length;
    e[] arrayOfe = new e[i4];
    b localb = (b)this.aQl.get();
    int j = 0;
    int k = 0;
    int m = 0;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label105:
    int n;
    label129:
    int i1;
    l locall;
    int[] arrayOfInt1;
    int i5;
    int i6;
    int i7;
    int i2;
    boolean bool;
    if (m < i4)
    {
      if (2 != paramArrayOfs[m].getTrackType()) {
        break label796;
      }
      i = k;
      if (k == 0)
      {
        localObject2 = paramArrayOfs[m];
        localObject3 = paramArrayOfm[m];
        int[][] arrayOfInt = paramArrayOfInt[m];
        e.a locala = this.aQk;
        localObject1 = null;
        if (locala != null)
        {
          if (localb.aQu)
          {
            k = 24;
            if ((!localb.aQt) || ((((s)localObject2).ky() & k) == 0)) {
              break label308;
            }
            n = 1;
            i1 = 0;
            if (i1 >= ((m)localObject3).length) {
              break label523;
            }
            locall = localObject3.aIZ[i1];
            arrayOfInt1 = arrayOfInt[i1];
            i5 = localb.aQo;
            i6 = localb.aQp;
            i7 = localb.aQq;
            i = localb.viewportWidth;
            i2 = localb.viewportHeight;
            bool = localb.aQs;
            if (locall.length >= 2) {
              break label314;
            }
            localObject1 = aQj;
            label215:
            if (localObject1.length <= 0) {
              break label514;
            }
            localObject1 = locala.nK();
          }
        }
        else
        {
          label230:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a((m)localObject3, arrayOfInt, localb);
          }
          arrayOfe[m] = localObject2;
          if (arrayOfe[m] == null) {
            break label529;
          }
          i = 1;
        }
      }
      else
      {
        label268:
        if (paramArrayOfm[m].length <= 0) {
          break label535;
        }
        k = 1;
        label281:
        j = k | j;
      }
    }
    for (;;)
    {
      m += 1;
      k = i;
      break;
      k = 16;
      break label105;
      label308:
      n = 0;
      break label129;
      label314:
      List localList = a(locall, i, i2, bool);
      if (localList.size() < 2)
      {
        localObject1 = aQj;
        break label215;
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
          localObject2 = locall.aIs[i3].aus;
          if (!localHashSet.add(localObject2)) {
            break label787;
          }
          i3 = a(locall, arrayOfInt1, k, (String)localObject2, i5, i6, i7, localList);
          if (i3 <= i) {
            break label787;
          }
          i = i3;
          localObject1 = localObject2;
          label457:
          i2 += 1;
        }
      }
      for (;;)
      {
        b(locall, arrayOfInt1, k, (String)localObject1, i5, i6, i7, localList);
        if (localList.size() < 2)
        {
          localObject1 = aQj;
          break label215;
        }
        localObject1 = t.v(localList);
        break label215;
        label514:
        i1 += 1;
        break;
        label523:
        localObject1 = null;
        break label230;
        label529:
        i = 0;
        break label268;
        label535:
        k = 0;
        break label281;
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
            arrayOfe[k] = c(paramArrayOfm[k], paramArrayOfInt[k], localb);
            i1 = m;
            i = n;
          }
          label676:
          label719:
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
            localObject2 = paramArrayOfm[k];
            localObject3 = paramArrayOfInt[k];
            if (j != 0)
            {
              localObject1 = null;
              arrayOfe[k] = a((m)localObject2, (int[][])localObject3, localb, (e.a)localObject1);
              if (arrayOfe[k] == null) {
                break label719;
              }
            }
            for (i = 1;; i = 0)
            {
              i1 = m;
              break;
              localObject1 = this.aQk;
              break label676;
            }
            i = n;
            i1 = m;
          } while (m != 0);
          arrayOfe[k] = b(paramArrayOfm[k], paramArrayOfInt[k], localb);
          if (arrayOfe[k] != null) {}
          for (i = 1;; i = 0)
          {
            i1 = i;
            i = n;
            break;
          }
        }
        return arrayOfe;
        label787:
        break label457;
        localObject1 = null;
      }
      label796:
      i = k;
    }
  }
  
  public static final class b
  {
    public final String aQm = null;
    public final String aQn = null;
    public final int aQo = 2147483647;
    public final int aQp = 2147483647;
    public final int aQq = 2147483647;
    public final boolean aQr = true;
    public final boolean aQs = true;
    public final boolean aQt = false;
    public final boolean aQu = true;
    public final boolean aQv = true;
    public final int viewportHeight = 2147483647;
    public final int viewportWidth = 2147483647;
    
    public b()
    {
      this((byte)0);
    }
    
    private b(byte paramByte) {}
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (b)paramObject;
      } while ((this.aQt == paramObject.aQt) && (this.aQu == paramObject.aQu) && (this.aQo == paramObject.aQo) && (this.aQp == paramObject.aQp) && (this.aQr == paramObject.aQr) && (this.aQv == paramObject.aQv) && (this.aQs == paramObject.aQs) && (this.viewportWidth == paramObject.viewportWidth) && (this.viewportHeight == paramObject.viewportHeight) && (this.aQq == paramObject.aQq) && (TextUtils.equals(this.aQm, paramObject.aQm)) && (TextUtils.equals(this.aQn, paramObject.aQn)));
      return false;
    }
    
    public final int hashCode()
    {
      int n = 1;
      int i1 = this.aQm.hashCode();
      int i2 = this.aQn.hashCode();
      int i;
      int j;
      label39:
      int i3;
      int i4;
      int i5;
      int k;
      label66:
      int m;
      if (this.aQt)
      {
        i = 1;
        if (!this.aQu) {
          break label158;
        }
        j = 1;
        i3 = this.aQo;
        i4 = this.aQp;
        i5 = this.aQq;
        if (!this.aQr) {
          break label163;
        }
        k = 1;
        if (!this.aQv) {
          break label168;
        }
        m = 1;
        label76:
        if (!this.aQs) {
          break label174;
        }
      }
      for (;;)
      {
        return (((m + (k + ((((j + (i + (i1 * 31 + i2) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + n) * 31 + this.viewportWidth) * 31 + this.viewportHeight;
        i = 0;
        break;
        label158:
        j = 0;
        break label39;
        label163:
        k = 0;
        break label66;
        label168:
        m = 0;
        break label76;
        label174:
        n = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */