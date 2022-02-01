package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class au
{
  public static int Th(String paramString)
  {
    AppMethodBeat.i(184430);
    paramString = "SELECT COUNT(oldUsername) FROM OldAccountFriend WHERE oldUsername = " + h.Fl(paramString);
    paramString = ((a)g.ah(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
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
  
  public static int Ti(String paramString)
  {
    AppMethodBeat.i(184431);
    paramString = "SELECT seq FROM OldAccountFriend WHERE oldUsername = " + h.Fl(paramString) + "ORDER BY seq DESC";
    paramString = ((a)g.ah(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
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
  
  public static List<a> aH(String paramString, int paramInt)
  {
    AppMethodBeat.i(184429);
    ArrayList localArrayList;
    Cursor localCursor;
    if (paramInt > 0)
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE showHead = " + paramInt + " AND oldUsername = " + h.Fl(paramString) + " ORDER BY pinyinName";
      localArrayList = new ArrayList();
      localCursor = ((a)g.ah(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
      if (localCursor == null) {}
    }
    else
    {
      for (;;)
      {
        r localr;
        try
        {
          if (!localCursor.moveToNext()) {
            break label245;
          }
          localr = new r();
          localr.convertFrom(localCursor);
          bn localbn = ((l)g.af(l.class)).eix().aEm(localr.field_encryptUsername);
          if ((localbn == null) || (!localr.field_encryptUsername.equals(localbn.field_talker))) {
            break label226;
          }
          localArrayList.add(new a(localr, localbn));
          continue;
          paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE oldUsername = " + h.Fl(paramString) + " ORDER BY showHead,pinyinName";
        }
        finally
        {
          localCursor.close();
          AppMethodBeat.o(184429);
        }
        break;
        label226:
        localArrayList.add(new a(localr));
      }
      label245:
      localCursor.close();
    }
    Log.i("MicroMsg.RecoverFriendLogic", "get recover friend, sql %s, get %d data", new Object[] { paramString, Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(184429);
    return localArrayList;
  }
  
  public static void aI(String paramString, int paramInt)
  {
    AppMethodBeat.i(184433);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.Fl(paramString);
      Log.i("MicroMsg.RecoverFriendLogic", "update old acct friend add state, sql %s", new Object[] { paramString });
      paramString = ((a)g.ah(a.class)).getOldAccountFriendStorage().rawQuery(paramString, new String[0]);
      if (paramString != null) {
        try
        {
          if (paramString.moveToFirst())
          {
            r localr = new r();
            localr.convertFrom(paramString);
            localr.field_addState = paramInt;
            ((ap)((a)g.ah(a.class)).getOldAccountFriendStorage()).replace(localr);
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
  
  public static r ca(String paramString1, String paramString2)
  {
    AppMethodBeat.i(184432);
    paramString1 = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.Fl(paramString2) + " AND oldUsername = " + h.Fl(paramString1);
    Log.i("MicroMsg.RecoverFriendLogic", "get old acct friend, sql %s", new Object[] { paramString1 });
    paramString1 = ((a)g.ah(a.class)).getOldAccountFriendStorage().rawQuery(paramString1, new String[0]);
    if (paramString1 != null) {}
    try
    {
      if (paramString1.moveToFirst())
      {
        paramString2 = new r();
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
    public r kfY;
    public bn kfZ;
    
    public a(r paramr)
    {
      this.kfY = paramr;
    }
    
    public a(r paramr, bn parambn)
    {
      this.kfY = paramr;
      this.kfZ = parambn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.au
 * JD-Core Version:    0.7.0.1
 */