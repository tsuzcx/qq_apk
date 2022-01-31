package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class h$1
  implements Runnable
{
  h$1(h paramh, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(59966);
    new ac(5, "", "", "", "", false, 1, false).doScene(h.a(this.fII), new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(59965);
        paramAnonymousm.setHasCallbackToQueue(true);
        ab.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(h.b(h.1.this.fII).size()), paramAnonymousString, Boolean.valueOf(h.c(h.1.this.fII)), Integer.valueOf(h.d(h.1.this.fII)) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.b(h.1.this.fII).clear();
          h.a(h.1.this.fII, paramAnonymousString);
        }
        for (;;)
        {
          h.f(h.1.this.fII);
          com.tencent.mm.platformtools.ae.glr = false;
          AppMethodBeat.o(59965);
          return;
          h.Y(h.b(h.1.this.fII));
          h.e(h.1.this.fII).onSceneEnd(4, -49, h.1.this.fIH, h.1.this.fII);
          h.Z(h.b(h.1.this.fII));
          h.b(h.1.this.fII).clear();
        }
      }
    });
    AppMethodBeat.o(59966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h.1
 * JD-Core Version:    0.7.0.1
 */