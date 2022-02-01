package com.tencent.mm.plugin.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.d.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bp;

public final class e$2
  extends bp<Boolean>
{
  public e$2(e parame, Boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    super(5000L, paramBoolean);
  }
  
  private Boolean bvU()
  {
    AppMethodBeat.i(24498);
    g.ajQ().gDv.a(782, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24497);
        if (((a)paramAnonymousn).rmE == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(bool) });
          g.ajQ().gDv.b(782, this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break;
          }
          e.2.this.aG(Boolean.valueOf(bool));
          AppMethodBeat.o(24497);
          return;
        }
        e.2.this.aG(Boolean.FALSE);
        AppMethodBeat.o(24497);
      }
    });
    g.ajQ().gDv.a(new a(this.val$url, this.kLV, this.kLW), 0);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(24498);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e.2
 * JD-Core Version:    0.7.0.1
 */