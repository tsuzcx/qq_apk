package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements f
{
  private static final String[] rcM = { "retCode" };
  private Context context;
  private String[] rdc;
  private int rdd;
  private int reE;
  private long reF;
  private long reG;
  private long reH;
  com.tencent.mm.pluginsdk.d.a.b reI;
  private long reJ;
  private boolean reK;
  private com.qq.wx.voice.embed.recognizer.c reL;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24524);
    this.rdc = null;
    this.rdd = -1;
    this.reE = 4;
    this.reI = new com.tencent.mm.pluginsdk.d.a.b();
    this.reJ = 0L;
    this.reL = new com.qq.wx.voice.embed.recognizer.c()
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
      
      public final void onGetError(int paramAnonymousInt)
      {
        AppMethodBeat.i(24522);
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(24522);
      }
    };
    this.rdc = paramArrayOfString;
    this.rdd = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(24524);
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
    if (parama.reW == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(24527);
      return false;
    }
    if (parama.reW.Fyo == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(24527);
      return false;
    }
    new gg();
    Object localObject = parama.reW;
    ((gg)localObject).Fyo.xcL = paramInt1;
    ((gg)localObject).Fyo.xcM = paramInt2;
    byte[] arrayOfByte = i.aY(parama.reV, paramInt1, paramInt2);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.reT), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.reV });
      AppMethodBeat.o(24527);
      return false;
    }
    ((gg)localObject).Fyu = com.tencent.mm.bx.b.cj(arrayOfByte);
    localObject = new a(parama.reT, parama.appId, parama.hMP, parama.reV, (gg)localObject);
    ((a)localObject).dfG = parama.dfG;
    ba.aiU().a((n)localObject, 0);
    AppMethodBeat.o(24527);
    return true;
  }
  
  private void afR(final String paramString)
  {
    AppMethodBeat.i(24530);
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramString);
    if ((localam == null) || (!com.tencent.mm.o.b.lM(localam.field_type)))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.reE = 3505;
      this.reI.countDown();
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
    this.reE = 1;
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.reI.countDown();
    AppMethodBeat.o(24530);
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
      if (!com.tencent.mm.audio.e.d.S(paramString2, (String)localObject2))
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
    int i = (int)i.aYo((String)localObject1);
    Object localObject2 = new gi();
    ((gi)localObject2).Fyv = 4;
    ((gi)localObject2).Fyw = 4;
    ((gi)localObject2).Fyx = paramInt3;
    ((gi)localObject2).Fyy = paramInt4;
    gh localgh = new gh();
    localgh.xcK = i;
    localgh.xcL = 0;
    if (i <= 16384) {
      localgh.xcM = i;
    }
    for (paramString2 = i.aY((String)localObject1, 0, i);; paramString2 = i.aY((String)localObject1, 0, 16384))
    {
      ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(24526);
      return false;
      localgh.xcM = 16384;
    }
    gg localgg = new gg();
    localgg.Fyt = ((gi)localObject2);
    localgg.Fyo = localgh;
    localgg.Fyu = com.tencent.mm.bx.b.cj(paramString2);
    paramInt1 = bt.flT().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localgg);
      ba.aiU().a(paramString1, 0);
      AppMethodBeat.o(24526);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(24528);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.reG == 0L) {
      this.reG = System.currentTimeMillis();
    }
    this.reH = System.currentTimeMillis();
    ga localga = new ga();
    localga.Fyh = paramb;
    paramString = new a(paramInt, paramString, localga, this.reG);
    ba.aiU().a(paramString, 0);
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
      this.reE = 3506;
      this.reI.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.reE = 3507;
      this.reI.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 985)
    {
      if (this.reK)
      {
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(24529);
        return;
      }
      final a locala = (a)paramn;
      paramString = (a)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (paramString = (gc)paramString.rr.hNL.hNQ; paramString == null; paramString = null)
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.reE = 3508;
        this.reI.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      locala.reU = paramString.Fyh;
      paramInt1 = locala.drI;
      if (paramString.Fyh == null)
      {
        paramn = "null";
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramn });
        if (locala.drI != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.Fyo == null)
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.reE = 3508;
            this.reI.countDown();
            AppMethodBeat.o(24529);
            return;
            paramn = new String(paramString.Fyh.zr);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.Fym), Integer.valueOf(paramString.Fyn), Integer.valueOf(paramString.Fyo.xcL), Integer.valueOf(paramString.Fyo.xcM) });
          if (paramString.Fyo.xcL >= locala.hMP)
          {
            aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24518);
                ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.Fyn;
                ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.reY = i;
                ExtControlProviderVoiceControl.this.a(locala.reT, locala.appId, locala.reU);
                AppMethodBeat.o(24518);
              }
            }, paramString.Fym);
            AppMethodBeat.o(24529);
            return;
          }
          ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.Fyo.xcL != 0) && (paramString.Fyo.xcL == locala.dfG))
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(24529);
            return;
          }
          locala.dfG = paramString.Fyo.xcL;
          if (paramString.Fyo.xcL + paramString.Fyo.xcM < locala.hMP)
          {
            if (!a(locala, paramString.Fyo.xcL, paramString.Fyo.xcM))
            {
              ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.reE = 3510;
              this.reI.countDown();
              AppMethodBeat.o(24529);
            }
          }
          else if (!a(locala, paramString.Fyo.xcL, locala.hMP - paramString.Fyo.xcL))
          {
            ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.reE = 3510;
            this.reI.countDown();
            AppMethodBeat.o(24529);
            return;
          }
          AppMethodBeat.o(24529);
          return;
        }
      }
      long l1;
      if (locala.drI == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.reZ;
        if (l1 <= locala.reY) {
          break label781;
        }
        ad.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.reY) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.reE = 3509;
        this.reI.countDown();
        AppMethodBeat.o(24529);
        return;
        paramInt1 = 0;
        break;
        label781:
        ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.reY) });
      }
      label818:
      if (paramString.Fyp != null) {
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.Fyp.Fyi), Integer.valueOf(paramString.Fyp.Fyq) });
      }
      if ((paramString.Fyp == null) || (paramString.Fyp.Fyq != 0))
      {
        if (System.currentTimeMillis() - this.reH >= paramString.Fym)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24519);
              ExtControlProviderVoiceControl.this.a(locala.reT, locala.appId, locala.reU);
              AppMethodBeat.o(24519);
            }
          });
          AppMethodBeat.o(24529);
          return;
        }
        long l2 = paramString.Fym - (System.currentTimeMillis() - this.reH);
        l1 = l2;
        if (l2 > paramString.Fym) {
          l1 = paramString.Fym;
        }
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24520);
            ExtControlProviderVoiceControl.this.a(locala.reT, locala.appId, locala.reU);
            AppMethodBeat.o(24520);
          }
        }, l1);
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.Fyp.Fyr == null)
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.reE = 3511;
        this.reI.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if ((paramString.Fyp.Fyr.Fys == null) || (paramString.Fyp.Fyr.Fys.size() <= 0))
      {
        ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.reE = 3511;
        this.reI.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.Fyp.Fyr.Fys.size() == 0)
      {
        this.reE = 3511;
        this.reI.countDown();
        AppMethodBeat.o(24529);
        return;
      }
      if (paramString.Fyp.Fyr.Fys.size() == 1)
      {
        afR(((gf)paramString.Fyp.Fyr.Fys.get(0)).Username);
        AppMethodBeat.o(24529);
        return;
      }
      paramn = new String[paramString.Fyp.Fyr.Fys.size()];
      paramInt1 = 0;
      while (paramInt1 < paramn.length)
      {
        paramn[paramInt1] = ((gf)paramString.Fyp.Fyr.Fys.get(paramInt1)).Username;
        ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramn[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramn);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.reT);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.bs.d.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.reE = 1;
      this.reI.countDown();
      AppMethodBeat.o(24529);
      return;
    }
    label1331:
    AppMethodBeat.o(24529);
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    AppMethodBeat.i(24525);
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.rdd) });
    this.reF = 0L;
    this.reG = 0L;
    a(paramUri, this.context, this.rdd, this.rdc);
    if (paramUri == null)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      fB(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(5);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (bt.isNullOrNil(this.rdo))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      fB(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(7);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (bt.isNullOrNil(csj()))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      fB(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(6);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = csk();
    if (i != 1)
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fB(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(i);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.rdd)
    {
    default: 
      fB(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(15);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      fB(3, 3501);
      this.reE = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3501);
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
      fB(3, 3502);
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3502);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    if (!i.fv(paramArrayOfString2))
    {
      ad.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      fB(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3503);
      AppMethodBeat.o(24525);
      return paramUri;
    }
    this.reF = System.currentTimeMillis();
    ba.aiU().a(985, this);
    this.reI.c(13000L, new Runnable()
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
            ExtControlProviderVoiceControl.this.reI.countDown();
          }
          AppMethodBeat.o(24517);
          return;
          ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    ad.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.reG - this.reF), Long.valueOf(System.currentTimeMillis() - this.reG) });
    ba.aiU().b(985, this);
    ab(10, 0, 1);
    if (1 != this.reE) {
      ab(11, 4, 1);
    }
    for (;;)
    {
      DF(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(this.reE);
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