package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class au
{
  public static int Gv(String paramString)
  {
    AppMethodBeat.i(184430);
    paramString = "SELECT COUNT(oldUsername) FROM OldAccountFriend WHERE oldUsername = " + h.ty(paramString);
    paramString = ((a)g.ad(a.class)).getOldAccountFriendStorage().rawQuery(paramString, null);
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
  
  public static int Gw(String paramString)
  {
    AppMethodBeat.i(184431);
    paramString = "SELECT seq FROM OldAccountFriend WHERE oldUsername = " + h.ty(paramString) + "ORDER BY seq DESC";
    paramString = ((a)g.ad(a.class)).getOldAccountFriendStorage().rawQuery(paramString, null);
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
  
  public static List<a> aA(String paramString, int paramInt)
  {
    AppMethodBeat.i(184429);
    ArrayList localArrayList;
    Cursor localCursor;
    if (paramInt > 0)
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE showHead = " + paramInt + " AND oldUsername = " + h.ty(paramString) + " ORDER BY pinyinName";
      localArrayList = new ArrayList();
      localCursor = ((a)g.ad(a.class)).getOldAccountFriendStorage().rawQuery(paramString, null);
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
            break label242;
          }
          localr = new r();
          localr.convertFrom(localCursor);
          bd localbd = ((k)g.ab(k.class)).dcq().ala(localr.field_encryptUsername);
          if ((localbd == null) || (!localr.field_encryptUsername.equals(localbd.field_talker))) {
            break label223;
          }
          localArrayList.add(new a(localr, localbd));
          continue;
          paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE oldUsername = " + h.ty(paramString) + " ORDER BY showHead,pinyinName";
        }
        finally
        {
          localCursor.close();
          AppMethodBeat.o(184429);
        }
        break;
        label223:
        localArrayList.add(new a(localr));
      }
      label242:
      localCursor.close();
    }
    ac.i("MicroMsg.RecoverFriendLogic", "get recover friend, sql %s, get %d data", new Object[] { paramString, Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(184429);
    return localArrayList;
  }
  
  public static void aB(String paramString, int paramInt)
  {
    AppMethodBeat.i(184433);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.ty(paramString);
      ac.i("MicroMsg.RecoverFriendLogic", "update old acct friend add state, sql %s", new Object[] { paramString });
      paramString = ((a)g.ad(a.class)).getOldAccountFriendStorage().rawQuery(paramString, null);
      if (paramString != null) {
        try
        {
          if (paramString.moveToFirst())
          {
            r localr = new r();
            localr.convertFrom(paramString);
            localr.field_addState = paramInt;
            ((ap)((a)g.ad(a.class)).getOldAccountFriendStorage()).replace(localr);
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
  
  public static r bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(184432);
    paramString1 = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.ty(paramString2) + " AND oldUsername = " + h.ty(paramString1);
    ac.i("MicroMsg.RecoverFriendLogic", "get old acct friend, sql %s", new Object[] { paramString1 });
    paramString1 = ((a)g.ad(a.class)).getOldAccountFriendStorage().rawQuery(paramString1, null);
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
    public r iLT;
    public bd iLU;
    
    public a(r paramr)
    {
      this.iLT = paramr;
    }
    
    public a(r paramr, bd parambd)
    {
      this.iLT = paramr;
      this.iLU = parambd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.au
 * JD-Core Version:    0.7.0.1
 */