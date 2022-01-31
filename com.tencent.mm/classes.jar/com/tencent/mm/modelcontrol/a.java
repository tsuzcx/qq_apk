package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  private static f[] fzF;
  
  static
  {
    AppMethodBeat.i(50591);
    fzF = null;
    f[] arrayOff = new f[2];
    fzF = arrayOff;
    arrayOff[0] = new f(0, 120, 540, 960, 30, 1200000, 1200000);
    fzF[1] = new f(120, 300, 360, 640, 24, 544000, 544000);
    AppMethodBeat.o(50591);
  }
  
  public static int a(f[] paramArrayOff, VideoTransPara paramVideoTransPara1, VideoTransPara paramVideoTransPara2)
  {
    AppMethodBeat.i(50590);
    f[] arrayOff;
    if (paramArrayOff != null) {
      arrayOff = paramArrayOff;
    }
    try
    {
      if (paramArrayOff.length <= 0) {
        arrayOff = fzF;
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
      if (paramVideoTransPara2.duration < arrayOff[(n - 1)].fAa) {
        break label855;
      }
      if (paramVideoTransPara2.duration >= fzF[1].fAa) {
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
        ab.e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + paramArrayOff.toString());
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
      if ((i1 >= arrayOff[m].fzZ) && (i1 < arrayOff[m].fAa))
      {
        i1 = arrayOff[m].fAb;
        i2 = arrayOff[m].fAc;
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
              if (paramVideoTransPara2.fps <= arrayOff[m].fAd) {
                break label462;
              }
              i = arrayOff[m].fAd;
              paramVideoTransPara2.fps = i;
              paramVideoTransPara2.videoBitrate = ((int)((arrayOff[m].fAe * arrayOff[m].fAa + arrayOff[m].fAf * paramVideoTransPara2.duration - arrayOff[m].fAe * paramVideoTransPara2.duration - arrayOff[m].fAf * arrayOff[m].fzZ) / (arrayOff[m].fAa - arrayOff[m].fzZ) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (arrayOff[m].fAb * arrayOff[m].fAc)) * (paramVideoTransPara2.fps + 10) / 40.0D));
              i = paramVideoTransPara2.videoBitrate;
            }
            for (;;)
            {
              AppMethodBeat.o(50590);
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
                if ((i1 >= fzF[m].fzZ) && (i1 < fzF[m].fAa))
                {
                  i1 = fzF[m].fAb;
                  i2 = fzF[m].fAc;
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
                    if (paramVideoTransPara2.fps <= fzF[m].fAd) {
                      break label777;
                    }
                  }
                  for (i = fzF[m].fAd;; i = paramVideoTransPara2.fps)
                  {
                    paramVideoTransPara2.fps = i;
                    paramVideoTransPara2.videoBitrate = ((int)((fzF[m].fAe * fzF[m].fAa + fzF[m].fAf * paramVideoTransPara2.duration - fzF[m].fAe * paramVideoTransPara2.duration - fzF[m].fAf * fzF[m].fzZ) / (fzF[m].fAa - fzF[m].fzZ) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (fzF[m].fAb * fzF[m].fAc)) * (paramVideoTransPara2.fps + 10) / 40.0D));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.a
 * JD-Core Version:    0.7.0.1
 */