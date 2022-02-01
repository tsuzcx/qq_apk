package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/Atom/Mp4ParserStat;", "", "()V", "ID", "", "TAG", "", "markIncrementParseCost", "", "cost", "markParse", "useLazy", "", "markParseCost", "timeTableLength", "", "plugin-playvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l pEx;
  
  static
  {
    AppMethodBeat.i(175938);
    pEx = new l();
    AppMethodBeat.o(175938);
  }
  
  public static void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(175936);
    Log.i("MicroMsg.Mp4ParserStat", "markParseCost, useLazy:" + paramBoolean + ", cost:" + paramLong + ", timetTableLength:" + paramInt);
    if ((paramLong < 0L) || (paramInt < 0))
    {
      AppMethodBeat.o(175936);
      return;
    }
    int i;
    label106:
    u localu;
    if (paramBoolean)
    {
      h.OAn.p(1290L, 8L, paramLong);
      h.OAn.p(1290L, 9L, 1L);
      if (paramInt < 0) {
        break label256;
      }
      if (paramInt > 30) {
        break label250;
      }
      i = 1;
      if (i == 0) {
        break label289;
      }
      if (!paramBoolean) {
        break label262;
      }
      localu = new u(Integer.valueOf(13), Integer.valueOf(22), Integer.valueOf(23));
    }
    for (;;)
    {
      paramInt = ((Number)localu.bsC).intValue();
      i = ((Number)localu.bsD).intValue();
      j = ((Number)localu.aiuN).intValue();
      h.OAn.p(1290L, paramInt, 1L);
      h.OAn.p(1290L, i, paramLong);
      h.OAn.p(1290L, j, 1L);
      AppMethodBeat.o(175936);
      return;
      h.OAn.p(1290L, 3L, paramLong);
      h.OAn.p(1290L, 4L, 1L);
      break;
      label250:
      i = 0;
      break label106;
      label256:
      i = 0;
      break label106;
      label262:
      localu = new u(Integer.valueOf(13), Integer.valueOf(47), Integer.valueOf(48));
      continue;
      label289:
      if (31 <= paramInt) {
        if (paramInt <= 60) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (paramBoolean)
          {
            localu = new u(Integer.valueOf(14), Integer.valueOf(26), Integer.valueOf(27));
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          localu = new u(Integer.valueOf(14), Integer.valueOf(51), Integer.valueOf(52));
          break;
        }
      }
      if (61 <= paramInt) {
        if (paramInt <= 120) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (paramBoolean)
          {
            localu = new u(Integer.valueOf(15), Integer.valueOf(30), Integer.valueOf(31));
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          localu = new u(Integer.valueOf(15), Integer.valueOf(55), Integer.valueOf(56));
          break;
        }
      }
      if (121 <= paramInt) {
        if (paramInt <= 180) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (paramBoolean)
          {
            localu = new u(Integer.valueOf(16), Integer.valueOf(34), Integer.valueOf(35));
            break;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          localu = new u(Integer.valueOf(16), Integer.valueOf(59), Integer.valueOf(60));
          break;
        }
      }
      if (181 <= paramInt) {
        if (paramInt <= 240) {
          paramInt = j;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          if (paramBoolean)
          {
            localu = new u(Integer.valueOf(17), Integer.valueOf(38), Integer.valueOf(39));
            break;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
          }
          localu = new u(Integer.valueOf(17), Integer.valueOf(63), Integer.valueOf(64));
          break;
        }
      }
      if (paramBoolean) {
        localu = new u(Integer.valueOf(18), Integer.valueOf(43), Integer.valueOf(44));
      } else {
        localu = new u(Integer.valueOf(18), Integer.valueOf(67), Integer.valueOf(68));
      }
    }
  }
  
  public static void hF(boolean paramBoolean)
  {
    AppMethodBeat.i(175935);
    Log.i("MicroMsg.Mp4ParserStat", s.X("markParse, useLazy:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      h.OAn.p(1290L, 0L, 1L);
      AppMethodBeat.o(175935);
      return;
    }
    h.OAn.p(1290L, 1L, 1L);
    AppMethodBeat.o(175935);
  }
  
  public static void jl(long paramLong)
  {
    AppMethodBeat.i(175937);
    Log.i("MicroMsg.Mp4ParserStat", s.X("markIncrementParseCost:", Long.valueOf(paramLong)));
    if (paramLong >= 0L)
    {
      h.OAn.p(1290L, 72L, paramLong);
      h.OAn.p(1290L, 73L, 1L);
    }
    AppMethodBeat.o(175937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.l
 * JD-Core Version:    0.7.0.1
 */