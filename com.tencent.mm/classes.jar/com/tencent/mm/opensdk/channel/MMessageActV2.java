package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2
{
  public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
  public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
  public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
  private static final String TAG = "MicroMsg.SDK.MMessageAct";
  
  public static boolean send(Context paramContext, MMessageActV2.Args paramArgs)
  {
    AppMethodBeat.i(128140);
    if ((paramContext == null) || (paramArgs == null))
    {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      AppMethodBeat.o(128140);
      return false;
    }
    if (d.b(paramArgs.targetPkgName))
    {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + paramArgs.targetPkgName);
      AppMethodBeat.o(128140);
      return false;
    }
    if (d.b(paramArgs.targetClassName)) {
      paramArgs.targetClassName = (paramArgs.targetPkgName + ".wxapi.WXEntryActivity");
    }
    Log.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + paramArgs.targetPkgName + ", targetClassName = " + paramArgs.targetClassName);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramArgs.targetPkgName, paramArgs.targetClassName);
    if (paramArgs.bundle != null) {
      localIntent.putExtras(paramArgs.bundle);
    }
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 620954624);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", paramArgs.content);
    localIntent.putExtra("_mmessage_checksum", b.a(paramArgs.content, 620954624, str));
    localIntent.putExtra("_message_token", paramArgs.token);
    if (paramArgs.flags == -1) {
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        Log.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=".concat(String.valueOf(localIntent)));
        AppMethodBeat.o(128140);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.SDK.MMessageAct", "send fail, ex = " + paramContext.getMessage());
        AppMethodBeat.o(128140);
      }
      localIntent.setFlags(paramArgs.flags);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2
 * JD-Core Version:    0.7.0.1
 */