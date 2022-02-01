package com.tencent.mm.plugin.facedetect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.g.b;

public final class a
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static j rfu;
  private static o rfv;
  private static com.tencent.mm.plugin.facedetect.model.i rfw;
  private static m rfx;
  private static com.tencent.mm.plugin.facedetectaction.b.c rfy;
  private static k rfz;
  private b iSv = null;
  
  static
  {
    AppMethodBeat.i(103581);
    rfu = new j();
    rfv = new o();
    rfw = new com.tencent.mm.plugin.facedetect.model.i();
    rfx = new m();
    rfy = new com.tencent.mm.plugin.facedetectaction.b.c();
    rfz = new k();
    AppMethodBeat.o(103581);
  }
  
  private static void gc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103575);
    com.tencent.mm.plugin.expansions.a.cmO();
    String str1 = com.tencent.mm.vfs.i.aPK(paramString1);
    String str2 = com.tencent.mm.vfs.i.aPK("assets:///".concat(String.valueOf(paramString2)));
    ad.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str1)));
    ad.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(str2)));
    if ((str1 == null) || (str1.equals(str2)))
    {
      ad.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", new Object[] { paramString1 });
      AppMethodBeat.o(103575);
      return;
    }
    com.tencent.mm.vfs.i.deleteFile(paramString1);
    ad.i("MicroMsg.TaskInitFace", paramString1 + " md5 is wrong");
    p.i(aj.getContext(), paramString2, paramString1);
    AppMethodBeat.o(103575);
  }
  
  private static void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(103574);
    if (paramc == null)
    {
      ad.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      AppMethodBeat.o(103574);
      return;
    }
    if (com.tencent.mm.sdk.b.a.IbL.e(paramc))
    {
      ad.w("MicroMsg.TaskInitFace", "hy: already has listener");
      AppMethodBeat.o(103574);
      return;
    }
    com.tencent.mm.sdk.b.a.IbL.c(paramc);
    AppMethodBeat.o(103574);
  }
  
  private static void y(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103576);
    com.tencent.mm.plugin.expansions.a.cmO();
    p.i(paramContext, paramString1, paramString2);
    AppMethodBeat.o(103576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.a
 * JD-Core Version:    0.7.0.1
 */