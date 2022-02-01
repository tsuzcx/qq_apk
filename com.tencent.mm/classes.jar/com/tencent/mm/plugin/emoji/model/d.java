package com.tencent.mm.plugin.emoji.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.e;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements com.tencent.mm.am.h
{
  private boolean xMr;
  List<a> xMs;
  List<String> xMt;
  private p xMu;
  
  public d()
  {
    AppMethodBeat.i(269871);
    this.xMr = false;
    this.xMs = new LinkedList();
    this.xMt = new LinkedList();
    com.tencent.mm.kernel.h.baD().mCm.a(3862, this);
    com.tencent.mm.kernel.h.baD().mCm.a(697, this);
    AppMethodBeat.o(269871);
  }
  
  private void Ko(int paramInt)
  {
    AppMethodBeat.i(269878);
    if (this.xMs.size() <= 0)
    {
      this.xMr = false;
      AppMethodBeat.o(269878);
      return;
    }
    a locala = (a)this.xMs.remove(0);
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(locala.msgId);
    if (localcc != null)
    {
      localcc.setStatus(paramInt);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(locala.msgId, localcc);
    }
    if (this.xMs.size() > 0)
    {
      this.xMt.clear();
      this.xMt.add(((a)this.xMs.get(0)).hBS.field_md5);
      com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.emoji.e.f((LinkedList)this.xMt), 0);
      AppMethodBeat.o(269878);
      return;
    }
    this.xMr = false;
    AppMethodBeat.o(269878);
  }
  
  public static long a(bk parambk, EmojiInfo paramEmojiInfo, g.a parama)
  {
    AppMethodBeat.i(269890);
    Log.i("MicroMsg.emoji.EmojiBypService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambk.md5, paramEmojiInfo.field_md5, Long.valueOf(parambk.hTh) });
    long l;
    if (parambk.hTh != 0L)
    {
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(parambk.talker, parambk.hTh);
      if ((localObject != null) && (((fi)localObject).field_msgSvrId == parambk.hTh))
      {
        l = ((fi)localObject).field_msgId;
        AppMethodBeat.o(269890);
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
        break label454;
      }
      bool = true;
      label272:
      ((cc)localObject).setContent(bg.a(str, 0L, bool, paramEmojiInfo.getMd5(), false, parambk.adjm));
      ((cc)localObject).setCreateTime(br.D(((fi)localObject).field_talker, parambk.createTime));
      ((cc)localObject).setStatus(3);
      if (!Util.isNullOrNil(parambk.jUr)) {
        ((cc)localObject).AU(parambk.jUr);
      }
      if (parama != null) {
        break label460;
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
      Log.i("MicroMsg.emoji.EmojiBypService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambk.peI) });
    }
    for (;;)
    {
      l = br.B((cc)localObject);
      AppMethodBeat.o(269890);
      return l;
      i = 0;
      break;
      label454:
      bool = false;
      break label272;
      label460:
      br.a((cc)localObject, parama);
    }
  }
  
  public static EmojiInfo a(bk parambk)
  {
    AppMethodBeat.i(269882);
    Log.i("MicroMsg.emoji.EmojiBypService", "createEmojiInfo: %s", new Object[] { parambk.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    com.tencent.mm.plugin.emoji.g.d.b(parambk, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.aklW;
    localEmojiInfo.field_catalog = EmojiInfo.aklG;
    s.getEmojiStorageMgr().adju.K(localEmojiInfo);
    AppMethodBeat.o(269882);
    return localEmojiInfo;
  }
  
  public static void b(bk parambk)
  {
    AppMethodBeat.i(269896);
    if (parambk == null)
    {
      AppMethodBeat.o(269896);
      return;
    }
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(parambk.talker, "update", null));
    AppMethodBeat.o(269896);
  }
  
  public final void b(String paramString, EmojiInfo paramEmojiInfo, cc paramcc)
  {
    AppMethodBeat.i(269903);
    if ((Util.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(269903);
      return;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    if (com.tencent.mm.plugin.emoji.g.d.x(paramEmojiInfo))
    {
      bool1 = s.dAp().aoy(paramEmojiInfo.field_groupId);
      Log.i("MicroMsg.emoji.EmojiBypService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
    }
    boolean bool2;
    long l1;
    for (;;)
    {
      if (paramcc == null)
      {
        paramcc = new cc();
        if ((paramEmojiInfo.field_type > 3) || (paramEmojiInfo.field_type <= 0))
        {
          Toast.makeText(MMApplicationContext.getContext(), h.h.emoji_send_fail_forbidden, 0).show();
          Log.i("MicroMsg.emoji.EmojiBypService", "gamelife fobidden image: wrong format: emoji Type:%d", new Object[] { Integer.valueOf(paramEmojiInfo.field_type) });
          AppMethodBeat.o(269903);
          return;
          s.dAp().dzI();
        }
        else
        {
          paramcc.setType(47);
          paramcc.BS(paramString);
          paramcc.pI(1);
          if ((!paramEmojiInfo.aqJ()) && (!paramEmojiInfo.isGif()))
          {
            bool2 = true;
            paramcc.setContent(bg.a("", l2, bool2, paramEmojiInfo.getMd5(), bool1, ""));
            paramcc.BT(paramEmojiInfo.getMd5());
            paramcc.setCreateTime(br.JN(paramcc.field_talker));
            l1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(paramcc);
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiBypService", "add Emoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.xMs.add(new a(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((this.xMr) && (this.xMs.size() != 1)) {
        break label502;
      }
      this.xMr = true;
      if ((paramEmojiInfo.field_catalog != EmojiInfo.aklL) && (paramEmojiInfo.field_catalog != EmojiInfo.aklK)) {
        break label439;
      }
      dzK();
      AppMethodBeat.o(269903);
      return;
      bool2 = false;
      break;
      l1 = paramcc.field_msgId;
      bg localbg = bg.byj(paramcc.field_content);
      if (localbg.time == 0L)
      {
        paramcc.setStatus(5);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(l1, paramcc);
        AppMethodBeat.o(269903);
        return;
      }
      l2 = localbg.time;
    }
    label439:
    this.xMt.clear();
    this.xMt.add(((a)this.xMs.get(0)).hBS.field_md5);
    com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.emoji.e.f((LinkedList)this.xMt), 0);
    label502:
    AppMethodBeat.o(269903);
  }
  
  public final void dzK()
  {
    AppMethodBeat.i(269906);
    if (this.xMs.isEmpty())
    {
      Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
      AppMethodBeat.o(269906);
      return;
    }
    Object localObject2 = (a)this.xMs.get(0);
    Object localObject1 = ((a)localObject2).hHa;
    EmojiInfo localEmojiInfo = ((a)localObject2).hBS;
    long l = ((a)localObject2).msgId;
    localObject2 = ((a)localObject2).hHB;
    a locala = a.dxL();
    locala.kLn = String.valueOf(localObject2);
    locala.mgK = localEmojiInfo;
    locala.toUser = ((String)localObject1);
    locala.msgId = Long.valueOf(l).longValue();
    localObject1 = locala.bKW();
    this.xMu = ((t.b)localObject1).oNb;
    ((t.b)localObject1).aXz();
    AppMethodBeat.o(269906);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 2;
    AppMethodBeat.i(269910);
    Log.i("MicroMsg.emoji.EmojiBypService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramp instanceof com.tencent.mm.plugin.emoji.e.f)) && (!this.xMs.isEmpty()))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Ko(5);
        AppMethodBeat.o(269910);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.e.f)paramp;
      if (paramString.rr == null) {}
      for (paramString = null; !paramString.YMz.isEmpty(); paramString = (kn)c.c.b(paramString.rr.otC))
      {
        paramString = (amn)paramString.YMz.getFirst();
        if ((!paramString.Md5.equals(this.xMt.get(0))) || (paramString.Url == null)) {
          break label204;
        }
        dzK();
        AppMethodBeat.o(269910);
        return;
      }
      Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult: BatchEmojiDownLoadResponse resp EmojiList empty ");
      label204:
      if (this.xMs.isEmpty())
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
        AppMethodBeat.o(269910);
        return;
      }
      new com.tencent.mm.emoji.e.f(((a)this.xMs.get(0)).hBS, false, new com.tencent.mm.emoji.e.d.a()
      {
        public final void onResult(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(269902);
          if (paramAnonymousInt == 0)
          {
            d.this.dzK();
            AppMethodBeat.o(269902);
            return;
          }
          d.a(d.this);
          Log.e("MicroMsg.emoji.EmojiBypService", "uploadCDN error");
          AppMethodBeat.o(269902);
        }
      });
      AppMethodBeat.o(269910);
      return;
    }
    if ((this.xMu != null) && (this.xMu.getClass().isInstance(paramp)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "handleBypSendResult errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        i = 5;
      }
      Ko(i);
    }
    AppMethodBeat.o(269910);
  }
  
  final class a
  {
    EmojiInfo hBS;
    String hHB;
    String hHa;
    long msgId;
    
    public a(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.hHa = paramString1;
      this.hBS = paramEmojiInfo;
      this.hHB = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */