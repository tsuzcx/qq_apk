package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bg
{
  private static final Queue<Integer> fmX;
  private static final long[] fmY;
  private static final int[] fmZ;
  private static final int[] fna;
  
  static
  {
    AppMethodBeat.i(59923);
    fmX = new ConcurrentLinkedQueue();
    fmY = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    fmZ = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    fna = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    AppMethodBeat.o(59923);
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(59922);
    if (paramString == null)
    {
      AppMethodBeat.o(59922);
      return;
    }
    int i;
    long l1;
    try
    {
      Object localObject = r.Zn();
      if (localObject != null)
      {
        bool = ((String)localObject).equals(paramString);
        if (bool)
        {
          AppMethodBeat.o(59922);
          return;
        }
      }
      localObject = ((j)g.E(j.class)).YA().arw(paramString);
      if (paramString.endsWith("@chatroom"))
      {
        i = ((aq)localObject).dqK;
        if (i == 0)
        {
          AppMethodBeat.o(59922);
          return;
        }
        ab.i("MicroMsg.MsgReporter", "[oneliang]it is a normal chatroom? username:%s", new Object[] { paramString });
      }
      do
      {
        l1 = cb.abp();
        if (l1 > 0L) {
          break label210;
        }
        ab.i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
        AppMethodBeat.o(59922);
        return;
        if ((t.oA(paramString)) || (ad.arc(paramString)) || (ad.are(paramString)) || (t.ow(paramString)) || (ad.nM(paramString))) {
          break;
        }
        bool = ((ad)localObject).dwz();
      } while (!bool);
      AppMethodBeat.o(59922);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MsgReporter", "[oneliang]something about contact has exception:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(59922);
      return;
    }
    label210:
    long l2 = System.currentTimeMillis();
    long l3 = l1 - paramLong2;
    ab.i("MicroMsg.MsgReporter", "[oneliang]current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong2), Long.valueOf(l3), paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt) });
    boolean bool = a.gO(paramLong2);
    if (bool)
    {
      e.qrI.idkeyStat(780L, 100L, 1L, false);
      i = fmY.length - 1;
      label308:
      if (i >= 0)
      {
        if (l3 < fmY[i]) {
          break label464;
        }
        if (!bool) {
          break label443;
        }
        e.qrI.idkeyStat(780L, fmZ[i], 1L, false);
        label348:
        if (l3 >= 2000L) {
          a.a(l1, l2, paramLong2, l3, paramLong1);
        }
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(59922);
      return;
      e.qrI.idkeyStat(780L, 101L, 1L, false);
      break;
      label443:
      e.qrI.idkeyStat(780L, fna[i], 1L, false);
      break label348;
      label464:
      i -= 1;
      break label308;
      if (l3 >= 60000L)
      {
        if (bool)
        {
          e.qrI.idkeyStat(780L, 113L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        e.qrI.idkeyStat(780L, 118L, 1L, false);
        AppMethodBeat.o(59922);
        return;
      }
      if (l3 >= 30000L)
      {
        if (bool)
        {
          e.qrI.idkeyStat(780L, 112L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        e.qrI.idkeyStat(780L, 117L, 1L, false);
        AppMethodBeat.o(59922);
        return;
      }
      if (l3 >= 10000L)
      {
        if (bool)
        {
          e.qrI.idkeyStat(780L, 111L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        e.qrI.idkeyStat(780L, 116L, 1L, false);
        AppMethodBeat.o(59922);
        return;
      }
      if (l3 >= 0L)
      {
        if (bool)
        {
          e.qrI.idkeyStat(780L, 110L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        e.qrI.idkeyStat(780L, 115L, 1L, false);
        AppMethodBeat.o(59922);
        return;
        if (l3 >= 60000L)
        {
          if (bool)
          {
            e.qrI.idkeyStat(780L, 123L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          e.qrI.idkeyStat(780L, 128L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        if (l3 >= 30000L)
        {
          if (bool)
          {
            e.qrI.idkeyStat(780L, 122L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          e.qrI.idkeyStat(780L, 127L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        if (l3 >= 10000L)
        {
          if (bool)
          {
            e.qrI.idkeyStat(780L, 121L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          e.qrI.idkeyStat(780L, 126L, 1L, false);
          AppMethodBeat.o(59922);
          return;
        }
        if (l3 >= 0L)
        {
          if (bool)
          {
            e.qrI.idkeyStat(780L, 120L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          e.qrI.idkeyStat(780L, 125L, 1L, false);
          AppMethodBeat.o(59922);
          return;
          if (l3 >= 60000L)
          {
            if (bool)
            {
              e.qrI.idkeyStat(780L, 133L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            e.qrI.idkeyStat(780L, 138L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          if (l3 >= 30000L)
          {
            if (bool)
            {
              e.qrI.idkeyStat(780L, 132L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            e.qrI.idkeyStat(780L, 137L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          if (l3 >= 10000L)
          {
            if (bool)
            {
              e.qrI.idkeyStat(780L, 131L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            e.qrI.idkeyStat(780L, 136L, 1L, false);
            AppMethodBeat.o(59922);
            return;
          }
          if (l3 >= 0L)
          {
            if (bool)
            {
              e.qrI.idkeyStat(780L, 130L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            e.qrI.idkeyStat(780L, 135L, 1L, false);
            AppMethodBeat.o(59922);
            return;
            if (l3 >= 60000L)
            {
              if (bool)
              {
                e.qrI.idkeyStat(780L, 143L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              e.qrI.idkeyStat(780L, 148L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            if (l3 >= 30000L)
            {
              if (bool)
              {
                e.qrI.idkeyStat(780L, 142L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              e.qrI.idkeyStat(780L, 147L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            if (l3 >= 10000L)
            {
              if (bool)
              {
                e.qrI.idkeyStat(780L, 141L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              e.qrI.idkeyStat(780L, 146L, 1L, false);
              AppMethodBeat.o(59922);
              return;
            }
            if (l3 >= 0L)
            {
              if (bool)
              {
                e.qrI.idkeyStat(780L, 140L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              e.qrI.idkeyStat(780L, 145L, 1L, false);
              AppMethodBeat.o(59922);
              return;
              if (l3 >= 60000L)
              {
                if (bool)
                {
                  e.qrI.idkeyStat(780L, 153L, 1L, false);
                  AppMethodBeat.o(59922);
                  return;
                }
                e.qrI.idkeyStat(780L, 158L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              if (l3 >= 30000L)
              {
                if (bool)
                {
                  e.qrI.idkeyStat(780L, 152L, 1L, false);
                  AppMethodBeat.o(59922);
                  return;
                }
                e.qrI.idkeyStat(780L, 157L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              if (l3 >= 10000L)
              {
                if (bool)
                {
                  e.qrI.idkeyStat(780L, 151L, 1L, false);
                  AppMethodBeat.o(59922);
                  return;
                }
                e.qrI.idkeyStat(780L, 156L, 1L, false);
                AppMethodBeat.o(59922);
                return;
              }
              if (l3 >= 0L)
              {
                if (bool)
                {
                  e.qrI.idkeyStat(780L, 150L, 1L, false);
                  AppMethodBeat.o(59922);
                  return;
                }
                e.qrI.idkeyStat(780L, 155L, 1L, false);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bg
 * JD-Core Version:    0.7.0.1
 */