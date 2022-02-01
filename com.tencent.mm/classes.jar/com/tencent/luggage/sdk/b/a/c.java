package com.tencent.luggage.sdk.b.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.n.w;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;
import java.util.Map;

public class c
  extends z
  implements d, com.tencent.mm.plugin.appbrand.jsapi.h
{
  private final Runnable cnp;
  
  public c()
  {
    super(bj.class);
    AppMethodBeat.i(146724);
    this.cnp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.Et();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends ab> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.cnp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.Et();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void Ev()
  {
    AppMethodBeat.i(146733);
    FrameLayout localFrameLayout = (FrameLayout)this.mdY.findViewById(2131296781);
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
  
  public com.tencent.luggage.sdk.d.d Eq()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.d.d locald = (com.tencent.luggage.sdk.d.d)super.getRuntime();
    AppMethodBeat.o(146725);
    return locald;
  }
  
  public com.tencent.luggage.sdk.b.a.c.c Er()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)super.Ey();
    AppMethodBeat.o(146726);
    return localc;
  }
  
  public void Es()
  {
    AppMethodBeat.i(146728);
    super.Es();
    bs(false);
    AppMethodBeat.o(146728);
  }
  
  public final void Et()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      ae.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), this.kxv });
      AppMethodBeat.o(146731);
      return;
    }
    ae.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), this.kxv });
    bvv();
    f localf = new f(getContext(), Eq());
    this.mdY.addView(localf);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> Eu()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = g.fSA().f(new a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void Ew()
  {
    AppMethodBeat.i(220760);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.mcJ == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.mcJ.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.a(c.this);
        c.this.mcJ.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    a(new f.e()
    {
      public final void Ez()
      {
        AppMethodBeat.i(169430);
        c.this.b(this);
        c.b(c.this);
        c.this.mcJ.setVerticalScrollBarEnabled(true);
        AppMethodBeat.o(169430);
      }
    });
    AppMethodBeat.o(220760);
  }
  
  public void Ex()
  {
    AppMethodBeat.i(146736);
    if (Eq().aWm().getPageCount() == 1)
    {
      bvi().setNavHidden(true);
      AppMethodBeat.o(146736);
      return;
    }
    bvi().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public final void bs(boolean paramBoolean)
  {
    AppMethodBeat.i(220759);
    removeCallbacks(this.cnp);
    if (paramBoolean) {
      TY("cancelShowErrorPageViewRunnable");
    }
    AppMethodBeat.o(220759);
  }
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    com.tencent.mm.plugin.appbrand.permission.d locald = Eq().cpU;
    if ((locald.a(Er(), w.class)) || (locald.a(this, w.class)))
    {
      super.bt(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.bt(true);
    AppMethodBeat.o(146735);
  }
  
  public boolean dm(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(220758);
    boolean bool = super.dm(paramString);
    if (bool) {
      bs(false);
    }
    for (;;)
    {
      if (i < this.mdY.getChildCount())
      {
        paramString = this.mdY.getChildAt(i);
        if ((paramString instanceof f)) {
          this.mdY.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(220758);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void dn(String paramString)
  {
    AppMethodBeat.i(146729);
    this.mgz = true;
    if (!Eq().cpU.a(this, b.class))
    {
      Et();
      AppMethodBeat.o(146729);
      return;
    }
    ae.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", new Object[] { paramString });
    Object localObject = new HashMap();
    ((Map)localObject).put("path", k.dt(paramString));
    ((Map)localObject).put("query", k.du(paramString));
    ((Map)localObject).put("rawPath", paramString);
    ((Map)localObject).put("isEntryPage", Boolean.valueOf(bu.nullAsNil(paramString).equals(Eq().aWx())));
    b(new b((byte)0).H((Map)localObject));
    paramString = this.cnp;
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
    com.tencent.mm.plugin.appbrand.page.a.h localh = (com.tencent.mm.plugin.appbrand.page.a.h)Q(com.tencent.mm.plugin.appbrand.page.a.h.class);
    if ((localh != null) && (localh.DQ()))
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