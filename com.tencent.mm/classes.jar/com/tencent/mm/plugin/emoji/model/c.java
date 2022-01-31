package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements f
{
  public HashMap<Long, String> lhb;
  private boolean lhc;
  List<c.b> lhd;
  private tb lhe;
  public c.a lhf;
  
  public c()
  {
    AppMethodBeat.i(53034);
    this.lhb = new HashMap();
    this.lhc = false;
    this.lhd = new LinkedList();
    g.RK().eHt.a(175, this);
    AppMethodBeat.o(53034);
  }
  
  private long a(as paramas, EmojiInfo paramEmojiInfo, e.a parama)
  {
    AppMethodBeat.i(139680);
    ab.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { paramas.cqq, paramEmojiInfo.field_md5, Long.valueOf(paramas.cFn) });
    long l;
    if (paramas.cFn != 0L)
    {
      localObject = ((j)g.E(j.class)).bPQ().ag(paramas.talker, paramas.cFn);
      if (((dd)localObject).field_msgSvrId == paramas.cFn)
      {
        l = ((dd)localObject).field_msgId;
        AppMethodBeat.o(139680);
        return l;
      }
    }
    Object localObject = ((j)g.E(j.class)).YA().arw(paramas.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.n.a)localObject).euF == 0))
    {
      localObject = new ad(paramas.talker);
      ((ad)localObject).setType(2);
      ((j)g.E(j.class)).YA().Y((ad)localObject);
    }
    localObject = new bi();
    ((bi)localObject).setType(47);
    ((bi)localObject).kj(paramas.talker);
    int i;
    boolean bool;
    if (com.tencent.mm.model.r.nB(paramas.fXq))
    {
      i = 1;
      ((bi)localObject).hL(i);
      ((bi)localObject).kk(paramEmojiInfo.Al());
      ((bi)localObject).fP(paramas.cFn);
      String str = paramas.fXq;
      if ((paramEmojiInfo.vY()) || (paramEmojiInfo.isGif())) {
        break label551;
      }
      bool = true;
      label269:
      ((bi)localObject).setContent(ap.a(str, 0L, bool, paramEmojiInfo.Al(), false, paramas.yNg));
      ((bi)localObject).fQ(bf.x(((dd)localObject).field_talker, paramas.createTime));
      ((bi)localObject).setStatus(3);
      if (!bo.isNullOrNil(paramas.dns)) {
        ((bi)localObject).jl(paramas.dns);
      }
      if (parama != null) {
        break label557;
      }
      i = paramas.dnr;
      if (i != 0)
      {
        ((bi)localObject).hV(i);
        if ((((dd)localObject).field_msgId == 0L) && (((dd)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((bi)localObject).fQ(paramas.createTime);
        }
      }
      if (paramas.gaE != 0) {
        ((bi)localObject).fS(paramas.gaE);
      }
      ab.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramas.gaE) });
    }
    for (;;)
    {
      if ((this.lhb != null) && (this.lhb.containsKey(Long.valueOf(((dd)localObject).field_msgSvrId))))
      {
        ab.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((bi)localObject).setContent((String)this.lhb.get(Long.valueOf(((dd)localObject).field_msgSvrId)));
        ((bi)localObject).setType(10000);
        this.lhb.remove(Long.valueOf(((dd)localObject).field_msgSvrId));
      }
      l = bf.l((bi)localObject);
      if (!com.tencent.mm.model.r.nB(paramas.fXq)) {
        iY(l);
      }
      AppMethodBeat.o(139680);
      return l;
      i = 0;
      break;
      label551:
      bool = false;
      break label269;
      label557:
      bf.a((bi)localObject, parama);
    }
  }
  
  private static EmojiInfo a(as paramas)
  {
    AppMethodBeat.i(53041);
    ab.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { paramas.cqq });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    as.b(paramas, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.yPw;
    localEmojiInfo.field_catalog = EmojiInfo.yPg;
    i.getEmojiStorageMgr().yNn.H(localEmojiInfo);
    AppMethodBeat.o(53041);
    return localEmojiInfo;
  }
  
  private void a(as paramas, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(139679);
    com.tencent.mm.emoji.loader.a locala = com.tencent.mm.emoji.loader.a.evk;
    com.tencent.mm.emoji.loader.a.a(paramEmojiInfo, true, new c.2(this, paramas, paramEmojiInfo));
    AppMethodBeat.o(139679);
  }
  
  static void b(as paramas)
  {
    AppMethodBeat.i(53044);
    if (paramas == null)
    {
      AppMethodBeat.o(53044);
      return;
    }
    ((j)g.E(j.class)).bPQ().a(new h.c(paramas.talker, "update", null));
    AppMethodBeat.o(53044);
  }
  
  private static void iY(long paramLong)
  {
    AppMethodBeat.i(53035);
    bi localbi = ((j)g.E(j.class)).bPQ().kB(paramLong);
    ((aq)((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbi);
    AppMethodBeat.o(53035);
  }
  
  public final void KS(String paramString)
  {
    AppMethodBeat.i(53037);
    g.RO().ac(new c.1(this, paramString));
    AppMethodBeat.o(53037);
  }
  
  public final void a(as paramas, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(53039);
    if (paramas == null)
    {
      ab.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(53039);
      return;
    }
    if ((parama != null) && (parama.eyJ != null) && (parama.eyJ.pIG == paramas.cFn))
    {
      paramas.dnr = bf.d(parama);
      paramas.gaE = parama.eyJ.woW;
      paramas.createTime = parama.eyJ.CreateTime;
    }
    EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().yNn.asP(paramas.cqq);
    if (localEmojiInfo != null)
    {
      ab.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, paramas.cqq, Long.valueOf(paramas.cFn) });
      as.b(paramas, localEmojiInfo);
      i.getEmojiStorageMgr().yNn.J(localEmojiInfo);
    }
    for (;;)
    {
      if (paramas.yNk) {
        a(paramas, localEmojiInfo, parama);
      }
      ab.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.Al(), Boolean.valueOf(localEmojiInfo.dzn()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.dzn()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramas, localEmojiInfo);
      AppMethodBeat.o(53039);
      return;
      ab.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { paramas.cqq });
      localEmojiInfo = a(paramas);
    }
    ab.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(paramas);
    label288:
    AppMethodBeat.o(53039);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bi parambi)
  {
    AppMethodBeat.i(53036);
    if ((bo.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(53036);
      return;
    }
    if (com.tencent.mm.vfs.e.avI(paramEmojiInfo.dQB()) <= 0L)
    {
      paramEmojiInfo.field_state = EmojiInfo.yPs;
      i.getEmojiStorageMgr().yNn.J(paramEmojiInfo);
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    label140:
    boolean bool2;
    label172:
    long l1;
    if (com.tencent.mm.plugin.emoji.h.b.x(paramEmojiInfo))
    {
      bool1 = i.blt().KI(paramEmojiInfo.field_groupId);
      ab.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (parambi != null) {
        break label389;
      }
      parambi = new bi();
      if ((paramEmojiInfo.field_type != EmojiInfo.yPq) && (paramEmojiInfo.field_type != EmojiInfo.yPr)) {
        break label374;
      }
      parambi.setType(1048625);
      parambi.kj(paramString);
      parambi.hL(1);
      String str = com.tencent.mm.model.r.Zn();
      if ((paramEmojiInfo.vY()) || (paramEmojiInfo.isGif())) {
        break label383;
      }
      bool2 = true;
      parambi.setContent(ap.a(str, l2, bool2, paramEmojiInfo.Al(), bool1, ""));
      parambi.kk(paramEmojiInfo.Al());
      parambi.fQ(bf.py(parambi.field_talker));
      l1 = ((j)g.E(j.class)).bPQ().Z(parambi);
    }
    for (;;)
    {
      ab.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.Al(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.lhd.add(new c.b(this, l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.lhc) || (this.lhd.size() == 1))
      {
        this.lhc = true;
        g.RK().eHt.a(new com.tencent.mm.plugin.emoji.f.r(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      KS(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(53036);
      return;
      i.blt().blj();
      break;
      label374:
      parambi.setType(47);
      break label140;
      label383:
      bool2 = false;
      break label172;
      label389:
      l1 = parambi.field_msgId;
      parambi = ap.arZ(parambi.field_content);
      if (parambi.time == 0L)
      {
        AppMethodBeat.o(53036);
        return;
      }
      l2 = parambi.time;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53042);
    ab.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof com.tencent.mm.plugin.emoji.f.r))
    {
      if (this.lhd.size() <= 0)
      {
        this.lhc = false;
        AppMethodBeat.o(53042);
        return;
      }
      paramString = (c.b)this.lhd.remove(0);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label281;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 35L, 1L, true);
    }
    label281:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      paramm = ((j)g.E(j.class)).bPQ().kB(paramString.cpO);
      paramm.setStatus(paramInt1);
      ((j)g.E(j.class)).bPQ().a(paramString.cpO, paramm);
      if (this.lhd.size() > 0)
      {
        paramString = (c.b)this.lhd.get(0);
        g.RK().eHt.a(new com.tencent.mm.plugin.emoji.f.r(paramString.ctV, paramString.toUserName, paramString.cos, paramString.cpO), 0);
      }
      for (;;)
      {
        if (this.lhe == null) {
          this.lhe = new tb();
        }
        this.lhe.cJC.cqx = paramString.cos.field_groupId;
        com.tencent.mm.sdk.b.a.ymk.l(this.lhe);
        AppMethodBeat.o(53042);
        return;
        this.lhc = false;
      }
    }
  }
  
  @Deprecated
  public final boolean t(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(53038);
    as localas = as.G(paramEmojiInfo);
    if (localas == null)
    {
      ab.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(53038);
      return true;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localas.talker = str;
      localas.yNk = false;
      a(localas, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      KS(paramEmojiInfo);
      AppMethodBeat.o(53038);
      return true;
      str = paramEmojiInfo.talker;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */