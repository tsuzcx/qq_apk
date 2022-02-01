package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.List;

public final class k
  extends com.tencent.mm.sdk.e.k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) " };
  public h gPa;
  
  public k(h paramh)
  {
    this.gPa = paramh;
  }
  
  public final boolean a(j paramj)
  {
    boolean bool1 = true;
    AppMethodBeat.i(131019);
    Object localObject = paramj.getUsername();
    localObject = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bt.aFQ(String.valueOf(localObject)) + "\"";
    localObject = this.gPa.a((String)localObject, null, 2);
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
    for (int i = this.gPa.update("friend_ext", paramj, "username=?", new String[] { "username" });; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        doNotify();
        AppMethodBeat.o(131019);
        return bool1;
        bool1 = false;
        continue;
        if (paramj != null)
        {
          paramj.dtM = -1;
          paramj = paramj.convertTo();
          if ((int)this.gPa.a("friend_ext", "username", paramj) != -1) {}
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean ao(List<j> paramList)
  {
    AppMethodBeat.i(131020);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(131020);
      return false;
    }
    br localbr = new br("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
    localbr.addSplit("transation begin");
    long l = this.gPa.rb(Thread.currentThread().getId());
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
        ad.e("MicroMsg.FriendExtStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.gPa.mX(l);
    localbr.addSplit("transation end");
    localbr.dumpToLog();
    doNotify();
    AppMethodBeat.o(131020);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.k
 * JD-Core Version:    0.7.0.1
 */