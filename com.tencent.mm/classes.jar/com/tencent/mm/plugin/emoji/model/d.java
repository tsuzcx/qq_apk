package com.tencent.mm.plugin.emoji.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.e;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements com.tencent.mm.an.i
{
  private boolean uEa;
  List<a> uEb;
  List<String> uEc;
  private q uEd;
  
  public d()
  {
    AppMethodBeat.i(257213);
    this.uEa = false;
    this.uEb = new LinkedList();
    this.uEc = new LinkedList();
    h.aHF().kcd.a(3862, this);
    h.aHF().kcd.a(697, this);
    AppMethodBeat.o(257213);
  }
  
  private void JD(int paramInt)
  {
    AppMethodBeat.i(257226);
    if (this.uEb.size() <= 0)
    {
      this.uEa = false;
      AppMethodBeat.o(257226);
      return;
    }
    a locala = (a)this.uEb.remove(0);
    ca localca = ((n)h.ae(n.class)).eSe().Oq(locala.msgId);
    localca.setStatus(paramInt);
    ((n)h.ae(n.class)).eSe().a(locala.msgId, localca);
    if (this.uEb.size() > 0)
    {
      this.uEc.clear();
      this.uEc.add(((a)this.uEb.get(0)).fxn.field_md5);
      h.aHF().kcd.a(new com.tencent.mm.plugin.emoji.f.f((LinkedList)this.uEc), 0);
      AppMethodBeat.o(257226);
      return;
    }
    this.uEa = false;
    AppMethodBeat.o(257226);
  }
  
  public static long a(bi parambi, EmojiInfo paramEmojiInfo, h.a parama)
  {
    AppMethodBeat.i(257231);
    Log.i("MicroMsg.emoji.EmojiBypService", "insertEmojiMsg: %s, %s msgSvrId: %s", new Object[] { parambi.md5, paramEmojiInfo.field_md5, Long.valueOf(parambi.fNu) });
    long l;
    if (parambi.fNu != 0L)
    {
      localObject = ((n)h.ae(n.class)).eSe().aL(parambi.talker, parambi.fNu);
      if (((et)localObject).field_msgSvrId == parambi.fNu)
      {
        l = ((et)localObject).field_msgId;
        AppMethodBeat.o(257231);
        return l;
      }
    }
    Object localObject = ((n)h.ae(n.class)).bbL().RG(parambi.talker);
    if ((localObject == null) || ((int)((com.tencent.mm.contact.d)localObject).jxt == 0))
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
        break label449;
      }
      bool = true;
      label267:
      ((ca)localObject).setContent(be.a(str, 0L, bool, paramEmojiInfo.getMd5(), false, parambi.VFz));
      ((ca)localObject).setCreateTime(bq.z(((et)localObject).field_talker, parambi.createTime));
      ((ca)localObject).setStatus(3);
      if (!Util.isNullOrNil(parambi.hxy)) {
        ((ca)localObject).Ip(parambi.hxy);
      }
      if (parama != null) {
        break label455;
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
      Log.i("MicroMsg.emoji.EmojiBypService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(parambi.mkX) });
    }
    for (;;)
    {
      l = bq.z((ca)localObject);
      AppMethodBeat.o(257231);
      return l;
      i = 0;
      break;
      label449:
      bool = false;
      break label267;
      label455:
      bq.a((ca)localObject, parama);
    }
  }
  
  public static EmojiInfo a(bi parambi)
  {
    AppMethodBeat.i(257228);
    Log.i("MicroMsg.emoji.EmojiBypService", "createEmojiInfo: %s", new Object[] { parambi.md5 });
    EmojiInfo localEmojiInfo = new EmojiInfo();
    b.b(parambi, localEmojiInfo);
    localEmojiInfo.field_temp = 1;
    localEmojiInfo.field_state = EmojiInfo.ZuH;
    localEmojiInfo.field_catalog = EmojiInfo.YCx;
    p.getEmojiStorageMgr().VFH.K(localEmojiInfo);
    AppMethodBeat.o(257228);
    return localEmojiInfo;
  }
  
  public static void b(bi parambi)
  {
    AppMethodBeat.i(257232);
    if (parambi == null)
    {
      AppMethodBeat.o(257232);
      return;
    }
    ((n)h.ae(n.class)).eSe().a(new i.c(parambi.talker, "update", null));
    AppMethodBeat.o(257232);
  }
  
  public final void b(String paramString, EmojiInfo paramEmojiInfo, ca paramca)
  {
    AppMethodBeat.i(257218);
    if ((Util.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(257218);
      return;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    if (b.x(paramEmojiInfo))
    {
      bool1 = p.cUS().auz(paramEmojiInfo.field_groupId);
      Log.i("MicroMsg.emoji.EmojiBypService", "isNeedShowRewardTip:%b", new Object[] { Boolean.valueOf(bool1) });
    }
    boolean bool2;
    long l1;
    for (;;)
    {
      if (paramca == null)
      {
        paramca = new ca();
        if ((paramEmojiInfo.field_type > 3) || (paramEmojiInfo.field_type <= 0))
        {
          Toast.makeText(MMApplicationContext.getContext(), i.h.emoji_send_fail_forbidden, 0).show();
          Log.i("MicroMsg.emoji.EmojiBypService", "gamelife fobidden image: wrong format: emoji Type:%d", new Object[] { Integer.valueOf(paramEmojiInfo.field_type) });
          AppMethodBeat.o(257218);
          return;
          p.cUS().cUB();
        }
        else
        {
          paramca.setType(47);
          paramca.Jm(paramString);
          paramca.pJ(1);
          if ((!paramEmojiInfo.Qv()) && (!paramEmojiInfo.isGif()))
          {
            bool2 = true;
            paramca.setContent(be.a("", l2, bool2, paramEmojiInfo.getMd5(), bool1, ""));
            paramca.Jn(paramEmojiInfo.getMd5());
            paramca.setCreateTime(bq.RP(paramca.field_talker));
            l1 = ((n)h.ae(n.class)).eSe().aM(paramca);
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiBypService", "add Emoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.uEb.add(new a(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((this.uEa) && (this.uEb.size() != 1)) {
        break label502;
      }
      this.uEa = true;
      if ((paramEmojiInfo.field_catalog != EmojiInfo.YCC) && (paramEmojiInfo.field_catalog != EmojiInfo.YCB)) {
        break label439;
      }
      cUD();
      AppMethodBeat.o(257218);
      return;
      bool2 = false;
      break;
      l1 = paramca.field_msgId;
      be localbe = be.bwQ(paramca.field_content);
      if (localbe.time == 0L)
      {
        paramca.setStatus(5);
        ((n)h.ae(n.class)).eSe().a(l1, paramca);
        AppMethodBeat.o(257218);
        return;
      }
      l2 = localbe.time;
    }
    label439:
    this.uEc.clear();
    this.uEc.add(((a)this.uEb.get(0)).fxn.field_md5);
    h.aHF().kcd.a(new com.tencent.mm.plugin.emoji.f.f((LinkedList)this.uEc), 0);
    label502:
    AppMethodBeat.o(257218);
  }
  
  public final void cUD()
  {
    AppMethodBeat.i(257220);
    if (this.uEb.isEmpty())
    {
      Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
      AppMethodBeat.o(257220);
      return;
    }
    Object localObject2 = (a)this.uEb.get(0);
    Object localObject1 = ((a)localObject2).fCl;
    EmojiInfo localEmojiInfo = ((a)localObject2).fxn;
    long l = ((a)localObject2).msgId;
    localObject2 = ((a)localObject2).fCM;
    a locala = a.cTq();
    locala.ilo = String.valueOf(localObject2);
    locala.jHh = localEmojiInfo;
    locala.toUser = ((String)localObject1);
    locala.msgId = Long.valueOf(l).longValue();
    localObject1 = locala.bnl();
    this.uEd = ((o.b)localObject1).lUi;
    ((o.b)localObject1).aEv();
    AppMethodBeat.o(257220);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 2;
    AppMethodBeat.i(257224);
    Log.i("MicroMsg.emoji.EmojiBypService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramq instanceof com.tencent.mm.plugin.emoji.f.f)) && (!this.uEb.isEmpty()))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        JD(5);
        AppMethodBeat.o(257224);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.f)paramq;
      if (paramString.rr == null) {}
      for (paramString = null; !paramString.RPm.isEmpty(); paramString = (jr)d.c.b(paramString.rr.lBS))
      {
        paramString = (aji)paramString.RPm.getFirst();
        if ((!paramString.Md5.equals(this.uEc.get(0))) || (paramString.Url == null)) {
          break label204;
        }
        cUD();
        AppMethodBeat.o(257224);
        return;
      }
      Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult: BatchEmojiDownLoadResponse resp EmojiList empty ");
      label204:
      if (this.uEb.isEmpty())
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
        AppMethodBeat.o(257224);
        return;
      }
      new com.tencent.mm.emoji.d.f(((a)this.uEb.get(0)).fxn, false, new com.tencent.mm.emoji.d.d.a()
      {
        public final void B(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(258323);
          if (paramAnonymousInt == 0)
          {
            d.this.cUD();
            AppMethodBeat.o(258323);
            return;
          }
          d.a(d.this);
          Log.e("MicroMsg.emoji.EmojiBypService", "uploadCDN error");
          AppMethodBeat.o(258323);
        }
      });
      AppMethodBeat.o(257224);
      return;
    }
    if ((this.uEd != null) && (this.uEd.getClass().isInstance(paramq)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "handleBypSendResult errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        i = 5;
      }
      JD(i);
    }
    AppMethodBeat.o(257224);
  }
  
  final class a
  {
    String fCM;
    String fCl;
    EmojiInfo fxn;
    long msgId;
    
    public a(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.fCl = paramString1;
      this.fxn = paramEmojiInfo;
      this.fCM = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */