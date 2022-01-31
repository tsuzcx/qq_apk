package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class h
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) " };
  public com.tencent.mm.cg.h fnw;
  
  public h(com.tencent.mm.cg.h paramh)
  {
    this.fnw = paramh;
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(108335);
    if (paramg.bsY == -1) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("Func Set always conv_flag == flag_all", bool);
      long l = paramg.dqE;
      localObject = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bo.wC(String.valueOf(l)) + "\"";
      localObject = this.fnw.a((String)localObject, null, 2);
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
      if (bool) {
        break label139;
      }
      if (paramg == null) {
        break;
      }
      paramg.bsY = -1;
      paramg = paramg.convertTo();
      if ((int)this.fnw.a("facebookfriend", "fbid", paramg) == -1) {
        break;
      }
      AppMethodBeat.o(108335);
      return true;
    }
    AppMethodBeat.o(108335);
    return false;
    label139:
    Object localObject = paramg.convertTo();
    int i = this.fnw.update("facebookfriend", (ContentValues)localObject, "fbid=?", new String[] { paramg.dqE });
    if (i > 0) {
      doNotify();
    }
    if (i > 0)
    {
      AppMethodBeat.o(108335);
      return true;
    }
    AppMethodBeat.o(108335);
    return false;
  }
  
  public final boolean aql()
  {
    AppMethodBeat.i(108336);
    boolean bool = this.fnw.execSQL("facebookfriend", "delete from facebookfriend");
    AppMethodBeat.o(108336);
    return bool;
  }
  
  public final Cursor xe(String paramString)
  {
    AppMethodBeat.i(108334);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.length() > 0))
    {
      localStringBuilder.append(" where ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + paramString + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + paramString + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + paramString + "%' ) ");
    }
    paramString = this.fnw.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0);
    AppMethodBeat.o(108334);
    return paramString;
  }
  
  public final g xf(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(108337);
    paramString = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
    Cursor localCursor = this.fnw.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(108337);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new g();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(108337);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.h
 * JD-Core Version:    0.7.0.1
 */