package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;

public class e
  implements f
{
  private static final a hmo;
  
  static
  {
    AppMethodBeat.i(42771);
    hmo = new a((byte)0);
    AppMethodBeat.o(42771);
  }
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(42768);
    hmo.bs(parama);
    AppMethodBeat.o(42768);
  }
  
  protected bo a(cu paramcu, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(42770);
    if (paramString3.equals(paramString1)) {}
    for (paramString3 = paramString2;; paramString3 = paramString1)
    {
      bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(paramString3, paramcu.vTQ);
      ac.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(paramcu.vTQ), Long.valueOf(localbo.field_msgId), paramString1, paramString2, paramString3 });
      if ((localbo.field_msgId != 0L) && (localbo.field_createTime + 604800000L < bi.z(paramString3, paramcu.CreateTime)))
      {
        ac.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(paramcu.vTQ), Long.valueOf(localbo.field_msgId) });
        bi.pK(localbo.field_msgId);
        localbo.setMsgId(0L);
      }
      paramString1 = localbo;
      if (localbo.field_msgId == 0L)
      {
        paramString1 = new bo();
        paramString1.oz(paramcu.vTQ);
        paramString1.oA(bi.z(paramString3, paramcu.CreateTime));
        paramString1.setType(paramcu.tit);
        paramString1.setContent(bs.aLO(bs.nullAsNil(z.a(paramcu.DPV))));
      }
      AppMethodBeat.o(42770);
      return paramString1;
    }
  }
  
  public f.b b(f.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.fXi;
    Object localObject2 = (String)g.agR().agA().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = z.a(((cu)localObject1).DPT);
    String str3 = z.a(((cu)localObject1).DPU);
    if ((bs.nullAsNil(str1).length() <= 0) || (bs.nullAsNil(str3).length() <= 0))
    {
      ac.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    bo localbo = a((cu)localObject1, str1, str3, (String)localObject2);
    if (localbo == null)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    boolean bool;
    int i;
    label183:
    f.b localb;
    label349:
    String str2;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().has(str1)) || (((String)localObject2).equals(str1)))
    {
      bool = true;
      if (!bool) {
        break label687;
      }
      localbo.jT(1);
      localbo.re(str3);
      i = ((cu)localObject1).ndj;
      localbo.setStatus(i);
      if (((cu)localObject1).tit == 10000) {
        localbo.setStatus(4);
      }
      localbo.qf(((cu)localObject1).DPY);
      if (localbo.aOj(u.axw()))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(localbo.field_talker);
        if (localObject2 != null)
        {
          ((ap)localObject2).lq(16777216);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a((ap)localObject2, localbo.field_talker);
        }
      }
      hmo.a(parama, localbo, str1, str3, bool);
      if (localbo.field_msgId != 0L) {
        break label723;
      }
      localbo.setFlag(2);
      bi.a(localbo, parama);
      localbo.setMsgId(bi.u(localbo));
      localb = new f.b(localbo, true);
      if (!bs.isNullOrNil(localbo.field_content))
      {
        if (!bool) {
          break label763;
        }
        str2 = str3;
        label368:
        if ((!parama.hvF) && (((i)g.ab(i.class)).ahY(str2)))
        {
          if (!bool) {
            break label770;
          }
          localObject2 = localbo.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        ac.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, bs.bG((String)localObject2, "null") });
      }
      ((i)g.ab(i.class)).a(str2, (String)localObject1, (String)localObject2, localbo.field_msgId, localbo.field_createTime / 1000L);
      if ((localbo.fch()) && (w.wp(localbo.field_talker)) && (((r)g.ab(r.class)).VM()))
      {
        g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localbo.field_talker);
        long l = ((av)localObject1).eys;
        ((ai)localObject1).ot(localbo.field_msgId);
        g.agS();
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().af((ai)localObject1);
        if (l != 0L)
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
          if (!bs.isNullOrNil(((dy)localObject1).eSo)) {
            ((r)g.ab(r.class)).aa(localbo.field_talker, ((dy)localObject1).eSo);
          }
        }
      }
      hmo.b(parama, localbo, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      bool = false;
      break;
      label687:
      localbo.jT(0);
      localbo.re(str1);
      if (((cu)localObject1).ndj > 3)
      {
        i = ((cu)localObject1).ndj;
        break label183;
      }
      i = 3;
      break label183;
      label723:
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().b(((cu)localObject1).vTQ, localbo);
      localb = new f.b(localbo, false);
      break label349;
      label763:
      str2 = str1;
      break label368;
      label770:
      localObject2 = localbo.field_content;
      i = bi.yi(localbo.field_content);
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
  
  public void b(f.c paramc) {}
  
  static final class a
    extends com.tencent.mm.cn.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public final void a(final f.a parama, final bo parambo, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42766);
      a(new a.a() {});
      AppMethodBeat.o(42766);
    }
    
    public final void b(final f.a parama, final bo parambo, final String paramString1, final String paramString2, final boolean paramBoolean)
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