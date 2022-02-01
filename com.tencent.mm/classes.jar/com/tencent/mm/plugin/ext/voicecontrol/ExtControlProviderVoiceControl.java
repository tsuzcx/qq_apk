package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements h
{
  private static final String[] zOz = { "retCode" };
  private Context context;
  private String[] zOO;
  private int zOP;
  private int zQn;
  private long zQo;
  private long zQp;
  private long zQq;
  com.tencent.mm.pluginsdk.d.a.b zQr;
  private long zQs;
  private boolean zQt;
  private com.qq.wx.voice.embed.recognizer.c zQu;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.zOO = null;
    this.zOP = -1;
    this.zQn = 4;
    this.zQr = new com.tencent.mm.pluginsdk.d.a.b();
    this.zQs = 0L;
    this.zQu = new com.qq.wx.voice.embed.recognizer.c()
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
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this)), paramAnonymousa.text, paramAnonymousa.name });
        if (!Util.isNullOrNil(paramAnonymousa.name))
        {
          ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this);
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
    this.zOO = paramArrayOfString;
    this.zOP = paramInt;
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
    if (parama.zQF == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.zQF.YIx == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new ha();
    Object localObject = parama.zQF;
    ((ha)localObject).YIx.NkO = paramInt1;
    ((ha)localObject).YIx.NkP = paramInt2;
    byte[] arrayOfByte = y.bi(parama.zQE, paramInt1, paramInt2);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.zQC), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.zQE });
      AppMethodBeat.o(24527);
      return false;
    }
    ((ha)localObject).YID = com.tencent.mm.bx.b.cX(arrayOfByte);
    localObject = new a(parama.zQC, parama.appId, parama.osy, parama.zQE, (ha)localObject);
    ((a)localObject).dIY = parama.dIY;
    bh.aZW().a((p)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  private void atF(final String paramString)
  {
    AppMethodBeat.i(24530);
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(paramString);
    if ((localau == null) || (!com.tencent.mm.contact.d.rs(localau.field_type)))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.zQn = 3505;
      this.zQr.asP();
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
    this.zQn = 1;
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.zQr.asP();
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
      if (!com.tencent.mm.audio.e.d.ae(paramString2, (String)localObject2))
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
    int i = (int)y.bEl((String)localObject1);
    Object localObject2 = new hc();
    ((hc)localObject2).YIE = 4;
    ((hc)localObject2).YIF = 4;
    ((hc)localObject2).YIG = paramInt3;
    ((hc)localObject2).YIH = paramInt4;
    hb localhb = new hb();
    localhb.NkN = i;
    localhb.NkO = 0;
    if (i <= 16384) {
      localhb.NkP = i;
    }
    for (paramString2 = y.bi((String)localObject1, 0, i);; paramString2 = y.bi((String)localObject1, 0, 16384))
    {
      Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localhb.NkP = 16384;
    }
    ha localha = new ha();
    localha.YIC = ((hc)localObject2);
    localha.YIx = localhb;
    localha.YID = com.tencent.mm.bx.b.cX(paramString2);
    paramString1 = new a(a.dOt(), paramString1, i, (String)localObject1, localha);
    bh.aZW().a(paramString1, 0);
    AppMethodBeat.o(24526);
    return true;
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(24528);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.zQp == 0L) {
      this.zQp = System.currentTimeMillis();
    }
    this.zQq = System.currentTimeMillis();
    gu localgu = new gu();
    localgu.YIp = paramb;
    paramString = new a(paramInt, paramString, localgu, this.zQp);
    bh.aZW().a(paramString, 0);
    AppMethodBeat.o(24528);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(24529);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.zQn = 3506;
      this.zQr.asP();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.zQn = 3507;
      this.zQr.asP();
      AppMethodBeat.o(24529);
      return;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 985)
    {
      if (this.zQt)
      {
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramp;
      paramString = (a)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (gw)c.c.b(paramString.rr.otC); paramString == null; paramString = null)
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.zQn = 3508;
        this.zQr.asP();
        AppMethodBeat.o(24529);
        return;
      }
      locala.zQD = paramString.YIp;
      paramInt1 = locala.hHC;
      if (paramString.YIp == null)
      {
        paramp = "null";
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramp });
        if (locala.hHC != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.YIx == null)
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.zQn = 3508;
            this.zQr.asP();
            AppMethodBeat.o(24529);
            return;
            paramp = new String(paramString.YIp.Op);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.YIv), Integer.valueOf(paramString.YIw), Integer.valueOf(paramString.YIx.NkO), Integer.valueOf(paramString.YIx.NkP) });
          if (paramString.YIx.NkO >= locala.osy)
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.YIw;
                Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.zQH = i;
                if (!ExtControlProviderVoiceControl.this.a(locala.zQC, locala.appId, locala.zQD))
                {
                  Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult fail, countDown");
                  ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, 3509);
                  ExtControlProviderVoiceControl.this.zQr.asP();
                  AppMethodBeat.o(24518);
                  return;
                }
                AppMethodBeat.o(24518);
              }
            }, paramString.YIv);
            AppMethodBeat.o(24529);
            return;
          }
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.YIx.NkO != 0) && (paramString.YIx.NkO == locala.dIY))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.dIY = paramString.YIx.NkO;
          if (paramString.YIx.NkO + paramString.YIx.NkP < locala.osy)
          {
            if (!a(locala, paramString.YIx.NkO, paramString.YIx.NkP))
            {
              Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.zQn = 3510;
              this.zQr.asP();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.YIx.NkO, locala.osy - paramString.YIx.NkO))
          {
            Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.zQn = 3510;
            this.zQr.asP();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.hHC == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.zQI;
        if (l1 <= locala.zQH) {
          break label781;
        }
        Log.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.zQH) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.zQn = 3509;
        this.zQr.asP();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.zQH) });
      }
      label818:
      if (paramString.YIy != null) {
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.YIy.YIr), Integer.valueOf(paramString.YIy.YIz) });
      }
      if ((paramString.YIy == null) || (paramString.YIy.YIz != 0))
      {
        if (System.currentTimeMillis() - this.zQq >= paramString.YIv)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              if (!ExtControlProviderVoiceControl.this.a(locala.zQC, locala.appId, locala.zQD))
              {
                Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult fail, countDown");
                ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, 3509);
                ExtControlProviderVoiceControl.this.zQr.asP();
                AppMethodBeat.o(24519);
                return;
              }
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.YIv - (System.currentTimeMillis() - this.zQq);
        l1 = l2;
        if (l2 > paramString.YIv) {
          l1 = paramString.YIv;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            if (!ExtControlProviderVoiceControl.this.a(locala.zQC, locala.appId, locala.zQD))
            {
              Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult fail, countDown");
              ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, 3509);
              ExtControlProviderVoiceControl.this.zQr.asP();
              AppMethodBeat.o(24520);
              return;
            }
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.YIy.YIA == null)
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.zQn = 3511;
        this.zQr.asP();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.YIy.YIA.YIB == null) || (paramString.YIy.YIA.YIB.size() <= 0))
      {
        Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.zQn = 3511;
        this.zQr.asP();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.YIy.YIA.YIB.size() == 0)
      {
        this.zQn = 3511;
        this.zQr.asP();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.YIy.YIA.YIB.size() == 1)
      {
        atF(((gz)paramString.YIy.YIA.YIB.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramp = new String[paramString.YIy.YIA.YIB.size()];
      paramInt1 = 0;
      while (paramInt1 < paramp.length)
      {
        paramp[paramInt1] = ((gz)paramString.YIy.YIA.YIB.get(paramInt1)).Username;
        Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramp[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramp);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.zQC);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.br.c.g(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.zQn = 1;
      this.zQr.asP();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.zOP) });
    this.zQo = 0L;
    this.zQp = 0L;
    a(paramUri, this.context, this.zOP, this.zOO);
    if (paramUri == null)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      hf(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (Util.isNullOrNil(this.zPa))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      hf(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (Util.isNullOrNil(dOe()))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      hf(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = dOf();
    if (i != 1)
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      hf(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.zOP)
    {
    default: 
      hf(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      hf(3, 3501);
      this.zQn = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(3501);
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
      hf(3, 3502);
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!y.ZC(paramArrayOfString2))
    {
      Log.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      hf(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.zQo = System.currentTimeMillis();
    bh.aZW().a(985, this);
    this.zQr.c(13000L, new Runnable()
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
            ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, 3504);
            ExtControlProviderVoiceControl.this.zQr.asP();
          }
          AppMethodBeat.o(24517);
          return;
          Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    Log.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.zQp - this.zQo), Long.valueOf(System.currentTimeMillis() - this.zQp) });
    bh.aZW().b(985, this);
    au(10, 0, 1);
    if (1 != this.zQn) {
      au(11, 4, 1);
    }
    for (;;)
    {
      Mm(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(this.zQn);
      AppMethodBeat.o(24525);
      return paramUri;
      au(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */