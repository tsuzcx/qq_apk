package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  public static int pMc = 0;
  public static int pMd = 1;
  private com.tencent.mm.ak.f callback;
  private int mIndex;
  private int pLZ;
  private ArrayList<String> pMb;
  private ArrayList<EmojiInfo> pMe;
  private int pMf;
  private am.a pMg;
  private am.a pMh;
  private LinkedList<String> pMi;
  private final com.tencent.mm.ak.b rr;
  
  public e(int paramInt)
  {
    this(new LinkedList(), paramInt, pMc);
    AppMethodBeat.i(104569);
    AppMethodBeat.o(104569);
  }
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, 0, pMd);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104570);
    this.pMb = new ArrayList();
    this.pMe = new ArrayList();
    this.mIndex = 0;
    this.pMf = 0;
    this.pMi = new LinkedList();
    b.a locala = new b.a();
    locala.hQF = new jl();
    locala.hQG = new jm();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.mIndex = 0;
    this.pMf = paramInt2;
    this.pMi = paramLinkedList;
    this.pLZ = paramInt1;
    if (this.pLZ == 1)
    {
      this.pMg = am.a.IKS;
      this.pMh = am.a.IKW;
      AppMethodBeat.o(104570);
      return;
    }
    this.pMg = am.a.IKR;
    this.pMh = am.a.IKV;
    AppMethodBeat.o(104570);
  }
  
  private void a(jm paramjm)
  {
    AppMethodBeat.i(104572);
    ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.pLZ) });
    if (paramjm == null)
    {
      ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramjm.FUH == null) || (paramjm.FUH.size() <= 0))
    {
      ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramjm = paramjm.FUH.iterator();
    while (paramjm.hasNext())
    {
      agk localagk = (agk)paramjm.next();
      if (bu.isNullOrNil(localagk.Md5))
      {
        ae.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localagk });
      }
      else
      {
        Object localObject = localagk.Md5.toLowerCase();
        this.pMb.add(localObject);
        localObject = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localagk, (EmojiInfo)localObject);
        if (this.pLZ == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.pMe.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.OAa;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final jm cir()
  {
    if (this.rr == null) {
      return null;
    }
    return (jm)this.rr.hQE.hQJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(104573);
    this.callback = paramf;
    paramf = (jl)this.rr.hQD.hQJ;
    paramf.FUF = this.mIndex;
    paramf.ReqType = this.pMf;
    paramf.FUG = this.pMi;
    paramf.uqG = this.pLZ;
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
    ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.pMf == pMc)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.g.ajR().ajA().set(this.pMh, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.g.ajR().ajA().set(this.pMg, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      paramq = (jm)this.rr.hQE.hQJ;
      paramArrayOfByte = (jl)this.rr.hQD.hQJ;
      if ((paramq.ijY == 0) && ((paramq.FSP == null) || (paramq.FSP.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (paramq.ijY == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.g.ajR().ajA().set(this.pMh, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.g.ajR().ajA().set(this.pMg, Boolean.FALSE);
        a(paramq);
        if (this.pMe == null) {}
        for (paramInt1 = 0;; paramInt1 = this.pMe.size())
        {
          ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.pMb;
          if ((paramString != null) && (paramString.size() > 0)) {
            break;
          }
          ae.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKJ, Boolean.FALSE);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
        }
        if (paramString.size() < m.afk()) {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKJ, Boolean.FALSE);
        }
        ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKM, Boolean.TRUE)).booleanValue();
        be.fvc().JfU.t(this.pLZ, this.pMe);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKM, Boolean.FALSE);
        paramq = be.fvc().JfU;
        paramInt1 = this.pLZ;
        ae.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
        long l = System.currentTimeMillis();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ae.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
          label524:
          paramString = (ArrayList)be.fvc().JfU.abO(0);
          if (paramString.size() <= 0) {
            break label853;
          }
          ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
          com.tencent.mm.plugin.report.service.g.yxI.f(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pLZ) });
          if (az.isWifi(ak.getContext())) {
            com.tencent.mm.plugin.report.service.g.yxI.f(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.pLZ) });
          }
          label639:
          if (this.pLZ != 1) {
            break label880;
          }
          i.aeX().jdMethod_do(true);
          paramString = EmojiSyncManager.grP;
          EmojiSyncManager.a.agy().dt(false);
        }
        for (;;)
        {
          paramString = j.gmz;
          j.afe();
          a.IvT.l(new qp());
          break;
          Object localObject = paramq.abL(paramInt1);
          if (((List)localObject).size() <= 0)
          {
            ae.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
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
              ae.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { str });
            }
          }
          paramq.C(paramArrayOfByte, paramInt1);
          ae.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
          break label524;
          label853:
          com.tencent.mm.kernel.g.ajR().ajA().set(this.pMg, Boolean.FALSE);
          ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
          break label639;
          label880:
          i.aeX().dm(true);
          i.aeX().dl(true);
          paramString = EmojiSyncManager.grP;
          EmojiSyncManager.a.agx().dt(false);
        }
      }
      ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.FUF), Integer.valueOf(paramq.FSP.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.FUF = paramq.FUF;
      this.mIndex = paramArrayOfByte.FUF;
      a(paramq);
      paramInt2 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0) {
        ae.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
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
    paramq = (jm)this.rr.hQE.hQJ;
    if ((paramq.FUH == null) || (paramq.FUH.size() <= 0)) {
      ae.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      be.fvc().JfU.hX(paramq.FUH);
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */