package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class e
  implements j
{
  public final ai afJ(String paramString)
  {
    AppMethodBeat.i(52550);
    ai localai2 = ((k)g.ab(k.class)).awB().aNn(paramString);
    ai localai1 = localai2;
    if (localai2 == null)
    {
      localai1 = new ai();
      paramString = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[] { paramString });
      if (paramString.moveToNext())
      {
        localai1.fLJ = paramString.getLong(0);
        localai1.setUsername(paramString.getString(1));
        localai1.qg(paramString.getString(2));
        localai1.qh(paramString.getString(3));
        localai1.qj(paramString.getString(4));
        localai1.jD(paramString.getInt(5));
        localai1.setType(paramString.getInt(6));
        localai1.M(paramString.getBlob(7));
        localai1.qq(paramString.getString(8));
        localai1.jF(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(52550);
    return localai1;
  }
  
  public final boolean afK(String paramString)
  {
    AppMethodBeat.i(52551);
    paramString = i(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[] { paramString });
    try
    {
      boolean bool = paramString.moveToNext();
      return bool;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(52551);
    }
  }
  
  public final long afL(String paramString)
  {
    AppMethodBeat.i(52552);
    paramString = i("SELECT conversationTime FROM rconversation WHERE username=?;", new String[] { paramString });
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.moveToFirst()) {
        l1 = paramString.getLong(0);
      }
    }
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(52552);
    return l1;
  }
  
  public final List<String> afM(String paramString)
  {
    AppMethodBeat.i(52553);
    ArrayList localArrayList = new ArrayList();
    String str = paramString;
    if (paramString.endsWith("")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    if (str.length() == 0)
    {
      AppMethodBeat.o(52553);
      return localArrayList;
    }
    paramString = i(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[] { str }), null);
    while (paramString.moveToNext()) {
      localArrayList.add(paramString.getString(0));
    }
    paramString.close();
    AppMethodBeat.o(52553);
    return localArrayList;
  }
  
  public final Cursor i(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52548);
    g.agS();
    paramString = g.agR().ghH.a(paramString, paramArrayOfString, 2);
    AppMethodBeat.o(52548);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52549);
    g.agS();
    paramString = g.agR().ghH.a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(52549);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.e
 * JD-Core Version:    0.7.0.1
 */