package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements g
{
  private static final String[] qsY = { "retCode" };
  private Context context;
  private String[] qto;
  private int qtp;
  private int quO;
  private long quP;
  private long quQ;
  private long quR;
  com.tencent.mm.pluginsdk.d.a.b quS;
  private long quT;
  private boolean quU;
  private com.qq.wx.voice.embed.recognizer.c quV;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.qto = null;
    this.qtp = -1;
    this.quO = 4;
    this.quS = new com.tencent.mm.pluginsdk.d.a.b();
    this.quT = 0L;
    this.quV = new com.qq.wx.voice.embed.recognizer.c()
    {
      public final void a(com.qq.wx.voice.embed.recognizer.a paramAnonymousa)
      {
        AppMethodBeat.i(24521);
        if (paramAnonymousa == null)
        {
          ac.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
          AppMethodBeat.o(24521);
          return;
        }
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this)), paramAnonymousa.text, paramAnonymousa.name });
        if (!bs.isNullOrNil(paramAnonymousa.name))
        {
          ExtControlProviderVoiceControl.d(ExtControlProviderVoiceControl.this);
          ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, paramAnonymousa.name);
        }
        AppMethodBeat.o(24521);
      }
      
      public final void onGetError(int paramAnonymousInt)
      {
        AppMethodBeat.i(24522);
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(24522);
      }
    };
    this.qto = paramArrayOfString;
    this.qtp = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(24524);
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24527);
    if (parama == null)
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.qvg == null)
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.qvg.DSV == null)
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new fz();
    Object localObject = parama.qvg;
    ((fz)localObject).DSV.vTI = paramInt1;
    ((fz)localObject).DSV.vTJ = paramInt2;
    byte[] arrayOfByte = i.aU(parama.qvf, paramInt1, paramInt2);
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.qvd), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.qvf });
      AppMethodBeat.o(24527);
      return false;
    }
    ((fz)localObject).DTb = com.tencent.mm.bw.b.cc(arrayOfByte);
    localObject = new a(parama.qvd, parama.appId, parama.hux, parama.qvf, (fz)localObject);
    ((a)localObject).cUq = parama.cUq;
    az.agi().a((n)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  private void acc(final String paramString)
  {
    AppMethodBeat.i(24530);
    az.ayM();
    ai localai = com.tencent.mm.model.c.awB().aNt(paramString);
    if ((localai == null) || (!com.tencent.mm.n.b.ln(localai.field_type)))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.quO = 3505;
      this.quS.countDown();
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
    this.quO = 1;
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.quS.countDown();
    AppMethodBeat.o(24530);
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(24526);
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.audio.e.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.audio.e.d.R(paramString2, (String)localObject2))
      {
        ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        AppMethodBeat.o(24526);
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = (int)i.aSp((String)localObject1);
    Object localObject2 = new gb();
    ((gb)localObject2).DTc = 4;
    ((gb)localObject2).DTd = 4;
    ((gb)localObject2).DTe = paramInt3;
    ((gb)localObject2).DTf = paramInt4;
    ga localga = new ga();
    localga.vTH = i;
    localga.vTI = 0;
    if (i <= 16384) {
      localga.vTJ = i;
    }
    for (paramString2 = i.aU((String)localObject1, 0, i);; paramString2 = i.aU((String)localObject1, 0, 16384))
    {
      ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localga.vTJ = 16384;
    }
    fz localfz = new fz();
    localfz.DTa = ((gb)localObject2);
    localfz.DSV = localga;
    localfz.DTb = com.tencent.mm.bw.b.cc(paramString2);
    paramInt1 = bs.eWj().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localfz);
      az.agi().a(paramString1, 0);
      AppMethodBeat.o(24526);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(24528);
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.quQ == 0L) {
      this.quQ = System.currentTimeMillis();
    }
    this.quR = System.currentTimeMillis();
    ft localft = new ft();
    localft.DSO = paramb;
    paramString = new a(paramInt, paramString, localft, this.quQ);
    az.agi().a(paramString, 0);
    AppMethodBeat.o(24528);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(24529);
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.quO = 3506;
      this.quS.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.quO = 3507;
      this.quS.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 985)
    {
      if (this.quU)
      {
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramn;
      paramString = (a)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (fv)paramString.rr.hvs.hvw; paramString == null; paramString = null)
      {
        ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.quO = 3508;
        this.quS.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      locala.qve = paramString.DSO;
      paramInt1 = locala.dgm;
      if (paramString.DSO == null)
      {
        paramn = "null";
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramn });
        if (locala.dgm != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.DSV == null)
          {
            ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.quO = 3508;
            this.quS.countDown();
            AppMethodBeat.o(24529);
            return;
            paramn = new String(paramString.DSO.xy);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.DST), Integer.valueOf(paramString.DSU), Integer.valueOf(paramString.DSV.vTI), Integer.valueOf(paramString.DSV.vTJ) });
          if (paramString.DSV.vTI >= locala.hux)
          {
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.DSU;
                ac.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.qvi = i;
                ExtControlProviderVoiceControl.this.a(locala.qvd, locala.appId, locala.qve);
                AppMethodBeat.o(24518);
              }
            }, paramString.DST);
            AppMethodBeat.o(24529);
            return;
          }
          ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.DSV.vTI != 0) && (paramString.DSV.vTI == locala.cUq))
          {
            ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.cUq = paramString.DSV.vTI;
          if (paramString.DSV.vTI + paramString.DSV.vTJ < locala.hux)
          {
            if (!a(locala, paramString.DSV.vTI, paramString.DSV.vTJ))
            {
              ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.quO = 3510;
              this.quS.countDown();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.DSV.vTI, locala.hux - paramString.DSV.vTI))
          {
            ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.quO = 3510;
            this.quS.countDown();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.dgm == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.qvj;
        if (l1 <= locala.qvi) {
          break label781;
        }
        ac.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.qvi) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.quO = 3509;
        this.quS.countDown();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        ac.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.qvi) });
      }
      label818:
      if (paramString.DSW != null) {
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.DSW.DSP), Integer.valueOf(paramString.DSW.DSX) });
      }
      if ((paramString.DSW == null) || (paramString.DSW.DSX != 0))
      {
        if (System.currentTimeMillis() - this.quR >= paramString.DST)
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              ExtControlProviderVoiceControl.this.a(locala.qvd, locala.appId, locala.qve);
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.DST - (System.currentTimeMillis() - this.quR);
        l1 = l2;
        if (l2 > paramString.DST) {
          l1 = paramString.DST;
        }
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            ExtControlProviderVoiceControl.this.a(locala.qvd, locala.appId, locala.qve);
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.DSW.DSY == null)
      {
        ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.quO = 3511;
        this.quS.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.DSW.DSY.DSZ == null) || (paramString.DSW.DSY.DSZ.size() <= 0))
      {
        ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.quO = 3511;
        this.quS.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.DSW.DSY.DSZ.size() == 0)
      {
        this.quO = 3511;
        this.quS.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.DSW.DSY.DSZ.size() == 1)
      {
        acc(((fy)paramString.DSW.DSY.DSZ.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramn = new String[paramString.DSW.DSY.DSZ.size()];
      paramInt1 = 0;
      while (paramInt1 < paramn.length)
      {
        paramn[paramInt1] = ((fy)paramString.DSW.DSY.DSZ.get(paramInt1)).Username;
        ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramn[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramn);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.qvd);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.br.d.e(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.quO = 1;
      this.quS.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.qtp) });
    this.quP = 0L;
    this.quQ = 0L;
    a(paramUri, this.context, this.qtp, this.qto);
    if (paramUri == null)
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      ft(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (bs.isNullOrNil(this.qtA))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      ft(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (bs.isNullOrNil(cmE()))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      ft(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = cmF();
    if (i != 1)
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      ft(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.qtp)
    {
    default: 
      ft(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      ft(3, 3501);
      this.quO = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3501);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((bs.isNullOrNil(paramUri)) || (bs.isNullOrNil(paramArrayOfString1)) || (bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramArrayOfString2)))
    {
      ft(3, 3502);
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!i.eA(paramArrayOfString2))
    {
      ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      ft(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.quP = System.currentTimeMillis();
    az.agi().a(985, this);
    this.quS.c(13000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24517);
        int i = bs.getInt(paramUri, 4);
        if (i == 1) {
          ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, paramArrayOfString2);
        }
        for (;;)
        {
          if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this), i, bs.getInt(paramArrayOfString1, 4), bs.getInt(paramString1, 16000), bs.getInt(paramString2, 16), paramArrayOfString2))
          {
            ac.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this);
            ExtControlProviderVoiceControl.this.quS.countDown();
          }
          AppMethodBeat.o(24517);
          return;
          ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    ac.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.quQ - this.quP), Long.valueOf(System.currentTimeMillis() - this.quQ) });
    az.agi().b(985, this);
    Z(10, 0, 1);
    if (1 != this.quO) {
      Z(11, 4, 1);
    }
    for (;;)
    {
      CN(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(this.quO);
      AppMethodBeat.o(24525);
      return paramUri;
      Z(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */