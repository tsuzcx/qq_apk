package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.h.b paramb, aop paramaop, aoq paramaoq)
  {
    if (paramaoq != null)
    {
      paramb.field_connProto = paramaoq.tks;
      paramb.field_connStrategy = paramaoq.tkt;
      paramb.field_closeStrategy = paramaoq.tku;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.j.b.BU(com.tencent.mm.plugin.exdevice.j.b.BV(paramaoq.sAE));
      paramb.field_authKey = paramaoq.syp;
      paramb.field_brandName = paramaoq.tkr;
      paramb.cZ(paramaoq.ffm);
      paramb.be(paramaoq.cMY);
      paramb.dX(paramaoq.tkA);
      paramb.dW(paramaoq.tkz);
      paramb.dV(paramaoq.tky);
      paramb.fH(paramaoq.tkB);
      paramb.setIconUrl(paramaoq.kSy);
      paramb.fI(paramaoq.cMX);
      paramb.dU(paramaoq.kRP);
      paramb.dY(paramaoq.cMZ);
      paramb.dZ(paramaoq.cNa);
      paramb.ea(paramaoq.cNb);
      paramb.eb(paramaoq.cNc);
    }
    if (paramaop != null)
    {
      paramb.field_deviceID = paramaop.hQb;
      paramb.field_deviceType = paramaop.syI;
      paramb.field_md5Str = g.o(new String(paramaop.syI + paramaop.hQb).getBytes());
      if (bk.bl(paramb.field_brandName)) {
        paramb.field_brandName = paramaop.syI;
      }
    }
  }
  
  public static boolean af(Context paramContext, String paramString)
  {
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    return true;
  }
  
  public static boolean b(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    return (paramb != null) && ((paramb.cMY & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */