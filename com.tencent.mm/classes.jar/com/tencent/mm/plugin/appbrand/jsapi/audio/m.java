package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.a.a;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.rm;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.plugin.appbrand.media.record.g.10;
import com.tencent.mm.plugin.appbrand.media.record.g.11;
import com.tencent.mm.plugin.appbrand.media.record.g.9;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.appbrand.utils.ae.a;
import com.tencent.mm.plugin.appbrand.utils.ae.b;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.ah;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.c<y>
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private static Vector<String> etb;
  private k.c eok;
  private b rDN;
  private ad rDO;
  private com.tencent.mm.plugin.appbrand.page.capsulebar.m.a rDP;
  
  static
  {
    AppMethodBeat.i(45944);
    etb = new Vector();
    AppMethodBeat.o(45944);
  }
  
  public final void a(final y paramy, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45941);
    com.tencent.mm.plugin.appbrand.permission.s.a(paramy.getAppId(), new a.a()
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
          m.this.a(paramy, paramJSONObject, paramInt);
          AppMethodBeat.o(45934);
          return;
        }
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
        paramy.callback(paramInt, m.this.ZP("fail:system permission denied"));
        AppMethodBeat.o(45934);
      }
    });
    int i;
    if ((paramy.getContext() instanceof Activity))
    {
      localObject = (Activity)paramy.getContext();
      if (localObject != null) {
        break label103;
      }
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      paramy.callback(paramInt, ZP("fail"));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label142;
      }
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
      paramy.callback(paramInt, ZP("fail:system permission denied"));
      AppMethodBeat.o(45941);
      return;
      localObject = null;
      break;
      label103:
      boolean bool = i.a((Activity)localObject, paramy, "android.permission.RECORD_AUDIO", 116, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.s.afs(paramy.getAppId());
        i = bool;
      }
    }
    label142:
    Object localObject = paramy.getRuntime().getPageContainer();
    if ((((x)localObject).getCurrentPage() == null) || (((x)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramy.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(45941);
      return;
    }
    this.rDO = ((x)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      paramy.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(45941);
      return;
    }
    localObject = paramy.getAppId();
    Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.rDN == null) {
      this.rDN = new b(this, paramy, paramInt);
    }
    this.rDN.ror = paramInt;
    this.rDN.appId = ((String)localObject);
    this.rDN.rDU = paramJSONObject.toString();
    this.rDN.processName = MMApplicationContext.getProcessName();
    if (this.eok == null) {
      this.eok = new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(45931);
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.etl });
          paramAnonymousd = new JSONObject();
          try
          {
            paramAnonymousd.put("operationType", "pause");
            if (m.a(m.this) == null) {
              m.a(m.this, new m.b(m.this, paramy, paramInt));
            }
            m.a(m.this).rDU = paramAnonymousd.toString();
            m.a(m.this).appId = this.etl;
            m.a(m.this).action = -1;
            m.a(m.this).bQt();
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
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[] { this.etl });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("operationType", "stop");
            if (m.a(m.this) == null) {
              m.a(m.this, new m.b(m.this, paramy, paramInt));
            }
            m.a(m.this).rDU = localJSONObject.toString();
            m.a(m.this).appId = this.etl;
            m.a(m.this).action = -1;
            m.a(m.this).cqe();
            com.tencent.mm.plugin.appbrand.k.b(this.etl, this);
            m.cqi().remove(this.etl);
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
    this.rDN.eok = this.eok;
    this.rDN.bQt();
    AppMethodBeat.o(45941);
  }
  
  static final class b
    extends a
  {
    public int action;
    public String appId;
    private int duration;
    k.c eok;
    public boolean error;
    private String filePath;
    private int fileSize;
    private byte[] frameBuffer;
    private boolean hUB;
    public String ppp;
    public String processName;
    public y qqV;
    public String rDE;
    AudioRecordVoIPInterruptListener rDS;
    private m rDT;
    public String rDU;
    private String rDV;
    private String rDW;
    private int rDX;
    private final IListener<rm> rDY;
    public int ror;
    private String state;
    
    public b(m paramm, y paramy, int paramInt)
    {
      AppMethodBeat.i(45936);
      this.processName = "";
      this.error = false;
      this.ppp = "";
      this.filePath = "";
      this.fileSize = 0;
      this.duration = 0;
      this.state = "";
      this.rDV = "";
      this.rDY = new JsApiOperateRecorder.OperateRecordTask.1(this, f.hfK);
      this.rDT = paramm;
      this.qqV = paramy;
      this.ror = paramInt;
      paramm = new com.tencent.mm.plugin.appbrand.af.k();
      if (paramy.getFileSystem().a(paramm) == r.qML)
      {
        this.rDW = ah.v(new com.tencent.mm.vfs.u((String)paramm.value, "frameBuffer").jKT());
        AppMethodBeat.o(45936);
        return;
      }
      this.rDW = ah.v(new com.tencent.mm.vfs.u(paramy.getContext().getCacheDir(), "frameBuffer_" + paramy.getAppId()).jKT());
      AppMethodBeat.o(45936);
    }
    
    /* Error */
    private void cqj()
    {
      // Byte code:
      //   0: ldc 250
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 185	java/lang/System:nanoTime	()J
      //   8: lstore_1
      //   9: new 111	com/tencent/mm/vfs/u
      //   12: dup
      //   13: aload_0
      //   14: getfield 133	com/tencent/mm/plugin/appbrand/jsapi/audio/m$b:rDW	Ljava/lang/String;
      //   17: invokespecial 186	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   20: astore_3
      //   21: aload_3
      //   22: invokevirtual 202	com/tencent/mm/vfs/u:jKS	()Z
      //   25: ifeq +105 -> 130
      //   28: aload_3
      //   29: invokestatic 254	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
      //   32: astore 6
      //   34: aload 6
      //   36: astore 5
      //   38: aload_3
      //   39: astore 4
      //   41: aload_0
      //   42: aload_0
      //   43: getfield 171	com/tencent/mm/plugin/appbrand/jsapi/audio/m$b:rDX	I
      //   46: newarray byte
      //   48: putfield 247	com/tencent/mm/plugin/appbrand/jsapi/audio/m$b:frameBuffer	[B
      //   51: aload 6
      //   53: astore 5
      //   55: aload_3
      //   56: astore 4
      //   58: aload 6
      //   60: aload_0
      //   61: getfield 247	com/tencent/mm/plugin/appbrand/jsapi/audio/m$b:frameBuffer	[B
      //   64: invokevirtual 260	java/io/InputStream:read	([B)I
      //   67: pop
      //   68: aload 6
      //   70: astore 5
      //   72: aload_3
      //   73: astore 4
      //   75: aload 6
      //   77: invokevirtual 261	java/io/InputStream:close	()V
      //   80: aload 6
      //   82: ifnull +8 -> 90
      //   85: aload 6
      //   87: invokevirtual 261	java/io/InputStream:close	()V
      //   90: aload_3
      //   91: invokevirtual 202	com/tencent/mm/vfs/u:jKS	()Z
      //   94: ifeq +94 -> 188
      //   97: aload_3
      //   98: invokevirtual 264	com/tencent/mm/vfs/u:diJ	()Z
      //   101: pop
      //   102: ldc 188
      //   104: ldc 232
      //   106: iconst_1
      //   107: anewarray 192	java/lang/Object
      //   110: dup
      //   111: iconst_0
      //   112: invokestatic 185	java/lang/System:nanoTime	()J
      //   115: lload_1
      //   116: lsub
      //   117: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   120: aastore
      //   121: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: ldc 250
      //   126: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: ldc 188
      //   132: ldc_w 266
      //   135: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   138: aload_3
      //   139: invokevirtual 202	com/tencent/mm/vfs/u:jKS	()Z
      //   142: ifeq +14 -> 156
      //   145: aload_3
      //   146: invokevirtual 264	com/tencent/mm/vfs/u:diJ	()Z
      //   149: pop
      //   150: ldc 250
      //   152: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: return
      //   156: ldc 188
      //   158: ldc_w 271
      //   161: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: ldc 250
      //   166: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: return
      //   170: astore 4
      //   172: ldc 188
      //   174: aload 4
      //   176: ldc 55
      //   178: iconst_0
      //   179: anewarray 192	java/lang/Object
      //   182: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   185: goto -95 -> 90
      //   188: ldc 188
      //   190: ldc_w 271
      //   193: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   213: ldc 188
      //   215: aload 7
      //   217: ldc 55
      //   219: iconst_0
      //   220: anewarray 192	java/lang/Object
      //   223: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   226: aload 6
      //   228: ifnull +8 -> 236
      //   231: aload 6
      //   233: invokevirtual 261	java/io/InputStream:close	()V
      //   236: aload_3
      //   237: ifnull +36 -> 273
      //   240: aload_3
      //   241: invokevirtual 202	com/tencent/mm/vfs/u:jKS	()Z
      //   244: ifeq +29 -> 273
      //   247: aload_3
      //   248: invokevirtual 264	com/tencent/mm/vfs/u:diJ	()Z
      //   251: pop
      //   252: goto -150 -> 102
      //   255: astore 4
      //   257: ldc 188
      //   259: aload 4
      //   261: ldc 55
      //   263: iconst_0
      //   264: anewarray 192	java/lang/Object
      //   267: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   270: goto -34 -> 236
      //   273: ldc 188
      //   275: ldc_w 271
      //   278: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   298: ldc 188
      //   300: aload 7
      //   302: ldc 55
      //   304: iconst_0
      //   305: anewarray 192	java/lang/Object
      //   308: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   311: aload 6
      //   313: ifnull +8 -> 321
      //   316: aload 6
      //   318: invokevirtual 261	java/io/InputStream:close	()V
      //   321: aload_3
      //   322: ifnull +36 -> 358
      //   325: aload_3
      //   326: invokevirtual 202	com/tencent/mm/vfs/u:jKS	()Z
      //   329: ifeq +29 -> 358
      //   332: aload_3
      //   333: invokevirtual 264	com/tencent/mm/vfs/u:diJ	()Z
      //   336: pop
      //   337: goto -235 -> 102
      //   340: astore 4
      //   342: ldc 188
      //   344: aload 4
      //   346: ldc 55
      //   348: iconst_0
      //   349: anewarray 192	java/lang/Object
      //   352: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   355: goto -34 -> 321
      //   358: ldc 188
      //   360: ldc_w 271
      //   363: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   366: goto -264 -> 102
      //   369: astore 6
      //   371: aconst_null
      //   372: astore 5
      //   374: aconst_null
      //   375: astore_3
      //   376: aload 5
      //   378: ifnull +8 -> 386
      //   381: aload 5
      //   383: invokevirtual 261	java/io/InputStream:close	()V
      //   386: aload_3
      //   387: ifnull +41 -> 428
      //   390: aload_3
      //   391: invokevirtual 202	com/tencent/mm/vfs/u:jKS	()Z
      //   394: ifeq +34 -> 428
      //   397: aload_3
      //   398: invokevirtual 264	com/tencent/mm/vfs/u:diJ	()Z
      //   401: pop
      //   402: ldc 250
      //   404: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   407: aload 6
      //   409: athrow
      //   410: astore 4
      //   412: ldc 188
      //   414: aload 4
      //   416: ldc 55
      //   418: iconst_0
      //   419: anewarray 192	java/lang/Object
      //   422: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   425: goto -39 -> 386
      //   428: ldc 188
      //   430: ldc_w 271
      //   433: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    
    public final void aFi()
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(45937);
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(this.rDU);
        String str = ((JSONObject)localObject2).optString("operationType");
        if (TextUtils.isEmpty(str))
        {
          Log.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
          this.error = true;
          this.action = -1;
          this.ppp = "operationType is null";
          callback();
          AppMethodBeat.o(45937);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.rDU });
        this.error = true;
        this.action = -1;
        this.ppp = "parser data fail, data is invalid";
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + localJSONException.getMessage());
        callback();
        AppMethodBeat.o(45937);
        return;
      }
      Log.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[] { localJSONException });
      this.error = false;
      this.action = -1;
      com.tencent.mm.plugin.appbrand.app.k.ceQ();
      Object localObject1;
      if (localJSONException.equals("start"))
      {
        i = ((JSONObject)localObject2).optInt("duration", 60000);
        int k = ((JSONObject)localObject2).optInt("sampleRate", 44100);
        int m = ((JSONObject)localObject2).optInt("numberOfChannels", 2);
        int n = ((JSONObject)localObject2).optInt("encodeBitRate", 128000);
        localObject1 = ((JSONObject)localObject2).optString("format");
        double d = ((JSONObject)localObject2).optDouble("frameSize", 0.0D);
        b localb = b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), b.til);
        com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.rDY);
        localObject2 = new RecordParam();
        ((RecordParam)localObject2).duration = i;
        ((RecordParam)localObject2).sampleRate = k;
        ((RecordParam)localObject2).tjy = m;
        ((RecordParam)localObject2).tjz = n;
        ((RecordParam)localObject2).rDV = ((String)localObject1);
        ((RecordParam)localObject2).scene = 8;
        ((RecordParam)localObject2).tjA = d;
        ((RecordParam)localObject2).lYI = System.currentTimeMillis();
        ((RecordParam)localObject2).processName = this.processName;
        ((RecordParam)localObject2).appId = this.appId;
        ((RecordParam)localObject2).tjB = localb;
        if (this.rDS == null) {
          this.rDS = new AudioRecordVoIPInterruptListener();
        }
        ((RecordParam)localObject2).tjC = this.rDS;
        this.rDV = ((String)localObject1);
        com.tencent.mm.plugin.appbrand.media.record.c.cBC();
        localObject1 = g.cBK();
        Log.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
        if ((((g)localObject1).tiz != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((g)localObject1).tiz.appId)))
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
          ((g)localObject1).aGH();
          if ((!TextUtils.isEmpty(((RecordParam)localObject2).rDV)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).tjz > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).tjy > 0)) {
            break label651;
          }
          i = 0;
          label540:
          if (i != 0) {
            break label656;
          }
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
          j.Co(15);
          i = j;
          label561:
          if (i == 0) {
            break label956;
          }
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
          this.action = -1;
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Record.JsApiOperateRecorder", this.ppp);
        }
        callback();
        AppMethodBeat.o(45937);
        return;
        if (((g)localObject1).Kf)
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
          i = j;
          break label561;
        }
        if (!((g)localObject1).aFF()) {
          break;
        }
        Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
        i = j;
        break label561;
        label651:
        i = 1;
        break label540;
        label656:
        if (!h.adH(((RecordParam)localObject2).rDV))
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).rDV });
          j.Co(16);
          i = j;
          break label561;
        }
        if (TextUtils.isEmpty(((RecordParam)localObject2).lYI)) {
          ((RecordParam)localObject2).lYI = System.currentTimeMillis();
        }
        j.cBS();
        Log.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).tjy), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).tjz) });
        if (((RecordParam)localObject2).duration <= 0)
        {
          ((RecordParam)localObject2).duration = 60000;
          label807:
          if ((((RecordParam)localObject2).tjy <= 0) && (((RecordParam)localObject2).tjy > 2)) {
            ((RecordParam)localObject2).tjy = 2;
          }
          if (((RecordParam)localObject2).sampleRate <= 48000) {
            break label912;
          }
          ((RecordParam)localObject2).sampleRate = 48000;
          label849:
          if (((RecordParam)localObject2).tjz <= 320000) {
            break label934;
          }
          ((RecordParam)localObject2).tjz = 320000;
        }
        for (;;)
        {
          ThreadPool.post(new g.9((g)localObject1, (RecordParam)localObject2), "app_brand_start_record");
          i = 1;
          break;
          if (((RecordParam)localObject2).duration < 600000) {
            break label807;
          }
          ((RecordParam)localObject2).duration = 600000;
          break label807;
          label912:
          if (((RecordParam)localObject2).sampleRate >= 8000) {
            break label849;
          }
          ((RecordParam)localObject2).sampleRate = 8000;
          break label849;
          label934:
          if (((RecordParam)localObject2).tjz < 16000) {
            ((RecordParam)localObject2).tjz = 16000;
          }
        }
        label956:
        if (g.cBK().Kf)
        {
          this.error = true;
          this.ppp = "audio is recording, don't start record again";
        }
        else
        {
          this.error = true;
          this.ppp = "start record fail";
          continue;
          if (((String)localObject1).equals("resume"))
          {
            localObject1 = g.cBK();
            if (((g)localObject1).Kf) {
              Log.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
            }
            for (;;)
            {
              if (i == 0) {
                break label1091;
              }
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
              break;
              if (((g)localObject1).tiz == null)
              {
                Log.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
              }
              else
              {
                j.cBS();
                ThreadPool.post(new g.10((g)localObject1), "app_brand_resume_record");
                i = 1;
              }
            }
            label1091:
            if (g.cBK().Kf)
            {
              this.error = true;
              this.ppp = "audio is recording, don't resume record again";
            }
            else
            {
              this.error = true;
              this.ppp = "resume record fail";
            }
          }
          else if (((String)localObject1).equals("pause"))
          {
            localObject1 = g.cBK();
            Log.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
            if (((g)localObject1).tix == null)
            {
              Log.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label1236;
              }
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
              break;
              if (((g)localObject1).aFF())
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
            label1236:
            if (g.cBK().aFF())
            {
              this.error = true;
              this.ppp = "audio is pause, don't pause record again";
            }
            else
            {
              this.error = true;
              this.ppp = "pause record fail";
            }
          }
          else if (((String)localObject1).equals("stop"))
          {
            if (g.cBK().aGH())
            {
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
            }
            else if (g.cBK().aFG())
            {
              this.error = true;
              this.ppp = "audio is stop, don't stop record again";
            }
            else
            {
              this.error = true;
              this.ppp = "stop record fail";
            }
          }
          else
          {
            Log.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
            this.error = true;
            this.ppp = "operationType is invalid";
          }
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(45938);
      super.callback();
      if (this.qqV == null)
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
          this.qqV.callback(this.ror, this.rDT.ZP("ok"));
          AppMethodBeat.o(45938);
          return;
        }
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[] { this.ppp });
        this.qqV.callback(this.ror, this.rDT.ZP("fail:" + this.ppp));
        AppMethodBeat.o(45938);
        return;
      }
      m.a locala = new m.a();
      HashMap localHashMap;
      Object localObject;
      switch (this.action)
      {
      default: 
        if (this.action == 2)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[] { this.filePath, this.rDV });
          localObject = new com.tencent.mm.plugin.appbrand.af.k();
          if (this.qqV.getFileSystem().a(new com.tencent.mm.vfs.u(this.filePath), h.adG(this.rDV), true, (com.tencent.mm.plugin.appbrand.af.k)localObject) == r.qML)
          {
            localHashMap.put("tempFilePath", ((com.tencent.mm.plugin.appbrand.af.k)localObject).value);
            label308:
            localHashMap.put("duration", Integer.valueOf(this.duration));
            localHashMap.put("fileSize", Integer.valueOf(this.fileSize));
            this.rDE = new JSONObject(localHashMap).toString();
          }
        }
        else if (this.action == 5)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          localHashMap.put("isLastFrame", Boolean.valueOf(this.hUB));
          if (this.rDX > 819200) {
            cqj();
          }
          if (this.frameBuffer == null) {
            break label660;
          }
          localHashMap.put("frameBuffer", ae.bc(this.frameBuffer));
          label441:
          localObject = ae.a(this.qqV.getJsRuntime(), localHashMap, (ae.a)this.qqV.aN(ae.a.class));
          if (localObject != ae.b.urr) {
            break label671;
          }
          this.rDE = new JSONObject(localHashMap).toString();
        }
        break;
      }
      label660:
      label671:
      while (localObject != ae.b.urs)
      {
        Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[] { Integer.valueOf(this.action), this.rDE });
        locala.h(this.qqV).ZQ(this.rDE).cpV();
        AppMethodBeat.o(45938);
        return;
        m.a(this.rDT, true);
        if (m.cqi().contains(this.appId)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.k.a(this.appId, this.eok);
        m.cqi().add(this.appId);
        break;
        m.a(this.rDT, false);
        if ((this.action != 2) && (this.action != 4)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.k.b(this.appId, this.eok);
        m.cqi().remove(this.appId);
        break;
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        break label308;
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
        break label441;
      }
      ae.m(this.qqV, "onRecorderStateChange");
      AppMethodBeat.o(45938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.m
 * JD-Core Version:    0.7.0.1
 */