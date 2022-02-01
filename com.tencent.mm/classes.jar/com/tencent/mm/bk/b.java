package com.tencent.mm.bk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;

public final class b
  extends e
{
  public final bu a(e.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(193138);
    parama = parama.gqE;
    paramString2 = z.a(parama.Fvk);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      ad.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(193138);
      return null;
    }
    paramString2 = bu.a.aUb(paramString2);
    if (((paramString2.IMm != null) || (paramString2.IMn != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new gl();
      paramString3.dsj.dsl = paramString2.IMm;
      paramString3.dsj.dsm = paramString2.IMn;
      a.IbL.l(paramString3);
      if (paramString3.dsk.dsn)
      {
        ad.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(193138);
        return null;
      }
    }
    if (paramString2.wSt > 0L) {
      com.tencent.mm.ak.c.e(paramString2.wSt, paramString2.IMl);
    }
    if (bt.nullAsNil(paramString2.dHm).length() > 0)
    {
      paramString3 = new i();
      paramString3.username = paramString2.dHm;
      paramString3.ePj = 3;
      paramString3.eB(true);
      paramString3.dDp = -1;
      paramString3.hMX = paramString2.IMo;
      paramString3.hMW = paramString2.IMp;
      paramString3.dDp = -1;
      ad.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.dHm, paramString3.aEq(), paramString3.aEr() });
      p.aEx().b(paramString3);
    }
    paramString3 = new bh();
    paramString3.field_createTime = c.B(paramString1, parama.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = z.a(parama.Fvk);
    paramString3.field_svrId = parama.xbt;
    paramString3.field_talker = paramString2.dHm;
    paramString3.field_type = 0;
    parama = d.aMo().aTU(paramString3.field_talker);
    if (parama != null)
    {
      ad.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + parama.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = parama.field_talker;
    }
    ba.aBQ();
    parama = com.tencent.mm.model.c.azp().Bf(paramString3.field_talker);
    if ((parama != null) && (com.tencent.mm.o.b.lM(parama.field_type)) && (parama.gfj > 0L))
    {
      ad.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(193138);
      return null;
    }
    d.aMn().b(paramString3);
    AppMethodBeat.o(193138);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bk.b
 * JD-Core Version:    0.7.0.1
 */