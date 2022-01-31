package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.plugin.appbrand.media.record.g.10;
import com.tencent.mm.plugin.appbrand.media.record.g.11;
import com.tencent.mm.plugin.appbrand.media.record.g.9;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.t.q.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

final class i$b
  extends a
{
  public int action;
  public String appId;
  e.c bCv;
  private boolean cCq;
  private int duration;
  public boolean error;
  private String filePath;
  private int fileSize;
  private byte[] frameBuffer;
  public String hBF;
  public String hCd;
  AudioRecordVoIPInterruptListener hCr;
  private i hCs;
  public String hCt;
  private String hCu;
  private String hCv;
  private int hCw;
  private final com.tencent.mm.sdk.b.c<mg> hCx;
  public int hry;
  public r hxb;
  public String processName;
  private String state;
  
  public i$b(i parami, r paramr, int paramInt)
  {
    AppMethodBeat.i(130747);
    this.processName = "";
    this.error = false;
    this.hBF = "";
    this.filePath = "";
    this.fileSize = 0;
    this.duration = 0;
    this.state = "";
    this.hCu = "";
    this.hCx = new i.b.1(this);
    this.hCs = parami;
    this.hxb = paramr;
    this.hry = paramInt;
    parami = new com.tencent.mm.plugin.appbrand.s.j();
    if (paramr.wX().a(parami) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
    {
      this.hCv = new File((String)parami.value, "frameBuffer").getAbsolutePath();
      AppMethodBeat.o(130747);
      return;
    }
    this.hCv = new File(paramr.getContext().getCacheDir(), "frameBuffer_" + paramr.getAppId()).getAbsolutePath();
    AppMethodBeat.o(130747);
  }
  
  /* Error */
  private void aBQ()
  {
    // Byte code:
    //   0: ldc 233
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 172	java/lang/System:nanoTime	()J
    //   8: lstore_1
    //   9: new 105	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/audio/i$b:hCv	Ljava/lang/String;
    //   17: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 189	java/io/File:exists	()Z
    //   25: ifeq +104 -> 129
    //   28: new 235	java/io/FileInputStream
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore 6
    //   38: aload 6
    //   40: astore 5
    //   42: aload_3
    //   43: astore 4
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 158	com/tencent/mm/plugin/appbrand/jsapi/audio/i$b:hCw	I
    //   50: newarray byte
    //   52: putfield 231	com/tencent/mm/plugin/appbrand/jsapi/audio/i$b:frameBuffer	[B
    //   55: aload 6
    //   57: astore 5
    //   59: aload_3
    //   60: astore 4
    //   62: aload 6
    //   64: aload_0
    //   65: getfield 231	com/tencent/mm/plugin/appbrand/jsapi/audio/i$b:frameBuffer	[B
    //   68: invokevirtual 240	java/io/FileInputStream:read	([B)I
    //   71: pop
    //   72: aload 6
    //   74: astore 5
    //   76: aload_3
    //   77: astore 4
    //   79: aload 6
    //   81: invokevirtual 241	java/io/FileInputStream:close	()V
    //   84: aload 6
    //   86: invokevirtual 241	java/io/FileInputStream:close	()V
    //   89: aload_3
    //   90: invokevirtual 189	java/io/File:exists	()Z
    //   93: ifeq +92 -> 185
    //   96: aload_3
    //   97: invokevirtual 244	java/io/File:delete	()Z
    //   100: pop
    //   101: ldc 175
    //   103: ldc 216
    //   105: iconst_1
    //   106: anewarray 179	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: invokestatic 172	java/lang/System:nanoTime	()J
    //   114: lload_1
    //   115: lsub
    //   116: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   119: aastore
    //   120: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc 233
    //   125: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: ldc 175
    //   131: ldc 246
    //   133: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_3
    //   137: invokevirtual 189	java/io/File:exists	()Z
    //   140: ifeq +14 -> 154
    //   143: aload_3
    //   144: invokevirtual 244	java/io/File:delete	()Z
    //   147: pop
    //   148: ldc 233
    //   150: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: ldc 175
    //   156: ldc 251
    //   158: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: ldc 233
    //   163: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: astore 4
    //   169: ldc 175
    //   171: aload 4
    //   173: ldc 53
    //   175: iconst_0
    //   176: anewarray 179	java/lang/Object
    //   179: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -93 -> 89
    //   185: ldc 175
    //   187: ldc 251
    //   189: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -91 -> 101
    //   195: astore 7
    //   197: aconst_null
    //   198: astore 6
    //   200: aconst_null
    //   201: astore_3
    //   202: aload 6
    //   204: astore 5
    //   206: aload_3
    //   207: astore 4
    //   209: ldc 175
    //   211: aload 7
    //   213: ldc 53
    //   215: iconst_0
    //   216: anewarray 179	java/lang/Object
    //   219: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: aload 6
    //   224: ifnull +8 -> 232
    //   227: aload 6
    //   229: invokevirtual 241	java/io/FileInputStream:close	()V
    //   232: aload_3
    //   233: ifnull +36 -> 269
    //   236: aload_3
    //   237: invokevirtual 189	java/io/File:exists	()Z
    //   240: ifeq +29 -> 269
    //   243: aload_3
    //   244: invokevirtual 244	java/io/File:delete	()Z
    //   247: pop
    //   248: goto -147 -> 101
    //   251: astore 4
    //   253: ldc 175
    //   255: aload 4
    //   257: ldc 53
    //   259: iconst_0
    //   260: anewarray 179	java/lang/Object
    //   263: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: goto -34 -> 232
    //   269: ldc 175
    //   271: ldc 251
    //   273: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: goto -175 -> 101
    //   279: astore 7
    //   281: aconst_null
    //   282: astore 6
    //   284: aconst_null
    //   285: astore_3
    //   286: aload 6
    //   288: astore 5
    //   290: aload_3
    //   291: astore 4
    //   293: ldc 175
    //   295: aload 7
    //   297: ldc 53
    //   299: iconst_0
    //   300: anewarray 179	java/lang/Object
    //   303: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: aload 6
    //   308: ifnull +8 -> 316
    //   311: aload 6
    //   313: invokevirtual 241	java/io/FileInputStream:close	()V
    //   316: aload_3
    //   317: ifnull +36 -> 353
    //   320: aload_3
    //   321: invokevirtual 189	java/io/File:exists	()Z
    //   324: ifeq +29 -> 353
    //   327: aload_3
    //   328: invokevirtual 244	java/io/File:delete	()Z
    //   331: pop
    //   332: goto -231 -> 101
    //   335: astore 4
    //   337: ldc 175
    //   339: aload 4
    //   341: ldc 53
    //   343: iconst_0
    //   344: anewarray 179	java/lang/Object
    //   347: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: goto -34 -> 316
    //   353: ldc 175
    //   355: ldc 251
    //   357: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto -259 -> 101
    //   363: astore 6
    //   365: aconst_null
    //   366: astore 5
    //   368: aconst_null
    //   369: astore_3
    //   370: aload 5
    //   372: ifnull +8 -> 380
    //   375: aload 5
    //   377: invokevirtual 241	java/io/FileInputStream:close	()V
    //   380: aload_3
    //   381: ifnull +41 -> 422
    //   384: aload_3
    //   385: invokevirtual 189	java/io/File:exists	()Z
    //   388: ifeq +34 -> 422
    //   391: aload_3
    //   392: invokevirtual 244	java/io/File:delete	()Z
    //   395: pop
    //   396: ldc 233
    //   398: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload 6
    //   403: athrow
    //   404: astore 4
    //   406: ldc 175
    //   408: aload 4
    //   410: ldc 53
    //   412: iconst_0
    //   413: anewarray 179	java/lang/Object
    //   416: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: goto -39 -> 380
    //   422: ldc 175
    //   424: ldc 251
    //   426: invokestatic 249	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto -33 -> 396
    //   432: astore 6
    //   434: aconst_null
    //   435: astore 5
    //   437: goto -67 -> 370
    //   440: astore 6
    //   442: aload 4
    //   444: astore_3
    //   445: goto -75 -> 370
    //   448: astore 7
    //   450: aconst_null
    //   451: astore 6
    //   453: goto -167 -> 286
    //   456: astore 7
    //   458: goto -172 -> 286
    //   461: astore 7
    //   463: aconst_null
    //   464: astore 6
    //   466: goto -264 -> 202
    //   469: astore 7
    //   471: goto -269 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	b
    //   8	107	1	l	long
    //   20	425	3	localObject1	Object
    //   43	35	4	localObject2	Object
    //   167	5	4	localIOException1	java.io.IOException
    //   207	1	4	localObject3	Object
    //   251	5	4	localIOException2	java.io.IOException
    //   291	1	4	localObject4	Object
    //   335	5	4	localIOException3	java.io.IOException
    //   404	39	4	localIOException4	java.io.IOException
    //   40	396	5	localFileInputStream1	java.io.FileInputStream
    //   36	276	6	localFileInputStream2	java.io.FileInputStream
    //   363	39	6	localObject5	Object
    //   432	1	6	localObject6	Object
    //   440	1	6	localObject7	Object
    //   451	14	6	localObject8	Object
    //   195	17	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   279	17	7	localIOException5	java.io.IOException
    //   448	1	7	localIOException6	java.io.IOException
    //   456	1	7	localIOException7	java.io.IOException
    //   461	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   469	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   84	89	167	java/io/IOException
    //   9	21	195	java/io/FileNotFoundException
    //   227	232	251	java/io/IOException
    //   9	21	279	java/io/IOException
    //   311	316	335	java/io/IOException
    //   9	21	363	finally
    //   375	380	404	java/io/IOException
    //   21	38	432	finally
    //   129	136	432	finally
    //   45	55	440	finally
    //   62	72	440	finally
    //   79	84	440	finally
    //   209	222	440	finally
    //   293	306	440	finally
    //   21	38	448	java/io/IOException
    //   129	136	448	java/io/IOException
    //   45	55	456	java/io/IOException
    //   62	72	456	java/io/IOException
    //   79	84	456	java/io/IOException
    //   21	38	461	java/io/FileNotFoundException
    //   129	136	461	java/io/FileNotFoundException
    //   45	55	469	java/io/FileNotFoundException
    //   62	72	469	java/io/FileNotFoundException
    //   79	84	469	java/io/FileNotFoundException
  }
  
  public final void Dh()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(130748);
    Object localObject2;
    try
    {
      localObject2 = new JSONObject(this.hCt);
      String str = ((JSONObject)localObject2).optString("operationType");
      if (TextUtils.isEmpty(str))
      {
        ab.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
        this.error = true;
        this.action = -1;
        this.hBF = "operationType is null";
        tU();
        AppMethodBeat.o(130748);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.hCt });
      this.error = true;
      this.action = -1;
      this.hBF = "parser data fail, data is invalid";
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + localJSONException.getMessage());
      tU();
      AppMethodBeat.o(130748);
      return;
    }
    ab.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[] { localJSONException });
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
      b localb = b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), b.ipj);
      com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.hCx);
      localObject2 = new RecordParam();
      ((RecordParam)localObject2).duration = i;
      ((RecordParam)localObject2).sampleRate = k;
      ((RecordParam)localObject2).ifH = m;
      ((RecordParam)localObject2).ifJ = n;
      ((RecordParam)localObject2).hCu = ((String)localObject1);
      ((RecordParam)localObject2).scene = 8;
      ((RecordParam)localObject2).ifK = d;
      ((RecordParam)localObject2).ese = System.currentTimeMillis();
      ((RecordParam)localObject2).processName = this.processName;
      ((RecordParam)localObject2).appId = this.appId;
      ((RecordParam)localObject2).iqs = localb;
      if (this.hCr == null) {
        this.hCr = new AudioRecordVoIPInterruptListener();
      }
      ((RecordParam)localObject2).iqt = this.hCr;
      this.hCu = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.record.c.aHL();
      localObject1 = g.aHT();
      ab.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
      if ((((g)localObject1).ipw != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((g)localObject1).ipw.appId)))
      {
        ab.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
        ((g)localObject1).Et();
        if ((!TextUtils.isEmpty(((RecordParam)localObject2).hCu)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).ifJ > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).ifH > 0)) {
          break label648;
        }
        i = 0;
        label537:
        if (i != 0) {
          break label653;
        }
        ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
        com.tencent.mm.plugin.appbrand.media.record.j.oS(15);
        i = j;
        label558:
        if (i == 0) {
          break label953;
        }
        ab.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
        this.action = -1;
      }
    }
    for (;;)
    {
      if (this.error) {
        ab.e("MicroMsg.Record.JsApiOperateRecorder", this.hBF);
      }
      tU();
      AppMethodBeat.o(130748);
      return;
      if (((g)localObject1).mIsRecording)
      {
        ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
        i = j;
        break label558;
      }
      if (!((g)localObject1).Ds()) {
        break;
      }
      ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
      i = j;
      break label558;
      label648:
      i = 1;
      break label537;
      label653:
      if (!h.DD(((RecordParam)localObject2).hCu))
      {
        ab.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).hCu });
        com.tencent.mm.plugin.appbrand.media.record.j.oS(16);
        i = j;
        break label558;
      }
      if (TextUtils.isEmpty(((RecordParam)localObject2).ese)) {
        ((RecordParam)localObject2).ese = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.appbrand.media.record.j.aIa();
      ab.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).ifH), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).ifJ) });
      if (((RecordParam)localObject2).duration <= 0)
      {
        ((RecordParam)localObject2).duration = 60000;
        label804:
        if ((((RecordParam)localObject2).ifH <= 0) && (((RecordParam)localObject2).ifH > 2)) {
          ((RecordParam)localObject2).ifH = 2;
        }
        if (((RecordParam)localObject2).sampleRate <= 48000) {
          break label909;
        }
        ((RecordParam)localObject2).sampleRate = 48000;
        label846:
        if (((RecordParam)localObject2).ifJ <= 320000) {
          break label931;
        }
        ((RecordParam)localObject2).ifJ = 320000;
      }
      for (;;)
      {
        d.post(new g.9((g)localObject1, (RecordParam)localObject2), "app_brand_start_record");
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
        if (((RecordParam)localObject2).ifJ < 16000) {
          ((RecordParam)localObject2).ifJ = 16000;
        }
      }
      label953:
      if (g.aHT().mIsRecording)
      {
        this.error = true;
        this.hBF = "audio is recording, don't start record again";
      }
      else
      {
        this.error = true;
        this.hBF = "start record fail";
        continue;
        if (((String)localObject1).equals("resume"))
        {
          localObject1 = g.aHT();
          if (((g)localObject1).mIsRecording) {
            ab.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
          }
          for (;;)
          {
            if (i == 0) {
              break label1088;
            }
            this.action = -1;
            ab.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
            break;
            if (((g)localObject1).ipw == null)
            {
              ab.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
            }
            else
            {
              com.tencent.mm.plugin.appbrand.media.record.j.aIa();
              d.post(new g.10((g)localObject1), "app_brand_resume_record");
              i = 1;
            }
          }
          label1088:
          if (g.aHT().mIsRecording)
          {
            this.error = true;
            this.hBF = "audio is recording, don't resume record again";
          }
          else
          {
            this.error = true;
            this.hBF = "resume record fail";
          }
        }
        else if (((String)localObject1).equals("pause"))
        {
          localObject1 = g.aHT();
          ab.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
          if (((g)localObject1).ipu == null)
          {
            ab.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
            i = 0;
          }
          for (;;)
          {
            if (i == 0) {
              break label1233;
            }
            this.action = -1;
            ab.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
            break;
            if (((g)localObject1).Ds())
            {
              ab.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
              i = 1;
            }
            else
            {
              d.post(new g.11((g)localObject1), "app_brand_pause_record");
              i = 1;
            }
          }
          label1233:
          if (g.aHT().Ds())
          {
            this.error = true;
            this.hBF = "audio is pause, don't pause record again";
          }
          else
          {
            this.error = true;
            this.hBF = "pause record fail";
          }
        }
        else if (((String)localObject1).equals("stop"))
        {
          if (g.aHT().Et())
          {
            this.action = -1;
            ab.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
          }
          else if (g.aHT().Dt())
          {
            this.error = true;
            this.hBF = "audio is stop, don't stop record again";
          }
          else
          {
            this.error = true;
            this.hBF = "stop record fail";
          }
        }
        else
        {
          ab.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
          this.error = true;
          this.hBF = "operationType is invalid";
        }
      }
    }
  }
  
  public final void tU()
  {
    AppMethodBeat.i(130749);
    super.tU();
    if (this.hxb == null)
    {
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
      AppMethodBeat.o(130749);
      return;
    }
    if (this.action == -1)
    {
      if (!this.error)
      {
        ab.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
        this.hxb.h(this.hry, this.hCs.j("ok", null));
        AppMethodBeat.o(130749);
        return;
      }
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[] { this.hBF });
      this.hxb.h(this.hry, this.hCs.j("fail:" + this.hBF, null));
      AppMethodBeat.o(130749);
      return;
    }
    i.a locala = new i.a();
    HashMap localHashMap;
    Object localObject;
    switch (this.action)
    {
    default: 
      if (this.action == 2)
      {
        localHashMap = new HashMap();
        localHashMap.put("state", this.state);
        ab.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[] { this.filePath, this.hCu });
        localObject = new com.tencent.mm.plugin.appbrand.s.j();
        if (this.hxb.wX().a(new File(this.filePath), h.DC(this.hCu), true, (com.tencent.mm.plugin.appbrand.s.j)localObject) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
        {
          localHashMap.put("tempFilePath", ((com.tencent.mm.plugin.appbrand.s.j)localObject).value);
          label312:
          localHashMap.put("duration", Integer.valueOf(this.duration));
          localHashMap.put("fileSize", Integer.valueOf(this.fileSize));
          this.hCd = new JSONObject(localHashMap).toString();
        }
      }
      else if (this.action == 5)
      {
        localHashMap = new HashMap();
        localHashMap.put("state", this.state);
        localHashMap.put("isLastFrame", Boolean.valueOf(this.cCq));
        if (this.hCw > 819200) {
          aBQ();
        }
        if (this.frameBuffer == null) {
          break label664;
        }
        localHashMap.put("frameBuffer", q.ak(this.frameBuffer));
        label445:
        localObject = q.a(this.hxb.aAO(), localHashMap, (q.a)this.hxb.U(q.a.class));
        if (localObject != q.b.iXY) {
          break label675;
        }
        this.hCd = new JSONObject(localHashMap).toString();
      }
      break;
    }
    label664:
    label675:
    while (localObject != q.b.iXZ)
    {
      ab.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[] { Integer.valueOf(this.action), this.hCd });
      locala.i(this.hxb).BM(this.hCd).aBz();
      AppMethodBeat.o(130749);
      return;
      i.a(this.hCs, true);
      if (i.aBP().contains(this.appId)) {
        break;
      }
      e.a(this.appId, this.bCv);
      i.aBP().add(this.appId);
      break;
      i.a(this.hCs, false);
      if ((this.action != 2) && (this.action != 4)) {
        break;
      }
      e.b(this.appId, this.bCv);
      i.aBP().remove(this.appId);
      break;
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
      localHashMap.put("tempFilePath", "");
      break label312;
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
      break label445;
    }
    q.l(this.hxb, "onRecorderStateChange");
    AppMethodBeat.o(130749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i.b
 * JD-Core Version:    0.7.0.1
 */