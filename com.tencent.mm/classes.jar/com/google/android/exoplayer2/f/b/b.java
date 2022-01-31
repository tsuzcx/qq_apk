package com.google.android.exoplayer2.f.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.SparseArray;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final byte[] aVi = { 0, 7, 8, 15 };
  private static final byte[] aVj = { 0, 119, -120, -1 };
  private static final byte[] aVk = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private final Paint aVl;
  private final Paint aVm;
  private final Canvas aVn;
  private final b.b aVo;
  private final b.a aVp;
  final b.h aVq;
  private Bitmap bitmap;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95626);
    this.aVl = new Paint();
    this.aVl.setStyle(Paint.Style.FILL_AND_STROKE);
    this.aVl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.aVl.setPathEffect(null);
    this.aVm = new Paint();
    this.aVm.setStyle(Paint.Style.FILL);
    this.aVm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    this.aVm.setPathEffect(null);
    this.aVn = new Canvas();
    this.aVo = new b.b(719, 575, 0, 719, 0, 575);
    this.aVp = new b.a(0, pZ(), qa(), qb());
    this.aVq = new b.h(paramInt1, paramInt2);
    AppMethodBeat.o(95626);
  }
  
  private static b.f a(l paraml, int paramInt)
  {
    AppMethodBeat.i(95628);
    int k = paraml.dD(8);
    paraml.dE(4);
    boolean bool = paraml.oj();
    paraml.dE(3);
    int m = paraml.dD(16);
    int n = paraml.dD(16);
    int i1 = paraml.dD(3);
    int i2 = paraml.dD(3);
    paraml.dE(2);
    int i3 = paraml.dD(8);
    int i4 = paraml.dD(8);
    int i5 = paraml.dD(4);
    int i6 = paraml.dD(2);
    paraml.dE(2);
    paramInt -= 10;
    SparseArray localSparseArray = new SparseArray();
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i;
    int j;
    if (paramInt > 0)
    {
      i7 = paraml.dD(16);
      i8 = paraml.dD(2);
      i9 = paraml.dD(2);
      i10 = paraml.dD(12);
      paraml.dE(4);
      i11 = paraml.dD(12);
      paramInt -= 6;
      i = 0;
      j = 0;
      if ((i8 != 1) && (i8 != 2)) {
        break label263;
      }
      i = paraml.dD(8);
      j = paraml.dD(8);
      paramInt -= 2;
    }
    label263:
    for (;;)
    {
      localSparseArray.put(i7, new b.g(i8, i9, i10, i11, i, j));
      break;
      paraml = new b.f(k, bool, m, n, i1, i2, i3, i4, i5, i6, localSparseArray);
      AppMethodBeat.o(95628);
      return paraml;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    AppMethodBeat.i(95633);
    l locall = new l(paramArrayOfByte);
    paramArrayOfByte = null;
    byte[] arrayOfByte1 = null;
    int i = paramInt2;
    int k = paramInt3;
    paramInt3 = i;
    label112:
    byte[] arrayOfByte2;
    label129:
    int m;
    for (;;)
    {
      if (locall.qI() != 0) {
        switch (locall.dD(8))
        {
        default: 
          break;
        case 16: 
          if (paramInt1 == 3) {
            if (paramArrayOfByte == null)
            {
              arrayOfByte2 = aVj;
              i = 0;
              m = paramInt3;
            }
          }
          break;
        }
      }
    }
    for (paramInt3 = i;; paramInt3 = i)
    {
      int n = locall.dD(2);
      int j;
      if (n != 0)
      {
        j = 1;
        i = paramInt3;
        paramInt3 = n;
      }
      for (;;)
      {
        if ((j != 0) && (paramPaint != null))
        {
          n = paramInt3;
          if (arrayOfByte2 != null) {
            n = arrayOfByte2[paramInt3];
          }
          paramPaint.setColor(paramArrayOfInt[n]);
          paramCanvas.drawRect(m, k, m + j, k + 1, paramPaint);
        }
        paramInt3 = m + j;
        if (i == 0) {
          break label1100;
        }
        locall.qL();
        break;
        arrayOfByte2 = paramArrayOfByte;
        break label129;
        if (paramInt1 == 2)
        {
          if (arrayOfByte1 == null) {}
          for (arrayOfByte2 = aVi;; arrayOfByte2 = arrayOfByte1) {
            break;
          }
        }
        arrayOfByte2 = null;
        break label129;
        if (locall.oj())
        {
          i = locall.dD(3);
          n = locall.dD(2);
          j = i + 3;
          i = paramInt3;
          paramInt3 = n;
        }
        else if (locall.oj())
        {
          n = 0;
          j = 1;
          i = paramInt3;
          paramInt3 = n;
        }
        else
        {
          switch (locall.dD(2))
          {
          default: 
            n = 0;
            j = 0;
            i = paramInt3;
            paramInt3 = n;
            break;
          case 0: 
            paramInt3 = 0;
            j = 0;
            i = 1;
            break;
          case 1: 
            n = 0;
            j = 2;
            i = paramInt3;
            paramInt3 = n;
            break;
          case 2: 
            i = locall.dD(4);
            n = locall.dD(2);
            j = i + 12;
            i = paramInt3;
            paramInt3 = n;
            break;
          case 3: 
            i = locall.dD(8);
            n = locall.dD(2);
            j = i + 29;
            i = paramInt3;
            paramInt3 = n;
          }
        }
      }
      if (paramInt1 == 3)
      {
        arrayOfByte2 = aVk;
        label509:
        i = 0;
        m = paramInt3;
      }
      for (paramInt3 = i;; paramInt3 = i)
      {
        n = locall.dD(4);
        if (n != 0)
        {
          j = 1;
          i = paramInt3;
          paramInt3 = n;
        }
        for (;;)
        {
          if ((j != 0) && (paramPaint != null))
          {
            n = paramInt3;
            if (arrayOfByte2 != null) {
              n = arrayOfByte2[paramInt3];
            }
            paramPaint.setColor(paramArrayOfInt[n]);
            paramCanvas.drawRect(m, k, m + j, k + 1, paramPaint);
          }
          paramInt3 = m + j;
          if (i == 0) {
            break label1089;
          }
          locall.qL();
          break;
          arrayOfByte2 = null;
          break label509;
          if (!locall.oj())
          {
            i = locall.dD(3);
            if (i != 0)
            {
              n = 0;
              j = i + 2;
              i = paramInt3;
              paramInt3 = n;
            }
            else
            {
              paramInt3 = 0;
              j = 0;
              i = 1;
            }
          }
          else if (!locall.oj())
          {
            i = locall.dD(2);
            n = locall.dD(4);
            j = i + 4;
            i = paramInt3;
            paramInt3 = n;
          }
          else
          {
            switch (locall.dD(2))
            {
            default: 
              n = 0;
              j = 0;
              i = paramInt3;
              paramInt3 = n;
              break;
            case 0: 
              n = 0;
              j = 1;
              i = paramInt3;
              paramInt3 = n;
              break;
            case 1: 
              n = 0;
              j = 2;
              i = paramInt3;
              paramInt3 = n;
              break;
            case 2: 
              i = locall.dD(4);
              n = locall.dD(4);
              j = i + 9;
              i = paramInt3;
              paramInt3 = n;
              break;
            case 3: 
              i = locall.dD(8);
              n = locall.dD(4);
              j = i + 25;
              i = paramInt3;
              paramInt3 = n;
            }
          }
        }
        i = 0;
        m = paramInt3;
        paramInt3 = i;
        label1086:
        for (;;)
        {
          i = locall.dD(8);
          if (i != 0) {
            j = 1;
          }
          for (;;)
          {
            if ((j != 0) && (paramPaint != null))
            {
              paramPaint.setColor(paramArrayOfInt[i]);
              paramCanvas.drawRect(m, k, m + j, k + 1, paramPaint);
            }
            m += j;
            if (paramInt3 == 0) {
              break label1086;
            }
            paramInt3 = m;
            break;
            if (!locall.oj())
            {
              j = locall.dD(7);
              if (j != 0)
              {
                i = 0;
              }
              else
              {
                i = 0;
                j = 0;
                paramInt3 = 1;
              }
            }
            else
            {
              j = locall.dD(7);
              i = locall.dD(8);
            }
          }
          arrayOfByte1 = a(4, 4, locall);
          break;
          paramArrayOfByte = a(4, 8, locall);
          break;
          paramArrayOfByte = a(16, 8, locall);
          break;
          k += 2;
          paramInt3 = paramInt2;
          break label112;
          AppMethodBeat.o(95633);
          return;
        }
        label1089:
        m = paramInt3;
      }
      label1100:
      m = paramInt3;
    }
  }
  
  private static byte[] a(int paramInt1, int paramInt2, l paraml)
  {
    AppMethodBeat.i(95634);
    byte[] arrayOfByte = new byte[paramInt1];
    int i = 0;
    while (i < paramInt1)
    {
      arrayOfByte[i] = ((byte)paraml.dD(paramInt2));
      i += 1;
    }
    AppMethodBeat.o(95634);
    return arrayOfByte;
  }
  
  private static b.a b(l paraml, int paramInt)
  {
    AppMethodBeat.i(95629);
    int n = paraml.dD(8);
    paraml.dE(8);
    paramInt -= 2;
    int[] arrayOfInt2 = pZ();
    int[] arrayOfInt3 = qa();
    int[] arrayOfInt4 = qb();
    if (paramInt > 0)
    {
      int i1 = paraml.dD(8);
      int i = paraml.dD(8);
      paramInt -= 2;
      int[] arrayOfInt1;
      label73:
      int m;
      int j;
      int k;
      if ((i & 0x80) != 0)
      {
        arrayOfInt1 = arrayOfInt2;
        if ((i & 0x1) == 0) {
          break label259;
        }
        m = paraml.dD(8);
        i = paraml.dD(8);
        j = paraml.dD(8);
        k = paraml.dD(8);
        paramInt -= 4;
      }
      for (;;)
      {
        if (m == 0)
        {
          i = 0;
          j = 0;
          k = 255;
        }
        k = (byte)(255 - (k & 0xFF));
        int i2 = (int)(m + 1.402D * (i - 128));
        i = (int)(m - 0.34414D * (j - 128) - 0.71414D * (i - 128));
        j = (int)(m + 1.772D * (j - 128));
        arrayOfInt1[i1] = m(k, x.t(i2, 0, 255), x.t(i, 0, 255), x.t(j, 0, 255));
        break;
        if ((i & 0x40) != 0)
        {
          arrayOfInt1 = arrayOfInt3;
          break label73;
        }
        arrayOfInt1 = arrayOfInt4;
        break label73;
        label259:
        m = paraml.dD(6) << 2;
        i = paraml.dD(4) << 4;
        j = paraml.dD(4) << 4;
        k = paraml.dD(2) << 6;
        paramInt -= 2;
      }
    }
    paraml = new b.a(n, arrayOfInt2, arrayOfInt3, arrayOfInt4);
    AppMethodBeat.o(95629);
    return paraml;
  }
  
  private static b.c b(l paraml)
  {
    byte[] arrayOfByte1 = null;
    AppMethodBeat.i(95630);
    int i = paraml.dD(16);
    paraml.dE(4);
    int j = paraml.dD(2);
    boolean bool = paraml.oj();
    paraml.dE(1);
    if (j == 1)
    {
      paraml.dE(paraml.dD(8) * 16);
      paraml = null;
      arrayOfByte1 = null;
    }
    for (;;)
    {
      paraml = new b.c(i, bool, arrayOfByte1, paraml);
      AppMethodBeat.o(95630);
      return paraml;
      if (j == 0)
      {
        j = paraml.dD(16);
        int k = paraml.dD(16);
        if (j > 0)
        {
          arrayOfByte1 = new byte[j];
          paraml.m(arrayOfByte1, j);
        }
        if (k > 0)
        {
          byte[] arrayOfByte2 = new byte[k];
          paraml.m(arrayOfByte2, k);
          paraml = arrayOfByte2;
        }
        else
        {
          paraml = arrayOfByte1;
        }
      }
      else
      {
        paraml = null;
        arrayOfByte1 = null;
      }
    }
  }
  
  private static int m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int[] pZ()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }
  
  private static int[] qa()
  {
    AppMethodBeat.i(95631);
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 0;
    int i = 1;
    if (i < 16)
    {
      int j;
      label40:
      int k;
      if (i < 8)
      {
        if ((i & 0x1) != 0)
        {
          j = 255;
          if ((i & 0x2) == 0) {
            break label85;
          }
          k = 255;
          label50:
          if ((i & 0x4) == 0) {
            break label90;
          }
        }
        label85:
        label90:
        for (m = 255;; m = 0)
        {
          arrayOfInt[i] = m(255, j, k, m);
          i += 1;
          break;
          j = 0;
          break label40;
          k = 0;
          break label50;
        }
      }
      if ((i & 0x1) != 0)
      {
        j = 127;
        label104:
        if ((i & 0x2) == 0) {
          break label143;
        }
        k = 127;
        label113:
        if ((i & 0x4) == 0) {
          break label148;
        }
      }
      label143:
      label148:
      for (int m = 127;; m = 0)
      {
        arrayOfInt[i] = m(255, j, k, m);
        break;
        j = 0;
        break label104;
        k = 0;
        break label113;
      }
    }
    AppMethodBeat.o(95631);
    return arrayOfInt;
  }
  
  private static int[] qb()
  {
    AppMethodBeat.i(95632);
    int[] arrayOfInt = new int[256];
    arrayOfInt[0] = 0;
    int i = 0;
    if (i < 256)
    {
      int j;
      label42:
      int k;
      label52:
      int m;
      if (i < 8) {
        if ((i & 0x1) != 0)
        {
          j = 255;
          if ((i & 0x2) == 0) {
            break label86;
          }
          k = 255;
          if ((i & 0x4) == 0) {
            break label91;
          }
          m = 255;
          label62:
          arrayOfInt[i] = m(63, j, k, m);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label42;
        label86:
        k = 0;
        break label52;
        label91:
        m = 0;
        break label62;
        switch (i & 0x88)
        {
        }
      }
      label156:
      label167:
      label176:
      int n;
      label188:
      int i1;
      if ((i & 0x1) != 0)
      {
        j = 85;
        if ((i & 0x10) == 0) {
          break label240;
        }
        k = 170;
        if ((i & 0x2) == 0) {
          break label245;
        }
        m = 85;
        if ((i & 0x20) == 0) {
          break label250;
        }
        n = 170;
        if ((i & 0x4) == 0) {
          break label256;
        }
        i1 = 85;
        label198:
        if ((i & 0x40) == 0) {
          break label262;
        }
      }
      label256:
      label262:
      for (int i2 = 170;; i2 = 0)
      {
        arrayOfInt[i] = m(255, j + k, m + n, i2 + i1);
        break;
        j = 0;
        break label156;
        label240:
        k = 0;
        break label167;
        label245:
        m = 0;
        break label176;
        label250:
        n = 0;
        break label188;
        i1 = 0;
        break label198;
      }
      if ((i & 0x1) != 0)
      {
        j = 85;
        label277:
        if ((i & 0x10) == 0) {
          break label360;
        }
        k = 170;
        label288:
        if ((i & 0x2) == 0) {
          break label365;
        }
        m = 85;
        label297:
        if ((i & 0x20) == 0) {
          break label370;
        }
        n = 170;
        label309:
        if ((i & 0x4) == 0) {
          break label376;
        }
        i1 = 85;
        label319:
        if ((i & 0x40) == 0) {
          break label382;
        }
      }
      label360:
      label365:
      label370:
      label376:
      label382:
      for (i2 = 170;; i2 = 0)
      {
        arrayOfInt[i] = m(127, j + k, m + n, i2 + i1);
        break;
        j = 0;
        break label277;
        k = 0;
        break label288;
        m = 0;
        break label297;
        n = 0;
        break label309;
        i1 = 0;
        break label319;
      }
      if ((i & 0x1) != 0)
      {
        j = 43;
        label397:
        if ((i & 0x10) == 0) {
          break label487;
        }
        k = 85;
        label407:
        if ((i & 0x2) == 0) {
          break label492;
        }
        m = 43;
        label416:
        if ((i & 0x20) == 0) {
          break label497;
        }
        n = 85;
        label427:
        if ((i & 0x4) == 0) {
          break label503;
        }
        i1 = 43;
        label437:
        if ((i & 0x40) == 0) {
          break label509;
        }
      }
      label487:
      label492:
      label497:
      label503:
      label509:
      for (i2 = 85;; i2 = 0)
      {
        arrayOfInt[i] = m(255, j + 127 + k, m + 127 + n, i2 + (i1 + 127));
        break;
        j = 0;
        break label397;
        k = 0;
        break label407;
        m = 0;
        break label416;
        n = 0;
        break label427;
        i1 = 0;
        break label437;
      }
      if ((i & 0x1) != 0)
      {
        j = 43;
        label524:
        if ((i & 0x10) == 0) {
          break label605;
        }
        k = 85;
        label534:
        if ((i & 0x2) == 0) {
          break label610;
        }
        m = 43;
        label543:
        if ((i & 0x20) == 0) {
          break label615;
        }
        n = 85;
        label554:
        if ((i & 0x4) == 0) {
          break label621;
        }
        i1 = 43;
        label564:
        if ((i & 0x40) == 0) {
          break label627;
        }
      }
      label605:
      label610:
      label615:
      label621:
      label627:
      for (i2 = 85;; i2 = 0)
      {
        arrayOfInt[i] = m(255, j + k, m + n, i2 + i1);
        break;
        j = 0;
        break label524;
        k = 0;
        break label534;
        m = 0;
        break label543;
        n = 0;
        break label554;
        i1 = 0;
        break label564;
      }
    }
    AppMethodBeat.o(95632);
    return arrayOfInt;
  }
  
  public final List<com.google.android.exoplayer2.f.a> e(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95627);
    paramArrayOfByte = new l(paramArrayOfByte, paramInt);
    Object localObject1;
    int i;
    int i1;
    label128:
    int m;
    int n;
    int j;
    int k;
    Object localObject3;
    while ((paramArrayOfByte.qI() >= 48) && (paramArrayOfByte.dD(8) == 15))
    {
      localObject1 = this.aVq;
      paramInt = paramArrayOfByte.dD(8);
      i = paramArrayOfByte.dD(16);
      i1 = paramArrayOfByte.dD(16);
      int i2 = paramArrayOfByte.qJ();
      if (i1 * 8 > paramArrayOfByte.qI())
      {
        paramArrayOfByte.dE(paramArrayOfByte.qI());
      }
      else
      {
        switch (paramInt)
        {
        default: 
          paramInt = paramArrayOfByte.qJ();
          if (paramArrayOfByte.aJo != 0) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          com.google.android.exoplayer2.i.a.checkState(bool);
          paramArrayOfByte.aJn += i2 + i1 - paramInt;
          paramArrayOfByte.ok();
          break;
          if (i != ((b.h)localObject1).aVS) {
            break label128;
          }
          paramArrayOfByte.dE(4);
          bool = paramArrayOfByte.oj();
          paramArrayOfByte.dE(3);
          m = paramArrayOfByte.dD(16);
          n = paramArrayOfByte.dD(16);
          if (bool)
          {
            paramInt = paramArrayOfByte.dD(16);
            i = paramArrayOfByte.dD(16);
            j = paramArrayOfByte.dD(16);
            k = paramArrayOfByte.dD(16);
          }
          for (;;)
          {
            ((b.h)localObject1).aVY = new b.b(m, n, paramInt, i, j, k);
            break;
            paramInt = 0;
            j = 0;
            k = n;
            i = m;
          }
          if (i != ((b.h)localObject1).aVS) {
            break label128;
          }
          localObject2 = ((b.h)localObject1).aVZ;
          i = paramArrayOfByte.dD(8);
          j = paramArrayOfByte.dD(4);
          k = paramArrayOfByte.dD(2);
          paramArrayOfByte.dE(2);
          paramInt = i1 - 2;
          localObject3 = new SparseArray();
          while (paramInt > 0)
          {
            m = paramArrayOfByte.dD(8);
            paramArrayOfByte.dE(8);
            n = paramArrayOfByte.dD(16);
            int i3 = paramArrayOfByte.dD(16);
            paramInt -= 6;
            ((SparseArray)localObject3).put(m, new b.e(n, i3));
          }
          localObject3 = new b.d(i, j, k, (SparseArray)localObject3);
          if (((b.d)localObject3).state != 0)
          {
            ((b.h)localObject1).aVZ = ((b.d)localObject3);
            ((b.h)localObject1).aVC.clear();
            ((b.h)localObject1).aVU.clear();
            ((b.h)localObject1).aVV.clear();
            break label128;
          }
          if ((localObject2 == null) || (((b.d)localObject2).version == ((b.d)localObject3).version)) {
            break label128;
          }
          ((b.h)localObject1).aVZ = ((b.d)localObject3);
          break label128;
          localObject2 = ((b.h)localObject1).aVZ;
          if ((i != ((b.h)localObject1).aVS) || (localObject2 == null)) {
            break label128;
          }
          localObject3 = a(paramArrayOfByte, i1);
          if (((b.d)localObject2).state == 0) {
            ((b.f)localObject3).a((b.f)((b.h)localObject1).aVC.get(((b.f)localObject3).id));
          }
          ((b.h)localObject1).aVC.put(((b.f)localObject3).id, localObject3);
          break label128;
          if (i == ((b.h)localObject1).aVS)
          {
            localObject2 = b(paramArrayOfByte, i1);
            ((b.h)localObject1).aVU.put(((b.a)localObject2).id, localObject2);
            break label128;
          }
          if (i != ((b.h)localObject1).aVT) {
            break label128;
          }
          localObject2 = b(paramArrayOfByte, i1);
          ((b.h)localObject1).aVW.put(((b.a)localObject2).id, localObject2);
          break label128;
          if (i == ((b.h)localObject1).aVS)
          {
            localObject2 = b(paramArrayOfByte);
            ((b.h)localObject1).aVV.put(((b.c)localObject2).id, localObject2);
            break label128;
          }
          if (i != ((b.h)localObject1).aVT) {
            break label128;
          }
          localObject2 = b(paramArrayOfByte);
          ((b.h)localObject1).aVX.put(((b.c)localObject2).id, localObject2);
          break label128;
        }
      }
    }
    if (this.aVq.aVZ == null)
    {
      paramArrayOfByte = Collections.emptyList();
      AppMethodBeat.o(95627);
      return paramArrayOfByte;
    }
    ArrayList localArrayList;
    b.f localf;
    if (this.aVq.aVY != null)
    {
      localObject1 = this.aVq.aVY;
      if ((this.bitmap == null) || (((b.b)localObject1).width + 1 != this.bitmap.getWidth()) || (((b.b)localObject1).height + 1 != this.bitmap.getHeight()))
      {
        this.bitmap = Bitmap.createBitmap(((b.b)localObject1).width + 1, ((b.b)localObject1).height + 1, Bitmap.Config.ARGB_8888);
        this.aVn.setBitmap(this.bitmap);
      }
      localArrayList = new ArrayList();
      SparseArray localSparseArray1 = this.aVq.aVZ.aVC;
      i = 0;
      if (i >= localSparseArray1.size()) {
        break label1465;
      }
      paramArrayOfByte = (b.e)localSparseArray1.valueAt(i);
      paramInt = localSparseArray1.keyAt(i);
      localf = (b.f)this.aVq.aVC.get(paramInt);
      j = paramArrayOfByte.aVD + ((b.b)localObject1).aVu;
      k = paramArrayOfByte.aVE + ((b.b)localObject1).aVw;
      paramInt = Math.min(localf.width + j, ((b.b)localObject1).aVv);
      m = Math.min(localf.height + k, ((b.b)localObject1).aVx);
      this.aVn.clipRect(j, k, paramInt, m, Region.Op.REPLACE);
      localObject2 = (b.a)this.aVq.aVU.get(localf.aVI);
      paramArrayOfByte = (byte[])localObject2;
      if (localObject2 != null) {
        break label1476;
      }
      localObject2 = (b.a)this.aVq.aVW.get(localf.aVI);
      paramArrayOfByte = (byte[])localObject2;
      if (localObject2 != null) {
        break label1476;
      }
    }
    label1040:
    label1426:
    label1465:
    label1473:
    label1476:
    for (Object localObject2 = this.aVp;; localObject2 = paramArrayOfByte)
    {
      SparseArray localSparseArray2 = localf.aVM;
      paramInt = 0;
      if (paramInt < localSparseArray2.size())
      {
        m = localSparseArray2.keyAt(paramInt);
        paramArrayOfByte = (b.g)localSparseArray2.valueAt(paramInt);
        localObject3 = (b.c)this.aVq.aVV.get(m);
        if (localObject3 != null) {
          break label1473;
        }
        localObject3 = (b.c)this.aVq.aVX.get(m);
      }
      for (;;)
      {
        Paint localPaint;
        label1122:
        Canvas localCanvas;
        if (localObject3 != null)
        {
          if (!((b.c)localObject3).aVy) {
            break label1221;
          }
          localPaint = null;
          m = localf.aVH;
          n = j + paramArrayOfByte.aVO;
          i1 = k + paramArrayOfByte.aVP;
          localCanvas = this.aVn;
          if (m != 3) {
            break label1230;
          }
          paramArrayOfByte = ((b.a)localObject2).aVt;
        }
        for (;;)
        {
          a(((b.c)localObject3).aVz, paramArrayOfByte, m, n, i1, localPaint, localCanvas);
          a(((b.c)localObject3).aVA, paramArrayOfByte, m, n, i1 + 1, localPaint, localCanvas);
          paramInt += 1;
          break label1040;
          localObject1 = this.aVo;
          break;
          label1221:
          localPaint = this.aVl;
          break label1122;
          label1230:
          if (m == 2) {
            paramArrayOfByte = ((b.a)localObject2).aVs;
          } else {
            paramArrayOfByte = ((b.a)localObject2).aVr;
          }
        }
        if (localf.aVF)
        {
          if (localf.aVH != 3) {
            break label1426;
          }
          paramInt = localObject2.aVt[localf.aVJ];
        }
        for (;;)
        {
          this.aVm.setColor(paramInt);
          this.aVn.drawRect(j, k, localf.width + j, localf.height + k, this.aVm);
          localArrayList.add(new com.google.android.exoplayer2.f.a(Bitmap.createBitmap(this.bitmap, j, k, localf.width, localf.height), j / ((b.b)localObject1).width, k / ((b.b)localObject1).height, localf.width / ((b.b)localObject1).width, localf.height / ((b.b)localObject1).height));
          this.aVn.drawColor(0, PorterDuff.Mode.CLEAR);
          i += 1;
          break;
          if (localf.aVH == 2) {
            paramInt = localObject2.aVs[localf.aVK];
          } else {
            paramInt = localObject2.aVr[localf.aVL];
          }
        }
        AppMethodBeat.o(95627);
        return localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.b
 * JD-Core Version:    0.7.0.1
 */