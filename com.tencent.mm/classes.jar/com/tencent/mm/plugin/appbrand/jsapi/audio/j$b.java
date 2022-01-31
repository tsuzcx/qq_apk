package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.h.a.lq;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.plugin.appbrand.media.record.g.7;
import com.tencent.mm.plugin.appbrand.media.record.g.8;
import com.tencent.mm.plugin.appbrand.media.record.g.9;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

final class j$b
  extends a
{
  public int action;
  public String appId;
  private boolean bUJ;
  private int duration = 0;
  public boolean error = false;
  private String filePath = "";
  private int fileSize = 0;
  private byte[] frameBuffer;
  g.b gda;
  public o gfd;
  public int gfg;
  public String giJ;
  AudioRecordVoIPInterruptListener giX;
  private j giY;
  public String giZ;
  public String gio = "";
  private String gja = "";
  private String gjb;
  private int gjc;
  private final com.tencent.mm.sdk.b.c<lq> gjd = new j.b.1(this);
  public String processName = "";
  private String state = "";
  
  public j$b(j paramj, o paramo, int paramInt)
  {
    this.giY = paramj;
    this.gfd = paramo;
    this.gfg = paramInt;
    paramj = new com.tencent.mm.plugin.appbrand.u.k();
    if (paramo.Zl().a(paramj) == com.tencent.mm.plugin.appbrand.appstorage.h.fGU)
    {
      this.gjb = new File((String)paramj.value, "frameBuffer").getAbsolutePath();
      return;
    }
    this.gjb = new File(paramo.getContext().getCacheDir(), "frameBuffer_" + paramo.mAppId).getAbsolutePath();
  }
  
  public final void ahX()
  {
    int i = 0;
    int j = 0;
    Object localObject2;
    try
    {
      localObject2 = new JSONObject(this.giZ);
      String str = ((JSONObject)localObject2).optString("operationType");
      if (TextUtils.isEmpty(str))
      {
        y.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
        this.error = true;
        this.action = -1;
        this.gio = "operationType is null";
        pQ();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[] { this.giZ });
      this.error = true;
      this.action = -1;
      this.gio = "parser data fail, data is invalid";
      y.e("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + localJSONException.getMessage());
      pQ();
      return;
    }
    y.i("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", new Object[] { localJSONException });
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
      b localb = b.a(((JSONObject)localObject2).optString("audioSource").toUpperCase(), b.gNp);
      com.tencent.mm.plugin.appbrand.media.record.c.b(this.appId, this.gjd);
      localObject2 = new RecordParam();
      ((RecordParam)localObject2).duration = i;
      ((RecordParam)localObject2).sampleRate = k;
      ((RecordParam)localObject2).gOG = m;
      ((RecordParam)localObject2).gOH = n;
      ((RecordParam)localObject2).gja = ((String)localObject1);
      ((RecordParam)localObject2).scene = 8;
      ((RecordParam)localObject2).gOI = d;
      ((RecordParam)localObject2).dzp = System.currentTimeMillis();
      ((RecordParam)localObject2).processName = this.processName;
      ((RecordParam)localObject2).appId = this.appId;
      ((RecordParam)localObject2).gOJ = localb;
      if (this.giX == null) {
        this.giX = new AudioRecordVoIPInterruptListener();
      }
      ((RecordParam)localObject2).gOK = this.giX;
      this.gja = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.record.c.ame();
      localObject1 = g.amm();
      y.i("MicroMsg.Record.AudioRecordMgr", "startRecord");
      if ((((g)localObject1).gNJ != null) && (((RecordParam)localObject2).appId != null) && (!((RecordParam)localObject2).appId.equalsIgnoreCase(((g)localObject1).gNJ.appId)))
      {
        y.e("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
        ((g)localObject1).uh();
        if ((!TextUtils.isEmpty(((RecordParam)localObject2).gja)) && (((RecordParam)localObject2).duration >= 0) && (((RecordParam)localObject2).gOH > 0) && (((RecordParam)localObject2).sampleRate > 0) && (((RecordParam)localObject2).gOG > 0)) {
          break label620;
        }
        i = 0;
        label515:
        if (i != 0) {
          break label625;
        }
        y.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
        com.tencent.mm.plugin.appbrand.media.record.j.lU(15);
        i = j;
        label536:
        if (i == 0) {
          break label925;
        }
        y.i("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
        this.action = -1;
      }
    }
    for (;;)
    {
      if (this.error) {
        y.e("MicroMsg.Record.JsApiOperateRecorder", this.gio);
      }
      pQ();
      return;
      if (((g)localObject1).mIsRecording)
      {
        y.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
        i = j;
        break label536;
      }
      if (!((g)localObject1).uf()) {
        break;
      }
      y.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
      i = j;
      break label536;
      label620:
      i = 1;
      break label515;
      label625:
      if (!com.tencent.mm.plugin.appbrand.media.record.h.vh(((RecordParam)localObject2).gja))
      {
        y.e("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[] { ((RecordParam)localObject2).gja });
        com.tencent.mm.plugin.appbrand.media.record.j.lU(16);
        i = j;
        break label536;
      }
      if (TextUtils.isEmpty(((RecordParam)localObject2).dzp)) {
        ((RecordParam)localObject2).dzp = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.appbrand.media.record.j.amv();
      y.i("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[] { Integer.valueOf(((RecordParam)localObject2).duration), Integer.valueOf(((RecordParam)localObject2).gOG), Integer.valueOf(((RecordParam)localObject2).sampleRate), Integer.valueOf(((RecordParam)localObject2).gOH) });
      if (((RecordParam)localObject2).duration <= 0)
      {
        ((RecordParam)localObject2).duration = 60000;
        label776:
        if ((((RecordParam)localObject2).gOG <= 0) && (((RecordParam)localObject2).gOG > 2)) {
          ((RecordParam)localObject2).gOG = 2;
        }
        if (((RecordParam)localObject2).sampleRate <= 48000) {
          break label881;
        }
        ((RecordParam)localObject2).sampleRate = 48000;
        label818:
        if (((RecordParam)localObject2).gOH <= 320000) {
          break label903;
        }
        ((RecordParam)localObject2).gOH = 320000;
      }
      for (;;)
      {
        e.post(new g.7((g)localObject1, (RecordParam)localObject2), "app_brand_start_record");
        i = 1;
        break;
        if (((RecordParam)localObject2).duration < 600000) {
          break label776;
        }
        ((RecordParam)localObject2).duration = 600000;
        break label776;
        label881:
        if (((RecordParam)localObject2).sampleRate >= 8000) {
          break label818;
        }
        ((RecordParam)localObject2).sampleRate = 8000;
        break label818;
        label903:
        if (((RecordParam)localObject2).gOH < 16000) {
          ((RecordParam)localObject2).gOH = 16000;
        }
      }
      label925:
      if (g.amm().mIsRecording)
      {
        this.error = true;
        this.gio = "audio is recording, don't start record again";
      }
      else
      {
        this.error = true;
        this.gio = "start record fail";
        continue;
        if (((String)localObject1).equals("resume"))
        {
          localObject1 = g.amm();
          if (((g)localObject1).mIsRecording) {
            y.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
          }
          for (;;)
          {
            if (i == 0) {
              break label1060;
            }
            this.action = -1;
            y.i("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
            break;
            if (((g)localObject1).gNJ == null)
            {
              y.e("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
            }
            else
            {
              com.tencent.mm.plugin.appbrand.media.record.j.amv();
              e.post(new g.8((g)localObject1), "app_brand_resume_record");
              i = 1;
            }
          }
          label1060:
          if (g.amm().mIsRecording)
          {
            this.error = true;
            this.gio = "audio is recording, don't resume record again";
          }
          else
          {
            this.error = true;
            this.gio = "resume record fail";
          }
        }
        else if (((String)localObject1).equals("pause"))
        {
          localObject1 = g.amm();
          y.i("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
          if (((g)localObject1).gNH == null)
          {
            y.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
            i = 0;
          }
          for (;;)
          {
            if (i == 0) {
              break label1205;
            }
            this.action = -1;
            y.i("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
            break;
            if (((g)localObject1).uf())
            {
              y.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
              i = 1;
            }
            else
            {
              e.post(new g.9((g)localObject1), "app_brand_pause_record");
              i = 1;
            }
          }
          label1205:
          if (g.amm().uf())
          {
            this.error = true;
            this.gio = "audio is pause, don't pause record again";
          }
          else
          {
            this.error = true;
            this.gio = "pause record fail";
          }
        }
        else if (((String)localObject1).equals("stop"))
        {
          if (g.amm().uh())
          {
            this.action = -1;
            y.i("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
          }
          else if (g.amm().amn())
          {
            this.error = true;
            this.gio = "audio is stop, don't stop record again";
          }
          else
          {
            this.error = true;
            this.gio = "stop record fail";
          }
        }
        else
        {
          y.e("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
          this.error = true;
          this.gio = "operationType is invalid";
        }
      }
    }
  }
  
  /* Error */
  public final void pQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 503	com/tencent/mm/plugin/appbrand/jsapi/audio/a:pQ	()V
    //   4: aload_0
    //   5: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   8: ifnonnull +12 -> 20
    //   11: ldc 164
    //   13: ldc_w 505
    //   16: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: return
    //   20: aload_0
    //   21: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   24: iconst_m1
    //   25: if_icmpne +100 -> 125
    //   28: aload_0
    //   29: getfield 50	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:error	Z
    //   32: ifne +34 -> 66
    //   35: ldc 164
    //   37: ldc_w 507
    //   40: invokestatic 375	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   47: aload_0
    //   48: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfg	I
    //   51: aload_0
    //   52: getfield 71	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giY	Lcom/tencent/mm/plugin/appbrand/jsapi/audio/j;
    //   55: ldc_w 509
    //   58: aconst_null
    //   59: invokevirtual 515	com/tencent/mm/plugin/appbrand/jsapi/i:h	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   62: invokevirtual 519	com/tencent/mm/plugin/appbrand/o:C	(ILjava/lang/String;)V
    //   65: return
    //   66: ldc 164
    //   68: ldc_w 521
    //   71: iconst_1
    //   72: anewarray 168	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: getfield 52	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gio	Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic 255	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   89: aload_0
    //   90: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfg	I
    //   93: aload_0
    //   94: getfield 71	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giY	Lcom/tencent/mm/plugin/appbrand/jsapi/audio/j;
    //   97: new 126	java/lang/StringBuilder
    //   100: dup
    //   101: ldc_w 523
    //   104: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 52	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gio	Ljava/lang/String;
    //   111: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aconst_null
    //   118: invokevirtual 515	com/tencent/mm/plugin/appbrand/jsapi/i:h	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   121: invokevirtual 519	com/tencent/mm/plugin/appbrand/o:C	(ILjava/lang/String;)V
    //   124: return
    //   125: new 525	com/tencent/mm/plugin/appbrand/jsapi/audio/j$a
    //   128: dup
    //   129: invokespecial 526	com/tencent/mm/plugin/appbrand/jsapi/audio/j$a:<init>	()V
    //   132: astore 8
    //   134: aload_0
    //   135: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   138: tableswitch	default:+34 -> 172, 0:+502->640, 1:+502->640, 2:+548->686, 3:+548->686, 4:+548->686
    //   173: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   176: iconst_2
    //   177: if_icmpne +163 -> 340
    //   180: new 528	java/util/HashMap
    //   183: dup
    //   184: invokespecial 529	java/util/HashMap:<init>	()V
    //   187: astore_3
    //   188: aload_3
    //   189: ldc_w 530
    //   192: aload_0
    //   193: getfield 60	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:state	Ljava/lang/String;
    //   196: invokeinterface 536 3 0
    //   201: pop
    //   202: ldc 164
    //   204: ldc_w 538
    //   207: iconst_2
    //   208: anewarray 168	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_0
    //   214: getfield 54	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:filePath	Ljava/lang/String;
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload_0
    //   221: getfield 62	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gja	Ljava/lang/String;
    //   224: aastore
    //   225: invokestatic 267	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: new 77	com/tencent/mm/plugin/appbrand/u/k
    //   231: dup
    //   232: invokespecial 78	com/tencent/mm/plugin/appbrand/u/k:<init>	()V
    //   235: astore 4
    //   237: aload_0
    //   238: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   241: invokevirtual 84	com/tencent/mm/plugin/appbrand/o:Zl	()Lcom/tencent/mm/plugin/appbrand/appstorage/k;
    //   244: new 98	java/io/File
    //   247: dup
    //   248: aload_0
    //   249: getfield 54	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:filePath	Ljava/lang/String;
    //   252: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: aload_0
    //   256: getfield 62	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gja	Ljava/lang/String;
    //   259: invokestatic 541	com/tencent/mm/plugin/appbrand/media/record/h:vg	(Ljava/lang/String;)Ljava/lang/String;
    //   262: iconst_1
    //   263: aload 4
    //   265: invokeinterface 544 5 0
    //   270: getstatic 96	com/tencent/mm/plugin/appbrand/appstorage/h:fGU	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   273: if_acmpne +462 -> 735
    //   276: aload_3
    //   277: ldc_w 546
    //   280: aload 4
    //   282: getfield 102	com/tencent/mm/plugin/appbrand/u/k:value	Ljava/lang/Object;
    //   285: invokeinterface 536 3 0
    //   290: pop
    //   291: aload_3
    //   292: ldc_w 274
    //   295: aload_0
    //   296: getfield 58	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:duration	I
    //   299: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: invokeinterface 536 3 0
    //   307: pop
    //   308: aload_3
    //   309: ldc_w 547
    //   312: aload_0
    //   313: getfield 56	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:fileSize	I
    //   316: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokeinterface 536 3 0
    //   324: pop
    //   325: aload_0
    //   326: new 226	org/json/JSONObject
    //   329: dup
    //   330: aload_3
    //   331: invokespecial 550	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   334: invokevirtual 551	org/json/JSONObject:toString	()Ljava/lang/String;
    //   337: putfield 553	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giJ	Ljava/lang/String;
    //   340: aload_0
    //   341: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   344: iconst_5
    //   345: if_icmpne +246 -> 591
    //   348: new 528	java/util/HashMap
    //   351: dup
    //   352: invokespecial 529	java/util/HashMap:<init>	()V
    //   355: astore 9
    //   357: aload 9
    //   359: ldc_w 530
    //   362: aload_0
    //   363: getfield 60	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:state	Ljava/lang/String;
    //   366: invokeinterface 536 3 0
    //   371: pop
    //   372: aload 9
    //   374: ldc_w 555
    //   377: aload_0
    //   378: getfield 218	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:bUJ	Z
    //   381: invokestatic 560	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   384: invokeinterface 536 3 0
    //   389: pop
    //   390: aload_0
    //   391: getfield 148	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gjc	I
    //   394: ldc_w 561
    //   397: if_icmple +121 -> 518
    //   400: invokestatic 161	java/lang/System:nanoTime	()J
    //   403: lstore_1
    //   404: new 98	java/io/File
    //   407: dup
    //   408: aload_0
    //   409: getfield 114	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gjb	Ljava/lang/String;
    //   412: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   415: astore_3
    //   416: aload_3
    //   417: invokevirtual 178	java/io/File:exists	()Z
    //   420: ifeq +338 -> 758
    //   423: new 563	java/io/FileInputStream
    //   426: dup
    //   427: aload_3
    //   428: invokespecial 564	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   431: astore 6
    //   433: aload 6
    //   435: astore 5
    //   437: aload_3
    //   438: astore 4
    //   440: aload_0
    //   441: aload_0
    //   442: getfield 148	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gjc	I
    //   445: newarray byte
    //   447: putfield 220	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:frameBuffer	[B
    //   450: aload 6
    //   452: astore 5
    //   454: aload_3
    //   455: astore 4
    //   457: aload 6
    //   459: aload_0
    //   460: getfield 220	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:frameBuffer	[B
    //   463: invokevirtual 568	java/io/FileInputStream:read	([B)I
    //   466: pop
    //   467: aload 6
    //   469: astore 5
    //   471: aload_3
    //   472: astore 4
    //   474: aload 6
    //   476: invokevirtual 569	java/io/FileInputStream:close	()V
    //   479: aload 6
    //   481: invokevirtual 569	java/io/FileInputStream:close	()V
    //   484: aload_3
    //   485: invokevirtual 178	java/io/File:exists	()Z
    //   488: ifeq +322 -> 810
    //   491: aload_3
    //   492: invokevirtual 572	java/io/File:delete	()Z
    //   495: pop
    //   496: ldc 164
    //   498: ldc 205
    //   500: iconst_1
    //   501: anewarray 168	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: invokestatic 161	java/lang/System:nanoTime	()J
    //   509: lload_1
    //   510: lsub
    //   511: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   514: aastore
    //   515: invokestatic 174	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: aload_0
    //   519: getfield 220	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:frameBuffer	[B
    //   522: ifnull +534 -> 1056
    //   525: aload 9
    //   527: ldc 105
    //   529: aload_0
    //   530: getfield 220	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:frameBuffer	[B
    //   533: invokestatic 578	com/tencent/mm/plugin/appbrand/v/n:Q	([B)Ljava/nio/ByteBuffer;
    //   536: invokeinterface 536 3 0
    //   541: pop
    //   542: aload_0
    //   543: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   546: invokevirtual 582	com/tencent/mm/plugin/appbrand/o:ahK	()Lcom/tencent/mm/plugin/appbrand/i/f;
    //   549: aload 9
    //   551: aload_0
    //   552: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   555: ldc_w 584
    //   558: invokevirtual 587	com/tencent/mm/plugin/appbrand/o:D	(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/g;
    //   561: checkcast 584	com/tencent/mm/plugin/appbrand/v/n$a
    //   564: invokestatic 590	com/tencent/mm/plugin/appbrand/v/n:a	(Lcom/tencent/mm/plugin/appbrand/i/f;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/v/n$a;)Lcom/tencent/mm/plugin/appbrand/v/n$b;
    //   567: astore_3
    //   568: aload_3
    //   569: getstatic 596	com/tencent/mm/plugin/appbrand/v/n$b:hlF	Lcom/tencent/mm/plugin/appbrand/v/n$b;
    //   572: if_acmpne +495 -> 1067
    //   575: aload_0
    //   576: new 226	org/json/JSONObject
    //   579: dup
    //   580: aload 9
    //   582: invokespecial 550	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   585: invokevirtual 551	org/json/JSONObject:toString	()Ljava/lang/String;
    //   588: putfield 553	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giJ	Ljava/lang/String;
    //   591: ldc 164
    //   593: ldc_w 598
    //   596: iconst_2
    //   597: anewarray 168	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload_0
    //   603: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   606: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   609: aastore
    //   610: dup
    //   611: iconst_1
    //   612: aload_0
    //   613: getfield 553	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giJ	Ljava/lang/String;
    //   616: aastore
    //   617: invokestatic 267	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   620: aload 8
    //   622: aload_0
    //   623: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   626: invokevirtual 601	com/tencent/mm/plugin/appbrand/jsapi/audio/j$a:d	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;)Lcom/tencent/mm/plugin/appbrand/jsapi/l;
    //   629: aload_0
    //   630: getfield 553	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giJ	Ljava/lang/String;
    //   633: invokevirtual 607	com/tencent/mm/plugin/appbrand/jsapi/l:tL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/l;
    //   636: invokevirtual 610	com/tencent/mm/plugin/appbrand/jsapi/l:dispatch	()V
    //   639: return
    //   640: aload_0
    //   641: getfield 71	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giY	Lcom/tencent/mm/plugin/appbrand/jsapi/audio/j;
    //   644: iconst_1
    //   645: invokestatic 613	com/tencent/mm/plugin/appbrand/jsapi/audio/j:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/audio/j;Z)V
    //   648: invokestatic 617	com/tencent/mm/plugin/appbrand/jsapi/audio/j:ahZ	()Ljava/util/Vector;
    //   651: aload_0
    //   652: getfield 311	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:appId	Ljava/lang/String;
    //   655: invokevirtual 622	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   658: ifne -486 -> 172
    //   661: aload_0
    //   662: getfield 311	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:appId	Ljava/lang/String;
    //   665: aload_0
    //   666: getfield 624	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gda	Lcom/tencent/mm/plugin/appbrand/g$b;
    //   669: invokestatic 629	com/tencent/mm/plugin/appbrand/g:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/g$b;)V
    //   672: invokestatic 617	com/tencent/mm/plugin/appbrand/jsapi/audio/j:ahZ	()Ljava/util/Vector;
    //   675: aload_0
    //   676: getfield 311	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:appId	Ljava/lang/String;
    //   679: invokevirtual 632	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   682: pop
    //   683: goto -511 -> 172
    //   686: aload_0
    //   687: getfield 71	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:giY	Lcom/tencent/mm/plugin/appbrand/jsapi/audio/j;
    //   690: iconst_0
    //   691: invokestatic 613	com/tencent/mm/plugin/appbrand/jsapi/audio/j:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/audio/j;Z)V
    //   694: aload_0
    //   695: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   698: iconst_2
    //   699: if_icmpeq +11 -> 710
    //   702: aload_0
    //   703: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:action	I
    //   706: iconst_4
    //   707: if_icmpne -535 -> 172
    //   710: aload_0
    //   711: getfield 311	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:appId	Ljava/lang/String;
    //   714: aload_0
    //   715: getfield 624	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gda	Lcom/tencent/mm/plugin/appbrand/g$b;
    //   718: invokestatic 634	com/tencent/mm/plugin/appbrand/g:b	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/g$b;)V
    //   721: invokestatic 617	com/tencent/mm/plugin/appbrand/jsapi/audio/j:ahZ	()Ljava/util/Vector;
    //   724: aload_0
    //   725: getfield 311	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:appId	Ljava/lang/String;
    //   728: invokevirtual 637	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   731: pop
    //   732: goto -560 -> 172
    //   735: ldc 164
    //   737: ldc_w 639
    //   740: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload_3
    //   744: ldc_w 546
    //   747: ldc 46
    //   749: invokeinterface 536 3 0
    //   754: pop
    //   755: goto -464 -> 291
    //   758: ldc 164
    //   760: ldc_w 641
    //   763: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: aload_3
    //   767: invokevirtual 178	java/io/File:exists	()Z
    //   770: ifeq +11 -> 781
    //   773: aload_3
    //   774: invokevirtual 572	java/io/File:delete	()Z
    //   777: pop
    //   778: goto -260 -> 518
    //   781: ldc 164
    //   783: ldc_w 643
    //   786: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: goto -271 -> 518
    //   792: astore 4
    //   794: ldc 164
    //   796: aload 4
    //   798: ldc 46
    //   800: iconst_0
    //   801: anewarray 168	java/lang/Object
    //   804: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   807: goto -323 -> 484
    //   810: ldc 164
    //   812: ldc_w 643
    //   815: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: goto -322 -> 496
    //   821: astore 7
    //   823: aconst_null
    //   824: astore 6
    //   826: aconst_null
    //   827: astore_3
    //   828: aload 6
    //   830: astore 5
    //   832: aload_3
    //   833: astore 4
    //   835: ldc 164
    //   837: aload 7
    //   839: ldc 46
    //   841: iconst_0
    //   842: anewarray 168	java/lang/Object
    //   845: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   848: aload 6
    //   850: ifnull +8 -> 858
    //   853: aload 6
    //   855: invokevirtual 569	java/io/FileInputStream:close	()V
    //   858: aload_3
    //   859: ifnull +36 -> 895
    //   862: aload_3
    //   863: invokevirtual 178	java/io/File:exists	()Z
    //   866: ifeq +29 -> 895
    //   869: aload_3
    //   870: invokevirtual 572	java/io/File:delete	()Z
    //   873: pop
    //   874: goto -378 -> 496
    //   877: astore 4
    //   879: ldc 164
    //   881: aload 4
    //   883: ldc 46
    //   885: iconst_0
    //   886: anewarray 168	java/lang/Object
    //   889: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   892: goto -34 -> 858
    //   895: ldc 164
    //   897: ldc_w 643
    //   900: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: goto -407 -> 496
    //   906: astore 7
    //   908: aconst_null
    //   909: astore 6
    //   911: aconst_null
    //   912: astore_3
    //   913: aload 6
    //   915: astore 5
    //   917: aload_3
    //   918: astore 4
    //   920: ldc 164
    //   922: aload 7
    //   924: ldc 46
    //   926: iconst_0
    //   927: anewarray 168	java/lang/Object
    //   930: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   933: aload 6
    //   935: ifnull +8 -> 943
    //   938: aload 6
    //   940: invokevirtual 569	java/io/FileInputStream:close	()V
    //   943: aload_3
    //   944: ifnull +36 -> 980
    //   947: aload_3
    //   948: invokevirtual 178	java/io/File:exists	()Z
    //   951: ifeq +29 -> 980
    //   954: aload_3
    //   955: invokevirtual 572	java/io/File:delete	()Z
    //   958: pop
    //   959: goto -463 -> 496
    //   962: astore 4
    //   964: ldc 164
    //   966: aload 4
    //   968: ldc 46
    //   970: iconst_0
    //   971: anewarray 168	java/lang/Object
    //   974: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   977: goto -34 -> 943
    //   980: ldc 164
    //   982: ldc_w 643
    //   985: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   988: goto -492 -> 496
    //   991: astore 6
    //   993: aconst_null
    //   994: astore 5
    //   996: aconst_null
    //   997: astore_3
    //   998: aload 5
    //   1000: ifnull +8 -> 1008
    //   1003: aload 5
    //   1005: invokevirtual 569	java/io/FileInputStream:close	()V
    //   1008: aload_3
    //   1009: ifnull +36 -> 1045
    //   1012: aload_3
    //   1013: invokevirtual 178	java/io/File:exists	()Z
    //   1016: ifeq +29 -> 1045
    //   1019: aload_3
    //   1020: invokevirtual 572	java/io/File:delete	()Z
    //   1023: pop
    //   1024: aload 6
    //   1026: athrow
    //   1027: astore 4
    //   1029: ldc 164
    //   1031: aload 4
    //   1033: ldc 46
    //   1035: iconst_0
    //   1036: anewarray 168	java/lang/Object
    //   1039: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1042: goto -34 -> 1008
    //   1045: ldc 164
    //   1047: ldc_w 643
    //   1050: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1053: goto -29 -> 1024
    //   1056: ldc 164
    //   1058: ldc_w 645
    //   1061: invokestatic 246	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1064: goto -522 -> 542
    //   1067: aload_3
    //   1068: getstatic 648	com/tencent/mm/plugin/appbrand/v/n$b:hlG	Lcom/tencent/mm/plugin/appbrand/v/n$b;
    //   1071: if_acmpne -480 -> 591
    //   1074: aload_0
    //   1075: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/audio/j$b:gfd	Lcom/tencent/mm/plugin/appbrand/o;
    //   1078: ldc_w 650
    //   1081: invokestatic 654	com/tencent/mm/plugin/appbrand/v/n:m	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;Ljava/lang/String;)V
    //   1084: return
    //   1085: astore 6
    //   1087: aconst_null
    //   1088: astore 5
    //   1090: goto -92 -> 998
    //   1093: astore 6
    //   1095: aload 4
    //   1097: astore_3
    //   1098: goto -100 -> 998
    //   1101: astore 7
    //   1103: aconst_null
    //   1104: astore 6
    //   1106: goto -193 -> 913
    //   1109: astore 7
    //   1111: goto -198 -> 913
    //   1114: astore 7
    //   1116: aconst_null
    //   1117: astore 6
    //   1119: goto -291 -> 828
    //   1122: astore 7
    //   1124: goto -296 -> 828
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1127	0	this	b
    //   403	107	1	l	long
    //   187	911	3	localObject1	Object
    //   235	238	4	localObject2	Object
    //   792	5	4	localIOException1	java.io.IOException
    //   833	1	4	localObject3	Object
    //   877	5	4	localIOException2	java.io.IOException
    //   918	1	4	localObject4	Object
    //   962	5	4	localIOException3	java.io.IOException
    //   1027	69	4	localIOException4	java.io.IOException
    //   435	654	5	localFileInputStream1	java.io.FileInputStream
    //   431	508	6	localFileInputStream2	java.io.FileInputStream
    //   991	34	6	localObject5	Object
    //   1085	1	6	localObject6	Object
    //   1093	1	6	localObject7	Object
    //   1104	14	6	localObject8	Object
    //   821	17	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   906	17	7	localIOException5	java.io.IOException
    //   1101	1	7	localIOException6	java.io.IOException
    //   1109	1	7	localIOException7	java.io.IOException
    //   1114	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   1122	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   132	489	8	locala	j.a
    //   355	226	9	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   479	484	792	java/io/IOException
    //   404	416	821	java/io/FileNotFoundException
    //   853	858	877	java/io/IOException
    //   404	416	906	java/io/IOException
    //   938	943	962	java/io/IOException
    //   404	416	991	finally
    //   1003	1008	1027	java/io/IOException
    //   416	433	1085	finally
    //   758	766	1085	finally
    //   440	450	1093	finally
    //   457	467	1093	finally
    //   474	479	1093	finally
    //   835	848	1093	finally
    //   920	933	1093	finally
    //   416	433	1101	java/io/IOException
    //   758	766	1101	java/io/IOException
    //   440	450	1109	java/io/IOException
    //   457	467	1109	java/io/IOException
    //   474	479	1109	java/io/IOException
    //   416	433	1114	java/io/FileNotFoundException
    //   758	766	1114	java/io/FileNotFoundException
    //   440	450	1122	java/io/FileNotFoundException
    //   457	467	1122	java/io/FileNotFoundException
    //   474	479	1122	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j.b
 * JD-Core Version:    0.7.0.1
 */