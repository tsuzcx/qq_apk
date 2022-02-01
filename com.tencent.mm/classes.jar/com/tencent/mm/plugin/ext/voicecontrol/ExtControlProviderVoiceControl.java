package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements g
{
  private static final String[] pKr = { "retCode" };
  private Context context;
  private String[] pKH;
  private int pKI;
  private int pMg;
  private long pMh;
  private long pMi;
  private long pMj;
  com.tencent.mm.pluginsdk.d.a.b pMk;
  private long pMl;
  private boolean pMm;
  private com.qq.wx.voice.embed.recognizer.c pMn;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.pKH = null;
    this.pKI = -1;
    this.pMg = 4;
    this.pMk = new com.tencent.mm.pluginsdk.d.a.b();
    this.pMl = 0L;
    this.pMn = new com.qq.wx.voice.embed.recognizer.c()
    {
      public final void a(com.qq.wx.voice.embed.recognizer.a paramAnonymousa)
      {
        AppMethodBeat.i(24521);
        if (paramAnonymousa == null)
        {
          ad.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
          AppMethodBeat.o(24521);
          return;
        }
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this)), paramAnonymousa.text, paramAnonymousa.name });
        if (!bt.isNullOrNil(paramAnonymousa.name))
        {
          ExtControlProviderVoiceControl.d(ExtControlProviderVoiceControl.this);
          ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, paramAnonymousa.name);
        }
        AppMethodBeat.o(24521);
      }
      
      public final void gp(int paramAnonymousInt)
      {
        AppMethodBeat.i(24522);
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(24522);
      }
    };
    this.pKH = paramArrayOfString;
    this.pKI = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(24524);
  }
  
  private void XF(final String paramString)
  {
    AppMethodBeat.i(24530);
    az.arV();
    af localaf = com.tencent.mm.model.c.apM().aHY(paramString);
    if ((localaf == null) || (!com.tencent.mm.n.b.ls(localaf.field_type)))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.pMg = 3505;
      this.pMk.countDown();
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
    this.pMg = 1;
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.pMk.countDown();
    AppMethodBeat.o(24530);
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24527);
    if (parama == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.pMy == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.pMy.CAz == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new fx();
    Object localObject = parama.pMy;
    ((fx)localObject).CAz.uKR = paramInt1;
    ((fx)localObject).CAz.uKS = paramInt2;
    byte[] arrayOfByte = i.aR(parama.pMx, paramInt1, paramInt2);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.pMv), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.pMx });
      AppMethodBeat.o(24527);
      return false;
    }
    ((fx)localObject).CAF = com.tencent.mm.bx.b.cd(arrayOfByte);
    localObject = new a(parama.pMv, parama.appId, parama.gTY, parama.pMx, (fx)localObject);
    ((a)localObject).cWU = parama.cWU;
    az.aeS().a((n)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(24526);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.audio.e.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.audio.e.d.Q(paramString2, (String)localObject2))
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        AppMethodBeat.o(24526);
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = (int)i.aMN((String)localObject1);
    Object localObject2 = new fz();
    ((fz)localObject2).CAG = 4;
    ((fz)localObject2).CAH = 4;
    ((fz)localObject2).CAI = paramInt3;
    ((fz)localObject2).CAJ = paramInt4;
    fy localfy = new fy();
    localfy.uKQ = i;
    localfy.uKR = 0;
    if (i <= 16384) {
      localfy.uKS = i;
    }
    for (paramString2 = i.aR((String)localObject1, 0, i);; paramString2 = i.aR((String)localObject1, 0, 16384))
    {
      ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localfy.uKS = 16384;
    }
    fx localfx = new fx();
    localfx.CAE = ((fz)localObject2);
    localfx.CAz = localfy;
    localfx.CAF = com.tencent.mm.bx.b.cd(paramString2);
    paramInt1 = bt.eGO().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localfx);
      az.aeS().a(paramString1, 0);
      AppMethodBeat.o(24526);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(24528);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.pMi == 0L) {
      this.pMi = System.currentTimeMillis();
    }
    this.pMj = System.currentTimeMillis();
    fr localfr = new fr();
    localfr.CAs = paramb;
    paramString = new a(paramInt, paramString, localfr, this.pMi);
    az.aeS().a(paramString, 0);
    AppMethodBeat.o(24528);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(24529);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.pMg = 3506;
      this.pMk.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.pMg = 3507;
      this.pMk.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 985)
    {
      if (this.pMm)
      {
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramn;
      paramString = (a)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (paramString = (ft)paramString.rr.gUT.gUX; paramString == null; paramString = null)
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.pMg = 3508;
        this.pMk.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      locala.pMw = paramString.CAs;
      paramInt1 = locala.diR;
      if (paramString.CAs == null)
      {
        paramn = "null";
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramn });
        if (locala.diR != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.CAz == null)
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.pMg = 3508;
            this.pMk.countDown();
            AppMethodBeat.o(24529);
            return;
            paramn = new String(paramString.CAs.wA);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.CAx), Integer.valueOf(paramString.CAy), Integer.valueOf(paramString.CAz.uKR), Integer.valueOf(paramString.CAz.uKS) });
          if (paramString.CAz.uKR >= locala.gTY)
          {
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.CAy;
                ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.pMA = i;
                ExtControlProviderVoiceControl.this.a(locala.pMv, locala.appId, locala.pMw);
                AppMethodBeat.o(24518);
              }
            }, paramString.CAx);
            AppMethodBeat.o(24529);
            return;
          }
          ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.CAz.uKR != 0) && (paramString.CAz.uKR == locala.cWU))
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.cWU = paramString.CAz.uKR;
          if (paramString.CAz.uKR + paramString.CAz.uKS < locala.gTY)
          {
            if (!a(locala, paramString.CAz.uKR, paramString.CAz.uKS))
            {
              ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.pMg = 3510;
              this.pMk.countDown();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.CAz.uKR, locala.gTY - paramString.CAz.uKR))
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.pMg = 3510;
            this.pMk.countDown();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.diR == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.pMB;
        if (l1 <= locala.pMA) {
          break label781;
        }
        ad.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.pMA) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.pMg = 3509;
        this.pMk.countDown();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.pMA) });
      }
      label818:
      if (paramString.CAA != null) {
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.CAA.CAt), Integer.valueOf(paramString.CAA.CAB) });
      }
      if ((paramString.CAA == null) || (paramString.CAA.CAB != 0))
      {
        if (System.currentTimeMillis() - this.pMj >= paramString.CAx)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              ExtControlProviderVoiceControl.this.a(locala.pMv, locala.appId, locala.pMw);
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.CAx - (System.currentTimeMillis() - this.pMj);
        l1 = l2;
        if (l2 > paramString.CAx) {
          l1 = paramString.CAx;
        }
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            ExtControlProviderVoiceControl.this.a(locala.pMv, locala.appId, locala.pMw);
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.CAA.CAC == null)
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.pMg = 3511;
        this.pMk.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.CAA.CAC.CAD == null) || (paramString.CAA.CAC.CAD.size() <= 0))
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.pMg = 3511;
        this.pMk.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.CAA.CAC.CAD.size() == 0)
      {
        this.pMg = 3511;
        this.pMk.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.CAA.CAC.CAD.size() == 1)
      {
        XF(((fw)paramString.CAA.CAC.CAD.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramn = new String[paramString.CAA.CAC.CAD.size()];
      paramInt1 = 0;
      while (paramInt1 < paramn.length)
      {
        paramn[paramInt1] = ((fw)paramString.CAA.CAC.CAD.get(paramInt1)).Username;
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramn[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramn);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.pMv);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.bs.d.e(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.pMg = 1;
      this.pMk.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.pKI) });
    this.pMh = 0L;
    this.pMi = 0L;
    a(paramUri, this.context, this.pKI, this.pKH);
    if (paramUri == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      fq(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (bt.isNullOrNil(this.pKT))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      fq(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (bt.isNullOrNil(ceX()))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      fq(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = ceY();
    if (i != 1)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fq(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.pKI)
    {
    default: 
      fq(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      fq(3, 3501);
      this.pMg = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3501);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((bt.isNullOrNil(paramUri)) || (bt.isNullOrNil(paramArrayOfString1)) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramArrayOfString2)))
    {
      fq(3, 3502);
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!i.eK(paramArrayOfString2))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      fq(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.pMh = System.currentTimeMillis();
    az.aeS().a(985, this);
    this.pMk.b(13000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24517);
        int i = bt.getInt(paramUri, 4);
        if (i == 1) {
          ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, paramArrayOfString2);
        }
        for (;;)
        {
          if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this), i, bt.getInt(paramArrayOfString1, 4), bt.getInt(paramString1, 16000), bt.getInt(paramString2, 16), paramArrayOfString2))
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this);
            ExtControlProviderVoiceControl.this.pMk.countDown();
          }
          AppMethodBeat.o(24517);
          return;
          ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.pMi - this.pMh), Long.valueOf(System.currentTimeMillis() - this.pMi) });
    az.aeS().b(985, this);
    Y(10, 0, 1);
    if (1 != this.pMg) {
      Y(11, 4, 1);
    }
    for (;;)
    {
      BS(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(this.pMg);
      AppMethodBeat.o(24525);
      return paramUri;
      Y(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */