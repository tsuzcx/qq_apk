package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, cyx paramcyx, cyy paramcyy)
  {
    AppMethodBeat.i(23316);
    if (paramcyy != null)
    {
      paramb.field_connProto = paramcyy.aaDN;
      paramb.field_connStrategy = paramcyy.aaDO;
      paramb.field_closeStrategy = paramcyy.aaDP;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.apW(com.tencent.mm.plugin.exdevice.k.b.apY(paramcyy.YNe));
      paramb.field_authKey = paramcyy.YJq;
      paramb.field_brandName = paramcyy.aaDM;
      paramb.AV(paramcyy.pSk);
      paramb.gV(paramcyy.kDi);
      paramb.BM(paramcyy.aaDV);
      paramb.BL(paramcyy.aaDU);
      paramb.BK(paramcyy.aaDT);
      paramb.pT(paramcyy.aaDW);
      paramb.setIconUrl(paramcyy.IHo);
      paramb.pU(paramcyy.kDh);
      paramb.BJ(paramcyy.IGI);
      paramb.BN(paramcyy.kDj);
      paramb.BO(paramcyy.kDk);
      paramb.BP(paramcyy.kDl);
      paramb.BQ(paramcyy.kDm);
    }
    if (paramcyx != null)
    {
      paramb.field_deviceID = paramcyx.vgV;
      paramb.field_deviceType = paramcyx.YJY;
      paramb.field_md5Str = g.getMessageDigest(new String(paramcyx.YJY + paramcyx.vgV).getBytes());
      if (Util.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = paramcyx.YJY;
      }
    }
    AppMethodBeat.o(23316);
  }
  
  public static boolean az(Context paramContext, String paramString)
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
  
  public static boolean c(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    return (paramb != null) && ((paramb.kDi & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */