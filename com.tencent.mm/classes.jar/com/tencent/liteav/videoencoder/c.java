package com.tencent.liteav.videoencoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229508);
    if (2 == com.tencent.liteav.basic.d.c.a().d())
    {
      if (!g.a().b("enable_hw_hevc_encode", true)) {
        break label73;
      }
      if (com.tencent.liteav.basic.d.c.a().k())
      {
        if (b(paramInt1, paramInt2, paramInt3))
        {
          TXCLog.i("TXCVideoEncoderUtils", "config hevc switch on!");
          AppMethodBeat.o(229508);
          return true;
        }
      }
      else {
        TXCLog.w("TXCVideoEncoderUtils", "not support hevc encoder: in blacklist!");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(229508);
      return false;
      label73:
      TXCLog.w("TXCVideoEncoderUtils", "local not support hevc encoder");
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229515);
    if (TXCBuild.VersionInt() < 21)
    {
      AppMethodBeat.o(229515);
      return false;
    }
    MediaCodecInfo[] arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
    int k = arrayOfMediaCodecInfo.length;
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = arrayOfMediaCodecInfo[i];
      if (localMediaCodecInfo.isEncoder())
      {
        Object localObject = localMediaCodecInfo.getSupportedTypes();
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          String str = localObject[j];
          if (str.contains("video/hevc"))
          {
            localObject = localMediaCodecInfo.getCapabilitiesForType(str);
            if (localObject == null)
            {
              AppMethodBeat.o(229515);
              return false;
            }
            localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
            if (localObject == null)
            {
              AppMethodBeat.o(229515);
              return false;
            }
            if ((!((MediaCodecInfo.VideoCapabilities)localObject).areSizeAndRateSupported(paramInt1, paramInt2, paramInt3)) || (!((MediaCodecInfo.VideoCapabilities)localObject).areSizeAndRateSupported(paramInt2, paramInt1, paramInt3))) {
              break;
            }
            TXCLog.i("TXCVideoEncoderUtils", "got hevc encoder:%s, type:%s", new Object[] { localMediaCodecInfo.getName(), str });
            AppMethodBeat.o(229515);
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    TXCLog.w("TXCVideoEncoderUtils", "not got hevc encoder");
    AppMethodBeat.o(229515);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.c
 * JD-Core Version:    0.7.0.1
 */