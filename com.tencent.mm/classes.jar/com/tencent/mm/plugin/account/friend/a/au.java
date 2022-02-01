package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class au
{
  public static int Cs(String paramString)
  {
    AppMethodBeat.i(184430);
    paramString = "SELECT COUNT(oldUsername) FROM OldAccountFriend WHERE oldUsername = " + h.qj(paramString);
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
  
  public static int Ct(String paramString)
  {
    AppMethodBeat.i(184431);
    paramString = "SELECT seq FROM OldAccountFriend WHERE oldUsername = " + h.qj(paramString) + "ORDER BY seq DESC";
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
  
  public static List<a> aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(184429);
    ArrayList localArrayList;
    Cursor localCursor;
    if (paramInt > 0)
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE showHead = " + paramInt + " AND oldUsername = " + h.qj(paramString) + " ORDER BY pinyinName";
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
          ba localba = ((k)g.ab(k.class)).cOH().agg(localr.field_encryptUsername);
          if ((localba == null) || (!localr.field_encryptUsername.equals(localba.field_talker))) {
            break label223;
          }
          localArrayList.add(new a(localr, localba));
          continue;
          paramString = "SELECT *,rowid FROM OldAccountFriend " + " WHERE oldUsername = " + h.qj(paramString) + " ORDER BY showHead,pinyinName";
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
    ad.i("MicroMsg.RecoverFriendLogic", "get recover friend, sql %s, get %d data", new Object[] { paramString, Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(184429);
    return localArrayList;
  }
  
  public static void ax(String paramString, int paramInt)
  {
    AppMethodBeat.i(184433);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.qj(paramString);
      ad.i("MicroMsg.RecoverFriendLogic", "update old acct friend add state, sql %s", new Object[] { paramString });
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
  
  public static r bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(184432);
    paramString1 = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.qj(paramString2) + " AND oldUsername = " + h.qj(paramString1);
    ad.i("MicroMsg.RecoverFriendLogic", "get old acct friend, sql %s", new Object[] { paramString1 });
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
    public r ilM;
    public ba ilN;
    
    public a(r paramr)
    {
      this.ilM = paramr;
    }
    
    public a(r paramr, ba paramba)
    {
      this.ilM = paramr;
      this.ilN = paramba;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.au
 * JD-Core Version:    0.7.0.1
 */