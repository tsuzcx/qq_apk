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
import com.tencent.mm.plugin.appbrand.jsapi.n.w;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.bk;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public class c
  extends aa
  implements d, com.tencent.mm.plugin.appbrand.jsapi.h
{
  private final Runnable cnn;
  
  public c()
  {
    super(bk.class);
    AppMethodBeat.i(146724);
    this.cnn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.Er();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends ac> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.cnn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.Er();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void Et()
  {
    AppMethodBeat.i(146733);
    FrameLayout localFrameLayout = (FrameLayout)this.lZG.findViewById(2131296781);
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
  
  public com.tencent.luggage.sdk.d.c En()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.d.c localc = (com.tencent.luggage.sdk.d.c)super.getRuntime();
    AppMethodBeat.o(146725);
    return localc;
  }
  
  public com.tencent.luggage.sdk.b.a.c.c Eo()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)super.Ew();
    AppMethodBeat.o(146726);
    return localc;
  }
  
  public View Ep()
  {
    AppMethodBeat.i(169431);
    if (buM())
    {
      localObject = new AppBrandActionHeaderLayout(getContext());
      ((AppBrandActionHeaderLayout)localObject).setActionHeaderStyle(this.mbY);
      ad.w("MicroMsg.AppBrandPageViewLU", "onCreateActionSheetHeader orientation:%d, mActionSheetTitle:%s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.f.a.jq(getContext()).getRequestedOrientation()), this.mbZ });
      if (!TextUtils.isEmpty(this.mbZ))
      {
        ((AppBrandActionHeaderLayout)localObject).setStatusDescription(this.mbZ);
        g(((AppBrandActionHeaderLayout)localObject).getStatusTextView());
      }
      String str1 = En().Fb().iconUrl;
      String str2 = En().Fb().doD;
      Drawable localDrawable = ((com.tencent.mm.plugin.appbrand.widget.h)K(com.tencent.mm.plugin.appbrand.widget.h.class)).bCg();
      ((AppBrandActionHeaderLayout)localObject).lYt.setVisibility(0);
      ((AppBrandActionHeaderLayout)localObject).lYu.setVisibility(8);
      ((AppBrandActionHeaderLayout)localObject).lYv.setImageDrawable(localDrawable);
      com.tencent.mm.modelappbrand.a.b.aDV().a(((AppBrandActionHeaderLayout)localObject).lYv.getImageView(), str1, null, com.tencent.mm.modelappbrand.a.g.hLC);
      ((AppBrandActionHeaderLayout)localObject).lYv.setTextViewText(str2);
      AppMethodBeat.o(169431);
      return localObject;
    }
    Object localObject = super.Ep();
    AppMethodBeat.o(169431);
    return localObject;
  }
  
  public void Eq()
  {
    AppMethodBeat.i(146728);
    super.Eq();
    bs(false);
    AppMethodBeat.o(146728);
  }
  
  public final void Er()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      ad.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), this.kuf });
      AppMethodBeat.o(146731);
      return;
    }
    ad.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), this.kuf });
    buK();
    com.tencent.mm.plugin.appbrand.page.g localg = new com.tencent.mm.plugin.appbrand.page.g(getContext(), En());
    this.lZG.addView(localg);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> Es()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fOf().f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void Eu()
  {
    AppMethodBeat.i(192187);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.lYc == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.lYc.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.a(c.this);
        c.this.lYc.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    a(new f.e()
    {
      public final void Ex()
      {
        AppMethodBeat.i(169430);
        c.this.b(this);
        c.b(c.this);
        c.this.lYc.setVerticalScrollBarEnabled(true);
        AppMethodBeat.o(169430);
      }
    });
    AppMethodBeat.o(192187);
  }
  
  public void Ev()
  {
    AppMethodBeat.i(146736);
    if (En().aVN().getPageCount() == 1)
    {
      bux().setNavHidden(true);
      AppMethodBeat.o(146736);
      return;
    }
    bux().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public final void bs(boolean paramBoolean)
  {
    AppMethodBeat.i(192186);
    removeCallbacks(this.cnn);
    if (paramBoolean) {
      Tn("cancelShowErrorPageViewRunnable");
    }
    AppMethodBeat.o(192186);
  }
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    com.tencent.mm.plugin.appbrand.permission.d locald = En().cpr;
    if ((locald.a(Eo(), w.class)) || (locald.a(this, w.class)))
    {
      super.bt(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.bt(true);
    AppMethodBeat.o(146735);
  }
  
  public boolean dk(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(192185);
    boolean bool = super.dk(paramString);
    if (bool) {
      bs(false);
    }
    for (;;)
    {
      if (i < this.lZG.getChildCount())
      {
        paramString = this.lZG.getChildAt(i);
        if ((paramString instanceof com.tencent.mm.plugin.appbrand.page.g)) {
          this.lZG.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(192185);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void dl(String paramString)
  {
    AppMethodBeat.i(146729);
    this.mch = true;
    if (!En().cpr.a(this, c.b.class))
    {
      Er();
      AppMethodBeat.o(146729);
      return;
    }
    ad.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", new Object[] { paramString });
    Object localObject = new HashMap();
    ((Map)localObject).put("path", k.dr(paramString));
    ((Map)localObject).put("query", k.ds(paramString));
    ((Map)localObject).put("rawPath", paramString);
    ((Map)localObject).put("isEntryPage", Boolean.valueOf(bt.nullAsNil(paramString).equals(En().aVW())));
    b(new c.b((byte)0).A((Map)localObject));
    paramString = this.cnn;
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
    if ((localh != null) && (localh.DN()))
    {
      AppMethodBeat.o(146734);
      return true;
    }
    AppMethodBeat.o(146734);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */