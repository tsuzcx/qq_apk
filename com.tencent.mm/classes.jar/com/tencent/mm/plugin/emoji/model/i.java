package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.ym;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements com.tencent.mm.an.i
{
  private boolean uEa;
  List<b> uEb;
  public HashMap<Long, String> uEi;
  private ym uEj;
  public a uEk;
  
  public i()
  {
    AppMethodBeat.i(108574);
    this.uEi = new HashMap();
    this.uEa = false;
    this.uEb = new LinkedList();
    h.aHF().kcd.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private static void IU(long paramLong)
  {
    AppMethodBeat.i(108575);
    ca localca = ((n)h.ae(n.class)).eSe().Oq(paramLong);
    ((bb)((a)h.ag(a.class)).getNotification()).a(localca);
    AppMethodBeat.o(108575);
  }
  
  private long a(bi parambi, EmojiInfo paramEmojiInfo, h.a parama)
  {
    AppMethodBeat.i(108583);
    Log.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambi.md5, paramEmojiInfo.field_md5, Long.valueOf(parambi.fNu) });
    long l;
    if (parambi.fNu != 0L)
    {
      localObject = ((n)h.ae(n.class)).eSe().aL(parambi.talker, parambi.fNu);
      if (((et)localObject).field_msgSvrId == parambi.fNu)
      {
        l = ((et)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((n)h.ae(n.class)).bbL().RG(parambi.talker);
    if ((localObject == null) || ((int)((d)localObject).jxt == 0))
    {
      localObject = new as(parambi.talker);
      ((as)localObject).setType(2);
      ((n)h.ae(n.class)).bbL().av((as)localObject);
    }
    localObject = new ca();
    ((ca)localObject).setType(47);
    ((ca)localObject).Jm(parambi.talker);
    int i;
    boolean bool;
    if (z.PD(parambi.mhK))
    {
      i = 1;
      ((ca)localObject).pJ(i);
      ((ca)localObject).Jn(paramEmojiInfo.getMd5());
      ((ca)localObject).EG(parambi.fNu);
      String str = parambi.mhK;
      if ((paramEmojiInfo.Qv()) || (paramEmojiInfo.isGif())) {
        break label552;
      }
      bool = true;
      label269:
      ((ca)localObject).setContent(be.a(str, 0L, bool, paramEmojiInfo.getMd5(), false, parambi.VFz));
      ((ca)localObject).setCreateTime(bq.z(((et)localObject).field_talker, parambi.createTime));
      ((ca)localObject).setStatus(3);
      if (!Util.isNullOrNil(parambi.hxy)) {
        ((ca)localObject).Ip(parambi.hxy);
      }
      if (parama != null) {
        break label558;
      }
      i = parambi.hxx;
      if (i != 0)
      {
        ((ca)localObject).setFlag(i);
        if ((((et)localObject).field_msgId == 0L) && (((et)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((ca)localObject).setCreateTime(parambi.createTime);
        }
      }
      if (parambi.mkX != 0) {
        ((ca)localObject).EI(parambi.mkX);
      }
      Log.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambi.mkX) });
    }
    for (;;)
    {
      if ((this.uEi != null) && (this.uEi.containsKey(Long.valueOf(((et)localObject).field_msgSvrId))))
      {
        Log.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((ca)localObject).setContent((String)this.uEi.get(Long.valueOf(((et)localObject).field_msgSvrId)));
        ((ca)localObject).setType(10000);
        this.uEi.remove(Long.valueOf(((et)localObject).field_msgSvrId));
      }
      l = bq.z((ca)localObject);
      if (!z.PD(parambi.mhK)) {
        IU(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label552:
      bool = false;
      break label269;
      label558:
      bq.a((ca)localObject, parama);
    }
  }
  
  private static EmojiInfo a(bi parambi)
  {
    AppMethodBeat.i(108581);
    Log.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { parambi.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    b.b(parambi, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.ZuH;
    localEmojiInfo.field_catalog = EmojiInfo.YCx;
    p.getEmojiStorageMgr().VFH.K(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final bi parambi, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.jGI;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, true, new com.tencent.mm.emoji.loader.d.i.a()
    {
      public final void ep(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        i.c(parambi);
        if (i.a(i.this) != null) {
          i.a(i.this).a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  private static void b(bi parambi)
  {
    AppMethodBeat.i(108584);
    if (parambi == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((n)h.ae(n.class)).eSe().a(new i.c(parambi.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  private void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257365);
    if (this.uEb.size() <= 0)
    {
      this.uEa = false;
      AppMethodBeat.o(257365);
      return;
    }
    b localb = (b)this.uEb.remove(0);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 35L, 1L, true);
    }
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      ca localca = ((n)h.ae(n.class)).eSe().Oq(localb.msgId);
      if (localca.field_msgId > 0L)
      {
        localca.setStatus(paramInt1);
        ((n)h.ae(n.class)).eSe().a(localb.msgId, localca);
      }
      if (this.uEb.size() > 0)
      {
        localb = (b)this.uEb.get(0);
        if (((n)h.ae(n.class)).eSe().Oq(localb.msgId).field_msgId > 0L) {
          h.aHF().kcd.a(new s(localb.fCM, localb.fCl, localb.fxn, localb.msgId), 0);
        }
      }
      for (;;)
      {
        if (this.uEj == null) {
          this.uEj = new ym();
        }
        this.uEj.fXI.productId = localb.fxn.field_groupId;
        EventCenter.instance.publish(this.uEj);
        AppMethodBeat.o(257365);
        return;
        fY(-1, -1);
        continue;
        this.uEa = false;
      }
    }
  }
  
  public final void a(bi parambi, h.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(108579);
    if (parambi == null)
    {
      Log.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(108579);
      return;
    }
    if ((parama != null) && (parama.jQG != null) && (parama.jQG.HlH == parambi.fNu))
    {
      parambi.hxx = bq.d(parama);
      parambi.mkX = parama.jQG.RIK;
      parambi.createTime = parama.jQG.CreateTime;
    }
    EmojiInfo localEmojiInfo = p.getEmojiStorageMgr().VFH.bxK(parambi.md5);
    if (localEmojiInfo != null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, parambi.md5, Long.valueOf(parambi.fNu) });
      b.b(parambi, localEmojiInfo);
      p.getEmojiStorageMgr().VFH.M(localEmojiInfo);
    }
    for (;;)
    {
      if (parambi.VFD) {
        a(parambi, localEmojiInfo, parama);
      }
      Log.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.getMd5(), Boolean.valueOf(localEmojiInfo.hBp()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.hBp()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(parambi, localEmojiInfo);
      AppMethodBeat.o(108579);
      return;
      Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { parambi.md5 });
      localEmojiInfo = a(parambi);
    }
    Log.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(parambi);
    label288:
    AppMethodBeat.o(108579);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, ca paramca)
  {
    AppMethodBeat.i(108576);
    if ((Util.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108576);
      return;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    boolean bool2;
    label121:
    long l1;
    if (b.x(paramEmojiInfo))
    {
      bool1 = p.cUS().auz(paramEmojiInfo.field_groupId);
      Log.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (paramca != null) {
        break label329;
      }
      paramca = new ca();
      paramca.setType(47);
      paramca.Jm(paramString);
      paramca.pJ(1);
      String str = z.bcZ();
      if ((paramEmojiInfo.Qv()) || (paramEmojiInfo.isGif())) {
        break label323;
      }
      bool2 = true;
      paramca.setContent(be.a(str, l2, bool2, paramEmojiInfo.getMd5(), bool1, ""));
      paramca.Jn(paramEmojiInfo.getMd5());
      paramca.setCreateTime(bq.RP(paramca.field_talker));
      l1 = ((n)h.ae(n.class)).eSe().aM(paramca);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.uEb.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.uEa) || (this.uEb.size() == 1))
      {
        this.uEa = true;
        h.aHF().kcd.a(new s(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      auJ(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(108576);
      return;
      p.cUS().cUB();
      break;
      label323:
      bool2 = false;
      break label121;
      label329:
      l1 = paramca.field_msgId;
      paramca = be.bwQ(paramca.field_content);
      if (paramca.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = paramca.time;
    }
  }
  
  public final void auJ(final String paramString)
  {
    AppMethodBeat.i(108577);
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108572);
        if (p.getEmojiStorageMgr().VFJ.bxI(paramString))
        {
          p.cUO();
          com.tencent.mm.plugin.emoji.e.f.auq(paramString);
        }
        AppMethodBeat.o(108572);
      }
    });
    AppMethodBeat.o(108577);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(108582);
    Log.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof s)) {
      fY(paramInt1, paramInt2);
    }
    AppMethodBeat.o(108582);
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    bi localbi = bi.J(paramEmojiInfo);
    if (localbi == null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108578);
      return true;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localbi.talker = str;
      localbi.VFD = false;
      a(localbi, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      auJ(paramEmojiInfo);
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
    String fCM;
    String fCl;
    EmojiInfo fxn;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.fCl = paramString1;
      this.fxn = paramEmojiInfo;
      this.fCM = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.i
 * JD-Core Version:    0.7.0.1
 */