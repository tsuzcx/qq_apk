package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class g$f
  extends a
{
  private int count;
  private String cpf;
  
  public g$f(g paramg, int paramInt, String paramString)
  {
    this.count = paramInt;
    this.cpf = paramString;
  }
  
  private static String B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(136803);
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 300)
    {
      localStringBuffer.append(paramArrayOfString[localRandom.nextInt(paramArrayOfString.length - 1)]);
      i += 1;
    }
    paramArrayOfString = localStringBuffer.toString();
    AppMethodBeat.o(136803);
    return paramArrayOfString;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136802);
    if (this.mVu.mVs == null)
    {
      localObject = e.cS("/sdcard/test_insert_msg_words.txt");
      this.mVu.mVs = ((String)localObject).split(",");
    }
    int i;
    label97:
    String str;
    bi localbi;
    if (this.mVu.mVt == null)
    {
      this.mVu.mVt = new ArrayList();
      if (!bo.isNullOrNil(this.cpf)) {
        this.mVu.mVt.add(this.cpf);
      }
    }
    else
    {
      if (this.mVu.mVs == null) {
        break label364;
      }
      i = 0;
      if (i >= this.count) {
        break label364;
      }
      str = B(this.mVu.mVs);
      localbi = new bi();
      localbi.setType(1);
      localbi.hL(1);
      localbi.setStatus(4);
      localbi.setContent(str);
      localObject = this.mVu.mVt;
      if (((List)localObject).size() <= 1) {
        break label350;
      }
    }
    label350:
    for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
    {
      localbi.kj((String)localObject);
      localbi.fQ(System.currentTimeMillis() - 250327040L);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z(localbi);
      ab.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localbi.field_msgId) });
      i += 1;
      break label97;
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().dwM();
      while (((Cursor)localObject).moveToNext()) {
        this.mVu.mVt.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
      break;
    }
    label364:
    AppMethodBeat.o(136802);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.f
 * JD-Core Version:    0.7.0.1
 */