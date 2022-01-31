package com.tencent.mm.console;

import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class b$6
  implements f
{
  b$6(boolean paramBoolean, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 != -102) && (!this.dAB))
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          b.y(b.6.this.val$context, "RSA(req) fatal err, must recheck!!!");
        }
      });
      return;
    }
    new i().a(g.DO().dJT.edx, new b.6.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.6
 * JD-Core Version:    0.7.0.1
 */