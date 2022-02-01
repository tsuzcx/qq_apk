package com.tencent.mm.compatible.deviceinfo;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaCodecProxyUtils
{
  private static volatile long geo;
  private static final Map<Integer, a> gep;
  private static final Map<Integer, a> geq;
  private static final Map<Integer, a> ger;
  private static final Map<Integer, a> ges;
  private static u get;
  
  static
  {
    AppMethodBeat.i(155819);
    geo = 0L;
    gep = new ConcurrentHashMap();
    geq = new ConcurrentHashMap();
    ger = new ConcurrentHashMap();
    ges = new ConcurrentHashMap();
    AppMethodBeat.o(155819);
  }
  
  public static a a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(155810);
    a locala = new a();
    locala.mimeType = paramString;
    locala.geu = paramBoolean;
    ae.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/")) {
      if (paramBoolean) {
        ger.put(Integer.valueOf(paramInt), locala);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155810);
      return locala;
      ges.put(Integer.valueOf(paramInt), locala);
      continue;
      if (paramString.contains("audio/"))
      {
        if (paramBoolean) {
          gep.put(Integer.valueOf(paramInt), locala);
        } else {
          geq.put(Integer.valueOf(paramInt), locala);
        }
      }
      else
      {
        b.lx(20);
        b.a(20, locala);
      }
    }
  }
  
  public static void a(u paramu)
  {
    get = paramu;
  }
  
  private static void a(Map<Integer, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(155814);
    if (paramMap.size() >= 8)
    {
      ae.i("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramMap.size()), ak.getProcessName() });
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (geo + 30000L >= System.currentTimeMillis())
      {
        if (geo == 0L) {
          ae.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
        }
      }
      else
      {
        geo = System.currentTimeMillis();
        ae.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", new Object[] { Long.valueOf(geo) });
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
            if (locala.gew != null) {
              localObject = locala.gew.replace(",", ";");
            }
            localStringBuilder1.append(locala.geu).append(";").append(locala.mimeType).append(";").append(locala.gev).append(";").append(ak.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            long l2 = l1 - locala.createTime;
            if (l2 > 600000L)
            {
              ae.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", new Object[] { Long.valueOf(l2) });
              localStringBuilder2.append(l2).append(";").append(locala.geu).append(";").append(locala.mimeType).append(";").append(locala.gev).append(";").append(ak.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            }
          }
        }
      }
      ae.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - geo) });
      AppMethodBeat.o(155814);
      return;
      if (paramInt == 12)
      {
        b.lx(12);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lx(192);
          if (ak.coh()) {
            b.u(192, localStringBuilder1.toString());
          }
        }
        if (ak.coh())
        {
          b.lx(180);
          b.u(180, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aba())
        {
          b.lx(184);
          AppMethodBeat.o(155814);
          return;
        }
        b.lx(188);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 13)
      {
        b.lx(13);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lx(193);
          if (ak.coh()) {
            b.u(193, localStringBuilder1.toString());
          }
        }
        if (ak.coh())
        {
          b.lx(181);
          b.u(181, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aba())
        {
          b.lx(185);
          AppMethodBeat.o(155814);
          return;
        }
        b.lx(189);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 14)
      {
        b.lx(14);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lx(194);
          if (ak.coh()) {
            b.u(194, localStringBuilder1.toString());
          }
        }
        if (ak.coh())
        {
          b.lx(182);
          b.u(182, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aba())
        {
          b.lx(186);
          AppMethodBeat.o(155814);
          return;
        }
        b.lx(190);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 15)
      {
        b.lx(15);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.lx(195);
          if (ak.coh()) {
            b.u(195, localStringBuilder1.toString());
          }
        }
        if (ak.coh())
        {
          b.lx(183);
          b.u(183, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (aba())
        {
          b.lx(187);
          AppMethodBeat.o(155814);
          return;
        }
        b.lx(191);
      }
    }
    AppMethodBeat.o(155814);
  }
  
  public static void a(boolean paramBoolean, String paramString, a parama)
  {
    AppMethodBeat.i(155817);
    ae.i("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        b.lx(6);
        b.a(6, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.lx(5);
      b.a(5, parama);
      AppMethodBeat.o(155817);
      return;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        b.lx(4);
        b.a(4, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.lx(3);
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
          parama.gev = localMediaCodecInfo.getName();
          AppMethodBeat.o(155815);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    ae.e("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.lx(23);
    b.a(23, parama);
    AppMethodBeat.o(155815);
    return false;
  }
  
  public static void aaZ()
  {
    AppMethodBeat.i(155813);
    ae.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", new Object[] { Integer.valueOf(gep.size() + geq.size() + ger.size() + ges.size()), Integer.valueOf(gep.size()), Integer.valueOf(geq.size()), Integer.valueOf(ger.size()), Integer.valueOf(ges.size()) });
    a(geq, 12);
    a(gep, 13);
    a(ges, 14);
    a(ger, 15);
    AppMethodBeat.o(155813);
  }
  
  private static boolean aba()
  {
    AppMethodBeat.i(175887);
    boolean bool = ak.getProcessName().contains(":appbrand");
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
        parama.gev = paramString;
        AppMethodBeat.o(155816);
        return true;
      }
      i += 1;
    }
    ae.e("MicroMsg.MediaCodecProxyUtils", "codecNameSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.lx(24);
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
  
  public static boolean lw(int paramInt)
  {
    AppMethodBeat.i(155812);
    if (gep.remove(Integer.valueOf(paramInt)) != null)
    {
      ae.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (geq.remove(Integer.valueOf(paramInt)) != null)
    {
      ae.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (ger.remove(Integer.valueOf(paramInt)) != null)
    {
      ae.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (ges.remove(Integer.valueOf(paramInt)) != null)
    {
      ae.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    ae.e("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
    b.lx(22);
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
          ae.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName success, codecName:[%s], mime:[%s]", new Object[] { paramString, arrayOfString[0] });
          paramString = a(paramInt, ((MediaCodecInfo)localObject).isEncoder(), arrayOfString[0]);
          AppMethodBeat.o(155811);
          return paramString;
        }
      }
      i += 1;
    }
    ae.e("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName fail, codecName:[%s]", new Object[] { paramString });
    Object localObject = new a();
    ((a)localObject).gev = paramString;
    b.lx(21);
    b.a(21, (a)localObject);
    paramString = new a();
    AppMethodBeat.o(155811);
    return paramString;
  }
  
  public static final class a
  {
    public long createTime;
    public boolean geu;
    public String gev;
    public String gew;
    public String mimeType;
    public String stack;
    
    public a()
    {
      AppMethodBeat.i(155797);
      this.stack = bu.fpN().toString();
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
      if (locala.gew != null) {
        parama = locala.gew.replace(",", ";");
      }
      v(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.abc().size()), Integer.valueOf(MediaCodecProxyUtils.abd().size()), Integer.valueOf(MediaCodecProxyUtils.abe().size()), Integer.valueOf(MediaCodecProxyUtils.ges.size()), Boolean.valueOf(locala.geu), locala.mimeType, locala.gev, parama, locala.stack }));
      AppMethodBeat.o(155799);
    }
    
    public static void lx(int paramInt)
    {
      AppMethodBeat.i(155798);
      u localu = MediaCodecProxyUtils.abb();
      if (localu != null) {
        localu.rd(paramInt);
      }
      AppMethodBeat.o(155798);
    }
    
    public static void u(int paramInt, String paramString)
    {
      AppMethodBeat.i(155800);
      v(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.abc().size()), Integer.valueOf(MediaCodecProxyUtils.abd().size()), Integer.valueOf(MediaCodecProxyUtils.abe().size()), Integer.valueOf(MediaCodecProxyUtils.ges.size()), Boolean.FALSE, "", "", "", paramString }));
      AppMethodBeat.o(155800);
    }
    
    private static void v(int paramInt, String paramString)
    {
      AppMethodBeat.i(155801);
      u localu = MediaCodecProxyUtils.abb();
      if ((localu != null) && (localu.aaW())) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
        if (bool) {
          break;
        }
        AppMethodBeat.o(155801);
        return;
      }
      localu.vG(paramString);
      AppMethodBeat.o(155801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils
 * JD-Core Version:    0.7.0.1
 */