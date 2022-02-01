package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.protocal.protobuf.cpt;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<no name provided>", "", "vid", "", "url"}, k=3, mv={1, 5, 1}, xi=48)
final class MPVideoPreviewMgr$b
  extends u
  implements m<String, String, ah>
{
  public static final b vXV;
  
  static
  {
    AppMethodBeat.i(302068);
    vXV = new b();
    AppMethodBeat.o(302068);
  }
  
  MPVideoPreviewMgr$b()
  {
    super(2);
  }
  
  private static final void a(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(302055);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(302055);
      return;
    }
    paramString = c.b.b(paramc.otB);
    if ((paramString instanceof cpt))
    {
      paramString = (cpt)paramString;
      paramc = c.c.b(paramc.otC);
      if (!(paramc instanceof cpu)) {
        break label78;
      }
    }
    label78:
    for (paramc = (cpu)paramc;; paramc = null)
    {
      if ((paramString != null) && (paramc != null)) {
        break label83;
      }
      AppMethodBeat.o(302055);
      return;
      paramString = null;
      break;
    }
    label83:
    if (paramc.block == 1)
    {
      Log.i("MicroMsg.MPVideoPreviewMgr", "cgiPlayUrl block");
      AppMethodBeat.o(302055);
      return;
    }
    MPVideoPreviewMgr.dhM().remove(paramString.vid);
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.gb(paramString.vid, paramc.OQR);
    AppMethodBeat.o(302055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.b
 * JD-Core Version:    0.7.0.1
 */