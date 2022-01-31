package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<String, Class<? extends AppBrandTaskProxyUI>> gdE;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(":appbrand0", AppBrandTaskProxyUI.class);
    localHashMap.put(":appbrand1", AppBrandTaskProxyUI1.class);
    localHashMap.put(":appbrand2", AppBrandTaskProxyUI2.class);
    localHashMap.put(":appbrand3", AppBrandTaskProxyUI3.class);
    localHashMap.put(":appbrand4", AppBrandTaskProxyUI4.class);
    localHashMap.put(":toolsmp", AppBrandTaskInToolsProxyUI.class);
    gdE = Collections.unmodifiableMap(localHashMap);
  }
  
  public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb)
  {
    AppBrandProcessProxyUI.a(paramContext, AppBrandProcessProxyUI.class, param_Req, paramb);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    AppBrandProcessProxyUI.a(paramContext, AppBrandProcessProxyUI.class, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, paramOnClickListener3);
  }
  
  public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void b(Context paramContext, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb)
  {
    Object localObject1 = ae.getProcessName();
    Object localObject2 = ae.getPackageName();
    localObject2 = (Class)gdE.get(((String)localObject1).replaceFirst((String)localObject2, ""));
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = AppBrandProcessProxyUI.class;
    }
    AppBrandProcessProxyUI.a(paramContext, (Class)localObject1, param_Req, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.a
 * JD-Core Version:    0.7.0.1
 */