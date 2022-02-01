package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.f.a.si;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends q
  implements m
{
  public static int uFA = 0;
  public static int uFB = 1;
  private i callback;
  private int mIndex;
  private final d rr;
  private ArrayList<EmojiInfo> uFC;
  private int uFD;
  private ar.a uFE;
  private ar.a uFF;
  private LinkedList<String> uFG;
  private int uFx;
  private ArrayList<String> uFz;
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, uFB);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(223750);
    this.uFz = new ArrayList();
    this.uFC = new ArrayList();
    this.mIndex = 0;
    this.uFD = 0;
    this.uFG = new LinkedList();
    d.a locala = new d.a();
    locala.lBU = new jq();
    locala.lBV = new jr();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.mIndex = 0;
    this.uFD = paramInt;
    this.uFG = paramLinkedList;
    this.uFx = 0;
    if (this.uFx == 1)
    {
      this.uFE = ar.a.VgO;
      this.uFF = ar.a.VgS;
      AppMethodBeat.o(223750);
      return;
    }
    this.uFE = ar.a.VgN;
    this.uFF = ar.a.VgR;
    AppMethodBeat.o(223750);
  }
  
  private void a(jr paramjr)
  {
    AppMethodBeat.i(104572);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.uFx) });
    if (paramjr == null)
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramjr.RPm == null) || (paramjr.RPm.size() <= 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramjr = paramjr.RPm.iterator();
    while (paramjr.hasNext())
    {
      aji localaji = (aji)paramjr.next();
      if (Util.isNullOrNil(localaji.Md5))
      {
        Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localaji });
      }
      else
      {
        Object localObject = localaji.Md5.toLowerCase();
        this.uFz.add(localObject);
        localObject = new EmojiInfo();
        b.a(localaji, (EmojiInfo)localObject);
        if (this.uFx == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.uFC.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.YCD;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final jr cUZ()
  {
    AppMethodBeat.i(223831);
    if (this.rr == null)
    {
      AppMethodBeat.o(223831);
      return null;
    }
    jr localjr = (jr)d.c.b(this.rr.lBS);
    AppMethodBeat.o(223831);
    return localjr;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(104573);
    this.callback = parami;
    parami = (jq)d.b.b(this.rr.lBR);
    parami.CqR = this.mIndex;
    parami.lpw = this.uFD;
    parami.RPk = this.uFG;
    parami.CNe = this.uFx;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(104573);
    return i;
  }
  
  public final int getType()
  {
    return 697;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104571);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.uFD == uFA)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.h.aHG().aHp().set(this.uFF, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.h.aHG().aHp().set(this.uFE, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      params = (jr)d.c.b(this.rr.lBS);
      paramArrayOfByte = (jq)d.b.b(this.rr.lBR);
      if ((params.lVs == 0) && ((params.RNs == null) || (params.RNs.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (params.lVs == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.h.aHG().aHp().set(this.uFF, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.h.aHG().aHp().set(this.uFE, Boolean.FALSE);
        a(params);
        if (this.uFC == null)
        {
          paramInt1 = 0;
          Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.uFz;
          if ((paramString != null) && (paramString.size() > 0)) {
            break label426;
          }
          Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgF, Boolean.FALSE);
          if (this.uFx == 0)
          {
            if ((this.uFz.contains("08f223fa83f1ca34e143d1e580252c7c")) && (this.uFz.contains("9bd1281af3a31710a45b84d736363691"))) {
              break label938;
            }
            b.cXa();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
          paramInt1 = this.uFC.size();
          break;
          label426:
          if (paramString.size() < o.aBT()) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgF, Boolean.FALSE);
          }
          ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgI, Boolean.TRUE)).booleanValue();
          bj.hyV().VFH.B(this.uFx, this.uFC);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgI, Boolean.FALSE);
          params = bj.hyV().VFH;
          paramInt1 = this.uFx;
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
          long l = System.currentTimeMillis();
          if ((paramString == null) || (paramString.size() <= 0))
          {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
            label560:
            paramString = (ArrayList)bj.hyV().VFH.hBF();
            if (paramString.size() <= 0) {
              break label885;
            }
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
            com.tencent.mm.plugin.report.service.h.IzE.a(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.uFx) });
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
              com.tencent.mm.plugin.report.service.h.IzE.a(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.uFx) });
            }
            label674:
            if (this.uFx != 1) {
              break label912;
            }
            k.aBH().ew(true);
            com.tencent.mm.emoji.sync.g.aDs().eD(true);
          }
          for (;;)
          {
            paramString = l.jIq;
            l.aBO();
            EventCenter.instance.publish(new si());
            break;
            Object localObject = params.asR(paramInt1);
            if (((List)localObject).size() <= 0)
            {
              Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
              break label560;
            }
            paramArrayOfByte = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              if (!paramString.contains(str.toLowerCase()))
              {
                paramArrayOfByte.add(str);
                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { str });
              }
            }
            params.J(paramArrayOfByte, paramInt1);
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
            break label560;
            label885:
            com.tencent.mm.kernel.h.aHG().aHp().set(this.uFE, Boolean.FALSE);
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
            break label674;
            label912:
            k.aBH().eu(true);
            k.aBH().et(true);
            com.tencent.mm.emoji.sync.g.aDr().eD(true);
          }
          label938:
          paramString = l.jIq;
          l.ex(true);
        }
      }
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.CqR), Integer.valueOf(params.RNs.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.CqR = params.CqR;
      this.mIndex = paramArrayOfByte.CqR;
      a(params);
      paramInt2 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0) {
        Log.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
      }
      AppMethodBeat.o(104571);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
    }
    params = (jr)d.c.b(this.rr.lBS);
    d.b.b(this.rr.lBR);
    if ((params.RPm == null) || (params.RPm.size() <= 0)) {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      bj.hyV().VFH.jT(params.RPm);
    }
  }
  
  public final int securityLimitCount()
  {
    return 150;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */