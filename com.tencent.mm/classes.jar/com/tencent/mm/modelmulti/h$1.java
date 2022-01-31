package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class h$1
  implements Runnable
{
  h$1(h paramh, String paramString) {}
  
  public final void run()
  {
    new ab(5, "", "", "", "", false, 1, false).a(h.a(this.esV), new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        paramAnonymousm.edh = true;
        y.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(h.b(h.1.this.esV).size()), paramAnonymousString, Boolean.valueOf(h.c(h.1.this.esV)), Integer.valueOf(h.d(h.1.this.esV)) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.b(h.1.this.esV).clear();
          h.a(h.1.this.esV, paramAnonymousString);
        }
        for (;;)
        {
          h.f(h.1.this.esV);
          com.tencent.mm.platformtools.ae.eTw = false;
          return;
          h.R(h.b(h.1.this.esV));
          h.e(h.1.this.esV).onSceneEnd(4, -49, h.1.this.esU, h.1.this.esV);
          h.S(h.b(h.1.this.esV));
          h.b(h.1.this.esV).clear();
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h.1
 * JD-Core Version:    0.7.0.1
 */