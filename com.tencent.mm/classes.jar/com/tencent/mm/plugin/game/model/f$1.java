package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class f$1
  implements com.tencent.mm.al.f
{
  f$1(String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(41398);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { this.jBr });
      g.aiU().b(1369, this);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41397);
          f.a(this.ubb, f.1.this.jBr);
          AppMethodBeat.o(41397);
        }
      });
      AppMethodBeat.o(41398);
      return;
    }
    ad.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { this.jBr });
    AppMethodBeat.o(41398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f.1
 * JD-Core Version:    0.7.0.1
 */