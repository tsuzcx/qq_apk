package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

final class f$1
  implements com.tencent.mm.ak.f
{
  f$1(String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(41398);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { this.jEl });
      g.ajj().b(1369, this);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41397);
          f.a(this.umd, f.1.this.jEl);
          AppMethodBeat.o(41397);
        }
      });
      AppMethodBeat.o(41398);
      return;
    }
    ae.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { this.jEl });
    AppMethodBeat.o(41398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f.1
 * JD-Core Version:    0.7.0.1
 */