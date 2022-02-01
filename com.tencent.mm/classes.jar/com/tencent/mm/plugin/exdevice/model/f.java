package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.do;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, cat paramcat, cau paramcau)
  {
    AppMethodBeat.i(23316);
    if (paramcau != null)
    {
      paramb.field_connProto = paramcau.MfZ;
      paramb.field_connStrategy = paramcau.Mga;
      paramb.field_closeStrategy = paramcau.Mgb;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.anY(com.tencent.mm.plugin.exdevice.k.b.anZ(paramcau.KOS));
      paramb.field_authKey = paramcau.KLg;
      paramb.field_brandName = paramcau.MfY;
      paramb.BC(paramcau.ked);
      paramb.yE(paramcau.fMg);
      paramb.Ct(paramcau.Mgh);
      paramb.Cs(paramcau.Mgg);
      paramb.Cr(paramcau.Mgf);
      paramb.nE(paramcau.Mgi);
      paramb.setIconUrl(paramcau.IconUrl);
      paramb.nF(paramcau.fMf);
      paramb.Cq(paramcau.xIy);
      paramb.Cu(paramcau.fMh);
      paramb.Cv(paramcau.fMi);
      paramb.Cw(paramcau.fMj);
      paramb.Cx(paramcau.fMk);
    }
    if (paramcat != null)
    {
      paramb.field_deviceID = paramcat.oTH;
      paramb.field_deviceType = paramcat.KLO;
      paramb.field_md5Str = g.getMessageDigest(new String(paramcat.KLO + paramcat.oTH).getBytes());
      if (Util.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = paramcat.KLO;
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
    return (paramb != null) && ((paramb.fMg & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */