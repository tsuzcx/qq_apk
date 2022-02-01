package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<String, Class<? extends AppBrandTaskProxyUI>> koF;
  
  static
  {
    AppMethodBeat.i(45384);
    HashMap localHashMap = new HashMap();
    localHashMap.put(":appbrand0", AppBrandTaskProxyUI.class);
    localHashMap.put(":appbrand1", AppBrandTaskProxyUI1.class);
    localHashMap.put(":appbrand2", AppBrandTaskProxyUI2.class);
    localHashMap.put(":appbrand3", AppBrandTaskProxyUI3.class);
    localHashMap.put(":appbrand4", AppBrandTaskProxyUI4.class);
    koF = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(45384);
  }
  
  public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb)
  {
    AppMethodBeat.i(45381);
    a(paramContext, param_Req, paramb, null);
    AppMethodBeat.o(45381);
  }
  
  public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb, Intent paramIntent)
  {
    AppMethodBeat.i(45382);
    if (param_Req.bhU()) {}
    for (Object localObject = AppBrandProcessLandscapeProxyUI.class;; localObject = AppBrandProcessProxyUI.class)
    {
      AppBrandProcessProxyUI.a(paramContext, (Class)localObject, param_Req, paramb, paramIntent);
      AppMethodBeat.o(45382);
      return;
    }
  }
  
  public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, _Req param_Req, String paramString)
  {
    AppMethodBeat.i(174742);
    Object localObject = aj.getPackageName();
    localObject = (Class)koF.get(paramString.replaceFirst((String)localObject, ""));
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = AppBrandProcessProxyUI.class;
    }
    AppBrandProcessProxyUI.a(paramContext, paramString, param_Req, null, null);
    AppMethodBeat.o(174742);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    AppMethodBeat.i(45380);
    AppBrandProcessProxyUI.a(paramContext, AppBrandProcessProxyUI.class, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, paramOnClickListener3);
    AppMethodBeat.o(45380);
  }
  
  public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void b(Context paramContext, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb)
  {
    AppMethodBeat.i(45383);
    Object localObject1 = aj.getProcessName();
    Object localObject2 = aj.getPackageName();
    localObject2 = (Class)koF.get(((String)localObject1).replaceFirst((String)localObject2, ""));
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = AppBrandProcessProxyUI.class;
    }
    AppBrandProcessProxyUI.a(paramContext, (Class)localObject1, param_Req, paramb, null);
    AppMethodBeat.o(45383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.a
 * JD-Core Version:    0.7.0.1
 */