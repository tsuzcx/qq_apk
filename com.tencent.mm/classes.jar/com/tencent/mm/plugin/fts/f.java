package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class f
  implements com.tencent.mm.plugin.fts.a.j
{
  public final ad DK(String paramString)
  {
    ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abf(paramString);
    ad localad1 = localad2;
    if (localad2 == null)
    {
      localad1 = new ad();
      paramString = g("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[] { paramString });
      if (paramString.moveToNext())
      {
        localad1.dBe = paramString.getLong(0);
        localad1.setUsername(paramString.getString(1));
        localad1.cZ(paramString.getString(2));
        localad1.df(paramString.getString(3));
        localad1.dk(paramString.getString(4));
        localad1.fi(paramString.getInt(5));
        localad1.setType(paramString.getInt(6));
        localad1.v(paramString.getBlob(7));
        localad1.dr(paramString.getString(8));
        localad1.fk(0);
      }
      paramString.close();
    }
    return localad1;
  }
  
  public final boolean DL(String paramString)
  {
    paramString = g(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[] { paramString });
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
    }
  }
  
  public final long DM(String paramString)
  {
    paramString = g("SELECT conversationTime FROM rconversation WHERE username=?;", new String[] { paramString });
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
    return l1;
  }
  
  public final List<String> DN(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramString;
    if (paramString.endsWith("")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    if (str.length() == 0) {
      return localArrayList;
    }
    paramString = g(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[] { str }), null);
    while (paramString.moveToNext()) {
      localArrayList.add(paramString.getString(0));
    }
    paramString.close();
    return localArrayList;
  }
  
  public final Cursor g(String paramString, String[] paramArrayOfString)
  {
    g.DQ();
    return g.DP().dKv.a(paramString, paramArrayOfString, 2);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    g.DQ();
    return g.DP().dKv.a(paramString, paramArrayOfString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.f
 * JD-Core Version:    0.7.0.1
 */