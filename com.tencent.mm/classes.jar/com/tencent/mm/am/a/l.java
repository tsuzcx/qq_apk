package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  public e db;
  final com.tencent.mm.sdk.e.l<l.a, a.b> hPL;
  Map<String, String> hRB;
  
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
    this.hRB = new HashMap();
    this.hPL = new com.tencent.mm.sdk.e.l() {};
    this.db = parame;
    parame.execSQL("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
    this.hRB.clear();
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
  
  public final int EA(String paramString)
  {
    AppMethodBeat.i(124285);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
      AppMethodBeat.o(124285);
      return -1;
    }
    paramString = eK(paramString);
    if (paramString != null)
    {
      int i = paramString.field_UserVersion;
      AppMethodBeat.o(124285);
      return i;
    }
    ad.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
    AppMethodBeat.o(124285);
    return -1;
  }
  
  public final k EB(String paramString)
  {
    AppMethodBeat.i(124286);
    if (paramString == null)
    {
      ad.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
      AppMethodBeat.o(124286);
      return null;
    }
    paramString = eL(paramString);
    if (paramString == null)
    {
      ad.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
      AppMethodBeat.o(124286);
      return null;
    }
    paramString = eK(paramString);
    AppMethodBeat.o(124286);
    return paramString;
  }
  
  public final boolean a(k paramk)
  {
    AppMethodBeat.i(124283);
    ad.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
    if (paramk == null)
    {
      ad.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
      AppMethodBeat.o(124283);
      return false;
    }
    boolean bool = super.insert(paramk);
    if (bool)
    {
      a.b localb = new a.b();
      localb.userId = paramk.field_userId;
      localb.hSs = a.a.hSo;
      localb.hSt = paramk;
      this.hPL.dV(localb);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124283);
    return bool;
  }
  
  public final boolean b(k paramk)
  {
    AppMethodBeat.i(124284);
    ad.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
    if (paramk == null)
    {
      ad.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(124284);
      return false;
    }
    if ((paramk == null) || (bt.isNullOrNil(paramk.field_userName))) {
      ad.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramk);
      if (bool)
      {
        a.b localb = new a.b();
        localb.userId = paramk.field_userId;
        localb.hSs = a.a.hSq;
        localb.hSt = paramk;
        this.hPL.dV(localb);
        this.hPL.doNotify();
      }
      AppMethodBeat.o(124284);
      return bool;
      paramk.field_userNamePY = com.tencent.mm.platformtools.f.IL(paramk.field_userName);
    }
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(124288);
    ad.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
    k localk = eK(paramk.field_userId);
    if (localk != null)
    {
      if ((!bt.isNullOrNil(paramk.field_userName)) && (!paramk.field_userName.equals(localk.field_userName)))
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
  
  public final k eK(String paramString)
  {
    AppMethodBeat.i(124282);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
      AppMethodBeat.o(124282);
      return null;
    }
    k localk = new k();
    localk.field_userId = paramString;
    super.get(localk, new String[0]);
    AppMethodBeat.o(124282);
    return localk;
  }
  
  public final String eL(String paramString)
  {
    AppMethodBeat.i(124287);
    if (paramString == null)
    {
      ad.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
      AppMethodBeat.o(124287);
      return null;
    }
    ad.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[] { paramString });
    if ((this.hRB.containsKey(paramString)) && (this.hRB.get(paramString) != null))
    {
      paramString = (String)this.hRB.get(paramString);
      AppMethodBeat.o(124287);
      return paramString;
    }
    f localf = ag.aGe().Ey(paramString);
    if (localf != null)
    {
      ad.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[] { paramString, localf.field_userId });
      this.hRB.put(paramString, localf.field_userId);
      paramString = localf.field_userId;
      AppMethodBeat.o(124287);
      return paramString;
    }
    ad.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[] { paramString });
    AppMethodBeat.o(124287);
    return null;
  }
  
  public static enum a$a
  {
    static
    {
      AppMethodBeat.i(124280);
      hSo = new a("INSTERT", 0);
      hSp = new a("DELETE", 1);
      hSq = new a("UPDATE", 2);
      hSr = new a[] { hSo, hSp, hSq };
      AppMethodBeat.o(124280);
    }
    
    private a$a() {}
  }
  
  public static final class a$b
  {
    public l.a.a hSs;
    public k hSt;
    public String userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.l
 * JD-Core Version:    0.7.0.1
 */