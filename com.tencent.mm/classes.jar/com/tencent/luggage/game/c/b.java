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
import com.tencent.luggage.wxa.a.a.f;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  private static final String ela;
  public g ekY;
  private k ekZ;
  boolean elb;
  public View elc;
  private LinkedList<String> eld;
  private boolean ele;
  private e elf;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(220158);
    ela = "wagame://" + WeChatHosts.domainString(a.f.host_servicewechat_com) + "/WAGameVConsole.html";
    AppMethodBeat.o(220158);
  }
  
  private b(g paramg, e parame, Context paramContext, k paramk)
  {
    AppMethodBeat.i(130495);
    this.elb = false;
    this.ele = false;
    this.ekZ = paramk;
    this.ekY = paramg;
    this.mContext = paramContext;
    this.elf = parame;
    this.ekY.bl(paramContext);
    this.ekY.apa().apb();
    this.elc = new a(this.mContext);
    this.elc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = b.this;
        if (paramAnonymousView.elb)
        {
          localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.3(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
        for (paramAnonymousView.elb = false;; paramAnonymousView.elb = true)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130487);
          return;
          paramAnonymousView.ekY.setTranslationY(paramAnonymousView.getDisplayHeight());
          paramAnonymousView.ekY.setVisibility(0);
          localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.4(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
      }
    });
    this.ekY.a(new g.b()
    {
      public final void aoZ()
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
      
      public final boolean eP(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = b.ela.equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream eQ(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.c(b.this).cbl().Lh(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.ekY.loadUrl(ela);
    this.ekY.setTranslationY(100000.0F);
    this.ekY.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  public static b a(e parame, Context paramContext, k paramk)
  {
    AppMethodBeat.i(220139);
    parame = new b(d.aoV().ekK, parame, paramContext, paramk);
    AppMethodBeat.o(220139);
    return parame;
  }
  
  private void eO(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = y.agF(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.ekY.eR("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.ekY.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.elf.eHD.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(220174);
    View localView = this.ekY.getView();
    AppMethodBeat.o(220174);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.ele)
    {
      eO(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.eld == null) {
      this.eld = new LinkedList();
    }
    this.eld.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.ekY.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */