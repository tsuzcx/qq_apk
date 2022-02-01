package com.tencent.luggage.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.p;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public g ciS;
  h ciT;
  boolean ciU;
  public View ciV;
  LinkedList<String> ciW;
  boolean ciX;
  private d ciY;
  private Context mContext;
  
  public b(g paramg, d paramd, Context paramContext, h paramh)
  {
    AppMethodBeat.i(130495);
    this.ciU = false;
    this.ciX = false;
    this.ciT = paramh;
    this.ciS = paramg;
    this.mContext = paramContext;
    this.ciY = paramd;
    this.ciS.av(paramContext);
    this.ciS.CB().CC();
    this.ciV = new a(this.mContext);
    this.ciV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = b.this;
        if (paramAnonymousView.ciU)
        {
          localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.3(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
        for (paramAnonymousView.ciU = false;; paramAnonymousView.ciU = true)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130487);
          return;
          paramAnonymousView.ciS.setTranslationY(paramAnonymousView.getDisplayHeight());
          paramAnonymousView.ciS.setVisibility(0);
          localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.4(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
      }
    });
    this.ciS.a(new g.b()
    {
      public final void CA()
      {
        AppMethodBeat.i(130489);
        b.this.ciX = true;
        if ((b.this.ciW != null) && (!b.this.ciW.isEmpty()))
        {
          Iterator localIterator = b.this.ciW.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            b.this.cL(str);
          }
        }
        AppMethodBeat.o(130489);
      }
      
      public final boolean cM(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = "wagame://servicewechat.com/WAGameVConsole.html".equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream cN(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.this.ciT.aVF().openRead(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.ciS.loadUrl("wagame://servicewechat.com/WAGameVConsole.html");
    this.ciS.setTranslationY(100000.0F);
    this.ciS.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  final void cL(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = p.Vc(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.ciS.cO("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.ciS.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.ciY.cwM.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(190401);
    View localView = this.ciS.getView();
    AppMethodBeat.o(190401);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.ciX)
    {
      cL(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.ciW == null) {
      this.ciW = new LinkedList();
    }
    this.ciW.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.ciS.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */