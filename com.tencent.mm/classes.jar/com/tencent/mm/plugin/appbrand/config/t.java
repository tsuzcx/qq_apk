package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class t
  extends j<WxaAttributes>
{
  public static final String[] hlS;
  final e db;
  
  static
  {
    AppMethodBeat.i(146060);
    hlS = new String[] { j.getCreateSQLs(WxaAttributes.jmW, "WxaAttributesTable") };
    AppMethodBeat.o(146060);
  }
  
  public t(e parame)
  {
    super(parame, WxaAttributes.jmW, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
    this.db = parame;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(208994);
    paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    super.insertNotify(paramWxaAttributes, false);
    if (d("username", new String[] { "appId" }) != null) {}
    for (;;)
    {
      if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
        doNotify("single", 2, paramWxaAttributes.field_username);
      }
      AppMethodBeat.o(208994);
      return bool;
      bool = false;
    }
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(208995);
    int i;
    if (!bs.T(paramVarArgs)) {
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
        AppMethodBeat.o(208995);
        return bool;
      }
      i += 1;
    }
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, String... paramVarArgs)
  {
    AppMethodBeat.i(146054);
    int i;
    if (!bs.T(paramVarArgs)) {
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
  
  private boolean a(String paramString, b paramb, List<eah> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(208993);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(208993);
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
        paramList = (eah)paramString.next();
        if (paramList != null) {
          bool = a(localWxaAttributes, paramList) | bool;
        }
      }
    }
    localWxaAttributes.field_syncTimeSecond = bs.aNx();
    if (paramb == null)
    {
      paramString = new byte[0];
      localWxaAttributes.field_syncVersion = bs.cx(paramString);
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
      AppMethodBeat.o(208993);
      return bool;
      paramString = paramb.xy;
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
    if (!bs.isNullOrNil(paramWxaAttributes.field_username)) {
      paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    }
    boolean bool = super.delete(paramWxaAttributes, false, paramVarArgs);
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
      doNotify("single", 5, paramWxaAttributes.field_username);
    }
    AppMethodBeat.o(146055);
    return bool;
  }
  
  private long baI()
  {
    AppMethodBeat.i(182788);
    if ((this.db instanceof f))
    {
      long l = ((f)this.db).vE(Thread.currentThread().getId());
      AppMethodBeat.o(182788);
      return l;
    }
    AppMethodBeat.o(182788);
    return -1L;
  }
  
  private static boolean cB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146053);
    boolean bool = bs.nullAsNil(paramString1).equals(bs.nullAsNil(paramString2));
    AppMethodBeat.o(146053);
    return bool;
  }
  
  private int qL(long paramLong)
  {
    AppMethodBeat.i(182789);
    if ((this.db instanceof f))
    {
      int i = ((f)this.db).qL(paramLong);
      AppMethodBeat.o(182789);
      return i;
    }
    AppMethodBeat.o(182789);
    return -1;
  }
  
  final b Kd(String paramString)
  {
    AppMethodBeat.i(146046);
    paramString = d(paramString, new String[] { "syncVersion" });
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = bs.aLu(bs.nullAsNil(paramString.field_syncVersion)))
    {
      paramString = new b(paramString);
      AppMethodBeat.o(146046);
      return paramString;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(146047);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
      AppMethodBeat.o(146047);
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    boolean bool = b(localWxaAttributes, false, new String[0]);
    AppMethodBeat.o(146047);
    return bool;
  }
  
  protected boolean a(WxaAttributes paramWxaAttributes, eah parameah)
  {
    AppMethodBeat.i(146052);
    if (("NickName".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = bs.nullAsNil(parameah.wTM);
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BrandIconURL".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = parameah.wTM;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BigHeadImgUrl".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = parameah.wTM;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("SmallHeadImgUrl".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = parameah.wTM;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("Signature".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = parameah.wTM;
      AppMethodBeat.o(146052);
      return true;
    }
    if ("WxAppOpt".equals(parameah.tlp))
    {
      int i = bs.getInt(parameah.wTM, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        AppMethodBeat.o(146052);
        return true;
      }
    }
    if (("RegisterSource".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = parameah.wTM;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("WxaAppInfo".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_appInfo))) {
      paramWxaAttributes.field_appInfo = parameah.wTM;
    }
    try
    {
      parameah = new JSONObject(parameah.wTM);
      paramWxaAttributes.field_appId = parameah.getString("Appid");
      paramWxaAttributes.field_roundedSquareIconURL = parameah.getString("RoundedSquareIconUrl");
      paramWxaAttributes.field_shortNickname = parameah.optString("ShortNickName");
      label380:
      AppMethodBeat.o(146052);
      return true;
      if (("WxaAppVersionInfo".equalsIgnoreCase(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_versionInfo)))
      {
        paramWxaAttributes.field_versionInfo = parameah.wTM;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("BindWxaInfo".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_bindWxaInfo)))
      {
        paramWxaAttributes.field_bindWxaInfo = parameah.wTM;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("WxaAppDynamic".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_dynamicInfo)))
      {
        paramWxaAttributes.field_dynamicInfo = parameah.wTM;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("MMBizMenu".equals(parameah.tlp)) && (!cB(parameah.wTM, paramWxaAttributes.field_bizMenu)))
      {
        paramWxaAttributes.field_bizMenu = parameah.wTM;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("PassThroughInfo".equals(parameah.tlp)) && (!cB(parameah.tlp, paramWxaAttributes.field_passThroughInfo)))
      {
        paramWxaAttributes.field_passThroughInfo = parameah.wTM;
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
  
  public final boolean a(km paramkm)
  {
    AppMethodBeat.i(182790);
    long l = baI();
    LinkedList localLinkedList = new LinkedList();
    paramkm = paramkm.DXB.iterator();
    boolean bool1 = false;
    while (paramkm.hasNext())
    {
      eak localeak = (eak)paramkm.next();
      ac.i("MicroMsg.WxaAttrStorage", "batchSyncInGroup flushAttrs(%s)", new Object[] { localeak.Fed });
      boolean bool2 = bool1 | a(localeak.Fed, localeak.EaW, localeak.EaX, false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localeak.Fed))
        {
          localLinkedList.add(localeak.Fed);
          bool1 = bool2;
        }
      }
    }
    qL(l);
    if (localLinkedList.size() > 0) {
      doNotify("batch", 3, localLinkedList);
    }
    AppMethodBeat.o(182790);
    return bool1;
  }
  
  public boolean a(String paramString, b paramb, List<eah> paramList)
  {
    AppMethodBeat.i(146051);
    boolean bool = a(paramString, paramb, paramList, true);
    AppMethodBeat.o(146051);
    return bool;
  }
  
  public final boolean baH()
  {
    AppMethodBeat.i(146045);
    if ((this.db != null) && (!this.db.eWz()))
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
    if (bs.isNullOrNil(paramString))
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
    if (bs.T(paramVarArgs)) {
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
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146049);
      return null;
    }
    Object localObject2 = this.db;
    if (bs.T(paramVarArgs)) {
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
    if (bs.isNullOrNil(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */