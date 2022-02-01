package com.tencent.mm.bk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gh.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;

public final class b
  extends e
{
  public final bl a(cs paramcs, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20661);
    paramString2 = z.a(paramcs.Cxz);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      ad.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(20661);
      return null;
    }
    paramString2 = bl.a.aIO(paramString2);
    if (((paramString2.FzV != null) || (paramString2.FzW != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new gh();
      paramString3.djr.djt = paramString2.FzV;
      paramString3.djr.dju = paramString2.FzW;
      a.ESL.l(paramString3);
      if (paramString3.djs.djv)
      {
        ad.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(20661);
        return null;
      }
    }
    if (paramString2.uCr > 0L) {
      com.tencent.mm.ak.c.e(paramString2.uCr, paramString2.FzU);
    }
    if (bt.nullAsNil(paramString2.yGA).length() > 0)
    {
      paramString3 = new i();
      paramString3.username = paramString2.yGA;
      paramString3.evo = 3;
      paramString3.ee(true);
      paramString3.dtM = -1;
      paramString3.gUg = paramString2.FzX;
      paramString3.gUf = paramString2.FzY;
      paramString3.dtM = -1;
      ad.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.yGA, paramString3.aux(), paramString3.auy() });
      p.auF().b(paramString3);
    }
    paramString3 = new ba();
    paramString3.field_createTime = c.y(paramString1, paramcs.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = z.a(paramcs.Cxz);
    paramString3.field_svrId = paramcs.uKZ;
    paramString3.field_talker = paramString2.yGA;
    paramString3.field_type = 0;
    paramcs = d.aCo().aIH(paramString3.field_talker);
    if (paramcs != null)
    {
      ad.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + paramcs.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = paramcs.field_talker;
    }
    com.tencent.mm.model.az.arV();
    paramcs = com.tencent.mm.model.c.apM().aHY(paramString3.field_talker);
    if ((paramcs != null) && (com.tencent.mm.n.b.ls(paramcs.field_type)) && (paramcs.fId > 0L))
    {
      ad.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(20661);
      return null;
    }
    d.aCn().b(paramString3);
    AppMethodBeat.o(20661);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bk.b
 * JD-Core Version:    0.7.0.1
 */