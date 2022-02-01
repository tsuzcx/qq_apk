package com.tencent.mm.compatible.deviceinfo;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaCodecProxyUtils
{
  private static volatile long lXu;
  private static final Map<Integer, a> lXv;
  private static final Map<Integer, a> lXw;
  private static final Map<Integer, a> lXx;
  private static final Map<Integer, a> lXy;
  private static v lXz;
  
  static
  {
    AppMethodBeat.i(155819);
    lXu = 0L;
    lXv = new ConcurrentHashMap();
    lXw = new ConcurrentHashMap();
    lXx = new ConcurrentHashMap();
    lXy = new ConcurrentHashMap();
    AppMethodBeat.o(155819);
  }
  
  public static a a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(155810);
    a locala = new a();
    locala.mimeType = paramString;
    locala.lXA = paramBoolean;
    Log.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/")) {
      if (paramBoolean) {
        lXx.put(Integer.valueOf(paramInt), locala);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155810);
      return locala;
      lXy.put(Integer.valueOf(paramInt), locala);
      continue;
      if (paramString.contains("audio/"))
      {
        if (paramBoolean) {
          lXv.put(Integer.valueOf(paramInt), locala);
        } else {
          lXw.put(Integer.valueOf(paramInt), locala);
        }
      }
      else
      {
        b.qY(20);
        b.a(20, locala);
      }
    }
  }
  
  public static void a(v paramv)
  {
    lXz = paramv;
  }
  
  public static void a(boolean paramBoolean, String paramString, a parama)
  {
    AppMethodBeat.i(155817);
    Log.i("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        b.qY(6);
        b.a(6, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.qY(5);
      b.a(5, parama);
      AppMethodBeat.o(155817);
      return;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        b.qY(4);
        b.a(4, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.qY(3);
      b.a(3, parama);
    }
    AppMethodBeat.o(155817);
  }
  
  public static boolean a(String paramString, a parama)
  {
    AppMethodBeat.i(155815);
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
      int j = 0;
      while (j < arrayOfString.length)
      {
        if (TextUtils.equals(arrayOfString[j], paramString))
        {
          parama.lXB = localMediaCodecInfo.getName();
          AppMethodBeat.o(155815);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.qY(23);
    b.a(23, parama);
    AppMethodBeat.o(155815);
    return false;
  }
  
  public static void aPF()
  {
    AppMethodBeat.i(155813);
    Log.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", new Object[] { Integer.valueOf(lXv.size() + lXw.size() + lXx.size() + lXy.size()), Integer.valueOf(lXv.size()), Integer.valueOf(lXw.size()), Integer.valueOf(lXx.size()), Integer.valueOf(lXy.size()) });
    b(lXw, 12);
    b(lXv, 13);
    b(lXy, 14);
    b(lXx, 15);
    AppMethodBeat.o(155813);
  }
  
  private static boolean aPG()
  {
    AppMethodBeat.i(175887);
    boolean bool = MMApplicationContext.getProcessName().contains(":appbrand");
    AppMethodBeat.o(175887);
    return bool;
  }
  
  private static void b(Map<Integer, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(155814);
    if (paramMap.size() >= 8)
    {
      Log.i("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramMap.size()), MMApplicationContext.getProcessName() });
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (lXu + 30000L >= System.currentTimeMillis())
      {
        if (lXu == 0L) {
          Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
        }
      }
      else
      {
        lXu = System.currentTimeMillis();
        Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", new Object[] { Long.valueOf(lXu) });
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        Object localObject = paramMap.keySet();
        long l1 = System.currentTimeMillis();
        Iterator localIterator = ((Set)localObject).iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)paramMap.get((Integer)localIterator.next());
          if (locala != null)
          {
            localObject = "";
            if (locala.lXC != null) {
              localObject = locala.lXC.replace(",", ";");
            }
            localStringBuilder1.append(locala.lXA).append(";").append(locala.mimeType).append(";").append(locala.lXB).append(";").append(MMApplicationContext.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            long l2 = l1 - locala.createTime;
            if (l2 > 600000L)
            {
              Log.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", new Object[] { Long.valueOf(l2) });
              localStringBuilder2.append(l2).append(";").append(locala.lXA).append(";").append(locala.mimeType).append(";").append(locala.lXB).append(";").append(MMApplicationContext.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            }
          }
        }
      }
      Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - lXu) });
      AppMethodBeat.o(155814);
      return;
      if (paramInt == 12)
      {
        b.qY(12);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.qY(192);
          if (MMApplicationContext.isMainProcess()) {
            b.x(192, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.qY(180);
          b.x(180, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aPG())
        {
          b.qY(184);
          AppMethodBeat.o(155814);
          return;
        }
        b.qY(188);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 13)
      {
        b.qY(13);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.qY(193);
          if (MMApplicationContext.isMainProcess()) {
            b.x(193, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.qY(181);
          b.x(181, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aPG())
        {
          b.qY(185);
          AppMethodBeat.o(155814);
          return;
        }
        b.qY(189);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 14)
      {
        b.qY(14);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.qY(194);
          if (MMApplicationContext.isMainProcess()) {
            b.x(194, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.qY(182);
          b.x(182, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aPG())
        {
          b.qY(186);
          AppMethodBeat.o(155814);
          return;
        }
        b.qY(190);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 15)
      {
        b.qY(15);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.qY(195);
          if (MMApplicationContext.isMainProcess()) {
            b.x(195, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.qY(183);
          b.x(183, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aPG())
        {
          b.qY(187);
          AppMethodBeat.o(155814);
          return;
        }
        b.qY(191);
      }
    }
    AppMethodBeat.o(155814);
  }
  
  public static boolean b(String paramString, a parama)
  {
    AppMethodBeat.i(155816);
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(paramString, MediaCodecList.getCodecInfoAt(i).getName()))
      {
        parama.lXB = paramString;
        AppMethodBeat.o(155816);
        return true;
      }
      i += 1;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "codecNameSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.qY(24);
    b.a(24, parama);
    AppMethodBeat.o(155816);
    return false;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(155818);
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (TextUtils.equals(localMediaCodecInfo.getName(), paramString))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        if (arrayOfString.length > 0) {
          a(localMediaCodecInfo.isEncoder(), arrayOfString[0], parama);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(155818);
  }
  
  public static boolean qX(int paramInt)
  {
    AppMethodBeat.i(155812);
    if (lXv.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (lXw.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (lXx.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (lXy.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
    b.qY(22);
    b.a(22, new a());
    AppMethodBeat.o(155812);
    return false;
  }
  
  public static a w(int paramInt, String paramString)
  {
    AppMethodBeat.i(155811);
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      localObject = MediaCodecList.getCodecInfoAt(i);
      if (TextUtils.equals(((MediaCodecInfo)localObject).getName(), paramString))
      {
        String[] arrayOfString = ((MediaCodecInfo)localObject).getSupportedTypes();
        if (arrayOfString.length > 0)
        {
          Log.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName success, codecName:[%s], mime:[%s]", new Object[] { paramString, arrayOfString[0] });
          paramString = a(paramInt, ((MediaCodecInfo)localObject).isEncoder(), arrayOfString[0]);
          AppMethodBeat.o(155811);
          return paramString;
        }
      }
      i += 1;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName fail, codecName:[%s]", new Object[] { paramString });
    Object localObject = new a();
    ((a)localObject).lXB = paramString;
    b.qY(21);
    b.a(21, (a)localObject);
    paramString = new a();
    AppMethodBeat.o(155811);
    return paramString;
  }
  
  public static final class a
  {
    public long createTime;
    public boolean lXA;
    public String lXB;
    public String lXC;
    public String mimeType;
    public String stack;
    
    public a()
    {
      AppMethodBeat.i(155797);
      this.stack = Util.getStack().toString();
      this.createTime = System.currentTimeMillis();
      AppMethodBeat.o(155797);
    }
  }
  
  public static final class b
  {
    public static void a(int paramInt, MediaCodecProxyUtils.a parama)
    {
      AppMethodBeat.i(155799);
      MediaCodecProxyUtils.a locala = parama;
      if (parama == null) {
        locala = new MediaCodecProxyUtils.a();
      }
      parama = "";
      if (locala.lXC != null) {
        parama = locala.lXC.replace(",", ";");
      }
      y(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.aCw().size()), Integer.valueOf(MediaCodecProxyUtils.aPI().size()), Integer.valueOf(MediaCodecProxyUtils.aPJ().size()), Integer.valueOf(MediaCodecProxyUtils.lXy.size()), Boolean.valueOf(locala.lXA), locala.mimeType, locala.lXB, parama, locala.stack }));
      AppMethodBeat.o(155799);
    }
    
    public static void qY(int paramInt)
    {
      AppMethodBeat.i(155798);
      v localv = MediaCodecProxyUtils.aPH();
      if (localv != null) {
        localv.hp(paramInt);
      }
      AppMethodBeat.o(155798);
    }
    
    public static void x(int paramInt, String paramString)
    {
      AppMethodBeat.i(155800);
      y(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.aCw().size()), Integer.valueOf(MediaCodecProxyUtils.aPI().size()), Integer.valueOf(MediaCodecProxyUtils.aPJ().size()), Integer.valueOf(MediaCodecProxyUtils.lXy.size()), Boolean.FALSE, "", "", "", paramString }));
      AppMethodBeat.o(155800);
    }
    
    private static void y(int paramInt, String paramString)
    {
      AppMethodBeat.i(155801);
      v localv = MediaCodecProxyUtils.aPH();
      if ((localv != null) && (localv.aPx())) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
        if (bool) {
          break;
        }
        AppMethodBeat.o(155801);
        return;
      }
      localv.Du(paramString);
      AppMethodBeat.o(155801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils
 * JD-Core Version:    0.7.0.1
 */