package com.tencent.mm.console;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class b$6
  implements i
{
  b$6(boolean paramBoolean, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20118);
    Log.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 != -102) && (!this.jwM))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20115);
          b.E(b.6.this.val$context, "RSA(req) fatal err, must recheck!!!");
          AppMethodBeat.o(20115);
        }
      });
      AppMethodBeat.o(20118);
      return;
    }
    new m().doScene(h.aHF().kcd.lCD, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(20117);
        Log.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -102))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20116);
              b.E(b.6.this.val$context, "RSA(base) fatal err, must recheck!!!");
              AppMethodBeat.o(20116);
            }
          });
          AppMethodBeat.o(20117);
          return;
        }
        Toast.makeText(b.6.this.val$context, "DefaultRSA check pass", 0).show();
        b.E(b.6.this.val$context, "");
        AppMethodBeat.o(20117);
      }
    });
    AppMethodBeat.o(20118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.6
 * JD-Core Version:    0.7.0.1
 */