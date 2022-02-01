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
  public g cbD;
  h cbE;
  boolean cbF;
  public View cbG;
  LinkedList<String> cbH;
  boolean cbI;
  private d cbJ;
  private Context mContext;
  
  public b(g paramg, d paramd, Context paramContext, h paramh)
  {
    AppMethodBeat.i(130495);
    this.cbF = false;
    this.cbI = false;
    this.cbE = paramh;
    this.cbD = paramg;
    this.mContext = paramContext;
    this.cbJ = paramd;
    this.cbD.au(paramContext);
    this.cbD.By().Bz();
    this.cbG = new a(this.mContext);
    this.cbG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        paramAnonymousView = b.this;
        if (paramAnonymousView.cbF)
        {
          localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          localValueAnimator.addUpdateListener(new b.3(paramAnonymousView));
          localValueAnimator.start();
          paramAnonymousView.cbF = false;
          AppMethodBeat.o(130487);
          return;
        }
        paramAnonymousView.cbD.setTranslationY(paramAnonymousView.getDisplayHeight());
        paramAnonymousView.cbD.setVisibility(0);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        localValueAnimator.addUpdateListener(new b.4(paramAnonymousView));
        localValueAnimator.start();
        paramAnonymousView.cbF = true;
        AppMethodBeat.o(130487);
      }
    });
    this.cbD.a(new g.b()
    {
      public final void Bx()
      {
        AppMethodBeat.i(130489);
        b.this.cbI = true;
        if ((b.this.cbH != null) && (!b.this.cbH.isEmpty()))
        {
          Iterator localIterator = b.this.cbH.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            b.this.cc(str);
          }
        }
        AppMethodBeat.o(130489);
      }
      
      public final boolean cd(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = "wagame://servicewechat.com/WAGameVConsole.html".equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream ce(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.this.cbE.aLC().openRead(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.cbD.loadUrl("wagame://servicewechat.com/WAGameVConsole.html");
    this.cbD.setTranslationY(100000.0F);
    this.cbD.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  final void cc(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = p.Nn(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.cbD.bO("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.cbD.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.cbJ.cpf.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(194647);
    View localView = this.cbD.getView();
    AppMethodBeat.o(194647);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.cbI)
    {
      cc(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.cbH == null) {
      this.cbH = new LinkedList();
    }
    this.cbH.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.cbD.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */