package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import junit.framework.Assert;

public class h
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) " };
  public com.tencent.mm.storagebase.h lvy;
  
  public h(com.tencent.mm.storagebase.h paramh)
  {
    this.lvy = paramh;
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(130997);
    if (paramg.cUP == -1) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("Func Set always conv_flag == flag_all", bool);
      long l = paramg.hDe;
      localObject = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + Util.escapeSqlValue(String.valueOf(l)) + "\"";
      localObject = this.lvy.rawQuery((String)localObject, null, 2);
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
      if (bool) {
        break label135;
      }
      paramg.cUP = -1;
      paramg = paramg.convertTo();
      if ((int)this.lvy.insert("facebookfriend", "fbid", paramg) == -1) {
        break;
      }
      AppMethodBeat.o(130997);
      return true;
    }
    AppMethodBeat.o(130997);
    return false;
    label135:
    Object localObject = paramg.convertTo();
    int i = this.lvy.update("facebookfriend", (ContentValues)localObject, "fbid=?", new String[] { paramg.hDe });
    if (i > 0) {
      doNotify();
    }
    if (i > 0)
    {
      AppMethodBeat.o(130997);
      return true;
    }
    AppMethodBeat.o(130997);
    return false;
  }
  
  public final Cursor aaE(String paramString)
  {
    AppMethodBeat.i(130996);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.length() > 0))
    {
      localStringBuilder.append(" where ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + paramString + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + paramString + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + paramString + "%' ) ");
    }
    paramString = this.lvy.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null);
    AppMethodBeat.o(130996);
    return paramString;
  }
  
  public final boolean byd()
  {
    AppMethodBeat.i(130998);
    boolean bool = this.lvy.execSQL("facebookfriend", "delete from facebookfriend");
    AppMethodBeat.o(130998);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.h
 * JD-Core Version:    0.7.0.1
 */