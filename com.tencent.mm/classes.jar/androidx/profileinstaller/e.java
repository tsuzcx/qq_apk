package androidx.profileinstaller;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class e
{
  static final byte[] bTZ = { 112, 114, 111, 0 };
  
  private static Map<String, b> a(InputStream paramInputStream, String paramString, int paramInt)
  {
    AppMethodBeat.i(194344);
    if (paramInputStream.available() == 0)
    {
      paramInputStream = new HashMap();
      AppMethodBeat.o(194344);
      return paramInputStream;
    }
    b[] arrayOfb = new b[paramInt];
    int i = 0;
    Object localObject;
    if (i < paramInt)
    {
      int j = c.j(paramInputStream);
      int k = c.j(paramInputStream);
      long l1 = c.k(paramInputStream);
      long l2 = c.k(paramInputStream);
      long l3 = c.k(paramInputStream);
      String str = new String(c.b(paramInputStream, j), StandardCharsets.UTF_8);
      if ("classes.dex".equals(str)) {
        localObject = paramString;
      }
      for (;;)
      {
        arrayOfb[i] = new b((String)localObject, l2, k, (int)l1, (int)l3, new LinkedHashSet(), new LinkedHashMap());
        i += 1;
        break;
        localObject = str;
        if (!str.contains("!"))
        {
          localObject = str;
          if (!str.endsWith(".apk")) {
            localObject = paramString + '!' + str;
          }
        }
      }
    }
    paramString = new HashMap(paramInt);
    i = arrayOfb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      localObject = arrayOfb[paramInt];
      a(paramInputStream, (b)localObject);
      b(paramInputStream, (b)localObject);
      c(paramInputStream, (b)localObject);
      paramString.put(((b)localObject).key, localObject);
      paramInt += 1;
    }
    AppMethodBeat.o(194344);
    return paramString;
  }
  
  static Map<String, b> a(InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(194334);
    if (!Arrays.equals(paramArrayOfByte, f.bUa))
    {
      paramInputStream = c.aQ("Unsupported version");
      AppMethodBeat.o(194334);
      throw paramInputStream;
    }
    int i = (int)c.c(paramInputStream, 1);
    long l = c.c(paramInputStream, 4);
    paramArrayOfByte = c.a(paramInputStream, (int)c.c(paramInputStream, 4), (int)l);
    if (paramInputStream.read() > 0)
    {
      paramInputStream = c.aQ("Content found after the end of file");
      AppMethodBeat.o(194334);
      throw paramInputStream;
    }
    paramInputStream = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      paramArrayOfByte = a(paramInputStream, paramString, i);
      paramInputStream.close();
      AppMethodBeat.o(194334);
      return paramArrayOfByte;
    }
    finally {}
    try
    {
      paramInputStream.close();
      AppMethodBeat.o(194334);
      throw paramArrayOfByte;
    }
    finally
    {
      paramArrayOfByte.addSuppressed(paramInputStream);
    }
  }
  
  private static void a(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(194353);
    int n = paramInputStream.available() - paramb.bTS;
    int j = 0;
    if (paramInputStream.available() > n)
    {
      int m = j + (int)c.c(paramInputStream, 2);
      paramb.bTV.put(Integer.valueOf(m), Integer.valueOf(1));
      int i = (int)c.c(paramInputStream, 2);
      for (;;)
      {
        j = m;
        if (i <= 0) {
          break;
        }
        c.c(paramInputStream, 2);
        j = (int)c.c(paramInputStream, 1);
        if ((j != 6) && (j != 7)) {
          while (j > 0)
          {
            c.c(paramInputStream, 1);
            int k = (int)c.c(paramInputStream, 1);
            while (k > 0)
            {
              c.c(paramInputStream, 2);
              k -= 1;
            }
            j -= 1;
          }
        }
        i -= 1;
      }
    }
    if (paramInputStream.available() != n)
    {
      paramInputStream = c.aQ("Read too much data during profile line parse");
      AppMethodBeat.o(194353);
      throw paramInputStream;
    }
    AppMethodBeat.o(194353);
  }
  
  private static void a(OutputStream paramOutputStream, b paramb)
  {
    AppMethodBeat.i(194319);
    paramb = paramb.bTV.entrySet().iterator();
    int i = 0;
    while (paramb.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramb.next();
      int j = ((Integer)localEntry.getKey()).intValue();
      if ((((Integer)localEntry.getValue()).intValue() & 0x1) != 0)
      {
        c.a(paramOutputStream, j - i, 2);
        c.a(paramOutputStream, 0L, 2);
        i = j;
      }
    }
    AppMethodBeat.o(194319);
  }
  
  private static void a(OutputStream paramOutputStream, Map<String, b> paramMap)
  {
    AppMethodBeat.i(194285);
    c.a(paramOutputStream, paramMap.size(), 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (b)((Map.Entry)localObject2).getValue();
      c.a(paramOutputStream, c.aP((String)localObject1), 2);
      c.a(paramOutputStream, ((b)localObject2).bTV.size(), 2);
      c.a(paramOutputStream, ((b)localObject2).bTU.size(), 2);
      c.a(paramOutputStream, ((b)localObject2).bTQ, 4);
      c.c(paramOutputStream, (String)localObject1);
      localObject1 = ((b)localObject2).bTV.keySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        c.a(paramOutputStream, ((Integer)((Iterator)localObject1).next()).intValue(), 2);
      }
      localObject1 = ((b)localObject2).bTU.iterator();
      while (((Iterator)localObject1).hasNext()) {
        c.a(paramOutputStream, ((Integer)((Iterator)localObject1).next()).intValue(), 2);
      }
    }
    AppMethodBeat.o(194285);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(194310);
    paramInt1 = w(paramInt1, paramInt2, paramb.bTT);
    paramInt2 = paramInt1 / 8;
    paramArrayOfByte[paramInt2] = ((byte)(1 << paramInt1 % 8 | paramArrayOfByte[paramInt2]));
    AppMethodBeat.o(194310);
  }
  
  static boolean a(OutputStream paramOutputStream, byte[] paramArrayOfByte, Map<String, b> paramMap)
  {
    AppMethodBeat.i(194275);
    if (Arrays.equals(paramArrayOfByte, f.bUa))
    {
      paramArrayOfByte = ac(new ArrayList(paramMap.values()));
      c.a(paramOutputStream, paramMap.size());
      c.a(paramOutputStream, paramArrayOfByte);
      AppMethodBeat.o(194275);
      return true;
    }
    if (Arrays.equals(paramArrayOfByte, f.bUb))
    {
      b(paramOutputStream, paramMap);
      AppMethodBeat.o(194275);
      return true;
    }
    if (Arrays.equals(paramArrayOfByte, f.bUc))
    {
      a(paramOutputStream, paramMap);
      AppMethodBeat.o(194275);
      return true;
    }
    AppMethodBeat.o(194275);
    return false;
  }
  
  private static byte[] ac(List<b> paramList)
  {
    int m = 0;
    AppMethodBeat.i(194299);
    int j = 0;
    int i = 0;
    int k;
    while (j < paramList.size())
    {
      localObject = (b)paramList.get(j);
      k = c.aP(((b)localObject).key);
      int n = ((b)localObject).bTR;
      int i1 = ((b)localObject).bTS;
      i += fv(((b)localObject).bTT) + (k + 16 + n * 2 + i1);
      j += 1;
    }
    Object localObject = new ByteArrayOutputStream(i);
    j = 0;
    b localb;
    for (;;)
    {
      k = m;
      if (j >= paramList.size()) {
        break;
      }
      localb = (b)paramList.get(j);
      c.b((OutputStream)localObject, c.aP(localb.key));
      c.b((OutputStream)localObject, localb.bTR);
      c.a((OutputStream)localObject, localb.bTS);
      c.a((OutputStream)localObject, localb.bTQ);
      c.a((OutputStream)localObject, localb.bTT);
      c.c((OutputStream)localObject, localb.key);
      j += 1;
    }
    while (k < paramList.size())
    {
      localb = (b)paramList.get(k);
      a((OutputStream)localObject, localb);
      b((OutputStream)localObject, localb);
      c((OutputStream)localObject, localb);
      k += 1;
    }
    if (((ByteArrayOutputStream)localObject).size() != i)
    {
      paramList = c.aQ("The bytes saved do not match expectation. actual=" + ((ByteArrayOutputStream)localObject).size() + " expected=" + i);
      AppMethodBeat.o(194299);
      throw paramList;
    }
    paramList = ((ByteArrayOutputStream)localObject).toByteArray();
    AppMethodBeat.o(194299);
    return paramList;
  }
  
  private static void b(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(194358);
    int i = 0;
    int j = 0;
    while (i < paramb.bTR)
    {
      j = (int)c.c(paramInputStream, 2) + j;
      paramb.bTU.add(Integer.valueOf(j));
      i += 1;
    }
    AppMethodBeat.o(194358);
  }
  
  private static void b(OutputStream paramOutputStream, b paramb)
  {
    AppMethodBeat.i(194326);
    paramb = paramb.bTU.iterator();
    Integer localInteger;
    for (int i = 0; paramb.hasNext(); i = localInteger.intValue())
    {
      localInteger = (Integer)paramb.next();
      c.a(paramOutputStream, localInteger.intValue() - i, 2);
    }
    AppMethodBeat.o(194326);
  }
  
  private static void b(OutputStream paramOutputStream, Map<String, b> paramMap)
  {
    AppMethodBeat.i(194291);
    c.a(paramOutputStream, paramMap.size(), 1);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (b)((Map.Entry)localObject2).getValue();
      int i = ((b)localObject2).bTV.size();
      c.a(paramOutputStream, c.aP((String)localObject1), 2);
      c.a(paramOutputStream, ((b)localObject2).bTU.size(), 2);
      c.a(paramOutputStream, i * 4, 4);
      c.a(paramOutputStream, ((b)localObject2).bTQ, 4);
      c.c(paramOutputStream, (String)localObject1);
      localObject1 = ((b)localObject2).bTV.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        c.a(paramOutputStream, ((Integer)((Iterator)localObject1).next()).intValue(), 2);
        c.a(paramOutputStream, 0L, 2);
      }
      localObject1 = ((b)localObject2).bTU.iterator();
      while (((Iterator)localObject1).hasNext()) {
        c.a(paramOutputStream, ((Integer)((Iterator)localObject1).next()).intValue(), 2);
      }
    }
    AppMethodBeat.o(194291);
  }
  
  static void b(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194267);
    paramOutputStream.write(bTZ);
    paramOutputStream.write(paramArrayOfByte);
    AppMethodBeat.o(194267);
  }
  
  private static void c(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(194369);
    BitSet localBitSet = BitSet.valueOf(c.b(paramInputStream, (paramb.bTT * 2 + 8 - 1 & 0xFFFFFFF8) / 8));
    int j = 0;
    int k;
    if (j < paramb.bTT)
    {
      k = paramb.bTT;
      if (!localBitSet.get(w(2, j, k))) {
        break label155;
      }
    }
    label155:
    for (int i = 2;; i = 0)
    {
      if (localBitSet.get(w(4, j, k))) {
        i |= 0x4;
      }
      for (;;)
      {
        if (i != 0)
        {
          Integer localInteger = (Integer)paramb.bTV.get(Integer.valueOf(j));
          paramInputStream = localInteger;
          if (localInteger == null) {
            paramInputStream = Integer.valueOf(0);
          }
          paramb.bTV.put(Integer.valueOf(j), Integer.valueOf(paramInputStream.intValue() | i));
        }
        j += 1;
        break;
        AppMethodBeat.o(194369);
        return;
      }
    }
  }
  
  private static void c(OutputStream paramOutputStream, b paramb)
  {
    AppMethodBeat.i(194331);
    byte[] arrayOfByte = new byte[fv(paramb.bTT)];
    Iterator localIterator = paramb.bTV.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i = ((Integer)localEntry.getKey()).intValue();
      int j = ((Integer)localEntry.getValue()).intValue();
      if ((j & 0x2) != 0) {
        a(arrayOfByte, 2, i, paramb);
      }
      if ((j & 0x4) != 0) {
        a(arrayOfByte, 4, i, paramb);
      }
    }
    paramOutputStream.write(arrayOfByte);
    AppMethodBeat.o(194331);
  }
  
  private static int fv(int paramInt)
  {
    AppMethodBeat.i(194304);
    paramInt = fw(paramInt * 2) / 8;
    AppMethodBeat.o(194304);
    return paramInt;
  }
  
  private static int fw(int paramInt)
  {
    return paramInt + 8 - 1 & 0xFFFFFFF8;
  }
  
  static byte[] l(InputStream paramInputStream)
  {
    AppMethodBeat.i(194261);
    byte[] arrayOfByte = c.b(paramInputStream, bTZ.length);
    if (!Arrays.equals(bTZ, arrayOfByte))
    {
      paramInputStream = c.aQ("Invalid magic");
      AppMethodBeat.o(194261);
      throw paramInputStream;
    }
    paramInputStream = c.b(paramInputStream, f.bUa.length);
    AppMethodBeat.o(194261);
    return paramInputStream;
  }
  
  private static int w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194374);
    RuntimeException localRuntimeException;
    switch (paramInt1)
    {
    case 3: 
    default: 
      localRuntimeException = c.aQ("Unexpected flag: ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(194374);
      throw localRuntimeException;
    case 1: 
      localRuntimeException = c.aQ("HOT methods are not stored in the bitmap");
      AppMethodBeat.o(194374);
      throw localRuntimeException;
    case 2: 
      AppMethodBeat.o(194374);
      return paramInt2;
    }
    AppMethodBeat.o(194374);
    return paramInt2 + paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.profileinstaller.e
 * JD-Core Version:    0.7.0.1
 */