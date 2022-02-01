package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pz;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.plugin.appbrand.media.record.g.10;
import com.tencent.mm.plugin.appbrand.media.record.g.11;
import com.tencent.mm.plugin.appbrand.media.record.g.9;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c<v>
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private static Vector<String> cAG;
  private k.c cwl;
  private b ozU;
  private ad ozV;
  private i.a ozW;
  
  static
  {
    AppMethodBeat.i(45944);
    cAG = new Vector();
    AppMethodBeat.o(45944);
  }
  
  public final void a(final v paramv, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45941);
    com.tencent.mm.plugin.appbrand.permission.r.a(paramv.getAppId(), new a.a()
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
          k.this.a(paramv, paramJSONObject, paramInt);
          AppMethodBeat.o(45934);
          return;
        }
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
        paramv.j(paramInt, k.this.h("fail:system permission denied", null));
        AppMethodBeat.o(45934);
      }
    });
    int i;
    if ((paramv.getContext() instanceof Activity))
    {
      localObject = (Activity)paramv.getContext();
      if (localObject != null) {
        break label105;
      }
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      paramv.j(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label143;
      }
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
      paramv.j(paramInt, h("fail:system permission denied", null));
      AppMethodBeat.o(45941);
      return;
      localObject = null;
      break;
      label105:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.amk(paramv.getAppId());
        i = bool;
      }
    }
    label143:
    Object localObject = paramv.getRuntime().bBX();
    if ((((x)localObject).getCurrentPage() == null) || (((x)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramv.j(paramInt, h("fail", null));
      AppMethodBeat.o(45941);
      return;
    }
    this.ozV = ((x)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      paramv.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(45941);
      return;
    }
    localObject = paramv.getAppId();
    Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.ozU == null) {
      this.ozU = new b(this, paramv, paramInt);
    }
    this.ozU.okO = paramInt;
    this.ozU.appId = ((String)localObject);
    this.ozU.oAb = paramJSONObject.toString();
    this.ozU.processName = MMApplicationContext.getProcessName();
    if (this.cwl == null) {
      this.cwl = new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(45931);
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.val$appId });
          paramAnonymousd = new JSONObject();
          try
          {
            paramAnonymousd.put("operationType", "pause");
            if (k.a(k.this) == null) {
              k.a(k.this, new k.b(k.this, paramv, paramInt));
            }
            k.a(k.this).oAb = paramAnonymousd.toString();
            k.a(k.this).appId = this.val$appId;
            k.a(k.this).action = -1;
            k.a(k.this).bsM();
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
              k.a(k.this, new k.b(k.this, paramv, paramInt));
            }
            k.a(k.this).oAb = localJSONObject.toString();
            k.a(k.this).appId = this.val$appId;
            k.a(k.this).action = -1;
            k.a(k.this).bPY();
            com.tencent.mm.plugin.appbrand.k.b(this.val$appId, this);
            k.bQb().remove(this.val$appId);
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
    this.ozU.cwl = this.cwl;
    this.ozU.bsM();
    AppMethodBeat.o(45941);
  }
  
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.r
  {
    private static final int CTRL_INDEX = 296;
    private static final String NAME = "onRecorderStateChange";
  }
  
  static final class b
    extends a
  {
    public int action;
    public String appId;
    k.c cwl;
    private int duration;
    public boolean error;
    private boolean fOI;
    private String filePath;
    private int fileSize;
    private byte[] frameBuffer;
    public String mvQ;
    public v nAz;
    private k oAa;
    public String oAb;
    private String oAc;
    private String oAd;
    private int oAe;
    private final IListener<pz> oAf;
    public int okO;
    public String ozL;
    AudioRecordVoIPInterruptListener ozZ;
    public String processName;
    private String state;
    
    public b(k paramk, v paramv, int paramInt)
    {
      AppMethodBeat.i(45936);
      this.processName = "";
      this.error = false;
      this.mvQ = "";
      this.filePath = "";
      this.fileSize = 0;
      this.duration = 0;
      this.state = "";
      this.oAc = "";
      this.oAf = new IListener() {};
      this.oAa = paramk;
      this.nAz = paramv;
      this.okO = paramInt;
      paramk = new i();
      if (paramv.getFileSystem().a(paramk) == m.nMR)
      {
        this.oAd = new q((String)paramk.value, "frameBuffer").bOF();
        AppMethodBeat.o(45936);
        return;
      }
      this.oAd = new q(paramv.getContext().getCacheDir(), "frameBuffer_" + paramv.getAppId()).bOF();
      AppMethodBeat.o(45936);
    }
    
    /* Error */
    private void bQc()
    {
      // Byte code:
      //   0: ldc 236
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 172	java/lang/System:nanoTime	()J
      //   8: lstore_1
      //   9: new 105	com/tencent/mm/vfs/q
      //   12: dup
      //   13: aload_0
      //   14: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:oAd	Ljava/lang/String;
      //   17: invokespecial 173	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   20: astore_3
      //   21: aload_3
      //   22: invokevirtual 189	com/tencent/mm/vfs/q:ifE	()Z
      //   25: ifeq +105 -> 130
      //   28: aload_3
      //   29: invokestatic 240	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
      //   32: astore 6
      //   34: aload 6
      //   36: astore 5
      //   38: aload_3
      //   39: astore 4
      //   41: aload_0
      //   42: aload_0
      //   43: getfield 158	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:oAe	I
      //   46: newarray byte
      //   48: putfield 234	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:frameBuffer	[B
      //   51: aload 6
      //   53: astore 5
      //   55: aload_3
      //   56: astore 4
      //   58: aload 6
      //   60: aload_0
      //   61: getfield 234	com/tencent/mm/plugin/appbrand/jsapi/audio/k$b:frameBuffer	[B
      //   64: invokevirtual 246	java/io/InputStream:read	([B)I
      //   67: pop
      //   68: aload 6
      //   70: astore 5
      //   72: aload_3
      //   73: astore 4
      //   75: aload 6
      //   77: invokevirtual 247	java/io/InputStream:close	()V
      //   80: aload 6
      //   82: ifnull +8 -> 90
      //   85: aload 6
      //   87: invokevirtual 247	java/io/InputStream:close	()V
      //   90: aload_3
      //   91: invokevirtual 189	com/tencent/mm/vfs/q:ifE	()Z
      //   94: ifeq +93 -> 187
      //   97: aload_3
      //   98: invokevirtual 250	com/tencent/mm/vfs/q:cFq	()Z
      //   101: pop
      //   102: ldc 175
      //   104: ldc 219
      //   106: iconst_1
      //   107: anewarray 179	java/lang/Object
      //   110: dup
      //   111: iconst_0
      //   112: invokestatic 172	java/lang/System:nanoTime	()J
      //   115: lload_1
      //   116: lsub
      //   117: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   120: aastore
      //   121: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: ldc 236
      //   126: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: ldc 175
      //   132: ldc 252
      //   134: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   137: aload_3
      //   138: invokevirtual 189	com/tencent/mm/vfs/q:ifE	()Z
      //   141: ifeq +14 -> 155
      //   144: aload_3
      //   145: invokevirtual 250	com/tencent/mm/vfs/q:cFq	()Z
      //   148: pop
      //   149: ldc 236
      //   151: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: return
      //   155: ldc 175
      //   157: ldc_w 257
      //   160: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   163: ldc 236
      //   165: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: return
      //   169: astore 4
      //   171: ldc 175
      //   173: aload 4
      //   175: ldc 55
      //   177: iconst_0
      //   178: anewarray 179	java/lang/Object
      //   181: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   184: goto -94 -> 90
      //   187: ldc 175
      //   189: ldc_w 257
      //   192: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   195: goto -93 -> 102
      //   198: astore 7
      //   200: aconst_null
      //   201: astore 6
      //   203: aconst_null
      //   204: astore_3
      //   205: aload 6
      //   207: astore 5
      //   209: aload_3
      //   210: astore 4
      //   212: ldc 175
      //   214: aload 7
      //   216: ldc 55
      //   218: iconst_0
      //   219: anewarray 179	java/lang/Object
      //   222: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   225: aload 6
      //   227: ifnull +8 -> 235
      //   230: aload 6
      //   232: invokevirtual 247	java/io/InputStream:close	()V
      //   235: aload_3
      //   236: ifnull +36 -> 272
      //   239: aload_3
      //   240: invokevirtual 189	com/tencent/mm/vfs/q:ifE	()Z
      //   243: ifeq +29 -> 272
      //   246: aload_3
      //   247: invokevirtual 250	com/tencent/mm/vfs/q:cFq	()Z
      //   250: pop
      //   251: goto -149 -> 102
      //   254: astore 4
      //   256: ldc 175
      //   258: aload 4
      //   260: ldc 55
      //   262: iconst_0
      //   263: anewarray 179	java/lang/Object
      //   266: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   269: goto -34 -> 235
      //   272: ldc 175
      //   274: ldc_w 257
      //   277: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   280: goto -178 -> 102
      //   283: astore 7
      //   285: aconst_null
      //   286: astore 6
      //   288: aconst_null
      //   289: astore_3
      //   290: aload 6
      //   292: astore 5
      //   294: aload_3
      //   295: astore 4
      //   297: ldc 175
      //   299: aload 7
      //   301: ldc 55
      //   303: iconst_0
      //   304: anewarray 179	java/lang/Object
      //   307: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   310: aload 6
      //   312: ifnull +8 -> 320
      //   315: aload 6
      //   317: invokevirtual 247	java/io/InputStream:close	()V
      //   320: aload_3
      //   321: ifnull +36 -> 357
      //   324: aload_3
      //   325: invokevirtual 189	com/tencent/mm/vfs/q:ifE	()Z
      //   328: ifeq +29 -> 357
      //   331: aload_3
      //   332: invokevirtual 250	com/tencent/mm/vfs/q:cFq	()Z
      //   335: pop
      //   336: goto -234 -> 102
      //   339: astore 4
      //   341: ldc 175
      //   343: aload 4
      //   345: ldc 55
      //   347: iconst_0
      //   348: anewarray 179	java/lang/Object
      //   351: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   354: goto -34 -> 320
      //   357: ldc 175
      //   359: ldc_w 257
      //   362: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   365: goto -263 -> 102
      //   368: astore 6
      //   370: aconst_null
      //   371: astore 5
      //   373: aconst_null
      //   374: astore_3
      //   375: aload 5
      //   377: ifnull +8 -> 385
      //   380: aload 5
      //   382: invokevirtual 247	java/io/InputStream:close	()V
      //   385: aload_3
      //   386: ifnull +41 -> 427
      //   389: aload_3
      //   390: invokevirtual 189	com/tencent/mm/vfs/q:ifE	()Z
      //   393: ifeq +34 -> 427
      //   396: aload_3
      //   397: invokevirtual 250	com/tencent/mm/vfs/q:cFq	()Z
      //   400: pop
      //   401: ldc 236
      //   403: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   406: aload 6
      //   408: athrow
      //   409: astore 4
      //   411: ldc 175
      //   413: aload 4
      //   415: ldc 55
      //   417: iconst_0
      //   418: anewarray 179	java/lang/Object
      //   421: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   424: goto -39 -> 385
      //   427: ldc 175
      //   429: ldc_w 257
      //   432: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   435: goto -34 -> 401
      //   438: astore 6
      //   440: aconst_null
      //   441: astore 5
      //   443: goto -68 -> 375
      //   446: astore 6
      //   448: aload 4
      //   450: astore_3
      //   451: goto -76 -> 375
      //   454: astore 7
      //   456: aconst_null
      //   457: astore 6
      //   459: goto -169 -> 290
      //   462: astore 7
      //   464: goto -174 -> 290
      //   467: astore 7
      //   469: aconst_null
      //   470: astore 6
      //   472: goto -267 -> 205
      //   475: astore 7
      //   477: goto -272 -> 205
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	480	0	this	b
      //   8	108	1	l	long
      //   20	431	3	localObject1	Object
      //   39	35	4	localObject2	Object
      //   169	5	4	localIOException1	java.io.IOException
      //   210	1	4	localObject3	Object
      //   254	5	4	localIOException2	java.io.IOException
      //   295	1	4	localObject4	Object
      //   339	5	4	localIOException3	java.io.IOException
      //   409	40	4	localIOException4	java.io.IOException
      //   36	406	5	localInputStream1	java.io.InputStream
      //   32	284	6	localInputStream2	java.io.InputStream
      //   368	39	6	localObject5	Object
      //   438	1	6	localObject6	Object
      //   446	1	6	localObject7	Object
      //   457	14	6	localObject8	Object
      //   198	17	7	localFileNotFoundException1	java.io.FileNotFoundException
      //   283	17	7	localIOException5	java.io.IOException
      //   454	1	7	localIOException6	java.io.IOException
      //   462	1	7	localIOException7	java.io.IOException
      //   467	1	7	localFileNotFoundException2	java.io.FileNotFoundException
      //   475	1	7	localFileNotFoundException3	java.io.FileNotFoundException
      // Exception table:
      //   from	to	target	type
      //   85	90	169	java/io/IOException
      //   9	21	198	java/io/FileNotFoundException
      //   230	235	254	java/io/IOException
      //   9	21	283	java/io/IOException
      //   315	320	339	java/io/IOException
      //   9	21	368	finally
      //   380	385	409	java/io/IOException
      //   21	34	438	finally
      //   130	137	438	finally
      //   41	51	446	finally
      //   58	68	446	finally
      //   75	80	446	finally
      //   212	225	446	finally
      //   297	310	446	finally
      //   21	34	454	java/io/IOException
      //   130	137	454	java/io/IOException
      //   41	51	462	java/io/IOException
      //   58	68	462	java/io/IOException
      //   75	80	462	java/io/IOException
      //   21	34	467	java/io/FileNotFoundException
      //   130	137	467	java/io/FileNotFoundException
      //   41	51	475	java/io/FileNotFoundException
      //   58	68	475	java/io/FileNotFoundException
      //   75	80	475	java/io/FileNotFoundException
    }
    
    public final void adj()
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(45937);
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(this.oAb);
        String str = ((JSONObject)localObject2).optString("operationType");
        if (TextUtils.isEmpty(str))
        {
          Log.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
          this.error = true;
          this.action = -1;
          this.mvQ = "operationType is null";
          callback();
          AppMethodBeat.o(45937);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.oAb });
        this.error = true;
        this.action = -1;
        this.mvQ = "parser data fail, data is invalid";
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
        com.tencent.mm.plugin.appbrand.media.record.b localb = com.tencent.mm.plugin.appbrand.media.record.b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), com.tencent.mm.plugin.appbrand.media.record.b.qdw);
        com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.oAf);
        localObject2 = new RecordParam();
        ((RecordParam)localObject2).duration = i;
        ((RecordParam)localObject2).sampleRate = k;
        ((RecordParam)localObject2).qeK = m;
        ((RecordParam)localObject2).qeL = n;
        ((RecordParam)localObject2).oAc = ((String)localObject1);
        ((RecordParam)localObject2).scene = 8;
        ((RecordParam)localObject2).qeM = d;
        ((RecordParam)localObject2).jvr = System.currentTimeMillis();
        ((RecordParam)localObject2).processName = this.processName;
        ((RecordParam)localObject2).appId = this.appId;
        ((RecordParam)localObject2).qeN = localb;
        if (this.ozZ == null) {
          this.ozZ = new AudioRecordVoIPInterruptListener();
        }
        ((RecordParam)localObject2).qeO = this.ozZ;
        this.oAc = ((String)localObject1);
        com.tencent.mm.plugin.appbrand.media.record.c.cbi();
        localObject1 = g.cbq();
        Log.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
        if ((((g)localObject1).qdK != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((g)localObject1).qdK.appId)))
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
          ((g)localObject1).aeJ();
          if ((!TextUtils.isEmpty(((RecordParam)localObject2).oAc)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).qeL > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).qeK > 0)) {
            break label648;
          }
          i = 0;
          label537:
          if (i != 0) {
            break label653;
          }
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
          j.BZ(15);
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
          Log.e("MicroMsg.Record.JsApiOperateRecorder", this.mvQ);
        }
        callback();
        AppMethodBeat.o(45937);
        return;
        if (((g)localObject1).qdI)
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
          i = j;
          break label558;
        }
        if (!((g)localObject1).adH()) {
          break;
        }
        Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
        i = j;
        break label558;
        label648:
        i = 1;
        break label537;
        label653:
        if (!h.akB(((RecordParam)localObject2).oAc))
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).oAc });
          j.BZ(16);
          i = j;
          break label558;
        }
        if (TextUtils.isEmpty(((RecordParam)localObject2).jvr)) {
          ((RecordParam)localObject2).jvr = System.currentTimeMillis();
        }
        j.cby();
        Log.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).qeK), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).qeL) });
        if (((RecordParam)localObject2).duration <= 0)
        {
          ((RecordParam)localObject2).duration = 60000;
          label804:
          if ((((RecordParam)localObject2).qeK <= 0) && (((RecordParam)localObject2).qeK > 2)) {
            ((RecordParam)localObject2).qeK = 2;
          }
          if (((RecordParam)localObject2).sampleRate <= 48000) {
            break label909;
          }
          ((RecordParam)localObject2).sampleRate = 48000;
          label846:
          if (((RecordParam)localObject2).qeL <= 320000) {
            break label931;
          }
          ((RecordParam)localObject2).qeL = 320000;
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
          if (((RecordParam)localObject2).qeL < 16000) {
            ((RecordParam)localObject2).qeL = 16000;
          }
        }
        label953:
        if (g.cbq().qdI)
        {
          this.error = true;
          this.mvQ = "audio is recording, don't start record again";
        }
        else
        {
          this.error = true;
          this.mvQ = "start record fail";
          continue;
          if (((String)localObject1).equals("resume"))
          {
            localObject1 = g.cbq();
            if (((g)localObject1).qdI) {
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
              if (((g)localObject1).qdK == null)
              {
                Log.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
              }
              else
              {
                j.cby();
                ThreadPool.post(new g.10((g)localObject1), "app_brand_resume_record");
                i = 1;
              }
            }
            label1088:
            if (g.cbq().qdI)
            {
              this.error = true;
              this.mvQ = "audio is recording, don't resume record again";
            }
            else
            {
              this.error = true;
              this.mvQ = "resume record fail";
            }
          }
          else if (((String)localObject1).equals("pause"))
          {
            localObject1 = g.cbq();
            Log.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
            if (((g)localObject1).qdH == null)
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
              if (((g)localObject1).adH())
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
            if (g.cbq().adH())
            {
              this.error = true;
              this.mvQ = "audio is pause, don't pause record again";
            }
            else
            {
              this.error = true;
              this.mvQ = "pause record fail";
            }
          }
          else if (((String)localObject1).equals("stop"))
          {
            if (g.cbq().aeJ())
            {
              this.action = -1;
              Log.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
            }
            else if (g.cbq().adI())
            {
              this.error = true;
              this.mvQ = "audio is stop, don't stop record again";
            }
            else
            {
              this.error = true;
              this.mvQ = "stop record fail";
            }
          }
          else
          {
            Log.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
            this.error = true;
            this.mvQ = "operationType is invalid";
          }
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(45938);
      super.callback();
      if (this.nAz == null)
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
          this.nAz.j(this.okO, this.oAa.h("ok", null));
          AppMethodBeat.o(45938);
          return;
        }
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[] { this.mvQ });
        this.nAz.j(this.okO, this.oAa.h("fail:" + this.mvQ, null));
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
          Log.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[] { this.filePath, this.oAc });
          localObject = new i();
          if (this.nAz.getFileSystem().a(new q(this.filePath), h.akA(this.oAc), true, (i)localObject) == m.nMR)
          {
            localHashMap.put("tempFilePath", ((i)localObject).value);
            label312:
            localHashMap.put("duration", Integer.valueOf(this.duration));
            localHashMap.put("fileSize", Integer.valueOf(this.fileSize));
            this.ozL = new JSONObject(localHashMap).toString();
          }
        }
        else if (this.action == 5)
        {
          localHashMap = new HashMap();
          localHashMap.put("state", this.state);
          localHashMap.put("isLastFrame", Boolean.valueOf(this.fOI));
          if (this.oAe > 819200) {
            bQc();
          }
          if (this.frameBuffer == null) {
            break label664;
          }
          localHashMap.put("frameBuffer", z.bc(this.frameBuffer));
          label445:
          localObject = z.a(this.nAz.getJsRuntime(), localHashMap, (z.a)this.nAz.au(z.a.class));
          if (localObject != z.b.rjc) {
            break label675;
          }
          this.ozL = new JSONObject(localHashMap).toString();
        }
        break;
      }
      label664:
      label675:
      while (localObject != z.b.rjd)
      {
        Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[] { Integer.valueOf(this.action), this.ozL });
        locala.i(this.nAz).agT(this.ozL).bPO();
        AppMethodBeat.o(45938);
        return;
        k.a(this.oAa, true);
        if (k.bQb().contains(this.appId)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.k.a(this.appId, this.cwl);
        k.bQb().add(this.appId);
        break;
        k.a(this.oAa, false);
        if ((this.action != 2) && (this.action != 4)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.k.b(this.appId, this.cwl);
        k.bQb().remove(this.appId);
        break;
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        break label312;
        Log.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
        break label445;
      }
      z.n(this.nAz, "onRecorderStateChange");
      AppMethodBeat.o(45938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */