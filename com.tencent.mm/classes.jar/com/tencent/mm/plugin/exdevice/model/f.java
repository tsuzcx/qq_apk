package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.h.b paramb, auh paramauh, aui paramaui)
  {
    AppMethodBeat.i(19248);
    if (paramaui != null)
    {
      paramb.field_connProto = paramaui.xjj;
      paramb.field_connStrategy = paramaui.xjk;
      paramb.field_closeStrategy = paramaui.xjl;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.j.b.LX(com.tencent.mm.plugin.exdevice.j.b.LY(paramaui.wuT));
      paramb.field_authKey = paramaui.wrS;
      paramb.field_brandName = paramaui.xji;
      paramb.jm(paramaui.gwU);
      paramb.fO(paramaui.dCO);
      paramb.ke(paramaui.xjr);
      paramb.kd(paramaui.xjq);
      paramb.kc(paramaui.xjp);
      paramb.hS(paramaui.xjs);
      paramb.ka(paramaui.IconUrl);
      paramb.hT(paramaui.dCN);
      paramb.kb(paramaui.npR);
      paramb.kf(paramaui.dCP);
      paramb.kg(paramaui.dCQ);
      paramb.kh(paramaui.dCR);
      paramb.ki(paramaui.dCS);
    }
    if (paramauh != null)
    {
      paramb.field_deviceID = paramauh.jJD;
      paramb.field_deviceType = paramauh.wsq;
      paramb.field_md5Str = g.w(new String(paramauh.wsq + paramauh.jJD).getBytes());
      if (bo.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = paramauh.wsq;
      }
    }
    AppMethodBeat.o(19248);
  }
  
  public static boolean an(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19247);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
      AppMethodBeat.o(19247);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(19247);
    return true;
  }
  
  public static boolean b(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    return (paramb != null) && ((paramb.dCO & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */