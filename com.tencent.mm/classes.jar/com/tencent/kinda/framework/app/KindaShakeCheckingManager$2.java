package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class KindaShakeCheckingManager$2
  extends d.a
{
  KindaShakeCheckingManager$2(KindaShakeCheckingManager paramKindaShakeCheckingManager) {}
  
  public void onRelease() {}
  
  public void onShake(boolean paramBoolean)
  {
    AppMethodBeat.i(144403);
    ab.i("KindaShakeCheckingManager", "onShake");
    long l = bo.av(KindaShakeCheckingManager.access$200(this.this$0));
    if (!KindaShakeCheckingManager.access$300(this.this$0))
    {
      if (l < 1200L) {
        AppMethodBeat.o(144403);
      }
    }
    else if (l < 80L)
    {
      AppMethodBeat.o(144403);
      return;
    }
    KindaShakeCheckingManager.access$202(this.this$0, bo.yB());
    KindaShakeCheckingManager.access$302(this.this$0, true);
    if (!KindaShakeCheckingManager.access$000(this.this$0))
    {
      KindaShakeCheckingManager.access$002(this.this$0, true);
      if (KindaShakeCheckingManager.access$400(this.this$0) != null) {
        KindaShakeCheckingManager.access$400(this.this$0).call();
      }
    }
    AppMethodBeat.o(144403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaShakeCheckingManager.2
 * JD-Core Version:    0.7.0.1
 */