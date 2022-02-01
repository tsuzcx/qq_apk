package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.a.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.g.10;
import com.tencent.mm.plugin.appbrand.media.record.g.11;
import com.tencent.mm.plugin.appbrand.media.record.g.9;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private static Vector<String> kbD;
  private g.c cbu;
  private b kcm;
  private aa kcn;
  private c.a kco;
  
  static
  {
    AppMethodBeat.i(45944);
    kbD = new Vector();
    AppMethodBeat.o(45944);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.q paramq, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45941);
    o.a(paramq.getAppId(), new a.a()
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
          ac.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
          j.this.a(paramq, paramJSONObject, paramInt);
          AppMethodBeat.o(45934);
          return;
        }
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
        paramq.h(paramInt, j.this.e("fail:system permission denied", null));
        AppMethodBeat.o(45934);
      }
    });
    int i;
    if ((paramq.getContext() instanceof Activity))
    {
      localObject = (Activity)paramq.getContext();
      if (localObject != null) {
        break label105;
      }
      ac.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      paramq.h(paramInt, e("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label143;
      }
      ac.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
      paramq.h(paramInt, e("fail:system permission denied", null));
      AppMethodBeat.o(45941);
      return;
      localObject = null;
      break;
      label105:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      i = bool;
      if (bool)
      {
        o.Qo(paramq.getAppId());
        i = bool;
      }
    }
    label143:
    Object localObject = paramq.getRuntime().aSA();
    if ((((u)localObject).getCurrentPage() == null) || (((u)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramq.h(paramInt, e("fail", null));
      AppMethodBeat.o(45941);
      return;
    }
    this.kcn = ((u)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      paramq.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(45941);
      return;
    }
    localObject = paramq.getAppId();
    ac.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.kcm == null) {
      this.kcm = new b(this, paramq, paramInt);
    }
    this.kcm.jOT = paramInt;
    this.kcm.appId = ((String)localObject);
    this.kcm.kct = paramJSONObject.toString();
    this.kcm.processName = ai.getProcessName();
    if (this.cbu == null) {
      this.cbu = new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(45931);
          ac.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.val$appId });
          paramAnonymousd = new JSONObject();
          try
          {
            paramAnonymousd.put("operationType", "pause");
            if (j.a(j.this) == null) {
              j.a(j.this, new j.b(j.this, paramq, paramInt));
            }
            j.a(j.this).kct = paramAnonymousd.toString();
            j.a(j.this).appId = this.val$appId;
            j.a(j.this).action = -1;
            j.a(j.this).aLt();
            AppMethodBeat.o(45931);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(45932);
          ac.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[] { this.val$appId });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("operationType", "stop");
            if (j.a(j.this) == null) {
              j.a(j.this, new j.b(j.this, paramq, paramInt));
            }
            j.a(j.this).kct = localJSONObject.toString();
            j.a(j.this).appId = this.val$appId;
            j.a(j.this).action = -1;
            j.a(j.this).beY();
            com.tencent.mm.plugin.appbrand.g.b(this.val$appId, this);
            j.bfb().remove(this.val$appId);
            AppMethodBeat.o(45932);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
      };
    }
    this.kcm.cbu = this.cbu;
    this.kcm.aLt();
    AppMethodBeat.o(45941);
  }
  
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    private static final int CTRL_INDEX = 296;
    private static final String NAME = "onRecorderStateChange";
  }
  
  static final class b
    extends a
  {
    public int action;
    public String appId;
    g.c cbu;
    private boolean dqz;
    private int duration;
    public boolean error;
    private String filePath;
    private int fileSize;
    private byte[] frameBuffer;
    public String imz;
    public int jOT;
    public com.tencent.mm.plugin.appbrand.q jiP;
    public String kcd;
    AudioRecordVoIPInterruptListener kcr;
    private j kcs;
    public String kct;
    private String kcu;
    private String kcv;
    private int kcw;
    private final com.tencent.mm.sdk.b.c<ob> kcx;
    public String processName;
    private String state;
    
    public b(j paramj, com.tencent.mm.plugin.appbrand.q paramq, int paramInt)
    {
      AppMethodBeat.i(45936);
      this.processName = "";
      this.error = false;
      this.imz = "";
      this.filePath = "";
      this.fileSize = 0;
      this.duration = 0;
      this.state = "";
      this.kcu = "";
      this.kcx = new com.tencent.mm.sdk.b.c() {};
      this.kcs = paramj;
      this.jiP = paramq;
      this.jOT = paramInt;
      paramj = new i();
      if (paramq.DH().a(paramj) == l.jsB)
      {
        this.kcv = com.tencent.mm.vfs.q.B(new e((String)paramj.value, "frameBuffer").fxV());
        AppMethodBeat.o(45936);
        return;
      }
      this.kcv = com.tencent.mm.vfs.q.B(new e(paramq.getContext().getCacheDir(), "frameBuffer_" + paramq.getAppId()).fxV());
      AppMethodBeat.o(45936);
    }
    
    /* Error */
    private void bfc()
    {
      // Byte code:
      //   0: ldc 243
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 179	java/lang/System:nanoTime	()J
      //   8: lstore_1
      //   9: new 105	com/tencent/mm/vfs/e
      //   12: dup
      //   13: aload_0
      //   14: getfield 127	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:kcv	Ljava/lang/String;
      //   17: invokespecial 180	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   20: astore_3
      //   21: aload_3
      //   22: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   25: ifeq +105 -> 130
      //   28: aload_3
      //   29: invokestatic 247	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
      //   32: astore 6
      //   34: aload 6
      //   36: astore 5
      //   38: aload_3
      //   39: astore 4
      //   41: aload_0
      //   42: aload_0
      //   43: getfield 165	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:kcw	I
      //   46: newarray byte
      //   48: putfield 241	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:frameBuffer	[B
      //   51: aload 6
      //   53: astore 5
      //   55: aload_3
      //   56: astore 4
      //   58: aload 6
      //   60: aload_0
      //   61: getfield 241	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:frameBuffer	[B
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
      //   91: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   94: ifeq +94 -> 188
      //   97: aload_3
      //   98: invokevirtual 257	com/tencent/mm/vfs/e:delete	()Z
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
      //   121: invokestatic 192	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: ldc 243
      //   126: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: ldc 182
      //   132: ldc_w 259
      //   135: invokestatic 262	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   138: aload_3
      //   139: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   142: ifeq +14 -> 156
      //   145: aload_3
      //   146: invokevirtual 257	com/tencent/mm/vfs/e:delete	()Z
      //   149: pop
      //   150: ldc 243
      //   152: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: return
      //   156: ldc 182
      //   158: ldc_w 264
      //   161: invokestatic 262	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: ldc 243
      //   166: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: return
      //   170: astore 4
      //   172: ldc 182
      //   174: aload 4
      //   176: ldc 55
      //   178: iconst_0
      //   179: anewarray 186	java/lang/Object
      //   182: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   185: goto -95 -> 90
      //   188: ldc 182
      //   190: ldc_w 264
      //   193: invokestatic 262	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   223: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   226: aload 6
      //   228: ifnull +8 -> 236
      //   231: aload 6
      //   233: invokevirtual 254	java/io/InputStream:close	()V
      //   236: aload_3
      //   237: ifnull +36 -> 273
      //   240: aload_3
      //   241: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   244: ifeq +29 -> 273
      //   247: aload_3
      //   248: invokevirtual 257	com/tencent/mm/vfs/e:delete	()Z
      //   251: pop
      //   252: goto -150 -> 102
      //   255: astore 4
      //   257: ldc 182
      //   259: aload 4
      //   261: ldc 55
      //   263: iconst_0
      //   264: anewarray 186	java/lang/Object
      //   267: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   270: goto -34 -> 236
      //   273: ldc 182
      //   275: ldc_w 264
      //   278: invokestatic 262	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   308: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   311: aload 6
      //   313: ifnull +8 -> 321
      //   316: aload 6
      //   318: invokevirtual 254	java/io/InputStream:close	()V
      //   321: aload_3
      //   322: ifnull +36 -> 358
      //   325: aload_3
      //   326: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   329: ifeq +29 -> 358
      //   332: aload_3
      //   333: invokevirtual 257	com/tencent/mm/vfs/e:delete	()Z
      //   336: pop
      //   337: goto -235 -> 102
      //   340: astore 4
      //   342: ldc 182
      //   344: aload 4
      //   346: ldc 55
      //   348: iconst_0
      //   349: anewarray 186	java/lang/Object
      //   352: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   355: goto -34 -> 321
      //   358: ldc 182
      //   360: ldc_w 264
      //   363: invokestatic 262	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   391: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   394: ifeq +34 -> 428
      //   397: aload_3
      //   398: invokevirtual 257	com/tencent/mm/vfs/e:delete	()Z
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
      //   422: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   425: goto -39 -> 386
      //   428: ldc 182
      //   430: ldc_w 264
      //   433: invokestatic 262	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    
    public final void Am()
    {
      AppMethodBeat.i(45938);
      super.Am();
      if (this.jiP == null)
      {
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
        AppMethodBeat.o(45938);
        return;
      }
      if (this.action == -1)
      {
        if (!this.error)
        {
          ac.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
          this.jiP.h(this.jOT, this.kcs.e("ok", null));
          AppMethodBeat.o(45938);
          return;
        }
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[] { this.imz });
        this.jiP.h(this.jOT, this.kcs.e("fail:" + this.imz, null));
        AppMethodBeat.o(45938);
        return;
      }
      j.a locala = new j.a();
      HashMap localHashMap;
      Object localObject;
      switch (this.action)
      {
      default: 
        if (this.action == 2)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          ac.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[] { this.filePath, this.kcu });
          localObject = new i();
          if (this.jiP.DH().a(new e(this.filePath), h.OQ(this.kcu), true, (i)localObject) == l.jsB)
          {
            localHashMap.put("tempFilePath", ((i)localObject).value);
            label312:
            localHashMap.put("duration", Integer.valueOf(this.duration));
            localHashMap.put("fileSize", Integer.valueOf(this.fileSize));
            this.kcd = new JSONObject(localHashMap).toString();
          }
        }
        else if (this.action == 5)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          localHashMap.put("isLastFrame", Boolean.valueOf(this.dqz));
          if (this.kcw > 819200) {
            bfc();
          }
          if (this.frameBuffer == null) {
            break label664;
          }
          localHashMap.put("frameBuffer", v.ay(this.frameBuffer));
          label445:
          localObject = v.a(this.jiP.aUV(), localHashMap, (v.a)this.jiP.ar(v.a.class));
          if (localObject != v.b.moG) {
            break label675;
          }
          this.kcd = new JSONObject(localHashMap).toString();
        }
        break;
      }
      label664:
      label675:
      while (localObject != v.b.moH)
      {
        ac.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[] { Integer.valueOf(this.action), this.kcd });
        locala.g(this.jiP).LN(this.kcd).beN();
        AppMethodBeat.o(45938);
        return;
        j.a(this.kcs, true);
        if (j.bfb().contains(this.appId)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.g.a(this.appId, this.cbu);
        j.bfb().add(this.appId);
        break;
        j.a(this.kcs, false);
        if ((this.action != 2) && (this.action != 4)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.g.b(this.appId, this.cbu);
        j.bfb().remove(this.appId);
        break;
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        break label312;
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
        break label445;
      }
      v.k(this.jiP, "onRecorderStateChange");
      AppMethodBeat.o(45938);
    }
    
    public final void MO()
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(45937);
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(this.kct);
        String str = ((JSONObject)localObject2).optString("operationType");
        if (TextUtils.isEmpty(str))
        {
          ac.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
          this.error = true;
          this.action = -1;
          this.imz = "operationType is null";
          Am();
          AppMethodBeat.o(45937);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.kct });
        this.error = true;
        this.action = -1;
        this.imz = "parser data fail, data is invalid";
        ac.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + localJSONException.getMessage());
        Am();
        AppMethodBeat.o(45937);
        return;
      }
      ac.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[] { localJSONException });
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
        com.tencent.mm.plugin.appbrand.media.record.b localb = com.tencent.mm.plugin.appbrand.media.record.b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), com.tencent.mm.plugin.appbrand.media.record.b.lrV);
        com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.kcx);
        localObject2 = new RecordParam();
        ((RecordParam)localObject2).duration = i;
        ((RecordParam)localObject2).sampleRate = k;
        ((RecordParam)localObject2).kXq = m;
        ((RecordParam)localObject2).kXr = n;
        ((RecordParam)localObject2).kcu = ((String)localObject1);
        ((RecordParam)localObject2).scene = 8;
        ((RecordParam)localObject2).kXs = d;
        ((RecordParam)localObject2).fJM = System.currentTimeMillis();
        ((RecordParam)localObject2).processName = this.processName;
        ((RecordParam)localObject2).appId = this.appId;
        ((RecordParam)localObject2).lth = localb;
        if (this.kcr == null) {
          this.kcr = new AudioRecordVoIPInterruptListener();
        }
        ((RecordParam)localObject2).lti = this.kcr;
        this.kcu = ((String)localObject1);
        com.tencent.mm.plugin.appbrand.media.record.c.boF();
        localObject1 = com.tencent.mm.plugin.appbrand.media.record.g.boN();
        ac.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
        if ((((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).lsi != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).lsi.appId)))
        {
          ac.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
          ((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).NX();
          if ((!TextUtils.isEmpty(((RecordParam)localObject2).kcu)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).kXr > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).kXq > 0)) {
            break label648;
          }
          i = 0;
          label537:
          if (i != 0) {
            break label653;
          }
          ac.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
          com.tencent.mm.plugin.appbrand.media.record.j.tY(15);
          i = j;
          label558:
          if (i == 0) {
            break label953;
          }
          ac.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
          this.action = -1;
        }
      }
      for (;;)
      {
        if (this.error) {
          ac.e("MicroMsg.Record.JsApiOperateRecorder", this.imz);
        }
        Am();
        AppMethodBeat.o(45937);
        return;
        if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).cXE)
        {
          ac.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
          i = j;
          break label558;
        }
        if (!((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).MZ()) {
          break;
        }
        ac.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
        i = j;
        break label558;
        label648:
        i = 1;
        break label537;
        label653:
        if (!h.OR(((RecordParam)localObject2).kcu))
        {
          ac.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).kcu });
          com.tencent.mm.plugin.appbrand.media.record.j.tY(16);
          i = j;
          break label558;
        }
        if (TextUtils.isEmpty(((RecordParam)localObject2).fJM)) {
          ((RecordParam)localObject2).fJM = System.currentTimeMillis();
        }
        com.tencent.mm.plugin.appbrand.media.record.j.boV();
        ac.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).kXq), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).kXr) });
        if (((RecordParam)localObject2).duration <= 0)
        {
          ((RecordParam)localObject2).duration = 60000;
          label804:
          if ((((RecordParam)localObject2).kXq <= 0) && (((RecordParam)localObject2).kXq > 2)) {
            ((RecordParam)localObject2).kXq = 2;
          }
          if (((RecordParam)localObject2).sampleRate <= 48000) {
            break label909;
          }
          ((RecordParam)localObject2).sampleRate = 48000;
          label846:
          if (((RecordParam)localObject2).kXr <= 320000) {
            break label931;
          }
          ((RecordParam)localObject2).kXr = 320000;
        }
        for (;;)
        {
          com.tencent.mm.sdk.g.b.c(new g.9((com.tencent.mm.plugin.appbrand.media.record.g)localObject1, (RecordParam)localObject2), "app_brand_start_record");
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
          if (((RecordParam)localObject2).kXr < 16000) {
            ((RecordParam)localObject2).kXr = 16000;
          }
        }
        label953:
        if (com.tencent.mm.plugin.appbrand.media.record.g.boN().cXE)
        {
          this.error = true;
          this.imz = "audio is recording, don't start record again";
        }
        else
        {
          this.error = true;
          this.imz = "start record fail";
          continue;
          if (((String)localObject1).equals("resume"))
          {
            localObject1 = com.tencent.mm.plugin.appbrand.media.record.g.boN();
            if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).cXE) {
              ac.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
            }
            for (;;)
            {
              if (i == 0) {
                break label1088;
              }
              this.action = -1;
              ac.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
              break;
              if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).lsi == null)
              {
                ac.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
              }
              else
              {
                com.tencent.mm.plugin.appbrand.media.record.j.boV();
                com.tencent.mm.sdk.g.b.c(new g.10((com.tencent.mm.plugin.appbrand.media.record.g)localObject1), "app_brand_resume_record");
                i = 1;
              }
            }
            label1088:
            if (com.tencent.mm.plugin.appbrand.media.record.g.boN().cXE)
            {
              this.error = true;
              this.imz = "audio is recording, don't resume record again";
            }
            else
            {
              this.error = true;
              this.imz = "resume record fail";
            }
          }
          else if (((String)localObject1).equals("pause"))
          {
            localObject1 = com.tencent.mm.plugin.appbrand.media.record.g.boN();
            ac.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
            if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).lsh == null)
            {
              ac.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label1233;
              }
              this.action = -1;
              ac.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
              break;
              if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).MZ())
              {
                ac.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                i = 1;
              }
              else
              {
                com.tencent.mm.sdk.g.b.c(new g.11((com.tencent.mm.plugin.appbrand.media.record.g)localObject1), "app_brand_pause_record");
                i = 1;
              }
            }
            label1233:
            if (com.tencent.mm.plugin.appbrand.media.record.g.boN().MZ())
            {
              this.error = true;
              this.imz = "audio is pause, don't pause record again";
            }
            else
            {
              this.error = true;
              this.imz = "pause record fail";
            }
          }
          else if (((String)localObject1).equals("stop"))
          {
            if (com.tencent.mm.plugin.appbrand.media.record.g.boN().NX())
            {
              this.action = -1;
              ac.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
            }
            else if (com.tencent.mm.plugin.appbrand.media.record.g.boN().Na())
            {
              this.error = true;
              this.imz = "audio is stop, don't stop record again";
            }
            else
            {
              this.error = true;
              this.imz = "stop record fail";
            }
          }
          else
          {
            ac.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
            this.error = true;
            this.imz = "operationType is invalid";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j
 * JD-Core Version:    0.7.0.1
 */