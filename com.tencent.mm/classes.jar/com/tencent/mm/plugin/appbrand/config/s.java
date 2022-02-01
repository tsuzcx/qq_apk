package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.a.a;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "insertOrUpdate", "", "record", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "CREATOR", "Constants", "plugin-appbrand-integration_release"})
public final class s
  extends u
{
  public static final String[] hGX;
  public static final b kci;
  private final f kch;
  
  static
  {
    AppMethodBeat.i(223268);
    kci = new b((byte)0);
    hGX = new String[] { u.getCreateSQLs(WxaAttributes.jJU, "WxaAttrAvailableBackupTable") };
    AppMethodBeat.o(223268);
  }
  
  public s(f paramf)
  {
    super((e)paramf, "WxaAttrAvailableBackupTable", null);
    AppMethodBeat.i(223267);
    this.kch = paramf;
    AppMethodBeat.o(223267);
  }
  
  public final boolean d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(223266);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(223266);
      return false;
    }
    Object localObject1 = new StringBuilder("WxaAttrAvailableBackupStorage.insertOrUpdate(").append(paramWxaAttributes.field_username).append('|').append(paramWxaAttributes.field_appId).append('|');
    Object localObject2 = paramWxaAttributes.beV();
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
      bool = ag.Ck();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label275;
      }
      ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(223266);
      return bool;
      i = -1;
      break;
      label262:
      bool = super.insert((c)paramWxaAttributes);
      break label124;
      label275:
      ae.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + paramWxaAttributes + " isMainThread: " + bool + ' ');
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$CREATOR;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandDBStorageRegistry$IStorageCreator;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage;", "()V", "create", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
  public static final class a
    implements a.a<s>
  {
    public static final a kcj;
    
    static
    {
      AppMethodBeat.i(223265);
      kcj = new a();
      AppMethodBeat.o(223265);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/WxaAttrAvailableBackupStorage$Constants;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-appbrand-integration_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */