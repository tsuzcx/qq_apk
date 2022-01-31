package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@SuppressLint({"ViewConstructor"})
public final class c
  extends z
{
  private boolean htF = false;
  
  c()
  {
    super(d.class);
  }
  
  public final void BC(String paramString) {}
  
  public final void BD(String paramString)
  {
    AppMethodBeat.i(130261);
    runOnUiThread(new c.1(this, paramString));
    AppMethodBeat.o(130261);
  }
  
  public final void a(Context paramContext, i parami)
  {
    AppMethodBeat.i(143179);
    ((com.tencent.luggage.game.b.a)U(com.tencent.luggage.game.b.a.class)).bzS = false;
    long l = bo.yB();
    super.a(paramContext, parami);
    ab.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView init cost [%d]ms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(143179);
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(130253);
    ab.e("AppBrandGame.WAGamePageView", "dispatch not support");
    AppMethodBeat.o(130253);
  }
  
  public final void aAE()
  {
    AppMethodBeat.i(130256);
    this.ixF.aLf();
    AppMethodBeat.o(130256);
  }
  
  public final void aAF()
  {
    AppMethodBeat.i(130257);
    ab.i("AppBrandGame.WAGamePageView", "hy: on perform foreground");
    if (aJi() != null)
    {
      super.aAF();
      AppMethodBeat.o(130257);
      return;
    }
    this.ixF.onForeground();
    AppMethodBeat.o(130257);
  }
  
  public final void aAG()
  {
    AppMethodBeat.i(130258);
    ab.i("AppBrandGame.WAGamePageView", "hy: on perform background");
    if (aJi() != null)
    {
      super.aAG();
      AppMethodBeat.o(130258);
      return;
    }
    this.ixF.onBackground();
    if (this.ixD != null) {
      this.ixD.dismiss();
    }
    AppMethodBeat.o(130258);
  }
  
  public final void aAH()
  {
    AppMethodBeat.i(130259);
    super.aAH();
    AppMethodBeat.o(130259);
  }
  
  public final String aAI()
  {
    return null;
  }
  
  public final void aAJ()
  {
    AppMethodBeat.i(130262);
    runOnUiThread(new c.2(this));
    AppMethodBeat.o(130262);
  }
  
  public final Bitmap aAK()
  {
    AppMethodBeat.i(130267);
    ab.i("AppBrandGame.WAGamePageView", "hy: jsapi enter wait");
    AppMethodBeat.o(130267);
    return null;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130255);
    getRuntime().atU().c(paramString1, paramString2, hashCode());
    AppMethodBeat.o(130255);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130252);
    ab.e("AppBrandGame.WAGamePageView", "dispatch not support");
    AppMethodBeat.o(130252);
  }
  
  public final void dW(boolean paramBoolean) {}
  
  public final void initActionBar()
  {
    AppMethodBeat.i(130249);
    super.initActionBar();
    if (aJi() != null)
    {
      AppMethodBeat.o(130249);
      return;
    }
    getActionBar().setFullscreenMode(true);
    AppMethodBeat.o(130249);
  }
  
  public final void nM(int paramInt) {}
  
  public final void nN(int paramInt) {}
  
  public final View wl()
  {
    AppMethodBeat.i(130263);
    AppBrandActionHeaderLayout localAppBrandActionHeaderLayout = new AppBrandActionHeaderLayout(getContext());
    localAppBrandActionHeaderLayout.setAppId(getAppId());
    localAppBrandActionHeaderLayout.setActionHeaderStyle(this.ixo);
    ab.w("AppBrandGame.WAGamePageView", "getActionSheetHeader orientation:%d, mActionSheetTitle:%s", new Object[] { Integer.valueOf(((MMActivity)getContext()).getRequestedOrientation()), this.ixp });
    if (aJx())
    {
      if (!TextUtils.isEmpty(this.ixp)) {
        localAppBrandActionHeaderLayout.setStatusDescription(this.ixp);
      }
      localAppBrandActionHeaderLayout.a(getRuntime().atS().iconUrl, getRuntime().atS().cqQ, com.tencent.mm.modelappbrand.a.a.acC());
      AppMethodBeat.o(130263);
      return localAppBrandActionHeaderLayout;
    }
    if (!TextUtils.isEmpty(this.ixp))
    {
      localAppBrandActionHeaderLayout.setStatusDescription(this.ixp);
      AppMethodBeat.o(130263);
      return localAppBrandActionHeaderLayout;
    }
    AppMethodBeat.o(130263);
    return null;
  }
  
  public final com.tencent.mm.vending.g.c<Bitmap> wp()
  {
    AppMethodBeat.i(130266);
    f localf = com.tencent.mm.cm.g.cT(null);
    AppMethodBeat.o(130266);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */