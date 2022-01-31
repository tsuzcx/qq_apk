package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class k
  extends com.tencent.mm.sdk.e.j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) " };
  public h dXo;
  
  public k(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean Q(List<j> paramList)
  {
    if (paramList.size() <= 0) {
      return false;
    }
    bi localbi = new bi("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
    localbi.addSplit("transation begin");
    long l = this.dXo.eV(Thread.currentThread().getId());
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
        y.e("MicroMsg.FriendExtStorage", paramList.getMessage());
        boolean bool = false;
      }
    }
    this.dXo.hI(l);
    localbi.addSplit("transation end");
    localbi.dumpToLog();
    doNotify();
    return bool;
  }
  
  public final boolean a(j paramj)
  {
    boolean bool1 = true;
    Object localObject = paramj.getUsername();
    localObject = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bk.pl((String)localObject) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    boolean bool2 = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    if (bool2) {
      if (paramj != null)
      {
        paramj = paramj.vf();
        if (paramj.size() <= 0) {
          break label158;
        }
      }
    }
    label158:
    for (int i = this.dXo.update("friend_ext", paramj, "username=?", new String[] { "username" });; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        doNotify();
        return bool1;
        bool1 = false;
        continue;
        if (paramj != null)
        {
          paramj.bcw = -1;
          paramj = paramj.vf();
          if ((int)this.dXo.insert("friend_ext", "username", paramj) != -1) {}
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.k
 * JD-Core Version:    0.7.0.1
 */