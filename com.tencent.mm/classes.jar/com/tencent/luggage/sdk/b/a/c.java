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
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.bk;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public class c
  extends aa
  implements d, com.tencent.mm.plugin.appbrand.jsapi.h
{
  private final Runnable ccW;
  
  public c()
  {
    super(bk.class);
    AppMethodBeat.i(146724);
    this.ccW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.CS();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends com.tencent.mm.plugin.appbrand.page.ac> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.ccW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.CS();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void CU()
  {
    AppMethodBeat.i(146733);
    FrameLayout localFrameLayout = (FrameLayout)this.lAi.findViewById(2131296781);
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
  
  public com.tencent.luggage.sdk.d.c CO()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.d.c localc = (com.tencent.luggage.sdk.d.c)super.getRuntime();
    AppMethodBeat.o(146725);
    return localc;
  }
  
  public com.tencent.luggage.sdk.b.a.c.c CP()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)super.CX();
    AppMethodBeat.o(146726);
    return localc;
  }
  
  public View CQ()
  {
    AppMethodBeat.i(169431);
    if (bqM())
    {
      localObject = new AppBrandActionHeaderLayout(getContext());
      ((AppBrandActionHeaderLayout)localObject).setActionHeaderStyle(this.lCx);
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandPageViewLU", "onCreateActionSheetHeader orientation:%d, mActionSheetTitle:%s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.f.a.jg(getContext()).getRequestedOrientation()), this.lCy });
      if (!TextUtils.isEmpty(this.lCy))
      {
        ((AppBrandActionHeaderLayout)localObject).setStatusDescription(this.lCy);
        g(((AppBrandActionHeaderLayout)localObject).getStatusTextView());
      }
      String str1 = CO().DC().iconUrl;
      String str2 = CO().DC().ddh;
      Drawable localDrawable = ((com.tencent.mm.plugin.appbrand.widget.h)K(com.tencent.mm.plugin.appbrand.widget.h.class)).bya();
      ((AppBrandActionHeaderLayout)localObject).lyV.setVisibility(0);
      ((AppBrandActionHeaderLayout)localObject).lyW.setVisibility(8);
      ((AppBrandActionHeaderLayout)localObject).lyX.setImageDrawable(localDrawable);
      com.tencent.mm.modelappbrand.a.b.aAS().a(((AppBrandActionHeaderLayout)localObject).lyX.getImageView(), str1, null, com.tencent.mm.modelappbrand.a.g.htk);
      ((AppBrandActionHeaderLayout)localObject).lyX.setTextViewText(str2);
      AppMethodBeat.o(169431);
      return localObject;
    }
    Object localObject = super.CQ();
    AppMethodBeat.o(169431);
    return localObject;
  }
  
  public void CR()
  {
    AppMethodBeat.i(146728);
    super.CR();
    br(false);
    AppMethodBeat.o(146728);
  }
  
  public final void CS()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), this.jZJ });
      AppMethodBeat.o(146731);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), this.jZJ });
    bqK();
    com.tencent.mm.plugin.appbrand.page.g localg = new com.tencent.mm.plugin.appbrand.page.g(getContext(), CO());
    this.lAi.addView(localg);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> CT()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fxs().f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void CV()
  {
    AppMethodBeat.i(206119);
    N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.lyE == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.lyE.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.a(c.this);
        c.this.lyE.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    a(new f.e()
    {
      public final void CY()
      {
        AppMethodBeat.i(169430);
        c.this.b(this);
        c.b(c.this);
        c.this.lyE.setVerticalScrollBarEnabled(true);
        AppMethodBeat.o(169430);
      }
    });
    AppMethodBeat.o(206119);
  }
  
  public void CW()
  {
    AppMethodBeat.i(146736);
    if (CO().aSA().getPageCount() == 1)
    {
      bqy().setNavHidden(true);
      AppMethodBeat.o(146736);
      return;
    }
    bqy().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public final void br(boolean paramBoolean)
  {
    AppMethodBeat.i(206118);
    removeCallbacks(this.ccW);
    if (paramBoolean) {
      onReady();
    }
    AppMethodBeat.o(206118);
  }
  
  public final void bs(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    e locale = CO().cfa;
    if ((locale.b(CP(), com.tencent.mm.plugin.appbrand.jsapi.k.u.class)) || (locale.b(this, com.tencent.mm.plugin.appbrand.jsapi.k.u.class)))
    {
      super.bs(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.bs(true);
    AppMethodBeat.o(146735);
  }
  
  public boolean ci(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(206117);
    boolean bool = super.ci(paramString);
    if (bool) {
      br(false);
    }
    for (;;)
    {
      if (i < this.lAi.getChildCount())
      {
        paramString = this.lAi.getChildAt(i);
        if ((paramString instanceof com.tencent.mm.plugin.appbrand.page.g)) {
          this.lAi.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(206117);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void cj(String paramString)
  {
    AppMethodBeat.i(146729);
    this.lCG = true;
    if (!CO().cfa.b(this, b.class))
    {
      CS();
      AppMethodBeat.o(146729);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", new Object[] { paramString });
    Object localObject = new HashMap();
    ((Map)localObject).put("path", k.cp(paramString));
    ((Map)localObject).put("query", k.cq(paramString));
    ((Map)localObject).put("rawPath", paramString);
    ((Map)localObject).put("isEntryPage", Boolean.valueOf(bs.nullAsNil(paramString).equals(CO().aSI())));
    b(new b((byte)0).A((Map)localObject));
    paramString = this.ccW;
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
    if ((localh != null) && (localh.Co()))
    {
      AppMethodBeat.o(146734);
      return true;
    }
    AppMethodBeat.o(146734);
    return false;
  }
  
  static final class b
    extends p
  {
    static final int CTRL_INDEX = 429;
    static final String NAME = "onPageNotFound";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */