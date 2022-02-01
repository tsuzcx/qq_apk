package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.di;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, bob parambob, boc paramboc)
  {
    AppMethodBeat.i(23316);
    if (paramboc != null)
    {
      paramb.field_connProto = paramboc.HaY;
      paramb.field_connStrategy = paramboc.HaZ;
      paramb.field_closeStrategy = paramboc.Hba;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.adP(com.tencent.mm.plugin.exdevice.k.b.adQ(paramboc.FVh));
      paramb.field_authKey = paramboc.FRz;
      paramb.field_brandName = paramboc.HaX;
      paramb.tl(paramboc.jga);
      paramb.qL(paramboc.fhD);
      paramb.ud(paramboc.Hbg);
      paramb.uc(paramboc.Hbf);
      paramb.ub(paramboc.Hbe);
      paramb.kB(paramboc.Hbh);
      paramb.setIconUrl(paramboc.IconUrl);
      paramb.kC(paramboc.fhC);
      paramb.ua(paramboc.uqf);
      paramb.ue(paramboc.fhE);
      paramb.uf(paramboc.fhF);
      paramb.ug(paramboc.fhG);
      paramb.uh(paramboc.fhH);
    }
    if (parambob != null)
    {
      paramb.field_deviceID = parambob.nIM;
      paramb.field_deviceType = parambob.FSh;
      paramb.field_md5Str = g.getMessageDigest(new String(parambob.FSh + parambob.nIM).getBytes());
      if (bu.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = parambob.FSh;
      }
    }
    AppMethodBeat.o(23316);
  }
  
  public static boolean ap(Context paramContext, String paramString)
  {
    AppMethodBeat.i(23315);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
      AppMethodBeat.o(23315);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(23315);
    return true;
  }
  
  public static boolean b(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    return (paramb != null) && ((paramb.fhD & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */