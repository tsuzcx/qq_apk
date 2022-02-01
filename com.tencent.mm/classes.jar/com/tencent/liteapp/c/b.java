package com.tencent.liteapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "", "startLiteApp", "Lcom/tencent/liteapp/mgr/LauncherStatus;", "app", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "pagePath", "", "query", "config", "startLiteAppAsync", "", "callback", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncherCallback;", "Companion", "wxa_lite_app_release"})
public abstract interface b
{
  public static final a coP = a.coQ;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "wxa_lite_app_release"})
  public static final class a
  {
    private static final String TAG = "WxaLiteApp.IWxaLiteAppLauncher";
    
    static
    {
      AppMethodBeat.i(259177);
      coQ = new a();
      TAG = "WxaLiteApp.IWxaLiteAppLauncher";
      AppMethodBeat.o(259177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.c.b
 * JD-Core Version:    0.7.0.1
 */