package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.os.Process;
import com.tencent.mm.modelmulti.l.a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

final class e$3
  implements l.a
{
  e$3(e parame, Context paramContext, com.tencent.tinker.lib.e.a parama) {}
  
  public final void bX(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
      ShareTinkerInternals.ig(this.val$context);
      this.lmW.bbj();
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e.3
 * JD-Core Version:    0.7.0.1
 */