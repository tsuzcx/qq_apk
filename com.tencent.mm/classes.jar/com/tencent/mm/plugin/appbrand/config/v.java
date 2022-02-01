package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.b.a;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "insertOrUpdate", "", "record", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "CREATOR", "Constants", "plugin-appbrand-integration_release"})
public final class v
  extends x
{
  public static final String[] iBh;
  public static final b lfN;
  private final ISQLiteDatabaseEx kOg;
  
  static
  {
    AppMethodBeat.i(228170);
    lfN = new b((byte)0);
    iBh = new String[] { x.getCreateSQLs(WxaAttributes.kLR, "WxaAttrAvailableBackupTable") };
    AppMethodBeat.o(228170);
  }
  
  public v(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, "WxaAttrAvailableBackupTable", null);
    AppMethodBeat.i(228169);
    this.kOg = paramISQLiteDatabaseEx;
    AppMethodBeat.o(228169);
  }
  
  public final boolean d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(228168);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(228168);
      return false;
    }
    Object localObject1 = new StringBuilder("WxaAttrAvailableBackupStorage.insertOrUpdate(").append(paramWxaAttributes.field_username).append('|').append(paramWxaAttributes.field_appId).append('|');
    Object localObject2 = paramWxaAttributes.bAp();
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
      bool = ag.LB();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label275;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(228168);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$CREATOR;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandDBStorageRegistry$IStorageCreator;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "()V", "create", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
  public static final class a
    implements b.a<v>
  {
    public static final a lfO;
    
    static
    {
      AppMethodBeat.i(228167);
      lfO = new a();
      AppMethodBeat.o(228167);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$Constants;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-appbrand-integration_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */