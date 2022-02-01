package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;
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
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  private static Vector<String> jBh;
  private g.c cex;
  private b jBQ;
  private aa jBR;
  private c.a jBS;
  
  static
  {
    AppMethodBeat.i(45944);
    jBh = new Vector();
    AppMethodBeat.o(45944);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45941);
    o.a(paramq.getAppId(), new j.3(this, paramq, paramJSONObject, paramInt));
    int i;
    if ((paramq.getContext() instanceof Activity))
    {
      localObject = (Activity)paramq.getContext();
      if (localObject != null) {
        break label105;
      }
      ad.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      paramq.h(paramInt, e("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label143;
      }
      ad.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
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
        o.Mi(paramq.getAppId());
        i = bool;
      }
    }
    label143:
    Object localObject = paramq.getRuntime().aLK();
    if ((((t)localObject).getCurrentPage() == null) || (((t)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramq.h(paramInt, e("fail", null));
      AppMethodBeat.o(45941);
      return;
    }
    this.jBR = ((t)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      paramq.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(45941);
      return;
    }
    localObject = paramq.getAppId();
    ad.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.jBQ == null) {
      this.jBQ = new b(this, paramq, paramInt);
    }
    this.jBQ.joH = paramInt;
    this.jBQ.appId = ((String)localObject);
    this.jBQ.jBX = paramJSONObject.toString();
    this.jBQ.processName = aj.getProcessName();
    if (this.cex == null) {
      this.cex = new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(45931);
          ad.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.val$appId });
          paramAnonymousd = new JSONObject();
          try
          {
            paramAnonymousd.put("operationType", "pause");
            if (j.a(j.this) == null) {
              j.a(j.this, new j.b(j.this, paramq, paramInt));
            }
            j.a(j.this).jBX = paramAnonymousd.toString();
            j.a(j.this).appId = this.val$appId;
            j.a(j.this).action = -1;
            j.a(j.this).aEC();
            AppMethodBeat.o(45931);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(45932);
          ad.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[] { this.val$appId });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("operationType", "stop");
            if (j.a(j.this) == null) {
              j.a(j.this, new j.b(j.this, paramq, paramInt));
            }
            j.a(j.this).jBX = localJSONObject.toString();
            j.a(j.this).appId = this.val$appId;
            j.a(j.this).action = -1;
            j.a(j.this).aYb();
            com.tencent.mm.plugin.appbrand.g.b(this.val$appId, this);
            j.aYe().remove(this.val$appId);
            AppMethodBeat.o(45932);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
      };
    }
    this.jBQ.cex = this.cex;
    this.jBQ.aEC();
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
    g.c cex;
    private boolean dsP;
    private int duration;
    public boolean error;
    private String filePath;
    private int fileSize;
    private byte[] frameBuffer;
    public String hMd;
    public com.tencent.mm.plugin.appbrand.q iIL;
    public String jBH;
    AudioRecordVoIPInterruptListener jBV;
    private j jBW;
    public String jBX;
    private String jBY;
    private String jBZ;
    private int jCa;
    private final com.tencent.mm.sdk.b.c<ns> jCb;
    public int joH;
    public String processName;
    private String state;
    
    public b(j paramj, com.tencent.mm.plugin.appbrand.q paramq, int paramInt)
    {
      AppMethodBeat.i(45936);
      this.processName = "";
      this.error = false;
      this.hMd = "";
      this.filePath = "";
      this.fileSize = 0;
      this.duration = 0;
      this.state = "";
      this.jBY = "";
      this.jCb = new com.tencent.mm.sdk.b.c() {};
      this.jBW = paramj;
      this.iIL = paramq;
      this.joH = paramInt;
      paramj = new i();
      if (paramq.Ee().a(paramj) == l.iSq)
      {
        this.jBZ = com.tencent.mm.vfs.q.B(new e((String)paramj.value, "frameBuffer").fhU());
        AppMethodBeat.o(45936);
        return;
      }
      this.jBZ = com.tencent.mm.vfs.q.B(new e(paramq.getContext().getCacheDir(), "frameBuffer_" + paramq.getAppId()).fhU());
      AppMethodBeat.o(45936);
    }
    
    /* Error */
    private void aYf()
    {
      // Byte code:
      //   0: ldc 243
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 179	java/lang/System:nanoTime	()J
      //   8: lstore_1
      //   9: new 105	com/tencent/mm/vfs/e
      //   12: dup
      //   13: aload_0
      //   14: getfield 127	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:jBZ	Ljava/lang/String;
      //   17: invokespecial 180	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   20: astore_3
      //   21: aload_3
      //   22: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
      //   25: ifeq +105 -> 130
      //   28: aload_3
      //   29: invokestatic 247	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
      //   32: astore 6
      //   34: aload 6
      //   36: astore 5
      //   38: aload_3
      //   39: astore 4
      //   41: aload_0
      //   42: aload_0
      //   43: getfield 165	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:jCa	I
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
      //   121: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: ldc 243
      //   126: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: ldc 182
      //   132: ldc_w 259
      //   135: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   161: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: ldc 243
      //   166: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: return
      //   170: astore 4
      //   172: ldc 182
      //   174: aload 4
      //   176: ldc 55
      //   178: iconst_0
      //   179: anewarray 186	java/lang/Object
      //   182: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   185: goto -95 -> 90
      //   188: ldc 182
      //   190: ldc_w 264
      //   193: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   223: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   267: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   270: goto -34 -> 236
      //   273: ldc 182
      //   275: ldc_w 264
      //   278: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   308: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   352: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   355: goto -34 -> 321
      //   358: ldc 182
      //   360: ldc_w 264
      //   363: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   422: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   425: goto -39 -> 386
      //   428: ldc 182
      //   430: ldc_w 264
      //   433: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    
    public final void AI()
    {
      AppMethodBeat.i(45938);
      super.AI();
      if (this.iIL == null)
      {
        ad.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
        AppMethodBeat.o(45938);
        return;
      }
      if (this.action == -1)
      {
        if (!this.error)
        {
          ad.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
          this.iIL.h(this.joH, this.jBW.e("ok", null));
          AppMethodBeat.o(45938);
          return;
        }
        ad.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[] { this.hMd });
        this.iIL.h(this.joH, this.jBW.e("fail:" + this.hMd, null));
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
          ad.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[] { this.filePath, this.jBY });
          localObject = new i();
          if (this.iIL.Ee().a(new e(this.filePath), h.KJ(this.jBY), true, (i)localObject) == l.iSq)
          {
            localHashMap.put("tempFilePath", ((i)localObject).value);
            label312:
            localHashMap.put("duration", Integer.valueOf(this.duration));
            localHashMap.put("fileSize", Integer.valueOf(this.fileSize));
            this.jBH = new JSONObject(localHashMap).toString();
          }
        }
        else if (this.action == 5)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          localHashMap.put("isLastFrame", Boolean.valueOf(this.dsP));
          if (this.jCa > 819200) {
            aYf();
          }
          if (this.frameBuffer == null) {
            break label664;
          }
          localHashMap.put("frameBuffer", v.az(this.frameBuffer));
          label445:
          localObject = v.a(this.iIL.aOf(), localHashMap, (v.a)this.iIL.ar(v.a.class));
          if (localObject != v.b.lMJ) {
            break label675;
          }
          this.jBH = new JSONObject(localHashMap).toString();
        }
        break;
      }
      label664:
      label675:
      while (localObject != v.b.lMK)
      {
        ad.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[] { Integer.valueOf(this.action), this.jBH });
        locala.g(this.iIL).HJ(this.jBH).aXQ();
        AppMethodBeat.o(45938);
        return;
        j.a(this.jBW, true);
        if (j.aYe().contains(this.appId)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.g.a(this.appId, this.cex);
        j.aYe().add(this.appId);
        break;
        j.a(this.jBW, false);
        if ((this.action != 2) && (this.action != 4)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.g.b(this.appId, this.cex);
        j.aYe().remove(this.appId);
        break;
        ad.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        break label312;
        ad.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
        break label445;
      }
      v.k(this.iIL, "onRecorderStateChange");
      AppMethodBeat.o(45938);
    }
    
    public final void MQ()
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(45937);
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(this.jBX);
        String str = ((JSONObject)localObject2).optString("operationType");
        if (TextUtils.isEmpty(str))
        {
          ad.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
          this.error = true;
          this.action = -1;
          this.hMd = "operationType is null";
          AI();
          AppMethodBeat.o(45937);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.jBX });
        this.error = true;
        this.action = -1;
        this.hMd = "parser data fail, data is invalid";
        ad.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + localJSONException.getMessage());
        AI();
        AppMethodBeat.o(45937);
        return;
      }
      ad.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[] { localJSONException });
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
        com.tencent.mm.plugin.appbrand.media.record.b localb = com.tencent.mm.plugin.appbrand.media.record.b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), com.tencent.mm.plugin.appbrand.media.record.b.kQw);
        com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.jCb);
        localObject2 = new RecordParam();
        ((RecordParam)localObject2).duration = i;
        ((RecordParam)localObject2).sampleRate = k;
        ((RecordParam)localObject2).kwc = m;
        ((RecordParam)localObject2).kwd = n;
        ((RecordParam)localObject2).jBY = ((String)localObject1);
        ((RecordParam)localObject2).scene = 8;
        ((RecordParam)localObject2).kwe = d;
        ((RecordParam)localObject2).fGf = System.currentTimeMillis();
        ((RecordParam)localObject2).processName = this.processName;
        ((RecordParam)localObject2).appId = this.appId;
        ((RecordParam)localObject2).kRH = localb;
        if (this.jBV == null) {
          this.jBV = new AudioRecordVoIPInterruptListener();
        }
        ((RecordParam)localObject2).kRI = this.jBV;
        this.jBY = ((String)localObject1);
        com.tencent.mm.plugin.appbrand.media.record.c.bhL();
        localObject1 = com.tencent.mm.plugin.appbrand.media.record.g.bhT();
        ad.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
        if ((((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).kQI != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).kQI.appId)))
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
          ((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).Ob();
          if ((!TextUtils.isEmpty(((RecordParam)localObject2).jBY)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).kwd > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).kwc > 0)) {
            break label648;
          }
          i = 0;
          label537:
          if (i != 0) {
            break label653;
          }
          ad.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
          com.tencent.mm.plugin.appbrand.media.record.j.th(15);
          i = j;
          label558:
          if (i == 0) {
            break label953;
          }
          ad.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
          this.action = -1;
        }
      }
      for (;;)
      {
        if (this.error) {
          ad.e("MicroMsg.Record.JsApiOperateRecorder", this.hMd);
        }
        AI();
        AppMethodBeat.o(45937);
        return;
        if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).dai)
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
          i = j;
          break label558;
        }
        if (!((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).Nb()) {
          break;
        }
        ad.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
        i = j;
        break label558;
        label648:
        i = 1;
        break label537;
        label653:
        if (!h.KK(((RecordParam)localObject2).jBY))
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).jBY });
          com.tencent.mm.plugin.appbrand.media.record.j.th(16);
          i = j;
          break label558;
        }
        if (TextUtils.isEmpty(((RecordParam)localObject2).fGf)) {
          ((RecordParam)localObject2).fGf = System.currentTimeMillis();
        }
        com.tencent.mm.plugin.appbrand.media.record.j.bib();
        ad.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).kwc), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).kwd) });
        if (((RecordParam)localObject2).duration <= 0)
        {
          ((RecordParam)localObject2).duration = 60000;
          label804:
          if ((((RecordParam)localObject2).kwc <= 0) && (((RecordParam)localObject2).kwc > 2)) {
            ((RecordParam)localObject2).kwc = 2;
          }
          if (((RecordParam)localObject2).sampleRate <= 48000) {
            break label909;
          }
          ((RecordParam)localObject2).sampleRate = 48000;
          label846:
          if (((RecordParam)localObject2).kwd <= 320000) {
            break label931;
          }
          ((RecordParam)localObject2).kwd = 320000;
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
          if (((RecordParam)localObject2).kwd < 16000) {
            ((RecordParam)localObject2).kwd = 16000;
          }
        }
        label953:
        if (com.tencent.mm.plugin.appbrand.media.record.g.bhT().dai)
        {
          this.error = true;
          this.hMd = "audio is recording, don't start record again";
        }
        else
        {
          this.error = true;
          this.hMd = "start record fail";
          continue;
          if (((String)localObject1).equals("resume"))
          {
            localObject1 = com.tencent.mm.plugin.appbrand.media.record.g.bhT();
            if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).dai) {
              ad.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
            }
            for (;;)
            {
              if (i == 0) {
                break label1088;
              }
              this.action = -1;
              ad.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
              break;
              if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).kQI == null)
              {
                ad.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
              }
              else
              {
                com.tencent.mm.plugin.appbrand.media.record.j.bib();
                com.tencent.mm.sdk.g.b.c(new g.10((com.tencent.mm.plugin.appbrand.media.record.g)localObject1), "app_brand_resume_record");
                i = 1;
              }
            }
            label1088:
            if (com.tencent.mm.plugin.appbrand.media.record.g.bhT().dai)
            {
              this.error = true;
              this.hMd = "audio is recording, don't resume record again";
            }
            else
            {
              this.error = true;
              this.hMd = "resume record fail";
            }
          }
          else if (((String)localObject1).equals("pause"))
          {
            localObject1 = com.tencent.mm.plugin.appbrand.media.record.g.bhT();
            ad.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
            if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).kQH == null)
            {
              ad.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label1233;
              }
              this.action = -1;
              ad.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
              break;
              if (((com.tencent.mm.plugin.appbrand.media.record.g)localObject1).Nb())
              {
                ad.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                i = 1;
              }
              else
              {
                com.tencent.mm.sdk.g.b.c(new g.11((com.tencent.mm.plugin.appbrand.media.record.g)localObject1), "app_brand_pause_record");
                i = 1;
              }
            }
            label1233:
            if (com.tencent.mm.plugin.appbrand.media.record.g.bhT().Nb())
            {
              this.error = true;
              this.hMd = "audio is pause, don't pause record again";
            }
            else
            {
              this.error = true;
              this.hMd = "pause record fail";
            }
          }
          else if (((String)localObject1).equals("stop"))
          {
            if (com.tencent.mm.plugin.appbrand.media.record.g.bhT().Ob())
            {
              this.action = -1;
              ad.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
            }
            else if (com.tencent.mm.plugin.appbrand.media.record.g.bhT().Nc())
            {
              this.error = true;
              this.hMd = "audio is stop, don't stop record again";
            }
            else
            {
              this.error = true;
              this.hMd = "stop record fail";
            }
          }
          else
          {
            ad.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
            this.error = true;
            this.hMd = "operationType is invalid";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j
 * JD-Core Version:    0.7.0.1
 */