package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class g$g
  extends a
{
  private g$g(g paramg) {}
  
  private static String B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(136805);
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 300)
    {
      localStringBuffer.append(paramArrayOfString[localRandom.nextInt(paramArrayOfString.length - 1)]);
      i += 1;
    }
    paramArrayOfString = localStringBuffer.toString();
    AppMethodBeat.o(136805);
    return paramArrayOfString;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136804);
    Object localObject;
    if (this.mVu.mVs == null)
    {
      localObject = e.cS("/sdcard/test_insert_msg_words.txt");
      this.mVu.mVs = ((String)localObject).split(",");
    }
    if (this.mVu.mVt == null)
    {
      this.mVu.mVt = new ArrayList();
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().dwM();
      while (((Cursor)localObject).moveToNext()) {
        this.mVu.mVt.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    if (this.mVu.mVs != null)
    {
      localObject = new int[7];
      Object tmp131_130 = localObject;
      tmp131_130[0] = 1000;
      Object tmp137_131 = tmp131_130;
      tmp137_131[1] = 2000;
      Object tmp143_137 = tmp137_131;
      tmp143_137[2] = 5000;
      Object tmp149_143 = tmp143_137;
      tmp149_143[3] = 10000;
      Object tmp155_149 = tmp149_143;
      tmp155_149[4] = 20000;
      Object tmp161_155 = tmp155_149;
      tmp161_155[5] = 50000;
      Object tmp166_161 = tmp161_155;
      tmp166_161[6] = 100000;
      tmp166_161;
      int i = 0;
      while (i < 7)
      {
        int j = 0;
        while (j < localObject[i])
        {
          String str = B(this.mVu.mVs);
          bi localbi = new bi();
          localbi.setType(1);
          localbi.hL(1);
          localbi.setStatus(4);
          localbi.setContent(str);
          localbi.kj((String)this.mVu.mVt.get(i));
          localbi.fQ(System.currentTimeMillis());
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z(localbi);
          ab.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject[i]), Integer.valueOf(str.length()), Long.valueOf(localbi.field_msgId) });
          j += 1;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(136804);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.g
 * JD-Core Version:    0.7.0.1
 */