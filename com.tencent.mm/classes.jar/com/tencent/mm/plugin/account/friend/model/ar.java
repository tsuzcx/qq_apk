package com.tencent.mm.plugin.account.friend.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.List;

public final class ar
{
  public static int Tg(String paramString)
  {
    AppMethodBeat.i(184430);
    paramString = "SELECT COUNT(oldUsername) FROM OldAccountFriend WHERE oldUsername = " + com.tencent.mm.storagebase.h.EQ(paramString);
    paramString = ((a)com.tencent.mm.kernel.h.az(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        return i;
      }
      return 0;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(184430);
    }
  }
  
  public static int Th(String paramString)
  {
    AppMethodBeat.i(184431);
    paramString = "SELECT seq FROM OldAccountFriend WHERE oldUsername = " + com.tencent.mm.storagebase.h.EQ(paramString) + "ORDER BY seq DESC";
    paramString = ((a)com.tencent.mm.kernel.h.az(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        return i;
      }
      return 0;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(184431);
    }
  }
  
  public static List<a> bq(String paramString, int paramInt)
  {
    AppMethodBeat.i(184429);
    ArrayList localArrayList;
    Cursor localCursor;
    if (paramInt > 0)
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE showHead = " + paramInt + " AND oldUsername = " + com.tencent.mm.storagebase.h.EQ(paramString) + " ORDER BY pinyinName";
      localArrayList = new ArrayList();
      localCursor = ((a)com.tencent.mm.kernel.h.az(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
      if (localCursor == null) {}
    }
    else
    {
      for (;;)
      {
        o localo;
        try
        {
          if (!localCursor.moveToNext()) {
            break label245;
          }
          localo = new o();
          localo.convertFrom(localCursor);
          bp localbp = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaY().aLv(localo.field_encryptUsername);
          if ((localbp == null) || (!localo.field_encryptUsername.equals(localbp.field_talker))) {
            break label226;
          }
          localArrayList.add(new a(localo, localbp));
          continue;
          paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE oldUsername = " + com.tencent.mm.storagebase.h.EQ(paramString) + " ORDER BY showHead,pinyinName";
        }
        finally
        {
          localCursor.close();
          AppMethodBeat.o(184429);
        }
        break;
        label226:
        localArrayList.add(new a(localo));
      }
      label245:
      localCursor.close();
    }
    Log.i("MicroMsg.RecoverFriendLogic", "get recover friend, sql %s, get %d data", new Object[] { paramString, Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(184429);
    return localArrayList;
  }
  
  public static void br(String paramString, int paramInt)
  {
    AppMethodBeat.i(184433);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + com.tencent.mm.storagebase.h.EQ(paramString);
      Log.i("MicroMsg.RecoverFriendLogic", "update old acct friend add state, sql %s", new Object[] { paramString });
      paramString = ((a)com.tencent.mm.kernel.h.az(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
      if (paramString != null) {
        try
        {
          if (paramString.moveToFirst())
          {
            o localo = new o();
            localo.convertFrom(paramString);
            localo.field_addState = paramInt;
            ((am)((a)com.tencent.mm.kernel.h.az(a.class)).getOldAccountFriendStorage()).replace(localo);
          }
          return;
        }
        finally
        {
          paramString.close();
          AppMethodBeat.o(184433);
        }
      }
    }
    AppMethodBeat.o(184433);
  }
  
  public static o cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(184432);
    paramString1 = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + com.tencent.mm.storagebase.h.EQ(paramString2) + " AND oldUsername = " + com.tencent.mm.storagebase.h.EQ(paramString1);
    Log.i("MicroMsg.RecoverFriendLogic", "get old acct friend, sql %s", new Object[] { paramString1 });
    paramString1 = ((a)com.tencent.mm.kernel.h.az(a.class)).getOldAccountFriendStorage().rawQuery(paramString1, new String[0]);
    if (paramString1 != null) {}
    try
    {
      if (paramString1.moveToFirst())
      {
        paramString2 = new o();
        paramString2.convertFrom(paramString1);
        return paramString2;
      }
      return null;
    }
    finally
    {
      paramString1.close();
      AppMethodBeat.o(184432);
    }
  }
  
  public static final class a
  {
    public o pUf;
    public bp pUg;
    
    public a(o paramo)
    {
      this.pUf = paramo;
    }
    
    public a(o paramo, bp parambp)
    {
      this.pUf = paramo;
      this.pUg = parambp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ar
 * JD-Core Version:    0.7.0.1
 */