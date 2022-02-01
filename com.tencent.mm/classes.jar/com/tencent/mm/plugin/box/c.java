package com.tencent.mm.plugin.box;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static AtomicBoolean snA;
  private static AtomicBoolean snB;
  private static short[][] snC;
  private static int[][] snD;
  private static int[][] snE;
  private static final HashMap<Integer, LinkedList<Integer>> snF;
  private static int snG;
  private static int snH;
  private static int snI;
  private static int snJ;
  private static HashSet<String> snK;
  private static HashSet<fml> snL;
  public static final Runnable snM;
  private static int snN;
  private static int snO;
  
  static
  {
    AppMethodBeat.i(250375);
    snA = new AtomicBoolean(false);
    snB = new AtomicBoolean(false);
    snF = new HashMap();
    snG = 0;
    snH = 2;
    snI = 400;
    snJ = 0;
    snK = new HashSet();
    snL = new HashSet();
    snM = new c.1();
    snN = 1;
    snO = 0;
    AppMethodBeat.o(250375);
  }
  
  public static int aoU(String paramString)
  {
    AppMethodBeat.i(250351);
    if (!u.agG(paramString))
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file do NOT exist, path: %s", new Object[] { paramString });
      AppMethodBeat.o(250351);
      return -2;
    }
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file %s %s", new Object[] { paramString, Long.valueOf(u.bBQ(paramString)) });
    snB.set(true);
    snA.set(false);
    long l = cm.bfE();
    paramString = u.aY(paramString, 0, -1);
    snO = 0;
    if (paramString.length < 24)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] bytes.length(%s) < 24", new Object[] { Integer.valueOf(paramString.length) });
      if (paramString.length == 0)
      {
        AppMethodBeat.o(250351);
        return -4;
      }
      AppMethodBeat.o(250351);
      return -3;
    }
    snG = bo(paramString);
    snH = bo(paramString);
    snI = bo(paramString);
    snJ = bo(paramString);
    int i1 = bo(paramString);
    if (i1 != 20003)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file broken, wordGroupC: %s, reCreate model", new Object[] { Integer.valueOf(i1) });
      AppMethodBeat.o(250351);
      return -3;
    }
    int i2 = (paramString.length - 20 - i1 * 4) / 7;
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordCntAvailable = %s", new Object[] { Integer.valueOf(i2) });
    snC = new short[i1][];
    snD = new int[i1][];
    snE = new int[i1][];
    int j = 0;
    int n;
    for (int i = 0; j < i1; i = n)
    {
      int i3 = bo(paramString);
      n = i + i3;
      if (n > i2)
      {
        Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] currCnt(%s) > wordCntAvailable%(%s)", new Object[] { Integer.valueOf(n), Integer.valueOf(i2) });
        AppMethodBeat.o(250351);
        return -3;
      }
      snC[j] = new short[i3];
      snD[j] = new int[i3];
      snE[j] = new int[i3];
      i = 0;
      Object localObject;
      int k;
      int m;
      while (i < i3)
      {
        localObject = snC[j];
        k = snO;
        snO = k + 1;
        k = paramString[k];
        m = snO;
        snO = m + 1;
        localObject[i] = ((short)((k << 8 & 0xFF) + (paramString[m] & 0xFF)));
        snD[j][i] = bo(paramString);
        localObject = snE[j];
        k = snO;
        snO = k + 1;
        paramString[k] &= 0xFF;
        i += 1;
      }
      if (i3 > 200)
      {
        localObject = new LinkedList();
        m = snC[j][0];
        i = 1;
        k = 1;
        if (k < i3)
        {
          if (snC[j][k] != m)
          {
            ((LinkedList)localObject).addLast(Integer.valueOf(i));
            i = 1;
            m = snC[j][k];
          }
          for (;;)
          {
            k += 1;
            break;
            i += 1;
          }
        }
        ((LinkedList)localObject).addLast(Integer.valueOf(i));
        snF.put(Integer.valueOf(j), localObject);
      }
      j += 1;
    }
    snA.set(true);
    snB.set(false);
    l = Math.ceil(cm.bfE() - l);
    ar.q(i, l, 2L);
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] load model from disk use %s ms, total cnt = %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    AppMethodBeat.o(250351);
    return 0;
  }
  
  public static boolean aoV(String paramString)
  {
    AppMethodBeat.i(250353);
    if (snB.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank is loading, Give UP searching");
      AppMethodBeat.o(250353);
      return false;
    }
    if ((!snA.get()) || (snC == null) || (snD == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank has NOT init");
      AppMethodBeat.o(250353);
      return false;
    }
    if ((paramString.length() < snH) || (paramString.length() > snI))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(snH), Integer.valueOf(snI) });
      AppMethodBeat.o(250353);
      return false;
    }
    long l = cm.bfE();
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = snC.length;
      short[] arrayOfShort = snC[(i % m)];
      int[] arrayOfInt = snD[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)snF.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearch] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(250353);
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
          int i2 = apa(paramString.substring(j, arrayOfShort[i] + j));
          m = i + i1 - 1;
          k = i;
          while (k <= m)
          {
            int i3 = (k + m) / 2;
            if (i2 == arrayOfInt[i3])
            {
              paramString = paramString.substring(j, arrayOfShort[i] + j);
              snN = Math.max((int)Math.ceil(cm.bfE() - l), 1);
              Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString, Integer.valueOf(snN) });
              AppMethodBeat.o(250353);
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
        if (apa(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i])
        {
          snN = Math.max((int)Math.ceil(cm.bfE() - l), 1);
          Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString.substring(j, arrayOfShort[i] + j), Integer.valueOf(snN) });
          AppMethodBeat.o(250353);
          return true;
        }
        i += 1;
      }
      j += 1;
    }
    snN = Math.max((int)Math.ceil(cm.bfE() - l), 1);
    Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] NO hot word found");
    AppMethodBeat.o(250353);
    return false;
  }
  
  public static String aoW(String paramString)
  {
    AppMethodBeat.i(250354);
    paramString = aoX(paramString);
    Collections.sort(paramString, new Comparator() {});
    if (paramString.size() > 0)
    {
      paramString = ((fml)paramString.get(0)).szv;
      AppMethodBeat.o(250354);
      return paramString;
    }
    AppMethodBeat.o(250354);
    return "";
  }
  
  public static LinkedList<fml> aoX(String paramString)
  {
    AppMethodBeat.i(250355);
    LinkedList localLinkedList = new LinkedList();
    if (snB.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
      AppMethodBeat.o(250355);
      return localLinkedList;
    }
    if ((!snA.get()) || (snC == null) || (snD == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
      AppMethodBeat.o(250355);
      return localLinkedList;
    }
    if ((paramString.length() < snH) || (paramString.length() > snI))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(snH), Integer.valueOf(snI) });
      AppMethodBeat.o(250355);
      return localLinkedList;
    }
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = snC.length;
      short[] arrayOfShort = snC[(i % m)];
      int[] arrayOfInt1 = snD[(i % m)];
      int[] arrayOfInt2 = snE[(i % m)];
      int k = arrayOfShort.length;
      Object localObject1;
      Object localObject2;
      if (k > 200)
      {
        localObject1 = (LinkedList)snF.get(Integer.valueOf(i % m));
        if (localObject1 == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(250355);
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
            int i2 = apa((String)localObject2);
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
                  fml localfml = new fml();
                  localfml.szv = ((String)localObject2);
                  localfml.weight = arrayOfInt2[i3];
                  localLinkedList.add(localfml);
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
          if (apa((String)localObject1) == arrayOfInt1[i])
          {
            localObject2 = new fml();
            ((fml)localObject2).szv = ((String)localObject1);
            ((fml)localObject2).weight = arrayOfInt2[i];
            localLinkedList.add(localObject2);
          }
          i += 1;
        }
      }
      j += 1;
    }
    AppMethodBeat.o(250355);
    return localLinkedList;
  }
  
  public static int aoY(String paramString)
  {
    AppMethodBeat.i(250358);
    localObject1 = new q(MMApplicationContext.getContext().getCacheDir(), "wordBank/temp");
    if (((q)localObject1).ifE()) {
      u.deleteDir(((q)localObject1).bOF());
    }
    ((q)localObject1).ifL();
    int i = u.gj(paramString, ((q)localObject1).bOF());
    if (i < 0)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + ((q)localObject1).bOF());
      AppMethodBeat.o(250358);
      return -1;
    }
    Object localObject3 = new q((q)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = u.al((q)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      ad.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getWordBankVersionFromZip] %s", new Object[] { paramString });
        ad.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      ad.closeQuietly(localObject2);
      AppMethodBeat.o(250358);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(250358);
    return i;
  }
  
  public static int aoZ(String paramString)
  {
    AppMethodBeat.i(250362);
    String str = cyt();
    if (u.agG(str)) {
      u.deleteDir(str);
    }
    u.bBD(str);
    int i = u.gj(paramString, str);
    if (i < 0)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + str);
      AppMethodBeat.o(250362);
      return -1;
    }
    Log.i("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip success, path: %s", new Object[] { str });
    AppMethodBeat.o(250362);
    return 0;
  }
  
  private static int apa(String paramString)
  {
    AppMethodBeat.i(250373);
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = i * 131 + k)
    {
      k = (short)paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(250373);
    return 0x7FFFFFFF & i;
  }
  
  public static void bn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250350);
    int i;
    int j;
    for (;;)
    {
      Object localObject;
      try
      {
        paramArrayOfByte = (dtq)new dtq().parseFrom(paramArrayOfByte);
        snG = paramArrayOfByte.version;
        localObject = paramArrayOfByte.TZR;
        i = ((fmm)localObject).version;
        snK.clear();
        snK.addAll(((fmm)localObject).ULh);
        paramArrayOfByte = paramArrayOfByte.TZQ;
        j = paramArrayOfByte.version;
        snL.clear();
        if (paramArrayOfByte.ULi.size() > 0)
        {
          snL.addAll(paramArrayOfByte.ULi);
          paramArrayOfByte = snL.iterator();
          if (!paramArrayOfByte.hasNext()) {
            break;
          }
          localObject = (fml)paramArrayOfByte.next();
          Log.i("MicroMsg.HotWordSearchUtil", "[white word]: %s %s", new Object[] { ((fml)localObject).szv, Integer.valueOf(((fml)localObject).weight) });
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.ULh.iterator();
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", paramArrayOfByte, "[resolveRealTimeWordBankFile]", new Object[0]);
        AppMethodBeat.o(250350);
        return;
      }
      while (paramArrayOfByte.hasNext())
      {
        localObject = (String)paramArrayOfByte.next();
        fml localfml = new fml();
        localfml.szv = ((String)localObject);
        localfml.weight = 255;
        snL.add(localfml);
      }
    }
    paramArrayOfByte = snK.iterator();
    while (paramArrayOfByte.hasNext()) {
      Log.i("MicroMsg.HotWordSearchUtil", "[black word]: %s", new Object[] { (String)paramArrayOfByte.next() });
    }
    Log.i("MicroMsg.HotWordSearchUtil", "realTimeWordsVersion: %s, blackVer: %s whiteVer: %s minMatchLen: %s, maxMatchLen: %s, disable: %s, blackList.size: %s, whiteList.size: %s", new Object[] { Integer.valueOf(snG), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(snH), Integer.valueOf(snI), Integer.valueOf(snJ), Integer.valueOf(snK.size()), Integer.valueOf(snL.size()) });
    AppMethodBeat.o(250350);
  }
  
  private static int bo(byte[] paramArrayOfByte)
  {
    int i = snO;
    snO = i + 1;
    i = paramArrayOfByte[i];
    int j = snO;
    snO = j + 1;
    j = paramArrayOfByte[j];
    int k = snO;
    snO = k + 1;
    k = paramArrayOfByte[k];
    int m = snO;
    snO = m + 1;
    return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF);
  }
  
  public static int cyr()
  {
    AppMethodBeat.i(250359);
    localObject1 = cyt();
    if (!u.agG((String)localObject1 + "/config.conf"))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[getCurrentWordBankVersion] config.conf NOT exist, path: %s", new Object[] { (String)localObject1 + "/config.conf" });
      AppMethodBeat.o(250359);
      return 1;
    }
    Object localObject4 = new q((String)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = u.al((q)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      ad.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getCurrentWordBankVersion]", new Object[0]);
        ad.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      ad.closeQuietly(localObject3);
      AppMethodBeat.o(250359);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(250359);
    return i;
  }
  
  public static String cys()
  {
    AppMethodBeat.i(250366);
    String str = new q(new q(cyt()), "blackWhite").bOF();
    AppMethodBeat.o(250366);
    return str;
  }
  
  private static String cyt()
  {
    AppMethodBeat.i(250367);
    String str = ai.anf(2).gRd() + "/wordBankDir";
    AppMethodBeat.o(250367);
    return str;
  }
  
  public static int getSearchDuration()
  {
    AppMethodBeat.i(250370);
    int i = Math.max(snN, 1);
    AppMethodBeat.o(250370);
    return i;
  }
  
  public static String getWordBankVersionForStat()
  {
    AppMethodBeat.i(250360);
    String str = cyr() + "_" + snG;
    AppMethodBeat.o(250360);
    return str;
  }
  
  public static int ls(boolean paramBoolean)
  {
    AppMethodBeat.i(250348);
    String str = lt(true);
    if (!u.agG(str))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] rawFile NOT exists, path = %s", new Object[] { str });
      AppMethodBeat.o(250348);
      return -1;
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = cys();
      if (u.agG((String)localObject3))
      {
        localObject3 = u.aY((String)localObject3, 0, -1);
        if (localObject3.length <= 0) {
          break label125;
        }
        bn((byte[])localObject3);
      }
    }
    int k;
    for (;;)
    {
      l = cm.bfE();
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
      localObject4 = new String(u.aY(str, 0, -1)).split("\n");
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
        break label905;
      }
      j = i;
      localObject5 = localObject4[n].split(" ");
      j = i;
      if (localObject5.length <= 1) {
        break label893;
      }
      str = localObject5[0];
      j = i;
      k = Util.getInt(localObject5[1], 0);
      j = i;
      m = i;
      if (Util.isNullOrNil(str)) {
        break label881;
      }
      j = i;
      if (snK.contains(str))
      {
        m = i - 1;
      }
      else
      {
        j = i;
        if (str.length() < 2) {
          break label915;
        }
        j = i;
        if (str.contains(",")) {
          break label915;
        }
        j = i;
        m = str.substring(0, 2).hashCode();
        j = i;
        int i2 = apa(str);
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
        localObject1 = snL.iterator();
      }
      try
      {
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (fml)((Iterator)localObject1).next();
          if ((((fml)localObject4).szv.length() >= 2) && (!((fml)localObject4).szv.contains(",")))
          {
            j = ((fml)localObject4).szv.substring(0, 2).hashCode();
            k = apa(((fml)localObject4).szv);
            s = (short)((fml)localObject4).szv.length();
            localObject3[(j % 20003)].add(new a(s, k, ((fml)localObject4).weight));
            i += 1;
          }
        }
      }
      catch (Exception localException3)
      {
        j = i;
      }
    }
    long l = cm.bfE() - l;
    ar.q(i, l, 1L);
    Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] Create model use %s ms, word cnt: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    l = cm.bfE();
    for (;;)
    {
      try
      {
        localObject4 = lt(false);
        if (u.agG((String)localObject4)) {
          u.deleteFile((String)localObject4);
        }
        u.bBV((String)localObject4);
        localObject1 = ByteBuffer.allocate(80012 + i * 7 + 50);
        ((ByteBuffer)localObject1).order(ByteOrder.BIG_ENDIAN);
        ((ByteBuffer)localObject1).clear();
        ((ByteBuffer)localObject1).putInt(snG);
        ((ByteBuffer)localObject1).putInt(snH);
        ((ByteBuffer)localObject1).putInt(snI);
        ((ByteBuffer)localObject1).putInt(snJ);
        ((ByteBuffer)localObject1).putInt(20003);
        i = 0;
        if (i < 20003)
        {
          k = localObject3[i].size();
          ((ByteBuffer)localObject1).putInt(k);
          j = 0;
          if (j >= k) {
            break label923;
          }
          localObject5 = (a)localObject3[i].get(j);
          ((ByteBuffer)localObject1).putShort(((a)localObject5).snP);
          ((ByteBuffer)localObject1).putInt(((a)localObject5).snQ);
          ((ByteBuffer)localObject1).put((byte)(((a)localObject5).weight & 0xFF));
          j += 1;
          continue;
        }
        ((ByteBuffer)localObject1).flip();
        localObject3 = u.bBP((String)localObject4);
        ((WritableByteChannel)localObject3).write((ByteBuffer)localObject1);
        ((WritableByteChannel)localObject3).close();
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException2, "[createModelFromTXTFileAndSave save]", new Object[0]);
        continue;
      }
      Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromTXTFileAndSave] Write model to disk use %s ms", new Object[] { Long.valueOf(cm.bfE() - l) });
      AppMethodBeat.o(250348);
      return 0;
      break label376;
      for (;;)
      {
        label881:
        n += 1;
        i = m;
        break;
        label893:
        Object localObject2 = localObject5[0];
        k = 0;
        break label248;
        label905:
        localObject2 = localObject4[n];
        break label248;
        label915:
        m = i - 1;
      }
      label923:
      i += 1;
    }
  }
  
  public static String lt(boolean paramBoolean)
  {
    AppMethodBeat.i(250363);
    q localq = new q(cyt());
    if (paramBoolean) {}
    for (String str = "fs_kw_main.txt";; str = "wordBank_Weight_1")
    {
      str = new q(localq, str).bOF();
      AppMethodBeat.o(250363);
      return str;
    }
  }
  
  static final class a
  {
    short snP;
    int snQ;
    int weight;
    
    a(short paramShort, int paramInt1, int paramInt2)
    {
      this.snP = paramShort;
      this.snQ = paramInt1;
      this.weight = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c
 * JD-Core Version:    0.7.0.1
 */