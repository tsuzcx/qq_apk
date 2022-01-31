package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  public static final int aDc = t.aG("ID3");
  private final a.a aHi;
  
  public a()
  {
    this(null);
  }
  
  public a(a.a parama)
  {
    this.aHi = parama;
  }
  
  private static ChapterFrame a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, a.a parama)
  {
    int i = paramj.position;
    int j = d(paramj.data, i);
    String str = new String(paramj.data, i, j - i, "ISO-8859-1");
    paramj.setPosition(j + 1);
    j = paramj.readInt();
    int k = paramj.readInt();
    long l2 = paramj.bp();
    long l1 = l2;
    if (l2 == 4294967295L) {
      l1 = -1L;
    }
    long l3 = paramj.bp();
    l2 = l3;
    if (l3 == 4294967295L) {
      l2 = -1L;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramj.position < i + paramInt1)
    {
      Id3Frame localId3Frame = a(paramInt2, paramj, paramBoolean, paramInt3, parama);
      if (localId3Frame != null) {
        localArrayList.add(localId3Frame);
      }
    }
    paramj = new Id3Frame[localArrayList.size()];
    localArrayList.toArray(paramj);
    return new ChapterFrame(str, j, k, l1, l2, paramj);
  }
  
  private static Id3Frame a(int paramInt1, j paramj, boolean paramBoolean, int paramInt2, a.a parama)
  {
    int i5 = paramj.readUnsignedByte();
    int i6 = paramj.readUnsignedByte();
    int i7 = paramj.readUnsignedByte();
    int i2;
    int i;
    if (paramInt1 >= 3)
    {
      i2 = paramj.readUnsignedByte();
      if (paramInt1 != 4) {
        break label152;
      }
      j = paramj.oh();
      i = j;
      if (!paramBoolean) {
        i = j & 0xFF | (j >> 8 & 0xFF) << 7 | (j >> 16 & 0xFF) << 14 | (j >> 24 & 0xFF) << 21;
      }
      label95:
      if (paramInt1 < 3) {
        break label175;
      }
    }
    label152:
    label175:
    for (int i3 = paramj.readUnsignedShort();; i3 = 0)
    {
      if ((i5 != 0) || (i6 != 0) || (i7 != 0) || (i2 != 0) || (i != 0) || (i3 != 0)) {
        break label181;
      }
      paramj.setPosition(paramj.limit);
      return null;
      i2 = 0;
      break;
      if (paramInt1 == 3)
      {
        i = paramj.oh();
        break label95;
      }
      i = paramj.of();
      break label95;
    }
    label181:
    int i8 = paramj.position + i;
    if (i8 > paramj.limit)
    {
      paramj.setPosition(paramj.limit);
      return null;
    }
    if ((parama != null) && (!parama.f(paramInt1, i5, i6, i7, i2)))
    {
      paramj.setPosition(i8);
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
          break label343;
        }
        k = 1;
        label284:
        if ((i3 & 0x20) == 0) {
          break label349;
        }
        m = 1;
        label295:
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
        break label461;
      }
      paramj.setPosition(i8);
      return null;
      j = 0;
      break;
      label343:
      k = 0;
      break label284;
      label349:
      m = 0;
      break label295;
      if (paramInt1 == 4)
      {
        if ((i3 & 0x40) != 0)
        {
          j = 1;
          label371:
          if ((i3 & 0x8) == 0) {
            break label429;
          }
          m = 1;
          label382:
          if ((i3 & 0x4) == 0) {
            break label435;
          }
          n = 1;
          label392:
          if ((i3 & 0x2) == 0) {
            break label441;
          }
        }
        label429:
        label435:
        label441:
        for (i1 = 1;; i1 = 0)
        {
          if ((i3 & 0x1) == 0) {
            break label447;
          }
          i3 = 1;
          k = j;
          j = i3;
          break;
          j = 0;
          break label371;
          m = 0;
          break label382;
          n = 0;
          break label392;
        }
        label447:
        i3 = 0;
        k = j;
        j = i3;
      }
    }
    label461:
    Object localObject2;
    label555:
    Object localObject1;
    label980:
    Object localObject3;
    if (k != 0)
    {
      k = i - 1;
      paramj.dB(1);
      i = k;
      if (j != 0)
      {
        i = k - 4;
        paramj.dB(4);
      }
      j = i;
      if (i1 != 0) {
        j = d(paramj, i);
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
          paramInt2 = paramj.readUnsignedByte();
          parama = de(paramInt2);
          localObject2 = new byte[j - 1];
          paramj.readBytes((byte[])localObject2, 0, j - 1);
          i = g((byte[])localObject2, 0, paramInt2);
          localObject1 = new String((byte[])localObject2, 0, i, parama);
          i += df(paramInt2);
          if (i < localObject2.length)
          {
            parama = new String((byte[])localObject2, i, g((byte[])localObject2, i, paramInt2) - i, parama);
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
            paramInt2 = paramj.readUnsignedByte();
            localObject1 = de(paramInt2);
            localObject2 = new byte[j - 1];
            paramj.readBytes((byte[])localObject2, 0, j - 1);
            parama = new TextInformationFrame(parama, null, new String((byte[])localObject2, 0, g((byte[])localObject2, 0, paramInt2), (String)localObject1));
            continue;
          }
        }
        finally
        {
          paramj.setPosition(i8);
        }
        if ((i5 == 87) && (i6 == 88) && (i7 == 88) && ((paramInt1 == 2) || (i2 == 88)))
        {
          if (j <= 0)
          {
            parama = null;
          }
          else
          {
            paramInt2 = paramj.readUnsignedByte();
            localObject1 = de(paramInt2);
            parama = new byte[j - 1];
            paramj.readBytes(parama, 0, j - 1);
            i = g(parama, 0, paramInt2);
            localObject1 = new String(parama, 0, i, (String)localObject1);
            paramInt2 = i + df(paramInt2);
            if (paramInt2 >= parama.length) {
              break;
            }
            parama = new String(parama, paramInt2, d(parama, paramInt2) - paramInt2, "ISO-8859-1");
            parama = new UrlLinkFrame("WXXX", (String)localObject1, parama);
          }
        }
        else if (i5 == 87)
        {
          parama = g(paramInt1, i5, i6, i7, i2);
          localObject1 = new byte[j];
          paramj.readBytes((byte[])localObject1, 0, j);
          parama = new UrlLinkFrame(parama, null, new String((byte[])localObject1, 0, d((byte[])localObject1, 0), "ISO-8859-1"));
        }
        else
        {
          if ((i5 != 80) || (i6 != 82) || (i7 != 73) || (i2 != 86)) {
            break label1841;
          }
          parama = new byte[j];
          paramj.readBytes(parama, 0, j);
          paramInt2 = d(parama, 0);
          parama = new PrivFrame(new String(parama, 0, paramInt2, "ISO-8859-1"), h(parama, paramInt2 + 1, parama.length));
          continue;
          label1153:
          paramInt2 = paramj.readUnsignedByte();
          parama = de(paramInt2);
          localObject1 = new byte[j - 1];
          paramj.readBytes((byte[])localObject1, 0, j - 1);
          i = d((byte[])localObject1, 0);
          localObject2 = new String((byte[])localObject1, 0, i, "ISO-8859-1");
          i += 1;
          k = g((byte[])localObject1, i, paramInt2);
          localObject3 = new String((byte[])localObject1, i, k - i, parama);
          i = df(paramInt2) + k;
          k = g((byte[])localObject1, i, paramInt2);
          parama = new GeobFrame((String)localObject2, (String)localObject3, new String((byte[])localObject1, i, k - i, parama), h((byte[])localObject1, df(paramInt2) + k, localObject1.length));
        }
      }
      label1311:
      k = paramj.readUnsignedByte();
      localObject2 = de(k);
      localObject3 = new byte[j - 1];
      paramj.readBytes((byte[])localObject3, 0, j - 1);
      if (paramInt1 == 2)
      {
        i = 2;
        localObject1 = "image/" + t.aE(new String((byte[])localObject3, 0, 3, "ISO-8859-1"));
        paramInt2 = i;
        parama = (a.a)localObject1;
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
        m = g((byte[])localObject3, paramInt2, k);
        parama = new ApicFrame(parama, new String((byte[])localObject3, paramInt2, m - paramInt2, (String)localObject2), i & 0xFF, h((byte[])localObject3, df(k) + m, localObject3.length));
        break;
        i = d((byte[])localObject3, 0);
        localObject1 = t.aE(new String((byte[])localObject3, 0, i, "ISO-8859-1"));
        paramInt2 = i;
        parama = (a.a)localObject1;
        if (((String)localObject1).indexOf('/') == -1)
        {
          parama = "image/" + (String)localObject1;
          paramInt2 = i;
        }
      }
      label1552:
      paramInt2 = paramj.readUnsignedByte();
      parama = de(paramInt2);
      localObject1 = new byte[3];
      paramj.readBytes((byte[])localObject1, 0, 3);
      localObject1 = new String((byte[])localObject1, 0, 3);
      localObject3 = new byte[j - 4];
      paramj.readBytes((byte[])localObject3, 0, j - 4);
      i = g((byte[])localObject3, 0, paramInt2);
      localObject2 = new String((byte[])localObject3, 0, i, parama);
      i += df(paramInt2);
      if (i >= localObject3.length) {
        break label1979;
      }
    }
    label1841:
    label1979:
    for (parama = new String((byte[])localObject3, i, g((byte[])localObject3, i, paramInt2) - i, parama);; parama = "")
    {
      parama = new CommentFrame((String)localObject1, (String)localObject2, parama);
      break label555;
      do
      {
        if ((i5 == 67) && (i6 == 72) && (i7 == 65) && (i2 == 80))
        {
          parama = a(paramj, j, paramInt1, paramBoolean, paramInt2, parama);
          break label555;
        }
        if ((i5 == 67) && (i6 == 84) && (i7 == 79) && (i2 == 67))
        {
          parama = b(paramj, j, paramInt1, paramBoolean, paramInt2, parama);
          break label555;
        }
        parama = g(paramInt1, i5, i6, i7, i2);
        localObject1 = new byte[j];
        paramj.readBytes((byte[])localObject1, 0, j);
        parama = new BinaryFrame(parama, (byte[])localObject1);
        break label555;
        k = i;
        break;
        parama = "";
        break label980;
        if ((i5 == 71) && (i6 == 69) && (i7 == 79) && ((i2 == 66) || (paramInt1 == 2))) {
          break label1153;
        }
        if (paramInt1 == 2 ? (i5 == 80) || (i6 == 73) || (i7 == 67) : (i5 == 65) && (i6 == 80) && (i7 == 73) && (i2 == 67)) {
          break label1311;
        }
      } while ((i5 != 67) || (i6 != 79) || (i7 != 77) || ((i2 != 77) && (paramInt1 != 2)));
      if (j >= 4) {
        break label1552;
      }
      parama = null;
      break label555;
    }
  }
  
  private static boolean a(j paramj, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = paramj.position;
    label355:
    label361:
    for (;;)
    {
      try
      {
        if (paramj.oe() >= paramInt2)
        {
          int k;
          if (paramInt1 >= 3)
          {
            i = paramj.readInt();
            l = paramj.bp();
            k = paramj.readUnsignedShort();
            if ((i == 0) && (l == 0L) && (k == 0)) {
              return true;
            }
          }
          else
          {
            i = paramj.of();
            j = paramj.of();
            l = j;
            k = 0;
            continue;
          }
          if ((paramInt1 != 4) || (paramBoolean)) {
            break label361;
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
              break label355;
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
          i = paramj.oe();
          if (i < l) {
            return false;
          }
          i = (int)l;
          paramj.dB(i);
          continue;
        }
      }
      finally
      {
        paramj.setPosition(m);
      }
      return true;
      int i = 0;
    }
  }
  
  private static ChapterTocFrame b(j paramj, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, a.a parama)
  {
    int j = paramj.position;
    int i = d(paramj.data, j);
    String str = new String(paramj.data, j, i - j, "ISO-8859-1");
    paramj.setPosition(i + 1);
    i = paramj.readUnsignedByte();
    boolean bool1;
    if ((i & 0x2) != 0)
    {
      bool1 = true;
      if ((i & 0x1) == 0) {
        break label161;
      }
    }
    String[] arrayOfString;
    label161:
    for (boolean bool2 = true;; bool2 = false)
    {
      int k = paramj.readUnsignedByte();
      arrayOfString = new String[k];
      i = 0;
      while (i < k)
      {
        int m = paramj.position;
        int n = d(paramj.data, m);
        arrayOfString[i] = new String(paramj.data, m, n - m, "ISO-8859-1");
        paramj.setPosition(n + 1);
        i += 1;
      }
      bool1 = false;
      break;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramj.position < j + paramInt1)
    {
      Id3Frame localId3Frame = a(paramInt2, paramj, paramBoolean, paramInt3, parama);
      if (localId3Frame != null) {
        localArrayList.add(localId3Frame);
      }
    }
    paramj = new Id3Frame[localArrayList.size()];
    localArrayList.toArray(paramj);
    return new ChapterTocFrame(str, bool1, bool2, arrayOfString, paramj);
  }
  
  private static int d(j paramj, int paramInt)
  {
    byte[] arrayOfByte = paramj.data;
    int j = paramj.position;
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
    return i;
  }
  
  private static int d(byte[] paramArrayOfByte, int paramInt)
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
  
  private static String de(int paramInt)
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
  
  private static int df(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3)) {
      return 1;
    }
    return 2;
  }
  
  private static int g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = d(paramArrayOfByte, paramInt1);
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      if (paramInt2 != 3) {}
    }
    else
    {
      return i;
    }
    do
    {
      paramInt1 = d(paramArrayOfByte, paramInt1 + 1);
      if (paramInt1 >= paramArrayOfByte.length - 1) {
        break;
      }
    } while ((paramInt1 % 2 != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0));
    return paramInt1;
    return paramArrayOfByte.length;
  }
  
  private static String g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 == 2) {
      return String.format(Locale.US, "%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    return String.format(Locale.US, "%c%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
  }
  
  private static byte[] h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1) {
      return new byte[0];
    }
    return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final Metadata a(d paramd)
  {
    paramd = paramd.ayD;
    return c(paramd.array(), paramd.limit());
  }
  
  public final Metadata c(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    ArrayList localArrayList = new ArrayList();
    j localj = new j(paramArrayOfByte, paramInt);
    if (localj.oe() < 10) {
      paramArrayOfByte = null;
    }
    int i;
    label113:
    boolean bool1;
    while (paramArrayOfByte == null)
    {
      return null;
      if (localj.of() != aDc)
      {
        paramArrayOfByte = null;
      }
      else
      {
        int k = localj.readUnsignedByte();
        localj.dB(1);
        int m = localj.readUnsignedByte();
        paramInt = localj.og();
        if (k == 2)
        {
          if ((m & 0x40) != 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label113;
            }
            paramArrayOfByte = null;
            break;
          }
          if ((k >= 4) || ((m & 0x80) == 0)) {
            break label285;
          }
        }
        label274:
        label285:
        for (bool1 = true;; bool1 = false)
        {
          paramArrayOfByte = new a.b(k, bool1, paramInt);
          break;
          if (k == 3)
          {
            if ((m & 0x40) != 0) {}
            for (j = 1;; j = 0)
            {
              i = paramInt;
              if (j != 0)
              {
                i = localj.readInt();
                localj.dB(i);
                i = paramInt - (i + 4);
              }
              paramInt = i;
              break;
            }
          }
          if (k == 4)
          {
            if ((m & 0x40) != 0)
            {
              j = 1;
              label217:
              i = paramInt;
              if (j != 0)
              {
                i = localj.og();
                localj.dB(i - 4);
                i = paramInt - i;
              }
              if ((m & 0x10) == 0) {
                break label274;
              }
            }
            for (j = 1;; j = 0)
            {
              paramInt = i;
              if (j != 0) {
                paramInt = i - 10;
              }
              break;
              j = 0;
              break label217;
            }
          }
          paramArrayOfByte = null;
          break;
        }
      }
    }
    int j = localj.position;
    if (paramArrayOfByte.aHj == 2)
    {
      paramInt = 6;
      i = paramArrayOfByte.aHl;
      if (paramArrayOfByte.aHk) {
        i = d(localj, paramArrayOfByte.aHl);
      }
      localj.dA(i + j);
      if (a(localj, paramArrayOfByte.aHj, paramInt, false)) {
        break label458;
      }
      if ((paramArrayOfByte.aHj != 4) || (!a(localj, 4, paramInt, true))) {
        break label428;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (localj.oe() >= paramInt)
      {
        Id3Frame localId3Frame = a(paramArrayOfByte.aHj, localj, bool1, paramInt, this.aHi);
        if (localId3Frame == null) {
          continue;
        }
        localArrayList.add(localId3Frame);
        continue;
        paramInt = 10;
        break;
        label428:
        new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(paramArrayOfByte.aHj);
        return null;
      }
      return new Metadata(localArrayList);
      label458:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.a
 * JD-Core Version:    0.7.0.1
 */