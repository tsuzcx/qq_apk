package com.tencent.mm.plugin.box;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.Closeable;
import java.io.FileNotFoundException;
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
  private static int oaA;
  private static int oaB;
  private static int oaC;
  private static int oaD;
  private static HashSet<String> oaE;
  private static HashSet<String> oaF;
  public static final Runnable oaG;
  private static int oaH;
  private static int oaI;
  private static AtomicBoolean oav;
  private static AtomicBoolean oaw;
  private static short[][] oax;
  private static int[][] oay;
  private static final HashMap<Integer, LinkedList<Integer>> oaz;
  
  static
  {
    AppMethodBeat.i(208292);
    oav = new AtomicBoolean(false);
    oaw = new AtomicBoolean(false);
    oaz = new HashMap();
    oaA = 0;
    oaB = 2;
    oaC = 400;
    oaD = 0;
    oaE = new HashSet();
    oaF = new HashSet();
    oaG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208277);
        try
        {
          String str = c.jj(false);
          int i = 0;
          if (i < 3)
          {
            int j = c.Xs(str);
            if (j == 0)
            {
              AppMethodBeat.o(208277);
              return;
            }
            switch (j)
            {
            }
            do
            {
              i += 1;
              break;
              ae.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file empty");
              o.deleteFile(str);
              ae.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, reCreate Model");
            } while (-1 != c.ji(true));
            ae.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, and raw file not exist");
            AppMethodBeat.o(208277);
            return;
          }
          AppMethodBeat.o(208277);
          return;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[loadTask]", new Object[0]);
          AppMethodBeat.o(208277);
        }
      }
    };
    oaH = 1;
    oaI = 0;
    AppMethodBeat.o(208292);
  }
  
  public static int Xs(String paramString)
  {
    AppMethodBeat.i(208280);
    if ((!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) || (!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()))
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] finger search not open");
      AppMethodBeat.o(208280);
      return 0;
    }
    if (!o.fB(paramString))
    {
      ae.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file do NOT exist, path: %s", new Object[] { paramString });
      AppMethodBeat.o(208280);
      return -2;
    }
    oaw.set(true);
    oav.set(false);
    long l = ch.aDc();
    paramString = o.bb(paramString, 0, -1);
    oaI = 0;
    if (paramString.length < 24)
    {
      ae.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] bytes.length(%s) < 24", new Object[] { Integer.valueOf(paramString.length) });
      if (paramString.length == 0)
      {
        AppMethodBeat.o(208280);
        return -4;
      }
      AppMethodBeat.o(208280);
      return -3;
    }
    oaA = aK(paramString);
    oaB = aK(paramString);
    oaC = aK(paramString);
    oaD = aK(paramString);
    int i1 = aK(paramString);
    if (i1 != 20003)
    {
      ae.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file broken, wordGroupC: %s, reCreate model", new Object[] { Integer.valueOf(i1) });
      AppMethodBeat.o(208280);
      return -3;
    }
    int i2 = (paramString.length - 20 - i1 * 4) / 6;
    ae.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordCntAvailable = %s", new Object[] { Integer.valueOf(i2) });
    oax = new short[i1][];
    oay = new int[i1][];
    int j = 0;
    int n;
    for (int i = 0; j < i1; i = n)
    {
      int i3 = aK(paramString);
      n = i + i3;
      if (n > i2)
      {
        ae.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] currCnt(%s) > wordCntAvailable%(%s)", new Object[] { Integer.valueOf(n), Integer.valueOf(i2) });
        AppMethodBeat.o(208280);
        return -3;
      }
      oax[j] = new short[i3];
      oay[j] = new int[i3];
      i = 0;
      Object localObject;
      int k;
      int m;
      while (i < i3)
      {
        localObject = oax[j];
        k = oaI;
        oaI = k + 1;
        k = paramString[k];
        m = oaI;
        oaI = m + 1;
        localObject[i] = ((short)((k << 8 & 0xFF) + (paramString[m] & 0xFF)));
        oay[j][i] = aK(paramString);
        i += 1;
      }
      if (i3 > 200)
      {
        localObject = new LinkedList();
        m = oax[j][0];
        i = 1;
        k = 1;
        if (k < i3)
        {
          if (oax[j][k] != m)
          {
            ((LinkedList)localObject).addLast(Integer.valueOf(i));
            i = 1;
            m = oax[j][k];
          }
          for (;;)
          {
            k += 1;
            break;
            i += 1;
          }
        }
        ((LinkedList)localObject).addLast(Integer.valueOf(i));
        oaz.put(Integer.valueOf(j), localObject);
      }
      j += 1;
    }
    oav.set(true);
    oaw.set(false);
    l = Math.ceil(ch.aDc() - l);
    am.o(i, l, 2L);
    ae.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] load model from disk use %s ms, total cnt = %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    AppMethodBeat.o(208280);
    return 0;
  }
  
  public static boolean Xt(String paramString)
  {
    AppMethodBeat.i(208281);
    if (oaw.get())
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank is loading, Give UP searching");
      AppMethodBeat.o(208281);
      return false;
    }
    if ((!oav.get()) || (oax == null) || (oay == null))
    {
      ae.w("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank has NOT init");
      AppMethodBeat.o(208281);
      return false;
    }
    if ((paramString.length() < oaB) || (paramString.length() > oaC))
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[hashSearch] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(oaB), Integer.valueOf(oaC) });
      AppMethodBeat.o(208281);
      return false;
    }
    long l = ch.aDc();
    int n = paramString.length();
    int j = 0;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = oax.length;
      short[] arrayOfShort = oax[(i % m)];
      int[] arrayOfInt = oay[(i % m)];
      int k = arrayOfShort.length;
      if (k > 200)
      {
        Object localObject = (LinkedList)oaz.get(Integer.valueOf(i % m));
        if (localObject == null)
        {
          ae.e("MicroMsg.HotWordSearchUtil", "[hashSearch] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(208281);
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
          int i2 = Xx(paramString.substring(j, arrayOfShort[i] + j));
          m = i + i1 - 1;
          k = i;
          while (k <= m)
          {
            int i3 = (k + m) / 2;
            if (i2 == arrayOfInt[i3])
            {
              paramString = paramString.substring(j, arrayOfShort[i] + j);
              oaH = Math.max((int)Math.ceil(ch.aDc() - l), 1);
              ae.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString, Integer.valueOf(oaH) });
              AppMethodBeat.o(208281);
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
        if (Xx(paramString.substring(j, arrayOfShort[i] + j)) == arrayOfInt[i])
        {
          oaH = Math.max((int)Math.ceil(ch.aDc() - l), 1);
          ae.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", new Object[] { paramString.substring(j, arrayOfShort[i] + j), Integer.valueOf(oaH) });
          AppMethodBeat.o(208281);
          return true;
        }
        i += 1;
      }
      j += 1;
    }
    oaH = Math.max((int)Math.ceil(ch.aDc() - l), 1);
    ae.i("MicroMsg.HotWordSearchUtil", "[hashSearch] NO hot word found");
    AppMethodBeat.o(208281);
    return false;
  }
  
  public static String Xu(String paramString)
  {
    AppMethodBeat.i(208282);
    if (oaw.get())
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
      AppMethodBeat.o(208282);
      return "";
    }
    if ((!oav.get()) || (oax == null) || (oay == null))
    {
      ae.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
      AppMethodBeat.o(208282);
      return "";
    }
    if ((paramString.length() < oaB) || (paramString.length() > oaC))
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(oaB), Integer.valueOf(oaC) });
      AppMethodBeat.o(208282);
      return "";
    }
    Object localObject1 = new HashSet();
    int n = paramString.length();
    int j = 0;
    Object localObject2;
    while (j < paramString.length() - 1)
    {
      int i = paramString.substring(j, j + 2).hashCode();
      int m = oax.length;
      localObject2 = oax[(i % m)];
      int[] arrayOfInt = oay[(i % m)];
      int k = localObject2.length;
      if (k > 200)
      {
        Object localObject3 = (LinkedList)oaz.get(Integer.valueOf(i % m));
        if (localObject3 == null)
        {
          ae.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", new Object[] { Integer.valueOf(i % m) });
          AppMethodBeat.o(208282);
          return null;
        }
        i = 0;
        localObject3 = ((LinkedList)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          int i1 = ((Integer)((Iterator)localObject3).next()).intValue();
          if (localObject2[i] + j <= n)
          {
            int i2 = Xx(paramString.substring(j, localObject2[i] + j));
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
          if (Xx(paramString.substring(j, localObject2[i] + j)) == arrayOfInt[i]) {
            ((HashSet)localObject1).add(paramString.substring(j, localObject2[i] + j));
          }
          i += 1;
        }
      }
      j += 1;
    }
    if (((HashSet)localObject1).size() == 0)
    {
      AppMethodBeat.o(208282);
      return "";
    }
    paramString = new StringBuilder();
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ae.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] found hot word: %s", new Object[] { localObject2 });
      paramString.append((String)localObject2).append('|');
    }
    paramString = paramString.substring(0, paramString.length() - 1);
    AppMethodBeat.o(208282);
    return paramString;
  }
  
  public static int Xv(String paramString)
  {
    AppMethodBeat.i(208283);
    localObject1 = new k(ak.getContext().getCacheDir(), "wordBank/temp");
    if (((k)localObject1).exists()) {
      o.dd(w.B(((k)localObject1).fTh()), true);
    }
    ((k)localObject1).mkdirs();
    int i = o.fD(paramString, w.B(((k)localObject1).fTh()));
    if (i < 0)
    {
      ae.e("MicroMsg.HotWordSearchUtil", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + w.B(((k)localObject1).fTh()));
      AppMethodBeat.o(208283);
      return -1;
    }
    Object localObject3 = new k((k)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = o.ai((k)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localProperties.load((InputStream)localObject3);
      w.closeQuietly((Closeable)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        ae.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getWordBankVersionFromZip] %s", new Object[] { paramString });
        w.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      w.closeQuietly(localObject2);
      AppMethodBeat.o(208283);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(208283);
    return i;
  }
  
  public static int Xw(String paramString)
  {
    AppMethodBeat.i(208286);
    String str = bNX();
    if (o.fB(str)) {
      o.dd(str, true);
    }
    o.aZI(str);
    int i = o.fD(paramString, str);
    if (i < 0)
    {
      ae.e("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + str);
      AppMethodBeat.o(208286);
      return -1;
    }
    ae.i("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip success, path: %s", new Object[] { str });
    AppMethodBeat.o(208286);
    return 0;
  }
  
  private static int Xx(String paramString)
  {
    AppMethodBeat.i(208291);
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = i * 131 + k)
    {
      k = (short)paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(208291);
    return 0x7FFFFFFF & i;
  }
  
  public static void aJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(208279);
    try
    {
      paramArrayOfByte = (csb)new csb().parseFrom(paramArrayOfByte);
      oaA = paramArrayOfByte.version;
      ehc localehc = paramArrayOfByte.HDh;
      oaE.clear();
      oaE.addAll(localehc.IkP);
      paramArrayOfByte = paramArrayOfByte.HDg;
      oaF.clear();
      oaF.addAll(paramArrayOfByte.IkP);
      paramArrayOfByte = oaF.iterator();
      while (paramArrayOfByte.hasNext()) {
        ae.i("MicroMsg.HotWordSearchUtil", "[white word]: %s", new Object[] { (String)paramArrayOfByte.next() });
      }
      paramArrayOfByte = oaE.iterator();
    }
    catch (Exception paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.HotWordSearchUtil", paramArrayOfByte, "[resolveRealTimeWordBankFile]", new Object[0]);
      AppMethodBeat.o(208279);
      return;
    }
    while (paramArrayOfByte.hasNext()) {
      ae.i("MicroMsg.HotWordSearchUtil", "[black word]: %s", new Object[] { (String)paramArrayOfByte.next() });
    }
    ae.i("MicroMsg.HotWordSearchUtil", "realTimeWordsVersion: %s, minMatchLen: %s, maxMatchLen: %s, disable: %s, blackList.size: %s, whiteList.size: %s", new Object[] { Integer.valueOf(oaA), Integer.valueOf(oaB), Integer.valueOf(oaC), Integer.valueOf(oaD), Integer.valueOf(oaE.size()), Integer.valueOf(oaF.size()) });
    AppMethodBeat.o(208279);
  }
  
  private static int aK(byte[] paramArrayOfByte)
  {
    int i = oaI;
    oaI = i + 1;
    i = paramArrayOfByte[i];
    int j = oaI;
    oaI = j + 1;
    j = paramArrayOfByte[j];
    int k = oaI;
    oaI = k + 1;
    k = paramArrayOfByte[k];
    int m = oaI;
    oaI = m + 1;
    return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF);
  }
  
  public static int bNV()
  {
    AppMethodBeat.i(208284);
    localObject1 = bNX();
    if (!o.fB((String)localObject1 + "/config.conf"))
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[getCurrentWordBankVersion] config.conf NOT exist, path: %s", new Object[] { (String)localObject1 + "/config.conf" });
      AppMethodBeat.o(208284);
      return 1;
    }
    Object localObject4 = new k((String)localObject1, "config.conf");
    Properties localProperties = new Properties();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = o.ai((k)localObject4);
      localObject1 = localObject4;
      localObject3 = localObject4;
      localProperties.load((InputStream)localObject4);
      w.closeQuietly((Closeable)localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        localObject3 = localObject1;
        ae.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[getCurrentWordBankVersion]", new Object[0]);
        w.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      w.closeQuietly(localObject3);
      AppMethodBeat.o(208284);
    }
    i = Integer.parseInt(localProperties.getProperty("version", "1").trim());
    AppMethodBeat.o(208284);
    return i;
  }
  
  public static String bNW()
  {
    AppMethodBeat.i(208288);
    String str = w.B(new k(new k(bNX()), "blackWhite").fTh());
    AppMethodBeat.o(208288);
    return str;
  }
  
  private static String bNX()
  {
    AppMethodBeat.i(208289);
    String str = ad.WJ(2).eQf() + "/wordBankDir";
    AppMethodBeat.o(208289);
    return str;
  }
  
  public static int getSearchDuration()
  {
    AppMethodBeat.i(208290);
    int i = Math.max(oaH, 1);
    AppMethodBeat.o(208290);
    return i;
  }
  
  public static String getWordBankVersionForStat()
  {
    AppMethodBeat.i(208285);
    String str = bNV() + "_" + oaA;
    AppMethodBeat.o(208285);
    return str;
  }
  
  public static int ji(boolean paramBoolean)
  {
    AppMethodBeat.i(208278);
    if ((!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) || (!((com.tencent.mm.plugin.websearch.api.c)g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()))
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] finger search not open");
      AppMethodBeat.o(208278);
      return 0;
    }
    Object localObject1 = jj(true);
    if (!o.fB((String)localObject1))
    {
      ae.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] rawFile NOT exists, path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(208278);
      return -1;
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = bNW();
      if (o.fB((String)localObject3))
      {
        localObject3 = o.bb((String)localObject3, 0, -1);
        if (localObject3.length <= 0) {
          break label170;
        }
        aJ((byte[])localObject3);
      }
    }
    for (;;)
    {
      l = ch.aDc();
      localObject3 = new LinkedList[20003];
      i = 0;
      while (i < 20003)
      {
        localObject3[i] = new LinkedList();
        i += 1;
      }
      label170:
      ae.e("MicroMsg.HotWordSearchUtil", "[resolveRealTimeWordBank] Length of real time word bank file = 0");
    }
    for (;;)
    {
      try
      {
        localObject1 = new String(o.bb((String)localObject1, 0, -1)).split("\n");
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
        if (bu.isNullOrNil(str)) {
          continue;
        }
        if (oaE.contains(str))
        {
          j = i - 1;
        }
        else
        {
          if ((str.length() < 2) || (str.contains(","))) {
            continue;
          }
          j = str.substring(0, 2).hashCode();
          int m = Xx(str);
          s = (short)str.length();
          localObject3[(j % 20003)].add(new a(s, m));
          j = i;
        }
      }
      catch (Exception localException1) {}
    }
    ae.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException1, "[createModelFromRawFileAndSave]", new Object[0]);
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
          if (oaF != null) {
            localObject2 = oaF.iterator();
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
            k = Xx(str);
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
    long l = ch.aDc() - l;
    am.o(i, l, 1L);
    ae.i("MicroMsg.HotWordSearchUtil", "[createModelFromRawFileAndSave] Create model use %s ms, word cnt: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
    l = ch.aDc();
    for (;;)
    {
      try
      {
        str = jj(false);
        if (o.fB(str)) {
          o.deleteFile(str);
        }
        o.aZV(str);
        localObject2 = ByteBuffer.allocate(80012 + i * 6 + 50);
        ((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN);
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).putInt(oaA);
        ((ByteBuffer)localObject2).putInt(oaB);
        ((ByteBuffer)localObject2).putInt(oaC);
        ((ByteBuffer)localObject2).putInt(oaD);
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
          ((ByteBuffer)localObject2).putShort(((a)localObject3[i].get(j)).oaJ);
          ((ByteBuffer)localObject2).putInt(((a)localObject3[i].get(j)).oaK);
          j += 1;
          continue;
        }
        ((ByteBuffer)localObject2).flip();
        if ((str == null) || (str.isEmpty()))
        {
          localObject2 = new FileNotFoundException("path is empty");
          AppMethodBeat.o(208278);
          throw ((Throwable)localObject2);
        }
      }
      catch (Exception localException2)
      {
        ae.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException2, "[createModelFromTXTFileAndSave save]", new Object[0]);
        ae.i("MicroMsg.HotWordSearchUtil", "[createModelFromTXTFileAndSave] Write model to disk use %s ms", new Object[] { Long.valueOf(ch.aDc() - l) });
        AppMethodBeat.o(208278);
        return 0;
      }
      localObject3 = o.d(w.parseUri(str), null);
      ((WritableByteChannel)localObject3).write(localException2);
      ((WritableByteChannel)localObject3).close();
    }
  }
  
  public static String jj(boolean paramBoolean)
  {
    AppMethodBeat.i(208287);
    k localk = new k(bNX());
    if (paramBoolean) {}
    for (String str = "fs_kw_main.txt";; str = "wordBank")
    {
      str = w.B(new k(localk, str).fTh());
      AppMethodBeat.o(208287);
      return str;
    }
  }
  
  static final class a
  {
    short oaJ;
    int oaK;
    
    a(short paramShort, int paramInt)
    {
      this.oaJ = paramShort;
      this.oaK = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c
 * JD-Core Version:    0.7.0.1
 */