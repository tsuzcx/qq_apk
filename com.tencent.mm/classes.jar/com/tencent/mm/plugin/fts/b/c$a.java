package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class c$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long fRR = 9223372036854775807L;
  private int kas = 0;
  private int kat = 0;
  private HashSet<Pair<Long, Long>> kzg = null;
  private ArrayList<Long> kzh = null;
  private int kzi = 0;
  private int mFailedCount = 0;
  
  private c$a(c paramc) {}
  
  public final String afJ()
  {
    return String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.kas), Integer.valueOf(this.kat), Integer.valueOf(this.mFailedCount) });
  }
  
  public final boolean execute()
  {
    this.fRR = this.kze.kyW.kuE.z(-200L, 9223372036854775807L);
    y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.fRR);
    long l1;
    long l2;
    if (this.kzg == null)
    {
      this.kzg = new HashSet();
      this.kzh = new ArrayList();
      localObject1 = this.kze.kyW.a(com.tencent.mm.plugin.fts.a.c.kuN, true, true, false, true, true);
      while (((Cursor)localObject1).moveToNext())
      {
        l1 = ((Cursor)localObject1).getLong(0);
        l2 = ((Cursor)localObject1).getLong(1);
        long l3 = ((Cursor)localObject1).getLong(2);
        if (((Cursor)localObject1).getInt(3) == -1) {
          this.kzh.add(Long.valueOf(l1));
        } else if (l3 <= this.fRR) {
          this.kzg.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
        }
      }
      ((Cursor)localObject1).close();
    }
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    int i = 2147483647;
    Object localObject1 = new String[2];
    Object localObject2 = new ArrayList();
    while (i >= 50)
    {
      localObject1[0] = Long.toString(this.fRR);
      localObject1[1] = Integer.toString(this.kzi);
      Object localObject3 = this.kze.kal.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
      i = 0;
      c.f localf;
      while (((Cursor)localObject3).moveToNext())
      {
        localf = new c.f(this.kze, (byte)0);
        localf.bIt = ((Cursor)localObject3).getLong(0);
        localf.talker = ((Cursor)localObject3).getString(1);
        localf.createTime = ((Cursor)localObject3).getLong(2);
        localf.content = ((Cursor)localObject3).getString(3);
        localf.msgType = ((Cursor)localObject3).getInt(4);
        localf.kzm = ((Cursor)localObject3).getInt(5);
        localf.kzl = 41;
        if (c.a(localf))
        {
          localf.aVN();
          if (localf.isAvailable()) {
            ((List)localObject2).add(localf);
          }
        }
        i += 1;
      }
      ((Cursor)localObject3).close();
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      int j = ((List)localObject2).size();
      if (j == 0)
      {
        y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[] { Integer.valueOf(j) });
        if (j <= 0) {
          break label783;
        }
        this.kze.kyW.beginTransaction();
        localObject3 = ((List)localObject2).iterator();
        label510:
        if (!((Iterator)localObject3).hasNext()) {
          break label756;
        }
        localf = (c.f)((Iterator)localObject3).next();
        l1 = localf.bIt;
        l2 = localf.createTime;
        if (l2 != this.fRR) {
          break label742;
        }
      }
      for (this.kzi += 1;; this.kzi = 0)
      {
        for (;;)
        {
          Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
          if (this.kzg.remove(localPair)) {
            break;
          }
          try
          {
            this.kze.kyW.a(localf.kzl, l1, localf.talker, l2, localf.kzn, localf.kzo);
            this.kas += 1;
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { localf.kzn });
            this.mFailedCount += 1;
          }
        }
        break label510;
        y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", new Object[] { Integer.valueOf(j), Long.valueOf(((c.f)((List)localObject2).get(0)).bIt), Long.valueOf(((c.f)((List)localObject2).get(j - 1)).bIt) });
        break;
        label742:
        this.fRR = l2;
      }
      label756:
      this.kze.kyW.commit();
      this.kze.kyW.A(-200L, this.fRR);
      label783:
      ((List)localObject2).clear();
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
    }
    i = 50;
    localObject1 = this.kzg.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      if (Thread.interrupted())
      {
        this.kze.kyW.commit();
        throw new InterruptedException();
      }
      if (i < 50) {
        break label1134;
      }
      this.kze.kyW.commit();
      this.kze.kyW.beginTransaction();
      i = 0;
    }
    label1131:
    label1134:
    for (;;)
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      this.kze.kyW.a(com.tencent.mm.plugin.fts.a.c.kuN, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
      i += 1;
      this.kat += 1;
      ((Iterator)localObject1).remove();
      break;
      this.kze.kyW.commit();
      i = 50;
      localObject1 = this.kzh.listIterator(this.kzh.size());
      if (((ListIterator)localObject1).hasPrevious())
      {
        if (Thread.interrupted())
        {
          this.kze.kyW.commit();
          throw new InterruptedException();
        }
        if (i < 50) {
          break label1131;
        }
        this.kze.kyW.commit();
        this.kze.kyW.beginTransaction();
        i = 0;
      }
      for (;;)
      {
        l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
        this.kze.kyW.h(Long.valueOf(l1));
        i += 1;
        this.kat += 1;
        ((ListIterator)localObject1).remove();
        break;
        this.kze.kyW.A(-200L, this.fRR - 1L);
        this.kze.kyW.commit();
        this.kze.kyX = false;
        return true;
      }
    }
  }
  
  public final int getId()
  {
    return 4;
  }
  
  public final String getName()
  {
    return "BuildMessageIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.a
 * JD-Core Version:    0.7.0.1
 */