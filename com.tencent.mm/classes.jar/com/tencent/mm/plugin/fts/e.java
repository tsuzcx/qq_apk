package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class e
  implements com.tencent.mm.plugin.fts.a.j
{
  public e()
  {
    AppMethodBeat.i(141121);
    AppMethodBeat.o(141121);
  }
  
  public final ad OT(String paramString)
  {
    AppMethodBeat.i(136566);
    ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arq(paramString);
    ad localad1 = localad2;
    if (localad2 == null)
    {
      localad1 = new ad();
      paramString = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[] { paramString });
      if (paramString.moveToNext())
      {
        localad1.euF = paramString.getLong(0);
        localad1.setUsername(paramString.getString(1));
        localad1.jm(paramString.getString(2));
        localad1.jn(paramString.getString(3));
        localad1.jp(paramString.getString(4));
        localad1.hu(paramString.getInt(5));
        localad1.setType(paramString.getInt(6));
        localad1.G(paramString.getBlob(7));
        localad1.jw(paramString.getString(8));
        localad1.hw(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(136566);
    return localad1;
  }
  
  public final boolean OU(String paramString)
  {
    AppMethodBeat.i(136567);
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
      AppMethodBeat.o(136567);
    }
  }
  
  public final long OV(String paramString)
  {
    AppMethodBeat.i(136568);
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
    AppMethodBeat.o(136568);
    return l1;
  }
  
  public final List<String> OW(String paramString)
  {
    AppMethodBeat.i(136569);
    ArrayList localArrayList = new ArrayList();
    String str = paramString;
    if (paramString.endsWith("")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    if (str.length() == 0)
    {
      AppMethodBeat.o(136569);
      return localArrayList;
    }
    paramString = i(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[] { str }), null);
    while (paramString.moveToNext()) {
      localArrayList.add(paramString.getString(0));
    }
    paramString.close();
    AppMethodBeat.o(136569);
    return localArrayList;
  }
  
  public final Cursor i(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(136564);
    g.RM();
    paramString = g.RL().eHT.a(paramString, paramArrayOfString, 2);
    AppMethodBeat.o(136564);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(136565);
    g.RM();
    paramString = g.RL().eHT.a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(136565);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.e
 * JD-Core Version:    0.7.0.1
 */