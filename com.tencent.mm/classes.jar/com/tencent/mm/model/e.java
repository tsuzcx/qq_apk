package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;

public class e
  implements com.tencent.mm.al.e
{
  private static final a hEB;
  
  static
  {
    AppMethodBeat.i(42771);
    hEB = new a();
    AppMethodBeat.o(42771);
  }
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(42768);
    hEB.bu(parama);
    AppMethodBeat.o(42768);
  }
  
  protected bu a(com.tencent.mm.al.e.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(192513);
    cv localcv = parama.gqE;
    if (paramString3.equals(paramString1)) {}
    for (parama = paramString2;; parama = paramString1)
    {
      paramString3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aI(parama, localcv.xbt);
      ad.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(localcv.xbt), Long.valueOf(paramString3.field_msgId), paramString1, paramString2, parama });
      if ((paramString3.field_msgId != 0L) && (paramString3.field_createTime + 604800000L < bj.B(parama, localcv.CreateTime)))
      {
        ad.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xbt), Long.valueOf(paramString3.field_msgId) });
        bj.rJ(paramString3.field_msgId);
        paramString3.setMsgId(0L);
      }
      paramString1 = paramString3;
      if (paramString3.field_msgId == 0L)
      {
        paramString1 = new bu();
        paramString1.tN(parama);
        paramString1.qz(localcv.xbt);
        paramString1.qA(bj.B(parama, localcv.CreateTime));
        paramString1.setType(localcv.ugm);
        paramString1.setContent(bt.aRv(bt.nullAsNil(z.a(localcv.Fvk))));
      }
      AppMethodBeat.o(192513);
      return paramString1;
    }
  }
  
  public e.b b(com.tencent.mm.al.e.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.gqE;
    Object localObject2 = (String)g.ajC().ajl().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = z.a(((cv)localObject1).Fvi);
    String str3 = z.a(((cv)localObject1).Fvj);
    if ((bt.nullAsNil(str1).length() <= 0) || (bt.nullAsNil(str3).length() <= 0))
    {
      ad.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    bu localbu = a(parama, str1, str3, (String)localObject2);
    if (localbu == null)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    int i;
    label190:
    boolean bool;
    label224:
    e.b localb;
    label367:
    String str2;
    if (!localbu.Zn)
    {
      if ((((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().has(str1)) || (((String)localObject2).equals(str1)))
      {
        i = 1;
        if (i == 0) {
          break label669;
        }
        localbu.kr(1);
        localbu.tN(str3);
        i = ((cv)localObject1).nDG;
        localbu.setStatus(i);
      }
    }
    else
    {
      if (((cv)localObject1).ugm == 10000) {
        localbu.setStatus(4);
      }
      if (localbu.field_isSend != 1) {
        break label705;
      }
      bool = true;
      localbu.sP(((cv)localObject1).Fvn);
      if (localbu.aUa(u.aAm()))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz(localbu.field_talker);
        if (localObject2 != null)
        {
          ((at)localObject2).lP(16777216);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().a((at)localObject2, localbu.field_talker);
        }
      }
      hEB.a(parama, localbu, str1, str3, bool);
      if (localbu.field_msgId != 0L) {
        break label710;
      }
      localbu.setFlag(2);
      bj.a(localbu, parama);
      localbu.setMsgId(bj.v(localbu));
      localb = new e.b(localbu, true);
      if (!bt.isNullOrNil(localbu.field_content))
      {
        if (!bool) {
          break label750;
        }
        str2 = str3;
        label386:
        if ((!parama.hNU) && (((j)g.ab(j.class)).amL(str2)))
        {
          if (!bool) {
            break label757;
          }
          localObject2 = localbu.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.i.DEBUG) {
        ad.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, bt.bI((String)localObject2, "null") });
      }
      ((j)g.ab(j.class)).a(str2, (String)localObject1, (String)localObject2, localbu.field_msgId, localbu.field_createTime / 1000L);
      if ((localbu.fso()) && (w.zk(localbu.field_talker)) && (((s)g.ab(s.class)).Yd()))
      {
        g.ajD();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(localbu.field_talker);
        long l = ((aw)localObject1).ePQ;
        ((am)localObject1).qt(localbu.field_msgId);
        g.ajD();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().af((am)localObject1);
        if (l != 0L) {
          ((s)g.ab(s.class)).q(localbu.field_talker, l);
        }
      }
      hEB.b(parama, localbu, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      i = 0;
      break;
      label669:
      localbu.kr(0);
      localbu.tN(str1);
      if (((cv)localObject1).nDG > 3)
      {
        i = ((cv)localObject1).nDG;
        break label190;
      }
      i = 3;
      break label190;
      label705:
      bool = false;
      break label224;
      label710:
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().b(((cv)localObject1).xbt, localbu);
      localb = new e.b(localbu, false);
      break label367;
      label750:
      str2 = str1;
      break label386;
      label757:
      localObject2 = localbu.field_content;
      i = bj.Bh(localbu.field_content);
      if (i != -1)
      {
        localObject1 = ((String)localObject2).substring(0, i).trim();
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
        for (;;)
        {
          localObject2 = ((String)localObject2).substring(i + 1).trim();
          break;
          localObject1 = "";
        }
      }
      localObject1 = "";
    }
  }
  
  public void b(e.c paramc) {}
  
  public static final class a
    extends com.tencent.mm.cn.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public final void a(final com.tencent.mm.al.e.a parama, final bu parambu, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42766);
      a(new a.a() {});
      AppMethodBeat.o(42766);
    }
    
    public final void b(final com.tencent.mm.al.e.a parama, final bu parambu, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42767);
      a(new a.a() {});
      AppMethodBeat.o(42767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.e
 * JD-Core Version:    0.7.0.1
 */