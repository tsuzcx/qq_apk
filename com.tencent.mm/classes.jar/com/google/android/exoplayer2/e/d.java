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
  private static final a btT;
  private static final Pattern btU;
  private static final HashMap<a, List<a>> btV;
  private static final SparseIntArray btW;
  private static final SparseIntArray btX;
  private static final Map<String, Integer> btY;
  private static int btZ;
  
  static
  {
    AppMethodBeat.i(92378);
    btT = new a("OMX.google.raw.decoder", null, null, false, false);
    btU = Pattern.compile("^\\D?(\\d+)$");
    btV = new HashMap();
    btZ = -1;
    Object localObject = new SparseIntArray();
    btW = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(66, 1);
    btW.put(77, 2);
    btW.put(88, 4);
    btW.put(100, 8);
    localObject = new SparseIntArray();
    btX = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(10, 1);
    btX.put(11, 4);
    btX.put(12, 8);
    btX.put(13, 16);
    btX.put(20, 32);
    btX.put(21, 64);
    btX.put(22, 128);
    btX.put(30, 256);
    btX.put(31, 512);
    btX.put(32, 1024);
    btX.put(40, 2048);
    btX.put(41, 4096);
    btX.put(42, 8192);
    btX.put(50, 16384);
    btX.put(51, 32768);
    btX.put(52, 65536);
    localObject = new HashMap();
    btY = (Map)localObject;
    ((Map)localObject).put("L30", Integer.valueOf(1));
    btY.put("L60", Integer.valueOf(4));
    btY.put("L63", Integer.valueOf(16));
    btY.put("L90", Integer.valueOf(64));
    btY.put("L93", Integer.valueOf(256));
    btY.put("L120", Integer.valueOf(1024));
    btY.put("L123", Integer.valueOf(4096));
    btY.put("L150", Integer.valueOf(16384));
    btY.put("L153", Integer.valueOf(65536));
    btY.put("L156", Integer.valueOf(262144));
    btY.put("L180", Integer.valueOf(1048576));
    btY.put("L183", Integer.valueOf(4194304));
    btY.put("L186", Integer.valueOf(16777216));
    btY.put("H30", Integer.valueOf(2));
    btY.put("H60", Integer.valueOf(8));
    btY.put("H63", Integer.valueOf(32));
    btY.put("H90", Integer.valueOf(128));
    btY.put("H93", Integer.valueOf(512));
    btY.put("H120", Integer.valueOf(2048));
    btY.put("H123", Integer.valueOf(8192));
    btY.put("H150", Integer.valueOf(32768));
    btY.put("H153", Integer.valueOf(131072));
    btY.put("H156", Integer.valueOf(524288));
    btY.put("H180", Integer.valueOf(2097152));
    btY.put("H183", Integer.valueOf(8388608));
    btY.put("H186", Integer.valueOf(33554432));
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
        int k = paramc.getCodecCount();
        boolean bool2 = paramc.vc();
        j = 0;
        if (j >= k) {
          break label1104;
        }
        MediaCodecInfo localMediaCodecInfo = paramc.getCodecInfoAt(j);
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
          if ((x.SDK_INT <= 22) && ((x.MODEL.equals("ODROID-XU3")) || (x.MODEL.equals("Nexus 10"))))
          {
            if ("OMX.Exynos.AVC.Decoder".equals(str2)) {
              break label1117;
            }
            if ("OMX.Exynos.AVC.Decoder.secure".equals(str2))
            {
              break label1117;
              if (((!bool2) || (parama.btd != bool3)) && ((bool2) || (parama.btd))) {
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
              if ((x.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(str2)) && (("a70".equals(x.DEVICE)) || (("Xiaomi".equals(x.MANUFACTURER)) && (x.DEVICE.startsWith("HM"))))) {
                break label1128;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(str2)) && (("dlxu".equals(x.DEVICE)) || ("protou".equals(x.DEVICE)) || ("ville".equals(x.DEVICE)) || ("villeplus".equals(x.DEVICE)) || ("villec2".equals(x.DEVICE)) || (x.DEVICE.startsWith("gee")) || ("C6602".equals(x.DEVICE)) || ("C6603".equals(x.DEVICE)) || ("C6606".equals(x.DEVICE)) || ("C6616".equals(x.DEVICE)) || ("L36h".equals(x.DEVICE)) || ("SO-02E".equals(x.DEVICE)))) {
                break label1133;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(str2)) && (("C1504".equals(x.DEVICE)) || ("C1505".equals(x.DEVICE)) || ("C1604".equals(x.DEVICE)) || ("C1605".equals(x.DEVICE)))) {
                break label1138;
              }
              if ((x.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(str2)) || ("OMX.Exynos.AAC.Decoder".equals(str2))) && (x.MANUFACTURER.equals("samsung")) && ((x.DEVICE.startsWith("zeroflte")) || (x.DEVICE.startsWith("zerolte")) || (x.DEVICE.startsWith("zenlte")) || (x.DEVICE.equals("SC-05G")) || (x.DEVICE.equals("marinelteatt")) || (x.DEVICE.equals("404SC")) || (x.DEVICE.equals("SC-04G")) || (x.DEVICE.equals("SCV31")))) {
                break label1143;
              }
              if ((x.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(str2)) && ("samsung".equals(x.MANUFACTURER)) && ((x.DEVICE.startsWith("d2")) || (x.DEVICE.startsWith("serrano")) || (x.DEVICE.startsWith("jflte")) || (x.DEVICE.startsWith("santos")) || (x.DEVICE.startsWith("t0")))) {
                break label1148;
              }
              if ((x.SDK_INT <= 19) && (x.DEVICE.startsWith("jflte")))
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
  
  public static Pair<Integer, Integer> bi(String paramString)
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
    localMatcher = btU.matcher(paramString[1]);
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(92374);
      return null;
    }
    String str = localMatcher.group(1);
    if ("1".equals(str)) {}
    for (i = 1;; i = 2)
    {
      paramString = (Integer)btY.get(paramString[3]);
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
    paramString = e(paramString);
    AppMethodBeat.o(92374);
    return paramString;
  }
  
  private static Pair<Integer, Integer> e(String[] paramArrayOfString)
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
        localInteger2 = Integer.valueOf(btW.get(localInteger1.intValue()));
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
    Integer localInteger1 = Integer.valueOf(btX.get(paramArrayOfString.intValue()));
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
  
  public static a f(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(92371);
    paramString = g(paramString, paramBoolean);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(92371);
      return null;
    }
    paramString = (a)paramString.get(0);
    AppMethodBeat.o(92371);
    return paramString;
  }
  
  private static List<a> g(String paramString, boolean paramBoolean)
  {
    label219:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92372);
        a locala = new a(paramString, paramBoolean);
        Object localObject = (List)btV.get(locala);
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
          u((List)localObject);
          paramString = Collections.unmodifiableList((List)localObject);
          btV.put(locala, paramString);
          AppMethodBeat.o(92372);
          continue;
        }
        localObject = new d((byte)0);
      }
      finally {}
    }
  }
  
  private static void u(List<a> paramList)
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
  
  public static a va()
  {
    return btT;
  }
  
  public static int vb()
  {
    int i = 0;
    AppMethodBeat.i(92373);
    int j;
    if (btZ == -1)
    {
      Object localObject = f("video/avc", false);
      if (localObject != null)
      {
        localObject = ((a)localObject).uU();
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
      btZ = i;
      i = btZ;
      AppMethodBeat.o(92373);
      return i;
    }
  }
  
  static final class a
  {
    public final boolean btd;
    public final String mimeType;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.mimeType = paramString;
      this.btd = paramBoolean;
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
      if ((TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.btd == paramObject.btd))
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
        if (!this.btd) {
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
    
    public abstract int getCodecCount();
    
    public abstract MediaCodecInfo getCodecInfoAt(int paramInt);
    
    public abstract boolean vc();
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
    
    public final int getCodecCount()
    {
      AppMethodBeat.i(92363);
      int i = MediaCodecList.getCodecCount();
      AppMethodBeat.o(92363);
      return i;
    }
    
    public final MediaCodecInfo getCodecInfoAt(int paramInt)
    {
      AppMethodBeat.i(92364);
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(paramInt);
      AppMethodBeat.o(92364);
      return localMediaCodecInfo;
    }
    
    public final boolean vc()
    {
      return false;
    }
  }
  
  @TargetApi(21)
  static final class e
    implements d.c
  {
    private final int bua;
    private MediaCodecInfo[] bub;
    
    public e(boolean paramBoolean)
    {
      AppMethodBeat.i(92366);
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.bua = i;
        AppMethodBeat.o(92366);
        return;
      }
    }
    
    private void vd()
    {
      AppMethodBeat.i(92370);
      if (this.bub == null) {
        this.bub = new MediaCodecList(this.bua).getCodecInfos();
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
    
    public final int getCodecCount()
    {
      AppMethodBeat.i(92367);
      vd();
      int i = this.bub.length;
      AppMethodBeat.o(92367);
      return i;
    }
    
    public final MediaCodecInfo getCodecInfoAt(int paramInt)
    {
      AppMethodBeat.i(92368);
      vd();
      MediaCodecInfo localMediaCodecInfo = this.bub[paramInt];
      AppMethodBeat.o(92368);
      return localMediaCodecInfo;
    }
    
    public final boolean vc()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d
 * JD-Core Version:    0.7.0.1
 */