package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class b
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static j jMg = new j();
  private static n jMh = new n();
  private static i jMi = new i();
  private static l jMj = new l();
  private static com.tencent.mm.plugin.facedetectaction.b.c jMk = new com.tencent.mm.plugin.facedetectaction.b.c();
  private com.tencent.mm.vending.g.b eVG = null;
  
  private static void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    if (paramc == null)
    {
      y.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      return;
    }
    if (com.tencent.mm.sdk.b.a.udP.e(paramc))
    {
      y.w("MicroMsg.TaskInitFace", "hy: already has listener");
      return;
    }
    com.tencent.mm.sdk.b.a.udP.c(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b
 * JD-Core Version:    0.7.0.1
 */