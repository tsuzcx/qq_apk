package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class h$1
  implements c.a
{
  h$1(h.a parama, t paramt) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    if (paramWxaAttributes == null)
    {
      y.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, get contact info fail");
      h.a(this.gMk);
      return;
    }
    if (paramWxaAttributes.aen().dWx == 4) {}
    for (int i = 1;; i = 0)
    {
      if (((!this.gMl.uU("banJumpGame")) || (i == 0)) && ((!this.gMl.uU("banJumpApp")) || (i != 0))) {
        break label92;
      }
      y.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, return should ban jump");
      paramWxaAttributes = this.gMk;
      if (paramWxaAttributes == null) {
        break;
      }
      paramWxaAttributes.alU();
      return;
    }
    label92:
    y.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no need to ban jump");
    h.a(this.gMk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.h.1
 * JD-Core Version:    0.7.0.1
 */