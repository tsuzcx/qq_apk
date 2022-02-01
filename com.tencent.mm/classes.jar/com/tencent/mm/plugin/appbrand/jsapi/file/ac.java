package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import org.json.JSONObject;

public final class ac
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 99;
  private static final String NAME = "openDocument";
  private static long rXH = -1L;
  private String mAppID;
  private com.tencent.mm.plugin.multitask.c.a rXI;
  private com.tencent.mm.plugin.multitask.c.a rXJ;
  private com.tencent.mm.plugin.appbrand.r.a rvg;
  
  public ac()
  {
    AppMethodBeat.i(174793);
    this.rXI = new com.tencent.mm.plugin.multitask.c.a()
    {
      /* Error */
      public final void dl(java.util.List<com.tencent.mm.plugin.multitask.model.MultiTaskInfo> paramAnonymousList)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_1
        //   6: invokeinterface 33 1 0
        //   11: astore_1
        //   12: aload_1
        //   13: invokeinterface 39 1 0
        //   18: ifeq +114 -> 132
        //   21: aload_1
        //   22: invokeinterface 43 1 0
        //   27: checkcast 45	com/tencent/mm/plugin/multitask/model/MultiTaskInfo
        //   30: astore_3
        //   31: aload_3
        //   32: ifnull -20 -> 12
        //   35: aload_3
        //   36: getfield 49	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_type	I
        //   39: iconst_4
        //   40: if_icmpne -28 -> 12
        //   43: aload_3
        //   44: getfield 53	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_data	[B
        //   47: ifnull -35 -> 12
        //   50: new 55	com/tencent/mm/protocal/protobuf/asy
        //   53: dup
        //   54: invokespecial 56	com/tencent/mm/protocal/protobuf/asy:<init>	()V
        //   57: astore_2
        //   58: aload_2
        //   59: aload_3
        //   60: getfield 53	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_data	[B
        //   63: invokevirtual 60	com/tencent/mm/protocal/protobuf/asy:parseFrom	([B)Lcom/tencent/mm/bx/a;
        //   66: pop
        //   67: aload_2
        //   68: getfield 64	com/tencent/mm/protocal/protobuf/asy:appId	Ljava/lang/String;
        //   71: invokestatic 70	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   74: aload_0
        //   75: getfield 14	com/tencent/mm/plugin/appbrand/jsapi/file/ac$3:rXL	Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;
        //   78: invokestatic 74	com/tencent/mm/plugin/appbrand/jsapi/file/ac:d	(Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;)Ljava/lang/String;
        //   81: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   84: ifeq -72 -> 12
        //   87: aload_0
        //   88: getfield 14	com/tencent/mm/plugin/appbrand/jsapi/file/ac$3:rXL	Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;
        //   91: invokestatic 84	com/tencent/mm/plugin/appbrand/jsapi/file/ac:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;)Lcom/tencent/mm/plugin/appbrand/r/a;
        //   94: ifnull -82 -> 12
        //   97: aload_0
        //   98: getfield 14	com/tencent/mm/plugin/appbrand/jsapi/file/ac$3:rXL	Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;
        //   101: invokestatic 84	com/tencent/mm/plugin/appbrand/jsapi/file/ac:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;)Lcom/tencent/mm/plugin/appbrand/r/a;
        //   104: invokestatic 90	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
        //   107: invokevirtual 96	com/tencent/mm/plugin/appbrand/r/a:adR	(Ljava/lang/String;)V
        //   110: goto -98 -> 12
        //   113: astore_3
        //   114: ldc 98
        //   116: ldc 100
        //   118: iconst_1
        //   119: anewarray 4	java/lang/Object
        //   122: dup
        //   123: iconst_0
        //   124: aload_3
        //   125: aastore
        //   126: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   129: goto -62 -> 67
        //   132: ldc 21
        //   134: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   137: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	3
        //   0	138	1	paramAnonymousList	java.util.List<com.tencent.mm.plugin.multitask.model.MultiTaskInfo>
        //   57	11	2	localasy	com.tencent.mm.protocal.protobuf.asy
        //   30	30	3	localMultiTaskInfo	com.tencent.mm.plugin.multitask.model.MultiTaskInfo
        //   113	12	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   58	67	113	finally
      }
    };
    this.rXJ = new com.tencent.mm.plugin.multitask.c.a()
    {
      /* Error */
      public final void dl(java.util.List<com.tencent.mm.plugin.multitask.model.MultiTaskInfo> paramAnonymousList)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_1
        //   6: invokeinterface 33 1 0
        //   11: astore_1
        //   12: aload_1
        //   13: invokeinterface 39 1 0
        //   18: ifeq +109 -> 127
        //   21: aload_1
        //   22: invokeinterface 43 1 0
        //   27: checkcast 45	com/tencent/mm/plugin/multitask/model/MultiTaskInfo
        //   30: astore_3
        //   31: aload_3
        //   32: ifnull -20 -> 12
        //   35: aload_3
        //   36: getfield 49	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_type	I
        //   39: iconst_4
        //   40: if_icmpne -28 -> 12
        //   43: aload_3
        //   44: getfield 53	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_data	[B
        //   47: ifnull -35 -> 12
        //   50: new 55	com/tencent/mm/protocal/protobuf/asy
        //   53: dup
        //   54: invokespecial 56	com/tencent/mm/protocal/protobuf/asy:<init>	()V
        //   57: astore_2
        //   58: aload_2
        //   59: aload_3
        //   60: getfield 53	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_data	[B
        //   63: invokevirtual 60	com/tencent/mm/protocal/protobuf/asy:parseFrom	([B)Lcom/tencent/mm/bx/a;
        //   66: pop
        //   67: aload_2
        //   68: getfield 64	com/tencent/mm/protocal/protobuf/asy:processName	Ljava/lang/String;
        //   71: invokestatic 70	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   74: invokestatic 76	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
        //   77: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   80: ifeq -68 -> 12
        //   83: aload_0
        //   84: getfield 14	com/tencent/mm/plugin/appbrand/jsapi/file/ac$4:rXL	Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;
        //   87: invokestatic 86	com/tencent/mm/plugin/appbrand/jsapi/file/ac:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;)Lcom/tencent/mm/plugin/appbrand/r/a;
        //   90: ifnull -78 -> 12
        //   93: aload_0
        //   94: getfield 14	com/tencent/mm/plugin/appbrand/jsapi/file/ac$4:rXL	Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;
        //   97: invokestatic 86	com/tencent/mm/plugin/appbrand/jsapi/file/ac:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/file/ac;)Lcom/tencent/mm/plugin/appbrand/r/a;
        //   100: ldc 88
        //   102: invokevirtual 94	com/tencent/mm/plugin/appbrand/r/a:adR	(Ljava/lang/String;)V
        //   105: goto -93 -> 12
        //   108: astore_3
        //   109: ldc 96
        //   111: ldc 98
        //   113: iconst_1
        //   114: anewarray 4	java/lang/Object
        //   117: dup
        //   118: iconst_0
        //   119: aload_3
        //   120: aastore
        //   121: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   124: goto -57 -> 67
        //   127: ldc 21
        //   129: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   132: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	133	0	this	4
        //   0	133	1	paramAnonymousList	java.util.List<com.tencent.mm.plugin.multitask.model.MultiTaskInfo>
        //   57	11	2	localasy	com.tencent.mm.protocal.protobuf.asy
        //   30	30	3	localMultiTaskInfo	com.tencent.mm.plugin.multitask.model.MultiTaskInfo
        //   108	12	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   58	67	108	finally
      }
    };
    AppMethodBeat.o(174793);
  }
  
  private static String a(f paramf, u paramu, String paramString)
  {
    AppMethodBeat.i(329157);
    if (paramu == null)
    {
      AppMethodBeat.o(329157);
      return null;
    }
    if ((paramf == null) || (paramf.getFileSystem() == null))
    {
      AppMethodBeat.o(329157);
      return null;
    }
    String str = ah.v(paramu.jKT());
    if (!Util.nullAsNil(str).endsWith(paramString))
    {
      Log.i("MicroMsg.AppBrand.JsApiOpenDocument", "create new temp file for suffix");
      paramString = String.format("%s.%s", new Object[] { paramu.getName(), paramString });
      paramf = paramf.getFileSystem().Wo(paramString);
      if ((paramf != null) && (paramf.jKS())) {}
    }
    try
    {
      paramf.jKZ();
      label112:
      y.O(str, ah.v(paramf.jKT()), false);
      if ((paramf.jKS()) && (paramf.length() == paramu.length()))
      {
        paramf = ah.v(paramf.jKT());
        AppMethodBeat.o(329157);
        return paramf;
      }
      paramf = ah.v(paramu.jKT());
      AppMethodBeat.o(329157);
      return paramf;
    }
    catch (IOException paramString)
    {
      break label112;
    }
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46349);
    long l = Util.nowMilliSecond();
    if (l - rXH < 1000L)
    {
      paramf.callback(paramInt, ZP("fail:document viewer already starting"));
      AppMethodBeat.o(46349);
      return;
    }
    rXH = l;
    final Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46349);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("showMenu");
    Object localObject = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil((String)localObject))
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46349);
      return;
    }
    u localu = paramf.getFileSystem().Wm((String)localObject);
    if (localu == null)
    {
      paramf.callback(paramInt, ZP("fail:file doesn't exist"));
      AppMethodBeat.o(46349);
      return;
    }
    this.mAppID = paramf.getAppId();
    String str = org.apache.commons.b.c.bKZ((String)localObject);
    localObject = new OpenFileRequest();
    ((OpenFileRequest)localObject).filePath = a(paramf, localu, str);
    ((OpenFileRequest)localObject).lPJ = str;
    ((OpenFileRequest)localObject).appId = this.mAppID;
    ((OpenFileRequest)localObject).rvh = bool;
    paramJSONObject = paramJSONObject.optString("fileType");
    if (!Util.isNullOrNil(paramJSONObject)) {
      ((OpenFileRequest)localObject).lPJ = paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, (AppBrandProxyUIProcessTask.ProcessRequest)localObject, new AppBrandProxyUIProcessTask.b() {});
    k.a(paramf.getAppId(), new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(174789);
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this);
          com.tencent.mm.plugin.appbrand.r.a.a(ac.b(ac.this));
        }
        AppMethodBeat.o(174789);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(174788);
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this);
          ac.a(ac.this, null);
        }
        k.b(paramf.getAppId(), this);
        AppMethodBeat.o(174788);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(174790);
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this);
          com.tencent.mm.plugin.appbrand.r.a.a(ac.c(ac.this));
        }
        AppMethodBeat.o(174790);
      }
    });
    AppMethodBeat.o(46349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ac
 * JD-Core Version:    0.7.0.1
 */