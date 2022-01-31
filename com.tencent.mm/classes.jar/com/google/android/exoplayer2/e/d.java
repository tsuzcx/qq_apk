package com.google.android.exoplayer2.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
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
  private static int aNA;
  private static final a aNu;
  private static final Pattern aNv;
  private static final HashMap<d.a, List<a>> aNw;
  private static final SparseIntArray aNx;
  private static final SparseIntArray aNy;
  private static final Map<String, Integer> aNz;
  
  static
  {
    AppMethodBeat.i(95256);
    aNu = new a("OMX.google.raw.decoder", null, null, false, false);
    aNv = Pattern.compile("^\\D?(\\d+)$");
    aNw = new HashMap();
    aNA = -1;
    Object localObject = new SparseIntArray();
    aNx = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(66, 1);
    aNx.put(77, 2);
    aNx.put(88, 4);
    aNx.put(100, 8);
    localObject = new SparseIntArray();
    aNy = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(10, 1);
    aNy.put(11, 4);
    aNy.put(12, 8);
    aNy.put(13, 16);
    aNy.put(20, 32);
    aNy.put(21, 64);
    aNy.put(22, 128);
    aNy.put(30, 256);
    aNy.put(31, 512);
    aNy.put(32, 1024);
    aNy.put(40, 2048);
    aNy.put(41, 4096);
    aNy.put(42, 8192);
    aNy.put(50, 16384);
    aNy.put(51, 32768);
    aNy.put(52, 65536);
    localObject = new HashMap();
    aNz = (Map)localObject;
    ((Map)localObject).put("L30", Integer.valueOf(1));
    aNz.put("L60", Integer.valueOf(4));
    aNz.put("L63", Integer.valueOf(16));
    aNz.put("L90", Integer.valueOf(64));
    aNz.put("L93", Integer.valueOf(256));
    aNz.put("L120", Integer.valueOf(1024));
    aNz.put("L123", Integer.valueOf(4096));
    aNz.put("L150", Integer.valueOf(16384));
    aNz.put("L153", Integer.valueOf(65536));
    aNz.put("L156", Integer.valueOf(262144));
    aNz.put("L180", Integer.valueOf(1048576));
    aNz.put("L183", Integer.valueOf(4194304));
    aNz.put("L186", Integer.valueOf(16777216));
    aNz.put("H30", Integer.valueOf(2));
    aNz.put("H60", Integer.valueOf(8));
    aNz.put("H63", Integer.valueOf(32));
    aNz.put("H90", Integer.valueOf(128));
    aNz.put("H93", Integer.valueOf(512));
    aNz.put("H120", Integer.valueOf(2048));
    aNz.put("H123", Integer.valueOf(8192));
    aNz.put("H150", Integer.valueOf(32768));
    aNz.put("H153", Integer.valueOf(131072));
    aNz.put("H156", Integer.valueOf(524288));
    aNz.put("H180", Integer.valueOf(2097152));
    aNz.put("H183", Integer.valueOf(8388608));
    aNz.put("H186", Integer.valueOf(33554432));
    AppMethodBeat.o(95256);
  }
  
  private static List<a> a(d.a parama, d.c paramc)
  {
    AppMethodBeat.i(95253);
    for (;;)
    {
      ArrayList localArrayList;
      int j;
      try
      {
        localArrayList = new ArrayList();
        String str1 = parama.mimeType;
        int k = paramc.getCodecCount();
        boolean bool2 = paramc.oJ();
        j = 0;
        if (j >= k) {
          break label1102;
        }
        MediaCodecInfo localMediaCodecInfo = paramc.getCodecInfoAt(j);
        String str2 = localMediaCodecInfo.getName();
        if (localMediaCodecInfo.isEncoder()) {
          break label1110;
        }
        String str3;
        if ((!bool2) && (str2.endsWith(".secure")))
        {
          break label1110;
          if (i == 0) {
            break label1095;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int m = arrayOfString.length;
          i = 0;
          if (i >= m) {
            break label1095;
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
              break label1115;
            }
            if ("OMX.Exynos.AVC.Decoder.secure".equals(str2))
            {
              break label1115;
              if (((!bool2) || (parama.aMF != bool3)) && ((bool2) || (parama.aMF))) {
                continue;
              }
              localArrayList.add(a.a(str2, str1, localCodecCapabilities, bool1, false));
              i += 1;
              continue;
              if ((x.SDK_INT < 21) && (("CIPAACDecoder".equals(str2)) || ("CIPMP3Decoder".equals(str2)) || ("CIPVorbisDecoder".equals(str2)) || ("CIPAMRNBDecoder".equals(str2)) || ("AACDecoder".equals(str2)) || ("MP3Decoder".equals(str2)))) {
                break label1121;
              }
              if ((x.SDK_INT < 18) && ("OMX.SEC.MP3.Decoder".equals(str2)))
              {
                i = 0;
                continue;
              }
              if ((x.SDK_INT < 18) && ("OMX.MTK.AUDIO.DECODER.AAC".equals(str2)) && (("a70".equals(x.DEVICE)) || (("Xiaomi".equals(x.MANUFACTURER)) && (x.DEVICE.startsWith("HM"))))) {
                break label1126;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.mp3".equals(str2)) && (("dlxu".equals(x.DEVICE)) || ("protou".equals(x.DEVICE)) || ("ville".equals(x.DEVICE)) || ("villeplus".equals(x.DEVICE)) || ("villec2".equals(x.DEVICE)) || (x.DEVICE.startsWith("gee")) || ("C6602".equals(x.DEVICE)) || ("C6603".equals(x.DEVICE)) || ("C6606".equals(x.DEVICE)) || ("C6616".equals(x.DEVICE)) || ("L36h".equals(x.DEVICE)) || ("SO-02E".equals(x.DEVICE)))) {
                break label1131;
              }
              if ((x.SDK_INT == 16) && ("OMX.qcom.audio.decoder.aac".equals(str2)) && (("C1504".equals(x.DEVICE)) || ("C1505".equals(x.DEVICE)) || ("C1604".equals(x.DEVICE)) || ("C1605".equals(x.DEVICE)))) {
                break label1136;
              }
              if ((x.SDK_INT < 24) && (("OMX.SEC.aac.dec".equals(str2)) || ("OMX.Exynos.AAC.Decoder".equals(str2))) && (x.MANUFACTURER.equals("samsung")) && ((x.DEVICE.startsWith("zeroflte")) || (x.DEVICE.startsWith("zerolte")) || (x.DEVICE.startsWith("zenlte")) || (x.DEVICE.equals("SC-05G")) || (x.DEVICE.equals("marinelteatt")) || (x.DEVICE.equals("404SC")) || (x.DEVICE.equals("SC-04G")) || (x.DEVICE.equals("SCV31")))) {
                break label1141;
              }
              if ((x.SDK_INT <= 19) && ("OMX.SEC.vp8.dec".equals(str2)) && ("samsung".equals(x.MANUFACTURER)) && ((x.DEVICE.startsWith("d2")) || (x.DEVICE.startsWith("serrano")) || (x.DEVICE.startsWith("jflte")) || (x.DEVICE.startsWith("santos")) || (x.DEVICE.startsWith("t0")))) {
                break label1146;
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
          AppMethodBeat.o(95253);
          return localArrayList;
        }
        catch (Exception localException)
        {
          if (x.SDK_INT > 23) {
            break label1054;
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
        parama = new d.b(parama, (byte)0);
        AppMethodBeat.o(95253);
        throw parama;
      }
      label1054:
      AppMethodBeat.o(95253);
      throw localException;
      label1095:
      j += 1;
      continue;
      label1102:
      AppMethodBeat.o(95253);
      return localArrayList;
      label1110:
      int i = 0;
      continue;
      label1115:
      boolean bool1 = true;
      continue;
      label1121:
      i = 0;
      continue;
      label1126:
      i = 0;
      continue;
      label1131:
      i = 0;
      continue;
      label1136:
      i = 0;
      continue;
      label1141:
      i = 0;
      continue;
      label1146:
      i = 0;
    }
  }
  
  public static Pair<Integer, Integer> ar(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(95252);
    if (paramString == null)
    {
      AppMethodBeat.o(95252);
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
        AppMethodBeat.o(95252);
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
      AppMethodBeat.o(95252);
      return null;
    }
    localMatcher = aNv.matcher(paramString[1]);
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(95252);
      return null;
    }
    String str = localMatcher.group(1);
    if ("1".equals(str)) {}
    for (i = 1;; i = 2)
    {
      paramString = (Integer)aNz.get(paramString[3]);
      if (paramString != null) {
        break label304;
      }
      new StringBuilder("Unknown HEVC level string: ").append(localMatcher.group(1));
      AppMethodBeat.o(95252);
      return null;
      if (!"2".equals(str)) {
        break;
      }
    }
    AppMethodBeat.o(95252);
    return null;
    label304:
    paramString = new Pair(Integer.valueOf(i), paramString);
    AppMethodBeat.o(95252);
    return paramString;
    paramString = c(paramString);
    AppMethodBeat.o(95252);
    return paramString;
  }
  
  private static Pair<Integer, Integer> c(String[] paramArrayOfString)
  {
    AppMethodBeat.i(95255);
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(95255);
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
        localInteger2 = Integer.valueOf(aNx.get(localInteger1.intValue()));
        if (localInteger2 != null) {
          break label155;
        }
        new StringBuilder("Unknown AVC profile: ").append(localInteger1);
        AppMethodBeat.o(95255);
        return null;
        if (paramArrayOfString.length < 3) {
          break;
        }
        localInteger1 = Integer.valueOf(Integer.parseInt(paramArrayOfString[1]));
        i = Integer.parseInt(paramArrayOfString[2]);
      }
      AppMethodBeat.o(95255);
      return null;
    }
    catch (NumberFormatException paramArrayOfString)
    {
      AppMethodBeat.o(95255);
      return null;
    }
    label155:
    Integer localInteger1 = Integer.valueOf(aNy.get(paramArrayOfString.intValue()));
    if (localInteger1 == null)
    {
      new StringBuilder("Unknown AVC level: ").append(paramArrayOfString);
      AppMethodBeat.o(95255);
      return null;
    }
    paramArrayOfString = new Pair(localInteger2, localInteger1);
    AppMethodBeat.o(95255);
    return paramArrayOfString;
  }
  
  public static a f(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(95249);
    paramString = g(paramString, paramBoolean);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95249);
      return null;
    }
    paramString = (a)paramString.get(0);
    AppMethodBeat.o(95249);
    return paramString;
  }
  
  private static List<a> g(String paramString, boolean paramBoolean)
  {
    label219:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(95250);
        d.a locala = new d.a(paramString, paramBoolean);
        Object localObject = (List)aNw.get(locala);
        if (localObject != null)
        {
          AppMethodBeat.o(95250);
          paramString = (String)localObject;
          return paramString;
        }
        if (x.SDK_INT >= 21)
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
              if (21 <= x.SDK_INT)
              {
                localObject = localList;
                if (x.SDK_INT <= 23)
                {
                  localObject = a(locala, new d.d((byte)0));
                  if (((List)localObject).isEmpty()) {
                    break label219;
                  }
                  new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(paramString).append(". Assuming: ").append(((a)((List)localObject).get(0)).name);
                  break label219;
                }
              }
            }
          }
          t((List)localObject);
          paramString = Collections.unmodifiableList((List)localObject);
          aNw.put(locala, paramString);
          AppMethodBeat.o(95250);
          continue;
        }
        localObject = new d.d((byte)0);
      }
      finally {}
    }
  }
  
  public static a oH()
  {
    return aNu;
  }
  
  public static int oI()
  {
    int i = 0;
    AppMethodBeat.i(95251);
    int j;
    if (aNA == -1)
    {
      Object localObject = f("video/avc", false);
      if (localObject != null)
      {
        localObject = ((a)localObject).oB();
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
      aNA = i;
      i = aNA;
      AppMethodBeat.o(95251);
      return i;
    }
  }
  
  private static void t(List<a> paramList)
  {
    int i = 1;
    AppMethodBeat.i(95254);
    if ((x.SDK_INT < 26) && (paramList.size() > 1) && ("OMX.MTK.AUDIO.DECODER.RAW".equals(((a)paramList.get(0)).name))) {
      while (i < paramList.size())
      {
        a locala = (a)paramList.get(i);
        if ("OMX.google.raw.decoder".equals(locala.name))
        {
          paramList.remove(i);
          paramList.add(0, locala);
          AppMethodBeat.o(95254);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(95254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d
 * JD-Core Version:    0.7.0.1
 */