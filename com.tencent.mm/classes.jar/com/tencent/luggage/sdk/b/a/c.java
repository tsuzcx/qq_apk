package com.tencent.luggage.sdk.b.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public class c
  extends v
  implements d, com.tencent.mm.plugin.appbrand.jsapi.h
{
  private final Runnable bDP;
  
  public c()
  {
    super(av.class);
    AppMethodBeat.i(101639);
    this.bDP = new c.1(this);
    AppMethodBeat.o(101639);
  }
  
  public c(Class<? extends x> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(140688);
    this.bDP = new c.1(this);
    AppMethodBeat.o(140688);
  }
  
  private void wq()
  {
    AppMethodBeat.i(101649);
    FrameLayout localFrameLayout = (FrameLayout)this.ivI.findViewById(2131820569);
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(8);
      if (!(localFrameLayout.getBackground() instanceof BitmapDrawable)) {
        break label68;
      }
    }
    label68:
    for (Bitmap localBitmap = ((BitmapDrawable)localFrameLayout.getBackground()).getBitmap();; localBitmap = null)
    {
      localFrameLayout.setBackground(null);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      AppMethodBeat.o(101649);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public final void bb(boolean paramBoolean)
  {
    AppMethodBeat.i(140693);
    e locale = wj().wO();
    if ((locale.b(wk(), com.tencent.mm.plugin.appbrand.jsapi.l.r.class)) || (locale.b(this, com.tencent.mm.plugin.appbrand.jsapi.l.r.class)))
    {
      super.bb(paramBoolean);
      AppMethodBeat.o(140693);
      return;
    }
    super.bb(true);
    AppMethodBeat.o(140693);
  }
  
  public final void cd(String paramString)
  {
    AppMethodBeat.i(101646);
    if (!wj().wO().b(this, c.b.class))
    {
      wo();
      AppMethodBeat.o(101646);
      return;
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", new Object[] { paramString });
    Object localObject = new HashMap();
    ((Map)localObject).put("path", com.tencent.luggage.g.h.cg(paramString));
    ((Map)localObject).put("query", com.tencent.luggage.g.h.ch(paramString));
    ((Map)localObject).put("rawPath", paramString);
    ((Map)localObject).put("isEntryPage", Boolean.valueOf(bo.nullAsNil(paramString).equals(wj().ato())));
    b(new c.b((byte)0).w((Map)localObject));
    paramString = this.bDP;
    if (paramString == null)
    {
      AppMethodBeat.o(101646);
      return;
    }
    localObject = getContentView();
    if (localObject != null)
    {
      ((View)localObject).postDelayed(paramString, 2000L);
      AppMethodBeat.o(101646);
      return;
    }
    AppMethodBeat.o(101646);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(140692);
    com.tencent.mm.plugin.appbrand.page.b.f localf = (com.tencent.mm.plugin.appbrand.page.b.f)x(com.tencent.mm.plugin.appbrand.page.b.f.class);
    if ((localf != null) && (localf.vM()))
    {
      AppMethodBeat.o(140692);
      return true;
    }
    AppMethodBeat.o(140692);
    return false;
  }
  
  public com.tencent.luggage.sdk.d.b wj()
  {
    AppMethodBeat.i(101640);
    com.tencent.luggage.sdk.d.b localb = (com.tencent.luggage.sdk.d.b)super.getRuntime();
    AppMethodBeat.o(101640);
    return localb;
  }
  
  public com.tencent.luggage.sdk.b.a.c.c wk()
  {
    AppMethodBeat.i(140689);
    com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)super.ws();
    AppMethodBeat.o(140689);
    return localc;
  }
  
  public View wl()
  {
    AppMethodBeat.i(140690);
    if (aJx())
    {
      localObject = new AppBrandActionHeaderLayout(getContext());
      ((AppBrandActionHeaderLayout)localObject).setActionHeaderStyle(this.ixo);
      com.tencent.luggage.g.d.w("MicroMsg.AppBrandPageViewLU", "getActionSheetHeader orientation:%d, mActionSheetTitle:%s", new Object[] { Integer.valueOf(a.hr(getContext()).getRequestedOrientation()), this.ixp });
      if (!TextUtils.isEmpty(this.ixp)) {
        ((AppBrandActionHeaderLayout)localObject).setStatusDescription(this.ixp);
      }
      ((AppBrandActionHeaderLayout)localObject).a(wj().wS().iconUrl, wj().wS().cqQ, ((com.tencent.mm.plugin.appbrand.widget.h)q(com.tencent.mm.plugin.appbrand.widget.h.class)).aOD());
      AppMethodBeat.o(140690);
      return localObject;
    }
    Object localObject = super.wl();
    AppMethodBeat.o(140690);
    return localObject;
  }
  
  public void wm()
  {
    AppMethodBeat.i(101642);
    super.wm();
    wn();
    AppMethodBeat.o(101642);
  }
  
  public final void wn()
  {
    AppMethodBeat.i(140691);
    removeCallbacks(this.bDP);
    AppMethodBeat.o(140691);
  }
  
  public final void wo()
  {
    AppMethodBeat.i(101647);
    if (wj() == null)
    {
      AppMethodBeat.o(101647);
      return;
    }
    aJu();
    if (wj().atj().getPageCount() < 2) {
      wj().gPP = true;
    }
    com.tencent.mm.plugin.appbrand.page.f localf = new com.tencent.mm.plugin.appbrand.page.f(getContext(), wj());
    this.ivI.addView(localf);
    AppMethodBeat.o(101647);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> wp()
  {
    AppMethodBeat.i(101648);
    com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.f.dQr().f(new c.2(this));
    AppMethodBeat.o(101648);
    return localc;
  }
  
  public void wr()
  {
    AppMethodBeat.i(140694);
    if (wj().atj().getPageCount() == 1)
    {
      if (this.gRG.atj().getPageCount() == 1)
      {
        getActionBar().setNavHidden(true);
        AppMethodBeat.o(140694);
        return;
      }
      getActionBar().setNavHidden(false);
      AppMethodBeat.o(140694);
      return;
    }
    aJv();
    AppMethodBeat.o(140694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */