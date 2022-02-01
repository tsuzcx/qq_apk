package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cp.a;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;

public class e
  implements g
{
  private static final a oiJ;
  
  static
  {
    AppMethodBeat.i(42771);
    oiJ = new a();
    AppMethodBeat.o(42771);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(42768);
    oiJ.add(paramc);
    AppMethodBeat.o(42768);
  }
  
  protected cc a(g.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241933);
    dl localdl = parama.mpN;
    if (paramString3.equals(paramString1)) {}
    for (parama = paramString2;; parama = paramString1)
    {
      paramString3 = ((n)h.ax(n.class)).gaZ().aU(parama, localdl.Njv);
      Log.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(paramString3.field_msgId), paramString1, paramString2, parama });
      if ((paramString3.field_msgId != 0L) && (paramString3.getCreateTime() + 604800000L < br.D(parama, localdl.CreateTime)))
      {
        Log.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(paramString3.field_msgId) });
        br.iu(paramString3.field_msgId);
        paramString3.setMsgId(0L);
      }
      paramString1 = paramString3;
      if (paramString3.field_msgId == 0L)
      {
        paramString1 = new cc();
        paramString1.BS(parama);
        paramString1.gX(localdl.Njv);
        paramString1.setCreateTime(br.D(parama, localdl.CreateTime));
        paramString1.setType(localdl.IIs);
        paramString1.setContent(Util.escapeStringForUCC(Util.nullAsNil(com.tencent.mm.platformtools.w.a(localdl.YFG))));
      }
      AppMethodBeat.o(241933);
      return paramString1;
    }
  }
  
  public g.b b(g.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.mpN;
    Object localObject2 = (String)h.baE().ban().d(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = com.tencent.mm.platformtools.w.a(((dl)localObject1).YFE);
    String str3 = com.tencent.mm.platformtools.w.a(((dl)localObject1).YFF);
    if ((Util.nullAsNil(str1).length() <= 0) || (Util.nullAsNil(str3).length() <= 0))
    {
      Log.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    cc localcc = a(parama, str1, str3, (String)localObject2);
    if (localcc == null)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    int i;
    label190:
    boolean bool;
    label224:
    g.b localb;
    label367:
    String str2;
    if (!localcc.hS)
    {
      if ((((n)h.ax(n.class)).bzJ().has(str1)) || (((String)localObject2).equals(str1)))
      {
        i = 1;
        if (i == 0) {
          break label669;
        }
        localcc.pI(1);
        localcc.BS(str3);
        i = ((dl)localObject1).vhk;
        localcc.setStatus(i);
      }
    }
    else
    {
      if (((dl)localObject1).IIs == 10000) {
        localcc.setStatus(4);
      }
      if (localcc.field_isSend != 1) {
        break label705;
      }
      bool = true;
      localcc.AU(((dl)localObject1).YFJ);
      if (localcc.byr(z.bAM()))
      {
        localObject2 = ((n)h.ax(n.class)).bzG().bxM(localcc.field_talker);
        if (localObject2 != null)
        {
          ((bb)localObject2).rw(16777216);
          ((n)h.ax(n.class)).bzG().c((bb)localObject2, localcc.field_talker);
        }
      }
      oiJ.a(parama, localcc, str1, str3, bool);
      if (localcc.field_msgId != 0L) {
        break label710;
      }
      localcc.setFlag(2);
      br.a(localcc, parama);
      localcc.setMsgId(br.B(localcc));
      localb = new g.b(localcc, true);
      if (!Util.isNullOrNil(localcc.field_content))
      {
        if (!bool) {
          break label750;
        }
        str2 = str3;
        label386:
        if ((!parama.otM) && (((com.tencent.mm.plugin.messenger.foundation.a.l)h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aHK(str2)))
        {
          if (!bool) {
            break label757;
          }
          localObject2 = localcc.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, Util.nullAs((String)localObject2, "null") });
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).b(str2, (String)localObject1, (String)localObject2, localcc.field_msgId, localcc.getCreateTime() / 1000L);
      if ((localcc.jcs()) && (au.bwG(localcc.field_talker)) && (((com.tencent.mm.plugin.messenger.foundation.a.w)h.ax(com.tencent.mm.plugin.messenger.foundation.a.w.class)).aLX()))
      {
        h.baF();
        localObject1 = ((n)h.ax(n.class)).bzA().JE(localcc.field_talker);
        long l = ((az)localObject1).kay;
        ((au)localObject1).gQ(localcc.field_msgId);
        h.baF();
        ((n)h.ax(n.class)).bzA().aA((au)localObject1);
        if (l != 0L) {
          ((com.tencent.mm.plugin.messenger.foundation.a.w)h.ax(com.tencent.mm.plugin.messenger.foundation.a.w.class)).p(localcc.field_talker, l);
        }
      }
      oiJ.b(parama, localcc, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      i = 0;
      break;
      label669:
      localcc.pI(0);
      localcc.BS(str1);
      if (((dl)localObject1).vhk > 3)
      {
        i = ((dl)localObject1).vhk;
        break label190;
      }
      i = 3;
      break label190;
      label705:
      bool = false;
      break label224;
      label710:
      ((n)h.ax(n.class)).gaZ().b(((dl)localObject1).Njv, localcc);
      localb = new g.b(localcc, false);
      break label367;
      label750:
      str2 = str1;
      break label386;
      label757:
      localObject2 = localcc.field_content;
      i = br.JG(localcc.field_content);
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
  
  public void b(g.c paramc) {}
  
  public static final class a
    extends a<c>
    implements c
  {
    public final void a(final g.a parama, final cc paramcc, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42766);
      a(new a.a() {});
      AppMethodBeat.o(42766);
    }
    
    public final void b(final g.a parama, final cc paramcc, final String paramString1, final String paramString2, final boolean paramBoolean)
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