package com.tencent.mm.model;

import com.tencent.mm.am.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class be
{
  private static final Queue<Integer> dWP = new ConcurrentLinkedQueue();
  private static final long[] dWQ = { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
  private static final int[] dWR = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  private static final int[] dWS = { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
  
  public static void a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramString == null) {}
    boolean bool;
    label165:
    long l3;
    label255:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              long l1;
              for (;;)
              {
                return;
                try
                {
                  Object localObject = q.Gj();
                  if ((localObject == null) || (!((String)localObject).equals(paramString)))
                  {
                    localObject = ((j)g.r(j.class)).Fw().abl(paramString);
                    if (paramString.endsWith("@chatroom"))
                    {
                      if (((ao)localObject).cCy != 0) {
                        y.i("MicroMsg.MsgReporter", "[oneliang]it is a normal chatroom? username:%s", new Object[] { paramString });
                      }
                    }
                    else
                    {
                      do
                      {
                        l1 = bz.Is();
                        if (l1 > 0L) {
                          break label165;
                        }
                        y.i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
                        return;
                        if ((s.hR(paramString)) || (ad.aaR(paramString)) || (ad.aaT(paramString)) || (s.hN(paramString)) || (ad.hd(paramString))) {
                          break;
                        }
                        bool = ((ad)localObject).cua();
                      } while (!bool);
                      return;
                    }
                  }
                }
                catch (Exception paramString)
                {
                  y.e("MicroMsg.MsgReporter", "[oneliang]something about contact has exception:%s", new Object[] { paramString.getMessage() });
                  return;
                }
              }
              long l2 = System.currentTimeMillis();
              l3 = l1 - paramLong2;
              y.i("MicroMsg.MsgReporter", "[oneliang]current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong2), Long.valueOf(l3), paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt) });
              bool = a.bT(paramLong2);
              int i;
              if (bool)
              {
                f.nEG.a(780L, 100L, 1L, false);
                i = dWQ.length - 1;
              }
              for (;;)
              {
                if (i >= 0)
                {
                  if (l3 < dWQ[i]) {
                    break label444;
                  }
                  if (!bool) {
                    break label423;
                  }
                  f.nEG.a(780L, dWR[i], 1L, false);
                }
                for (;;)
                {
                  if (l3 >= 2000L) {
                    a.a(l1, l2, paramLong2, l3, paramLong1);
                  }
                  switch (paramInt)
                  {
                  default: 
                    return;
                  case 1: 
                    if (l3 < 60000L) {
                      break label468;
                    }
                    if (!bool) {
                      break label453;
                    }
                    f.nEG.a(780L, 113L, 1L, false);
                    return;
                    f.nEG.a(780L, 101L, 1L, false);
                    break label255;
                    f.nEG.a(780L, dWS[i], 1L, false);
                  }
                }
                i -= 1;
              }
              f.nEG.a(780L, 118L, 1L, false);
              return;
              if (l3 >= 30000L)
              {
                if (bool)
                {
                  f.nEG.a(780L, 112L, 1L, false);
                  return;
                }
                f.nEG.a(780L, 117L, 1L, false);
                return;
              }
              if (l3 >= 10000L)
              {
                if (bool)
                {
                  f.nEG.a(780L, 111L, 1L, false);
                  return;
                }
                f.nEG.a(780L, 116L, 1L, false);
                return;
              }
            } while (l3 < 0L);
            if (bool)
            {
              f.nEG.a(780L, 110L, 1L, false);
              return;
            }
            f.nEG.a(780L, 115L, 1L, false);
            return;
            if (l3 >= 60000L)
            {
              if (bool)
              {
                f.nEG.a(780L, 123L, 1L, false);
                return;
              }
              f.nEG.a(780L, 128L, 1L, false);
              return;
            }
            if (l3 >= 30000L)
            {
              if (bool)
              {
                f.nEG.a(780L, 122L, 1L, false);
                return;
              }
              f.nEG.a(780L, 127L, 1L, false);
              return;
            }
            if (l3 >= 10000L)
            {
              if (bool)
              {
                f.nEG.a(780L, 121L, 1L, false);
                return;
              }
              f.nEG.a(780L, 126L, 1L, false);
              return;
            }
          } while (l3 < 0L);
          if (bool)
          {
            f.nEG.a(780L, 120L, 1L, false);
            return;
          }
          f.nEG.a(780L, 125L, 1L, false);
          return;
          if (l3 >= 60000L)
          {
            if (bool)
            {
              f.nEG.a(780L, 133L, 1L, false);
              return;
            }
            f.nEG.a(780L, 138L, 1L, false);
            return;
          }
          if (l3 >= 30000L)
          {
            if (bool)
            {
              f.nEG.a(780L, 132L, 1L, false);
              return;
            }
            f.nEG.a(780L, 137L, 1L, false);
            return;
          }
          if (l3 >= 10000L)
          {
            if (bool)
            {
              f.nEG.a(780L, 131L, 1L, false);
              return;
            }
            f.nEG.a(780L, 136L, 1L, false);
            return;
          }
        } while (l3 < 0L);
        if (bool)
        {
          f.nEG.a(780L, 130L, 1L, false);
          return;
        }
        f.nEG.a(780L, 135L, 1L, false);
        return;
        if (l3 >= 60000L)
        {
          if (bool)
          {
            f.nEG.a(780L, 143L, 1L, false);
            return;
          }
          f.nEG.a(780L, 148L, 1L, false);
          return;
        }
        if (l3 >= 30000L)
        {
          if (bool)
          {
            f.nEG.a(780L, 142L, 1L, false);
            return;
          }
          f.nEG.a(780L, 147L, 1L, false);
          return;
        }
        if (l3 >= 10000L)
        {
          if (bool)
          {
            f.nEG.a(780L, 141L, 1L, false);
            return;
          }
          f.nEG.a(780L, 146L, 1L, false);
          return;
        }
      } while (l3 < 0L);
      if (bool)
      {
        f.nEG.a(780L, 140L, 1L, false);
        return;
      }
      f.nEG.a(780L, 145L, 1L, false);
      return;
      if (l3 >= 60000L)
      {
        if (bool)
        {
          f.nEG.a(780L, 153L, 1L, false);
          return;
        }
        f.nEG.a(780L, 158L, 1L, false);
        return;
      }
      if (l3 >= 30000L)
      {
        if (bool)
        {
          f.nEG.a(780L, 152L, 1L, false);
          return;
        }
        f.nEG.a(780L, 157L, 1L, false);
        return;
      }
      if (l3 >= 10000L)
      {
        if (bool)
        {
          f.nEG.a(780L, 151L, 1L, false);
          return;
        }
        f.nEG.a(780L, 156L, 1L, false);
        return;
      }
    } while (l3 < 0L);
    label423:
    label444:
    label453:
    label468:
    if (bool)
    {
      f.nEG.a(780L, 150L, 1L, false);
      return;
    }
    f.nEG.a(780L, 155L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.be
 * JD-Core Version:    0.7.0.1
 */