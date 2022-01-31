package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  extends ah
{
  f$2(f paramf) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2) {
      if (this.eLS.eLO != null) {
        this.eLS.eLO.Ty();
      }
    }
    label143:
    label169:
    do
    {
      return;
      if (paramMessage.what == 0)
      {
        if (f.b(this.eLS) == 0)
        {
          y.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
          g.Dk().a(349, this.eLS);
          if (f.b(this.eLS) != 0) {
            break label169;
          }
          if (f.c(this.eLS)) {
            break label143;
          }
          f.a(this.eLS, new e(f.d(this.eLS), 0));
        }
        for (;;)
        {
          g.Dk().a(f.e(this.eLS), 0);
          return;
          g.Dk().a(206, this.eLS);
          break;
          f.a(this.eLS, new e(f.d(this.eLS), 1));
          continue;
          f.a(this.eLS, new d(f.d(this.eLS), f.b(this.eLS)));
        }
      }
    } while ((paramMessage.what != 3) || (this.eLS.eLO == null));
    this.eLS.eLO.a(new String[0], -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f.2
 * JD-Core Version:    0.7.0.1
 */