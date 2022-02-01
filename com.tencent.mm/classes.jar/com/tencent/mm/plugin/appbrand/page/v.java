package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.menu.w;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class v
  implements i.b, i.c
{
  private ad enm;
  private String mAppId;
  private f qAo;
  private List<w> qAp;
  private View tvf;
  private final Set<Runnable> tvg;
  private final Set<Runnable> tvh;
  v.a tvi;
  
  public v(ad paramad, List<w> paramList)
  {
    this(paramad, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public v(ad paramad, List<w> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.tvf = null;
    this.tvg = new HashSet();
    this.tvh = new HashSet();
    this.mAppId = paramad.getAppId();
    this.enm = paramad;
    this.qAp = paramList;
    paramList = paramad.getContext();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.qAo = new f(paramList, false, i);
      paramad = paramad.getRuntime().getWindowAndroid();
      Log.i("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", new Object[] { Integer.valueOf(paramad.getVDisplayMetrics().widthPixels) });
      if (paramad.asq())
      {
        paramList = this.qAo;
        float f = paramad.getVDisplayMetrics().widthPixels;
        paramList.sRB = ((int)(paramad.getScale() * f));
      }
      b(this.qAo);
      AppMethodBeat.o(176563);
      return;
    }
  }
  
  protected void a(f paramf) {}
  
  @Deprecated
  public final void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(324931);
    if (paramRunnable != null) {
      this.tvg.add(paramRunnable);
    }
    AppMethodBeat.o(324931);
  }
  
  @Deprecated
  public final void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(324934);
    ar(paramRunnable);
    AppMethodBeat.o(324934);
  }
  
  public final void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(324936);
    if (paramRunnable != null) {
      this.tvh.add(paramRunnable);
    }
    AppMethodBeat.o(324936);
  }
  
  protected void b(f paramf)
  {
    AppMethodBeat.i(324949);
    paramf = this.enm.cEU();
    if (paramf != null)
    {
      this.qAo.af(paramf, true);
      this.tvf = paramf;
    }
    paramf = ad.cEV();
    if (paramf != null) {
      this.qAo.setFooterView(paramf);
    }
    this.qAo.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(325099);
        v.a(v.this, paramAnonymouss, true);
        AppMethodBeat.o(325099);
      }
    };
    this.qAo.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(325124);
        v.a(v.this, paramAnonymousMenuItem);
        AppMethodBeat.o(325124);
      }
    };
    this.qAo.GAz = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(325115);
        v.a(v.this, paramAnonymouss, false);
        AppMethodBeat.o(325115);
      }
    };
    this.qAo.agem = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(325119);
        v.a(v.this, paramAnonymousMenuItem);
        AppMethodBeat.o(325119);
      }
    };
    if (f.a.uzf == this.enm.txh) {
      this.qAo.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(324949);
  }
  
  protected final View cEk()
  {
    return this.tvf;
  }
  
  public final boolean cem()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        f localf = this.qAo;
        if (!this.enm.cdZ())
        {
          if (this.enm.isFullScreen())
          {
            break label192;
            localf.sRy = bool;
            localf = this.qAo;
            if (this.enm.cdZ()) {
              break label197;
            }
            if (this.enm.isFullScreen())
            {
              break label197;
              localf.sRz = bool;
              a(this.qAo);
              this.qAo.dDn();
              this.enm.a(this);
              this.enm.a(this);
              this.qAo.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
              {
                public final void onViewAttachedToWindow(View paramAnonymousView)
                {
                  AppMethodBeat.i(325112);
                  paramAnonymousView = v.a(v.this).iterator();
                  while (paramAnonymousView.hasNext()) {
                    ((Runnable)paramAnonymousView.next()).run();
                  }
                  AppMethodBeat.o(325112);
                }
                
                public final void onViewDetachedFromWindow(View paramAnonymousView)
                {
                  AppMethodBeat.i(325118);
                  paramAnonymousView = v.b(v.this).iterator();
                  while (paramAnonymousView.hasNext()) {
                    ((Runnable)paramAnonymousView.next()).run();
                  }
                  AppMethodBeat.o(325118);
                }
              });
              this.qAo.getWindow().setFlags(131072, 131072);
              this.qAo.getWindow().setSoftInputMode(48);
              AppMethodBeat.o(135014);
              return true;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          bool = false;
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandPageActionSheet", localException, "showActionSheet", new Object[0]);
        AppMethodBeat.o(135014);
        return false;
      }
      label192:
      continue;
      label197:
      boolean bool = true;
    }
  }
  
  protected final boolean cen()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.qAo.cyW();
      this.enm.b(this);
      this.enm.b(this);
      AppMethodBeat.o(135015);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(135015);
    }
    return false;
  }
  
  protected final ad getPageView()
  {
    return this.enm;
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135017);
    cen();
    AppMethodBeat.o(135017);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(135016);
    cen();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */