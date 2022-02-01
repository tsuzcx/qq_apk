package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.gm.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;

public final class b
  extends e
{
  public final bv a(e.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(186387);
    parama = parama.gte;
    paramString2 = z.a(parama.FNI);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      ae.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(186387);
      return null;
    }
    paramString2 = bv.a.aVC(paramString2);
    if (((paramString2.JgT != null) || (paramString2.JgU != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new gm();
      paramString3.dtp.dtr = paramString2.JgT;
      paramString3.dtp.dtt = paramString2.JgU;
      a.IvT.l(paramString3);
      if (paramString3.dtq.dtu)
      {
        ae.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(186387);
        return null;
      }
    }
    if (paramString2.xik > 0L) {
      com.tencent.mm.aj.c.e(paramString2.xik, paramString2.JgS);
    }
    if (bu.nullAsNil(paramString2.cUA).length() > 0)
    {
      paramString3 = new i();
      paramString3.username = paramString2.cUA;
      paramString3.eQU = 3;
      paramString3.eD(true);
      paramString3.dEu = -1;
      paramString3.hPQ = paramString2.JgV;
      paramString3.hPP = paramString2.JgW;
      paramString3.dEu = -1;
      ae.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.cUA, paramString3.aEG(), paramString3.aEH() });
      p.aEN().b(paramString3);
    }
    paramString3 = new bi();
    paramString3.field_createTime = c.B(paramString1, parama.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = z.a(parama.FNI);
    paramString3.field_svrId = parama.xrk;
    paramString3.field_talker = paramString2.cUA;
    paramString3.field_type = 0;
    parama = d.aMM().aVv(paramString3.field_talker);
    if (parama != null)
    {
      ae.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + parama.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = parama.field_talker;
    }
    bc.aCg();
    parama = com.tencent.mm.model.c.azF().BH(paramString3.field_talker);
    if ((parama != null) && (com.tencent.mm.contact.c.lO(parama.field_type)) && (parama.ght > 0L))
    {
      ae.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(186387);
      return null;
    }
    d.aML().b(paramString3);
    AppMethodBeat.o(186387);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.b
 * JD-Core Version:    0.7.0.1
 */