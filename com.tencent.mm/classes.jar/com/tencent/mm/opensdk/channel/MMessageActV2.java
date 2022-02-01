package com.tencent.mm.opensdk.channel;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

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
    if ((paramContext != null) && (paramArgs != null))
    {
      if (b.b(paramArgs.targetPkgName))
      {
        Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + paramArgs.targetPkgName);
        AppMethodBeat.o(3828);
        return false;
      }
      if (b.b(paramArgs.targetClassName)) {
        paramArgs.targetClassName = (paramArgs.targetPkgName + ".wxapi.WXEntryActivity");
      }
      Log.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + paramArgs.targetPkgName + ", targetClassName = " + paramArgs.targetClassName + ", launchMode = " + paramArgs.launchMode);
      Intent localIntent = new Intent();
      localIntent.setClassName(paramArgs.targetPkgName, paramArgs.targetClassName);
      Object localObject = paramArgs.bundle;
      if (localObject != null) {
        localIntent.putExtras((Bundle)localObject);
      }
      localObject = paramContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 638058496);
      localIntent.putExtra("_mmessage_appPackage", (String)localObject);
      localIntent.putExtra("_mmessage_content", paramArgs.content);
      localIntent.putExtra("_mmessage_checksum", com.tencent.mm.opensdk.channel.a.a.a(paramArgs.content, 638058496, (String)localObject));
      localIntent.putExtra("_message_token", paramArgs.token);
      int i = paramArgs.flags;
      if (i == -1) {
        localIntent.addFlags(268435456).addFlags(134217728);
      }
      try
      {
        if ((Build.VERSION.SDK_INT >= 29) && (paramArgs.launchMode == 2)) {
          sendUsingPendingIntent(paramContext, localIntent);
        }
        for (;;)
        {
          Log.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=".concat(String.valueOf(localIntent)));
          AppMethodBeat.o(3828);
          return true;
          localIntent.setFlags(i);
          break;
          paramArgs = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArgs.aYi(), "com/tencent/mm/opensdk/channel/MMessageActV2", "send", "(Landroid/content/Context;Lcom/tencent/mm/opensdk/channel/MMessageActV2$Args;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramArgs.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/opensdk/channel/MMessageActV2", "send", "(Landroid/content/Context;Lcom/tencent/mm/opensdk/channel/MMessageActV2$Args;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.SDK.MMessageAct", "send fail, ex = " + paramContext.getMessage());
        AppMethodBeat.o(3828);
        return false;
      }
    }
    AppMethodBeat.o(3828);
    return false;
  }
  
  private static void sendUsingPendingIntent(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(242958);
    try
    {
      Log.i("MicroMsg.SDK.MMessageAct", "sendUsingPendingIntent");
      PendingIntent.getActivity(paramContext, 3, paramIntent, 134217728).send(paramContext, 4, null, new PendingIntent.OnFinished()
      {
        public void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(242954);
          Log.i("MicroMsg.SDK.MMessageAct", "sendUsingPendingIntent onSendFinished resultCode: " + paramAnonymousInt + ", resultData: " + paramAnonymousString);
          AppMethodBeat.o(242954);
        }
      }, null);
      AppMethodBeat.o(242958);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.MMessageAct", "sendUsingPendingIntent fail, ex = " + localException.getMessage());
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/opensdk/channel/MMessageActV2", "sendUsingPendingIntent", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/opensdk/channel/MMessageActV2", "sendUsingPendingIntent", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(242958);
    }
  }
  
  public static class Args
  {
    public static final int INVALID_FLAGS = -1;
    public Bundle bundle;
    public String content;
    public int flags;
    public int launchMode;
    public String targetClassName;
    public String targetPkgName;
    public String token;
    
    public Args()
    {
      AppMethodBeat.i(242953);
      this.flags = -1;
      this.launchMode = 2;
      AppMethodBeat.o(242953);
    }
    
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