package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements f
{
  private static final String[] mdM = { "retCode" };
  private Context context;
  private String[] mdZ;
  private int mea;
  private boolean mfA;
  private com.qq.wx.voice.embed.recognizer.c mfB;
  private int mfu;
  private long mfv;
  private long mfw;
  private long mfx;
  com.tencent.mm.pluginsdk.d.a.b mfy;
  private long mfz;
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(20447);
    this.mdZ = null;
    this.mea = -1;
    this.mfu = 4;
    this.mfy = new com.tencent.mm.pluginsdk.d.a.b();
    this.mfz = 0L;
    this.mfB = new ExtControlProviderVoiceControl.5(this);
    this.mdZ = paramArrayOfString;
    this.mea = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(20447);
  }
  
  private void Nl(String paramString)
  {
    AppMethodBeat.i(20453);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(paramString);
    if ((localad == null) || (!com.tencent.mm.n.a.je(localad.field_type)))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.mfu = 3505;
      this.mfy.countDown();
      AppMethodBeat.o(20453);
      return;
    }
    com.tencent.mm.compatible.a.a.a(11, new ExtControlProviderVoiceControl.6(this, paramString));
    this.mfu = 1;
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.mfy.countDown();
    AppMethodBeat.o(20453);
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20450);
    if (parama == null)
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      AppMethodBeat.o(20450);
      return false;
    }
    if (parama.mfM == null)
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      AppMethodBeat.o(20450);
      return false;
    }
    if (parama.mfM.wrl == null)
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      AppMethodBeat.o(20450);
      return false;
    }
    new ff();
    Object localObject = parama.mfM;
    ((ff)localObject).wrl.pIy = paramInt1;
    ((ff)localObject).wrl.pIz = paramInt2;
    byte[] arrayOfByte = e.j(parama.mfL, paramInt1, paramInt2);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.mfJ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.mfL });
      AppMethodBeat.o(20450);
      return false;
    }
    ((ff)localObject).wrr = com.tencent.mm.bv.b.bL(arrayOfByte);
    localObject = new a(parama.mfJ, parama.appId, parama.fsd, parama.mfL, (ff)localObject);
    ((a)localObject).chT = parama.chT;
    aw.Rc().a((m)localObject, 0);
    AppMethodBeat.o(20450);
    return true;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(20449);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.audio.e.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.audio.e.d.K(paramString2, (String)localObject2))
      {
        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        AppMethodBeat.o(20449);
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = e.cM((String)localObject1);
    Object localObject2 = new fh();
    ((fh)localObject2).wrs = 4;
    ((fh)localObject2).wrt = 4;
    ((fh)localObject2).wru = paramInt3;
    ((fh)localObject2).wrv = paramInt4;
    fg localfg = new fg();
    localfg.pIx = i;
    localfg.pIy = 0;
    if (i <= 16384) {
      localfg.pIz = i;
    }
    for (paramString2 = e.j((String)localObject1, 0, i);; paramString2 = e.j((String)localObject1, 0, 16384))
    {
      ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      AppMethodBeat.o(20449);
      return false;
      localfg.pIz = 16384;
    }
    ff localff = new ff();
    localff.wrq = ((fh)localObject2);
    localff.wrl = localfg;
    localff.wrr = com.tencent.mm.bv.b.bL(paramString2);
    paramInt1 = bo.aoy().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localff);
      aw.Rc().a(paramString1, 0);
      AppMethodBeat.o(20449);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bv.b paramb)
  {
    AppMethodBeat.i(20451);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.mfw == 0L) {
      this.mfw = System.currentTimeMillis();
    }
    this.mfx = System.currentTimeMillis();
    ez localez = new ez();
    localez.wre = paramb;
    paramString = new a(paramInt, paramString, localez, this.mfw);
    aw.Rc().a(paramString, 0);
    AppMethodBeat.o(20451);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20452);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.mfu = 3506;
      this.mfy.countDown();
      AppMethodBeat.o(20452);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.mfu = 3507;
      this.mfy.countDown();
      AppMethodBeat.o(20452);
      return;
    }
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramm.getType()) });
    if (paramm.getType() == 985)
    {
      if (this.mfA)
      {
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        AppMethodBeat.o(20452);
        return;
      }
      a locala = (a)paramm;
      paramString = (a)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (fb)paramString.rr.fsW.fta; paramString == null; paramString = null)
      {
        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.mfu = 3508;
        this.mfy.countDown();
        AppMethodBeat.o(20452);
        return;
      }
      locala.mfK = paramString.wre;
      paramInt1 = locala.ctW;
      if (paramString.wre == null)
      {
        paramm = "null";
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramm });
        if (locala.ctW != 1) {
          break label369;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.wrl == null)
          {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
            this.mfu = 3508;
            this.mfy.countDown();
            AppMethodBeat.o(20452);
            return;
            paramm = new String(paramString.wre.pW);
            break;
            label369:
            paramInt1 = 0;
            continue;
          }
          ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.wrj), Integer.valueOf(paramString.wrk), Integer.valueOf(paramString.wrl.pIy), Integer.valueOf(paramString.wrl.pIz) });
          if (paramString.wrl.pIy >= locala.fsd)
          {
            al.p(new ExtControlProviderVoiceControl.2(this, locala, paramString), paramString.wrj);
            AppMethodBeat.o(20452);
            return;
          }
          ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.wrl.pIy != 0) && (paramString.wrl.pIy == locala.chT))
          {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            AppMethodBeat.o(20452);
            return;
          }
          locala.chT = paramString.wrl.pIy;
          if (paramString.wrl.pIy + paramString.wrl.pIz < locala.fsd)
          {
            if (!a(locala, paramString.wrl.pIy, paramString.wrl.pIz))
            {
              ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.mfu = 3510;
              this.mfy.countDown();
              AppMethodBeat.o(20452);
            }
          }
          else if (!a(locala, paramString.wrl.pIy, locala.fsd - paramString.wrl.pIy))
          {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.mfu = 3510;
            this.mfy.countDown();
            AppMethodBeat.o(20452);
            return;
          }
          AppMethodBeat.o(20452);
          return;
        }
      }
      long l1;
      if (locala.ctW == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1331;
        }
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.mfP;
        if (l1 <= locala.mfO) {
          break label781;
        }
        ab.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.mfO) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label818;
        }
        this.mfu = 3509;
        this.mfy.countDown();
        AppMethodBeat.o(20452);
        return;
        paramInt1 = 0;
        break;
        label781:
        ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.mfO) });
      }
      label818:
      if (paramString.wrm != null) {
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.wrm.wrf), Integer.valueOf(paramString.wrm.wrn) });
      }
      if ((paramString.wrm == null) || (paramString.wrm.wrn != 0))
      {
        if (System.currentTimeMillis() - this.mfx >= paramString.wrj)
        {
          al.d(new ExtControlProviderVoiceControl.3(this, locala));
          AppMethodBeat.o(20452);
          return;
        }
        long l2 = paramString.wrj - (System.currentTimeMillis() - this.mfx);
        l1 = l2;
        if (l2 > paramString.wrj) {
          l1 = paramString.wrj;
        }
        al.p(new ExtControlProviderVoiceControl.4(this, locala), l1);
        AppMethodBeat.o(20452);
        return;
      }
      if (paramString.wrm.wro == null)
      {
        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.mfu = 3511;
        this.mfy.countDown();
        AppMethodBeat.o(20452);
        return;
      }
      if ((paramString.wrm.wro.wrp == null) || (paramString.wrm.wro.wrp.size() <= 0))
      {
        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.mfu = 3511;
        this.mfy.countDown();
        AppMethodBeat.o(20452);
        return;
      }
      if (paramString.wrm.wro.wrp.size() == 0)
      {
        this.mfu = 3511;
        this.mfy.countDown();
        AppMethodBeat.o(20452);
        return;
      }
      if (paramString.wrm.wro.wrp.size() == 1)
      {
        Nl(((fe)paramString.wrm.wro.wrp.get(0)).Username);
        AppMethodBeat.o(20452);
        return;
      }
      paramm = new String[paramString.wrm.wro.wrp.size()];
      paramInt1 = 0;
      while (paramInt1 < paramm.length)
      {
        paramm[paramInt1] = ((fe)paramString.wrm.wro.wrp.get(paramInt1)).Username;
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramm[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramm);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.mfJ);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.bq.d.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.mfu = 1;
      this.mfy.countDown();
      AppMethodBeat.o(20452);
      return;
    }
    label1331:
    AppMethodBeat.o(20452);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(20448);
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.mea) });
    this.mfv = 0L;
    this.mfw = 0L;
    a(paramUri, this.context, this.mea, this.mdZ);
    if (paramUri == null)
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      ej(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(5);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (bo.isNullOrNil(this.mei))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      ej(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(7);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    if (bo.isNullOrNil(btD()))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      ej(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(6);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = btE();
    if (i != 1)
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(i)));
      ej(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(i);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.mea)
    {
    default: 
      ej(3, 15);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(15);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      ej(3, 3501);
      this.mfu = 3501;
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3501);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((bo.isNullOrNil(paramUri)) || (bo.isNullOrNil(paramArrayOfString1)) || (bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramArrayOfString2)))
    {
      ej(3, 3502);
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3502);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    if (!e.cN(paramArrayOfString2))
    {
      ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      ej(3, 3503);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3503);
      AppMethodBeat.o(20448);
      return paramUri;
    }
    this.mfv = System.currentTimeMillis();
    aw.Rc().a(985, this);
    this.mfy.b(13000L, new ExtControlProviderVoiceControl.1(this, paramUri, paramArrayOfString2, paramArrayOfString1, paramString1, paramString2));
    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.mfw - this.mfv), Long.valueOf(System.currentTimeMillis() - this.mfw) });
    aw.Rc().b(985, this);
    S(10, 0, 1);
    if (1 != this.mfu) {
      S(11, 4, 1);
    }
    for (;;)
    {
      vA(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(this.mfu);
      AppMethodBeat.o(20448);
      return paramUri;
      S(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */