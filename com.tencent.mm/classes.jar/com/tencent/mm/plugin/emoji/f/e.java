package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.g.a.of;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends m
  implements k
{
  public static int lil = 0;
  public static int lim = 1;
  private f callback;
  private int lii;
  private ArrayList<String> lik;
  private ArrayList<EmojiInfo> lin;
  private int lio;
  private ac.a lip;
  private ac.a liq;
  private LinkedList<String> lir;
  private int mIndex;
  private final com.tencent.mm.ai.b rr;
  
  public e(int paramInt)
  {
    this(new LinkedList(), paramInt, lil);
    AppMethodBeat.i(62337);
    AppMethodBeat.o(62337);
  }
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, 0, lim);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62338);
    this.lik = new ArrayList();
    this.lin = new ArrayList();
    this.mIndex = 0;
    this.lio = 0;
    this.lir = new LinkedList();
    b.a locala = new b.a();
    locala.fsX = new hz();
    locala.fsY = new ia();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.mIndex = 0;
    this.lio = paramInt2;
    this.lir = paramLinkedList;
    this.lii = paramInt1;
    if (this.lii == 1)
    {
      this.lip = ac.a.yxV;
      this.liq = ac.a.yxZ;
      AppMethodBeat.o(62338);
      return;
    }
    this.lip = ac.a.yxU;
    this.liq = ac.a.yxY;
    AppMethodBeat.o(62338);
  }
  
  private void a(ia paramia)
  {
    AppMethodBeat.i(62340);
    ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.lii) });
    if (paramia == null)
    {
      ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(62340);
      return;
    }
    if ((paramia.wuz == null) || (paramia.wuz.size() <= 0))
    {
      ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(62340);
      return;
    }
    paramia = paramia.wuz.iterator();
    while (paramia.hasNext())
    {
      zg localzg = (zg)paramia.next();
      if (bo.isNullOrNil(localzg.Md5))
      {
        ab.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localzg });
      }
      else
      {
        Object localObject = localzg.Md5.toLowerCase();
        this.lik.add(localObject);
        localObject = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localzg, (EmojiInfo)localObject);
        if (this.lii == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.lin.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.yPm;
        }
      }
    }
    AppMethodBeat.o(62340);
  }
  
  public final ia blA()
  {
    if (this.rr == null) {
      return null;
    }
    return (ia)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(62341);
    this.callback = paramf;
    paramf = (hz)this.rr.fsV.fta;
    paramf.wux = this.mIndex;
    paramf.ReqType = this.lio;
    paramf.wuy = this.lir;
    paramf.wsX = this.lii;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(62341);
    return i;
  }
  
  public final int getType()
  {
    return 697;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62339);
    ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.lio == lil)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(164L, 1L, 1L, false);
        g.RL().Ru().set(this.liq, Long.valueOf(System.currentTimeMillis() + 3600000L));
        g.RL().Ru().set(this.lip, Boolean.TRUE);
        AppMethodBeat.o(62339);
        return;
      }
      paramq = (ia)this.rr.fsW.fta;
      paramArrayOfByte = (hz)this.rr.fsV.fta;
      if ((paramq.fKi == 0) && ((paramq.wsV == null) || (paramq.wsV.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(62339);
        return;
      }
      if (paramq.fKi == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        g.RL().Ru().set(this.liq, Long.valueOf(System.currentTimeMillis() + 86400000L));
        g.RL().Ru().set(this.lip, Boolean.FALSE);
        a(paramq);
        if (this.lin == null) {}
        for (paramInt1 = 0;; paramInt1 = this.lin.size())
        {
          ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.lik;
          if ((paramString != null) && (paramString.size() > 0)) {
            break;
          }
          ab.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          g.RL().Ru().set(ac.a.yxM, Boolean.FALSE);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(62339);
          return;
        }
        if (paramString.size() < com.tencent.mm.emoji.a.h.OK()) {
          g.RL().Ru().set(ac.a.yxM, Boolean.FALSE);
        }
        ((Boolean)g.RL().Ru().get(ac.a.yxP, Boolean.TRUE)).booleanValue();
        com.tencent.mm.storage.at.dxt().yNn.m(this.lii, this.lin);
        g.RL().Ru().set(ac.a.yxP, Boolean.FALSE);
        paramq = com.tencent.mm.storage.at.dxt().yNn;
        paramInt1 = this.lii;
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
        long l = System.currentTimeMillis();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
          label524:
          paramString = (ArrayList)com.tencent.mm.storage.at.dxt().yNn.NJ(0);
          if (paramString.size() <= 0) {
            break label853;
          }
          ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
          com.tencent.mm.plugin.report.service.h.qsU.e(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.lii) });
          if (com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext())) {
            com.tencent.mm.plugin.report.service.h.qsU.e(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.lii) });
          }
          label639:
          if (this.lii != 1) {
            break label880;
          }
          com.tencent.mm.emoji.a.d.Oz().cm(true);
          paramString = EmojiSyncManager.exH;
          EmojiSyncManager.a.Ph().cp(false);
        }
        for (;;)
        {
          paramString = com.tencent.mm.emoji.a.e.ewz;
          com.tencent.mm.emoji.a.e.OE();
          a.ymk.l(new of());
          break;
          Object localObject = paramq.NG(paramInt1);
          if (((List)localObject).size() <= 0)
          {
            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
            break label524;
          }
          paramArrayOfByte = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (!paramString.contains(str.toLowerCase()))
            {
              paramArrayOfByte.add(str);
              ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { str });
            }
          }
          paramq.t(paramArrayOfByte, paramInt1);
          ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
          break label524;
          label853:
          g.RL().Ru().set(this.lip, Boolean.FALSE);
          ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
          break label639;
          label880:
          com.tencent.mm.emoji.a.d.Oz().ck(true);
          com.tencent.mm.emoji.a.d.Oz().cj(true);
          paramString = EmojiSyncManager.exH;
          EmojiSyncManager.a.Pg().cp(false);
        }
      }
      ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.wux), Integer.valueOf(paramq.wsV.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.wux = paramq.wux;
      this.mIndex = paramArrayOfByte.wux;
      a(paramq);
      paramInt2 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0) {
        ab.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
      }
      AppMethodBeat.o(62339);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(62339);
      return;
    }
    paramq = (ia)this.rr.fsW.fta;
    if ((paramq.wuz == null) || (paramq.wuz.size() <= 0)) {
      ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(62339);
      return;
      com.tencent.mm.storage.at.dxt().yNn.eT(paramq.wuz);
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */