package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.di;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, bnj parambnj, bnk parambnk)
  {
    AppMethodBeat.i(23316);
    if (parambnk != null)
    {
      paramb.field_connProto = parambnk.GHw;
      paramb.field_connStrategy = parambnk.GHx;
      paramb.field_closeStrategy = parambnk.GHy;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.acY(com.tencent.mm.plugin.exdevice.k.b.acZ(parambnk.FCM));
      paramb.field_authKey = parambnk.Fzb;
      paramb.field_brandName = parambnk.GHv;
      paramb.sQ(parambnk.jdh);
      paramb.qy(parambnk.ffG);
      paramb.tI(parambnk.GHE);
      paramb.tH(parambnk.GHD);
      paramb.tG(parambnk.GHC);
      paramb.kz(parambnk.GHF);
      paramb.setIconUrl(parambnk.IconUrl);
      paramb.kA(parambnk.ffF);
      paramb.tF(parambnk.ueY);
      paramb.tJ(parambnk.ffH);
      paramb.tK(parambnk.ffI);
      paramb.tL(parambnk.ffJ);
      paramb.tM(parambnk.ffK);
    }
    if (parambnj != null)
    {
      paramb.field_deviceID = parambnj.nDr;
      paramb.field_deviceType = parambnj.FzJ;
      paramb.field_md5Str = g.getMessageDigest(new String(parambnj.FzJ + parambnj.nDr).getBytes());
      if (bt.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = parambnj.FzJ;
      }
    }
    AppMethodBeat.o(23316);
  }
  
  public static boolean an(Context paramContext, String paramString)
  {
    AppMethodBeat.i(23315);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
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
    return (paramb != null) && ((paramb.ffG & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */