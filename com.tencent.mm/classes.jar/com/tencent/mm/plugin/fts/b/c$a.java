package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class c$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long hls = 9223372036854775807L;
  private int mFailedCount = 0;
  private HashSet<Pair<Long, Long>> mUW = null;
  private ArrayList<Long> mUX = null;
  private int mUY = 0;
  private int muO = 0;
  private int muP = 0;
  
  private c$a(c paramc) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(136747);
    String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.muO), Integer.valueOf(this.muP), Integer.valueOf(this.mFailedCount) });
    AppMethodBeat.o(136747);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136746);
    this.hls = this.mUU.mUM.mQr.L(-200L, 9223372036854775807L);
    ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.hls);
    long l1;
    long l2;
    if (this.mUW == null)
    {
      this.mUW = new HashSet();
      this.mUX = new ArrayList();
      localObject1 = this.mUU.mUM.a(com.tencent.mm.plugin.fts.a.c.mQA, true, true, false, true, true);
      while (((Cursor)localObject1).moveToNext())
      {
        l1 = ((Cursor)localObject1).getLong(0);
        l2 = ((Cursor)localObject1).getLong(1);
        long l3 = ((Cursor)localObject1).getLong(2);
        if (((Cursor)localObject1).getInt(3) == -1) {
          this.mUX.add(Long.valueOf(l1));
        } else if (l3 <= this.hls) {
          this.mUW.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
        }
      }
      ((Cursor)localObject1).close();
    }
    if (Thread.interrupted())
    {
      localObject1 = new InterruptedException();
      AppMethodBeat.o(136746);
      throw ((Throwable)localObject1);
    }
    int i = 2147483647;
    Object localObject1 = new String[2];
    Object localObject2 = new ArrayList();
    if (i >= 50)
    {
      localObject1[0] = Long.toString(this.hls);
      localObject1[1] = Integer.toString(this.mUY);
      Object localObject3 = this.mUU.muH.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
      l1 = 0L;
      i = 0;
      c.d locald;
      while (((Cursor)localObject3).moveToNext())
      {
        locald = new c.d(this.mUU, (byte)0);
        locald.cpO = ((Cursor)localObject3).getLong(0);
        locald.talker = ((Cursor)localObject3).getString(1);
        locald.createTime = ((Cursor)localObject3).getLong(2);
        locald.content = ((Cursor)localObject3).getString(3);
        locald.msgType = ((Cursor)localObject3).getInt(4);
        locald.mVc = ((Cursor)localObject3).getInt(5);
        locald.mVb = 41;
        if (c.a(locald))
        {
          locald.bCq();
          if (locald.isAvailable()) {
            ((List)localObject2).add(locald);
          }
        }
        l1 = locald.createTime;
        i += 1;
      }
      ((Cursor)localObject3).close();
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136746);
        throw ((Throwable)localObject1);
      }
      int j = ((List)localObject2).size();
      if (j == 0)
      {
        ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[] { Integer.valueOf(j) });
        if (j <= 0) {
          break label844;
        }
        this.mUU.mUM.beginTransaction();
        localObject3 = ((List)localObject2).iterator();
        label541:
        if (!((Iterator)localObject3).hasNext()) {
          break label787;
        }
        locald = (c.d)((Iterator)localObject3).next();
        l1 = locald.cpO;
        l2 = locald.createTime;
        if (l2 != this.hls) {
          break label773;
        }
      }
      for (this.mUY += 1;; this.mUY = 0)
      {
        for (;;)
        {
          Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
          if (this.mUW.remove(localPair)) {
            break;
          }
          try
          {
            this.mUU.mUM.a(locald.mVb, l1, locald.talker, l2, locald.mVd, locald.mVe);
            this.muO += 1;
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.mVd });
            this.mFailedCount += 1;
          }
        }
        break label541;
        ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).cpO), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).cpO) });
        break;
        label773:
        this.hls = l2;
      }
      label787:
      this.mUU.mUM.commit();
      this.mUU.mUM.M(-200L, this.hls);
      for (;;)
      {
        ((List)localObject2).clear();
        if (!Thread.interrupted()) {
          break;
        }
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136746);
        throw ((Throwable)localObject1);
        label844:
        this.hls = l1;
        this.mUY = 0;
      }
    }
    i = 50;
    localObject1 = this.mUW.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      if (Thread.interrupted())
      {
        this.mUU.mUM.commit();
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136746);
        throw ((Throwable)localObject1);
      }
      if (i < 50) {
        break label1210;
      }
      this.mUU.mUM.commit();
      this.mUU.mUM.beginTransaction();
      i = 0;
    }
    label1207:
    label1210:
    for (;;)
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      this.mUU.mUM.a(com.tencent.mm.plugin.fts.a.c.mQA, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
      i += 1;
      this.muP += 1;
      ((Iterator)localObject1).remove();
      break;
      this.mUU.mUM.commit();
      i = 50;
      localObject1 = this.mUX.listIterator(this.mUX.size());
      if (((ListIterator)localObject1).hasPrevious())
      {
        if (Thread.interrupted())
        {
          this.mUU.mUM.commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(136746);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1207;
        }
        this.mUU.mUM.commit();
        this.mUU.mUM.beginTransaction();
        i = 0;
      }
      for (;;)
      {
        l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
        this.mUU.mUM.g(Long.valueOf(l1));
        i += 1;
        this.muP += 1;
        ((ListIterator)localObject1).remove();
        break;
        this.mUU.mUM.M(-200L, this.hls - 1L);
        this.mUU.mUM.commit();
        this.mUU.mUN = false;
        AppMethodBeat.o(136746);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.a
 * JD-Core Version:    0.7.0.1
 */