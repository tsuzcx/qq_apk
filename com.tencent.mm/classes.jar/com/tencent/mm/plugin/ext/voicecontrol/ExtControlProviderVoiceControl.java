package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements i
{
  private static final String[] wst = { "retCode" };
  private Context context;
  private String[] wsI;
  private int wsJ;
  private int wuh;
  private long wui;
  private long wuj;
  private long wuk;
  com.tencent.mm.pluginsdk.e.a.b wul;
  private long wum;
  private boolean wun;
  private com.qq.wx.voice.embed.recognizer.c wuo;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.wsI = null;
    this.wsJ = -1;
    this.wuh = 4;
    this.wul = new com.tencent.mm.pluginsdk.e.a.b();
    this.wum = 0L;
    this.wuo = new com.qq.wx.voice.embed.recognizer.c()
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
    this.wsI = paramArrayOfString;
    this.wsJ = paramInt;
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
    if (parama.wuz == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.wuz.RLl == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new gh();
    Object localObject = parama.wuz;
    ((gh)localObject).RLl.Hna = paramInt1;
    ((gh)localObject).RLl.Hnb = paramInt2;
    byte[] arrayOfByte = u.aY(parama.wuy, paramInt1, paramInt2);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.wuw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.wuy });
      AppMethodBeat.o(24527);
      return false;
    }
    ((gh)localObject).RLr = com.tencent.mm.cd.b.cU(arrayOfByte);
    localObject = new a(parama.wuw, parama.appId, parama.lAW, parama.wuy, (gh)localObject);
    ((a)localObject).bPt = parama.bPt;
    bh.aGY().a((q)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  private void azy(final String paramString)
  {
    AppMethodBeat.i(24530);
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(paramString);
    if ((localas == null) || (!com.tencent.mm.contact.d.rk(localas.field_type)))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.wuh = 3505;
      this.wul.Sz();
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
    this.wuh = 1;
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.wul.Sz();
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
      if (!com.tencent.mm.audio.e.d.Z(paramString2, (String)localObject2))
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
    int i = (int)u.bBQ((String)localObject1);
    Object localObject2 = new gj();
    ((gj)localObject2).RLs = 4;
    ((gj)localObject2).RLt = 4;
    ((gj)localObject2).RLu = paramInt3;
    ((gj)localObject2).RLv = paramInt4;
    gi localgi = new gi();
    localgi.HmZ = i;
    localgi.Hna = 0;
    if (i <= 16384) {
      localgi.Hnb = i;
    }
    for (paramString2 = u.aY((String)localObject1, 0, i);; paramString2 = u.aY((String)localObject1, 0, 16384))
    {
      Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localgi.Hnb = 16384;
    }
    gh localgh = new gh();
    localgh.RLq = ((gj)localObject2);
    localgh.RLl = localgi;
    localgh.RLr = com.tencent.mm.cd.b.cU(paramString2);
    paramString1 = new a(a.dhI(), paramString1, i, (String)localObject1, localgh);
    bh.aGY().a(paramString1, 0);
    AppMethodBeat.o(24526);
    return true;
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(24528);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.wuj == 0L) {
      this.wuj = System.currentTimeMillis();
    }
    this.wuk = System.currentTimeMillis();
    gb localgb = new gb();
    localgb.RLd = paramb;
    paramString = new a(paramInt, paramString, localgb, this.wuj);
    bh.aGY().a(paramString, 0);
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
      this.wuh = 3506;
      this.wul.Sz();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.wuh = 3507;
      this.wul.Sz();
      AppMethodBeat.o(24529);
      return;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 985)
    {
      if (this.wun)
      {
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramq;
      paramString = (a)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (paramString = (gd)d.c.b(paramString.rr.lBS); paramString == null; paramString = null)
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.wuh = 3508;
        this.wul.Sz();
        AppMethodBeat.o(24529);
        return;
      }
      locala.wux = paramString.RLd;
      paramInt1 = locala.fCN;
      if (paramString.RLd == null)
      {
        paramq = "null";
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramq });
        if (locala.fCN != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.RLl == null)
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.wuh = 3508;
            this.wul.Sz();
            AppMethodBeat.o(24529);
            return;
            paramq = new String(paramString.RLd.UH);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.RLj), Integer.valueOf(paramString.RLk), Integer.valueOf(paramString.RLl.Hna), Integer.valueOf(paramString.RLl.Hnb) });
          if (paramString.RLl.Hna >= locala.lAW)
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.RLk;
                Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.wuB = i;
                ExtControlProviderVoiceControl.this.a(locala.wuw, locala.appId, locala.wux);
                AppMethodBeat.o(24518);
              }
            }, paramString.RLj);
            AppMethodBeat.o(24529);
            return;
          }
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.RLl.Hna != 0) && (paramString.RLl.Hna == locala.bPt))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.bPt = paramString.RLl.Hna;
          if (paramString.RLl.Hna + paramString.RLl.Hnb < locala.lAW)
          {
            if (!a(locala, paramString.RLl.Hna, paramString.RLl.Hnb))
            {
              Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.wuh = 3510;
              this.wul.Sz();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.RLl.Hna, locala.lAW - paramString.RLl.Hna))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.wuh = 3510;
            this.wul.Sz();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.fCN == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.wuC;
        if (l1 <= locala.wuB) {
          break label781;
        }
        Log.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.wuB) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.wuh = 3509;
        this.wul.Sz();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.wuB) });
      }
      label818:
      if (paramString.RLm != null) {
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.RLm.RLf), Integer.valueOf(paramString.RLm.RLn) });
      }
      if ((paramString.RLm == null) || (paramString.RLm.RLn != 0))
      {
        if (System.currentTimeMillis() - this.wuk >= paramString.RLj)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              ExtControlProviderVoiceControl.this.a(locala.wuw, locala.appId, locala.wux);
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.RLj - (System.currentTimeMillis() - this.wuk);
        l1 = l2;
        if (l2 > paramString.RLj) {
          l1 = paramString.RLj;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            ExtControlProviderVoiceControl.this.a(locala.wuw, locala.appId, locala.wux);
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.RLm.RLo == null)
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.wuh = 3511;
        this.wul.Sz();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.RLm.RLo.RLp == null) || (paramString.RLm.RLo.RLp.size() <= 0))
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.wuh = 3511;
        this.wul.Sz();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.RLm.RLo.RLp.size() == 0)
      {
        this.wuh = 3511;
        this.wul.Sz();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.RLm.RLo.RLp.size() == 1)
      {
        azy(((gg)paramString.RLm.RLo.RLp.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramq = new String[paramString.RLm.RLo.RLp.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.length)
      {
        paramq[paramInt1] = ((gg)paramString.RLm.RLo.RLp.get(paramInt1)).Username;
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramq[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramq);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.wuw);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.by.c.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.wuh = 1;
      this.wul.Sz();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.wsJ) });
    this.wui = 0L;
    this.wuj = 0L;
    a(paramUri, this.context, this.wsJ, this.wsI);
    if (paramUri == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      gm(3, 5);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (Util.isNullOrNil(this.wsU))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      gm(3, 7);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (Util.isNullOrNil(dht()))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      gm(3, 6);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = dhu();
    if (i != 1)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      gm(2, i);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.wsJ)
    {
    default: 
      gm(3, 15);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      gm(3, 3501);
      this.wuh = 3501;
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(3501);
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
      gm(3, 3502);
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!u.agG(paramArrayOfString2))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      gm(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.wui = System.currentTimeMillis();
    bh.aGY().a(985, this);
    this.wul.c(13000L, new Runnable()
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
            ExtControlProviderVoiceControl.this.wul.Sz();
          }
          AppMethodBeat.o(24517);
          return;
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.wuj - this.wui), Long.valueOf(System.currentTimeMillis() - this.wuj) });
    bh.aGY().b(985, this);
    ad(10, 0, 1);
    if (1 != this.wuh) {
      ad(11, 4, 1);
    }
    for (;;)
    {
      Lp(0);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(this.wuh);
      AppMethodBeat.o(24525);
      return paramUri;
      ad(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */