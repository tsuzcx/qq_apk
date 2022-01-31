package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(52);
    String str1 = p.buH();
    String str2 = p.buI();
    String str3 = p.buJ();
    boolean bool1 = com.tencent.mm.pluginsdk.g.a.d.a.cN(str1);
    boolean bool2 = com.tencent.mm.pluginsdk.g.a.d.a.cN(str2);
    boolean bool3 = com.tencent.mm.pluginsdk.g.a.d.a.cN(str3);
    ab.i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b, postDetectModel: %s, exist: %s", new Object[] { str1, Boolean.valueOf(bool1), str2, Boolean.valueOf(bool2), str3, Boolean.valueOf(bool3) });
    if (!bool1)
    {
      ab.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
      p.p(ah.getContext(), "face_detect" + File.separator + "ufdmtcc.bin", str1);
      if (bool2) {
        break label249;
      }
      ab.i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
      p.p(ah.getContext(), "face_detect" + File.separator + "ufat.bin", str2);
    }
    for (;;)
    {
      if (bool3) {
        break label280;
      }
      ab.i("MicroMsg.TaskInitFace", "copy post detect model file");
      p.p(ah.getContext(), "face_detect" + File.separator + "PE.dat", str3);
      AppMethodBeat.o(52);
      return;
      a.em(str1, "face_detect" + File.separator + "ufdmtcc.bin");
      break;
      label249:
      a.em(str2, "face_detect" + File.separator + "ufat.bin");
    }
    label280:
    a.em(str3, "face_detect" + File.separator + "PE.dat");
    AppMethodBeat.o(52);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.a.1
 * JD-Core Version:    0.7.0.1
 */