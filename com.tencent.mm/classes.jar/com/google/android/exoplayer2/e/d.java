package com.google.android.exoplayer2.e;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{
  private static final a cXl;
  private static final Pattern cXm;
  private static final HashMap<d.a, List<a>> cXn;
  private static final SparseIntArray cXo;
  private static final SparseIntArray cXp;
  private static final Map<String, Integer> cXq;
  private static int cXr;
  
  static
  {
    AppMethodBeat.i(92378);
    cXl = new a("OMX.google.raw.decoder", null, null, false, false);
    cXm = Pattern.compile("^\\D?(\\d+)$");
    cXn = new HashMap();
    cXr = -1;
    Object localObject = new SparseIntArray();
    cXo = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(66, 1);
    cXo.put(77, 2);
    cXo.put(88, 4);
    cXo.put(100, 8);
    localObject = new SparseIntArray();
    cXp = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(10, 1);
    cXp.put(11, 4);
    cXp.put(12, 8);
    cXp.put(13, 16);
    cXp.put(20, 32);
    cXp.put(21, 64);
    cXp.put(22, 128);
    cXp.put(30, 256);
    cXp.put(31, 512);
    cXp.put(32, 1024);
    cXp.put(40, 2048);
    cXp.put(41, 4096);
    cXp.put(42, 8192);
    cXp.put(50, 16384);
    cXp.put(51, 32768);
    cXp.put(52, 65536);
    localObject = new HashMap();
    cXq = (Map)localObject;
    ((Map)localObject).put("L30", Integer.valueOf(1));
    cXq.put("L60", Integer.valueOf(4));
    cXq.put("L63", Integer.valueOf(16));
    cXq.put("L90", Integer.valueOf(64));
    cXq.put("L93", Integer.valueOf(256));
    cXq.put("L120", Integer.valueOf(1024));
    cXq.put("L123", Integer.valueOf(4096));
    cXq.put("L150", Integer.valueOf(16384));
    cXq.put("L153", Integer.valueOf(65536));
    cXq.put("L156", Integer.valueOf(262144));
    cXq.put("L180", Integer.valueOf(1048576));
    cXq.put("L183", Integer.valueOf(4194304));
    cXq.put("L186", Integer.valueOf(16777216));
    cXq.put("H30", Integer.valueOf(2));
    cXq.put("H60", Integer.valueOf(8));
    cXq.put("H63", Integer.valueOf(32));
    cXq.put("H90", Integer.valueOf(128));
    cXq.put("H93", Integer.valueOf(512));
    cXq.put("H120", Integer.valueOf(2048));
    cXq.put("H123", Integer.valueOf(8192));
    cXq.put("H150", Integer.valueOf(32768));
    cXq.put("H153", Integer.valueOf(131072));
    cXq.put("H156", Integer.valueOf(524288));
    cXq.put("H180", Integer.valueOf(2097152));
    cXq.put("H183", Integer.valueOf(8388608));
    cXq.put("H186", Integer.valueOf(33554432));
    AppMethodBeat.o(92378);
  }
  
  public static a SF()
  {
    return cXl;
  }
  
  public static int SG()
  {
    int i = 0;
    AppMethodBeat.i(92373);
    int j;
    if (cXr == -1)
    {
      Object localObject = e("video/avc", false);
      if (localObject != null)
      {
        localObject = ((a)localObject).Sy();
        int m = localObject.length;
        int k = 0;
        j = 0;
        if (k < m)
        {
          switch (localObject[k].level)
          {
          default: 
            i = -1;
          }
          for (;;)
          {
            j = Math.max(i, j);
            k += 1;
            break;
            i = 25344;
            continue;
            i = 25344;
            continue;
            i = 101376;
            continue;
            i = 101376;
            continue;
            i = 101376;
            continue;
            i = 202752;
            continue;
            i = 414720;
            continue;
            i = 414720;
            continue;
            i = 921600;
            continue;
            i = 1310720;
            continue;
            i = 2097152;
            continue;
            i = 2097152;
            continue;
            i = 2228224;
            continue;
            i = 5652480;
            continue;
            i = 9437184;
            continue;
            i = 9437184;
          }
        }
        if (x.SDK_INT < 21) {
          break label337;
        }
      }
    }
    label337:
    for (i = 345600;; i = 172800)
    {
      i = Math.max(j, i);
      cXr = i;
      i = cXr;
      AppMethodBeat.o(92373);
      return i;
    }
  }
  
  private static List<a> a(d.a parama, c paramc)
  {
    AppMethodBeat.i(92375);
    for (;;)
    {
      ArrayList localArrayList;
      int j;
      try
      {
        localArrayList = new ArrayList();
        String str1 = parama.mimeType;
        int k = paramc.SH();
        boolean bool2 = paramc.SI();
        j = 0;
        if (j >= k) {
          break label1109;
        }
        MediaCodecInfo localMediaCodecInfo = paramc.hY(j);
        String str2 = localMediaCodecInfo.getName();
        if (localMediaCodecInfo.isEncoder()) {
          break label1117;
        }
        String str3;
        if ((!bool2) && (str2.endsWith(".secure")))
        {
          break label1117;
          if (i == 0) {
            break label1102;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int m = arrayOfString.length;
          i = 0;
          if (i >= m) {
            break label1102;
          }
          str3 = arrayOfString[i];
          bool1 = str3.equalsIgnoreCase(str1);
          if (!bool1) {}
        }
        try
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
          boolean bool3 = paramc.a(str1, localCodecCapabilities);
          if ((x.SDK_INT <= 22) && ((x.MODEL.equals("ODROID-XU3")) || (x.MODEL.equals("Nexus 10"))))
          {
            if ("OMX.Exynos.AVC.Decoder".equals(str2)) {
              break label1122;
            }
            if ("OMX.Exynos.AVC.Decoder.secure".equals(str2))
            {
              break label1122;
              if (((!bool2) || (parama.cWw != bool3)) && ((bool2) || (parama.cWw))) {
                continue;
              }
              localArrayList.add(a.a(str2, str1, localCodecCapabilities, bool1, false));
              i += 1;
              continue;
              if ((x.SDK_INT < 21) && (("CIPAACDecoder".equals(str2)) || ("CIPMP3Decoder".equals(str2)) || ("CIPVorbisDecoder".equals(str2)) || ("CIPAMRNBDecoder".equals(str2)) || ("AACDecoder".equals(str2)) || ("MP3Decoder".equals(str2)))) {
                break label1128;
              }
              if ((x.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(str2)))
              {
                i = 0;
                continue;
              }
              if ((x.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(str2)) && (("a70".equals(x.dkS)) || (("Xiaomi".equals(x.MANUFACTURER)) && (x.dkS.startsWith("HM"))))) {
                break label1133;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(str2)) && (("dlxu".equals(x.dkS)) || ("protou".equals(x.dkS)) || ("ville".equals(x.dkS)) || ("villeplus".equals(x.dkS)) || ("villec2".equals(x.dkS)) || (x.dkS.startsWith("gee")) || ("C6602".equals(x.dkS)) || ("C6603".equals(x.dkS)) || ("C6606".equals(x.dkS)) || ("C6616".equals(x.dkS)) || ("L36h".equals(x.dkS)) || ("SO-02E".equals(x.dkS)))) {
                break label1138;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(str2)) && (("C1504".equals(x.dkS)) || ("C1505".equals(x.dkS)) || ("C1604".equals(x.dkS)) || ("C1605".equals(x.dkS)))) {
                break label1143;
              }
              if ((x.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(str2)) || ("OMX.Exynos.AAC.Decoder".equals(str2))) && (x.MANUFACTURER.equals("samsung")) && ((x.dkS.startsWith("zeroflte")) || (x.dkS.startsWith("zerolte")) || (x.dkS.startsWith("zenlte")) || (x.dkS.equals("SC-05G")) || (x.dkS.equals("marinelteatt")) || (x.dkS.equals("404SC")) || (x.dkS.equals("SC-04G")) || (x.dkS.equals("SCV31")))) {
                break label1148;
              }
              if ((x.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(str2)) && ("samsung".equals(x.MANUFACTURER)) && ((x.dkS.startsWith("d2")) || (x.dkS.startsWith("serrano")) || (x.dkS.startsWith("jflte")) || (x.dkS.startsWith("santos")) || (x.dkS.startsWith("t0")))) {
                break label1153;
              }
              if ((x.SDK_INT <= 19) && (x.dkS.startsWith("jflte")))
              {
                bool1 = "OMX.qcom.video.decoder.vp8".equals(str2);
                if (bool1)
                {
                  i = 0;
                  continue;
                }
              }
              i = 1;
              continue;
            }
          }
          bool1 = false;
          continue;
          if ((bool2) || (!bool3)) {
            continue;
          }
          localArrayList.add(a.a(str2 + ".secure", str1, localCodecCapabilities, bool1, true));
          AppMethodBeat.o(92375);
          return localArrayList;
        }
        catch (Exception localException)
        {
          if (x.SDK_INT > 23) {
            break label1061;
          }
        }
        if (!localArrayList.isEmpty())
        {
          new StringBuilder("Skipping codec ").append(str2).append(" (failed to query capabilities)");
          continue;
        }
        new StringBuilder("Failed to query codec ").append(str2).append(" (").append(str3).append(")");
      }
      catch (Exception parama)
      {
        parama = new b(parama, (byte)0);
        AppMethodBeat.o(92375);
        throw parama;
      }
      label1061:
      AppMethodBeat.o(92375);
      throw localException;
      label1102:
      j += 1;
      continue;
      label1109:
      AppMethodBeat.o(92375);
      return localArrayList;
      label1117:
      int i = 0;
      continue;
      label1122:
      boolean bool1 = true;
      continue;
      label1128:
      i = 0;
      continue;
      label1133:
      i = 0;
      continue;
      label1138:
      i = 0;
      continue;
      label1143:
      i = 0;
      continue;
      label1148:
      i = 0;
      continue;
      label1153:
      i = 0;
    }
  }
  
  private static void ai(List<a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(92376);
    if ((x.SDK_INT < 26) && (paramList.size() > 1) && ("OMX.MTK.AUDIO.DECODER.RAW".equals(((a)paramList.get(0)).name))) {
      while (i < paramList.size())
      {
        a locala = (a)paramList.get(i);
        if ("OMX.google.raw.decoder".equals(locala.name))
        {
          paramList.remove(i);
          paramList.add(0, locala);
          AppMethodBeat.o(92376);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(92376);
  }
  
  private static Pair<Integer, Integer> c(String[] paramArrayOfString)
  {
    AppMethodBeat.i(92377);
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(92377);
      return null;
    }
    Integer localInteger2;
    try
    {
      int i;
      if (paramArrayOfString[1].length() == 6)
      {
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1].substring(0, 2), 16));
        i = Integer.parseInt(paramArrayOfString[1].substring(4), 16);
      }
      for (paramArrayOfString = Integer.valueOf(i);; paramArrayOfString = Integer.valueOf(i))
      {
        localInteger2 = Integer.valueOf(cXo.get(localInteger1.intValue()));
        if (localInteger2 != null) {
          break label155;
        }
        new StringBuilder("Unknown AVC profile: ").append(localInteger1);
        AppMethodBeat.o(92377);
        return null;
        if (paramArrayOfString.length < 3) {
          break;
        }
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
        i = Integer.parseInt(paramArrayOfString[2]);
      }
      AppMethodBeat.o(92377);
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      AppMethodBeat.o(92377);
      return null;
    }
    label155:
    Integer localInteger1 = Integer.valueOf(cXp.get(paramArrayOfString.intValue()));
    if (localInteger1 == null)
    {
      new StringBuilder("Unknown AVC level: ").append(paramArrayOfString);
      AppMethodBeat.o(92377);
      return null;
    }
    paramArrayOfString = new Pair(localInteger2, localInteger1);
    AppMethodBeat.o(92377);
    return paramArrayOfString;
  }
  
  public static Pair<Integer, Integer> cL(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(92374);
    if (paramString == null)
    {
      AppMethodBeat.o(92374);
      return null;
    }
    paramString = paramString.split("\\.");
    Matcher localMatcher = paramString[0];
    switch (localMatcher.hashCode())
    {
    default: 
      label80:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(92374);
        return null;
        if (!localMatcher.equals("hev1")) {
          break label80;
        }
        continue;
        if (!localMatcher.equals("hvc1")) {
          break label80;
        }
        i = 1;
        continue;
        if (!localMatcher.equals("avc1")) {
          break label80;
        }
        i = 2;
        continue;
        if (!localMatcher.equals("avc2")) {
          break label80;
        }
        i = 3;
      }
    }
    if (paramString.length < 4)
    {
      AppMethodBeat.o(92374);
      return null;
    }
    localMatcher = cXm.matcher(paramString[1]);
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(92374);
      return null;
    }
    String str = localMatcher.group(1);
    if ("1".equals(str)) {}
    for (i = 1;; i = 2)
    {
      paramString = (Integer)cXq.get(paramString[3]);
      if (paramString != null) {
        break label304;
      }
      new StringBuilder("Unknown HEVC level string: ").append(localMatcher.group(1));
      AppMethodBeat.o(92374);
      return null;
      if (!"2".equals(str)) {
        break;
      }
    }
    AppMethodBeat.o(92374);
    return null;
    label304:
    paramString = new Pair(Integer.valueOf(i), paramString);
    AppMethodBeat.o(92374);
    return paramString;
    paramString = c(paramString);
    AppMethodBeat.o(92374);
    return paramString;
  }
  
  public static a e(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(92371);
    paramString = f(paramString, paramBoolean);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(92371);
      return null;
    }
    paramString = (a)paramString.get(0);
    AppMethodBeat.o(92371);
    return paramString;
  }
  
  private static List<a> f(String paramString, boolean paramBoolean)
  {
    label219:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92372);
        d.a locala = new d.a(paramString, paramBoolean);
        Object localObject = (List)cXn.get(locala);
        if (localObject != null)
        {
          AppMethodBeat.o(92372);
          paramString = (String)localObject;
          return paramString;
        }
        if (x.SDK_INT >= 21)
        {
          localObject = new e(paramBoolean);
          List localList = a(locala, (c)localObject);
          localObject = localList;
          if (paramBoolean)
          {
            localObject = localList;
            if (localList.isEmpty())
            {
              localObject = localList;
              if (21 <= x.SDK_INT)
              {
                localObject = localList;
                if (x.SDK_INT <= 23)
                {
                  localObject = a(locala, new d((byte)0));
                  if (((List)localObject).isEmpty()) {
                    break label219;
                  }
                  new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(paramString).append(". Assuming: ").append(((a)((List)localObject).get(0)).name);
                  break label219;
                }
              }
            }
          }
          ai((List)localObject);
          paramString = Collections.unmodifiableList((List)localObject);
          cXn.put(locala, paramString);
          AppMethodBeat.o(92372);
          continue;
        }
        localObject = new d((byte)0);
      }
      finally {}
    }
  }
  
  public static final class b
    extends Exception
  {
    private b(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static abstract interface c
  {
    public abstract int SH();
    
    public abstract boolean SI();
    
    public abstract boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
    
    public abstract MediaCodecInfo hY(int paramInt);
  }
  
  static final class d
    implements d.c
  {
    public final int SH()
    {
      AppMethodBeat.i(92363);
      int i = MediaCodecList.getCodecCount();
      AppMethodBeat.o(92363);
      return i;
    }
    
    public final boolean SI()
    {
      return false;
    }
    
    public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      AppMethodBeat.i(92365);
      boolean bool = "video/avc".equals(paramString);
      AppMethodBeat.o(92365);
      return bool;
    }
    
    public final MediaCodecInfo hY(int paramInt)
    {
      AppMethodBeat.i(92364);
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(paramInt);
      AppMethodBeat.o(92364);
      return localMediaCodecInfo;
    }
  }
  
  static final class e
    implements d.c
  {
    private final int cXs;
    private MediaCodecInfo[] cXt;
    
    public e(boolean paramBoolean)
    {
      AppMethodBeat.i(92366);
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.cXs = i;
        AppMethodBeat.o(92366);
        return;
      }
    }
    
    private void SJ()
    {
      AppMethodBeat.i(92370);
      if (this.cXt == null) {
        this.cXt = new MediaCodecList(this.cXs).getCodecInfos();
      }
      AppMethodBeat.o(92370);
    }
    
    public final int SH()
    {
      AppMethodBeat.i(92367);
      SJ();
      int i = this.cXt.length;
      AppMethodBeat.o(92367);
      return i;
    }
    
    public final boolean SI()
    {
      return true;
    }
    
    public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      AppMethodBeat.i(92369);
      boolean bool = paramCodecCapabilities.isFeatureSupported("secure-playback");
      AppMethodBeat.o(92369);
      return bool;
    }
    
    public final MediaCodecInfo hY(int paramInt)
    {
      AppMethodBeat.i(92368);
      SJ();
      MediaCodecInfo localMediaCodecInfo = this.cXt[paramInt];
      AppMethodBeat.o(92368);
      return localMediaCodecInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d
 * JD-Core Version:    0.7.0.1
 */