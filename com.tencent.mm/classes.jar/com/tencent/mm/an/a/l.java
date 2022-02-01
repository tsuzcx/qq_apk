package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  final MStorageEvent<l.a, a.b> ovQ;
  Map<String, String> oxD;
  
  static
  {
    AppMethodBeat.i(124291);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "BizChatUserInfo") };
    AppMethodBeat.o(124291);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "BizChatUserInfo", null);
    AppMethodBeat.i(124281);
    this.oxD = new HashMap();
    this.ovQ = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
    this.oxD.clear();
    AppMethodBeat.o(124281);
  }
  
  public static String a(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(124289);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(124289);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(" 1=1 ");
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0)
      {
        localObject = paramList.iterator();
        for (paramList = ""; ((Iterator)localObject).hasNext(); paramList = paramList + " and userId != '" + str + "'") {
          str = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" and ");
    localStringBuilder.append("userId in(");
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(" '").append(paramArrayOfString[i]).append("' ");
      i += 1;
    }
    localStringBuilder.append(" )");
    paramArrayOfString = localStringBuilder.toString();
    AppMethodBeat.o(124289);
    return paramArrayOfString;
  }
  
  public final int Nl(String paramString)
  {
    AppMethodBeat.i(124285);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
      AppMethodBeat.o(124285);
      return -1;
    }
    paramString = hM(paramString);
    if (paramString != null)
    {
      int i = paramString.field_UserVersion;
      AppMethodBeat.o(124285);
      return i;
    }
    Log.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
    AppMethodBeat.o(124285);
    return -1;
  }
  
  public final k Nm(String paramString)
  {
    AppMethodBeat.i(124286);
    if (paramString == null)
    {
      Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
      AppMethodBeat.o(124286);
      return null;
    }
    paramString = hN(paramString);
    if (paramString == null)
    {
      Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
      AppMethodBeat.o(124286);
      return null;
    }
    paramString = hM(paramString);
    AppMethodBeat.o(124286);
    return paramString;
  }
  
  public final boolean a(k paramk)
  {
    AppMethodBeat.i(124283);
    Log.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
    if (paramk == null)
    {
      Log.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
      AppMethodBeat.o(124283);
      return false;
    }
    boolean bool = super.insert(paramk);
    if (bool)
    {
      a.b localb = new a.b();
      localb.userId = paramk.field_userId;
      localb.oyu = a.a.oyq;
      localb.oyv = paramk;
      this.ovQ.event(localb);
      this.ovQ.doNotify();
    }
    AppMethodBeat.o(124283);
    return bool;
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(124284);
    Log.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
    if (paramk == null)
    {
      Log.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(124284);
      return false;
    }
    if ((paramk == null) || (Util.isNullOrNil(paramk.field_userName))) {
      Log.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramk);
      if (bool)
      {
        a.b localb = new a.b();
        localb.userId = paramk.field_userId;
        localb.oyu = a.a.oys;
        localb.oyv = paramk;
        this.ovQ.event(localb);
        this.ovQ.doNotify();
      }
      AppMethodBeat.o(124284);
      return bool;
      paramk.field_userNamePY = com.tencent.mm.platformtools.f.RZ(paramk.field_userName);
    }
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(124288);
    Log.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
    k localk = hM(paramk.field_userId);
    if (localk != null)
    {
      if ((!Util.isNullOrNil(paramk.field_userName)) && (!paramk.field_userName.equals(localk.field_userName)))
      {
        localk.field_userName = paramk.field_userName;
        b(localk);
        AppMethodBeat.o(124288);
      }
    }
    else {
      a(paramk);
    }
    AppMethodBeat.o(124288);
  }
  
  public final k hM(String paramString)
  {
    AppMethodBeat.i(124282);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
      AppMethodBeat.o(124282);
      return null;
    }
    k localk = new k();
    localk.field_userId = paramString;
    super.get(localk, new String[0]);
    AppMethodBeat.o(124282);
    return localk;
  }
  
  public final String hN(String paramString)
  {
    AppMethodBeat.i(124287);
    if (paramString == null)
    {
      Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
      AppMethodBeat.o(124287);
      return null;
    }
    Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[] { paramString });
    if ((this.oxD.containsKey(paramString)) && (this.oxD.get(paramString) != null))
    {
      paramString = (String)this.oxD.get(paramString);
      AppMethodBeat.o(124287);
      return paramString;
    }
    f localf = af.bHk().Nj(paramString);
    if (localf != null)
    {
      Log.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[] { paramString, localf.field_userId });
      this.oxD.put(paramString, localf.field_userId);
      paramString = localf.field_userId;
      AppMethodBeat.o(124287);
      return paramString;
    }
    Log.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[] { paramString });
    AppMethodBeat.o(124287);
    return null;
  }
  
  public static enum a$a
  {
    static
    {
      AppMethodBeat.i(124280);
      oyq = new a("INSTERT", 0);
      oyr = new a("DELETE", 1);
      oys = new a("UPDATE", 2);
      oyt = new a[] { oyq, oyr, oys };
      AppMethodBeat.o(124280);
    }
    
    private a$a() {}
  }
  
  public static final class a$b
  {
    public l.a.a oyu;
    public k oyv;
    public String userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.l
 * JD-Core Version:    0.7.0.1
 */