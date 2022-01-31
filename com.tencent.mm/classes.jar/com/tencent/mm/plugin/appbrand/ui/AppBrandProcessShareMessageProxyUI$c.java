package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class AppBrandProcessShareMessageProxyUI$c
{
  private Context context;
  Runnable hGy;
  private boolean iNk;
  boolean iNl;
  private boolean iNm;
  private int iNn;
  AppBrandProcessShareMessageProxyUI.b iNo;
  private String text;
  p tipDialog;
  
  public AppBrandProcessShareMessageProxyUI$c(AppBrandProcessShareMessageProxyUI paramAppBrandProcessShareMessageProxyUI, Context paramContext)
  {
    AppMethodBeat.i(133018);
    this.hGy = new AppBrandProcessShareMessageProxyUI.c.1(this);
    this.context = paramContext;
    AppMethodBeat.o(133018);
  }
  
  public final void aMj()
  {
    AppMethodBeat.i(133020);
    if (this.iNo != null) {
      this.iNo.e(this.iNm, this.text, this.iNn);
    }
    AppMethodBeat.o(133020);
  }
  
  public final void f(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133019);
    this.iNk = true;
    this.iNm = paramBoolean;
    this.text = paramString;
    this.iNn = paramInt;
    if (lw())
    {
      aMj();
      AppMethodBeat.o(133019);
      return;
    }
    if (paramBoolean)
    {
      this.tipDialog = h.b(this.context, this.context.getString(2131297069), true, null);
      al.p(this.hGy, 5000L);
    }
    AppMethodBeat.o(133019);
  }
  
  public final boolean lw()
  {
    return (this.iNk) && (this.iNl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.c
 * JD-Core Version:    0.7.0.1
 */