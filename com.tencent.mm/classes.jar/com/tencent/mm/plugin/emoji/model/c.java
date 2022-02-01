package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.al.f
{
  public HashMap<Long, String> pDS;
  private boolean pDT;
  List<b> pDU;
  private wb pDV;
  public a pDW;
  
  public c()
  {
    AppMethodBeat.i(108574);
    this.pDS = new HashMap();
    this.pDT = false;
    this.pDU = new LinkedList();
    g.ajB().gAO.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private long a(bc parambc, EmojiInfo paramEmojiInfo, e.a parama)
  {
    AppMethodBeat.i(108583);
    ad.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambc.md5, paramEmojiInfo.field_md5, Long.valueOf(parambc.dAY) });
    long l;
    if (parambc.dAY != 0L)
    {
      localObject = ((l)g.ab(l.class)).dlK().aI(parambc.talker, parambc.dAY);
      if (((ei)localObject).field_msgSvrId == parambc.dAY)
      {
        l = ((ei)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((l)g.ab(l.class)).azp().Bf(parambc.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.o.b)localObject).gfj == 0))
    {
      localObject = new am(parambc.talker);
      ((am)localObject).setType(2);
      ((l)g.ab(l.class)).azp().ag((am)localObject);
    }
    localObject = new bu();
    ((bu)localObject).setType(47);
    ((bu)localObject).tN(parambc.talker);
    int i;
    boolean bool;
    if (u.za(parambc.itY))
    {
      i = 1;
      ((bu)localObject).kr(i);
      ((bu)localObject).tO(paramEmojiInfo.Lb());
      ((bu)localObject).qz(parambc.dAY);
      String str = parambc.itY;
      if ((paramEmojiInfo.Eb()) || (paramEmojiInfo.isGif())) {
        break label551;
      }
      bool = true;
      label269:
      ((bu)localObject).setContent(ay.a(str, 0L, bool, paramEmojiInfo.Lb(), false, parambc.ILg));
      ((bu)localObject).qA(bj.B(((ei)localObject).field_talker, parambc.createTime));
      ((bu)localObject).setStatus(3);
      if (!bt.isNullOrNil(parambc.eLs)) {
        ((bu)localObject).sP(parambc.eLs);
      }
      if (parama != null) {
        break label557;
      }
      i = parambc.eLr;
      if (i != 0)
      {
        ((bu)localObject).setFlag(i);
        if ((((ei)localObject).field_msgId == 0L) && (((ei)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((bu)localObject).qA(parambc.createTime);
        }
      }
      if (parambc.ixn != 0) {
        ((bu)localObject).qC(parambc.ixn);
      }
      ad.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambc.ixn) });
    }
    for (;;)
    {
      if ((this.pDS != null) && (this.pDS.containsKey(Long.valueOf(((ei)localObject).field_msgSvrId))))
      {
        ad.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((bu)localObject).setContent((String)this.pDS.get(Long.valueOf(((ei)localObject).field_msgSvrId)));
        ((bu)localObject).setType(10000);
        this.pDS.remove(Long.valueOf(((ei)localObject).field_msgSvrId));
      }
      l = bj.v((bu)localObject);
      if (!u.za(parambc.itY)) {
        uq(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label551:
      bool = false;
      break label269;
      label557:
      bj.a((bu)localObject, parama);
    }
  }
  
  private static EmojiInfo a(bc parambc)
  {
    AppMethodBeat.i(108581);
    ad.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { parambc.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.h.b.b(parambc, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.Ofd;
    localEmojiInfo.field_catalog = EmojiInfo.OeN;
    k.getEmojiStorageMgr().ILn.I(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final bc parambc, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.giz;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, true, new i.a()
    {
      public final void dg(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        c.b(parambc);
        if (c.this.pDW != null) {
          c.this.pDW.a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  static void b(bc parambc)
  {
    AppMethodBeat.i(108584);
    if (parambc == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((l)g.ab(l.class)).dlK().a(new i.c(parambc.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  private static void uq(long paramLong)
  {
    AppMethodBeat.i(108575);
    bu localbu = ((l)g.ab(l.class)).dlK().xY(paramLong);
    ((au)((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbu);
    AppMethodBeat.o(108575);
  }
  
  public final void a(bc parambc, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(108579);
    if (parambc == null)
    {
      ad.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(108579);
      return;
    }
    if ((parama != null) && (parama.gqE != null) && (parama.gqE.xbt == parambc.dAY))
    {
      parambc.eLr = bj.d(parama);
      parambc.ixn = parama.gqE.Fvp;
      parambc.createTime = parama.gqE.CreateTime;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().ILn.aUK(parambc.md5);
    if (localEmojiInfo != null)
    {
      ad.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, parambc.md5, Long.valueOf(parambc.dAY) });
      com.tencent.mm.plugin.emoji.h.b.b(parambc, localEmojiInfo);
      k.getEmojiStorageMgr().ILn.K(localEmojiInfo);
    }
    for (;;)
    {
      if (parambc.ILk) {
        a(parambc, localEmojiInfo, parama);
      }
      ad.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.Lb(), Boolean.valueOf(localEmojiInfo.fOu()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.fOu()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(parambc, localEmojiInfo);
      AppMethodBeat.o(108579);
      return;
      ad.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { parambc.md5 });
      localEmojiInfo = a(parambc);
    }
    ad.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(parambc);
    label288:
    AppMethodBeat.o(108579);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bu parambu)
  {
    AppMethodBeat.i(108576);
    if ((bt.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108576);
      return;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    label110:
    boolean bool2;
    label142:
    long l1;
    if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
    {
      bool1 = k.cgU().abH(paramEmojiInfo.field_groupId);
      ad.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (parambu != null) {
        break label359;
      }
      parambu = new bu();
      if ((paramEmojiInfo.field_type != EmojiInfo.OeX) && (paramEmojiInfo.field_type != EmojiInfo.OeY)) {
        break label344;
      }
      parambu.setType(1048625);
      parambu.tN(paramString);
      parambu.kr(1);
      String str = u.aAm();
      if ((paramEmojiInfo.Eb()) || (paramEmojiInfo.isGif())) {
        break label353;
      }
      bool2 = true;
      parambu.setContent(ay.a(str, l2, bool2, paramEmojiInfo.Lb(), bool1, ""));
      parambu.tO(paramEmojiInfo.Lb());
      parambu.qA(bj.Bo(parambu.field_talker));
      l1 = ((l)g.ab(l.class)).dlK().as(parambu);
    }
    for (;;)
    {
      ad.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.Lb(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.pDU.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.pDT) || (this.pDU.size() == 1))
      {
        this.pDT = true;
        g.ajB().gAO.a(new r(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      abR(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(108576);
      return;
      k.cgU().cgG();
      break;
      label344:
      parambu.setType(47);
      break label110;
      label353:
      bool2 = false;
      break label142;
      label359:
      l1 = parambu.field_msgId;
      parambu = ay.aTS(parambu.field_content);
      if (parambu.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = parambu.time;
    }
  }
  
  public final void abR(String paramString)
  {
    AppMethodBeat.i(108577);
    g.ajF().ay(new c.1(this, paramString));
    AppMethodBeat.o(108577);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108582);
    ad.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof r))
    {
      if (this.pDU.size() <= 0)
      {
        this.pDT = false;
        AppMethodBeat.o(108582);
        return;
      }
      paramString = (b)this.pDU.remove(0);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label281;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 35L, 1L, true);
    }
    label281:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      paramn = ((l)g.ab(l.class)).dlK().xY(paramString.msgId);
      paramn.setStatus(paramInt1);
      ((l)g.ab(l.class)).dlK().a(paramString.msgId, paramn);
      if (this.pDU.size() > 0)
      {
        paramString = (b)this.pDU.get(0);
        g.ajB().gAO.a(new r(paramString.drH, paramString.drf, paramString.dmi, paramString.msgId), 0);
      }
      for (;;)
      {
        if (this.pDV == null) {
          this.pDV = new wb();
        }
        this.pDV.dKv.dok = paramString.dmi.field_groupId;
        com.tencent.mm.sdk.b.a.IbL.l(this.pDV);
        AppMethodBeat.o(108582);
        return;
        this.pDT = false;
      }
    }
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    bc localbc = bc.H(paramEmojiInfo);
    if (localbc == null)
    {
      ad.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108578);
      return true;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localbc.talker = str;
      localbc.ILk = false;
      a(localbc, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      abR(paramEmojiInfo);
      AppMethodBeat.o(108578);
      return true;
      str = paramEmojiInfo.talker;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, EmojiInfo paramEmojiInfo);
  }
  
  final class b
  {
    EmojiInfo dmi;
    String drH;
    String drf;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.drf = paramString1;
      this.dmi = paramEmojiInfo;
      this.drH = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */