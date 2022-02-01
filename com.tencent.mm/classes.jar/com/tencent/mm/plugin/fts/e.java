package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class e
  implements j
{
  public final am akh(String paramString)
  {
    AppMethodBeat.i(52550);
    am localam2 = ((l)g.ab(l.class)).azp().aTf(paramString);
    am localam1 = localam2;
    if (localam2 == null)
    {
      localam1 = new am();
      paramString = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[] { paramString });
      if (paramString.moveToNext())
      {
        localam1.gfj = paramString.getLong(0);
        localam1.setUsername(paramString.getString(1));
        localam1.sQ(paramString.getString(2));
        localam1.sR(paramString.getString(3));
        localam1.sT(paramString.getString(4));
        localam1.kb(paramString.getInt(5));
        localam1.setType(paramString.getInt(6));
        localam1.L(paramString.getBlob(7));
        localam1.ta(paramString.getString(8));
        localam1.kd(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(52550);
    return localam1;
  }
  
  public final boolean aki(String paramString)
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
  
  public final long akj(String paramString)
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
  
  public final List<String> akk(String paramString)
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
    g.ajD();
    paramString = g.ajC().gBr.a(paramString, paramArrayOfString, 2);
    AppMethodBeat.o(52548);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52549);
    g.ajD();
    paramString = g.ajC().gBr.a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(52549);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.e
 * JD-Core Version:    0.7.0.1
 */