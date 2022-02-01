package com.tencent.mm.plugin.emoji.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.ak.g
{
  public HashMap<Long, String> pai;
  private boolean paj;
  List<b> pak;
  private vi pal;
  public a pam;
  
  public c()
  {
    AppMethodBeat.i(108574);
    this.pai = new HashMap();
    this.paj = false;
    this.pak = new LinkedList();
    com.tencent.mm.kernel.g.agQ().ghe.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private long a(ay paramay, EmojiInfo paramEmojiInfo, f.a parama)
  {
    AppMethodBeat.i(108583);
    ac.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { paramay.md5, paramEmojiInfo.field_md5, Long.valueOf(paramay.dpl) });
    long l;
    if (paramay.dpl != 0L)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(paramay.talker, paramay.dpl);
      if (((dy)localObject).field_msgSvrId == paramay.dpl)
      {
        l = ((dy)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramay.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.n.b)localObject).fLJ == 0))
    {
      localObject = new ai(paramay.talker);
      ((ai)localObject).setType(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ag((ai)localObject);
    }
    localObject = new bo();
    ((bo)localObject).setType(47);
    ((bo)localObject).re(paramay.talker);
    int i;
    boolean bool;
    if (u.wh(paramay.iaC))
    {
      i = 1;
      ((bo)localObject).jT(i);
      ((bo)localObject).rf(paramEmojiInfo.JC());
      ((bo)localObject).oz(paramay.dpl);
      String str = paramay.iaC;
      if ((paramEmojiInfo.CC()) || (paramEmojiInfo.isGif())) {
        break label551;
      }
      bool = true;
      label269:
      ((bo)localObject).setContent(au.a(str, 0L, bool, paramEmojiInfo.JC(), false, paramay.GXS));
      ((bo)localObject).oA(bi.z(((dy)localObject).field_talker, paramay.createTime));
      ((bo)localObject).setStatus(3);
      if (!bs.isNullOrNil(paramay.eul)) {
        ((bo)localObject).qf(paramay.eul);
      }
      if (parama != null) {
        break label557;
      }
      i = paramay.euk;
      if (i != 0)
      {
        ((bo)localObject).setFlag(i);
        if ((((dy)localObject).field_msgId == 0L) && (((dy)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((bo)localObject).oA(paramay.createTime);
        }
      }
      if (paramay.idS != 0) {
        ((bo)localObject).oC(paramay.idS);
      }
      ac.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramay.idS) });
    }
    for (;;)
    {
      if ((this.pai != null) && (this.pai.containsKey(Long.valueOf(((dy)localObject).field_msgSvrId))))
      {
        ac.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((bo)localObject).setContent((String)this.pai.get(Long.valueOf(((dy)localObject).field_msgSvrId)));
        ((bo)localObject).setType(10000);
        this.pai.remove(Long.valueOf(((dy)localObject).field_msgSvrId));
      }
      l = bi.u((bo)localObject);
      if (!u.wh(paramay.iaC)) {
        ss(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label551:
      bool = false;
      break label269;
      label557:
      bi.a((bo)localObject, parama);
    }
  }
  
  private static EmojiInfo a(ay paramay)
  {
    AppMethodBeat.i(108581);
    ac.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { paramay.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.h.b.b(paramay, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.Kgh;
    localEmojiInfo.field_catalog = EmojiInfo.Jss;
    k.getEmojiStorageMgr().GXZ.J(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final ay paramay, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.fOZ;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, true, new i.a()
    {
      public final void de(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        c.b(paramay);
        if (c.this.pam != null) {
          c.this.pam.a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  static void b(ay paramay)
  {
    AppMethodBeat.i(108584);
    if (paramay == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(paramay.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  private static void ss(long paramLong)
  {
    AppMethodBeat.i(108575);
    bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong);
    ((at)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbo);
    AppMethodBeat.o(108575);
  }
  
  public final void Yl(final String paramString)
  {
    AppMethodBeat.i(108577);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(108572);
        Object localObject = k.getEmojiStorageMgr().GYb;
        String str = paramString;
        long l1;
        long l2;
        if (com.tencent.mm.plugin.emoji.h.b.YC(str))
        {
          l1 = ((com.tencent.mm.storage.emotion.e)localObject).HaQ.getLong("274544".concat(String.valueOf(str)), 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 < 86400000L) {}
        }
        while (i != 0)
        {
          k.ccm();
          localObject = paramString;
          if (bs.isNullOrNil((String)localObject))
          {
            ac.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
            AppMethodBeat.o(108572);
            return;
            if ((((com.tencent.mm.storage.emotion.e)localObject).aOR(str)) || (l2 - l1 < 3600000L)) {
              i = 0;
            }
          }
          else
          {
            localObject = new com.tencent.mm.plugin.emoji.f.k((String)localObject);
            com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
          }
        }
        AppMethodBeat.o(108572);
      }
    });
    AppMethodBeat.o(108577);
  }
  
  public final void a(ay paramay, f.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(108579);
    if (paramay == null)
    {
      ac.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(108579);
      return;
    }
    if ((parama != null) && (parama.fXi != null) && (parama.fXi.vTQ == paramay.dpl))
    {
      paramay.euk = bi.d(parama);
      paramay.idS = parama.fXi.DQa;
      paramay.createTime = parama.fXi.CreateTime;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().GXZ.aOT(paramay.md5);
    if (localEmojiInfo != null)
    {
      ac.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, paramay.md5, Long.valueOf(paramay.dpl) });
      com.tencent.mm.plugin.emoji.h.b.b(paramay, localEmojiInfo);
      k.getEmojiStorageMgr().GXZ.L(localEmojiInfo);
    }
    for (;;)
    {
      if (paramay.GXW) {
        a(paramay, localEmojiInfo, parama);
      }
      ac.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.JC(), Boolean.valueOf(localEmojiInfo.fdp()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.fdp()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramay, localEmojiInfo);
      AppMethodBeat.o(108579);
      return;
      ac.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { paramay.md5 });
      localEmojiInfo = a(paramay);
    }
    ac.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(paramay);
    label288:
    AppMethodBeat.o(108579);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bo parambo)
  {
    AppMethodBeat.i(108576);
    if ((bs.isNullOrNil(paramString)) || (paramEmojiInfo == null))
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
      bool1 = k.ccq().Yb(paramEmojiInfo.field_groupId);
      ac.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (parambo != null) {
        break label359;
      }
      parambo = new bo();
      if ((paramEmojiInfo.field_type != EmojiInfo.Kgb) && (paramEmojiInfo.field_type != EmojiInfo.Kgc)) {
        break label344;
      }
      parambo.setType(1048625);
      parambo.re(paramString);
      parambo.jT(1);
      String str = u.axw();
      if ((paramEmojiInfo.CC()) || (paramEmojiInfo.isGif())) {
        break label353;
      }
      bool2 = true;
      parambo.setContent(au.a(str, l2, bool2, paramEmojiInfo.JC(), bool1, ""));
      parambo.rf(paramEmojiInfo.JC());
      parambo.oA(bi.yp(parambo.field_talker));
      l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(parambo);
    }
    for (;;)
    {
      ac.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.JC(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.pak.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.paj) || (this.pak.size() == 1))
      {
        this.paj = true;
        com.tencent.mm.kernel.g.agQ().ghe.a(new r(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      Yl(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(108576);
      return;
      k.ccq().ccc();
      break;
      label344:
      parambo.setType(47);
      break label110;
      label353:
      bool2 = false;
      break label142;
      label359:
      l1 = parambo.field_msgId;
      parambo = au.aOb(parambo.field_content);
      if (parambo.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = parambo.time;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108582);
    ac.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof r))
    {
      if (this.pak.size() <= 0)
      {
        this.paj = false;
        AppMethodBeat.o(108582);
        return;
      }
      paramString = (b)this.pak.remove(0);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label281;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 35L, 1L, true);
    }
    label281:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramString.msgId);
      paramn.setStatus(paramInt1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramString.msgId, paramn);
      if (this.pak.size() > 0)
      {
        paramString = (b)this.pak.get(0);
        com.tencent.mm.kernel.g.agQ().ghe.a(new r(paramString.dgl, paramString.dfJ, paramString.daO, paramString.msgId), 0);
      }
      for (;;)
      {
        if (this.pal == null) {
          this.pal = new vi();
        }
        this.pal.dyi.dcO = paramString.daO.field_groupId;
        com.tencent.mm.sdk.b.a.GpY.l(this.pal);
        AppMethodBeat.o(108582);
        return;
        this.paj = false;
      }
    }
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    ay localay = ay.I(paramEmojiInfo);
    if (localay == null)
    {
      ac.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108578);
      return true;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localay.talker = str;
      localay.GXW = false;
      a(localay, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      Yl(paramEmojiInfo);
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
    EmojiInfo daO;
    String dfJ;
    String dgl;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.dfJ = paramString1;
      this.daO = paramEmojiInfo;
      this.dgl = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */