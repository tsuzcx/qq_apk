package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.a.l;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  public static int oyo = 0;
  public static int oyp = 1;
  private com.tencent.mm.al.g callback;
  private int mIndex;
  private int oyl;
  private ArrayList<String> oyn;
  private ArrayList<EmojiInfo> oyq;
  private int oyr;
  private ae.a oys;
  private ae.a oyt;
  private LinkedList<String> oyu;
  private final com.tencent.mm.al.b rr;
  
  public e(int paramInt)
  {
    this(new LinkedList(), paramInt, oyo);
    AppMethodBeat.i(104569);
    AppMethodBeat.o(104569);
  }
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, 0, oyp);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104570);
    this.oyn = new ArrayList();
    this.oyq = new ArrayList();
    this.mIndex = 0;
    this.oyr = 0;
    this.oyu = new LinkedList();
    b.a locala = new b.a();
    locala.gUU = new iw();
    locala.gUV = new ix();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.mIndex = 0;
    this.oyr = paramInt2;
    this.oyu = paramLinkedList;
    this.oyl = paramInt1;
    if (this.oyl == 1)
    {
      this.oys = ae.a.Fgp;
      this.oyt = ae.a.Fgt;
      AppMethodBeat.o(104570);
      return;
    }
    this.oys = ae.a.Fgo;
    this.oyt = ae.a.Fgs;
    AppMethodBeat.o(104570);
  }
  
  private void a(ix paramix)
  {
    AppMethodBeat.i(104572);
    ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.oyl) });
    if (paramix == null)
    {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramix.CEq == null) || (paramix.CEq.size() <= 0))
    {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramix = paramix.CEq.iterator();
    while (paramix.hasNext())
    {
      act localact = (act)paramix.next();
      if (bt.isNullOrNil(localact.Md5))
      {
        ad.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localact });
      }
      else
      {
        Object localObject = localact.Md5.toLowerCase();
        this.oyn.add(localObject);
        localObject = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localact, (EmojiInfo)localObject);
        if (this.oyl == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.oyq.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.LBW;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final ix bVk()
  {
    if (this.rr == null) {
      return null;
    }
    return (ix)this.rr.gUT.gUX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(104573);
    this.callback = paramg;
    paramg = (iw)this.rr.gUS.gUX;
    paramg.CEo = this.mIndex;
    paramg.ReqType = this.oyr;
    paramg.CEp = this.oyu;
    paramg.CCC = this.oyl;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(104573);
    return i;
  }
  
  public final int getType()
  {
    return 697;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104571);
    ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.oyr == oyo)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.g.afB().afk().set(this.oyt, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.g.afB().afk().set(this.oys, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      paramq = (ix)this.rr.gUT.gUX;
      paramArrayOfByte = (iw)this.rr.gUS.gUX;
      if ((paramq.hno == 0) && ((paramq.CCA == null) || (paramq.CCA.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (paramq.hno == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.g.afB().afk().set(this.oyt, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.g.afB().afk().set(this.oys, Boolean.FALSE);
        a(paramq);
        if (this.oyq == null) {}
        for (paramInt1 = 0;; paramInt1 = this.oyq.size())
        {
          ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.oyn;
          if ((paramString != null) && (paramString.size() > 0)) {
            break;
          }
          ad.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgg, Boolean.FALSE);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
        }
        if (paramString.size() < l.abt()) {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgg, Boolean.FALSE);
        }
        ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fgj, Boolean.TRUE)).booleanValue();
        aw.eLx().FyY.n(this.oyl, this.oyq);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgj, Boolean.FALSE);
        paramq = aw.eLx().FyY;
        paramInt1 = this.oyl;
        ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
        long l = System.currentTimeMillis();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
          label524:
          paramString = (ArrayList)aw.eLx().FyY.WN(0);
          if (paramString.size() <= 0) {
            break label853;
          }
          ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
          com.tencent.mm.plugin.report.service.h.vKh.f(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.oyl) });
          if (ay.isWifi(aj.getContext())) {
            com.tencent.mm.plugin.report.service.h.vKh.f(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.oyl) });
          }
          label639:
          if (this.oyl != 1) {
            break label880;
          }
          com.tencent.mm.emoji.a.h.abj().dn(true);
          paramString = EmojiSyncManager.fRW;
          EmojiSyncManager.a.acy().dr(false);
        }
        for (;;)
        {
          paramString = i.fMT;
          i.abn();
          a.ESL.l(new pu());
          break;
          Object localObject = paramq.WK(paramInt1);
          if (((List)localObject).size() <= 0)
          {
            ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
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
              ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { str });
            }
          }
          paramq.z(paramArrayOfByte, paramInt1);
          ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
          break label524;
          label853:
          com.tencent.mm.kernel.g.afB().afk().set(this.oys, Boolean.FALSE);
          ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
          break label639;
          label880:
          com.tencent.mm.emoji.a.h.abj().dl(true);
          com.tencent.mm.emoji.a.h.abj().dk(true);
          paramString = EmojiSyncManager.fRW;
          EmojiSyncManager.a.acx().dr(false);
        }
      }
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.CEo), Integer.valueOf(paramq.CCA.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.CEo = paramq.CEo;
      this.mIndex = paramArrayOfByte.CEo;
      a(paramq);
      paramInt2 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0) {
        ad.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
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
    paramq = (ix)this.rr.gUT.gUX;
    if ((paramq.CEq == null) || (paramq.CEq.size() <= 0)) {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      aw.eLx().FyY.ho(paramq.CEq);
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */