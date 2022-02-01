package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static g[] oBw;
  
  static
  {
    AppMethodBeat.i(126746);
    oBw = null;
    g[] arrayOfg = new g[2];
    oBw = arrayOfg;
    arrayOfg[0] = new g(0, 120, 540, 960, 30, 1200000, 1200000);
    oBw[1] = new g(120, 300, 360, 640, 24, 544000, 544000);
    AppMethodBeat.o(126746);
  }
  
  public static int a(g[] paramArrayOfg, VideoTransPara paramVideoTransPara1, VideoTransPara paramVideoTransPara2)
  {
    AppMethodBeat.i(126745);
    g[] arrayOfg;
    if (paramArrayOfg != null) {
      arrayOfg = paramArrayOfg;
    }
    try
    {
      if (paramArrayOfg.length <= 0) {
        arrayOfg = oBw;
      }
      n = arrayOfg.length;
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
      if (paramVideoTransPara2.duration < arrayOfg[(n - 1)].oBT) {
        break label855;
      }
      if (paramVideoTransPara2.duration >= oBw[1].oBT) {
        break label794;
      }
    }
    catch (Exception paramArrayOfg)
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
        Log.e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + paramArrayOfg.toString());
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
      if ((i1 >= arrayOfg[m].oBS) && (i1 < arrayOfg[m].oBT))
      {
        i1 = arrayOfg[m].oBU;
        i2 = arrayOfg[m].oBV;
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
              if (paramVideoTransPara2.fps <= arrayOfg[m].oBW) {
                break label462;
              }
              i = arrayOfg[m].oBW;
              paramVideoTransPara2.fps = i;
              paramVideoTransPara2.videoBitrate = ((int)((arrayOfg[m].oBX * arrayOfg[m].oBT + arrayOfg[m].oBY * paramVideoTransPara2.duration - arrayOfg[m].oBX * paramVideoTransPara2.duration - arrayOfg[m].oBY * arrayOfg[m].oBS) / (arrayOfg[m].oBT - arrayOfg[m].oBS) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (arrayOfg[m].oBU * arrayOfg[m].oBV)) * (paramVideoTransPara2.fps + 10) / 40.0D));
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
                if ((i1 >= oBw[m].oBS) && (i1 < oBw[m].oBT))
                {
                  i1 = oBw[m].oBU;
                  i2 = oBw[m].oBV;
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
                    if (paramVideoTransPara2.fps <= oBw[m].oBW) {
                      break label777;
                    }
                  }
                  for (i = oBw[m].oBW;; i = paramVideoTransPara2.fps)
                  {
                    paramVideoTransPara2.fps = i;
                    paramVideoTransPara2.videoBitrate = ((int)((oBw[m].oBX * oBw[m].oBT + oBw[m].oBY * paramVideoTransPara2.duration - oBw[m].oBX * paramVideoTransPara2.duration - oBw[m].oBY * oBw[m].oBS) / (oBw[m].oBT - oBw[m].oBS) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (oBw[m].oBU * oBw[m].oBV)) * (paramVideoTransPara2.fps + 10) / 40.0D));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.a
 * JD-Core Version:    0.7.0.1
 */