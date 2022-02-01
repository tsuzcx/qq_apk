package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;

public class e
  implements com.tencent.mm.ak.e
{
  private static final a hHt;
  
  static
  {
    AppMethodBeat.i(42771);
    hHt = new a();
    AppMethodBeat.o(42771);
  }
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(42768);
    hHt.bu(parama);
    AppMethodBeat.o(42768);
  }
  
  protected bv a(com.tencent.mm.ak.e.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213387);
    cv localcv = parama.gte;
    if (paramString3.equals(paramString1)) {}
    for (parama = paramString2;; parama = paramString1)
    {
      paramString3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().aJ(parama, localcv.xrk);
      ae.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(localcv.xrk), Long.valueOf(paramString3.field_msgId), paramString1, paramString2, parama });
      if ((paramString3.field_msgId != 0L) && (paramString3.field_createTime + 604800000L < bl.B(parama, localcv.CreateTime)))
      {
        ae.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xrk), Long.valueOf(paramString3.field_msgId) });
        bl.rW(paramString3.field_msgId);
        paramString3.setMsgId(0L);
      }
      paramString1 = paramString3;
      if (paramString3.field_msgId == 0L)
      {
        paramString1 = new bv();
        paramString1.ui(parama);
        paramString1.qM(localcv.xrk);
        paramString1.qN(bl.B(parama, localcv.CreateTime));
        paramString1.setType(localcv.urJ);
        paramString1.setContent(bu.aSS(bu.nullAsNil(z.a(localcv.FNI))));
      }
      AppMethodBeat.o(213387);
      return paramString1;
    }
  }
  
  public e.b b(com.tencent.mm.ak.e.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.gte;
    Object localObject2 = (String)g.ajR().ajA().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = z.a(((cv)localObject1).FNG);
    String str3 = z.a(((cv)localObject1).FNH);
    if ((bu.nullAsNil(str1).length() <= 0) || (bu.nullAsNil(str3).length() <= 0))
    {
      ae.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    bv localbv = a(parama, str1, str3, (String)localObject2);
    if (localbv == null)
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
    if (!localbv.Zn)
    {
      if ((((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().has(str1)) || (((String)localObject2).equals(str1)))
      {
        i = 1;
        if (i == 0) {
          break label669;
        }
        localbv.kt(1);
        localbv.ui(str3);
        i = ((cv)localObject1).nJb;
        localbv.setStatus(i);
      }
    }
    else
    {
      if (((cv)localObject1).urJ == 10000) {
        localbv.setStatus(4);
      }
      if (localbv.field_isSend != 1) {
        break label705;
      }
      bool = true;
      localbv.tk(((cv)localObject1).FNL);
      if (localbv.aVB(v.aAC()))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(localbv.field_talker);
        if (localObject2 != null)
        {
          ((au)localObject2).lR(16777216);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().a((au)localObject2, localbv.field_talker);
        }
      }
      hHt.a(parama, localbv, str1, str3, bool);
      if (localbv.field_msgId != 0L) {
        break label710;
      }
      localbv.setFlag(2);
      bl.a(localbv, parama);
      localbv.setMsgId(bl.v(localbv));
      localb = new e.b(localbv, true);
      if (!bu.isNullOrNil(localbv.field_content))
      {
        if (!bool) {
          break label750;
        }
        str2 = str3;
        label386:
        if ((!parama.hQN) && (((com.tencent.mm.plugin.messenger.foundation.a.j)g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).anM(str2)))
        {
          if (!bool) {
            break label757;
          }
          localObject2 = localbv.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.j.DEBUG) {
        ae.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, bu.bI((String)localObject2, "null") });
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).a(str2, (String)localObject1, (String)localObject2, localbv.field_msgId, localbv.field_createTime / 1000L);
      if ((localbv.fwp()) && (x.zU(localbv.field_talker)) && (((t)g.ab(t.class)).Yn()))
      {
        g.ajS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(localbv.field_talker);
        long l = ((aw)localObject1).eRB;
        ((an)localObject1).qG(localbv.field_msgId);
        g.ajS();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().am((an)localObject1);
        if (l != 0L) {
          ((t)g.ab(t.class)).q(localbv.field_talker, l);
        }
      }
      hHt.b(parama, localbv, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      i = 0;
      break;
      label669:
      localbv.kt(0);
      localbv.ui(str1);
      if (((cv)localObject1).nJb > 3)
      {
        i = ((cv)localObject1).nJb;
        break label190;
      }
      i = 3;
      break label190;
      label705:
      bool = false;
      break label224;
      label710:
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().b(((cv)localObject1).xrk, localbv);
      localb = new e.b(localbv, false);
      break label367;
      label750:
      str2 = str1;
      break label386;
      label757:
      localObject2 = localbv.field_content;
      i = bl.BJ(localbv.field_content);
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
    extends com.tencent.mm.cm.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public final void a(final com.tencent.mm.ak.e.a parama, final bv parambv, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42766);
      a(new a.a() {});
      AppMethodBeat.o(42766);
    }
    
    public final void b(final com.tencent.mm.ak.e.a parama, final bv parambv, final String paramString1, final String paramString2, final boolean paramBoolean)
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