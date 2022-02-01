package com.tencent.mm.console;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class b$6
  implements f
{
  b$6(boolean paramBoolean, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20118);
    ad.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 != -102) && (!this.geI))
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20115);
          b.C(b.6.this.val$context, "RSA(req) fatal err, must recheck!!!");
          AppMethodBeat.o(20115);
        }
      });
      AppMethodBeat.o(20118);
      return;
    }
    new l().doScene(g.ajB().gAO.hOv, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(20117);
        ad.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -102))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20116);
              b.C(b.6.this.val$context, "RSA(base) fatal err, must recheck!!!");
              AppMethodBeat.o(20116);
            }
          });
          AppMethodBeat.o(20117);
          return;
        }
        Toast.makeText(b.6.this.val$context, "DefaultRSA check pass", 0).show();
        b.C(b.6.this.val$context, "");
        AppMethodBeat.o(20117);
      }
    });
    AppMethodBeat.o(20118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.b.6
 * JD-Core Version:    0.7.0.1
 */