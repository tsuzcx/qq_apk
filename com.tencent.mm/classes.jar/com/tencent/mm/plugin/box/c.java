package com.tencent.mm.plugin.box;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static AtomicBoolean nUP;
  private static AtomicBoolean nUQ;
  private static short[][] nUR;
  private static int[][] nUS;
  private static final HashMap<Integer, LinkedList<Integer>> nUT;
  private static int nUU;
  private static int nUV;
  private static int nUW;
  private static int nUX;
  private static HashSet<String> nUY;
  private static HashSet<String> nUZ;
  private static int nVa;
  public static final Runnable vJD;
  private static int vJE;
  
  static
  {
    AppMethodBeat.i(219098);
    nUP = new AtomicBoolean(false);
    nUQ = new AtomicBoolean(false);
    nUT = new HashMap();
    nUU = 0;
    nUV = 2;
    nUW = 400;
    nUX = 0;
    nUY = new HashSet();
    nUZ = new HashSet();
    vJD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221325);
        try
        {
          String str = c.jk(false);
          int i = 0;
          if (i < 3)
          {
            int j = c.WG(str);
            if (j == 0)
            {
              AppMethodBeat.o(221325);
              return;
            }
            switch (j)
            {
            }
            do
            {
              i += 1;
              break;
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file empty");
              i.deleteFile(str);
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, reCreate Model");
            } while (-1 != c.mv(true));
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, and raw file not exist");
            AppMethodBeat.o(221325);
            return;
          }
          AppMethodBeat.o(221325);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[loadTask]", new Object[0]);
          AppMethodBeat.o(221325);
        }
      }
    };
    nVa = 1;
    vJE = 0;
    AppMethodBeat.o(219098);
  }
  
  public static int WG(String paramString)
  {
    AppMethodBeat.i(219087);
    if ((!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) || (!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] finger search not open");
      AppMethodBeat.o(219087);
      return 0;
    }
    if (!i.fv(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file do NOT exist, path: %s", new Object[] { paramString });
      AppMethodBeat.o(219087);
      return -2;
    }
    nUQ.set(true);
    nUP.set(false);
    long l = cf.aCM();
    paramString = i.aY(paramString, 0, -1);
    vJE = 0;
    if (paramString.length < 24)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] bytes.length(%s) < 24", new Object[] { Integer.valueOf(paramString.length) });
      if (paramString.length == 0)
      {
        AppMethodBeat.o(219087);
        return -4;
      }
      AppMethodBeat.o(219087);
      return -3;
    }
    nUU = aK(paramString);
    nUV = aK(paramString);
    nUW = aK(paramString);
    nUX = aK(paramString);
    int i1 = aK(paramString);
    if (i1 != 20003)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file broken, wordGroupC: %s, reCreate model", new Object[] { Integer.valueOf(i1) });
      AppMethodBeat.o(219087);
      return -3;
    }
    int i2 = (paramString.length - 20 - i1 * 4) / 6;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordCntAvailable = %s", new Object[] { Integer.valueOf(i2) });
    nUR = new short[i1][];
    nUS = new int[i1][];
    int j = 0;
    int n;
    for (int i = 0; j < i1; i = n)
    {
      int i3 = aK(paramString);
      n = i + i3;
      if (n > i2)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] currCnt(%s) > wordCntAvailable%(%s)", new Object[] { Integer.valueOf(n), Integer.valueOf(i2) });
        AppMethodBeat.o(219087);
        return -3;
      }
      nUR[j] = new short[i3];
      nUS[j] = new int[i3];
      i = 0;
      Object localObject;
      int k;
      int m;
      while (i < i3)
      {
        localObject = nUR[j];
        k = vJE;
        vJE = k + 1;
        k = paramString[k];
        m = vJE;
        vJE = m + 1;
        localObject[i] = ((short)((k << 8 & 0xFF) + (paramString[m] & 0xFF)));
        nUS[j][i] = aK(paramString);
        i += 1;
      }
      if (i3 > 200)
      {
        localObject = new LinkedList();
        m = nUR[j][0];
        i = 1;
        k = 1;
        if (k < i3)
        {
          if (nUR[j][k] != m)
          {
            ((LinkedList)localObject).addLast(Integer.valueOf(i));
            i = 1;
            m = nUR[j][k];
          }
          for (;;)
          {
            k += 1;
            break;
            i += 1;
          }
        }
        ((LinkedList)localObject).addLast(Integer.valueOf(i));
        nUT.put(Integer.valueOf(j), localObject);
      }
      j += 1;
    }
    nUP.set(true);
    nUQ.set(false);
    l = Math.ceil(cf.aCM() - l);
    am.o(i, l, 2L);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] load model from disk use %s ms, total cnt = %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    AppMethodBeat.o(219087);
    return 0;
  }
  
  public static boolean WH(String paramString)
  {
    AppMethodBeat.i(219088);
    if (nUQ.get())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank is loading, Give UP searching");
      AppMethodBeat.o(219088);
      return false;
    }
    if ((!nUP.get()) || (nUR == null) || (nUS == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank has NOT init");
      AppMethodBeat.o(219088);
      return false;
    }
    if ((paramString.length() < nUV) || (paramString.length() > nUW))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearch] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(nUV), Integer.valueOf(nUW) });
      AppMethodBeat.o(219088);
      return false;
    }
    long l = cf.aCM();
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = nUR.length;
      short[] arrayOfShort = nUR[(i % m)];
      int[] arrayOfInt = nUS[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)nUT.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[hashSearch] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(219088);
          return false;
        }
        i = 0;
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i1 = ((Integer)((Iterator)localObject).next()).intValue();
          if (arrayOfShort[i] + j > n) {
            break;
          }
          int i2 = WL(paramString.substring(j, arrayOfShort[i] + j));
          m = i + i1 - 1;
          k = i;
          while (k <= m)
          {
            int i3 = (k + m) / 2;
            if (i2 == arrayOfInt[i3])
            {
              paramString = paramString.substring(j, arrayOfShort[i] + j);
              nVa = Math.max((int)Math.ceil(cf.aCM() - l), 1);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString, Integer.valueOf(nVa) });
              AppMethodBeat.o(219088);
              return true;
            }
            if (i2 < arrayOfInt[i3]) {
              m = i3 - 1;
            } else {
              k = i3 + 1;
            }
          }
          i += i1;
        }
      }
      i = 0;
      while ((i < k) && (arrayOfShort[i] + j <= n))
      {
        if (WL(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i])
        {
          nVa = Math.max((int)Math.ceil(cf.aCM() - l), 1);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString.substring(j, arrayOfShort[i] + j), Integer.valueOf(nVa) });
          AppMethodBeat.o(219088);
          return true;
        }
        i += 1;
      }
      j += 1;
    }
    nVa = Math.max((int)Math.ceil(cf.aCM() - l), 1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearch] NO hot word found");
    AppMethodBeat.o(219088);
    return false;
  }
  
  public static String WI(String paramString)
  {
    AppMethodBeat.i(219089);
    if (nUQ.get())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
      AppMethodBeat.o(219089);
      return "";
    }
    if ((!nUP.get()) || (nUR == null) || (nUS == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
      AppMethodBeat.o(219089);
      return "";
    }
    if ((paramString.length() < nUV) || (paramString.length() > nUW))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(nUV), Integer.valueOf(nUW) });
      AppMethodBeat.o(219089);
      return "";
    }
    Object localObject1 = new HashSet();
    int n = paramString.length();
    int j = 0;
    Object localObject2;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = nUR.length;
      localObject2 = nUR[(i % m)];
      int[] arrayOfInt = nUS[(i % m)];
      int k = localObject2.length;
      if (k > 200)
      {
        Object localObject3 = (LinkedList)nUT.get(Integer.valueOf(i % m));
        if (localObject3 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(219089);
          return null;
        }
        i = 0;
        localObject3 = ((LinkedList)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          int i1 = ((Integer)((Iterator)localObject3).next()).intValue();
          if (localObject2[i] + j <= n)
          {
            int i2 = WL(paramString.substring(j, localObject2[i] + j));
            m = i + i1 - 1;
            k = i;
            for (;;)
            {
              int i3;
              if (k <= m)
              {
                i3 = (k + m) / 2;
                if (i2 == arrayOfInt[i3]) {
                  ((HashSet)localObject1).add(paramString.substring(j, localObject2[i] + j));
                }
              }
              else
              {
                i += i1;
                break;
              }
              if (i2 < arrayOfInt[i3]) {
                m = i3 - 1;
              } else {
                k = i3 + 1;
              }
            }
          }
        }
      }
      else
      {
        i = 0;
        while ((i < k) && (localObject2[i] + j <= n))
        {
          if (WL(paramString.substring(j, localObject2[i] + j)) == arrayOfInt[i]) {
            ((HashSet)localObject1).add(paramString.substring(j, localObject2[i] + j));
          }
          i += 1;
        }
      }
      j += 1;
    }
    if (((HashSet)localObject1).size() == 0)
    {
      AppMethodBeat.o(219089);
      return "";
    }
    paramString = new StringBuilder();
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] found hot word: %s", new Object[] { localObject2 });
      paramString.append((String)localObject2).append('|');
    }
    paramString = paramString.substring(0, paramString.length() - 1);
    AppMethodBeat.o(219089);
    return paramString;
  }
  
  public static int WJ(String paramString)
  {
    AppMethodBeat.i(219090);
    localObject1 = new e(aj.getContext().getCacheDir(), "wordBank/temp");
    if (((e)localObject1).exists()) {
      i.cZ(q.B(((e)localObject1).fOK()), true);
    }
    ((e)localObject1).mkdirs();
    int i = i.fz(paramString, q.B(((e)localObject1).fOK()));
    if (i < 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + q.B(((e)localObject1).fOK()));
      AppMethodBeat.o(219090);
      return -1;
    }
    Object localObject3 = new e((e)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = i.ai((e)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      q.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getWordBankVersionFromZip] %s", new Object[] { paramString });
        q.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      q.closeQuietly(localObject2);
      AppMethodBeat.o(219090);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(219090);
    return i;
  }
  
  public static int WK(String paramString)
  {
    AppMethodBeat.i(219093);
    String str = bMZ();
    if (i.fv(str)) {
      i.cZ(str, true);
    }
    i.aYg(str);
    int i = i.fz(paramString, str);
    if (i < 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + str);
      AppMethodBeat.o(219093);
      return -1;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip success, path: %s", new Object[] { str });
    AppMethodBeat.o(219093);
    return 0;
  }
  
  private static int WL(String paramString)
  {
    AppMethodBeat.i(219097);
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = i * 131 + k)
    {
      k = (short)paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(219097);
    return 0x7FFFFFFF & i;
  }
  
  public static void aJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221327);
    try
    {
      paramArrayOfByte = (crh)new crh().parseFrom(paramArrayOfByte);
      nUU = paramArrayOfByte.version;
      efl localefl = paramArrayOfByte.HjH;
      nUY.clear();
      nUY.addAll(localefl.HQI);
      paramArrayOfByte = paramArrayOfByte.HjG;
      nUZ.clear();
      nUZ.addAll(paramArrayOfByte.HQI);
      paramArrayOfByte = nUZ.iterator();
      while (paramArrayOfByte.hasNext()) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[white word]: %s", new Object[] { (String)paramArrayOfByte.next() });
      }
      paramArrayOfByte = nUY.iterator();
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HotWordSearchUtil", paramArrayOfByte, "[resolveRealTimeWordBankFile]", new Object[0]);
      AppMethodBeat.o(221327);
      return;
    }
    while (paramArrayOfByte.hasNext()) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[black word]: %s", new Object[] { (String)paramArrayOfByte.next() });
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "realTimeWordsVersion: %s, minMatchLen: %s, maxMatchLen: %s, disable: %s, blackList.size: %s, whiteList.size: %s", new Object[] { Integer.valueOf(nUU), Integer.valueOf(nUV), Integer.valueOf(nUW), Integer.valueOf(nUX), Integer.valueOf(nUY.size()), Integer.valueOf(nUZ.size()) });
    AppMethodBeat.o(221327);
  }
  
  private static int aK(byte[] paramArrayOfByte)
  {
    int i = vJE;
    vJE = i + 1;
    i = paramArrayOfByte[i];
    int j = vJE;
    vJE = j + 1;
    j = paramArrayOfByte[j];
    int k = vJE;
    vJE = k + 1;
    k = paramArrayOfByte[k];
    int m = vJE;
    vJE = m + 1;
    return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF);
  }
  
  public static String bEc()
  {
    AppMethodBeat.i(221328);
    String str = q.B(new e(new e(bMZ()), "blackWhite").fOK());
    AppMethodBeat.o(221328);
    return str;
  }
  
  public static int bMY()
  {
    AppMethodBeat.i(219091);
    localObject1 = bMZ();
    if (!i.fv((String)localObject1 + "/config.conf"))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[getCurrentWordBankVersion] config.conf NOT exist, path: %s", new Object[] { (String)localObject1 + "/config.conf" });
      AppMethodBeat.o(219091);
      return 1;
    }
    Object localObject4 = new e((String)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = i.ai((e)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      q.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getCurrentWordBankVersion]", new Object[0]);
        q.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      q.closeQuietly(localObject3);
      AppMethodBeat.o(219091);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(219091);
    return i;
  }
  
  private static String bMZ()
  {
    AppMethodBeat.i(219095);
    String str = com.tencent.mm.plugin.websearch.api.ad.Wc(2).eMw() + "/wordBankDir";
    AppMethodBeat.o(219095);
    return str;
  }
  
  public static int getSearchDuration()
  {
    AppMethodBeat.i(219096);
    int i = Math.max(nVa, 1);
    AppMethodBeat.o(219096);
    return i;
  }
  
  public static String getWordBankVersionForStat()
  {
    AppMethodBeat.i(219092);
    String str = bMY() + "_" + nUU;
    AppMethodBeat.o(219092);
    return str;
  }
  
  public static String jk(boolean paramBoolean)
  {
    AppMethodBeat.i(219094);
    e locale = new e(bMZ());
    if (paramBoolean) {}
    for (String str = "fs_kw_main.txt";; str = "wordBank")
    {
      str = q.B(new e(locale, str).fOK());
      AppMethodBeat.o(219094);
      return str;
    }
  }
  
  public static int mv(boolean paramBoolean)
  {
    AppMethodBeat.i(221326);
    if ((!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) || (!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] finger search not open");
      AppMethodBeat.o(221326);
      return 0;
    }
    Object localObject1 = jk(true);
    if (!i.fv((String)localObject1))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] rawFile NOT exists, path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(221326);
      return -1;
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = bEc();
      if (i.fv((String)localObject3))
      {
        localObject3 = i.aY((String)localObject3, 0, -1);
        if (localObject3.length <= 0) {
          break label170;
        }
        aJ((byte[])localObject3);
      }
    }
    for (;;)
    {
      l = cf.aCM();
      localObject3 = new LinkedList[20003];
      i = 0;
      while (i < 20003)
      {
        localObject3[i] = new LinkedList();
        i += 1;
      }
      label170:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HotWordSearchUtil", "[resolveRealTimeWordBank] Length of real time word bank file = 0");
    }
    for (;;)
    {
      try
      {
        localObject1 = new String(i.aY((String)localObject1, 0, -1)).split("\n");
        i = localObject1.length;
        i -= 1;
        k = 1;
      }
      catch (Exception localException3)
      {
        int k;
        String str;
        short s;
        i = 0;
        continue;
        continue;
        k += 1;
        i = j;
        continue;
        int j = i - 1;
        continue;
        i += 1;
        continue;
      }
      try
      {
        if (k >= localObject1.length) {
          continue;
        }
        str = localObject1[k];
        j = i;
        if (bt.isNullOrNil(str)) {
          continue;
        }
        if (nUY.contains(str))
        {
          j = i - 1;
        }
        else
        {
          if ((str.length() < 2) || (str.contains(","))) {
            continue;
          }
          j = str.substring(0, 2).hashCode();
          int m = WL(str);
          s = (short)str.length();
          localObject3[(j % 20003)].add(new a(s, m));
          j = i;
        }
      }
      catch (Exception localException1) {}
    }
    com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException1, "[createModelFromRawFileAndSave]", new Object[0]);
    for (;;)
    {
      j = 0;
      Object localObject2;
      for (;;)
      {
        if (j < 20003)
        {
          Collections.sort(localObject3[j], new c.2());
          j += 1;
          continue;
          j = i;
          if (nUZ != null) {
            localObject2 = nUZ.iterator();
          }
        }
      }
      try
      {
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if ((str.length() >= 2) && (!str.contains(",")))
          {
            j = str.substring(0, 2).hashCode();
            k = WL(str);
            s = (short)str.length();
            localObject3[(j % 20003)].add(new a(s, k));
            i += 1;
          }
        }
        j = i;
        i = j;
      }
      catch (Exception localException4) {}
    }
    long l = cf.aCM() - l;
    am.o(i, l, 1L);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] Create model use %s ms, word cnt: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    l = cf.aCM();
    for (;;)
    {
      try
      {
        str = jk(false);
        if (i.fv(str)) {
          i.deleteFile(str);
        }
        i.aYs(str);
        localObject2 = ByteBuffer.allocate(80012 + i * 6 + 50);
        ((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN);
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).putInt(nUU);
        ((ByteBuffer)localObject2).putInt(nUV);
        ((ByteBuffer)localObject2).putInt(nUW);
        ((ByteBuffer)localObject2).putInt(nUX);
        ((ByteBuffer)localObject2).putInt(20003);
        i = 0;
        if (i < 20003)
        {
          k = localObject3[i].size();
          ((ByteBuffer)localObject2).putInt(k);
          j = 0;
          if (j >= k) {
            break;
          }
          ((ByteBuffer)localObject2).putShort(((a)localObject3[i].get(j)).nVc);
          ((ByteBuffer)localObject2).putInt(((a)localObject3[i].get(j)).nVd);
          j += 1;
          continue;
        }
        ((ByteBuffer)localObject2).flip();
        if ((str == null) || (str.isEmpty()))
        {
          localObject2 = new FileNotFoundException("path is empty");
          AppMethodBeat.o(221326);
          throw ((Throwable)localObject2);
        }
      }
      catch (Exception localException2)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException2, "[createModelFromTXTFileAndSave save]", new Object[0]);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HotWordSearchUtil", "[createModelFromTXTFileAndSave] Write model to disk use %s ms", new Object[] { Long.valueOf(cf.aCM() - l) });
        AppMethodBeat.o(221326);
        return 0;
      }
      localObject3 = i.d(q.parseUri(str), null);
      ((WritableByteChannel)localObject3).write(localException2);
      ((WritableByteChannel)localObject3).close();
    }
  }
  
  static final class a
  {
    short nVc;
    int nVd;
    
    a(short paramShort, int paramInt)
    {
      this.nVc = paramShort;
      this.nVd = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c
 * JD-Core Version:    0.7.0.1
 */