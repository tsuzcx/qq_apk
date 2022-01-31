package com.tencent.mm.ai.a;

import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  extends i<j>
{
  public static final String[] dXp = { i.a(j.buS, "BizChatUserInfo") };
  public e dXw;
  final com.tencent.mm.sdk.e.k<a, k.a.b> eeJ = new k.1(this);
  Map<String, String> eho = new HashMap();
  
  public k(e parame)
  {
    super(parame, j.buS, "BizChatUserInfo", null);
    this.dXw = parame;
    parame.gk("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
    this.eho.clear();
  }
  
  public static String a(String[] paramArrayOfString, List<String> paramList)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
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
    return localStringBuilder.toString();
  }
  
  public final boolean a(j paramj)
  {
    y.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
    boolean bool1;
    if (paramj == null)
    {
      y.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = super.b(paramj);
      bool1 = bool2;
    } while (!bool2);
    k.a.b localb = new k.a.b();
    localb.userId = paramj.field_userId;
    localb.ehY = k.a.a.ehU;
    localb.ehZ = paramj;
    this.eeJ.bV(localb);
    this.eeJ.doNotify();
    return bool2;
  }
  
  public final boolean b(j paramj)
  {
    y.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
    boolean bool1;
    if (paramj == null)
    {
      y.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
      bool1 = false;
      return bool1;
    }
    if ((paramj == null) || (bk.bl(paramj.field_userName))) {
      y.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool2 = super.a(paramj);
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      k.a.b localb = new k.a.b();
      localb.userId = paramj.field_userId;
      localb.ehY = k.a.a.ehW;
      localb.ehZ = paramj;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
      return bool2;
      paramj.field_userNamePY = com.tencent.mm.platformtools.g.oY(paramj.field_userName);
    }
  }
  
  public final j bY(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
      return null;
    }
    j localj = new j();
    localj.field_userId = paramString;
    super.b(localj, new String[0]);
    return localj;
  }
  
  public final String bZ(String paramString)
  {
    if (paramString == null)
    {
      y.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
      return null;
    }
    y.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[] { paramString });
    if ((this.eho.containsKey(paramString)) && (this.eho.get(paramString) != null)) {
      return (String)this.eho.get(paramString);
    }
    f localf = z.MD().lz(paramString);
    if (localf != null)
    {
      y.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[] { paramString, localf.field_userId });
      this.eho.put(paramString, localf.field_userId);
      return localf.field_userId;
    }
    y.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[] { paramString });
    return null;
  }
  
  public final void c(j paramj)
  {
    y.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
    j localj = bY(paramj.field_userId);
    if (localj != null)
    {
      if ((!bk.bl(paramj.field_userName)) && (!paramj.field_userName.equals(localj.field_userName)))
      {
        localj.field_userName = paramj.field_userName;
        b(localj);
      }
      return;
    }
    a(paramj);
  }
  
  public final j lB(String paramString)
  {
    if (paramString == null)
    {
      y.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
      return null;
    }
    paramString = bZ(paramString);
    if (paramString == null)
    {
      y.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
      return null;
    }
    return bY(paramString);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.k
 * JD-Core Version:    0.7.0.1
 */