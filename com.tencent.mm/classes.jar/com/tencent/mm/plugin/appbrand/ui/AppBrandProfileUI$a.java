package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;

final class AppBrandProfileUI$a
  implements b.a
{
  WeakReference<AppBrandProfileUI> iOr;
  
  public AppBrandProfileUI$a(AppBrandProfileUI paramAppBrandProfileUI)
  {
    AppMethodBeat.i(133049);
    this.iOr = new WeakReference(paramAppBrandProfileUI);
    AppMethodBeat.o(133049);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(133050);
    if ((this.iOr != null) && (this.iOr.get() != null))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.fsW.fta != null) && ((paramb.fsW.fta instanceof aok)))
      {
        ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
        al.d(new AppBrandProfileUI.a.1(this, (aok)paramb.fsW.fta));
        AppMethodBeat.o(133050);
        return;
      }
      ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
    }
    AppMethodBeat.o(133050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.a
 * JD-Core Version:    0.7.0.1
 */