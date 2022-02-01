package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements i
{
  private static final String[] sMy = { "retCode" };
  private Context context;
  private String[] sMN;
  private int sMO;
  private int sOm;
  private long sOn;
  private long sOo;
  private long sOp;
  com.tencent.mm.pluginsdk.d.a.b sOq;
  private long sOr;
  private boolean sOs;
  private com.qq.wx.voice.embed.recognizer.c sOt;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.sMN = null;
    this.sMO = -1;
    this.sOm = 4;
    this.sOq = new com.tencent.mm.pluginsdk.d.a.b();
    this.sOr = 0L;
    this.sOt = new com.qq.wx.voice.embed.recognizer.c()
    {
      public final void a(com.qq.wx.voice.embed.recognizer.a paramAnonymousa)
      {
        AppMethodBeat.i(24521);
        if (paramAnonymousa == null)
        {
          Log.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
          AppMethodBeat.o(24521);
          return;
        }
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this)), paramAnonymousa.text, paramAnonymousa.name });
        if (!Util.isNullOrNil(paramAnonymousa.name))
        {
          ExtControlProviderVoiceControl.d(ExtControlProviderVoiceControl.this);
          ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, paramAnonymousa.name);
        }
        AppMethodBeat.o(24521);
      }
      
      public final void onGetError(int paramAnonymousInt)
      {
        AppMethodBeat.i(24522);
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(24522);
      }
    };
    this.sMN = paramArrayOfString;
    this.sMO = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(24524);
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24527);
    if (parama == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.sOE == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.sOE.KKt == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new gt();
    Object localObject = parama.sOE;
    ((gt)localObject).KKt.BsG = paramInt1;
    ((gt)localObject).KKt.BsH = paramInt2;
    byte[] arrayOfByte = s.aW(parama.sOD, paramInt1, paramInt2);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.sOB), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.sOD });
      AppMethodBeat.o(24527);
      return false;
    }
    ((gt)localObject).KKz = com.tencent.mm.bw.b.cD(arrayOfByte);
    localObject = new a(parama.sOB, parama.appId, parama.iKP, parama.sOD, (gt)localObject);
    ((a)localObject).bNu = parama.bNu;
    bg.azz().a((q)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  private void arx(final String paramString)
  {
    AppMethodBeat.i(24530);
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(paramString);
    if ((localas == null) || (!com.tencent.mm.contact.c.oR(localas.field_type)))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.sOm = 3505;
      this.sOq.countDown();
      AppMethodBeat.o(24530);
      return;
    }
    com.tencent.mm.compatible.a.a.a(11, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(24523);
        ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this, paramString);
        AppMethodBeat.o(24523);
      }
    });
    this.sOm = 1;
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.sOq.countDown();
    AppMethodBeat.o(24530);
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(24526);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.audio.e.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.audio.e.d.U(paramString2, (String)localObject2))
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        AppMethodBeat.o(24526);
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = (int)s.boW((String)localObject1);
    Object localObject2 = new gv();
    ((gv)localObject2).KKA = 4;
    ((gv)localObject2).KKB = 4;
    ((gv)localObject2).KKC = paramInt3;
    ((gv)localObject2).KKD = paramInt4;
    gu localgu = new gu();
    localgu.BsF = i;
    localgu.BsG = 0;
    if (i <= 16384) {
      localgu.BsH = i;
    }
    for (paramString2 = s.aW((String)localObject1, 0, i);; paramString2 = s.aW((String)localObject1, 0, 16384))
    {
      Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localgu.BsH = 16384;
    }
    gt localgt = new gt();
    localgt.KKy = ((gv)localObject2);
    localgt.KKt = localgu;
    localgt.KKz = com.tencent.mm.bw.b.cD(paramString2);
    paramInt1 = Util.nowMilliSecond().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localgt);
      bg.azz().a(paramString1, 0);
      AppMethodBeat.o(24526);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(24528);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.sOo == 0L) {
      this.sOo = System.currentTimeMillis();
    }
    this.sOp = System.currentTimeMillis();
    gn localgn = new gn();
    localgn.KKm = paramb;
    paramString = new a(paramInt, paramString, localgn, this.sOo);
    bg.azz().a(paramString, 0);
    AppMethodBeat.o(24528);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(24529);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.sOm = 3506;
      this.sOq.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.sOm = 3507;
      this.sOq.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 985)
    {
      if (this.sOs)
      {
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramq;
      paramString = (a)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (paramString = (gp)paramString.rr.iLL.iLR; paramString == null; paramString = null)
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.sOm = 3508;
        this.sOq.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      locala.sOC = paramString.KKm;
      paramInt1 = locala.dJY;
      if (paramString.KKm == null)
      {
        paramq = "null";
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramq });
        if (locala.dJY != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.KKt == null)
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.sOm = 3508;
            this.sOq.countDown();
            AppMethodBeat.o(24529);
            return;
            paramq = new String(paramString.KKm.zy);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.KKr), Integer.valueOf(paramString.KKs), Integer.valueOf(paramString.KKt.BsG), Integer.valueOf(paramString.KKt.BsH) });
          if (paramString.KKt.BsG >= locala.iKP)
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.KKs;
                Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.sOG = i;
                ExtControlProviderVoiceControl.this.a(locala.sOB, locala.appId, locala.sOC);
                AppMethodBeat.o(24518);
              }
            }, paramString.KKr);
            AppMethodBeat.o(24529);
            return;
          }
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.KKt.BsG != 0) && (paramString.KKt.BsG == locala.bNu))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.bNu = paramString.KKt.BsG;
          if (paramString.KKt.BsG + paramString.KKt.BsH < locala.iKP)
          {
            if (!a(locala, paramString.KKt.BsG, paramString.KKt.BsH))
            {
              Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.sOm = 3510;
              this.sOq.countDown();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.KKt.BsG, locala.iKP - paramString.KKt.BsG))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.sOm = 3510;
            this.sOq.countDown();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.dJY == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.sOH;
        if (l1 <= locala.sOG) {
          break label781;
        }
        Log.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.sOG) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.sOm = 3509;
        this.sOq.countDown();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.sOG) });
      }
      label818:
      if (paramString.KKu != null) {
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.KKu.KKn), Integer.valueOf(paramString.KKu.KKv) });
      }
      if ((paramString.KKu == null) || (paramString.KKu.KKv != 0))
      {
        if (System.currentTimeMillis() - this.sOp >= paramString.KKr)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              ExtControlProviderVoiceControl.this.a(locala.sOB, locala.appId, locala.sOC);
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.KKr - (System.currentTimeMillis() - this.sOp);
        l1 = l2;
        if (l2 > paramString.KKr) {
          l1 = paramString.KKr;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            ExtControlProviderVoiceControl.this.a(locala.sOB, locala.appId, locala.sOC);
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.KKu.KKw == null)
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.sOm = 3511;
        this.sOq.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.KKu.KKw.KKx == null) || (paramString.KKu.KKw.KKx.size() <= 0))
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.sOm = 3511;
        this.sOq.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.KKu.KKw.KKx.size() == 0)
      {
        this.sOm = 3511;
        this.sOq.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.KKu.KKw.KKx.size() == 1)
      {
        arx(((gs)paramString.KKu.KKw.KKx.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramq = new String[paramString.KKu.KKw.KKx.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.length)
      {
        paramq[paramInt1] = ((gs)paramString.KKu.KKw.KKx.get(paramInt1)).Username;
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramq[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramq);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.sOB);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.br.c.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.sOm = 1;
      this.sOq.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.sMO) });
    this.sOn = 0L;
    this.sOo = 0L;
    a(paramUri, this.context, this.sMO, this.sMN);
    if (paramUri == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      fP(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (Util.isNullOrNil(this.sMZ))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      fP(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (Util.isNullOrNil(cSt()))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      fP(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = cSu();
    if (i != 1)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fP(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.sMO)
    {
    default: 
      fP(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      fP(3, 3501);
      this.sOm = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3501);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((Util.isNullOrNil(paramUri)) || (Util.isNullOrNil(paramArrayOfString1)) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramArrayOfString2)))
    {
      fP(3, 3502);
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!s.YS(paramArrayOfString2))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      fP(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.sOn = System.currentTimeMillis();
    bg.azz().a(985, this);
    this.sOq.c(13000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24517);
        int i = Util.getInt(paramUri, 4);
        if (i == 1) {
          ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, paramArrayOfString2);
        }
        for (;;)
        {
          if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this), i, Util.getInt(paramArrayOfString1, 4), Util.getInt(paramString1, 16000), Util.getInt(paramString2, 16), paramArrayOfString2))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this);
            ExtControlProviderVoiceControl.this.sOq.countDown();
          }
          AppMethodBeat.o(24517);
          return;
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.sOo - this.sOn), Long.valueOf(System.currentTimeMillis() - this.sOo) });
    bg.azz().b(985, this);
    ac(10, 0, 1);
    if (1 != this.sOm) {
      ac(11, 4, 1);
    }
    for (;;)
    {
      HF(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(this.sOm);
      AppMethodBeat.o(24525);
      return paramUri;
      ac(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */