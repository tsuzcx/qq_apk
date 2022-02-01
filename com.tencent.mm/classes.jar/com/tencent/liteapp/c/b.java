package com.tencent.liteapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "", "startLiteApp", "Lcom/tencent/liteapp/mgr/LauncherStatus;", "app", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "pagePath", "", "query", "startLiteAppAsync", "", "callback", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncherCallback;", "Companion", "wxa_lite_app_release"})
public abstract interface b
{
  public static final a cra = a.crb;
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "wxa_lite_app_release"})
  public static final class a
  {
    private static final String TAG = "WxaLiteApp.IWxaLiteAppLauncher";
    
    static
    {
      AppMethodBeat.i(197925);
      crb = new a();
      TAG = "WxaLiteApp.IWxaLiteAppLauncher";
      AppMethodBeat.o(197925);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.c.b
 * JD-Core Version:    0.7.0.1
 */