package com.tencent.liteapp.c;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "", "delete", "", "appId", "", "query", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "queryAll", "", "update", "app", "Companion", "wxa_lite_app_release"})
public abstract interface c
{
  public static final a coR = a.coS;
  
  public abstract WxaLiteAppInfo Nn();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "wxa_lite_app_release"})
  public static final class a
  {
    private static String TAG;
    
    static
    {
      AppMethodBeat.i(259184);
      coS = new a();
      TAG = "WxaLiteApp.IWxaLiteAppStorage";
      AppMethodBeat.o(259184);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.c.c
 * JD-Core Version:    0.7.0.1
 */