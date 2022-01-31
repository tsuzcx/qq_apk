package com.google.android.exoplayer2.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.i.t;
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
  private static final Pattern aGA;
  private static final HashMap<d.a, List<a>> aGB;
  private static final SparseIntArray aGC;
  private static final SparseIntArray aGD;
  private static final Map<String, Integer> aGE;
  private static int aGF;
  private static final a aGz = new a("OMX.google.raw.decoder", null, null, false, false);
  
  static
  {
    aGA = Pattern.compile("^\\D?(\\d+)$");
    aGB = new HashMap();
    aGF = -1;
    Object localObject = new SparseIntArray();
    aGC = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(66, 1);
    aGC.put(77, 2);
    aGC.put(88, 4);
    aGC.put(100, 8);
    localObject = new SparseIntArray();
    aGD = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(10, 1);
    aGD.put(11, 4);
    aGD.put(12, 8);
    aGD.put(13, 16);
    aGD.put(20, 32);
    aGD.put(21, 64);
    aGD.put(22, 128);
    aGD.put(30, 256);
    aGD.put(31, 512);
    aGD.put(32, 1024);
    aGD.put(40, 2048);
    aGD.put(41, 4096);
    aGD.put(42, 8192);
    aGD.put(50, 16384);
    aGD.put(51, 32768);
    aGD.put(52, 65536);
    localObject = new HashMap();
    aGE = (Map)localObject;
    ((Map)localObject).put("L30", Integer.valueOf(1));
    aGE.put("L60", Integer.valueOf(4));
    aGE.put("L63", Integer.valueOf(16));
    aGE.put("L90", Integer.valueOf(64));
    aGE.put("L93", Integer.valueOf(256));
    aGE.put("L120", Integer.valueOf(1024));
    aGE.put("L123", Integer.valueOf(4096));
    aGE.put("L150", Integer.valueOf(16384));
    aGE.put("L153", Integer.valueOf(65536));
    aGE.put("L156", Integer.valueOf(262144));
    aGE.put("L180", Integer.valueOf(1048576));
    aGE.put("L183", Integer.valueOf(4194304));
    aGE.put("L186", Integer.valueOf(16777216));
    aGE.put("H30", Integer.valueOf(2));
    aGE.put("H60", Integer.valueOf(8));
    aGE.put("H63", Integer.valueOf(32));
    aGE.put("H90", Integer.valueOf(128));
    aGE.put("H93", Integer.valueOf(512));
    aGE.put("H120", Integer.valueOf(2048));
    aGE.put("H123", Integer.valueOf(8192));
    aGE.put("H150", Integer.valueOf(32768));
    aGE.put("H153", Integer.valueOf(131072));
    aGE.put("H156", Integer.valueOf(524288));
    aGE.put("H180", Integer.valueOf(2097152));
    aGE.put("H183", Integer.valueOf(8388608));
    aGE.put("H186", Integer.valueOf(33554432));
  }
  
  private static List<a> a(d.a parama, d.c paramc)
  {
    for (;;)
    {
      int j;
      try
      {
        ArrayList localArrayList = new ArrayList();
        String str1 = parama.mimeType;
        int k = paramc.getCodecCount();
        boolean bool2 = paramc.ms();
        j = 0;
        MediaCodecInfo localMediaCodecInfo;
        String str2;
        String str3;
        if (j < k)
        {
          localMediaCodecInfo = paramc.getCodecInfoAt(j);
          str2 = localMediaCodecInfo.getName();
          if (localMediaCodecInfo.isEncoder()) {
            break label1075;
          }
          if ((!bool2) && (str2.endsWith(".secure")))
          {
            break label1075;
            if (i == 0) {
              break label1068;
            }
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int m = arrayOfString.length;
            i = 0;
            if (i >= m) {
              break label1068;
            }
            str3 = arrayOfString[i];
            bool1 = str3.equalsIgnoreCase(str1);
            if (!bool1) {}
          }
        }
        try
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(str3);
          boolean bool3 = paramc.a(str1, localCodecCapabilities);
          if ((t.SDK_INT <= 22) && ((t.MODEL.equals("ODROID-XU3")) || (t.MODEL.equals("Nexus 10"))))
          {
            if ("OMX.Exynos.AVC.Decoder".equals(str2)) {
              break label1080;
            }
            if ("OMX.Exynos.AVC.Decoder.secure".equals(str2))
            {
              break label1080;
              if (((!bool2) || (parama.aFK != bool3)) && ((bool2) || (parama.aFK))) {
                continue;
              }
              localArrayList.add(a.a(str2, str1, localCodecCapabilities, bool1, false));
              i += 1;
              continue;
              if ((t.SDK_INT < 21) && (("CIPAACDecoder".equals(str2)) || ("CIPMP3Decoder".equals(str2)) || ("CIPVorbisDecoder".equals(str2)) || ("CIPAMRNBDecoder".equals(str2)) || ("AACDecoder".equals(str2)) || ("MP3Decoder".equals(str2)))) {
                break label1086;
              }
              if ((t.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(str2)))
              {
                i = 0;
                continue;
              }
              if ((t.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(str2)) && (("a70".equals(t.DEVICE)) || (("Xiaomi".equals(t.MANUFACTURER)) && (t.DEVICE.startsWith("HM"))))) {
                break label1091;
              }
              if ((t.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(str2)) && (("dlxu".equals(t.DEVICE)) || ("protou".equals(t.DEVICE)) || ("ville".equals(t.DEVICE)) || ("villeplus".equals(t.DEVICE)) || ("villec2".equals(t.DEVICE)) || (t.DEVICE.startsWith("gee")) || ("C6602".equals(t.DEVICE)) || ("C6603".equals(t.DEVICE)) || ("C6606".equals(t.DEVICE)) || ("C6616".equals(t.DEVICE)) || ("L36h".equals(t.DEVICE)) || ("SO-02E".equals(t.DEVICE)))) {
                break label1096;
              }
              if ((t.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(str2)) && (("C1504".equals(t.DEVICE)) || ("C1505".equals(t.DEVICE)) || ("C1604".equals(t.DEVICE)) || ("C1605".equals(t.DEVICE)))) {
                break label1101;
              }
              if ((t.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(str2)) || ("OMX.Exynos.AAC.Decoder".equals(str2))) && (t.MANUFACTURER.equals("samsung")) && ((t.DEVICE.startsWith("zeroflte")) || (t.DEVICE.startsWith("zerolte")) || (t.DEVICE.startsWith("zenlte")) || (t.DEVICE.equals("SC-05G")) || (t.DEVICE.equals("marinelteatt")) || (t.DEVICE.equals("404SC")) || (t.DEVICE.equals("SC-04G")) || (t.DEVICE.equals("SCV31")))) {
                break label1106;
              }
              if ((t.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(str2)) && ("samsung".equals(t.MANUFACTURER)) && ((t.DEVICE.startsWith("d2")) || (t.DEVICE.startsWith("serrano")) || (t.DEVICE.startsWith("jflte")) || (t.DEVICE.startsWith("santos")) || (t.DEVICE.startsWith("t0")))) {
                break label1111;
              }
              if ((t.SDK_INT <= 19) && (t.DEVICE.startsWith("jflte")))
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
          return localArrayList;
        }
        catch (Exception localException)
        {
          if (t.SDK_INT > 23) {
            break label1032;
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
        throw new d.b(parama, (byte)0);
      }
      label1032:
      throw localException;
      label1068:
      j += 1;
      continue;
      label1075:
      int i = 0;
      continue;
      label1080:
      boolean bool1 = true;
      continue;
      label1086:
      i = 0;
      continue;
      label1091:
      i = 0;
      continue;
      label1096:
      i = 0;
      continue;
      label1101:
      i = 0;
      continue;
      label1106:
      i = 0;
      continue;
      label1111:
      i = 0;
    }
  }
  
  public static Pair<Integer, Integer> am(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\.");
    Matcher localMatcher = paramString[0];
    switch (localMatcher.hashCode())
    {
    default: 
      label68:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (!localMatcher.equals("hev1")) {
          break label68;
        }
        continue;
        if (!localMatcher.equals("hvc1")) {
          break label68;
        }
        i = 1;
        continue;
        if (!localMatcher.equals("avc1")) {
          break label68;
        }
        i = 2;
        continue;
        if (!localMatcher.equals("avc2")) {
          break label68;
        }
        i = 3;
      }
    }
    if (paramString.length < 4) {
      return null;
    }
    localMatcher = aGA.matcher(paramString[1]);
    if (!localMatcher.matches()) {
      return null;
    }
    String str = localMatcher.group(1);
    if ("1".equals(str)) {}
    for (i = 1;; i = 2)
    {
      paramString = (Integer)aGE.get(paramString[3]);
      if (paramString != null) {
        break label262;
      }
      new StringBuilder("Unknown HEVC level string: ").append(localMatcher.group(1));
      return null;
      if (!"2".equals(str)) {
        break;
      }
    }
    return null;
    label262:
    return new Pair(Integer.valueOf(i), paramString);
    return c(paramString);
  }
  
  private static Pair<Integer, Integer> c(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2) {
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
        localInteger2 = Integer.valueOf(aGC.get(localInteger1.intValue()));
        if (localInteger2 != null) {
          break label125;
        }
        new StringBuilder("Unknown AVC profile: ").append(localInteger1);
        return null;
        if (paramArrayOfString.length < 3) {
          break;
        }
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
        i = Integer.parseInt(paramArrayOfString[2]);
      }
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      return null;
    }
    label125:
    Integer localInteger1 = Integer.valueOf(aGD.get(paramArrayOfString.intValue()));
    if (localInteger1 == null)
    {
      new StringBuilder("Unknown AVC level: ").append(paramArrayOfString);
      return null;
    }
    return new Pair(localInteger2, localInteger1);
  }
  
  public static a d(String paramString, boolean paramBoolean)
  {
    paramString = e(paramString, paramBoolean);
    if (paramString.isEmpty()) {
      return null;
    }
    return (a)paramString.get(0);
  }
  
  private static List<a> e(String paramString, boolean paramBoolean)
  {
    label201:
    for (;;)
    {
      try
      {
        d.a locala = new d.a(paramString, paramBoolean);
        Object localObject = (List)aGB.get(locala);
        if (localObject != null)
        {
          paramString = (String)localObject;
          return paramString;
        }
        if (t.SDK_INT >= 21)
        {
          localObject = new d.e(paramBoolean);
          List localList = a(locala, (d.c)localObject);
          localObject = localList;
          if (paramBoolean)
          {
            localObject = localList;
            if (localList.isEmpty())
            {
              localObject = localList;
              if (21 <= t.SDK_INT)
              {
                localObject = localList;
                if (t.SDK_INT <= 23)
                {
                  localObject = a(locala, new d.d((byte)0));
                  if (((List)localObject).isEmpty()) {
                    break label201;
                  }
                  new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(paramString).append(". Assuming: ").append(((a)((List)localObject).get(0)).name);
                  break label201;
                }
              }
            }
          }
          r((List)localObject);
          paramString = Collections.unmodifiableList((List)localObject);
          aGB.put(locala, paramString);
          continue;
        }
        localObject = new d.d((byte)0);
      }
      finally {}
    }
  }
  
  public static a mq()
  {
    return aGz;
  }
  
  public static int mr()
  {
    int i = 0;
    int j;
    if (aGF == -1)
    {
      Object localObject = d("video/avc", false);
      if (localObject != null)
      {
        localObject = ((a)localObject).mk();
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
        if (t.SDK_INT < 21) {
          break label339;
        }
      }
    }
    label339:
    for (i = 345600;; i = 172800)
    {
      i = Math.max(j, i);
      aGF = i;
      return aGF;
    }
  }
  
  private static void r(List<a> paramList)
  {
    int i = 1;
    if ((t.SDK_INT < 26) && (paramList.size() > 1) && ("OMX.MTK.AUDIO.DECODER.RAW".equals(((a)paramList.get(0)).name))) {}
    for (;;)
    {
      if (i < paramList.size())
      {
        a locala = (a)paramList.get(i);
        if ("OMX.google.raw.decoder".equals(locala.name))
        {
          paramList.remove(i);
          paramList.add(0, locala);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d
 * JD-Core Version:    0.7.0.1
 */