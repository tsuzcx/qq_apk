package com.google.android.exoplayer2.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
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

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d
{
  private static final a bdr;
  private static final Pattern bds;
  private static final HashMap<a, List<a>> bdt;
  private static final SparseIntArray bdu;
  private static final SparseIntArray bdv;
  private static final Map<String, Integer> bdw;
  private static int bdx;
  
  static
  {
    AppMethodBeat.i(92378);
    bdr = new a("OMX.google.raw.decoder", null, null, false, false);
    bds = Pattern.compile("^\\D?(\\d+)$");
    bdt = new HashMap();
    bdx = -1;
    Object localObject = new SparseIntArray();
    bdu = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(66, 1);
    bdu.put(77, 2);
    bdu.put(88, 4);
    bdu.put(100, 8);
    localObject = new SparseIntArray();
    bdv = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(10, 1);
    bdv.put(11, 4);
    bdv.put(12, 8);
    bdv.put(13, 16);
    bdv.put(20, 32);
    bdv.put(21, 64);
    bdv.put(22, 128);
    bdv.put(30, 256);
    bdv.put(31, 512);
    bdv.put(32, 1024);
    bdv.put(40, 2048);
    bdv.put(41, 4096);
    bdv.put(42, 8192);
    bdv.put(50, 16384);
    bdv.put(51, 32768);
    bdv.put(52, 65536);
    localObject = new HashMap();
    bdw = (Map)localObject;
    ((Map)localObject).put("L30", Integer.valueOf(1));
    bdw.put("L60", Integer.valueOf(4));
    bdw.put("L63", Integer.valueOf(16));
    bdw.put("L90", Integer.valueOf(64));
    bdw.put("L93", Integer.valueOf(256));
    bdw.put("L120", Integer.valueOf(1024));
    bdw.put("L123", Integer.valueOf(4096));
    bdw.put("L150", Integer.valueOf(16384));
    bdw.put("L153", Integer.valueOf(65536));
    bdw.put("L156", Integer.valueOf(262144));
    bdw.put("L180", Integer.valueOf(1048576));
    bdw.put("L183", Integer.valueOf(4194304));
    bdw.put("L186", Integer.valueOf(16777216));
    bdw.put("H30", Integer.valueOf(2));
    bdw.put("H60", Integer.valueOf(8));
    bdw.put("H63", Integer.valueOf(32));
    bdw.put("H90", Integer.valueOf(128));
    bdw.put("H93", Integer.valueOf(512));
    bdw.put("H120", Integer.valueOf(2048));
    bdw.put("H123", Integer.valueOf(8192));
    bdw.put("H150", Integer.valueOf(32768));
    bdw.put("H153", Integer.valueOf(131072));
    bdw.put("H156", Integer.valueOf(524288));
    bdw.put("H180", Integer.valueOf(2097152));
    bdw.put("H183", Integer.valueOf(8388608));
    bdw.put("H186", Integer.valueOf(33554432));
    AppMethodBeat.o(92378);
  }
  
  private static List<a> a(a parama, c paramc)
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
        int k = paramc.te();
        boolean bool2 = paramc.tf();
        j = 0;
        if (j >= k) {
          break label1104;
        }
        MediaCodecInfo localMediaCodecInfo = paramc.eI(j);
        String str2 = localMediaCodecInfo.getName();
        if (localMediaCodecInfo.isEncoder()) {
          break label1112;
        }
        String str3;
        if ((!bool2) && (str2.endsWith(".secure")))
        {
          break label1112;
          if (i == 0) {
            break label1097;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int m = arrayOfString.length;
          i = 0;
          if (i >= m) {
            break label1097;
          }
          str3 = arrayOfString[i];
          bool1 = str3.equalsIgnoreCase(str1);
          if (!bool1) {}
        }
        try
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
          boolean bool3 = paramc.a(str1, localCodecCapabilities);
          if ((x.SDK_INT <= 22) && ((x.brq.equals("ODROID-XU3")) || (x.brq.equals("Nexus 10"))))
          {
            if ("OMX.Exynos.AVC.Decoder".equals(str2)) {
              break label1117;
            }
            if ("OMX.Exynos.AVC.Decoder.secure".equals(str2))
            {
              break label1117;
              if (((!bool2) || (parama.bcB != bool3)) && ((bool2) || (parama.bcB))) {
                continue;
              }
              localArrayList.add(a.a(str2, str1, localCodecCapabilities, bool1, false));
              i += 1;
              continue;
              if ((x.SDK_INT < 21) && (("CIPAACDecoder".equals(str2)) || ("CIPMP3Decoder".equals(str2)) || ("CIPVorbisDecoder".equals(str2)) || ("CIPAMRNBDecoder".equals(str2)) || ("AACDecoder".equals(str2)) || ("MP3Decoder".equals(str2)))) {
                break label1123;
              }
              if ((x.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(str2)))
              {
                i = 0;
                continue;
              }
              if ((x.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(str2)) && (("a70".equals(x.bro)) || (("Xiaomi".equals(x.brp)) && (x.bro.startsWith("HM"))))) {
                break label1128;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(str2)) && (("dlxu".equals(x.bro)) || ("protou".equals(x.bro)) || ("ville".equals(x.bro)) || ("villeplus".equals(x.bro)) || ("villec2".equals(x.bro)) || (x.bro.startsWith("gee")) || ("C6602".equals(x.bro)) || ("C6603".equals(x.bro)) || ("C6606".equals(x.bro)) || ("C6616".equals(x.bro)) || ("L36h".equals(x.bro)) || ("SO-02E".equals(x.bro)))) {
                break label1133;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(str2)) && (("C1504".equals(x.bro)) || ("C1505".equals(x.bro)) || ("C1604".equals(x.bro)) || ("C1605".equals(x.bro)))) {
                break label1138;
              }
              if ((x.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(str2)) || ("OMX.Exynos.AAC.Decoder".equals(str2))) && (x.brp.equals("samsung")) && ((x.bro.startsWith("zeroflte")) || (x.bro.startsWith("zerolte")) || (x.bro.startsWith("zenlte")) || (x.bro.equals("SC-05G")) || (x.bro.equals("marinelteatt")) || (x.bro.equals("404SC")) || (x.bro.equals("SC-04G")) || (x.bro.equals("SCV31")))) {
                break label1143;
              }
              if ((x.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(str2)) && ("samsung".equals(x.brp)) && ((x.bro.startsWith("d2")) || (x.bro.startsWith("serrano")) || (x.bro.startsWith("jflte")) || (x.bro.startsWith("santos")) || (x.bro.startsWith("t0")))) {
                break label1148;
              }
              if ((x.SDK_INT <= 19) && (x.bro.startsWith("jflte")))
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
            break label1056;
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
      label1056:
      AppMethodBeat.o(92375);
      throw localException;
      label1097:
      j += 1;
      continue;
      label1104:
      AppMethodBeat.o(92375);
      return localArrayList;
      label1112:
      int i = 0;
      continue;
      label1117:
      boolean bool1 = true;
      continue;
      label1123:
      i = 0;
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
    }
  }
  
  public static Pair<Integer, Integer> bt(String paramString)
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
    localMatcher = bds.matcher(paramString[1]);
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(92374);
      return null;
    }
    String str = localMatcher.group(1);
    if ("1".equals(str)) {}
    for (i = 1;; i = 2)
    {
      paramString = (Integer)bdw.get(paramString[3]);
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
        localInteger2 = Integer.valueOf(bdu.get(localInteger1.intValue()));
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
    Integer localInteger1 = Integer.valueOf(bdv.get(paramArrayOfString.intValue()));
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
        a locala = new a(paramString, paramBoolean);
        Object localObject = (List)bdt.get(locala);
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
          p((List)localObject);
          paramString = Collections.unmodifiableList((List)localObject);
          bdt.put(locala, paramString);
          AppMethodBeat.o(92372);
          continue;
        }
        localObject = new d((byte)0);
      }
      finally {}
    }
  }
  
  private static void p(List<a> paramList)
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
  
  public static a tc()
  {
    return bdr;
  }
  
  public static int td()
  {
    int i = 0;
    AppMethodBeat.i(92373);
    int j;
    if (bdx == -1)
    {
      Object localObject = e("video/avc", false);
      if (localObject != null)
      {
        localObject = ((a)localObject).sU();
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
          break label355;
        }
      }
    }
    label355:
    for (i = 345600;; i = 172800)
    {
      i = Math.max(j, i);
      bdx = i;
      i = bdx;
      AppMethodBeat.o(92373);
      return i;
    }
  }
  
  static final class a
  {
    public final boolean bcB;
    public final String mimeType;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.mimeType = paramString;
      this.bcB = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(92362);
      if (this == paramObject)
      {
        AppMethodBeat.o(92362);
        return true;
      }
      if ((paramObject == null) || (paramObject.getClass() != a.class))
      {
        AppMethodBeat.o(92362);
        return false;
      }
      paramObject = (a)paramObject;
      if ((TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.bcB == paramObject.bcB))
      {
        AppMethodBeat.o(92362);
        return true;
      }
      AppMethodBeat.o(92362);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(92361);
      int i;
      if (this.mimeType == null)
      {
        i = 0;
        if (!this.bcB) {
          break label51;
        }
      }
      label51:
      for (int j = 1231;; j = 1237)
      {
        AppMethodBeat.o(92361);
        return j + (i + 31) * 31;
        i = this.mimeType.hashCode();
        break;
      }
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
    public abstract boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
    
    public abstract MediaCodecInfo eI(int paramInt);
    
    public abstract int te();
    
    public abstract boolean tf();
  }
  
  static final class d
    implements d.c
  {
    public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      AppMethodBeat.i(92365);
      boolean bool = "video/avc".equals(paramString);
      AppMethodBeat.o(92365);
      return bool;
    }
    
    public final MediaCodecInfo eI(int paramInt)
    {
      AppMethodBeat.i(92364);
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(paramInt);
      AppMethodBeat.o(92364);
      return localMediaCodecInfo;
    }
    
    public final int te()
    {
      AppMethodBeat.i(92363);
      int i = MediaCodecList.getCodecCount();
      AppMethodBeat.o(92363);
      return i;
    }
    
    public final boolean tf()
    {
      return false;
    }
  }
  
  @TargetApi(21)
  static final class e
    implements d.c
  {
    private final int bdy;
    private MediaCodecInfo[] bdz;
    
    public e(boolean paramBoolean)
    {
      AppMethodBeat.i(92366);
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.bdy = i;
        AppMethodBeat.o(92366);
        return;
      }
    }
    
    private void tg()
    {
      AppMethodBeat.i(92370);
      if (this.bdz == null) {
        this.bdz = new MediaCodecList(this.bdy).getCodecInfos();
      }
      AppMethodBeat.o(92370);
    }
    
    public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      AppMethodBeat.i(92369);
      boolean bool = paramCodecCapabilities.isFeatureSupported("secure-playback");
      AppMethodBeat.o(92369);
      return bool;
    }
    
    public final MediaCodecInfo eI(int paramInt)
    {
      AppMethodBeat.i(92368);
      tg();
      MediaCodecInfo localMediaCodecInfo = this.bdz[paramInt];
      AppMethodBeat.o(92368);
      return localMediaCodecInfo;
    }
    
    public final int te()
    {
      AppMethodBeat.i(92367);
      tg();
      int i = this.bdz.length;
      AppMethodBeat.o(92367);
      return i;
    }
    
    public final boolean tf()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d
 * JD-Core Version:    0.7.0.1
 */