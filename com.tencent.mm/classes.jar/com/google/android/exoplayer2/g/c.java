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
  private static final int[] btO = new int[0];
  private final f.a btP;
  private final AtomicReference<b> btQ;
  
  public c()
  {
    this(null);
  }
  
  public c(f.a parama)
  {
    AppMethodBeat.i(92933);
    this.btP = parama;
    this.btQ = new AtomicReference(new b());
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
      if (!a(paramo.bmh[k], paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4)) {
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
  
  private static int a(o paramo, int[] paramArrayOfInt, a parama)
  {
    AppMethodBeat.i(92940);
    int j = 0;
    int i = 0;
    if (j < paramo.length)
    {
      if (!a(paramo.bmh[j], paramArrayOfInt[j], parama)) {
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
      o localo = paramp.bmM[m];
      List localList = a(localo, paramb.viewportWidth, paramb.viewportHeight, paramb.btX);
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
        if (o(arrayOfInt[j], paramb.bua))
        {
          localFormat = localo.bmh[j];
          if ((!localList.contains(Integer.valueOf(j))) || ((localFormat.width != -1) && (localFormat.width > paramb.btT)) || ((localFormat.height != -1) && (localFormat.height > paramb.btU)) || ((localFormat.bitrate != -1) && (localFormat.bitrate > paramb.btV))) {
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
            if (!paramb.btW) {}
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
              if (localFormat.rR() == i3) {
                break label418;
              }
              i = bk(localFormat.rR(), i3);
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
            i8 = localFormat.rR();
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
          i = bk(localFormat.bitrate, i2);
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
      localo = paramp.bmM[j];
      arrayOfInt = paramArrayOfInt[j];
      k = 0;
      int i1 = m;
      if (k < localo.length)
      {
        int i4 = i2;
        int i3 = i1;
        i = n;
        if (o(arrayOfInt[k], paramb.bua))
        {
          Format localFormat = localo.bmh[k];
          i3 = arrayOfInt[k];
          String str = paramb.btR;
          if ((localFormat.aTl & 0x1) == 0) {
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
    o localo = paramp.bmM[n];
    if (parama != null)
    {
      arrayOfInt = paramArrayOfInt[n];
      boolean bool = paramb.btY;
      i = 0;
      paramp = null;
      paramb = new HashSet();
      j = 0;
      if (j < localo.length)
      {
        paramArrayOfInt = localo.bmh[j];
        k = paramArrayOfInt.channelCount;
        n = paramArrayOfInt.sampleRate;
        if (bool)
        {
          paramArrayOfInt = null;
          label346:
          paramArrayOfInt = new a(k, n, paramArrayOfInt);
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
      paramArrayOfInt = paramArrayOfInt.aSY;
      break label346;
      if (i > 1)
      {
        paramArrayOfInt = new int[i];
        j = 0;
        i = 0;
        while (i < localo.length)
        {
          k = j;
          if (a(localo.bmh[i], arrayOfInt[i], paramp))
          {
            paramArrayOfInt[j] = i;
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      for (paramp = paramArrayOfInt; paramp.length > 0; paramp = btO)
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
      Format localFormat = paramo.bmh[j];
      if ((localFormat.width <= 0) || (localFormat.height <= 0)) {
        break label273;
      }
      Point localPoint = b(paramBoolean, paramInt1, paramInt2, localFormat.width, localFormat.height);
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
          paramInt2 = paramo.bmh[paramInt2].rR();
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
  
  private static boolean a(Format paramFormat, int paramInt, a parama)
  {
    AppMethodBeat.i(92941);
    if ((o(paramInt, false)) && (paramFormat.channelCount == parama.channelCount) && (paramFormat.sampleRate == parama.sampleRate) && ((parama.mimeType == null) || (TextUtils.equals(parama.mimeType, paramFormat.aSY))))
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
    if ((paramString != null) && (TextUtils.equals(paramString, x.aM(paramFormat.aTm))))
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
    if ((o(paramInt1, false)) && ((paramInt1 & paramInt2) != 0) && ((paramString == null) || (x.g(paramFormat.aSY, paramString))) && ((paramFormat.width == -1) || (paramFormat.width <= paramInt3)) && ((paramFormat.height == -1) || (paramFormat.height <= paramInt4)) && ((paramFormat.bitrate == -1) || (paramFormat.bitrate <= paramInt5)))
    {
      AppMethodBeat.o(92937);
      return true;
    }
    AppMethodBeat.o(92937);
    return false;
  }
  
  private static Point b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
        localPoint = new Point(paramInt2, x.bm(paramInt2 * paramInt4, paramInt3));
        AppMethodBeat.o(92946);
        return localPoint;
        i = 0;
        break;
        label75:
        j = 0;
        break label26;
      }
      Point localPoint = new Point(x.bm(paramInt1 * paramInt3, paramInt4), paramInt1);
      AppMethodBeat.o(92946);
      return localPoint;
      label107:
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
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
      o localo = paramp.bmM[m];
      int[] arrayOfInt = paramArrayOfInt[m];
      int j = 0;
      if (j < localo.length)
      {
        int i2 = i1;
        int i = n;
        Object localObject2 = localObject1;
        Format localFormat;
        label103:
        int k;
        if (o(arrayOfInt[j], paramb.bua))
        {
          localFormat = localo.bmh[j];
          if ((localFormat.aTl & 0x1) == 0) {
            break label206;
          }
          i = 1;
          if ((localFormat.aTl & 0x2) == 0) {
            break label211;
          }
          k = 1;
          label116:
          if (!a(localFormat, paramb.btS)) {
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
          if (a(localFormat, paramb.btR)) {
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
      if (!a(paramo.bmh[j], paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4)) {
        paramList.remove(i);
      }
      i -= 1;
    }
    AppMethodBeat.o(92936);
  }
  
  private static int bk(int paramInt1, int paramInt2)
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
      o localo = paramp.bmM[n];
      int[] arrayOfInt = paramArrayOfInt[n];
      i = 0;
      if (i < localo.length)
      {
        if (!o(arrayOfInt[i], paramb.bua)) {
          break label195;
        }
        if ((localo.bmh[i].aTl & 0x1) != 0)
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
    b localb = (b)this.btQ.get();
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
        f.a locala = this.btP;
        localObject1 = null;
        if (locala != null)
        {
          if (localb.btZ)
          {
            k = 24;
            if ((!localb.btY) || ((((s)localObject2).rz() & k) == 0)) {
              break label318;
            }
            n = 1;
            i1 = 0;
            if (i1 >= ((p)localObject3).length) {
              break label533;
            }
            localo = localObject3.bmM[i1];
            arrayOfInt1 = arrayOfInt[i1];
            i5 = localb.btT;
            i6 = localb.btU;
            i7 = localb.btV;
            i = localb.viewportWidth;
            i2 = localb.viewportHeight;
            bool = localb.btX;
            if (localo.length >= 2) {
              break label324;
            }
            localObject1 = btO;
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
        localObject1 = btO;
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
          localObject2 = localo.bmh[i3].aSY;
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
          localObject1 = btO;
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
              localObject1 = this.btP;
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
  
  static final class a
  {
    public final int channelCount;
    public final String mimeType;
    public final int sampleRate;
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.channelCount = paramInt1;
      this.sampleRate = paramInt2;
      this.mimeType = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(92929);
      if (this == paramObject)
      {
        AppMethodBeat.o(92929);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(92929);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.channelCount == paramObject.channelCount) && (this.sampleRate == paramObject.sampleRate) && (TextUtils.equals(this.mimeType, paramObject.mimeType)))
      {
        AppMethodBeat.o(92929);
        return true;
      }
      AppMethodBeat.o(92929);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(92930);
      int j = this.channelCount;
      int k = this.sampleRate;
      if (this.mimeType != null) {}
      for (int i = this.mimeType.hashCode();; i = 0)
      {
        AppMethodBeat.o(92930);
        return i + (j * 31 + k) * 31;
      }
    }
  }
  
  public static final class b
  {
    public final String btR = null;
    public final String btS = null;
    public final int btT = 2147483647;
    public final int btU = 2147483647;
    public final int btV = 2147483647;
    public final boolean btW = true;
    public final boolean btX = true;
    public final boolean btY = false;
    public final boolean btZ = true;
    public final boolean bua = true;
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
      if ((this.btY == paramObject.btY) && (this.btZ == paramObject.btZ) && (this.btT == paramObject.btT) && (this.btU == paramObject.btU) && (this.btW == paramObject.btW) && (this.bua == paramObject.bua) && (this.btX == paramObject.btX) && (this.viewportWidth == paramObject.viewportWidth) && (this.viewportHeight == paramObject.viewportHeight) && (this.btV == paramObject.btV) && (TextUtils.equals(this.btR, paramObject.btR)) && (TextUtils.equals(this.btS, paramObject.btS)))
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
      int i1 = this.btR.hashCode();
      int i2 = this.btS.hashCode();
      int i;
      int j;
      label44:
      int i3;
      int i4;
      int i5;
      int k;
      label71:
      int m;
      if (this.btY)
      {
        i = 1;
        if (!this.btZ) {
          break label176;
        }
        j = 1;
        i3 = this.btT;
        i4 = this.btU;
        i5 = this.btV;
        if (!this.btW) {
          break label181;
        }
        k = 1;
        if (!this.bua) {
          break label186;
        }
        m = 1;
        label81:
        if (!this.btX) {
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