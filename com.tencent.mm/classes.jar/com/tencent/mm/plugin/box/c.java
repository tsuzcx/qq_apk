package com.tencent.mm.plugin.box;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private static HashSet<String> plA;
  private static HashSet<String> plB;
  public static final Runnable plC;
  private static int plD;
  private static int plE;
  private static AtomicBoolean plr;
  private static AtomicBoolean pls;
  private static short[][] plt;
  private static int[][] plu;
  private static final HashMap<Integer, LinkedList<Integer>> plv;
  private static int plw;
  private static int plx;
  private static int ply;
  private static int plz;
  
  static
  {
    AppMethodBeat.i(196200);
    plr = new AtomicBoolean(false);
    pls = new AtomicBoolean(false);
    plv = new HashMap();
    plw = 0;
    plx = 2;
    ply = 400;
    plz = 0;
    plA = new HashSet();
    plB = new HashSet();
    plC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196184);
        try
        {
          String str = c.ki(false);
          int i = 0;
          if (i < 3)
          {
            int j = c.aho(str);
            if (j == 0)
            {
              AppMethodBeat.o(196184);
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
              s.deleteFile(str);
              Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, reCreate Model");
            } while (-1 != c.kh(true));
            Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, and raw file not exist");
            AppMethodBeat.o(196184);
            return;
          }
          AppMethodBeat.o(196184);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[loadTask]", new Object[0]);
          AppMethodBeat.o(196184);
        }
      }
    };
    plD = 1;
    plE = 0;
    AppMethodBeat.o(196200);
  }
  
  public static int aho(String paramString)
  {
    AppMethodBeat.i(196187);
    if ((!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) || (!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] finger search not open");
      AppMethodBeat.o(196187);
      return 0;
    }
    if (!s.YS(paramString))
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file do NOT exist, path: %s", new Object[] { paramString });
      AppMethodBeat.o(196187);
      return -2;
    }
    pls.set(true);
    plr.set(false);
    long l = cl.aWA();
    paramString = s.aW(paramString, 0, -1);
    plE = 0;
    if (paramString.length < 24)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] bytes.length(%s) < 24", new Object[] { Integer.valueOf(paramString.length) });
      if (paramString.length == 0)
      {
        AppMethodBeat.o(196187);
        return -4;
      }
      AppMethodBeat.o(196187);
      return -3;
    }
    plw = bb(paramString);
    plx = bb(paramString);
    ply = bb(paramString);
    plz = bb(paramString);
    int i1 = bb(paramString);
    if (i1 != 20003)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file broken, wordGroupC: %s, reCreate model", new Object[] { Integer.valueOf(i1) });
      AppMethodBeat.o(196187);
      return -3;
    }
    int i2 = (paramString.length - 20 - i1 * 4) / 6;
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordCntAvailable = %s", new Object[] { Integer.valueOf(i2) });
    plt = new short[i1][];
    plu = new int[i1][];
    int j = 0;
    int n;
    for (int i = 0; j < i1; i = n)
    {
      int i3 = bb(paramString);
      n = i + i3;
      if (n > i2)
      {
        Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] currCnt(%s) > wordCntAvailable%(%s)", new Object[] { Integer.valueOf(n), Integer.valueOf(i2) });
        AppMethodBeat.o(196187);
        return -3;
      }
      plt[j] = new short[i3];
      plu[j] = new int[i3];
      i = 0;
      Object localObject;
      int k;
      int m;
      while (i < i3)
      {
        localObject = plt[j];
        k = plE;
        plE = k + 1;
        k = paramString[k];
        m = plE;
        plE = m + 1;
        localObject[i] = ((short)((k << 8 & 0xFF) + (paramString[m] & 0xFF)));
        plu[j][i] = bb(paramString);
        i += 1;
      }
      if (i3 > 200)
      {
        localObject = new LinkedList();
        m = plt[j][0];
        i = 1;
        k = 1;
        if (k < i3)
        {
          if (plt[j][k] != m)
          {
            ((LinkedList)localObject).addLast(Integer.valueOf(i));
            i = 1;
            m = plt[j][k];
          }
          for (;;)
          {
            k += 1;
            break;
            i += 1;
          }
        }
        ((LinkedList)localObject).addLast(Integer.valueOf(i));
        plv.put(Integer.valueOf(j), localObject);
      }
      j += 1;
    }
    plr.set(true);
    pls.set(false);
    l = Math.ceil(cl.aWA() - l);
    ar.o(i, l, 2L);
    Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] load model from disk use %s ms, total cnt = %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    AppMethodBeat.o(196187);
    return 0;
  }
  
  public static boolean ahp(String paramString)
  {
    AppMethodBeat.i(196188);
    if (pls.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank is loading, Give UP searching");
      AppMethodBeat.o(196188);
      return false;
    }
    if ((!plr.get()) || (plt == null) || (plu == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank has NOT init");
      AppMethodBeat.o(196188);
      return false;
    }
    if ((paramString.length() < plx) || (paramString.length() > ply))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(plx), Integer.valueOf(ply) });
      AppMethodBeat.o(196188);
      return false;
    }
    long l = cl.aWA();
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = plt.length;
      short[] arrayOfShort = plt[(i % m)];
      int[] arrayOfInt = plu[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)plv.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearch] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(196188);
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
          int i2 = ahu(paramString.substring(j, arrayOfShort[i] + j));
          m = i + i1 - 1;
          k = i;
          while (k <= m)
          {
            int i3 = (k + m) / 2;
            if (i2 == arrayOfInt[i3])
            {
              paramString = paramString.substring(j, arrayOfShort[i] + j);
              plD = Math.max((int)Math.ceil(cl.aWA() - l), 1);
              Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString, Integer.valueOf(plD) });
              AppMethodBeat.o(196188);
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
        if (ahu(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i])
        {
          plD = Math.max((int)Math.ceil(cl.aWA() - l), 1);
          Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString.substring(j, arrayOfShort[i] + j), Integer.valueOf(plD) });
          AppMethodBeat.o(196188);
          return true;
        }
        i += 1;
      }
      j += 1;
    }
    plD = Math.max((int)Math.ceil(cl.aWA() - l), 1);
    Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] NO hot word found");
    AppMethodBeat.o(196188);
    return false;
  }
  
  public static String ahq(String paramString)
  {
    AppMethodBeat.i(196189);
    if (pls.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
      AppMethodBeat.o(196189);
      return "";
    }
    if ((!plr.get()) || (plt == null) || (plu == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
      AppMethodBeat.o(196189);
      return "";
    }
    if ((paramString.length() < plx) || (paramString.length() > ply))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(plx), Integer.valueOf(ply) });
      AppMethodBeat.o(196189);
      return "";
    }
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = plt.length;
      short[] arrayOfShort = plt[(i % m)];
      int[] arrayOfInt = plu[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)plv.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(196189);
          return "";
        }
        localObject = ((LinkedList)localObject).iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          int i1 = ((Integer)((Iterator)localObject).next()).intValue();
          if (arrayOfShort[i] + j > n) {
            break;
          }
          int i2 = ahu(paramString.substring(j, arrayOfShort[i] + j));
          m = i + i1 - 1;
          k = i;
          while (k <= m)
          {
            int i3 = (k + m) / 2;
            if (i2 == arrayOfInt[i3])
            {
              paramString = paramString.substring(j, arrayOfShort[i] + j);
              AppMethodBeat.o(196189);
              return paramString;
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
        if (ahu(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i])
        {
          paramString = paramString.substring(j, arrayOfShort[i] + j);
          AppMethodBeat.o(196189);
          return paramString;
        }
        i += 1;
      }
      j += 1;
    }
    AppMethodBeat.o(196189);
    return "";
  }
  
  public static HashSet<String> ahr(String paramString)
  {
    AppMethodBeat.i(196190);
    HashSet localHashSet = new HashSet();
    if (pls.get())
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
      AppMethodBeat.o(196190);
      return localHashSet;
    }
    if ((!plr.get()) || (plt == null) || (plu == null))
    {
      Log.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
      AppMethodBeat.o(196190);
      return localHashSet;
    }
    if ((paramString.length() < plx) || (paramString.length() > ply))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(plx), Integer.valueOf(ply) });
      AppMethodBeat.o(196190);
      return localHashSet;
    }
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = plt.length;
      short[] arrayOfShort = plt[(i % m)];
      int[] arrayOfInt = plu[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)plv.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          Log.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(196190);
          return null;
        }
        i = 0;
        localObject = ((LinkedList)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          int i1 = ((Integer)((Iterator)localObject).next()).intValue();
          if (arrayOfShort[i] + j <= n)
          {
            int i2 = ahu(paramString.substring(j, arrayOfShort[i] + j));
            m = i + i1 - 1;
            k = i;
            for (;;)
            {
              int i3;
              if (k <= m)
              {
                i3 = (k + m) / 2;
                if (i2 == arrayOfInt[i3]) {
                  localHashSet.add(paramString.substring(j, arrayOfShort[i] + j));
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
        while ((i < k) && (arrayOfShort[i] + j <= n))
        {
          if (ahu(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i]) {
            localHashSet.add(paramString.substring(j, arrayOfShort[i] + j));
          }
          i += 1;
        }
      }
      j += 1;
    }
    AppMethodBeat.o(196190);
    return localHashSet;
  }
  
  public static int ahs(String paramString)
  {
    AppMethodBeat.i(196191);
    localObject1 = new o(MMApplicationContext.getContext().getCacheDir(), "wordBank/temp");
    if (((o)localObject1).exists()) {
      s.dy(aa.z(((o)localObject1).her()), true);
    }
    ((o)localObject1).mkdirs();
    int i = s.fW(paramString, aa.z(((o)localObject1).her()));
    if (i < 0)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + aa.z(((o)localObject1).her()));
      AppMethodBeat.o(196191);
      return -1;
    }
    Object localObject3 = new o((o)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = s.ao((o)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      aa.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getWordBankVersionFromZip] %s", new Object[] { paramString });
        aa.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      aa.closeQuietly(localObject2);
      AppMethodBeat.o(196191);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(196191);
    return i;
  }
  
  public static int aht(String paramString)
  {
    AppMethodBeat.i(196194);
    String str = ckX();
    if (s.YS(str)) {
      s.dy(str, true);
    }
    s.boN(str);
    int i = s.fW(paramString, str);
    if (i < 0)
    {
      Log.e("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + str);
      AppMethodBeat.o(196194);
      return -1;
    }
    Log.i("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip success, path: %s", new Object[] { str });
    AppMethodBeat.o(196194);
    return 0;
  }
  
  private static int ahu(String paramString)
  {
    AppMethodBeat.i(196199);
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = i * 131 + k)
    {
      k = (short)paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(196199);
    return 0x7FFFFFFF & i;
  }
  
  public static void ba(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196186);
    try
    {
      paramArrayOfByte = (dkb)new dkb().parseFrom(paramArrayOfByte);
      plw = paramArrayOfByte.version;
      fbs localfbs = paramArrayOfByte.MNY;
      plA.clear();
      plA.addAll(localfbs.NxQ);
      paramArrayOfByte = paramArrayOfByte.MNX;
      plB.clear();
      plB.addAll(paramArrayOfByte.NxQ);
      paramArrayOfByte = plB.iterator();
      while (paramArrayOfByte.hasNext()) {
        Log.i("MicroMsg.HotWordSearchUtil", "[white word]: %s", new Object[] { (String)paramArrayOfByte.next() });
      }
      paramArrayOfByte = plA.iterator();
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", paramArrayOfByte, "[resolveRealTimeWordBankFile]", new Object[0]);
      AppMethodBeat.o(196186);
      return;
    }
    while (paramArrayOfByte.hasNext()) {
      Log.i("MicroMsg.HotWordSearchUtil", "[black word]: %s", new Object[] { (String)paramArrayOfByte.next() });
    }
    Log.i("MicroMsg.HotWordSearchUtil", "realTimeWordsVersion: %s, minMatchLen: %s, maxMatchLen: %s, disable: %s, blackList.size: %s, whiteList.size: %s", new Object[] { Integer.valueOf(plw), Integer.valueOf(plx), Integer.valueOf(ply), Integer.valueOf(plz), Integer.valueOf(plA.size()), Integer.valueOf(plB.size()) });
    AppMethodBeat.o(196186);
  }
  
  private static int bb(byte[] paramArrayOfByte)
  {
    int i = plE;
    plE = i + 1;
    i = paramArrayOfByte[i];
    int j = plE;
    plE = j + 1;
    j = paramArrayOfByte[j];
    int k = plE;
    plE = k + 1;
    k = paramArrayOfByte[k];
    int m = plE;
    plE = m + 1;
    return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF);
  }
  
  public static int ckV()
  {
    AppMethodBeat.i(196192);
    localObject1 = ckX();
    if (!s.YS((String)localObject1 + "/config.conf"))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[getCurrentWordBankVersion] config.conf NOT exist, path: %s", new Object[] { (String)localObject1 + "/config.conf" });
      AppMethodBeat.o(196192);
      return 1;
    }
    Object localObject4 = new o((String)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = s.ao((o)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      aa.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getCurrentWordBankVersion]", new Object[0]);
        aa.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      aa.closeQuietly(localObject3);
      AppMethodBeat.o(196192);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(196192);
    return i;
  }
  
  public static String ckW()
  {
    AppMethodBeat.i(196196);
    String str = aa.z(new o(new o(ckX()), "blackWhite").her());
    AppMethodBeat.o(196196);
    return str;
  }
  
  private static String ckX()
  {
    AppMethodBeat.i(196197);
    String str = ai.afr(2).fYs() + "/wordBankDir";
    AppMethodBeat.o(196197);
    return str;
  }
  
  public static int getSearchDuration()
  {
    AppMethodBeat.i(196198);
    int i = Math.max(plD, 1);
    AppMethodBeat.o(196198);
    return i;
  }
  
  public static String getWordBankVersionForStat()
  {
    AppMethodBeat.i(196193);
    String str = ckV() + "_" + plw;
    AppMethodBeat.o(196193);
    return str;
  }
  
  public static int kh(boolean paramBoolean)
  {
    AppMethodBeat.i(196185);
    if ((!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) || (!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] finger search not open");
      AppMethodBeat.o(196185);
      return 0;
    }
    Object localObject1 = ki(true);
    if (!s.YS((String)localObject1))
    {
      Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] rawFile NOT exists, path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(196185);
      return -1;
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = ckW();
      if (s.YS((String)localObject3))
      {
        localObject3 = s.aW((String)localObject3, 0, -1);
        if (localObject3.length <= 0) {
          break label170;
        }
        ba((byte[])localObject3);
      }
    }
    for (;;)
    {
      l = cl.aWA();
      localObject3 = new LinkedList[20003];
      i = 0;
      while (i < 20003)
      {
        localObject3[i] = new LinkedList();
        i += 1;
      }
      label170:
      Log.e("MicroMsg.HotWordSearchUtil", "[resolveRealTimeWordBank] Length of real time word bank file = 0");
    }
    for (;;)
    {
      try
      {
        localObject1 = new String(s.aW((String)localObject1, 0, -1)).split("\n");
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
        if (Util.isNullOrNil(str)) {
          continue;
        }
        if (plA.contains(str))
        {
          j = i - 1;
        }
        else
        {
          if ((str.length() < 2) || (str.contains(","))) {
            continue;
          }
          j = str.substring(0, 2).hashCode();
          int m = ahu(str);
          s = (short)str.length();
          localObject3[(j % 20003)].add(new a(s, m));
          j = i;
        }
      }
      catch (Exception localException1) {}
    }
    Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException1, "[createModelFromRawFileAndSave]", new Object[0]);
    for (;;)
    {
      j = 0;
      Object localObject2;
      for (;;)
      {
        if (j < 20003)
        {
          Collections.sort(localObject3[j], new Comparator() {});
          j += 1;
          continue;
          j = i;
          if (plB != null) {
            localObject2 = plB.iterator();
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
            k = ahu(str);
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
    long l = cl.aWA() - l;
    ar.o(i, l, 1L);
    Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] Create model use %s ms, word cnt: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    l = cl.aWA();
    try
    {
      str = ki(false);
      if (s.YS(str)) {
        s.deleteFile(str);
      }
      s.bpa(str);
      localObject2 = ByteBuffer.allocate(80012 + i * 6 + 50);
      ((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN);
      ((ByteBuffer)localObject2).clear();
      ((ByteBuffer)localObject2).putInt(plw);
      ((ByteBuffer)localObject2).putInt(plx);
      ((ByteBuffer)localObject2).putInt(ply);
      ((ByteBuffer)localObject2).putInt(plz);
      ((ByteBuffer)localObject2).putInt(20003);
      i = 0;
      if (i < 20003)
      {
        k = localObject3[i].size();
        ((ByteBuffer)localObject2).putInt(k);
        j = 0;
        while (j < k)
        {
          ((ByteBuffer)localObject2).putShort(((a)localObject3[i].get(j)).plF);
          ((ByteBuffer)localObject2).putInt(((a)localObject3[i].get(j)).plG);
          j += 1;
        }
      }
      ((ByteBuffer)localObject2).flip();
      localObject3 = s.d(aa.parseUri(str), null);
      ((WritableByteChannel)localObject3).write((ByteBuffer)localObject2);
      ((WritableByteChannel)localObject3).close();
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException2, "[createModelFromTXTFileAndSave save]", new Object[0]);
      }
    }
    Log.i("MicroMsg.HotWordSearchUtil", "[createModelFromTXTFileAndSave] Write model to disk use %s ms", new Object[] { Long.valueOf(cl.aWA() - l) });
    AppMethodBeat.o(196185);
    return 0;
  }
  
  public static String ki(boolean paramBoolean)
  {
    AppMethodBeat.i(196195);
    o localo = new o(ckX());
    if (paramBoolean) {}
    for (String str = "fs_kw_main.txt";; str = "wordBank")
    {
      str = aa.z(new o(localo, str).her());
      AppMethodBeat.o(196195);
      return str;
    }
  }
  
  static final class a
  {
    short plF;
    int plG;
    
    a(short paramShort, int paramInt)
    {
      this.plF = paramShort;
      this.plG = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c
 * JD-Core Version:    0.7.0.1
 */