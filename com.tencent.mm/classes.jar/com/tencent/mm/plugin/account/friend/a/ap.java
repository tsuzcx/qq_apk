package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.y;

public final class ap
  extends m
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) " };
  public final h dXo;
  
  public ap(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final Cursor A(int paramInt, boolean paramBoolean)
  {
    String str;
    String[] arrayOfString;
    if (paramBoolean)
    {
      str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
      arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramInt);
    }
    for (;;)
    {
      return this.dXo.a(str, arrayOfString, 0);
      str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
      arrayOfString = new String[3];
      arrayOfString[0] = String.valueOf(paramInt);
      arrayOfString[1] = "1";
      arrayOfString[2] = "2";
    }
  }
  
  protected final boolean WH()
  {
    boolean bool = true;
    if ((this.dXo == null) || (this.dXo.csp())) {
      if (this.dXo != null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.dXo.csp()))
    {
      y.w("MicroMsg.QQListStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
      bool = false;
      return bool;
    }
  }
  
  public final int a(long paramLong, ao paramao)
  {
    int i = 0;
    paramao = paramao.Xh();
    if (paramao.size() > 0) {
      i = this.dXo.update("qqlist", paramao, "qq=?", new String[] { String.valueOf(paramLong) });
    }
    if (i > 0) {
      b(3, this, String.valueOf(paramLong));
    }
    return i;
  }
  
  public final boolean a(ao paramao)
  {
    if (paramao == null) {}
    ContentValues localContentValues;
    do
    {
      return false;
      y.d("MicroMsg.QQListStorage", "insert: name:" + paramao.Xi());
      paramao.bcw = -1;
      localContentValues = paramao.Xh();
    } while ((int)this.dXo.insert("qqlist", "qq", localContentValues) == -1);
    b(2, this, paramao.fgW);
    return true;
  }
  
  public final Cursor c(int paramInt, String paramString, boolean paramBoolean)
  {
    y.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + paramInt + ", searchby:" + paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {
      localStringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt + "\" and ( ");
    }
    for (;;)
    {
      localStringBuilder.append("qqlist.qq like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.username like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.nickname like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.pyinitial like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.quanpin like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.qqnickname like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.qqpyinitial like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.qqquanpin like '%" + paramString + "%' or ");
      localStringBuilder.append("qqlist.qqremark like '%" + paramString + "%' )");
      localStringBuilder.append(" order by reserved3");
      return this.dXo.a(localStringBuilder.toString(), null, 0);
      localStringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt + "\" and (wexinstatus =\"1\" or wexinstatus =\"2\") and ( ");
    }
  }
  
  public final ao cr(long paramLong)
  {
    ao localao = null;
    Object localObject = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + paramLong + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localao = new ao();
      localao.d((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    return localao;
  }
  
  public final boolean ka(int paramInt)
  {
    bool3 = false;
    bool2 = false;
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.dXo.a("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[] { String.valueOf(paramInt), "0" }, 2);
      boolean bool1 = bool2;
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        boolean bool4 = localCursor.moveToFirst();
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (localCursor != null)
      {
        localCursor.close();
        bool2 = bool1;
      }
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      y.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", new Object[] { localException.toString() });
      bool2 = bool3;
      return false;
    }
    finally
    {
      if (localObject3 == null) {
        break label146;
      }
      localObject3.close();
    }
    return bool2;
  }
  
  public final ao pR(String paramString)
  {
    Object localObject = null;
    paramString = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + paramString + "\"";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ao();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ap
 * JD-Core Version:    0.7.0.1
 */