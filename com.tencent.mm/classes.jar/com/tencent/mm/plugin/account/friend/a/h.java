package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;
import junit.framework.Assert;

public final class h
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) " };
  public com.tencent.mm.cf.h dXo;
  
  public h(com.tencent.mm.cf.h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean WJ()
  {
    return this.dXo.gk("facebookfriend", "delete from facebookfriend");
  }
  
  public final boolean a(g paramg)
  {
    boolean bool;
    Object localObject;
    if (paramg.bcw == -1)
    {
      bool = true;
      Assert.assertTrue("Func Set always conv_flag == flag_all", bool);
      long l = paramg.cCs;
      localObject = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bk.pl(String.valueOf(l)) + "\"";
      localObject = this.dXo.a((String)localObject, null, 2);
      bool = ((Cursor)localObject).moveToFirst();
      ((Cursor)localObject).close();
      if (bool) {
        break label120;
      }
      paramg.bcw = -1;
      paramg = paramg.vf();
      if ((int)this.dXo.insert("facebookfriend", "fbid", paramg) == -1) {
        break label118;
      }
    }
    label118:
    label120:
    int i;
    do
    {
      return true;
      bool = false;
      break;
      return false;
      localObject = paramg.vf();
      i = this.dXo.update("facebookfriend", (ContentValues)localObject, "fbid=?", new String[] { paramg.cCs });
      if (i > 0) {
        doNotify();
      }
    } while (i > 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.h
 * JD-Core Version:    0.7.0.1
 */