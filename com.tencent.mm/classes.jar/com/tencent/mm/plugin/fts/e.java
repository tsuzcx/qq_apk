package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.List;

public final class e
  implements j
{
  public final au aEa(String paramString)
  {
    AppMethodBeat.i(52550);
    au localau2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq(paramString);
    au localau1 = localau2;
    if (localau2 == null)
    {
      localau1 = new au();
      paramString = h("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[] { paramString });
      if (paramString.moveToNext())
      {
        localau1.maN = paramString.getLong(0);
        localau1.setUsername(paramString.getString(1));
        localau1.AV(paramString.getString(2));
        localau1.AW(paramString.getString(3));
        localau1.setNickname(paramString.getString(4));
        localau1.pr(paramString.getInt(5));
        localau1.ru(paramString.getInt(6));
        localau1.ag(paramString.getBlob(7));
        localau1.Be(paramString.getString(8));
        localau1.pt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(52550);
    return localau1;
  }
  
  public final boolean aEb(String paramString)
  {
    AppMethodBeat.i(52551);
    paramString = h(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[] { paramString });
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
  
  public final long aEc(String paramString)
  {
    AppMethodBeat.i(52552);
    paramString = h("SELECT conversationTime FROM rconversation WHERE username=?;", new String[] { paramString });
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
  
  public final List<String> aEd(String paramString)
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
    paramString = h(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[] { str }), null);
    while (paramString.moveToNext()) {
      localArrayList.add(paramString.getString(0));
    }
    paramString.close();
    AppMethodBeat.o(52553);
    return localArrayList;
  }
  
  public final Cursor h(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52548);
    com.tencent.mm.kernel.h.baF();
    paramString = com.tencent.mm.kernel.h.baE().mCO.rawQuery(paramString, paramArrayOfString, 2);
    AppMethodBeat.o(52548);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52549);
    com.tencent.mm.kernel.h.baF();
    paramString = com.tencent.mm.kernel.h.baE().mCO.rawQuery(paramString, paramArrayOfString);
    AppMethodBeat.o(52549);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.e
 * JD-Core Version:    0.7.0.1
 */