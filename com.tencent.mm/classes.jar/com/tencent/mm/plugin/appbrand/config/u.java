package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.eif;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class u
  extends j<WxaAttributes>
{
  final e db;
  
  public u(e parame, String paramString, String[] paramArrayOfString)
  {
    super(parame, WxaAttributes.jJU, paramString, paramArrayOfString);
    this.db = parame;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(220753);
    paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    super.insertNotify(paramWxaAttributes, false);
    if (d(paramWxaAttributes.field_username, new String[] { "appId" }) != null) {}
    for (;;)
    {
      if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
        doNotify("single", 2, paramWxaAttributes.field_username);
      }
      AppMethodBeat.o(220753);
      return bool;
      bool = false;
    }
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(220754);
    int i;
    if (!bu.V(paramVarArgs)) {
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
      else
      {
        boolean bool = super.updateNotify(paramWxaAttributes, false, paramVarArgs);
        if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
          doNotify("single", 3, paramWxaAttributes.field_username);
        }
        AppMethodBeat.o(220754);
        return bool;
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString, b paramb, List<eic> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(220752);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(220752);
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    if (!a(localWxaAttributes, new String[] { "username" })) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      paramString = paramList.iterator();
      bool = false;
      while (paramString.hasNext())
      {
        paramList = (eic)paramString.next();
        if (paramList != null) {
          bool = a(localWxaAttributes, paramList) | bool;
        }
      }
    }
    localWxaAttributes.field_syncTimeSecond = bu.aRi();
    if (paramb == null)
    {
      paramString = new byte[0];
      localWxaAttributes.field_syncVersion = bu.cH(paramString);
      if (!bool) {
        break label190;
      }
      if (i == 0) {
        break label169;
      }
      a(localWxaAttributes, paramBoolean);
    }
    for (;;)
    {
      AppMethodBeat.o(220752);
      return bool;
      paramString = paramb.zr;
      break;
      label169:
      a(localWxaAttributes, paramBoolean, new String[] { "username" });
      continue;
      label190:
      a(localWxaAttributes, false, new String[] { "username" });
    }
  }
  
  private boolean b(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(146055);
    if (!bu.isNullOrNil(paramWxaAttributes.field_username)) {
      paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    }
    boolean bool = super.delete(paramWxaAttributes, false, paramVarArgs);
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
      doNotify("single", 5, paramWxaAttributes.field_username);
    }
    AppMethodBeat.o(146055);
    return bool;
  }
  
  private long beP()
  {
    AppMethodBeat.i(182788);
    if ((this.db instanceof f))
    {
      long l = ((f)this.db).yi(Thread.currentThread().getId());
      AppMethodBeat.o(182788);
      return l;
    }
    AppMethodBeat.o(182788);
    return -1L;
  }
  
  private static boolean cF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146053);
    boolean bool = bu.nullAsNil(paramString1).equals(bu.nullAsNil(paramString2));
    AppMethodBeat.o(146053);
    return bool;
  }
  
  private int sW(long paramLong)
  {
    AppMethodBeat.i(182789);
    if ((this.db instanceof f))
    {
      int i = ((f)this.db).sW(paramLong);
      AppMethodBeat.o(182789);
      return i;
    }
    AppMethodBeat.o(182789);
    return -1;
  }
  
  final b Oe(String paramString)
  {
    AppMethodBeat.i(146046);
    paramString = d(paramString, new String[] { "syncVersion" });
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = bu.aSx(bu.nullAsNil(paramString.field_syncVersion)))
    {
      paramString = new b(paramString);
      AppMethodBeat.o(146046);
      return paramString;
    }
  }
  
  public final boolean Of(String paramString)
  {
    AppMethodBeat.i(146047);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
      AppMethodBeat.o(146047);
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    boolean bool = b(localWxaAttributes, false, new String[0]);
    AppMethodBeat.o(146047);
    return bool;
  }
  
  protected boolean a(WxaAttributes paramWxaAttributes, eic parameic)
  {
    AppMethodBeat.i(146052);
    if (("NickName".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = bu.nullAsNil(parameic.yxn);
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BrandIconURL".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = parameic.yxn;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BigHeadImgUrl".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = parameic.yxn;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("SmallHeadImgUrl".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = parameic.yxn;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("Signature".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = parameic.yxn;
      AppMethodBeat.o(146052);
      return true;
    }
    if ("WxAppOpt".equals(parameic.uuW))
    {
      int i = bu.getInt(parameic.yxn, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        AppMethodBeat.o(146052);
        return true;
      }
    }
    if (("RegisterSource".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = parameic.yxn;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("WxaAppInfo".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_appInfo))) {
      paramWxaAttributes.field_appInfo = parameic.yxn;
    }
    try
    {
      parameic = new JSONObject(parameic.yxn);
      paramWxaAttributes.field_appId = parameic.getString("Appid");
      paramWxaAttributes.field_roundedSquareIconURL = parameic.getString("RoundedSquareIconUrl");
      paramWxaAttributes.field_shortNickname = parameic.optString("ShortNickName");
      label376:
      AppMethodBeat.o(146052);
      return true;
      if (("WxaAppVersionInfo".equalsIgnoreCase(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_versionInfo)))
      {
        paramWxaAttributes.field_versionInfo = parameic.yxn;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("BindWxaInfo".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_bindWxaInfo)))
      {
        paramWxaAttributes.field_bindWxaInfo = parameic.yxn;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("WxaAppDynamic".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_dynamicInfo)))
      {
        paramWxaAttributes.field_dynamicInfo = parameic.yxn;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("MMBizMenu".equals(parameic.uuW)) && (!cF(parameic.yxn, paramWxaAttributes.field_bizMenu)))
      {
        paramWxaAttributes.field_bizMenu = parameic.yxn;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("PassThroughInfo".equals(parameic.uuW)) && (!cF(parameic.uuW, paramWxaAttributes.field_passThroughInfo)))
      {
        paramWxaAttributes.field_passThroughInfo = parameic.yxn;
        AppMethodBeat.o(146052);
        return true;
      }
      AppMethodBeat.o(146052);
      return false;
    }
    catch (Exception paramWxaAttributes)
    {
      break label376;
    }
  }
  
  public final boolean a(WxaAttributes paramWxaAttributes, String... paramVarArgs)
  {
    AppMethodBeat.i(146054);
    int i;
    if (!bu.V(paramVarArgs)) {
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
      else
      {
        boolean bool = super.get(paramWxaAttributes, paramVarArgs);
        AppMethodBeat.o(146054);
        return bool;
      }
      i += 1;
    }
  }
  
  public final boolean a(kv paramkv, List<String> paramList)
  {
    AppMethodBeat.i(220751);
    long l = beP();
    LinkedList localLinkedList = new LinkedList();
    paramkv = paramkv.FVs.iterator();
    boolean bool1 = false;
    while (paramkv.hasNext())
    {
      eif localeif = (eif)paramkv.next();
      ae.i("MicroMsg.WxaAttrStorage", "batchSyncInGroup flushAttrs(%s)", new Object[] { localeif.Hhh });
      boolean bool2 = bool1 | a(localeif.Hhh, localeif.FZb, localeif.FZc, false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localeif.Hhh))
        {
          localLinkedList.add(localeif.Hhh);
          bool1 = bool2;
        }
      }
    }
    sW(l);
    if (localLinkedList.size() > 0)
    {
      if (paramList != null) {
        paramList.addAll(localLinkedList);
      }
      doNotify("batch", 3, localLinkedList);
    }
    AppMethodBeat.o(220751);
    return bool1;
  }
  
  public boolean a(String paramString, b paramb, List<eic> paramList)
  {
    AppMethodBeat.i(146051);
    boolean bool = a(paramString, paramb, paramList, true);
    AppMethodBeat.o(146051);
    return bool;
  }
  
  public final boolean beO()
  {
    AppMethodBeat.i(146045);
    if ((this.db != null) && (!this.db.fqe()))
    {
      AppMethodBeat.o(146045);
      return true;
    }
    AppMethodBeat.o(146045);
    return false;
  }
  
  public final WxaAttributes d(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(146048);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146048);
      return null;
    }
    if (!paramString.endsWith("@app"))
    {
      AppMethodBeat.o(146048);
      return null;
    }
    Object localObject2 = this.db;
    String str = getTableName();
    if (bu.V(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((e)localObject2).a(str, paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "usernameHash" }), new String[] { String.valueOf(paramString.hashCode()) }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(146048);
      return null;
    }
    paramVarArgs = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new WxaAttributes();
      paramVarArgs.convertFrom((Cursor)localObject2);
      paramVarArgs.field_username = paramString;
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(146048);
    return paramVarArgs;
  }
  
  public final WxaAttributes e(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(146049);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146049);
      return null;
    }
    Object localObject2 = this.db;
    String str = getTableName();
    if (bu.V(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((e)localObject2).a(str, paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      ae.e("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) null==cursor", new Object[] { paramString });
      AppMethodBeat.o(146049);
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new WxaAttributes();
      paramVarArgs.convertFrom((Cursor)localObject2);
      paramVarArgs.field_appId = paramString;
    }
    for (paramString = paramVarArgs;; paramString = localObject1)
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(146049);
      return paramString;
      ae.e("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) !cursor.moveToFirst()", new Object[] { paramString });
    }
  }
  
  protected boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146050);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146050);
      return false;
    }
    Object localObject = d(paramString, new String[] { "appOpt" });
    if (localObject == null)
    {
      AppMethodBeat.o(146050);
      return false;
    }
    int i = ((WxaAttributes)localObject).field_appOpt;
    if (!paramBoolean) {}
    for (paramInt = i & (paramInt ^ 0xFFFFFFFF);; paramInt = i | paramInt)
    {
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("appOpt", Integer.valueOf(paramInt));
      if (this.db.update(getTableName(), (ContentValues)localObject, String.format("%s=?", new Object[] { "username" }), new String[] { paramString }) <= 0) {
        break;
      }
      AppMethodBeat.o(146050);
      return true;
    }
    AppMethodBeat.o(146050);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.u
 * JD-Core Version:    0.7.0.1
 */