package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  public static void a(com.tencent.mm.plugin.exdevice.i.b paramb, bfj parambfj, bfk parambfk)
  {
    AppMethodBeat.i(23316);
    if (parambfk != null)
    {
      paramb.field_connProto = parambfk.DCE;
      paramb.field_connStrategy = parambfk.DCF;
      paramb.field_closeStrategy = parambfk.DCG;
      paramb.field_mac = com.tencent.mm.plugin.exdevice.k.b.Vg(com.tencent.mm.plugin.exdevice.k.b.Vh(parambfk.CEQ));
      paramb.field_authKey = parambfk.CBj;
      paramb.field_brandName = parambfk.DCD;
      paramb.na(parambfk.ijR);
      paramb.kW(parambfk.eKs);
      paramb.nT(parambfk.DCM);
      paramb.nS(parambfk.DCL);
      paramb.nR(parambfk.DCK);
      paramb.kd(parambfk.DCN);
      paramb.nP(parambfk.IconUrl);
      paramb.ke(parambfk.eKr);
      paramb.nQ(parambfk.rZo);
      paramb.nU(parambfk.eKt);
      paramb.nV(parambfk.eKu);
      paramb.nW(parambfk.eKv);
      paramb.nX(parambfk.eKw);
    }
    if (parambfj != null)
    {
      paramb.field_deviceID = parambfj.mAT;
      paramb.field_deviceType = parambfj.CBS;
      paramb.field_md5Str = g.getMessageDigest(new String(parambfj.CBS + parambfj.mAT).getBytes());
      if (bt.isNullOrNil(paramb.field_brandName)) {
        paramb.field_brandName = parambfj.CBS;
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
    return (paramb != null) && ((paramb.eKs & 1L) == 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f
 * JD-Core Version:    0.7.0.1
 */