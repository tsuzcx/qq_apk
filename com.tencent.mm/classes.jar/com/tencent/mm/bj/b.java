package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gp.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
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
    AppMethodBeat.i(231572);
    parama = parama.heO;
    paramString2 = z.a(parama.KHn);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      Log.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      AppMethodBeat.o(231572);
      return null;
    }
    paramString2 = ca.a.bkA(paramString2);
    if (((paramString2.OqK != null) || (paramString2.OqL != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new gp();
      paramString3.dKz.dKB = paramString2.OqK;
      paramString3.dKz.dKC = paramString2.OqL;
      EventCenter.instance.publish(paramString3);
      if (paramString3.dKA.dKD)
      {
        Log.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        AppMethodBeat.o(231572);
        return null;
      }
    }
    if (paramString2.Bge > 0L) {
      com.tencent.mm.aj.c.e(paramString2.Bge, paramString2.OqJ);
    }
    if (Util.nullAsNil(paramString2.dkU).length() > 0)
    {
      paramString3 = new i();
      paramString3.username = paramString2.dkU;
      paramString3.fuz = 3;
      paramString3.fv(true);
      paramString3.cSx = -1;
      paramString3.iKX = paramString2.OqM;
      paramString3.iKW = paramString2.OqN;
      paramString3.cSx = -1;
      Log.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.dkU, paramString3.aYt(), paramString3.aYu() });
      p.aYB().b(paramString3);
    }
    paramString3 = new bn();
    paramString3.field_createTime = c.C(paramString1, parama.CreateTime);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = z.a(parama.KHn);
    paramString3.field_svrId = parama.Brn;
    paramString3.field_talker = paramString2.dkU;
    paramString3.field_type = 0;
    parama = d.bgN().bkt(paramString3.field_talker);
    if (parama != null)
    {
      Log.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + parama.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = parama.field_talker;
    }
    bg.aVF();
    parama = com.tencent.mm.model.c.aSN().Kn(paramString3.field_talker);
    if ((parama != null) && (com.tencent.mm.contact.c.oR(parama.field_type)) && (parama.gMZ > 0L))
    {
      Log.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      AppMethodBeat.o(231572);
      return null;
    }
    d.bgM().b(paramString3);
    AppMethodBeat.o(231572);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bj.b
 * JD-Core Version:    0.7.0.1
 */