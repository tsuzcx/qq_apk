package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class ap
  extends n
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) " };
  public final h fnw;
  
  public ap(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final Cursor E(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(108503);
    Object localObject;
    String[] arrayOfString;
    if (paramBoolean)
    {
      localObject = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
      arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramInt);
    }
    for (;;)
    {
      localObject = this.fnw.a((String)localObject, arrayOfString, 0);
      AppMethodBeat.o(108503);
      return localObject;
      localObject = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
      arrayOfString = new String[3];
      arrayOfString[0] = String.valueOf(paramInt);
      arrayOfString[1] = "1";
      arrayOfString[2] = "2";
    }
  }
  
  public final int a(long paramLong, ao paramao)
  {
    int i = 0;
    AppMethodBeat.i(108507);
    paramao = paramao.aqL();
    if (paramao.size() > 0) {
      i = this.fnw.update("qqlist", paramao, "qq=?", new String[] { String.valueOf(paramLong) });
    }
    if (i > 0) {
      b(3, this, String.valueOf(paramLong));
    }
    AppMethodBeat.o(108507);
    return i;
  }
  
  public final boolean a(ao paramao)
  {
    AppMethodBeat.i(108508);
    if (paramao == null)
    {
      AppMethodBeat.o(108508);
      return false;
    }
    ab.d("MicroMsg.QQListStorage", "insert: name:" + paramao.aqM());
    paramao.bsY = -1;
    ContentValues localContentValues = paramao.aqL();
    if ((int)this.fnw.a("qqlist", "qq", localContentValues) != -1)
    {
      b(2, this, paramao.gyE);
      AppMethodBeat.o(108508);
      return true;
    }
    AppMethodBeat.o(108508);
    return false;
  }
  
  public final boolean aqj()
  {
    AppMethodBeat.i(108509);
    if ((this.fnw == null) || (this.fnw.dun()))
    {
      if (this.fnw == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.fnw.dun()))
      {
        ab.w("MicroMsg.QQListStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(108509);
        return false;
      }
    }
    AppMethodBeat.o(108509);
    return true;
  }
  
  public final Cursor c(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108504);
    ab.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + paramInt + ", searchby:" + paramString);
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
      paramString = this.fnw.a(localStringBuilder.toString(), null, 0);
      AppMethodBeat.o(108504);
      return paramString;
      localStringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt + "\" and (wexinstatus =\"1\" or wexinstatus =\"2\") and ( ");
    }
  }
  
  public final ao hn(long paramLong)
  {
    ao localao = null;
    AppMethodBeat.i(108505);
    Object localObject = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + paramLong + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(108505);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localao = new ao();
      localao.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(108505);
    return localao;
  }
  
  public final boolean mV(int paramInt)
  {
    bool3 = false;
    bool2 = false;
    AppMethodBeat.i(108510);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.fnw.a("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[] { String.valueOf(paramInt), "0" }, 2);
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
      for (;;)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", new Object[] { localException.toString() });
        bool2 = bool3;
        if (localObject1 != null)
        {
          localObject1.close();
          bool2 = bool3;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label160;
      }
      localObject3.close();
      AppMethodBeat.o(108510);
    }
    AppMethodBeat.o(108510);
    return bool2;
  }
  
  public final ao xn(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(108506);
    paramString = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + paramString + "\"";
    Cursor localCursor = this.fnw.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(108506);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ao();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(108506);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ap
 * JD-Core Version:    0.7.0.1
 */