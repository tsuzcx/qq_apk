package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class e
  implements j
{
  public final af aaR(String paramString)
  {
    AppMethodBeat.i(52550);
    af localaf2 = ((k)g.ab(k.class)).apM().aHS(paramString);
    af localaf1 = localaf2;
    if (localaf2 == null)
    {
      localaf1 = new af();
      paramString = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[] { paramString });
      if (paramString.moveToNext())
      {
        localaf1.fId = paramString.getLong(0);
        localaf1.setUsername(paramString.getString(1));
        localaf1.na(paramString.getString(2));
        localaf1.nb(paramString.getString(3));
        localaf1.nd(paramString.getString(4));
        localaf1.jF(paramString.getInt(5));
        localaf1.setType(paramString.getInt(6));
        localaf1.O(paramString.getBlob(7));
        localaf1.nk(paramString.getString(8));
        localaf1.jH(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(52550);
    return localaf1;
  }
  
  public final boolean aaS(String paramString)
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
  
  public final long aaT(String paramString)
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
  
  public final List<String> aaU(String paramString)
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
    g.afC();
    paramString = g.afB().gdb.a(paramString, paramArrayOfString, 2);
    AppMethodBeat.o(52548);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52549);
    g.afC();
    paramString = g.afB().gdb.a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(52549);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.e
 * JD-Core Version:    0.7.0.1
 */