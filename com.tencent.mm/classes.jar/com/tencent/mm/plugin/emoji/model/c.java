package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.ak.f
{
  public a pKA;
  public HashMap<Long, String> pKw;
  private boolean pKx;
  List<b> pKy;
  private wf pKz;
  
  public c()
  {
    AppMethodBeat.i(108574);
    this.pKw = new HashMap();
    this.pKx = false;
    this.pKy = new LinkedList();
    g.ajQ().gDv.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private long a(bd parambd, EmojiInfo paramEmojiInfo, e.a parama)
  {
    AppMethodBeat.i(108583);
    ae.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambd.md5, paramEmojiInfo.field_md5, Long.valueOf(parambd.dCd) });
    long l;
    if (parambd.dCd != 0L)
    {
      localObject = ((l)g.ab(l.class)).doJ().aJ(parambd.talker, parambd.dCd);
      if (((ei)localObject).field_msgSvrId == parambd.dCd)
      {
        l = ((ei)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((l)g.ab(l.class)).azF().BH(parambd.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).ght == 0))
    {
      localObject = new an(parambd.talker);
      ((an)localObject).setType(2);
      ((l)g.ab(l.class)).azF().an((an)localObject);
    }
    localObject = new bv();
    ((bv)localObject).setType(47);
    ((bv)localObject).ui(parambd.talker);
    int i;
    boolean bool;
    if (v.zK(parambd.iwS))
    {
      i = 1;
      ((bv)localObject).kt(i);
      ((bv)localObject).uj(paramEmojiInfo.Lj());
      ((bv)localObject).qM(parambd.dCd);
      String str = parambd.iwS;
      if ((paramEmojiInfo.Ee()) || (paramEmojiInfo.isGif())) {
        break label551;
      }
      bool = true;
      label269:
      ((bv)localObject).setContent(az.a(str, 0L, bool, paramEmojiInfo.Lj(), false, parambd.JfN));
      ((bv)localObject).qN(bl.B(((ei)localObject).field_talker, parambd.createTime));
      ((bv)localObject).setStatus(3);
      if (!bu.isNullOrNil(parambd.eNd)) {
        ((bv)localObject).tk(parambd.eNd);
      }
      if (parama != null) {
        break label557;
      }
      i = parambd.eNc;
      if (i != 0)
      {
        ((bv)localObject).setFlag(i);
        if ((((ei)localObject).field_msgId == 0L) && (((ei)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((bv)localObject).qN(parambd.createTime);
        }
      }
      if (parambd.iAg != 0) {
        ((bv)localObject).qP(parambd.iAg);
      }
      ae.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambd.iAg) });
    }
    for (;;)
    {
      if ((this.pKw != null) && (this.pKw.containsKey(Long.valueOf(((ei)localObject).field_msgSvrId))))
      {
        ae.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((bv)localObject).setContent((String)this.pKw.get(Long.valueOf(((ei)localObject).field_msgSvrId)));
        ((bv)localObject).setType(10000);
        this.pKw.remove(Long.valueOf(((ei)localObject).field_msgSvrId));
      }
      l = bl.v((bv)localObject);
      if (!v.zK(parambd.iwS)) {
        uH(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label551:
      bool = false;
      break label269;
      label557:
      bl.a((bv)localObject, parama);
    }
  }
  
  private static EmojiInfo a(bd parambd)
  {
    AppMethodBeat.i(108581);
    ae.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { parambd.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.h.b.b(parambd, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.OAk;
    localEmojiInfo.field_catalog = EmojiInfo.OzU;
    k.getEmojiStorageMgr().JfU.I(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final bd parambd, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.gkR;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, true, new i.a()
    {
      public final void dg(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        c.b(parambd);
        if (c.this.pKA != null) {
          c.this.pKA.a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  static void b(bd parambd)
  {
    AppMethodBeat.i(108584);
    if (parambd == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((l)g.ab(l.class)).doJ().a(new i.c(parambd.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  private static void uH(long paramLong)
  {
    AppMethodBeat.i(108575);
    bv localbv = ((l)g.ab(l.class)).doJ().ys(paramLong);
    ((aw)((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbv);
    AppMethodBeat.o(108575);
  }
  
  public final void a(bd parambd, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(108579);
    if (parambd == null)
    {
      ae.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(108579);
      return;
    }
    if ((parama != null) && (parama.gte != null) && (parama.gte.xrk == parambd.dCd))
    {
      parambd.eNc = bl.d(parama);
      parambd.iAg = parama.gte.FNN;
      parambd.createTime = parama.gte.CreateTime;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().JfU.aWl(parambd.md5);
    if (localEmojiInfo != null)
    {
      ae.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, parambd.md5, Long.valueOf(parambd.dCd) });
      com.tencent.mm.plugin.emoji.h.b.b(parambd, localEmojiInfo);
      k.getEmojiStorageMgr().JfU.K(localEmojiInfo);
    }
    for (;;)
    {
      if (parambd.JfR) {
        a(parambd, localEmojiInfo, parama);
      }
      ae.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.Lj(), Boolean.valueOf(localEmojiInfo.fxn()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.fxn()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(parambd, localEmojiInfo);
      AppMethodBeat.o(108579);
      return;
      ae.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { parambd.md5 });
      localEmojiInfo = a(parambd);
    }
    ae.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(parambd);
    label288:
    AppMethodBeat.o(108579);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bv parambv)
  {
    AppMethodBeat.i(108576);
    if ((bu.isNullOrNil(paramString)) || (paramEmojiInfo == null))
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
      bool1 = k.cik().acy(paramEmojiInfo.field_groupId);
      ae.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (parambv != null) {
        break label359;
      }
      parambv = new bv();
      if ((paramEmojiInfo.field_type != EmojiInfo.OAe) && (paramEmojiInfo.field_type != EmojiInfo.OAf)) {
        break label344;
      }
      parambv.setType(1048625);
      parambv.ui(paramString);
      parambv.kt(1);
      String str = v.aAC();
      if ((paramEmojiInfo.Ee()) || (paramEmojiInfo.isGif())) {
        break label353;
      }
      bool2 = true;
      parambv.setContent(az.a(str, l2, bool2, paramEmojiInfo.Lj(), bool1, ""));
      parambv.uj(paramEmojiInfo.Lj());
      parambv.qN(bl.BQ(parambv.field_talker));
      l1 = ((l)g.ab(l.class)).doJ().ar(parambv);
    }
    for (;;)
    {
      ae.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.Lj(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.pKy.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.pKx) || (this.pKy.size() == 1))
      {
        this.pKx = true;
        g.ajQ().gDv.a(new r(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      acI(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(108576);
      return;
      k.cik().chW();
      break;
      label344:
      parambv.setType(47);
      break label110;
      label353:
      bool2 = false;
      break label142;
      label359:
      l1 = parambv.field_msgId;
      parambv = az.aVt(parambv.field_content);
      if (parambv.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = parambv.time;
    }
  }
  
  public final void acI(String paramString)
  {
    AppMethodBeat.i(108577);
    g.ajU().aw(new c.1(this, paramString));
    AppMethodBeat.o(108577);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108582);
    ae.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof r))
    {
      if (this.pKy.size() <= 0)
      {
        this.pKx = false;
        AppMethodBeat.o(108582);
        return;
      }
      paramString = (b)this.pKy.remove(0);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label281;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 35L, 1L, true);
    }
    label281:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      paramn = ((l)g.ab(l.class)).doJ().ys(paramString.msgId);
      paramn.setStatus(paramInt1);
      ((l)g.ab(l.class)).doJ().a(paramString.msgId, paramn);
      if (this.pKy.size() > 0)
      {
        paramString = (b)this.pKy.get(0);
        g.ajQ().gDv.a(new r(paramString.dsN, paramString.dsk, paramString.dnk, paramString.msgId), 0);
      }
      for (;;)
      {
        if (this.pKz == null) {
          this.pKz = new wf();
        }
        this.pKz.dLK.dpp = paramString.dnk.field_groupId;
        com.tencent.mm.sdk.b.a.IvT.l(this.pKz);
        AppMethodBeat.o(108582);
        return;
        this.pKx = false;
      }
    }
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    bd localbd = bd.H(paramEmojiInfo);
    if (localbd == null)
    {
      ae.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108578);
      return true;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localbd.talker = str;
      localbd.JfR = false;
      a(localbd, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      acI(paramEmojiInfo);
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
    EmojiInfo dnk;
    String dsN;
    String dsk;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.dsk = paramString1;
      this.dnk = paramEmojiInfo;
      this.dsN = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */