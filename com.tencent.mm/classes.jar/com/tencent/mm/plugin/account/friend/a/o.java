package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;

public final class o
  extends j<n>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  public com.tencent.mm.sdk.e.n jdR;
  
  static
  {
    AppMethodBeat.i(131060);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "GoogleFriend") };
    AppMethodBeat.o(131060);
  }
  
  public o(e parame)
  {
    super(parame, n.info, "GoogleFriend", null);
    AppMethodBeat.i(131049);
    this.jdR = new com.tencent.mm.sdk.e.n()
    {
      public final boolean aSH()
      {
        AppMethodBeat.i(131048);
        if ((o.a(o.this) == null) || (o.a(o.this).fmj()))
        {
          if (o.a(o.this) == null) {}
          for (Object localObject = "null";; localObject = Boolean.valueOf(o.a(o.this).fmj()))
          {
            ad.w("MicroMsg.GoogleContact.GoogleFriendUI", "shouldProcessEvent db is close :%s", new Object[] { localObject });
            AppMethodBeat.o(131048);
            return false;
          }
        }
        AppMethodBeat.o(131048);
        return true;
      }
    };
    this.db = parame;
    AppMethodBeat.o(131049);
  }
  
  private boolean JH(String paramString)
  {
    AppMethodBeat.i(131057);
    paramString = "SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    paramString = this.db.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(131057);
    return bool;
  }
  
  private boolean a(n paramn)
  {
    AppMethodBeat.i(131050);
    if (paramn == null)
    {
      AppMethodBeat.o(131050);
      return false;
    }
    paramn = paramn.convertTo();
    if ((int)this.db.insert("GoogleFriend", "googleitemid", paramn) > 0)
    {
      AppMethodBeat.o(131050);
      return true;
    }
    AppMethodBeat.o(131050);
    return false;
  }
  
  public final Cursor JG(String paramString)
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
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean aA(String paramString, int paramInt)
  {
    AppMethodBeat.i(131055);
    paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' WHERE googleitemid='" + paramString + "'";
    boolean bool = this.db.execSQL("GoogleFriend", paramString);
    AppMethodBeat.o(131055);
    return bool;
  }
  
  public final boolean aB(String paramString, int paramInt)
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
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(131054);
    if (!JH(paramn.field_googleitemid))
    {
      boolean bool = a(paramn);
      AppMethodBeat.o(131054);
      return bool;
    }
    ContentValues localContentValues = paramn.convertTo();
    int i = this.db.update("GoogleFriend", localContentValues, "googleitemid=?", new String[] { paramn.field_googleitemid });
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
  
  public final Cursor bQ(String paramString1, String paramString2)
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
  
  public final void clear()
  {
    AppMethodBeat.i(131058);
    this.db.execSQL("GoogleFriend", " delete from GoogleFriend");
    this.jdR.b(5, this.jdR, "");
    AppMethodBeat.o(131058);
  }
  
  public final String getTableName()
  {
    return "GoogleFriend";
  }
  
  public final boolean u(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(131051);
    if (paramArrayList.size() <= 0)
    {
      ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
      AppMethodBeat.o(131051);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.xO(Thread.currentThread().getId());
      ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        a((n)paramArrayList.get(i));
        i += 1;
      }
      if (localh != null)
      {
        localh.sJ(l);
        ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
      }
      this.jdR.b(2, this.jdR, "");
      AppMethodBeat.o(131051);
      return true;
      l = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.o
 * JD-Core Version:    0.7.0.1
 */