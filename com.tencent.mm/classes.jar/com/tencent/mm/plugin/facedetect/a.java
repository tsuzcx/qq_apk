package com.tencent.mm.plugin.facedetect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.g.b;

public final class a
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static m rnA;
  private static com.tencent.mm.plugin.facedetectaction.b.c rnB;
  private static k rnC;
  private static j rnx;
  private static com.tencent.mm.plugin.facedetect.model.o rny;
  private static i rnz;
  private b iVo = null;
  
  static
  {
    AppMethodBeat.i(103581);
    rnx = new j();
    rny = new com.tencent.mm.plugin.facedetect.model.o();
    rnz = new i();
    rnA = new m();
    rnB = new com.tencent.mm.plugin.facedetectaction.b.c();
    rnC = new k();
    AppMethodBeat.o(103581);
  }
  
  private static void gh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103575);
    com.tencent.mm.plugin.expansions.a.coe();
    String str1 = com.tencent.mm.vfs.o.aRh(paramString1);
    String str2 = com.tencent.mm.vfs.o.aRh("assets:///".concat(String.valueOf(paramString2)));
    ae.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str1)));
    ae.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(str2)));
    if ((str1 == null) || (str1.equals(str2)))
    {
      ae.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", new Object[] { paramString1 });
      AppMethodBeat.o(103575);
      return;
    }
    com.tencent.mm.vfs.o.deleteFile(paramString1);
    ae.i("MicroMsg.TaskInitFace", paramString1 + " md5 is wrong");
    p.i(ak.getContext(), paramString2, paramString1);
    AppMethodBeat.o(103575);
  }
  
  private static void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(103574);
    if (paramc == null)
    {
      ae.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      AppMethodBeat.o(103574);
      return;
    }
    if (com.tencent.mm.sdk.b.a.IvT.e(paramc))
    {
      ae.w("MicroMsg.TaskInitFace", "hy: already has listener");
      AppMethodBeat.o(103574);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.c(paramc);
    AppMethodBeat.o(103574);
  }
  
  private static void y(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103576);
    com.tencent.mm.plugin.expansions.a.coe();
    p.i(paramContext, paramString1, paramString2);
    AppMethodBeat.o(103576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.a
 * JD-Core Version:    0.7.0.1
 */