package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.b.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, bjb parambjb, bjc parambjc)
  {
    AppMethodBeat.i(23316);
    if (parambjc != null)
    {
      paramb.field_connProto = parambjc.EYa;
      paramb.field_connStrategy = parambjc.EYb;
      paramb.field_closeStrategy = parambjc.EYc;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.Zs(com.tencent.mm.plugin.exdevice.k.b.Zt(parambjc.DXq));
      paramb.field_authKey = parambjc.DTH;
      paramb.field_brandName = parambjc.EXZ;
      paramb.qg(parambjc.iJY);
      paramb.oy(parambjc.eNk);
      paramb.qZ(parambjc.EYi);
      paramb.qY(parambjc.EYh);
      paramb.qX(parambjc.EYg);
      paramb.kb(parambjc.EYj);
      paramb.qV(parambjc.IconUrl);
      paramb.kc(parambjc.eNj);
      paramb.qW(parambjc.thh);
      paramb.ra(parambjc.eNl);
      paramb.rb(parambjc.eNm);
      paramb.rc(parambjc.eNn);
      paramb.rd(parambjc.eNo);
    }
    if (parambjb != null)
    {
      paramb.field_deviceID = parambjb.ncU;
      paramb.field_deviceType = parambjb.DUp;
      paramb.field_md5Str = g.getMessageDigest(new String(parambjb.DUp + parambjb.ncU).getBytes());
      if (bs.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = parambjb.DUp;
      }
    }
    AppMethodBeat.o(23316);
  }
  
  public static boolean ao(Context paramContext, String paramString)
  {
    AppMethodBeat.i(23315);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
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
    return (paramb != null) && ((paramb.eNk & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */