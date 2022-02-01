package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.fnv;
import com.tencent.mm.protocal.protobuf.fny;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class x
  extends MAutoStorage<WxaAttributes>
{
  final ISQLiteDatabase db;
  
  public x(ISQLiteDatabase paramISQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, WxaAttributes.nFK, paramString, paramArrayOfString);
    this.db = paramISQLiteDatabase;
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(232455);
    paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    super.insertNotify(paramWxaAttributes, false);
    if (c(paramWxaAttributes.field_username, new String[] { "appId" }) != null) {}
    for (;;)
    {
      if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
        doNotify("single", 2, paramWxaAttributes.field_username);
      }
      AppMethodBeat.o(232455);
      return bool;
      bool = false;
    }
  }
  
  private boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(232456);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
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
        AppMethodBeat.o(232456);
        return bool;
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString, b paramb, List<fnv> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(232451);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(232451);
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
        paramList = (fnv)paramString.next();
        if (paramList != null) {
          bool = a(localWxaAttributes, paramList) | bool;
        }
      }
    }
    localWxaAttributes.field_syncTimeSecond = Util.nowSecond();
    if (paramb == null)
    {
      paramString = new byte[0];
      localWxaAttributes.field_syncVersion = Util.encodeHexString(paramString);
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
      AppMethodBeat.o(232451);
      return bool;
      paramString = paramb.UH;
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
    if (!Util.isNullOrNil(paramWxaAttributes.field_username)) {
      paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    }
    boolean bool = super.delete(paramWxaAttributes, false, paramVarArgs);
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
      doNotify("single", 5, paramWxaAttributes.field_username);
    }
    AppMethodBeat.o(146055);
    return bool;
  }
  
  private long bLA()
  {
    AppMethodBeat.i(182788);
    if ((this.db instanceof ISQLiteDatabaseEx))
    {
      long l = ((ISQLiteDatabaseEx)this.db).beginTransaction(Thread.currentThread().getId());
      AppMethodBeat.o(182788);
      return l;
    }
    AppMethodBeat.o(182788);
    return -1L;
  }
  
  private static boolean dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146053);
    boolean bool = Util.nullAsNil(paramString1).equals(Util.nullAsNil(paramString2));
    AppMethodBeat.o(146053);
    return bool;
  }
  
  private int endTransaction(long paramLong)
  {
    AppMethodBeat.i(182789);
    if ((this.db instanceof ISQLiteDatabaseEx))
    {
      int i = ((ISQLiteDatabaseEx)this.db).endTransaction(paramLong);
      AppMethodBeat.o(182789);
      return i;
    }
    AppMethodBeat.o(182789);
    return -1;
  }
  
  public final boolean a(int paramInt, lc paramlc, List<String> paramList)
  {
    AppMethodBeat.i(232449);
    long l = bLA();
    LinkedList localLinkedList = new LinkedList();
    paramlc = paramlc.RQb.iterator();
    boolean bool1 = false;
    while (paramlc.hasNext())
    {
      fny localfny = (fny)paramlc.next();
      Log.i("MicroMsg.WxaAttrStorage", "batchSyncInGroup, scene(%d), flushAttrs(%s)", new Object[] { Integer.valueOf(paramInt), localfny.Txp });
      boolean bool2 = bool1 | a(localfny.Txp, localfny.RTT, localfny.RTU, false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localfny.Txp))
        {
          localLinkedList.add(localfny.Txp);
          bool1 = bool2;
        }
      }
    }
    endTransaction(l);
    if (localLinkedList.size() > 0)
    {
      if (paramList != null) {
        paramList.addAll(localLinkedList);
      }
      doNotify("batch", 3, localLinkedList);
    }
    AppMethodBeat.o(232449);
    return bool1;
  }
  
  protected boolean a(WxaAttributes paramWxaAttributes, fnv paramfnv)
  {
    AppMethodBeat.i(146052);
    if (("NickName".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = Util.nullAsNil(paramfnv.Izj);
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BrandIconURL".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = paramfnv.Izj;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BigHeadImgUrl".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = paramfnv.Izj;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("SmallHeadImgUrl".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = paramfnv.Izj;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("Signature".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = paramfnv.Izj;
      AppMethodBeat.o(146052);
      return true;
    }
    if ("WxAppOpt".equals(paramfnv.CRg))
    {
      int i = Util.getInt(paramfnv.Izj, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        AppMethodBeat.o(146052);
        return true;
      }
    }
    if (("RegisterSource".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = paramfnv.Izj;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("WxaAppInfo".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_appInfo))) {
      paramWxaAttributes.field_appInfo = paramfnv.Izj;
    }
    try
    {
      paramfnv = new JSONObject(paramfnv.Izj);
      paramWxaAttributes.field_appId = paramfnv.getString("Appid");
      paramWxaAttributes.field_roundedSquareIconURL = paramfnv.getString("RoundedSquareIconUrl");
      paramWxaAttributes.field_shortNickname = paramfnv.optString("ShortNickName");
      label381:
      AppMethodBeat.o(146052);
      return true;
      if (("WxaAppVersionInfo".equalsIgnoreCase(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_versionInfo)))
      {
        paramWxaAttributes.field_versionInfo = paramfnv.Izj;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("BindWxaInfo".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_bindWxaInfo)))
      {
        paramWxaAttributes.field_bindWxaInfo = paramfnv.Izj;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("WxaAppDynamic".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_dynamicInfo)))
      {
        paramWxaAttributes.field_dynamicInfo = paramfnv.Izj;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("MMBizMenu".equals(paramfnv.CRg)) && (!dc(paramfnv.Izj, paramWxaAttributes.field_bizMenu)))
      {
        paramWxaAttributes.field_bizMenu = paramfnv.Izj;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("PassThroughInfo".equals(paramfnv.CRg)) && (!dc(paramfnv.CRg, paramWxaAttributes.field_passThroughInfo)))
      {
        paramWxaAttributes.field_passThroughInfo = paramfnv.Izj;
        AppMethodBeat.o(146052);
        return true;
      }
      AppMethodBeat.o(146052);
      return false;
    }
    catch (Exception paramWxaAttributes)
    {
      break label381;
    }
  }
  
  public final boolean a(WxaAttributes paramWxaAttributes, String... paramVarArgs)
  {
    AppMethodBeat.i(146054);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
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
  
  public boolean a(String paramString, b paramb, List<fnv> paramList)
  {
    AppMethodBeat.i(146051);
    boolean bool = a(paramString, paramb, paramList, true);
    AppMethodBeat.o(146051);
    return bool;
  }
  
  final long afa(String paramString)
  {
    AppMethodBeat.i(232441);
    paramString = c(paramString, new String[] { "syncTimeSecond" });
    if (paramString == null)
    {
      AppMethodBeat.o(232441);
      return 0L;
    }
    long l = paramString.field_syncTimeSecond;
    AppMethodBeat.o(232441);
    return l;
  }
  
  final b afb(String paramString)
  {
    AppMethodBeat.i(146046);
    paramString = c(paramString, new String[] { "syncVersion" });
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = Util.decodeHexString(Util.nullAsNil(paramString.field_syncVersion)))
    {
      paramString = new b(paramString);
      AppMethodBeat.o(146046);
      return paramString;
    }
  }
  
  public final boolean afc(String paramString)
  {
    AppMethodBeat.i(146047);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
      AppMethodBeat.o(146047);
      return false;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    boolean bool = b(localWxaAttributes, false, new String[0]);
    AppMethodBeat.o(146047);
    return bool;
  }
  
  public final boolean bLz()
  {
    AppMethodBeat.i(146045);
    if ((this.db != null) && (!this.db.isClose()))
    {
      AppMethodBeat.o(146045);
      return true;
    }
    AppMethodBeat.o(146045);
    return false;
  }
  
  public final WxaAttributes c(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(146048);
    if (Util.isNullOrNil(paramString))
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
    if (Util.isNullOrNil(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((ISQLiteDatabase)localObject2).query(str, paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "usernameHash" }), new String[] { String.valueOf(paramString.hashCode()) }, null, null, null, 2);
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
  
  public final WxaAttributes d(String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(146049);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146049);
      return null;
    }
    Object localObject2 = this.db;
    String str = getTableName();
    if (Util.isNullOrNil(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((ISQLiteDatabase)localObject2).query(str, paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      Log.e("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) null==cursor", new Object[] { paramString });
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
      Log.e("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) !cursor.moveToFirst()", new Object[] { paramString });
    }
  }
  
  protected boolean o(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146050);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146050);
      return false;
    }
    Object localObject = c(paramString, new String[] { "appOpt" });
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.x
 * JD-Core Version:    0.7.0.1
 */