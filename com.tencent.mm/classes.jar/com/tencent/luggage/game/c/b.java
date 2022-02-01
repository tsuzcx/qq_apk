package com.tencent.luggage.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.game.b.c;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  private static final String cuR;
  public g cuP;
  private k cuQ;
  boolean cuS;
  public View cuT;
  private LinkedList<String> cuU;
  private boolean cuV;
  private e cuW;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(222876);
    cuR = "wagame://" + WeChatHosts.domainString(2131761738) + "/WAGameVConsole.html";
    AppMethodBeat.o(222876);
  }
  
  private b(g paramg, e parame, Context paramContext, k paramk)
  {
    AppMethodBeat.i(130495);
    this.cuS = false;
    this.cuV = false;
    this.cuQ = paramk;
    this.cuP = paramg;
    this.mContext = paramContext;
    this.cuW = parame;
    this.cuP.aF(paramContext);
    this.cuP.Ma().Mb();
    this.cuT = new a(this.mContext);
    this.cuT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = b.this;
        if (paramAnonymousView.cuS)
        {
          localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.3(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
        for (paramAnonymousView.cuS = false;; paramAnonymousView.cuS = true)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130487);
          return;
          paramAnonymousView.cuP.setTranslationY(paramAnonymousView.getDisplayHeight());
          paramAnonymousView.cuP.setVisibility(0);
          localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.4(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
      }
    });
    this.cuP.a(new g.b()
    {
      public final void LZ()
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
      
      public final boolean dn(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = b.cuR.equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream jdMethod_do(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.c(b.this).bqZ().openRead(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.cuP.loadUrl(cuR);
    this.cuP.setTranslationY(100000.0F);
    this.cuP.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  public static b a(e parame, Context paramContext, k paramk)
  {
    AppMethodBeat.i(222872);
    parame = new b(c.LV().cuE, parame, paramContext, paramk);
    AppMethodBeat.o(222872);
    return parame;
  }
  
  private void dm(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = r.afJ(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.cuP.dp("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.cuP.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.cuW.cLz.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(222873);
    View localView = this.cuP.getView();
    AppMethodBeat.o(222873);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.cuV)
    {
      dm(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.cuU == null) {
      this.cuU = new LinkedList();
    }
    this.cuU.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.cuP.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */