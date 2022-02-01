package com.tencent.luggage.sdk.b.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.u;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bp;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public class c
  extends aa
  implements d, com.tencent.mm.plugin.appbrand.jsapi.h
{
  private final Runnable cfZ;
  
  public c()
  {
    super(bp.class);
    AppMethodBeat.i(146724);
    this.cfZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.Dp();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends ac> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.cfZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.Dp();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void Dr()
  {
    AppMethodBeat.i(146733);
    FrameLayout localFrameLayout = (FrameLayout)this.kYy.findViewById(2131296781);
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
      AppMethodBeat.o(146733);
      return;
    }
  }
  
  public com.tencent.luggage.sdk.d.c Dl()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.d.c localc = (com.tencent.luggage.sdk.d.c)super.getRuntime();
    AppMethodBeat.o(146725);
    return localc;
  }
  
  public com.tencent.luggage.sdk.b.a.c.c Dm()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)super.Du();
    AppMethodBeat.o(146726);
    return localc;
  }
  
  public View Dn()
  {
    AppMethodBeat.i(169431);
    if (bjV())
    {
      localObject = new AppBrandActionHeaderLayout(getContext());
      ((AppBrandActionHeaderLayout)localObject).setActionHeaderStyle(this.laY);
      ad.w("MicroMsg.AppBrandPageViewLU", "onCreateActionSheetHeader orientation:%d, mActionSheetTitle:%s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.f.a.iV(getContext()).getRequestedOrientation()), this.laZ });
      if (!TextUtils.isEmpty(this.laZ))
      {
        ((AppBrandActionHeaderLayout)localObject).setStatusDescription(this.laZ);
        g(((AppBrandActionHeaderLayout)localObject).getStatusTextView());
      }
      String str1 = Dl().DZ().iconUrl;
      String str2 = Dl().DZ().dfM;
      Drawable localDrawable = ((com.tencent.mm.plugin.appbrand.widget.h)K(com.tencent.mm.plugin.appbrand.widget.h.class)).bra();
      ((AppBrandActionHeaderLayout)localObject).kXl.setVisibility(0);
      ((AppBrandActionHeaderLayout)localObject).kXm.setVisibility(8);
      ((AppBrandActionHeaderLayout)localObject).kXn.setImageDrawable(localDrawable);
      com.tencent.mm.modelappbrand.a.b.aub().a(((AppBrandActionHeaderLayout)localObject).kXn.getImageView(), str1, null, com.tencent.mm.modelappbrand.a.g.gSK);
      ((AppBrandActionHeaderLayout)localObject).kXn.setTextViewText(str2);
      AppMethodBeat.o(169431);
      return localObject;
    }
    Object localObject = super.Dn();
    AppMethodBeat.o(169431);
    return localObject;
  }
  
  public void Do()
  {
    AppMethodBeat.i(146728);
    super.Do();
    bs(false);
    AppMethodBeat.o(146728);
  }
  
  public final void Dp()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      ad.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), this.jzm });
      AppMethodBeat.o(146731);
      return;
    }
    ad.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), this.jzm });
    bjT();
    com.tencent.mm.plugin.appbrand.page.g localg = new com.tencent.mm.plugin.appbrand.page.g(getContext(), Dl());
    this.kYy.addView(localg);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> Dq()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fhq().f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void Ds()
  {
    AppMethodBeat.i(186871);
    L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.kWU == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.kWU.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.a(c.this);
        c.this.kWU.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    a(new f.e()
    {
      public final void Dv()
      {
        AppMethodBeat.i(169430);
        c.this.b(this);
        c.b(c.this);
        c.this.kWU.setVerticalScrollBarEnabled(true);
        AppMethodBeat.o(169430);
      }
    });
    AppMethodBeat.o(186871);
  }
  
  public void Dt()
  {
    AppMethodBeat.i(146736);
    if (Dl().aLK().getPageCount() == 1)
    {
      bjH().setNavHidden(true);
      AppMethodBeat.o(146736);
      return;
    }
    bjH().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public final void bs(boolean paramBoolean)
  {
    AppMethodBeat.i(186870);
    removeCallbacks(this.cfZ);
    if (paramBoolean) {
      onReady();
    }
    AppMethodBeat.o(186870);
  }
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    e locale = Dl().cif;
    if ((locale.b(Dm(), u.class)) || (locale.b(this, u.class)))
    {
      super.bt(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.bt(true);
    AppMethodBeat.o(146735);
  }
  
  public boolean ct(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(186869);
    boolean bool = super.ct(paramString);
    if (bool) {
      bs(false);
    }
    for (;;)
    {
      if (i < this.kYy.getChildCount())
      {
        paramString = this.kYy.getChildAt(i);
        if ((paramString instanceof com.tencent.mm.plugin.appbrand.page.g)) {
          this.kYy.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(186869);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void cu(String paramString)
  {
    AppMethodBeat.i(146729);
    this.lbh = true;
    if (!Dl().cif.b(this, c.b.class))
    {
      Dp();
      AppMethodBeat.o(146729);
      return;
    }
    ad.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", new Object[] { paramString });
    Object localObject = new HashMap();
    ((Map)localObject).put("path", k.cA(paramString));
    ((Map)localObject).put("query", k.cB(paramString));
    ((Map)localObject).put("rawPath", paramString);
    ((Map)localObject).put("isEntryPage", Boolean.valueOf(bt.nullAsNil(paramString).equals(Dl().aLS())));
    b(new c.b((byte)0).B((Map)localObject));
    paramString = this.cfZ;
    if (paramString == null)
    {
      AppMethodBeat.o(146729);
      return;
    }
    localObject = getContentView();
    if (localObject != null)
    {
      ((View)localObject).postDelayed(paramString, 2000L);
      AppMethodBeat.o(146729);
      return;
    }
    AppMethodBeat.o(146729);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(146734);
    com.tencent.mm.plugin.appbrand.page.b.h localh = (com.tencent.mm.plugin.appbrand.page.b.h)Q(com.tencent.mm.plugin.appbrand.page.b.h.class);
    if ((localh != null) && (localh.CK()))
    {
      AppMethodBeat.o(146734);
      return true;
    }
    AppMethodBeat.o(146734);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */