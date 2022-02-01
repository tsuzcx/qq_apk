package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.co.a.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;

public class e
  implements h
{
  private static final a iBD;
  
  static
  {
    AppMethodBeat.i(42771);
    iBD = new a();
    AppMethodBeat.o(42771);
  }
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(42768);
    iBD.add(parama);
    AppMethodBeat.o(42768);
  }
  
  protected ca a(h.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(225913);
    de localde = parama.heO;
    if (paramString3.equals(paramString1)) {}
    for (parama = paramString2;; parama = paramString1)
    {
      paramString3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(parama, localde.Brn);
      Log.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(localde.Brn), Long.valueOf(paramString3.field_msgId), paramString1, paramString2, parama });
      if ((paramString3.field_msgId != 0L) && (paramString3.field_createTime + 604800000L < bp.C(parama, localde.CreateTime)))
      {
        Log.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localde.Brn), Long.valueOf(paramString3.field_msgId) });
        bp.Ad(paramString3.field_msgId);
        paramString3.setMsgId(0L);
      }
      paramString1 = paramString3;
      if (paramString3.field_msgId == 0L)
      {
        paramString1 = new ca();
        paramString1.Cy(parama);
        paramString1.yF(localde.Brn);
        paramString1.setCreateTime(bp.C(parama, localde.CreateTime));
        paramString1.setType(localde.xKb);
        paramString1.setContent(Util.escapeStringForUCC(Util.nullAsNil(com.tencent.mm.platformtools.z.a(localde.KHn))));
      }
      AppMethodBeat.o(225913);
      return paramString1;
    }
  }
  
  public h.b b(h.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.heO;
    Object localObject2 = (String)g.aAh().azQ().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = com.tencent.mm.platformtools.z.a(((de)localObject1).KHl);
    String str3 = com.tencent.mm.platformtools.z.a(((de)localObject1).KHm);
    if ((Util.nullAsNil(str1).length() <= 0) || (Util.nullAsNil(str3).length() <= 0))
    {
      Log.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    ca localca = a(parama, str1, str3, (String)localObject2);
    if (localca == null)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    int i;
    label190:
    boolean bool;
    label224:
    h.b localb;
    label367:
    String str2;
    if (!localca.ZA)
    {
      if ((((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().has(str1)) || (((String)localObject2).equals(str1)))
      {
        i = 1;
        if (i == 0) {
          break label669;
        }
        localca.nv(1);
        localca.Cy(str3);
        i = ((de)localObject1).oTW;
        localca.setStatus(i);
      }
    }
    else
    {
      if (((de)localObject1).xKb == 10000) {
        localca.setStatus(4);
      }
      if (localca.field_isSend != 1) {
        break label705;
      }
      bool = true;
      localca.BB(((de)localObject1).KHq);
      if (localca.bkz(z.aTY()))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(localca.field_talker);
        if (localObject2 != null)
        {
          ((az)localObject2).oU(16777216);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a((az)localObject2, localca.field_talker);
        }
      }
      iBD.a(parama, localca, str1, str3, bool);
      if (localca.field_msgId != 0L) {
        break label710;
      }
      localca.setFlag(2);
      bp.a(localca, parama);
      localca.setMsgId(bp.x(localca));
      localb = new h.b(localca, true);
      if (!Util.isNullOrNil(localca.field_content))
      {
        if (!bool) {
          break label750;
        }
        str2 = str3;
        label386:
        if ((!parama.iLV) && (((j)g.af(j.class)).aBf(str2)))
        {
          if (!bool) {
            break label757;
          }
          localObject2 = localca.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, Util.nullAs((String)localObject2, "null") });
      }
      ((j)g.af(j.class)).a(str2, (String)localObject1, (String)localObject2, localca.field_msgId, localca.field_createTime / 1000L);
      if ((localca.gDV()) && (ab.Ix(localca.field_talker)) && (((t)g.af(t.class)).ama()))
      {
        g.aAi();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localca.field_talker);
        long l = ((ax)localObject1).fve;
        ((as)localObject1).yz(localca.field_msgId);
        g.aAi();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ao((as)localObject1);
        if (l != 0L) {
          ((t)g.af(t.class)).r(localca.field_talker, l);
        }
      }
      iBD.b(parama, localca, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      i = 0;
      break;
      label669:
      localca.nv(0);
      localca.Cy(str1);
      if (((de)localObject1).oTW > 3)
      {
        i = ((de)localObject1).oTW;
        break label190;
      }
      i = 3;
      break label190;
      label705:
      bool = false;
      break label224;
      label710:
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().b(((de)localObject1).Brn, localca);
      localb = new h.b(localca, false);
      break label367;
      label750:
      str2 = str1;
      break label386;
      label757:
      localObject2 = localca.field_content;
      i = bp.Kp(localca.field_content);
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
  
  public void b(h.c paramc) {}
  
  public static final class a
    extends com.tencent.mm.co.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public final void a(final h.a parama, final ca paramca, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42766);
      a(new a.a() {});
      AppMethodBeat.o(42766);
    }
    
    public final void b(final h.a parama, final ca paramca, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42767);
      a(new a.a() {});
      AppMethodBeat.o(42767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.e
 * JD-Core Version:    0.7.0.1
 */