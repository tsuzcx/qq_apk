package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  private static f[] hbG;
  
  static
  {
    AppMethodBeat.i(126746);
    hbG = null;
    f[] arrayOff = new f[2];
    hbG = arrayOff;
    arrayOff[0] = new f(0, 120, 540, 960, 30, 1200000, 1200000);
    hbG[1] = new f(120, 300, 360, 640, 24, 544000, 544000);
    AppMethodBeat.o(126746);
  }
  
  public static int a(f[] paramArrayOff, VideoTransPara paramVideoTransPara1, VideoTransPara paramVideoTransPara2)
  {
    AppMethodBeat.i(126745);
    f[] arrayOff;
    if (paramArrayOff != null) {
      arrayOff = paramArrayOff;
    }
    try
    {
      if (paramArrayOff.length <= 0) {
        arrayOff = hbG;
      }
      n = arrayOff.length;
      paramVideoTransPara2.width = paramVideoTransPara1.width;
      paramVideoTransPara2.height = paramVideoTransPara1.height;
      paramVideoTransPara2.fps = paramVideoTransPara1.fps;
      paramVideoTransPara2.videoBitrate = paramVideoTransPara1.videoBitrate;
      paramVideoTransPara2.duration = paramVideoTransPara1.duration;
      if (paramVideoTransPara1.width <= paramVideoTransPara1.height) {
        break label424;
      }
      k = 1;
      if (k == 0) {
        break label430;
      }
      i = paramVideoTransPara1.width;
      label91:
      if (k == 0) {
        break label438;
      }
      j = paramVideoTransPara1.height;
      label102:
      i1 = paramVideoTransPara1.duration;
      if (paramVideoTransPara2.duration < arrayOff[(n - 1)].hcc) {
        break label855;
      }
      if (paramVideoTransPara2.duration >= hbG[1].hcc) {
        break label794;
      }
    }
    catch (Exception paramArrayOff)
    {
      for (;;)
      {
        int k;
        int i1;
        int i2;
        label272:
        label424:
        label430:
        label438:
        label462:
        ad.e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + paramArrayOff.toString());
        label777:
        label794:
        int i = 0;
        continue;
        int n = i;
        i = j;
        int j = n;
        break label982;
        n = i;
        i = j;
        j = n;
        break label899;
        int m = 0;
        continue;
        if (i * i2 > j * i1)
        {
          n = 1;
          continue;
          j = j + 8 >> 4 << 4;
          i = i + 8 >> 4 << 4;
          if (k != 0)
          {
            n = j;
            continue;
          }
        }
        else
        {
          n = 0;
          continue;
        }
        n = i;
        continue;
        i = j;
        continue;
        m += 1;
        continue;
        m = 0;
        continue;
        if (i * i2 > j * i1)
        {
          n = 1;
          continue;
          j = j + 8 >> 4 << 4;
          i = i + 8 >> 4 << 4;
          if (k != 0)
          {
            n = j;
            continue;
          }
        }
        else
        {
          n = 0;
          continue;
        }
        n = i;
        continue;
        i = j;
      }
    }
    if (m < n) {
      if ((i1 >= arrayOff[m].hcb) && (i1 < arrayOff[m].hcc))
      {
        i1 = arrayOff[m].hcd;
        i2 = arrayOff[m].hce;
        if (i <= i1) {
          if (j > i2)
          {
            break label861;
            if (n != 0)
            {
              i = j * i1 / i;
              j = i1;
              break label879;
              paramVideoTransPara2.width = n;
              if (k == 0) {
                break label923;
              }
              paramVideoTransPara2.height = i;
              if (paramVideoTransPara2.fps <= arrayOff[m].hcf) {
                break label462;
              }
              i = arrayOff[m].hcf;
              paramVideoTransPara2.fps = i;
              paramVideoTransPara2.videoBitrate = ((int)((arrayOff[m].hcg * arrayOff[m].hcc + arrayOff[m].hch * paramVideoTransPara2.duration - arrayOff[m].hcg * paramVideoTransPara2.duration - arrayOff[m].hch * arrayOff[m].hcb) / (arrayOff[m].hcc - arrayOff[m].hcb) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (arrayOff[m].hcd * arrayOff[m].hce)) * (paramVideoTransPara2.fps + 10) / 40.0D));
              i = paramVideoTransPara2.videoBitrate;
            }
            for (;;)
            {
              AppMethodBeat.o(126745);
              return i;
              k = 0;
              break;
              i = paramVideoTransPara1.height;
              break label91;
              j = paramVideoTransPara1.width;
              break label102;
              j = i * i2 / j;
              i = i2;
              break label879;
              i = paramVideoTransPara2.fps;
              break label272;
              for (;;)
              {
                if (m >= 2) {
                  break label794;
                }
                if ((i1 >= hbG[m].hcb) && (i1 < hbG[m].hcc))
                {
                  i1 = hbG[m].hcd;
                  i2 = hbG[m].hce;
                  if (i > i1) {
                    break label944;
                  }
                  if (j <= i2) {
                    break label829;
                  }
                  break label944;
                  if (n != 0)
                  {
                    i = j * i1 / i;
                    j = i1;
                    break label962;
                    paramVideoTransPara2.width = n;
                    if (k == 0) {
                      break label1006;
                    }
                    paramVideoTransPara2.height = i;
                    if (paramVideoTransPara2.fps <= hbG[m].hcf) {
                      break label777;
                    }
                  }
                  for (i = hbG[m].hcf;; i = paramVideoTransPara2.fps)
                  {
                    paramVideoTransPara2.fps = i;
                    paramVideoTransPara2.videoBitrate = ((int)((hbG[m].hcg * hbG[m].hcc + hbG[m].hch * paramVideoTransPara2.duration - hbG[m].hcg * paramVideoTransPara2.duration - hbG[m].hch * hbG[m].hcb) / (hbG[m].hcc - hbG[m].hcb) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (hbG[m].hcd * hbG[m].hce)) * (paramVideoTransPara2.fps + 10) / 40.0D));
                    i = paramVideoTransPara2.videoBitrate;
                    break;
                    j = i * i2 / j;
                    i = i2;
                    break label962;
                  }
                }
                m += 1;
              }
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.a
 * JD-Core Version:    0.7.0.1
 */