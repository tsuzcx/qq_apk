package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ds;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, ciu paramciu, civ paramciv)
  {
    AppMethodBeat.i(23316);
    if (paramciv != null)
    {
      paramb.field_connProto = paramciv.TpL;
      paramb.field_connStrategy = paramciv.TpM;
      paramb.field_closeStrategy = paramciv.TpN;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.avW(com.tencent.mm.plugin.exdevice.k.b.avX(paramciv.RPQ));
      paramb.field_authKey = paramciv.RMc;
      paramb.field_brandName = paramciv.TpK;
      paramb.Iq(paramciv.mVD);
      paramb.EF(paramciv.idY);
      paramb.Jh(paramciv.TpT);
      paramb.Jg(paramciv.TpS);
      paramb.Jf(paramciv.TpR);
      paramb.pT(paramciv.TpU);
      paramb.setIconUrl(paramciv.CNj);
      paramb.pU(paramciv.idX);
      paramb.Je(paramciv.CMD);
      paramb.Ji(paramciv.idZ);
      paramb.Jj(paramciv.iea);
      paramb.Jk(paramciv.ieb);
      paramb.Jl(paramciv.iec);
    }
    if (paramciu != null)
    {
      paramb.field_deviceID = paramciu.rVF;
      paramb.field_deviceType = paramciu.RMK;
      paramb.field_md5Str = g.getMessageDigest(new String(paramciu.RMK + paramciu.rVF).getBytes());
      if (Util.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = paramciu.RMK;
      }
    }
    AppMethodBeat.o(23316);
  }
  
  public static boolean ay(Context paramContext, String paramString)
  {
    AppMethodBeat.i(23315);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
      AppMethodBeat.o(23315);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(23315);
    return true;
  }
  
  public static boolean b(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    return (paramb != null) && ((paramb.idY & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */