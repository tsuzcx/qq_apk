package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.a.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.c;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.plugin.appbrand.media.record.g.10;
import com.tencent.mm.plugin.appbrand.media.record.g.11;
import com.tencent.mm.plugin.appbrand.media.record.g.9;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.utils.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends d<com.tencent.mm.plugin.appbrand.s>
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private static Vector<String> lDK;
  private h.c cxI;
  private b lEt;
  private ac lEu;
  private i.a lEv;
  
  static
  {
    AppMethodBeat.i(45944);
    lDK = new Vector();
    AppMethodBeat.o(45944);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.s params, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45941);
    r.a(params.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(45934);
        if (paramAnonymousInt != 116)
        {
          AppMethodBeat.o(45934);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
          k.this.a(params, paramJSONObject, paramInt);
          AppMethodBeat.o(45934);
          return;
        }
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
        params.i(paramInt, k.this.h("fail:system permission denied", null));
        AppMethodBeat.o(45934);
      }
    });
    int i;
    if ((params.getContext() instanceof Activity))
    {
      localObject = (Activity)params.getContext();
      if (localObject != null) {
        break label105;
      }
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      params.i(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label143;
      }
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
      params.i(paramInt, h("fail:system permission denied", null));
      AppMethodBeat.o(45941);
      return;
      localObject = null;
      break;
      label105:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      i = bool;
      if (bool)
      {
        r.aeq(params.getAppId());
        i = bool;
      }
    }
    label143:
    Object localObject = params.getRuntime().brh();
    if ((((w)localObject).getCurrentPage() == null) || (((w)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      params.i(paramInt, h("fail", null));
      AppMethodBeat.o(45941);
      return;
    }
    this.lEu = ((w)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      params.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(45941);
      return;
    }
    localObject = params.getAppId();
    Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.lEt == null) {
      this.lEt = new b(this, params, paramInt);
    }
    this.lEt.lqe = paramInt;
    this.lEt.appId = ((String)localObject);
    this.lEt.lEA = paramJSONObject.toString();
    this.lEt.processName = MMApplicationContext.getProcessName();
    if (this.cxI == null) {
      this.cxI = new h.c()
      {
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(45931);
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.val$appId });
          paramAnonymousd = new JSONObject();
          try
          {
            paramAnonymousd.put("operationType", "pause");
            if (k.a(k.this) == null) {
              k.a(k.this, new k.b(k.this, params, paramInt));
            }
            k.a(k.this).lEA = paramAnonymousd.toString();
            k.a(k.this).appId = this.val$appId;
            k.a(k.this).action = -1;
            k.a(k.this).bjm();
            AppMethodBeat.o(45931);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(45932);
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[] { this.val$appId });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("operationType", "stop");
            if (k.a(k.this) == null) {
              k.a(k.this, new k.b(k.this, params, paramInt));
            }
            k.a(k.this).lEA = localJSONObject.toString();
            k.a(k.this).appId = this.val$appId;
            k.a(k.this).action = -1;
            k.a(k.this).bEy();
            com.tencent.mm.plugin.appbrand.h.b(this.val$appId, this);
            k.bEB().remove(this.val$appId);
            AppMethodBeat.o(45932);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
      };
    }
    this.lEt.cxI = this.cxI;
    this.lEt.bjm();
    AppMethodBeat.o(45941);
  }
  
  static final class b
    extends a
  {
    public int action;
    public String appId;
    h.c cxI;
    private boolean dVg;
    private int duration;
    public boolean error;
    private String filePath;
    private int fileSize;
    private byte[] frameBuffer;
    public String jFn;
    public com.tencent.mm.plugin.appbrand.s kGT;
    public String lEA;
    private String lEB;
    private String lEC;
    private int lED;
    private final IListener<pc> lEE;
    public String lEk;
    AudioRecordVoIPInterruptListener lEy;
    private k lEz;
    public int lqe;
    public String processName;
    private String state;
    
    public b(k paramk, com.tencent.mm.plugin.appbrand.s params, int paramInt)
    {
      AppMethodBeat.i(45936);
      this.processName = "";
      this.error = false;
      this.jFn = "";
      this.filePath = "";
      this.fileSize = 0;
      this.duration = 0;
      this.state = "";
      this.lEB = "";
      this.lEE = new IListener() {};
      this.lEz = paramk;
      this.kGT = params;
      this.lqe = paramInt;
      paramk = new i();
      if (params.getFileSystem().a(paramk) == m.kSu)
      {
        this.lEC = aa.z(new o((String)paramk.value, "frameBuffer").her());
        AppMethodBeat.o(45936);
        return;
      }
      this.lEC = aa.z(new o(params.getContext().getCacheDir(), "frameBuffer_" + params.getAppId()).her());
      AppMethodBeat.o(45936);
    }
    
    /* Error */
    private void bEC()
    {
      // Byte code:
      //   0: ldc 243
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 179	java/lang/System:nanoTime	()J
      //   8: lstore_1
      //   9: new 105	com/tencent/mm/vfs/o
      //   12: dup
      //   13: aload_0
      //   14: getfield 127	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:lEC	Ljava/lang/String;
      //   17: invokespecial 180	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
      //   20: astore_3
      //   21: aload_3
      //   22: invokevirtual 196	com/tencent/mm/vfs/o:exists	()Z
      //   25: ifeq +105 -> 130
      //   28: aload_3
      //   29: invokestatic 247	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
      //   32: astore 6
      //   34: aload 6
      //   36: astore 5
      //   38: aload_3
      //   39: astore 4
      //   41: aload_0
      //   42: aload_0
      //   43: getfield 165	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:lED	I
      //   46: newarray byte
      //   48: putfield 241	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:frameBuffer	[B
      //   51: aload 6
      //   53: astore 5
      //   55: aload_3
      //   56: astore 4
      //   58: aload 6
      //   60: aload_0
      //   61: getfield 241	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:frameBuffer	[B
      //   64: invokevirtual 253	java/io/InputStream:read	([B)I
      //   67: pop
      //   68: aload 6
      //   70: astore 5
      //   72: aload_3
      //   73: astore 4
      //   75: aload 6
      //   77: invokevirtual 254	java/io/InputStream:close	()V
      //   80: aload 6
      //   82: ifnull +8 -> 90
      //   85: aload 6
      //   87: invokevirtual 254	java/io/InputStream:close	()V
      //   90: aload_3
      //   91: invokevirtual 196	com/tencent/mm/vfs/o:exists	()Z
      //   94: ifeq +94 -> 188
      //   97: aload_3
      //   98: invokevirtual 257	com/tencent/mm/vfs/o:delete	()Z
      //   101: pop
      //   102: ldc 182
      //   104: ldc 226
      //   106: iconst_1
      //   107: anewarray 186	java/lang/Object
      //   110: dup
      //   111: iconst_0
      //   112: invokestatic 179	java/lang/System:nanoTime	()J
      //   115: lload_1
      //   116: lsub
      //   117: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   120: aastore
      //   121: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: ldc 243
      //   126: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: ldc 182
      //   132: ldc_w 259
      //   135: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   138: aload_3
      //   139: invokevirtual 196	com/tencent/mm/vfs/o:exists	()Z
      //   142: ifeq +14 -> 156
      //   145: aload_3
      //   146: invokevirtual 257	com/tencent/mm/vfs/o:delete	()Z
      //   149: pop
      //   150: ldc 243
      //   152: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: return
      //   156: ldc 182
      //   158: ldc_w 264
      //   161: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: ldc 243
      //   166: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: return
      //   170: astore 4
      //   172: ldc 182
      //   174: aload 4
      //   176: ldc 55
      //   178: iconst_0
      //   179: anewarray 186	java/lang/Object
      //   182: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   185: goto -95 -> 90
      //   188: ldc 182
      //   190: ldc_w 264
      //   193: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   196: goto -94 -> 102
      //   199: astore 7
      //   201: aconst_null
      //   202: astore 6
      //   204: aconst_null
      //   205: astore_3
      //   206: aload 6
      //   208: astore 5
      //   210: aload_3
      //   211: astore 4
      //   213: ldc 182
      //   215: aload 7
      //   217: ldc 55
      //   219: iconst_0
      //   220: anewarray 186	java/lang/Object
      //   223: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   226: aload 6
      //   228: ifnull +8 -> 236
      //   231: aload 6
      //   233: invokevirtual 254	java/io/InputStream:close	()V
      //   236: aload_3
      //   237: ifnull +36 -> 273
      //   240: aload_3
      //   241: invokevirtual 196	com/tencent/mm/vfs/o:exists	()Z
      //   244: ifeq +29 -> 273
      //   247: aload_3
      //   248: invokevirtual 257	com/tencent/mm/vfs/o:delete	()Z
      //   251: pop
      //   252: goto -150 -> 102
      //   255: astore 4
      //   257: ldc 182
      //   259: aload 4
      //   261: ldc 55
      //   263: iconst_0
      //   264: anewarray 186	java/lang/Object
      //   267: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   270: goto -34 -> 236
      //   273: ldc 182
      //   275: ldc_w 264
      //   278: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   281: goto -179 -> 102
      //   284: astore 7
      //   286: aconst_null
      //   287: astore 6
      //   289: aconst_null
      //   290: astore_3
      //   291: aload 6
      //   293: astore 5
      //   295: aload_3
      //   296: astore 4
      //   298: ldc 182
      //   300: aload 7
      //   302: ldc 55
      //   304: iconst_0
      //   305: anewarray 186	java/lang/Object
      //   308: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   311: aload 6
      //   313: ifnull +8 -> 321
      //   316: aload 6
      //   318: invokevirtual 254	java/io/InputStream:close	()V
      //   321: aload_3
      //   322: ifnull +36 -> 358
      //   325: aload_3
      //   326: invokevirtual 196	com/tencent/mm/vfs/o:exists	()Z
      //   329: ifeq +29 -> 358
      //   332: aload_3
      //   333: invokevirtual 257	com/tencent/mm/vfs/o:delete	()Z
      //   336: pop
      //   337: goto -235 -> 102
      //   340: astore 4
      //   342: ldc 182
      //   344: aload 4
      //   346: ldc 55
      //   348: iconst_0
      //   349: anewarray 186	java/lang/Object
      //   352: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   355: goto -34 -> 321
      //   358: ldc 182
      //   360: ldc_w 264
      //   363: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   366: goto -264 -> 102
      //   369: astore 6
      //   371: aconst_null
      //   372: astore 5
      //   374: aconst_null
      //   375: astore_3
      //   376: aload 5
      //   378: ifnull +8 -> 386
      //   381: aload 5
      //   383: invokevirtual 254	java/io/InputStream:close	()V
      //   386: aload_3
      //   387: ifnull +41 -> 428
      //   390: aload_3
      //   391: invokevirtual 196	com/tencent/mm/vfs/o:exists	()Z
      //   394: ifeq +34 -> 428
      //   397: aload_3
      //   398: invokevirtual 257	com/tencent/mm/vfs/o:delete	()Z
      //   401: pop
      //   402: ldc 243
      //   404: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   407: aload 6
      //   409: athrow
      //   410: astore 4
      //   412: ldc 182
      //   414: aload 4
      //   416: ldc 55
      //   418: iconst_0
      //   419: anewarray 186	java/lang/Object
      //   422: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   425: goto -39 -> 386
      //   428: ldc 182
      //   430: ldc_w 264
      //   433: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   436: goto -34 -> 402
      //   439: astore 6
      //   441: aconst_null
      //   442: astore 5
      //   444: goto -68 -> 376
      //   447: astore 6
      //   449: aload 4
      //   451: astore_3
      //   452: goto -76 -> 376
      //   455: astore 7
      //   457: aconst_null
      //   458: astore 6
      //   460: goto -169 -> 291
      //   463: astore 7
      //   465: goto -174 -> 291
      //   468: astore 7
      //   470: aconst_null
      //   471: astore 6
      //   473: goto -267 -> 206
      //   476: astore 7
      //   478: goto -272 -> 206
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	481	0	this	b
      //   8	108	1	l	long
      //   20	432	3	localObject1	Object
      //   39	35	4	localObject2	Object
      //   170	5	4	localIOException1	java.io.IOException
      //   211	1	4	localObject3	Object
      //   255	5	4	localIOException2	java.io.IOException
      //   296	1	4	localObject4	Object
      //   340	5	4	localIOException3	java.io.IOException
      //   410	40	4	localIOException4	java.io.IOException
      //   36	407	5	localInputStream1	java.io.InputStream
      //   32	285	6	localInputStream2	java.io.InputStream
      //   369	39	6	localObject5	Object
      //   439	1	6	localObject6	Object
      //   447	1	6	localObject7	Object
      //   458	14	6	localObject8	Object
      //   199	17	7	localFileNotFoundException1	java.io.FileNotFoundException
      //   284	17	7	localIOException5	java.io.IOException
      //   455	1	7	localIOException6	java.io.IOException
      //   463	1	7	localIOException7	java.io.IOException
      //   468	1	7	localFileNotFoundException2	java.io.FileNotFoundException
      //   476	1	7	localFileNotFoundException3	java.io.FileNotFoundException
      // Exception table:
      //   from	to	target	type
      //   85	90	170	java/io/IOException
      //   9	21	199	java/io/FileNotFoundException
      //   231	236	255	java/io/IOException
      //   9	21	284	java/io/IOException
      //   316	321	340	java/io/IOException
      //   9	21	369	finally
      //   381	386	410	java/io/IOException
      //   21	34	439	finally
      //   130	138	439	finally
      //   41	51	447	finally
      //   58	68	447	finally
      //   75	80	447	finally
      //   213	226	447	finally
      //   298	311	447	finally
      //   21	34	455	java/io/IOException
      //   130	138	455	java/io/IOException
      //   41	51	463	java/io/IOException
      //   58	68	463	java/io/IOException
      //   75	80	463	java/io/IOException
      //   21	34	468	java/io/FileNotFoundException
      //   130	138	468	java/io/FileNotFoundException
      //   41	51	476	java/io/FileNotFoundException
      //   58	68	476	java/io/FileNotFoundException
      //   75	80	476	java/io/FileNotFoundException
    }
    
    public final void YC()
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(45937);
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(this.lEA);
        String str = ((JSONObject)localObject2).optString("operationType");
        if (TextUtils.isEmpty(str))
        {
          Log.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
          this.error = true;
          this.action = -1;
          this.jFn = "operationType is null";
          callback();
          AppMethodBeat.o(45937);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.lEA });
        this.error = true;
        this.action = -1;
        this.jFn = "parser data fail, data is invalid";
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + localJSONException.getMessage());
        callback();
        AppMethodBeat.o(45937);
        return;
      }
      Log.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[] { localJSONException });
      this.error = false;
      this.action = -1;
      Object localObject1;
      if (localJSONException.equals("start"))
      {
        i = ((JSONObject)localObject2).optInt("duration", 60000);
        int k = ((JSONObject)localObject2).optInt("sampleRate", 44100);
        int m = ((JSONObject)localObject2).optInt("numberOfChannels", 2);
        int n = ((JSONObject)localObject2).optInt("encodeBitRate", 128000);
        localObject1 = ((JSONObject)localObject2).optString("format");
        double d = ((JSONObject)localObject2).optDouble("frameSize", 0.0D);
        com.tencent.mm.plugin.appbrand.media.record.b localb = com.tencent.mm.plugin.appbrand.media.record.b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), com.tencent.mm.plugin.appbrand.media.record.b.ndh);
        c.b(this.appId, this.lEE);
        localObject2 = new RecordParam();
        ((RecordParam)localObject2).duration = i;
        ((RecordParam)localObject2).sampleRate = k;
        ((RecordParam)localObject2).mFQ = m;
        ((RecordParam)localObject2).mFR = n;
        ((RecordParam)localObject2).lEB = ((String)localObject1);
        ((RecordParam)localObject2).scene = 8;
        ((RecordParam)localObject2).mFS = d;
        ((RecordParam)localObject2).gLc = System.currentTimeMillis();
        ((RecordParam)localObject2).processName = this.processName;
        ((RecordParam)localObject2).appId = this.appId;
        ((RecordParam)localObject2).neu = localb;
        if (this.lEy == null) {
          this.lEy = new AudioRecordVoIPInterruptListener();
        }
        ((RecordParam)localObject2).nev = this.lEy;
        this.lEB = ((String)localObject1);
        c.bOS();
        localObject1 = g.bPa();
        Log.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
        if ((((g)localObject1).ndu != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((g)localObject1).ndu.appId)))
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
          ((g)localObject1).ZZ();
          if ((!TextUtils.isEmpty(((RecordParam)localObject2).lEB)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).mFR > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).mFQ > 0)) {
            break label648;
          }
          i = 0;
          label537:
          if (i != 0) {
            break label653;
          }
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
          j.yz(15);
          i = j;
          label558:
          if (i == 0) {
            break label953;
          }
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
          this.action = -1;
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Record.JsApiOperateRecorder", this.jFn);
        }
        callback();
        AppMethodBeat.o(45937);
        return;
        if (((g)localObject1).dBi)
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
          i = j;
          break label558;
        }
        if (!((g)localObject1).YY()) {
          break;
        }
        Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
        i = j;
        break label558;
        label648:
        i = 1;
        break label537;
        label653:
        if (!com.tencent.mm.plugin.appbrand.media.record.h.acH(((RecordParam)localObject2).lEB))
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).lEB });
          j.yz(16);
          i = j;
          break label558;
        }
        if (TextUtils.isEmpty(((RecordParam)localObject2).gLc)) {
          ((RecordParam)localObject2).gLc = System.currentTimeMillis();
        }
        j.bPi();
        Log.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).mFQ), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).mFR) });
        if (((RecordParam)localObject2).duration <= 0)
        {
          ((RecordParam)localObject2).duration = 60000;
          label804:
          if ((((RecordParam)localObject2).mFQ <= 0) && (((RecordParam)localObject2).mFQ > 2)) {
            ((RecordParam)localObject2).mFQ = 2;
          }
          if (((RecordParam)localObject2).sampleRate <= 48000) {
            break label909;
          }
          ((RecordParam)localObject2).sampleRate = 48000;
          label846:
          if (((RecordParam)localObject2).mFR <= 320000) {
            break label931;
          }
          ((RecordParam)localObject2).mFR = 320000;
        }
        for (;;)
        {
          ThreadPool.post(new g.9((g)localObject1, (RecordParam)localObject2), "app_brand_start_record");
          i = 1;
          break;
          if (((RecordParam)localObject2).duration < 600000) {
            break label804;
          }
          ((RecordParam)localObject2).duration = 600000;
          break label804;
          label909:
          if (((RecordParam)localObject2).sampleRate >= 8000) {
            break label846;
          }
          ((RecordParam)localObject2).sampleRate = 8000;
          break label846;
          label931:
          if (((RecordParam)localObject2).mFR < 16000) {
            ((RecordParam)localObject2).mFR = 16000;
          }
        }
        label953:
        if (g.bPa().dBi)
        {
          this.error = true;
          this.jFn = "audio is recording, don't start record again";
        }
        else
        {
          this.error = true;
          this.jFn = "start record fail";
          continue;
          if (((String)localObject1).equals("resume"))
          {
            localObject1 = g.bPa();
            if (((g)localObject1).dBi) {
              Log.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
            }
            for (;;)
            {
              if (i == 0) {
                break label1088;
              }
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
              break;
              if (((g)localObject1).ndu == null)
              {
                Log.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
              }
              else
              {
                j.bPi();
                ThreadPool.post(new g.10((g)localObject1), "app_brand_resume_record");
                i = 1;
              }
            }
            label1088:
            if (g.bPa().dBi)
            {
              this.error = true;
              this.jFn = "audio is recording, don't resume record again";
            }
            else
            {
              this.error = true;
              this.jFn = "resume record fail";
            }
          }
          else if (((String)localObject1).equals("pause"))
          {
            localObject1 = g.bPa();
            Log.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
            if (((g)localObject1).nds == null)
            {
              Log.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label1233;
              }
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
              break;
              if (((g)localObject1).YY())
              {
                Log.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                i = 1;
              }
              else
              {
                ThreadPool.post(new g.11((g)localObject1), "app_brand_pause_record");
                i = 1;
              }
            }
            label1233:
            if (g.bPa().YY())
            {
              this.error = true;
              this.jFn = "audio is pause, don't pause record again";
            }
            else
            {
              this.error = true;
              this.jFn = "pause record fail";
            }
          }
          else if (((String)localObject1).equals("stop"))
          {
            if (g.bPa().ZZ())
            {
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
            }
            else if (g.bPa().YZ())
            {
              this.error = true;
              this.jFn = "audio is stop, don't stop record again";
            }
            else
            {
              this.error = true;
              this.jFn = "stop record fail";
            }
          }
          else
          {
            Log.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
            this.error = true;
            this.jFn = "operationType is invalid";
          }
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(45938);
      super.callback();
      if (this.kGT == null)
      {
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
        AppMethodBeat.o(45938);
        return;
      }
      if (this.action == -1)
      {
        if (!this.error)
        {
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
          this.kGT.i(this.lqe, this.lEz.h("ok", null));
          AppMethodBeat.o(45938);
          return;
        }
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[] { this.jFn });
        this.kGT.i(this.lqe, this.lEz.h("fail:" + this.jFn, null));
        AppMethodBeat.o(45938);
        return;
      }
      k.a locala = new k.a();
      HashMap localHashMap;
      Object localObject;
      switch (this.action)
      {
      default: 
        if (this.action == 2)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[] { this.filePath, this.lEB });
          localObject = new i();
          if (this.kGT.getFileSystem().a(new o(this.filePath), com.tencent.mm.plugin.appbrand.media.record.h.acG(this.lEB), true, (i)localObject) == m.kSu)
          {
            localHashMap.put("tempFilePath", ((i)localObject).value);
            label312:
            localHashMap.put("duration", Integer.valueOf(this.duration));
            localHashMap.put("fileSize", Integer.valueOf(this.fileSize));
            this.lEk = new JSONObject(localHashMap).toString();
          }
        }
        else if (this.action == 5)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          localHashMap.put("isLastFrame", Boolean.valueOf(this.dVg));
          if (this.lED > 819200) {
            bEC();
          }
          if (this.frameBuffer == null) {
            break label664;
          }
          localHashMap.put("frameBuffer", x.aP(this.frameBuffer));
          label445:
          localObject = x.a(this.kGT.getJsRuntime(), localHashMap, (x.a)this.kGT.av(x.a.class));
          if (localObject != x.b.oho) {
            break label675;
          }
          this.lEk = new JSONObject(localHashMap).toString();
        }
        break;
      }
      label664:
      label675:
      while (localObject != x.b.ohp)
      {
        Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[] { Integer.valueOf(this.action), this.lEk });
        locala.g(this.kGT).Zg(this.lEk).bEo();
        AppMethodBeat.o(45938);
        return;
        k.a(this.lEz, true);
        if (k.bEB().contains(this.appId)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.h.a(this.appId, this.cxI);
        k.bEB().add(this.appId);
        break;
        k.a(this.lEz, false);
        if ((this.action != 2) && (this.action != 4)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.h.b(this.appId, this.cxI);
        k.bEB().remove(this.appId);
        break;
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        break label312;
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
        break label445;
      }
      x.m(this.kGT, "onRecorderStateChange");
      AppMethodBeat.o(45938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */