package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import com.tencent.luggage.sdk.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "insertOrUpdate", "", "record", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "removeForAppIdAndVersionLessThan", "appId", "", "version", "", "CREATOR", "Constants", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends ac
{
  public static final String[] nVW;
  public static final aa.b raZ;
  private final ISQLiteDatabaseEx qGR;
  
  static
  {
    AppMethodBeat.i(323313);
    raZ = new aa.b((byte)0);
    nVW = new String[] { ac.getCreateSQLs(WxaAttributes.DB_INFO, "WxaAttrAvailableBackupTable") };
    AppMethodBeat.o(323313);
  }
  
  public aa(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, "WxaAttrAvailableBackupTable", null);
    AppMethodBeat.i(323308);
    this.qGR = paramISQLiteDatabaseEx;
    AppMethodBeat.o(323308);
  }
  
  public final boolean c(WxaAttributes paramWxaAttributes)
  {
    int i = -1;
    AppMethodBeat.i(323321);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(323321);
      return false;
    }
    Object localObject1 = new StringBuilder("WxaAttrAvailableBackupStorage.insertOrUpdate(").append(paramWxaAttributes.field_username).append('|').append(paramWxaAttributes.field_appId).append('|');
    Object localObject2;
    long l;
    boolean bool;
    label116:
    Boolean localBoolean;
    if (paramWxaAttributes == null)
    {
      localObject2 = i + ')';
      localObject1 = d.evM;
      l = SystemClock.elapsedRealtime();
      if (!super.a(paramWxaAttributes, new String[] { "username" })) {
        break label269;
      }
      bool = super.a(paramWxaAttributes, false, new String[] { "username" });
      localBoolean = Boolean.valueOf(bool);
      localObject1 = localBoolean.toString();
      paramWxaAttributes = (WxaAttributes)localObject1;
      if (localObject1 == null) {
        paramWxaAttributes = "";
      }
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label280;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(323321);
      return bool;
      localObject2 = paramWxaAttributes.clf();
      if (localObject2 == null) {
        break;
      }
      i = ((WxaAttributes.WxaVersionInfo)localObject2).appVersion;
      break;
      label269:
      bool = super.a(paramWxaAttributes, false);
      break label116;
      label280:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
  }
  
  public final boolean cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(323325);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(323325);
      return false;
    }
    Log.i("MicroMsg.AppBrand.WxaAttrAvailableBackupStorage", "removeForAppIdAndVersionLessThan(appId:" + paramString + ", version:" + paramInt + ')');
    try
    {
      paramString = super.e(paramString, new String[] { "versionInfo" });
      if ((paramString != null) && (paramString.clf().appVersion < paramInt))
      {
        super.b(paramString, false, new String[0]);
        AppMethodBeat.o(323325);
        return true;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(323325);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.aa
 * JD-Core Version:    0.7.0.1
 */