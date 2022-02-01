package com.tencent.mm.plugin.emoji.model;

import android.content.ContentValues;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aaf;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.e.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.notification.b.b;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements com.tencent.mm.am.h
{
  private aaf xMA;
  public i.a xMB;
  private boolean xMr;
  List<b> xMs;
  public HashMap<Long, String> xMz;
  
  public i()
  {
    AppMethodBeat.i(108574);
    this.xMz = new HashMap();
    this.xMr = false;
    this.xMs = new LinkedList();
    com.tencent.mm.kernel.h.baD().mCm.a(175, this);
    AppMethodBeat.o(108574);
  }
  
  private long a(bk parambk, EmojiInfo paramEmojiInfo, g.a parama)
  {
    AppMethodBeat.i(108583);
    Log.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambk.md5, paramEmojiInfo.field_md5, Long.valueOf(parambk.hTh) });
    long l;
    if (parambk.hTh != 0L)
    {
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(parambk.talker, parambk.hTh);
      if ((localObject != null) && (((fi)localObject).field_msgSvrId == parambk.hTh))
      {
        l = ((fi)localObject).field_msgId;
        AppMethodBeat.o(108583);
        return l;
      }
    }
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(parambk.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.contact.d)localObject).maN == 0))
    {
      localObject = new au(parambk.talker);
      ((au)localObject).setType(2);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().aB((au)localObject);
    }
    localObject = new cc();
    ((cc)localObject).setType(47);
    ((cc)localObject).BS(parambk.talker);
    int i;
    boolean bool;
    if (z.Iy(parambk.paV))
    {
      i = 1;
      ((cc)localObject).pI(i);
      ((cc)localObject).BT(paramEmojiInfo.getMd5());
      ((cc)localObject).gX(parambk.hTh);
      String str = parambk.paV;
      if ((paramEmojiInfo.aqJ()) || (paramEmojiInfo.isGif())) {
        break label556;
      }
      bool = true;
      label274:
      ((cc)localObject).setContent(bg.a(str, 0L, bool, paramEmojiInfo.getMd5(), false, parambk.adjm));
      ((cc)localObject).setCreateTime(br.D(((fi)localObject).field_talker, parambk.createTime));
      ((cc)localObject).setStatus(3);
      if (!Util.isNullOrNil(parambk.jUr)) {
        ((cc)localObject).AU(parambk.jUr);
      }
      if (parama != null) {
        break label562;
      }
      i = parambk.jUq;
      if (i != 0)
      {
        ((cc)localObject).setFlag(i);
        if ((((fi)localObject).field_msgId == 0L) && (((fi)localObject).field_isSend == 0) && ((i & 0x2) != 0)) {
          ((cc)localObject).setCreateTime(parambk.createTime);
        }
      }
      if (parambk.peI != 0) {
        ((cc)localObject).gZ(parambk.peI);
      }
      Log.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambk.peI) });
    }
    for (;;)
    {
      if ((this.xMz != null) && (this.xMz.containsKey(Long.valueOf(((fi)localObject).field_msgSvrId))))
      {
        Log.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
        ((cc)localObject).setContent((String)this.xMz.get(Long.valueOf(((fi)localObject).field_msgSvrId)));
        ((cc)localObject).setType(10000);
        this.xMz.remove(Long.valueOf(((fi)localObject).field_msgSvrId));
      }
      l = br.B((cc)localObject);
      if (!z.Iy(parambk.paV)) {
        lp(l);
      }
      AppMethodBeat.o(108583);
      return l;
      i = 0;
      break;
      label556:
      bool = false;
      break label274;
      label562:
      br.a((cc)localObject, parama);
    }
  }
  
  private static EmojiInfo a(bk parambk)
  {
    AppMethodBeat.i(108581);
    Log.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", new Object[] { parambk.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.g.d.b(parambk, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.aklW;
    localEmojiInfo.field_catalog = EmojiInfo.aklG;
    s.getEmojiStorageMgr().adju.K(localEmojiInfo);
    AppMethodBeat.o(108581);
    return localEmojiInfo;
  }
  
  private void a(final bk parambk, final EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108580);
    com.tencent.mm.emoji.b.e locale = com.tencent.mm.emoji.b.e.mgl;
    com.tencent.mm.emoji.b.e.a(paramEmojiInfo, true, new h.a()
    {
      public final void onResult(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108573);
        i.d(parambk);
        if (i.a(i.this) != null) {
          i.a(i.this).a(paramAnonymousBoolean, paramEmojiInfo);
        }
        AppMethodBeat.o(108573);
      }
    });
    AppMethodBeat.o(108580);
  }
  
  private static void b(bk parambk)
  {
    AppMethodBeat.i(108584);
    if (parambk == null)
    {
      AppMethodBeat.o(108584);
      return;
    }
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(parambk.talker, "update", null));
    AppMethodBeat.o(108584);
  }
  
  public static void c(bk parambk)
  {
    AppMethodBeat.i(269874);
    if (Util.isNullOrNil(parambk.desc))
    {
      AppMethodBeat.o(269874);
      return;
    }
    Object localObject1 = Base64.decode(parambk.desc, 0);
    drm localdrm = new drm();
    try
    {
      localdrm.parseFrom((byte[])localObject1);
      localObject1 = bl.jba().adjw;
      Object localObject2 = parambk.productId;
      Object localObject3 = parambk.md5;
      if (localdrm.vgO == null) {
        Log.w("MicroMsg.emoji.EmojiInfoDescStorage", "msg desc list is null");
      }
      for (;;)
      {
        if (localdrm.vgO != null) {
          Log.i("MicroMsg.emoji.EmojiService", "emoji desc %s", new Object[] { Integer.valueOf(localdrm.vgO.size()) });
        }
        AppMethodBeat.o(269874);
        return;
        parambk = new com.tencent.mm.storage.emotion.d();
        parambk.field_groupId = ((String)localObject2);
        parambk.field_md5 = ((String)localObject3);
        localObject2 = localdrm.vgO.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (dgn)((Iterator)localObject2).next();
          parambk.field_desc = ((dgn)localObject3).IGG;
          parambk.field_lang = ((dgn)localObject3).IJD;
          parambk.field_md5_lang = (parambk.field_md5 + parambk.field_lang);
          localObject3 = parambk.convertTo();
          ((com.tencent.mm.storage.emotion.e)localObject1).db.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3);
        }
      }
      return;
    }
    catch (IOException parambk)
    {
      Log.printErrStackTrace("MicroMsg.emoji.EmojiService", parambk, "", new Object[0]);
      AppMethodBeat.o(269874);
    }
  }
  
  private void gR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(269865);
    if (this.xMs.size() <= 0)
    {
      this.xMr = false;
      AppMethodBeat.o(269865);
      return;
    }
    b localb = (b)this.xMs.remove(0);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 35L, 1L, true);
    }
    for (paramInt1 = 5;; paramInt1 = 2)
    {
      cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localb.msgId);
      if ((localcc != null) && (localcc.field_msgId > 0L))
      {
        localcc.setStatus(paramInt1);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(localb.msgId, localcc);
      }
      if (this.xMs.size() > 0)
      {
        localb = (b)this.xMs.get(0);
        localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localb.msgId);
        if ((localcc != null) && (localcc.field_msgId > 0L)) {
          com.tencent.mm.kernel.h.baD().mCm.a(new t(localb.hHB, localb.hHa, localb.hBS, localb.msgId), 0);
        }
      }
      for (;;)
      {
        if (this.xMA == null) {
          this.xMA = new aaf();
        }
        this.xMA.idJ.productId = localb.hBS.field_groupId;
        this.xMA.publish();
        AppMethodBeat.o(269865);
        return;
        gR(-1, -1);
        continue;
        this.xMr = false;
      }
    }
  }
  
  private static void lp(long paramLong)
  {
    AppMethodBeat.i(108575);
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
    if (localcc != null) {
      ((bb)((b)com.tencent.mm.kernel.h.az(b.class)).getNotification()).a(localcc);
    }
    AppMethodBeat.o(108575);
  }
  
  public final void a(bk parambk, g.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(108579);
    if (parambk == null)
    {
      Log.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
      AppMethodBeat.o(108579);
      return;
    }
    if ((parama != null) && (parama.mpN != null) && (parama.mpN.Njv == parambk.hTh))
    {
      parambk.jUq = br.d(parama);
      parambk.peI = parama.mpN.YFL;
      parambk.createTime = parama.mpN.CreateTime;
    }
    EmojiInfo localEmojiInfo = s.getEmojiStorageMgr().adju.bza(parambk.md5);
    if (localEmojiInfo != null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", new Object[] { localEmojiInfo.field_md5, parambk.md5, Long.valueOf(parambk.hTh) });
      com.tencent.mm.plugin.emoji.g.d.b(parambk, localEmojiInfo);
      s.getEmojiStorageMgr().adju.M(localEmojiInfo);
    }
    for (;;)
    {
      if (parambk.adjq) {
        a(parambk, localEmojiInfo, parama);
      }
      Log.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[] { localEmojiInfo.getMd5(), Boolean.valueOf(localEmojiInfo.kLZ()), Boolean.valueOf(paramBoolean) });
      if (localEmojiInfo.kLZ()) {
        break label288;
      }
      if (!paramBoolean) {
        break;
      }
      a(parambk, localEmojiInfo);
      AppMethodBeat.o(108579);
      return;
      Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", new Object[] { parambk.md5 });
      localEmojiInfo = a(parambk);
    }
    Log.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    b(parambk);
    label288:
    AppMethodBeat.o(108579);
  }
  
  public final void a(String paramString, EmojiInfo paramEmojiInfo, cc paramcc)
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
    if (com.tencent.mm.plugin.emoji.g.d.x(paramEmojiInfo))
    {
      bool1 = s.dAp().aoy(paramEmojiInfo.field_groupId);
      Log.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
      if (paramcc != null) {
        break label321;
      }
      paramcc = new cc();
      paramcc.setType(47);
      paramcc.BS(paramString);
      paramcc.pI(1);
      String str = z.bAM();
      if ((paramEmojiInfo.aqJ()) || (paramEmojiInfo.isGif())) {
        break label315;
      }
      bool2 = true;
      paramcc.setContent(bg.a(str, l2, bool2, paramEmojiInfo.getMd5(), bool1, ""));
      paramcc.BT(paramEmojiInfo.getMd5());
      paramcc.setCreateTime(br.JN(paramcc.field_talker));
      l1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(paramcc);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.xMs.add(new b(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((!this.xMr) || (this.xMs.size() == 1))
      {
        this.xMr = true;
        com.tencent.mm.kernel.h.baD().mCm.a(new t(String.valueOf(l2), paramString, paramEmojiInfo, l1), 0);
      }
      AppMethodBeat.o(108576);
      return;
      s.dAp().dzI();
      break;
      label315:
      bool2 = false;
      break label121;
      label321:
      l1 = paramcc.field_msgId;
      paramcc = bg.byj(paramcc.field_content);
      if (paramcc.time == 0L)
      {
        AppMethodBeat.o(108576);
        return;
      }
      l2 = paramcc.time;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(108582);
    Log.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof t)) {
      gR(paramInt1, paramInt2);
    }
    AppMethodBeat.o(108582);
  }
  
  @Deprecated
  public final boolean u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108578);
    bk localbk = bk.J(paramEmojiInfo);
    if (localbk == null)
    {
      Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
      AppMethodBeat.o(108578);
      return true;
    }
    if (paramEmojiInfo == null) {}
    for (paramEmojiInfo = "";; paramEmojiInfo = paramEmojiInfo.talker)
    {
      localbk.talker = paramEmojiInfo;
      localbk.adjq = false;
      a(localbk, null, true);
      AppMethodBeat.o(108578);
      return true;
    }
  }
  
  final class b
  {
    EmojiInfo hBS;
    String hHB;
    String hHa;
    long msgId;
    
    public b(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.hHa = paramString1;
      this.hBS = paramEmojiInfo;
      this.hHB = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.i
 * JD-Core Version:    0.7.0.1
 */