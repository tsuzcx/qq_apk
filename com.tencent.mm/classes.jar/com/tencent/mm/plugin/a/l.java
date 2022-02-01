package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.t;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/Atom/Mp4ParserStat;", "", "()V", "ID", "", "TAG", "", "markIncrementParseCost", "", "cost", "markParse", "useLazy", "", "markParseCost", "timeTableLength", "", "plugin-playvideo_release"})
public final class l
{
  public static final l iTT;
  
  static
  {
    AppMethodBeat.i(175938);
    iTT = new l();
    AppMethodBeat.o(175938);
  }
  
  public static void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(175936);
    ae.i("MicroMsg.Mp4ParserStat", "markParseCost, useLazy:" + paramBoolean + ", cost:" + paramLong + ", timetTableLength:" + paramInt);
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
    t localt;
    if (paramBoolean)
    {
      g.yxI.n(1290L, 8L, paramLong);
      g.yxI.n(1290L, 9L, 1L);
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
      localt = new t(Integer.valueOf(18), Integer.valueOf(43), Integer.valueOf(44));
    }
    for (;;)
    {
      paramInt = ((Number)localt.first).intValue();
      int i = ((Number)localt.second).intValue();
      int j = ((Number)localt.Nho).intValue();
      g.yxI.n(1290L, paramInt, 1L);
      g.yxI.n(1290L, i, paramLong);
      g.yxI.n(1290L, j, 1L);
      AppMethodBeat.o(175936);
      return;
      g.yxI.n(1290L, 3L, paramLong);
      g.yxI.n(1290L, 4L, 1L);
      break;
      label258:
      if (30 < paramInt) {
        break label94;
      }
      if (paramBoolean)
      {
        localt = new t(Integer.valueOf(13), Integer.valueOf(22), Integer.valueOf(23));
      }
      else
      {
        localt = new t(Integer.valueOf(13), Integer.valueOf(47), Integer.valueOf(48));
        continue;
        label322:
        if (60 < paramInt) {
          break label100;
        }
        if (paramBoolean)
        {
          localt = new t(Integer.valueOf(14), Integer.valueOf(26), Integer.valueOf(27));
        }
        else
        {
          localt = new t(Integer.valueOf(14), Integer.valueOf(51), Integer.valueOf(52));
          continue;
          label386:
          if (120 < paramInt) {
            break label106;
          }
          if (paramBoolean)
          {
            localt = new t(Integer.valueOf(15), Integer.valueOf(30), Integer.valueOf(31));
          }
          else
          {
            localt = new t(Integer.valueOf(15), Integer.valueOf(55), Integer.valueOf(56));
            continue;
            label450:
            if (180 < paramInt) {
              break label112;
            }
            if (paramBoolean)
            {
              localt = new t(Integer.valueOf(16), Integer.valueOf(34), Integer.valueOf(35));
            }
            else
            {
              localt = new t(Integer.valueOf(16), Integer.valueOf(59), Integer.valueOf(60));
              continue;
              label515:
              if (240 < paramInt) {
                break label119;
              }
              if (paramBoolean)
              {
                localt = new t(Integer.valueOf(17), Integer.valueOf(38), Integer.valueOf(39));
              }
              else
              {
                localt = new t(Integer.valueOf(17), Integer.valueOf(63), Integer.valueOf(64));
                continue;
                label580:
                localt = new t(Integer.valueOf(18), Integer.valueOf(67), Integer.valueOf(68));
              }
            }
          }
        }
      }
    }
  }
  
  public static void fm(boolean paramBoolean)
  {
    AppMethodBeat.i(175935);
    ae.i("MicroMsg.Mp4ParserStat", "markParse, useLazy:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      g.yxI.n(1290L, 0L, 1L);
      AppMethodBeat.o(175935);
      return;
    }
    g.yxI.n(1290L, 1L, 1L);
    AppMethodBeat.o(175935);
  }
  
  public static void sN(long paramLong)
  {
    AppMethodBeat.i(175937);
    ae.i("MicroMsg.Mp4ParserStat", "markIncrementParseCost:".concat(String.valueOf(paramLong)));
    if (paramLong >= 0L)
    {
      g.yxI.n(1290L, 72L, paramLong);
      g.yxI.n(1290L, 73L, 1L);
    }
    AppMethodBeat.o(175937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.l
 * JD-Core Version:    0.7.0.1
 */