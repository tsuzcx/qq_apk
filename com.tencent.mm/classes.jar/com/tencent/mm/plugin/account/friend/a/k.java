package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class k
  extends com.tencent.mm.sdk.e.k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) " };
  public h fnw;
  
  public k(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final boolean X(List<j> paramList)
  {
    AppMethodBeat.i(108359);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(108359);
      return false;
    }
    bm localbm = new bm("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
    localbm.addSplit("transation begin");
    long l = this.fnw.kr(Thread.currentThread().getId());
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        j localj = (j)paramList.get(i);
        if (localj != null) {
          a(localj);
        }
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        ab.e("MicroMsg.FriendExtStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.fnw.nY(l);
    localbm.addSplit("transation end");
    localbm.dumpToLog();
    doNotify();
    AppMethodBeat.o(108359);
    return bool;
  }
  
  public final boolean a(j paramj)
  {
    boolean bool1 = true;
    AppMethodBeat.i(108358);
    Object localObject = paramj.getUsername();
    localObject = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bo.wC(String.valueOf(localObject)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    boolean bool2 = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    if (bool2) {
      if (paramj != null)
      {
        paramj = paramj.convertTo();
        if (paramj.size() <= 0) {
          break label171;
        }
      }
    }
    label171:
    for (int i = this.fnw.update("friend_ext", paramj, "username=?", new String[] { "username" });; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        doNotify();
        AppMethodBeat.o(108358);
        return bool1;
        bool1 = false;
        continue;
        if (paramj != null)
        {
          paramj.bsY = -1;
          paramj = paramj.convertTo();
          if ((int)this.fnw.a("friend_ext", "username", paramj) != -1) {}
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.k
 * JD-Core Version:    0.7.0.1
 */