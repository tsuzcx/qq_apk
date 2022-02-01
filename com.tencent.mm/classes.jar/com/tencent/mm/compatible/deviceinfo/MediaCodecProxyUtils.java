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
  private static volatile long gJP;
  private static final Map<Integer, a> gJQ;
  private static final Map<Integer, a> gJR;
  private static final Map<Integer, a> gJS;
  private static final Map<Integer, a> gJT;
  private static u gJU;
  
  static
  {
    AppMethodBeat.i(155819);
    gJP = 0L;
    gJQ = new ConcurrentHashMap();
    gJR = new ConcurrentHashMap();
    gJS = new ConcurrentHashMap();
    gJT = new ConcurrentHashMap();
    AppMethodBeat.o(155819);
  }
  
  public static a a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(155810);
    a locala = new a();
    locala.mimeType = paramString;
    locala.gJV = paramBoolean;
    Log.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/")) {
      if (paramBoolean) {
        gJS.put(Integer.valueOf(paramInt), locala);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155810);
      return locala;
      gJT.put(Integer.valueOf(paramInt), locala);
      continue;
      if (paramString.contains("audio/"))
      {
        if (paramBoolean) {
          gJQ.put(Integer.valueOf(paramInt), locala);
        } else {
          gJR.put(Integer.valueOf(paramInt), locala);
        }
      }
      else
      {
        b.oA(20);
        b.a(20, locala);
      }
    }
  }
  
  public static void a(u paramu)
  {
    gJU = paramu;
  }
  
  private static void a(Map<Integer, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(155814);
    if (paramMap.size() >= 8)
    {
      Log.i("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramMap.size()), MMApplicationContext.getProcessName() });
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (gJP + 30000L >= System.currentTimeMillis())
      {
        if (gJP == 0L) {
          Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
        }
      }
      else
      {
        gJP = System.currentTimeMillis();
        Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", new Object[] { Long.valueOf(gJP) });
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
            if (locala.gJX != null) {
              localObject = locala.gJX.replace(",", ";");
            }
            localStringBuilder1.append(locala.gJV).append(";").append(locala.mimeType).append(";").append(locala.gJW).append(";").append(MMApplicationContext.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            long l2 = l1 - locala.createTime;
            if (l2 > 600000L)
            {
              Log.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", new Object[] { Long.valueOf(l2) });
              localStringBuilder2.append(l2).append(";").append(locala.gJV).append(";").append(locala.mimeType).append(";").append(locala.gJW).append(";").append(MMApplicationContext.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            }
          }
        }
      }
      Log.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - gJP) });
      AppMethodBeat.o(155814);
      return;
      if (paramInt == 12)
      {
        b.oA(12);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.oA(192);
          if (MMApplicationContext.isMainProcess()) {
            b.w(192, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.oA(180);
          b.w(180, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aoZ())
        {
          b.oA(184);
          AppMethodBeat.o(155814);
          return;
        }
        b.oA(188);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 13)
      {
        b.oA(13);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.oA(193);
          if (MMApplicationContext.isMainProcess()) {
            b.w(193, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.oA(181);
          b.w(181, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aoZ())
        {
          b.oA(185);
          AppMethodBeat.o(155814);
          return;
        }
        b.oA(189);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 14)
      {
        b.oA(14);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.oA(194);
          if (MMApplicationContext.isMainProcess()) {
            b.w(194, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.oA(182);
          b.w(182, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aoZ())
        {
          b.oA(186);
          AppMethodBeat.o(155814);
          return;
        }
        b.oA(190);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 15)
      {
        b.oA(15);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.oA(195);
          if (MMApplicationContext.isMainProcess()) {
            b.w(195, localStringBuilder1.toString());
          }
        }
        if (MMApplicationContext.isMainProcess())
        {
          b.oA(183);
          b.w(183, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aoZ())
        {
          b.oA(187);
          AppMethodBeat.o(155814);
          return;
        }
        b.oA(191);
      }
    }
    AppMethodBeat.o(155814);
  }
  
  public static void a(boolean paramBoolean, String paramString, a parama)
  {
    AppMethodBeat.i(155817);
    Log.i("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        b.oA(6);
        b.a(6, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.oA(5);
      b.a(5, parama);
      AppMethodBeat.o(155817);
      return;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        b.oA(4);
        b.a(4, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.oA(3);
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
          parama.gJW = localMediaCodecInfo.getName();
          AppMethodBeat.o(155815);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.oA(23);
    b.a(23, parama);
    AppMethodBeat.o(155815);
    return false;
  }
  
  public static void aoY()
  {
    AppMethodBeat.i(155813);
    Log.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", new Object[] { Integer.valueOf(gJQ.size() + gJR.size() + gJS.size() + gJT.size()), Integer.valueOf(gJQ.size()), Integer.valueOf(gJR.size()), Integer.valueOf(gJS.size()), Integer.valueOf(gJT.size()) });
    a(gJR, 12);
    a(gJQ, 13);
    a(gJT, 14);
    a(gJS, 15);
    AppMethodBeat.o(155813);
  }
  
  private static boolean aoZ()
  {
    AppMethodBeat.i(175887);
    boolean bool = MMApplicationContext.getProcessName().contains(":appbrand");
    AppMethodBeat.o(175887);
    return bool;
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
        parama.gJW = paramString;
        AppMethodBeat.o(155816);
        return true;
      }
      i += 1;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "codecNameSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.oA(24);
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
  
  public static boolean oz(int paramInt)
  {
    AppMethodBeat.i(155812);
    if (gJQ.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (gJR.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (gJS.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (gJT.remove(Integer.valueOf(paramInt)) != null)
    {
      Log.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    Log.e("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
    b.oA(22);
    b.a(22, new a());
    AppMethodBeat.o(155812);
    return false;
  }
  
  public static a v(int paramInt, String paramString)
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
    ((a)localObject).gJW = paramString;
    b.oA(21);
    b.a(21, (a)localObject);
    paramString = new a();
    AppMethodBeat.o(155811);
    return paramString;
  }
  
  public static final class a
  {
    public long createTime;
    public boolean gJV;
    public String gJW;
    public String gJX;
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
      if (locala.gJX != null) {
        parama = locala.gJX.replace(",", ";");
      }
      x(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.apb().size()), Integer.valueOf(MediaCodecProxyUtils.apc().size()), Integer.valueOf(MediaCodecProxyUtils.apd().size()), Integer.valueOf(MediaCodecProxyUtils.gJT.size()), Boolean.valueOf(locala.gJV), locala.mimeType, locala.gJW, parama, locala.stack }));
      AppMethodBeat.o(155799);
    }
    
    public static void oA(int paramInt)
    {
      AppMethodBeat.i(155798);
      u localu = MediaCodecProxyUtils.apa();
      if (localu != null) {
        localu.yU(paramInt);
      }
      AppMethodBeat.o(155798);
    }
    
    public static void w(int paramInt, String paramString)
    {
      AppMethodBeat.i(155800);
      x(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.apb().size()), Integer.valueOf(MediaCodecProxyUtils.apc().size()), Integer.valueOf(MediaCodecProxyUtils.apd().size()), Integer.valueOf(MediaCodecProxyUtils.gJT.size()), Boolean.FALSE, "", "", "", paramString }));
      AppMethodBeat.o(155800);
    }
    
    private static void x(int paramInt, String paramString)
    {
      AppMethodBeat.i(155801);
      u localu = MediaCodecProxyUtils.apa();
      if ((localu != null) && (localu.aoV())) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
        if (bool) {
          break;
        }
        AppMethodBeat.o(155801);
        return;
      }
      localu.DX(paramString);
      AppMethodBeat.o(155801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils
 * JD-Core Version:    0.7.0.1
 */