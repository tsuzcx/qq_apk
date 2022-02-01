package com.tencent.mm.compatible.deviceinfo;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaCodecProxyUtils
{
  private static volatile long fIF;
  private static final Map<Integer, a> fIG;
  private static final Map<Integer, a> fIH;
  private static final Map<Integer, a> fII;
  private static final Map<Integer, a> fIJ;
  private static u fIK;
  
  static
  {
    AppMethodBeat.i(155819);
    fIF = 0L;
    fIG = new ConcurrentHashMap();
    fIH = new ConcurrentHashMap();
    fII = new ConcurrentHashMap();
    fIJ = new ConcurrentHashMap();
    AppMethodBeat.o(155819);
  }
  
  public static void Yo()
  {
    AppMethodBeat.i(155813);
    ac.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", new Object[] { Integer.valueOf(fIG.size() + fIH.size() + fII.size() + fIJ.size()), Integer.valueOf(fIG.size()), Integer.valueOf(fIH.size()), Integer.valueOf(fII.size()), Integer.valueOf(fIJ.size()) });
    a(fIH, 12);
    a(fIG, 13);
    a(fIJ, 14);
    a(fII, 15);
    AppMethodBeat.o(155813);
  }
  
  private static boolean Yp()
  {
    AppMethodBeat.i(175887);
    boolean bool = ai.getProcessName().contains(":appbrand");
    AppMethodBeat.o(175887);
    return bool;
  }
  
  public static a a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(155810);
    a locala = new a();
    locala.mimeType = paramString;
    locala.fIL = paramBoolean;
    ac.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/")) {
      if (paramBoolean) {
        fII.put(Integer.valueOf(paramInt), locala);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155810);
      return locala;
      fIJ.put(Integer.valueOf(paramInt), locala);
      continue;
      if (paramString.contains("audio/"))
      {
        if (paramBoolean) {
          fIG.put(Integer.valueOf(paramInt), locala);
        } else {
          fIH.put(Integer.valueOf(paramInt), locala);
        }
      }
      else
      {
        b.kW(20);
        b.a(20, locala);
      }
    }
  }
  
  public static void a(u paramu)
  {
    fIK = paramu;
  }
  
  private static void a(Map<Integer, a> paramMap, int paramInt)
  {
    AppMethodBeat.i(155814);
    if (paramMap.size() >= 8)
    {
      ac.i("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramMap.size()), ai.getProcessName() });
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if (fIF + 30000L >= System.currentTimeMillis())
      {
        if (fIF == 0L) {
          ac.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
        }
      }
      else
      {
        fIF = System.currentTimeMillis();
        ac.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", new Object[] { Long.valueOf(fIF) });
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
            if (locala.fIN != null) {
              localObject = locala.fIN.replace(",", ";");
            }
            localStringBuilder1.append(locala.fIL).append(";").append(locala.mimeType).append(";").append(locala.fIM).append(";").append(ai.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            long l2 = l1 - locala.createTime;
            if (l2 > 600000L)
            {
              ac.i("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", new Object[] { Long.valueOf(l2) });
              localStringBuilder2.append(l2).append(";").append(locala.fIL).append(";").append(locala.mimeType).append(";").append(locala.fIM).append(";").append(ai.getProcessName()).append(";").append((String)localObject).append(";").append(locala.stack).append("|");
            }
          }
        }
      }
      ac.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - fIF) });
      AppMethodBeat.o(155814);
      return;
      if (paramInt == 12)
      {
        b.kW(12);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.kW(192);
          if (ai.cin()) {
            b.u(192, localStringBuilder1.toString());
          }
        }
        if (ai.cin())
        {
          b.kW(180);
          b.u(180, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Yp())
        {
          b.kW(184);
          AppMethodBeat.o(155814);
          return;
        }
        b.kW(188);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 13)
      {
        b.kW(13);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.kW(193);
          if (ai.cin()) {
            b.u(193, localStringBuilder1.toString());
          }
        }
        if (ai.cin())
        {
          b.kW(181);
          b.u(181, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Yp())
        {
          b.kW(185);
          AppMethodBeat.o(155814);
          return;
        }
        b.kW(189);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 14)
      {
        b.kW(14);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.kW(194);
          if (ai.cin()) {
            b.u(194, localStringBuilder1.toString());
          }
        }
        if (ai.cin())
        {
          b.kW(182);
          b.u(182, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Yp())
        {
          b.kW(186);
          AppMethodBeat.o(155814);
          return;
        }
        b.kW(190);
        AppMethodBeat.o(155814);
        return;
      }
      if (paramInt == 15)
      {
        b.kW(15);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          b.kW(195);
          if (ai.cin()) {
            b.u(195, localStringBuilder1.toString());
          }
        }
        if (ai.cin())
        {
          b.kW(183);
          b.u(183, localStringBuilder1.toString());
          AppMethodBeat.o(155814);
          return;
        }
        if (Yp())
        {
          b.kW(187);
          AppMethodBeat.o(155814);
          return;
        }
        b.kW(191);
      }
    }
    AppMethodBeat.o(155814);
  }
  
  public static void a(boolean paramBoolean, String paramString, a parama)
  {
    AppMethodBeat.i(155817);
    ac.i("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        b.kW(6);
        b.a(6, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.kW(5);
      b.a(5, parama);
      AppMethodBeat.o(155817);
      return;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        b.kW(4);
        b.a(4, parama);
        AppMethodBeat.o(155817);
        return;
      }
      b.kW(3);
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
          parama.fIM = localMediaCodecInfo.getName();
          AppMethodBeat.o(155815);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    ac.e("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.kW(23);
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
        parama.fIM = paramString;
        AppMethodBeat.o(155816);
        return true;
      }
      i += 1;
    }
    ac.e("MicroMsg.MediaCodecProxyUtils", "codecNameSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    b.kW(24);
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
  
  public static boolean kV(int paramInt)
  {
    AppMethodBeat.i(155812);
    if (fIG.remove(Integer.valueOf(paramInt)) != null)
    {
      ac.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (fIH.remove(Integer.valueOf(paramInt)) != null)
    {
      ac.d("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (fII.remove(Integer.valueOf(paramInt)) != null)
    {
      ac.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    if (fIJ.remove(Integer.valueOf(paramInt)) != null)
    {
      ac.d("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
      AppMethodBeat.o(155812);
      return true;
    }
    ac.e("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
    b.kW(22);
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
          ac.i("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName success, codecName:[%s], mime:[%s]", new Object[] { paramString, arrayOfString[0] });
          paramString = a(paramInt, ((MediaCodecInfo)localObject).isEncoder(), arrayOfString[0]);
          AppMethodBeat.o(155811);
          return paramString;
        }
      }
      i += 1;
    }
    ac.e("MicroMsg.MediaCodecProxyUtils", "insertMapWithCodecName fail, codecName:[%s]", new Object[] { paramString });
    Object localObject = new a();
    ((a)localObject).fIM = paramString;
    b.kW(21);
    b.a(21, (a)localObject);
    paramString = new a();
    AppMethodBeat.o(155811);
    return paramString;
  }
  
  public static class MediaCodecRetryInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaCodecRetryInfo> CREATOR;
    int fIO;
    
    static
    {
      AppMethodBeat.i(155805);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(155805);
    }
    
    protected MediaCodecRetryInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(155803);
      this.fIO = paramParcel.readInt();
      AppMethodBeat.o(155803);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(155804);
      paramParcel.writeInt(this.fIO);
      AppMethodBeat.o(155804);
    }
  }
  
  public static class MediaCodecRetryInfoWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaCodecRetryInfoWrapper> CREATOR;
    List<MediaCodecProxyUtils.MediaCodecRetryInfo> fIP;
    
    static
    {
      AppMethodBeat.i(155809);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(155809);
    }
    
    protected MediaCodecRetryInfoWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(155807);
      this.fIP = paramParcel.createTypedArrayList(MediaCodecProxyUtils.MediaCodecRetryInfo.CREATOR);
      AppMethodBeat.o(155807);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(155808);
      paramParcel.writeTypedList(this.fIP);
      AppMethodBeat.o(155808);
    }
  }
  
  public static final class a
  {
    public long createTime;
    public boolean fIL;
    public String fIM;
    public String fIN;
    public String mimeType;
    public String stack;
    
    public a()
    {
      AppMethodBeat.i(155797);
      this.stack = bs.eWi().toString();
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
      if (locala.fIN != null) {
        parama = locala.fIN.replace(",", ";");
      }
      v(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.Yr().size()), Integer.valueOf(MediaCodecProxyUtils.Ys().size()), Integer.valueOf(MediaCodecProxyUtils.Yt().size()), Integer.valueOf(MediaCodecProxyUtils.fIJ.size()), Boolean.valueOf(locala.fIL), locala.mimeType, locala.fIM, parama, locala.stack }));
      AppMethodBeat.o(155799);
    }
    
    public static void kW(int paramInt)
    {
      AppMethodBeat.i(155798);
      u localu = MediaCodecProxyUtils.Yq();
      if (localu != null) {
        localu.oQ(paramInt);
      }
      AppMethodBeat.o(155798);
    }
    
    public static void u(int paramInt, String paramString)
    {
      AppMethodBeat.i(155800);
      v(paramInt, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MediaCodecProxyUtils.Yr().size()), Integer.valueOf(MediaCodecProxyUtils.Ys().size()), Integer.valueOf(MediaCodecProxyUtils.Yt().size()), Integer.valueOf(MediaCodecProxyUtils.fIJ.size()), Boolean.FALSE, "", "", "", paramString }));
      AppMethodBeat.o(155800);
    }
    
    private static void v(int paramInt, String paramString)
    {
      AppMethodBeat.i(155801);
      u localu = MediaCodecProxyUtils.Yq();
      if ((localu != null) && (localu.Yl())) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
        if (bool) {
          break;
        }
        AppMethodBeat.o(155801);
        return;
      }
      localu.sv(paramString);
      AppMethodBeat.o(155801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils
 * JD-Core Version:    0.7.0.1
 */