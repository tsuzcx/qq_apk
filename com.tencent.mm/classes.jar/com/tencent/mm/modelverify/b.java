package com.tencent.mm.modelverify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.a.hh;
import com.tencent.mm.autogen.a.hh.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.e;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;

public final class b
  extends e
{
  public final cc a(g.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(231184);
    parama = parama.mpN;
    paramString2 = w.a(parama.YFG);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      Log.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(231184);
      return null;
    }
    paramString2 = cc.a.bys(paramString2);
    if (((paramString2.adkz != null) || (paramString2.adkA != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new hh();
      paramString3.hIe.hIg = paramString2.adkz;
      paramString3.hIe.hIh = paramString2.adkA;
      paramString3.publish();
      if (paramString3.hIf.hIi)
      {
        Log.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(231184);
        return null;
      }
    }
    if (paramString2.MXS > 0L) {
      com.tencent.mm.modelavatar.d.n(paramString2.MXS, paramString2.adky);
    }
    if (Util.nullAsNil(paramString2.hgk).length() > 0)
    {
      paramString3 = new j();
      paramString3.username = paramString2.hgk;
      paramString3.jZY = 3;
      paramString3.gX(true);
      paramString3.eQp = -1;
      paramString3.osN = paramString2.adkB;
      paramString3.osM = paramString2.adkC;
      paramString3.eQp = -1;
      Log.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.hgk, paramString3.bFw(), paramString3.bFx() });
      q.bFE().b(paramString3);
    }
    paramString3 = new bp();
    paramString3.field_createTime = c.D(paramString1, parama.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = w.a(parama.YFG);
    paramString3.field_svrId = parama.Njv;
    paramString3.field_talker = paramString2.hgk;
    paramString3.field_type = 0;
    parama = d.bNI().byl(paramString3.field_talker);
    if (parama != null)
    {
      Log.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + parama.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = parama.field_talker;
    }
    bh.bCz();
    parama = com.tencent.mm.model.c.bzA().JE(paramString3.field_talker);
    if ((parama != null) && (com.tencent.mm.contact.d.rs(parama.field_type)) && (parama.maN > 0L))
    {
      Log.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(231184);
      return null;
    }
    d.bNH().b(paramString3);
    AppMethodBeat.o(231184);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelverify.b
 * JD-Core Version:    0.7.0.1
 */