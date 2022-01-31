package com.tencent.mm.cf;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i
{
  private am byQ = new am(Looper.getMainLooper(), new am.a()
  {
    public final boolean tC()
    {
      if (!i.this.uEc.isOpen()) {
        return false;
      }
      i.this.cxh();
      return false;
    }
  }, false);
  private String table = null;
  h uEc;
  private BlockingQueue<a> uEw = new LinkedBlockingQueue();
  
  public i(h paramh, String paramString)
  {
    this.uEc = paramh;
    this.table = paramString;
  }
  
  final int a(a parama)
  {
    this.uEw.add(parama);
    if (this.uEw.size() >= 40) {
      cxh();
    }
    if (this.byQ.crl()) {
      this.byQ.S(60000L, 60000L);
    }
    return 0;
  }
  
  public final int cxh()
  {
    y.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.uEc.inTransaction()), Integer.valueOf(this.uEw.size()) });
    if (this.uEw.isEmpty()) {
      return 0;
    }
    long l;
    if (!this.uEc.inTransaction()) {
      l = this.uEc.eV(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (!this.uEw.isEmpty())
      {
        a locala = (a)this.uEw.poll();
        if (locala == null) {
          y.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.table });
        } else if ((this.uEc == null) || (!this.uEc.isOpen())) {
          y.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
        } else if (locala.uhL == 2) {
          this.uEc.insert(this.table, locala.ujM, locala.values);
        } else if (locala.uhL == 5) {
          this.uEc.delete(this.table, locala.uEy, locala.uEz);
        } else if (locala.uhL == 1) {
          this.uEc.gk(this.table, locala.sql);
        } else if (locala.uhL == 4) {
          this.uEc.replace(this.table, locala.ujM, locala.values);
        } else if (locala.uhL == 3) {
          this.uEc.update(this.table, locala.values, locala.uEy, locala.uEz);
        }
      }
      else
      {
        if (l <= 0L) {
          break;
        }
        this.uEc.hI(l);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public String sql;
    public String uEy;
    public String[] uEz;
    public int uhL;
    public String ujM;
    public ContentValues values;
    
    public final void K(String[] paramArrayOfString)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {}
      for (;;)
      {
        return;
        this.uEz = new String[paramArrayOfString.length];
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          this.uEz[i] = new String(paramArrayOfString[i]);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.i
 * JD-Core Version:    0.7.0.1
 */