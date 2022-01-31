package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.i.a;

final class h$1
  implements i.a
{
  h$1(h.a parama, com.tencent.mm.plugin.appbrand.launching.ab paramab) {}
  
  public final void d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(132044);
    if (paramWxaAttributes == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, get contact info fail");
      h.a(this.inB);
      AppMethodBeat.o(132044);
      return;
    }
    boolean bool = paramWxaAttributes.ayC().vY();
    if (((this.inC.Dn("banJumpGame")) && (bool)) || ((this.inC.Dn("banJumpApp")) && (!bool)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, return should ban jump");
      paramWxaAttributes = this.inB;
      if (paramWxaAttributes != null) {
        paramWxaAttributes.aHo();
      }
      AppMethodBeat.o(132044);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no need to ban jump");
    h.a(this.inB);
    AppMethodBeat.o(132044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.h.1
 * JD-Core Version:    0.7.0.1
 */