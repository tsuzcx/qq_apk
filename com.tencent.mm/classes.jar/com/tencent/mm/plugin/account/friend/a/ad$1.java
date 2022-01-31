package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.sdk.platformtools.y;

final class ad$1
  implements Runnable
{
  ad$1(ad paramad, int paramInt) {}
  
  public final void run()
  {
    new i().a(this.fgw.edc, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        y.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymousm.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.1.this.fgw.dmL.onSceneEnd(paramAnonymousInt1, paramAnonymousInt2, "", ad.1.this.fgw);
          return;
        }
        ad.1.this.fgw.a(ad.1.this.fgw.edc, ad.1.this.fgw.dmL);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad.1
 * JD-Core Version:    0.7.0.1
 */