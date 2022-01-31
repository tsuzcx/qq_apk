package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;

final class WXCommProvider$6
  extends bj<Boolean>
{
  WXCommProvider$6(WXCommProvider paramWXCommProvider, Boolean paramBoolean)
  {
    super(4000L, paramBoolean);
  }
  
  private Boolean aJK()
  {
    AppMethodBeat.i(18168);
    try
    {
      ab.i("MicroMsg.WXCommProvider", "checkIsLogin run");
      if (!aw.RG())
      {
        Boolean localBoolean1 = Boolean.FALSE;
        AppMethodBeat.o(18168);
        return localBoolean1;
      }
      ab.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
      boolean bool = aw.Rc().a(new bk(new WXCommProvider.6.1(this)), 0);
      AppMethodBeat.o(18168);
      return Boolean.valueOf(bool);
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
      cv(Boolean.FALSE);
      Boolean localBoolean2 = Boolean.FALSE;
      AppMethodBeat.o(18168);
      return localBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.6
 * JD-Core Version:    0.7.0.1
 */