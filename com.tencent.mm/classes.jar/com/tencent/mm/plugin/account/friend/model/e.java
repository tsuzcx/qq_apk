package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public class e
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) " };
  public h omV;
  
  public e(h paramh)
  {
    this.omV = paramh;
  }
  
  public final Cursor SY(String paramString)
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
    paramString = this.omV.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null);
    AppMethodBeat.o(130996);
    return paramString;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(130997);
    if (paramd.eQp == -1) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("Func Set always conv_flag == flag_all", bool);
      long l = paramd.kaa;
      localObject = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + Util.escapeSqlValue(String.valueOf(l)) + "\"";
      localObject = this.omV.rawQuery((String)localObject, null, 2);
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
      if (bool) {
        break label135;
      }
      paramd.eQp = -1;
      paramd = paramd.convertTo();
      if ((int)this.omV.insert("facebookfriend", "fbid", paramd) == -1) {
        break;
      }
      AppMethodBeat.o(130997);
      return true;
    }
    AppMethodBeat.o(130997);
    return false;
    label135:
    Object localObject = paramd.convertTo();
    int i = this.omV.update("facebookfriend", (ContentValues)localObject, "fbid=?", new String[] { paramd.kaa });
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
  
  public final boolean bwy()
  {
    AppMethodBeat.i(130998);
    boolean bool = this.omV.execSQL("facebookfriend", "delete from facebookfriend");
    AppMethodBeat.o(130998);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.e
 * JD-Core Version:    0.7.0.1
 */