package com.tencent.liteav.videodecoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230824);
    if (a.a())
    {
      AppMethodBeat.o(230824);
      return true;
    }
    boolean bool = b(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(230824);
    return bool;
  }
  
  public static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230826);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(230826);
      return false;
    }
    boolean bool2 = false;
    MediaCodecList localMediaCodecList = new MediaCodecList(0);
    MediaCodecInfo[] arrayOfMediaCodecInfo = localMediaCodecList.getCodecInfos();
    int k = arrayOfMediaCodecInfo.length;
    int i = 0;
    if (i < k)
    {
      Object localObject1 = arrayOfMediaCodecInfo[i];
      Object localObject2 = ((MediaCodecInfo)localObject1).getSupportedTypes();
      bool1 = bool2;
      int m;
      int j;
      if (!((MediaCodecInfo)localObject1).isEncoder())
      {
        m = localObject2.length;
        j = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        boolean bool3;
        if (j < m)
        {
          str = localObject2[j];
          if (!str.contains("video/hevc")) {
            break label335;
          }
          localObject2 = ((MediaCodecInfo)localObject1).getCapabilitiesForType(str);
          bool1 = bool2;
          if (localObject2 != null)
          {
            localObject2 = ((MediaCodecInfo.CodecCapabilities)localObject2).getVideoCapabilities();
            bool1 = bool2;
            if (localObject2 != null)
            {
              bool1 = ((MediaCodecInfo.VideoCapabilities)localObject2).areSizeAndRateSupported(paramInt1, paramInt2, paramInt3);
              bool3 = ((MediaCodecInfo.VideoCapabilities)localObject2).areSizeAndRateSupported(paramInt2, paramInt1, paramInt3);
              TXCLog.i("TXCVideoDecoderUtils", "got hevc decoder:%s, type:%s, supportPort= %b,supportLand=%b", new Object[] { ((MediaCodecInfo)localObject1).getName(), str, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
              if ((!bool3) || (!bool1)) {
                break label234;
              }
              bool1 = true;
            }
          }
        }
        i += 1;
        bool2 = bool1;
        break;
        label234:
        String str = null;
        if (!bool3)
        {
          localObject1 = str;
          if (!bool1) {}
        }
        else
        {
          if (bool3) {
            break label314;
          }
          localObject1 = MediaFormat.createVideoFormat("video/hevc", paramInt2, paramInt1);
        }
        for (;;)
        {
          bool1 = bool2;
          if (localObject1 == null) {
            break;
          }
          localObject1 = localMediaCodecList.findDecoderForFormat((MediaFormat)localObject1);
          TXCLog.i("TXCVideoDecoderUtils", "findDecoderForFormat hevc decodername:%s", new Object[] { localObject1 });
          bool1 = bool2;
          if (localObject1 == null) {
            break;
          }
          bool1 = true;
          break;
          label314:
          localObject1 = str;
          if (!bool1) {
            localObject1 = MediaFormat.createVideoFormat("video/hevc", paramInt1, paramInt2);
          }
        }
        label335:
        j += 1;
      }
    }
    if ((bool2) && (c.a().l())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      TXCLog.i("TXCVideoDecoderUtils", "config hevc decoder switch : " + bool1 + " ,isSupport=" + bool2);
      AppMethodBeat.o(230826);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.e
 * JD-Core Version:    0.7.0.1
 */