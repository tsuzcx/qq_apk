package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class f$f
  extends a
{
  private int count;
  
  public f$f(f paramf, int paramInt)
  {
    this.count = paramInt;
  }
  
  private static String x(String[] paramArrayOfString)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 300)
    {
      localStringBuffer.append(paramArrayOfString[localRandom.nextInt(paramArrayOfString.length - 1)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final boolean execute()
  {
    Object localObject;
    if (this.kzE.kzC == null)
    {
      localObject = e.bP("/sdcard/test_insert_msg_words.txt");
      this.kzE.kzC = ((String)localObject).split(",");
    }
    if (this.kzE.kzD == null)
    {
      this.kzE.kzD = new ArrayList();
      localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().cun();
      while (((Cursor)localObject).moveToNext()) {
        this.kzE.kzD.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    if (this.kzE.kzC != null)
    {
      int i = 0;
      while (i < this.count)
      {
        localObject = x(this.kzE.kzC);
        bi localbi = new bi();
        localbi.setType(1);
        localbi.fA(1);
        localbi.setStatus(4);
        localbi.setContent((String)localObject);
        List localList = this.kzE.kzD;
        localbi.ec((String)localList.get(new Random().nextInt(localList.size() - 1)));
        localbi.bg(System.currentTimeMillis() - 250327040L);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
        y.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(((String)localObject).length()), Long.valueOf(localbi.field_msgId) });
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f.f
 * JD-Core Version:    0.7.0.1
 */