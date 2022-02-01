package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.List;

public class h
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) " };
  public com.tencent.mm.storagebase.h omV;
  
  public h(com.tencent.mm.storagebase.h paramh)
  {
    this.omV = paramh;
  }
  
  public final boolean a(g paramg)
  {
    boolean bool1 = true;
    AppMethodBeat.i(131019);
    Object localObject = paramg.getUsername();
    localObject = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + Util.escapeSqlValue(String.valueOf(localObject)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    boolean bool2 = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    if (bool2) {
      if (paramg != null)
      {
        paramg = paramg.convertTo();
        if (paramg.size() <= 0) {
          break label171;
        }
      }
    }
    label171:
    for (int i = this.omV.update("friend_ext", paramg, "username=?", new String[] { "username" });; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        doNotify();
        AppMethodBeat.o(131019);
        return bool1;
        bool1 = false;
        continue;
        if (paramg != null)
        {
          paramg.eQp = -1;
          paramg = paramg.convertTo();
          if ((int)this.omV.insert("friend_ext", "username", paramg) != -1) {}
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean bY(List<g> paramList)
  {
    AppMethodBeat.i(131020);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(131020);
      return false;
    }
    TimeLogger localTimeLogger = new TimeLogger("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
    localTimeLogger.addSplit("transation begin");
    long l = this.omV.beginTransaction(Thread.currentThread().getId());
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        g localg = (g)paramList.get(i);
        if (localg != null) {
          a(localg);
        }
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        Log.e("MicroMsg.FriendExtStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.omV.endTransaction(l);
    localTimeLogger.addSplit("transation end");
    localTimeLogger.dumpToLog();
    doNotify();
    AppMethodBeat.o(131020);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.h
 * JD-Core Version:    0.7.0.1
 */