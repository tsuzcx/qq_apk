package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  public static final int bfU;
  private final a bkh;
  
  static
  {
    AppMethodBeat.i(92443);
    bfU = x.aQ("ID3");
    AppMethodBeat.o(92443);
  }
  
  public a()
  {
    this(null);
  }
  
  public a(a parama)
  {
    this.bkh = parama;
  }
  
  private static ChapterFrame a(m paramm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, a parama)
  {
    AppMethodBeat.i(92437);
    int i = paramm.position;
    int j = e(paramm.data, i);
    String str = new String(paramm.data, i, j - i, "ISO-8859-1");
    paramm.setPosition(j + 1);
    j = paramm.readInt();
    int k = paramm.readInt();
    long l2 = paramm.dm();
    long l1 = l2;
    if (l2 == 4294967295L) {
      l1 = -1L;
    }
    long l3 = paramm.dm();
    l2 = l3;
    if (l3 == 4294967295L) {
      l2 = -1L;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramm.position < i + paramInt1)
    {
      Id3Frame localId3Frame = a(paramInt2, paramm, paramBoolean, paramInt3, parama);
      if (localId3Frame != null) {
        localArrayList.add(localId3Frame);
      }
    }
    paramm = new Id3Frame[localArrayList.size()];
    localArrayList.toArray(paramm);
    paramm = new ChapterFrame(str, j, k, l1, l2, paramm);
    AppMethodBeat.o(92437);
    return paramm;
  }
  
  private static Id3Frame a(int paramInt1, m paramm, boolean paramBoolean, int paramInt2, a parama)
  {
    AppMethodBeat.i(92436);
    int i5 = paramm.readUnsignedByte();
    int i6 = paramm.readUnsignedByte();
    int i7 = paramm.readUnsignedByte();
    int i2;
    int i;
    if (paramInt1 >= 3)
    {
      i2 = paramm.readUnsignedByte();
      if (paramInt1 != 4) {
        break label162;
      }
      j = paramm.vF();
      i = j;
      if (!paramBoolean) {
        i = j & 0xFF | (j >> 8 & 0xFF) << 7 | (j >> 16 & 0xFF) << 14 | (j >> 24 & 0xFF) << 21;
      }
      label100:
      if (paramInt1 < 3) {
        break label185;
      }
    }
    label162:
    label185:
    for (int i3 = paramm.readUnsignedShort();; i3 = 0)
    {
      if ((i5 != 0) || (i6 != 0) || (i7 != 0) || (i2 != 0) || (i != 0) || (i3 != 0)) {
        break label191;
      }
      paramm.setPosition(paramm.limit);
      AppMethodBeat.o(92436);
      return null;
      i2 = 0;
      break;
      if (paramInt1 == 3)
      {
        i = paramm.vF();
        break label100;
      }
      i = paramm.vA();
      break label100;
    }
    label191:
    int i8 = paramm.position + i;
    if (i8 > paramm.limit)
    {
      paramm.setPosition(paramm.limit);
      AppMethodBeat.o(92436);
      return null;
    }
    if ((parama != null) && (!parama.f(paramInt1, i5, i6, i7, i2)))
    {
      paramm.setPosition(i8);
      AppMethodBeat.o(92436);
      return null;
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    int j = 0;
    int k = 0;
    if (paramInt1 == 3) {
      if ((i3 & 0x80) != 0)
      {
        j = 1;
        if ((i3 & 0x40) == 0) {
          break label368;
        }
        k = 1;
        label304:
        if ((i3 & 0x20) == 0) {
          break label374;
        }
        m = 1;
        label315:
        i3 = j;
        int i4 = m;
        m = j;
        n = k;
        k = i4;
        j = i3;
      }
    }
    for (;;)
    {
      if ((m == 0) && (n == 0)) {
        break label486;
      }
      paramm.setPosition(i8);
      AppMethodBeat.o(92436);
      return null;
      j = 0;
      break;
      label368:
      k = 0;
      break label304;
      label374:
      m = 0;
      break label315;
      if (paramInt1 == 4)
      {
        if ((i3 & 0x40) != 0)
        {
          j = 1;
          label396:
          if ((i3 & 0x8) == 0) {
            break label454;
          }
          m = 1;
          label407:
          if ((i3 & 0x4) == 0) {
            break label460;
          }
          n = 1;
          label417:
          if ((i3 & 0x2) == 0) {
            break label466;
          }
        }
        label454:
        label460:
        label466:
        for (i1 = 1;; i1 = 0)
        {
          if ((i3 & 0x1) == 0) {
            break label472;
          }
          i3 = 1;
          k = j;
          j = i3;
          break;
          j = 0;
          break label396;
          m = 0;
          break label407;
          n = 0;
          break label417;
        }
        label472:
        i3 = 0;
        k = j;
        j = i3;
      }
    }
    label486:
    Object localObject2;
    label580:
    Object localObject1;
    label1020:
    Object localObject3;
    if (k != 0)
    {
      k = i - 1;
      paramm.eX(1);
      i = k;
      if (j != 0)
      {
        i = k - 4;
        paramm.eX(4);
      }
      j = i;
      if (i1 != 0) {
        j = f(paramm, i);
      }
      if ((i5 == 84) && (i6 == 88) && (i7 == 88) && ((paramInt1 == 2) || (i2 == 88))) {
        if (j <= 0) {
          parama = null;
        }
      }
      for (;;)
      {
        if (parama == null) {}
        try
        {
          new StringBuilder("Failed to decode frame: id=").append(g(paramInt1, i5, i6, i7, i2)).append(", frameSize=").append(j);
          return parama;
          paramInt2 = paramm.readUnsignedByte();
          parama = ev(paramInt2);
          localObject2 = new byte[j - 1];
          paramm.readBytes((byte[])localObject2, 0, j - 1);
          i = h((byte[])localObject2, 0, paramInt2);
          localObject1 = new String((byte[])localObject2, 0, i, parama);
          i += ew(paramInt2);
          if (i < localObject2.length)
          {
            parama = new String((byte[])localObject2, i, h((byte[])localObject2, i, paramInt2) - i, parama);
            parama = new TextInformationFrame("TXXX", (String)localObject1, parama);
            continue;
          }
        }
        catch (UnsupportedEncodingException parama)
        {
          for (;;)
          {
            return null;
            parama = "";
          }
          if (i5 == 84)
          {
            parama = g(paramInt1, i5, i6, i7, i2);
            if (j <= 0)
            {
              parama = null;
              continue;
            }
            paramInt2 = paramm.readUnsignedByte();
            localObject1 = ev(paramInt2);
            localObject2 = new byte[j - 1];
            paramm.readBytes((byte[])localObject2, 0, j - 1);
            parama = new TextInformationFrame(parama, null, new String((byte[])localObject2, 0, h((byte[])localObject2, 0, paramInt2), (String)localObject1));
            continue;
          }
        }
        finally
        {
          paramm.setPosition(i8);
          AppMethodBeat.o(92436);
        }
        if ((i5 == 87) && (i6 == 88) && (i7 == 88) && ((paramInt1 == 2) || (i2 == 88)))
        {
          if (j <= 0)
          {
            parama = null;
          }
          else
          {
            paramInt2 = paramm.readUnsignedByte();
            localObject1 = ev(paramInt2);
            parama = new byte[j - 1];
            paramm.readBytes(parama, 0, j - 1);
            i = h(parama, 0, paramInt2);
            localObject1 = new String(parama, 0, i, (String)localObject1);
            paramInt2 = i + ew(paramInt2);
            if (paramInt2 >= parama.length) {
              break;
            }
            parama = new String(parama, paramInt2, e(parama, paramInt2) - paramInt2, "ISO-8859-1");
            parama = new UrlLinkFrame("WXXX", (String)localObject1, parama);
          }
        }
        else if (i5 == 87)
        {
          parama = g(paramInt1, i5, i6, i7, i2);
          localObject1 = new byte[j];
          paramm.readBytes((byte[])localObject1, 0, j);
          parama = new UrlLinkFrame(parama, null, new String((byte[])localObject1, 0, e((byte[])localObject1, 0), "ISO-8859-1"));
        }
        else
        {
          if ((i5 != 80) || (i6 != 82) || (i7 != 73) || (i2 != 86)) {
            break label1874;
          }
          parama = new byte[j];
          paramm.readBytes(parama, 0, j);
          paramInt2 = e(parama, 0);
          parama = new PrivFrame(new String(parama, 0, paramInt2, "ISO-8859-1"), i(parama, paramInt2 + 1, parama.length));
          continue;
          label1193:
          paramInt2 = paramm.readUnsignedByte();
          parama = ev(paramInt2);
          localObject1 = new byte[j - 1];
          paramm.readBytes((byte[])localObject1, 0, j - 1);
          i = e((byte[])localObject1, 0);
          localObject2 = new String((byte[])localObject1, 0, i, "ISO-8859-1");
          i += 1;
          k = h((byte[])localObject1, i, paramInt2);
          localObject3 = new String((byte[])localObject1, i, k - i, parama);
          i = ew(paramInt2) + k;
          k = h((byte[])localObject1, i, paramInt2);
          parama = new GeobFrame((String)localObject2, (String)localObject3, new String((byte[])localObject1, i, k - i, parama), i((byte[])localObject1, ew(paramInt2) + k, localObject1.length));
        }
      }
      label1351:
      k = paramm.readUnsignedByte();
      localObject2 = ev(k);
      localObject3 = new byte[j - 1];
      paramm.readBytes((byte[])localObject3, 0, j - 1);
      if (paramInt1 == 2)
      {
        i = 2;
        localObject1 = "image/" + x.aO(new String((byte[])localObject3, 0, 3, "ISO-8859-1"));
        paramInt2 = i;
        parama = (a)localObject1;
        if (((String)localObject1).equals("image/jpg"))
        {
          parama = "image/jpeg";
          paramInt2 = i;
        }
      }
      for (;;)
      {
        i = localObject3[(paramInt2 + 1)];
        paramInt2 += 2;
        m = h((byte[])localObject3, paramInt2, k);
        parama = new ApicFrame(parama, new String((byte[])localObject3, paramInt2, m - paramInt2, (String)localObject2), i & 0xFF, i((byte[])localObject3, ew(k) + m, localObject3.length));
        break;
        i = e((byte[])localObject3, 0);
        localObject1 = x.aO(new String((byte[])localObject3, 0, i, "ISO-8859-1"));
        paramInt2 = i;
        parama = (a)localObject1;
        if (((String)localObject1).indexOf('/') == -1)
        {
          parama = "image/".concat(String.valueOf(localObject1));
          paramInt2 = i;
        }
      }
      label1585:
      paramInt2 = paramm.readUnsignedByte();
      parama = ev(paramInt2);
      localObject1 = new byte[3];
      paramm.readBytes((byte[])localObject1, 0, 3);
      localObject1 = new String((byte[])localObject1, 0, 3);
      localObject3 = new byte[j - 4];
      paramm.readBytes((byte[])localObject3, 0, j - 4);
      i = h((byte[])localObject3, 0, paramInt2);
      localObject2 = new String((byte[])localObject3, 0, i, parama);
      i += ew(paramInt2);
      if (i >= localObject3.length) {
        break label2012;
      }
    }
    label1874:
    label2012:
    for (parama = new String((byte[])localObject3, i, h((byte[])localObject3, i, paramInt2) - i, parama);; parama = "")
    {
      parama = new CommentFrame((String)localObject1, (String)localObject2, parama);
      break label580;
      do
      {
        if ((i5 == 67) && (i6 == 72) && (i7 == 65) && (i2 == 80))
        {
          parama = a(paramm, j, paramInt1, paramBoolean, paramInt2, parama);
          break label580;
        }
        if ((i5 == 67) && (i6 == 84) && (i7 == 79) && (i2 == 67))
        {
          parama = b(paramm, j, paramInt1, paramBoolean, paramInt2, parama);
          break label580;
        }
        parama = g(paramInt1, i5, i6, i7, i2);
        localObject1 = new byte[j];
        paramm.readBytes((byte[])localObject1, 0, j);
        parama = new BinaryFrame(parama, (byte[])localObject1);
        break label580;
        k = i;
        break;
        parama = "";
        break label1020;
        if ((i5 == 71) && (i6 == 69) && (i7 == 79) && ((i2 == 66) || (paramInt1 == 2))) {
          break label1193;
        }
        if (paramInt1 == 2 ? (i5 == 80) || (i6 == 73) || (i7 == 67) : (i5 == 65) && (i6 == 80) && (i7 == 73) && (i2 == 67)) {
          break label1351;
        }
      } while ((i5 != 67) || (i6 != 79) || (i7 != 77) || ((i2 != 77) && (paramInt1 != 2)));
      if (j >= 4) {
        break label1585;
      }
      parama = null;
      break label580;
    }
  }
  
  private static boolean a(m paramm, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(92435);
    int m = paramm.position;
    label390:
    label396:
    for (;;)
    {
      try
      {
        if (paramm.vy() >= paramInt2)
        {
          int k;
          if (paramInt1 >= 3)
          {
            i = paramm.readInt();
            l = paramm.dm();
            k = paramm.readUnsignedShort();
            if ((i == 0) && (l == 0L) && (k == 0)) {
              return true;
            }
          }
          else
          {
            i = paramm.vA();
            j = paramm.vA();
            l = j;
            k = 0;
            continue;
          }
          if ((paramInt1 != 4) || (paramBoolean)) {
            break label396;
          }
          if ((0x808080 & l) != 0L) {
            return false;
          }
          long l = (l >> 24 & 0xFF) << 21 | 0xFF & l | (l >> 8 & 0xFF) << 7 | (l >> 16 & 0xFF) << 14;
          int j = 0;
          if (paramInt1 == 4)
          {
            if ((k & 0x40) != 0)
            {
              i = 1;
              if ((k & 0x1) != 0)
              {
                j = 1;
                k = j;
                j = i;
                i = k;
                k = 0;
                if (j != 0) {
                  k = 1;
                }
                j = k;
                if (i != 0) {
                  j = k + 4;
                }
                if (l >= j) {
                  continue;
                }
                return false;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            j = 0;
            continue;
          }
          else
          {
            if (paramInt1 != 3) {
              break label390;
            }
            if ((k & 0x20) != 0)
            {
              j = 1;
              if ((k & 0x80) != 0) {
                i = 1;
              }
            }
            else
            {
              j = 0;
              continue;
            }
            i = 0;
            continue;
          }
          i = paramm.vy();
          if (i < l) {
            return false;
          }
          i = (int)l;
          paramm.eX(i);
          continue;
        }
        paramm.setPosition(m);
      }
      finally
      {
        paramm.setPosition(m);
        AppMethodBeat.o(92435);
      }
      AppMethodBeat.o(92435);
      return true;
      int i = 0;
    }
  }
  
  private static ChapterTocFrame b(m paramm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, a parama)
  {
    AppMethodBeat.i(92438);
    int j = paramm.position;
    int i = e(paramm.data, j);
    String str = new String(paramm.data, j, i - j, "ISO-8859-1");
    paramm.setPosition(i + 1);
    i = paramm.readUnsignedByte();
    boolean bool1;
    if ((i & 0x2) != 0)
    {
      bool1 = true;
      if ((i & 0x1) == 0) {
        break label166;
      }
    }
    String[] arrayOfString;
    label166:
    for (boolean bool2 = true;; bool2 = false)
    {
      int k = paramm.readUnsignedByte();
      arrayOfString = new String[k];
      i = 0;
      while (i < k)
      {
        int m = paramm.position;
        int n = e(paramm.data, m);
        arrayOfString[i] = new String(paramm.data, m, n - m, "ISO-8859-1");
        paramm.setPosition(n + 1);
        i += 1;
      }
      bool1 = false;
      break;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramm.position < j + paramInt1)
    {
      Id3Frame localId3Frame = a(paramInt2, paramm, paramBoolean, paramInt3, parama);
      if (localId3Frame != null) {
        localArrayList.add(localId3Frame);
      }
    }
    paramm = new Id3Frame[localArrayList.size()];
    localArrayList.toArray(paramm);
    paramm = new ChapterTocFrame(str, bool1, bool2, arrayOfString, paramm);
    AppMethodBeat.o(92438);
    return paramm;
  }
  
  private static int e(byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[paramInt] == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramArrayOfByte.length;
  }
  
  private static String ev(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ISO-8859-1";
    case 0: 
      return "ISO-8859-1";
    case 1: 
      return "UTF-16";
    case 2: 
      return "UTF-16BE";
    }
    return "UTF-8";
  }
  
  private static int ew(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3)) {
      return 1;
    }
    return 2;
  }
  
  private static int f(m paramm, int paramInt)
  {
    AppMethodBeat.i(92439);
    byte[] arrayOfByte = paramm.data;
    int j = paramm.position;
    int i = paramInt;
    paramInt = j;
    while (paramInt + 1 < i)
    {
      j = i;
      if ((arrayOfByte[paramInt] & 0xFF) == 255)
      {
        j = i;
        if (arrayOfByte[(paramInt + 1)] == 0)
        {
          System.arraycopy(arrayOfByte, paramInt + 2, arrayOfByte, paramInt + 1, i - paramInt - 2);
          j = i - 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(92439);
    return i;
  }
  
  private static String g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(92440);
    if (paramInt1 == 2)
    {
      str = String.format(Locale.US, "%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(92440);
      return str;
    }
    String str = String.format(Locale.US, "%c%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(92440);
    return str;
  }
  
  private static int h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92441);
    int i = e(paramArrayOfByte, paramInt1);
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      if (paramInt2 != 3) {}
    }
    else
    {
      AppMethodBeat.o(92441);
      return i;
    }
    do
    {
      paramInt1 = e(paramArrayOfByte, paramInt1 + 1);
      if (paramInt1 >= paramArrayOfByte.length - 1) {
        break;
      }
    } while ((paramInt1 % 2 != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0));
    AppMethodBeat.o(92441);
    return paramInt1;
    paramInt1 = paramArrayOfByte.length;
    AppMethodBeat.o(92441);
    return paramInt1;
  }
  
  private static byte[] i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92442);
    if (paramInt2 <= paramInt1)
    {
      AppMethodBeat.o(92442);
      return new byte[0];
    }
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92442);
    return paramArrayOfByte;
  }
  
  private static b x(m paramm)
  {
    AppMethodBeat.i(92434);
    if (paramm.vy() < 10)
    {
      AppMethodBeat.o(92434);
      return null;
    }
    if (paramm.vA() != bfU)
    {
      AppMethodBeat.o(92434);
      return null;
    }
    int m = paramm.readUnsignedByte();
    paramm.eX(1);
    int n = paramm.readUnsignedByte();
    int i = paramm.vE();
    int j;
    if (m == 2)
    {
      if ((n & 0x40) != 0) {}
      for (j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(92434);
        return null;
      }
      if ((m >= 4) || ((n & 0x80) == 0)) {
        break label263;
      }
    }
    label263:
    for (boolean bool = true;; bool = false)
    {
      paramm = new b(m, bool, i);
      AppMethodBeat.o(92434);
      return paramm;
      int k;
      if (m == 3)
      {
        if ((n & 0x40) != 0) {}
        for (k = 1;; k = 0)
        {
          j = i;
          if (k != 0)
          {
            j = paramm.readInt();
            paramm.eX(j);
            j = i - (j + 4);
          }
          i = j;
          break;
        }
      }
      if (m == 4)
      {
        if ((n & 0x40) != 0)
        {
          k = 1;
          label199:
          j = i;
          if (k != 0)
          {
            j = paramm.vE();
            paramm.eX(j - 4);
            j = i - j;
          }
          if ((n & 0x10) == 0) {
            break label250;
          }
        }
        label250:
        for (k = 1;; k = 0)
        {
          i = j;
          if (k != 0) {
            i = j - 10;
          }
          break;
          k = 0;
          break label199;
        }
      }
      AppMethodBeat.o(92434);
      return null;
    }
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92432);
    paramd = paramd.aJg;
    paramd = d(paramd.array(), paramd.limit());
    AppMethodBeat.o(92432);
    return paramd;
  }
  
  public final Metadata d(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92433);
    ArrayList localArrayList = new ArrayList();
    paramArrayOfByte = new m(paramArrayOfByte, paramInt);
    b localb = x(paramArrayOfByte);
    if (localb == null)
    {
      AppMethodBeat.o(92433);
      return null;
    }
    int j = paramArrayOfByte.position;
    boolean bool;
    if (localb.bki == 2)
    {
      paramInt = 6;
      int i = localb.bkk;
      if (localb.bkj) {
        i = f(paramArrayOfByte, localb.bkk);
      }
      paramArrayOfByte.eW(i + j);
      if (a(paramArrayOfByte, localb.bki, paramInt, false)) {
        break label225;
      }
      if ((localb.bki != 4) || (!a(paramArrayOfByte, 4, paramInt, true))) {
        break label180;
      }
      bool = true;
    }
    for (;;)
    {
      if (paramArrayOfByte.vy() >= paramInt)
      {
        Id3Frame localId3Frame = a(localb.bki, paramArrayOfByte, bool, paramInt, this.bkh);
        if (localId3Frame == null) {
          continue;
        }
        localArrayList.add(localId3Frame);
        continue;
        paramInt = 10;
        break;
        label180:
        new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(localb.bki);
        AppMethodBeat.o(92433);
        return null;
      }
      paramArrayOfByte = new Metadata(localArrayList);
      AppMethodBeat.o(92433);
      return paramArrayOfByte;
      label225:
      bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
  
  static final class b
  {
    final int bki;
    final boolean bkj;
    final int bkk;
    
    public b(int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.bki = paramInt1;
      this.bkj = paramBoolean;
      this.bkk = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.a
 * JD-Core Version:    0.7.0.1
 */