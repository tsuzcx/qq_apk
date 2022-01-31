package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class p
  extends j<WxaAttributes>
{
  public static final String[] fkl;
  final e db;
  
  static
  {
    AppMethodBeat.i(94153);
    fkl = new String[] { j.getCreateSQLs(WxaAttributes.gUb, "WxaAttributesTable") };
    AppMethodBeat.o(94153);
  }
  
  public p(e parame)
  {
    super(parame, WxaAttributes.gUb, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
    this.db = parame;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(94148);
    if (!bo.isNullOrNil(paramWxaAttributes.field_username)) {
      paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    }
    paramBoolean = super.delete(paramWxaAttributes, paramBoolean, paramVarArgs);
    AppMethodBeat.o(94148);
    return paramBoolean;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, String... paramVarArgs)
  {
    AppMethodBeat.i(94147);
    int i;
    if (!bo.Q(paramVarArgs)) {
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
        AppMethodBeat.o(94147);
        return bool;
      }
      i += 1;
    }
  }
  
  private static boolean bK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(94146);
    boolean bool = bo.nullAsNil(paramString1).equals(bo.nullAsNil(paramString2));
    AppMethodBeat.o(94146);
    return bool;
  }
  
  final long Ah(String paramString)
  {
    AppMethodBeat.i(94138);
    paramString = d(paramString, new String[] { "syncTimeSecond" });
    if (paramString == null)
    {
      AppMethodBeat.o(94138);
      return 0L;
    }
    long l = paramString.field_syncTimeSecond;
    AppMethodBeat.o(94138);
    return l;
  }
  
  final b Ai(String paramString)
  {
    AppMethodBeat.i(94139);
    paramString = d(paramString, new String[] { "syncVersion" });
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = bo.apQ(bo.nullAsNil(paramString.field_syncVersion)))
    {
      paramString = new b(paramString);
      AppMethodBeat.o(94139);
      return paramString;
    }
  }
  
  public final boolean Aj(String paramString)
  {
    AppMethodBeat.i(94140);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
      AppMethodBeat.o(94140);
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    boolean bool = a(localWxaAttributes, false, new String[0]);
    AppMethodBeat.o(94140);
    return bool;
  }
  
  protected boolean a(WxaAttributes paramWxaAttributes, daa paramdaa)
  {
    AppMethodBeat.i(94145);
    if (("NickName".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = bo.nullAsNil(paramdaa.qsu);
      AppMethodBeat.o(94145);
      return true;
    }
    if (("BrandIconURL".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = paramdaa.qsu;
      AppMethodBeat.o(94145);
      return true;
    }
    if (("BigHeadImgUrl".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = paramdaa.qsu;
      AppMethodBeat.o(94145);
      return true;
    }
    if (("SmallHeadImgUrl".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = paramdaa.qsu;
      AppMethodBeat.o(94145);
      return true;
    }
    if (("Signature".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = paramdaa.qsu;
      AppMethodBeat.o(94145);
      return true;
    }
    if ("WxAppOpt".equals(paramdaa.wxP))
    {
      int i = bo.getInt(paramdaa.qsu, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        AppMethodBeat.o(94145);
        return true;
      }
    }
    if (("RegisterSource".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = paramdaa.qsu;
      AppMethodBeat.o(94145);
      return true;
    }
    if (("WxaAppInfo".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_appInfo))) {
      paramWxaAttributes.field_appInfo = paramdaa.qsu;
    }
    try
    {
      paramdaa = new JSONObject(paramdaa.qsu);
      paramWxaAttributes.field_appId = paramdaa.getString("Appid");
      paramWxaAttributes.field_roundedSquareIconURL = paramdaa.getString("RoundedSquareIconUrl");
      paramWxaAttributes.field_shortNickname = paramdaa.optString("ShortNickName");
      label371:
      AppMethodBeat.o(94145);
      return true;
      if (("WxaAppVersionInfo".equalsIgnoreCase(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_versionInfo)))
      {
        paramWxaAttributes.field_versionInfo = paramdaa.qsu;
        AppMethodBeat.o(94145);
        return true;
      }
      if (("BindWxaInfo".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_bindWxaInfo)))
      {
        paramWxaAttributes.field_bindWxaInfo = paramdaa.qsu;
        AppMethodBeat.o(94145);
        return true;
      }
      if (("WxaAppDynamic".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_dynamicInfo)))
      {
        paramWxaAttributes.field_dynamicInfo = paramdaa.qsu;
        AppMethodBeat.o(94145);
        return true;
      }
      if (("MMBizMenu".equals(paramdaa.wxP)) && (!bK(paramdaa.qsu, paramWxaAttributes.field_bizMenu)))
      {
        paramWxaAttributes.field_bizMenu = paramdaa.qsu;
        AppMethodBeat.o(94145);
        return true;
      }
      AppMethodBeat.o(94145);
      return false;
    }
    catch (Exception paramWxaAttributes)
    {
      break label371;
    }
  }
  
  public boolean a(String paramString, b paramb, List<daa> paramList)
  {
    AppMethodBeat.i(94144);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(94144);
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
        paramList = (daa)paramString.next();
        if (paramList != null) {
          bool = a(localWxaAttributes, paramList) | bool;
        }
      }
    }
    if (bool)
    {
      if (i != 0) {
        insert(localWxaAttributes);
      }
    }
    else
    {
      localWxaAttributes.field_syncTimeSecond = bo.aox();
      if (paramb != null) {
        break label194;
      }
    }
    label194:
    for (paramString = new byte[0];; paramString = paramb.pW)
    {
      localWxaAttributes.field_syncVersion = bo.cg(paramString);
      update(localWxaAttributes, new String[] { "username" });
      AppMethodBeat.o(94144);
      return bool;
      update(localWxaAttributes, new String[] { "username" });
      break;
    }
  }
  
  public final boolean ayz()
  {
    AppMethodBeat.i(94137);
    if ((this.db != null) && (!this.db.dun()))
    {
      AppMethodBeat.o(94137);
      return true;
    }
    AppMethodBeat.o(94137);
    return false;
  }
  
  public final WxaAttributes d(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94141);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94141);
      return null;
    }
    if (!paramString.endsWith("@app"))
    {
      AppMethodBeat.o(94141);
      return null;
    }
    Object localObject2 = this.db;
    if (bo.Q(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((e)localObject2).a("WxaAttributesTable", paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "usernameHash" }), new String[] { String.valueOf(paramString.hashCode()) }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(94141);
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
    AppMethodBeat.o(94141);
    return paramVarArgs;
  }
  
  public final WxaAttributes e(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94142);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94142);
      return null;
    }
    Object localObject2 = this.db;
    if (bo.Q(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((e)localObject2).a("WxaAttributesTable", paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(94142);
      return null;
    }
    paramVarArgs = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new WxaAttributes();
      paramVarArgs.convertFrom((Cursor)localObject2);
      paramVarArgs.field_appId = paramString;
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(94142);
    return paramVarArgs;
  }
  
  protected boolean k(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94143);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94143);
      return false;
    }
    Object localObject = d(paramString, new String[] { "appOpt" });
    if (localObject == null)
    {
      AppMethodBeat.o(94143);
      return false;
    }
    int i = ((WxaAttributes)localObject).field_appOpt;
    if (!paramBoolean) {}
    for (paramInt = i & (paramInt ^ 0xFFFFFFFF);; paramInt = i | paramInt)
    {
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("appOpt", Integer.valueOf(paramInt));
      if (this.db.update("WxaAttributesTable", (ContentValues)localObject, String.format("%s=?", new Object[] { "username" }), new String[] { paramString }) <= 0) {
        break;
      }
      AppMethodBeat.o(94143);
      return true;
    }
    AppMethodBeat.o(94143);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */