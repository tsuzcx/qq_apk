package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements f
{
  private static final String[] rkS = { "retCode" };
  private Context context;
  private String[] rli;
  private int rlj;
  private int rmH;
  private long rmI;
  private long rmJ;
  private long rmK;
  com.tencent.mm.pluginsdk.d.a.b rmL;
  private long rmM;
  private boolean rmN;
  private com.qq.wx.voice.embed.recognizer.c rmO;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.rli = null;
    this.rlj = -1;
    this.rmH = 4;
    this.rmL = new com.tencent.mm.pluginsdk.d.a.b();
    this.rmM = 0L;
    this.rmO = new com.qq.wx.voice.embed.recognizer.c()
    {
      public final void a(com.qq.wx.voice.embed.recognizer.a paramAnonymousa)
      {
        AppMethodBeat.i(24521);
        if (paramAnonymousa == null)
        {
          ae.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
          AppMethodBeat.o(24521);
          return;
        }
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this)), paramAnonymousa.text, paramAnonymousa.name });
        if (!bu.isNullOrNil(paramAnonymousa.name))
        {
          ExtControlProviderVoiceControl.d(ExtControlProviderVoiceControl.this);
          ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, paramAnonymousa.name);
        }
        AppMethodBeat.o(24521);
      }
      
      public final void onGetError(int paramAnonymousInt)
      {
        AppMethodBeat.i(24522);
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(24522);
      }
    };
    this.rli = paramArrayOfString;
    this.rlj = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(24524);
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24527);
    if (parama == null)
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.rmZ == null)
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.rmZ.FQM == null)
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new gg();
    Object localObject = parama.rmZ;
    ((gg)localObject).FQM.xsC = paramInt1;
    ((gg)localObject).FQM.xsD = paramInt2;
    byte[] arrayOfByte = o.bb(parama.rmY, paramInt1, paramInt2);
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.rmW), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.rmY });
      AppMethodBeat.o(24527);
      return false;
    }
    ((gg)localObject).FQS = com.tencent.mm.bw.b.cm(arrayOfByte);
    localObject = new a(parama.rmW, parama.appId, parama.hPI, parama.rmY, (gg)localObject);
    ((a)localObject).dgI = parama.dgI;
    bc.ajj().a((n)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  private void agN(final String paramString)
  {
    AppMethodBeat.i(24530);
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramString);
    if ((localan == null) || (!com.tencent.mm.contact.c.lO(localan.field_type)))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.rmH = 3505;
      this.rmL.countDown();
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
    this.rmH = 1;
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.rmL.countDown();
    AppMethodBeat.o(24530);
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(24526);
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.audio.e.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.audio.e.d.S(paramString2, (String)localObject2))
      {
        ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        AppMethodBeat.o(24526);
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = (int)o.aZR((String)localObject1);
    Object localObject2 = new gi();
    ((gi)localObject2).FQT = 4;
    ((gi)localObject2).FQU = 4;
    ((gi)localObject2).FQV = paramInt3;
    ((gi)localObject2).FQW = paramInt4;
    gh localgh = new gh();
    localgh.xsB = i;
    localgh.xsC = 0;
    if (i <= 16384) {
      localgh.xsD = i;
    }
    for (paramString2 = o.bb((String)localObject1, 0, i);; paramString2 = o.bb((String)localObject1, 0, 16384))
    {
      ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localgh.xsD = 16384;
    }
    gg localgg = new gg();
    localgg.FQR = ((gi)localObject2);
    localgg.FQM = localgh;
    localgg.FQS = com.tencent.mm.bw.b.cm(paramString2);
    paramInt1 = bu.fpO().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localgg);
      bc.ajj().a(paramString1, 0);
      AppMethodBeat.o(24526);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(24528);
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.rmJ == 0L) {
      this.rmJ = System.currentTimeMillis();
    }
    this.rmK = System.currentTimeMillis();
    ga localga = new ga();
    localga.FQF = paramb;
    paramString = new a(paramInt, paramString, localga, this.rmJ);
    bc.ajj().a(paramString, 0);
    AppMethodBeat.o(24528);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(24529);
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.rmH = 3506;
      this.rmL.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.rmH = 3507;
      this.rmL.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 985)
    {
      if (this.rmN)
      {
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramn;
      paramString = (a)paramn;
      if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
      for (paramString = (gc)paramString.rr.hQE.hQJ; paramString == null; paramString = null)
      {
        ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.rmH = 3508;
        this.rmL.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      locala.rmX = paramString.FQF;
      paramInt1 = locala.dsO;
      if (paramString.FQF == null)
      {
        paramn = "null";
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramn });
        if (locala.dsO != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.FQM == null)
          {
            ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.rmH = 3508;
            this.rmL.countDown();
            AppMethodBeat.o(24529);
            return;
            paramn = new String(paramString.FQF.zr);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.FQK), Integer.valueOf(paramString.FQL), Integer.valueOf(paramString.FQM.xsC), Integer.valueOf(paramString.FQM.xsD) });
          if (paramString.FQM.xsC >= locala.hPI)
          {
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.FQL;
                ae.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.rnb = i;
                ExtControlProviderVoiceControl.this.a(locala.rmW, locala.appId, locala.rmX);
                AppMethodBeat.o(24518);
              }
            }, paramString.FQK);
            AppMethodBeat.o(24529);
            return;
          }
          ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.FQM.xsC != 0) && (paramString.FQM.xsC == locala.dgI))
          {
            ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.dgI = paramString.FQM.xsC;
          if (paramString.FQM.xsC + paramString.FQM.xsD < locala.hPI)
          {
            if (!a(locala, paramString.FQM.xsC, paramString.FQM.xsD))
            {
              ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.rmH = 3510;
              this.rmL.countDown();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.FQM.xsC, locala.hPI - paramString.FQM.xsC))
          {
            ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.rmH = 3510;
            this.rmL.countDown();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.dsO == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.rnc;
        if (l1 <= locala.rnb) {
          break label781;
        }
        ae.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.rnb) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.rmH = 3509;
        this.rmL.countDown();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        ae.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.rnb) });
      }
      label818:
      if (paramString.FQN != null) {
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.FQN.FQG), Integer.valueOf(paramString.FQN.FQO) });
      }
      if ((paramString.FQN == null) || (paramString.FQN.FQO != 0))
      {
        if (System.currentTimeMillis() - this.rmK >= paramString.FQK)
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              ExtControlProviderVoiceControl.this.a(locala.rmW, locala.appId, locala.rmX);
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.FQK - (System.currentTimeMillis() - this.rmK);
        l1 = l2;
        if (l2 > paramString.FQK) {
          l1 = paramString.FQK;
        }
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            ExtControlProviderVoiceControl.this.a(locala.rmW, locala.appId, locala.rmX);
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.FQN.FQP == null)
      {
        ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.rmH = 3511;
        this.rmL.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.FQN.FQP.FQQ == null) || (paramString.FQN.FQP.FQQ.size() <= 0))
      {
        ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.rmH = 3511;
        this.rmL.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.FQN.FQP.FQQ.size() == 0)
      {
        this.rmH = 3511;
        this.rmL.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.FQN.FQP.FQQ.size() == 1)
      {
        agN(((gf)paramString.FQN.FQP.FQQ.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramn = new String[paramString.FQN.FQP.FQQ.size()];
      paramInt1 = 0;
      while (paramInt1 < paramn.length)
      {
        paramn[paramInt1] = ((gf)paramString.FQN.FQP.FQQ.get(paramInt1)).Username;
        ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramn[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramn);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.rmW);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.br.d.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.rmH = 1;
      this.rmL.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.rlj) });
    this.rmI = 0L;
    this.rmJ = 0L;
    a(paramUri, this.context, this.rlj, this.rli);
    if (paramUri == null)
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      fz(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (bu.isNullOrNil(this.rlu))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      fz(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (bu.isNullOrNil(ctL()))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      fz(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = ctM();
    if (i != 1)
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fz(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.rlj)
    {
    default: 
      fz(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      fz(3, 3501);
      this.rmH = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3501);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((bu.isNullOrNil(paramUri)) || (bu.isNullOrNil(paramArrayOfString1)) || (bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramArrayOfString2)))
    {
      fz(3, 3502);
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!o.fB(paramArrayOfString2))
    {
      ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      fz(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.rmI = System.currentTimeMillis();
    bc.ajj().a(985, this);
    this.rmL.c(13000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24517);
        int i = bu.getInt(paramUri, 4);
        if (i == 1) {
          ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, paramArrayOfString2);
        }
        for (;;)
        {
          if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this), i, bu.getInt(paramArrayOfString1, 4), bu.getInt(paramString1, 16000), bu.getInt(paramString2, 16), paramArrayOfString2))
          {
            ae.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this);
            ExtControlProviderVoiceControl.this.rmL.countDown();
          }
          AppMethodBeat.o(24517);
          return;
          ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    ae.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.rmJ - this.rmI), Long.valueOf(System.currentTimeMillis() - this.rmJ) });
    bc.ajj().b(985, this);
    ab(10, 0, 1);
    if (1 != this.rmH) {
      ab(11, 4, 1);
    }
    for (;;)
    {
      DS(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(this.rmH);
      AppMethodBeat.o(24525);
      return paramUri;
      ab(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */