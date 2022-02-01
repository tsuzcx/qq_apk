package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.a.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "insertOrUpdate", "", "record", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "CREATOR", "Constants", "plugin-appbrand-integration_release"})
public final class s
  extends u
{
  public static final String[] hEf;
  public static final b jYR;
  private final f jYQ;
  
  static
  {
    AppMethodBeat.i(189009);
    jYR = new b((byte)0);
    hEf = new String[] { u.getCreateSQLs(WxaAttributes.jGU, "WxaAttrAvailableBackupTable") };
    AppMethodBeat.o(189009);
  }
  
  public s(f paramf)
  {
    super((e)paramf, "WxaAttrAvailableBackupTable", null);
    AppMethodBeat.i(189008);
    this.jYQ = paramf;
    AppMethodBeat.o(189008);
  }
  
  public final boolean d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(189007);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(189007);
      return false;
    }
    Object localObject1 = new StringBuilder("WxaAttrAvailableBackupStorage.insertOrUpdate(").append(paramWxaAttributes.field_username).append('|').append(paramWxaAttributes.field_appId).append('|');
    Object localObject2 = paramWxaAttributes.ben();
    int i;
    long l;
    boolean bool;
    label124:
    Boolean localBoolean;
    if (localObject2 != null)
    {
      i = ((WxaAttributes.WxaVersionInfo)localObject2).aDD;
      localObject2 = i + ')';
      l = SystemClock.elapsedRealtime();
      if (!super.a(paramWxaAttributes, new String[] { "username" })) {
        break label262;
      }
      bool = super.update((c)paramWxaAttributes, new String[] { "username" });
      localBoolean = Boolean.valueOf(bool);
      localObject1 = localBoolean.toString();
      paramWxaAttributes = (WxaAttributes)localObject1;
      if (localObject1 == null) {
        paramWxaAttributes = "";
      }
      bool = com.tencent.mm.plugin.appbrand.utils.ad.Ch();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label275;
      }
      com.tencent.mm.sdk.platformtools.ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(189007);
      return bool;
      i = -1;
      break;
      label262:
      bool = super.insert((c)paramWxaAttributes);
      break label124;
      label275:
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$CREATOR;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandDBStorageRegistry$IStorageCreator;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "()V", "create", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
  public static final class a
    implements a.a<s>
  {
    public static final a jYS;
    
    static
    {
      AppMethodBeat.i(189006);
      jYS = new a();
      AppMethodBeat.o(189006);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$Constants;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-appbrand-integration_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */