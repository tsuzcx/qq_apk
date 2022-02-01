package com.tencent.mm.plugin.facedetect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.g.b;

public final class a
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static j qvE;
  private static o qvF;
  private static com.tencent.mm.plugin.facedetect.model.i qvG;
  private static m qvH;
  private static com.tencent.mm.plugin.facedetectaction.b.c qvI;
  private static k qvJ;
  private b izm = null;
  
  static
  {
    AppMethodBeat.i(103581);
    qvE = new j();
    qvF = new o();
    qvG = new com.tencent.mm.plugin.facedetect.model.i();
    qvH = new m();
    qvI = new com.tencent.mm.plugin.facedetectaction.b.c();
    qvJ = new k();
    AppMethodBeat.o(103581);
  }
  
  private static void fT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103575);
    com.tencent.mm.plugin.expansions.a.cik();
    String str1 = com.tencent.mm.vfs.i.aKe(paramString1);
    String str2 = com.tencent.mm.vfs.i.aKe("assets:///".concat(String.valueOf(paramString2)));
    ac.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str1)));
    ac.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(str2)));
    if ((str1 == null) || (str1.equals(str2)))
    {
      ac.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", new Object[] { paramString1 });
      AppMethodBeat.o(103575);
      return;
    }
    com.tencent.mm.vfs.i.deleteFile(paramString1);
    ac.i("MicroMsg.TaskInitFace", paramString1 + " md5 is wrong");
    p.i(ai.getContext(), paramString2, paramString1);
    AppMethodBeat.o(103575);
  }
  
  private static void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(103574);
    if (paramc == null)
    {
      ac.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      AppMethodBeat.o(103574);
      return;
    }
    if (com.tencent.mm.sdk.b.a.GpY.e(paramc))
    {
      ac.w("MicroMsg.TaskInitFace", "hy: already has listener");
      AppMethodBeat.o(103574);
      return;
    }
    com.tencent.mm.sdk.b.a.GpY.c(paramc);
    AppMethodBeat.o(103574);
  }
  
  private static void x(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103576);
    com.tencent.mm.plugin.expansions.a.cik();
    p.i(paramContext, paramString1, paramString2);
    AppMethodBeat.o(103576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.a
 * JD-Core Version:    0.7.0.1
 */