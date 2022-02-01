package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class t
  extends j<WxaAttributes>
{
  public static final String[] gLs;
  final e db;
  
  static
  {
    AppMethodBeat.i(146060);
    gLs = new String[] { j.getCreateSQLs(WxaAttributes.iMP, "WxaAttributesTable") };
    AppMethodBeat.o(146060);
  }
  
  public t(e parame)
  {
    super(parame, WxaAttributes.iMP, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
    this.db = parame;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(194589);
    paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    super.insertNotify(paramWxaAttributes, false);
    if (d("username", new String[] { "appId" }) != null) {}
    for (;;)
    {
      if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
        doNotify("single", 2, paramWxaAttributes.field_username);
      }
      AppMethodBeat.o(194589);
      return bool;
      bool = false;
    }
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(194590);
    int i;
    if (!bt.T(paramVarArgs)) {
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
        AppMethodBeat.o(194590);
        return bool;
      }
      i += 1;
    }
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, String... paramVarArgs)
  {
    AppMethodBeat.i(146054);
    int i;
    if (!bt.T(paramVarArgs)) {
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
  
  private boolean a(String paramString, b paramb, List<duq> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(194588);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(194588);
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
        paramList = (duq)paramString.next();
        if (paramList != null) {
          bool = a(localWxaAttributes, paramList) | bool;
        }
      }
    }
    localWxaAttributes.field_syncTimeSecond = bt.aGK();
    if (paramb == null)
    {
      paramString = new byte[0];
      localWxaAttributes.field_syncVersion = bt.cy(paramString);
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
      AppMethodBeat.o(194588);
      return bool;
      paramString = paramb.wA;
      break;
      label169:
      a(localWxaAttributes, paramBoolean, new String[] { "username" });
      continue;
      label190:
      a(localWxaAttributes, false, new String[] { "username" });
    }
  }
  
  private long aTK()
  {
    AppMethodBeat.i(182788);
    if ((this.db instanceof f))
    {
      long l = ((f)this.db).rb(Thread.currentThread().getId());
      AppMethodBeat.o(182788);
      return l;
    }
    AppMethodBeat.o(182788);
    return -1L;
  }
  
  private boolean b(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(146055);
    if (!bt.isNullOrNil(paramWxaAttributes.field_username)) {
      paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    }
    boolean bool = super.delete(paramWxaAttributes, false, paramVarArgs);
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
      doNotify("single", 5, paramWxaAttributes.field_username);
    }
    AppMethodBeat.o(146055);
    return bool;
  }
  
  private static boolean cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146053);
    boolean bool = bt.nullAsNil(paramString1).equals(bt.nullAsNil(paramString2));
    AppMethodBeat.o(146053);
    return bool;
  }
  
  private int mX(long paramLong)
  {
    AppMethodBeat.i(182789);
    if ((this.db instanceof f))
    {
      int i = ((f)this.db).mX(paramLong);
      AppMethodBeat.o(182789);
      return i;
    }
    AppMethodBeat.o(182789);
    return -1;
  }
  
  final b FZ(String paramString)
  {
    AppMethodBeat.i(146046);
    paramString = d(paramString, new String[] { "syncVersion" });
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = bt.aGd(bt.nullAsNil(paramString.field_syncVersion)))
    {
      paramString = new b(paramString);
      AppMethodBeat.o(146046);
      return paramString;
    }
  }
  
  public final boolean Ga(String paramString)
  {
    AppMethodBeat.i(146047);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
      AppMethodBeat.o(146047);
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    boolean bool = b(localWxaAttributes, false, new String[0]);
    AppMethodBeat.o(146047);
    return bool;
  }
  
  protected boolean a(WxaAttributes paramWxaAttributes, duq paramduq)
  {
    AppMethodBeat.i(146052);
    if (("NickName".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = bt.nullAsNil(paramduq.vJI);
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BrandIconURL".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = paramduq.vJI;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BigHeadImgUrl".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = paramduq.vJI;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("SmallHeadImgUrl".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = paramduq.vJI;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("Signature".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = paramduq.vJI;
      AppMethodBeat.o(146052);
      return true;
    }
    if ("WxAppOpt".equals(paramduq.sdv))
    {
      int i = bt.getInt(paramduq.vJI, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        AppMethodBeat.o(146052);
        return true;
      }
    }
    if (("RegisterSource".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = paramduq.vJI;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("WxaAppInfo".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_appInfo))) {
      paramWxaAttributes.field_appInfo = paramduq.vJI;
    }
    try
    {
      paramduq = new JSONObject(paramduq.vJI);
      paramWxaAttributes.field_appId = paramduq.getString("Appid");
      paramWxaAttributes.field_roundedSquareIconURL = paramduq.getString("RoundedSquareIconUrl");
      paramWxaAttributes.field_shortNickname = paramduq.optString("ShortNickName");
      label380:
      AppMethodBeat.o(146052);
      return true;
      if (("WxaAppVersionInfo".equalsIgnoreCase(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_versionInfo)))
      {
        paramWxaAttributes.field_versionInfo = paramduq.vJI;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("BindWxaInfo".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_bindWxaInfo)))
      {
        paramWxaAttributes.field_bindWxaInfo = paramduq.vJI;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("WxaAppDynamic".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_dynamicInfo)))
      {
        paramWxaAttributes.field_dynamicInfo = paramduq.vJI;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("MMBizMenu".equals(paramduq.sdv)) && (!cr(paramduq.vJI, paramWxaAttributes.field_bizMenu)))
      {
        paramWxaAttributes.field_bizMenu = paramduq.vJI;
        AppMethodBeat.o(146052);
        return true;
      }
      AppMethodBeat.o(146052);
      return false;
    }
    catch (Exception paramWxaAttributes)
    {
      break label380;
    }
  }
  
  public final boolean a(kg paramkg)
  {
    AppMethodBeat.i(182790);
    long l = aTK();
    LinkedList localLinkedList = new LinkedList();
    paramkg = paramkg.CFb.iterator();
    boolean bool1 = false;
    while (paramkg.hasNext())
    {
      dut localdut = (dut)paramkg.next();
      ad.i("MicroMsg.WxaAttrStorage", "batchSyncInGroup flushAttrs(%s)", new Object[] { localdut.DII });
      boolean bool2 = bool1 | a(localdut.DII, localdut.CIu, localdut.CIv, false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localdut.DII))
        {
          localLinkedList.add(localdut.DII);
          bool1 = bool2;
        }
      }
    }
    mX(l);
    if (localLinkedList.size() > 0) {
      doNotify("batch", 3, localLinkedList);
    }
    AppMethodBeat.o(182790);
    return bool1;
  }
  
  public boolean a(String paramString, b paramb, List<duq> paramList)
  {
    AppMethodBeat.i(146051);
    boolean bool = a(paramString, paramb, paramList, true);
    AppMethodBeat.o(146051);
    return bool;
  }
  
  public final boolean aTJ()
  {
    AppMethodBeat.i(146045);
    if ((this.db != null) && (!this.db.eHe()))
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
    if (bt.isNullOrNil(paramString))
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
    if (bt.T(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((e)localObject2).a("WxaAttributesTable", paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "usernameHash" }), new String[] { String.valueOf(paramString.hashCode()) }, null, null, null, 2);
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
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146049);
      return null;
    }
    Object localObject2 = this.db;
    if (bt.T(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((e)localObject2).a("WxaAttributesTable", paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(146049);
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
    AppMethodBeat.o(146049);
    return paramVarArgs;
  }
  
  protected boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146050);
    if (bt.isNullOrNil(paramString))
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
      if (this.db.update("WxaAttributesTable", (ContentValues)localObject, String.format("%s=?", new Object[] { "username" }), new String[] { paramString }) <= 0) {
        break;
      }
      AppMethodBeat.o(146050);
      return true;
    }
    AppMethodBeat.o(146050);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */