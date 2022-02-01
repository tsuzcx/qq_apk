package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class ah
{
  public static boolean XT(String paramString)
  {
    AppMethodBeat.i(323307);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(323307);
      return false;
    }
    k localk = k.qKk;
    long l1 = k.VN(paramString);
    ai.clk();
    long l2 = ai.XZ(paramString);
    if ((l1 > 0L) && (l1 >= l2))
    {
      Log.i("MicroMsg.WxaAttrSyncUtils", "isContactMarkedAsInvalid (%s) returns true, treated as invalid until %d, attrs lastSyncTimestamp %d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(323307);
      return true;
    }
    AppMethodBeat.o(323307);
    return false;
  }
  
  public static boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(323300);
    if (Util.isNullOrNil(paramWxaAttributes.field_appId))
    {
      Log.e("MicroMsg.WxaAttrSyncUtils", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(323300);
      return true;
    }
    if (paramWxaAttributes.clf() == null)
    {
      Log.e("MicroMsg.WxaAttrSyncUtils", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(323300);
      return true;
    }
    if ((paramWxaAttributes.cld() == null) || (TextUtils.isEmpty(paramWxaAttributes.cld().appId)))
    {
      Log.e("MicroMsg.WxaAttrSyncUtils", "invalid appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(323300);
      return true;
    }
    if ((paramWxaAttributes.clf().eoZ == 0) && (paramWxaAttributes.clf().appVersion <= 0))
    {
      Log.e("MicroMsg.WxaAttrSyncUtils", "invalid versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(323300);
      return true;
    }
    AppMethodBeat.o(323300);
    return false;
  }
  
  public static boolean h(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(323303);
    k localk = k.qKk;
    long l = k.VN(paramWxaAttributes.field_username);
    if ((l > 0L) && (l >= paramWxaAttributes.field_syncTimeSecond))
    {
      Log.i("MicroMsg.WxaAttrSyncUtils", "isContactMarkedAsInvalid (%s) returns true, treated as invalid until %d, attrs lastSyncTimestamp %d", new Object[] { paramWxaAttributes.field_username, Long.valueOf(l), Long.valueOf(paramWxaAttributes.field_syncTimeSecond) });
      AppMethodBeat.o(323303);
      return true;
    }
    AppMethodBeat.o(323303);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ah
 * JD-Core Version:    0.7.0.1
 */