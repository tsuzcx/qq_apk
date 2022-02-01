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
  private static final byte[] brk = { 0, 7, 8, 15 };
  private static final byte[] brl = { 0, 119, -120, -1 };
  private static final byte[] brm = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private Bitmap bitmap;
  private final Paint brn;
  private final Paint bro;
  private final Canvas brp;
  private final b brq;
  private final a brr;
  final h brs;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92794);
    this.brn = new Paint();
    this.brn.setStyle(Paint.Style.FILL_AND_STROKE);
    this.brn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.brn.setPathEffect(null);
    this.bro = new Paint();
    this.bro.setStyle(Paint.Style.FILL);
    this.bro.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    this.bro.setPathEffect(null);
    this.brp = new Canvas();
    this.brq = new b(719, 575, 0, 719, 0, 575);
    this.brr = new a(0, uN(), uO(), uP());
    this.brs = new h(paramInt1, paramInt2);
    AppMethodBeat.o(92794);
  }
  
  private static f a(l paraml, int paramInt)
  {
    AppMethodBeat.i(92796);
    int k = paraml.eo(8);
    paraml.ep(4);
    boolean bool = paraml.te();
    paraml.ep(3);
    int m = paraml.eo(16);
    int n = paraml.eo(16);
    int i1 = paraml.eo(3);
    int i2 = paraml.eo(3);
    paraml.ep(2);
    int i3 = paraml.eo(8);
    int i4 = paraml.eo(8);
    int i5 = paraml.eo(4);
    int i6 = paraml.eo(2);
    paraml.ep(2);
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
      i7 = paraml.eo(16);
      i8 = paraml.eo(2);
      i9 = paraml.eo(2);
      i10 = paraml.eo(12);
      paraml.ep(4);
      i11 = paraml.eo(12);
      paramInt -= 6;
      i = 0;
      j = 0;
      if ((i8 != 1) && (i8 != 2)) {
        break label263;
      }
      i = paraml.eo(8);
      j = paraml.eo(8);
      paramInt -= 2;
    }
    label263:
    for (;;)
    {
      localSparseArray.put(i7, new g(i8, i9, i10, i11, i, j));
      break;
      paraml = new f(k, bool, m, n, i1, i2, i3, i4, i5, i6, localSparseArray);
      AppMethodBeat.o(92796);
      return paraml;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    AppMethodBeat.i(92801);
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
      if (locall.vu() != 0) {
        switch (locall.eo(8))
        {
        default: 
          break;
        case 16: 
          if (paramInt1 == 3) {
            if (paramArrayOfByte == null)
            {
              arrayOfByte2 = brl;
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
      int n = locall.eo(2);
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
        locall.vx();
        break;
        arrayOfByte2 = paramArrayOfByte;
        break label129;
        if (paramInt1 == 2)
        {
          if (arrayOfByte1 == null) {}
          for (arrayOfByte2 = brk;; arrayOfByte2 = arrayOfByte1) {
            break;
          }
        }
        arrayOfByte2 = null;
        break label129;
        if (locall.te())
        {
          i = locall.eo(3);
          n = locall.eo(2);
          j = i + 3;
          i = paramInt3;
          paramInt3 = n;
        }
        else if (locall.te())
        {
          n = 0;
          j = 1;
          i = paramInt3;
          paramInt3 = n;
        }
        else
        {
          switch (locall.eo(2))
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
            i = locall.eo(4);
            n = locall.eo(2);
            j = i + 12;
            i = paramInt3;
            paramInt3 = n;
            break;
          case 3: 
            i = locall.eo(8);
            n = locall.eo(2);
            j = i + 29;
            i = paramInt3;
            paramInt3 = n;
          }
        }
      }
      if (paramInt1 == 3)
      {
        arrayOfByte2 = brm;
        label509:
        i = 0;
        m = paramInt3;
      }
      for (paramInt3 = i;; paramInt3 = i)
      {
        n = locall.eo(4);
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
          locall.vx();
          break;
          arrayOfByte2 = null;
          break label509;
          if (!locall.te())
          {
            i = locall.eo(3);
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
          else if (!locall.te())
          {
            i = locall.eo(2);
            n = locall.eo(4);
            j = i + 4;
            i = paramInt3;
            paramInt3 = n;
          }
          else
          {
            switch (locall.eo(2))
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
              i = locall.eo(4);
              n = locall.eo(4);
              j = i + 9;
              i = paramInt3;
              paramInt3 = n;
              break;
            case 3: 
              i = locall.eo(8);
              n = locall.eo(4);
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
          i = locall.eo(8);
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
            if (!locall.te())
            {
              j = locall.eo(7);
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
              j = locall.eo(7);
              i = locall.eo(8);
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
          AppMethodBeat.o(92801);
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
    AppMethodBeat.i(92802);
    byte[] arrayOfByte = new byte[paramInt1];
    int i = 0;
    while (i < paramInt1)
    {
      arrayOfByte[i] = ((byte)paraml.eo(paramInt2));
      i += 1;
    }
    AppMethodBeat.o(92802);
    return arrayOfByte;
  }
  
  private static a b(l paraml, int paramInt)
  {
    AppMethodBeat.i(92797);
    int n = paraml.eo(8);
    paraml.ep(8);
    paramInt -= 2;
    int[] arrayOfInt2 = uN();
    int[] arrayOfInt3 = uO();
    int[] arrayOfInt4 = uP();
    if (paramInt > 0)
    {
      int i1 = paraml.eo(8);
      int i = paraml.eo(8);
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
        m = paraml.eo(8);
        i = paraml.eo(8);
        j = paraml.eo(8);
        k = paraml.eo(8);
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
        arrayOfInt1[i1] = n(k, x.v(i2, 0, 255), x.v(i, 0, 255), x.v(j, 0, 255));
        break;
        if ((i & 0x40) != 0)
        {
          arrayOfInt1 = arrayOfInt3;
          break label73;
        }
        arrayOfInt1 = arrayOfInt4;
        break label73;
        label259:
        m = paraml.eo(6) << 2;
        i = paraml.eo(4) << 4;
        j = paraml.eo(4) << 4;
        k = paraml.eo(2) << 6;
        paramInt -= 2;
      }
    }
    paraml = new a(n, arrayOfInt2, arrayOfInt3, arrayOfInt4);
    AppMethodBeat.o(92797);
    return paraml;
  }
  
  private static c b(l paraml)
  {
    byte[] arrayOfByte1 = null;
    AppMethodBeat.i(92798);
    int i = paraml.eo(16);
    paraml.ep(4);
    int j = paraml.eo(2);
    boolean bool = paraml.te();
    paraml.ep(1);
    if (j == 1)
    {
      paraml.ep(paraml.eo(8) * 16);
      paraml = null;
      arrayOfByte1 = null;
    }
    for (;;)
    {
      paraml = new c(i, bool, arrayOfByte1, paraml);
      AppMethodBeat.o(92798);
      return paraml;
      if (j == 0)
      {
        j = paraml.eo(16);
        int k = paraml.eo(16);
        if (j > 0)
        {
          arrayOfByte1 = new byte[j];
          paraml.p(arrayOfByte1, j);
        }
        if (k > 0)
        {
          byte[] arrayOfByte2 = new byte[k];
          paraml.p(arrayOfByte2, k);
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
  
  private static int n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int[] uN()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }
  
  private static int[] uO()
  {
    AppMethodBeat.i(92799);
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
          arrayOfInt[i] = n(255, j, k, m);
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
        arrayOfInt[i] = n(255, j, k, m);
        break;
        j = 0;
        break label104;
        k = 0;
        break label113;
      }
    }
    AppMethodBeat.o(92799);
    return arrayOfInt;
  }
  
  private static int[] uP()
  {
    AppMethodBeat.i(92800);
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
          arrayOfInt[i] = n(63, j, k, m);
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
        arrayOfInt[i] = n(255, j + k, m + n, i2 + i1);
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
        arrayOfInt[i] = n(127, j + k, m + n, i2 + i1);
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
        arrayOfInt[i] = n(255, j + 127 + k, m + 127 + n, i2 + (i1 + 127));
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
        arrayOfInt[i] = n(255, j + k, m + n, i2 + i1);
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
    AppMethodBeat.o(92800);
    return arrayOfInt;
  }
  
  public final List<com.google.android.exoplayer2.f.a> g(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92795);
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
    while ((paramArrayOfByte.vu() >= 48) && (paramArrayOfByte.eo(8) == 15))
    {
      localObject1 = this.brs;
      paramInt = paramArrayOfByte.eo(8);
      i = paramArrayOfByte.eo(16);
      i1 = paramArrayOfByte.eo(16);
      int i2 = paramArrayOfByte.vv();
      if (i1 * 8 > paramArrayOfByte.vu())
      {
        paramArrayOfByte.ep(paramArrayOfByte.vu());
      }
      else
      {
        switch (paramInt)
        {
        default: 
          paramInt = paramArrayOfByte.vv();
          if (paramArrayOfByte.bfu != 0) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          com.google.android.exoplayer2.i.a.checkState(bool);
          paramArrayOfByte.bft += i2 + i1 - paramInt;
          paramArrayOfByte.tf();
          break;
          if (i != ((h)localObject1).brU) {
            break label128;
          }
          paramArrayOfByte.ep(4);
          bool = paramArrayOfByte.te();
          paramArrayOfByte.ep(3);
          m = paramArrayOfByte.eo(16);
          n = paramArrayOfByte.eo(16);
          if (bool)
          {
            paramInt = paramArrayOfByte.eo(16);
            i = paramArrayOfByte.eo(16);
            j = paramArrayOfByte.eo(16);
            k = paramArrayOfByte.eo(16);
          }
          for (;;)
          {
            ((h)localObject1).bsa = new b(m, n, paramInt, i, j, k);
            break;
            paramInt = 0;
            j = 0;
            k = n;
            i = m;
          }
          if (i != ((h)localObject1).brU) {
            break label128;
          }
          localObject2 = ((h)localObject1).bsb;
          i = paramArrayOfByte.eo(8);
          j = paramArrayOfByte.eo(4);
          k = paramArrayOfByte.eo(2);
          paramArrayOfByte.ep(2);
          paramInt = i1 - 2;
          localObject3 = new SparseArray();
          while (paramInt > 0)
          {
            m = paramArrayOfByte.eo(8);
            paramArrayOfByte.ep(8);
            n = paramArrayOfByte.eo(16);
            int i3 = paramArrayOfByte.eo(16);
            paramInt -= 6;
            ((SparseArray)localObject3).put(m, new e(n, i3));
          }
          localObject3 = new d(i, j, k, (SparseArray)localObject3);
          if (((d)localObject3).state != 0)
          {
            ((h)localObject1).bsb = ((d)localObject3);
            ((h)localObject1).brE.clear();
            ((h)localObject1).brW.clear();
            ((h)localObject1).brX.clear();
            break label128;
          }
          if ((localObject2 == null) || (((d)localObject2).version == ((d)localObject3).version)) {
            break label128;
          }
          ((h)localObject1).bsb = ((d)localObject3);
          break label128;
          localObject2 = ((h)localObject1).bsb;
          if ((i != ((h)localObject1).brU) || (localObject2 == null)) {
            break label128;
          }
          localObject3 = a(paramArrayOfByte, i1);
          if (((d)localObject2).state == 0) {
            ((f)localObject3).a((f)((h)localObject1).brE.get(((f)localObject3).id));
          }
          ((h)localObject1).brE.put(((f)localObject3).id, localObject3);
          break label128;
          if (i == ((h)localObject1).brU)
          {
            localObject2 = b(paramArrayOfByte, i1);
            ((h)localObject1).brW.put(((a)localObject2).id, localObject2);
            break label128;
          }
          if (i != ((h)localObject1).brV) {
            break label128;
          }
          localObject2 = b(paramArrayOfByte, i1);
          ((h)localObject1).brY.put(((a)localObject2).id, localObject2);
          break label128;
          if (i == ((h)localObject1).brU)
          {
            localObject2 = b(paramArrayOfByte);
            ((h)localObject1).brX.put(((c)localObject2).id, localObject2);
            break label128;
          }
          if (i != ((h)localObject1).brV) {
            break label128;
          }
          localObject2 = b(paramArrayOfByte);
          ((h)localObject1).brZ.put(((c)localObject2).id, localObject2);
          break label128;
        }
      }
    }
    if (this.brs.bsb == null)
    {
      paramArrayOfByte = Collections.emptyList();
      AppMethodBeat.o(92795);
      return paramArrayOfByte;
    }
    ArrayList localArrayList;
    f localf;
    if (this.brs.bsa != null)
    {
      localObject1 = this.brs.bsa;
      if ((this.bitmap == null) || (((b)localObject1).width + 1 != this.bitmap.getWidth()) || (((b)localObject1).height + 1 != this.bitmap.getHeight()))
      {
        this.bitmap = Bitmap.createBitmap(((b)localObject1).width + 1, ((b)localObject1).height + 1, Bitmap.Config.ARGB_8888);
        this.brp.setBitmap(this.bitmap);
      }
      localArrayList = new ArrayList();
      SparseArray localSparseArray1 = this.brs.bsb.brE;
      i = 0;
      if (i >= localSparseArray1.size()) {
        break label1465;
      }
      paramArrayOfByte = (e)localSparseArray1.valueAt(i);
      paramInt = localSparseArray1.keyAt(i);
      localf = (f)this.brs.brE.get(paramInt);
      j = paramArrayOfByte.brF + ((b)localObject1).brw;
      k = paramArrayOfByte.brG + ((b)localObject1).bry;
      paramInt = Math.min(localf.width + j, ((b)localObject1).brx);
      m = Math.min(localf.height + k, ((b)localObject1).brz);
      this.brp.clipRect(j, k, paramInt, m, Region.Op.REPLACE);
      localObject2 = (a)this.brs.brW.get(localf.brK);
      paramArrayOfByte = (byte[])localObject2;
      if (localObject2 != null) {
        break label1476;
      }
      localObject2 = (a)this.brs.brY.get(localf.brK);
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
    for (Object localObject2 = this.brr;; localObject2 = paramArrayOfByte)
    {
      SparseArray localSparseArray2 = localf.brO;
      paramInt = 0;
      if (paramInt < localSparseArray2.size())
      {
        m = localSparseArray2.keyAt(paramInt);
        paramArrayOfByte = (g)localSparseArray2.valueAt(paramInt);
        localObject3 = (c)this.brs.brX.get(m);
        if (localObject3 != null) {
          break label1473;
        }
        localObject3 = (c)this.brs.brZ.get(m);
      }
      for (;;)
      {
        Paint localPaint;
        label1122:
        Canvas localCanvas;
        if (localObject3 != null)
        {
          if (!((c)localObject3).brA) {
            break label1221;
          }
          localPaint = null;
          m = localf.brJ;
          n = j + paramArrayOfByte.brQ;
          i1 = k + paramArrayOfByte.brR;
          localCanvas = this.brp;
          if (m != 3) {
            break label1230;
          }
          paramArrayOfByte = ((a)localObject2).brv;
        }
        for (;;)
        {
          a(((c)localObject3).brB, paramArrayOfByte, m, n, i1, localPaint, localCanvas);
          a(((c)localObject3).brC, paramArrayOfByte, m, n, i1 + 1, localPaint, localCanvas);
          paramInt += 1;
          break label1040;
          localObject1 = this.brq;
          break;
          label1221:
          localPaint = this.brn;
          break label1122;
          label1230:
          if (m == 2) {
            paramArrayOfByte = ((a)localObject2).bru;
          } else {
            paramArrayOfByte = ((a)localObject2).brt;
          }
        }
        if (localf.brH)
        {
          if (localf.brJ != 3) {
            break label1426;
          }
          paramInt = localObject2.brv[localf.brL];
        }
        for (;;)
        {
          this.bro.setColor(paramInt);
          this.brp.drawRect(j, k, localf.width + j, localf.height + k, this.bro);
          localArrayList.add(new com.google.android.exoplayer2.f.a(Bitmap.createBitmap(this.bitmap, j, k, localf.width, localf.height), j / ((b)localObject1).width, k / ((b)localObject1).height, localf.width / ((b)localObject1).width, localf.height / ((b)localObject1).height));
          this.brp.drawColor(0, PorterDuff.Mode.CLEAR);
          i += 1;
          break;
          if (localf.brJ == 2) {
            paramInt = localObject2.bru[localf.brM];
          } else {
            paramInt = localObject2.brt[localf.brN];
          }
        }
        AppMethodBeat.o(92795);
        return localArrayList;
      }
    }
  }
  
  static final class a
  {
    public final int[] brt;
    public final int[] bru;
    public final int[] brv;
    public final int id;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    {
      this.id = paramInt;
      this.brt = paramArrayOfInt1;
      this.bru = paramArrayOfInt2;
      this.brv = paramArrayOfInt3;
    }
  }
  
  static final class b
  {
    public final int brw;
    public final int brx;
    public final int bry;
    public final int brz;
    public final int height;
    public final int width;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.brw = paramInt3;
      this.brx = paramInt4;
      this.bry = paramInt5;
      this.brz = paramInt6;
    }
  }
  
  static final class c
  {
    public final boolean brA;
    public final byte[] brB;
    public final byte[] brC;
    public final int id;
    
    public c(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.id = paramInt;
      this.brA = paramBoolean;
      this.brB = paramArrayOfByte1;
      this.brC = paramArrayOfByte2;
    }
  }
  
  static final class d
  {
    public final int brD;
    public final SparseArray<b.e> brE;
    public final int state;
    public final int version;
    
    public d(int paramInt1, int paramInt2, int paramInt3, SparseArray<b.e> paramSparseArray)
    {
      this.brD = paramInt1;
      this.version = paramInt2;
      this.state = paramInt3;
      this.brE = paramSparseArray;
    }
  }
  
  static final class e
  {
    public final int brF;
    public final int brG;
    
    public e(int paramInt1, int paramInt2)
    {
      this.brF = paramInt1;
      this.brG = paramInt2;
    }
  }
  
  static final class f
  {
    public final boolean brH;
    public final int brI;
    public final int brJ;
    public final int brK;
    public final int brL;
    public final int brM;
    public final int brN;
    public final SparseArray<b.g> brO;
    public final int height;
    public final int id;
    public final int width;
    
    public f(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<b.g> paramSparseArray)
    {
      this.id = paramInt1;
      this.brH = paramBoolean;
      this.width = paramInt2;
      this.height = paramInt3;
      this.brI = paramInt4;
      this.brJ = paramInt5;
      this.brK = paramInt6;
      this.brL = paramInt7;
      this.brM = paramInt8;
      this.brN = paramInt9;
      this.brO = paramSparseArray;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(92792);
      if (paramf == null)
      {
        AppMethodBeat.o(92792);
        return;
      }
      paramf = paramf.brO;
      int i = 0;
      while (i < paramf.size())
      {
        this.brO.put(paramf.keyAt(i), paramf.valueAt(i));
        i += 1;
      }
      AppMethodBeat.o(92792);
    }
  }
  
  static final class g
  {
    public final int brP;
    public final int brQ;
    public final int brR;
    public final int brS;
    public final int brT;
    public final int type;
    
    public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.type = paramInt1;
      this.brP = paramInt2;
      this.brQ = paramInt3;
      this.brR = paramInt4;
      this.brS = paramInt5;
      this.brT = paramInt6;
    }
  }
  
  static final class h
  {
    public final SparseArray<b.f> brE;
    public final int brU;
    public final int brV;
    public final SparseArray<b.a> brW;
    public final SparseArray<b.c> brX;
    public final SparseArray<b.a> brY;
    public final SparseArray<b.c> brZ;
    public b.b bsa;
    public b.d bsb;
    
    public h(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92793);
      this.brE = new SparseArray();
      this.brW = new SparseArray();
      this.brX = new SparseArray();
      this.brY = new SparseArray();
      this.brZ = new SparseArray();
      this.brU = paramInt1;
      this.brV = paramInt2;
      AppMethodBeat.o(92793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.b
 * JD-Core Version:    0.7.0.1
 */