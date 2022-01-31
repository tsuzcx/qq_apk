package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class f$2
  extends ak
{
  f$2(f paramf) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(116694);
    if (paramMessage.what == 2)
    {
      if (this.gbz.gbv != null)
      {
        this.gbz.gbv.amK();
        AppMethodBeat.o(116694);
      }
    }
    else
    {
      if (paramMessage.what == 0)
      {
        if (f.b(this.gbz) == 0)
        {
          ab.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
          g.Rc().a(349, this.gbz);
          if (f.b(this.gbz) != 0) {
            break label184;
          }
          if (f.c(this.gbz)) {
            break label158;
          }
          f.a(this.gbz, new e(f.d(this.gbz), 0));
        }
        for (;;)
        {
          g.Rc().a(f.e(this.gbz), 0);
          AppMethodBeat.o(116694);
          return;
          g.Rc().a(206, this.gbz);
          break;
          label158:
          f.a(this.gbz, new e(f.d(this.gbz), 1));
          continue;
          label184:
          f.a(this.gbz, new d(f.d(this.gbz), f.b(this.gbz)));
        }
      }
      if ((paramMessage.what == 3) && (this.gbz.gbv != null)) {
        this.gbz.gbv.a(new String[0], -1L);
      }
    }
    AppMethodBeat.o(116694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f.2
 * JD-Core Version:    0.7.0.1
 */