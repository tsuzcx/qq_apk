package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.ga.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;

public final class b
  extends e
{
  public final bi a(cm paramcm, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(16617);
    paramString2 = aa.a(paramcm.woR);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      ab.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(16617);
      return null;
    }
    paramString2 = bi.a.asj(paramString2);
    if (((paramString2.yOi != null) || (paramString2.yOj != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new ga();
      paramString3.cuu.cuw = paramString2.yOi;
      paramString3.cuu.cux = paramString2.yOj;
      com.tencent.mm.sdk.b.a.ymk.l(paramString3);
      if (paramString3.cuv.cuy)
      {
        ab.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(16617);
        return null;
      }
    }
    if (paramString2.pAI > 0L) {
      com.tencent.mm.ah.b.d(paramString2.pAI, paramString2.yOh);
    }
    if (bo.nullAsNil(paramString2.tac).length() > 0)
    {
      paramString3 = new h();
      paramString3.username = paramString2.tac;
      paramString3.dqB = 3;
      paramString3.cM(true);
      paramString3.bsY = -1;
      paramString3.fsl = paramString2.yOk;
      paramString3.fsk = paramString2.yOl;
      paramString3.bsY = -1;
      ab.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.tac, paramString3.acX(), paramString3.acY() });
      o.adg().b(paramString3);
    }
    paramString3 = new ax();
    paramString3.field_createTime = c.x(paramString1, paramcm.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = aa.a(paramcm.woR);
    paramString3.field_svrId = paramcm.pIG;
    paramString3.field_talker = paramString2.tac;
    paramString3.field_type = 0;
    paramcm = d.ali().asb(paramString3.field_talker);
    if (paramcm != null)
    {
      ab.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + paramcm.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = paramcm.field_talker;
    }
    com.tencent.mm.model.aw.aaz();
    paramcm = com.tencent.mm.model.c.YA().arw(paramString3.field_talker);
    if ((paramcm != null) && (com.tencent.mm.n.a.je(paramcm.field_type)) && (paramcm.euF > 0L))
    {
      ab.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(16617);
      return null;
    }
    d.alh().b(paramString3);
    AppMethodBeat.o(16617);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bi.b
 * JD-Core Version:    0.7.0.1
 */