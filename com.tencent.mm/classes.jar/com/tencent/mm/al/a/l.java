package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  public e db;
  final com.tencent.mm.sdk.e.l<l.a, a.b> hSD;
  Map<String, String> hUt;
  
  static
  {
    AppMethodBeat.i(124291);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "BizChatUserInfo") };
    AppMethodBeat.o(124291);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "BizChatUserInfo", null);
    AppMethodBeat.i(124281);
    this.hUt = new HashMap();
    this.hSD = new com.tencent.mm.sdk.e.l() {};
    this.db = parame;
    parame.execSQL("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
    this.hUt.clear();
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
  
  public final int Fc(String paramString)
  {
    AppMethodBeat.i(124285);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
      AppMethodBeat.o(124285);
      return -1;
    }
    paramString = eP(paramString);
    if (paramString != null)
    {
      int i = paramString.field_UserVersion;
      AppMethodBeat.o(124285);
      return i;
    }
    ae.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
    AppMethodBeat.o(124285);
    return -1;
  }
  
  public final k Fd(String paramString)
  {
    AppMethodBeat.i(124286);
    if (paramString == null)
    {
      ae.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
      AppMethodBeat.o(124286);
      return null;
    }
    paramString = eQ(paramString);
    if (paramString == null)
    {
      ae.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
      AppMethodBeat.o(124286);
      return null;
    }
    paramString = eP(paramString);
    AppMethodBeat.o(124286);
    return paramString;
  }
  
  public final boolean a(k paramk)
  {
    AppMethodBeat.i(124283);
    ae.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
    if (paramk == null)
    {
      ae.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
      AppMethodBeat.o(124283);
      return false;
    }
    boolean bool = super.insert(paramk);
    if (bool)
    {
      a.b localb = new a.b();
      localb.userId = paramk.field_userId;
      localb.hVk = a.a.hVg;
      localb.hVl = paramk;
      this.hSD.dW(localb);
      this.hSD.doNotify();
    }
    AppMethodBeat.o(124283);
    return bool;
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(124284);
    ae.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
    if (paramk == null)
    {
      ae.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(124284);
      return false;
    }
    if ((paramk == null) || (bu.isNullOrNil(paramk.field_userName))) {
      ae.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramk);
      if (bool)
      {
        a.b localb = new a.b();
        localb.userId = paramk.field_userId;
        localb.hVk = a.a.hVi;
        localb.hVl = paramk;
        this.hSD.dW(localb);
        this.hSD.doNotify();
      }
      AppMethodBeat.o(124284);
      return bool;
      paramk.field_userNamePY = com.tencent.mm.platformtools.f.Jk(paramk.field_userName);
    }
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(124288);
    ae.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
    k localk = eP(paramk.field_userId);
    if (localk != null)
    {
      if ((!bu.isNullOrNil(paramk.field_userName)) && (!paramk.field_userName.equals(localk.field_userName)))
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
  
  public final k eP(String paramString)
  {
    AppMethodBeat.i(124282);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
      AppMethodBeat.o(124282);
      return null;
    }
    k localk = new k();
    localk.field_userId = paramString;
    super.get(localk, new String[0]);
    AppMethodBeat.o(124282);
    return localk;
  }
  
  public final String eQ(String paramString)
  {
    AppMethodBeat.i(124287);
    if (paramString == null)
    {
      ae.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
      AppMethodBeat.o(124287);
      return null;
    }
    ae.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[] { paramString });
    if ((this.hUt.containsKey(paramString)) && (this.hUt.get(paramString) != null))
    {
      paramString = (String)this.hUt.get(paramString);
      AppMethodBeat.o(124287);
      return paramString;
    }
    f localf = ag.aGu().Fa(paramString);
    if (localf != null)
    {
      ae.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[] { paramString, localf.field_userId });
      this.hUt.put(paramString, localf.field_userId);
      paramString = localf.field_userId;
      AppMethodBeat.o(124287);
      return paramString;
    }
    ae.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[] { paramString });
    AppMethodBeat.o(124287);
    return null;
  }
  
  public static enum a$a
  {
    static
    {
      AppMethodBeat.i(124280);
      hVg = new a("INSTERT", 0);
      hVh = new a("DELETE", 1);
      hVi = new a("UPDATE", 2);
      hVj = new a[] { hVg, hVh, hVi };
      AppMethodBeat.o(124280);
    }
    
    private a$a() {}
  }
  
  public static final class a$b
  {
    public l.a.a hVk;
    public k hVl;
    public String userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.l
 * JD-Core Version:    0.7.0.1
 */