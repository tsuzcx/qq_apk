package com.tencent.mm.cg;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i
{
  private ap caS;
  private BlockingQueue<a> queue;
  private String table;
  h yQL;
  
  public i(h paramh, String paramString)
  {
    AppMethodBeat.i(59132);
    this.table = null;
    this.caS = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(59130);
        if (!i.this.yQL.isOpen())
        {
          AppMethodBeat.o(59130);
          return false;
        }
        i.this.dzW();
        AppMethodBeat.o(59130);
        return false;
      }
    }, false);
    this.queue = new LinkedBlockingQueue();
    this.yQL = paramh;
    this.table = paramString;
    AppMethodBeat.o(59132);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(59133);
    if (parama == null)
    {
      ab.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.table });
      AppMethodBeat.o(59133);
      return -2;
    }
    if ((this.yQL == null) || (!this.yQL.isOpen()))
    {
      ab.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
      AppMethodBeat.o(59133);
      return -3;
    }
    if (parama.ypQ == 2) {
      this.yQL.a(this.table, parama.yrL, parama.values);
    }
    for (;;)
    {
      AppMethodBeat.o(59133);
      return 0;
      if (parama.ypQ == 5)
      {
        this.yQL.delete(this.table, parama.yRg, parama.yRh);
      }
      else if (parama.ypQ == 1)
      {
        this.yQL.execSQL(this.table, parama.sql);
      }
      else if (parama.ypQ == 4)
      {
        this.yQL.replace(this.table, parama.yrL, parama.values);
      }
      else
      {
        if (parama.ypQ != 3) {
          break;
        }
        this.yQL.update(this.table, parama.values, parama.yRg, parama.yRh);
      }
    }
    AppMethodBeat.o(59133);
    return -1;
  }
  
  final int b(a parama)
  {
    AppMethodBeat.i(59135);
    this.queue.add(parama);
    if (this.queue.size() >= 40) {
      dzW();
    }
    if (this.caS.dtj()) {
      this.caS.ag(60000L, 60000L);
    }
    AppMethodBeat.o(59135);
    return 0;
  }
  
  public final int dzW()
  {
    AppMethodBeat.i(59134);
    ab.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.yQL.inTransaction()), Integer.valueOf(this.queue.size()) });
    if (this.queue.isEmpty())
    {
      AppMethodBeat.o(59134);
      return 0;
    }
    long l;
    if (!this.yQL.inTransaction()) {
      l = this.yQL.kr(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (!this.queue.isEmpty())
      {
        a((a)this.queue.poll());
      }
      else
      {
        if (l > 0L) {
          this.yQL.nY(l);
        }
        AppMethodBeat.o(59134);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public String sql;
    public ContentValues values;
    public String yRg;
    public String[] yRh;
    public int ypQ;
    public String yrL;
    
    public final void T(String[] paramArrayOfString)
    {
      AppMethodBeat.i(59131);
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
      {
        AppMethodBeat.o(59131);
        return;
      }
      this.yRh = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.yRh[i] = new String(paramArrayOfString[i]);
        i += 1;
      }
      AppMethodBeat.o(59131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.i
 * JD-Core Version:    0.7.0.1
 */