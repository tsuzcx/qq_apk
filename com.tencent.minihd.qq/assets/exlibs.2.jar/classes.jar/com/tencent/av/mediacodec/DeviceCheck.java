package com.tencent.av.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.config.BaseConfigParser;
import com.tencent.av.config.CodecConfigParser2;
import com.tencent.av.config.ConfigManager;
import com.tencent.qav.QavSDK;
import java.util.List;

public class DeviceCheck
{
  private static final String TAG = "DeviceCheck";
  
  private static boolean checkDecoderSupportColorFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean checkEncoderSupportColorFormat(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isAVCDecSupportColorFormats()
  {
    List localList = AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME);
    int i = 0;
    if (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
      if ((localCodecCapabilities == null) || (localCodecCapabilities.colorFormats == null)) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        while (j < localCodecCapabilities.colorFormats.length)
        {
          if (checkDecoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
            return true;
          }
          j += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean isAVCDecWhitelistDevices()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 4")) && (Build.PRODUCT.equalsIgnoreCase("occam")) && (Build.VERSION.SDK_INT >= 21)) {
      bool1 = isAVCDecSupportColorFormats();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 5")) && (Build.PRODUCT.equalsIgnoreCase("hammerhead"))) {
              return isAVCDecSupportColorFormats();
            }
            if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500")) && (Build.VERSION.SDK_INT > 18)) {
              return isAVCDecSupportColorFormats();
            }
            if ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 3"))) {
              break;
            }
            bool1 = bool2;
          } while (Build.PRODUCT.equalsIgnoreCase("pisces"));
          if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("LG-D802"))) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4 Pro"))) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M353")) && (Build.PRODUCT.equalsIgnoreCase("meizu_mx3"))) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("m1 note")) && (Build.PRODUCT.equalsIgnoreCase("m1 note"))) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9005")) && (Build.VERSION.SDK_INT > 18)) {
            return true;
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9006V")) && (Build.VERSION.SDK_INT > 18)) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("smartisan")) && (Build.MODEL.equalsIgnoreCase("SM705")) && (Build.PRODUCT.equalsIgnoreCase("msm8974sfo_lte"))) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
            return isAVCDecSupportColorFormats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("HM 1SC")) && (Build.PRODUCT.equalsIgnoreCase("armani"))) {
            return isAVCDecSupportColorFormats();
          }
          bool1 = bool2;
        } while (!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"));
        bool1 = bool2;
      } while (!Build.MODEL.equalsIgnoreCase("HM NOTE 1TD"));
      bool1 = bool2;
    } while (!Build.PRODUCT.equalsIgnoreCase("Icsh92_wet_tdd"));
    return false;
  }
  
  public static boolean isAVCEncSupportColorFormats()
  {
    List localList = AndroidCodec.getEncoderInfos(AndroidCodec.AVC_CODEC_MIME);
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
      if (localCodecCapabilities != null)
      {
        int j = 0;
        while (j < localCodecCapabilities.colorFormats.length)
        {
          if (checkEncoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isAVCEncWhitelistDevices()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return isAVCEncSupportColorFormats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return isAVCEncSupportColorFormats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) && (Build.PRODUCT.equalsIgnoreCase("virgo"))) {
        return isAVCEncSupportColorFormats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("asus")) && (Build.MODEL.equalsIgnoreCase("ASUS_Z00ADA")) && (Build.PRODUCT.equalsIgnoreCase("CN_Z00A"))) {
        return isAVCEncSupportColorFormats();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 4W")) || (!Build.PRODUCT.equalsIgnoreCase("cancro_wc_lte")));
    return isAVCEncSupportColorFormats();
  }
  
  public static boolean isHevcDecSupportColorFormats()
  {
    List localList = AndroidCodec.getDecoderInfos(AndroidCodec.HEVC_CODEC_MIME);
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.HEVC_CODEC_MIME);
      if ((localCodecCapabilities == null) || (localCodecCapabilities.colorFormats == null)) {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkDecoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isHevcEncSupportColorFormats()
  {
    List localList = AndroidCodec.getEncoderInfos(AndroidCodec.HEVC_CODEC_MIME);
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.HEVC_CODEC_MIME);
      if (localCodecCapabilities == null) {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkEncoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isSupportAsyncAPI()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    BaseConfigParser localBaseConfigParser;
    CodecConfigParser2 localCodecConfigParser2;
    do
    {
      return false;
      localBaseConfigParser = ConfigManager.getInstance(QavSDK.getInstance().getContext()).getParser();
      localCodecConfigParser2 = new CodecConfigParser2();
    } while ((!localCodecConfigParser2.getAVCEncoderAbility(localBaseConfigParser)) || (!localCodecConfigParser2.isEnableAsyncApi(localBaseConfigParser, 2)) || (!localCodecConfigParser2.getAVCDecoderAbility(localBaseConfigParser)) || (!localCodecConfigParser2.isEnableAsyncApi(localBaseConfigParser, 1)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.mediacodec.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */