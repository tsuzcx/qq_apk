package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;

public final class b
  extends e
{
  public final bo a(cu paramcu, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20661);
    paramString2 = z.a(paramcu.DPV);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      ac.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(20661);
      return null;
    }
    paramString2 = bo.a.aOk(paramString2);
    if (((paramString2.GYX != null) || (paramString2.GYY != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new gi();
      paramString3.dgM.dgO = paramString2.GYX;
      paramString3.dgM.dgP = paramString2.GYY;
      a.GpY.l(paramString3);
      if (paramString3.dgN.dgQ)
      {
        ac.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(20661);
        return null;
      }
    }
    if (paramString2.vLk > 0L) {
      com.tencent.mm.aj.c.e(paramString2.vLk, paramString2.GYW);
    }
    if (bs.nullAsNil(paramString2.zTO).length() > 0)
    {
      paramString3 = new i();
      paramString3.username = paramString2.zTO;
      paramString3.exK = 3;
      paramString3.ez(true);
      paramString3.drx = -1;
      paramString3.huF = paramString2.GYZ;
      paramString3.huE = paramString2.GZa;
      paramString3.drx = -1;
      ac.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.zTO, paramString3.aBo(), paramString3.aBp() });
      p.aBw().b(paramString3);
    }
    paramString3 = new bd();
    paramString3.field_createTime = c.z(paramString1, paramcu.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = z.a(paramcu.DPV);
    paramString3.field_svrId = paramcu.vTQ;
    paramString3.field_talker = paramString2.zTO;
    paramString3.field_type = 0;
    paramcu = d.aJe().aOd(paramString3.field_talker);
    if (paramcu != null)
    {
      ac.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + paramcu.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = paramcu.field_talker;
    }
    az.ayM();
    paramcu = com.tencent.mm.model.c.awB().aNt(paramString3.field_talker);
    if ((paramcu != null) && (com.tencent.mm.n.b.ln(paramcu.field_type)) && (paramcu.fLJ > 0L))
    {
      ac.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(20661);
      return null;
    }
    d.aJd().b(paramString3);
    AppMethodBeat.o(20661);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.b
 * JD-Core Version:    0.7.0.1
 */