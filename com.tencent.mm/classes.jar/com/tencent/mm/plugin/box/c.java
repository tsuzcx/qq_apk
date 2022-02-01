package com.tencent.mm.plugin.box;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.protocal.protobuf.gjd;
import com.tencent.mm.protocal.protobuf.gje;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static short[][] vzA;
  private static int[][] vzB;
  private static int[][] vzC;
  private static final HashMap<Integer, LinkedList<Integer>> vzD;
  private static int vzE;
  private static int vzF;
  private static int vzG;
  private static int vzH;
  private static HashSet<String> vzI;
  private static HashSet<gjd> vzJ;
  public static final Runnable vzK;
  private static int vzL;
  private static int vzM;
  private static AtomicBoolean vzy;
  private static AtomicBoolean vzz;
  
  static
  {
    AppMethodBeat.i(278732);
    vzy = new AtomicBoolean(false);
    vzz = new AtomicBoolean(false);
    vzD = new HashMap();
    vzE = 0;
    vzF = 2;
    vzG = 400;
    vzH = 0;
    vzI = new HashSet();
    vzJ = new HashSet();
    vzK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278685);
        try
        {
          String str = c.mL(false);
          int i = 0;
          if (i < 3)
          {
            int j = c.aiq(str);
            if (j == 0)
            {
              AppMethodBeat.o(278685);
              return;
            }
            switch (j)
            {
            }
            do
            {
              i += 1;
              break;
              Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file empty");
              y.deleteFile(str);
              Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, reCreate Model");
            } while (-1 != c.mK(true));
            Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, and raw file not exist");
            AppMethodBeat.o(278685);
            return;
          }
          AppMethodBeat.o(278685);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[loadTask]", new Object[0]);
          AppMethodBeat.o(278685);
        }
      }
    };
    vzL = 1;
    vzM = 0;
    AppMethodBeat.o(278732);
  }
  
  public static int aiq(String paramString)
  {
    AppMethodBeat.i(278709);
    if (!y.ZC(paramString))
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file do NOT exist, path: %s", new Object[] { paramString });
      AppMethodBeat.o(278709);
      return -2;
    }
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file %s %s", new Object[] { paramString, Long.valueOf(y.bEl(paramString)) });
    vzz.set(true);
    vzy.set(false);
    long l = cn.bDw();
    paramString = y.bi(paramString, 0, -1);
    if ((paramString == null) || (paramString.length < 24))
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] bytes.length(%s) < 24", new Object[] { Integer.valueOf(paramString.length) });
      if (paramString.length == 0)
      {
        AppMethodBeat.o(278709);
        return -4;
      }
      AppMethodBeat.o(278709);
      return -3;
    }
    vzM = 0;
    vzE = bo(paramString);
    vzF = bo(paramString);
    vzG = bo(paramString);
    vzH = bo(paramString);
    int i1 = bo(paramString);
    if (i1 != 20003)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file broken, wordGroupC: %s, reCreate model", new Object[] { Integer.valueOf(i1) });
      AppMethodBeat.o(278709);
      return -3;
    }
    int i2 = (paramString.length - 20 - i1 * 4) / 7;
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordCntAvailable = %s", new Object[] { Integer.valueOf(i2) });
    vzA = new short[i1][];
    vzB = new int[i1][];
    vzC = new int[i1][];
    int j = 0;
    int n;
    for (int i = 0; j < i1; i = n)
    {
      int i3 = bo(paramString);
      n = i + i3;
      if (n > i2)
      {
        Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] currCnt(%s) > wordCntAvailable%(%s)", new Object[] { Integer.valueOf(n), Integer.valueOf(i2) });
        AppMethodBeat.o(278709);
        return -3;
      }
      vzA[j] = new short[i3];
      vzB[j] = new int[i3];
      vzC[j] = new int[i3];
      i = 0;
      Object localObject;
      int k;
      int m;
      while (i < i3)
      {
        localObject = vzA[j];
        k = vzM;
        vzM = k + 1;
        k = paramString[k];
        m = vzM;
        vzM = m + 1;
        localObject[i] = ((short)((k << 8 & 0xFF) + (paramString[m] & 0xFF)));
        vzB[j][i] = bo(paramString);
        localObject = vzC[j];
        k = vzM;
        vzM = k + 1;
        paramString[k] &= 0xFF;
        i += 1;
      }
      if (i3 > 200)
      {
        localObject = new LinkedList();
        m = vzA[j][0];
        i = 1;
        k = 1;
        if (k < i3)
        {
          if (vzA[j][k] != m)
          {
            ((LinkedList)localObject).addLast(Integer.valueOf(i));
            i = 1;
            m = vzA[j][k];
          }
          for (;;)
          {
            k += 1;
            break;
            i += 1;
          }
        }
        ((LinkedList)localObject).addLast(Integer.valueOf(i));
        vzD.put(Integer.valueOf(j), localObject);
      }
      j += 1;
    }
    vzy.set(true);
    vzz.set(false);
    l = Math.ceil(cn.bDw() - l);
    as.s(i, l, 2L);
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] load model from disk use %s ms, total cnt = %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    AppMethodBeat.o(278709);
    return 0;
  }
  
  public static boolean air(String paramString)
  {
    AppMethodBeat.i(278711);
    if (vzz.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank is loading, Give UP searching");
      AppMethodBeat.o(278711);
      return false;
    }
    if ((!vzy.get()) || (vzA == null) || (vzB == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank has NOT init");
      AppMethodBeat.o(278711);
      return false;
    }
    if ((paramString.length() < vzF) || (paramString.length() > vzG))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(vzF), Integer.valueOf(vzG) });
      AppMethodBeat.o(278711);
      return false;
    }
    long l = cn.bDw();
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = vzA.length;
      short[] arrayOfShort = vzA[(i % m)];
      int[] arrayOfInt = vzB[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)vzD.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearch] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(278711);
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
          int i2 = aiw(paramString.substring(j, arrayOfShort[i] + j));
          m = i + i1 - 1;
          k = i;
          while (k <= m)
          {
            int i3 = (k + m) / 2;
            if (i2 == arrayOfInt[i3])
            {
              paramString = paramString.substring(j, arrayOfShort[i] + j);
              vzL = Math.max((int)Math.ceil(cn.bDw() - l), 1);
              Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString, Integer.valueOf(vzL) });
              AppMethodBeat.o(278711);
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
        if (aiw(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i])
        {
          vzL = Math.max((int)Math.ceil(cn.bDw() - l), 1);
          Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString.substring(j, arrayOfShort[i] + j), Integer.valueOf(vzL) });
          AppMethodBeat.o(278711);
          return true;
        }
        i += 1;
      }
      j += 1;
    }
    vzL = Math.max((int)Math.ceil(cn.bDw() - l), 1);
    Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] NO hot word found");
    AppMethodBeat.o(278711);
    return false;
  }
  
  public static String ais(String paramString)
  {
    AppMethodBeat.i(278713);
    paramString = ait(paramString);
    Collections.sort(paramString, new c.3());
    if (paramString.size() > 0)
    {
      paramString = ((gjd)paramString.get(0)).vFa;
      AppMethodBeat.o(278713);
      return paramString;
    }
    AppMethodBeat.o(278713);
    return "";
  }
  
  public static LinkedList<gjd> ait(String paramString)
  {
    AppMethodBeat.i(278714);
    LinkedList localLinkedList = new LinkedList();
    if (vzz.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
      AppMethodBeat.o(278714);
      return localLinkedList;
    }
    if ((!vzy.get()) || (vzA == null) || (vzB == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
      AppMethodBeat.o(278714);
      return localLinkedList;
    }
    if ((paramString.length() < vzF) || (paramString.length() > vzG))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(vzF), Integer.valueOf(vzG) });
      AppMethodBeat.o(278714);
      return localLinkedList;
    }
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = vzA.length;
      short[] arrayOfShort = vzA[(i % m)];
      int[] arrayOfInt1 = vzB[(i % m)];
      int[] arrayOfInt2 = vzC[(i % m)];
      int k = arrayOfShort.length;
      Object localObject1;
      Object localObject2;
      if (k > 200)
      {
        localObject1 = (LinkedList)vzD.get(Integer.valueOf(i % m));
        if (localObject1 == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(278714);
          return null;
        }
        i = 0;
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          int i1 = ((Integer)((Iterator)localObject1).next()).intValue();
          if (arrayOfShort[i] + j <= n)
          {
            localObject2 = paramString.substring(j, arrayOfShort[i] + j);
            int i2 = aiw((String)localObject2);
            m = i + i1 - 1;
            k = i;
            for (;;)
            {
              int i3;
              if (k <= m)
              {
                i3 = (k + m) / 2;
                if (i2 == arrayOfInt1[i3])
                {
                  gjd localgjd = new gjd();
                  localgjd.vFa = ((String)localObject2);
                  localgjd.weight = arrayOfInt2[i3];
                  localLinkedList.add(localgjd);
                }
              }
              else
              {
                i += i1;
                break;
              }
              if (i2 < arrayOfInt1[i3]) {
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
        while ((i < k) && (arrayOfShort[i] + j <= n))
        {
          localObject1 = paramString.substring(j, arrayOfShort[i] + j);
          if (aiw((String)localObject1) == arrayOfInt1[i])
          {
            localObject2 = new gjd();
            ((gjd)localObject2).vFa = ((String)localObject1);
            ((gjd)localObject2).weight = arrayOfInt2[i];
            localLinkedList.add(localObject2);
          }
          i += 1;
        }
      }
      j += 1;
    }
    AppMethodBeat.o(278714);
    return localLinkedList;
  }
  
  public static int aiu(String paramString)
  {
    AppMethodBeat.i(278715);
    localObject1 = new u(MMApplicationContext.getContext().getCacheDir(), "wordBank/temp");
    if (((u)localObject1).jKS()) {
      y.ew(ah.v(((u)localObject1).jKT()), true);
    }
    ((u)localObject1).jKY();
    int i = y.aA(paramString, ah.v(((u)localObject1).jKT()));
    if (i < 0)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + ah.v(((u)localObject1).jKT()));
      AppMethodBeat.o(278715);
      return -1;
    }
    Object localObject3 = new u((u)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = y.ao((u)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      ah.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getWordBankVersionFromZip] %s", new Object[] { paramString });
        ah.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      ah.closeQuietly(localObject2);
      AppMethodBeat.o(278715);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(278715);
    return i;
  }
  
  public static int aiv(String paramString)
  {
    AppMethodBeat.i(278721);
    String str = dbk();
    if (y.ZC(str)) {
      y.ew(str, true);
    }
    y.bDX(str);
    int i = y.aA(paramString, str);
    if (i < 0)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + str);
      AppMethodBeat.o(278721);
      return -1;
    }
    Log.i("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip success, path: %s", new Object[] { str });
    AppMethodBeat.o(278721);
    return 0;
  }
  
  private static int aiw(String paramString)
  {
    AppMethodBeat.i(278730);
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = i * 131 + k)
    {
      k = (short)paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(278730);
    return 0x7FFFFFFF & i;
  }
  
  public static void bn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(278707);
    int i;
    int j;
    for (;;)
    {
      Object localObject;
      try
      {
        paramArrayOfByte = (eml)new eml().parseFrom(paramArrayOfByte);
        vzE = paramArrayOfByte.version;
        localObject = paramArrayOfByte.abqO;
        i = ((gje)localObject).version;
        vzI.clear();
        vzI.addAll(((gje)localObject).acfu);
        paramArrayOfByte = paramArrayOfByte.abqN;
        j = paramArrayOfByte.version;
        vzJ.clear();
        if (paramArrayOfByte.acfv.size() > 0)
        {
          vzJ.addAll(paramArrayOfByte.acfv);
          paramArrayOfByte = vzJ.iterator();
          if (!paramArrayOfByte.hasNext()) {
            break;
          }
          localObject = (gjd)paramArrayOfByte.next();
          Log.i("MicroMsg.HotWordSearchUtil", "[white word]: %s %s", new Object[] { ((gjd)localObject).vFa, Integer.valueOf(((gjd)localObject).weight) });
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.acfu.iterator();
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", paramArrayOfByte, "[resolveRealTimeWordBankFile]", new Object[0]);
        AppMethodBeat.o(278707);
        return;
      }
      while (paramArrayOfByte.hasNext())
      {
        localObject = (String)paramArrayOfByte.next();
        gjd localgjd = new gjd();
        localgjd.vFa = ((String)localObject);
        localgjd.weight = 255;
        vzJ.add(localgjd);
      }
    }
    paramArrayOfByte = vzI.iterator();
    while (paramArrayOfByte.hasNext()) {
      Log.i("MicroMsg.HotWordSearchUtil", "[black word]: %s", new Object[] { (String)paramArrayOfByte.next() });
    }
    Log.i("MicroMsg.HotWordSearchUtil", "realTimeWordsVersion: %s, blackVer: %s whiteVer: %s minMatchLen: %s, maxMatchLen: %s, disable: %s, blackList.size: %s, whiteList.size: %s", new Object[] { Integer.valueOf(vzE), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(vzF), Integer.valueOf(vzG), Integer.valueOf(vzH), Integer.valueOf(vzI.size()), Integer.valueOf(vzJ.size()) });
    AppMethodBeat.o(278707);
  }
  
  private static int bo(byte[] paramArrayOfByte)
  {
    int i = vzM;
    vzM = i + 1;
    i = paramArrayOfByte[i];
    int j = vzM;
    vzM = j + 1;
    j = paramArrayOfByte[j];
    int k = vzM;
    vzM = k + 1;
    k = paramArrayOfByte[k];
    int m = vzM;
    vzM = m + 1;
    return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF);
  }
  
  public static int dbi()
  {
    AppMethodBeat.i(278717);
    localObject1 = dbk();
    if (!y.ZC((String)localObject1 + "/config.conf"))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[getCurrentWordBankVersion] config.conf NOT exist, path: %s", new Object[] { (String)localObject1 + "/config.conf" });
      AppMethodBeat.o(278717);
      return 1;
    }
    Object localObject4 = new u((String)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = y.ao((u)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      ah.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getCurrentWordBankVersion]", new Object[0]);
        ah.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      ah.closeQuietly(localObject3);
      AppMethodBeat.o(278717);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(278717);
    return i;
  }
  
  public static String dbj()
  {
    AppMethodBeat.i(278725);
    String str = ah.v(new u(new u(dbk()), "blackWhite").jKT());
    AppMethodBeat.o(278725);
    return str;
  }
  
  private static String dbk()
  {
    AppMethodBeat.i(278727);
    String str = aj.asW(2).iqp() + "/wordBankDir";
    AppMethodBeat.o(278727);
    return str;
  }
  
  public static int getSearchDuration()
  {
    AppMethodBeat.i(278729);
    int i = Math.max(vzL, 1);
    AppMethodBeat.o(278729);
    return i;
  }
  
  public static String getWordBankVersionForStat()
  {
    AppMethodBeat.i(278719);
    String str = dbi() + "_" + vzE;
    AppMethodBeat.o(278719);
    return str;
  }
  
  public static int mK(boolean paramBoolean)
  {
    AppMethodBeat.i(278702);
    String str = mL(true);
    if (!y.ZC(str))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] rawFile NOT exists, path = %s", new Object[] { str });
      AppMethodBeat.o(278702);
      return -1;
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = dbj();
      if (y.ZC((String)localObject3))
      {
        localObject3 = y.bi((String)localObject3, 0, -1);
        if (localObject3.length <= 0) {
          break label125;
        }
        bn((byte[])localObject3);
      }
    }
    int k;
    for (;;)
    {
      l = cn.bDw();
      k = 0;
      localObject3 = new LinkedList[20003];
      i = 0;
      while (i < 20003)
      {
        localObject3[i] = new LinkedList();
        i += 1;
      }
      label125:
      Log.e("MicroMsg.HotWordSearchUtil", "[resolveRealTimeWordBank] Length of real time word bank file = 0");
    }
    int j = k;
    Object localObject4;
    int n;
    Object localObject5;
    label248:
    int m;
    short s;
    try
    {
      localObject4 = new String(y.bi(str, 0, -1)).split("\n");
      j = k;
      i = localObject4.length - 1;
      j = i;
      int i1 = Util.getInt(localObject4[0], 0);
      n = 1;
      j = i;
      if (n >= localObject4.length) {
        break label422;
      }
      k = 0;
      if (i1 < 200000) {
        break label909;
      }
      j = i;
      localObject5 = localObject4[n].split(" ");
      j = i;
      if (localObject5.length <= 1) {
        break label897;
      }
      str = localObject5[0];
      j = i;
      k = Util.getInt(localObject5[1], 0);
      j = i;
      m = i;
      if (Util.isNullOrNil(str)) {
        break label885;
      }
      j = i;
      if (vzI.contains(str))
      {
        m = i - 1;
      }
      else
      {
        j = i;
        if (str.length() < 2) {
          break label919;
        }
        j = i;
        if (str.contains(",")) {
          break label919;
        }
        j = i;
        m = str.substring(0, 2).hashCode();
        j = i;
        int i2 = aiw(str);
        j = i;
        s = (short)str.length();
        j = i;
        localObject3[(m % 20003)].add(new a(s, i2, k));
        m = i;
      }
    }
    catch (Exception localException1) {}
    label376:
    Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException1, "[createModelFromRawFileAndSave]", new Object[0]);
    int i = j;
    for (;;)
    {
      j = 0;
      label422:
      Object localObject1;
      while (j < 20003)
      {
        Collections.sort(localObject3[j], new Comparator() {});
        j += 1;
        continue;
        j = i;
        localObject1 = vzJ.iterator();
      }
      try
      {
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (gjd)((Iterator)localObject1).next();
          if ((((gjd)localObject4).vFa.length() >= 2) && (!((gjd)localObject4).vFa.contains(",")))
          {
            j = ((gjd)localObject4).vFa.substring(0, 2).hashCode();
            k = aiw(((gjd)localObject4).vFa);
            s = (short)((gjd)localObject4).vFa.length();
            localObject3[(j % 20003)].add(new a(s, k, ((gjd)localObject4).weight));
            i += 1;
          }
        }
      }
      catch (Exception localException3)
      {
        j = i;
      }
    }
    long l = cn.bDw() - l;
    as.s(i, l, 1L);
    Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] Create model use %s ms, word cnt: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    l = cn.bDw();
    for (;;)
    {
      try
      {
        localObject4 = mL(false);
        if (y.ZC((String)localObject4)) {
          y.deleteFile((String)localObject4);
        }
        y.bEp((String)localObject4);
        localObject1 = ByteBuffer.allocate(80012 + i * 7 + 50);
        ((ByteBuffer)localObject1).order(ByteOrder.BIG_ENDIAN);
        ((ByteBuffer)localObject1).clear();
        ((ByteBuffer)localObject1).putInt(vzE);
        ((ByteBuffer)localObject1).putInt(vzF);
        ((ByteBuffer)localObject1).putInt(vzG);
        ((ByteBuffer)localObject1).putInt(vzH);
        ((ByteBuffer)localObject1).putInt(20003);
        i = 0;
        if (i < 20003)
        {
          k = localObject3[i].size();
          ((ByteBuffer)localObject1).putInt(k);
          j = 0;
          if (j >= k) {
            break label927;
          }
          localObject5 = (a)localObject3[i].get(j);
          ((ByteBuffer)localObject1).putShort(((a)localObject5).vzN);
          ((ByteBuffer)localObject1).putInt(((a)localObject5).vzO);
          ((ByteBuffer)localObject1).put((byte)(((a)localObject5).weight & 0xFF));
          j += 1;
          continue;
        }
        ((ByteBuffer)localObject1).flip();
        localObject3 = y.d(ah.parseUri((String)localObject4), null);
        ((WritableByteChannel)localObject3).write((ByteBuffer)localObject1);
        ((WritableByteChannel)localObject3).close();
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException2, "[createModelFromTXTFileAndSave save]", new Object[0]);
        continue;
      }
      Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromTXTFileAndSave] Write model to disk use %s ms", new Object[] { Long.valueOf(cn.bDw() - l) });
      AppMethodBeat.o(278702);
      return 0;
      break label376;
      for (;;)
      {
        label885:
        n += 1;
        i = m;
        break;
        label897:
        Object localObject2 = localObject5[0];
        k = 0;
        break label248;
        label909:
        localObject2 = localObject4[n];
        break label248;
        label919:
        m = i - 1;
      }
      label927:
      i += 1;
    }
  }
  
  public static String mL(boolean paramBoolean)
  {
    AppMethodBeat.i(278723);
    u localu = new u(dbk());
    if (paramBoolean) {}
    for (String str = "fs_kw_main.txt";; str = "wordBank_Weight_1")
    {
      str = ah.v(new u(localu, str).jKT());
      AppMethodBeat.o(278723);
      return str;
    }
  }
  
  static final class a
  {
    short vzN;
    int vzO;
    int weight;
    
    a(short paramShort, int paramInt1, int paramInt2)
    {
      this.vzN = paramShort;
      this.vzO = paramInt1;
      this.weight = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c
 * JD-Core Version:    0.7.0.1
 */