package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class o
  extends i<n>
  implements g.a
{
  public static final String[] dXp = { i.a(n.buS, "GoogleFriend") };
  public e dXw;
  public m ffW = new o.1(this);
  
  public o(e parame)
  {
    super(parame, n.buS, "GoogleFriend", null);
    this.dXw = parame;
  }
  
  private boolean a(n paramn)
  {
    if (paramn == null) {}
    do
    {
      return false;
      paramn = paramn.vf();
    } while ((int)this.dXw.insert("GoogleFriend", "googleitemid", paramn) <= 0);
    return true;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final boolean ab(String paramString, int paramInt)
  {
    paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' WHERE googleitemid='" + paramString + "'";
    return this.dXw.gk("GoogleFriend", paramString);
  }
  
  public final boolean ac(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' , status='0' WHERE username='" + paramString + "'";
      return this.dXw.gk("GoogleFriend", paramString);
    }
    return false;
  }
  
  public final boolean b(n paramn)
  {
    boolean bool1 = true;
    Object localObject = paramn.field_googleitemid;
    localObject = "SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bk.pl((String)localObject) + "\"";
    localObject = this.dXw.a((String)localObject, null, 2);
    boolean bool2 = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    if (!bool2) {
      bool1 = a(paramn);
    }
    int i;
    do
    {
      return bool1;
      localObject = paramn.vf();
      i = this.dXw.update("GoogleFriend", (ContentValues)localObject, "googleitemid=?", new String[] { paramn.field_googleitemid });
      if (i > 0) {
        doNotify();
      }
    } while (i > 0);
    return false;
  }
  
  public final void clear()
  {
    this.dXw.gk("GoogleFriend", " delete from GoogleFriend");
    this.ffW.b(5, this.ffW, "");
  }
  
  public final String getTableName()
  {
    return "GoogleFriend";
  }
  
  public final boolean i(ArrayList<n> paramArrayList)
  {
    if (paramArrayList.size() <= 0)
    {
      y.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
      return false;
    }
    h localh = null;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
      y.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
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
        localh.hI(l);
        y.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
      }
      this.ffW.b(2, this.ffW, "");
      return true;
      l = -1L;
    }
  }
  
  public final Cursor pP(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(" WHERE ( ");
      localStringBuilder.append("GoogleFriend.googleid='" + paramString + "'");
      localStringBuilder.append(" ) ");
    }
    return this.dXw.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + localStringBuilder, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.o
 * JD-Core Version:    0.7.0.1
 */