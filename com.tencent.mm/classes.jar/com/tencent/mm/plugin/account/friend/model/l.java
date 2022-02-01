package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;

public class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  public MStorageEx pST;
  
  static
  {
    AppMethodBeat.i(131060);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "GoogleFriend") };
    AppMethodBeat.o(131060);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "GoogleFriend", null);
    AppMethodBeat.i(131049);
    this.pST = new MStorageEx()
    {
      public final boolean shouldProcessEvent()
      {
        AppMethodBeat.i(131048);
        if ((l.a(l.this) == null) || (l.a(l.this).isClose()))
        {
          if (l.a(l.this) == null) {}
          for (Object localObject = "null";; localObject = Boolean.valueOf(l.a(l.this).isClose()))
          {
            Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "shouldProcessEvent db is close :%s", new Object[] { localObject });
            AppMethodBeat.o(131048);
            return false;
          }
        }
        AppMethodBeat.o(131048);
        return true;
      }
    };
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(131049);
  }
  
  private boolean Td(String paramString)
  {
    AppMethodBeat.i(131057);
    paramString = "SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    paramString = this.db.rawQuery(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(131057);
    return bool;
  }
  
  private boolean a(k paramk)
  {
    AppMethodBeat.i(131050);
    if (paramk == null)
    {
      AppMethodBeat.o(131050);
      return false;
    }
    paramk = paramk.convertTo();
    if ((int)this.db.insert("GoogleFriend", "googleitemid", paramk) > 0)
    {
      AppMethodBeat.o(131050);
      return true;
    }
    AppMethodBeat.o(131050);
    return false;
  }
  
  public final boolean D(ArrayList<k> paramArrayList)
  {
    AppMethodBeat.i(131051);
    if (paramArrayList.size() <= 0)
    {
      Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
      AppMethodBeat.o(131051);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        a((k)paramArrayList.get(i));
        i += 1;
      }
      if (localh != null)
      {
        localh.endTransaction(l);
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
      }
      this.pST.doNotify(2, this.pST, "");
      AppMethodBeat.o(131051);
      return true;
      l = -1L;
    }
  }
  
  public final Cursor Tc(String paramString)
  {
    AppMethodBeat.i(131053);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(" WHERE ( ");
      localStringBuilder.append("GoogleFriend.googleid='" + paramString + "'");
      localStringBuilder.append(" ) ");
    }
    paramString = this.db.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  ".concat(String.valueOf(localStringBuilder)), null);
    AppMethodBeat.o(131053);
    return paramString;
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(131054);
    if (!Td(paramk.field_googleitemid))
    {
      boolean bool = a(paramk);
      AppMethodBeat.o(131054);
      return bool;
    }
    ContentValues localContentValues = paramk.convertTo();
    int i = this.db.update("GoogleFriend", localContentValues, "googleitemid=?", new String[] { paramk.field_googleitemid });
    if (i > 0) {
      doNotify();
    }
    if (i > 0)
    {
      AppMethodBeat.o(131054);
      return true;
    }
    AppMethodBeat.o(131054);
    return false;
  }
  
  public final boolean bo(String paramString, int paramInt)
  {
    AppMethodBeat.i(131055);
    paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' WHERE googleitemid='" + paramString + "'";
    boolean bool = this.db.execSQL("GoogleFriend", paramString);
    AppMethodBeat.o(131055);
    return bool;
  }
  
  public final boolean bp(String paramString, int paramInt)
  {
    AppMethodBeat.i(131056);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' , status='0' WHERE username='" + paramString + "'";
      boolean bool = this.db.execSQL("GoogleFriend", paramString);
      AppMethodBeat.o(131056);
      return bool;
    }
    AppMethodBeat.o(131056);
    return false;
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(304790);
    this.db.execSQL("GoogleFriend", " delete from GoogleFriend");
    this.pST.doNotify(5, this.pST, "");
    AppMethodBeat.o(304790);
  }
  
  public final Cursor ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131052);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder.append(" WHERE ( ");
      localStringBuilder.append("GoogleFriend.googlegmail!='" + paramString2 + "' AND ");
      localStringBuilder.append("GoogleFriend.googlename LIKE '%" + paramString1 + "%' OR ");
      localStringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + paramString1 + "%' OR ");
      localStringBuilder.append("GoogleFriend.googlegmail LIKE '%" + paramString1 + "%' OR ");
      localStringBuilder.append("GoogleFriend.nickname LIKE '%" + paramString1 + "%' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(" GROUP BY googleid,contecttype");
      localStringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
      paramString1 = this.db.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + localStringBuilder.toString(), null);
      AppMethodBeat.o(131052);
      return paramString1;
      localStringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + paramString2 + "' )");
    }
  }
  
  public String getTableName()
  {
    return "GoogleFriend";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.l
 * JD-Core Version:    0.7.0.1
 */