package com.tencent.luggage.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.game.b.d;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  private static final String ctf;
  public g ctd;
  private j cte;
  boolean ctg;
  public View cth;
  private LinkedList<String> cti;
  private boolean ctj;
  private e ctk;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(246835);
    ctf = "wagame://" + WeChatHosts.domainString(a.e.host_servicewechat_com) + "/WAGameVConsole.html";
    AppMethodBeat.o(246835);
  }
  
  private b(g paramg, e parame, Context paramContext, j paramj)
  {
    AppMethodBeat.i(130495);
    this.ctg = false;
    this.ctj = false;
    this.cte = paramj;
    this.ctd = paramg;
    this.mContext = paramContext;
    this.ctk = parame;
    this.ctd.aC(paramContext);
    this.ctd.OS().OT();
    this.cth = new a(this.mContext);
    this.cth.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = b.this;
        if (paramAnonymousView.ctg)
        {
          localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.3(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
        for (paramAnonymousView.ctg = false;; paramAnonymousView.ctg = true)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130487);
          return;
          paramAnonymousView.ctd.setTranslationY(paramAnonymousView.getDisplayHeight());
          paramAnonymousView.ctd.setVisibility(0);
          localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.4(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
      }
    });
    this.ctd.a(new g.b()
    {
      public final void OR()
      {
        AppMethodBeat.i(130489);
        b.a(b.this);
        if ((b.b(b.this) != null) && (!b.b(b.this).isEmpty()))
        {
          Iterator localIterator = b.b(b.this).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            b.a(b.this, str);
          }
        }
        AppMethodBeat.o(130489);
      }
      
      public final boolean dE(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = b.ctf.equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream dF(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.c(b.this).bBP().Tf(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.ctd.loadUrl(ctf);
    this.ctd.setTranslationY(100000.0F);
    this.ctd.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  public static b a(e parame, Context paramContext, j paramj)
  {
    AppMethodBeat.i(246822);
    parame = new b(d.ON().csQ, parame, paramContext, paramj);
    AppMethodBeat.o(246822);
    return parame;
  }
  
  private void dD(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = t.anl(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.ctd.dG("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.ctd.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.ctk.cMj.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(246825);
    View localView = this.ctd.getView();
    AppMethodBeat.o(246825);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.ctj)
    {
      dD(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.cti == null) {
      this.cti = new LinkedList();
    }
    this.cti.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.ctd.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */