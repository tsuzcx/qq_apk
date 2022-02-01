package com.tencent.mm.plugin.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ext.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SyncTask;

public final class e$2
  extends SyncTask<Boolean>
{
  public e$2(e parame, Boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    super(5000L, paramBoolean, true);
  }
  
  private Boolean ceW()
  {
    AppMethodBeat.i(24498);
    h.aHF().kcd.a(782, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(24497);
        if (((a)paramAnonymousq).wue == 0) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(bool) });
          h.aHF().kcd.b(782, this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break;
          }
          e.2.this.setResultFinish(Boolean.valueOf(bool));
          AppMethodBeat.o(24497);
          return;
        }
        e.2.this.setResultFinish(Boolean.FALSE);
        AppMethodBeat.o(24497);
      }
    });
    h.aHF().kcd.a(new a(this.val$url, this.oNc, this.oNd), 0);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(24498);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e.2
 * JD-Core Version:    0.7.0.1
 */