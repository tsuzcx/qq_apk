package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  public static int pFy = 0;
  public static int pFz = 1;
  private com.tencent.mm.al.f callback;
  private int mIndex;
  private ArrayList<EmojiInfo> pFA;
  private int pFB;
  private al.a pFC;
  private al.a pFD;
  private LinkedList<String> pFE;
  private int pFv;
  private ArrayList<String> pFx;
  private final com.tencent.mm.al.b rr;
  
  public e(int paramInt)
  {
    this(new LinkedList(), paramInt, pFy);
    AppMethodBeat.i(104569);
    AppMethodBeat.o(104569);
  }
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, 0, pFz);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104570);
    this.pFx = new ArrayList();
    this.pFA = new ArrayList();
    this.mIndex = 0;
    this.pFB = 0;
    this.pFE = new LinkedList();
    b.a locala = new b.a();
    locala.hNM = new jl();
    locala.hNN = new jm();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.mIndex = 0;
    this.pFB = paramInt2;
    this.pFE = paramLinkedList;
    this.pFv = paramInt1;
    if (this.pFv == 1)
    {
      this.pFC = al.a.Iqw;
      this.pFD = al.a.IqA;
      AppMethodBeat.o(104570);
      return;
    }
    this.pFC = al.a.Iqv;
    this.pFD = al.a.Iqz;
    AppMethodBeat.o(104570);
  }
  
  private void a(jm paramjm)
  {
    AppMethodBeat.i(104572);
    ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.pFv) });
    if (paramjm == null)
    {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramjm.FCm == null) || (paramjm.FCm.size() <= 0))
    {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramjm = paramjm.FCm.iterator();
    while (paramjm.hasNext())
    {
      agb localagb = (agb)paramjm.next();
      if (bt.isNullOrNil(localagb.Md5))
      {
        ad.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localagb });
      }
      else
      {
        Object localObject = localagb.Md5.toLowerCase();
        this.pFx.add(localObject);
        localObject = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localagb, (EmojiInfo)localObject);
        if (this.pFv == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.pFA.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.OeT;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final jm chb()
  {
    if (this.rr == null) {
      return null;
    }
    return (jm)this.rr.hNL.hNQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(104573);
    this.callback = paramf;
    paramf = (jl)this.rr.hNK.hNQ;
    paramf.FCk = this.mIndex;
    paramf.ReqType = this.pFB;
    paramf.FCl = this.pFE;
    paramf.FAu = this.pFv;
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
    if (this.pFB == pFy)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.g.ajC().ajl().set(this.pFD, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.g.ajC().ajl().set(this.pFC, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      paramq = (jm)this.rr.hNL.hNQ;
      paramArrayOfByte = (jl)this.rr.hNK.hNQ;
      if ((paramq.ihf == 0) && ((paramq.FAs == null) || (paramq.FAs.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (paramq.ihf == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.g.ajC().ajl().set(this.pFD, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.g.ajC().ajl().set(this.pFC, Boolean.FALSE);
        a(paramq);
        if (this.pFA == null) {}
        for (paramInt1 = 0;; paramInt1 = this.pFA.size())
        {
          ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.pFx;
          if ((paramString != null) && (paramString.size() > 0)) {
            break;
          }
          ad.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqn, Boolean.FALSE);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
        }
        if (paramString.size() < m.aeW()) {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqn, Boolean.FALSE);
        }
        ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iqq, Boolean.TRUE)).booleanValue();
        bd.frc().ILn.r(this.pFv, this.pFA);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqq, Boolean.FALSE);
        paramq = bd.frc().ILn;
        paramInt1 = this.pFv;
        ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
        long l = System.currentTimeMillis();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
          label524:
          paramString = (ArrayList)bd.frc().ILn.abg(0);
          if (paramString.size() <= 0) {
            break label853;
          }
          ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
          com.tencent.mm.plugin.report.service.g.yhR.f(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pFv) });
          if (ay.isWifi(aj.getContext())) {
            com.tencent.mm.plugin.report.service.g.yhR.f(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.pFv) });
          }
          label639:
          if (this.pFv != 1) {
            break label880;
          }
          i.aeL().jdMethod_do(true);
          paramString = EmojiSyncManager.gpu;
          EmojiSyncManager.a.agk().dt(false);
        }
        for (;;)
        {
          paramString = j.gkf;
          j.aeQ();
          a.IbL.l(new qo());
          break;
          Object localObject = paramq.abd(paramInt1);
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
          paramq.B(paramArrayOfByte, paramInt1);
          ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
          break label524;
          label853:
          com.tencent.mm.kernel.g.ajC().ajl().set(this.pFC, Boolean.FALSE);
          ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
          break label639;
          label880:
          i.aeL().dm(true);
          i.aeL().dl(true);
          paramString = EmojiSyncManager.gpu;
          EmojiSyncManager.a.agj().dt(false);
        }
      }
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.FCk), Integer.valueOf(paramq.FAs.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.FCk = paramq.FCk;
      this.mIndex = paramArrayOfByte.FCk;
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
    paramq = (jm)this.rr.hNL.hNQ;
    if ((paramq.FCm == null) || (paramq.FCm.size() <= 0)) {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      bd.frc().ILn.hN(paramq.FCm);
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */