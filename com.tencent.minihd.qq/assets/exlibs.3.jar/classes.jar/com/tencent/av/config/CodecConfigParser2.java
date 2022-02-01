package com.tencent.av.config;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.av.utils.UITools;
import com.tencent.qav.log.AVLog;

public class CodecConfigParser2
{
  private static final String TAG = "CodecConfigParser";
  private static final String key_async = "sharp/hwcodec_new2/async/";
  private static String key_async_codec = "sharp/hwcodec_new2/async/codec";
  private static String key_async_min_sdk;
  private static final String key_avc_decocoder = "sharp/hwcodec_new2/avc_decoder/";
  private static final String key_avc_encocoder = "sharp/hwcodec_new2/avc_encoder/";
  private static String key_avcdec_bl_fingerprint;
  private static String key_avcdec_bl_model;
  private static String key_avcdec_bl_product;
  private static String key_avcdec_bl_sdk;
  private static String key_avcdec_bl_version;
  private static String key_avcdec_wl_min_version;
  private static String key_avcdec_wl_minsdk;
  private static String key_avcenc_bl_fingerprint;
  private static String key_avcenc_bl_model;
  private static String key_avcenc_bl_product;
  private static String key_avcenc_bl_sdk;
  private static String key_avcenc_bl_version;
  private static String key_avcenc_wl_min_version;
  private static String key_avcenc_wl_minsdk;
  private static final String key_hevc_decocoder = "sharp/hwcodec_new2/hevc_decoder/";
  private static final String key_hevc_encocoder = "sharp/hwcodec_new2/hevc_encoder/";
  private static String key_hevcdec_bl_fingerprint;
  private static String key_hevcdec_bl_model;
  private static String key_hevcdec_bl_product;
  private static String key_hevcdec_bl_sdk;
  private static String key_hevcdec_bl_version;
  private static String key_hevcdec_wl_min_sdk;
  private static String key_hevcdec_wl_min_version;
  private static String key_hevcenc_bl_fingerprint;
  private static String key_hevcenc_bl_model;
  private static String key_hevcenc_bl_product;
  private static String key_hevcenc_bl_sdk;
  private static String key_hevcenc_bl_version;
  private static String key_hevcenc_wl_min_sdk;
  private static String key_hevcenc_wl_min_version;
  private static final String key_root = "sharp/hwcodec_new2/";
  private static final String key_test = "sharp/hwcodec_new2/test/";
  private static String key_test_async_min_sdk;
  private static String key_test_codec;
  private static String key_test_disable_sdk;
  private static String key_test_min_version;
  private static String key_test_minsdk = null;
  private static final String str_async = "async/";
  private static final String str_async_codec = "codec";
  private static final String str_async_min_sdk = "min_sdk";
  private static final String str_black_list = "black_list/";
  private static final String str_codec = "codec";
  private static final String str_disable_sdk = "disable_sdk";
  private static final String str_fingerprint = "fingerprint";
  private static final String str_min_sdk = "min_sdk";
  private static final String str_min_version = "min_version";
  private static final String str_model = "model";
  private static final String str_product = "product";
  private static final String str_sdk = "sdk";
  private static final String str_test_async_min_sdk = "async_min_sdk";
  private static final String str_version = "version";
  private static final String str_white_list = "white_list/";
  
  static
  {
    key_test_disable_sdk = null;
    key_test_codec = null;
    key_test_async_min_sdk = null;
    key_test_min_version = null;
    key_avcdec_wl_minsdk = null;
    key_avcdec_wl_min_version = null;
    key_avcdec_bl_model = null;
    key_avcdec_bl_product = null;
    key_avcdec_bl_fingerprint = null;
    key_avcdec_bl_sdk = null;
    key_avcdec_bl_version = null;
    key_avcenc_wl_minsdk = null;
    key_avcenc_wl_min_version = null;
    key_avcenc_bl_model = null;
    key_avcenc_bl_product = null;
    key_avcenc_bl_fingerprint = null;
    key_avcenc_bl_sdk = null;
    key_avcenc_bl_version = null;
    key_hevcdec_wl_min_sdk = null;
    key_hevcdec_wl_min_version = null;
    key_hevcdec_bl_model = null;
    key_hevcdec_bl_product = null;
    key_hevcdec_bl_fingerprint = null;
    key_hevcdec_bl_sdk = null;
    key_hevcdec_bl_version = null;
    key_hevcenc_wl_min_sdk = null;
    key_hevcenc_wl_min_version = null;
    key_hevcenc_bl_model = null;
    key_hevcenc_bl_product = null;
    key_hevcenc_bl_fingerprint = null;
    key_hevcenc_bl_sdk = null;
    key_hevcenc_bl_version = null;
    key_async_min_sdk = null;
    key_async_codec = null;
    key_test_minsdk = "sharp/hwcodec_new2/test/min_sdk";
    key_test_disable_sdk = "sharp/hwcodec_new2/test/disable_sdk";
    key_test_codec = "sharp/hwcodec_new2/test/codec";
    key_test_async_min_sdk = "sharp/hwcodec_new2/test/async_min_sdk";
    key_test_min_version = "sharp/hwcodec_new2/test/min_version";
    key_avcdec_wl_minsdk = "sharp/hwcodec_new2/avc_decoder/white_list/min_sdk";
    key_avcdec_wl_min_version = "sharp/hwcodec_new2/avc_decoder/white_list/min_version";
    key_avcdec_bl_model = "sharp/hwcodec_new2/avc_decoder/black_list/model";
    key_avcdec_bl_product = "sharp/hwcodec_new2/avc_decoder/black_list/product";
    key_avcdec_bl_fingerprint = "sharp/hwcodec_new2/avc_decoder/black_list/fingerprint";
    key_avcdec_bl_sdk = "sharp/hwcodec_new2/avc_decoder/black_list/sdk";
    key_avcdec_bl_version = "sharp/hwcodec_new2/avc_decoder/black_list/version";
    key_avcenc_wl_minsdk = "sharp/hwcodec_new2/avc_encoder/white_list/min_sdk";
    key_avcenc_wl_min_version = "sharp/hwcodec_new2/avc_encoder/white_list/min_version";
    key_avcenc_bl_model = "sharp/hwcodec_new2/avc_encoder/black_list/model";
    key_avcenc_bl_product = "sharp/hwcodec_new2/avc_encoder/black_list/product";
    key_avcenc_bl_fingerprint = "sharp/hwcodec_new2/avc_encoder/black_list/fingerprint";
    key_avcenc_bl_sdk = "sharp/hwcodec_new2/avc_encoder/black_list/sdk";
    key_avcenc_bl_version = "sharp/hwcodec_new2/avc_encoder/black_list/version";
    key_hevcdec_wl_min_sdk = "sharp/hwcodec_new2/hevc_decoder/white_list/min_sdk";
    key_hevcdec_wl_min_version = "sharp/hwcodec_new2/hevc_decoder/white_list/min_version";
    key_hevcdec_bl_model = "sharp/hwcodec_new2/hevc_decoder/black_list/model";
    key_hevcdec_bl_product = "sharp/hwcodec_new2/hevc_decoder/black_list/product";
    key_hevcdec_bl_fingerprint = "sharp/hwcodec_new2/hevc_decoder/black_list/fingerprint";
    key_hevcdec_bl_sdk = "sharp/hwcodec_new2/hevc_decoder/black_list/sdk";
    key_hevcdec_bl_version = "sharp/hwcodec_new2/hevc_decoder/black_list/version";
    key_hevcenc_wl_min_sdk = "sharp/hwcodec_new2/hevc_encoder/white_list/min_sdk";
    key_hevcenc_wl_min_version = "sharp/hwcodec_new2/hevc_encoder/white_list/min_version";
    key_hevcenc_bl_model = "sharp/hwcodec_new2/hevc_encoder/black_list/model";
    key_hevcenc_bl_product = "sharp/hwcodec_new2/hevc_encoder/black_list/product";
    key_hevcenc_bl_fingerprint = "sharp/hwcodec_new2/hevc_encoder/black_list/fingerprint";
    key_hevcenc_bl_sdk = "sharp/hwcodec_new2/hevc_encoder/black_list/sdk";
    key_hevcenc_bl_version = "sharp/hwcodec_new2/hevc_encoder/black_list/version";
    key_async_min_sdk = "sharp/hwcodec_new2/async/min_sdk";
  }
  
  private boolean checkQQVer(BaseConfigParser paramBaseConfigParser, String paramString1, String paramString2)
  {
    int j = UITools.getQQVersion();
    if (UITools.strVersionToInt(paramBaseConfigParser.getStringValue(paramString1, "")) > j) {
      return false;
    }
    if (paramString2 != null)
    {
      paramBaseConfigParser = paramBaseConfigParser.getStringValues(paramString2);
      if (paramBaseConfigParser != null)
      {
        int k = paramBaseConfigParser.length;
        int i = 0;
        for (;;)
        {
          if (i >= k) {
            break label72;
          }
          if (UITools.strVersionToInt(paramBaseConfigParser[i]) == j) {
            break;
          }
          i += 1;
        }
      }
    }
    label72:
    return true;
  }
  
  private int[] getIntValues(BaseConfigParser paramBaseConfigParser, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramBaseConfigParser.getIntValues(paramString);
  }
  
  private String[] getStringValues(BaseConfigParser paramBaseConfigParser, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramBaseConfigParser.getStringValues(paramString);
  }
  
  public boolean getAVCDecoderAbility(BaseConfigParser paramBaseConfigParser)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = getIntValues(paramBaseConfigParser, key_avcdec_wl_minsdk);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0]) || (!checkQQVer(paramBaseConfigParser, key_avcdec_wl_min_version, key_avcdec_bl_version))) {
          continue;
        }
        localObject = getIntValues(paramBaseConfigParser, key_avcdec_bl_sdk);
        int i;
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label90;
            }
            if (Build.VERSION.SDK_INT == localObject[i]) {
              break;
            }
            i += 1;
          }
        }
        label90:
        localObject = getStringValues(paramBaseConfigParser, key_avcdec_bl_model);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label134;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label134:
        localObject = getStringValues(paramBaseConfigParser, key_avcdec_bl_product);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label178;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label178:
        paramBaseConfigParser = getStringValues(paramBaseConfigParser, key_avcdec_bl_fingerprint);
        if (paramBaseConfigParser != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= paramBaseConfigParser.length) {
              break label232;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(paramBaseConfigParser[i]);
            if (bool) {
              break;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception paramBaseConfigParser)
      {
        AVLog.d("CodecConfigParser", "getAVCDecoderAbility fail.", paramBaseConfigParser);
        return false;
      }
    }
  }
  
  public boolean getAVCEncoderAbility(BaseConfigParser paramBaseConfigParser)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = getIntValues(paramBaseConfigParser, key_avcenc_wl_minsdk);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0]) || (!checkQQVer(paramBaseConfigParser, key_avcenc_wl_min_version, key_avcenc_bl_version))) {
          continue;
        }
        localObject = getIntValues(paramBaseConfigParser, key_avcenc_bl_sdk);
        int i;
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label90;
            }
            if (Build.VERSION.SDK_INT == localObject[i]) {
              break;
            }
            i += 1;
          }
        }
        label90:
        localObject = getStringValues(paramBaseConfigParser, key_avcenc_bl_model);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label134;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label134:
        localObject = getStringValues(paramBaseConfigParser, key_avcenc_bl_product);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label178;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label178:
        paramBaseConfigParser = getStringValues(paramBaseConfigParser, key_avcenc_bl_fingerprint);
        if (paramBaseConfigParser != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= paramBaseConfigParser.length) {
              break label232;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(paramBaseConfigParser[i]);
            if (bool) {
              break;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception paramBaseConfigParser)
      {
        AVLog.d("CodecConfigParser", "getAVCEncoderAbility fail.", paramBaseConfigParser);
        return false;
      }
    }
  }
  
  public boolean getHevcDecoderAbility(BaseConfigParser paramBaseConfigParser)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = getIntValues(paramBaseConfigParser, key_hevcdec_wl_min_sdk);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0]) || (!checkQQVer(paramBaseConfigParser, key_hevcdec_wl_min_version, key_hevcdec_bl_version))) {
          continue;
        }
        localObject = getIntValues(paramBaseConfigParser, key_hevcdec_bl_sdk);
        int i;
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label90;
            }
            if (Build.VERSION.SDK_INT == localObject[i]) {
              break;
            }
            i += 1;
          }
        }
        label90:
        localObject = getStringValues(paramBaseConfigParser, key_hevcdec_bl_model);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label134;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label134:
        localObject = getStringValues(paramBaseConfigParser, key_hevcdec_bl_product);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label178;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label178:
        paramBaseConfigParser = getStringValues(paramBaseConfigParser, key_hevcdec_bl_fingerprint);
        if (paramBaseConfigParser != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= paramBaseConfigParser.length) {
              break label232;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(paramBaseConfigParser[i]);
            if (bool) {
              break;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception paramBaseConfigParser)
      {
        AVLog.d("CodecConfigParser", "getHevcDecoderAbility fail.", paramBaseConfigParser);
        return false;
      }
    }
  }
  
  public boolean getHevcEncoderAbility(BaseConfigParser paramBaseConfigParser)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = getIntValues(paramBaseConfigParser, key_hevcenc_wl_min_sdk);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0]) || (!checkQQVer(paramBaseConfigParser, key_hevcenc_wl_min_version, key_hevcenc_bl_version))) {
          continue;
        }
        localObject = getIntValues(paramBaseConfigParser, key_hevcenc_bl_sdk);
        int i;
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label90;
            }
            if (Build.VERSION.SDK_INT == localObject[i]) {
              break;
            }
            i += 1;
          }
        }
        label90:
        localObject = getStringValues(paramBaseConfigParser, key_hevcenc_bl_model);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label134;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label134:
        localObject = getStringValues(paramBaseConfigParser, key_hevcenc_bl_product);
        if (localObject != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label178;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        label178:
        paramBaseConfigParser = getStringValues(paramBaseConfigParser, key_hevcenc_bl_fingerprint);
        if (paramBaseConfigParser != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= paramBaseConfigParser.length) {
              break label232;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(paramBaseConfigParser[i]);
            if (bool) {
              break;
            }
            i += 1;
          }
        }
        return true;
      }
      catch (Exception paramBaseConfigParser)
      {
        AVLog.d("CodecConfigParser", "getHevcEncoderAbility fail.", paramBaseConfigParser);
        return false;
      }
    }
  }
  
  public boolean isEnableAsyncApi(BaseConfigParser paramBaseConfigParser, int paramInt)
  {
    try
    {
      int[] arrayOfInt = getIntValues(paramBaseConfigParser, key_async_min_sdk);
      if (arrayOfInt == null) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
      {
        paramBaseConfigParser = getIntValues(paramBaseConfigParser, key_async_codec);
        if (paramBaseConfigParser != null)
        {
          boolean bool = ArrayUtils.contains(paramBaseConfigParser, paramInt);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramBaseConfigParser)
    {
      AVLog.d("CodecConfigParser", "isEnableAsyncApi fail.", paramBaseConfigParser);
    }
    return false;
  }
  
  public static abstract interface TestFlag
  {
    public static final int DISABLE = 0;
    public static final int USE_ASYNC_API = 2;
    public static final int USE_SYNC_API = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.CodecConfigParser2
 * JD-Core Version:    0.7.0.1
 */