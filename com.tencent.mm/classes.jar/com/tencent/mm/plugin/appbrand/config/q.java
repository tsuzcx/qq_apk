package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.bv.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cmj;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class q
  extends com.tencent.mm.sdk.e.i<WxaAttributes>
{
  final com.tencent.mm.cf.h dXo;
  
  public q(com.tencent.mm.cf.h paramh)
  {
    super(paramh, WxaAttributes.fCU, "WxaAttributesTable", WxaAttributes.cqY);
    this.dXo = paramh;
    Cursor localCursor;
    if ((ael()) && (!com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.utl, false)))
    {
      y.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
      localCursor = paramh.a("select appInfo from WxaAttributesTable", null, 2);
      if ((localCursor == null) || (localCursor.isClosed())) {
        y.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
      }
    }
    else
    {
      return;
    }
    if (localCursor.moveToFirst())
    {
      Object localObject1 = new LinkedList();
      Object localObject2 = localCursor.getString(0);
      if (!bk.bl((String)localObject2)) {}
      for (;;)
      {
        try
        {
          localObject3 = new JSONObject((String)localObject2);
          localObject2 = ((JSONObject)localObject3).optString("Appid");
          localObject3 = ((JSONObject)localObject3).optString("RoundedSquareIconUrl");
          if (!bk.bl((String)localObject2))
          {
            boolean bool = bk.bl((String)localObject3);
            if (!bool) {
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject3;
          long l;
          ContentValues localContentValues;
          continue;
          paramh.hI(l);
          y.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
        }
        if (localCursor.moveToNext()) {
          break;
        }
        localCursor.close();
        l = paramh.eV(Thread.currentThread().getId());
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (Pair)((Iterator)localObject1).next();
        paramh.update("WxaAttributesTable", (ContentValues)((Pair)localObject2).second, "appId=?", new String[] { (String)((Pair)localObject2).first });
        continue;
        localContentValues = new ContentValues(1);
        localContentValues.put("roundedSquareIconURL", (String)localObject3);
        ((List)localObject1).add(Pair.create(localObject2, localContentValues));
      }
    }
    for (;;)
    {
      if (!localCursor.isClosed()) {
        localCursor.close();
      }
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.utl, Boolean.valueOf(true));
      return;
      y.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  private static boolean a(WxaAttributes paramWxaAttributes, cmj paramcmj)
  {
    if (("NickName".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = bk.pm(paramcmj.nFs);
      return true;
    }
    if (("BrandIconURL".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = paramcmj.nFs;
      return true;
    }
    if (("BigHeadImgUrl".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = paramcmj.nFs;
      return true;
    }
    if (("SmallHeadImgUrl".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = paramcmj.nFs;
      return true;
    }
    if (("Signature".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = paramcmj.nFs;
      return true;
    }
    if ("WxAppOpt".equals(paramcmj.sCH))
    {
      int i = bk.getInt(paramcmj.nFs, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        return true;
      }
    }
    if (("RegisterSource".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = paramcmj.nFs;
      return true;
    }
    if (("WxaAppInfo".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_appInfo)))
    {
      paramWxaAttributes.field_appInfo = paramcmj.nFs;
      try
      {
        paramcmj = new JSONObject(paramcmj.nFs);
        paramWxaAttributes.field_appId = paramcmj.getString("Appid");
        paramWxaAttributes.field_roundedSquareIconURL = paramcmj.getString("RoundedSquareIconUrl");
        paramWxaAttributes.field_shortNickname = paramcmj.optString("ShortNickName");
        paramcmj = o.m(paramcmj);
        n.b(paramWxaAttributes.field_appId, paramcmj.swv);
        return true;
      }
      catch (Exception paramWxaAttributes)
      {
        return true;
      }
    }
    if (("WxaAppVersionInfo".equalsIgnoreCase(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_versionInfo)))
    {
      paramWxaAttributes.field_versionInfo = paramcmj.nFs;
      return true;
    }
    if (("BindWxaInfo".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_bindWxaInfo)))
    {
      paramWxaAttributes.field_bindWxaInfo = paramcmj.nFs;
      return true;
    }
    if (("WxaAppDynamic".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_dynamicInfo)))
    {
      paramWxaAttributes.field_dynamicInfo = paramcmj.nFs;
      return true;
    }
    if (("MMBizMenu".equals(paramcmj.sCH)) && (!bj(paramcmj.nFs, paramWxaAttributes.field_bizMenu)))
    {
      paramWxaAttributes.field_bizMenu = paramcmj.nFs;
      return true;
    }
    return false;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, String... paramVarArgs)
  {
    int i;
    if (!bk.H(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("username"))
        {
          paramVarArgs[i] = "usernameHash";
          paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
        }
      }
      else {
        return super.b(paramWxaAttributes, paramVarArgs);
      }
      i += 1;
    }
  }
  
  private static boolean bj(String paramString1, String paramString2)
  {
    return bk.pm(paramString1).equals(bk.pm(paramString2));
  }
  
  public final boolean a(String paramString, b paramb, List<cmj> paramList)
  {
    if (bk.dk(paramList)) {
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    if (!a(localWxaAttributes, new String[] { "username" })) {}
    boolean bool;
    for (i = 1;; i = 0)
    {
      paramString = paramList.iterator();
      bool = false;
      while (paramString.hasNext())
      {
        paramList = (cmj)paramString.next();
        if (paramList != null) {
          bool = a(localWxaAttributes, paramList) | bool;
        }
      }
    }
    if (bool)
    {
      if (i == 0) {
        break label442;
      }
      b(localWxaAttributes);
    }
    for (;;)
    {
      try
      {
        if (!com.tencent.mm.kernel.g.DK()) {
          continue;
        }
        paramList = localWxaAttributes.field_username;
        str1 = localWxaAttributes.field_nickname;
        str2 = localWxaAttributes.field_bigHeadURL;
        str3 = localWxaAttributes.field_smallHeadURL;
        paramString = com.tencent.mm.ag.o.Kh().kp(paramList);
        if (paramString != null) {
          continue;
        }
        paramString = new com.tencent.mm.ag.h();
        i = 1;
      }
      catch (Exception paramString)
      {
        String str1;
        String str2;
        String str3;
        label442:
        y.printErrStackTrace("MicroMsg.WxaAttrStorage", paramString, "flushContactInMainDB", new Object[0]);
        continue;
        paramString = paramb.oY;
        continue;
        i = 0;
        continue;
        continue;
        i = 0;
        continue;
      }
      if (!bk.pm(str3).equals(paramString.JY()))
      {
        paramString.ebS = str3;
        i = 1;
      }
      if (!bk.pm(str2).equals(paramString.JX()))
      {
        paramString.ebT = str2;
        i = 1;
      }
      if (i != 0)
      {
        paramString.username = paramList;
        paramString.bK(true);
        paramString.bcw = 31;
        com.tencent.mm.ag.o.Kh().a(paramString);
      }
      paramString = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramList);
      if (paramString != null) {
        continue;
      }
      paramString = new ad();
      if ((int)paramString.dBe != 0) {
        continue;
      }
      paramString.setUsername(paramList);
      i = 1;
      if (!str1.equals(paramString.field_nickname))
      {
        paramString.dk(str1);
        paramString.dl(com.tencent.mm.platformtools.g.oZ(str1));
        paramString.dm(com.tencent.mm.platformtools.g.oY(str1));
        i = 1;
      }
      if (i != 0) {
        ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().T(paramString);
      }
      paramString = localWxaAttributes.aep();
      if ((paramString != null) && (paramString.fPB == 0)) {
        com.tencent.mm.plugin.appbrand.app.e.abb().a(localWxaAttributes.field_appId, localWxaAttributes.aep());
      }
      localWxaAttributes.field_syncTimeSecond = bk.UX();
      if (paramb != null) {
        continue;
      }
      paramString = new byte[0];
      localWxaAttributes.field_syncVersion = bk.bG(paramString);
      c(localWxaAttributes, new String[] { "username" });
      return bool;
      c(localWxaAttributes, new String[] { "username" });
    }
  }
  
  public final boolean ael()
  {
    return (this.dXo != null) && (!this.dXo.csp());
  }
  
  public final WxaAttributes d(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    if (bk.bl(paramString)) {}
    while (!paramString.endsWith("@app")) {
      return null;
    }
    Object localObject2 = this.dXo;
    if (bk.H(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.cf.h)localObject2).a("WxaAttributesTable", paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "usernameHash" }), new String[] { String.valueOf(paramString.hashCode()) }, null, null, null, 2);
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = localObject1;
      if (((Cursor)localObject2).moveToFirst())
      {
        paramVarArgs = new WxaAttributes();
        paramVarArgs.d((Cursor)localObject2);
        paramVarArgs.field_username = paramString;
      }
      ((Cursor)localObject2).close();
      return paramVarArgs;
    }
  }
  
  public final WxaAttributes e(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject2 = this.dXo;
    if (bk.H(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.cf.h)localObject2).a("WxaAttributesTable", paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null, null, 2);
      if (localObject2 == null) {
        break;
      }
      paramVarArgs = localObject1;
      if (((Cursor)localObject2).moveToFirst())
      {
        paramVarArgs = new WxaAttributes();
        paramVarArgs.d((Cursor)localObject2);
        paramVarArgs.field_appId = paramString;
      }
      ((Cursor)localObject2).close();
      return paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */