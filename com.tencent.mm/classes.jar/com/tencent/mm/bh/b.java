package com.tencent.mm.bh;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.fx;
import com.tencent.mm.h.a.fx.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;

public final class b
  extends e
{
  protected final bi a(cd paramcd, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = aa.a(paramcd.svH);
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      y.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
      return null;
    }
    paramString2 = bi.a.abZ(paramString2);
    if (((paramString2.uBW != null) || (paramString2.uBX != null)) && ((paramString2.scene == 10) || (paramString2.scene == 11)))
    {
      paramString3 = new fx();
      paramString3.bNc.bNe = paramString2.uBW;
      paramString3.bNc.bNf = paramString2.uBX;
      com.tencent.mm.sdk.b.a.udP.m(paramString3);
      if (paramString3.bNd.bNg)
      {
        y.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
        return null;
      }
    }
    if (paramString2.mXV > 0L) {
      com.tencent.mm.ag.b.c(paramString2.mXV, paramString2.uBV);
    }
    if (bk.pm(paramString2.pyp).length() > 0)
    {
      paramString3 = new h();
      paramString3.username = paramString2.pyp;
      paramString3.cCq = 3;
      paramString3.bK(true);
      paramString3.bcw = -1;
      paramString3.ebT = paramString2.uBY;
      paramString3.ebS = paramString2.uBZ;
      paramString3.bcw = -1;
      y.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { paramString2.pyp, paramString3.JX(), paramString3.JY() });
      o.Kh().a(paramString3);
    }
    paramString3 = new ax();
    paramString3.field_createTime = c.o(paramString1, paramcd.mPL);
    paramString3.field_isSend = 0;
    paramString3.field_msgContent = aa.a(paramcd.svH);
    paramString3.field_svrId = paramcd.ndp;
    paramString3.field_talker = paramString2.pyp;
    paramString3.field_type = 0;
    paramcd = d.RY().abR(paramString3.field_talker);
    if (paramcd != null)
    {
      y.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + paramString3.field_talker + " , real talker = " + paramcd.field_talker);
      paramString3.field_encryptTalker = paramString3.field_talker;
      paramString3.field_talker = paramcd.field_talker;
    }
    au.Hx();
    paramcd = com.tencent.mm.model.c.Fw().abl(paramString3.field_talker);
    if ((paramcd != null) && (com.tencent.mm.n.a.gR(paramcd.field_type)) && (paramcd.dBe > 0L))
    {
      y.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + paramString3.field_talker + " has already been in user's contact list");
      return null;
    }
    d.RX().b(paramString3);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bh.b
 * JD-Core Version:    0.7.0.1
 */