package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;

public class aq
  extends MStorageEx
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) " };
  public final h omV;
  
  public aq(h paramh)
  {
    this.omV = paramh;
  }
  
  public final ap Tf(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(131167);
    paramString = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + paramString + "\"";
    Cursor localCursor = this.omV.rawQuery(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(131167);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ap();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(131167);
    return paramString;
  }
  
  public final int a(long paramLong, ap paramap)
  {
    int i = 0;
    AppMethodBeat.i(131168);
    paramap = paramap.bXs();
    if (paramap.size() > 0) {
      i = this.omV.update("qqlist", paramap, "qq=?", new String[] { String.valueOf(paramLong) });
    }
    if (i > 0) {
      doNotify(3, this, String.valueOf(paramLong));
    }
    AppMethodBeat.o(131168);
    return i;
  }
  
  public final boolean a(ap paramap)
  {
    AppMethodBeat.i(131169);
    if (paramap == null)
    {
      AppMethodBeat.o(131169);
      return false;
    }
    Log.d("MicroMsg.QQListStorage", "insert: name:" + paramap.bXt());
    paramap.eQp = -1;
    ContentValues localContentValues = paramap.bXs();
    if ((int)this.omV.insert("qqlist", "qq", localContentValues) != -1)
    {
      doNotify(2, this, paramap.pTU);
      AppMethodBeat.o(131169);
      return true;
    }
    AppMethodBeat.o(131169);
    return false;
  }
  
  public final Cursor aa(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(131164);
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
      localObject = this.omV.rawQuery((String)localObject, arrayOfString);
      AppMethodBeat.o(131164);
      return localObject;
      localObject = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
      arrayOfString = new String[3];
      arrayOfString[0] = String.valueOf(paramInt);
      arrayOfString[1] = "1";
      arrayOfString[2] = "2";
    }
  }
  
  public final Cursor b(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131165);
    Log.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + paramInt + ", searchby:" + paramString);
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
      paramString = this.omV.rawQuery(localStringBuilder.toString(), null);
      AppMethodBeat.o(131165);
      return paramString;
      localStringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt + "\" and (wexinstatus =\"1\" or wexinstatus =\"2" + "\") and ( ");
    }
  }
  
  public final ap jt(long paramLong)
  {
    ap localap = null;
    AppMethodBeat.i(131166);
    Object localObject = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + paramLong + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(131166);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localap = new ap();
      localap.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(131166);
    return localap;
  }
  
  public boolean shouldProcessEvent()
  {
    AppMethodBeat.i(131170);
    if ((this.omV == null) || (this.omV.isClose()))
    {
      if (this.omV == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.omV.isClose()))
      {
        Log.w("MicroMsg.QQListStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(131170);
        return false;
      }
    }
    AppMethodBeat.o(131170);
    return true;
  }
  
  public final boolean yt(int paramInt)
  {
    bool3 = false;
    bool2 = false;
    AppMethodBeat.i(131171);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.omV.rawQuery("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[] { String.valueOf(paramInt), "0" }, 2);
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
        Log.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", new Object[] { localException.toString() });
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
      AppMethodBeat.o(131171);
    }
    AppMethodBeat.o(131171);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.aq
 * JD-Core Version:    0.7.0.1
 */