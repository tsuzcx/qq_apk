package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "insertOrUpdate", "", "record", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "removeForAppIdAndVersionLessThan", "appId", "", "version", "", "CREATOR", "Constants", "plugin-appbrand-integration_release"})
public final class v
  extends x
{
  public static final String[] lqL;
  public static final b oan;
  private final ISQLiteDatabaseEx nHd;
  
  static
  {
    AppMethodBeat.i(270165);
    oan = new b((byte)0);
    lqL = new String[] { x.getCreateSQLs(WxaAttributes.nFK, "WxaAttrAvailableBackupTable") };
    AppMethodBeat.o(270165);
  }
  
  public v(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, "WxaAttrAvailableBackupTable", null);
    AppMethodBeat.i(270164);
    this.nHd = paramISQLiteDatabaseEx;
    AppMethodBeat.o(270164);
  }
  
  public final boolean bY(String paramString, int paramInt)
  {
    AppMethodBeat.i(270163);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(270163);
      return false;
    }
    Log.i("MicroMsg.AppBrand.WxaAttrAvailableBackupStorage", "removeForAppIdAndVersionLessThan(appId:" + paramString + ", version:" + paramInt + ')');
    try
    {
      paramString = super.d(paramString, new String[] { "versionInfo" });
      if ((paramString != null) && (paramString.bLH().appVersion < paramInt))
      {
        super.delete((IAutoDBItem)paramString, new String[0]);
        AppMethodBeat.o(270163);
        return true;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(270163);
    }
    return false;
  }
  
  public final boolean d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(270162);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(270162);
      return false;
    }
    Object localObject1 = new StringBuilder("WxaAttrAvailableBackupStorage.insertOrUpdate(").append(paramWxaAttributes.field_username).append('|').append(paramWxaAttributes.field_appId).append('|');
    Object localObject2 = paramWxaAttributes.bLH();
    int i;
    long l;
    boolean bool;
    label124:
    Boolean localBoolean;
    if (localObject2 != null)
    {
      i = ((WxaAttributes.WxaVersionInfo)localObject2).appVersion;
      localObject2 = i + ')';
      l = SystemClock.elapsedRealtime();
      if (!super.a(paramWxaAttributes, new String[] { "username" })) {
        break label262;
      }
      bool = super.update((IAutoDBItem)paramWxaAttributes, new String[] { "username" });
      localBoolean = Boolean.valueOf(bool);
      localObject1 = localBoolean.toString();
      paramWxaAttributes = (WxaAttributes)localObject1;
      if (localObject1 == null) {
        paramWxaAttributes = "";
      }
      bool = ai.Or();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label275;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(270162);
      return bool;
      i = -1;
      break;
      label262:
      bool = super.insert((IAutoDBItem)paramWxaAttributes);
      break label124;
      label275:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$Constants;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-appbrand-integration_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */