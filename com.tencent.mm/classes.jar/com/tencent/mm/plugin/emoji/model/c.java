package com.tencent.mm.plugin.emoji.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.d.d.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.e;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.ak.i
{
  private boolean raZ;
  List<a> rba;
  List<String> rbb;
  private q rbc;
  
  public c()
  {
    AppMethodBeat.i(240141);
    this.raZ = false;
    this.rba = new LinkedList();
    this.rbb = new LinkedList();
    g.aAg().hqi.a(3862, this);
    g.aAg().hqi.a(697, this);
    AppMethodBeat.o(240141);
  }
  
  final void FV(int paramInt)
  {
    AppMethodBeat.i(240145);
    if (this.rba.size() <= 0)
    {
      this.raZ = false;
      AppMethodBeat.o(240145);
      return;
    }
    a locala = (a)this.rba.remove(0);
    ca localca = ((l)g.af(l.class)).eiy().Hb(locala.msgId);
    localca.setStatus(paramInt);
    ((l)g.af(l.class)).eiy().a(locala.msgId, localca);
    if (this.rba.size() > 0)
    {
      this.rbb.clear();
      this.rbb.add(((a)this.rba.get(0)).dEz.field_md5);
      g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.f((LinkedList)this.rbb), 0);
      AppMethodBeat.o(240145);
      return;
    }
    this.raZ = false;
    AppMethodBeat.o(240145);
  }
  
  public final void b(String paramString, EmojiInfo paramEmojiInfo, ca paramca)
  {
    AppMethodBeat.i(240142);
    if ((Util.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(240142);
      return;
    }
    long l2 = System.currentTimeMillis();
    boolean bool1 = false;
    if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
    {
      bool1 = k.cGj().amF(paramEmojiInfo.field_groupId);
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
          Toast.makeText(MMApplicationContext.getContext(), 2131758590, 0).show();
          Log.i("MicroMsg.emoji.EmojiBypService", "gamelife fobidden image: wrong format: emoji Type:%d", new Object[] { Integer.valueOf(paramEmojiInfo.field_type) });
          AppMethodBeat.o(240142);
          return;
          k.cGj().cFU();
        }
        else
        {
          paramca.setType(47);
          paramca.Cy(paramString);
          paramca.nv(1);
          if ((!paramEmojiInfo.NA()) && (!paramEmojiInfo.isGif()))
          {
            bool2 = true;
            paramca.setContent(be.a("", l2, bool2, paramEmojiInfo.getMd5(), bool1, ""));
            paramca.Cz(paramEmojiInfo.getMd5());
            paramca.setCreateTime(bp.Kw(paramca.field_talker));
            l1 = ((l)g.af(l.class)).eiy().aC(paramca);
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiBypService", "add Emoji: msgId = %s, md5 %s, len %s", new Object[] { Long.valueOf(l1), paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      this.rba.add(new a(l1, paramString, paramEmojiInfo, String.valueOf(l2)));
      if ((this.raZ) && (this.rba.size() != 1)) {
        break label492;
      }
      this.raZ = true;
      if ((paramEmojiInfo.field_catalog != EmojiInfo.Uuu) && (paramEmojiInfo.field_catalog != EmojiInfo.Uut)) {
        break label429;
      }
      cFV();
      AppMethodBeat.o(240142);
      return;
      bool2 = false;
      break;
      l1 = paramca.field_msgId;
      be localbe = be.bkr(paramca.field_content);
      if (localbe.time == 0L)
      {
        paramca.setStatus(5);
        ((l)g.af(l.class)).eiy().a(l1, paramca);
        AppMethodBeat.o(240142);
        return;
      }
      l2 = localbe.time;
    }
    label429:
    this.rbb.clear();
    this.rbb.add(((a)this.rba.get(0)).dEz.field_md5);
    g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.f((LinkedList)this.rbb), 0);
    label492:
    AppMethodBeat.o(240142);
  }
  
  public final void cFV()
  {
    AppMethodBeat.i(240143);
    if (this.rba.isEmpty())
    {
      Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
      AppMethodBeat.o(240143);
      return;
    }
    Object localObject2 = (a)this.rba.get(0);
    Object localObject1 = ((a)localObject2).dJw;
    EmojiInfo localEmojiInfo = ((a)localObject2).dEz;
    long l = ((a)localObject2).msgId;
    localObject2 = ((a)localObject2).dJX;
    a locala = a.cEL();
    locala.fQY = String.valueOf(localObject2);
    locala.gWm = localEmojiInfo;
    locala.toUser = ((String)localObject1);
    locala.msgId = Long.valueOf(l).longValue();
    localObject1 = locala.bdQ();
    this.rbc = ((o.b)localObject1).jdJ;
    ((o.b)localObject1).execute();
    AppMethodBeat.o(240143);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 2;
    AppMethodBeat.i(240144);
    Log.i("MicroMsg.emoji.EmojiBypService", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (((paramq instanceof com.tencent.mm.plugin.emoji.f.f)) && (!this.rba.isEmpty()))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        FV(5);
        AppMethodBeat.o(240144);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.f)paramq;
      if (paramString.rr == null) {}
      for (paramString = null; !paramString.KOp.isEmpty(); paramString = (kb)paramString.rr.iLL.iLR)
      {
        paramString = (ait)paramString.KOp.getFirst();
        if ((!paramString.Md5.equals(this.rbb.get(0))) || (paramString.Url == null)) {
          break label204;
        }
        cFV();
        AppMethodBeat.o(240144);
        return;
      }
      Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult: BatchEmojiDownLoadResponse resp EmojiList empty ");
      label204:
      if (this.rba.isEmpty())
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
        AppMethodBeat.o(240144);
        return;
      }
      new com.tencent.mm.emoji.d.f(((a)this.rba.get(0)).dEz, false, new d.a()
      {
        public final void A(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(240139);
          if (paramAnonymousInt == 0)
          {
            c.this.cFV();
            AppMethodBeat.o(240139);
            return;
          }
          c.this.FV(5);
          Log.e("MicroMsg.emoji.EmojiBypService", "uploadCDN error");
          AppMethodBeat.o(240139);
        }
      });
      AppMethodBeat.o(240144);
      return;
    }
    if ((this.rbc != null) && (this.rbc.getClass().isInstance(paramq)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.emoji.EmojiBypService", "handleBypSendResult errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        i = 5;
      }
      FV(i);
    }
    AppMethodBeat.o(240144);
  }
  
  final class a
  {
    EmojiInfo dEz;
    String dJX;
    String dJw;
    long msgId;
    
    public a(long paramLong, String paramString1, EmojiInfo paramEmojiInfo, String paramString2)
    {
      this.msgId = paramLong;
      this.dJw = paramString1;
      this.dEz = paramEmojiInfo;
      this.dJX = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */