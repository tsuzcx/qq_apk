package com.tencent.liteapp.c;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "", "delete", "", "appId", "", "deleteBaselib", "majorVersion", "query", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "queryAll", "", "queryBaselib", "Lcom/tencent/liteapp/storage/WxaLiteAppBaselibInfo;", "queryLatestBaselib", "update", "app", "updateBaselib", "baselib", "Companion", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
public abstract interface c
{
  public static final a egd = a.ege;
  
  public abstract WxaLiteAppInfo anG();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    private static String TAG;
    
    static
    {
      AppMethodBeat.i(219057);
      ege = new a();
      TAG = "WxaLiteApp.IWxaLiteAppStorage";
      AppMethodBeat.o(219057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.c.c
 * JD-Core Version:    0.7.0.1
 */