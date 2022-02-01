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
  public g bYA;
  h bYB;
  boolean bYC;
  public View bYD;
  LinkedList<String> bYE;
  boolean bYF;
  private d bYG;
  private Context mContext;
  
  public b(g paramg, d paramd, Context paramContext, h paramh)
  {
    AppMethodBeat.i(130495);
    this.bYC = false;
    this.bYF = false;
    this.bYB = paramh;
    this.bYA = paramg;
    this.mContext = paramContext;
    this.bYG = paramd;
    this.bYA.av(paramContext);
    this.bYA.Bc().Bd();
    this.bYD = new a(this.mContext);
    this.bYD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        paramAnonymousView = b.this;
        if (paramAnonymousView.bYC)
        {
          localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          localValueAnimator.addUpdateListener(new b.3(paramAnonymousView));
          localValueAnimator.start();
          paramAnonymousView.bYC = false;
          AppMethodBeat.o(130487);
          return;
        }
        paramAnonymousView.bYA.setTranslationY(paramAnonymousView.getDisplayHeight());
        paramAnonymousView.bYA.setVisibility(0);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        localValueAnimator.addUpdateListener(new b.4(paramAnonymousView));
        localValueAnimator.start();
        paramAnonymousView.bYC = true;
        AppMethodBeat.o(130487);
      }
    });
    this.bYA.a(new g.b()
    {
      public final void Bb()
      {
        AppMethodBeat.i(130489);
        b.this.bYF = true;
        if ((b.this.bYE != null) && (!b.this.bYE.isEmpty()))
        {
          Iterator localIterator = b.this.bYE.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            b.this.bS(str);
          }
        }
        AppMethodBeat.o(130489);
      }
      
      public final boolean bT(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = "wagame://servicewechat.com/WAGameVConsole.html".equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream bU(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.this.bYB.aSt().openRead(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.bYA.loadUrl("wagame://servicewechat.com/WAGameVConsole.html");
    this.bYA.setTranslationY(100000.0F);
    this.bYA.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  final void bS(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = p.Rw(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.bYA.bE("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.bYA.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.bYG.cmk.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(206094);
    View localView = this.bYA.getView();
    AppMethodBeat.o(206094);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.bYF)
    {
      bS(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.bYE == null) {
      this.bYE = new LinkedList();
    }
    this.bYE.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.bYA.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */