package com.tencent.mm.bl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.a.gw;
import com.tencent.mm.f.a.gw.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;

public final class b
  extends e
{
  public final ca a(h.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(279492);
    parama = parama.jQG;
    paramString2 = z.a(parama.RIF);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      Log.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(279492);
      return null;
    }
    paramString2 = ca.a.bwZ(paramString2);
    if (((paramString2.VGG != null) || (paramString2.VGH != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new gw();
      paramString3.fDo.fDq = paramString2.VGG;
      paramString3.fDo.fDr = paramString2.VGH;
      EventCenter.instance.publish(paramString3);
      if (paramString3.fDp.fDs)
      {
        Log.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(279492);
        return null;
      }
    }
    if (paramString2.GZN > 0L) {
      com.tencent.mm.am.d.f(paramString2.GZN, paramString2.VGF);
    }
    if (Util.nullAsNil(paramString2.fcC).length() > 0)
    {
      paramString3 = new j();
      paramString3.username = paramString2.fcC;
      paramString3.hDc = 3;
      paramString3.gg(true);
      paramString3.cUP = -1;
      paramString3.lBe = paramString2.VGI;
      paramString3.lBd = paramString2.VGJ;
      paramString3.cUP = -1;
      Log.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.fcC, paramString3.bhH(), paramString3.bhI() });
      q.bhP().b(paramString3);
    }
    paramString3 = new bn();
    paramString3.field_createTime = c.z(paramString1, parama.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = z.a(parama.RIF);
    paramString3.field_svrId = parama.HlH;
    paramString3.field_talker = paramString2.fcC;
    paramString3.field_type = 0;
    parama = d.bqc().bwS(paramString3.field_talker);
    if (parama != null)
    {
      Log.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + parama.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = parama.field_talker;
    }
    bh.beI();
    parama = com.tencent.mm.model.c.bbL().RG(paramString3.field_talker);
    if ((parama != null) && (com.tencent.mm.contact.d.rk(parama.field_type)) && (parama.jxt > 0L))
    {
      Log.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(279492);
      return null;
    }
    d.bqb().b(paramString3);
    AppMethodBeat.o(279492);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bl.b
 * JD-Core Version:    0.7.0.1
 */