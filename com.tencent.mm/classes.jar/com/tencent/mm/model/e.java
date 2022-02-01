package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.co.a.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;

public class e
  implements f
{
  private static final a gLO;
  
  static
  {
    AppMethodBeat.i(42771);
    gLO = new a((byte)0);
    AppMethodBeat.o(42771);
  }
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(42768);
    gLO.bv(parama);
    AppMethodBeat.o(42768);
  }
  
  protected bl a(cs paramcs, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(42770);
    if (paramString3.equals(paramString1)) {}
    for (paramString3 = paramString2;; paramString3 = paramString1)
    {
      bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(paramString3, paramcs.uKZ);
      ad.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(paramcs.uKZ), Long.valueOf(localbl.field_msgId), paramString1, paramString2, paramString3 });
      if ((localbl.field_msgId != 0L) && (localbl.field_createTime + 604800000L < bi.y(paramString3, paramcs.CreateTime)))
      {
        ad.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(paramcs.uKZ), Long.valueOf(localbl.field_msgId) });
        bi.lW(localbl.field_msgId);
        localbl.setMsgId(0L);
      }
      paramString1 = localbl;
      if (localbl.field_msgId == 0L)
      {
        paramString1 = new bl();
        paramString1.kX(paramcs.uKZ);
        paramString1.kY(bi.y(paramString3, paramcs.CreateTime));
        paramString1.setType(paramcs.saz);
        paramString1.setContent(bt.aGx(bt.nullAsNil(z.a(paramcs.Cxz))));
      }
      AppMethodBeat.o(42770);
      return paramString1;
    }
  }
  
  public f.b b(f.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.fTo;
    Object localObject2 = (String)g.afB().afk().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = z.a(((cs)localObject1).Cxx);
    String str3 = z.a(((cs)localObject1).Cxy);
    if ((bt.nullAsNil(str1).length() <= 0) || (bt.nullAsNil(str3).length() <= 0))
    {
      ad.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    bl localbl = a((cs)localObject1, str1, str3, (String)localObject2);
    if (localbl == null)
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
    if ((((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().has(str1)) || (((String)localObject2).equals(str1)))
    {
      bool = true;
      if (!bool) {
        break label687;
      }
      localbl.jV(1);
      localbl.nY(str3);
      i = ((cs)localObject1).mBi;
      localbl.setStatus(i);
      if (((cs)localObject1).saz == 10000) {
        localbl.setStatus(4);
      }
      localbl.mZ(((cs)localObject1).CxC);
      if (localbl.aIN(u.aqG()))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(localbl.field_talker);
        if (localObject2 != null)
        {
          ((am)localObject2).lv(16777216);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a((am)localObject2, localbl.field_talker);
        }
      }
      gLO.a(parama, localbl, str1, str3, bool);
      if (localbl.field_msgId != 0L) {
        break label723;
      }
      localbl.setFlag(2);
      bi.a(localbl, parama);
      localbl.setMsgId(bi.u(localbl));
      localb = new f.b(localbl, true);
      if (!bt.isNullOrNil(localbl.field_content))
      {
        if (!bool) {
          break label763;
        }
        str2 = str3;
        label368:
        if ((!parama.gVg) && (((i)g.ab(i.class)).adg(str2)))
        {
          if (!bool) {
            break label770;
          }
          localObject2 = localbl.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        ad.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, bt.by((String)localObject2, "null") });
      }
      ((i)g.ab(i.class)).a(str2, (String)localObject1, (String)localObject2, localbl.field_msgId, localbl.field_createTime / 1000L);
      if ((localbl.eMC()) && (w.sm(localbl.field_talker)) && (((r)g.ab(r.class)).UQ()))
      {
        g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localbl.field_talker);
        long l = ((au)localObject1).evV;
        ((af)localObject1).kR(localbl.field_msgId);
        g.afC();
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ae((af)localObject1);
        if (l != 0L)
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
          if (!bt.isNullOrNil(((du)localObject1).ePg)) {
            ((r)g.ab(r.class)).Z(localbl.field_talker, ((du)localObject1).ePg);
          }
        }
      }
      gLO.b(parama, localbl, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      bool = false;
      break;
      label687:
      localbl.jV(0);
      localbl.nY(str1);
      if (((cs)localObject1).mBi > 3)
      {
        i = ((cs)localObject1).mBi;
        break label183;
      }
      i = 3;
      break label183;
      label723:
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().b(((cs)localObject1).uKZ, localbl);
      localb = new f.b(localbl, false);
      break label349;
      label763:
      str2 = str1;
      break label368;
      label770:
      localObject2 = localbl.field_content;
      i = bi.uc(localbl.field_content);
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
    extends com.tencent.mm.co.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public final void a(final f.a parama, final bl parambl, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42766);
      a(new a.a() {});
      AppMethodBeat.o(42766);
    }
    
    public final void b(final f.a parama, final bl parambl, final String paramString1, final String paramString2, final boolean paramBoolean)
    {
      AppMethodBeat.i(42767);
      a(new a.a() {});
      AppMethodBeat.o(42767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.e
 * JD-Core Version:    0.7.0.1
 */