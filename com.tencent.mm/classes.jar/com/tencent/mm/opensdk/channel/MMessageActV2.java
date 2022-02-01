package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
  private byte _hellAccFlag_;
  
  public static boolean send(Context paramContext, Args paramArgs)
  {
    AppMethodBeat.i(3828);
    if ((paramContext == null) || (paramArgs == null))
    {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      AppMethodBeat.o(3828);
      return false;
    }
    if (d.b(paramArgs.targetPkgName))
    {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + paramArgs.targetPkgName);
      AppMethodBeat.o(3828);
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
    localIntent.putExtra("_mmessage_sdkVersion", 637927424);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", paramArgs.content);
    localIntent.putExtra("_mmessage_checksum", b.a(paramArgs.content, 637927424, str));
    localIntent.putExtra("_message_token", paramArgs.token);
    if (paramArgs.flags == -1) {
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    for (;;)
    {
      try
      {
        paramArgs = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArgs.aeD(), "com/tencent/mm/opensdk/channel/MMessageActV2", "send", "(Landroid/content/Context;Lcom/tencent/mm/opensdk/channel/MMessageActV2$Args;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramArgs.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/opensdk/channel/MMessageActV2", "send", "(Landroid/content/Context;Lcom/tencent/mm/opensdk/channel/MMessageActV2$Args;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=".concat(String.valueOf(localIntent)));
        AppMethodBeat.o(3828);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.SDK.MMessageAct", "send fail, ex = " + paramContext.getMessage());
        AppMethodBeat.o(3828);
      }
      localIntent.setFlags(paramArgs.flags);
    }
    return false;
  }
  
  public static class Args
  {
    public static final int INVALID_FLAGS = -1;
    public Bundle bundle;
    public String content;
    public int flags = -1;
    public String targetClassName;
    public String targetPkgName;
    public String token;
    
    public String toString()
    {
      AppMethodBeat.i(3829);
      String str = "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
      AppMethodBeat.o(3829);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2
 * JD-Core Version:    0.7.0.1
 */