package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.gku;
import com.tencent.mm.protocal.protobuf.gkx;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.sdk.platformtools.BuildInfo;
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

public class ac
  extends MAutoStorage<WxaAttributes>
{
  final ISQLiteDatabase db;
  
  public ac(ISQLiteDatabase paramISQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, WxaAttributes.DB_INFO, paramString, paramArrayOfString);
    this.db = paramISQLiteDatabase;
  }
  
  private long ckX()
  {
    AppMethodBeat.i(182788);
    if ((BuildInfo.DEBUG) && (Thread.currentThread() == Looper.getMainLooper().getThread()))
    {
      RuntimeException localRuntimeException = new RuntimeException("Can not do transaction in main thread!");
      AppMethodBeat.o(182788);
      throw localRuntimeException;
    }
    if ((this.db instanceof ISQLiteDatabaseEx))
    {
      long l = ((ISQLiteDatabaseEx)this.db).beginTransaction(Thread.currentThread().getId());
      AppMethodBeat.o(182788);
      return l;
    }
    AppMethodBeat.o(182788);
    return -1L;
  }
  
  public static b d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(323320);
    if (paramWxaAttributes == null) {}
    for (paramWxaAttributes = new byte[0];; paramWxaAttributes = Util.decodeHexString(Util.nullAsNil(paramWxaAttributes.field_syncVersion)))
    {
      paramWxaAttributes = new b(paramWxaAttributes);
      AppMethodBeat.o(323320);
      return paramWxaAttributes;
    }
  }
  
  private static boolean dt(String paramString1, String paramString2)
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
  
  final long XC(String paramString)
  {
    AppMethodBeat.i(323352);
    paramString = d(paramString, new String[] { "syncTimeSecond" });
    if (paramString == null)
    {
      AppMethodBeat.o(323352);
      return 0L;
    }
    long l = paramString.field_syncTimeSecond;
    AppMethodBeat.o(323352);
    return l;
  }
  
  public final boolean XD(String paramString)
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
  
  public final boolean a(int paramInt, md parammd)
  {
    AppMethodBeat.i(323375);
    boolean bool = a(paramInt, parammd, null);
    AppMethodBeat.o(323375);
    return bool;
  }
  
  public final boolean a(int paramInt, md parammd, List<String> paramList)
  {
    AppMethodBeat.i(323381);
    long l = ckX();
    LinkedList localLinkedList = new LinkedList();
    parammd = parammd.YNp.iterator();
    boolean bool1 = false;
    while (parammd.hasNext())
    {
      gkx localgkx = (gkx)parammd.next();
      Log.i("MicroMsg.WxaAttrStorage", "batchSyncInGroup, scene(%d), flushAttrs(%s)", new Object[] { Integer.valueOf(paramInt), localgkx.aaLU });
      boolean bool2 = bool1 | a(localgkx.aaLU, localgkx.YRt, localgkx.YRu, false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localgkx.aaLU))
        {
          localLinkedList.add(localgkx.aaLU);
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
    AppMethodBeat.o(323381);
    return bool1;
  }
  
  protected boolean a(WxaAttributes paramWxaAttributes, gku paramgku)
  {
    AppMethodBeat.i(146052);
    if (("NickName".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_nickname)))
    {
      paramWxaAttributes.field_nickname = Util.nullAsNil(paramgku.OzQ);
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BrandIconURL".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_brandIconURL)))
    {
      paramWxaAttributes.field_brandIconURL = paramgku.OzQ;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("BigHeadImgUrl".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_bigHeadURL)))
    {
      paramWxaAttributes.field_bigHeadURL = paramgku.OzQ;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("SmallHeadImgUrl".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_smallHeadURL)))
    {
      paramWxaAttributes.field_smallHeadURL = paramgku.OzQ;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("Signature".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_signature)))
    {
      paramWxaAttributes.field_signature = paramgku.OzQ;
      AppMethodBeat.o(146052);
      return true;
    }
    if ("WxAppOpt".equals(paramgku.ILw))
    {
      int i = Util.getInt(paramgku.OzQ, 0);
      if (i != paramWxaAttributes.field_appOpt)
      {
        paramWxaAttributes.field_appOpt = i;
        AppMethodBeat.o(146052);
        return true;
      }
    }
    if (("RegisterSource".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_registerSource)))
    {
      paramWxaAttributes.field_registerSource = paramgku.OzQ;
      AppMethodBeat.o(146052);
      return true;
    }
    if (("WxaAppInfo".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_appInfo))) {
      paramWxaAttributes.field_appInfo = paramgku.OzQ;
    }
    try
    {
      paramgku = new JSONObject(paramgku.OzQ);
      paramWxaAttributes.field_appId = paramgku.getString("Appid");
      paramWxaAttributes.field_roundedSquareIconURL = paramgku.getString("RoundedSquareIconUrl");
      paramWxaAttributes.field_shortNickname = paramgku.optString("ShortNickName");
      label380:
      AppMethodBeat.o(146052);
      return true;
      if (("WxaAppVersionInfo".equalsIgnoreCase(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_versionInfo)))
      {
        paramWxaAttributes.field_versionInfo = paramgku.OzQ;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("BindWxaInfo".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_bindWxaInfo)))
      {
        paramWxaAttributes.field_bindWxaInfo = paramgku.OzQ;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("WxaAppDynamic".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_dynamicInfo)))
      {
        paramWxaAttributes.field_dynamicInfo = paramgku.OzQ;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("MMBizMenu".equals(paramgku.ILw)) && (!dt(paramgku.OzQ, paramWxaAttributes.field_bizMenu)))
      {
        paramWxaAttributes.field_bizMenu = paramgku.OzQ;
        AppMethodBeat.o(146052);
        return true;
      }
      if (("PassThroughInfo".equals(paramgku.ILw)) && (!dt(paramgku.ILw, paramWxaAttributes.field_passThroughInfo)))
      {
        paramWxaAttributes.field_passThroughInfo = paramgku.OzQ;
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
  
  public final boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(323418);
    paramWxaAttributes.field_usernameHash = paramWxaAttributes.field_username.hashCode();
    super.insertNotify(paramWxaAttributes, false);
    if (d(paramWxaAttributes.field_username, new String[] { "appId" }) != null) {}
    for (;;)
    {
      if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(paramWxaAttributes.field_username))) {
        doNotify("single", 2, paramWxaAttributes.field_username);
      }
      AppMethodBeat.o(323418);
      return bool;
      bool = false;
    }
  }
  
  public final boolean a(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(323424);
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
        AppMethodBeat.o(323424);
        return bool;
      }
      i += 1;
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
  
  public final boolean a(String paramString, b paramb, List<gku> paramList)
  {
    AppMethodBeat.i(146051);
    boolean bool = a(paramString, paramb, paramList, true);
    AppMethodBeat.o(146051);
    return bool;
  }
  
  protected boolean a(String paramString, b paramb, List<gku> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(323394);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(323394);
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
        paramList = (gku)paramString.next();
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
        break label195;
      }
      if (i == 0) {
        break label173;
      }
      a(localWxaAttributes, paramBoolean);
    }
    for (;;)
    {
      AppMethodBeat.o(323394);
      return bool;
      paramString = paramb.Op;
      break;
      label173:
      a(localWxaAttributes, paramBoolean, new String[] { "username" });
      continue;
      label195:
      a(localWxaAttributes, false, new String[] { "username" });
    }
  }
  
  public final boolean b(WxaAttributes paramWxaAttributes, boolean paramBoolean, String... paramVarArgs)
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
  
  public final boolean ckW()
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
  
  public final WxaAttributes d(String paramString, String... paramVarArgs)
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
  
  public void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(323430);
    super.doNotify(paramString, paramInt, paramObject);
    new ae(paramString, paramInt, paramObject).publish();
    AppMethodBeat.o(323430);
  }
  
  public final WxaAttributes e(String paramString, String... paramVarArgs)
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
  
  protected boolean p(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146050);
    if (Util.isNullOrNil(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ac
 * JD-Core Version:    0.7.0.1
 */