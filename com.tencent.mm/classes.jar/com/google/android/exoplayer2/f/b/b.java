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
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final byte[] aNO = { 0, 7, 8, 15 };
  private static final byte[] aNP = { 0, 119, -120, -1 };
  private static final byte[] aNQ = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private final Paint aNR = new Paint();
  private final Paint aNS;
  private final Canvas aNT;
  private final b.b aNU;
  private final b.a aNV;
  final b.h aNW;
  private Bitmap bitmap;
  
  public b(int paramInt1, int paramInt2)
  {
    this.aNR.setStyle(Paint.Style.FILL_AND_STROKE);
    this.aNR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.aNR.setPathEffect(null);
    this.aNS = new Paint();
    this.aNS.setStyle(Paint.Style.FILL);
    this.aNS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    this.aNS.setPathEffect(null);
    this.aNT = new Canvas();
    this.aNU = new b.b(719, 575, 0, 719, 0, 575);
    this.aNV = new b.a(0, nB(), nC(), nD());
    this.aNW = new b.h(paramInt1, paramInt2);
  }
  
  private static b.f a(i parami, int paramInt)
  {
    int k = parami.dz(8);
    parami.dy(4);
    boolean bool = parami.ob();
    parami.dy(3);
    int m = parami.dz(16);
    int n = parami.dz(16);
    int i1 = parami.dz(3);
    int i2 = parami.dz(3);
    parami.dy(2);
    int i3 = parami.dz(8);
    int i4 = parami.dz(8);
    int i5 = parami.dz(4);
    int i6 = parami.dz(2);
    parami.dy(2);
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
      i7 = parami.dz(16);
      i8 = parami.dz(2);
      i9 = parami.dz(2);
      i10 = parami.dz(12);
      parami.dy(4);
      i11 = parami.dz(12);
      paramInt -= 6;
      i = 0;
      j = 0;
      if ((i8 != 1) && (i8 != 2)) {
        break label251;
      }
      i = parami.dz(8);
      j = parami.dz(8);
      paramInt -= 2;
    }
    label251:
    for (;;)
    {
      localSparseArray.put(i7, new b.g(i8, i9, i10, i11, i, j));
      break;
      return new b.f(k, bool, m, n, i1, i2, i3, i4, i5, i6, localSparseArray);
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    i locali = new i(paramArrayOfByte);
    paramArrayOfByte = null;
    byte[] arrayOfByte1 = null;
    int i = paramInt2;
    int k = paramInt3;
    paramInt3 = i;
    label108:
    byte[] arrayOfByte2;
    label125:
    int m;
    for (;;)
    {
      if (locali.nZ() != 0) {
        switch (locali.dz(8))
        {
        default: 
          break;
        case 16: 
          if (paramInt1 == 3) {
            if (paramArrayOfByte == null)
            {
              arrayOfByte2 = aNP;
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
      int n = locali.dz(2);
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
          break label1095;
        }
        locali.oc();
        break;
        arrayOfByte2 = paramArrayOfByte;
        break label125;
        if (paramInt1 == 2)
        {
          if (arrayOfByte1 == null) {}
          for (arrayOfByte2 = aNO;; arrayOfByte2 = arrayOfByte1) {
            break;
          }
        }
        arrayOfByte2 = null;
        break label125;
        if (locali.ob())
        {
          i = locali.dz(3);
          n = locali.dz(2);
          j = i + 3;
          i = paramInt3;
          paramInt3 = n;
        }
        else if (locali.ob())
        {
          n = 0;
          j = 1;
          i = paramInt3;
          paramInt3 = n;
        }
        else
        {
          switch (locali.dz(2))
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
            i = locali.dz(4);
            n = locali.dz(2);
            j = i + 12;
            i = paramInt3;
            paramInt3 = n;
            break;
          case 3: 
            i = locali.dz(8);
            n = locali.dz(2);
            j = i + 29;
            i = paramInt3;
            paramInt3 = n;
          }
        }
      }
      if (paramInt1 == 3)
      {
        arrayOfByte2 = aNQ;
        label505:
        i = 0;
        m = paramInt3;
      }
      for (paramInt3 = i;; paramInt3 = i)
      {
        n = locali.dz(4);
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
            break label1084;
          }
          locali.oc();
          break;
          arrayOfByte2 = null;
          break label505;
          if (!locali.ob())
          {
            i = locali.dz(3);
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
          else if (!locali.ob())
          {
            i = locali.dz(2);
            n = locali.dz(4);
            j = i + 4;
            i = paramInt3;
            paramInt3 = n;
          }
          else
          {
            switch (locali.dz(2))
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
              i = locali.dz(4);
              n = locali.dz(4);
              j = i + 9;
              i = paramInt3;
              paramInt3 = n;
              break;
            case 3: 
              i = locali.dz(8);
              n = locali.dz(4);
              j = i + 25;
              i = paramInt3;
              paramInt3 = n;
            }
          }
        }
        i = 0;
        m = paramInt3;
        paramInt3 = i;
        for (;;)
        {
          i = locali.dz(8);
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
            i = m + j;
            if (paramInt3 == 0) {
              break label1077;
            }
            paramInt3 = i;
            break;
            if (!locali.ob())
            {
              j = locali.dz(7);
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
              j = locali.dz(7);
              i = locali.dz(8);
            }
          }
          arrayOfByte1 = a(4, 4, locali);
          break;
          paramArrayOfByte = a(4, 8, locali);
          break;
          paramArrayOfByte = a(16, 8, locali);
          break;
          k += 2;
          paramInt3 = paramInt2;
          break label108;
          return;
          label1077:
          m = i;
        }
        label1084:
        m = paramInt3;
      }
      label1095:
      m = paramInt3;
    }
  }
  
  private static byte[] a(int paramInt1, int paramInt2, i parami)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    int i = 0;
    while (i < paramInt1)
    {
      arrayOfByte[i] = ((byte)parami.dz(paramInt2));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static b.a b(i parami, int paramInt)
  {
    int n = parami.dz(8);
    parami.dy(8);
    paramInt -= 2;
    int[] arrayOfInt2 = nB();
    int[] arrayOfInt3 = nC();
    int[] arrayOfInt4 = nD();
    if (paramInt > 0)
    {
      int i1 = parami.dz(8);
      int i = parami.dz(8);
      paramInt -= 2;
      int[] arrayOfInt1;
      label68:
      int m;
      int j;
      int k;
      if ((i & 0x80) != 0)
      {
        arrayOfInt1 = arrayOfInt2;
        if ((i & 0x1) == 0) {
          break label254;
        }
        m = parami.dz(8);
        i = parami.dz(8);
        j = parami.dz(8);
        k = parami.dz(8);
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
        arrayOfInt1[i1] = k(k, t.t(i2, 0, 255), t.t(i, 0, 255), t.t(j, 0, 255));
        break;
        if ((i & 0x40) != 0)
        {
          arrayOfInt1 = arrayOfInt3;
          break label68;
        }
        arrayOfInt1 = arrayOfInt4;
        break label68;
        label254:
        m = parami.dz(6) << 2;
        i = parami.dz(4) << 4;
        j = parami.dz(4) << 4;
        k = parami.dz(2) << 6;
        paramInt -= 2;
      }
    }
    return new b.a(n, arrayOfInt2, arrayOfInt3, arrayOfInt4);
  }
  
  private static b.c b(i parami)
  {
    byte[] arrayOfByte1 = null;
    int i = parami.dz(16);
    parami.dy(4);
    int j = parami.dz(2);
    boolean bool = parami.ob();
    parami.dy(1);
    if (j == 1)
    {
      parami.dy(parami.dz(8) * 16);
      parami = null;
      arrayOfByte1 = null;
    }
    for (;;)
    {
      return new b.c(i, bool, arrayOfByte1, parami);
      if (j == 0)
      {
        j = parami.dz(16);
        int k = parami.dz(16);
        if (j > 0)
        {
          arrayOfByte1 = new byte[j];
          parami.n(arrayOfByte1, j);
        }
        if (k > 0)
        {
          byte[] arrayOfByte2 = new byte[k];
          parami.n(arrayOfByte2, k);
          parami = arrayOfByte2;
        }
        else
        {
          parami = arrayOfByte1;
        }
      }
      else
      {
        parami = null;
        arrayOfByte1 = null;
      }
    }
  }
  
  private static int k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int[] nB()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }
  
  private static int[] nC()
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 0;
    int i = 1;
    if (i < 16)
    {
      int j;
      label35:
      int k;
      if (i < 8)
      {
        if ((i & 0x1) != 0)
        {
          j = 255;
          if ((i & 0x2) == 0) {
            break label80;
          }
          k = 255;
          label45:
          if ((i & 0x4) == 0) {
            break label85;
          }
        }
        label80:
        label85:
        for (m = 255;; m = 0)
        {
          arrayOfInt[i] = k(255, j, k, m);
          i += 1;
          break;
          j = 0;
          break label35;
          k = 0;
          break label45;
        }
      }
      if ((i & 0x1) != 0)
      {
        j = 127;
        label99:
        if ((i & 0x2) == 0) {
          break label138;
        }
        k = 127;
        label108:
        if ((i & 0x4) == 0) {
          break label143;
        }
      }
      label138:
      label143:
      for (int m = 127;; m = 0)
      {
        arrayOfInt[i] = k(255, j, k, m);
        break;
        j = 0;
        break label99;
        k = 0;
        break label108;
      }
    }
    return arrayOfInt;
  }
  
  private static int[] nD()
  {
    int[] arrayOfInt = new int[256];
    arrayOfInt[0] = 0;
    int i = 0;
    if (i < 256)
    {
      int j;
      label37:
      int k;
      label47:
      int m;
      if (i < 8) {
        if ((i & 0x1) != 0)
        {
          j = 255;
          if ((i & 0x2) == 0) {
            break label81;
          }
          k = 255;
          if ((i & 0x4) == 0) {
            break label86;
          }
          m = 255;
          label57:
          arrayOfInt[i] = k(63, j, k, m);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label37;
        label81:
        k = 0;
        break label47;
        label86:
        m = 0;
        break label57;
        switch (i & 0x88)
        {
        }
      }
      label152:
      label163:
      label172:
      int n;
      label184:
      int i1;
      if ((i & 0x1) != 0)
      {
        j = 85;
        if ((i & 0x10) == 0) {
          break label236;
        }
        k = 170;
        if ((i & 0x2) == 0) {
          break label241;
        }
        m = 85;
        if ((i & 0x20) == 0) {
          break label246;
        }
        n = 170;
        if ((i & 0x4) == 0) {
          break label252;
        }
        i1 = 85;
        label194:
        if ((i & 0x40) == 0) {
          break label258;
        }
      }
      label258:
      for (int i2 = 170;; i2 = 0)
      {
        arrayOfInt[i] = k(255, j + k, m + n, i2 + i1);
        break;
        j = 0;
        break label152;
        label236:
        k = 0;
        break label163;
        label241:
        m = 0;
        break label172;
        label246:
        n = 0;
        break label184;
        label252:
        i1 = 0;
        break label194;
      }
      if ((i & 0x1) != 0)
      {
        j = 85;
        label273:
        if ((i & 0x10) == 0) {
          break label356;
        }
        k = 170;
        label284:
        if ((i & 0x2) == 0) {
          break label361;
        }
        m = 85;
        label293:
        if ((i & 0x20) == 0) {
          break label366;
        }
        n = 170;
        label305:
        if ((i & 0x4) == 0) {
          break label372;
        }
        i1 = 85;
        label315:
        if ((i & 0x40) == 0) {
          break label378;
        }
      }
      label356:
      label361:
      label366:
      label372:
      label378:
      for (i2 = 170;; i2 = 0)
      {
        arrayOfInt[i] = k(127, j + k, m + n, i2 + i1);
        break;
        j = 0;
        break label273;
        k = 0;
        break label284;
        m = 0;
        break label293;
        n = 0;
        break label305;
        i1 = 0;
        break label315;
      }
      if ((i & 0x1) != 0)
      {
        j = 43;
        label393:
        if ((i & 0x10) == 0) {
          break label483;
        }
        k = 85;
        label403:
        if ((i & 0x2) == 0) {
          break label488;
        }
        m = 43;
        label412:
        if ((i & 0x20) == 0) {
          break label493;
        }
        n = 85;
        label423:
        if ((i & 0x4) == 0) {
          break label499;
        }
        i1 = 43;
        label433:
        if ((i & 0x40) == 0) {
          break label505;
        }
      }
      label483:
      label488:
      label493:
      label499:
      label505:
      for (i2 = 85;; i2 = 0)
      {
        arrayOfInt[i] = k(255, j + 127 + k, m + 127 + n, i2 + (i1 + 127));
        break;
        j = 0;
        break label393;
        k = 0;
        break label403;
        m = 0;
        break label412;
        n = 0;
        break label423;
        i1 = 0;
        break label433;
      }
      if ((i & 0x1) != 0)
      {
        j = 43;
        label520:
        if ((i & 0x10) == 0) {
          break label601;
        }
        k = 85;
        label530:
        if ((i & 0x2) == 0) {
          break label606;
        }
        m = 43;
        label539:
        if ((i & 0x20) == 0) {
          break label611;
        }
        n = 85;
        label550:
        if ((i & 0x4) == 0) {
          break label617;
        }
        i1 = 43;
        label560:
        if ((i & 0x40) == 0) {
          break label623;
        }
      }
      label601:
      label606:
      label611:
      label617:
      label623:
      for (i2 = 85;; i2 = 0)
      {
        arrayOfInt[i] = k(255, j + k, m + n, i2 + i1);
        break;
        j = 0;
        break label520;
        k = 0;
        break label530;
        m = 0;
        break label539;
        n = 0;
        break label550;
        i1 = 0;
        break label560;
      }
    }
    return arrayOfInt;
  }
  
  public final List<com.google.android.exoplayer2.f.a> f(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new i(paramArrayOfByte, paramInt);
    Object localObject1;
    int i;
    int i1;
    label124:
    int m;
    int n;
    int j;
    int k;
    Object localObject3;
    while ((paramArrayOfByte.nZ() >= 48) && (paramArrayOfByte.dz(8) == 15))
    {
      localObject1 = this.aNW;
      paramInt = paramArrayOfByte.dz(8);
      i = paramArrayOfByte.dz(16);
      i1 = paramArrayOfByte.dz(16);
      int i2 = paramArrayOfByte.oa();
      if (i1 * 8 > paramArrayOfByte.nZ())
      {
        paramArrayOfByte.dy(paramArrayOfByte.nZ());
      }
      else
      {
        switch (paramInt)
        {
        default: 
          paramInt = paramArrayOfByte.oa();
          if (paramArrayOfByte.aSB != 0) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          com.google.android.exoplayer2.i.a.aC(bool);
          paramArrayOfByte.aSA += i2 + i1 - paramInt;
          paramArrayOfByte.od();
          break;
          if (i != ((b.h)localObject1).aOy) {
            break label124;
          }
          paramArrayOfByte.dy(4);
          bool = paramArrayOfByte.ob();
          paramArrayOfByte.dy(3);
          m = paramArrayOfByte.dz(16);
          n = paramArrayOfByte.dz(16);
          if (bool)
          {
            paramInt = paramArrayOfByte.dz(16);
            i = paramArrayOfByte.dz(16);
            j = paramArrayOfByte.dz(16);
            k = paramArrayOfByte.dz(16);
          }
          for (;;)
          {
            ((b.h)localObject1).aOE = new b.b(m, n, paramInt, i, j, k);
            break;
            paramInt = 0;
            j = 0;
            k = n;
            i = m;
          }
          if (i != ((b.h)localObject1).aOy) {
            break label124;
          }
          localObject2 = ((b.h)localObject1).aOF;
          i = paramArrayOfByte.dz(8);
          j = paramArrayOfByte.dz(4);
          k = paramArrayOfByte.dz(2);
          paramArrayOfByte.dy(2);
          paramInt = i1 - 2;
          localObject3 = new SparseArray();
          while (paramInt > 0)
          {
            m = paramArrayOfByte.dz(8);
            paramArrayOfByte.dy(8);
            n = paramArrayOfByte.dz(16);
            int i3 = paramArrayOfByte.dz(16);
            paramInt -= 6;
            ((SparseArray)localObject3).put(m, new b.e(n, i3));
          }
          localObject3 = new b.d(i, j, k, (SparseArray)localObject3);
          if (((b.d)localObject3).state != 0)
          {
            ((b.h)localObject1).aOF = ((b.d)localObject3);
            ((b.h)localObject1).aOi.clear();
            ((b.h)localObject1).aOA.clear();
            ((b.h)localObject1).aOB.clear();
            break label124;
          }
          if ((localObject2 == null) || (((b.d)localObject2).version == ((b.d)localObject3).version)) {
            break label124;
          }
          ((b.h)localObject1).aOF = ((b.d)localObject3);
          break label124;
          localObject2 = ((b.h)localObject1).aOF;
          if ((i != ((b.h)localObject1).aOy) || (localObject2 == null)) {
            break label124;
          }
          localObject3 = a(paramArrayOfByte, i1);
          if (((b.d)localObject2).state == 0) {
            ((b.f)localObject3).a((b.f)((b.h)localObject1).aOi.get(((b.f)localObject3).id));
          }
          ((b.h)localObject1).aOi.put(((b.f)localObject3).id, localObject3);
          break label124;
          if (i == ((b.h)localObject1).aOy)
          {
            localObject2 = b(paramArrayOfByte, i1);
            ((b.h)localObject1).aOA.put(((b.a)localObject2).id, localObject2);
            break label124;
          }
          if (i != ((b.h)localObject1).aOz) {
            break label124;
          }
          localObject2 = b(paramArrayOfByte, i1);
          ((b.h)localObject1).aOC.put(((b.a)localObject2).id, localObject2);
          break label124;
          if (i == ((b.h)localObject1).aOy)
          {
            localObject2 = b(paramArrayOfByte);
            ((b.h)localObject1).aOB.put(((b.c)localObject2).id, localObject2);
            break label124;
          }
          if (i != ((b.h)localObject1).aOz) {
            break label124;
          }
          localObject2 = b(paramArrayOfByte);
          ((b.h)localObject1).aOD.put(((b.c)localObject2).id, localObject2);
          break label124;
        }
      }
    }
    if (this.aNW.aOF == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList;
    b.f localf;
    if (this.aNW.aOE != null)
    {
      localObject1 = this.aNW.aOE;
      if ((this.bitmap == null) || (((b.b)localObject1).width + 1 != this.bitmap.getWidth()) || (((b.b)localObject1).height + 1 != this.bitmap.getHeight()))
      {
        this.bitmap = Bitmap.createBitmap(((b.b)localObject1).width + 1, ((b.b)localObject1).height + 1, Bitmap.Config.ARGB_8888);
        this.aNT.setBitmap(this.bitmap);
      }
      localArrayList = new ArrayList();
      SparseArray localSparseArray1 = this.aNW.aOF.aOi;
      i = 0;
      if (i >= localSparseArray1.size()) {
        break label1454;
      }
      paramArrayOfByte = (b.e)localSparseArray1.valueAt(i);
      paramInt = localSparseArray1.keyAt(i);
      localf = (b.f)this.aNW.aOi.get(paramInt);
      j = paramArrayOfByte.aOj + ((b.b)localObject1).aOa;
      k = paramArrayOfByte.aOk + ((b.b)localObject1).aOc;
      paramInt = Math.min(localf.width + j, ((b.b)localObject1).aOb);
      m = Math.min(localf.height + k, ((b.b)localObject1).aOd);
      this.aNT.clipRect(j, k, paramInt, m, Region.Op.REPLACE);
      localObject2 = (b.a)this.aNW.aOA.get(localf.aOo);
      paramArrayOfByte = (byte[])localObject2;
      if (localObject2 != null) {
        break label1460;
      }
      localObject2 = (b.a)this.aNW.aOC.get(localf.aOo);
      paramArrayOfByte = (byte[])localObject2;
      if (localObject2 != null) {
        break label1460;
      }
    }
    label1029:
    label1415:
    label1454:
    label1457:
    label1460:
    for (Object localObject2 = this.aNV;; localObject2 = paramArrayOfByte)
    {
      SparseArray localSparseArray2 = localf.aOs;
      paramInt = 0;
      if (paramInt < localSparseArray2.size())
      {
        m = localSparseArray2.keyAt(paramInt);
        paramArrayOfByte = (b.g)localSparseArray2.valueAt(paramInt);
        localObject3 = (b.c)this.aNW.aOB.get(m);
        if (localObject3 != null) {
          break label1457;
        }
        localObject3 = (b.c)this.aNW.aOD.get(m);
      }
      for (;;)
      {
        Paint localPaint;
        label1111:
        Canvas localCanvas;
        if (localObject3 != null)
        {
          if (!((b.c)localObject3).aOe) {
            break label1210;
          }
          localPaint = null;
          m = localf.aOn;
          n = j + paramArrayOfByte.aOu;
          i1 = k + paramArrayOfByte.aOv;
          localCanvas = this.aNT;
          if (m != 3) {
            break label1219;
          }
          paramArrayOfByte = ((b.a)localObject2).aNZ;
        }
        for (;;)
        {
          a(((b.c)localObject3).aOf, paramArrayOfByte, m, n, i1, localPaint, localCanvas);
          a(((b.c)localObject3).aOg, paramArrayOfByte, m, n, i1 + 1, localPaint, localCanvas);
          paramInt += 1;
          break label1029;
          localObject1 = this.aNU;
          break;
          label1210:
          localPaint = this.aNR;
          break label1111;
          label1219:
          if (m == 2) {
            paramArrayOfByte = ((b.a)localObject2).aNY;
          } else {
            paramArrayOfByte = ((b.a)localObject2).aNX;
          }
        }
        if (localf.aOl)
        {
          if (localf.aOn != 3) {
            break label1415;
          }
          paramInt = localObject2.aNZ[localf.aOp];
        }
        for (;;)
        {
          this.aNS.setColor(paramInt);
          this.aNT.drawRect(j, k, localf.width + j, localf.height + k, this.aNS);
          localArrayList.add(new com.google.android.exoplayer2.f.a(Bitmap.createBitmap(this.bitmap, j, k, localf.width, localf.height), j / ((b.b)localObject1).width, k / ((b.b)localObject1).height, localf.width / ((b.b)localObject1).width, localf.height / ((b.b)localObject1).height));
          this.aNT.drawColor(0, PorterDuff.Mode.CLEAR);
          i += 1;
          break;
          if (localf.aOn == 2) {
            paramInt = localObject2.aNY[localf.aOq];
          } else {
            paramInt = localObject2.aNX[localf.aOr];
          }
        }
        return localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.b
 * JD-Core Version:    0.7.0.1
 */