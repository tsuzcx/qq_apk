package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.r;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/Atom/Mp4ParserStat;", "", "()V", "ID", "", "TAG", "", "markIncrementParseCost", "", "cost", "markParse", "useLazy", "", "markParseCost", "timeTableLength", "", "plugin-playvideo_release"})
public final class l
{
  public static final l jQN;
  
  static
  {
    AppMethodBeat.i(175938);
    jQN = new l();
    AppMethodBeat.o(175938);
  }
  
  public static void AS(long paramLong)
  {
    AppMethodBeat.i(175937);
    Log.i("MicroMsg.Mp4ParserStat", "markIncrementParseCost:".concat(String.valueOf(paramLong)));
    if (paramLong >= 0L)
    {
      h.CyF.n(1290L, 72L, paramLong);
      h.CyF.n(1290L, 73L, 1L);
    }
    AppMethodBeat.o(175937);
  }
  
  public static void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(175936);
    Log.i("MicroMsg.Mp4ParserStat", "markParseCost, useLazy:" + paramBoolean + ", cost:" + paramLong + ", timetTableLength:" + paramInt);
    if ((paramLong < 0L) || (paramInt < 0))
    {
      AppMethodBeat.o(175936);
      return;
    }
    label94:
    label100:
    label106:
    label112:
    label119:
    r localr;
    if (paramBoolean)
    {
      h.CyF.n(1290L, 8L, paramLong);
      h.CyF.n(1290L, 9L, 1L);
      if (paramInt >= 0) {
        break label258;
      }
      if (31 <= paramInt) {
        break label322;
      }
      if (61 <= paramInt) {
        break label386;
      }
      if (121 <= paramInt) {
        break label450;
      }
      if (181 <= paramInt) {
        break label515;
      }
      if (!paramBoolean) {
        break label580;
      }
      localr = new r(Integer.valueOf(18), Integer.valueOf(43), Integer.valueOf(44));
    }
    for (;;)
    {
      paramInt = ((Number)localr.first).intValue();
      int i = ((Number)localr.second).intValue();
      int j = ((Number)localr.SWY).intValue();
      h.CyF.n(1290L, paramInt, 1L);
      h.CyF.n(1290L, i, paramLong);
      h.CyF.n(1290L, j, 1L);
      AppMethodBeat.o(175936);
      return;
      h.CyF.n(1290L, 3L, paramLong);
      h.CyF.n(1290L, 4L, 1L);
      break;
      label258:
      if (30 < paramInt) {
        break label94;
      }
      if (paramBoolean)
      {
        localr = new r(Integer.valueOf(13), Integer.valueOf(22), Integer.valueOf(23));
      }
      else
      {
        localr = new r(Integer.valueOf(13), Integer.valueOf(47), Integer.valueOf(48));
        continue;
        label322:
        if (60 < paramInt) {
          break label100;
        }
        if (paramBoolean)
        {
          localr = new r(Integer.valueOf(14), Integer.valueOf(26), Integer.valueOf(27));
        }
        else
        {
          localr = new r(Integer.valueOf(14), Integer.valueOf(51), Integer.valueOf(52));
          continue;
          label386:
          if (120 < paramInt) {
            break label106;
          }
          if (paramBoolean)
          {
            localr = new r(Integer.valueOf(15), Integer.valueOf(30), Integer.valueOf(31));
          }
          else
          {
            localr = new r(Integer.valueOf(15), Integer.valueOf(55), Integer.valueOf(56));
            continue;
            label450:
            if (180 < paramInt) {
              break label112;
            }
            if (paramBoolean)
            {
              localr = new r(Integer.valueOf(16), Integer.valueOf(34), Integer.valueOf(35));
            }
            else
            {
              localr = new r(Integer.valueOf(16), Integer.valueOf(59), Integer.valueOf(60));
              continue;
              label515:
              if (240 < paramInt) {
                break label119;
              }
              if (paramBoolean)
              {
                localr = new r(Integer.valueOf(17), Integer.valueOf(38), Integer.valueOf(39));
              }
              else
              {
                localr = new r(Integer.valueOf(17), Integer.valueOf(63), Integer.valueOf(64));
                continue;
                label580:
                localr = new r(Integer.valueOf(18), Integer.valueOf(67), Integer.valueOf(68));
              }
            }
          }
        }
      }
    }
  }
  
  public static void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(175935);
    Log.i("MicroMsg.Mp4ParserStat", "markParse, useLazy:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      h.CyF.n(1290L, 0L, 1L);
      AppMethodBeat.o(175935);
      return;
    }
    h.CyF.n(1290L, 1L, 1L);
    AppMethodBeat.o(175935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.a.l
 * JD-Core Version:    0.7.0.1
 */