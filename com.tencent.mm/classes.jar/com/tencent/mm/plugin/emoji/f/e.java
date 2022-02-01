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
import com.tencent.mm.g.a.qd;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
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
  public static int pbO = 0;
  public static int pbP = 1;
  private com.tencent.mm.ak.g callback;
  private int mIndex;
  private int pbL;
  private ArrayList<String> pbN;
  private ArrayList<EmojiInfo> pbQ;
  private int pbR;
  private ah.a pbS;
  private ah.a pbT;
  private LinkedList<String> pbU;
  private final com.tencent.mm.ak.b rr;
  
  public e(int paramInt)
  {
    this(new LinkedList(), paramInt, pbO);
    AppMethodBeat.i(104569);
    AppMethodBeat.o(104569);
  }
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, 0, pbP);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104570);
    this.pbN = new ArrayList();
    this.pbQ = new ArrayList();
    this.mIndex = 0;
    this.pbR = 0;
    this.pbU = new LinkedList();
    b.a locala = new b.a();
    locala.hvt = new jc();
    locala.hvu = new jd();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.mIndex = 0;
    this.pbR = paramInt2;
    this.pbU = paramLinkedList;
    this.pbL = paramInt1;
    if (this.pbL == 1)
    {
      this.pbS = ah.a.GEd;
      this.pbT = ah.a.GEh;
      AppMethodBeat.o(104570);
      return;
    }
    this.pbS = ah.a.GEc;
    this.pbT = ah.a.GEg;
    AppMethodBeat.o(104570);
  }
  
  private void a(jd paramjd)
  {
    AppMethodBeat.i(104572);
    ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.pbL) });
    if (paramjd == null)
    {
      ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramjd.DWQ == null) || (paramjd.DWQ.size() <= 0))
    {
      ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramjd = paramjd.DWQ.iterator();
    while (paramjd.hasNext())
    {
      ads localads = (ads)paramjd.next();
      if (bs.isNullOrNil(localads.Md5))
      {
        ac.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localads });
      }
      else
      {
        Object localObject = localads.Md5.toLowerCase();
        this.pbN.add(localObject);
        localObject = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.a(localads, (EmojiInfo)localObject);
        if (this.pbL == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.pbQ.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.Jsy;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final jd ccx()
  {
    if (this.rr == null) {
      return null;
    }
    return (jd)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(104573);
    this.callback = paramg;
    paramg = (jc)this.rr.hvr.hvw;
    paramg.DWO = this.mIndex;
    paramg.ReqType = this.pbR;
    paramg.DWP = this.pbU;
    paramg.DUZ = this.pbL;
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
    ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.pbR == pbO)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        h.wUl.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.g.agR().agA().set(this.pbT, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.g.agR().agA().set(this.pbS, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      paramq = (jd)this.rr.hvs.hvw;
      paramArrayOfByte = (jc)this.rr.hvr.hvw;
      if ((paramq.hNR == 0) && ((paramq.DUX == null) || (paramq.DUX.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        h.wUl.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (paramq.hNR == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.g.agR().agA().set(this.pbT, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.g.agR().agA().set(this.pbS, Boolean.FALSE);
        a(paramq);
        if (this.pbQ == null) {}
        for (paramInt1 = 0;; paramInt1 = this.pbQ.size())
        {
          ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.pbN;
          if ((paramString != null) && (paramString.size() > 0)) {
            break;
          }
          ac.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDU, Boolean.FALSE);
          h.wUl.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
        }
        if (paramString.size() < m.acs()) {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDU, Boolean.FALSE);
        }
        ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GDX, Boolean.TRUE)).booleanValue();
        az.faZ().GXZ.q(this.pbL, this.pbQ);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDX, Boolean.FALSE);
        paramq = az.faZ().GXZ;
        paramInt1 = this.pbL;
        ac.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
        long l = System.currentTimeMillis();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          ac.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
          label524:
          paramString = (ArrayList)az.faZ().GXZ.YX(0);
          if (paramString.size() <= 0) {
            break label853;
          }
          ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
          h.wUl.f(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pbL) });
          if (ax.isWifi(ai.getContext())) {
            h.wUl.f(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.pbL) });
          }
          label639:
          if (this.pbL != 1) {
            break label880;
          }
          i.ach().dm(true);
          paramString = EmojiSyncManager.fVR;
          EmojiSyncManager.a.adE().dr(false);
        }
        for (;;)
        {
          paramString = j.fQF;
          j.acm();
          a.GpY.l(new qd());
          break;
          Object localObject = paramq.YU(paramInt1);
          if (((List)localObject).size() <= 0)
          {
            ac.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
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
              ac.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { str });
            }
          }
          paramq.z(paramArrayOfByte, paramInt1);
          ac.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
          break label524;
          label853:
          com.tencent.mm.kernel.g.agR().agA().set(this.pbS, Boolean.FALSE);
          ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
          break label639;
          label880:
          i.ach().dk(true);
          i.ach().dj(true);
          paramString = EmojiSyncManager.fVR;
          EmojiSyncManager.a.adD().dr(false);
        }
      }
      ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.DWO), Integer.valueOf(paramq.DUX.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.DWO = paramq.DWO;
      this.mIndex = paramArrayOfByte.DWO;
      a(paramq);
      paramInt2 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0) {
        ac.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
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
    paramq = (jd)this.rr.hvs.hvw;
    if ((paramq.DWQ == null) || (paramq.DWQ.size() <= 0)) {
      ac.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      az.faZ().GXZ.hB(paramq.DWQ);
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */