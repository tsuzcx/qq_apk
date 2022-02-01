package com.tencent.mm.compatible.deviceinfo;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaCodecProxyUtils
{
  private static volatile long fEY;
  private static final Map<Integer, a> fEZ;
  private static final Map<Integer, a> fFa;
  private static final Map<Integer, a> fFb;
  private static final Map<Integer, a> fFc;
  private static u fFd;
  
  static
  {
    AppMethodBeat.i(155819);
    fEY = 0L;
    fEZ = new ConcurrentHashMap();
    fFa = new ConcurrentHashMap();
    fFb = new ConcurrentHashMap();
    fFc = new ConcurrentHashMap();
    AppMethodBeat.o(155819);
  }
  
  public static void Xr()
  {
    AppMethodBeat.i(155813);
    ad.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", new Object[] { Integer.valueOf(fEZ.size() + fFa.size() + fFb.size() + fFc.size()), Integer.valueOf(fEZ.size()), Integer.valueOf(fFa.size()), Integer.valueOf(fFb.size()), Integer.valueOf(fFc.size()) });
    a(fFa, 12);
    a(fEZ, 13);
    a(fFc, 14);
    a(fFb, 15);
    AppMethodBeat.o(155813);
  }
  
  private static boolean Xs()
  {
    AppMethodBeat.i(175887);
    boolean bool = aj.getProcessName().contains(":appbrand");
    AppMethodBeat.o(175887);
    return bool;
  }
  
  public static a a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(155810);
    a locala = new a();
    locala.mimeType = paramString;
    locala.fFe = paramBoolean;
    ad.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/")) {
      if (paramBoolean) {
        fFb.put(Integer.valueOf(paramInt), locala);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155810);
      return locala;
      fFc.put(Integer.valueOf(paramInt), locala);
      continue;
      if (paramString.contains("audio/"))
      {
        if (paramBoolean) {
          fEZ.put(Integer.valueOf(paramInt), locala);
        } else {
          fFa.put(Integer.valueOf(paramInt), locala);
        }
      }
      else
      {
        b.lc(20);
        b.a(20, locala);
      }
    }
  }
  
  public static void a(u paramu)
  {
    fFd = paramu;
  }
  
  private static void a(Map<Integer, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(155814);
    if (paramMap.size() >= 8)
    {
      ad.i("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramMap.size()), aj.getProcessName() });
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (fEY + 30000L >= System.currentTimeMillis())
      {
        if (fEY == 0L) {
          ad.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
        }
      }
      else
      {
        fEY = System.currentTimeMillis();
        ad.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", new Object[] { Long.valueOf(fEY) });
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
            if (locala.fFg != null) {
              localObject = locala.fFg.replace(",", ";");
            }
            localStringBuilder1.append(locala.fFe).append(";").append(locala.mimeType).append(";").append(locala.fFf).append(";").append(aj.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            long l2 = l1 - locala.createTime;
            if (l2 > 600000L)
            {
              ad.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", new Object[] { Long.valueOf(l2) });
              localStringBuilder2.append(l2).append(";").append(locala.fFe).append(";").append(locala.mimeType).append(";").append(locala.fFf).append(";").append(aj.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            }
          }
        }
      }
      ad.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - fEY) });
      AppMethodBeat.o(155814);
      return;
      if (paramInt == 12)
      {
        b.lc(12);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lc(192);
          if (aj.cbe()) {
            b.u(192, localStringBuilder1.toString());
          }
        }
        if (aj.cbe())
        {
          b.lc(180);
          b.u(180, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Xs())
        {
          b.lc(184);
          AppMethodBeat.o(155814);
          return;
        }
        b.lc(188);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 13)
      {
        b.lc(13);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lc(193);
          if (aj.cbe()) {
            b.u(193, localStringBuilder1.toString());
          }
        }
        if (aj.cbe())
        {
          b.lc(181);
          b.u(181, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Xs())
        {
          b.lc(185);
          AppMethodBeat.o(155814);
          return;
        }
        b.lc(189);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 14)
      {
        b.lc(14);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lc(194);
          if (aj.cbe()) {
            b.u(194, localStringBuilder1.toString());
          }
        }
        if (aj.cbe())
        {
          b.lc(182);
          b.u(182, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Xs())
        {
          b.lc(186);
          AppMethodBeat.o(155814);
          return;
        }
        b.lc(190);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 15)
      {
        b.lc(15);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lc(195);
          if (aj.cbe()) {
            b.u(195, localStringBuilder1.toString());
          }
        }
        if (aj.cbe())
        {
          b.lc(183);
          b.u(183, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Xs())
        {
          b.lc(187);
          AppMethodBeat.o(155814);
          return;
        }
        b.lc(191);
      }
    }
    AppMethodBeat.o(155814);
  }
  
  public static void a(boolean paramBoolean, String paramString, a parama)
  {
    AppMethodBeat.i(155817);
    ad.i("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        b.lc(6);
        b.a(6, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.lc(5);
      b.a(5, parama);
      AppMethodBeat.o(155817);
      return;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        b.lc(4);
        b.a(4, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.lc(3);
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
          parama.fFf = localMediaCodecInfo.getName();
          AppMethodBeat.o(155815);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    ad.e("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.lc(23);
    b.a(23, parama);
    AppMethodBeat.o(155815);
    return false;
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
        parama.fFf = paramString;
        AppMethodBeat.o(155816);
        return true;
      }
      i += 1;
    }
    ad.e("MicroMsg.MediaCodecProxyUtils", "codecNameSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.lc(24);
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
  
  public static boolean lb(int paramInt)
  {
    AppMethodBeat.i(155812);
    if (fEZ.remove(Integer.valueOf(paramInt)) != null)
    {
      ad.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (fFa.remove(Integer.valueOf(paramInt)) != null)
    {
      ad.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (fFb.remove(Integer.valueOf(paramInt)) != null)
    {
      ad.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (fFc.remove(Integer.valueOf(paramInt)) != null)
    {
      ad.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    ad.e("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
    b.lc(22);
    b.a(22, new a());
    AppMethodBeat.o(155812);
    return false;
  }
  
  public static a t(int paramInt, String paramString)
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
          ad.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName success, codecName:[%s], mime:[%s]", new Object[] { paramString, arrayOfString[0] });
          paramString = a(paramInt, ((MediaCodecInfo)localObject).isEncoder(), arrayOfString[0]);
          AppMethodBeat.o(155811);
          return paramString;
        }
      }
      i += 1;
    }
    ad.e("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName fail, codecName:[%s]", new Object[] { paramString });
    Object localObject = new a();
    ((a)localObject).fFf = paramString;
    b.lc(21);
    b.a(21, (a)localObject);
    paramString = new a();
    AppMethodBeat.o(155811);
    return paramString;
  }
  
  public static final class a
  {
    public long createTime;
    public boolean fFe;
    public String fFf;
    public String fFg;
    public String mimeType;
    public String stack;
    
    public a()
    {
      AppMethodBeat.i(155797);
      this.stack = bt.eGN().toString();
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
      if (locala.fFg != null) {
        parama = locala.fFg.replace(",", ";");
      }
      v(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.Xu().size()), Integer.valueOf(MediaCodecProxyUtils.Xv().size()), Integer.valueOf(MediaCodecProxyUtils.Xw().size()), Integer.valueOf(MediaCodecProxyUtils.fFc.size()), Boolean.valueOf(locala.fFe), locala.mimeType, locala.fFf, parama, locala.stack }));
      AppMethodBeat.o(155799);
    }
    
    public static void lc(int paramInt)
    {
      AppMethodBeat.i(155798);
      u localu = MediaCodecProxyUtils.Xt();
      if (localu != null) {
        localu.ln(paramInt);
      }
      AppMethodBeat.o(155798);
    }
    
    public static void u(int paramInt, String paramString)
    {
      AppMethodBeat.i(155800);
      v(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.Xu().size()), Integer.valueOf(MediaCodecProxyUtils.Xv().size()), Integer.valueOf(MediaCodecProxyUtils.Xw().size()), Integer.valueOf(MediaCodecProxyUtils.fFc.size()), Boolean.FALSE, "", "", "", paramString }));
      AppMethodBeat.o(155800);
    }
    
    private static void v(int paramInt, String paramString)
    {
      AppMethodBeat.i(155801);
      u localu = MediaCodecProxyUtils.Xt();
      if ((localu != null) && (localu.Xo())) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
        if (bool) {
          break;
        }
        AppMethodBeat.o(155801);
        return;
      }
      localu.pj(paramString);
      AppMethodBeat.o(155801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils
 * JD-Core Version:    0.7.0.1
 */