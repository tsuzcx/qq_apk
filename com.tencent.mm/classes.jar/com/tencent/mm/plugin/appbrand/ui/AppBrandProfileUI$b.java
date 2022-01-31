package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;

final class AppBrandProfileUI$b
  implements b.a
{
  WeakReference<AppBrandProfileUI> iOr;
  
  public AppBrandProfileUI$b(AppBrandProfileUI paramAppBrandProfileUI)
  {
    AppMethodBeat.i(133053);
    this.iOr = new WeakReference(paramAppBrandProfileUI);
    AppMethodBeat.o(133053);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(133054);
    if ((this.iOr != null) && (this.iOr.get() != null))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.fsW.fta != null) && ((paramb.fsW.fta instanceof cnm)))
      {
        ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
        al.d(new AppBrandProfileUI.b.1(this));
        AppMethodBeat.o(133054);
        return;
      }
      ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
      al.d(new AppBrandProfileUI.b.2(this));
    }
    AppMethodBeat.o(133054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.b
 * JD-Core Version:    0.7.0.1
 */