package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements f
{
  private static final String[] jJI = { "retCode" };
  private Context context;
  private String[] jJU = null;
  private int jJV = -1;
  private int jLq = 4;
  private long jLr;
  private long jLs;
  private long jLt;
  com.tencent.mm.pluginsdk.d.a.b jLu = new com.tencent.mm.pluginsdk.d.a.b();
  private long jLv = 0L;
  private boolean jLw;
  private com.qq.wx.voice.embed.recognizer.c jLx = new ExtControlProviderVoiceControl.5(this);
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.jJU = paramArrayOfString;
    this.jJV = paramInt;
    this.context = paramContext;
  }
  
  private void Ck(String paramString)
  {
    au.Hx();
    ad localad = com.tencent.mm.model.c.Fw().abl(paramString);
    if ((localad == null) || (!com.tencent.mm.n.a.gR(localad.field_type)))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.jLq = 3505;
      this.jLu.countDown();
      return;
    }
    com.tencent.mm.compatible.a.a.a(11, new ExtControlProviderVoiceControl.6(this, paramString));
    this.jLq = 1;
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.jLu.countDown();
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    if (parama == null)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      return false;
    }
    if (parama.jLI == null)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      return false;
    }
    if (parama.jLI.sxH == null)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      return false;
    }
    new ee();
    Object localObject = parama.jLI;
    ((ee)localObject).sxH.ndg = paramInt1;
    ((ee)localObject).sxH.ndh = paramInt2;
    byte[] arrayOfByte = e.d(parama.jLH, paramInt1, paramInt2);
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.jLF), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.jLH });
      return false;
    }
    ((ee)localObject).sxO = com.tencent.mm.bv.b.bk(arrayOfByte);
    localObject = new a(parama.jLF, parama.appId, parama.ebK, parama.jLH, (ee)localObject);
    ((a)localObject).ebL = parama.ebL;
    au.Dk().a((m)localObject, 0);
    return true;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.f.c.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.f.c.d.y(paramString2, (String)localObject2))
      {
        y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = e.bJ((String)localObject1);
    Object localObject2 = new eg();
    ((eg)localObject2).sxP = 4;
    ((eg)localObject2).sxQ = 4;
    ((eg)localObject2).sxR = paramInt3;
    ((eg)localObject2).sxS = paramInt4;
    ef localef = new ef();
    localef.ndf = i;
    localef.ndg = 0;
    if (i <= 16384) {
      localef.ndh = i;
    }
    for (paramString2 = e.d((String)localObject1, 0, i);; paramString2 = e.d((String)localObject1, 0, 16384))
    {
      y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      return false;
      localef.ndh = 16384;
    }
    ee localee = new ee();
    localee.sxN = ((eg)localObject2);
    localee.sxH = localef;
    localee.sxO = com.tencent.mm.bv.b.bk(paramString2);
    paramInt1 = bk.UY().hashCode();
    if (paramInt1 != -2147483648) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = -2147483648)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localee);
      au.Dk().a(paramString1, 0);
      return true;
    }
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bv.b paramb)
  {
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.jLs == 0L) {
      this.jLs = System.currentTimeMillis();
    }
    this.jLt = System.currentTimeMillis();
    dy localdy = new dy();
    localdy.sxA = paramb;
    paramString = new a(paramInt, paramString, localdy, this.jLs);
    au.Dk().a(paramString, 0);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.jLq = 3506;
      this.jLu.countDown();
    }
    a locala;
    label333:
    label338:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.jLq = 3507;
            this.jLu.countDown();
            return;
          }
          y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramm.getType()) });
        } while (paramm.getType() != 985);
        if (this.jLw)
        {
          y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
          return;
        }
        locala = (a)paramm;
        paramString = (a)paramm;
        if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
        for (paramString = (ea)paramString.dmK.ecF.ecN; paramString == null; paramString = null)
        {
          y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
          this.jLq = 3508;
          this.jLu.countDown();
          return;
        }
        locala.jLG = paramString.sxA;
        paramInt1 = locala.bMC;
        if (paramString.sxA == null)
        {
          paramm = "null";
          y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramm });
          if (locala.bMC != 1) {
            break label333;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label604;
          }
          if (paramString.sxH != null) {
            break label338;
          }
          y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
          this.jLq = 3508;
          this.jLu.countDown();
          return;
          paramm = new String(paramString.sxA.oY);
          break;
        }
        y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.sxF), Integer.valueOf(paramString.sxG), Integer.valueOf(paramString.sxH.ndg), Integer.valueOf(paramString.sxH.ndh) });
        if (paramString.sxH.ndg >= locala.ebK)
        {
          ai.l(new ExtControlProviderVoiceControl.2(this, locala, paramString), paramString.sxF);
          return;
        }
        y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
        if ((paramString.sxH.ndg != 0) && (paramString.sxH.ndg == locala.ebL))
        {
          y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
          return;
        }
        locala.ebL = paramString.sxH.ndg;
        if (paramString.sxH.ndg + paramString.sxH.ndh >= locala.ebK) {
          break;
        }
      } while (a(locala, paramString.sxH.ndg, paramString.sxH.ndh));
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
      this.jLq = 3510;
      this.jLu.countDown();
      return;
    } while (a(locala, paramString.sxH.ndg, locala.ebK - paramString.sxH.ndg));
    y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
    this.jLq = 3510;
    this.jLu.countDown();
    return;
    label604:
    label615:
    long l1;
    if (locala.bMC == 2)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label706;
      }
      y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
      l1 = System.currentTimeMillis() - locala.jLL;
      if (l1 <= locala.jLK) {
        break label708;
      }
      y.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.jLK) });
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label745;
      }
      this.jLq = 3509;
      this.jLu.countDown();
      return;
      paramInt1 = 0;
      break label615;
      label706:
      break;
      label708:
      y.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.jLK) });
    }
    label745:
    if (paramString.sxI != null) {
      y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.sxI.sxB), Integer.valueOf(paramString.sxI.sxJ) });
    }
    if ((paramString.sxI == null) || (paramString.sxI.sxJ != 0))
    {
      if (System.currentTimeMillis() - this.jLt >= paramString.sxF)
      {
        ai.d(new ExtControlProviderVoiceControl.3(this, locala));
        return;
      }
      long l2 = paramString.sxF - (System.currentTimeMillis() - this.jLt);
      l1 = l2;
      if (l2 > paramString.sxF) {
        l1 = paramString.sxF;
      }
      ai.l(new ExtControlProviderVoiceControl.4(this, locala), l1);
      return;
    }
    if (paramString.sxI.sxK == null)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
      this.jLq = 3511;
      this.jLu.countDown();
      return;
    }
    if ((paramString.sxI.sxK.sxL == null) || (paramString.sxI.sxK.sxL.size() <= 0))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
      this.jLq = 3511;
      this.jLu.countDown();
      return;
    }
    if (paramString.sxI.sxK.sxL.size() == 0)
    {
      this.jLq = 3511;
      this.jLu.countDown();
      return;
    }
    if (paramString.sxI.sxK.sxL.size() == 1)
    {
      Ck(((ed)paramString.sxI.sxK.sxL.get(0)).sxM);
      return;
    }
    paramm = new String[paramString.sxI.sxK.sxL.size()];
    paramInt1 = 0;
    while (paramInt1 < paramm.length)
    {
      paramm[paramInt1] = ((ed)paramString.sxI.sxK.sxL.get(paramInt1)).sxM;
      y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramm[paramInt1] });
      paramInt1 += 1;
    }
    paramString = new Intent();
    paramString.putExtra("VoiceSearchResultUI_Resultlist", paramm);
    paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.jLF);
    paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
    paramString.setFlags(67108864);
    paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
    com.tencent.mm.br.d.e(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
    this.jLq = 1;
    this.jLu.countDown();
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.jJV) });
    this.jLr = 0L;
    this.jLs = 0L;
    a(paramUri, this.context, this.jJV, this.jJU);
    if (paramUri == null)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      cL(3, 5);
      return com.tencent.mm.pluginsdk.d.a.a.DA(5);
    }
    long l1 = System.currentTimeMillis();
    if (bk.bl(this.jKd))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      cL(3, 7);
      return com.tencent.mm.pluginsdk.d.a.a.DA(7);
    }
    if (bk.bl(aNA()))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      cL(3, 6);
      return com.tencent.mm.pluginsdk.d.a.a.DA(6);
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = aNB();
    if (i != 1)
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = " + i);
      cL(2, i);
      return com.tencent.mm.pluginsdk.d.a.a.DA(i);
    }
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.jJV)
    {
    default: 
      cL(3, 15);
      return com.tencent.mm.pluginsdk.d.a.a.DA(15);
    }
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      cL(3, 3501);
      this.jLq = 3501;
      return com.tencent.mm.pluginsdk.d.a.a.DA(3501);
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((bk.bl(paramUri)) || (bk.bl(paramArrayOfString1)) || (bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramArrayOfString2)))
    {
      cL(3, 3502);
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      return com.tencent.mm.pluginsdk.d.a.a.DA(3502);
    }
    if (!e.bK(paramArrayOfString2))
    {
      y.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      cL(3, 3503);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3503);
    }
    this.jLr = System.currentTimeMillis();
    au.Dk().a(985, this);
    this.jLu.b(13000L, new ExtControlProviderVoiceControl.1(this, paramUri, paramArrayOfString2, paramArrayOfString1, paramString1, paramString2));
    y.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.jLs - this.jLr), Long.valueOf(System.currentTimeMillis() - this.jLs) });
    au.Dk().b(985, this);
    G(10, 0, 1);
    if (1 != this.jLq) {
      G(11, 4, 1);
    }
    for (;;)
    {
      qF(0);
      return com.tencent.mm.pluginsdk.d.a.a.DA(this.jLq);
      G(10, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl
 * JD-Core Version:    0.7.0.1
 */