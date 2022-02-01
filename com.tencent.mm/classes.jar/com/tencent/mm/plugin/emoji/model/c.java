package com.tencent.mm.plugin.emoji.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.al.g
{
  public HashMap<Long, String> owI;
  private boolean owJ;
  List<b> owK;
  private uy owL;
  public a owM;
  
  public c()
  {
    AppMethodBeat.i(108574);
    this.owI = new HashMap();
    this.owJ = false;
    this.owK = new LinkedList();
    com.tencent.mm.kernel.g.afA().gcy.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private long a(av paramav, EmojiInfo paramEmojiInfo, f.a parama)
  {
    AppMethodBeat.i(108583);
    ad.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { paramav.md5, paramEmojiInfo.field_md5, Long.valueOf(paramav.drA) });
    long l;
    if (paramav.drA != 0L)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(paramav.talker, paramav.drA);
      if (((du)localObject).field_msgSvrId == paramav.drA)
      {
        l = ((du)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramav.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.n.b)localObject).fId == 0))
    {
      localObject = new af(paramav.talker);
      ((af)localObject).setType(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().af((af)localObject);
    }
    localObject = new bl();
    ((bl)localObject).setType(47);
    ((bl)localObject).nY(paramav.talker);
    int i;
    boolean bool;
    if (u.se(paramav.hAb))
    {
      i = 1;
      ((bl)localObject).jV(i);
      ((bl)localObject).nZ(paramEmojiInfo.JS());
      ((bl)localObject).kX(paramav.drA);
      String str = paramav.hAb;
      if ((paramEmojiInfo.CZ()) || (paramEmojiInfo.isGif())) {
        break label551;
      }
      bool = true;
      label269:
      ((bl)localObject).setContent(ar.a(str, 0L, bool, paramEmojiInfo.JS(), false, paramav.FyR));
      ((bl)localObject).kY(bi.y(((du)localObject).field_talker, paramav.createTime));
      ((bl)localObject).setStatus(3);
      if (!bt.isNullOrNil(paramav.esh)) {
        ((bl)localObject).mZ(paramav.esh);
      }
      if (parama != null) {
        break label557;
      }
      i = paramav.esg;
      if (i != 0)
      {
        ((bl)localObject).setFlag(i);
        if ((((du)localObject).field_msgId == 0L) && (((du)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((bl)localObject).kY(paramav.createTime);
        }
      }
      if (paramav.hDq != 0) {
        ((bl)localObject).la(paramav.hDq);
      }
      ad.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramav.hDq) });
    }
    for (;;)
    {
      if ((this.owI != null) && (this.owI.containsKey(Long.valueOf(((du)localObject).field_msgSvrId))))
      {
        ad.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((bl)localObject).setContent((String)this.owI.get(Long.valueOf(((du)localObject).field_msgSvrId)));
        ((bl)localObject).setType(10000);
        this.owI.remove(Long.valueOf(((du)localObject).field_msgSvrId));
      }
      l = bi.u((bl)localObject);
      if (!u.se(paramav.hAb)) {
        oG(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label551:
      bool = false;
      break label269;
      label557:
      bi.a((bl)localObject, parama);
    }
  }
  
  private static EmojiInfo a(av paramav)
  {
    AppMethodBeat.i(108581);
    ad.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { paramav.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.h.b.b(paramav, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.LCg;
    localEmojiInfo.field_catalog = EmojiInfo.LBQ;
    k.getEmojiStorageMgr().FyY.J(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final av paramav, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.fLn;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, true, new i.a()
    {
      public final void df(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        c.b(paramav);
        if (c.this.owM != null) {
          c.this.owM.a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  static void b(av paramav)
  {
    AppMethodBeat.i(108584);
    if (paramav == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(paramav.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  private static void oG(long paramLong)
  {
    AppMethodBeat.i(108575);
    bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong);
    ((at)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbl);
    AppMethodBeat.o(108575);
  }
  
  public final void TZ(final String paramString)
  {
    AppMethodBeat.i(108577);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(108572);
        Object localObject = k.getEmojiStorageMgr().Fza;
        String str = paramString;
        long l1;
        long l2;
        if (com.tencent.mm.plugin.emoji.h.b.Uq(str))
        {
          l1 = ((com.tencent.mm.storage.emotion.e)localObject).FBQ.getLong("274544".concat(String.valueOf(str)), 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 < 86400000L) {}
        }
        while (i != 0)
        {
          k.bUZ();
          localObject = paramString;
          if (bt.isNullOrNil((String)localObject))
          {
            ad.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
            AppMethodBeat.o(108572);
            return;
            if ((((com.tencent.mm.storage.emotion.e)localObject).aJv(str)) || (l2 - l1 < 3600000L)) {
              i = 0;
            }
          }
          else
          {
            localObject = new com.tencent.mm.plugin.emoji.f.k((String)localObject);
            com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
          }
        }
        AppMethodBeat.o(108572);
      }
    });
    AppMethodBeat.o(108577);
  }
  
  public final void a(av paramav, f.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(108579);
    if (paramav == null)
    {
      ad.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(108579);
      return;
    }
    if ((parama != null) && (parama.fTo != null) && (parama.fTo.uKZ == paramav.drA))
    {
      paramav.esg = bi.d(parama);
      paramav.hDq = parama.fTo.CxE;
      paramav.createTime = parama.fTo.CreateTime;
    }
    EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().FyY.aJx(paramav.md5);
    if (localEmojiInfo != null)
    {
      ad.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, paramav.md5, Long.valueOf(paramav.drA) });
      com.tencent.mm.plugin.emoji.h.b.b(paramav, localEmojiInfo);
      k.getEmojiStorageMgr().FyY.L(localEmojiInfo);
    }
    for (;;)
    {
      if (paramav.FyV) {
        a(paramav, localEmojiInfo, parama);
      }
      ad.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.JS(), Boolean.valueOf(localEmojiInfo.fZM()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.fZM()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramav, localEmojiInfo);
      AppMethodBeat.o(108579);
      return;
      ad.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { paramav.md5 });
      localEmojiInfo = a(paramav);
    }
    ad.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(paramav);
    label288:
    AppMethodBeat.o(108579);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, bl parambl)
  {
    AppMethodBeat.i(108576);
    if ((bt.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108576);
      return;
    }
    if (com.tencent.mm.vfs.i.aMN(paramEmojiInfo.gaa()) <= 0L)
    {
      paramEmojiInfo.field_state = EmojiInfo.LCc;
      k.getEmojiStorageMgr().FyY.L(paramEmojiInfo);
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    label140:
    boolean bool2;
    label172:
    long l1;
    if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
    {
      bool1 = k.bVd().TP(paramEmojiInfo.field_groupId);
      ad.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (parambl != null) {
        break label389;
      }
      parambl = new bl();
      if ((paramEmojiInfo.field_type != EmojiInfo.LCa) && (paramEmojiInfo.field_type != EmojiInfo.LCb)) {
        break label374;
      }
      parambl.setType(1048625);
      parambl.nY(paramString);
      parambl.jV(1);
      String str = u.aqG();
      if ((paramEmojiInfo.CZ()) || (paramEmojiInfo.isGif())) {
        break label383;
      }
      bool2 = true;
      parambl.setContent(ar.a(str, l2, bool2, paramEmojiInfo.JS(), bool1, ""));
      parambl.nZ(paramEmojiInfo.JS());
      parambl.kY(bi.uj(parambl.field_talker));
      l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(parambl);
    }
    for (;;)
    {
      ad.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.JS(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.owK.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.owJ) || (this.owK.size() == 1))
      {
        this.owJ = true;
        com.tencent.mm.kernel.g.afA().gcy.a(new r(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      TZ(paramEmojiInfo.field_groupId);
      AppMethodBeat.o(108576);
      return;
      k.bVd().bUP();
      break;
      label374:
      parambl.setType(47);
      break label140;
      label383:
      bool2 = false;
      break label172;
      label389:
      l1 = parambl.field_msgId;
      parambl = ar.aIF(parambl.field_content);
      if (parambl.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = parambl.time;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108582);
    ad.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof r))
    {
      if (this.owK.size() <= 0)
      {
        this.owJ = false;
        AppMethodBeat.o(108582);
        return;
      }
      paramString = (b)this.owK.remove(0);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label281;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 35L, 1L, true);
    }
    label281:
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramString.msgId);
      paramn.setStatus(paramInt1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramString.msgId, paramn);
      if (this.owK.size() > 0)
      {
        paramString = (b)this.owK.get(0);
        com.tencent.mm.kernel.g.afA().gcy.a(new r(paramString.diQ, paramString.dio, paramString.ddq, paramString.msgId), 0);
      }
      for (;;)
      {
        if (this.owL == null) {
          this.owL = new uy();
        }
        this.owL.dAw.dft = paramString.ddq.field_groupId;
        com.tencent.mm.sdk.b.a.ESL.l(this.owL);
        AppMethodBeat.o(108582);
        return;
        this.owJ = false;
      }
    }
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    av localav = av.I(paramEmojiInfo);
    if (localav == null)
    {
      ad.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108578);
      return true;
    }
    String str;
    if (paramEmojiInfo == null)
    {
      str = "";
      localav.talker = str;
      localav.FyV = false;
      a(localav, null, true);
      if (paramEmojiInfo != null) {
        break label83;
      }
    }
    label83:
    for (paramEmojiInfo = null;; paramEmojiInfo = paramEmojiInfo.field_groupId)
    {
      TZ(paramEmojiInfo);
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
    EmojiInfo ddq;
    String diQ;
    String dio;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.dio = paramString1;
      this.ddq = paramEmojiInfo;
      this.diQ = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */