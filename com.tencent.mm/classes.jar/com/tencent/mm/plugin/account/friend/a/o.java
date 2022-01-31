package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class o
  extends j<n>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  public com.tencent.mm.sdk.e.n gxE;
  
  static
  {
    AppMethodBeat.i(108399);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "GoogleFriend") };
    AppMethodBeat.o(108399);
  }
  
  public o(e parame)
  {
    super(parame, n.info, "GoogleFriend", null);
    AppMethodBeat.i(108388);
    this.gxE = new o.1(this);
    this.db = parame;
    AppMethodBeat.o(108388);
  }
  
  private boolean a(n paramn)
  {
    AppMethodBeat.i(108389);
    if (paramn == null)
    {
      AppMethodBeat.o(108389);
      return false;
    }
    paramn = paramn.convertTo();
    if ((int)this.db.insert("GoogleFriend", "googleitemid", paramn) > 0)
    {
      AppMethodBeat.o(108389);
      return true;
    }
    AppMethodBeat.o(108389);
    return false;
  }
  
  private boolean xl(String paramString)
  {
    AppMethodBeat.i(108396);
    paramString = "SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    paramString = this.db.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(108396);
    return bool;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(108394);
    paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' WHERE googleitemid='" + paramString + "'";
    boolean bool = this.db.execSQL("GoogleFriend", paramString);
    AppMethodBeat.o(108394);
    return bool;
  }
  
  public final boolean ak(String paramString, int paramInt)
  {
    AppMethodBeat.i(108395);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' , status='0' WHERE username='" + paramString + "'";
      boolean bool = this.db.execSQL("GoogleFriend", paramString);
      AppMethodBeat.o(108395);
      return bool;
    }
    AppMethodBeat.o(108395);
    return false;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(108393);
    if (!xl(paramn.field_googleitemid))
    {
      boolean bool = a(paramn);
      AppMethodBeat.o(108393);
      return bool;
    }
    ContentValues localContentValues = paramn.convertTo();
    int i = this.db.update("GoogleFriend", localContentValues, "googleitemid=?", new String[] { paramn.field_googleitemid });
    if (i > 0) {
      doNotify();
    }
    if (i > 0)
    {
      AppMethodBeat.o(108393);
      return true;
    }
    AppMethodBeat.o(108393);
    return false;
  }
  
  public final Cursor bl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108391);
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
      AppMethodBeat.o(108391);
      return paramString1;
      localStringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + paramString2 + "' )");
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108397);
    this.db.execSQL("GoogleFriend", " delete from GoogleFriend");
    this.gxE.b(5, this.gxE, "");
    AppMethodBeat.o(108397);
  }
  
  public final String getTableName()
  {
    return "GoogleFriend";
  }
  
  public final boolean i(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(108390);
    if (paramArrayList.size() <= 0)
    {
      ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
      AppMethodBeat.o(108390);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
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
        localh.nY(l);
        ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
      }
      this.gxE.b(2, this.gxE, "");
      AppMethodBeat.o(108390);
      return true;
      l = -1L;
    }
  }
  
  public final Cursor xk(String paramString)
  {
    AppMethodBeat.i(108392);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(" WHERE ( ");
      localStringBuilder.append("GoogleFriend.googleid='" + paramString + "'");
      localStringBuilder.append(" ) ");
    }
    paramString = this.db.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  ".concat(String.valueOf(localStringBuilder)), null);
    AppMethodBeat.o(108392);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.o
 * JD-Core Version:    0.7.0.1
 */