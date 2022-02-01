package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.contact.c;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.protocal.protobuf.de;
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

public final class d
  implements com.tencent.mm.ak.i
{
  private boolean raZ;
  List<b> rba;
  public HashMap<Long, String> rbe;
  private xf rbf;
  public a rbg;
  
  public d()
  {
    AppMethodBeat.i(108574);
    this.rbe = new HashMap();
    this.raZ = false;
    this.rba = new LinkedList();
    g.aAg().hqi.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private static void CL(long paramLong)
  {
    AppMethodBeat.i(108575);
    ca localca = ((l)g.af(l.class)).eiy().Hb(paramLong);
    ((ba)((a)g.ah(a.class)).getNotification()).a(localca);
    AppMethodBeat.o(108575);
  }
  
  private long a(bi parambi, EmojiInfo paramEmojiInfo, h.a parama)
  {
    AppMethodBeat.i(108583);
    Log.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambi.md5, paramEmojiInfo.field_md5, Long.valueOf(parambi.dTS) });
    long l;
    if (parambi.dTS != 0L)
    {
      localObject = ((l)g.af(l.class)).eiy().aJ(parambi.talker, parambi.dTS);
      if (((eo)localObject).field_msgSvrId == parambi.dTS)
      {
        l = ((eo)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((l)g.af(l.class)).aSN().Kn(parambi.talker);
    if ((localObject == null) || ((int)((c)localObject).gMZ == 0))
    {
      localObject = new as(parambi.talker);
      ((as)localObject).setType(2);
      ((l)g.af(l.class)).aSN().ap((as)localObject);
    }
    localObject = new ca();
    ((ca)localObject).setType(47);
    ((ca)localObject).Cy(parambi.talker);
    int i;
    boolean bool;
    if (z.Im(parambi.jsh))
    {
      i = 1;
      ((ca)localObject).nv(i);
      ((ca)localObject).Cz(paramEmojiInfo.getMd5());
      ((ca)localObject).yF(parambi.dTS);
      String str = parambi.jsh;
      if ((paramEmojiInfo.NA()) || (paramEmojiInfo.isGif())) {
        break label552;
      }
      bool = true;
      label269:
      ((ca)localObject).setContent(be.a(str, 0L, bool, paramEmojiInfo.getMd5(), false, parambi.OpG));
      ((ca)localObject).setCreateTime(bp.C(((eo)localObject).field_talker, parambi.createTime));
      ((ca)localObject).setStatus(3);
      if (!Util.isNullOrNil(parambi.fqK)) {
        ((ca)localObject).BB(parambi.fqK);
      }
      if (parama != null) {
        break label558;
      }
      i = parambi.fqJ;
      if (i != 0)
      {
        ((ca)localObject).setFlag(i);
        if ((((eo)localObject).field_msgId == 0L) && (((eo)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((ca)localObject).setCreateTime(parambi.createTime);
        }
      }
      if (parambi.jvu != 0) {
        ((ca)localObject).yH(parambi.jvu);
      }
      Log.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambi.jvu) });
    }
    for (;;)
    {
      if ((this.rbe != null) && (this.rbe.containsKey(Long.valueOf(((eo)localObject).field_msgSvrId))))
      {
        Log.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((ca)localObject).setContent((String)this.rbe.get(Long.valueOf(((eo)localObject).field_msgSvrId)));
        ((ca)localObject).setType(10000);
        this.rbe.remove(Long.valueOf(((eo)localObject).field_msgSvrId));
      }
      l = bp.x((ca)localObject);
      if (!z.Im(parambi.jsh)) {
        CL(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label552:
      bool = false;
      break label269;
      label558:
      bp.a((ca)localObject, parama);
    }
  }
  
  private static EmojiInfo a(bi parambi)
  {
    AppMethodBeat.i(108581);
    Log.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { parambi.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.h.b.b(parambi, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.UuF;
    localEmojiInfo.field_catalog = EmojiInfo.Uup;
    k.getEmojiStorageMgr().OpN.J(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final bi parambi, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.gVM;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, true, new i.a()
    {
      public final void dQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        d.b(parambi);
        if (d.this.rbg != null) {
          d.this.rbg.a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  static void b(bi parambi)
  {
    AppMethodBeat.i(108584);
    if (parambi == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((l)g.af(l.class)).eiy().a(new i.c(parambi.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  private void fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240147);
    if (this.rba.size() <= 0)
    {
      this.raZ = false;
      AppMethodBeat.o(240147);
      return;
    }
    b localb = (b)this.rba.remove(0);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 35L, 1L, true);
    }
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      ca localca = ((l)g.af(l.class)).eiy().Hb(localb.msgId);
      if (localca.field_msgId > 0L)
      {
        localca.setStatus(paramInt1);
        ((l)g.af(l.class)).eiy().a(localb.msgId, localca);
      }
      if (this.rba.size() > 0)
      {
        localb = (b)this.rba.get(0);
        if (((l)g.af(l.class)).eiy().Hb(localb.msgId).field_msgId > 0L) {
          g.aAg().hqi.a(new s(localb.dJX, localb.dJw, localb.dEz, localb.msgId), 0);
        }
      }
      for (;;)
      {
        if (this.rbf == null) {
          this.rbf = new xf();
        }
        this.rbf.edz.productId = localb.dEz.field_groupId;
        EventCenter.instance.publish(this.rbf);
        AppMethodBeat.o(240147);
        return;
        fB(-1, -1);
        continue;
        this.raZ = false;
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
    if ((parama != null) && (parama.heO != null) && (parama.heO.Brn == parambi.dTS))
    {
      parambi.fqJ = bp.d(parama);
      parambi.jvu = parama.heO.KHs;
      parambi.createTime = parama.heO.CreateTime;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(parambi.md5);
    if (localEmojiInfo != null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, parambi.md5, Long.valueOf(parambi.dTS) });
      com.tencent.mm.plugin.emoji.h.b.b(parambi, localEmojiInfo);
      k.getEmojiStorageMgr().OpN.L(localEmojiInfo);
    }
    for (;;)
    {
      if (parambi.OpK) {
        a(parambi, localEmojiInfo, parama);
      }
      Log.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.getMd5(), Boolean.valueOf(localEmojiInfo.hRx()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.hRx()) {
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
    label110:
    boolean bool2;
    label142:
    long l1;
    if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
    {
      bool1 = k.cGj().amF(paramEmojiInfo.field_groupId);
      Log.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (paramca != null) {
        break label359;
      }
      paramca = new ca();
      if ((paramEmojiInfo.field_type != EmojiInfo.Uuz) && (paramEmojiInfo.field_type != EmojiInfo.UuA)) {
        break label344;
      }
      paramca.setType(1048625);
      paramca.Cy(paramString);
      paramca.nv(1);
      String str = z.aTY();
      if ((paramEmojiInfo.NA()) || (paramEmojiInfo.isGif())) {
        break label353;
      }
      bool2 = true;
      paramca.setContent(be.a(str, l2, bool2, paramEmojiInfo.getMd5(), bool1, ""));
      paramca.Cz(paramEmojiInfo.getMd5());
      paramca.setCreateTime(bp.Kw(paramca.field_talker));
      l1 = ((l)g.af(l.class)).eiy().aC(paramca);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.rba.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.raZ) || (this.rba.size() == 1))
      {
        this.raZ = true;
        g.aAg().hqi.a(new s(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      amP(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(108576);
      return;
      k.cGj().cFU();
      break;
      label344:
      paramca.setType(47);
      break label110;
      label353:
      bool2 = false;
      break label142;
      label359:
      l1 = paramca.field_msgId;
      paramca = be.bkr(paramca.field_content);
      if (paramca.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = paramca.time;
    }
  }
  
  public final void amP(final String paramString)
  {
    AppMethodBeat.i(108577);
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108572);
        if (k.getEmojiStorageMgr().OpP.bli(paramString))
        {
          k.cGf();
          com.tencent.mm.plugin.emoji.e.f.amx(paramString);
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
      fB(paramInt1, paramInt2);
    }
    AppMethodBeat.o(108582);
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    bi localbi = bi.I(paramEmojiInfo);
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
      localbi.OpK = false;
      a(localbi, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      amP(paramEmojiInfo);
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
    EmojiInfo dEz;
    String dJX;
    String dJw;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.dJw = paramString1;
      this.dEz = paramEmojiInfo;
      this.dJX = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */