package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  extends com.tencent.mm.sdk.e.j<j>
{
  public static final String[] SQL_CREATE;
  public e db;
  final l<k.a, k.a.b> fuL;
  Map<String, String> fxs;
  
  static
  {
    AppMethodBeat.i(11605);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(j.info, "BizChatUserInfo") };
    AppMethodBeat.o(11605);
  }
  
  public k(e parame)
  {
    super(parame, j.info, "BizChatUserInfo", null);
    AppMethodBeat.i(11595);
    this.fxs = new HashMap();
    this.fuL = new k.1(this);
    this.db = parame;
    parame.execSQL("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
    this.fxs.clear();
    AppMethodBeat.o(11595);
  }
  
  public static String a(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(11603);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(11603);
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
    AppMethodBeat.o(11603);
    return paramArrayOfString;
  }
  
  public final boolean a(j paramj)
  {
    AppMethodBeat.i(11597);
    ab.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
    if (paramj == null)
    {
      ab.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
      AppMethodBeat.o(11597);
      return false;
    }
    boolean bool = super.insert(paramj);
    if (bool)
    {
      k.a.b localb = new k.a.b();
      localb.userId = paramj.field_userId;
      localb.fyc = k.a.a.fxY;
      localb.fyd = paramj;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11597);
    return bool;
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(11598);
    ab.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
    if (paramj == null)
    {
      ab.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(11598);
      return false;
    }
    if ((paramj == null) || (bo.isNullOrNil(paramj.field_userName))) {
      ab.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.replace(paramj);
      if (bool)
      {
        k.a.b localb = new k.a.b();
        localb.userId = paramj.field_userId;
        localb.fyc = k.a.a.fya;
        localb.fyd = paramj;
        this.fuL.cy(localb);
        this.fuL.doNotify();
      }
      AppMethodBeat.o(11598);
      return bool;
      paramj.field_userNamePY = com.tencent.mm.platformtools.g.wq(paramj.field_userName);
    }
  }
  
  public final void c(j paramj)
  {
    AppMethodBeat.i(11602);
    ab.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
    j localj = df(paramj.field_userId);
    if (localj != null)
    {
      if ((!bo.isNullOrNil(paramj.field_userName)) && (!paramj.field_userName.equals(localj.field_userName)))
      {
        localj.field_userName = paramj.field_userName;
        b(localj);
        AppMethodBeat.o(11602);
      }
    }
    else {
      a(paramj);
    }
    AppMethodBeat.o(11602);
  }
  
  public final j df(String paramString)
  {
    AppMethodBeat.i(11596);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
      AppMethodBeat.o(11596);
      return null;
    }
    j localj = new j();
    localj.field_userId = paramString;
    super.get(localj, new String[0]);
    AppMethodBeat.o(11596);
    return localj;
  }
  
  public final String dg(String paramString)
  {
    AppMethodBeat.i(11601);
    if (paramString == null)
    {
      ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
      AppMethodBeat.o(11601);
      return null;
    }
    ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[] { paramString });
    if ((this.fxs.containsKey(paramString)) && (this.fxs.get(paramString) != null))
    {
      paramString = (String)this.fxs.get(paramString);
      AppMethodBeat.o(11601);
      return paramString;
    }
    f localf = z.afn().sv(paramString);
    if (localf != null)
    {
      ab.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[] { paramString, localf.field_userId });
      this.fxs.put(paramString, localf.field_userId);
      paramString = localf.field_userId;
      AppMethodBeat.o(11601);
      return paramString;
    }
    ab.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[] { paramString });
    AppMethodBeat.o(11601);
    return null;
  }
  
  public final int sx(String paramString)
  {
    AppMethodBeat.i(11599);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
      AppMethodBeat.o(11599);
      return -1;
    }
    paramString = df(paramString);
    if (paramString != null)
    {
      int i = paramString.field_UserVersion;
      AppMethodBeat.o(11599);
      return i;
    }
    ab.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
    AppMethodBeat.o(11599);
    return -1;
  }
  
  public final j sy(String paramString)
  {
    AppMethodBeat.i(11600);
    if (paramString == null)
    {
      ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
      AppMethodBeat.o(11600);
      return null;
    }
    paramString = dg(paramString);
    if (paramString == null)
    {
      ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
      AppMethodBeat.o(11600);
      return null;
    }
    paramString = df(paramString);
    AppMethodBeat.o(11600);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.a.k
 * JD-Core Version:    0.7.0.1
 */